package br.com.engenharia.projeto.ProjetoFinal.negocio.Cobranca.implementacao;

public abstract class ValidacaoAbstrataCobranca implements IStrategyCobranca{

	protected StringBuilder sb = new StringBuilder();
	
	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}
}
