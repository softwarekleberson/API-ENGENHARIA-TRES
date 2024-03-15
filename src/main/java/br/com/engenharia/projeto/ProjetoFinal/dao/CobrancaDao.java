package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCobrancas;
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
	public Cobranca alterar(DadosAtualizacaoCobrancas dados, Long clienteId, Long idCobranca) {
		
		Optional<Cliente> existeCliente = clienteRepository.findById(clienteId);
		Optional<Cobranca> opDataBaseCobranca = repository.findById(dados.idCliente());
		
		if(existeCliente.isEmpty() || opDataBaseCobranca.isEmpty()) {
			throw new IllegalArgumentException("Id cliente ou id cobranca incorreto");
		}
		
		else {
			
			if(opDataBaseCobranca.isPresent()) {
				Cobranca cobranca = opDataBaseCobranca.get();
				
				if(dados.cobranca().logradouro() != null) {
					cobranca.setLogradouro(dados.cobranca().logradouro());
				}
				
				if(dados.cobranca().numero() != null) {
					cobranca.setNumero(dados.cobranca().numero());
				}
				
				if(dados.cobranca().bairro() != null) {
					cobranca.setBairro(dados.cobranca().bairro());
				}
				
				if(dados.cobranca().cep() != null) {
					cobranca.setCep(dados.cobranca().cep());
				}
				
				if(dados.cobranca().observacao() != null) {
					cobranca.setObservacao(dados.cobranca().observacao());
				}
				
				if(dados.cobranca().tipoLogradouro() != null) {
					cobranca.setTipoLogradouro(dados.cobranca().tipoLogradouro());
				}
				
				if(dados.cobranca().tipoResidencia() != null) {
					cobranca.setTipoResidencia(dados.cobranca().tipoResidencia());
				}
				
				if(dados.cobranca().cidade() != null) {
					cobranca.setCidade(dados.cobranca().cidade());
				}
				
				if(dados.cobranca().estado() != null) {
					cobranca.setEstado(dados.cobranca().estado());
				}
				
				if(dados.cobranca().pais() != null) {
					cobranca.getCidade().getEstado().setPais(dados.cobranca().pais());
				}
				
				repository.save(cobranca);
				return cobranca;		
			}
		}
		return null;
	}

	public Page<DadosDetalhamentoCobranca> listarEnderecosCobrancaDoCliente(Long clienteId, Pageable pageable) {
		Page<Cobranca> cobrancas = repository.findByCliente_Id(clienteId, pageable);	        
	    if(cobrancas.isEmpty()) {
	    	throw new IllegalArgumentException("Id incorreto");
	    }
		return cobrancas.map(DadosDetalhamentoCobranca::new);
	}

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