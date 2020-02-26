package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtenso;

@Component
public class ConverterParaExtensoDezenas implements ConverterParaExtenso {

	private final String[] LISTA_DEZENAS = {"dez", "vinte", "trinta", "quarenta", "cinquenta", 
			"sessenta", "setenta", "oitenta", "noventa"};
	
	/**
	 * @@TODO
	 * Tratar entre 10 e 19
	 */
	@Override
	public String converter(int id) {
		if (id == 0) {
			return "";
		}
		return LISTA_DEZENAS[id-1];
		
	}

}
