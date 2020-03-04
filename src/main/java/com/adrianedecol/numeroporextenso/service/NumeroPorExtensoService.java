package com.adrianedecol.numeroporextenso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianedecol.numeroporextenso.converter.ConverterParaExtensoBuilder;
import com.adrianedecol.numeroporextenso.converter.NumeroPorExtenso;

@Service
public class NumeroPorExtensoService {

	@Autowired
	private NumeroPorExtenso porExtenso;	
	@Autowired
	private ConverterParaExtensoBuilder builderConversao;
	
	public NumeroPorExtenso retornarVersaoPorExtenso (Long id) throws Exception {
		if (id > 99999 || id < -99999) {
			throw new Exception("Valor fora do limite [-99999,99999]");
		}
		Map<String, Integer> valores = desmembrarNumeroEmMilharesCentenasDecimaisEUnidades(id);
		String extenso = builderConversao.negativo(valores.get("S")==-1)
					.milhares(valores.get("M"))
					.centenas(valores.get("C"))
					.dezenas(valores.get("D"))
					.unidades(valores.get("U"))
					.converter();
			porExtenso.setExtenso(extenso);			
		return porExtenso;		
	}
	
	private Map<String, Integer> desmembrarNumeroEmMilharesCentenasDecimaisEUnidades (Long id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int milhares = 0, centenas = 0, dezenas = 0, unidades = 0;
		map.put("S", 1);
		if (Math.signum(id.doubleValue()) == -1) {
			map.put("S", -1);
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
