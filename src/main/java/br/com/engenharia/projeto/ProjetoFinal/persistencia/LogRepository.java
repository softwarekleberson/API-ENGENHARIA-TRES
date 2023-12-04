package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
