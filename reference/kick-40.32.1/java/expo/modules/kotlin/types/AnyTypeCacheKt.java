package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnyTypeCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"cachedAnyType", "Lexpo/modules/kotlin/types/AnyType;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/AnyTypeCache;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AnyTypeCacheKt {
    public static final /* synthetic */ <T> AnyType cachedAnyType(AnyTypeCache anyTypeCache) {
        Intrinsics.checkNotNullParameter(anyTypeCache, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
    }
}
