package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import jakarta.transaction.Transactional;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

	Page<Cobranca> findByCliente_Id(Long clienteId, Pageable pageable);

	@Transactional
    @Modifying
    void deleteByCliente_Id(Long clienteId);
}
