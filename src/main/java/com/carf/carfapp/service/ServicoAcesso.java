package com.carf.carfapp.service;

import com.carf.carfapp.model.Aluno;
import com.carf.carfapp.model.RegistroAcesso;
import com.carf.carfapp.repository.AlunoRepository;
import com.carf.carfapp.repository.RegistroAcessoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicoAcesso {

    private final AlunoRepository alunoRepository;
    private final RegistroAcessoRepository registroAcessoRepository;
    private final ServicoReconhecimento servicoReconhecimento;

    public ServicoAcesso(AlunoRepository alunoRepository,
                         RegistroAcessoRepository registroAcessoRepository,
                         ServicoReconhecimento servicoReconhecimento) {
        this.alunoRepository = alunoRepository;
        this.registroAcessoRepository = registroAcessoRepository;
        this.servicoReconhecimento = servicoReconhecimento;
    }

    public Aluno buscarAlunoPorMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com matrícula: " + matricula));
    }

    public String registrarAcesso(String cpf, String imagemCapturada) {
        var aluno = alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não cadastrado com CPF: " + cpf));

        boolean reconhecido = servicoReconhecimento.compararFaces(aluno.getImagemReferencia(), imagemCapturada);

        var registro = new RegistroAcesso();
        registro.setAluno(aluno);
        registro.setDataHora(LocalDateTime.now());
        registro.setResultado(reconhecido ? "Acesso Permitido" : "Acesso Negado");

        registroAcessoRepository.save(registro);

        return registro.getResultado();
    }
}
