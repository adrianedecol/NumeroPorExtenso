package com.adrianedecol.numeroporextenso.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adrianedecol.numeroporextenso.converter.NumeroPorExtenso;
import com.adrianedecol.numeroporextenso.service.NumeroPorExtensoService;

@SpringBootTest
class NumeroPorExtensoServiceTests {
	
	@Autowired
	private NumeroPorExtensoService service;
	@Autowired
	private NumeroPorExtenso resultado;
	
	@Test
	void retornarNumeroCincoPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(5L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("cinco");
	}
	
	@Test
	void retornarNumeroDezenovePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("dezenove");
	}
	
	@Test
	void retornarNumeroTrintaECincoPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(35L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("trinta e cinco");
	}

	@Test
	void retornarNumeroSetentaPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(70L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("setenta");
	}
	
	@Test
	void retornarNumeroQuinhentosEQuarentaESetePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(547L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("quinhentos e quarenta e sete");
	}
	
	@Test
	void retornarNumeroDoisMilETrezentosEOitentaENovePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(2389L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dois Mil e Trezentos E Oitenta E Nove");
	}
	

	@Test
	void retornarNumeroVinteECincoMilESeiscentosETrintaEDoisPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(25632L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Vinte E Cinco Mil E Seiscentos E Trinta E Dois");
	}
	
	@Test
	void retornarNumeroMenosCincoPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-5L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos cinco");
	}
	
	@Test
	void retornarNumeroMenosDezenovePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos dezenove");
	}
	
	@Test
	void retornarNumeroMenosTrintaECincoPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-35L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos trinta e cinco");
	}

	@Test
	void retornarNumeroMenosSetentaPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-70L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos setenta");
	}
	
	@Test
	void retornarNumeroMenosQuinhentosEQuarentaESetePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-547L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos quinhentos e quarenta e sete");
	}
	
	@Test
	void retornarNumeroMenosDoisMilETrezentosEOitentaENovePorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-2389L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos Dois Mil e Trezentos E Oitenta E Nove");
	}	

	@Test
	void retornarNumeroMenosVinteECincoMilESeiscentosETrintaEDoisPorExtenso() throws Exception {
		resultado = service.retornarVersaoPorExtenso(-25632L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("menos Vinte E Cinco Mil E Seiscentos E Trinta E Dois");
	}
	
	@Test
	void retornarNumeroZero() throws Exception {
		resultado = service.retornarVersaoPorExtenso(0L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("zero");
	}
	
	@Test
	void retornarNumeroQuinhentos() throws Exception {
		resultado = service.retornarVersaoPorExtenso(500L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("quinhentos");
	}
	
	@Test
	void retornarNumeroTresMil() throws Exception {
		resultado = service.retornarVersaoPorExtenso(3000L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("três mil");
	}
	
	@Test
	void retornarNumeroCinquentaMil() throws Exception {
		resultado = service.retornarVersaoPorExtenso(50000L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("cinquenta mil");
	}
	
	@Test
	void retornarNumeroUmMilECinquentaEQuatro() throws Exception {
		resultado = service.retornarVersaoPorExtenso(1054L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("um mil e cinquenta e quatro");
	}
	
	@Test
	void retornarNumeroUmMilECem() throws Exception {
		resultado = service.retornarVersaoPorExtenso(1100L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("um mil e cem");
	}
	
	@Test
	void retornarNumeroOitocentosEQuarenta() throws Exception {
		resultado = service.retornarVersaoPorExtenso(840L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("oitocentos e quarenta");
	}
	
	@Test
	void retornarNumeroUmMilEQuinhentosEQuatro() throws Exception {
		resultado = service.retornarVersaoPorExtenso(1504L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Um Mil E Quinhentos E Quatro");
	}
	
	@Test
	void retornarNumeroDezenove() throws Exception {
		resultado = service.retornarVersaoPorExtenso(19L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dezenove");
	}
	
	@Test
	void retornarNumeroDezMilEQuinhentosEVinte() throws Exception {
		resultado = service.retornarVersaoPorExtenso(10520L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("Dez Mil E Quinhentos E Vinte");
	}
	
	@Test
	void retornarNumeroSessentaESeteMilEQuinhentosEDezessete() throws Exception {
		resultado = service.retornarVersaoPorExtenso(67517L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("sessenta e sete mil e quinhentos e dezesete");
	}
	
	@Test
	void retornarNumeroQuatorzeMil() throws Exception {
		resultado = service.retornarVersaoPorExtenso(14000L);
		assertThat(resultado.getExtenso()).isEqualToIgnoringCase("quatorze mil");
	}
}
