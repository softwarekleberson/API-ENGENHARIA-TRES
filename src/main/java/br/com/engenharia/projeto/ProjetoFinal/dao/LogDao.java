package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.LogRepository;

public class LogDao implements IdaoLog {

	@Autowired
	private LogRepository logRepository;
	
	public LogDao(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	@Override
	public String sava(Log entidade) {
		logRepository.save(entidade);
		return null;
	}

	
}
