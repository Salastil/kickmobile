package com.datadog.trace.api.cache;

import com.datadog.android.internal.network.HttpSpec;
import com.datadog.android.trace.internal.compat.function.IntFunction;
import com.datadog.trace.api.config.ProfilingConfig;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.java_websocket.WebSocketImpl;

/* JADX INFO: loaded from: classes6.dex */
public final class RadixTreeCache<T> {
    public static final RadixTreeCache<UTF8BytesString> HTTP_STATUSES;
    public static final RadixTreeCache<Integer> PORTS;
    private static final IntFunction<UTF8BytesString> TO_STRING;
    public static final int UNSET_PORT = 0;
    public static final int UNSET_STATUS = 0;
    private final int level1;
    private final int level2;
    private final IntFunction<T> mapper;
    private final int mask;
    private final int shift;
    private final AtomicReferenceArray<Object[]> tree;

    static {
        IntFunction<UTF8BytesString> intFunction = new IntFunction() { // from class: com.datadog.trace.api.cache.RadixTreeCache$$ExternalSyntheticLambda1
            @Override // com.datadog.android.trace.internal.compat.function.IntFunction
            public final Object apply(int i) {
                return UTF8BytesString.create(Integer.toString(i));
            }
        };
        TO_STRING = intFunction;
        HTTP_STATUSES = new RadixTreeCache<>(16, 32, intFunction, 200, 201, 301, 307, 400, 401, 403, HttpSpec.StatusCode.NOT_FOUND, 500, 502, 503);
        PORTS = new RadixTreeCache<>(256, 256, new IntFunction() { // from class: com.datadog.trace.api.cache.RadixTreeCache$$ExternalSyntheticLambda2
            @Override // com.datadog.android.trace.internal.compat.function.IntFunction
            public final Object apply(int i) {
                return Integer.valueOf(i);
            }
        }, 80, WebSocketImpl.DEFAULT_WSS_PORT, ProfilingConfig.PROFILING_PROXY_PORT_DEFAULT);
    }

    public RadixTreeCache(int i, int i2, IntFunction<T> intFunction, int... iArr) {
        this.tree = new AtomicReferenceArray<>(i);
        this.mapper = intFunction;
        this.level1 = i;
        this.level2 = i2;
        int i3 = i2 - 1;
        this.mask = i3;
        this.shift = Integer.bitCount(i3);
        for (int i4 : iArr) {
            get(i4);
        }
    }

    public T get(int i) {
        int i2 = i >>> this.shift;
        if (i2 >= this.level1) {
            return this.mapper.apply(i);
        }
        return computeIfAbsent(i2, i);
    }

    private T computeIfAbsent(int i, int i2) {
        Object[] objArr = this.tree.get(i);
        if (objArr == null) {
            objArr = new Object[this.level2];
            if (!RadixTreeCache$$ExternalSyntheticBackportWithForwarding0.m(this.tree, i, null, objArr)) {
                objArr = this.tree.get(i);
            }
        }
        int i3 = this.mask & i2;
        T t = (T) objArr[i3];
        if (t != null) {
            return t;
        }
        T tApply = this.mapper.apply(i2);
        objArr[i3] = tApply;
        return tApply;
    }
}
