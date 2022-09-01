package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.PaisRegistroDTO;
import br.com.confidencecambio.aplicacao.enums.MensagemLogs;
import br.com.confidencecambio.aplicacao.model.PaisRegistro;
import br.com.confidencecambio.aplicacao.repository.PaisRegistroRepository;
import br.com.confidencecambio.aplicacao.service.IPaisRegistroService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PaisRegistroServiceImpl implements IPaisRegistroService {

    private final Logger logger = LogManager.getLogger(NotoriedadeServiceImpl.class);

    @Autowired
    PaisRegistroRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PaisRegistroDTO buscarPorID(Long id) throws Exception {
        logger.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "buscarPorID");
        try {
            Optional<PaisRegistro> optional = Optional.ofNullable(repository.findById(id)).orElse(null);
            return optional.map(paisRegistro -> modelMapper.map(paisRegistro, PaisRegistroDTO.class)).orElse(null);
        } catch (Exception e) {
            logger.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "buscarPorID", e);
            throw new Exception(e);
        }
    }

}
