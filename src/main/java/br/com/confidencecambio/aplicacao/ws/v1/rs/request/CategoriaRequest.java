package br.com.confidencecambio.aplicacao.ws.v1.rs.request;

import lombok.Builder;

@Builder
public class CategoriaRequest {

    private Integer id;

    public Integer getId()
    {
        return  Integer.valueOf(this.id);
    }

}
