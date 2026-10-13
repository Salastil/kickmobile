package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n2\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ>\u0010\u001f\u001a\u00020\u0017\"\u0004\b\u0000\u0010 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u00022!\u0010\"\u001a\u001d\u0012\u0013\u0012\u0011H ¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00170#H\u0082\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006'"}, d2 = {"Lio/github/expo/modules/v2/converters/ListConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "typeDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "<init>", "(Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;)V", "elementDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "elementConverter", "", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "[I", "isPassthrough", "", "()Z", "fromJni", "value", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/List;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/util/List;", "iterateOver", ExifInterface.GPS_DIRECTION_TRUE, "values", "putElement", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListConverter extends TypeConverter<List<?>> {
    private final int[] codes;
    private final TypeConverter<Object> elementConverter;
    private final TypeDescriptor.ObjectLike elementDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListConverter(TypeDescriptor.Parametrized typeDescriptor) {
        super(typeDescriptor.isNullable());
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeDescriptor.ObjectLike objectLike = typeDescriptor.getParams()[0];
        this.elementDescriptor = objectLike;
        TypeConverter<?> converter = objectLike.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        this.elementConverter = converter;
        this.codes = CppType.m12415pluswHJnekk(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12437getLISTz4oZPQ(), getIsNullable()), converter.getCodes());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: from getter */
    public int[] getCodes() {
        return this.codes;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return this.elementConverter.isPassthrough();
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public List<?> fromJni(Object value) {
        ListConverter listConverter = this;
        if (value != null) {
            List<?> list = (List) value;
            if (this.elementConverter.isPassthrough()) {
                return list;
            }
            Iterable iterable = (Iterable) value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(this.elementConverter.fromJni(it.next()));
            }
            return arrayList;
        }
        if (listConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(listConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(List<?> value) {
        if (this.elementConverter.isPassthrough()) {
            return value;
        }
        if (value == null) {
            return null;
        }
        List<?> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.elementConverter.toJni(it.next()));
        }
        return arrayList;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, List<?> value) {
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
        if (!this.elementConverter.getIsNullable()) {
            TypeConverter<Object> typeConverter = this.elementConverter;
            if (typeConverter instanceof PassthroughConverter) {
                int kind = ((PassthroughConverter) typeConverter).getKind();
                if (!CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12424getBOX_DOUBLEz4oZPQ())) {
                    if (!CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12426getBOX_INTz4oZPQ())) {
                        if (!CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12427getBOX_LONGz4oZPQ())) {
                            if (!CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12425getBOX_FLOATz4oZPQ())) {
                                if (!CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12423getBOX_BOOLEANz4oZPQ())) {
                                    if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12429getDOUBLEz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12433getINTz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12438getLONGz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12431getFLOATz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12421getBOOLEANz4oZPQ())) {
                                        throw new IllegalStateException("List has to use boxed types".toString());
                                    }
                                } else {
                                    Iterator<T> it = value.iterator();
                                    while (it.hasNext()) {
                                        BinaryBuffer.m12274putBooleanWPjWIpM(buf, ((Boolean) it.next()).booleanValue());
                                    }
                                    return;
                                }
                            } else {
                                Iterator<T> it2 = value.iterator();
                                while (it2.hasNext()) {
                                    BinaryBuffer.m12282putFloatWPjWIpM(buf, ((Number) it2.next()).floatValue());
                                }
                                return;
                            }
                        } else {
                            Iterator<T> it3 = value.iterator();
                            while (it3.hasNext()) {
                                BinaryBuffer.m12289putLongWPjWIpM(buf, ((Number) it3.next()).longValue());
                            }
                            return;
                        }
                    } else {
                        Iterator<T> it4 = value.iterator();
                        while (it4.hasNext()) {
                            BinaryBuffer.m12285putIntWPjWIpM(buf, ((Number) it4.next()).intValue());
                        }
                        return;
                    }
                } else {
                    Iterator<T> it5 = value.iterator();
                    while (it5.hasNext()) {
                        BinaryBuffer.m12278putDoubleWPjWIpM(buf, ((Number) it5.next()).doubleValue());
                    }
                    return;
                }
            }
        }
        Iterator<?> it6 = value.iterator();
        while (it6.hasNext()) {
            this.elementConverter.mo12333writeToBufferuOnPpUM(buf, it6.next());
        }
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc, reason: avoid collision after fix types in other method */
    public List<?> mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        ArrayList list = null;
        if (getIsNullable() && !BinaryBuffer.m12249getBooleanimpl(buf)) {
            return null;
        }
        int iM12260getIntimpl = BinaryBuffer.m12260getIntimpl(buf);
        if (!this.elementConverter.getIsNullable()) {
            TypeConverter<Object> typeConverter = this.elementConverter;
            if (typeConverter instanceof PassthroughConverter) {
                int kind = ((PassthroughConverter) typeConverter).getKind();
                if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12424getBOX_DOUBLEz4oZPQ())) {
                    list = ArraysKt.toList(BinaryBuffer.m12255getDoublesimpl(buf, iM12260getIntimpl));
                } else if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12426getBOX_INTz4oZPQ())) {
                    list = ArraysKt.toList(BinaryBuffer.m12262getIntsimpl(buf, iM12260getIntimpl));
                } else if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12427getBOX_LONGz4oZPQ())) {
                    list = ArraysKt.toList(BinaryBuffer.m12267getLongsimpl(buf, iM12260getIntimpl));
                } else if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12425getBOX_FLOATz4oZPQ())) {
                    list = ArraysKt.toList(BinaryBuffer.m12259getFloatsimpl(buf, iM12260getIntimpl));
                } else if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12423getBOX_BOOLEANz4oZPQ())) {
                    ArrayList arrayList = new ArrayList(iM12260getIntimpl);
                    for (int i = 0; i < iM12260getIntimpl; i++) {
                        arrayList.add(Boolean.valueOf(BinaryBuffer.m12249getBooleanimpl(buf)));
                    }
                    list = arrayList;
                } else if (CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12429getDOUBLEz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12433getINTz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12438getLONGz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12431getFLOATz4oZPQ()) || CppType.m12407equalsimpl0(kind, CppType.INSTANCE.m12421getBOOLEANz4oZPQ())) {
                    throw new IllegalStateException("List has to use boxed types".toString());
                }
                if (list != null) {
                    return list;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(iM12260getIntimpl);
        for (int i2 = 0; i2 < iM12260getIntimpl; i2++) {
            arrayList2.add(this.elementConverter.mo12332readFromBufferR_h_rCc(buf));
        }
        return arrayList2;
    }

    private final <T> void iterateOver(List<?> values, Function1<? super T, Unit> putElement) {
        Intrinsics.checkNotNull(values, "null cannot be cast to non-null type kotlin.collections.List<T of io.github.expo.modules.v2.converters.ListConverter.iterateOver>");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            putElement.invoke(it.next());
        }
    }
}
