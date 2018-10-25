package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	
	private int NMAX = 100 ;
	private int TMAX = 7 ;
	
	private int segreto ; // numero da indovinare
	private int tentativi ; // tentativi gi� fatti
	
	private boolean  inGame = false ; // se partita in corso oppure no


	public Model() {
		this.inGame = false ;
	}
	
	/**
	 * Avvia una nuava partita, generando un nuovo numero segreto
	 */
	public void newGame(){
    	this.segreto = (int) (Math.random()*NMAX)+1; //Risultato:mi da un valore compreso tra [0,100)
        
    	this.tentativi = 0;
    	this.inGame = true ;
		
	}
	
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t valore numerico del tentativo
	 * @return 0 se � indovinato, +1 se � troppo grande, -1 se � troppo picolo
	 */
	public int tentativo(int t){
		
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		if(!valoreValido(t)) {
			throw new  InvalidParameterException("Tentativo fuori range ");
		}
		
		this.tentativi++;
		if(this.tentativi==TMAX) {
			this.inGame = false ;
		}
		
		if(t==this.segreto){
			this.inGame = false ;
			return 0;
			}
		if(t<this.segreto)
			return -1;
		return +1;
		
	}
	
	/**
	 * Controlla se il tentativo fornito rispetta le regole formali 
	 * del gioco , cio� � nel range  [1, NMAX]
	 * @param tentativo
	 * @return {@code true} se il tentativo � valido
	 */
	
	public boolean valoreValido(int tentativo) {
		return tentativo>1 && tentativo<= this.NMAX ;
	}

	public boolean isInGame() {
		return inGame;
	}
	
	public int getTentativi(){
		return this.tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}
	
	
}
