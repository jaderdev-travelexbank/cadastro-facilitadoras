package br.com.confidencecambio.aplicacao.dto;

import br.com.confidencecambio.aplicacao.model.Merchant;
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
    private Long fk_id_pais_registro;

    @NotNull(message = "Parâmetro URL obrigatório")
    @NotBlank
    @Size(min = 1, max = 100, message = "Parâmetro URL inválido")
    private String url;

    @NotNull(message = "Parâmetro Categoria obrigatório")
    @NotBlank
    private Long fk_id_categoria;
    private Long fk_id_notoriedade;
    private String nif;
    private String telefone;
    private String email;
    @Size(max = 10)
    private  String[] socios;
    private Long fk_id_status;
    private Long fk_id_facilitadora;
    private LocalDate data_hora;
    private String lista_restritiva;

    public static MerchantDTO convertDto(Merchant merchant) {
        return MerchantDTO.builder()
                .id(merchant.getId())
                .nome_fantasia(merchant.getNome_fantasia())
                .nome_registro(merchant.getNome_registro())
                .fk_id_pais_registro(merchant.getFk_id_pais_registro())
                .url(merchant.getUrl())
                .fk_id_categoria(merchant.getFk_id_categoria())
                .fk_id_notoriedade(merchant.getFk_id_notoriedade())
                .nif(merchant.getNif())
                .telefone(merchant.getTelefone())
                .email(merchant.getEmail())
                .socios(new String[]{merchant.getSocios()})
                .fk_id_status(merchant.getFk_id_status())
                .fk_id_facilitadora(merchant.getFk_id_facilitadora())
                .build();
    }

    public static List<MerchantDTO> convert(List<Merchant> lista) {
        return Optional.ofNullable(lista).isPresent() ?
                lista.stream().map(MerchantDTO::convertDto).collect(Collectors.toList()) : null;
    }


}
