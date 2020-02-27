package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoAbstract;

@Component
public class ConverterParaExtensoMilhares extends ConverterParaExtensoAbstract {

	private Boolean ehEntre10e19;
	private int primeiroDigito;
	private int segundoDigito;
	
	@Override
	public String converter() {		
		if (getValor() == 0) {
			return "";
		}
		ehEntre10e19 = (getValor() >= 10 && getValor() <= 19);
		primeiroDigito = Math.floorDiv(getValor(), 10);
		segundoDigito = Math.floorDiv(getValor() - (primeiroDigito * 10), 1);	
		if (primeiroDigito == 0) {
			return (ehEntre10e19? LISTA_NUMEROS_10_a_19[segundoDigito]:LISTA_NUMEROS_0_a_9[segundoDigito]).concat(MIL);
		}
		if (segundoDigito == 0) {
			return LISTA_DEZENAS[primeiroDigito-1].concat(MIL);
		}
		return (ehEntre10e19? LISTA_NUMEROS_10_a_19[segundoDigito]:LISTA_DEZENAS[primeiroDigito-1].concat(E).concat(LISTA_NUMEROS_0_a_9[segundoDigito])).concat(MIL);		
	}

}
