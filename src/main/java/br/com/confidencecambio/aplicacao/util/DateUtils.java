package br.com.confidencecambio.aplicacao.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DateUtils {

    public static LocalDate converterParaLocalDate(String dataHora, Boolean ignoreMilliseconds) throws Exception{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_TIME_PATTERN);
        if(ignoreMilliseconds)
            return LocalDate.parse(dataHora.substring(0, 19), formatter);
        else
            return LocalDate.parse(dataHora, formatter);
    }
}
