package io.github.expo.modules.v2.converters;

import io.github.expo.modules.v2.SharedRef;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedRefConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lio/github/expo/modules/v2/converters/SharedRefConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "Lio/github/expo/modules/v2/SharedRef;", "classId", "Lio/github/expo/modules/v2/sharedobjects/SharedClassId;", "refClass", "Ljava/lang/Class;", "isNullable", "", "<init>", "(ILjava/lang/Class;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "[I", "isPassthrough", "()Z", "fromJni", "value", "", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Lio/github/expo/modules/v2/SharedRef;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Lio/github/expo/modules/v2/SharedRef;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedRefConverter extends TypeConverter<SharedRef<?>> {
    private final int[] codes;
    private final Class<?> refClass;

    public /* synthetic */ SharedRefConverter(int i, Class cls, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, cls, z);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(SharedRef<?> value) {
        return value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private SharedRefConverter(int i, Class<?> refClass, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(refClass, "refClass");
        this.refClass = refClass;
        this.codes = TypeCodes.INSTANCE.m12462ofDWjln38(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12442getSHARED_OBJECTz4oZPQ(), z), i);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: from getter */
    public int[] getCodes() {
        return this.codes;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public SharedRef<?> fromJni(Object value) {
        SharedRefConverter sharedRefConverter = this;
        if (value != null) {
            SharedRef<?> sharedRef = (SharedRef) value;
            if (this.refClass.isInstance(sharedRef.getRef())) {
                return sharedRef;
            }
            throw new IllegalArgumentException("Expected a SharedRef<" + this.refClass.getSimpleName() + ">, got " + sharedRef.getClass().getSimpleName() + " carrying a " + sharedRef.getRef().getClass().getSimpleName());
        }
        if (sharedRefConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(sharedRefConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, SharedRef<?> value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        throw new IllegalStateException(("No typed encoding for a shared ref (SharedRef<" + this.refClass.getName() + ">)").toString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public SharedRef<?> mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        throw new IllegalStateException(("No typed decoding for a shared ref (SharedRef<" + this.refClass.getName() + ">)").toString());
    }
}
