package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: DurationConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\b\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\b\u0012J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lio/github/expo/modules/v2/converters/DurationConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "Lkotlin/time/Duration;", "isNullable", "", "<init>", "(Z)V", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "()Z", "fromJni", "value", "", "fromJni-LV8wdWc", "toJni", "toJni-BwNAW2A", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-W7fVSFM", "(Ljava/nio/ByteBuffer;Lkotlin/time/Duration;)V", "readFromBuffer", "readFromBuffer-inQVWxQ", "(Ljava/nio/ByteBuffer;)Lkotlin/time/Duration;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DurationConverter extends TypeConverter<Duration> {
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    public DurationConverter(boolean z) {
        super(z);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public int[] getCodes() {
        if (getIsNullable()) {
            return CppType.m12418toTypeCodespj4Pta4(CppType.m12412nullableIpqU398(CppType.INSTANCE.m12424getBOX_DOUBLEz4oZPQ(), true));
        }
        return CppType.m12418toTypeCodespj4Pta4(CppType.INSTANCE.m12429getDOUBLEz4oZPQ());
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: fromJni-LV8wdWc, reason: not valid java name and merged with bridge method [inline-methods] */
    public Duration fromJni(Object value) {
        DurationConverter durationConverter = this;
        if (value != null) {
            return Duration.m14062boximpl(DurationKt.toDuration(((Double) value).doubleValue(), DurationUnit.SECONDS));
        }
        if (durationConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(durationConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: toJni-BwNAW2A, reason: not valid java name and merged with bridge method [inline-methods] */
    public Object toJni(Duration value) {
        if (value != null) {
            return Double.valueOf(Duration.m14100toDoubleimpl(value.getRawValue(), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-W7fVSFM, reason: not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, Duration value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        BinaryBuffer.m12278putDoubleWPjWIpM(buf, Duration.m14100toDoubleimpl(value.getRawValue(), DurationUnit.SECONDS));
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-inQVWxQ, reason: not valid java name and merged with bridge method [inline-methods] */
    public Duration mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!getIsNullable() || BinaryBuffer.m12249getBooleanimpl(buf)) {
            return Duration.m14062boximpl(DurationKt.toDuration(BinaryBuffer.m12253getDoubleimpl(buf), DurationUnit.SECONDS));
        }
        return null;
    }
}
