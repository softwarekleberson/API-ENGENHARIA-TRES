package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	Page<Entrega> findAllByAtivoTrue(Pageable paginacao);
	Streamable<Entrega> findAllByClienteIdAndAtivoTrue(Long clienteId);

}
