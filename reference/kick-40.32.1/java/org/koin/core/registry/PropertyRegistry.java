package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: PropertyRegistry.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u000eJ)\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0010*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u001b\u0010\u0016\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lorg/koin/core/registry/PropertyRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "<init>", "(Lorg/koin/core/Koin;)V", "get_koin$koin_core", "()Lorg/koin/core/Koin;", "_values", "", "", "saveProperties", "", "properties", "", "saveProperty", ExifInterface.GPS_DIRECTION_TRUE, "key", "value", "saveProperty$koin_core", "(Ljava/lang/String;Ljava/lang/Object;)V", "deleteProperty", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "close", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropertyRegistry {
    private final Koin _koin;
    private final Map<String, Object> _values;

    public PropertyRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        this._values = KoinPlatformTools.INSTANCE.safeHashMap();
    }

    /* JADX INFO: renamed from: get_koin$koin_core, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    public final void saveProperties(Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this._koin.getLogger().debug("load " + properties.size() + " properties");
        this._values.putAll(properties);
    }

    public final <T> void saveProperty$koin_core(String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this._values.put(key, value);
    }

    public final void deleteProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this._values.remove(key);
    }

    public final <T> T getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this._values.get(key);
        if (t == null) {
            return null;
        }
        return t;
    }

    public final void close() {
        this._values.clear();
    }
}
