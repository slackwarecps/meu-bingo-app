package br.com.fabioalvaro.api_cartelas.service;

import br.com.fabioalvaro.api_cartelas.entidades.Cartela;
import br.com.fabioalvaro.api_cartelas.repository.CartelaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartelaService {

    @Autowired
    private CartelaRepository cartelaRepository;

    public List<Cartela> getAllCartelas() {
        return cartelaRepository.findAll();
    }

    public Optional<Cartela> getCartelaById(Long id) {
        return cartelaRepository.findById(id);
    }

    public Cartela salvarCartela(Cartela cartela) {
        return cartelaRepository.save(cartela);
    }

    public void deletarCartela(Long id) {
        cartelaRepository.deleteById(id);
    }
}