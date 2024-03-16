package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.engenharia.projeto.ProjetoFinal.dao.CobrancaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.EntregaDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntregas;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEntrega;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/entrega/{clienteId}")
	public ResponseEntity cadastrarEntrega(@RequestBody @Valid DadosCadastroEntrega dados, @PathVariable Long clienteId) {
		var entrega = new Entrega(dados);
		new EntregaDao(entregaRepository, clienteRepository).salvarNovoEntrega(entrega, clienteId);
		return ResponseEntity.ok(entrega);
	}
	
	@PostMapping("/cobranca/{clienteId}")
	public ResponseEntity cadastrarCobranca(@RequestBody @Valid DadosCadastroCobranca dados, @PathVariable Long clienteId) {
		var cobranca = new Cobranca(dados);
		new CobrancaDao(cobrancaRepository, clienteRepository).salvarNovaCobranca(cobranca, clienteId);
		return ResponseEntity.ok(cobranca);
	}
	
	@GetMapping("/entrega/{clienteId}")
	public ResponseEntity<Page<DadosDetalhamentoEntrega>> listarEnderecosEntrega(@PathVariable Long clienteId, Pageable pageable){
		Page<DadosDetalhamentoEntrega> entregas = new EntregaDao(entregaRepository, clienteRepository).listarEntregasDoCliente(clienteId, pageable);
		return ResponseEntity.ok(entregas);
    }
	
	@GetMapping("/cobranca/{clienteId}")
	public ResponseEntity<Page<DadosDetalhamentoCobranca>> listarEnderecosCobranca(@PathVariable Long clienteId, Pageable pageable){
		Page<DadosDetalhamentoCobranca> cobrancas = new CobrancaDao(cobrancaRepository, clienteRepository).listarEnderecosCobrancaDoCliente(clienteId, pageable);
		return ResponseEntity.ok(cobrancas);
    }
	
	@PutMapping("/entrega/{clienteId}/{idEntrega}")
	public  ResponseEntity atualizarEntrega(@RequestBody @Valid DadosAtualizacaoEntregas dados, @PathVariable Long clienteId, @PathVariable Long idEntrega ) {
		Entrega updateEntrega = new EntregaDao(entregaRepository, clienteRepository).alterar(dados, clienteId, idEntrega);
		return ResponseEntity.ok(updateEntrega);
	}
	
	@PutMapping("/cobranca/{clienteId}/{idCobranca}")
	public  ResponseEntity atualizarCobranca(@RequestBody @Valid DadosAtualizacaoEndereco dados, @PathVariable Long clienteId, @PathVariable Long idCobranca) {
		Cobranca updateCobranca = new CobrancaDao(cobrancaRepository, clienteRepository).alterar(dados, clienteId, idCobranca);
		return ResponseEntity.ok(updateCobranca);
	}
	
	@DeleteMapping("/entrega/{clienteId}/{idEntrega}")
	public ResponseEntity<Void> deletarEnderecoEntrega (@PathVariable Long clienteId, @PathVariable Long idEntrega) {
		new EntregaDao(entregaRepository, clienteRepository).excluir(clienteId, idEntrega);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/cobranca/{clienteId}/{idCobranca}")
	public ResponseEntity<Void> deletarEnderecoCobranca (@PathVariable Long clienteId, @PathVariable Long idCobranca) {
		new CobrancaDao(cobrancaRepository, clienteRepository).excluir(clienteId, idCobranca);
		return ResponseEntity.noContent().build();
	}	
}