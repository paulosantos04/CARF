package com.carf.carfapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RegistroAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    private LocalDateTime dataHora;

    private String resultado; // "Acesso Permitido" ou "Acesso Negado"

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
