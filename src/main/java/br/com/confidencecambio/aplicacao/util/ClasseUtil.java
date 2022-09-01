package br.com.confidencecambio.aplicacao.util;

import liquibase.util.file.FilenameUtils;

public class ClasseUtil {

    public static String classeName() {
        Throwable thr = new Throwable();
        thr.fillInStackTrace();
        StackTraceElement[] ste = thr.getStackTrace();
        return FilenameUtils.removeExtension(ste[1].getFileName()) + ":" + ste[1].getMethodName();
    }
}
