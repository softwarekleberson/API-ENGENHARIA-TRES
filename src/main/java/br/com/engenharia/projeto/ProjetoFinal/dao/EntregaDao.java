package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntregas;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;

@Service
public class EntregaDao implements IdaoEntrega{

	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public EntregaDao(EntregaRepository repository, ClienteRepository clienteRepository) {
		this.repository = repository;
		this.clienteRepository = clienteRepository;
	}

	@Override
	public void salvar(Entrega entrega) {
		this.repository.save(entrega);
	}
	
	@Override
	public DadosDetalhamentoEntrega salvarNovoEntrega(Entrega entrega, Long clienteId) {
		Optional<Cliente> existeCliente = clienteRepository.findById(clienteId);
		
		if(existeCliente.isEmpty()) {
			throw new IllegalArgumentException("Id do cliente não existe");
		}
		
		entrega.setClinte(clienteId);
		repository.save(entrega);
		return new DadosDetalhamentoEntrega(entrega);
		
	}

	@Override
	public Entrega alterar(DadosAtualizacaoEntregas dados, Long clienteId, Long idEntrega) {
		Optional<Cliente> existeCliente = clienteRepository.findById(clienteId);
		Optional<Entrega> opDataBaseEntrega = repository.findById(idEntrega);
		
		if(existeCliente.isEmpty() || opDataBaseEntrega.isEmpty()) {
			throw new IllegalArgumentException("Id cliente ou id entrega incorreto");
		}
		
		else {
			
			if(opDataBaseEntrega.isPresent()) {
				Entrega entrega = opDataBaseEntrega.get();
				
				if(dados.entrega().logradouro() != null) {
					entrega.setLogradouro(dados.entrega().logradouro());
				}
				
				if(dados.entrega().numero() != null) {
					entrega.setNumero(dados.entrega().numero());
				}

				if(dados.entrega().bairro() != null) {
					entrega.setBairro(dados.entrega().bairro());
				}
				
				if(dados.entrega().cep() != null) {
					entrega.setCep(dados.entrega().cep());
				}
				
				if(dados.entrega().observacao() != null) {
					entrega.setObservacao(dados.entrega().observacao());
				}
				
				if(dados.fraseEntrega() != null) {
					entrega.setObservacao(dados.fraseEntrega());
				}
				
				if(dados.entrega().tipoLogradouro() != null) {
					entrega.getTipoLogradouro().setTipoLogradouro(dados.entrega().tipoLogradouro());
				}
				
				if(dados.entrega().tipoResidencia() != null) {
					entrega.getTipoResidencia().setTipoResidencia(dados.entrega().tipoResidencia());
				}
				
				if(dados.entrega().cidade() != null) {
					entrega.getCidade().setCidade(dados.entrega().cidade());
				}
				
				if(dados.entrega().estado() != null) {
					entrega.getCidade().getEstado().setEstado(dados.entrega().estado());
				}
				
				if(dados.entrega().pais() != null) {
					entrega.getCidade().getEstado().getPais().setPaisUpdate(dados.entrega().pais());
				}
				
				repository.save(entrega);
				return entrega;
			}
		}
		return null;
	}

	@Override
	public Page<DadosDetalhamentoEntrega> listarEntregasDoCliente(Long clienteId, Pageable pageable) {
		Page<Entrega> entregas = repository.findByCliente_Id(clienteId, pageable);	        
	    if(entregas.isEmpty()) {
	    	throw new IllegalArgumentException("Id incorreto");
	    }
		return entregas.map(DadosDetalhamentoEntrega::new);
	}

	@Override
	public void excluir(Long clienteId, Long idEntrega) {
		
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Optional<Entrega> cobranca =  repository.findById(idEntrega);
		
		if(cliente.isEmpty()) {
			throw new IllegalArgumentException("Id incorreto do cliente");
		}else {
			if(cobranca.isEmpty()) {
				throw new IllegalArgumentException("Id de entrega incorrto");
			}
			else {
				repository.deleteById(idEntrega);
			}
		}
	}
}