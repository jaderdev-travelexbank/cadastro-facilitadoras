package br.com.confidencecambio.aplicacao.ws.v1.rs;

import br.com.confidencecambio.aplicacao.dto.LogDTO;
import br.com.confidencecambio.aplicacao.dto.MerchantDTO;
import br.com.confidencecambio.aplicacao.service.ILogService;
import br.com.confidencecambio.aplicacao.service.IMerchantService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Tag(name = MerchantController.NOME_SERVICO)
@RequestMapping("/v1/merchant")
@RestController
@Slf4j
public class MerchantController {

    static final String NOME_SERVICO = "Merchant";


    @Autowired
    private ILogService logService;

    @Autowired
    private IMerchantService service;

    private void gravarLog(String tipoConsulta, String request, String response) {
        LogDTO logDto = new LogDTO(tipoConsulta, "usuario", "sistema", request, response);
        log.info(logDto.toString());
        logService.salvarLog(logDto);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @Parameters({@Parameter(name = "auth", description = "Token de autorizacao - Parametro obrigatorio", required = true, in = ParameterIn.HEADER)})
    @GetMapping("/todos")
    public ResponseEntity<List<MerchantDTO>> buscarTodos() throws Exception {
        gravarLog(ClasseUtil.classeName(), "", "");
        List<MerchantDTO> MerchantDTO = ofNullable(service.buscarMerchant()).orElseGet(Collections::emptyList);
        if (MerchantDTO.isEmpty()) {
            gravarLog(ClasseUtil.classeName(), "", HttpStatus.NO_CONTENT.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        gravarLog(ClasseUtil.classeName(), "", MerchantDTO.toString());
        return new ResponseEntity<>(MerchantDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @Parameters({@Parameter(name = "auth", description = "Token de autorizacao - Parametro obrigatorio", required = true, in = ParameterIn.HEADER)})
    public ResponseEntity<MerchantDTO> buscarPorId(@NotNull @NotBlank @PathVariable("id") Long id) {
        gravarLog(ClasseUtil.classeName(), id.toString(), "");
        MerchantDTO buscarMerchant = service.buscarMerchantById(id);
        if (isNull(buscarMerchant)) {
            gravarLog(ClasseUtil.classeName(), id.toString(), HttpStatus.NO_CONTENT.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        gravarLog(ClasseUtil.classeName(), id.toString(), buscarMerchant.toString());
        return new ResponseEntity<>(buscarMerchant, HttpStatus.OK);
    }
}
