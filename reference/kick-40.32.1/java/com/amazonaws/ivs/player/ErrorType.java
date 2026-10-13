package com.amazonaws.ivs.player;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public enum ErrorType {
    OK(0),
    ERROR(1),
    ERROR_NOT_SUPPORTED(2),
    ERROR_NO_SOURCE(3),
    ERROR_INVALID_DATA(4),
    ERROR_INVALID_STATE(5),
    ERROR_INVALID_PARAMETER(6),
    ERROR_TIMEOUT(7),
    ERROR_NETWORK(8),
    ERROR_NETWORK_IO(9),
    ERROR_AUTHORIZATION(10),
    ERROR_NOT_AVAILABLE(11),
    ERROR_TYPE_UNKNOWN(12);

    private static final Map<Integer, ErrorType> codeToError = new HashMap();
    private final int errorCode;

    static {
        for (ErrorType errorType : values()) {
            codeToError.put(Integer.valueOf(errorType.getErrorCode()), errorType);
        }
    }

    ErrorType(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static ErrorType fromInt(int i) {
        ErrorType errorType = codeToError.get(Integer.valueOf(i));
        return errorType == null ? ERROR_TYPE_UNKNOWN : errorType;
    }
}
