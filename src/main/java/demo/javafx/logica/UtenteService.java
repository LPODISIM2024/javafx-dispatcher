package demo.javafx.logica;

import java.util.List;

import demo.javafx.data.Utente;

public interface UtenteService {

	public List<Utente> getUtenti();
	public Utente getUtente(String name);
	public boolean instertUtente(Utente ut);
}
