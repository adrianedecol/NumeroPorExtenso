package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoUnidades extends ConverterParaExtensoAbstract {
	
	private boolean zero;

	@Override
	public String converter() {
		if (getValor() == 0 && !isZero()) {
			return "";
		}
		return LISTA_NUMEROS_0_a_9[getValor()];	
	}

	public boolean isZero() {
		return zero;
	}

	public void setZero(boolean zero) {
		this.zero = zero;
	}

}
