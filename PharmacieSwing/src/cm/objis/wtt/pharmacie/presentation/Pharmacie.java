package cm.objis.wtt.pharmacie.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cm.objis.wtt.pharmacie.domaine.Produit;
import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;

/**
 * Classe principale du programme
 * 
 * @author thierry WADJI
 *
 */
public class Pharmacie {

	private static Scanner sc = new Scanner(System.in);
	private static IService service = new ServiceImpl();

	public static void main(String[] args) {
		System.out.println("########################################################################");
		System.out.println("BIENVENUE DANS NOTRE APPLICATION DE GESTION DES PRODUITS PHARMACEUTIQUES");
		System.out.println("########################################################################");

		char rep = 'q';
		System.out.println("Les op�rations de notre applcation sont les suivantes:");
		System.out.println("e: Enregistrer un produit");
		System.out.println("r: Rechecher un produit par sa reference");
		System.out.println("l: Lister tous les produits");
		System.out.println("c: Calculer le nombre de produits");
		System.out.println("q: Quitter l'application");
		
		do{
			System.out.println("Choisir l'opération que vous voulez effectuer.");
			System.out.print("e= Enregistrer - r= Rechercher - l= Lister - c= Calculer - q= Quitter :");
			rep = sc.nextLine().charAt(0);
			switch(rep){
			case 'e':
				enregistreProduit();
				break;
			case 'r':
				rechercheProduit();
				break;
			case 'l':
				listeProduit();
				break;
			case 'c':
				calculNbreProduit();
				break;
			case 'q':
				sc.close();
				System.out.println("Aurevoir");
				break;
			default :
				System.out.println("l'op�ration choisie n'existe pas");		
			}


		}while(rep != 'q');

	}

	/**
	 * Proc�dure d'enregistrement des produits 
	 */
	private static void enregistreProduit(){
		System.out.println("################################");
		System.out.println("    ENREGISTREMENT DE PRODUIT   ");
		System.out.println("################################");

		Scanner sc = new Scanner(System.in);
		// Je r�cup�re les propri�t�s du Produit
		System.out.print("R�ference: ");
		String ref = sc.nextLine();
		System.out.print("Libelle: ");
		String libelle = sc.nextLine();
		System.out.print("Prix: ");
		double prix = Double.parseDouble(sc.nextLine());
		System.out.print("Quantit�: ");
		int qte = Integer.parseInt(sc.nextLine());
		Produit produit = new Produit(ref, libelle, prix, qte);

		try {
			// j'enregistre le nouveau produit si la reference n'est pas dejà enregistré
			if( !service.dejaEnregistreService(ref)) {
				service.enregistrerProduitService(produit);
				System.out.println("Enregistrement effectu� avec succ�s");
				
			} else {
				
				System.err.println("Désolé, un produit de référence <<"+ ref + ">> existe dejà en base de données.");
			}
			

		} catch (SQLException e) {

			System.out.println();
			System.err.println("ERREUR: "+e.getMessage());
			System.out.println();
		}
		System.out.println("########## FIN ENREGISTREMENT ########");
		System.out.println();

	}
	/**
	 * Proc�dure de recherche d'un produit par sa reference
	 */
	private static void rechercheProduit(){
		System.out.println("################################");
		System.out.println("      RECHERCHE DE PRODUIT      ");
		System.out.println("################################");
		System.out.print("Entrer la reference du Produit: ");
		String reference = sc.nextLine();

		try {
			Produit produit = service.rechercheProduitService(reference);
			System.out.println("Le résultat de la recherche: ");
			System.out.println(produit);

		} catch (SQLException e) {

			System.out.println();
			System.err.println("ERREUR: "+e.getMessage());
			System.out.println();
		}

		System.out.println("######## FIN RECHERCHE #########");
		System.out.println();

	}
	/**
	 * Proc�dure de liste des produits
	 */
	private static void listeProduit(){
		System.out.println("################################");
		System.out.println("   LISTE DE TOUS LES PRODUITS   ");
		System.out.println("################################");

		try {
			List<Produit> produits  = service.listProduitService();
			for (Produit produit : produits) {
				System.out.println(produit);

			}
		} catch (SQLException e) {

			System.out.println();
			System.err.println("ERREUR: "+e.getMessage());
			System.out.println();
		}
		System.out.println("########### FIN LISTE ##########");
		System.out.println();

	}

	/**
	 * Proc�dure de calcul du es produits
	 */
	private static void calculNbreProduit(){
		System.out.println("################################");
		System.out.println("   CALCUL DU NOMBRE DE PRODUITS   ");
		System.out.println("################################");

		try {
			long nb = service.nombreProduitService();
			System.out.println("Le nombre de produits actuellement en base: "+ nb);
		} catch (SQLException e) {
			System.out.println();
			System.err.println("ERREUR: "+e.getMessage());
			System.out.println();
		}

		System.out.println("########### FIN LISTE ##########");
		System.out.println();

	}

}
