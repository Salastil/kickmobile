package com.datadog.trace.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes6.dex */
public class DDTraceCoreInfo {
    public static final String JAVA_VERSION = System.getProperty("java.version", "unknown");
    public static final String JAVA_VM_NAME = System.getProperty("java.vm.name", "unknown");
    public static final String JAVA_VM_VENDOR = System.getProperty("java.vm.vendor", "unknown");
    public static final String VERSION;

    static {
        String str = "unknown";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(DDTraceCoreInfo.class.getResourceAsStream("/dd-trace-core.version"), "UTF-8"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i == -1) {
                        break;
                    } else {
                        sb.append((char) i);
                    }
                    VERSION = str;
                }
                String strTrim = sb.toString().trim();
                bufferedReader.close();
                str = strTrim;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
        }
        VERSION = str;
    }

    public static void main(String... strArr) {
        System.out.println(VERSION);
    }
}
