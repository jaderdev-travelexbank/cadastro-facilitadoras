package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.NotoriedadeDTO;

public interface INotoriedadeService {

    NotoriedadeDTO buscarPorID(Long id) throws Exception;
}
