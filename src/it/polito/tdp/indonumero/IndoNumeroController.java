/**
 * Sample Skeleton for 'IndoNumero.fxml' Controller Class
 */

package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	
	private int NMAX = 100 ;
	private int TMAX = 7 ;
	
	private int segreto ; // numero da indovinare
	private int tentativi ; // tentativi già fatti
	
	private boolean  inGame = false ; // se partita in corso oppure no

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuava"
    private Button btnNuava; // Value injected by FXMLLoader

    @FXML // fx:id="txtCurr"
    private TextField txtCurr; // Value injected by FXMLLoader

    @FXML // fx:id="txtMax"
    private TextField txtMax; // Value injected by FXMLLoader

    @FXML // fx:id="boxGioco"
    private HBox boxGioco; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativo"
    private TextField txtTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML
    void handleNuava(ActionEvent event) {
    	
    	
    	this.segreto = (int) (Math.random()*NMAX); //Risultato:mi da un valore compreso tra [0,100)
        
    	this.tentativi = 0;
    	this.inGame = true ;
    	
    	btnNuava.setDisable(true); // Abilatare
    	boxGioco.setDisable(false); // Disabilitare
    	txtCurr.setText(String.format("%d", this.tentativi));
    	txtMax.setText(String.format("%d", this.TMAX));
    }

    @FXML
    void handleProva(ActionEvent event) {
    	
    	String numS = txtTentativo.getText();
    	
    	if(numS.length() == 0) {
    		txtLog.appendText("Devi inserire un numero\n");
    		return ;
    	}
    	
    	try {
    		 int num = Integer.parseInt(numS) ;
    		 // numero era effettivamente un intero 
        	
		} catch (NumberFormatException ex) {
			txtLog.appendText("Il dato inserito non è numerico \n");
			return ;
			
		}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuava != null : "fx:id=\"btnNuava\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtCurr != null : "fx:id=\"txtCurr\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxGioco != null : "fx:id=\"boxGioco\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
}
