package com.carf.carfapp.controller;

import com.carf.carfapp.service.ServicoAcesso;
import com.carf.carfapp.service.ServicoReconhecimento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private final ServicoAcesso servicoAcesso;
    private final ServicoReconhecimento servicoReconhecimento;

   public AcessoController(ServicoAcesso servicoAcesso, ServicoReconhecimento servicoReconhecimento){
       this.servicoAcesso = servicoAcesso;
       this.servicoReconhecimento = servicoReconhecimento;
   }

    @PostMapping("/reconhecer")
    public ResponseEntity<?>reconhecer(@RequestParam("imagem") MultipartFile imagem){

       String nomeAluno = servicoReconhecimento.reconhecer(imagem);
        if (!nomeAluno.equals("Não Reconhecido")){
            servicoAcesso.registrarAcesso(nomeAluno);
            return ResponseEntity.ok("Acesso Liberado - "+nomeAluno);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não reconhecido");
    }
}
