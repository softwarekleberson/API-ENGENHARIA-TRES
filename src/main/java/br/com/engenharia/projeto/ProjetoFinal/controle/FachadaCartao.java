package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dao.CartaoDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.IdaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Cartao.implementacao.IStrategyCartao;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Cartao.implementacao.ValidarCartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;

public class FachadaCartao implements IfachadaCartao {

	@Autowired
	private CartaoRepository repository;
	
	private Map<String, IdaoCartao> daos;
	private Map<String, List<IStrategyCartao>> rns;

	public FachadaCartao(CartaoRepository repository) {

		this.repository = repository;
		
		daos = new HashMap<String, IdaoCartao>();
		daos.put(Cartao.class.getName(), new CartaoDao(repository));

		rns = new HashMap<String, List<IStrategyCartao>>();
		ValidarCartao valCartao = new ValidarCartao();

		List<IStrategyCartao> rnsCartao = new ArrayList<IStrategyCartao>();
		rnsCartao.add(valCartao);

		rns.put(Cartao.class.getName(), rnsCartao);

	}

	@Override
	public String salvar(Cartao entidade) {
		String nmClass = entidade.getClass().getName();

		List<IStrategyCartao> rnEntidade = rns.get(nmClass);
		StringBuilder sb = new StringBuilder();
		for (IStrategyCartao s : rnEntidade) {
			String msg = s.processar(entidade);
			if (msg != null) {
				System.out.println(sb.append(msg));
			}
		}
		if (sb.length() > 0) {
			System.out.println("Erros encontrados" + sb.toString());
			return sb.toString();

		} else {
			IdaoCartao dao = daos.get(nmClass);
			System.out.println("salvei cartao");
			dao.salvar(entidade);
			return null;
		}

	}
	
	@Override
	public String alterar(Cartao entidade, DadosAtualizacaoCartao dados) {
		IdaoCartao dao = new CartaoDao(repository);
		dao.alterar(entidade, dados);
		return null;
	}

	@Override
	public List<Cliente> consultar(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Cartao entidade) {
		IdaoCartao dao = new CartaoDao(repository);
		dao.inativar(entidade);
		return null;
	}

}
