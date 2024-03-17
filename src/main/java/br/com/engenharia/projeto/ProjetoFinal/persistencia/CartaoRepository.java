package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.util.Streamable;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;
import jakarta.transaction.Transactional;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

	Page<Cartao> findAllByAtivoTrue(Pageable paginacao);

	Streamable<Cartao> findAllByClienteIdAndAtivoTrue(Long clienteId);

    Page<Cartao> findByCliente_Id(Long clienteId, Pageable pageable);

    @Transactional
    @Modifying
    void deleteByCliente_Id(Long clienteId);
}
