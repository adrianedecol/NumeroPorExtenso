package com.adrianedecol.numeroporextenso.converter.impl;

import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtenso;

@Component
public class ConverterParaExtensoMilhares implements ConverterParaExtenso {

	private Boolean ehEntre10e19;
	private int primeiroDigito;
	private int segundoDigito;
	private final String[] LISTA_NUMEROS_10_a_19 = {"dez", "onze", "doze", "treze", "quatorze", "quinze", 
			"dezesseis", "dezesete", "dezoito", "dezenove"};
	private final String[] LISTA_DEZENAS = {"dez", "vinte", "trinta", "quarenta", "cinquenta", 
			"sessenta", "setenta", "oitenta", "noventa"};
	private final String E = " e ";
	private final String MIL = " mil";
	private final String[] LISTA_NUMEROS_0_a_9 = {"zero", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove"};
	
	@Override
	public String converter(int id) {		
		if (id == 0) {
			return "";
		}
		ehEntre10e19 = (id >= 10 && id <= 19);
		primeiroDigito = Math.floorDiv(id, 10);
		segundoDigito = Math.floorDiv(id - (primeiroDigito * 10), 1);	
		if (primeiroDigito == 0) {
			return (ehEntre10e19? LISTA_NUMEROS_10_a_19[segundoDigito]:LISTA_NUMEROS_0_a_9[segundoDigito]).concat(MIL);
		}
		return (ehEntre10e19? LISTA_NUMEROS_10_a_19[segundoDigito]:LISTA_DEZENAS[primeiroDigito-1].concat(E).concat(LISTA_NUMEROS_0_a_9[segundoDigito])).concat(MIL);		
	}

}
