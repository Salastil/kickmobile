package io.github.expo.modules.v2.records.writers;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferRecordWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0016J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012H\u0016J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JA\u0010\u0017\u001a\u00020\b\"\b\b\u0000\u0010\u0018*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u0001H\u00182\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u001bH\u0082\b¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001d"}, d2 = {"Lio/github/expo/modules/v2/records/writers/BufferRecordWriter;", "Lio/github/expo/modules/v2/records/writers/RecordWriter;", "buffer", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "<init>", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/nio/ByteBuffer;", "write", "", "value", "", "(Ljava/lang/Boolean;)V", "", "(Ljava/lang/Integer;)V", "", "(Ljava/lang/Long;)V", "", "(Ljava/lang/Float;)V", "", "(Ljava/lang/Double;)V", "", "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "writeNullable", ExifInterface.GPS_DIRECTION_TRUE, "put", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferRecordWriter implements RecordWriter {
    private final ByteBuffer buffer;

    public /* synthetic */ BufferRecordWriter(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    private BufferRecordWriter(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(boolean value) {
        BinaryBuffer.m12274putBooleanWPjWIpM(this.buffer, value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(int value) {
        BinaryBuffer.m12285putIntWPjWIpM(this.buffer, value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(long value) {
        BinaryBuffer.m12289putLongWPjWIpM(this.buffer, value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(float value) {
        BinaryBuffer.m12282putFloatWPjWIpM(this.buffer, value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(double value) {
        BinaryBuffer.m12278putDoubleWPjWIpM(this.buffer, value);
    }

    private final <T> void writeNullable(T value, Function2<? super BinaryBuffer, ? super T, Unit> put) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            put.invoke(BinaryBuffer.m12244boximpl(this.buffer), value);
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Boolean value) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            BinaryBuffer.m12274putBooleanWPjWIpM(this.buffer, value.booleanValue());
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Integer value) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            BinaryBuffer.m12285putIntWPjWIpM(this.buffer, value.intValue());
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Long value) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            BinaryBuffer.m12289putLongWPjWIpM(this.buffer, value.longValue());
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Float value) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            BinaryBuffer.m12282putFloatWPjWIpM(this.buffer, value.floatValue());
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Double value) {
        ByteBuffer byteBuffer = this.buffer;
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, false));
        } else {
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, true);
            BinaryBuffer.m12278putDoubleWPjWIpM(this.buffer, value.doubleValue());
        }
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Object value, TypeDescriptor schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        TypeConverter<?> converter = schema.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        converter.mo12333writeToBufferuOnPpUM(this.buffer, value);
    }
}
