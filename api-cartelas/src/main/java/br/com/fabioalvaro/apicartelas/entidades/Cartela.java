package br.com.fabioalvaro.apicartelas.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cartelas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cartela {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nome;


    
}

