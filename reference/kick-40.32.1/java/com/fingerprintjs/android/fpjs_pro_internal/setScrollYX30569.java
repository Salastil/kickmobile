package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\b\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setScrollYX30569;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/util/List;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class setScrollYX30569 extends wX26196 {
    private static int component5 = 0;
    private static int component9 = 1;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private setScrollYX30569(List<String> list, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.xQ31420.INSTANCE.component5(), list, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setScrollYX30569$setPivotYN16904, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042 \u0010\u0005\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000bJ1\u0010\f\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u0004\u0012\u00020\n0\u0006*\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/ThreadsInfoSignal$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/fingerprintjs/android/fpjs_pro/api/fetch_visitor_id_request/signals/ThreadsInfoSignal;", "threadsInfoResult", "Lcom/cloned/github/michaelbull/result/Result;", "", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/threads_info/ThreadsInfo;", "", "Lcom/fingerprintjs/android/fpjs_pro/raw_signal_providers/threads_info/ThreadsInfoResult;", "withReducedInfoSize", "withReducedInfoSize$fpjs_pro_release", "fpjs-pro_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component9 = 1;
        private static int vD14832N6715;

        private Companion() {
        }

        private static D8871<List<String>, Throwable> component9(List<String> list) {
            setPivotYN16904 setpivotyn16904;
            int i = 2 % 2;
            try {
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    List<String> listLines = StringsKt.lines(new Regex(I30900.bj.INSTANCE.component5()).replace((String) it.next(), I30900.bl.INSTANCE.component5()));
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : listLines) {
                        int i2 = vD14832N6715;
                        int i3 = (i2 & 51) + (i2 | 51);
                        component9 = i3 % 128;
                        int i4 = i3 % 2;
                        if (StringsKt.isBlank((String) obj)) {
                            int i5 = component9 + 97;
                            vD14832N6715 = i5 % 128;
                            int i6 = i5 % 2;
                        } else {
                            int i7 = component9;
                            int i8 = (i7 & 111) + (i7 | 111);
                            vD14832N6715 = i8 % 128;
                            int i9 = i8 % 2;
                            arrayList2.add(obj);
                            int i10 = vD14832N6715;
                            int i11 = (i10 ^ 87) + ((i10 & 87) << 1);
                            component9 = i11 % 128;
                            int i12 = i11 % 2;
                        }
                    }
                    arrayList.add(CollectionsKt.joinToString$default(arrayList2, I30900.ce.INSTANCE.component5(), null, null, 0, null, null, 62, null));
                }
                setpivotyn16904 = new vD14832N6715(CollectionsKt.distinct(arrayList));
            } catch (Throwable th) {
                setpivotyn16904 = new setPivotYN16904(th);
            }
            int i13 = component9;
            int i14 = ((i13 | 35) << 1) - (i13 ^ 35);
            vD14832N6715 = i14 % 128;
            if (i14 % 2 != 0) {
                int i15 = 33 / 0;
            }
            return setpivotyn16904;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static setScrollYX30569 component9(D8871<? extends List<String>, ? extends Throwable> d8871) {
            int i = 2 % 2;
            int i2 = component9;
            int i3 = ((i2 | 27) << 1) - (i2 ^ 27);
            int i4 = i3 % 128;
            vD14832N6715 = i4;
            Object obj = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i3 % 2 != 0) {
                boolean z = d8871 instanceof vD14832N6715;
                obj.hashCode();
                throw null;
            }
            if (d8871 instanceof vD14832N6715) {
                int i5 = i4 + 111;
                component9 = i5 % 128;
                int i6 = i5 % 2;
                List list = (List) ((vD14832N6715) d8871).setPivotYN16904;
                Companion companion = setScrollYX30569.INSTANCE;
                d8871 = component9((List<String>) list);
            } else {
                if (!(d8871 instanceof setPivotYN16904)) {
                    throw new NoWhenBranchMatchedException();
                }
                int i7 = ((i2 | 103) << 1) - (i2 ^ 103);
                vD14832N6715 = i7 % 128;
                if (i7 % 2 != 0) {
                    int i8 = 68 / 0;
                }
            }
            if (d8871 instanceof vD14832N6715) {
                setScrollYX30569 setscrollyx30569 = new setScrollYX30569((List) ((vD14832N6715) d8871).setPivotYN16904, wX26196.setPivotYN16904.component13.INSTANCE, objArr3 == true ? 1 : 0);
                int i9 = vD14832N6715;
                int i10 = (i9 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i9 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                component9 = i10 % 128;
                if (i10 % 2 != 0) {
                    return setscrollyx30569;
                }
                throw null;
            }
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            setScrollYX30569 setscrollyx305610 = new setScrollYX30569(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
            int i11 = vD14832N6715 + 97;
            component9 = i11 % 128;
            int i12 = i11 % 2;
            return setscrollyx305610;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component9;
        int i2 = (i & 55) + (i | 55);
        component5 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ setScrollYX30569(List list, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, setpivotyn16904);
    }
}
