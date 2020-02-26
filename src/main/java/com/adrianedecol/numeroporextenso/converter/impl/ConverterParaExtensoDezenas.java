package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoDezenas extends ConverterParaExtensoAbstract{
	
	/**
	 * @@TODO
	 * Tratar entre 10 e 19
	 */
	@Override
	public String converter() {
		if (getValor() == 0) {
			return "";
		}
		return LISTA_DEZENAS[getValor()-1];
		
	}

}
