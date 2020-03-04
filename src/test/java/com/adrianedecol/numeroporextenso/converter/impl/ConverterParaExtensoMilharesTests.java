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
		converter.setValor(10);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("dez mil");
	}
	
	@Test
	void converterCincoMilParaExtenso() {
		converter.setValor(5);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("cinco mil");
	}
	
	@Test
	void converterDezesseisMilParaExtenso() {
		converter.setValor(16);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("dezesseis mil");
	}
	
	@Test
	void converterQuarentaECincoMilParaExtenso() {
		converter.setValor(45);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("quarenta e cinco mil");
	}
	
	@Test
	void converterNoventaENoveMilParaExtenso() {
		converter.setValor(99);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("noventa e nove mil");
	}
}
