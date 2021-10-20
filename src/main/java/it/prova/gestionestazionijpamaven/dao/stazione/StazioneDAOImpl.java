package it.prova.gestionestazionijpamaven.dao.stazione;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionestazionijpamaven.model.Stazione;

public class StazioneDAOImpl implements StazioneDAO {

	private EntityManager entityManager;

	@Override
	public List<Stazione> list() throws Exception {
		return entityManager.createQuery("from Stazione", Stazione.class).getResultList();
	}

	@Override
	public Stazione get(Long id) throws Exception {
		return entityManager.find(Stazione.class, id);
	}

	@Override
	public void update(Stazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Stazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Stazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public Stazione findByDenominazione(String denominazioneInput) throws Exception {
		TypedQuery<Stazione> query = entityManager
				.createQuery("select a from Stazione a where a.denominazione=?1", Stazione.class)
				.setParameter(1, denominazioneInput);

		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Stazione findByIdFetchingTreni(Long id) throws Exception {
		TypedQuery<Stazione> query = entityManager.createQuery(
				"select c FROM Stazione c left join fetch c.treni g where c.id = :idStazione", Stazione.class);
		query.setParameter("idStazione", id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	// ##################################################### TODO ##########################


}
