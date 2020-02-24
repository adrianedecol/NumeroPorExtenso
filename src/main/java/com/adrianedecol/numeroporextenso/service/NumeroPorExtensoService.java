package com.adrianedecol.numeroporextenso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianedecol.numeroporextenso.object.NumeroPorExtenso;

@Service
public class NumeroPorExtensoService {

	@Autowired
	private NumeroPorExtenso porExtenso;
	private String[] LISTA_NUMEROS_0_a_9 = {"zero", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove"};
	private String[] LISTA_NUMEROS_10_a_19 = {"dez", "onze", "doze", "treze", "quatorze", "quinze", 
			"dezesseis", "dezesette", "dezoito", "dezenove"};
	private String[] LISTA_DEZENAS = {"dez", "vinte", "trinta", "quarenta", "cinquenta", 
			"sessenta", "setenta", "oitenta", "noventa"};
	private String[] LISTA_CENTENAS = {"cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", 
			"seiscentos", "setecentos", "oitocentos", "novecentos"};
	
	public NumeroPorExtenso retornarVersaoPorExtenso (Long id) {
		porExtenso.setExtenso(converterNumeroParaExtenso(id));
		return porExtenso;		
	}
	
	/**
	 * @TODO
	 * Tratamento de números com 4 dígitos -- OK
	 * Tratamento de casas com 0
	 * Tratamento dos números de 11 a 19
	 * 
	 */
	private String converterNumeroParaExtenso(Long id) {
		String idComoString = id.toString();
		String valorPorExtenso = "valor fora do limite [-99999,99999]";
		int tamanho = idComoString.length();
		if ((tamanho <= 5) || (tamanho == 6 && (idComoString.startsWith("-")))) {
			valorPorExtenso = "";
			if (idComoString.startsWith("-")) {
				valorPorExtenso = "menos ";
				idComoString = idComoString.replace("-", "");
				tamanho = idComoString.length();
			}			
			if (tamanho == 5) {
				String milhares = idComoString.substring(0, 2);
				Integer numero = Integer.parseInt(milhares.substring(0, 1));
				Integer numero2 = Integer.parseInt(milhares.substring(1, 2));
				valorPorExtenso += LISTA_DEZENAS[numero-1].concat(" e ").concat(LISTA_NUMEROS_0_a_9[numero2]).concat(" mil e ");
				idComoString = idComoString.substring(2, 5);
				tamanho = idComoString.length();
			}
			if (tamanho == 4 && !idComoString.equalsIgnoreCase("0000")) {
				String milhares = idComoString.substring(0, 1);
				Integer numero = Integer.parseInt(milhares.substring(0, 1));
				valorPorExtenso += LISTA_NUMEROS_0_a_9[numero].concat(" mil e ");
				idComoString = idComoString.substring(1, 4);
				tamanho = idComoString.length();
			}
			if (tamanho == 3 && !idComoString.equalsIgnoreCase("000")) {
				String centenas = idComoString;
				Integer numero = Integer.parseInt(centenas.substring(0, 1));
				valorPorExtenso += LISTA_CENTENAS[numero-1].concat(" e ");
				idComoString = idComoString.substring(1, 3);
				tamanho = idComoString.length();						
			}
			if (tamanho == 2 && !idComoString.equalsIgnoreCase("00")) {
				String dezenas = idComoString;
				Integer numero = Integer.parseInt(dezenas.substring(0, 1));
				valorPorExtenso += LISTA_DEZENAS[numero-1].concat(" e ");
				idComoString = idComoString.substring(1, 2);
				tamanho = idComoString.length();
			}
			if (tamanho == 1) {
				Integer numero = Integer.parseInt(idComoString);
				valorPorExtenso += LISTA_NUMEROS_0_a_9[numero];
			}
		}
		return valorPorExtenso;
	}
	
}
