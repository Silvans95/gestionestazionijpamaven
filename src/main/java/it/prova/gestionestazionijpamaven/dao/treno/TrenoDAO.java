package it.prova.gestionestazionijpamaven.dao.treno;

import java.util.List;

import it.prova.gestionestazionijpamaven.dao.IBaseDAO;
import it.prova.gestionestazionijpamaven.model.Treno;

public interface TrenoDAO extends IBaseDAO<Treno> {

	Treno findByDenominazione(String denominazioneInput) throws Exception;

	List<Integer> loadListaNumeroAbitantiAssociatiAdUnaStazione(Long idStazioneInput) throws Exception;

}
