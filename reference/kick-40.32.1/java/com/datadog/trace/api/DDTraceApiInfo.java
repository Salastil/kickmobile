package com.datadog.trace.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes6.dex */
public class DDTraceApiInfo {
    public static final String VERSION;

    static {
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(DDTraceApiInfo.class.getResourceAsStream("/dd-trace-api.version"), "UTF-8"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i == -1) {
                        break;
                    } else {
                        sb.append((char) i);
                    }
                    strTrim = "unknown";
                    VERSION = strTrim;
                }
                strTrim = sb.toString().trim();
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            strTrim = "unknown";
        }
        VERSION = strTrim;
    }
}
