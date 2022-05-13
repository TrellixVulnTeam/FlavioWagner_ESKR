package br.com.appnovo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appnovo.dto.AppConfigDTO;
import br.com.appnovo.model.Appconfig;
import br.com.appnovo.repository.AppconfigRepository;
import br.com.appnovo.service.interfaces.ICustomService;

@Service
public class AppConfigService implements ICustomService<AppConfigDTO,Integer>{
	@Autowired
	AppconfigRepository appconfigRepository;
	
	@Override
	public List<AppConfigDTO> Listar() {
		try {
			List<AppConfigDTO> lista = appconfigRepository.findAll()
					               .stream()
					               .map(x -> new AppConfigDTO(x))
					               .collect(Collectors.toList());
			return lista;
		} catch (Exception e) {
			return new ArrayList<AppConfigDTO>();
		}	
	}

	@Override
	public AppConfigDTO Item(Integer id) {
		try {
			return new AppConfigDTO( appconfigRepository.findById(id).get() );
			
		} catch (Exception e) {
			return new AppConfigDTO(new Appconfig());
		}	
	}

	@Override
	public AppConfigDTO Inserir(AppConfigDTO item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppConfigDTO Atualizar(AppConfigDTO item) {
		Appconfig config = appconfigRepository.findById(item.getId()).get();
		config.setTheme(item.getTheme());
		config.setInputStyle(item.getInputStyle());
		config.setDark(item.isDark());
		config.setRipple(item.isRipple());
		return new AppConfigDTO( appconfigRepository.save(config));
	}

	@Override
	public boolean Deletar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
