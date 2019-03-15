package ui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Evaluation;
import model.Event;

public class EvaluationController {

    @FXML
    private TextField textField;
    	
    @FXML
    private TextArea area;
    
    private Event event;

    @FXML
    void export(ActionEvent event) {
    	try {
			this.event.exportCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void save(ActionEvent event) {
    	double grade = Double.parseDouble(textField.getText());
    	String comments = area.getText();
    	this.event.getEvals().add(new Evaluation(grade, comments));
    	try {
			this.event.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    public void initialize() {
    	this.event = new Event();
    	try {
			event.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Todavía no hay archivos para cargar");

		} catch (ClassNotFoundException e) {
			System.out.println("Todavía no hay archivos para cargar");
		}
    }

}
