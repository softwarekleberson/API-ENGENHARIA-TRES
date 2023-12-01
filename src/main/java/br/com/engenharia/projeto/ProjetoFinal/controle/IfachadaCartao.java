package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;

public interface IfachadaCartao {

	public String salvar(Cartao entidade);
	public List<Cliente> consultar(Cartao entidade);
	public String excluir(Cartao entidade);
	public String alterar(Cartao entidade, DadosAtualizacaoCartao dados);

}
