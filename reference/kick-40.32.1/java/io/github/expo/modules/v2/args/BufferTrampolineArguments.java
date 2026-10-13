package io.github.expo.modules.v2.args;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.binary.BinaryBufferExtensionKt;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import io.ktor.http.LinkHeader;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferTrampolineArguments.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00100\u001a\u000201H\u0016J\n\u00102\u001a\u0004\u0018\u000101H\u0016J\u001b\u00103\u001a\u0002H4\"\u0004\b\u0000\u001042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u00069"}, d2 = {"Lio/github/expo/modules/v2/args/BufferTrampolineArguments;", "Lio/github/expo/modules/v2/args/TrampolineArguments;", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "<init>", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/nio/ByteBuffer;", "rewind", "", "payloadLength", "", "nextBoolean", "", "nextBooleanOrNull", "()Ljava/lang/Boolean;", "nextInt", "nextIntOrNull", "()Ljava/lang/Integer;", "nextLong", "", "nextLongOrNull", "()Ljava/lang/Long;", "nextFloat", "", "nextFloatOrNull", "()Ljava/lang/Float;", "nextDouble", "", "nextDoubleOrNull", "()Ljava/lang/Double;", "nextString", "", "nextStringOrNull", "nextBooleanArray", "", "nextBooleanArrayOrNull", "nextIntArray", "", "nextIntArrayOrNull", "nextLongArray", "", "nextLongArrayOrNull", "nextFloatArray", "", "nextFloatArrayOrNull", "nextDoubleArray", "", "nextDoubleArrayOrNull", "nextByteArray", "", "nextByteArrayOrNull", LinkHeader.Rel.Next, ExifInterface.GPS_DIRECTION_TRUE, "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "finish", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferTrampolineArguments implements TrampolineArguments {
    private final ByteBuffer buf;

    public /* synthetic */ BufferTrampolineArguments(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public void finish() {
    }

    private BufferTrampolineArguments(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this.buf = buf;
    }

    public final void rewind(int payloadLength) {
        BinaryBufferExtensionKt.m12314rewinduOnPpUM(this.buf, payloadLength);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean nextBoolean() {
        return BinaryBuffer.m12249getBooleanimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Boolean nextBooleanOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return Boolean.valueOf(BinaryBuffer.m12249getBooleanimpl(this.buf));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int nextInt() {
        return BinaryBuffer.m12260getIntimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Integer nextIntOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return Integer.valueOf(BinaryBuffer.m12260getIntimpl(this.buf));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long nextLong() {
        return BinaryBuffer.m12265getLongimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Long nextLongOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return Long.valueOf(BinaryBuffer.m12265getLongimpl(this.buf));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float nextFloat() {
        return BinaryBuffer.m12257getFloatimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Float nextFloatOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return Float.valueOf(BinaryBuffer.m12257getFloatimpl(this.buf));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double nextDouble() {
        return BinaryBuffer.m12253getDoubleimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public Double nextDoubleOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return Double.valueOf(BinaryBuffer.m12253getDoubleimpl(this.buf));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public String nextString() {
        return BinaryBuffer.m12271getStringimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public String nextStringOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12271getStringimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean[] nextBooleanArray() {
        return BinaryBuffer.m12250getBooleanArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public boolean[] nextBooleanArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12250getBooleanArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int[] nextIntArray() {
        return BinaryBuffer.m12261getIntArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public int[] nextIntArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12261getIntArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long[] nextLongArray() {
        return BinaryBuffer.m12266getLongArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public long[] nextLongArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12266getLongArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float[] nextFloatArray() {
        return BinaryBuffer.m12258getFloatArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public float[] nextFloatArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12258getFloatArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double[] nextDoubleArray() {
        return BinaryBuffer.m12254getDoubleArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public double[] nextDoubleArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12254getDoubleArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public byte[] nextByteArray() {
        return BinaryBuffer.m12251getByteArrayimpl(this.buf);
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public byte[] nextByteArrayOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buf)) {
            return BinaryBuffer.m12251getByteArrayimpl(this.buf);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.args.TrampolineArguments
    public <T> T next(TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter<?> converter = type.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return (T) converter.mo12332readFromBufferR_h_rCc(this.buf);
    }
}
