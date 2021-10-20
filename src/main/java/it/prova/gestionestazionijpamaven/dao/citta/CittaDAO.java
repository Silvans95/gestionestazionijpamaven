package it.prova.gestionestazionijpamaven.dao.citta;

import it.prova.gestionestazionijpamaven.dao.IBaseDAO;
import it.prova.gestionestazionijpamaven.model.Citta;

public interface CittaDAO extends IBaseDAO<Citta> {

	Citta getEagerStazioni(Long id) throws Exception;

}
