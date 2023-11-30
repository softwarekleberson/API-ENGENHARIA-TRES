package br.com.engenharia.projeto.ProjetoFinal.negocio.Entrega.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;

public class ValidarEnderecoEntrega extends ValidacaoAbstrataEntrega {

	@Override
	public String processar(Entrega dominio) {
		
		if (isNull(dominio.getBairro())) {
			sb.append("Bairro não pode ser nulo");
		}
		
		if (dominio.getCep().length() != 8) {
			sb.append("Cep deve conter 8 digitos");
		}
		
		if (isNull(dominio.getCidade())) {
			sb.append("Cidade não deve ser nulo");
		}
		
		if (isNull(dominio.getLogradouro())) {
			sb.append("Lograduto não deve ser nulo");
		}
		
		if (isNull(dominio.getNumero())) {
			sb.append("Numero não deve ser nulo");
		}
		
		if (isNull(dominio.getTipoResidencia())) {
			sb.append("Tipo Residencia não deve ser nulo");
		}
		
		if (isNull(dominio.getTipoLogradouro())) {
			sb.append("Tipo Logradouto não deve ser nulo");
		}
		
		if (isNull(dominio.getCidade().getEstado())) {
			sb.append("Estado não deve ser nulo");
		}
		
		if (isNull(dominio.getCidade().getEstado().getPais())) {
			sb.append("Pais não deve ser nulo");
		}

		if(sb.length()!=0){
			return sb.toString();
		}
		return null;
	}
}
