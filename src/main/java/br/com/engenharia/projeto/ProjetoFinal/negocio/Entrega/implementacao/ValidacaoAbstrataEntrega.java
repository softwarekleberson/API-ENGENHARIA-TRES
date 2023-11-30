package br.com.engenharia.projeto.ProjetoFinal.negocio.Entrega.implementacao;

public abstract class ValidacaoAbstrataEntrega implements IStrategyEntrega{

	protected StringBuilder sb = new StringBuilder();
	
	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}
}
