package io.github.expo.modules.v2.records.readers;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferRecordReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 J3\u0010!\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u001d0$¢\u0006\u0002\b%H\u0082\b¢\u0006\u0002\u0010&R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006'"}, d2 = {"Lio/github/expo/modules/v2/records/readers/BufferRecordReader;", "Lio/github/expo/modules/v2/records/readers/RecordReader;", "buffer", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "<init>", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/nio/ByteBuffer;", "readIsPresent", "", "readBoolean", "readBooleanOrNull", "()Ljava/lang/Boolean;", "readInt", "", "readIntOrNull", "()Ljava/lang/Integer;", "readLong", "", "readLongOrNull", "()Ljava/lang/Long;", "readFloat", "", "readFloatOrNull", "()Ljava/lang/Float;", "readDouble", "", "readDoubleOrNull", "()Ljava/lang/Double;", "read", ExifInterface.GPS_DIRECTION_TRUE, "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "readNullable", "", "get", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferRecordReader implements RecordReader {
    private final ByteBuffer buffer;

    public /* synthetic */ BufferRecordReader(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    private BufferRecordReader(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public boolean readIsPresent() {
        return BinaryBuffer.m12249getBooleanimpl(this.buffer);
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public boolean readBoolean() {
        return BinaryBuffer.m12249getBooleanimpl(this.buffer);
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public int readInt() {
        return BinaryBuffer.m12260getIntimpl(this.buffer);
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public long readLong() {
        return BinaryBuffer.m12265getLongimpl(this.buffer);
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public float readFloat() {
        return BinaryBuffer.m12257getFloatimpl(this.buffer);
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public double readDouble() {
        return BinaryBuffer.m12253getDoubleimpl(this.buffer);
    }

    private final <T> T readNullable(Function1<? super BinaryBuffer, ? extends T> get) {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return get.invoke(BinaryBuffer.m12244boximpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Boolean readBooleanOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return Boolean.valueOf(BinaryBuffer.m12249getBooleanimpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Integer readIntOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return Integer.valueOf(BinaryBuffer.m12260getIntimpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Long readLongOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return Long.valueOf(BinaryBuffer.m12265getLongimpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Float readFloatOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return Float.valueOf(BinaryBuffer.m12257getFloatimpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Double readDoubleOrNull() {
        if (BinaryBuffer.m12249getBooleanimpl(this.buffer)) {
            return Double.valueOf(BinaryBuffer.m12253getDoubleimpl(this.buffer));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public <T> T read(TypeDescriptor schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        TypeConverter<?> converter = schema.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return (T) converter.mo12332readFromBufferR_h_rCc(this.buffer);
    }
}
