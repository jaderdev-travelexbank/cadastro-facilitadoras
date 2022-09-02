package br.com.confidencecambio.aplicacao.service;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;

import java.util.List;

public interface IMerchantService {

    MerchantDTO salvar(MerchantDTO merchant) throws Exception;

    MerchantDTO atualizar(MerchantDTO merchantDTO) throws Exception;

    List<MerchantDTO> buscarStatusMerchant();

    List<MerchantDTO> buscarMerchant() throws Exception;;

    MerchantDTO buscarMerchantById(Long id);
}
