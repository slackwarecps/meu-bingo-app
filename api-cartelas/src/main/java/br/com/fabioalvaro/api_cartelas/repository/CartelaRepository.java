package br.com.fabioalvaro.api_cartelas.repository;

import br.com.fabioalvaro.api_cartelas.entidades.Cartela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartelaRepository extends JpaRepository<Cartela, Long> {
} 