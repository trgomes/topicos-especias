package br.gov.sp.fatec.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	@RequestMapping(value = "/")
	public String hello()
	{
		return "O mapeamento Cliente está funcionando!";
	}
}
