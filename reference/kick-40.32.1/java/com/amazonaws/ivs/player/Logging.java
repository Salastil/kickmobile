package com.amazonaws.ivs.player;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
class Logging {
    static final String TAG = "AmazonIVS";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private static int logLevel = 6;

    private Logging() {
    }

    static void v(String str) {
        if (VERBOSE || logLevel <= 2) {
            Log.v(TAG, str);
        }
    }

    static void v(String str, Throwable th) {
        if (VERBOSE || logLevel <= 2) {
            Log.v(TAG, str, th);
        }
    }

    static void d(String str) {
        if (VERBOSE || logLevel <= 3) {
            Log.d(TAG, str);
        }
    }

    static void d(String str, Throwable th) {
        if (VERBOSE || logLevel <= 3) {
            Log.d(TAG, str, th);
        }
    }

    static void i(String str) {
        if (VERBOSE || logLevel <= 4) {
            Log.i(TAG, str);
        }
    }

    static void i(String str, Throwable th) {
        if (VERBOSE || logLevel <= 4) {
            Log.i(TAG, str, th);
        }
    }

    static void w(String str) {
        if (VERBOSE || logLevel <= 5) {
            Log.w(TAG, str);
        }
    }

    static void w(Throwable th) {
        if (VERBOSE || logLevel <= 5) {
            Log.w(TAG, th);
        }
    }

    static void w(String str, Throwable th) {
        if (VERBOSE || logLevel <= 5) {
            Log.w(TAG, str, th);
        }
    }

    static void e(String str) {
        if (VERBOSE || logLevel <= 6) {
            Log.e(TAG, str);
        }
    }

    static void e(String str, Throwable th) {
        if (VERBOSE || logLevel <= 6) {
            Log.e(TAG, str, th);
        }
    }

    static void setLogLevel(int i) {
        logLevel = i;
    }

    static boolean isVerbose() {
        return VERBOSE;
    }
}
