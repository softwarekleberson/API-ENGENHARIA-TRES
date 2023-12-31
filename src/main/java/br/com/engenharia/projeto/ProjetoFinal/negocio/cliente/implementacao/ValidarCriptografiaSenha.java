package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;


import org.jasypt.util.password.StrongPasswordEncryptor;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public class ValidarCriptografiaSenha implements IStrategyCliente{

	public String processar(Cliente dominio) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	    String senhaCriptografada = passwordEncryptor.encryptPassword(dominio.getSenha());
		dominio.CriptografarSenha(senhaCriptografada);
	    
	    return null;
	}

}
