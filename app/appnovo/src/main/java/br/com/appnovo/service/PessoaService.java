package br.com.appnovo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appnovo.dto.PessoaDTO;
import br.com.appnovo.model.Pessoa;
import br.com.appnovo.repository.PessoaRepository;
import br.com.appnovo.service.interfaces.ICustomService;

@Service
public class PessoaService implements ICustomService<PessoaDTO, Integer>{

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	public List<PessoaDTO> Listar() {
		try {
			List<PessoaDTO> lista = pessoaRepository.findAll()
					               .stream()
					               .map(x -> new PessoaDTO(x))
					               .collect(Collectors.toList());
			return lista;
		} catch (Exception e) {
			return new ArrayList<PessoaDTO>();
		}			
	}
	
	@Override
	public PessoaDTO Item(Integer id) {
		try {
			return new PessoaDTO( pessoaRepository.findById(id).get() );
			
		} catch (Exception e) {
			return new PessoaDTO(new Pessoa());
		}	
	}
	
	@Override
	public PessoaDTO Inserir(PessoaDTO item) {
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(item.getNome());
			pessoa.setNascimento(item.getNascimento());
			return new PessoaDTO(pessoaRepository.save(pessoa));
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public PessoaDTO Atualizar(PessoaDTO item) {
		Pessoa pessoa = null;
		try {
			pessoa = pessoaRepository.findById(item.getId()).get();
			pessoa.setNome(item.getNome());
			pessoa.setNascimento(item.getNascimento());
			return new PessoaDTO(pessoaRepository.save(pessoa));
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean Deletar(Integer id) {
		try {
			pessoaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
