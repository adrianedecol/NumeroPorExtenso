package com.adrianedecol.numeroporextenso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoBuilder;
import com.adrianedecol.numeroporextenso.object.NumeroPorExtenso;

@Service
public class NumeroPorExtensoService {

	@Autowired
	private NumeroPorExtenso porExtenso;
	/*private final String[] LISTA_NUMEROS_0_a_9 = {"zero", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove"};
	private final String[] LISTA_NUMEROS_10_a_19 = {"dez", "onze", "doze", "treze", "quatorze", "quinze", 
			"dezesseis", "dezesete", "dezoito", "dezenove"};
	private final String[] LISTA_DEZENAS = {"dez", "vinte", "trinta", "quarenta", "cinquenta", 
			"sessenta", "setenta", "oitenta", "noventa"};
	private final String[] LISTA_CENTENAS = {"cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", 
			"seiscentos", "setecentos", "oitocentos", "novecentos"};
	private final String[] LISTA_CENTENAS_COM_CEM = {"cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", 
			"seiscentos", "setecentos", "oitocentos", "novecentos"};
	private final String FORA_DO_LIMITE = "valor fora do limite [-99999,99999]";
	private final String MENOS = "menos ";
	private final String E = " e ";
	private final String MIL = " mil";
	private final String MENOS_SIMBOLO = "-";
	private final String VAZIO = "";*/
	
	@Autowired
	private ConverterParaExtensoBuilder builderConversao;
	
	public NumeroPorExtenso retornarVersaoPorExtenso (Long id) {
		Map<String, Integer> valores = converterNumeroParaExtenso2(id);
		String extenso = builderConversao.milhares(valores.get("M"))
				.centenas(valores.get("C"), (valores.get("D")==0&&valores.get("U")==0) )
				.dezenas(valores.get("D"))
				.unidades(valores.get("U"), (valores.get("M")==0&&valores.get("D")==0&&valores.get("U")==0))
				.converter();
		porExtenso.setExtenso(extenso);		
		//porExtenso.setExtenso(converterNumeroParaExtenso(id));
		return porExtenso;		
	}
	
	/*private String converterNumeroParaExtenso(Long id) {
		String idComoString = id.toString();
		String valorPorExtenso = FORA_DO_LIMITE;
		int tamanho = idComoString.length();
		if ((tamanho <= 5) || (tamanho == 6 && (idComoString.startsWith(MENOS_SIMBOLO)))) {
			valorPorExtenso = VAZIO;
			if (idComoString.startsWith(MENOS_SIMBOLO)) {
				valorPorExtenso = MENOS;
				idComoString = idComoString.replace(MENOS_SIMBOLO, VAZIO);
				tamanho = idComoString.length();
			}			
			if (tamanho == 5) {
				String milhares = idComoString.substring(0, 2);
				boolean ehEntre10e19 = Integer.parseInt(milhares) >= 10 && Integer.parseInt(milhares) <= 19;
				Integer numero = Integer.parseInt(milhares.substring(0, 1));
				Integer numero2 = Integer.parseInt(milhares.substring(1, 2));
				if (Integer.parseInt(idComoString) % 1000 == 0) {
					valorPorExtenso += (ehEntre10e19? LISTA_NUMEROS_10_a_19[numero2]:LISTA_DEZENAS[numero-1]).concat(MIL);
					return valorPorExtenso;					
				}
				valorPorExtenso += (ehEntre10e19? LISTA_NUMEROS_10_a_19[numero2]:LISTA_DEZENAS[numero-1].concat(E).concat(LISTA_NUMEROS_0_a_9[numero2])).concat(MIL).concat(E);
				idComoString = idComoString.substring(2, 5);
				tamanho = idComoString.length();
			}
			if (tamanho == 4 && !idComoString.equalsIgnoreCase("0000")) {
				String milhares = idComoString.substring(0, 1);
				Integer numero = Integer.parseInt(milhares.substring(0, 1));
				if (Integer.parseInt(idComoString) % 1000 == 0) {
					valorPorExtenso += LISTA_NUMEROS_0_a_9[numero].concat(MIL);
					return valorPorExtenso;					
				}
				valorPorExtenso += LISTA_NUMEROS_0_a_9[numero].concat(MIL).concat(E);
				idComoString = idComoString.substring(1, 4);
				tamanho = idComoString.length();
			}
			if (tamanho == 3 && !idComoString.equalsIgnoreCase("000")) {
				String centenas = idComoString;
				Integer numero = Integer.parseInt(centenas.substring(0, 1));
				if (Integer.parseInt(idComoString) % 100 == 0) {
					valorPorExtenso += LISTA_CENTENAS_COM_CEM[numero-1];
					return valorPorExtenso;					
				} else if (numero != 0) {
					valorPorExtenso += LISTA_CENTENAS[numero-1].concat(E);	
				}
				idComoString = idComoString.substring(1, 3);
				tamanho = idComoString.length();						
			}
			if (tamanho == 2 && !idComoString.equalsIgnoreCase("00")) {
				String dezenas = idComoString;
				boolean ehEntre10e19 = Integer.parseInt(idComoString) >= 10 && Integer.parseInt(idComoString) <= 19;
				Integer numero = Integer.parseInt(dezenas.substring(0, 1));
				if (numero != 0) {					
					if (Integer.parseInt(idComoString) % 10 == 0) {
						valorPorExtenso += (ehEntre10e19? LISTA_NUMEROS_10_a_19[Integer.parseInt(dezenas.substring(1, 2))]:LISTA_DEZENAS[numero-1]);
						return valorPorExtenso;					
					}
					valorPorExtenso += (ehEntre10e19? LISTA_NUMEROS_10_a_19[Integer.parseInt(dezenas.substring(1, 2))]:LISTA_DEZENAS[numero-1].concat(E));					
				}
				idComoString = idComoString.substring(1, 2);
				tamanho = (ehEntre10e19?0:idComoString.length());
			}
			if (tamanho == 1) {
				Integer numero = Integer.parseInt(idComoString);
				valorPorExtenso += LISTA_NUMEROS_0_a_9[numero];	
			}
		}
		return valorPorExtenso;
	}*/
	
	private Map<String, Integer> converterNumeroParaExtenso2 (Long id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int milhares = 0, centenas = 0, dezenas = 0, unidades = 0;
		if (Math.signum(id.doubleValue()) == -1) {
			id = id * - 1L;
		}
		unidades = id.intValue();
		if (id.compareTo(99L) == -1 || id.compareTo(99L) == 0) { //números com apenas dezenas
			dezenas = Math.floorDiv(id.intValue(), 10);
			unidades = Math.floorDiv(id.intValue() - (dezenas * 10), 1);
		} else if (id.compareTo(999L) == -1 || id.compareTo(999L) == 0) { //números com centenas
			centenas = Math.floorDiv(id.intValue(), 100);
			dezenas = Math.floorDiv(id.intValue() - (centenas * 100), 10);
			unidades = Math.floorDiv((id.intValue() - (centenas * 100) - (dezenas * 10)), 1);
		} else if (id.compareTo(1000L) == 1 || id.compareTo(1000L) == 0) { //números com milhares
			milhares = Math.floorDiv(id.intValue(), 1000);
			centenas = Math.floorDiv(id.intValue() - (milhares * 1000), 100);
			dezenas = Math.floorDiv(id.intValue() - (milhares * 1000) - (centenas * 100), 10);
			unidades = Math.floorDiv(id.intValue() - (milhares * 1000) - (centenas * 100) - (dezenas * 10), 1);
		}		
		map.put("M", milhares);
		map.put("C", centenas);
		map.put("D", dezenas);
		map.put("U", unidades);
		return map;
	}
	
}
