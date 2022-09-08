package br.com.confidencecambio.aplicacao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant", catalog = "facilitadoras.dbo")
public class Merchant implements Serializable {

    @Serial
    private static final long serialVersionUID = -4490721768940704565L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @NotNull
    @Column(name = "nome_registro")
    private String nomeRegistro;

    @NotNull
    @JoinColumn(name = "pais_registro", referencedColumnName = "id")
    @ManyToOne
    private PaisRegistro paisRegistroIdPaisRegistro;


    @NotNull
    @Column(name = "URL")
    private String url;

    @NotNull
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoriaIdCategoria;

    @JoinColumn(name = "notoriedade", referencedColumnName = "id")
    @ManyToOne
    private Notoriedade notoriedadeIdNotoriedade;

    @Column(name = "nif")
    private String nif;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "merchant_id")
    private Set<Socio> sociosIdSocios;

    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private Status statusIdStatus;


    @JoinColumn(name = "facilitadora", referencedColumnName = "id")
    @ManyToOne
    private Facilitadoras facilitadorasIdFacilitadoras;

    @Column(name = "data_hora")
    private LocalDate dataHora;

    @Column(name = "lista_restritiva")
    private String listaRestritiva;

    @Column(name = "limite")
    private String limite;

    @Column(name = "grau_risco")
    private String grauRisco;

    @Column(name = "tempo_validade_cadastro")
    private String tempoValidadeCadastro;

    @Column(name = "obs")
    private String obs;
}



