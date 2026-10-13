package androidx.camera.viewfinder.core.impl;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Typography;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RefCounted.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0014B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/viewfinder/core/impl/RefCounted;", ExifInterface.GPS_DIRECTION_TRUE, "", "debugRefCounts", "", "onRelease", "Lkotlin/Function1;", "", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "refCounted", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlin/Pair;", "", "initialize", "newValue", "(Ljava/lang/Object;)V", "acquire", "()Ljava/lang/Object;", "release", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RefCounted<T> {
    private static final String TAG = "RefCounted";
    private final boolean debugRefCounts;
    private final Function1<T, Unit> onRelease;
    private final AtomicRef<Pair<T, Integer>> refCounted;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pair<Unit, Integer> UNINITIALIZED = new Pair<>(Unit.INSTANCE, -1);
    private static final Pair<Unit, Integer> RELEASED = new Pair<>(Unit.INSTANCE, 0);

    /* JADX WARN: Multi-variable type inference failed */
    public RefCounted(boolean z, Function1<? super T, Unit> onRelease) {
        Intrinsics.checkNotNullParameter(onRelease, "onRelease");
        this.debugRefCounts = z;
        this.onRelease = onRelease;
        this.refCounted = AtomicFU.atomic(INSTANCE.uninitialized());
    }

    public /* synthetic */ RefCounted(boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, function1);
    }

    public final void initialize(T newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (!this.refCounted.compareAndSet(INSTANCE.uninitialized(), new Pair<>(newValue, 1))) {
            throw new IllegalStateException("Ref-count managed object has already been initialized.".toString());
        }
        if (this.debugRefCounts) {
            StringBuilder sb = new StringBuilder("RefCounted@");
            String str = String.format("%x", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            sb.append(str);
            sb.append(Typography.less);
            sb.append(Reflection.getOrCreateKotlinClass(newValue.getClass()).getSimpleName());
            sb.append("> initialized: [refCount: 1, value: ");
            sb.append(newValue);
            sb.append(AbstractJsonLexerKt.END_LIST);
            Log.d(TAG, sb.toString(), new Throwable());
        }
    }

    public final T acquire() {
        Pair<T, Integer> value;
        T tComponent1;
        int iIntValue;
        if (Intrinsics.areEqual(this.refCounted.getValue(), INSTANCE.uninitialized())) {
            throw new IllegalStateException("Ref-count managed object has not yet been initialized. Unable to acquire.".toString());
        }
        AtomicRef<Pair<T, Integer>> atomicRef = this.refCounted;
        do {
            value = atomicRef.getValue();
            if (Intrinsics.areEqual(value, INSTANCE.released())) {
                if (!this.debugRefCounts) {
                    return null;
                }
                StringBuilder sb = new StringBuilder("RefCounted@");
                String str = String.format("%x", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
                sb.append(".acquire() failure: [refCount: 0]");
                Log.d(TAG, sb.toString(), new Throwable());
                return null;
            }
            tComponent1 = value.component1();
            iIntValue = value.component2().intValue() + 1;
        } while (!this.refCounted.compareAndSet(value, new Pair<>(tComponent1, Integer.valueOf(iIntValue))));
        if (this.debugRefCounts) {
            StringBuilder sb2 = new StringBuilder("RefCounted@");
            String str2 = String.format("%x", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            sb2.append(str2);
            sb2.append(Typography.less);
            sb2.append(Reflection.getOrCreateKotlinClass(tComponent1.getClass()).getSimpleName());
            sb2.append(">.acquire() success: [refCount: ");
            sb2.append(iIntValue);
            sb2.append(", value: ");
            sb2.append(tComponent1);
            sb2.append(AbstractJsonLexerKt.END_LIST);
            Log.d(TAG, sb2.toString(), new Throwable());
        }
        return tComponent1;
    }

    public final void release() {
        Pair<T, Integer> value;
        Companion companion;
        T tComponent1;
        int iIntValue;
        Pair<T, Integer> pairReleased;
        if (Intrinsics.areEqual(this.refCounted.getValue(), INSTANCE.uninitialized())) {
            throw new IllegalStateException("Ref-count managed object has not yet been initialized. Unable to release.".toString());
        }
        AtomicRef<Pair<T, Integer>> atomicRef = this.refCounted;
        do {
            value = atomicRef.getValue();
            companion = INSTANCE;
            if (Intrinsics.areEqual(value, companion.released())) {
                throw new IllegalStateException("Release called more times than initialize + acquire.".toString());
            }
            tComponent1 = value.component1();
            iIntValue = value.component2().intValue();
            pairReleased = iIntValue == 1 ? companion.released() : new Pair<>(tComponent1, Integer.valueOf(iIntValue - 1));
        } while (!this.refCounted.compareAndSet(value, pairReleased));
        boolean zAreEqual = Intrinsics.areEqual(pairReleased, companion.released());
        boolean z = this.debugRefCounts;
        if (zAreEqual) {
            if (z) {
                StringBuilder sb = new StringBuilder("RefCounted@");
                String str = String.format("%x", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
                sb.append(Typography.less);
                sb.append(Reflection.getOrCreateKotlinClass(tComponent1.getClass()).getSimpleName());
                sb.append(">.release() (last ref): [refCount: 0, value: ");
                sb.append(tComponent1);
                sb.append(AbstractJsonLexerKt.END_LIST);
                Log.d(TAG, sb.toString(), new Throwable());
            }
            this.onRelease.invoke(tComponent1);
            return;
        }
        if (z) {
            StringBuilder sb2 = new StringBuilder("RefCounted@");
            String str2 = String.format("%x", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            sb2.append(str2);
            sb2.append(Typography.less);
            sb2.append(Reflection.getOrCreateKotlinClass(tComponent1.getClass()).getSimpleName());
            sb2.append(">.release(): [refCount: ");
            sb2.append(iIntValue - 1);
            sb2.append(", value: ");
            sb2.append(tComponent1);
            sb2.append(AbstractJsonLexerKt.END_LIST);
            Log.d(TAG, sb2.toString(), new Throwable());
        }
    }

    /* JADX INFO: compiled from: RefCounted.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0007\"\u0004\b\u0001\u0010\fH\u0002J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0007\"\u0004\b\u0001\u0010\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/viewfinder/core/impl/RefCounted$Companion;", "", "<init>", "()V", "TAG", "", "UNINITIALIZED", "Lkotlin/Pair;", "", "", "RELEASED", "uninitialized", ExifInterface.GPS_DIRECTION_TRUE, "released", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Pair<T, Integer> uninitialized() {
            Pair<T, Integer> pair = RefCounted.UNINITIALIZED;
            Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.Pair<T of androidx.camera.viewfinder.core.impl.RefCounted.Companion.uninitialized, kotlin.Int>");
            return pair;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Pair<T, Integer> released() {
            Pair<T, Integer> pair = RefCounted.RELEASED;
            Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.Pair<T of androidx.camera.viewfinder.core.impl.RefCounted.Companion.released, kotlin.Int>");
            return pair;
        }
    }
}
