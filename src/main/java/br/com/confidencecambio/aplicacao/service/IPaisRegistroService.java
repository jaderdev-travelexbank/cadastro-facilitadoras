package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.PaisRegistroDTO;

public interface IPaisRegistroService {

    PaisRegistroDTO buscarPorID(Long id) throws Exception;
}
