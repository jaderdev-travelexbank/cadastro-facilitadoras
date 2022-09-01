package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.CategoriaDTO;

public interface ICategoriaService {

    CategoriaDTO buscarPorID(Long id) throws  Exception;
}
