package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.StatusDTO;

public interface IStatusService {

    StatusDTO buscarPorID(Long id) throws Exception;
}
