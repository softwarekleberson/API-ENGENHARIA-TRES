package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import br.com.engenharia.projeto.ProjetoFinal.services.ServiceCartao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

	@Autowired
	private ServiceCartao service;
	
	@Autowired
	private CartaoRepository repository;
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCartao dados, UriComponentsBuilder uriBuilder) {
		var dto = service.criar(dados);
	    var uri = uriBuilder.path("/cartao/{id}").buildAndExpand(dto.id()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCartao dados) {
		DadosDetalhamentoCartao detalhamentoCartao = service.atualizar(dados);
        return ResponseEntity.ok(detalhamentoCartao);
	}
}
