package com.fingerprintjs.android.fpjs_pro_internal;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB#\b\u0002\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/getKeepScreenOn;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "", "", "p0", "<init>", "(Ljava/util/List;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class getKeepScreenOn extends wX26196 {

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private getKeepScreenOn(List<? extends Map<String, ? extends Object>> list) {
        super(I30900.setScrollXT29053.INSTANCE.component5(), list, wX26196.setPivotYN16904.component13.INSTANCE);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.getKeepScreenOn$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¨\u0006\t"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LastKnownMockedLocationsInfoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/LastKnownMockedLocationsInfoSignal;", "result", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LastKnownMockedLocationInfo;", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/location/LastKnownMockedLocationsInfoResult;", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component5 = 1;
        private static int component9;

        private Companion() {
        }

        public static getKeepScreenOn vD14832N6715(List<P29109> list) {
            int i = 2 % 2;
            List<P29109> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            int i2 = component5;
            int i3 = ((i2 | 11) << 1) - (i2 ^ 11);
            component9 = i3 % 128;
            int i4 = i3 % 2;
            for (P29109 p29109 : list2) {
                int i5 = component9;
                int i6 = (i5 ^ 11) + ((i5 & 11) << 1);
                component5 = i6 % 128;
                int i7 = i6 % 2;
                arrayList.add(MapsKt.mapOf(TuplesKt.to(I30900.bk.INSTANCE.component5(), p29109.setPivotYN16904()), TuplesKt.to(I30900.cs.INSTANCE.component5(), Long.valueOf(p29109.component5()))));
            }
            return new getKeepScreenOn(arrayList, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        y.setPivotYN16904();
        y.setPivotYN16904();
    }

    public /* synthetic */ getKeepScreenOn(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
