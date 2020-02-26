package com.adrianedecol.numeroporextenso.converter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterParaExtensoDezenasTests {
	
	@Autowired
	private ConverterParaExtensoDezenas converter;
	private String resultado;
	
	@Test
	void converterDezParaExtenso() {
		converter.setValor(1);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("dez");
	}
	
	@Test
	void converterTrintaParaExtenso() {
		converter.setValor(3);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("trinta");
	}
	
	@Test
	void converterNoventaParaExtenso() {
		converter.setValor(9);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("noventa");
	}

}
