package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

public interface IdaoCliente {

	public void salvar(Cliente entidade);
	public void alterarCliente(Long id, DadosAtualizacaoCliente dados);
	void alterarSenha(Long id, String senhaCriptografada);
	public Optional<Cliente> consultar(Cliente entidade);
	public void deletar(Long id);
	Page pegaTodosClientes(Pageable page);
}
