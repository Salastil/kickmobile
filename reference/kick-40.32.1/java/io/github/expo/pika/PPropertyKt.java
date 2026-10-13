package io.github.expo.pika;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PProperty.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\b¨\u0006\u0006"}, d2 = {"cast", "Lio/github/expo/pika/PProperty;", "OwnerType", ExifInterface.GPS_DIRECTION_TRUE, "propertyType", "Ljava/lang/Class;", "pika-api"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PPropertyKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <OwnerType, T> PProperty<OwnerType, T> cast(PProperty<OwnerType, ?> pProperty, Class<T> propertyType) {
        Intrinsics.checkNotNullParameter(pProperty, "<this>");
        Intrinsics.checkNotNullParameter(propertyType, "propertyType");
        return pProperty;
    }

    public static /* synthetic */ PProperty cast$default(PProperty pProperty, Class propertyType, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            propertyType = Object.class;
        }
        Intrinsics.checkNotNullParameter(pProperty, "<this>");
        Intrinsics.checkNotNullParameter(propertyType, "propertyType");
        return pProperty;
    }
}
