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
    @Column(name = "nomeFantasia")
    private String nomeFantasia;

    @NotNull
    @Column(name = "nomeRegistro")
    private String nomeRegistro;

    @NotNull
    @JoinColumn(name = "paisRegistro", referencedColumnName = "id")
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

    @Column(name = "socios")
    private String socios;

    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private Status statusIdStatus;


    @JoinColumn(name = "facilitadora", referencedColumnName = "id")
    @ManyToOne
    private Facilitadoras facilitadorasIdFacilitadoras;

    @Column(name = "dataHora")
    private LocalDate dataHora;

    @Column(name = "listaRestritiva")
    private String listaRestritiva;
}



