package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.FacilitadorasDTO;
import br.com.confidencecambio.aplicacao.repository.FacilitadorasRepository;
import br.com.confidencecambio.aplicacao.service.IFacilitadorasService;
import br.com.confidencecambio.aplicacao.util.ClasseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class FacilitadorasServiceImpl implements IFacilitadorasService {

    private static String FILTRO = "id";
    private static String START = "service operation has started.";
    private static String LOG_INFO = "method={}, message={}";

    @Autowired
    FacilitadorasRepository repository;

    @Override
    public List<FacilitadorasDTO> listarTodas() {
        log.info(LOG_INFO, ClasseUtil.classeName(), START);
        return FacilitadorasDTO.convert(repository.findAll(Sort.by(Sort.Direction.DESC, FILTRO)));
    }

    @Override
    public List<FacilitadorasDTO> listarTodasNomeFantasia(String descricao) {
        log.info(LOG_INFO, ClasseUtil.classeName(), START);
        return FacilitadorasDTO.convert(repository.findByNomeFantasiaContains(descricao));
    }

    @Override
    public List<FacilitadorasDTO> listarTodasNomeRegistro(String descricao) {
        log.info(LOG_INFO, ClasseUtil.classeName(), START);
        return FacilitadorasDTO.convert(repository.findByNomeRegistroContains(descricao));
    }


}