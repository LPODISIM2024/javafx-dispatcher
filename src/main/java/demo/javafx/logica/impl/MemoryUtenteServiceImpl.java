package demo.javafx.logica.impl;

import java.util.Arrays;
import java.util.List;

import demo.javafx.data.Utente;
import demo.javafx.logica.UtenteService;

public class MemoryUtenteServiceImpl implements UtenteService {

	List<Utente> utenti;
	
	public MemoryUtenteServiceImpl() {
		utenti = Arrays.asList(new Utente("j","1"), new Utente("d","2"), new Utente("r","3"));
	}
	
	@Override
	public List<Utente> getUtenti() {
		// TODO Auto-generated method stub
		return utenti;
	}

	@Override
	public Utente getUtente(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean instertUtente(Utente ut) {
		// TODO Auto-generated method stub
		return false;
	}

}
