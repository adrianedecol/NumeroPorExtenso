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
		resultado = converter.converter(1);
		assertThat(resultado).isEqualToIgnoringCase("dez");
	}
	
	@Test
	void converterTrintaParaExtenso() {
		resultado = converter.converter(3);
		assertThat(resultado).isEqualToIgnoringCase("trinta");
	}
	
	@Test
	void converterNoventaParaExtenso() {
		resultado = converter.converter(9);
		assertThat(resultado).isEqualToIgnoringCase("noventa");
	}

}
