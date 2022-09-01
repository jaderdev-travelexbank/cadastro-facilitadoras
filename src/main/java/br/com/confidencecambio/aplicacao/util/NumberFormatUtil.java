package br.com.confidencecambio.aplicacao.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberFormatUtil {

    private static Locale locale = new Locale( "pt", "BR" );

    public static String aplicarSeisCasasDecimais(String strValor) throws NumberFormatException {
        DecimalFormat numberFormat = new DecimalFormat( "0.00", new DecimalFormatSymbols(locale));
        numberFormat.setParseBigDecimal(true);
        numberFormat.setDecimalSeparatorAlwaysShown(true);
        numberFormat.setMinimumFractionDigits(6);
        BigDecimal valor = new BigDecimal(strValor);
        return numberFormat.format(valor).replaceAll(",", ".");
    }

    public static String dividirPorNumero(String strValor, BigDecimal numero) throws NumberFormatException {
        BigDecimal valor = new BigDecimal(strValor);
        valor = valor.divide(numero);
        return valor.toString();
    }

    public static String converterBigDecimalParaString(BigDecimal valor, int qtdCasasDecimais) {
        DecimalFormat numberFormat = new DecimalFormat( "0.00", new DecimalFormatSymbols(locale));
        numberFormat.setParseBigDecimal(true);
        numberFormat.setDecimalSeparatorAlwaysShown(true);
        numberFormat.setMinimumFractionDigits(qtdCasasDecimais);
        return numberFormat.format(valor).replaceAll(",", ".");
    }

}