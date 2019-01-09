package cm.objis.wtt.pharmacie.service;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.dao.DaoImpl;
import cm.objis.wtt.pharmacie.dao.IDao;
import cm.objis.wtt.pharmacie.domaine.Produit;

public class ServiceImpl implements IService {
	
	private IDao dao;
	
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void enregistrerProduitService(Produit produit) throws SQLException {
		dao.enregistrerProduitDao(produit);

	}

	@Override
	public List<Produit> listProduitService() throws SQLException {
		return dao.listProduitDao();		
	}

	@Override
	public Produit rechercheProduitService(String ref) throws SQLException {
		return dao.rechercheProduitDao(ref);
	}
	
	

	@Override
	public boolean dejaEnregistreService(String ref) throws SQLException {
		
		return dao.dejaEnregistreDao(ref);
	}

	@Override
	public long nombreProduitService() throws SQLException {
		return dao.nombreProduitDao();
	}

	@Override
	public void modifierProduitService(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		dao.modifierProduitDao(produit);
	}

}
