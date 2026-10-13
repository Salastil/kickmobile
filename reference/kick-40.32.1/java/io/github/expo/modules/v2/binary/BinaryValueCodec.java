package io.github.expo.modules.v2.binary;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.kolibri.binary.ListHeader;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.RecordCodec;
import io.github.expo.modules.v2.records.RecordRegistry;
import io.github.expo.modules.v2.records.RecordType;
import io.github.expo.modules.v2.records.SchemaId;
import io.github.expo.modules.v2.records.readers.BufferRecordReader;
import io.github.expo.modules.v2.records.writers.BufferRecordWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BinaryValueCodec.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0013\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"H\u0002¢\u0006\u0004\b#\u0010$J7\u0010%\u001a\"\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u00010&j\u0010\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u0001`(2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b,\u0010\n¨\u0006-"}, d2 = {"Lio/github/expo/modules/v2/binary/BinaryValueCodec;", "", "<init>", "()V", "writeDynamic", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeDynamic-uOnPpUM$react_release", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)V", "readDynamic", "readDynamic-R_h_rCc$react_release", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "writeDynamicList", "list", "", "writeDynamicList-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/List;)V", "readDynamicList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "readDynamicList-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/util/ArrayList;", "dynamicScalarTagOf", "", "(Ljava/util/List;)Ljava/lang/Integer;", "(Ljava/lang/Object;)Ljava/lang/Integer;", "writeDynamicScalar", "scalarTag", "writeDynamicScalar-i6ZDxrg", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;I)V", "writeDynamicMap", "map", "", "writeDynamicMap-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/Map;)V", "readDynamicMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "readDynamicMap-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/util/HashMap;", "writeDynamicExternalSchema", "writeDynamicExternalSchema-uOnPpUM", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BinaryValueCodec {
    public static final BinaryValueCodec INSTANCE = new BinaryValueCodec();

    private BinaryValueCodec() {
    }

    /* JADX INFO: renamed from: writeDynamic-uOnPpUM$react_release, reason: not valid java name */
    public final void m12323writeDynamicuOnPpUM$react_release(ByteBuffer buf, Object value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (value == null) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12302putTaggedNullBdoBPnE(buf));
            return;
        }
        if (value instanceof Boolean) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12296putTaggedBooleanWPjWIpM(buf, ((Boolean) value).booleanValue()));
            return;
        }
        if (value instanceof Integer) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12300putTaggedIntWPjWIpM(buf, ((Number) value).intValue()));
            return;
        }
        if (value instanceof Long) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12301putTaggedLongWPjWIpM(buf, ((Number) value).longValue()));
            return;
        }
        if (value instanceof Float) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12299putTaggedFloatWPjWIpM(buf, ((Number) value).floatValue()));
            return;
        }
        if (value instanceof Double) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12298putTaggedDoubleWPjWIpM(buf, ((Number) value).doubleValue()));
            return;
        }
        if (value instanceof String) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12303putTaggedStringWPjWIpM(buf, (String) value));
            return;
        }
        if (value instanceof List) {
            m12319writeDynamicListuOnPpUM(buf, (List) value);
            Unit unit = Unit.INSTANCE;
            return;
        }
        if (value instanceof Map) {
            m12320writeDynamicMapuOnPpUM(buf, (Map) value);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12280putDoublesWPjWIpM(BinaryBuffer.m12288putListHeadercwiCPus(buf, dArr.length, 5), dArr));
            return;
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12287putIntsWPjWIpM(BinaryBuffer.m12288putListHeadercwiCPus(buf, iArr.length, 2), iArr));
            return;
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12291putLongsWPjWIpM(BinaryBuffer.m12288putListHeadercwiCPus(buf, jArr.length, 3), jArr));
            return;
        }
        if (value instanceof float[]) {
            float[] fArr = (float[]) value;
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12284putFloatsWPjWIpM(BinaryBuffer.m12288putListHeadercwiCPus(buf, fArr.length, 4), fArr));
            return;
        }
        if (value instanceof boolean[]) {
            boolean[] zArr = (boolean[]) value;
            BinaryBuffer.m12288putListHeadercwiCPus(buf, zArr.length, 0);
            for (boolean z : zArr) {
                BinaryBuffer.m12274putBooleanWPjWIpM(buf, z);
            }
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        if (value instanceof byte[]) {
            BinaryBuffer.m12244boximpl(BinaryBuffer.m12297putTaggedByteArrayWPjWIpM(buf, (byte[]) value));
        } else {
            m12318writeDynamicExternalSchemauOnPpUM(buf, value);
            Unit unit4 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: readDynamic-R_h_rCc$react_release, reason: not valid java name */
    public final Object m12322readDynamicR_h_rCc$react_release(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int iM12272getTagimpl = BinaryBuffer.m12272getTagimpl(buf);
        DefaultConstructorMarker defaultConstructorMarker = null;
        switch (iM12272getTagimpl) {
            case 0:
                return Boolean.valueOf(BinaryBuffer.m12249getBooleanimpl(buf));
            case 1:
                return BinaryBuffer.m12271getStringimpl(buf);
            case 2:
                return Integer.valueOf(BinaryBuffer.m12260getIntimpl(buf));
            case 3:
                return Long.valueOf(BinaryBuffer.m12265getLongimpl(buf));
            case 4:
                return Float.valueOf(BinaryBuffer.m12257getFloatimpl(buf));
            case 5:
                return Double.valueOf(BinaryBuffer.m12253getDoubleimpl(buf));
            case 6:
                return m12316readDynamicListR_h_rCc(buf);
            case 7:
                return m12317readDynamicMapR_h_rCc(buf);
            case 8:
                return null;
            case 9:
                return BinaryBuffer.m12251getByteArrayimpl(buf);
            case 10:
                return RecordRegistry.INSTANCE.m12379typeForvoaxQT4$react_release(SchemaId.m12385constructorimpl(BinaryBuffer.m12256getExternalSchemaIdimpl(buf))).getCodec().decode(new BufferRecordReader(buf, defaultConstructorMarker));
            default:
                throw new IllegalStateException("Unknown binary tag: " + iM12272getTagimpl);
        }
    }

    /* JADX INFO: renamed from: writeDynamicList-uOnPpUM, reason: not valid java name */
    private final void m12319writeDynamicListuOnPpUM(ByteBuffer buf, List<?> list) {
        Integer numDynamicScalarTagOf = dynamicScalarTagOf(list);
        if (numDynamicScalarTagOf == null) {
            BinaryBuffer.m12288putListHeadercwiCPus(buf, list.size(), 255);
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                m12323writeDynamicuOnPpUM$react_release(buf, it.next());
            }
            return;
        }
        BinaryBuffer.m12288putListHeadercwiCPus(buf, list.size(), numDynamicScalarTagOf.intValue());
        for (Object obj : list) {
            Intrinsics.checkNotNull(obj);
            m12321writeDynamicScalari6ZDxrg(buf, obj, numDynamicScalarTagOf.intValue());
        }
    }

    /* JADX INFO: renamed from: readDynamicList-R_h_rCc, reason: not valid java name */
    private final ArrayList<Object> m12316readDynamicListR_h_rCc(ByteBuffer buf) {
        ListHeader listHeaderM12264getListHeaderimpl = BinaryBuffer.m12264getListHeaderimpl(buf);
        int count = listHeaderM12264getListHeaderimpl.getCount();
        int elementTag = listHeaderM12264getListHeaderimpl.getElementTag();
        ArrayList<Object> arrayList = new ArrayList<>(count);
        int i = 0;
        if (elementTag == 0) {
            while (i < count) {
                arrayList.add(Boolean.valueOf(BinaryBuffer.m12249getBooleanimpl(buf)));
                i++;
            }
        } else if (elementTag == 255) {
            while (i < count) {
                arrayList.add(INSTANCE.m12322readDynamicR_h_rCc$react_release(buf));
                i++;
            }
        } else if (elementTag == 2) {
            int[] iArrM12262getIntsimpl = BinaryBuffer.m12262getIntsimpl(buf, count);
            int length = iArrM12262getIntsimpl.length;
            while (i < length) {
                arrayList.add(Integer.valueOf(iArrM12262getIntsimpl[i]));
                i++;
            }
        } else if (elementTag == 3) {
            long[] jArrM12267getLongsimpl = BinaryBuffer.m12267getLongsimpl(buf, count);
            int length2 = jArrM12267getLongsimpl.length;
            while (i < length2) {
                arrayList.add(Long.valueOf(jArrM12267getLongsimpl[i]));
                i++;
            }
        } else if (elementTag == 4) {
            float[] fArrM12259getFloatsimpl = BinaryBuffer.m12259getFloatsimpl(buf, count);
            int length3 = fArrM12259getFloatsimpl.length;
            while (i < length3) {
                arrayList.add(Float.valueOf(fArrM12259getFloatsimpl[i]));
                i++;
            }
        } else if (elementTag == 5) {
            double[] dArrM12255getDoublesimpl = BinaryBuffer.m12255getDoublesimpl(buf, count);
            int length4 = dArrM12255getDoublesimpl.length;
            while (i < length4) {
                arrayList.add(Double.valueOf(dArrM12255getDoublesimpl[i]));
                i++;
            }
        } else {
            throw new IllegalStateException("Unknown list element tag: " + elementTag);
        }
        return arrayList;
    }

    private final Integer dynamicScalarTagOf(List<?> list) {
        Integer numDynamicScalarTagOf;
        Integer numDynamicScalarTagOf2;
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (objFirstOrNull == null || (numDynamicScalarTagOf = dynamicScalarTagOf(objFirstOrNull)) == null) {
            return null;
        }
        numDynamicScalarTagOf.intValue();
        int iIntValue = numDynamicScalarTagOf.intValue();
        List<?> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return numDynamicScalarTagOf;
        }
        for (Object obj : list2) {
            if (obj == null || (numDynamicScalarTagOf2 = INSTANCE.dynamicScalarTagOf(obj)) == null || numDynamicScalarTagOf2.intValue() != iIntValue) {
                return null;
            }
        }
        return numDynamicScalarTagOf;
    }

    private final Integer dynamicScalarTagOf(Object value) {
        if (value instanceof Double) {
            return 5;
        }
        if (value instanceof Integer) {
            return 2;
        }
        if (value instanceof Long) {
            return 3;
        }
        if (value instanceof Float) {
            return 4;
        }
        return value instanceof Boolean ? 0 : null;
    }

    /* JADX INFO: renamed from: writeDynamicScalar-i6ZDxrg, reason: not valid java name */
    private final void m12321writeDynamicScalari6ZDxrg(ByteBuffer buf, Object value, int scalarTag) {
        if (scalarTag == 0) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, ((Boolean) value).booleanValue());
            return;
        }
        if (scalarTag == 2) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
            BinaryBuffer.m12285putIntWPjWIpM(buf, ((Integer) value).intValue());
            return;
        }
        if (scalarTag == 3) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
            BinaryBuffer.m12289putLongWPjWIpM(buf, ((Long) value).longValue());
        } else if (scalarTag == 4) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
            BinaryBuffer.m12282putFloatWPjWIpM(buf, ((Float) value).floatValue());
        } else if (scalarTag == 5) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
            BinaryBuffer.m12278putDoubleWPjWIpM(buf, ((Double) value).doubleValue());
        } else {
            throw new IllegalStateException("Not a bulk-run element tag: " + scalarTag);
        }
    }

    /* JADX INFO: renamed from: writeDynamicMap-uOnPpUM, reason: not valid java name */
    private final void m12320writeDynamicMapuOnPpUM(ByteBuffer buf, Map<?, ?> map) {
        BinaryBuffer.m12292putMapHeaderWPjWIpM(buf, map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(key instanceof String)) {
                throw new IllegalArgumentException("Cannot binary-encode a Map with non-String key".toString());
            }
            BinaryBuffer.m12293putStringWPjWIpM(buf, (String) key);
            m12323writeDynamicuOnPpUM$react_release(buf, value);
        }
    }

    /* JADX INFO: renamed from: readDynamicMap-R_h_rCc, reason: not valid java name */
    private final HashMap<String, Object> m12317readDynamicMapR_h_rCc(ByteBuffer buf) {
        int iM12268getMapSizeimpl = BinaryBuffer.m12268getMapSizeimpl(buf);
        HashMap<String, Object> map = new HashMap<>(((iM12268getMapSizeimpl * 4) / 3) + 1);
        for (int i = 0; i < iM12268getMapSizeimpl; i++) {
            map.put(BinaryBuffer.m12271getStringimpl(buf), INSTANCE.m12322readDynamicR_h_rCc$react_release(buf));
        }
        return map;
    }

    /* JADX INFO: renamed from: writeDynamicExternalSchema-uOnPpUM, reason: not valid java name */
    private final void m12318writeDynamicExternalSchemauOnPpUM(ByteBuffer buf, Object value) {
        RecordType<?> recordTypeTypeFor$react_release = RecordRegistry.INSTANCE.typeFor$react_release(value.getClass());
        if (recordTypeTypeFor$react_release == null) {
            throw new IllegalArgumentException("No external schema registered for " + value.getClass().getName() + "; annotate the class with @io.github.expo.modules.v2.Record, or call RecordRegistry.register before the payload encode begins");
        }
        BinaryBuffer.m12281putExternalSchemaHeaderWPjWIpM(buf, recordTypeTypeFor$react_release.m12383getSchemaIdGvrSWAs());
        BufferRecordWriter bufferRecordWriter = new BufferRecordWriter(buf, null);
        RecordCodec<Record> anyCodec = recordTypeTypeFor$react_release.getAnyCodec();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.github.expo.modules.v2.records.Record");
        anyCodec.encode((Record) value, bufferRecordWriter);
    }
}
