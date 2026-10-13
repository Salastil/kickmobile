package com.datadog.android.internal.system;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: BuildSdkVersionProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "", "isAtLeastBaklava", "", "()Z", "isAtLeastN", "isAtLeastO", "isAtLeastP", "isAtLeastQ", "isAtLeastR", "isAtLeastS", "isAtLeastTiramisu", "isAtLeastVanillaIceCream", "version", "", "getVersion", "()I", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BuildSdkVersionProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    int getVersion();

    /* JADX INFO: renamed from: isAtLeastBaklava */
    boolean getIsAtLeastBaklava();

    /* JADX INFO: renamed from: isAtLeastN */
    boolean getIsAtLeastN();

    /* JADX INFO: renamed from: isAtLeastO */
    boolean getIsAtLeastO();

    /* JADX INFO: renamed from: isAtLeastP */
    boolean getIsAtLeastP();

    /* JADX INFO: renamed from: isAtLeastQ */
    boolean getIsAtLeastQ();

    /* JADX INFO: renamed from: isAtLeastR */
    boolean getIsAtLeastR();

    /* JADX INFO: renamed from: isAtLeastS */
    boolean getIsAtLeastS();

    /* JADX INFO: renamed from: isAtLeastTiramisu */
    boolean getIsAtLeastTiramisu();

    /* JADX INFO: renamed from: isAtLeastVanillaIceCream */
    boolean getIsAtLeastVanillaIceCream();

    /* JADX INFO: compiled from: BuildSdkVersionProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/system/BuildSdkVersionProvider$Companion;", "", "()V", "DEFAULT", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "getDEFAULT", "()Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final BuildSdkVersionProvider DEFAULT = new BuildSdkVersionProvider() { // from class: com.datadog.android.internal.system.BuildSdkVersionProvider$Companion$DEFAULT$1
            private final boolean isAtLeastBaklava;
            private final boolean isAtLeastO;
            private final boolean isAtLeastP;
            private final boolean isAtLeastQ;
            private final boolean isAtLeastR;
            private final boolean isAtLeastS;
            private final boolean isAtLeastTiramisu;
            private final boolean isAtLeastVanillaIceCream;
            private final int version = Build.VERSION.SDK_INT;
            private final boolean isAtLeastN = true;

            {
                this.isAtLeastO = Build.VERSION.SDK_INT >= 26;
                this.isAtLeastP = Build.VERSION.SDK_INT >= 28;
                this.isAtLeastQ = Build.VERSION.SDK_INT >= 29;
                this.isAtLeastR = Build.VERSION.SDK_INT >= 30;
                this.isAtLeastS = Build.VERSION.SDK_INT >= 31;
                this.isAtLeastTiramisu = Build.VERSION.SDK_INT >= 33;
                this.isAtLeastVanillaIceCream = Build.VERSION.SDK_INT >= 35;
                this.isAtLeastBaklava = Build.VERSION.SDK_INT >= 36;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            public int getVersion() {
                return this.version;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastN, reason: from getter */
            public boolean getIsAtLeastN() {
                return this.isAtLeastN;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastO, reason: from getter */
            public boolean getIsAtLeastO() {
                return this.isAtLeastO;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastP, reason: from getter */
            public boolean getIsAtLeastP() {
                return this.isAtLeastP;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastQ, reason: from getter */
            public boolean getIsAtLeastQ() {
                return this.isAtLeastQ;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastR, reason: from getter */
            public boolean getIsAtLeastR() {
                return this.isAtLeastR;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastS, reason: from getter */
            public boolean getIsAtLeastS() {
                return this.isAtLeastS;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastTiramisu, reason: from getter */
            public boolean getIsAtLeastTiramisu() {
                return this.isAtLeastTiramisu;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastVanillaIceCream, reason: from getter */
            public boolean getIsAtLeastVanillaIceCream() {
                return this.isAtLeastVanillaIceCream;
            }

            @Override // com.datadog.android.internal.system.BuildSdkVersionProvider
            /* JADX INFO: renamed from: isAtLeastBaklava, reason: from getter */
            public boolean getIsAtLeastBaklava() {
                return this.isAtLeastBaklava;
            }
        };

        private Companion() {
        }

        public final BuildSdkVersionProvider getDEFAULT() {
            return DEFAULT;
        }
    }
}
