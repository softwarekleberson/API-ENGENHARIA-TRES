package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}