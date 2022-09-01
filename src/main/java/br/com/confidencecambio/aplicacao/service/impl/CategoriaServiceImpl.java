package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.CategoriaDTO;
import br.com.confidencecambio.aplicacao.enums.MensagemLogs;
import br.com.confidencecambio.aplicacao.model.Categoria;
import br.com.confidencecambio.aplicacao.repository.CategoriaRepository;
import br.com.confidencecambio.aplicacao.service.ICategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CategoriaServiceImpl implements ICategoriaService {

    private final Logger logger = LogManager.getLogger(CategoriaServiceImpl.class);

    @Autowired
    CategoriaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaDTO buscarPorID(Long id) throws Exception {
        logger.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "buscarPorID");
        try {
            Optional<Categoria> optional = Optional.ofNullable(repository.findById(id)).orElse(null);
            return optional.map(categoria -> modelMapper.map(categoria, CategoriaDTO.class)).orElse(null);
        } catch (Exception e) {
            logger.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "buscarPorID", e);
            throw new Exception(e);
        }
    }
}
