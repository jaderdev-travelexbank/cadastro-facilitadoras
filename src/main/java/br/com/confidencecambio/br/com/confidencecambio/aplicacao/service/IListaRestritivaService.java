package br.com.confidencecambio.br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.enums.ListaRestritivaStatus;
import org.springframework.context.annotation.Bean;

public interface IListaRestritivaService {
    @Bean
    ListaRestritivaStatus ConsultarListaRestritiva(MerchantDTO merchant);
}
