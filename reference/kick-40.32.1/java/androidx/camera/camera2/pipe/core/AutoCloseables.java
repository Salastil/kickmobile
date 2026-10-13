package androidx.camera.camera2.pipe.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: AutoCloseables.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u0005\"\f\b\u0000\u0010\u0006*\u00060\u0007j\u0002`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\fH\u0086\bø\u0001\u0000JQ\u0010\r\u001a\u00020\u0005\"\f\b\u0000\u0010\u0006*\u00060\u0007j\u0002`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2'\u0010\u000b\u001a#\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000Ju\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00140\n\"\f\b\u0000\u0010\u0006*\u00060\u0007j\u0002`\b\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2/\b\u0004\u0010\u000b\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0002\b\u001aH\u0086H¢\u0006\u0002\u0010\u001bJ\u008d\u0001\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00140\n\"\f\b\u0000\u0010\u0006*\u00060\u0007j\u0002`\b\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2D\b\u0004\u0010\u000b\u001a>\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/pipe/core/AutoCloseables;", "", "<init>", "()V", "useEach", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeables", "", "action", "Lkotlin/Function1;", "useEachIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "useEachAsync", "Lkotlinx/coroutines/Deferred;", "R", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useEachIndexedAsync", "Lkotlin/Function4;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoCloseables {
    public static final AutoCloseables INSTANCE = new AutoCloseables();

    private AutoCloseables() {
    }

    public final <T extends AutoCloseable> void useEachIndexed(List<? extends T> closeables, Function2<? super Integer, ? super T, Unit> action) {
        int i;
        Throwable th;
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        Intrinsics.checkNotNullParameter(action, "action");
        int i2 = 0;
        while (i2 < closeables.size()) {
            try {
                T t = closeables.get(i2);
                i = i2 + 1;
                try {
                    action.invoke(Integer.valueOf(i2), t);
                    Unit unit = Unit.INSTANCE;
                    try {
                        AutoCloseableKt.closeFinally(t, null);
                        i2 = i;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            while (i < closeables.size()) {
                                int i3 = i + 1;
                                try {
                                    UByte$$ExternalSyntheticBackport0.m12761m((Object) closeables.get(i));
                                } catch (Throwable th4) {
                                    ExceptionsKt.addSuppressed(th, th4);
                                }
                                i = i3;
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        AutoCloseableKt.closeFinally(t, th5);
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                i = i2;
                th = th7;
            }
        }
        while (i2 < closeables.size()) {
            int i4 = i2 + 1;
            try {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) closeables.get(i2));
            } catch (Throwable unused) {
            }
            i2 = i4;
        }
    }

    public final <T extends AutoCloseable, R> List<Deferred<R>> useEachIndexedAsync(CoroutineScope scope, List<? extends T> closeables, Function4<? super CoroutineScope, ? super Integer, ? super T, ? super Continuation<? super R>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        Intrinsics.checkNotNullParameter(action, "action");
        ArrayList arrayList = new ArrayList(closeables.size());
        int size = closeables.size();
        int i = 0;
        while (i < size) {
            T t = closeables.get(i);
            CoroutineScope coroutineScope = scope;
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AutoCloseables$useEachIndexedAsync$deferred$1(t, action, i, null), 1, null));
            i++;
            scope = coroutineScope;
        }
        return arrayList;
    }

    public final <T extends AutoCloseable> void useEach(List<? extends T> closeables, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        while (i < closeables.size()) {
            try {
                T t = closeables.get(i);
                i++;
                try {
                    action.invoke(t);
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(t, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(t, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    while (i < closeables.size()) {
                        int i2 = i + 1;
                        try {
                            UByte$$ExternalSyntheticBackport0.m12761m((Object) closeables.get(i));
                        } catch (Throwable th5) {
                            ExceptionsKt.addSuppressed(th3, th5);
                        }
                        i = i2;
                    }
                    throw th4;
                }
            }
        }
        while (i < closeables.size()) {
            int i3 = i + 1;
            try {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) closeables.get(i));
            } catch (Throwable unused) {
            }
            i = i3;
        }
    }

    public final <T extends AutoCloseable, R> Object useEachAsync(CoroutineScope coroutineScope, List<? extends T> list, Function3<? super CoroutineScope, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            T t = list.get(i);
            CoroutineScope coroutineScope2 = coroutineScope;
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new AutoCloseables$useEachAsync$$inlined$useEachIndexedAsync$1(t, i, null, function3), 1, null));
            i++;
            coroutineScope = coroutineScope2;
        }
        return arrayList;
    }

    private final <T extends AutoCloseable, R> Object useEachAsync$$forInline(CoroutineScope coroutineScope, List<? extends T> list, Function3<? super CoroutineScope, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            T t = list.get(i);
            CoroutineScope coroutineScope2 = coroutineScope;
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new AutoCloseables$useEachAsync$$inlined$useEachIndexedAsync$1(t, i, null, function3), 1, null));
            i++;
            coroutineScope = coroutineScope2;
        }
        return arrayList;
    }
}
