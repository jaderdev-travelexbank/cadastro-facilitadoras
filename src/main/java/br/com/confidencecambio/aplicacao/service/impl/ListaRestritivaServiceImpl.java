package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.enums.ListaRestritivaStatus;
import br.com.confidencecambio.aplicacao.service.IListaRestritivaService;
import org.springframework.stereotype.Service;

@Service
public class ListaRestritivaServiceImpl implements IListaRestritivaService {

    @Override
    public ListaRestritivaStatus ConsultarListaRestritiva(MerchantDTO merchant) {
        return ListaRestritivaStatus.BAIXO; //mock para serviço Lista Restritiva
    }
}
