package io.github.expo.modules.v2.records;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.jni.ClassExtensionsKt;
import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.types.TypeCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0003J0\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e¨\u0006)"}, d2 = {"Lio/github/expo/modules/v2/records/RecordType;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/records/Record;", "", "schemaId", "Lio/github/expo/modules/v2/records/SchemaId;", "codec", "Lio/github/expo/modules/v2/records/RecordCodec;", "<init>", "(ILio/github/expo/modules/v2/records/RecordCodec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSchemaId-GvrSWAs", "()I", "I", "getCodec", "()Lio/github/expo/modules/v2/records/RecordCodec;", "schema", "Lio/github/expo/modules/v2/records/RecordSchema;", "getSchema", "()Lio/github/expo/modules/v2/records/RecordSchema;", "anyCodec", "getAnyCodec$annotations", "()V", "getAnyCodec", "toData", "Lio/github/expo/modules/v2/records/RecordSchemaData;", "marshallCodes", "", "fieldCodesSize", "", "component1", "component1-GvrSWAs", "component2", "copy", "copy-NfgH2Cs", "(ILio/github/expo/modules/v2/records/RecordCodec;)Lio/github/expo/modules/v2/records/RecordType;", "equals", "", "other", "hashCode", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecordType<T extends Record> {
    private final RecordCodec<T> codec;
    private final RecordSchema schema;
    private final int schemaId;

    public /* synthetic */ RecordType(int i, RecordCodec recordCodec, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, recordCodec);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-NfgH2Cs$default, reason: not valid java name */
    public static /* synthetic */ RecordType m12380copyNfgH2Cs$default(RecordType recordType, int i, RecordCodec recordCodec, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordType.schemaId;
        }
        if ((i2 & 2) != 0) {
            recordCodec = recordType.codec;
        }
        return recordType.m12382copyNfgH2Cs(i, recordCodec);
    }

    public static /* synthetic */ void getAnyCodec$annotations() {
    }

    /* JADX INFO: renamed from: component1-GvrSWAs, reason: not valid java name and from getter */
    public final int getSchemaId() {
        return this.schemaId;
    }

    public final RecordCodec<T> component2() {
        return this.codec;
    }

    /* JADX INFO: renamed from: copy-NfgH2Cs, reason: not valid java name */
    public final RecordType<T> m12382copyNfgH2Cs(int schemaId, RecordCodec<T> codec) {
        Intrinsics.checkNotNullParameter(codec, "codec");
        return new RecordType<>(schemaId, codec, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordType)) {
            return false;
        }
        RecordType recordType = (RecordType) other;
        return SchemaId.m12387equalsimpl0(this.schemaId, recordType.schemaId) && Intrinsics.areEqual(this.codec, recordType.codec);
    }

    public int hashCode() {
        return (SchemaId.m12388hashCodeimpl(this.schemaId) * 31) + this.codec.hashCode();
    }

    public String toString() {
        return "RecordType(schemaId=" + SchemaId.m12390toStringimpl(this.schemaId) + ", codec=" + this.codec + ")";
    }

    private RecordType(int i, RecordCodec<T> codec) {
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.schemaId = i;
        this.codec = codec;
        this.schema = codec.getSchema();
    }

    /* JADX INFO: renamed from: getSchemaId-GvrSWAs, reason: not valid java name */
    public final int m12383getSchemaIdGvrSWAs() {
        return this.schemaId;
    }

    public final RecordCodec<T> getCodec() {
        return this.codec;
    }

    public final RecordSchema getSchema() {
        return this.schema;
    }

    public final RecordCodec<Record> getAnyCodec() {
        RecordCodec<T> recordCodec = this.codec;
        Intrinsics.checkNotNull(recordCodec, "null cannot be cast to non-null type io.github.expo.modules.v2.records.RecordCodec<io.github.expo.modules.v2.records.Record>");
        return recordCodec;
    }

    public final RecordSchemaData toData() {
        String name = this.schema.getName();
        String jniDescriptor = ClassExtensionsKt.getJniDescriptor(this.codec.getRecordClass());
        boolean bufferSafe = this.schema.getBufferSafe();
        List<RecordField> fields = this.schema.getFields();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
        Iterator<T> it = fields.iterator();
        while (it.hasNext()) {
            arrayList.add(((RecordField) it.next()).getName());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        int[] iArrMarshallCodes = marshallCodes();
        int size = this.schema.getFields().size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = this.schema.getFields().get(i).isOptional();
        }
        return new RecordSchemaData(name, jniDescriptor, bufferSafe, strArr, iArrMarshallCodes, zArr);
    }

    private final int[] marshallCodes() {
        int[] iArr = new int[fieldCodesSize()];
        Iterator<T> it = this.schema.getFields().iterator();
        int i = 0;
        while (it.hasNext()) {
            int[] codes = ((RecordField) it.next()).getType().getConverter().getCodes();
            int i2 = i + 1;
            iArr[i] = TypeCodes.m12453getSizeimpl(codes);
            int length = codes.length;
            int i3 = 0;
            while (i3 < length) {
                iArr[i2] = codes[i3];
                i3++;
                i2++;
            }
            i = i2;
        }
        return iArr;
    }

    private final int fieldCodesSize() {
        Iterator<T> it = this.schema.getFields().iterator();
        int iM12453getSizeimpl = 0;
        while (it.hasNext()) {
            iM12453getSizeimpl = iM12453getSizeimpl + 1 + TypeCodes.m12453getSizeimpl(((RecordField) it.next()).getType().getConverter().getCodes());
        }
        return iM12453getSizeimpl;
    }
}
