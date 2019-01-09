package cm.objis.wtt.pharmacie.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * La classe qui représente le TableModel utilisé pour remplir le tableau de liste des produits
 * @author thierry WADJI
 *
 */
public class ProduitModel extends AbstractTableModel {

	/**
	 * Les entêtes du tableau de listing des produits
	 */
	private final String[] entetes = {"Numero", "Reference", "Libelle", "Prix", "Quantite"};
	
	/**
	 * La liste de produit composant le model. Il sera affiché dans le tableau. 
	 */
	private List<Produit> produits;
		
	public ProduitModel(List<Produit> produits) {
		super();
		this.produits = produits;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return produits.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {

        case 0:
            // ID
            return produits.get(rowIndex).getId();

        case 1:
            // Reference
            return produits.get(rowIndex).getReference();
        case 2:
            // Libelle
            return produits.get(rowIndex).getLibelle();
        case 3:
            // Prix
            return produits.get(rowIndex).getPrix();
        case 4:
            // Quantite
            return produits.get(rowIndex).getQuantite();
            
        default:
            throw new IllegalArgumentException();

		}
	}
	
	@Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {

        case 0:
            // ID
            return Long.class;

        case 1:
            // Reference
            
        case 2:
            // Libelle
            return String.class;
        case 3:
            // Prix
            return Double.class;
        case 4:
            // Quantite
            return Integer.class;
            
        default:
            return Object.class;

		}

	}
	

}
