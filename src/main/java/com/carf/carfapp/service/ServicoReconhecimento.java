package com.carf.carfapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServicoReconhecimento{

    public ServicoReconhecimento(){
        System.out.println("Serviço de Reconhecimento Facial Iniciado");
    }

    public String reconhecer(MultipartFile imagem){
        try {
            if (imagem.getSize()%2 == 0){
                return "Paulo Santos";
            }
            return "Não Reconhecido";
        } catch (Exception e){
            return "Erro ao processar:"+e.getMessage();
        }
    }
}