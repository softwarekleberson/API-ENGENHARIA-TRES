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

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.controle.FachadaCartao;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.LogRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

	@Autowired
	private CartaoRepository repository;

	@Autowired
	private LogRepository logRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCartao dados) {
		var cartao = new Cartao(dados);
		new FachadaCartao(repository).salvar(cartao);

		var log = new Log(dados.idCliente(), LocalDateTime.now());
		new LogDao(logRepository).sava(log);
	}

	@GetMapping
	public Page<DadosDetalhamentoCartao> listar(@PageableDefault(size = 10, sort = { "codigo" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCartao::new);
	}

	@GetMapping("{clienteId}")
	public List<DadosDetalhamentoCartao> listarPorCliente(@PathVariable Long clienteId) {
		return repository.findAllByClienteIdAndAtivoTrue(clienteId).stream().map(DadosDetalhamentoCartao::new)
				.collect(Collectors.toList());
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoCartao dados) {
		var cartao = repository.getReferenceById(dados.id());
		new FachadaCartao(repository).alterar(cartao, dados);

		var log = new Log(cartao.getCliente().getId(), LocalDateTime.now());
		new LogDao(logRepository).sava(log);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var cartao = repository.getReferenceById(id);
		new FachadaCartao(repository).excluir(cartao);
	}

}
