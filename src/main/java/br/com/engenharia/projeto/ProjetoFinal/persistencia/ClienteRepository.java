package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
    Optional<Cliente> findByCpf(String itin);
}
