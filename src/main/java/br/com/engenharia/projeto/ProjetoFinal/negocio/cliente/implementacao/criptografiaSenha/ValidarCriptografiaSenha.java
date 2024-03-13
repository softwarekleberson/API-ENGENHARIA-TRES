package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.criptografiaSenha;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

@Service
public class ValidarCriptografiaSenha implements IStrategyCriptografaSenha{
		
	public String processar(Cliente dominio) {
			
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		    String senhaCriptografada = passwordEncryptor.encryptPassword(dominio.getSenha());
			dominio.CriptografarSenha(senhaCriptografada);
		    		
	    return null;
	}
}