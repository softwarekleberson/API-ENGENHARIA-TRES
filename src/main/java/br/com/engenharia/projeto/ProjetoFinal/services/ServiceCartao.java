package br.com.engenharia.projeto.ProjetoFinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dao.CartaoDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
public class ServiceCartao {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private CartaoDao daoCartao;
	
	@Autowired
	private LogDao daoLog;
	
	public DadosDetalhamentoCartao criar(DadosCadastroCartao dados) {
		Optional<Cliente> clienteExiste = clienteRepository.findById(dados.idCliente());
		if(!clienteExiste.isPresent()) {
			throw new ValidationException("Id cliente não encontrado");
		}
		
		Cartao cartao = new Cartao(dados);
		daoCartao.salvar(cartao);	
		
		Log log = new Log(cartao.getCliente().getId());
		daoLog.save(log);
		
		return new DadosDetalhamentoCartao(cartao);
	}

	public DadosDetalhamentoCartao atualizar(@Valid DadosAtualizacaoCartao dados) {
		Optional<Cliente> clienteExiste = clienteRepository.findById(dados.idCliente());
		if(!clienteExiste.isPresent()) {
			throw new ValidationException("Id cliente não encontrado");
		}
		
		Optional<Cartao> cartaoExiste = cartaoRepository.findById(dados.idCartao());
		if(!cartaoExiste.isPresent()) {
			throw new ValidationException("Id cartão não encontrado");
		}
		
		var cartao = daoCartao.alterar(dados.idCartao(), dados);
		return new DadosDetalhamentoCartao(cartao);
	}
}