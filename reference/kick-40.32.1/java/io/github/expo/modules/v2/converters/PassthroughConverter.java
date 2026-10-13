package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0016J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00028\u0000H$¢\u0006\u0004\b\"\u0010\u001dJ\u0019\u0010#\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001a\u001a\u00020\u001bH$¢\u0006\u0004\b$\u0010 R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\n%&'()*+,-.¨\u0006/"}, d2 = {"Lio/github/expo/modules/v2/converters/PassthroughConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/github/expo/modules/v2/converters/TypeConverter;", "kind", "Lio/github/expo/modules/v2/types/CppType;", "isNullable", "", "<init>", "(IZ)V", "getKind-z4oZP-Q", "()I", "I", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "[I", "isPassthrough", "()Z", "fromJni", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "writeValue", "writeValue-uOnPpUM", "readValue", "readValue-R_h_rCc", "Lio/github/expo/modules/v2/converters/BoxedBooleanConverter;", "Lio/github/expo/modules/v2/converters/BoxedDoubleConverter;", "Lio/github/expo/modules/v2/converters/BoxedFloatConverter;", "Lio/github/expo/modules/v2/converters/BoxedIntConverter;", "Lio/github/expo/modules/v2/converters/BoxedLongConverter;", "Lio/github/expo/modules/v2/converters/DynamicConverter;", "Lio/github/expo/modules/v2/converters/JsHandleConverter;", "Lio/github/expo/modules/v2/converters/NonNullablePassthroughConverter;", "Lio/github/expo/modules/v2/converters/StringConverter;", "Lio/github/expo/modules/v2/converters/UnitConverter;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PassthroughConverter<T> extends TypeConverter<T> {
    private final int[] codes;
    private final int kind;

    public /* synthetic */ PassthroughConverter(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public final boolean isPassthrough() {
        return true;
    }

    /* JADX INFO: renamed from: readValue-R_h_rCc */
    protected abstract T mo12336readValueR_h_rCc(ByteBuffer buf);

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public final Object toJni(T value) {
        return value;
    }

    /* JADX INFO: renamed from: writeValue-uOnPpUM */
    protected abstract void mo12337writeValueuOnPpUM(ByteBuffer buf, T value);

    /* JADX INFO: renamed from: getKind-z4oZP-Q, reason: not valid java name and from getter */
    public final int getKind() {
        return this.kind;
    }

    private PassthroughConverter(int i, boolean z) {
        super(z);
        this.kind = i;
        this.codes = CppType.m12418toTypeCodespj4Pta4(CppType.m12412nullableIpqU398(i, z));
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: from getter */
    public final int[] getCodes() {
        return this.codes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public final T fromJni(Object value) {
        PassthroughConverter<T> passthroughConverter = this;
        if (value != 0) {
            return value;
        }
        if (passthroughConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(passthroughConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, T value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        mo12337writeValueuOnPpUM(buf, value);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public T mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            return mo12336readValueR_h_rCc(buf);
        }
        return null;
    }
}
