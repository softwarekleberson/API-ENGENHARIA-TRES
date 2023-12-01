package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;

public interface IdaoCobranca {

	public String salvar(Cobranca entidade);
	public String alterar(Cobranca entidade, DadosAtualizacaoEndereco dados);
	public List<Cliente> consultar(Cobranca entidade);
	public boolean inativar(Cobranca entidade);
	
}
