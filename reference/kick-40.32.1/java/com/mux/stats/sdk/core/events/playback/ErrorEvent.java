package com.mux.stats.sdk.core.events.playback;

import com.facebook.hermes.intl.Constants;
import com.mux.stats.sdk.core.model.PlayerData;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class ErrorEvent extends PlaybackEvent {
    public static final String TYPE = "error";

    /* JADX INFO: renamed from: com.mux.stats.sdk.core.events.playback.ErrorEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f243a;

        static {
            int[] iArr = new int[ErrorSeverity.values().length];
            f243a = iArr;
            try {
                iArr[ErrorSeverity.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f243a[ErrorSeverity.ErrorSeverityWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f243a[ErrorSeverity.FATAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f243a[ErrorSeverity.ErrorSeverityFatal.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum ErrorSeverity {
        FATAL,
        WARNING,
        ErrorSeverityFatal,
        ErrorSeverityWarning;

        public static ErrorSeverity fromString(String str) {
            if (str == null) {
                return FATAL;
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == 97203460) {
                lowerCase.equals("fatal");
            } else if (iHashCode == 1124446108 && lowerCase.equals("warning")) {
                return WARNING;
            }
            return FATAL;
        }

        @Override // java.lang.Enum
        public final String toString() {
            int i = AnonymousClass1.f243a[ordinal()];
            return (i == 1 || i == 2) ? "warning" : "fatal";
        }
    }

    public ErrorEvent(PlayerData playerData) {
        super(playerData);
    }

    public ErrorEvent(PlayerData playerData, String str) {
        this(playerData);
        playerData.setPlayerErrorContext(str);
    }

    public ErrorEvent(PlayerData playerData, String str, ErrorSeverity errorSeverity) throws JSONException {
        this(playerData, str);
        playerData.setPlayerErrorSeverity(errorSeverity.toString());
    }

    public ErrorEvent(PlayerData playerData, String str, ErrorSeverity errorSeverity, boolean z) throws JSONException {
        this(playerData, str, errorSeverity);
        playerData.setPlayerErrorBusinessException(z ? "true" : Constants.CASEFIRST_FALSE);
    }

    public String getErrorContext() {
        return this.playerData.getPlayerErrorContext();
    }

    public boolean getIsBusinessException() {
        return this.playerData.getPlayerErrorBusinessException().equalsIgnoreCase("true");
    }

    public ErrorSeverity getSeverity() {
        String playerErrorSeverity = this.playerData.getPlayerErrorSeverity();
        if (playerErrorSeverity == null) {
            return null;
        }
        return ErrorSeverity.fromString(playerErrorSeverity);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return "error";
    }

    public void setIsBusinessException(boolean z) throws JSONException {
        this.playerData.setPlayerErrorBusinessException(z ? "true" : Constants.CASEFIRST_FALSE);
    }

    public void setSeverity(ErrorSeverity errorSeverity) throws JSONException {
        this.playerData.setPlayerErrorSeverity(errorSeverity.toString());
    }
}
