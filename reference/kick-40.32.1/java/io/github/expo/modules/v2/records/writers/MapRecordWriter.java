package io.github.expo.modules.v2.records.writers;

import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.RecordField;
import io.github.expo.modules.v2.records.RecordType;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapRecordWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001cH\u0016J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001eH\u0016J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020 H\u0016J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0%2\u0006\u0010&\u001a\u00020'R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lio/github/expo/modules/v2/records/writers/MapRecordWriter;", "Lio/github/expo/modules/v2/records/writers/RecordWriter;", "type", "Lio/github/expo/modules/v2/records/RecordType;", "<init>", "(Lio/github/expo/modules/v2/records/RecordType;)V", "fields", "", "Lio/github/expo/modules/v2/records/RecordField;", "currentIndex", "", "out", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "nextField", "getNextField", "()Lio/github/expo/modules/v2/records/RecordField;", "nextFieldName", "getNextFieldName", "()Ljava/lang/String;", "write", "", "value", "", "(Ljava/lang/Boolean;)V", "(Ljava/lang/Integer;)V", "", "(Ljava/lang/Long;)V", "", "(Ljava/lang/Float;)V", "", "(Ljava/lang/Double;)V", "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "encode", "", "record", "Lio/github/expo/modules/v2/records/Record;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MapRecordWriter implements RecordWriter {
    private int currentIndex;
    private final List<RecordField> fields;
    private final LinkedHashMap<String, Object> out;
    private final RecordType<?> type;

    public MapRecordWriter(RecordType<?> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        List<RecordField> fields = type.getSchema().getFields();
        this.fields = fields;
        this.out = new LinkedHashMap<>(fields.size());
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

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(boolean value) {
        this.out.put(getNextFieldName(), Boolean.valueOf(value));
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Boolean value) {
        this.out.put(getNextFieldName(), value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(int value) {
        this.out.put(getNextFieldName(), Integer.valueOf(value));
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Integer value) {
        this.out.put(getNextFieldName(), value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(long value) {
        this.out.put(getNextFieldName(), Long.valueOf(value));
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Long value) {
        this.out.put(getNextFieldName(), value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(float value) {
        this.out.put(getNextFieldName(), Float.valueOf(value));
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Float value) {
        this.out.put(getNextFieldName(), value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(double value) {
        this.out.put(getNextFieldName(), Double.valueOf(value));
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Double value) {
        this.out.put(getNextFieldName(), value);
    }

    @Override // io.github.expo.modules.v2.records.writers.RecordWriter
    public void write(Object value, TypeDescriptor schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        RecordField nextField = getNextField();
        String strComponent1 = nextField.getName();
        TypeConverter<?> converter = nextField.getType().getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        LinkedHashMap<String, Object> linkedHashMap = this.out;
        if (!converter.isPassthrough()) {
            value = converter.toJni(value);
        }
        linkedHashMap.put(strComponent1, value);
    }

    public final Map<String, Object> encode(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.type.getAnyCodec().encode(record, this);
        return this.out;
    }
}
