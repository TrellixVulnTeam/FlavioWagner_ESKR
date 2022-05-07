package br.com.appnovo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appnovo.dto.AppconfigDTO;
import br.com.appnovo.service.AppConfigService;

@RestController
@RequestMapping("/appconfig")
public class AppConfigController extends CustomClassController<AppConfigService, AppconfigDTO, Integer> {

	@Autowired
	AppConfigService appConfigService;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	protected void LoadData() {
		setService(this.appConfigService);
		setMapper(this.mapper); 
	}

}
