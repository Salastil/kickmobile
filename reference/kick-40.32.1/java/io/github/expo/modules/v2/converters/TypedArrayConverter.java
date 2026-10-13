package io.github.expo.modules.v2.converters;

import io.github.expo.modules.v2.TypedArray;
import io.github.expo.modules.v2.jsi.JavaScriptObject;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypedArrayConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lio/github/expo/modules/v2/converters/TypedArrayConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "Lio/github/expo/modules/v2/TypedArray;", "isNullable", "", "<init>", "(Z)V", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "()Z", "fromJni", "value", "", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Lio/github/expo/modules/v2/TypedArray;)Ljava/lang/Void;", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Lio/github/expo/modules/v2/TypedArray;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TypedArrayConverter extends TypeConverter<TypedArray> {
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    public TypedArrayConverter(boolean z) {
        super(z);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public int[] getCodes() {
        return CppType.m12418toTypeCodespj4Pta4(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12435getJS_OBJECTz4oZPQ(), getIsNullable()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public TypedArray fromJni(Object value) {
        String str;
        TypedArrayConverter typedArrayConverter = this;
        if (value != null) {
            JavaScriptObject javaScriptObject = (JavaScriptObject) value;
            ByteBuffer arrayBufferViewBytes = javaScriptObject.getArrayBufferViewBytes();
            if (arrayBufferViewBytes == null) {
                if (javaScriptObject.isArrayBuffer()) {
                    str = "an ArrayBuffer";
                } else {
                    str = "another object";
                }
                throw new IllegalArgumentException("Expected a typed array, such as a Uint8Array, or a DataView, but got " + str + ". Pass a view of the buffer, for example `new Uint8Array(buffer)`");
            }
            return new TypedArray(javaScriptObject, arrayBufferViewBytes);
        }
        if (typedArrayConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(typedArrayConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(TypedArray value) {
        if (value != null) {
            return value.getJsObject();
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Void mo12333writeToBufferuOnPpUM(ByteBuffer buf, TypedArray value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        throw new IllegalStateException("A TypedArray is a live JavaScript object and cannot be written to the buffer".toString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public TypedArray mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        throw new IllegalStateException("A TypedArray is a live JavaScript object and cannot be read from the buffer".toString());
    }
}
