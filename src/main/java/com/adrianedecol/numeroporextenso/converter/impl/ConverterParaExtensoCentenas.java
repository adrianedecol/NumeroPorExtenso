package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtenso;

@Component
public class ConverterParaExtensoCentenas implements ConverterParaExtenso {

	private final String[] LISTA_CENTENAS = {"cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", 
			"seiscentos", "setecentos", "oitocentos", "novecentos"};
	
	/**
	 * @@TODO
	 * Tratar o CEM
	 */
	@Override
	public String converter(int id) {
		if (id == 0) {
			return "";
		}
		return LISTA_CENTENAS[id-1];
	}

}
