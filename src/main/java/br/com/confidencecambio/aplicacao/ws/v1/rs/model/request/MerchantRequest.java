package br.com.confidencecambio.aplicacao.ws.v1.rs.model.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class MerchantRequest {

    @NotNull(message = "Nome Fantasia não pode ser nulo")
    private String nome_fantasia;
    @NotNull(message = "Nome Registro não pode ser nulo")
    private String nome_registro;
    @NotNull(message = "Id País de Registro não pode ser nulo")
    private Long fk_id_pais_registro;
    @NotNull(message = "URL não pode ser nulo")
    private String url;
    @NotNull(message = "Categoria não pode ser nulo")
    private Long fk_id_categoria;
    private Long fk_id_notoriedade;
    private String nif;
    private String telefone;
    private String email;
    private String[] socios;
    private Long fk_id_status;
    @NotNull(message = "Id Facilitadora não pode ser nulo")
    private Long fk_id_facilitadora;
    private LocalDate data_hora;
    private String lista_restritiva;



}
