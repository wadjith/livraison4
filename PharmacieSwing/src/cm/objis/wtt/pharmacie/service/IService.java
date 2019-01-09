package cm.objis.wtt.pharmacie.service;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * 
 * Interface de service de sur les produits
 * 
 * @author thierry WADJI
 *
 */
public interface IService {

	/**
	 * Méthode d'enregistrement de produit
	 * 
	 * @param produit est un objet de la classe Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public void enregistrerProduitService(Produit produit) throws SQLException;

	/**
	 * Méthode de listing des produits enregistrés en BD
	 * 
	 * @return List de Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public List<Produit> listProduitService() throws SQLException;

	/**
	 * Méthode de recherche de produit par sa référence
	 * 
	 * @param ref reférence du produit
	 * @return Produit objet de la classe Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public Produit rechercheProduitService(String ref) throws SQLException;

	/**
	 * Méthode qui vérifie si un produit de reférence donnée est déjà enregistré en
	 * BD
	 * 
	 * @param ref référence du produit
	 * @return true si le produit est dejà enregistrée en BD et false au cas
	 *         contraire
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public boolean dejaEnregistreService(String ref) throws SQLException;

	/**
	 * Calcul le nombre d'enregistrement de produit
	 * 
	 * @return long nombre de produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public long nombreProduitService() throws SQLException;
	
	/**
	 * Méthode de modification d'un produit
	 * 
	 * @param produit est un objet de la classe Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public void modifierProduitService(Produit produit) throws SQLException;

}
