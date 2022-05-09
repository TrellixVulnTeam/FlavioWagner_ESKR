package br.com.appnovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appnovo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
