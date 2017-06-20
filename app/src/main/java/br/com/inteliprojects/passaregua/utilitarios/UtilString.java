package br.com.inteliprojects.passaregua.utilitarios;

import java.math.BigDecimal;

/**
 * Created by DARUMA02 on 21/02/2017.
 */
public class UtilString {
    private UtilString() {}

    public static String zerosLeft(int valor, int numZerosMax) {
        String strValor = valor + "";
        while(strValor.length() < numZerosMax) {
            strValor = "0" + strValor;
        }

        return strValor;
    }

    public static String formataCasasDecimais(BigDecimal bgDecimal) {
        return String.format("%.2f", bgDecimal);
    }
}
