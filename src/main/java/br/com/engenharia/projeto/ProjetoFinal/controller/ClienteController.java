package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.services.ServiceCliente;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ServiceCliente service;
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
		var dto = service.criar(dados);
	    var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(dto.id()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
