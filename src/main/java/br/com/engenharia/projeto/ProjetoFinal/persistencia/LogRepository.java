package br.com.engenharia.projeto.ProjetoFinal.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
