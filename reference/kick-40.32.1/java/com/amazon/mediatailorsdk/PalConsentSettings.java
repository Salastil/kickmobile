package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PAL.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/amazon/mediatailorsdk/PalConsentSettings;", "", "builder", "Lcom/amazon/mediatailorsdk/PalConsentSettings$Builder;", "<init>", "(Lcom/amazon/mediatailorsdk/PalConsentSettings$Builder;)V", "allowStorage", "", "getAllowStorage", "()Z", "directedForChildOrUnknownAge", "getDirectedForChildOrUnknownAge", "Builder", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PalConsentSettings {
    private final boolean allowStorage;
    private final boolean directedForChildOrUnknownAge;

    public /* synthetic */ PalConsentSettings(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PalConsentSettings(Builder builder) {
        this.allowStorage = builder.getAllowStorage();
        this.directedForChildOrUnknownAge = builder.getDirectedForChildOrUnknownAge();
    }

    public final boolean getAllowStorage() {
        return this.allowStorage;
    }

    public final boolean getDirectedForChildOrUnknownAge() {
        return this.directedForChildOrUnknownAge;
    }

    /* JADX INFO: compiled from: PAL.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u001e\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/amazon/mediatailorsdk/PalConsentSettings$Builder;", "", "<init>", "()V", "allowStorage", "value", "", "getAllowStorage", "()Z", "directedForChildOrUnknownAge", "getDirectedForChildOrUnknownAge", "build", "Lcom/amazon/mediatailorsdk/PalConsentSettings;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private boolean allowStorage;
        private boolean directedForChildOrUnknownAge;

        public final Builder allowStorage(boolean value) {
            this.allowStorage = value;
            return this;
        }

        public final boolean getAllowStorage() {
            return this.allowStorage;
        }

        public final Builder directedForChildOrUnknownAge(boolean value) {
            this.directedForChildOrUnknownAge = value;
            return this;
        }

        public final boolean getDirectedForChildOrUnknownAge() {
            return this.directedForChildOrUnknownAge;
        }

        public final PalConsentSettings build() {
            return new PalConsentSettings(this, null);
        }
    }
}
