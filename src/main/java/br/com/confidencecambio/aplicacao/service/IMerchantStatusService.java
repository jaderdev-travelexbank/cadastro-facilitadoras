package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.enums.MerchantStatus;
public interface IMerchantStatusService {

    MerchantStatus ConsultarMerchantStatus (MerchantDTO merchant);
}
