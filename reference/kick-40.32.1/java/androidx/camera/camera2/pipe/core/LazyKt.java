package androidx.camera.camera2.pipe.core;

import android.os.Trace;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0080\bø\u0001\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0080\bø\u0001\u0000\u001aF\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u0001\"\u0004\b\u0000\u0010\n2\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t0\u0004H\u0080\bø\u0001\u0000\u001a>\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u0001\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t0\u0004H\u0080\bø\u0001\u0000\u001aF\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\f0\u0001\"\u0004\b\u0000\u0010\n2\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\f0\u0004H\u0080\bø\u0001\u0000\u001a<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\f0\u0001\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\f0\u0004H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"lazyOrFalse", "Lkotlin/Lazy;", "", "blockNameFn", "Lkotlin/Function0;", "", "block", "blockName", "lazyOrEmptySet", "", ExifInterface.GPS_DIRECTION_TRUE, "lazyOrEmptyList", "", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyKt {
    public static final Lazy<Boolean> lazyOrFalse(final Function0<String> blockNameFn, final Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(blockNameFn, "blockNameFn");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Boolean>() { // from class: androidx.camera.camera2.pipe.core.LazyKt.lazyOrFalse.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean zBooleanValue;
                String strInvoke = blockNameFn.invoke();
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0<Boolean> function0 = block;
                    try {
                        Trace.beginSection(strInvoke);
                        zBooleanValue = function0.invoke().booleanValue();
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + strInvoke + "! Caching false and ignoring exception.", th);
                    }
                    zBooleanValue = false;
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    public static final <T> Lazy<Set<T>> lazyOrEmptySet(final Function0<String> blockNameFn, final Function0<? extends Set<? extends T>> block) {
        Intrinsics.checkNotNullParameter(blockNameFn, "blockNameFn");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends T>>() { // from class: androidx.camera.camera2.pipe.core.LazyKt.lazyOrEmptySet.1
            @Override // kotlin.jvm.functions.Function0
            public final Set<T> invoke() {
                String strInvoke = blockNameFn.invoke();
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0<Set<T>> function0 = block;
                    try {
                        Trace.beginSection(strInvoke);
                        Set<T> setInvoke = function0.invoke();
                        if (setInvoke == null) {
                            setInvoke = SetsKt.emptySet();
                        }
                        return setInvoke;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + strInvoke + "! Caching {} and ignoring exception.", th);
                    }
                    return SetsKt.emptySet();
                }
            }
        });
    }

    public static final <T> Lazy<List<T>> lazyOrEmptyList(final Function0<String> blockNameFn, final Function0<? extends List<? extends T>> block) {
        Intrinsics.checkNotNullParameter(blockNameFn, "blockNameFn");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<? extends T>>() { // from class: androidx.camera.camera2.pipe.core.LazyKt.lazyOrEmptyList.1
            @Override // kotlin.jvm.functions.Function0
            public final List<T> invoke() {
                String strInvoke = blockNameFn.invoke();
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0<List<T>> function0 = block;
                    try {
                        Trace.beginSection(strInvoke);
                        List<T> listInvoke = function0.invoke();
                        if (listInvoke == null) {
                            listInvoke = CollectionsKt.emptyList();
                        }
                        return listInvoke;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + strInvoke + "! Caching [] and ignoring exception.", th);
                    }
                    return CollectionsKt.emptyList();
                }
            }
        });
    }

    public static final Lazy<Boolean> lazyOrFalse(final String blockName, final Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Boolean>() { // from class: androidx.camera.camera2.pipe.core.LazyKt$lazyOrFalse$$inlined$lazyOrFalse$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean zBooleanValue;
                String str = blockName;
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0 function0 = block;
                    try {
                        Trace.beginSection(str);
                        zBooleanValue = ((Boolean) function0.invoke()).booleanValue();
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching false and ignoring exception.", th);
                    }
                    zBooleanValue = false;
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    public static final <T> Lazy<Set<T>> lazyOrEmptySet(final String blockName, final Function0<? extends Set<? extends T>> block) {
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends T>>() { // from class: androidx.camera.camera2.pipe.core.LazyKt$lazyOrEmptySet$$inlined$lazyOrEmptySet$1
            @Override // kotlin.jvm.functions.Function0
            public final Set<T> invoke() {
                String str = blockName;
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0 function0 = block;
                    try {
                        Trace.beginSection(str);
                        Set<T> setEmptySet = (Set) function0.invoke();
                        if (setEmptySet == null) {
                            setEmptySet = SetsKt.emptySet();
                        }
                        return setEmptySet;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                    }
                    return SetsKt.emptySet();
                }
            }
        });
    }

    public static final <T> Lazy<List<T>> lazyOrEmptyList(final String blockName, final Function0<? extends List<? extends T>> block) {
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Intrinsics.checkNotNullParameter(block, "block");
        return kotlin.LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<? extends T>>() { // from class: androidx.camera.camera2.pipe.core.LazyKt$lazyOrEmptyList$$inlined$lazyOrEmptyList$1
            @Override // kotlin.jvm.functions.Function0
            public final List<T> invoke() {
                String str = blockName;
                try {
                    Debug debug = Debug.INSTANCE;
                    Function0 function0 = block;
                    try {
                        Trace.beginSection(str);
                        List<T> listEmptyList = (List) function0.invoke();
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return listEmptyList;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching [] and ignoring exception.", th);
                    }
                    return CollectionsKt.emptyList();
                }
            }
        });
    }
}
