package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import jakarta.validation.ValidationException;

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
	public List<Cliente> consultar(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Cartao entidade) {
		repository.delete(entidade);
		return false;
	}	
}