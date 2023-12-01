package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;

public interface IfachadaEntrega {

	public String salvar(Entrega entidade);
	public String alterar(Entrega entidade, DadosAtualizacaoEndereco dados);
	public List<Cliente> consultar(Entrega entidade);
	public String excluir(Entrega entidade);
}
