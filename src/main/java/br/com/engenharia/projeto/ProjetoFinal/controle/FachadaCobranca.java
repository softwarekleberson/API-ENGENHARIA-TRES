package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.dao.CobrancaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.IdaoCobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Cobranca.implementacao.IStrategyCobranca;
import br.com.engenharia.projeto.ProjetoFinal.negocio.Cobranca.implementacao.ValidarEnderecoCobranca;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;

public class FachadaCobranca implements IfachadaCobranca{

	@Autowired
	private CobrancaRepository repository;
	
	private Map<String, IdaoCobranca> daos;
	private Map<String, List<IStrategyCobranca>> rns;

	public FachadaCobranca(CobrancaRepository repository) {

		this.repository = repository;
		
		daos = new HashMap<String, IdaoCobranca>();
		daos.put(Cobranca.class.getName(), new CobrancaDao(repository));

		rns = new HashMap<String, List<IStrategyCobranca>>();
		ValidarEnderecoCobranca valEnderecoCobranca = new ValidarEnderecoCobranca();

		List<IStrategyCobranca> rnsCobranca = new ArrayList<IStrategyCobranca>();
		rnsCobranca.add(valEnderecoCobranca);
		rns.put(Cobranca.class.getName(), rnsCobranca);

	}
		
	@Override
	public String salvar(Cobranca entidade) {
		String nmClass = entidade.getClass().getName();

		List<IStrategyCobranca> rnEntidade = rns.get(nmClass);
		StringBuilder sb = new StringBuilder();
		for (IStrategyCobranca s : rnEntidade) {
			String msg = s.processar(entidade);
			if (msg != null) {
				System.out.println(sb.append(msg));
			}
		}
		
		if (sb.length() > 0) {
			System.out.println("Erros encontrados" + sb.toString());
			return sb.toString();

		} else {
			IdaoCobranca dao = daos.get(nmClass);
			System.out.println("salvei Cobranca");
			dao.salvar(entidade);
			return null;
		}
	}

	@Override
	public String alterar(Cobranca entidade, DadosAtualizacaoEndereco dados) {
		IdaoCobranca dao = new CobrancaDao(repository);
		dao.alterar(entidade, dados);
		return null;
	}

	@Override
	public List<Cliente> consultar(Cobranca entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Cobranca entidade) {
		IdaoCobranca dao = new CobrancaDao(repository);
		dao.inativar(entidade);
		return null;
	}

	
}
