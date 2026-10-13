package io.ktor.client.plugins.cache.storage;

import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: FileCacheStorage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0010J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0016R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "<init>", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "Lio/ktor/http/Url;", ImagesContract.URL, "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {49}, m = "find", n = {ImagesContract.URL, "varyKeys"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.find(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "findAll", n = {ImagesContract.URL}, s = {"L$0"}, v = 1)
    static final class C09601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09601(Continuation<? super C09601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.findAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$remove$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 1, 1}, l = {65, 66}, m = "remove", n = {ImagesContract.URL, "varyKeys", ImagesContract.URL, "varyKeys"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C09611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09611(Continuation<? super C09611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.remove(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$removeAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0}, l = {70}, m = "removeAll", n = {ImagesContract.URL}, s = {"L$0"}, v = 1)
    static final class C09621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09621(Continuation<? super C09621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.removeAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 1, 1}, l = {43, 44}, m = "store", n = {ImagesContract.URL, "data", ImagesContract.URL, "data"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C09631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09631(Continuation<? super C09631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.store(null, null, this);
        }
    }

    public CachingCacheStorage(CacheStorage delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.store = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        C09631 c09631;
        Url url2;
        Map map;
        if (continuation instanceof C09631) {
            c09631 = (C09631) continuation;
            if ((c09631.label & Integer.MIN_VALUE) != 0) {
                c09631.label -= Integer.MIN_VALUE;
            } else {
                c09631 = new C09631(continuation);
            }
        } else {
            c09631 = new C09631(continuation);
        }
        Object obj = c09631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            c09631.L$0 = url;
            c09631.L$1 = SpillingKt.nullOutSpilledVariable(cachedResponseData);
            c09631.label = 1;
            if (cacheStorage.store(url, cachedResponseData, c09631) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            cachedResponseData = (CachedResponseData) c09631.L$1;
            url = (Url) c09631.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            url2 = (Url) c09631.L$3;
            map = (Map) c09631.L$2;
            ResultKt.throwOnFailure(obj);
        }
        map.put(url2, obj);
        return Unit.INSTANCE;
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
        CacheStorage cacheStorage2 = this.delegate;
        c09631.L$0 = SpillingKt.nullOutSpilledVariable(url);
        c09631.L$1 = SpillingKt.nullOutSpilledVariable(cachedResponseData);
        c09631.L$2 = concurrentMap;
        c09631.L$3 = url;
        c09631.label = 2;
        Object objFindAll = cacheStorage2.findAll(url, c09631);
        if (objFindAll != coroutine_suspended) {
            obj = objFindAll;
            url2 = url;
            map = concurrentMap;
            map.put(url2, obj);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:27:0x0091  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:22:0x007d->B:39:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:? A[LOOP:1: B:28:0x0099->B:40:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        AnonymousClass1 anonymousClass1;
        Map<String, String> map2;
        Map map3;
        Url url2;
        CachedResponseData cachedResponseData;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.store.containsKey(url)) {
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                CacheStorage cacheStorage = this.delegate;
                anonymousClass1.L$0 = url;
                anonymousClass1.L$1 = map;
                anonymousClass1.L$2 = concurrentMap;
                anonymousClass1.L$3 = url;
                anonymousClass1.label = 1;
                Object objFindAll = cacheStorage.findAll(url, anonymousClass1);
                if (objFindAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map2 = map;
                map3 = concurrentMap;
                obj = objFindAll;
                url2 = url;
            }
            for (Object obj2 : (Set) MapsKt.getValue(this.store, url)) {
                cachedResponseData = (CachedResponseData) obj2;
                if (map.isEmpty()) {
                    return obj2;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(entry.getKey()), entry.getValue())) {
                    }
                }
                return obj2;
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        url = (Url) anonymousClass1.L$3;
        map3 = (Map) anonymousClass1.L$2;
        map2 = (Map) anonymousClass1.L$1;
        url2 = (Url) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        map3.put(url, obj);
        url = url2;
        map = map2;
        while (r4.hasNext()) {
            cachedResponseData = (CachedResponseData) obj2;
            if (map.isEmpty()) {
                return obj2;
            }
            while (r0.hasNext()) {
                if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(entry.getKey()), entry.getValue())) {
                }
            }
            return obj2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        C09601 c09601;
        Map map;
        Url url2;
        if (continuation instanceof C09601) {
            c09601 = (C09601) continuation;
            if ((c09601.label & Integer.MIN_VALUE) != 0) {
                c09601.label -= Integer.MIN_VALUE;
            } else {
                c09601 = new C09601(continuation);
            }
        } else {
            c09601 = new C09601(continuation);
        }
        Object obj = c09601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.store.containsKey(url)) {
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                CacheStorage cacheStorage = this.delegate;
                c09601.L$0 = url;
                c09601.L$1 = concurrentMap;
                c09601.L$2 = url;
                c09601.label = 1;
                Object objFindAll = cacheStorage.findAll(url, c09601);
                if (objFindAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = concurrentMap;
                obj = objFindAll;
                url2 = url;
            }
            return MapsKt.getValue(this.store, url);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        url = (Url) c09601.L$2;
        map = (Map) c09601.L$1;
        url2 = (Url) c09601.L$0;
        ResultKt.throwOnFailure(obj);
        map.put(url, obj);
        url = url2;
        return MapsKt.getValue(this.store, url);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, Map<String, String> map, Continuation<? super Unit> continuation) {
        C09611 c09611;
        Url url2;
        Map map2;
        if (continuation instanceof C09611) {
            c09611 = (C09611) continuation;
            if ((c09611.label & Integer.MIN_VALUE) != 0) {
                c09611.label -= Integer.MIN_VALUE;
            } else {
                c09611 = new C09611(continuation);
            }
        } else {
            c09611 = new C09611(continuation);
        }
        Object obj = c09611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            c09611.L$0 = url;
            c09611.L$1 = SpillingKt.nullOutSpilledVariable(map);
            c09611.label = 1;
            if (cacheStorage.remove(url, map, c09611) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            map = (Map) c09611.L$1;
            url = (Url) c09611.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            url2 = (Url) c09611.L$3;
            map2 = (Map) c09611.L$2;
            ResultKt.throwOnFailure(obj);
        }
        map2.put(url2, obj);
        return Unit.INSTANCE;
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
        CacheStorage cacheStorage2 = this.delegate;
        c09611.L$0 = SpillingKt.nullOutSpilledVariable(url);
        c09611.L$1 = SpillingKt.nullOutSpilledVariable(map);
        c09611.L$2 = concurrentMap;
        c09611.L$3 = url;
        c09611.label = 2;
        Object objFindAll = cacheStorage2.findAll(url, c09611);
        if (objFindAll != coroutine_suspended) {
            obj = objFindAll;
            url2 = url;
            map2 = concurrentMap;
            map2.put(url2, obj);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation<? super Unit> continuation) {
        C09621 c09621;
        if (continuation instanceof C09621) {
            c09621 = (C09621) continuation;
            if ((c09621.label & Integer.MIN_VALUE) != 0) {
                c09621.label -= Integer.MIN_VALUE;
            } else {
                c09621 = new C09621(continuation);
            }
        } else {
            c09621 = new C09621(continuation);
        }
        Object obj = c09621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09621.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            c09621.L$0 = url;
            c09621.label = 1;
            if (cacheStorage.removeAll(url, c09621) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            url = (Url) c09621.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.store.remove(url);
        return Unit.INSTANCE;
    }
}
