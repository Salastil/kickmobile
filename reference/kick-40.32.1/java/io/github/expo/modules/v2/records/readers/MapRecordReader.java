package io.github.expo.modules.v2.records.readers;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.RecordField;
import io.github.expo.modules.v2.records.RecordType;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapRecordReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016J\u000f\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u000f\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010(J\u001b\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020/R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lio/github/expo/modules/v2/records/readers/MapRecordReader;", "Lio/github/expo/modules/v2/records/readers/RecordReader;", "type", "Lio/github/expo/modules/v2/records/RecordType;", "map", "", "", "", "<init>", "(Lio/github/expo/modules/v2/records/RecordType;Ljava/util/Map;)V", "fields", "", "Lio/github/expo/modules/v2/records/RecordField;", "currentIndex", "", "nextField", "getNextField", "()Lio/github/expo/modules/v2/records/RecordField;", "nextFieldName", "getNextFieldName", "()Ljava/lang/String;", "readIsPresent", "", "readBoolean", "readBooleanOrNull", "()Ljava/lang/Boolean;", "readInt", "readIntOrNull", "()Ljava/lang/Integer;", "readLong", "", "readLongOrNull", "()Ljava/lang/Long;", "readFloat", "", "readFloatOrNull", "()Ljava/lang/Float;", "readDouble", "", "readDoubleOrNull", "()Ljava/lang/Double;", "read", ExifInterface.GPS_DIRECTION_TRUE, "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "decode", "Lio/github/expo/modules/v2/records/Record;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MapRecordReader implements RecordReader {
    private int currentIndex;
    private final List<RecordField> fields;
    private final Map<String, Object> map;
    private final RecordType<?> type;

    public MapRecordReader(RecordType<?> type, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(map, "map");
        this.type = type;
        this.map = map;
        this.fields = type.getSchema().getFields();
    }

    private final RecordField getNextField() {
        List<RecordField> list = this.fields;
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return list.get(i);
    }

    private final String getNextFieldName() {
        return getNextField().getName();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public boolean readIsPresent() {
        if (this.map.containsKey(this.fields.get(this.currentIndex).getName())) {
            return true;
        }
        this.currentIndex++;
        return false;
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public boolean readBoolean() {
        Object obj = this.map.get(getNextFieldName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Boolean readBooleanOrNull() {
        return (Boolean) this.map.get(getNextFieldName());
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public int readInt() {
        Object obj = this.map.get(getNextFieldName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj).intValue();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Integer readIntOrNull() {
        return (Integer) this.map.get(getNextFieldName());
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public long readLong() {
        Object obj = this.map.get(getNextFieldName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Long readLongOrNull() {
        return (Long) this.map.get(getNextFieldName());
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public float readFloat() {
        Object obj = this.map.get(getNextFieldName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) obj).floatValue();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Float readFloatOrNull() {
        return (Float) this.map.get(getNextFieldName());
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public double readDouble() {
        Object obj = this.map.get(getNextFieldName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public Double readDoubleOrNull() {
        return (Double) this.map.get(getNextFieldName());
    }

    @Override // io.github.expo.modules.v2.records.readers.RecordReader
    public <T> T read(TypeDescriptor schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        RecordField nextField = getNextField();
        String strComponent1 = nextField.getName();
        TypeConverter<?> converter = nextField.getType().getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        T t = (T) this.map.get(strComponent1);
        return (t == null || !converter.isPassthrough()) ? (T) converter.fromJni(t) : t;
    }

    public final Record decode() {
        return this.type.getAnyCodec().decode(this);
    }
}
