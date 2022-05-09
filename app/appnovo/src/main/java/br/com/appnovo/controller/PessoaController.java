package br.com.appnovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appnovo.controller.interfaces.ICustomController;
import br.com.appnovo.dto.PessoaDTO;
import br.com.appnovo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController implements ICustomController<PessoaDTO, Integer> {

	@Autowired
	PessoaService pessoaService;
	
	@Override
	public ResponseEntity<List<PessoaDTO>> Listar() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(pessoaService.Listar());
	}

	@Override
	public ResponseEntity<PessoaDTO> Item(Integer id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(pessoaService.Item(id));
	}

	@Override
	public ResponseEntity<PessoaDTO> Inserir(PessoaDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(pessoaService.Inserir(item));
	}

	@Override
	public ResponseEntity<PessoaDTO> Atualizar(PessoaDTO item) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(pessoaService.Atualizar(item));
	}

	@Override
	public boolean Deletar(Integer id) {
		// TODO Auto-generated method stub
		return pessoaService.Deletar(id);
	}

}
