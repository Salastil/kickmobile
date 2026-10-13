package io.github.expo.modules.v2.args;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverflowTrampolineArguments.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020'H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010,\u001a\u00020-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u000200H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\u001b\u00102\u001a\u0002H3\"\u0004\b\u0000\u001032\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u000208H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0004H\u0002R\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lio/github/expo/modules/v2/args/OverflowTrampolineArguments;", "Lio/github/expo/modules/v2/args/TrampolineArguments;", "slots", "", "", "<init>", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "cursor", "", "nextBoolean", "", "nextBooleanOrNull", "()Ljava/lang/Boolean;", "nextInt", "nextIntOrNull", "()Ljava/lang/Integer;", "nextLong", "", "nextLongOrNull", "()Ljava/lang/Long;", "nextFloat", "", "nextFloatOrNull", "()Ljava/lang/Float;", "nextDouble", "", "nextDoubleOrNull", "()Ljava/lang/Double;", "nextString", "", "nextStringOrNull", "nextBooleanArray", "", "nextBooleanArrayOrNull", "nextIntArray", "", "nextIntArrayOrNull", "nextLongArray", "", "nextLongArrayOrNull", "nextFloatArray", "", "nextFloatArrayOrNull", "nextDoubleArray", "", "nextDoubleArrayOrNull", "nextByteArray", "", "nextByteArrayOrNull", LinkHeader.Rel.Next, ExifInterface.GPS_DIRECTION_TRUE, "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "finish", "", "take", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OverflowTrampolineArguments implements TrampolineArguments {
    private int cursor;
    private final Object[] slots;

    public OverflowTrampolineArguments(Object[] slots) {
        Intrinsics.checkNotNullParameter(slots, "slots");
        this.slots = slots;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean nextBoolean() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objTake).booleanValue();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Boolean nextBooleanOrNull() {
        return (Boolean) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int nextInt() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objTake).intValue();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Integer nextIntOrNull() {
        return (Integer) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long nextLong() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objTake).longValue();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Long nextLongOrNull() {
        return (Long) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float nextFloat() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objTake).floatValue();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Float nextFloatOrNull() {
        return (Float) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double nextDouble() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objTake).doubleValue();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Double nextDoubleOrNull() {
        return (Double) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public String nextString() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.String");
        return (String) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public String nextStringOrNull() {
        return (String) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean[] nextBooleanArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.BooleanArray");
        return (boolean[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean[] nextBooleanArrayOrNull() {
        return (boolean[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int[] nextIntArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.IntArray");
        return (int[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int[] nextIntArrayOrNull() {
        return (int[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long[] nextLongArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.LongArray");
        return (long[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long[] nextLongArrayOrNull() {
        return (long[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float[] nextFloatArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.FloatArray");
        return (float[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float[] nextFloatArrayOrNull() {
        return (float[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double[] nextDoubleArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.DoubleArray");
        return (double[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double[] nextDoubleArrayOrNull() {
        return (double[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public byte[] nextByteArray() {
        Object objTake = take();
        Intrinsics.checkNotNull(objTake, "null cannot be cast to non-null type kotlin.ByteArray");
        return (byte[]) objTake;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public byte[] nextByteArrayOrNull() {
        return (byte[]) take();
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public <T> T next(TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        T t = (T) take();
        TypeConverter<?> converter = type.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return (t == null || !converter.isPassthrough()) ? (T) converter.fromJni(t) : t;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public void finish() {
        ArraysKt.fill$default(this.slots, (Object) null, 0, 0, 6, (Object) null);
    }

    private final Object take() {
        int i = this.cursor;
        Object[] objArr = this.slots;
        if (i >= objArr.length) {
            throw new IllegalStateException(("Trampoline read more than the " + objArr.length + " available overflow arguments (trampoline/declaration drift)").toString());
        }
        Object obj = objArr[i];
        objArr[i] = null;
        this.cursor = i + 1;
        return obj;
    }
}
