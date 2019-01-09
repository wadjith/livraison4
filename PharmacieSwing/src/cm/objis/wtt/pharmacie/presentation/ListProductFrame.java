package cm.objis.wtt.pharmacie.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.wtt.pharmacie.domaine.Produit;
import cm.objis.wtt.pharmacie.domaine.ProduitModel;
import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;
import cm.objis.wtt.pharmacie.util.FrameParameter;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Fenêtre d'enregistrement des nouveaux produits
 * @author thierry WADJI
 *
 */
public class ListProductFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNumber;
	private JButton btnModifier;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListProductFrame frame = new ListProductFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ListProductFrame() {
		/* Placer une icone sur la fenêtre */
		Image img = new ImageIcon(this.getClass().getResource("/Plus-icon.png")).getImage();
		setIconImage(img);
		setTitle("Liste des produits");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 396);
		FrameParameter.centered(this); // Je centre l'affichage de la fenêtre
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 55, 651, 285);
		contentPane.add(scrollPane);
		
		// Appel de la couche service
		IService service = new ServiceImpl();
		long nbProduit = 0;
		Produit produit = new Produit();
		List<Produit> produits = new ArrayList<>();
		try {
			nbProduit = service.nombreProduitService();
			produits = service.listProduitService();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "Erreur", 0);
		}
		
		table = new JTable(new ProduitModel(produits));
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModifier.setEnabled(true);
				int row = table.getSelectedRow();
				long id = (long)table.getModel().getValueAt(row, 0);
				String ref = table.getModel().getValueAt(row, 1).toString();
				String libelle = table.getModel().getValueAt(row, 2).toString();
				double prix = (double)table.getModel().getValueAt(row, 3);
				int qte = (int)table.getModel().getValueAt(row, 4);
				
				// Je construis l'objet correspondant à la ligne selectionnée
				produit.setId(id);
				produit.setReference(ref);
				produit.setLibelle(libelle);
				produit.setPrix(prix);
				produit.setQuantite(qte);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Nombre de produits");
		lblNewLabel.setBounds(367, 19, 146, 20);
		contentPane.add(lblNewLabel);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setEditable(false);
		textFieldNumber.setBounds(518, 16, 146, 26);
		textFieldNumber.setText(Long.toString(nbProduit));
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//J'ouvre la fenêtre de modification en lui passant l'objet à modiifier
				UpdateProductFrame frame = new UpdateProductFrame(produit);
				frame.setVisible(true);
				dispose(); // Je ferme la fenêtre en cours
			}
		});
		btnModifier.setEnabled(false);
		Image imgBtn = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnModifier.setIcon(new ImageIcon(imgBtn));
		btnModifier.setBounds(15, 10, 125, 42);
		contentPane.add(btnModifier);
	}
}
