package com.adrianedecol.numeroporextenso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianedecol.numeroporextenso.converter.NumeroPorExtenso;
import com.adrianedecol.numeroporextenso.service.NumeroPorExtensoService;

@RestController
@RequestMapping("/")
public class NumeroPorExtensoController {

	@Autowired
	private NumeroPorExtensoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<NumeroPorExtenso> retornarPorExtenso(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.retornarVersaoPorExtenso(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
