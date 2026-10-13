package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: GenericExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a0\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0005\u001a\u001f\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u0004\u0018\u0001H\t2\u0006\u0010\n\u001a\u0002H\t¢\u0006\u0002\u0010\u000b*_\u0010\f\"\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011`\r2<\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u00110\u0012j\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011`\r¨\u0006\u0013"}, d2 = {"isNull", "", "", "isNotNull", "orDefault", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "or", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "DataMap", "Lkotlin/collections/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Ljava/util/HashMap;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class GenericExtensionsKt {
    public static final boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static final boolean isNull(Object obj) {
        return obj == null;
    }

    public static final <T> T or(T t, T t2) {
        return t == null ? t2 : t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> orDefault(Map<K, ? extends V> map) {
        return map == 0 ? new LinkedHashMap() : map;
    }
}
