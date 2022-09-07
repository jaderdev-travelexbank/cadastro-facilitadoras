package br.com.confidencecambio.aplicacao.ws.v1.rs.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class MerchantRequest {

    @NotNull(message = "Nome Fantasia não pode ser nulo")
    private String nomeFantasia;
    @NotNull(message = "Nome Registro não pode ser nulo")
    private String nomeRegistro;
    @NotNull(message = "Id País de Registro não pode ser nulo")
    private Long fk_id_paisRegistro;
    @NotNull(message = "URL não pode ser nulo")
    private String url;
    @NotNull(message = "Categoria não pode ser nulo")
    private Long fk_id_categoria;
    private Long fk_id_notoriedade;
    private String nif;
    private String telefone;
    private String email;
    private String socios;
    private Long fk_id_status;
    @NotNull(message = "Id Facilitadora não pode ser nulo")
    private Long fk_id_facilitadora;
    private LocalDate dataHora;
    private String listaRestritiva;
    private String limite;
    private String grauRisco;
    private String tempoValidadeCadastro;
    private String obs;



}
