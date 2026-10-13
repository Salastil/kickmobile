package com.swmansion.rnscreens.ext;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WeakReferenceExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"refersToCompat", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "referent", "(Ljava/lang/ref/WeakReference;Ljava/lang/Object;)Z", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WeakReferenceExtKt {
    public static final <T> boolean refersToCompat(WeakReference<T> weakReference, T t) {
        Intrinsics.checkNotNullParameter(weakReference, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            return weakReference.refersTo(t);
        }
        T t2 = weakReference.get();
        if (t2 != null) {
            return t2 == t;
        }
        return t == null;
    }
}
