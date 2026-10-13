package org.h.s;

import io.mobileshield.sdk.MobileShieldReadinessListener;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h2 implements j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MobileShieldReadinessListener f517a;

    public h2(MobileShieldReadinessListener mobileShieldReadinessListener) {
        Intrinsics.checkNotNullParameter(mobileShieldReadinessListener, "mobileShieldReadinessListener");
        this.f517a = mobileShieldReadinessListener;
    }

    @Override // org.h.s.j4
    public final void a(u3 sdkState) {
        Intrinsics.checkNotNullParameter(sdkState, "sdkState");
        LocalLogger.log(16, 28000L, sdkState.f579a.name());
        switch (sdkState.f579a.ordinal()) {
            case 0:
                this.f517a.onAwaitingInterrogation();
                break;
            case 1:
            case 2:
            case 3:
                LocalLogger.log(16, 28004L, "");
                this.f517a.onInitialisationInProgress();
                break;
            case 4:
            case 5:
            case 7:
            case 8:
                LocalLogger.log(16, 28002L, String.valueOf(sdkState.b));
                this.f517a.onUnreachableServer(sdkState.f579a.f488a);
                break;
            case 6:
                LocalLogger.log(16, 28001L, "");
                this.f517a.onReady();
                break;
        }
    }
}
