package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

public abstract class ValidacaoAbstrataCliente implements IStrategyCliente{

	protected StringBuilder sb = new StringBuilder();
	
	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}
}