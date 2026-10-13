package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.SystemClock;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/gF31878;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "p0", "<init>", "(Ljava/util/List;)V", "vD14832N6715"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class gF31878 extends wX26196 {
    private static int component5 = 1;
    private static int component9;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private gF31878(List<String> list) {
        super(I30900.getContentSensitivity.INSTANCE.component5(), list, wX26196.setPivotYN16904.component13.INSTANCE);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.gF31878$vD14832N6715, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¨\u0006\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SuspiciousFilesSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/SuspiciousFilesSignal;", "result", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/suspicious_files/SuspiciousFiles;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int D8871 = 0;
        private static int component5 = 1;
        public static int setPivotYN16904;
        public static int vD14832N6715;

        private Companion() {
        }

        public static gF31878 component5(List<String> list) {
            int i = 2 % 2;
            gF31878 gf31878 = new gF31878(list, null);
            int i2 = D8871;
            int i3 = (i2 & 61) + (i2 | 61);
            component5 = i3 % 128;
            int i4 = i3 % 2;
            return gf31878;
        }

        public static int setPivotYN16904() {
            int i = setPivotYN16904;
            int i2 = i % 7209294;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return vD14832N6715;
            }
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            vD14832N6715 = iElapsedRealtime;
            return iElapsedRealtime;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component9;
        int i2 = ((i | 73) << 1) - (i ^ 73);
        component5 = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 31 / 0;
        }
    }

    public /* synthetic */ gF31878(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
