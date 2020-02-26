package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtenso;

@Component
public class ConverterParaExtensoUnidades implements ConverterParaExtenso{
	
	private final String[] LISTA_NUMEROS_0_a_9 = {"zero", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove"};

	/**
	 * @@TODO
	 * Tratar o zero sozinho
	 */
	@Override
	public String converter(int id) {
		if (id == 0) {
			return "";
		}
		return LISTA_NUMEROS_0_a_9[id];	
	}

}
