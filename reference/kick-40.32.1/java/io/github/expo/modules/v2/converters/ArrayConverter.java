package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import io.github.expo.modules.v2.types.TypeDescriptor;
import io.ktor.http.ContentDisposition;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006%"}, d2 = {"Lio/github/expo/modules/v2/converters/ArrayConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "typeDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "<init>", "(Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;)V", "elementConverter", "", "elementClass", "Ljava/lang/Class;", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "", "()Z", "fromJni", "value", "(Ljava/lang/Object;)[Ljava/lang/Object;", "toJni", "([Ljava/lang/Object;)Ljava/lang/Object;", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;[Ljava/lang/Object;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)[Ljava/lang/Object;", "newArray", ContentDisposition.Parameters.Size, "", "(I)[Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArrayConverter<T> extends TypeConverter<T[]> {
    private final Class<?> elementClass;
    private final TypeConverter<Object> elementConverter;

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayConverter(TypeDescriptor.Parametrized typeDescriptor) {
        super(typeDescriptor.isNullable());
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeConverter<?> converter = typeDescriptor.getParams()[0].getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        this.elementConverter = converter;
        Class<?> componentType = typeDescriptor.getJavaClass().getComponentType();
        componentType = (componentType == null || componentType.isPrimitive()) ? null : componentType;
        if (componentType != null) {
            this.elementClass = componentType;
            return;
        }
        throw new IllegalArgumentException((typeDescriptor.getJavaClass().getName() + " is not an object-array class, so it declares no element type").toString());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: not valid java name */
    public int[] getCodes() {
        return CppType.m12415pluswHJnekk(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12437getLISTz4oZPQ(), getIsNullable()), this.elementConverter.getCodes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public T[] fromJni(Object value) {
        ArrayConverter<T> arrayConverter = this;
        if (value != null) {
            T[] tArrNewArray = newArray(((List) value).size());
            int i = 0;
            if (this.elementConverter.isPassthrough()) {
                Iterator<T> it = ((Iterable) value).iterator();
                while (it.hasNext()) {
                    tArrNewArray[i] = it.next();
                    i++;
                }
            } else {
                Iterator<T> it2 = ((Iterable) value).iterator();
                while (it2.hasNext()) {
                    tArrNewArray[i] = this.elementConverter.fromJni(it2.next());
                    i++;
                }
            }
            return tArrNewArray;
        }
        if (arrayConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(arrayConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(T[] value) {
        if (this.elementConverter.isPassthrough()) {
            if (value != null) {
                return ArraysKt.toList(value);
            }
            return null;
        }
        if (value == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(value.length);
        for (T t : value) {
            arrayList.add(this.elementConverter.toJni(t));
        }
        return arrayList;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, T[] value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        BinaryBuffer.m12285putIntWPjWIpM(buf, value.length);
        for (T t : value) {
            this.elementConverter.mo12333writeToBufferuOnPpUM(buf, t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public T[] mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable() && !BinaryBuffer.m12249getBooleanimpl(buf)) {
            return null;
        }
        int iM12260getIntimpl = BinaryBuffer.m12260getIntimpl(buf);
        T[] tArrNewArray = newArray(iM12260getIntimpl);
        for (int i = 0; i < iM12260getIntimpl; i++) {
            tArrNewArray[i] = this.elementConverter.mo12332readFromBufferR_h_rCc(buf);
        }
        return tArrNewArray;
    }

    private final T[] newArray(int size) {
        Object objNewInstance = Array.newInstance(this.elementClass, size);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of io.github.expo.modules.v2.converters.ArrayConverter>");
        return (T[]) ((Object[]) objNewInstance);
    }
}
