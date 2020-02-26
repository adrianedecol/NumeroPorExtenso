package com.adrianedecol.numeroporextenso.converter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterParaExtensoMilharesTests {

	@Autowired
	private ConverterParaExtensoMilhares converter;
	private String resultado;
	
	@Test
	void converterDezMilParaExtenso() {
		resultado = converter.converter(10);
		assertThat(resultado).isEqualToIgnoringCase("dez mil");
	}
	
	@Test
	void converterCincoMilParaExtenso() {
		resultado = converter.converter(5);
		assertThat(resultado).isEqualToIgnoringCase("cinco mil");
	}
	
	@Test
	void converterDezesseisMilParaExtenso() {
		resultado = converter.converter(16);
		assertThat(resultado).isEqualToIgnoringCase("dezesseis mil");
	}
	
	@Test
	void converterQuarentaECincoMilParaExtenso() {
		resultado = converter.converter(45);
		assertThat(resultado).isEqualToIgnoringCase("quarenta e cinco mil");
	}
	
	@Test
	void converterNoventaENoveMilParaExtenso() {
		resultado = converter.converter(99);
		assertThat(resultado).isEqualToIgnoringCase("noventa e nove mil");
	}
}
