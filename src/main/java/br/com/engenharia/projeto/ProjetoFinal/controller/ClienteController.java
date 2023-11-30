package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.engenharia.projeto.ProjetoFinal.controle.FachadaCliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
		var cliente = new Cliente(dados);
		new FachadaCliente(repository).salvar(cliente);
	}

	@GetMapping
	public Page<DadosDetalhamentoCliente> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
	}
}
