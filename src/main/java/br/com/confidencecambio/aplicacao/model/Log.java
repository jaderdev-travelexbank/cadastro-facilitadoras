package br.com.confidencecambio.aplicacao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "log", catalog = "facilitadoras.dbo")
public class Log implements Serializable {

    @Serial
    private static final long serialVersionUID = -4490721768940704565L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tipo_consulta")
    private String tipoConsulta;

    @NotNull
    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "sistema")
    private String sistema;

    @NotNull
    @Column(name = "request")
    private String request;

    @NotNull
    @Column(name = "response")
    private String response;


}
