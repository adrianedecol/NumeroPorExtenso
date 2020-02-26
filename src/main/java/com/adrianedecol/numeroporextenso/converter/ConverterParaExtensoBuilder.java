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
		converterMilhares.setValor(id);
		return this;
	}

	public ConverterParaExtensoBuilder centenas (int id, boolean ehCem) {
		converterCentenas.setValor(id);
		converterCentenas.setCem(ehCem);
		return this;
	}
	
	public ConverterParaExtensoBuilder dezenas (int id) {
		converterDezenas.setValor(id);
		return this;
	}
	
	public ConverterParaExtensoBuilder unidades (int id, boolean isZero) {
		converterUnidades.setValor(id);
		converterUnidades.setZero(isZero);
		return this;
	}
	
	public String converter() {
		String milhar = converterMilhares.converter();
		String dezena = converterDezenas.converter();
		String centena = converterCentenas.converter();
		String unidade = converterUnidades.converter();
		return milhar + " e " + centena + " e " + dezena + " e " + unidade;
	}
}
