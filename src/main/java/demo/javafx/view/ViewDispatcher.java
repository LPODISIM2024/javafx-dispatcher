package demo.javafx.view;

import java.io.IOException;
import java.util.List;

import demo.javafx.controller.DataInitializable;
import demo.javafx.data.Utente;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewDispatcher {

	private static final String RESOURCE_BASE = "/";
	private static final String FXML_SUFFIX = ".fxml";


	private Stage stage;
	private BorderPane layout;

	private static ViewDispatcher instance = new ViewDispatcher();
	private ViewDispatcher() {}
	
	public static ViewDispatcher getInstance() {
		return instance;
	}
	
	/*
	 * Punto di ingresso
	 */
	public void utenti(Stage stage, List<Utente> utenti) throws ViewException {
		this.stage = stage;
		layout = (BorderPane) loadView("layout").getView();
		renderView("utenti", utenti);
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.show();
	}
	
	public void utenti(List<Utente> utenti) throws ViewException {
		renderView("utenti", utenti);
		stage.show();
	}

	public void utente(Utente ut) throws ViewException {
		renderView("utente", ut);
		stage.show();
	}


	public <T> void renderView(String viewName, T data) {
		try {
			View<T> view = loadView(viewName);
			view.getController().initializeData(data);
			layout.setCenter(view.getView());
		} catch (ViewException e) {
			renderError(e);
		}
	}

	public void renderError(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	

	private <T> View<T> loadView(String viewName) throws ViewException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(RESOURCE_BASE + viewName + FXML_SUFFIX));
			Parent parent = (Parent) loader.load();
			return new View<>(parent, loader.getController());

		} catch (IOException ex) {
			throw new ViewException();
		}
	}
}














