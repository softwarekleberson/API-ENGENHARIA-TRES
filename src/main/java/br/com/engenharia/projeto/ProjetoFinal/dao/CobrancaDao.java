package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;

@Service
public class CobrancaDao implements IdaoCobranca{

	@Autowired
	private CobrancaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public CobrancaDao(CobrancaRepository repository, ClienteRepository clienteRepository) {
		this.repository = repository;
		this.clienteRepository = clienteRepository;
	}

	@Override
	public void salvar(Cobranca cobranca) {
		this.repository.save(cobranca);
	}
	
	@Override
	public DadosDetalhamentoCobranca salvarNovaCobranca(Cobranca cobranca, Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if(cliente.isEmpty()) {
			throw new IllegalArgumentException("Id do cliente incorreto");
		}
		
		cobranca.setCliente(clienteId);
		repository.save(cobranca);
		return new DadosDetalhamentoCobranca(cobranca);
	}

	@Override
	public Cobranca alterar(DadosAtualizacaoEndereco dados, Long clienteId, Long idCobranca) {
		
		Optional<Cliente> existeCliente = clienteRepository.findById(clienteId);
		Optional<Cobranca> opDataBaseCobranca = repository.findById(idCobranca);
		
		if(existeCliente.isEmpty() || opDataBaseCobranca.isEmpty()) {
			throw new IllegalArgumentException("Id cliente ou id cobranca incorreto");
		}
		
		else {
			
			if(opDataBaseCobranca.isPresent()) {
				Cobranca cobranca = opDataBaseCobranca.get();
				
				if(dados.logradouro() != null) {
					System.out.println(dados.logradouro());
					cobranca.setLogradouro(dados.logradouro());
				}
				
				if(dados.numero() != null) {
					cobranca.setNumero(dados.numero());
				}
				
				if(dados.bairro() != null) {
					cobranca.setBairro(dados.bairro());
				}
				
				if(dados.cep() != null) {
					cobranca.setCep(dados.cep());
				}
				
				if(dados.observacao() != null) {
					cobranca.setObservacao(dados.observacao());
				}
				
				if(dados.tipoLogradouro() != null) {
					cobranca.setLogradouro(dados.tipoLogradouro());
				}
				
				if(dados.tipoResidencia() != null) {
					cobranca.setTipoResidencia(dados.tipoResidencia());
				}
				
				if(dados.cidade() != null) {
					cobranca.getCidade().setCidade(dados.cidade());
				}
				
				if(dados.estado() != null) {
					cobranca.getCidade().getEstado().setEstado(dados.estado());
				}
				
				if(dados.pais() != null) {
					cobranca.getCidade().getEstado().setPais(dados.pais());
				}
				
				repository.save(cobranca);
				return cobranca;		
			}
		}
		return null;
	}

	@Override
	public Page<DadosDetalhamentoCobranca> listarEnderecosCobrancaDoCliente(Long clienteId, Pageable pageable) {
		Page<Cobranca> cobrancas = repository.findByCliente_Id(clienteId, pageable);	        
	    if(cobrancas.isEmpty()) {
	    	throw new IllegalArgumentException("Id incorreto");
	    }
		return cobrancas.map(DadosDetalhamentoCobranca::new);
	}

	@Override
	public void excluir(Long clienteId, Long idCobranca) {
		
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Optional<Cobranca> cobranca =  repository.findById(idCobranca);
		
		if(cliente.isEmpty()) {
			throw new IllegalArgumentException("Id incorreto do cliente");
		}else {
			if(cobranca.isEmpty()) {
				throw new IllegalArgumentException("Id de cobranca incorrto");
			}
			else {
				repository.deleteById(idCobranca);
			}
		}
	}
}