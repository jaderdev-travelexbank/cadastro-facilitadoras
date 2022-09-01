package br.com.confidencecambio.aplicacao.dto;

import br.com.confidencecambio.aplicacao.model.Facilitadoras;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacilitadorasDTO {

    private Long id;
    private String nome_fantasia;
    private String nome_registro;
    private String ativo;
    private String data_alteracao;
    private String usuario;
    private String documento;

    public static FacilitadorasDTO convertDto(Facilitadoras facilitadoras) {
        return FacilitadorasDTO.builder()
                .id(facilitadoras.getId())
                .nome_fantasia(facilitadoras.getNomeFantasia())
                .nome_registro(facilitadoras.getNomeRegistro())
                .ativo(facilitadoras.getAtivo())
                .data_alteracao(facilitadoras.getDataAlteracao().format(DateTimeFormatter.ISO_DATE_TIME))
                .usuario(facilitadoras.getUsuario())
                .documento(facilitadoras.getDocumento())
                .build();
    }

    public static List<FacilitadorasDTO> convert(List<Facilitadoras> lista) {
        return Optional.ofNullable(lista).isPresent() ?
                lista.stream().map(FacilitadorasDTO::convertDto).collect(Collectors.toList()) : null;
    }
}
