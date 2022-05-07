package br.com.appnovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appnovo.model.Appconfig;

public interface AppconfigRepository extends JpaRepository<Appconfig, Integer> {

}
