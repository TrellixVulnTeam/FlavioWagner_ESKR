package br.com.appnovo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appnovo.dto.PessoaFisicaDTO;
import br.com.appnovo.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService extends CustomService<PessoaFisicaRepository, PessoaFisicaDTO, Long> {
	@Autowired
	PessoaFisicaRepository fisicaRepository;

	@Override
	public void LoadData() {
		setRepository(this.fisicaRepository);		
	}

	


}
