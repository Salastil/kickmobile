package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import io.ktor.util.NioPathKt$$ExternalSyntheticApiModelOutline0;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lio/github/expo/modules/v2/converters/PathConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "Ljava/nio/file/Path;", "isNullable", "", "<init>", "(Z)V", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "()Z", "fromJni", "value", "", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/nio/file/Path;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/nio/file/Path;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PathConverter extends TypeConverter<Path> {
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public /* bridge */ /* synthetic */ Object toJni(Path path) {
        return toJni2(NioPathKt$$ExternalSyntheticApiModelOutline0.m12608m((Object) path));
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM */
    public /* bridge */ /* synthetic */ void mo12333writeToBufferuOnPpUM(ByteBuffer byteBuffer, Path path) {
        m12363writeToBufferuOnPpUM(byteBuffer, NioPathKt$$ExternalSyntheticApiModelOutline0.m12608m((Object) path));
    }

    public PathConverter(boolean z) {
        super(z);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public int[] getCodes() {
        return CppType.m12418toTypeCodespj4Pta4(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12443getSTRINGz4oZPQ(), getIsNullable()));
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Path fromJni(Object value) {
        PathConverter pathConverter = this;
        if (value != null) {
            return Paths.get((String) value, new String[0]);
        }
        if (pathConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(pathConverter.getCodes())) + " bridge value arrived as null");
    }

    /* JADX INFO: renamed from: toJni, reason: avoid collision after fix types in other method */
    public Object toJni2(Path value) {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name */
    public void m12363writeToBufferuOnPpUM(ByteBuffer buf, Path value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        BinaryBuffer.m12293putStringWPjWIpM(buf, value.toString());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc, reason: avoid collision after fix types in other method */
    public Path mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            return Paths.get(BinaryBuffer.m12271getStringimpl(buf), new String[0]);
        }
        return null;
    }
}
