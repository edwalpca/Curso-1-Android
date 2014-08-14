package com.cyberfuel.tarea1;

import java.util.Random;

public class MiAleatorio {
	
	
	/* El siguiente metodo genera un numero aleatorio */
	protected int deme_numero(){
		
		Random rand = new Random();
		int mi_numero = rand.nextInt(4);
		
		return mi_numero;
	}

}
