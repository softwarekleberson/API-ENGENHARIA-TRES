package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
