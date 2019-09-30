package dad.javafx.dad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {
	
	private TextField firstQuant;
	private TextField secondQuant;
	private ComboBox<String> typeMoney1;
	private ComboBox<String> typeMoney2;
	private Button change;
 	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		firstQuant = new TextField();
		firstQuant.setPromptText("Cantidad");
		
		secondQuant = new TextField();
		secondQuant.setPromptText("Cantidad");
		
		typeMoney1 = new ComboBox<String>();
		typeMoney1.getItems().addAll("Euro","Libra","Yen","Dolar");
		typeMoney1.setPromptText("Tipo");
		
		typeMoney2 = new ComboBox<String>();
		typeMoney2.getItems().addAll("Euro","Libra","Yen","Dolar");
		typeMoney2.setPromptText("Tipo");
		
		change = new Button("Cambiar");
		change.setDefaultButton(true);
		change.setOnAction(e -> onActionChange(e));
		
		HBox first = new HBox(5,firstQuant,typeMoney1);
		first.setAlignment(Pos.CENTER);
		
		HBox second = new HBox(5,secondQuant,typeMoney2);
		second.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(5,first,second,change);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("Cambio de Divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onActionChange(ActionEvent e) {
		Divisa euro = new Divisa("Euro", 1.0);
		Divisa libra = new Divisa("Libra", 0.8873);
		Divisa dolar = new Divisa("Dolar", 1.2007);
		Divisa yen = new Divisa("Yen", 133.59);
		
		double cambio=Double.parseDouble(firstQuant.getText());
		
		if(typeMoney1.getValue().equals("Euro")) {
			if(typeMoney2.getValue().equals("Libra")) {
				cambio =Divisa.fromTo(euro,libra, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Dolar")) {
				cambio =Divisa.fromTo(euro,dolar, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Yen")) {
				cambio =Divisa.fromTo(euro,yen, Double.parseDouble(firstQuant.getText()));
			}	
		}
		else if(typeMoney1.getValue().equals("Libra")) {
			if(typeMoney2.getValue().equals("Euro")) {
				cambio =Divisa.fromTo(libra,euro, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Dolar")) {
				cambio =Divisa.fromTo(libra,dolar, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Yen")) {
				cambio =Divisa.fromTo(libra,yen, Double.parseDouble(firstQuant.getText()));
			}	
		}
		else if(typeMoney1.getValue().equals("Yen")) {
			if(typeMoney2.getValue().equals("Libra")) {
				cambio =Divisa.fromTo(yen,libra, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Dolar")) {
				cambio =Divisa.fromTo(yen,dolar, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Euro")) {
				cambio =Divisa.fromTo(yen,euro, Double.parseDouble(firstQuant.getText()));
			}	
		}
		if(typeMoney1.getValue().equals("Dolar")) {
			if(typeMoney2.getValue().equals("Libra")) {
				cambio =Divisa.fromTo(dolar,libra, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Euro")) {
				cambio =Divisa.fromTo(dolar,euro, Double.parseDouble(firstQuant.getText()));
			}
			else if(typeMoney2.getValue().equals("Yen")) {
				cambio =Divisa.fromTo(dolar,yen, Double.parseDouble(firstQuant.getText()));
			}	
		}
		secondQuant.setText(cambio+"");
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
