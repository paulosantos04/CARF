package com.carf.carfapp.service;

import org.springframework.stereotype.Service;

@Service
public class ServicoReconhecimento {

    public ServicoReconhecimento() {
        // Aqui você poderia inicializar OpenCV, carregar cascades etc.
        System.out.println("✅ Serviço de reconhecimento facial inicializado");
    }

    public boolean compararFaces(String imagemReferencia, String imagemCapturada) {
        // Implementação fictícia para teste
        // Aqui você integra com OpenCV real
        return imagemCapturada.hashCode() % 2 == 0;
    }
}
