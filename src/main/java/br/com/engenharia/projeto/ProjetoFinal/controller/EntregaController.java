package br.com.engenharia.projeto.ProjetoFinal.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.controle.FachadaEntrega;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.LogRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private LogRepository logRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEndereco dados) {
		var entregas = new Entrega(dados);
		new FachadaEntrega(repository).salvar(entregas);
		
		var log = new Log(dados.idCliente(), LocalDateTime.now());
		new LogDao(logRepository).sava(log);
	}

	@GetMapping
	public Page<DadosDetalhamentoEntrega> listar(@PageableDefault(size = 10, sort = { "cep" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoEntrega::new);
	}

	@GetMapping("{clienteId}")
	public List<DadosDetalhamentoEntrega> listarPorCliente(@PathVariable Long clienteId) {
		return repository.findAllByClienteIdAndAtivoTrue(clienteId).stream().map(DadosDetalhamentoEntrega::new)
				.collect(Collectors.toList());
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoEndereco dados) {
		var entrega = repository.getReferenceById(dados.id());
		new FachadaEntrega(repository).alterar(entrega, dados);
		
		var log = new Log(entrega.getId(), LocalDateTime.now());
		new LogDao(logRepository).sava(log);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var entrega = repository.getReferenceById(id);
		new FachadaEntrega(repository).excluir(entrega);
	}
}
