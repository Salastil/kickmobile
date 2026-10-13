package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.option.KoinOption;

/* JADX INFO: compiled from: OptionRegistry.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u0002H\u000eH\u0000¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lorg/koin/core/registry/OptionRegistry;", "", "<init>", "()V", "options", "Ljava/util/HashMap;", "Lorg/koin/core/option/KoinOption;", "Lkotlin/collections/HashMap;", "setValues", "", "values", "", "setValues$koin_core", "getOrNull", ExifInterface.GPS_DIRECTION_TRUE, "op", "getOrNull$koin_core", "(Lorg/koin/core/option/KoinOption;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "getOrDefault$koin_core", "(Lorg/koin/core/option/KoinOption;Ljava/lang/Object;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionRegistry {
    private final HashMap<KoinOption, Object> options = new HashMap<>();

    public final void setValues$koin_core(Map<KoinOption, ? extends Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.options.putAll(values);
    }

    public final <T> T getOrNull$koin_core(KoinOption op) {
        Intrinsics.checkNotNullParameter(op, "op");
        T t = (T) this.options.get(op);
        if (t == null) {
            return null;
        }
        return t;
    }

    public final <T> T getOrDefault$koin_core(KoinOption op, T t) {
        Intrinsics.checkNotNullParameter(op, "op");
        T t2 = (T) getOrNull$koin_core(op);
        if (t2 == null) {
            t2 = null;
        }
        return t2 == null ? t : t2;
    }
}
