package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoDezenas extends ConverterParaExtensoAbstract{
	
	private boolean entre10e19;
	private int valorEntre10e19;

	@Override
	public String converter() {
		if (getValor() == 0) {
			return "";
		}
		return entre10e19 ? LISTA_NUMEROS_10_a_19[getValorEntre10e19()%10] : LISTA_DEZENAS[getValor()-1];
	}

	public boolean isEntre10e19() {
		return entre10e19;
	}

	public void setEntre10e19(boolean entre10e19) {
		this.entre10e19 = entre10e19;
	}

	public int getValorEntre10e19() {
		return valorEntre10e19;
	}

	public void setValorEntre10e19(int valorEntre10e19) {
		this.valorEntre10e19 = valorEntre10e19;
	}

}
