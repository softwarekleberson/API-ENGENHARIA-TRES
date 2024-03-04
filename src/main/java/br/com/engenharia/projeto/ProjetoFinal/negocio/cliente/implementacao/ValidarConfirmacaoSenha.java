package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import org.springframework.stereotype.Service;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.infra.TratadorErros.ValidacaoExcepetion;

@Service
public class ValidarConfirmacaoSenha extends ValidacaoAbstrataCliente{

	@Override
	public String processar(Cliente dominio) throws ValidacaoExcepetion {
		
		if(!dominio.getSenha().matches(dominio.getConfirmar_Senha())) {
			throw new ValidacaoExcepetion("senha não bate com confirmar senha");
		}
		
		 return null;		
	}
}