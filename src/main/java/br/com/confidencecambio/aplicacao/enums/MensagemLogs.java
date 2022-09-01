package br.com.confidencecambio.aplicacao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MensagemLogs {

    SERVICO_INICIADO("Metodo: {} , message= Serviço iniciado."),
    SERVICO_FALHOU("Metodo: {} , message= Serviço falhou.");

    private final String descricao;
}
