package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.StatusDTO;
import br.com.confidencecambio.aplicacao.enums.MensagemLogs;
import br.com.confidencecambio.aplicacao.model.Status;
import br.com.confidencecambio.aplicacao.repository.StatusRepository;
import br.com.confidencecambio.aplicacao.service.IStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StatusServiceImpl implements IStatusService {

    private final Logger logger = LogManager.getLogger(StatusServiceImpl.class);

    @Autowired
    StatusRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public StatusDTO buscarPorID(Long id) throws Exception {
        logger.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "buscarPorID");
        try {
            Optional<Status> optional = Optional.ofNullable(repository.findById(id)).orElse(null);
            return optional.map(status -> modelMapper.map(status, StatusDTO.class)).orElse(null);
        } catch (Exception e) {
            logger.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "buscarPorID", e);
            throw new Exception(e);
        }
    }
}
