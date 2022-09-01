package br.com.confidencecambio.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class LogDTO implements Serializable {

    private Long id;
    private String tipoConsulta;
    private LocalDateTime dataConsulta;
    private String usuario;
    private String sistema;
    private String request;
    private String response;

    public LogDTO(String tipoConsulta, String usuario, String sistema, String request, String response) {
        this.tipoConsulta = tipoConsulta;
        this.usuario = usuario;
        this.sistema = sistema;
        this.request = request;
        this.response = response;
        this.dataConsulta = LocalDateTime.now();
    }
}
