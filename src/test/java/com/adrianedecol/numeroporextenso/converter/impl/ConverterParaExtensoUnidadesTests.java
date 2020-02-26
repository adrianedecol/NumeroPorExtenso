package com.adrianedecol.numeroporextenso.converter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterParaExtensoUnidadesTests {
	
	@Autowired
	private ConverterParaExtensoUnidades converter;
	private String resultado;
	
	@Test
	void converterUmParaExtenso() {
		resultado = converter.converter(1);
		assertThat(resultado).isEqualToIgnoringCase("um");
	}

	@Test
	void converteSeisParaExtenso() {
		resultado = converter.converter(6);
		assertThat(resultado).isEqualToIgnoringCase("seis");
	}
	
	@Test
	void converteZeroParaExtenso() {
		resultado = converter.converter(0);
		assertThat(resultado).isEqualToIgnoringCase("zero");
	}
}
