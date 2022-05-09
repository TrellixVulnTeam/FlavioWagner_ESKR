package br.com.appnovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appnovo.controller.interfaces.ICustomController;
import br.com.appnovo.dto.AppConfigDTO;
import br.com.appnovo.service.AppConfigService;

@RestController
@RequestMapping("/appconfig")
public class AppConfigController implements ICustomController<AppConfigDTO, Integer>{

	@Autowired
	AppConfigService appConfigService;

	@Override
	public ResponseEntity<List<AppConfigDTO>> Listar() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(appConfigService.Listar());
	}

	@Override
	public ResponseEntity<AppConfigDTO> Item(Integer id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(appConfigService.Item(id));
	}

	@Override
	public ResponseEntity<AppConfigDTO> Inserir(AppConfigDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(appConfigService.Inserir(item));
	}

	@Override
	public ResponseEntity<AppConfigDTO> Atualizar(AppConfigDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(appConfigService.Atualizar(item));
	}

	@Override
	public boolean Deletar(Integer id) {
		// TODO Auto-generated method stub
		return appConfigService.Deletar(id);
	}
	
	

}
