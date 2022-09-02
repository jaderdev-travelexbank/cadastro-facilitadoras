package br.com.confidencecambio.aplicacao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sourceforge.jtds.jdbc.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

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

    @NotNull
    @Column(name = "id_pais_registro")
    private Long fk_id_pais_registro;

    @NotNull
    @Column(name = "URL")
    private String url;

    @NotNull
    @Column(name = "id_categoria")
    private Long fk_id_categoria;

    @Column(name = "id_notoriedade")
    private Long fk_id_notoriedade;

    @Column(name = "nif")
    private String nif;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "socios")
    private String socios;

    @Column(name = "id_status")
    private Long fk_id_status;

    @Column(name = "id_facilitadora")
    private Long fk_id_facilitadora;

    @Column(name = "data_hora")
    private DateTime data_hora;
}



