package com.adrianedecol.numeroporextenso.converter;

/**
 * Interface responsável pela conversão de números
 * Cada característica deve implementar suas regras específicas (milhares, centenas, dezenas e unidades)
 * @author adrianedecol
 *
 */
public interface ConverterParaExtenso {
	
	final String[] LISTA_NUMEROS_10_a_19 = {"dez", "onze", "doze", "treze", "quatorze", "quinze", 
			"dezesseis", "dezesete", "dezoito", "dezenove"};
	final String[] LISTA_DEZENAS = {"dez", "vinte", "trinta", "quarenta", "cinquenta", 
			"sessenta", "setenta", "oitenta", "noventa"};
	final String E = " e ";
	final String MIL = " mil";
	final String[] LISTA_NUMEROS_0_a_9 = {"zero", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove"};
	final String[] LISTA_CENTENAS = {"cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", 
			"seiscentos", "setecentos", "oitocentos", "novecentos"};
	
	/**
	 * Método utilizado na conversão de um número para extenso
	 * @return string com o valor convertido, considerando a característica (milhares, centenas, dezenas e unidades)
	 */
	public String converter ();
	
}
