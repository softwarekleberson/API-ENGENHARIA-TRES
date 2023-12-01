package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dao.EntregaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.IdaoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Entrega.implementacao.IStrategyEntrega;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Entrega.implementacao.ValidarEnderecoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;

public class FachadaEntrega implements IfachadaEntrega {

	@Autowired
	private EntregaRepository repository;
	
	private Map<String, IdaoEntrega> daos;
	private Map<String, List<IStrategyEntrega>> rns;

	public FachadaEntrega(EntregaRepository repository) {

		this.repository = repository;
		
		daos = new HashMap<String, IdaoEntrega>();
		daos.put(Entrega.class.getName(), new EntregaDao(repository));

		rns = new HashMap<String, List<IStrategyEntrega>>();
		ValidarEnderecoEntrega valEnderecoEntrega = new ValidarEnderecoEntrega();

		List<IStrategyEntrega> rnsEntrega = new ArrayList<IStrategyEntrega>();
		rnsEntrega.add(valEnderecoEntrega);
		rns.put(Entrega.class.getName(), rnsEntrega);

	}

	@Override
	public String salvar(Entrega entidade) {
		String nmClass = entidade.getClass().getName();

		List<IStrategyEntrega> rnEntidade = rns.get(nmClass);
		StringBuilder sb = new StringBuilder();
		for (IStrategyEntrega s : rnEntidade) {
			String msg = s.processar(entidade);
			if (msg != null) {
				System.out.println(sb.append(msg));
			}
		}
		if (sb.length() > 0) {
			System.out.println("Erros encontrados" + sb.toString());
			return sb.toString();

		} else {
			IdaoEntrega dao = daos.get(nmClass);
			System.out.println("salvei Entrega");
			dao.salvar(entidade);
			return null;
		}

	}

	@Override
	public String alterar(Entrega entidade, DadosAtualizacaoEndereco dados) {
		IdaoEntrega dao = new EntregaDao(repository);
		dao.alterar(entidade, dados);
		return null;
	}

	@Override
	public List<Cliente> consultar(Entrega entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Entrega entidade) {
		IdaoEntrega dao = new EntregaDao(repository);
		dao.inativar(entidade);
		return null;
	}

}
