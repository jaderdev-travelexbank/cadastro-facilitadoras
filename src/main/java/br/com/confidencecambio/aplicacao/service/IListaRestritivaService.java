package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.enums.ListaRestritivaStatus;

public interface IListaRestritivaService {

    ListaRestritivaStatus ConsultarListaRestritiva(MerchantDTO merchant);
}
