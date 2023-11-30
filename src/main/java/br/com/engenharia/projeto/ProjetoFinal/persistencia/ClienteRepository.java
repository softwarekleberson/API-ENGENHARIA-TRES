package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Page<Cliente> findAllByAtivoTrue(Pageable paginacao);


}
