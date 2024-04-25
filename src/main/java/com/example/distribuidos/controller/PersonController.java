package com.example.distribuidos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping()
public class PersonController {

    @GetMapping()    
    public ResponseEntity<String> person() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String message = "Hola desde: " + localHost.getHostName();

            // Crear una cabecera con la opción "Connection: keep-alive"
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONNECTION, "keep-alive");

            // Devolver la respuesta con la cabecera
            return ResponseEntity.ok().headers(headers).body(message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al obtener el nombre de la máquina");
        }
    }
    
}
