package io.github.expo.modules.v2.records;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodecFor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0006"}, d2 = {"codecFor", "Lio/github/expo/modules/v2/records/RecordCodec;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/records/Record;", "clazz", "Ljava/lang/Class;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CodecForKt {
    public static final /* synthetic */ <T extends Record> RecordCodec<T> codecFor() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return codecFor(Record.class);
    }

    public static final <T extends Record> RecordCodec<T> codecFor(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        RecordType<?> recordTypeTypeFor$react_release = RecordRegistry.INSTANCE.typeFor$react_release((Class<?>) clazz);
        if (recordTypeTypeFor$react_release == null) {
            throw new IllegalArgumentException(clazz.getName() + " has no RecordCodec - annotate it with @io.github.expo.modules.v2.Record");
        }
        RecordCodec<T> codec = recordTypeTypeFor$react_release.getCodec();
        Intrinsics.checkNotNull(codec, "null cannot be cast to non-null type io.github.expo.modules.v2.records.RecordCodec<T of io.github.expo.modules.v2.records.CodecForKt.codecFor>");
        return codec;
    }
}
