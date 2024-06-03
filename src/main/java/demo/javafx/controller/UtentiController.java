package demo.javafx.controller;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import demo.javafx.data.Utente;
import demo.javafx.logica.UtenteService;
import demo.javafx.logica.impl.MemoryUtenteServiceImpl;
import demo.javafx.view.ViewDispatcher;
import demo.javafx.view.ViewException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UtentiController implements Initializable, DataInitializable<List<Utente>> {
	@FXML
	TableView<Utente> utentiTable;
	@FXML
	TableColumn<Utente, String> nomeColumn;
	@FXML
	TableColumn<Utente, String> passwordColumn;

	@FXML
	Button myButton;
	@FXML
	private UtenteService utService;

	private ViewDispatcher dispatcher;

	public UtentiController() {
		dispatcher = ViewDispatcher.getInstance();
		utService = new MemoryUtenteServiceImpl();
	}

	@FXML
	public void btnOnAction(ActionEvent event) throws ViewException {
		Utente ut = utentiTable.getSelectionModel().getSelectedItem();
		dispatcher.utente(ut);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

	}

	@Override
	public void initializeData(List<Utente> t) {
		ObservableList<Utente> utentiData = FXCollections.observableArrayList(t);
		utentiTable.setItems(utentiData);

	}
}
