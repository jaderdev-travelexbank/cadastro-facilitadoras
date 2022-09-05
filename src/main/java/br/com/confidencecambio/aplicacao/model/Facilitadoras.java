package br.com.confidencecambio.aplicacao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facilitadoras", catalog = "facilitadoras.dbo")
public class Facilitadoras implements Serializable {

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
    @Column(name = "ativo")
    private String ativo;

    @NotNull
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

    @Column(name = "usuario")
    private String usuario;

    @NotNull
    @Column(name = "documento")
    private String documento;

    @Override
    public String toString() {
        return "Facilitadoras{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", nomeRegistro='" + nomeRegistro + '\'' +
                ", ativo='" + ativo + '\'' +
                ", dataAlteracao=" + dataAlteracao +
                ", usuario='" + usuario + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facilitadoras that = (Facilitadoras) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeFantasia, that.nomeFantasia) && Objects.equals(nomeRegistro, that.nomeRegistro) && Objects.equals(ativo, that.ativo) && Objects.equals(dataAlteracao, that.dataAlteracao) && Objects.equals(usuario, that.usuario) && Objects.equals(documento, that.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, nomeRegistro, ativo, dataAlteracao, usuario, documento);
    }
}
