package it.prova.gestionestazionijpamaven.test;

import java.util.List;

import it.prova.gestionestazionijpamaven.dao.EntityManagerUtil;
import it.prova.gestionestazionijpamaven.model.Citta;
import it.prova.gestionestazionijpamaven.model.Stazione;
import it.prova.gestionestazionijpamaven.model.Treno;
import it.prova.gestionestazionijpamaven.service.MyServiceFactory;
import it.prova.gestionestazionijpamaven.service.citta.CittaService;
import it.prova.gestionestazionijpamaven.service.stazione.StazioneService;
import it.prova.gestionestazionijpamaven.service.treno.TrenoService;

public class GestioneStazioniTest {
	public static void main(String[] args) {

		StazioneService stazioneServiceInstance = MyServiceFactory.getStazioneServiceInstance();
		CittaService cittaServiceInstance = MyServiceFactory.getCittaServiceInstance();
		TrenoService trenoServiceInstance = MyServiceFactory.getTrenoServiceInstance();

		try {
			System.out.println(
					"*************************************************************************************************");
			System.out.println(
					"**************************** inizio batteria di test ********************************************");

			System.out.println();
//			testInserimentoNuovaCitta(cittaServiceInstance);
			System.out.println();
//			testInserimentoNuovaStazione(cittaServiceInstance, stazioneServiceInstance);
			System.out.println();
//			testInserimentoNuovoTreno(trenoServiceInstance);
			System.out.println();
//			testDueStazioneUnaCitta(cittaServiceInstance, stazioneServiceInstance);
			System.out.println();
//			testUnaCittaUnaStazioneDueTreno(cittaServiceInstance, stazioneServiceInstance, trenoServiceInstance);
			System.out.println();
//			testUnaCittaUnaStazioneDueTrenoCancellaCitta(cittaServiceInstance, stazioneServiceInstance,
//					trenoServiceInstance);
			System.out.println();
			testEstraiListaDescrizioneGeneriAssociateAdUnStazione(stazioneServiceInstance, trenoServiceInstance,
					cittaServiceInstance);
			System.out.println();

			System.out.println(
					"**************************** fine batteria di test **********************************************");
			System.out.println(
					"*************************************************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

//	TODO######################################## TEST INSERIMENTO CITTA ##############################################################

	public static void testInserimentoNuovaCitta(CittaService cittaServiceInstance) throws Exception {

		System.out.println("######################## testInserimentoNuovaCitta inizio ########################");

//		creo una nuova citta;
		Citta cittaInstance = new Citta("CITTA_10", 10);
		cittaServiceInstance.inserisciNuovo(cittaInstance);
		if (cittaInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaCitta fallito: non ho inserito la citta ");

		System.out.println("##################### testInserimentoNuovaCitta fine: PASSED ########################");
	}

//	TODO########################################## TEST INSERIMENTO STAZIONE ########################################################

	public static void testInserimentoNuovaStazione(CittaService cittaServiceInstance,
			StazioneService stazioneServiceInstance) throws Exception {

		System.out.println("######################## testInserimentoNuovaStazione inizio ########################");

//		creo una nuova citta;
		Citta cittaInstance = new Citta("CITTA_20", 20);
		cittaServiceInstance.inserisciNuovo(cittaInstance);
		if (cittaInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaCitta fallito: non ho inserito la citta ");

//		creo una nuova stazione;
		Stazione stazioneInstance = new Stazione("STAZIONE_20", "INDIRIZZO_20");
		stazioneInstance.setCitta(cittaInstance);
		stazioneServiceInstance.inserisciNuovo(stazioneInstance);
		if (stazioneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaStazione fallito: non ho inserito la stazione ");

		System.out.println("##################### testInserimentoNuovaStazione fine: PASSED ########################");
	}

//	TODO########################################## TEST INSERIMENTO TRENO ########################################################

	public static void testInserimentoNuovoTreno(TrenoService trenoServiceInstance) throws Exception {

		System.out.println("######################## testInserimentoNuovoTreno inizio ########################");

//		creo un nuovo treno		
		Treno trenoInstance = new Treno("TRENO_30", "TTT_30");
		trenoServiceInstance.inserisciNuovo(trenoInstance);
		if (trenoInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoTreno fallito: non ho inserito il treno ");

		System.out.println("##################### testInserimentoNuovoTreno fine: PASSED ########################");
	}

//	TODO########################################## TEST DUE STAZIONI UNA CITTA ########################################################

	public static void testDueStazioneUnaCitta(CittaService cittaServiceInstance,
			StazioneService stazioneServiceInstance) throws Exception {

		System.out.println("######################## testInserimentoNuovaStazione inizio ########################");

//		creo una nuova citta;
		Citta cittaInstance = new Citta("CITTA_40", 40);
		cittaServiceInstance.inserisciNuovo(cittaInstance);
		if (cittaInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaCitta fallito: non ho inserito la citta ");

//		creo una nuova stazione;
		Stazione stazioneInstance = new Stazione("STAZIONE_40", "INDIRIZZO_40");
		stazioneInstance.setCitta(cittaInstance);
		stazioneServiceInstance.inserisciNuovo(stazioneInstance);
		if (stazioneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaStazione fallito: non ho inserito la stazione ");

//		creo una nuova stazione;
		Stazione stazioneInstance2 = new Stazione("STAZIONE_400", "INDIRIZZO_400");
		stazioneInstance2.setCitta(cittaInstance);
		stazioneServiceInstance.inserisciNuovo(stazioneInstance2);
		if (stazioneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaStazione fallito: non ho inserito la stazione ");

//		controllo se le stazione e la citta sono collegate
		Citta cittaReloaded = cittaServiceInstance.caricaSingolaCittaConStazioni(cittaInstance.getId());
		if (cittaReloaded.getStazioni().size() != 2)
			throw new RuntimeException("testDueStazioneUnaCitta fallito: le due stazion non sono state collegate");

		System.out.println("##################### testInserimentoNuovaStazione fine: PASSED ########################");

	}

//	TODO########################################## TEST UNA CITTA UNA STAZIONE DUE TRENI ########################################################

	public static void testUnaCittaUnaStazioneDueTreno(CittaService cittaServiceInstance,
			StazioneService stazioneServiceInstance, TrenoService trenoServiceInstance) throws Exception {

		System.out.println("######################## testUnaCittaUnaStazioneDueTreno inizio ########################");

//		creo una nuova citta;
		Citta cittaInstance = new Citta("CITTA_50", 50);
		cittaServiceInstance.inserisciNuovo(cittaInstance);
		if (cittaInstance.getId() == null)
			throw new RuntimeException("testUnaCittaUnaStazioneDueTreno fallito: non ho inserito la citta ");

//		creo una nuova stazione;
		Stazione stazioneInstance = new Stazione("STAZIONE_50", "INDIRIZZO_50");
		stazioneInstance.setCitta(cittaInstance);
		stazioneServiceInstance.inserisciNuovo(stazioneInstance);
		if (stazioneInstance.getId() == null)
			throw new RuntimeException("testUnaCittaUnaStazioneDueTreno fallito: non ho inserito la stazione ");

//		controllo se le stazione e la citta sono collegate
		Citta cittaReloaded = cittaServiceInstance.caricaSingolaCittaConStazioni(cittaInstance.getId());
		if (cittaReloaded.getStazioni().size() != 1)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTreno fallito: le due stazion non sono state collegate");

//		creo i due treni

		Treno trenoInstance = new Treno("TRENO_50", "TTT_50");
		stazioneServiceInstance.aggiungiTreno(stazioneInstance, trenoInstance);

		Treno trenoInstance2 = new Treno("TRENO_500", "TTT_500");
		stazioneServiceInstance.aggiungiTreno(stazioneInstance, trenoInstance2);

		Stazione stazioneReloaded = stazioneServiceInstance.caricaSingoloElementoEagerTreno(stazioneInstance.getId());
		if (stazioneReloaded.getTreni().size() != 2)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTreno fallito: le due stazion non sono state collegate");

		System.out
				.println("##################### testUnaCittaUnaStazioneDueTreno fine: PASSED ########################");
	}

//	TODO########################################## TEST UNA CITTA UNA STAZIONE DUE TRENI CANCELLA CITTA ########################################################

	public static void testUnaCittaUnaStazioneDueTrenoCancellaCitta(CittaService cittaServiceInstance,
			StazioneService stazioneServiceInstance, TrenoService trenoServiceInstance) throws Exception {

		System.out.println("######################## testUnaCittaUnaStazioneDueTreno inizio ########################");

//		creo una nuova citta;
		Citta cittaInstance = new Citta("CITTA_60", 60);
		cittaServiceInstance.inserisciNuovo(cittaInstance);
		if (cittaInstance.getId() == null)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: non ho inserito la citta ");

//		creo una nuova stazione;
		Stazione stazioneInstance = new Stazione("STAZIONE_60", "INDIRIZZO_60");
		stazioneInstance.setCitta(cittaInstance);
		stazioneServiceInstance.inserisciNuovo(stazioneInstance);
		if (stazioneInstance.getId() == null)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: non ho inserito la stazione ");

//		controllo se le stazione e la citta sono collegate
		Citta cittaReloaded = cittaServiceInstance.caricaSingolaCittaConStazioni(cittaInstance.getId());
		if (cittaReloaded.getStazioni().size() != 1)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: la stazione non è stata collegata");

//		creo i due treni
		Treno trenoInstance = new Treno("TRENO_60", "TTT_60");
		trenoServiceInstance.inserisciNuovo(trenoInstance);
		Treno trenoInstance2 = new Treno("TRENO_600", "TTT_600");
		trenoServiceInstance.inserisciNuovo(trenoInstance2);

		stazioneServiceInstance.aggiungiTreno(stazioneInstance, trenoInstance);
		stazioneServiceInstance.aggiungiTreno(stazioneInstance, trenoInstance2);

		Stazione stazioneReloaded = stazioneServiceInstance.caricaSingoloElementoEagerTreno(stazioneInstance.getId());
		if (stazioneReloaded.getTreni().size() != 2)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: le due stazion non sono state collegate");

//		disaccoppio la stazione dai treni

		stazioneServiceInstance.scollegaTreno(stazioneReloaded, trenoInstance);

		stazioneServiceInstance.scollegaTreno(stazioneReloaded, trenoInstance2);

		Stazione stazioneReloaded2 = stazioneServiceInstance.caricaSingoloElementoEagerTreno(stazioneReloaded.getId());
		if (stazioneReloaded2.getTreni().size() != 0)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: le due stazion non sono state disaccoppiate");

//		cancello la stazione
		stazioneServiceInstance.rimuovi(stazioneReloaded2);

		Citta cittaReloaded2 = cittaServiceInstance.caricaSingolaCittaConStazioni(cittaReloaded.getId());
		if (cittaReloaded2.getStazioni().size() != 0)
			throw new RuntimeException(
					"testUnaCittaUnaStazioneDueTrenoCancellaCitta fallito: la stazione non è stata rimossa");

//		cancello la citta
		cittaServiceInstance.rimuovi(cittaReloaded2);
		Citta cittaReloaded3 = cittaServiceInstance.caricaSingolaCittaConStazioni(cittaReloaded2.getId());
		if (cittaReloaded3 != null)
			throw new RuntimeException("testInserimentoNuovaCitta fallito: non ho rimosso la citta ");

		System.out.println(
				"##################### testUnaCittaUnaStazioneDueTrenoCancellaCitta fine: PASSED ########################");
	}
//	############################################################################################################################à

	private static void testEstraiListaDescrizioneGeneriAssociateAdUnStazione(StazioneService stazioneServiceInstance,
			TrenoService trenoServiceInstance, CittaService cittaServiceInstance) throws Exception {
		System.out.println(".......testEstraiListaDescrizioneGeneriAssociateAdUnStazione inizio.............");

		Citta cittaInstance1 = new Citta("citta1", 10);
		cittaServiceInstance.inserisciNuovo(cittaInstance1);
		Citta cittaInstance2 = new Citta("citta2", 20);
		cittaServiceInstance.inserisciNuovo(cittaInstance2);
		Citta cittaInstance3 = new Citta("citta3", 30);
		cittaServiceInstance.inserisciNuovo(cittaInstance3);
		Citta cittaInstance4 = new Citta("citta4", 40);
		cittaServiceInstance.inserisciNuovo(cittaInstance4);

		Stazione stazione1 = new Stazione("Stazione1", "Stazione1");
		Stazione stazione2 = new Stazione("Stazione2", "Stazione2");
		Stazione stazione3 = new Stazione("Stazione3", "Stazione3");
		Stazione stazione4 = new Stazione("Stazione4", "Stazione4");

		stazione1.setCitta(cittaInstance1);
		stazione2.setCitta(cittaInstance2);
		stazione3.setCitta(cittaInstance3);
		stazione4.setCitta(cittaInstance4);

		stazioneServiceInstance.inserisciNuovo(stazione1);
		stazioneServiceInstance.inserisciNuovo(stazione2);
		stazioneServiceInstance.inserisciNuovo(stazione3);
		stazioneServiceInstance.inserisciNuovo(stazione4);

		Treno treno1 = new Treno("treno1", "treno1");
		trenoServiceInstance.inserisciNuovo(treno1);
		stazioneServiceInstance.aggiungiTreno(stazione1, treno1);
		Long treno1ID = treno1.getId();

		Treno treno2 = new Treno("treno2", "treno2");
		trenoServiceInstance.inserisciNuovo(treno2);
		stazioneServiceInstance.aggiungiTreno(stazione2, treno2);

		Treno treno3 = new Treno("treno3", "treno3");
		trenoServiceInstance.inserisciNuovo(treno3);
		stazioneServiceInstance.aggiungiTreno(stazione3, treno3);

		Treno treno4 = new Treno("treno4", "treno4");
		trenoServiceInstance.inserisciNuovo(treno4);
		stazioneServiceInstance.aggiungiTreno(stazione4, treno4);

		stazioneServiceInstance.aggiungiTreno(stazione2, treno1);
		stazioneServiceInstance.aggiungiTreno(stazione3, treno1);
		stazioneServiceInstance.aggiungiTreno(stazione4, treno1);

		List<Integer> listaGeneriAssociatiAlStazioneReloaded = trenoServiceInstance
				.estraiListaNumeroAbitantiAssociateAdUnaStazione(treno1ID);

		for (Integer integerItem : listaGeneriAssociatiAlStazioneReloaded) {
			System.out.println(integerItem);
		}

		if (listaGeneriAssociatiAlStazioneReloaded.size() != 4)
			throw new RuntimeException(
					"testEstraiListaDescrizioneGeneriAssociateAdUnStazione fallito: nessun numeroAbitanti caricato ");

		System.out.println(".......testEstraiListaDescrizioneGeneriAssociateAdUnStazione fine: PASSED.............");
	}

}
