package androidx.core.backported.fixes;

import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackportedFixManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/core/backported/fixes/BackportedFixManager;", "", "resolver", "Landroidx/core/backported/fixes/StatusResolver;", "<init>", "(Landroidx/core/backported/fixes/StatusResolver;)V", "()V", "isFixed", "", "ki", "Landroidx/core/backported/fixes/KnownIssue;", "getStatus", "Landroidx/core/backported/fixes/Status;", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackportedFixManager {
    private final StatusResolver resolver;

    /* JADX INFO: compiled from: BackportedFixManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.Fixed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.NotApplicable.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.NotFixed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BackportedFixManager(StatusResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.resolver = resolver;
    }

    public BackportedFixManager() {
        this(new SystemPropertyResolver());
    }

    public final boolean isFixed(KnownIssue ki) {
        Intrinsics.checkNotNullParameter(ki, "ki");
        int i = WhenMappings.$EnumSwitchMapping$0[getStatus(ki).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Status getStatus(KnownIssue ki) {
        Intrinsics.checkNotNullParameter(ki, "ki");
        if (ki.getPrecondition$core_backported_fixes().invoke().booleanValue()) {
            if (ki.getManuallyTestedFingerprints$core_backported_fixes().contains(Build.FINGERPRINT)) {
                return Status.Fixed;
            }
            return this.resolver.getStatus(ki);
        }
        return Status.NotApplicable;
    }
}
