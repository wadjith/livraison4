package cm.objis.wtt.pharmacie.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.wtt.pharmacie.domaine.Produit;
import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;
import cm.objis.wtt.pharmacie.util.FrameParameter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * 
 * Fenêtre d'enregistrement des nouveaux produits
 * @author thierry WADJI
 *
 */
public class SaveProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldReference;
	private JTextField textFieldLibelle;
	private JTextField textFieldPrix;
	private JTextField textFieldQuantite;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveProductFrame frame = new SaveProductFrame();
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
	public SaveProductFrame() {
		/* Placer une icone sur la fenêtre */
		Image img = new ImageIcon(this.getClass().getResource("/Plus-icon.png")).getImage();
		setIconImage(img);
		setResizable(false);
		/* Fin ajout de l'icone */
		setTitle("Enregistrer un Produit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 386);
		FrameParameter.centered(this); // Je centre l'affichage de la fenêtre
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRfrence = new JLabel("Référence");
		lblRfrence.setBounds(158, 43, 69, 20);
		contentPane.add(lblRfrence);
		
		JLabel lblLibell = new JLabel("Libellé");
		lblLibell.setBounds(158, 92, 69, 20);
		contentPane.add(lblLibell);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(158, 141, 69, 20);
		contentPane.add(lblPrix);
		
		JLabel lblQuantit = new JLabel("Quantité");
		lblQuantit.setBounds(158, 190, 69, 20);
		contentPane.add(lblQuantit);
		
		textFieldReference = new JTextField();
		textFieldReference.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldReference.setBounds(251, 37, 270, 33);
		contentPane.add(textFieldReference);
		textFieldReference.setColumns(10);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLibelle.setBounds(251, 86, 270, 33);
		contentPane.add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		textFieldPrix = new JTextField();
		textFieldPrix.setBounds(251, 135, 270, 33);
		contentPane.add(textFieldPrix);
		textFieldPrix.setColumns(10);
		
		textFieldQuantite = new JTextField();
		textFieldQuantite.setBounds(251, 184, 270, 33);
		contentPane.add(textFieldQuantite);
		textFieldQuantite.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref = "";
				String libelle = "";
				double prix = 0.0d;
				int qte = 0;
				/******    VERIFICATION DE N'AVOIR PAS DE CHAMPS VIDES    *****/
				if(textFieldReference.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Ce champ ne doit pas être vide", "Info", 1);
					textFieldReference.requestFocus();
					return;
				}else {
					ref = textFieldReference.getText();
				}
				
				if(textFieldLibelle.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Ce champ ne doit pas être vide", "Info", 1);
					textFieldLibelle.requestFocus();
					return;
				}else {
					libelle = textFieldLibelle.getText();
				}
				if(textFieldPrix.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Ce champ ne doit pas être vide", "Info", 1);
					textFieldPrix.requestFocus();
					return;
				}else {
					try {
						prix = Double.parseDouble(textFieldPrix.getText());
					} catch(NumberFormatException ne) {
						JOptionPane.showMessageDialog(null, "Le prix saisi n'est pas valide!!", "Error", 0);
						textFieldPrix.requestFocus();
						return;
					}
					
				}
				if(textFieldQuantite.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Ce champ ne doit pas être vide", "Info", 1);
					textFieldQuantite.requestFocus();
					return;
				}else {
					try {
						qte = Integer.parseInt(textFieldQuantite.getText());
					} catch(NumberFormatException ne) {
						JOptionPane.showMessageDialog(null, "La quantité saisie n'est pas valide!!", "Error", 0);
						textFieldQuantite.requestFocus();
						return;
					}
					
				}
				/****  FIN DE LA VERIFICATION  *****/
				
				Produit produit = new Produit(ref, libelle, prix, qte);
				try {
					// Appel de la couche service
					IService service = new ServiceImpl();
					// j'enregistre le nouveau produit si la reference n'est pas dejà enregistrée
					if( !service.dejaEnregistreService(ref)) {
						service.enregistrerProduitService(produit);
						JOptionPane.showMessageDialog(null, "Enregistrement effectué avec succès", "Info", 1);
						// Je vide les champs de saisies
						textFieldReference.setText("");
						textFieldLibelle.setText("");
						textFieldPrix.setText("");
						textFieldQuantite.setText("");
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Désolé un produit de référence("+ref+") est dejà enregistré", "Info", 1);
						textFieldReference.requestFocus();
					}
					
				} catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex, "Error", 0);
					
				}
			}
		});
		Image imgBtn = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnEnregistrer.setIcon(new ImageIcon(imgBtn));
		btnEnregistrer.setBounds(384, 260, 137, 40);
		contentPane.add(btnEnregistrer);
		
		JLabel lblNewLabel = new JLabel("");
		/* Ajout d'une image icone sur le bouton */
		Image imgLabel = new ImageIcon(this.getClass().getResource("/new-product.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgLabel));
		/* Fin de l'ajout de l'image icône */
		lblNewLabel.setBounds(15, 43, 128, 199);
		contentPane.add(lblNewLabel);
	}
}
