package br.com.confidencecambio.aplicacao.util;

import java.math.BigDecimal;

public class Convert {
    public static BigDecimal strToBigDecimal(String value) {
        return new BigDecimal(value.replaceAll(",", "."));
    }
}
