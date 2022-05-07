package br.com.appnovo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appnovo.dto.AppconfigDTO;
import br.com.appnovo.model.Appconfig;
import br.com.appnovo.repository.AppconfigRepository;
import br.com.appnovo.service.interfaces.ICustomService;

@Service
public class AppConfigService implements ICustomService<AppconfigDTO,Integer>{
	@Autowired
	AppconfigRepository appconfigRepository;
	
	@Override
	public List<AppconfigDTO> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppconfigDTO Item(Integer id) {
		try {
			return new AppconfigDTO( appconfigRepository.findById(id).get() );
			
		} catch (Exception e) {
			return new AppconfigDTO(new Appconfig());
		}	
	}

	@Override
	public AppconfigDTO Inserir(AppconfigDTO item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppconfigDTO Atualizar(AppconfigDTO item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Deletar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
