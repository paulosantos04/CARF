package com.carf.carfapp.controller;

import com.carf.carfapp.service.ServicoAcesso;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private final ServicoAcesso servicoAcesso;

    public AcessoController(ServicoAcesso servicoAcesso) {
        this.servicoAcesso = servicoAcesso;
    }

    // Registrar acesso via POST (ex: envio de CPF + imagem Base64)
    @PostMapping("/registrar")
    public String registrar(@RequestParam String cpf,
                            @RequestParam String imagemBase64) {
        return servicoAcesso.registrarAcesso(cpf, imagemBase64);
    }
}
