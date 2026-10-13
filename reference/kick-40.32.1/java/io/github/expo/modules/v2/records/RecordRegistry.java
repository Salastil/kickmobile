package io.github.expo.modules.v2.records;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.cache.Cache;
import io.github.expo.modules.v2.loader.ExpoClassLoader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J+\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0007\"\b\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0012H\u0000¢\u0006\u0002\b\u0016J\u001b\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u0016J\u001a\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J \u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0001H\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\"H\u0007J&\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0007\"\b\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0012H\u0002J(\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0007\"\b\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0012H\u0002R\"\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Lio/github/expo/modules/v2/records/RecordRegistry;", "", "<init>", "()V", "byClass", "Lio/github/expo/modules/v2/cache/Cache;", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/records/RecordType;", "byId", "Lio/github/expo/modules/v2/records/SchemaId;", "_nextRecordId", "I", "nextRecordId", "getNextRecordId-GvrSWAs", "()I", "register", "", "codec", "Lio/github/expo/modules/v2/records/RecordCodec;", "typeFor", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/records/Record;", "typeFor$react_release", "schemaId", "typeFor-voaxQT4$react_release", "(I)Lio/github/expo/modules/v2/records/RecordType;", "clazz", "forceInitAndRetry", "dynamicRecordToMap", "", "", "value", "fetchSchema", "Lio/github/expo/modules/v2/records/RecordSchemaData;", "", "registerCodec", "existingTypeFor", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordRegistry {
    public static final RecordRegistry INSTANCE = new RecordRegistry();
    private static final Cache<Class<?>, RecordType<?>> byClass = new Cache<>();
    private static final Cache<SchemaId, RecordType<?>> byId = new Cache<>();
    private static volatile int _nextRecordId = SchemaId.m12385constructorimpl(1);

    private RecordRegistry() {
    }

    /* JADX INFO: renamed from: getNextRecordId-GvrSWAs, reason: not valid java name */
    private final int m12378getNextRecordIdGvrSWAs() {
        int i = _nextRecordId;
        _nextRecordId = SchemaId.m12389incGvrSWAs(i);
        return i;
    }

    public final void register(RecordCodec<?> codec) {
        Intrinsics.checkNotNullParameter(codec, "codec");
        if (codec.getRecordClass() == null) {
            throw new IllegalArgumentException((codec.getClass().getName() + " ran `RecordRegistry.register(this)` before `recordClass` was initialized — declare `override val recordClass` above the `init` block").toString());
        }
        registerCodec(codec);
    }

    public final <T extends Record> RecordType<T> typeFor$react_release(RecordCodec<T> codec) {
        Intrinsics.checkNotNullParameter(codec, "codec");
        RecordType<T> recordTypeExistingTypeFor = existingTypeFor(codec);
        if (recordTypeExistingTypeFor != null) {
            return recordTypeExistingTypeFor;
        }
        throw new IllegalStateException("RecordCodec " + codec.getClass().getName() + " is not registered - add `init { RecordRegistry.register(this) }` to the codec, declared after `recordClass`");
    }

    /* JADX INFO: renamed from: typeFor-voaxQT4$react_release, reason: not valid java name */
    public final RecordType<?> m12379typeForvoaxQT4$react_release(int schemaId) {
        RecordType<?> recordType = byId.get(SchemaId.m12384boximpl(schemaId));
        if (recordType != null) {
            return recordType;
        }
        throw new IllegalStateException("Unknown external schema id " + SchemaId.m12390toStringimpl(schemaId) + " - register it via RecordRegistry.register first");
    }

    public final RecordType<?> typeFor$react_release(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        RecordType<?> recordType = byClass.get(clazz);
        return recordType == null ? forceInitAndRetry(clazz) : recordType;
    }

    private final RecordType<?> forceInitAndRetry(Class<?> clazz) {
        if (!Record.class.isAssignableFrom(clazz)) {
            return null;
        }
        ExpoClassLoader.INSTANCE.loadAndInitializeClass(clazz);
        return byClass.get(clazz);
    }

    @JvmStatic
    public static final Map<String, Object> dynamicRecordToMap(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        RecordType<?> recordTypeTypeFor$react_release = INSTANCE.typeFor$react_release(value.getClass());
        if (recordTypeTypeFor$react_release == null) {
            return null;
        }
        return recordTypeTypeFor$react_release.getAnyCodec().toMap((Record) value);
    }

    @JvmStatic
    public static final RecordSchemaData fetchSchema(int schemaId) {
        return INSTANCE.m12379typeForvoaxQT4$react_release(SchemaId.m12385constructorimpl(schemaId)).toData();
    }

    private final synchronized <T extends Record> RecordType<T> registerCodec(RecordCodec<T> codec) {
        RecordType<T> recordType;
        if (existingTypeFor(codec) != null) {
            throw new IllegalStateException("Codec has been registered before".toString());
        }
        int iM12378getNextRecordIdGvrSWAs = m12378getNextRecordIdGvrSWAs();
        recordType = new RecordType<>(iM12378getNextRecordIdGvrSWAs, codec, null);
        byClass.put(codec.getRecordClass(), recordType);
        byId.put(SchemaId.m12384boximpl(iM12378getNextRecordIdGvrSWAs), recordType);
        return recordType;
    }

    private final <T extends Record> RecordType<T> existingTypeFor(RecordCodec<T> codec) {
        RecordType<T> recordType = (RecordType) byClass.get(codec.getRecordClass());
        if (recordType == null) {
            return null;
        }
        if (recordType.getCodec() == codec) {
            return recordType;
        }
        throw new IllegalArgumentException(("Class " + codec.getRecordClass().getName() + " is already registered with a different RecordCodec").toString());
    }
}
