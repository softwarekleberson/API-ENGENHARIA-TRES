package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;

@Service
public class CartaoDao implements IdaoCartao{

	@Autowired
	private CartaoRepository repository;
	
	public CartaoDao(CartaoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public String salvar(Cartao entidade) {
		repository.save(entidade);
		return null;
	}

	public Cartao alterar(Long idCartao, DadosAtualizacaoCartao dados) {
		Optional<Cartao> opDataBaseCartao = repository.findById(idCartao);
		
		if(opDataBaseCartao.isPresent()) {
			Cartao cartao = opDataBaseCartao.get();
			
			if(dados.nomeImpresso() != null) {
				cartao.setNomeImpresso(dados.nomeImpresso());
			}
			
			if(dados.codigo() != null) {
				cartao.setCodigo(dados.codigo());
			}
			
			repository.save(cartao);
			return cartao;
		} 
	
		return null;
	}

	@Override
	public void deletar(Long id) {
		Optional<Cartao> cartao = repository.findById(id);
		if(cartao.isEmpty()) {
			throw new IllegalArgumentException("Id cartão incorreto");
		}
		repository.deleteById(id);
	}

	public Page listarCartaosDoCliente(Long clienteId, Pageable pageable) {
		 Page<Cartao> cartoesPage = repository.findByCliente_Id(clienteId, pageable);	        
	     if(cartoesPage.isEmpty()) {
	    	 throw new IllegalArgumentException("Id incorreto");
	     }
		 return cartoesPage.map(DadosDetalhamentoCartao::new);
	}
}