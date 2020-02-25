package com.adrianedecol.numeroporextenso;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adrianedecol.numeroporextenso.object.NumeroPorExtenso;
import com.adrianedecol.numeroporextenso.service.NumeroPorExtensoService;

@SpringBootTest
class NumeroPorExtensoServiceTests {
	
	@Autowired
	private NumeroPorExtensoService service;
	@Autowired
	private NumeroPorExtenso resultado;
	
	@Test
	void retornarNumeroCincoPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(5L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("cinco");
	}
	
	@Test
	void retornarNumeroDezenovePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("dezenove");
	}
	
	@Test
	void retornarNumeroTrintaECincoPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(35L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("trinta e cinco");
	}

	@Test
	void retornarNumeroSetentaPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(70L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("setenta");
	}
	
	@Test
	void retornarNumeroQuinhentosEQuarentaESetePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(547L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("quinhentos e quarenta e sete");
	}
	
	@Test
	void retornarNumeroDoisMilETrezentosEOitentaENovePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(2389L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dois Mil e Trezentos E Oitenta E Nove");
	}
	

	@Test
	void retornarNumeroVinteECincoMilESeiscentosETrintaEDoisPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(25632L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Vinte E Cinco Mil E Seiscentos E Trinta E Dois");
	}
	
	@Test
	void retornarNumeroMenosCincoPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-5L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos cinco");
	}
	
	@Test
	void retornarNumeroMenosDezenovePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos dezenove");
	}
	
	@Test
	void retornarNumeroMenosTrintaECincoPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-35L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos trinta e cinco");
	}

	@Test
	void retornarNumeroMenosSetentaPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-70L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos setenta");
	}
	
	@Test
	void retornarNumeroMenosQuinhentosEQuarentaESetePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-547L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos quinhentos e quarenta e sete");
	}
	
	@Test
	void retornarNumeroMenosDoisMilETrezentosEOitentaENovePorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-2389L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos Dois Mil e Trezentos E Oitenta E Nove");
	}	

	@Test
	void retornarNumeroMenosVinteECincoMilESeiscentosETrintaEDoisPorExtenso() {
		resultado = service.retornarVersaoPorExtenso(-25632L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos Vinte E Cinco Mil E Seiscentos E Trinta E Dois");
	}
	
	@Test
	void retornarValorNegativoForaDoIntervalo() {
		resultado = service.retornarVersaoPorExtenso(-999999L);
		assertThat(resultado.getExtenso()).contains("fora");
	}
	
	@Test
	void retornarValorPositivoForaDoIntervalo() {
		resultado = service.retornarVersaoPorExtenso(999999L);
		assertThat(resultado.getExtenso()).contains("fora");
	}
	
	@Test
	void retornarNumeroZero() {
		resultado = service.retornarVersaoPorExtenso(0L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("zero");
	}
	
	@Test
	void retornarNumeroQuinhentos() {
		resultado = service.retornarVersaoPorExtenso(500L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("quinhentos");
	}
	
	@Test
	void retornarNumeroTresMil() {
		resultado = service.retornarVersaoPorExtenso(3000L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("três mil");
	}
	
	@Test
	void retornarNumeroCinquentaMil() {
		resultado = service.retornarVersaoPorExtenso(50000L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("cinquenta mil");
	}
	
	@Test
	void retornarNumeroUmMilECinquentaEQuatro() {
		resultado = service.retornarVersaoPorExtenso(1054L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("um mil e cinquenta e quatro");
	}
	
	@Test
	void retornarNumeroUmMilECem() {
		resultado = service.retornarVersaoPorExtenso(1100L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("um mil e cem");
	}
	
	@Test
	void retornarNumeroOitocentosEQuarenta() {
		resultado = service.retornarVersaoPorExtenso(840L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("oitocentos e quarenta");
	}
	
	@Test
	void retornarNumeroUmMilEQuinhentosEQuatro() {
		resultado = service.retornarVersaoPorExtenso(1504L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Um Mil E Quinhentos E Quatro");
	}
	
	@Test
	void retornarNumeroDezenove() {
		resultado = service.retornarVersaoPorExtenso(19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dezenove");
	}
	
	@Test
	void retornarNumeroDezMilEQuinhentosEVinte() {
		resultado = service.retornarVersaoPorExtenso(10520L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dez Mil E Quinhentos E Vinte");
	}
	
	@Test
	void retornarNumeroSessentaESeteMilEQuinhentosEDezessete() {
		resultado = service.retornarVersaoPorExtenso(67517L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("sessenta e sete mil e quinhentos e dezesette");
	}
}
