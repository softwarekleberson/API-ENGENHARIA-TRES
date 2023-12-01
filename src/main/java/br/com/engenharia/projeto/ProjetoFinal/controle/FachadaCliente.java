package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.IdaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.IStrategyCliente;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarCliente;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarConfirmacaoSenha;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarCriptografiaSenha;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarEmail;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarExistencia;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarSenha;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.ValidarTelefone;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

public class FachadaCliente implements IfachadaCliente {

	private ClienteRepository repository;
	
	private Map<String, IdaoCliente> daos;
	private Map<String, List<IStrategyCliente>> rns;

	public FachadaCliente(ClienteRepository repository) {

		this.repository = repository;

		daos = new HashMap<String, IdaoCliente>();
		daos.put(Cliente.class.getName(), new ClienteDao(repository));

		rns = new HashMap<String, List<IStrategyCliente>>();
		ValidarCliente valClinte = new ValidarCliente();
		ValidarCriptografiaSenha valCriptografia = new ValidarCriptografiaSenha();
		ValidarSenha valSenha = new ValidarSenha();
		ValidarTelefone valTelefone = new ValidarTelefone();
		ValidarEmail valEmail = new ValidarEmail();
		ValidarConfirmacaoSenha valConfirmacaoSenha = new ValidarConfirmacaoSenha();
		ValidarExistencia valExistencia = new ValidarExistencia(repository);
		
		List<IStrategyCliente> rnsCliente = new ArrayList<IStrategyCliente>();
		rnsCliente.add(valExistencia);
		rnsCliente.add(valClinte);
		rnsCliente.add(valTelefone);
		rnsCliente.add(valSenha);
		rnsCliente.add(valConfirmacaoSenha);
		rnsCliente.add(valCriptografia);
		rnsCliente.add(valEmail);
		rns.put(Cliente.class.getName(), rnsCliente);
		
	}

	public String salvar(Cliente entidade) {
		String nmClass = entidade.getClass().getName();

		List<IStrategyCliente> rnEntidade = rns.get(nmClass);
		StringBuilder sb = new StringBuilder();
		for (IStrategyCliente s : rnEntidade) {
			String msg = s.processar(entidade);
			if (msg != null) {
				System.out.println(sb.append(msg));
			}
		}
		if (sb.length() > 0) {
			System.out.println("Erros encontrados" + sb.toString());
			return sb.toString();

		} else {
			IdaoCliente dao = daos.get(nmClass);
			System.out.println(dao);
			dao.salvar(entidade);
			return null;
		}

	}

	@Override
	public String alterar(Cliente entidade, DadosAtualizacaoCliente dados) {
		
		IdaoCliente dao = new ClienteDao(repository);
		dao.alterar(entidade, dados);
		return null;
	}

	public List<Cliente> consultar(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public String excluir(Cliente entidade) {
		IdaoCliente dao = new ClienteDao(repository);
		dao.excluir(entidade);
		return null;
	}
}
