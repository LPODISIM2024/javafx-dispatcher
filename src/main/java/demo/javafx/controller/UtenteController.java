package demo.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import demo.javafx.data.Utente;
import demo.javafx.logica.UtenteService;
import demo.javafx.logica.impl.MemoryUtenteServiceImpl;
import demo.javafx.view.ViewDispatcher;
import demo.javafx.view.ViewException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class UtenteController implements Initializable, DataInitializable<Utente> {
	
	@FXML
	private Button myButton;
	@FXML
	private Text nomeText;
	@FXML
	private Text passwordText;
	private ViewDispatcher dispatcher;
	private UtenteService utService;
	
	public UtenteController() {
		dispatcher = ViewDispatcher.getInstance();
		utService = new MemoryUtenteServiceImpl();
	}

	@FXML
	public void btnOnAction(ActionEvent event) throws ViewException {
		dispatcher.utenti(utService.getUtenti());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void initializeData(Utente t) {
		nomeText.setText(t.getName());
		passwordText.setText(t.getPassword());
		
	}
}
