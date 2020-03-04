package com.adrianedecol.numeroporextenso.converter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterParaExtensoCentenasTests {

	@Autowired
	private ConverterParaExtensoCentenas converter;
	private String resultado;
	
	@Test
	void converterCemParaExtenso() {
		converter.setValor(1);
		converter.setCem(true);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("cem");
	}
	
	@Test
	void converterCentoParaExtenso() {
		converter.setValor(1);
		converter.setCem(false);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("cento");
	}
	
	@Test
	void converterQuatrocentosCentosParaExtenso(){
		converter.setValor(4);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("quatrocentos");
	}
	
	@Test
	void converterNovecentosParaExtenso() {
		converter.setValor(9);
		resultado = converter.converter();
		assertThat(resultado).isEqualToIgnoringCase("novecentos");
	}
}
