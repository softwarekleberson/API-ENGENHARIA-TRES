package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import org.springframework.stereotype.Service;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

@Service
public class ValidarConfirmacaoSenha extends ValidacaoAbstrataCliente{

	@Override
	public String processar(Cliente dominio) {
		
		System.out.println("Validar Conformação de senhas");
		if(!dominio.getSenha().matches(dominio.getConfirmar_Senha())) {
			throw new IllegalArgumentException("primeira senha não corresponde a confirmar senha");
		}
		
		 return null;		
	}
}