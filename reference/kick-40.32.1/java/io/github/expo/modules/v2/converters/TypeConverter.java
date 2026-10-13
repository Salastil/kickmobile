package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\r\u001a\u0004\u0018\u00018\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0019J8\u0010\u001a\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u0001*\u00020\u00142\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u00010\u001c¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJJ\u0010 \u001a\u00020\u0012\"\b\b\u0001\u0010\u0001*\u00020\u0002*\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u0001H\u00012\u001d\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00120\"¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$J9\u0010%\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Lio/github/expo/modules/v2/converters/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "isNullable", "", "<init>", "(Z)V", "()Z", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "fromJni", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "readPresent", "readPayload", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "readPresent-uOnPpUM", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writePresent", "writePayload", "Lkotlin/Function2;", "writePresent-i6ZDxrg", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "handleNullable", "convert", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TypeConverter<T> {
    private final boolean isNullable;

    public abstract T fromJni(Object value);

    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public abstract int[] getCodes();

    public abstract boolean isPassthrough();

    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public abstract T mo12332readFromBufferR_h_rCc(ByteBuffer buf);

    public abstract Object toJni(T value);

    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM */
    public abstract void mo12333writeToBufferuOnPpUM(ByteBuffer buf, T value);

    public TypeConverter(boolean z) {
        this.isNullable = z;
    }

    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* JADX INFO: renamed from: readPresent-uOnPpUM, reason: not valid java name */
    public final <T> T m12369readPresentuOnPpUM(ByteBuffer readPresent, Function1<? super BinaryBuffer, ? extends T> readPayload) {
        Intrinsics.checkNotNullParameter(readPresent, "$this$readPresent");
        Intrinsics.checkNotNullParameter(readPayload, "readPayload");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(readPresent)) {
            return readPayload.invoke(BinaryBuffer.m12244boximpl(readPresent));
        }
        return null;
    }

    /* JADX INFO: renamed from: writePresent-i6ZDxrg, reason: not valid java name */
    public final <T> void m12370writePresenti6ZDxrg(ByteBuffer writePresent, T t, Function2<? super BinaryBuffer, ? super T, Unit> writePayload) {
        Intrinsics.checkNotNullParameter(writePresent, "$this$writePresent");
        Intrinsics.checkNotNullParameter(writePayload, "writePayload");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(writePresent, t != null);
            if (t == null) {
                return;
            }
        } else if (t == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        writePayload.invoke(BinaryBuffer.m12244boximpl(writePresent), t);
    }

    public final <T> T handleNullable(Object value, Function1<Object, ? extends T> convert) {
        Intrinsics.checkNotNullParameter(convert, "convert");
        if (value == null) {
            if (getIsNullable()) {
                return null;
            }
            throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(getCodes())) + " bridge value arrived as null");
        }
        return convert.invoke(value);
    }
}
