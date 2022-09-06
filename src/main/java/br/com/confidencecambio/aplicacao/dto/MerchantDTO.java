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
    private String nomeFantasia;

    @NotNull(message = "Parâmetro Nome Registro obrigatório")
    @NotBlank
    @Size(min = 1, max = 100, message = "Parâmetro Nome Registro inválido")
    private String nomeRegistro;

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
    private LocalDate dataHora;
    private String listaRestritiva;
    private String limite;
    private String grauRisco;
    private String tempoValidadeCadastro;
    private String obs;

    public static MerchantDTO convertDto(Merchant merchant) {
        return MerchantDTO.builder()
                .id(merchant.getId())
                .nomeFantasia(merchant.getNomeFantasia())
                .nomeRegistro(merchant.getNomeRegistro())
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
                .listaRestritiva(merchant.getListaRestritiva())
                .dataHora(merchant.getDataHora())
                .limite(merchant.getLimite())
                .grauRisco(merchant.getGrauRisco())
                .tempoValidadeCadastro(merchant.getTempoValidadeCadastro())
                .obs(merchant.getObs())
                .build();
    }

    public static List<MerchantDTO> convert(List<Merchant> lista) {
        return Optional.ofNullable(lista).isPresent() ?
                lista.stream().map(MerchantDTO::convertDto).collect(Collectors.toList()) : null;
    }


}
