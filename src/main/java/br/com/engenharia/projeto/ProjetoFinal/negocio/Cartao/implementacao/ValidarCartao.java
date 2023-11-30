package br.com.engenharia.projeto.ProjetoFinal.negocio.Cartao.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;

public class ValidarCartao extends ValidacaoAbstrataCartao{

	private static final int NUMERO_CARTAO = 16;
	private static final int CODIGO_SEGURANCA = 3;
	
	public String processar(Cartao dominio) {
								
		if(isNull(dominio.getBandeira())) {
			sb.append("Necessario bandeira");
		}
		
		if(dominio.getCodigo().length() != CODIGO_SEGURANCA) {
			sb.append("Codigo no cartão necessita de 3 digitos");
		}
		
		if(dominio.getNumeroCartao().length() != NUMERO_CARTAO) {
			sb.append("Cartão necessita de 16 digitos");
		}
		
		if(dominio.getNomeImpresso().trim() == null) {
			sb.append("Nome no cartão é necessario");
		}
			
		if(sb.length() != 0) {
			return sb.toString();
		}
		
		return null;
	}

}
