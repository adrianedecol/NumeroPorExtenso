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
		converter.setValor(1);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("um");
	}

	@Test
	void converteSeisParaExtenso() {
		converter.setValor(6);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("seis");
	}
	
	@Test
	void converteZeroParaExtenso() {
		converter.setValor(0);
		converter.setZero(true);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("zero");
	}
}
