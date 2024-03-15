package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	Page<Entrega> findByCliente_Id(Long clienteId, Pageable pageable);

}
