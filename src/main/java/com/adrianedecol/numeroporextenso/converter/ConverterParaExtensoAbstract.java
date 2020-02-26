package com.adrianedecol.numeroporextenso.converter;

import org.springframework.stereotype.Component;

@Component
public abstract class ConverterParaExtensoAbstract implements ConverterParaExtenso {

	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
