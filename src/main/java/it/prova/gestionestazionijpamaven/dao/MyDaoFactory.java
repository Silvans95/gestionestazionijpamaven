package it.prova.gestionestazionijpamaven.dao;

import it.prova.gestionestazionijpamaven.dao.citta.CittaDAO;
import it.prova.gestionestazionijpamaven.dao.citta.CittaDAOImpl;
import it.prova.gestionestazionijpamaven.dao.stazione.StazioneDAO;
import it.prova.gestionestazionijpamaven.dao.stazione.StazioneDAOImpl;
import it.prova.gestionestazionijpamaven.dao.treno.TrenoDAO;
import it.prova.gestionestazionijpamaven.dao.treno.TrenoDAOImpl;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static CittaDAO cittaDAOInstance = null;
	private static StazioneDAO stazioneDAOInstance = null;
	private static TrenoDAO trenoDAOInstance = null;

	
	public static CittaDAO getCittaDAOInstance() {
		if (cittaDAOInstance == null)
			cittaDAOInstance = new CittaDAOImpl();
		return cittaDAOInstance;
	}

	public static StazioneDAO getStazioneDAOInstance(){
		if(stazioneDAOInstance == null)
			stazioneDAOInstance= new StazioneDAOImpl();
		return stazioneDAOInstance;
	}
	
	public static TrenoDAO getTrenoDAOInstance(){
		if(trenoDAOInstance == null)
			trenoDAOInstance= new TrenoDAOImpl();
		return trenoDAOInstance;
	}

}
