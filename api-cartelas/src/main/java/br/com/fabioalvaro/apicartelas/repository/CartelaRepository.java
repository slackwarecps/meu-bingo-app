package br.com.fabioalvaro.apicartelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabioalvaro.apicartelas.entidades.Cartela;

public interface CartelaRepository extends JpaRepository<Cartela, Long> {
} 