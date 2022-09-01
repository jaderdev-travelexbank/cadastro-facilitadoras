package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.FacilitadorasDTO;

import java.util.List;

public interface IFacilitadorasService {

    List<FacilitadorasDTO> listarTodas();

    List<FacilitadorasDTO> listarTodasNomeFantasia(String nome);

    List<FacilitadorasDTO> listarTodasNomeRegistro(String nome);
}