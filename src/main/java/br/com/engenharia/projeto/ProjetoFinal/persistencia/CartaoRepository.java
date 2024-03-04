package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

	Page<Cartao> findAllByAtivoTrue(Pageable paginacao);

	Streamable<Cartao> findAllByClienteIdAndAtivoTrue(Long clienteId);

	
}
