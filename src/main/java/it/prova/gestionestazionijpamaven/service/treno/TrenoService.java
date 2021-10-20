package it.prova.gestionestazionijpamaven.service.treno;

import java.util.List;

import it.prova.gestionestazionijpamaven.dao.treno.TrenoDAO;
import it.prova.gestionestazionijpamaven.model.Stazione;
import it.prova.gestionestazionijpamaven.model.Treno;

public interface TrenoService {

	public List<Treno> listAll() throws Exception;

	public Treno caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Treno trenoInstance) throws Exception;

	public void inserisciNuovo(Treno trenoInstance) throws Exception;

	public void rimuovi(Treno trenoInstance) throws Exception;

	public void aggiungiStazione(Treno trenoInstance, Stazione stazioneInstance) throws Exception;

	public Treno cercaPerDenominazione(String denominazione) throws Exception;

	// per injection
	public void setTrenoDAO(TrenoDAO trenoDAO);

	void scollegaStazioni(Stazione stazioneInstance, Treno trenoInstance) throws Exception;

	List<Integer> estraiListaNumeroAbitantiAssociateAdUnaStazione(Long idtrenoInput) throws Exception;
}
