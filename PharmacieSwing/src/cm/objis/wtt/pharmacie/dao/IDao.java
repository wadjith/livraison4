package cm.objis.wtt.pharmacie.dao;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;


/**
 * 
 * Interface de communication avec la BD 
 * @author thierry WADJI
 *
 */
public interface IDao {
	
	
	
	/**
	 * Enregistre un produit dans la BD
	 * @param produit est un objet de type Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public void enregistrerProduitDao(Produit produit) throws SQLException;
	
	/**
	 * 
	 * Liste les produits de la BD
	 * 
	 * @return List de Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public List<Produit> listProduitDao() throws SQLException;
	
	
	/**
	 * @param ref reférene du Produit
	 * @return Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public Produit rechercheProduitDao(String ref) throws SQLException;
	
	
	/**
	 * Verifie si un produit de reference donnée est dejà enregistré dans la BD
	 * 
	 * @param ref reférence du produit
	 * @return True si un produit de reference(ref) esr dejà en BD ou False sinon 
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public boolean dejaEnregistreDao(String ref) throws SQLException;
	
	
	/**
	 * Calcul le nombre de produit dans la BD
	 * 
	 * @return long
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public long nombreProduitDao() throws SQLException;
	
	/**
	 * Modifie un produit sélectionné
	 * 
	 * @param produit un objet de type Produit 
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public void modifierProduitDao(Produit produit) throws SQLException;

}
