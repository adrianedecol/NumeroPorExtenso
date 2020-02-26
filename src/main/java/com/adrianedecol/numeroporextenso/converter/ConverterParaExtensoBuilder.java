package com.adrianedecol.numeroporextenso.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adrianedecol.numeroporextenso.converter.impl.ConverterParaExtensoCentenas;
import com.adrianedecol.numeroporextenso.converter.impl.ConverterParaExtensoDezenas;
import com.adrianedecol.numeroporextenso.converter.impl.ConverterParaExtensoMilhares;
import com.adrianedecol.numeroporextenso.converter.impl.ConverterParaExtensoUnidades;

@Component
public class ConverterParaExtensoBuilder {
	
	@Autowired
	private ConverterParaExtensoMilhares converterMilhares;
	@Autowired
	private ConverterParaExtensoCentenas converterCentenas;
	@Autowired
	private ConverterParaExtensoDezenas converterDezenas;
	@Autowired
	private ConverterParaExtensoUnidades converterUnidades;
	
	public ConverterParaExtensoBuilder milhares(int id) {
		return this;
	}

	public ConverterParaExtensoBuilder centenas (int id) {
		return this;
	}
	
	public ConverterParaExtensoBuilder dezenas (int id) {
		return this;
	}
	
	public ConverterParaExtensoBuilder unidades (int id) {
		return this;
	}
	
	public String converter(int milhares, int centenas, int dezenas, int unidades) {
		String milhar = converterMilhares.converter(milhares);
		String dezena = converterDezenas.converter(dezenas);
		String centena = converterCentenas.converter(centenas);
		String unidade = converterUnidades.converter(unidades);
		return milhar + " e " + centena + " e " + dezena + " e " + unidade;
	}
}
