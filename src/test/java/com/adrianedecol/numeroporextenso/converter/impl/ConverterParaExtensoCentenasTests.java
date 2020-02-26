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
		resultado = converter.converter(1);
		assertThat(resultado).isEqualToIgnoringCase("cem");
	}
	
	@Test
	void converterQuatrocentosCentosParaExtenso() {
		resultado = converter.converter(4);
		assertThat(resultado).isEqualToIgnoringCase("quatrocentos");
	}
	
	@Test
	void converterNovecentosParaExtenso() {
		resultado = converter.converter(9);
		assertThat(resultado).isEqualToIgnoringCase("novecentos");
	}
}
