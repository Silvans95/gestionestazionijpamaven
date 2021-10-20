package it.prova.gestionestazionijpamaven.service.citta;

import java.util.List;

import it.prova.gestionestazionijpamaven.dao.citta.CittaDAO;
import it.prova.gestionestazionijpamaven.model.Citta;



public interface CittaService {

	

	public List<Citta> listAllCitta() throws Exception;

	public Citta caricaSingolaCitta(Long id) throws Exception;

	public Citta caricaSingolaCittaConStazioni(Long id) throws Exception;

	public void aggiorna(Citta cittaInstance) throws Exception;

	public void inserisciNuovo(Citta cittaInstance) throws Exception;

	public void rimuovi(Citta cittaInstance) throws Exception;

	// per injection
	public void setCittaDAO(CittaDAO cittaDAO);

	
}
