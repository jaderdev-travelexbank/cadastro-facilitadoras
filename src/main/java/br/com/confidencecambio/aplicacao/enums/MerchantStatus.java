package br.com.confidencecambio.aplicacao.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MerchantStatus {
    APROVACAO ("Em Aprovação"),
    PARAMETRIZACAO ("Aguardando Parametrização"),
    ATIVO ("Ativo"),
    BLOQUEADO ("Bloqueado"),
    REPROVADO ("Reprovado"),
    INATIVO ("Inativo"),
    PEND_ANALISE ("Pend. Análise"),
    PEND_INFORMACAO ("Pend. Informação"),
    PEND_APROVACAO_CONSELHO ("Pend. Aprovação Conselho");

    private final String descricao;

}
