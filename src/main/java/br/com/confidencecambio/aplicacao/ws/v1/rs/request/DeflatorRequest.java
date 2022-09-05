package br.com.confidencecambio.aplicacao.ws.v1.rs.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DeflatorRequest {

    @NotNull(message = "Id da moeda não pode ser nulo")
    private Integer id;

    @NotBlank(message = "Valor sigla moeda não pode estar vazio")
    @NotNull(message = "Valor sigla moeda não pode estar vazio")
    private String sigla_moeda;

    @NotBlank(message = "Valor compra não pode estar vazio")
    @NotNull(message = "Valor compra não pode estar vazio")
    private String compra;

    @NotBlank(message = "Valor venda não pode estar vazio")
    @NotNull(message = "Valor venda não pode estar vazio")
    private String venda;




}
