package com.cly.mara.util;

public class CheckSqlInsert {
    public static String TransactSQLInjection(String str)
    {
        return str.replaceAll(".*([';]+|(--)+).*", " ");
    }
}
