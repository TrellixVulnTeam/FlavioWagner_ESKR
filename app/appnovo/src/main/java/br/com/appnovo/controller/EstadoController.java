package br.com.appnovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appnovo.controller.interfaces.ICustomController;
import br.com.appnovo.dto.EstadoDTO;
import br.com.appnovo.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController implements ICustomController<EstadoDTO, Integer>{

	@Autowired
	EstadoService estadoService;

	@Override
	public ResponseEntity<List<EstadoDTO>> Listar() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(estadoService.Listar());
	}

	@Override
	public ResponseEntity<EstadoDTO> Item(Integer id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(estadoService.Item(id));
	}

	@Override
	public ResponseEntity<EstadoDTO> Inserir(EstadoDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(estadoService.Inserir(item));
	}

	@Override
	public ResponseEntity<EstadoDTO> Atualizar(EstadoDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(estadoService.Atualizar(item));
	}

	@Override
	public boolean Deletar(Integer id) {
		// TODO Auto-generated method stub
		return estadoService.Deletar(id);
	}
	
	@RequestMapping("/sigla/{uf}")
	public ResponseEntity<EstadoDTO>  Item(@PathVariable(value="uf") String uf) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(estadoService.Item(uf));
	}	
}
