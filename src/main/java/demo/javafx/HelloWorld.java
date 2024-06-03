package demo.javafx;

import demo.javafx.logica.UtenteService;
import demo.javafx.logica.impl.MemoryUtenteServiceImpl;
import demo.javafx.view.ViewDispatcher;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) {
		try {
			UtenteService utService = new MemoryUtenteServiceImpl();
			ViewDispatcher vd = ViewDispatcher.getInstance();			
			vd.utenti(stage, utService.getUtenti());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}

}