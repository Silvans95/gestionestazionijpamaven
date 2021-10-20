package it.prova.gestionestazionijpamaven.service.treno;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionestazionijpamaven.dao.EntityManagerUtil;
import it.prova.gestionestazionijpamaven.dao.treno.TrenoDAO;
import it.prova.gestionestazionijpamaven.model.Stazione;
import it.prova.gestionestazionijpamaven.model.Treno;

public class TrenoServiceImpl implements TrenoService {

	private TrenoDAO trenoDAO;

	@Override
	public List<Treno> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return trenoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Treno caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return trenoDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Treno genereInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			trenoDAO.update(genereInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Treno trenoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			trenoDAO.insert(trenoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Treno  trenoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			trenoDAO.delete(trenoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Treno cercaPerDenominazione(String denominazione) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			trenoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return trenoDAO.findByDenominazione(denominazione);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void aggiungiStazione(Treno trenoInstance, Stazione stazioneInstance) throws Exception {

	}
	@Override
	public void scollegaStazioni(Stazione stazioneInstance, Treno trenoInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			trenoDAO.setEntityManager(entityManager);

			stazioneInstance = entityManager.merge(stazioneInstance);
			trenoInstance = entityManager.merge(trenoInstance);

			trenoInstance.removeFromStazioni(stazioneInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	@Override
	public void setTrenoDAO(TrenoDAO trenoDAO) {
		this.trenoDAO = trenoDAO;
	}
	
//	################################ TODO #########################################################
	

	@Override
	public List<Integer> estraiListaNumeroAbitantiAssociateAdUnaStazione(Long idtrenoInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			trenoDAO.setEntityManager(entityManager);

			return trenoDAO.loadListaNumeroAbitantiAssociatiAdUnaStazione(idtrenoInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	
	
}
