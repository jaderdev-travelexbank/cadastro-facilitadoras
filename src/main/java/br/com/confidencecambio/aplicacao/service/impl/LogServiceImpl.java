package br.com.confidencecambio.aplicacao.service.impl;

import br.com.confidencecambio.aplicacao.dto.LogDTO;
import br.com.confidencecambio.aplicacao.model.Log;
import br.com.confidencecambio.aplicacao.repository.LogRepository;
import br.com.confidencecambio.aplicacao.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class LogServiceImpl implements ILogService {

    @Autowired
    LogRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void salvarLog(LogDTO logDto) {
        repository.save(modelMapper.map(logDto, Log.class));
    }
}
