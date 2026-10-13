package com.amazon.mediatailorsdk;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: SessionConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionFeatures;", "", "builder", "Lcom/amazon/mediatailorsdk/SessionFeatures$Builder;", "<init>", "(Lcom/amazon/mediatailorsdk/SessionFeatures$Builder;)V", "overlayAvails", "", "getOverlayAvails", "()Ljava/lang/String;", "adSignaling", "", "getAdSignaling", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "reportingMode", "getReportingMode", "extra", "", "Lkotlinx/serialization/json/JsonElement;", "getExtra", "()Ljava/util/Map;", "Builder", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionFeatures {
    private final Boolean adSignaling;
    private final Map<String, JsonElement> extra;
    private final String overlayAvails;
    private final String reportingMode;

    public /* synthetic */ SessionFeatures(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SessionFeatures(Builder builder) {
        this.overlayAvails = builder.getOverlayAvails();
        this.adSignaling = builder.getAdSignaling();
        this.reportingMode = builder.getReportingMode();
        this.extra = builder.getExtra();
    }

    public final String getOverlayAvails() {
        return this.overlayAvails;
    }

    public final Boolean getAdSignaling() {
        return this.adSignaling;
    }

    public final String getReportingMode() {
        return this.reportingMode;
    }

    public final Map<String, JsonElement> getExtra() {
        return this.extra;
    }

    /* JADX INFO: compiled from: SessionConfiguration.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fJ\u001a\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0016\u001a\u00020\u0017R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR:\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionFeatures$Builder;", "", "<init>", "()V", "overlayAvails", "value", "", "", "getOverlayAvails", "()Ljava/lang/String;", "adSignaling", "getAdSignaling", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "reportingMode", "Lcom/amazon/mediatailorsdk/SessionReportingMode;", "getReportingMode", "extra", "", "Lkotlinx/serialization/json/JsonElement;", "getExtra", "()Ljava/util/Map;", "build", "Lcom/amazon/mediatailorsdk/SessionFeatures;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private Boolean adSignaling;
        private Map<String, ? extends JsonElement> extra;
        private String overlayAvails;
        private String reportingMode;

        public final Builder overlayAvails(boolean value) {
            this.overlayAvails = value ? null : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            return this;
        }

        public final String getOverlayAvails() {
            return this.overlayAvails;
        }

        public final Builder adSignaling(boolean value) {
            this.adSignaling = Boolean.valueOf(value);
            return this;
        }

        public final Boolean getAdSignaling() {
            return this.adSignaling;
        }

        public final Builder reportingMode(SessionReportingMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.reportingMode = value == SessionReportingMode.SERVER ? value.getModeString() : null;
            return this;
        }

        public final String getReportingMode() {
            return this.reportingMode;
        }

        public final Builder extra(Map<String, ? extends JsonElement> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.extra = value;
            return this;
        }

        public final Map<String, JsonElement> getExtra() {
            return this.extra;
        }

        public final SessionFeatures build() {
            return new SessionFeatures(this, null);
        }
    }
}
