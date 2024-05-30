package br.com.fabioalvaro.apicartelas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fabioalvaro.apicartelas.entidades.Cartela;
import br.com.fabioalvaro.apicartelas.service.CartelaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/cartela", produces = { "application/json" })
@Tag(name = "Cartela", description = "Endpoints para gerenciamento de cartelas")
public class CartelaController {

    @Autowired
    private CartelaService cartelaService;

    @Operation(summary = "Verifica o status de saúde da aplicação", description = "Retorna uma string indicando que a aplicação está saudável.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aplicação está saudável")
    })
    @GetMapping("/health")
    public String health() {
        return "Cartela Health v1.0 30-05-2024 07:38";
    }

    @Operation(summary = "Retorna todas as cartelas", description = "Este endpoint retorna uma lista de todas as cartelas disponíveis.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cartelas retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/")
    public ResponseEntity<List<Cartela>> getAllCartelas() {
        List<Cartela> cartelas = cartelaService.getAllCartelas();
        return ResponseEntity.ok(cartelas);
    }

    @Operation(summary = "Obter Cartela por ID", description = "Retorna uma cartela específica pelo seu ID", tags = {"Cartela"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cartela encontrada", content = @Content(schema = @Schema(implementation = Cartela.class))),
        @ApiResponse(responseCode = "404", description = "Cartela não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cartela> getCartelaById(@PathVariable Long id) {
        Optional<Cartela> cartela = cartelaService.getCartelaById(id);
        return cartela.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta uma cartela", description = "Deleta uma cartela pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cartela deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cartela não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartela(@PathVariable Long id) {
        cartelaService.deletarCartela(id);
        return ResponseEntity.noContent().build();
    }

}
