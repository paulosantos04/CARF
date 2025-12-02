package com.carf.carfapp.service;

import com.carf.carfapp.model.RegistroAcesso;
import com.carf.carfapp.repository.AlunoRepository;
import com.carf.carfapp.repository.RegistroAcessoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicoAcesso{
    private final AlunoRepository alunoRepository;
    private final RegistroAcessoRepository registroAcessoRepository;

    public ServicoAcesso(AlunoRepository alunoRepository, RegistroAcessoRepository registroAcessoRepository){
        this.alunoRepository = alunoRepository;
        this.registroAcessoRepository = registroAcessoRepository;
    }

    public String registrarAcesso(String nomeAluno){
        var aluno = alunoRepository.finByNome(nomeAluno).orElseThrow(()-> new RuntimeException("Aluno não encontrado"+nomeAluno));

        RegistroAcesso registro = new RegistroAcesso();
        registro.setAluno(aluno);
        registro.setDataHora(LocalDateTime.now());
        registro.setResultado("Acesso Permitido");

        registroAcessoRepository.save(registro);

        return "Acesso liberado para: "+aluno.getNomeAluno();
    }
}