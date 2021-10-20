package it.prova.gestionestazionijpamaven.dao.citta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionestazionijpamaven.model.Citta;

public class CittaDAOImpl implements CittaDAO{
	

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Citta> list() throws Exception {

		return entityManager.createQuery("from Citta", Citta.class).getResultList();
	}

	@Override
	public Citta get(Long id) throws Exception {
		return entityManager.find(Citta.class, id);
	}

	@Override
	public void update(Citta cittaInstance) throws Exception {
		if (cittaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		cittaInstance = entityManager.merge(cittaInstance);
	}

	@Override
	public void insert(Citta cittaInstance) throws Exception {
		if (cittaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(cittaInstance);
	}
	
	@Override
	public void delete(Citta cittaInstance) throws Exception {
		if (cittaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(cittaInstance));
	}

	@Override
	public Citta getEagerStazioni(Long id) throws Exception {
		TypedQuery<Citta> query = entityManager.createQuery("from Citta m left join fetch m.stazioni where m.id = ?1",
				Citta.class);
		query.setParameter(1, id);

		return query.getResultStream().findFirst().orElse(null);
	}
	


}
