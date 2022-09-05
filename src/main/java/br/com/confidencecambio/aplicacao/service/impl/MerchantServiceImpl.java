package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.enums.MensagemLogs;
import br.com.confidencecambio.aplicacao.model.Merchant;
import br.com.confidencecambio.aplicacao.repository.MerchantRepository;
import br.com.confidencecambio.aplicacao.service.IMerchantService;
import br.com.confidencecambio.aplicacao.util.ClasseUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class MerchantServiceImpl implements IMerchantService {

    private static String FILTRO = "idStatus";
    private static String START = "service operation has started.";
    private static String LOG_INFO = "method={}, message={}";

    @Autowired
    MerchantRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MerchantDTO> buscarStatusMerchant(){
        log.info(LOG_INFO, ClasseUtil.classeName(), START);
        return MerchantDTO.convert(repository.findAll(Sort.by(Sort.Direction.DESC, FILTRO)));
    }

    public List<MerchantDTO> buscarMerchant() throws Exception {
        log.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "buscarTodosMerchant");
        try {
            return repository.findAll().stream().map(entity -> modelMapper.map(entity, MerchantDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "buscarTodosMerchant", e);
            throw new Exception(e);
        }
    }

    @Override
    public MerchantDTO salvar(MerchantDTO merchantDTO) throws Exception {
        log.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "salvar");

        try {
            Merchant entity = modelMapper.map(merchantDTO, Merchant.class);
            return modelMapper.map(repository.save(entity), MerchantDTO.class);
        } catch (Exception e) {
            log.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "salvar", e);
            throw new Exception(e);
        }
    }

    @Override
    public MerchantDTO atualizar(MerchantDTO merchantDTO) throws Exception {
        log.info(MensagemLogs.SERVICO_INICIADO.getDescricao(), "atualizar");
        try {
            Merchant entity = modelMapper.map(merchantDTO, Merchant.class);
            return modelMapper.map(repository.save(entity), MerchantDTO.class);
        } catch (Exception e) {
            log.error(MensagemLogs.SERVICO_FALHOU.getDescricao(), "atualizar", e);
            throw new Exception(e);
        }
    }

    @Override
    public MerchantDTO buscarMerchantById(Long id) {
        log.info(LOG_INFO, ClasseUtil.classeName(), START);
        Optional<Merchant> idMerchant = repository.findById(id);
        return idMerchant.map(MerchantDTO::convertDto).orElse(null);
    }
}
