package br.com.confidencecambio.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotNull(message = "Parâmetro descrição obrigatório")
    @NotBlank
    @Size(max = 100, message = "Parâmetro descrição inválido")
    private String descricao;
}
