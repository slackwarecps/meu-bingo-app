package br.com.fabioalvaro.apicartelas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabioalvaro.apicartelas.entidades.Cartela;
import br.com.fabioalvaro.apicartelas.repository.CartelaRepository;

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