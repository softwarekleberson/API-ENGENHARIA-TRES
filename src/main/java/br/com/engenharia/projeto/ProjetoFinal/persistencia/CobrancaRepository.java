package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

	Page<Cobranca> findByCliente_Id(Long clienteId, Pageable pageable);

}
