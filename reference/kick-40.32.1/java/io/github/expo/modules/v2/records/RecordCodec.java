package io.github.expo.modules.v2.records;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.readers.MapRecordReader;
import io.github.expo.modules.v2.records.readers.RecordReader;
import io.github.expo.modules.v2.records.writers.MapRecordWriter;
import io.github.expo.modules.v2.records.writers.RecordWriter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordCodec.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00172\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u00028\u00002\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017H\u0016¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/records/RecordCodec;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/records/Record;", "", "recordClass", "Ljava/lang/Class;", "getRecordClass", "()Ljava/lang/Class;", "schema", "Lio/github/expo/modules/v2/records/RecordSchema;", "getSchema", "()Lio/github/expo/modules/v2/records/RecordSchema;", "encode", "", "value", "writer", "Lio/github/expo/modules/v2/records/writers/RecordWriter;", "(Lio/github/expo/modules/v2/records/Record;Lio/github/expo/modules/v2/records/writers/RecordWriter;)V", "decode", "reader", "Lio/github/expo/modules/v2/records/readers/RecordReader;", "(Lio/github/expo/modules/v2/records/readers/RecordReader;)Lio/github/expo/modules/v2/records/Record;", "toMap", "", "", "(Lio/github/expo/modules/v2/records/Record;)Ljava/util/Map;", "fromMap", "map", "(Ljava/util/Map;)Lio/github/expo/modules/v2/records/Record;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecordCodec<T extends Record> {
    T decode(RecordReader reader);

    void encode(T value, RecordWriter writer);

    Class<T> getRecordClass();

    RecordSchema getSchema();

    /* JADX INFO: compiled from: RecordCodec.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends Record> Map<String, Object> toMap(RecordCodec<T> recordCodec, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return RecordCodec.super.toMap(value);
        }

        @Deprecated
        public static <T extends Record> T fromMap(RecordCodec<T> recordCodec, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return (T) RecordCodec.super.fromMap(map);
        }
    }

    default Map<String, Object> toMap(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new MapRecordWriter(RecordRegistry.INSTANCE.typeFor$react_release(this)).encode(value);
    }

    default T fromMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return (T) decode(new MapRecordReader(RecordRegistry.INSTANCE.typeFor$react_release(this), map));
    }
}
