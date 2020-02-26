package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoCentenas extends ConverterParaExtensoAbstract {
	
	private boolean cem;
	
	@Override
	public String converter() {
		if (getValor()==0) {
			return "";
		}
		return cem? CEM : LISTA_CENTENAS[getValor()-1];
	}

	public boolean isCem() {
		return cem;
	}

	public void setCem(boolean cem) {
		this.cem = cem;
	}

}
