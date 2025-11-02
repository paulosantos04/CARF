package com.carf.carfapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String cpf;

    private String nome;

    // Base64 ou caminho da imagem de referência
    @Column(length = 100000)
    private String imagemReferencia;
}
