package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoDezenas extends ConverterParaExtensoAbstract{
	
	private boolean entre10e19;
	
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

	public boolean isEntre10e19() {
		return entre10e19;
	}

	public void setEntre10e19(boolean entre10e19) {
		this.entre10e19 = entre10e19;
	}

}
