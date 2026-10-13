package io.ktor.client.plugins.cache.storage;

import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.datadog.trace.api.DDSpanTypes;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.mlkit.common.MlKitException;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.bouncycastle.math.Primes;
import org.slf4j.Logger;

/* JADX INFO: compiled from: FileCacheStorage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0004\b\u0017\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ8\u0010!\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u001e\u0010 \u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001f0\u001eH\u0082H¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b#\u0010\u001dJ&\u0010%\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0082@¢\u0006\u0004\b%\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b'\u0010\u001dJ \u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\nH\u0082@¢\u0006\u0004\b+\u0010,J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010)\u001a\u00020-H\u0082@¢\u0006\u0004\b\u001c\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010/R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00100R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lio/ktor/http/Url;", ImagesContract.URL, "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "key", "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "readCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", ViewProps.TRANSFORM, "updateCache", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCache", "caches", "writeCacheUnsafe", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readCacheUnsafe", "Lio/ktor/utils/io/ByteChannel;", "channel", DDSpanTypes.CACHE, "writeCache", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlinx/coroutines/sync/Mutex;", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class FileCacheStorage implements CacheStorage {
    private final File directory;
    private final CoroutineDispatcher dispatcher;
    private final ConcurrentMap<String, Mutex> mutexes;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0, 0}, l = {268}, m = "deleteCache", n = {"urlHex", "mutex", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.deleteCache(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {268, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE}, m = "readCache", n = {"urlHex", "mutex", "$this$withLock_u24default$iv", "$i$f$withLock", "urlHex", "mutex", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-FileCacheStorage$readCache$2"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C09651 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09651(Continuation<? super C09651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((String) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14}, l = {225, 226, 226, 227, 228, WebmConstants.MkvEbmlElement.TIMESTAMP, 232, 235, WebmConstants.MkvEbmlElement.VOID, 237, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 242, 246, 248}, m = "readCache", n = {"channel", "channel", ImagesContract.URL, "channel", ImagesContract.URL, "channel", ImagesContract.URL, "status", "channel", ImagesContract.URL, "status", "version", "channel", ImagesContract.URL, "status", "version", "headers", "headersCount", "it", "$i$a$-repeat-FileCacheStorage$readCache$4", "channel", ImagesContract.URL, "status", "version", "headers", "key", "headersCount", "it", "$i$a$-repeat-FileCacheStorage$readCache$4", "channel", ImagesContract.URL, "status", "version", "headers", "headersCount", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "headersCount", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "headersCount", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "headersCount", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u243", "headersCount", "varyKeysCount", "$i$a$-buildMap-FileCacheStorage$readCache$varyKeys$1", "it", "$i$a$-repeat-FileCacheStorage$readCache$varyKeys$1$1", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u243", "key", "headersCount", "varyKeysCount", "$i$a$-buildMap-FileCacheStorage$readCache$varyKeys$1", "it", "$i$a$-repeat-FileCacheStorage$readCache$varyKeys$1$1", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", "headersCount", "varyKeysCount", "channel", ImagesContract.URL, "status", "version", "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headersCount", "varyKeysCount", "bodyCount"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "I$1", "I$2", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "I$2", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((ByteReadChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {178, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, m = "readCacheUnsafe", n = {"urlHex", "file", "it", "channel", "$i$a$-use-FileCacheStorage$readCacheUnsafe$2", "urlHex", "file", "it", "channel", "caches", "$i$a$-use-FileCacheStorage$readCacheUnsafe$2", "requestsCount", ContextChain.TAG_INFRA, "urlHex", "file", "it", "channel", "caches", "$i$a$-use-FileCacheStorage$readCacheUnsafe$2", "requestsCount"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C09661 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C09661(Continuation<? super C09661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCacheUnsafe(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 13, 13, 13, 14, 14, 14}, l = {193, 194, 195, 196, 198, 200, 201, 203, 204, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 206, JfifUtil.MARKER_RST0, 209, Primes.SMALL_FACTOR_LIMIT, 212}, m = "writeCache", n = {"channel", DDSpanTypes.CACHE, "channel", DDSpanTypes.CACHE, "channel", DDSpanTypes.CACHE, "channel", DDSpanTypes.CACHE, "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers", "key", "value", "channel", DDSpanTypes.CACHE, "headers", "key", "value", "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers", "key", "value", "channel", DDSpanTypes.CACHE, "headers", "key", "value", "channel", DDSpanTypes.CACHE, "headers", "channel", DDSpanTypes.CACHE, "headers"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C09701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09701(Continuation<? super C09701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.writeCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0}, l = {151}, m = "writeCacheUnsafe", n = {"urlHex", "caches", "channel"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C09711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09711(Continuation<? super C09711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.writeCacheUnsafe(null, null, this);
        }
    }

    public FileCacheStorage(File directory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.directory = directory;
        this.dispatcher = dispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, null);
        directory.mkdirs();
    }

    public /* synthetic */ FileCacheStorage(File file, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {RotationOptions.ROTATE_270, 273, TiffUtil.TIFF_TAG_ORIENTATION}, m = "invokeSuspend", n = {"urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "$i$f$updateCache", "$i$f$withLock", "urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "$i$f$updateCache", "$i$f$withLock", "$i$a$-withLock$default-FileCacheStorage$updateCache$2$iv", "urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "caches$iv", "$i$f$updateCache", "$i$f$withLock", "$i$a$-withLock$default-FileCacheStorage$updateCache$2$iv"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C09692 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CachedResponseData $data;
        final /* synthetic */ Url $url;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09692(Url url, CachedResponseData cachedResponseData, Continuation<? super C09692> continuation) {
            super(2, continuation);
            this.$url = url;
            this.$data = cachedResponseData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new C09692(this.$url, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09692) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0117 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:29:0x0101, B:30:0x0111, B:32:0x0117, B:34:0x012f, B:36:0x0137), top: B:60:0x0101 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x012f A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:29:0x0101, B:30:0x0111, B:32:0x0117, B:34:0x012f, B:36:0x0137), top: B:60:0x0101 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0171  */
        /* JADX WARN: Code duplicated, block: B:64:0x0132 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            String str2;
            int i;
            int i2;
            FileCacheStorage fileCacheStorage;
            Mutex mutex;
            CachedResponseData cachedResponseData;
            Mutex mutex2;
            Mutex mutex3;
            Object cacheUnsafe;
            int i3;
            Mutex mutex4;
            int i4;
            Set set;
            ArrayList arrayList;
            List listPlus;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strKey = FileCacheStorage.this.key(this.$url);
                    FileCacheStorage fileCacheStorage2 = FileCacheStorage.this;
                    CachedResponseData cachedResponseData2 = this.$data;
                    Mutex mutex5 = (Mutex) fileCacheStorage2.mutexes.computeIfAbsent(strKey, FileCacheStorage$updateCache$mutex$1.INSTANCE);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(strKey);
                    this.L$1 = fileCacheStorage2;
                    this.L$2 = strKey;
                    this.L$3 = cachedResponseData2;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(mutex5);
                    this.L$5 = mutex5;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (mutex5.lock(null, this) != coroutine_suspended) {
                        str = strKey;
                        str2 = str;
                        i = 0;
                        i2 = 0;
                        fileCacheStorage = fileCacheStorage2;
                        mutex = mutex5;
                        cachedResponseData = cachedResponseData2;
                        mutex2 = mutex;
                    }
                    return coroutine_suspended;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = this.I$2;
                        i = this.I$1;
                        int i7 = this.I$0;
                        mutex4 = (Mutex) this.L$5;
                        Mutex mutex6 = (Mutex) this.L$4;
                        CachedResponseData cachedResponseData3 = (CachedResponseData) this.L$3;
                        String str3 = (String) this.L$2;
                        FileCacheStorage fileCacheStorage3 = (FileCacheStorage) this.L$1;
                        String str4 = (String) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str2 = str4;
                            fileCacheStorage = fileCacheStorage3;
                            str = str3;
                            cachedResponseData = cachedResponseData3;
                            mutex2 = mutex6;
                            i4 = i6;
                            i3 = i7;
                            cacheUnsafe = obj;
                            try {
                                set = (Set) cacheUnsafe;
                                arrayList = new ArrayList();
                                for (Object obj3 : set) {
                                    Set set2 = set;
                                    if (!Intrinsics.areEqual(((CachedResponseData) obj3).getVaryKeys(), cachedResponseData.getVaryKeys())) {
                                        arrayList.add(obj3);
                                    }
                                    set = set2;
                                }
                                listPlus = CollectionsKt.plus((Collection<? extends CachedResponseData>) arrayList, cachedResponseData);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(fileCacheStorage);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(mutex2);
                                this.L$4 = mutex4;
                                this.L$5 = SpillingKt.nullOutSpilledVariable(set);
                                this.I$0 = i3;
                                this.I$1 = i;
                                this.I$2 = i4;
                                this.label = 3;
                                if (fileCacheStorage.writeCacheUnsafe(str, listPlus, this) != coroutine_suspended) {
                                    mutex3 = mutex4;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th) {
                                th = th;
                                mutex3 = mutex4;
                                obj2 = null;
                                mutex3.unlock(obj2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mutex3 = mutex4;
                        }
                    } else {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex3 = (Mutex) this.L$4;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    obj2 = null;
                    mutex3.unlock(obj2);
                    throw th;
                }
                i = this.I$1;
                i2 = this.I$0;
                mutex = (Mutex) this.L$5;
                mutex2 = (Mutex) this.L$4;
                cachedResponseData = (CachedResponseData) this.L$3;
                str = (String) this.L$2;
                fileCacheStorage = (FileCacheStorage) this.L$1;
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    Unit unit = Unit.INSTANCE;
                    mutex3.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    obj2 = null;
                    mutex3.unlock(obj2);
                    throw th;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                this.L$1 = fileCacheStorage;
                this.L$2 = str;
                this.L$3 = cachedResponseData;
                this.L$4 = SpillingKt.nullOutSpilledVariable(mutex2);
                this.L$5 = mutex;
                this.I$0 = i2;
                this.I$1 = i;
                this.I$2 = 0;
                this.label = 2;
                cacheUnsafe = fileCacheStorage.readCacheUnsafe(str, this);
                if (cacheUnsafe != coroutine_suspended) {
                    i3 = i2;
                    mutex4 = mutex;
                    i4 = 0;
                    set = (Set) cacheUnsafe;
                    arrayList = new ArrayList();
                    while (r14.hasNext()) {
                        Set set3 = set;
                        if (!Intrinsics.areEqual(((CachedResponseData) obj3).getVaryKeys(), cachedResponseData.getVaryKeys())) {
                            arrayList.add(obj3);
                        }
                        set = set3;
                    }
                    listPlus = CollectionsKt.plus((Collection<? extends CachedResponseData>) arrayList, cachedResponseData);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(fileCacheStorage);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(mutex2);
                    this.L$4 = mutex4;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(set);
                    this.I$0 = i3;
                    this.I$1 = i;
                    this.I$2 = i4;
                    this.label = 3;
                    if (fileCacheStorage.writeCacheUnsafe(str, listPlus, this) != coroutine_suspended) {
                        mutex3 = mutex4;
                        Unit unit2 = Unit.INSTANCE;
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                mutex3 = mutex;
                obj2 = null;
                mutex3.unlock(obj2);
                throw th;
            }
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09692(url, cachedResponseData, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$2", f = "FileCacheStorage.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends CachedResponseData>>, Object> {
        final /* synthetic */ Url $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09642(Url url, Continuation<? super C09642> continuation) {
            super(2, continuation);
            this.$url = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new C09642(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends CachedResponseData>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Set<CachedResponseData>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<CachedResponseData>> continuation) {
            return ((C09642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FileCacheStorage fileCacheStorage = FileCacheStorage.this;
                this.label = 1;
                obj = fileCacheStorage.readCache(fileCacheStorage.key(this.$url), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return CollectionsKt.toSet((Iterable) obj);
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C09642(url, null), continuation);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$find$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$find$2", f = "FileCacheStorage.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CachedResponseData>, Object> {
        final /* synthetic */ Url $url;
        final /* synthetic */ Map<String, String> $varyKeys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Url url, Map<String, String> map, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = url;
            this.$varyKeys = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new AnonymousClass2(this.$url, this.$varyKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CachedResponseData> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FileCacheStorage fileCacheStorage = FileCacheStorage.this;
                this.label = 1;
                obj = fileCacheStorage.readCache(fileCacheStorage.key(this.$url), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Map<String, String> map = this.$varyKeys;
            for (Object obj2 : (Set) obj) {
                CachedResponseData cachedResponseData = (CachedResponseData) obj2;
                if (map.isEmpty()) {
                    return obj2;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(key), entry.getValue())) {
                    }
                }
                return obj2;
            }
            return null;
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(url, map, null), continuation);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$2", f = "FileCacheStorage.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {RotationOptions.ROTATE_270, 273, TiffUtil.TIFF_TAG_ORIENTATION}, m = "invokeSuspend", n = {"urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "$i$f$updateCache", "$i$f$withLock", "urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "$i$f$updateCache", "$i$f$withLock", "$i$a$-withLock$default-FileCacheStorage$updateCache$2$iv", "urlHex", "this_$iv", "urlHex$iv", "mutex$iv", "$this$withLock_u24default$iv$iv", "caches$iv", "$i$f$updateCache", "$i$f$withLock", "$i$a$-withLock$default-FileCacheStorage$updateCache$2$iv"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C09672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Url $url;
        final /* synthetic */ Map<String, String> $varyKeys;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09672(Url url, Map<String, String> map, Continuation<? super C09672> continuation) {
            super(2, continuation);
            this.$url = url;
            this.$varyKeys = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new C09672(this.$url, this.$varyKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0116 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:29:0x0100, B:30:0x0110, B:32:0x0116, B:34:0x0128, B:36:0x012e), top: B:58:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x0128 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:29:0x0100, B:30:0x0110, B:32:0x0116, B:34:0x0128, B:36:0x012e), top: B:58:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0160  */
        /* JADX WARN: Code duplicated, block: B:64:0x012b A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            String str2;
            int i;
            int i2;
            FileCacheStorage fileCacheStorage;
            Mutex mutex;
            Map<String, String> map;
            Mutex mutex2;
            Mutex mutex3;
            Object cacheUnsafe;
            int i3;
            Mutex mutex4;
            int i4;
            ArrayList arrayList;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strKey = FileCacheStorage.this.key(this.$url);
                    FileCacheStorage fileCacheStorage2 = FileCacheStorage.this;
                    Map<String, String> map2 = this.$varyKeys;
                    Mutex mutex5 = (Mutex) fileCacheStorage2.mutexes.computeIfAbsent(strKey, FileCacheStorage$updateCache$mutex$1.INSTANCE);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(strKey);
                    this.L$1 = fileCacheStorage2;
                    this.L$2 = strKey;
                    this.L$3 = map2;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(mutex5);
                    this.L$5 = mutex5;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (mutex5.lock(null, this) != coroutine_suspended) {
                        str = strKey;
                        str2 = str;
                        i = 0;
                        i2 = 0;
                        fileCacheStorage = fileCacheStorage2;
                        mutex = mutex5;
                        map = map2;
                        mutex2 = mutex;
                    }
                    return coroutine_suspended;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = this.I$2;
                        i = this.I$1;
                        int i7 = this.I$0;
                        mutex4 = (Mutex) this.L$5;
                        Mutex mutex6 = (Mutex) this.L$4;
                        Map<String, String> map3 = (Map) this.L$3;
                        String str3 = (String) this.L$2;
                        FileCacheStorage fileCacheStorage3 = (FileCacheStorage) this.L$1;
                        String str4 = (String) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str2 = str4;
                            fileCacheStorage = fileCacheStorage3;
                            str = str3;
                            map = map3;
                            mutex2 = mutex6;
                            i4 = i6;
                            i3 = i7;
                            cacheUnsafe = obj;
                            try {
                                Set set = (Set) cacheUnsafe;
                                arrayList = new ArrayList();
                                for (Object obj3 : set) {
                                    if (!Intrinsics.areEqual(((CachedResponseData) obj3).getVaryKeys(), map)) {
                                        arrayList.add(obj3);
                                    }
                                }
                                this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(fileCacheStorage);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(mutex2);
                                this.L$4 = mutex4;
                                this.L$5 = SpillingKt.nullOutSpilledVariable(set);
                                this.I$0 = i3;
                                this.I$1 = i;
                                this.I$2 = i4;
                                this.label = 3;
                                if (fileCacheStorage.writeCacheUnsafe(str, arrayList, this) != coroutine_suspended) {
                                    mutex3 = mutex4;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th) {
                                th = th;
                                mutex3 = mutex4;
                                obj2 = null;
                                mutex3.unlock(obj2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mutex3 = mutex4;
                        }
                    } else {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex3 = (Mutex) this.L$4;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    obj2 = null;
                    mutex3.unlock(obj2);
                    throw th;
                }
                i = this.I$1;
                i2 = this.I$0;
                mutex = (Mutex) this.L$5;
                mutex2 = (Mutex) this.L$4;
                map = (Map) this.L$3;
                str = (String) this.L$2;
                fileCacheStorage = (FileCacheStorage) this.L$1;
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    Unit unit = Unit.INSTANCE;
                    mutex3.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    obj2 = null;
                    mutex3.unlock(obj2);
                    throw th;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                this.L$1 = fileCacheStorage;
                this.L$2 = str;
                this.L$3 = map;
                this.L$4 = SpillingKt.nullOutSpilledVariable(mutex2);
                this.L$5 = mutex;
                this.I$0 = i2;
                this.I$1 = i;
                this.I$2 = 0;
                this.label = 2;
                cacheUnsafe = fileCacheStorage.readCacheUnsafe(str, this);
                if (cacheUnsafe != coroutine_suspended) {
                    i3 = i2;
                    mutex4 = mutex;
                    i4 = 0;
                    Set set2 = (Set) cacheUnsafe;
                    arrayList = new ArrayList();
                    while (r14.hasNext()) {
                        if (!Intrinsics.areEqual(((CachedResponseData) obj3).getVaryKeys(), map)) {
                            arrayList.add(obj3);
                        }
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(fileCacheStorage);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(mutex2);
                    this.L$4 = mutex4;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(set2);
                    this.I$0 = i3;
                    this.I$1 = i;
                    this.I$2 = i4;
                    this.label = 3;
                    if (fileCacheStorage.writeCacheUnsafe(str, arrayList, this) != coroutine_suspended) {
                        mutex3 = mutex4;
                        Unit unit2 = Unit.INSTANCE;
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                mutex3 = mutex;
                obj2 = null;
                mutex3.unlock(obj2);
                throw th;
            }
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, Map<String, String> map, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09672(url, map, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$removeAll$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$removeAll$2", f = "FileCacheStorage.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"urlHex"}, s = {"L$0"}, v = 1)
    static final class C09682 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Url $url;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09682(Url url, Continuation<? super C09682> continuation) {
            super(2, continuation);
            this.$url = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileCacheStorage.this.new C09682(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09682) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strKey = FileCacheStorage.this.key(this.$url);
                this.L$0 = SpillingKt.nullOutSpilledVariable(strKey);
                this.label = 1;
                if (FileCacheStorage.this.deleteCache(strKey, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09682(url, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(StringsKt.encodeToByteArray(url.getUrlString()));
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return CryptoKt.hex(bArrDigest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readCache(String str, Continuation<? super Set<CachedResponseData>> continuation) throws Throwable {
        C09651 c09651;
        Mutex mutexComputeIfAbsent;
        Mutex mutex;
        int i;
        Mutex mutex2;
        if (continuation instanceof C09651) {
            c09651 = (C09651) continuation;
            if ((c09651.label & Integer.MIN_VALUE) != 0) {
                c09651.label -= Integer.MIN_VALUE;
            } else {
                c09651 = new C09651(continuation);
            }
        } else {
            c09651 = new C09651(continuation);
        }
        Object obj = c09651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09651.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutexComputeIfAbsent = this.mutexes.computeIfAbsent(str, new Function0() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MutexKt.Mutex$default(false, 1, null);
                    }
                });
                c09651.L$0 = str;
                c09651.L$1 = SpillingKt.nullOutSpilledVariable(mutexComputeIfAbsent);
                c09651.L$2 = mutexComputeIfAbsent;
                c09651.I$0 = 0;
                c09651.label = 1;
                if (mutexComputeIfAbsent.lock(null, c09651) != coroutine_suspended) {
                    mutex = mutexComputeIfAbsent;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c09651.I$1;
                int i4 = c09651.I$0;
                mutex2 = (Mutex) c09651.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    Set set = (Set) obj;
                    mutex2.unlock(null);
                    return set;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i5 = c09651.I$0;
            Mutex mutex3 = (Mutex) c09651.L$2;
            mutex = (Mutex) c09651.L$1;
            String str2 = (String) c09651.L$0;
            ResultKt.throwOnFailure(obj);
            mutexComputeIfAbsent = mutex3;
            i = i5;
            str = str2;
            c09651.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c09651.L$1 = SpillingKt.nullOutSpilledVariable(mutex);
            c09651.L$2 = mutexComputeIfAbsent;
            c09651.I$0 = i;
            c09651.I$1 = 0;
            c09651.label = 2;
            Object cacheUnsafe = readCacheUnsafe(str, c09651);
            if (cacheUnsafe != coroutine_suspended) {
                Mutex mutex4 = mutexComputeIfAbsent;
                obj = cacheUnsafe;
                mutex2 = mutex4;
                Set set2 = (Set) obj;
                mutex2.unlock(null);
                return set2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutexComputeIfAbsent;
            mutex2.unlock(null);
            throw th;
        }
    }

    private final Object updateCache(String str, Function1<? super Set<CachedResponseData>, ? extends List<CachedResponseData>> function1, Continuation<? super Unit> continuation) {
        Mutex mutex = (Mutex) this.mutexes.computeIfAbsent(str, FileCacheStorage$updateCache$mutex$1.INSTANCE);
        mutex.lock(null, continuation);
        try {
            writeCacheUnsafe(str, function1.invoke((Set) readCacheUnsafe(str, null)), null);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object deleteCache(String str, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex mutexComputeIfAbsent;
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
            mutexComputeIfAbsent = this.mutexes.computeIfAbsent(str, new Function0() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MutexKt.Mutex$default(false, 1, null);
                }
            });
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(mutexComputeIfAbsent);
            anonymousClass1.L$2 = mutexComputeIfAbsent;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            if (mutexComputeIfAbsent.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            Mutex mutex = (Mutex) anonymousClass1.L$2;
            String str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutexComputeIfAbsent = mutex;
            str = str2;
        }
        try {
            File file = new File(this.directory, str);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    Logger logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Exception during cache deletion in a file: " + ExceptionsKt.stackTraceToString(e));
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            mutexComputeIfAbsent.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutexComputeIfAbsent.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[Catch: all -> 0x0039, TryCatch #3 {all -> 0x0039, blocks: (B:12:0x0035, B:30:0x0080, B:32:0x0084, B:33:0x008b, B:35:0x0095), top: B:41:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0095 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #3 {all -> 0x0039, blocks: (B:12:0x0035, B:30:0x0080, B:32:0x0084, B:33:0x008b, B:35:0x0095), top: B:41:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0095, please report this as an issue */
    public final Object writeCacheUnsafe(String str, List<CachedResponseData> list, Continuation<? super Unit> continuation) throws Throwable {
        C09711 c09711;
        Throwable th;
        ByteChannel byteChannel;
        Exception exc;
        Logger logger;
        if (continuation instanceof C09711) {
            c09711 = (C09711) continuation;
            if ((c09711.label & Integer.MIN_VALUE) != 0) {
                c09711.label -= Integer.MIN_VALUE;
            } else {
                c09711 = new C09711(continuation);
            }
        } else {
            c09711 = new C09711(continuation);
        }
        C09711 c09712 = c09711;
        Object obj = c09712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09712.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ByteChannel byteChannel2 = new ByteChannel(false, 1, null);
            try {
                C09722 c09722 = new C09722(str, byteChannel2, list, null);
                c09712.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c09712.L$1 = SpillingKt.nullOutSpilledVariable(list);
                c09712.L$2 = byteChannel2;
                c09712.label = 1;
                if (CoroutineScopeKt.coroutineScope(c09722, c09712) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteChannel = byteChannel2;
            } catch (Exception e) {
                exc = e;
                byteChannel = byteChannel2;
                if (exc instanceof CancellationException) {
                    JobKt.ensureActive(c09712.getContext());
                }
                logger = HttpCacheKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(exc));
                }
            } catch (Throwable th2) {
                th = th2;
                byteChannel = byteChannel2;
                byteChannel.close();
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannel = (ByteChannel) c09712.L$2;
            try {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    exc = e2;
                    if (exc instanceof CancellationException) {
                        JobKt.ensureActive(c09712.getContext());
                    }
                    logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(exc));
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteChannel.close();
                throw th;
            }
        }
        byteChannel.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2", f = "FileCacheStorage.kt", i = {0, 0, 0}, l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "invokeSuspend", n = {"$this$coroutineScope", "output", "$i$a$-use-FileCacheStorage$writeCacheUnsafe$2$1"}, s = {"L$0", "L$2", "I$0"}, v = 1)
    static final class C09722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ List<CachedResponseData> $caches;
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ String $urlHex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09722(String str, ByteChannel byteChannel, List<CachedResponseData> list, Continuation<? super C09722> continuation) {
            super(2, continuation);
            this.$urlHex = str;
            this.$channel = byteChannel;
            this.$caches = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09722 c09722 = FileCacheStorage.this.new C09722(this.$urlHex, this.$channel, this.$caches, continuation);
            c09722.L$0 = obj;
            return c09722;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C09722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BufferedOutputStream bufferedOutputStream;
            Object objCopyTo$default;
            Closeable closeable;
            Throwable th;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OutputStream fileOutputStream = new FileOutputStream(new File(FileCacheStorage.this.directory, this.$urlHex));
                bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
                ByteChannel byteChannel = this.$channel;
                try {
                    BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FileCacheStorage$writeCacheUnsafe$2$1$1(byteChannel, this.$caches, FileCacheStorage.this, null), 3, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = bufferedOutputStream;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(bufferedOutputStream2);
                    this.I$0 = 0;
                    this.label = 1;
                    objCopyTo$default = WritingKt.copyTo$default(byteChannel, bufferedOutputStream2, 0L, this, 2, null);
                    if (objCopyTo$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = bufferedOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    objCopyTo$default = obj;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = closeable;
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(bufferedOutputStream, th);
                        throw th4;
                    }
                }
            }
            Long lBoxLong = Boxing.boxLong(((Number) objCopyTo$default).longValue());
            CloseableKt.closeFinally(closeable, null);
            return lBoxLong;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x012f A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:45:0x012f, B:51:0x0177, B:26:0x00a5, B:43:0x011a), top: B:69:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0159  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0159 -> B:49:0x0166). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readCacheUnsafe(java.lang.String r25, kotlin.coroutines.Continuation<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r26) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCacheUnsafe(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x004f A[PHI: r1 r11 r12
      0x004f: PHI (r1v45 io.ktor.utils.io.ByteChannel) = (r1v39 io.ktor.utils.io.ByteChannel), (r1v48 io.ktor.utils.io.ByteChannel) binds: [B:80:0x03d6, B:13:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x004f: PHI (r11v61 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r11v52 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r11v63 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:80:0x03d6, B:13:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x004f: PHI (r12v50 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r12v44 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r12v52 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:80:0x03d6, B:13:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x0138 A[PHI: r11 r12
      0x0138: PHI (r11v12 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r11v9 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r11v15 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:42:0x01f1, B:26:0x012d] A[DONT_GENERATE, DONT_INLINE]
      0x0138: PHI (r12v11 io.ktor.utils.io.ByteChannel) = (r12v8 io.ktor.utils.io.ByteChannel), (r12v14 io.ktor.utils.io.ByteChannel) binds: [B:42:0x01f1, B:26:0x012d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x01d0 A[PHI: r11 r12
      0x01d0: PHI (r11v9 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r11v6 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r11v11 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:39:0x01cc, B:28:0x013c] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r12v8 io.ktor.utils.io.ByteChannel) = (r12v5 io.ktor.utils.io.ByteChannel), (r12v10 io.ktor.utils.io.ByteChannel) binds: [B:39:0x01cc, B:28:0x013c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x0221  */
    /* JADX WARN: Code duplicated, block: B:53:0x0264  */
    /* JADX WARN: Code duplicated, block: B:57:0x029e  */
    /* JADX WARN: Code duplicated, block: B:60:0x02c5 A[PHI: r1 r11 r12
      0x02c5: PHI (r1v23 io.ktor.utils.io.ByteChannel) = (r1v17 io.ktor.utils.io.ByteChannel), (r1v25 io.ktor.utils.io.ByteChannel) binds: [B:58:0x02c1, B:21:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x02c5: PHI (r11v34 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r11v25 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r11v36 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:58:0x02c1, B:21:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x02c5: PHI (r12v28 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r12v22 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r12v30 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:58:0x02c1, B:21:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x02e6 A[PHI: r1 r11 r12
      0x02e6: PHI (r1v26 io.ktor.utils.io.ByteChannel) = (r1v23 io.ktor.utils.io.ByteChannel), (r1v28 io.ktor.utils.io.ByteChannel) binds: [B:61:0x02e2, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r11v37 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r11v34 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r11v39 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:61:0x02e2, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r12v31 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r12v28 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r12v33 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:61:0x02e2, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0305 A[PHI: r1 r11 r12
      0x0305: PHI (r1v29 io.ktor.utils.io.ByteChannel) = (r1v26 io.ktor.utils.io.ByteChannel), (r1v31 io.ktor.utils.io.ByteChannel) binds: [B:64:0x0301, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r11v40 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r11v37 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r11v42 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:64:0x0301, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r12v34 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r12v31 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r12v36 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:64:0x0301, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x0338  */
    /* JADX WARN: Code duplicated, block: B:75:0x037c  */
    /* JADX WARN: Code duplicated, block: B:79:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0213, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r1, r4, r0) == r13) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x029a, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r4, r7, r0) == r13) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0322, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r1, r4, r0) == r13) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x03b3, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r4, r7, r0) == r13) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x03ff, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r0, r1, 0, 0, r4, 6, null) == r13) goto L84;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x0221, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x0338, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x029a -> B:23:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x03b3 -> B:16:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeCache(io.ktor.utils.io.ByteChannel r11, io.ktor.client.plugins.cache.storage.CachedResponseData r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.writeCache(io.ktor.utils.io.ByteChannel, io.ktor.client.plugins.cache.storage.CachedResponseData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0389  */
    /* JADX WARN: Code duplicated, block: B:53:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:57:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x03eb -> B:58:0x03f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0594 -> B:85:0x05a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readCache(io.ktor.utils.io.ByteReadChannel r26, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r27) {
        /*
            Method dump skipped, instruction units count: 1640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCache(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
