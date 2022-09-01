package br.com.confidencecambio.aplicacao.ws.v1.rs;

import br.com.confidencecambio.aplicacao.dto.FacilitadorasDTO;
import br.com.confidencecambio.aplicacao.dto.LogDTO;
import br.com.confidencecambio.aplicacao.service.IFacilitadorasService;
import br.com.confidencecambio.aplicacao.service.ILogService;
import br.com.confidencecambio.aplicacao.util.ClasseUtil;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

@Tag(name = FacilitadorasController.NOME_SERVICO, description = FacilitadorasController.DESCRICAO_SERVICO)
@RequestMapping("/v1/facilitadoras")
@RestController
@Slf4j
public class FacilitadorasController {

    static final String NOME_SERVICO = "Facilitadoras";
    static final String DESCRICAO_SERVICO = "Controle das facilitadoras";

    @Autowired
    private ILogService logService;

    @Autowired
    private IFacilitadorasService service;

    private void gravarLog(String tipoConsulta, String request, String response) {
        LogDTO logDto = new LogDTO(tipoConsulta, "usuario", "sistema", request, response);
        log.info(logDto.toString());
        logService.salvarLog(logDto);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @Parameters({@Parameter(name = "auth", description = "Token de autorizacao - Parametro obrigatorio",
            required = true, in = ParameterIn.HEADER)})
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilitadorasDTO>> buscarTodos() {
        gravarLog(ClasseUtil.classeName(), "", "");
        List<FacilitadorasDTO> facilitadoras = ofNullable(service.listarTodas()).orElseGet(Collections::emptyList);
        if (facilitadoras.isEmpty()) {
            gravarLog(ClasseUtil.classeName(), "", HttpStatus.NO_CONTENT.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        gravarLog(ClasseUtil.classeName(), "", facilitadoras.toString());
        return new ResponseEntity<>(facilitadoras, HttpStatus.OK);
    }

    @GetMapping("/nomeFantasia/{nomeFantasia}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @Parameters({@Parameter(name = "auth", description = "Token de autorizacao - Parametro obrigatorio", required = true, in = ParameterIn.HEADER)})
    public ResponseEntity<List<FacilitadorasDTO>> buscarPorNomeFantasiaLike(@PathVariable("nomeFantasia") String descricao) {
        gravarLog(ClasseUtil.classeName(), descricao, "");
        List<FacilitadorasDTO> facilitadoras = ofNullable(service.listarTodasNomeFantasia(descricao)).orElseGet(Collections::emptyList);
        if (facilitadoras.isEmpty()) {
            gravarLog(ClasseUtil.classeName(), descricao, HttpStatus.NO_CONTENT.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        gravarLog(ClasseUtil.classeName(), descricao, facilitadoras.toString());
        return new ResponseEntity<>(facilitadoras, HttpStatus.OK);
    }

    @GetMapping("/nomeRegistro/{nomeRegistro}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @Parameters({@Parameter(name = "auth", description = "Token de autorizacao - Parametro obrigatorio", required = true, in = ParameterIn.HEADER)})
    public ResponseEntity<List<FacilitadorasDTO>> buscarNomeRegistroLike(@PathVariable("nomeRegistro") String descricao) {
        gravarLog(ClasseUtil.classeName(), descricao, "");
        List<FacilitadorasDTO> facilitadoras = ofNullable(service.listarTodasNomeRegistro(descricao)).orElseGet(Collections::emptyList);
        if (facilitadoras.isEmpty()) {
            gravarLog(ClasseUtil.classeName(), descricao, HttpStatus.NO_CONTENT.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        gravarLog(ClasseUtil.classeName(), descricao, facilitadoras.toString());
        return new ResponseEntity<>(facilitadoras, HttpStatus.OK);
    }
}