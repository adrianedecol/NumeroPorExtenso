package com.adrianedecol.numeroporextenso.object;

import org.springframework.stereotype.Component;

@Component
public class NumeroPorExtenso {

	private static final long serialVersionUID = 1L;

	private String extenso;

	public String getExtenso() {
		return extenso;
	}

	public void setExtenso(String extenso) {
		this.extenso = extenso;
	}
}
