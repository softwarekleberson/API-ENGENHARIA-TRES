package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

	Page<Cobranca> findAllByAtivoTrue(Pageable paginacao);
	Streamable<Cobranca> findAllByClienteIdAndAtivoTrue(Long clienteId);

}
