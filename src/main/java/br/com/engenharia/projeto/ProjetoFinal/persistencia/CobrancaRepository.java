package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

}
