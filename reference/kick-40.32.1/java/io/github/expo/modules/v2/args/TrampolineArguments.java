package io.github.expo.modules.v2.args;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.types.TypeDescriptor;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;

/* JADX INFO: compiled from: TrampolineArguments.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\u000f\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H&J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001c\u001a\u00020\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\b\u0010\u001f\u001a\u00020 H&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\b\u0010\"\u001a\u00020#H&J\n\u0010$\u001a\u0004\u0018\u00010#H&J\b\u0010%\u001a\u00020&H&J\n\u0010'\u001a\u0004\u0018\u00010&H&J\b\u0010(\u001a\u00020)H&J\n\u0010*\u001a\u0004\u0018\u00010)H&J\u001b\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020.H&¢\u0006\u0002\u0010/J\b\u00100\u001a\u000201H&\u0082\u0001\u000223¨\u00064À\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/args/TrampolineArguments;", "", "nextBoolean", "", "nextBooleanOrNull", "()Ljava/lang/Boolean;", "nextInt", "", "nextIntOrNull", "()Ljava/lang/Integer;", "nextLong", "", "nextLongOrNull", "()Ljava/lang/Long;", "nextFloat", "", "nextFloatOrNull", "()Ljava/lang/Float;", "nextDouble", "", "nextDoubleOrNull", "()Ljava/lang/Double;", "nextString", "", "nextStringOrNull", "nextBooleanArray", "", "nextBooleanArrayOrNull", "nextIntArray", "", "nextIntArrayOrNull", "nextLongArray", "", "nextLongArrayOrNull", "nextFloatArray", "", "nextFloatArrayOrNull", "nextDoubleArray", "", "nextDoubleArrayOrNull", "nextByteArray", "", "nextByteArrayOrNull", LinkHeader.Rel.Next, ExifInterface.GPS_DIRECTION_TRUE, "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "finish", "", "Lio/github/expo/modules/v2/args/BufferTrampolineArguments;", "Lio/github/expo/modules/v2/args/OverflowTrampolineArguments;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TrampolineArguments {
    void finish();

    <T> T next(TypeDescriptor type);

    boolean nextBoolean();

    boolean[] nextBooleanArray();

    boolean[] nextBooleanArrayOrNull();

    Boolean nextBooleanOrNull();

    byte[] nextByteArray();

    byte[] nextByteArrayOrNull();

    double nextDouble();

    double[] nextDoubleArray();

    double[] nextDoubleArrayOrNull();

    Double nextDoubleOrNull();

    float nextFloat();

    float[] nextFloatArray();

    float[] nextFloatArrayOrNull();

    Float nextFloatOrNull();

    int nextInt();

    int[] nextIntArray();

    int[] nextIntArrayOrNull();

    Integer nextIntOrNull();

    long nextLong();

    long[] nextLongArray();

    long[] nextLongArrayOrNull();

    Long nextLongOrNull();

    String nextString();

    String nextStringOrNull();
}
