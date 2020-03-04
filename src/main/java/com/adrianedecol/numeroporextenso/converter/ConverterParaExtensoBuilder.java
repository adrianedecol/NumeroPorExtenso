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
	private boolean isNegativo;
	
	public ConverterParaExtensoBuilder milhares(int id) {
		converterMilhares.setValor(id);
		return this;
	}

	public ConverterParaExtensoBuilder centenas (int id){
		converterCentenas.setValor(id);
		return this;
	}
	
	public ConverterParaExtensoBuilder dezenas (int id) {
		converterDezenas.setValor(id);
		return this;
	}
	
	public ConverterParaExtensoBuilder unidades (int id) {
		converterUnidades.setValor(id);
		return this;
	}
	
	private void processarExcessoes(){
		converterCentenas.setCem(converterCentenas.getValor()==1&&converterDezenas.getValor()==0&&converterUnidades.getValor()==0);
		converterUnidades.setZero(converterMilhares.getValor()==0&&converterCentenas.getValor()==0&&converterDezenas.getValor()==0);		
		int dezenasComUnidades = ((converterDezenas.getValor()*10)+converterUnidades.getValor());
		boolean entre10e19 = dezenasComUnidades >= 10 && dezenasComUnidades <= 19;
		converterDezenas.setEntre10e19(entre10e19);
		if (entre10e19) {
			converterDezenas.setValorEntre10e19(dezenasComUnidades);
			converterUnidades.setValor(0); //nesse caso todo o valor será tratado pelo converter das dezenas
		}
	}
	
	public ConverterParaExtensoBuilder negativo(boolean isNegativo) {
		this.isNegativo = isNegativo;
		return this;
	}
	
	public String converter() {		
		processarExcessoes();
		String milhar = converterMilhares.converter();
		String dezena = converterDezenas.converter();
		String centena = converterCentenas.converter();
		String unidade = converterUnidades.converter();	
		String eMilhar = (!milhar.isEmpty()&&(!centena.isEmpty()||!dezena.isEmpty()||!unidade.isEmpty())?" e ":"");
		String eCentena = !centena.isEmpty()&&((!dezena.isEmpty()||!unidade.isEmpty()))?" e ":"";
		String eDezena = (!dezena.isEmpty()&&!unidade.isEmpty())?" e ":"";
		String menos = isNegativo?"menos ":"";
		return menos.concat(milhar).concat(eMilhar).concat(centena).concat(eCentena)
				.concat(dezena).concat(eDezena).concat(unidade);
				
	}
	
}
