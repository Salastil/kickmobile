package com.amazon.mediatailorsdk;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.google.ads.interactivemedia.pal.PlatformSignalCollector;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAL.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommon;", "builder", "Lcom/amazon/mediatailorsdk/PalNonceRequestParams$Builder;", "<init>", "(Lcom/amazon/mediatailorsdk/PalNonceRequestParams$Builder;)V", "platformSignalCollector", "Lcom/google/ads/interactivemedia/pal/PlatformSignalCollector;", "getPlatformSignalCollector", "()Lcom/google/ads/interactivemedia/pal/PlatformSignalCollector;", "Builder", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PalNonceRequestParams extends PalNonceRequestParamsCommon {
    private final PlatformSignalCollector platformSignalCollector;

    public /* synthetic */ PalNonceRequestParams(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PalNonceRequestParams(Builder builder) {
        super(builder);
        this.platformSignalCollector = builder.getPlatformSignalCollector();
    }

    public final PlatformSignalCollector getPlatformSignalCollector() {
        return this.platformSignalCollector;
    }

    /* JADX INFO: compiled from: PAL.android.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0016\u0010\u0014\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/amazon/mediatailorsdk/PalNonceRequestParams$Builder;", "Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommonBuilder;", "<init>", "()V", "adWillAutoPlay", "value", "", "adWillPlayMuted", "continuousPlayback", "descriptionUrl", "", "iconsSupported", "nonceLengthLimit", "", "omidPartnerName", "omidPartnerVersion", "playerType", "playerVersion", "ppid", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "supportedApiFrameworks", "", "videoHeight", "videoWidth", "platformSignalCollector", "Lcom/google/ads/interactivemedia/pal/PlatformSignalCollector;", "getPlatformSignalCollector", "()Lcom/google/ads/interactivemedia/pal/PlatformSignalCollector;", "build", "Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder extends PalNonceRequestParamsCommonBuilder {
        private PlatformSignalCollector platformSignalCollector;

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public /* bridge */ /* synthetic */ PalNonceRequestParamsCommonBuilder supportedApiFrameworks(Set set) {
            return supportedApiFrameworks((Set<Integer>) set);
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder adWillAutoPlay(boolean value) {
            super.adWillAutoPlay(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder adWillPlayMuted(boolean value) {
            super.adWillPlayMuted(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder continuousPlayback(boolean value) {
            super.continuousPlayback(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder descriptionUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.descriptionUrl(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder iconsSupported(boolean value) {
            super.iconsSupported(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder nonceLengthLimit(int value) {
            super.nonceLengthLimit(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder omidPartnerName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.omidPartnerName(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder omidPartnerVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.omidPartnerVersion(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder playerType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.playerType(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder playerVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.playerVersion(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder ppid(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.ppid(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder sessionId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.sessionId(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder supportedApiFrameworks(Set<Integer> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super.supportedApiFrameworks(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder videoHeight(int value) {
            super.videoHeight(value);
            return this;
        }

        @Override // com.amazon.mediatailorsdk.PalNonceRequestParamsCommonBuilder
        public Builder videoWidth(int value) {
            super.videoWidth(value);
            return this;
        }

        public final Builder platformSignalCollector(PlatformSignalCollector value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.platformSignalCollector = value;
            return this;
        }

        public final PlatformSignalCollector getPlatformSignalCollector() {
            return this.platformSignalCollector;
        }

        public final PalNonceRequestParams build() {
            return new PalNonceRequestParams(this, null);
        }
    }
}
