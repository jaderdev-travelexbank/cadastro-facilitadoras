package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.NotoriedadeDTO;
import br.com.confidencecambio.aplicacao.enums.MensagemLogs;
import br.com.confidencecambio.aplicacao.model.Notoriedade;
import br.com.confidencecambio.aplicacao.repository.NotoriedadeRepository;
import br.com.confidencecambio.aplicacao.service.INotoriedadeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NotoriedadeServiceImpl implements INotoriedadeService {

    private final Logger logger = LogManager.getLogger(NotoriedadeServiceImpl.class);

    @Autowired
    NotoriedadeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public NotoriedadeDTO buscarPorID(Long id) throws Exception {
        logger.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "buscarPorID");
        try {
            Optional<Notoriedade> optional = Optional.ofNullable(repository.findById(id)).orElse(null);
            return optional.map(notoriedade -> modelMapper.map(notoriedade, NotoriedadeDTO.class)).orElse(null);
        } catch (Exception e) {
            logger.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "buscarPorID", e);
            throw new Exception(e);
        }
    }
}
