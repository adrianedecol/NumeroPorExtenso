package com.adrianedecol.numeroporextenso.converter;

/**
 * Interface responsável pela conversão de números
 * Cada característica deve implementar suas regras específicas (milhares, centenas, dezenas e unidades)
 * @author adrianedecol
 *
 */
public interface ConverterParaExtenso {
	
	/**
	 * Método utilizado na conversão de um número para extenso
	 * @param id número a ser convertido
	 * @return string com o valor convertido, considerando a característica (milhares, centenas, dezenas e unidades)
	 */
	public String converter (int id);
	
}
