package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.RecordType;
import io.github.expo.modules.v2.records.readers.BufferRecordReader;
import io.github.expo.modules.v2.records.readers.MapRecordReader;
import io.github.expo.modules.v2.records.writers.BufferRecordWriter;
import io.github.expo.modules.v2.records.writers.MapRecordWriter;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/github/expo/modules/v2/converters/RecordConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "Lio/github/expo/modules/v2/records/Record;", "recordType", "Lio/github/expo/modules/v2/records/RecordType;", "isNullable", "", "<init>", "(Lio/github/expo/modules/v2/records/RecordType;Z)V", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "[I", "isPassthrough", "()Z", "fromJni", "value", "", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Lio/github/expo/modules/v2/records/Record;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Lio/github/expo/modules/v2/records/Record;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordConverter extends TypeConverter<Record> {
    private final int[] codes;
    private final RecordType<?> recordType;

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordConverter(RecordType<?> recordType, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        this.recordType = recordType;
        this.codes = TypeCodes.INSTANCE.m12462ofDWjln38(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12441getRECORDz4oZPQ(), z), recordType.m12383getSchemaIdGvrSWAs());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: from getter */
    public int[] getCodes() {
        return this.codes;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Record fromJni(Object value) {
        RecordConverter recordConverter = this;
        if (value != null) {
            return new MapRecordReader(this.recordType, (Map) value).decode();
        }
        if (recordConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(recordConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(Record value) {
        if (value != null) {
            return new MapRecordWriter(this.recordType).encode(value);
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, Record value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        this.recordType.getAnyCodec().encode(value, new BufferRecordWriter(buf, null));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public Record mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            return this.recordType.getAnyCodec().decode(new BufferRecordReader(buf, null));
        }
        return null;
    }
}
