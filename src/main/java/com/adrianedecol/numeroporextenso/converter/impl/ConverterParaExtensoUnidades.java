package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoUnidades extends ConverterParaExtensoAbstract {
	
	/**
	 * @@TODO
	 * Tratar o zero sozinho
	 */
	@Override
	public String converter() {
		if (getValor() == 0) {
			return "";
		}
		return LISTA_NUMEROS_0_a_9[getValor()];	
	}

}
