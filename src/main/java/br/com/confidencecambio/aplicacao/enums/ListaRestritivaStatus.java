package br.com.confidencecambio.aplicacao.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ListaRestritivaStatus {

    ALTO ("ALTO"),
    MEDIO ("MEDIO"),
    BAIXO ("BAIXO");

    private final String descricao;
}
