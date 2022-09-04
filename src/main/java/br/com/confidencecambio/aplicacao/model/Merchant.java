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
import java.util.Date;

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
    private String nome_fantasia;

    @NotNull
    @Column(name = "nome_registro")
    private String nome_registro;


    //private Long fk_id_pais_registro;
    @NotNull
    @Column(name = "pais_registro")
    private String pais_registro;
    @JoinColumn(name = "fk_id_pais_registro", referencedColumnName = "id")
    @ManyToOne
    private PaisRegistro paisRegistroIdPaisRegistro;


    @NotNull
    @Column(name = "URL")
    private String url;

    @NotNull
    @Column(name = "categoria")
    private Long fk_id_categoria;

    @Column(name = "notoriedade")
    private Long fk_id_notoriedade;

    @Column(name = "nif")
    private String nif;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "socios")
    private String socios;

    @Column(name = "status")
    private Long fk_id_status;

    @Column(name = "facilitadora")
    private Long fk_id_facilitadora;

    @Column(name = "data_hora")
    private LocalDate data_hora;

    @Column(name = "lista_restritiva")
    private String lista_restritiva;
}



