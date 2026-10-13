package io.mobileshield.sdk;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lio/mobileshield/sdk/MobileShieldReadinessListener;", "", "onAwaitingInterrogation", "", "onInitialisationInProgress", "onReady", "onUnreachableServer", "errorCode", "", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MobileShieldReadinessListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int NETWORK_NOT_AVAILABLE = 2;
    public static final int PROTECTION_FAILED = 3;
    public static final int RETRY = 4;
    public static final int TIMED_OUT = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/mobileshield/sdk/MobileShieldReadinessListener$Companion;", "", "()V", "NETWORK_NOT_AVAILABLE", "", "PROTECTION_FAILED", "RETRY", "TIMED_OUT", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int NETWORK_NOT_AVAILABLE = 2;
        public static final int PROTECTION_FAILED = 3;
        public static final int RETRY = 4;
        public static final int TIMED_OUT = 1;

        private Companion() {
        }
    }

    default void onAwaitingInterrogation() {
    }

    void onInitialisationInProgress();

    void onReady();

    void onUnreachableServer(int errorCode);
}
