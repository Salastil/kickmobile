package io.github.expo.modules.v2.cache;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/github/expo/modules/v2/cache/Cache;", "Key", "", "Value", "<init>", "()V", "store", "Ljava/util/concurrent/ConcurrentHashMap;", "put", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Cache<Key, Value> {
    private final ConcurrentHashMap<Key, Value> store = new ConcurrentHashMap<>();

    public final void put(Key key, Value value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.store.put(key, value);
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.store.get(key);
    }

    public final Value getOrPut(Key key, Function0<? extends Value> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Value value = get(key);
        if (value != null) {
            return value;
        }
        Value valueInvoke = defaultValue.invoke();
        this.store.put(key, valueInvoke);
        return valueInvoke;
    }
}
