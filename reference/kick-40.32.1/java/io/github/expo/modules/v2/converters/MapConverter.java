package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0011\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001d"}, d2 = {"Lio/github/expo/modules/v2/converters/MapConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "typeDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "<init>", "(Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;)V", "valueConverter", "", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "[I", "isPassthrough", "", "()Z", "fromJni", "value", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/Map;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/util/Map;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MapConverter extends TypeConverter<Map<?, ?>> {
    private final int[] codes;
    private final TypeConverter<Object> valueConverter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapConverter(TypeDescriptor.Parametrized typeDescriptor) {
        super(typeDescriptor.isNullable());
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeConverter<?> converter = typeDescriptor.getParams()[1].getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        this.valueConverter = converter;
        this.codes = CppType.m12415pluswHJnekk(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12440getMAPz4oZPQ(), getIsNullable()), converter.getCodes());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: from getter */
    public int[] getCodes() {
        return this.codes;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return this.valueConverter.isPassthrough();
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Map<?, ?> fromJni(Object value) {
        MapConverter mapConverter = this;
        if (value != null) {
            Map<?, ?> map = (Map) value;
            if (this.valueConverter.isPassthrough()) {
                return map;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), this.valueConverter.fromJni(entry.getValue()));
            }
            return linkedHashMap;
        }
        if (mapConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(mapConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(Map<?, ?> value) {
        if (this.valueConverter.isPassthrough()) {
            return value;
        }
        if (value == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(value.size()));
        Iterator<T> it = value.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), this.valueConverter.toJni(entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, Map<?, ?> value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        BinaryBuffer.m12285putIntWPjWIpM(buf, value.size());
        for (Map.Entry<?, ?> entry : value.entrySet()) {
            Object key = entry.getKey();
            Object value2 = entry.getValue();
            if (!(key instanceof String)) {
                throw new IllegalArgumentException("Cannot binary-encode a Map with non-String key".toString());
            }
            BinaryBuffer.m12293putStringWPjWIpM(buf, (String) key);
            this.valueConverter.mo12333writeToBufferuOnPpUM(buf, value2);
        }
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc, reason: avoid collision after fix types in other method */
    public Map<?, ?> mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        HashMap map;
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            int iM12260getIntimpl = BinaryBuffer.m12260getIntimpl(buf);
            HashMap map2 = new HashMap(iM12260getIntimpl, 1.0f);
            for (int i = 0; i < iM12260getIntimpl; i++) {
                map2.put(BinaryBuffer.m12271getStringimpl(buf), this.valueConverter.mo12332readFromBufferR_h_rCc(buf));
            }
            map = map2;
        } else {
            map = null;
        }
        return map;
    }
}
