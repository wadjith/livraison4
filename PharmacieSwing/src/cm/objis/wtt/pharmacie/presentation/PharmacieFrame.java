package cm.objis.wtt.pharmacie.presentation;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Fenêtre Principale de l'application
 * @author thierry WADJI
 *
 */
public class PharmacieFrame {

	private JFrame frmGestionDesPharmacies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PharmacieFrame window = new PharmacieFrame();
					// Maximize the frame
					window.frmGestionDesPharmacies.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmGestionDesPharmacies.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PharmacieFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesPharmacies = new JFrame();
		frmGestionDesPharmacies.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		/* Placer une icone sur la fenêtre */
		Image img = new ImageIcon(this.getClass().getResource("/Plus-icon.png")).getImage();
		frmGestionDesPharmacies.setIconImage(img);
		/* Fin ajout de l'icone */
		frmGestionDesPharmacies.setTitle("Gestion des Pharmacies");
		/*Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmGestionDesPharmacies.setBounds(0, 0, screen.width, screen.height);*/
		frmGestionDesPharmacies.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesPharmacies.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		frmGestionDesPharmacies.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		mnFichier.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				//frmGestionDesPharmacies.dispose();
			}
		});
		mnFichier.add(mntmQuitter);
		
		JMenu mnProduit = new JMenu("Produit");
		mnProduit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnProduit);
		
		JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
		mntmEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveProductFrame frame = new SaveProductFrame();
				frame.setVisible(true);
			}
		});
		mntmEnregistrer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnProduit.add(mntmEnregistrer);
		
		JMenuItem mntmLister = new JMenuItem("Lister");
		mntmLister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProductFrame frame = new ListProductFrame();
				frame.setVisible(true);
			}
		});
		mntmLister.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnProduit.add(mntmLister);
	}
}
