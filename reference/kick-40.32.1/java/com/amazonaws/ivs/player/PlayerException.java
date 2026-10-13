package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public class PlayerException extends RuntimeException {
    private final int code;
    private final ErrorType errorType;
    private final String message;
    private final String source;

    PlayerException(ErrorType errorType, String str) {
        this(null, "Unspecified", errorType, 0, str);
    }

    PlayerException(String str, ErrorType errorType, int i, String str2) {
        this(null, str, errorType, i, str2);
    }

    PlayerException(Throwable th, String str, ErrorType errorType, int i, String str2) {
        super(constructMessage(th, str, errorType, i, str2), th);
        this.source = str == null ? "Unspecified" : str;
        this.errorType = errorType == null ? ErrorType.ERROR : errorType;
        this.code = i;
        this.message = str2 == null ? "" : str2;
    }

    private static String constructMessage(Throwable th, String str, ErrorType errorType, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str != null && !"Unspecified".equals(str)) {
            sb.append(str);
            sb.append(" : ");
        }
        if (errorType != null) {
            sb.append(errorType);
            sb.append(" : ");
        }
        if (i != 0) {
            sb.append(i);
            sb.append(" : ");
        }
        if (str2 != null) {
            sb.append(str2);
        }
        if (th != null) {
            sb.append(" (");
            sb.append(th);
            sb.append(")");
        }
        return sb.toString();
    }

    public int getCode() {
        return this.code;
    }

    public String getSource() {
        return this.source;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
