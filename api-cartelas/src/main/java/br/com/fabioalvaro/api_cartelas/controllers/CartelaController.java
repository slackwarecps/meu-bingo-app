package br.com.fabioalvaro.api_cartelas.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioalvaro.api_cartelas.entidades.Cartela;
import br.com.fabioalvaro.api_cartelas.service.CartelaService;

@RestController
@RequestMapping("/cartela")
public class CartelaController {

    @Autowired
        private CartelaService cartelaService;

    @GetMapping("/health")
    public String health() {
        return "Cartela Health v1.0 30-05-2024 07:38";
    }

   
    @GetMapping("/")
    public ResponseEntity<List<Cartela>> getAllCartelas() {
        List<Cartela> cartelas = cartelaService.getAllCartelas();
        return ResponseEntity.ok(cartelas);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Cartela> getCartelaById(@PathVariable Long id) {
        //Cartela cartela1 = new Cartela( Long.valueOf(1),"Rex");
        Optional<Cartela> cartela = cartelaService.getCartelaById(id);
        return cartela.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartela(@PathVariable Long id) {
        cartelaService.deletarCartela(id);
        return ResponseEntity.noContent().build();
    }
    

}
