package com.datadog.android.core.internal;

import android.app.Application;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.configuration.DataUploadConfiguration;
import com.datadog.android.core.internal.data.upload.DataFlusher;
import com.datadog.android.core.internal.data.upload.DataOkHttpUploader;
import com.datadog.android.core.internal.data.upload.DataUploadScheduler;
import com.datadog.android.core.internal.data.upload.DataUploader;
import com.datadog.android.core.internal.data.upload.DefaultUploadSchedulerStrategy;
import com.datadog.android.core.internal.data.upload.NoOpDataUploader;
import com.datadog.android.core.internal.data.upload.NoOpUploadScheduler;
import com.datadog.android.core.internal.data.upload.UploadScheduler;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.metrics.NoOpMetricsDispatcher;
import com.datadog.android.core.internal.persistence.AbstractStorage;
import com.datadog.android.core.internal.persistence.ConsentAwareStorage;
import com.datadog.android.core.internal.persistence.NoOpStorage;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler;
import com.datadog.android.core.internal.persistence.datastore.DataStoreFileHelper;
import com.datadog.android.core.internal.persistence.datastore.DatastoreFileReader;
import com.datadog.android.core.internal.persistence.datastore.DatastoreFileWriter;
import com.datadog.android.core.internal.persistence.datastore.NoOpDataStoreHandler;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.file.NoOpFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.internal.utils.LockExtKt;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.internal.profiler.BenchmarkSdkUploads;
import com.datadog.android.internal.profiler.GlobalBenchmark;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.security.Encryption;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010R\u001a\u00020SH\u0007J\b\u0010T\u001a\u00020SH\u0002J(\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0018\u0010\\\u001a\u00020?2\u0006\u0010W\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020K2\u0006\u0010`\u001a\u00020aH\u0002J\r\u0010b\u001a\u00020SH\u0001¢\u0006\u0002\bcJ%\u0010d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010f\u0018\u00010e2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0hH\u0000¢\u0006\u0002\biJ\u0016\u0010j\u001a\u00020S2\u0006\u0010k\u001a\u00020l2\u0006\u0010V\u001a\u00020\u001eJ\u0006\u0010m\u001a\u00020nJ\u0012\u0010o\u001a\u00020S2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J4\u0010r\u001a\u00020?2\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010\u0006\u001a\u00020u2\u0006\u0010k\u001a\u00020l2\u0006\u0010V\u001a\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0010\u0010v\u001a\u00020S2\u0006\u0010w\u001a\u00020\u001fH\u0016J\"\u0010x\u001a\u00020S2\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010]\u001a\u00020^2\u0006\u0010k\u001a\u00020lH\u0002J \u0010y\u001a\u00020S2\u0006\u0010z\u001a\u00020u2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~H\u0002J\u0006\u0010\u007f\u001a\u00020SJ\u001a\u0010\u0080\u0001\u001a\u0003H\u0081\u0001\"\t\b\u0000\u0010\u0081\u0001*\u00020\u0007H\u0016¢\u0006\u0002\u0010QJ?\u0010\u0082\u0001\u001a\u00020S2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0h2&\u0010\u0083\u0001\u001a!\u0012\u0016\u0012\u00140f¢\u0006\u000f\b\u0085\u0001\u0012\n\b\u0086\u0001\u0012\u0005\b\b(\u0087\u0001\u0012\u0004\u0012\u00020S0\u0084\u0001H\u0016JS\u0010\u0088\u0001\u001a\u00020S2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0h2:\u0010\u0083\u0001\u001a5\u0012\u0004\u0012\u00020f\u0012$\u0012\"\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020S0\u0084\u0001\u0012\u0004\u0012\u00020S0\u0084\u0001j\u0003`\u008b\u0001\u0012\u0004\u0012\u00020S0\u0089\u0001H\u0016JS\u0010\u008c\u0001\u001a\u00020n2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0h2:\u0010\u0083\u0001\u001a5\u0012\u0004\u0012\u00020f\u0012$\u0012\"\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020S0\u0084\u0001\u0012\u0004\u0012\u00020S0\u0084\u0001j\u0003`\u008b\u0001\u0012\u0004\u0012\u00020S0\u0089\u0001H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010Q¨\u0006\u008e\u0001"}, d2 = {"Lcom/datadog/android/core/internal/SdkFeature;", "Lcom/datadog/android/api/feature/FeatureScope;", "coreFeature", "Lcom/datadog/android/core/internal/CoreFeature;", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "wrappedFeature", "Lcom/datadog/android/api/feature/Feature;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "benchmarkSdkUploads", "Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;", "(Lcom/datadog/android/core/internal/CoreFeature;Lcom/datadog/android/core/internal/ContextProvider;Lcom/datadog/android/api/feature/Feature;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;)V", "getContextProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/ContextProvider;", "getCoreFeature$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/CoreFeature;", "dataStore", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "getDataStore", "()Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "setDataStore", "(Lcom/datadog/android/api/storage/datastore/DataStoreHandler;)V", "eventReceiver", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "getEventReceiver$dd_sdk_android_core_release", "()Ljava/util/concurrent/atomic/AtomicReference;", "featureContext", "", "", "", "getFeatureContext$dd_sdk_android_core_release", "()Ljava/util/Map;", "featureContextLock", "Ljava/util/concurrent/locks/ReadWriteLock;", "getFeatureContextLock$dd_sdk_android_core_release", "()Ljava/util/concurrent/locks/ReadWriteLock;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getFileOrchestrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "setFileOrchestrator$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_core_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "metricsDispatcher", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "getMetricsDispatcher$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "setMetricsDispatcher$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;)V", "processLifecycleMonitor", "Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor;", "getProcessLifecycleMonitor$dd_sdk_android_core_release", "()Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor;", "setProcessLifecycleMonitor$dd_sdk_android_core_release", "(Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor;)V", "storage", "Lcom/datadog/android/core/internal/persistence/Storage;", "getStorage$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/Storage;", "setStorage$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/persistence/Storage;)V", "uploadScheduler", "Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "getUploadScheduler$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "setUploadScheduler$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/data/upload/UploadScheduler;)V", "uploader", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "getUploader$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/data/upload/DataUploader;", "setUploader$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/data/upload/DataUploader;)V", "getWrappedFeature$dd_sdk_android_core_release", "()Lcom/datadog/android/api/feature/Feature;", "clearAllData", "", "createBatchCountBenchmark", "createCustomStorage", "instanceId", "featureName", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "persistenceStrategyFactory", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "createFileStorage", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "createUploader", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "flushStoredData", "flushStoredData$dd_sdk_android_core_release", "getContextFuture", "Ljava/util/concurrent/Future;", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "getContextFuture$dd_sdk_android_core_release", "initialize", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "isInitialized", "", "prepareDataStoreHandler", "encryption", "Lcom/datadog/android/security/Encryption;", "prepareStorage", "dataUploadConfiguration", "Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "sendEvent", "event", "setupMetricsDispatcher", "setupUploader", "feature", "uploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "maxBatchesPerJob", "", "stop", "unwrap", ExifInterface.GPS_DIRECTION_TRUE, "withContext", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "datadogContext", "withWriteContext", "Lkotlin/Function2;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "withWriteContextSync", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdkFeature implements FeatureScope {
    public static final String BATCH_COUNT_METRIC_NAME = "android.benchmark.batch_count";
    public static final String METER_NAME = "dd-sdk-android";
    public static final String NO_EVENT_RECEIVER = "Feature \"%s\" has no event receiver registered, ignoring event.";
    public static final String TRACK_NAME = "track";
    private final BenchmarkSdkUploads benchmarkSdkUploads;
    private final ContextProvider contextProvider;
    private final CoreFeature coreFeature;
    private DataStoreHandler dataStore;
    private final AtomicReference<FeatureEventReceiver> eventReceiver;
    private final Map<String, Object> featureContext;
    private final ReadWriteLock featureContextLock;
    private FileOrchestrator fileOrchestrator;
    private final AtomicBoolean initialized;
    private final InternalLogger internalLogger;
    private MetricsDispatcher metricsDispatcher;
    private ProcessLifecycleMonitor processLifecycleMonitor;
    private Storage storage;
    private UploadScheduler uploadScheduler;
    private DataUploader uploader;
    private final Feature wrappedFeature;

    public SdkFeature(CoreFeature coreFeature, ContextProvider contextProvider, Feature wrappedFeature, InternalLogger internalLogger, BenchmarkSdkUploads benchmarkSdkUploads) {
        Intrinsics.checkNotNullParameter(coreFeature, "coreFeature");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(wrappedFeature, "wrappedFeature");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads, "benchmarkSdkUploads");
        this.coreFeature = coreFeature;
        this.contextProvider = contextProvider;
        this.wrappedFeature = wrappedFeature;
        this.internalLogger = internalLogger;
        this.benchmarkSdkUploads = benchmarkSdkUploads;
        this.dataStore = new NoOpDataStoreHandler();
        this.initialized = new AtomicBoolean(false);
        this.eventReceiver = new AtomicReference<>(null);
        this.storage = new NoOpStorage();
        this.uploader = new NoOpDataUploader();
        this.uploadScheduler = new NoOpUploadScheduler();
        this.fileOrchestrator = new NoOpFileOrchestrator();
        this.metricsDispatcher = new NoOpMetricsDispatcher();
        this.featureContextLock = new ReentrantReadWriteLock();
        this.featureContext = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: getCoreFeature$dd_sdk_android_core_release, reason: from getter */
    public final CoreFeature getCoreFeature() {
        return this.coreFeature;
    }

    /* JADX INFO: renamed from: getContextProvider$dd_sdk_android_core_release, reason: from getter */
    public final ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    /* JADX INFO: renamed from: getWrappedFeature$dd_sdk_android_core_release, reason: from getter */
    public final Feature getWrappedFeature() {
        return this.wrappedFeature;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_core_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    public /* synthetic */ SdkFeature(CoreFeature coreFeature, ContextProvider contextProvider, Feature feature, InternalLogger internalLogger, BenchmarkSdkUploads benchmarkSdkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coreFeature, contextProvider, feature, internalLogger, (i & 16) != 0 ? GlobalBenchmark.INSTANCE.getBenchmarkSdkUploads() : benchmarkSdkUploads);
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public DataStoreHandler getDataStore() {
        return this.dataStore;
    }

    public void setDataStore(DataStoreHandler dataStoreHandler) {
        Intrinsics.checkNotNullParameter(dataStoreHandler, "<set-?>");
        this.dataStore = dataStoreHandler;
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_core_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    public final AtomicReference<FeatureEventReceiver> getEventReceiver$dd_sdk_android_core_release() {
        return this.eventReceiver;
    }

    /* JADX INFO: renamed from: getStorage$dd_sdk_android_core_release, reason: from getter */
    public final Storage getStorage() {
        return this.storage;
    }

    public final void setStorage$dd_sdk_android_core_release(Storage storage) {
        Intrinsics.checkNotNullParameter(storage, "<set-?>");
        this.storage = storage;
    }

    /* JADX INFO: renamed from: getUploader$dd_sdk_android_core_release, reason: from getter */
    public final DataUploader getUploader() {
        return this.uploader;
    }

    public final void setUploader$dd_sdk_android_core_release(DataUploader dataUploader) {
        Intrinsics.checkNotNullParameter(dataUploader, "<set-?>");
        this.uploader = dataUploader;
    }

    /* JADX INFO: renamed from: getUploadScheduler$dd_sdk_android_core_release, reason: from getter */
    public final UploadScheduler getUploadScheduler() {
        return this.uploadScheduler;
    }

    public final void setUploadScheduler$dd_sdk_android_core_release(UploadScheduler uploadScheduler) {
        Intrinsics.checkNotNullParameter(uploadScheduler, "<set-?>");
        this.uploadScheduler = uploadScheduler;
    }

    /* JADX INFO: renamed from: getFileOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getFileOrchestrator() {
        return this.fileOrchestrator;
    }

    public final void setFileOrchestrator$dd_sdk_android_core_release(FileOrchestrator fileOrchestrator) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "<set-?>");
        this.fileOrchestrator = fileOrchestrator;
    }

    /* JADX INFO: renamed from: getMetricsDispatcher$dd_sdk_android_core_release, reason: from getter */
    public final MetricsDispatcher getMetricsDispatcher() {
        return this.metricsDispatcher;
    }

    public final void setMetricsDispatcher$dd_sdk_android_core_release(MetricsDispatcher metricsDispatcher) {
        Intrinsics.checkNotNullParameter(metricsDispatcher, "<set-?>");
        this.metricsDispatcher = metricsDispatcher;
    }

    /* JADX INFO: renamed from: getProcessLifecycleMonitor$dd_sdk_android_core_release, reason: from getter */
    public final ProcessLifecycleMonitor getProcessLifecycleMonitor() {
        return this.processLifecycleMonitor;
    }

    public final void setProcessLifecycleMonitor$dd_sdk_android_core_release(ProcessLifecycleMonitor processLifecycleMonitor) {
        this.processLifecycleMonitor = processLifecycleMonitor;
    }

    /* JADX INFO: renamed from: getFeatureContextLock$dd_sdk_android_core_release, reason: from getter */
    public final ReadWriteLock getFeatureContextLock() {
        return this.featureContextLock;
    }

    public final Map<String, Object> getFeatureContext$dd_sdk_android_core_release() {
        return this.featureContext;
    }

    public final void initialize(Context context, String instanceId) {
        SdkFeature sdkFeature;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        if (this.initialized.get()) {
            return;
        }
        Feature feature = this.wrappedFeature;
        if (feature instanceof StorageBackedFeature) {
            DataUploadConfiguration dataUploadConfiguration = new DataUploadConfiguration(this.coreFeature.getUploadFrequency(), this.coreFeature.getBatchProcessingLevel().getMaxBatchesPerUploadJob());
            DefaultUploadSchedulerStrategy customUploadSchedulerStrategy = this.coreFeature.getCustomUploadSchedulerStrategy();
            if (customUploadSchedulerStrategy == null) {
                customUploadSchedulerStrategy = new DefaultUploadSchedulerStrategy(dataUploadConfiguration);
            }
            sdkFeature = this;
            sdkFeature.storage = sdkFeature.prepareStorage(dataUploadConfiguration, (StorageBackedFeature) this.wrappedFeature, context, instanceId, this.coreFeature.getPersistenceStrategyFactory());
            sdkFeature.wrappedFeature.onInitialize(context);
            sdkFeature.setupUploader((StorageBackedFeature) sdkFeature.wrappedFeature, customUploadSchedulerStrategy, dataUploadConfiguration.getMaxBatchesPerUploadJob$dd_sdk_android_core_release());
        } else {
            sdkFeature = this;
            feature.onInitialize(context);
        }
        if (sdkFeature.wrappedFeature instanceof TrackingConsentProviderCallback) {
            sdkFeature.coreFeature.getTrackingConsentProvider().registerCallback((TrackingConsentProviderCallback) sdkFeature.wrappedFeature);
        }
        sdkFeature.prepareDataStoreHandler(sdkFeature.coreFeature.getLocalDataEncryption());
        sdkFeature.createBatchCountBenchmark();
        sdkFeature.initialized.set(true);
        sdkFeature.uploadScheduler.startScheduling();
    }

    public final boolean isInitialized() {
        return this.initialized.get();
    }

    public final void clearAllData() {
        this.storage.dropAll();
        getDataStore().clearAllData();
    }

    public final void stop() {
        if (this.initialized.get()) {
            this.wrappedFeature.onStop();
            if (this.wrappedFeature instanceof TrackingConsentProviderCallback) {
                this.coreFeature.getTrackingConsentProvider().unregisterCallback((TrackingConsentProviderCallback) this.wrappedFeature);
            }
            this.uploadScheduler.stopScheduling();
            this.uploadScheduler = new NoOpUploadScheduler();
            this.storage = new NoOpStorage();
            setDataStore(new NoOpDataStoreHandler());
            this.uploader = new NoOpDataUploader();
            this.fileOrchestrator = new NoOpFileOrchestrator();
            this.metricsDispatcher = new NoOpMetricsDispatcher();
            Context appContext = this.coreFeature.getAppContext();
            Application application = appContext instanceof Application ? (Application) appContext : null;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this.processLifecycleMonitor);
            }
            this.processLifecycleMonitor = null;
            Lock lockWriteLock = this.featureContextLock.writeLock();
            Intrinsics.checkNotNullExpressionValue(lockWriteLock, "featureContextLock.writeLock()");
            LockExtKt.safeTryWithLock(lockWriteLock, 1L, TimeUnit.SECONDS, this.internalLogger, new Function0<Unit>() { // from class: com.datadog.android.core.internal.SdkFeature.stop.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SdkFeature.this.getFeatureContext$dd_sdk_android_core_release().clear();
                }
            });
            this.initialized.set(false);
        }
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public void withWriteContext(final Set<String> withFeatureContexts, final Function2<? super DatadogContext, ? super Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ConcurrencyExtKt.executeSafe(this.coreFeature.getContextExecutorService$dd_sdk_android_core_release(), "withWriteContext-" + this.wrappedFeature.getName(), this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.SdkFeature$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SdkFeature.withWriteContext$lambda$0(this.f$0, withFeatureContexts, callback);
            }
        });
    }

    static final void withWriteContext$lambda$0(SdkFeature sdkFeature, Set set, Function2 function2) {
        if (sdkFeature.coreFeature.getInitialized().get()) {
            DatadogContext context = sdkFeature.contextProvider.getContext(set);
            function2.invoke(context, sdkFeature.storage.getEventWriteScope(context));
        }
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public void withContext(final Set<String> withFeatureContexts, final Function1<? super DatadogContext, Unit> callback) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ConcurrencyExtKt.executeSafe(this.coreFeature.getContextExecutorService$dd_sdk_android_core_release(), "withContext-" + this.wrappedFeature.getName(), this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.SdkFeature$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SdkFeature.withContext$lambda$1(this.f$0, withFeatureContexts, callback);
            }
        });
    }

    static final void withContext$lambda$1(SdkFeature sdkFeature, Set set, Function1 function1) {
        if (sdkFeature.coreFeature.getInitialized().get()) {
            function1.invoke(sdkFeature.contextProvider.getContext(set));
        }
    }

    public final Future<DatadogContext> getContextFuture$dd_sdk_android_core_release(final Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        return ConcurrencyExtKt.submitSafe(this.coreFeature.getContextExecutorService$dd_sdk_android_core_release(), "getContextFuture-" + this.wrappedFeature.getName(), this.internalLogger, new Callable() { // from class: com.datadog.android.core.internal.SdkFeature$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SdkFeature.getContextFuture$lambda$2(this.f$0, withFeatureContexts);
            }
        });
    }

    static final DatadogContext getContextFuture$lambda$2(SdkFeature sdkFeature, Set set) {
        if (sdkFeature.coreFeature.getInitialized().get()) {
            return sdkFeature.contextProvider.getContext(set);
        }
        return null;
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public boolean withWriteContextSync(final Set<String> withFeatureContexts, final Function2<? super DatadogContext, ? super Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = "withWriteContextSync-" + this.wrappedFeature.getName();
        Boolean bool = (Boolean) ConcurrencyExtKt.getSafe(ConcurrencyExtKt.submitSafe(this.coreFeature.getContextExecutorService$dd_sdk_android_core_release(), str, this.internalLogger, new Callable() { // from class: com.datadog.android.core.internal.SdkFeature$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SdkFeature.withWriteContextSync$lambda$3(this.f$0, withFeatureContexts, callback);
            }
        }), str, this.internalLogger);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    static final Boolean withWriteContextSync$lambda$3(SdkFeature sdkFeature, Set set, Function2 function2) {
        if (!sdkFeature.coreFeature.getInitialized().get()) {
            return false;
        }
        DatadogContext context = sdkFeature.contextProvider.getContext(set);
        function2.invoke(context, sdkFeature.storage.getEventWriteScope(context));
        return true;
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public void sendEvent(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeatureEventReceiver featureEventReceiver = this.eventReceiver.get();
        if (featureEventReceiver == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.SdkFeature.sendEvent.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, SdkFeature.NO_EVENT_RECEIVER, Arrays.copyOf(new Object[]{SdkFeature.this.getWrappedFeature().getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            featureEventReceiver.onReceive(event);
        }
    }

    @Override // com.datadog.android.api.feature.FeatureScope
    public <T extends Feature> T unwrap() {
        T t = (T) this.wrappedFeature;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.datadog.android.core.internal.SdkFeature.unwrap");
        return t;
    }

    private final void createBatchCountBenchmark() {
        this.benchmarkSdkUploads.getMeter("dd-sdk-android").createObservableGauge(BATCH_COUNT_METRIC_NAME, MapsKt.mapOf(TuplesKt.to("track", this.wrappedFeature.getName())), new Function0<Double>() { // from class: com.datadog.android.core.internal.SdkFeature.createBatchCountBenchmark.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(SdkFeature.this.getFileOrchestrator().getFlushableFiles().size());
            }
        });
    }

    private final void setupMetricsDispatcher(DataUploadConfiguration dataUploadConfiguration, FilePersistenceConfig filePersistenceConfig, Context context) {
        BatchMetricsDispatcher batchMetricsDispatcher = new BatchMetricsDispatcher(this.wrappedFeature.getName(), dataUploadConfiguration, filePersistenceConfig, this.internalLogger, this.coreFeature.getTimeProvider());
        if (context instanceof Application) {
            ProcessLifecycleMonitor processLifecycleMonitor = new ProcessLifecycleMonitor(batchMetricsDispatcher);
            this.processLifecycleMonitor = processLifecycleMonitor;
            ((Application) context).registerActivityLifecycleCallbacks(processLifecycleMonitor);
        }
        this.metricsDispatcher = batchMetricsDispatcher;
    }

    private final void setupUploader(StorageBackedFeature feature, UploadSchedulerStrategy uploadSchedulerStrategy, int maxBatchesPerJob) {
        NoOpUploadScheduler noOpUploadScheduler;
        if (this.coreFeature.getIsMainProcess()) {
            this.uploader = createUploader(feature.getRequestFactory());
            noOpUploadScheduler = new DataUploadScheduler(feature.getName(), this.storage, this.uploader, this.contextProvider, this.coreFeature.getNetworkInfoProvider(), this.coreFeature.getSystemInfoProvider(), uploadSchedulerStrategy, maxBatchesPerJob, this.coreFeature.getUploadExecutorService$dd_sdk_android_core_release(), this.internalLogger);
        } else {
            noOpUploadScheduler = new NoOpUploadScheduler();
        }
        this.uploadScheduler = noOpUploadScheduler;
    }

    private final Storage prepareStorage(DataUploadConfiguration dataUploadConfiguration, StorageBackedFeature wrappedFeature, Context context, String instanceId, PersistenceStrategy.Factory persistenceStrategyFactory) {
        FeatureStorageConfiguration storageConfiguration = wrappedFeature.getStorageConfiguration();
        if (persistenceStrategyFactory == null) {
            long windowDurationMs = this.coreFeature.getBatchSize().getWindowDurationMs();
            FilePersistenceConfig filePersistenceConfigBuildFilePersistenceConfig = this.coreFeature.buildFilePersistenceConfig();
            FilePersistenceConfig filePersistenceConfigCopy = filePersistenceConfigBuildFilePersistenceConfig.copy((96 & 1) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.recentDelayMs : windowDurationMs, (96 & 2) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.maxBatchSize : storageConfiguration.getMaxBatchSize(), (96 & 4) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.maxItemSize : storageConfiguration.getMaxItemSize(), (96 & 8) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.maxItemsPerBatch : storageConfiguration.getMaxItemsPerBatch(), (96 & 16) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.oldFileThreshold : storageConfiguration.getOldBatchThreshold(), (96 & 32) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.maxDiskSpace : 0L, (96 & 64) != 0 ? filePersistenceConfigBuildFilePersistenceConfig.cleanupFrequencyThreshold : 0L);
            setupMetricsDispatcher(dataUploadConfiguration, filePersistenceConfigCopy, context);
            return createFileStorage(wrappedFeature.getName(), filePersistenceConfigCopy);
        }
        return createCustomStorage(instanceId, wrappedFeature.getName(), storageConfiguration, persistenceStrategyFactory);
    }

    private final Storage createCustomStorage(String instanceId, String featureName, FeatureStorageConfiguration storageConfiguration, PersistenceStrategy.Factory persistenceStrategyFactory) {
        return new AbstractStorage(instanceId, featureName, persistenceStrategyFactory, this.coreFeature.getPersistenceExecutorService$dd_sdk_android_core_release(), this.internalLogger, storageConfiguration, this.coreFeature.getTrackingConsentProvider());
    }

    private final Storage createFileStorage(String featureName, FilePersistenceConfig filePersistenceConfig) {
        FeatureFileOrchestrator featureFileOrchestrator = new FeatureFileOrchestrator(this.coreFeature.getTrackingConsentProvider(), this.coreFeature.getStorageDir$dd_sdk_android_core_release(), featureName, this.coreFeature.getPersistenceExecutorService$dd_sdk_android_core_release(), filePersistenceConfig, this.internalLogger, this.metricsDispatcher, this.coreFeature.getTimeProvider());
        this.fileOrchestrator = featureFileOrchestrator;
        return new ConsentAwareStorage(this.coreFeature.getPersistenceExecutorService$dd_sdk_android_core_release(), featureFileOrchestrator.getGrantedOrchestrator(), featureFileOrchestrator.getPendingOrchestrator(), BatchFileReaderWriter.INSTANCE.create(this.internalLogger, this.coreFeature.getLocalDataEncryption()), FileReaderWriter.INSTANCE.create(this.internalLogger, this.coreFeature.getLocalDataEncryption()), new FileMover(this.internalLogger), this.internalLogger, filePersistenceConfig, this.metricsDispatcher, featureName, null, 1024, null);
    }

    private final DataUploader createUploader(RequestFactory requestFactory) {
        return new DataOkHttpUploader(requestFactory, this.internalLogger, this.coreFeature.getCallFactory$dd_sdk_android_core_release(), this.coreFeature.getSdkVersion(), this.coreFeature.getAndroidInfoProvider(), GlobalBenchmark.INSTANCE.createExecutionTimer(this.wrappedFeature.getName(), this.coreFeature.getTimeProvider()));
    }

    private final void prepareDataStoreHandler(Encryption encryption) {
        FileReaderWriter fileReaderWriterCreate = FileReaderWriter.INSTANCE.create(this.internalLogger, encryption);
        DataStoreFileHelper dataStoreFileHelper = new DataStoreFileHelper(this.internalLogger);
        String name = this.wrappedFeature.getName();
        File storageDir$dd_sdk_android_core_release = this.coreFeature.getStorageDir$dd_sdk_android_core_release();
        setDataStore(new DataStoreFileHandler(name, this.coreFeature.getPersistenceExecutorService$dd_sdk_android_core_release(), this.internalLogger, new DatastoreFileReader(dataStoreFileHelper, name, storageDir$dd_sdk_android_core_release, this.internalLogger, new TLVBlockFileReader(this.internalLogger, fileReaderWriterCreate, 0, 4, null)), new DatastoreFileWriter(dataStoreFileHelper, name, storageDir$dd_sdk_android_core_release, this.internalLogger, fileReaderWriterCreate)));
    }

    public final void flushStoredData$dd_sdk_android_core_release() {
        new DataFlusher(this.contextProvider, this.fileOrchestrator, BatchFileReaderWriter.INSTANCE.create(this.internalLogger, this.coreFeature.getLocalDataEncryption()), FileReaderWriter.INSTANCE.create(this.internalLogger, this.coreFeature.getLocalDataEncryption()), new FileMover(this.internalLogger), this.wrappedFeature.getName(), this.internalLogger).flush(this.uploader);
    }
}
