package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoCentenas extends ConverterParaExtensoAbstract {
	
	/**
	 * @@TODO
	 * Tratar o CEM
	 */
	@Override
	public String converter() {
		if (getValor()==0) {
			return "";
		}
		return LISTA_CENTENAS[getValor()-1];
	}

}
