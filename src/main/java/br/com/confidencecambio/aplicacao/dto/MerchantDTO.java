package br.com.confidencecambio.aplicacao.dto;

import br.com.confidencecambio.aplicacao.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {

    private Long id;

    @NotNull(message = "Parâmetro Nome Fantasia obrigatório")
    @NotBlank
    @Size(min = 1, max = 100, message = "Parâmetro Nome Fantasia inválido")
    private String nome_fantasia;

    @NotNull(message = "Parâmetro Nome Registro obrigatório")
    @NotBlank
    @Size(min = 1, max = 100, message = "Parâmetro Nome Registro inválido")
    private String nome_registro;

    @NotNull(message = "Parâmetro País de Registro obrigatório")
    @NotBlank
    private PaisRegistro paisRegistro;

    @NotNull(message = "Parâmetro URL obrigatório")
    @NotBlank
    @Size(min = 1, max = 100, message = "Parâmetro URL inválido")
    private String url;

    @NotNull(message = "Parâmetro Categoria obrigatório")
    @NotBlank
    private Categoria categoria;
    private Notoriedade notoriedade;
    private String nif;
    private String telefone;
    private String email;
    @Size(max = 10)
    private  String[] socios;
    private Status status;
    private Facilitadoras facilitadoras;
    private LocalDate data_hora;
    private String lista_restritiva;

    public static MerchantDTO convertDto(Merchant merchant) {
        return MerchantDTO.builder()
                .id(merchant.getId())
                .nome_fantasia(merchant.getNome_fantasia())
                .nome_registro(merchant.getNome_registro())
                .paisRegistro(merchant.getPaisRegistroIdPaisRegistro())
                .url(merchant.getUrl())
                .categoria(merchant.getCategoriaIdCategoria())
                .notoriedade(merchant.getNotoriedadeIdNotoriedade())
                .nif(merchant.getNif())
                .telefone(merchant.getTelefone())
                .email(merchant.getEmail())
                .socios(new String[]{merchant.getSocios()})
                .status(merchant.getStatusIdStatus())
                .facilitadoras(merchant.getFacilitadorasIdFacilitadoras())
                .lista_restritiva(merchant.getLista_restritiva())
                .build();
    }

    public static List<MerchantDTO> convert(List<Merchant> lista) {
        return Optional.ofNullable(lista).isPresent() ?
                lista.stream().map(MerchantDTO::convertDto).collect(Collectors.toList()) : null;
    }


}
