package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J'\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001d"}, d2 = {"Lio/github/expo/modules/v2/converters/SetConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "typeDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "<init>", "(Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;)V", "elementConverter", "", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "", "()Z", "fromJni", "value", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/Set;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/util/Set;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetConverter<T> extends TypeConverter<Set<? extends T>> {
    private final TypeConverter<Object> elementConverter;

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetConverter(TypeDescriptor.Parametrized typeDescriptor) {
        super(typeDescriptor.isNullable());
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeConverter<?> converter = typeDescriptor.getParams()[0].getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        this.elementConverter = converter;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public int[] getCodes() {
        return CppType.m12415pluswHJnekk(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12437getLISTz4oZPQ(), getIsNullable()), this.elementConverter.getCodes());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Set<T> fromJni(Object value) {
        SetConverter<T> setConverter = this;
        if (value != null) {
            if (this.elementConverter.isPassthrough()) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<T of io.github.expo.modules.v2.converters.SetConverter>");
                return (Set) CollectionsKt.toCollection((List) value, new HashSet());
            }
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                linkedHashSet.add(this.elementConverter.fromJni(it.next()));
            }
            return linkedHashSet;
        }
        if (setConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(setConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(Set<? extends T> value) {
        if (this.elementConverter.isPassthrough()) {
            if (value != null) {
                return CollectionsKt.toList(value);
            }
            return null;
        }
        if (value == null) {
            return null;
        }
        Set<? extends T> set = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.elementConverter.toJni(it.next()));
        }
        return arrayList;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, Set<? extends T> value) {
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
        Iterator<? extends T> it = value.iterator();
        while (it.hasNext()) {
            this.elementConverter.mo12333writeToBufferuOnPpUM(buf, it.next());
        }
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public Set<T> mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        HashSet hashSet;
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            int iM12260getIntimpl = BinaryBuffer.m12260getIntimpl(buf);
            HashSet hashSet2 = new HashSet(iM12260getIntimpl);
            for (int i = 0; i < iM12260getIntimpl; i++) {
                hashSet2.add(this.elementConverter.mo12332readFromBufferR_h_rCc(buf));
            }
            hashSet = hashSet2;
        } else {
            hashSet = null;
        }
        return hashSet;
    }
}
