package io.github.expo.modules.v2.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiKeyCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u0002¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00018\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u0004\u0018\u00018\u00022\u0006\u0010\r\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/github/expo/modules/v2/cache/MultiKeyCache;", "Key1", "", "Key2", "Value", "<init>", "()V", "byKey1", "Lio/github/expo/modules/v2/cache/Cache;", "byKey2", "put", "", "key1", "key2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "get", "getKey1", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKey2", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiKeyCache<Key1, Key2, Value> {
    private final Cache<Key1, Value> byKey1 = new Cache<>();
    private final Cache<Key2, Value> byKey2 = new Cache<>();

    public final void put(Key1 key1, Key2 key2, Value value) {
        Intrinsics.checkNotNullParameter(key1, "key1");
        Intrinsics.checkNotNullParameter(key2, "key2");
        Intrinsics.checkNotNullParameter(value, "value");
        this.byKey1.put(key1, value);
        this.byKey2.put(key2, value);
    }

    public final Value getKey1(Key1 key1) {
        Intrinsics.checkNotNullParameter(key1, "key1");
        return this.byKey1.get(key1);
    }

    public final Value getKey2(Key2 key2) {
        Intrinsics.checkNotNullParameter(key2, "key2");
        return this.byKey2.get(key2);
    }
}
