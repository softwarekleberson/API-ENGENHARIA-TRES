package br.com.engenharia.projeto.ProjetoFinal.negocio.Cartao.implementacao;

public abstract class ValidacaoAbstrataCartao implements IStrategyCartao{

	protected StringBuilder sb = new StringBuilder();
	
	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}
}
