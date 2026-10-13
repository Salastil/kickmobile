package androidx.camera.core.impl;

import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraPresenceProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u0001:\u0003EFGB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010'\u001a\u00020&J\u0016\u0010(\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J$\u0010*\u001a\u00020&2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130,H\u0002J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u001dJ\u000e\u00100\u001a\u00020&2\u0006\u0010/\u001a\u00020\u001dJ\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020&H\u0002J\u001e\u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010;\u001a\u00020&2\u0006\u00102\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020&H\u0002J\u0016\u0010=\u001a\u00020&2\u0006\u0010/\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010@\u001a\u00020&2\u0006\u0010/\u001a\u00020>J\u0016\u0010A\u001a\u00020&2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130,H\u0002J\u0016\u0010C\u001a\u00020&2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0!8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Landroidx/camera/core/impl/CameraPresenceProvider;", "", "backgroundExecutor", "Ljava/util/concurrent/Executor;", "scheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "<init>", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;)V", "observerLock", "retryLock", "retryScanFuture", "Ljava/util/concurrent/ScheduledFuture;", "cameraFactory", "Landroidx/camera/core/impl/CameraFactory;", "cameraRepository", "Landroidx/camera/core/impl/CameraRepository;", "sourcePresenceObservable", "Landroidx/camera/core/impl/Observable;", "", "Landroidx/camera/core/CameraIdentifier;", "cameraValidator", "Landroidx/camera/core/impl/CameraValidator;", "sourceObserver", "Landroidx/camera/core/impl/CameraPresenceProvider$SourceObservableObserver;", "currentFilteredIds", "isMonitoring", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dependentInternalListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/camera/core/impl/InternalCameraPresenceListener;", "publicApiListeners", "Landroidx/camera/core/impl/CameraPresenceProvider$ListenerWrapper;", "cameraStateObservers", "", "", "Landroidx/lifecycle/Observer;", "Landroidx/camera/core/CameraState;", "startup", "", "shutdown", "processFilteredCameraIdUpdate", "newFilteredIdentifiers", "notifyPublicListeners", "addedCameras", "", "removedCameras", "addDependentInternalListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeDependentInternalListener", "conditionallySetupCameraStateObserver", "systemCameraId", "setupCameraStateObserver", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "triggerRefreshWithRetries", "scheduleRetryAttempt", "attemptsLeft", "", "initialIds", "removeCameraStateObserver", "clearAllCameraStateObservers", "addCameraPresenceListener", "Landroidx/camera/core/CameraPresenceListener;", "executor", "removeCameraPresenceListener", "notifyPublicCamerasAdded", "addedIds", "notifyPublicCamerasRemoved", "removedIds", "ListenerWrapper", "SourceObservableObserver", "Companion", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPresenceProvider {
    private static final int MAX_SCAN_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 400;
    private static final String TAG = "CameraPresencePrvdr";
    private final Executor backgroundExecutor;
    private CameraFactory cameraFactory;
    private CameraRepository cameraRepository;
    private final Map<String, Observer<CameraState>> cameraStateObservers;
    private CameraValidator cameraValidator;
    private volatile List<CameraIdentifier> currentFilteredIds;
    private final CopyOnWriteArrayList<InternalCameraPresenceListener> dependentInternalListeners;
    private final AtomicBoolean isMonitoring;
    private final Object observerLock;
    private final CopyOnWriteArrayList<ListenerWrapper> publicApiListeners;
    private final Object retryLock;
    private ScheduledFuture<?> retryScanFuture;
    private final ScheduledExecutorService scheduledExecutor;
    private final SourceObservableObserver sourceObserver;
    private Observable<List<CameraIdentifier>> sourcePresenceObservable;

    public CameraPresenceProvider(Executor backgroundExecutor, ScheduledExecutorService scheduledExecutor) {
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(scheduledExecutor, "scheduledExecutor");
        this.backgroundExecutor = backgroundExecutor;
        this.scheduledExecutor = scheduledExecutor;
        this.observerLock = new Object();
        this.retryLock = new Object();
        this.sourceObserver = new SourceObservableObserver();
        this.currentFilteredIds = CollectionsKt.emptyList();
        this.isMonitoring = new AtomicBoolean(false);
        this.dependentInternalListeners = new CopyOnWriteArrayList<>();
        this.publicApiListeners = new CopyOnWriteArrayList<>();
        this.cameraStateObservers = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CameraPresenceProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/camera/core/impl/CameraPresenceProvider$ListenerWrapper;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/core/CameraPresenceListener;", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Landroidx/camera/core/CameraPresenceListener;Ljava/util/concurrent/Executor;)V", "getListener", "()Landroidx/camera/core/CameraPresenceListener;", "getExecutor", "()Ljava/util/concurrent/Executor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class ListenerWrapper {
        private final Executor executor;
        private final CameraPresenceListener listener;

        public static /* synthetic */ ListenerWrapper copy$default(ListenerWrapper listenerWrapper, CameraPresenceListener cameraPresenceListener, Executor executor, int i, Object obj) {
            if ((i & 1) != 0) {
                cameraPresenceListener = listenerWrapper.listener;
            }
            if ((i & 2) != 0) {
                executor = listenerWrapper.executor;
            }
            return listenerWrapper.copy(cameraPresenceListener, executor);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraPresenceListener getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Executor getExecutor() {
            return this.executor;
        }

        public final ListenerWrapper copy(CameraPresenceListener listener, Executor executor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(executor, "executor");
            return new ListenerWrapper(listener, executor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListenerWrapper)) {
                return false;
            }
            ListenerWrapper listenerWrapper = (ListenerWrapper) other;
            return Intrinsics.areEqual(this.listener, listenerWrapper.listener) && Intrinsics.areEqual(this.executor, listenerWrapper.executor);
        }

        public int hashCode() {
            return (this.listener.hashCode() * 31) + this.executor.hashCode();
        }

        public String toString() {
            return "ListenerWrapper(listener=" + this.listener + ", executor=" + this.executor + ')';
        }

        public ListenerWrapper(CameraPresenceListener listener, Executor executor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.listener = listener;
            this.executor = executor;
        }

        public final Executor getExecutor() {
            return this.executor;
        }

        public final CameraPresenceListener getListener() {
            return this.listener;
        }
    }

    public final void startup(CameraValidator cameraValidator, CameraFactory cameraFactory, CameraRepository cameraRepository) {
        Intrinsics.checkNotNullParameter(cameraValidator, "cameraValidator");
        Intrinsics.checkNotNullParameter(cameraFactory, "cameraFactory");
        Intrinsics.checkNotNullParameter(cameraRepository, "cameraRepository");
        if (this.isMonitoring.compareAndSet(false, true)) {
            Logger.i(TAG, "Starting CameraPresenceProvider monitoring.");
            this.cameraValidator = cameraValidator;
            Set<String> availableCameraIds = cameraFactory.getAvailableCameraIds();
            Intrinsics.checkNotNullExpressionValue(availableCameraIds, "getAvailableCameraIds(...)");
            Set<String> set = availableCameraIds;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            for (String str : set) {
                Intrinsics.checkNotNull(str);
                arrayList.add(CameraIdentifier.Factory.create$default(str, null, null, 6, null));
            }
            this.currentFilteredIds = arrayList;
            this.cameraFactory = cameraFactory;
            this.cameraRepository = cameraRepository;
            this.sourcePresenceObservable = cameraFactory.getCameraPresenceSource();
            this.backgroundExecutor.execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPresenceProvider.startup$lambda$1(this.f$0);
                }
            });
            Observable<List<CameraIdentifier>> observable = this.sourcePresenceObservable;
            if (observable != null) {
                observable.addObserver(CameraXExecutors.newSequentialExecutor(this.backgroundExecutor), this.sourceObserver);
            }
        }
    }

    static final void startup$lambda$1(CameraPresenceProvider cameraPresenceProvider) {
        Iterator<T> it = cameraPresenceProvider.currentFilteredIds.iterator();
        while (it.hasNext()) {
            cameraPresenceProvider.conditionallySetupCameraStateObserver(((CameraIdentifier) it.next()).getInternalId());
        }
    }

    public final void shutdown() {
        if (!this.isMonitoring.getAndSet(false)) {
            Logger.d(TAG, "Shutdown called when not monitoring. Ignoring.");
            return;
        }
        Logger.i(TAG, "Shutting down CameraPresenceProvider monitoring.");
        synchronized (this.retryLock) {
            ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.retryScanFuture = null;
            Unit unit = Unit.INSTANCE;
        }
        Observable<List<CameraIdentifier>> observable = this.sourcePresenceObservable;
        if (observable != null) {
            observable.removeObserver(this.sourceObserver);
        }
        clearAllCameraStateObservers();
        this.cameraValidator = null;
        this.dependentInternalListeners.clear();
        this.publicApiListeners.clear();
        this.currentFilteredIds = CollectionsKt.emptyList();
        this.cameraFactory = null;
        this.cameraRepository = null;
    }

    /* JADX INFO: compiled from: CameraPresenceProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/camera/core/impl/CameraPresenceProvider$SourceObservableObserver;", "Landroidx/camera/core/impl/Observable$Observer;", "", "Landroidx/camera/core/CameraIdentifier;", "<init>", "(Landroidx/camera/core/impl/CameraPresenceProvider;)V", "onNewData", "", "rawCameraIdentifiers", "onError", "t", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class SourceObservableObserver implements Observable.Observer<List<? extends CameraIdentifier>> {
        public SourceObservableObserver() {
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public /* bridge */ /* synthetic */ void onNewData(List<? extends CameraIdentifier> list) {
            onNewData2((List<CameraIdentifier>) list);
        }

        /* JADX INFO: renamed from: onNewData, reason: avoid collision after fix types in other method */
        public void onNewData2(List<CameraIdentifier> rawCameraIdentifiers) {
            CameraFactory cameraFactory;
            CameraRepository cameraRepository;
            CameraValidator cameraValidator;
            ArrayList arrayListEmptyList;
            if (!CameraPresenceProvider.this.isMonitoring.get() || (cameraFactory = CameraPresenceProvider.this.cameraFactory) == null || (cameraRepository = CameraPresenceProvider.this.cameraRepository) == null || (cameraValidator = CameraPresenceProvider.this.cameraValidator) == null) {
                return;
            }
            if (rawCameraIdentifiers != null) {
                List<CameraIdentifier> list = rawCameraIdentifiers;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((CameraIdentifier) it.next()).getInternalId());
                }
                arrayListEmptyList = arrayList;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            if (cameraFactory instanceof CameraFactory.Interrogator) {
                try {
                    List list2 = CameraPresenceProvider.this.currentFilteredIds;
                    List<String> availableCameraIds = ((CameraFactory.Interrogator) cameraFactory).getAvailableCameraIds(arrayListEmptyList);
                    Intrinsics.checkNotNullExpressionValue(availableCameraIds, "getAvailableCameraIds(...)");
                    List<String> list3 = availableCameraIds;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (String str : list3) {
                        Intrinsics.checkNotNull(str);
                        arrayList2.add(CameraIdentifier.Factory.create$default(str, null, null, 6, null));
                    }
                    Set<CameraIdentifier> setMinus = SetsKt.minus(CollectionsKt.toSet(list2), (Iterable) CollectionsKt.toSet(arrayList2));
                    if (!setMinus.isEmpty()) {
                        LinkedHashSet<CameraInternal> cameras = cameraRepository.getCameras();
                        Intrinsics.checkNotNullExpressionValue(cameras, "getCameras(...)");
                        if (cameraValidator.isChangeInvalid(cameras, setMinus)) {
                            Logger.w(CameraPresenceProvider.TAG, "Camera removal update invalid. Aborting.");
                            return;
                        }
                    }
                } catch (Exception e) {
                    Logger.w(CameraPresenceProvider.TAG, "Failed to interrogate camera factory. Falling back to full update.", e);
                }
            }
            try {
                cameraFactory.onCameraIdsUpdated(arrayListEmptyList);
                Set<String> availableCameraIds2 = cameraFactory.getAvailableCameraIds();
                Intrinsics.checkNotNullExpressionValue(availableCameraIds2, "getAvailableCameraIds(...)");
                Set<String> set = availableCameraIds2;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                for (String str2 : set) {
                    Intrinsics.checkNotNull(str2);
                    arrayList3.add(CameraIdentifier.Factory.create$default(str2, null, null, 6, null));
                }
                ArrayList arrayList4 = arrayList3;
                if (Intrinsics.areEqual(arrayList4, CameraPresenceProvider.this.currentFilteredIds)) {
                    return;
                }
                CameraPresenceProvider.this.processFilteredCameraIdUpdate(arrayList4);
            } catch (Exception e2) {
                Logger.w(CameraPresenceProvider.TAG, "CameraFactory failed to update. The camera list may be stale until the next update.", e2);
            }
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            if (CameraPresenceProvider.this.isMonitoring.get()) {
                Logger.e(CameraPresenceProvider.TAG, "Error from source camera presence observable. Triggering refresh.", t);
                Observable observable = CameraPresenceProvider.this.sourcePresenceObservable;
                if (observable != null) {
                    observable.fetchData();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processFilteredCameraIdUpdate(List<CameraIdentifier> newFilteredIdentifiers) {
        List list = CollectionsKt.toList(this.currentFilteredIds);
        if (Intrinsics.areEqual(newFilteredIdentifiers, list)) {
            return;
        }
        synchronized (this.retryLock) {
            if (this.retryScanFuture != null) {
                Logger.d(TAG, "Camera list updated. Cancelling any pending retries.");
                ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
                Intrinsics.checkNotNull(scheduledFuture);
                scheduledFuture.cancel(false);
                this.retryScanFuture = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        List list2 = list;
        Set set = CollectionsKt.toSet(list2);
        List<CameraIdentifier> list3 = newFilteredIdentifiers;
        Set set2 = CollectionsKt.toSet(list3);
        Set<CameraIdentifier> setMinus = SetsKt.minus(set2, (Iterable) set);
        Set<CameraIdentifier> setMinus2 = SetsKt.minus(set, (Iterable) set2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList2.add(((CameraIdentifier) it.next()).getInternalId());
        }
        ArrayList arrayList3 = arrayList2;
        try {
            Iterator<T> it2 = setMinus2.iterator();
            while (it2.hasNext()) {
                removeCameraStateObserver(((CameraIdentifier) it2.next()).getInternalId());
            }
            CameraRepository cameraRepository = this.cameraRepository;
            if (cameraRepository != null) {
                Logger.d(TAG, "Updating CameraRepository...");
                cameraRepository.onCamerasUpdated(arrayList3);
                arrayList.add(cameraRepository);
                Logger.d(TAG, "CameraRepository updated successfully.");
            }
            if (!this.dependentInternalListeners.isEmpty()) {
                Logger.d(TAG, "Updating " + this.dependentInternalListeners.size() + " dependent listeners...");
                for (InternalCameraPresenceListener internalCameraPresenceListener : this.dependentInternalListeners) {
                    internalCameraPresenceListener.onCamerasUpdated(arrayList3);
                    Intrinsics.checkNotNull(internalCameraPresenceListener);
                    arrayList.add(internalCameraPresenceListener);
                }
            }
            this.currentFilteredIds = newFilteredIdentifiers;
            Iterator<T> it3 = setMinus.iterator();
            while (it3.hasNext()) {
                conditionallySetupCameraStateObserver(((CameraIdentifier) it3.next()).getInternalId());
            }
            notifyPublicListeners(setMinus, setMinus2);
        } catch (Exception e) {
            Logger.e(TAG, "A core module failed to update. Rolling back changes.", e);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                arrayList4.add(((CameraIdentifier) it4.next()).getInternalId());
            }
            ArrayList arrayList5 = arrayList4;
            for (InternalCameraPresenceListener internalCameraPresenceListener2 : CollectionsKt.asReversedMutable(arrayList)) {
                try {
                    internalCameraPresenceListener2.onCamerasUpdated(arrayList5);
                } catch (Exception e2) {
                    Logger.e(TAG, "Failed to rollback listener: " + internalCameraPresenceListener2, e2);
                }
            }
            Iterator<T> it5 = setMinus2.iterator();
            while (it5.hasNext()) {
                conditionallySetupCameraStateObserver(((CameraIdentifier) it5.next()).getInternalId());
            }
            Iterator<T> it6 = setMinus.iterator();
            while (it6.hasNext()) {
                removeCameraStateObserver(((CameraIdentifier) it6.next()).getInternalId());
            }
        }
    }

    private final void notifyPublicListeners(Set<CameraIdentifier> addedCameras, Set<CameraIdentifier> removedCameras) {
        if (!addedCameras.isEmpty()) {
            Logger.i(TAG, "Notifying " + addedCameras.size() + " cameras added.");
            notifyPublicCamerasAdded(addedCameras);
        }
        if (removedCameras.isEmpty()) {
            return;
        }
        Logger.i(TAG, "Notifying " + removedCameras.size() + " cameras removed.");
        notifyPublicCamerasRemoved(removedCameras);
    }

    public final void addDependentInternalListener(InternalCameraPresenceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dependentInternalListeners.add(listener);
    }

    public final void removeDependentInternalListener(InternalCameraPresenceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dependentInternalListeners.remove(listener);
    }

    private final void conditionallySetupCameraStateObserver(String systemCameraId) {
        CameraRepository cameraRepository = this.cameraRepository;
        if (cameraRepository == null) {
            return;
        }
        try {
            CameraInternal camera = cameraRepository.getCamera(systemCameraId);
            Intrinsics.checkNotNullExpressionValue(camera, "getCamera(...)");
            CameraInfoInternal cameraInfo = camera.getCameraInfo();
            Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfoInternal(...)");
            setupCameraStateObserver(cameraInfo);
        } catch (IllegalArgumentException unused) {
            Logger.w(TAG, "CameraInternal not found for " + systemCameraId + ". Cannot setup state observer.");
        }
    }

    private final void setupCameraStateObserver(final CameraInfoInternal cameraInfoInternal) {
        final String cameraId = cameraInfoInternal.getCameraId();
        Intrinsics.checkNotNullExpressionValue(cameraId, "getCameraId(...)");
        if (this.isMonitoring.get()) {
            synchronized (this.observerLock) {
                if (this.cameraStateObservers.containsKey(cameraId)) {
                    return;
                }
                final Observer<CameraState> observer = new Observer() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda10
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CameraPresenceProvider.setupCameraStateObserver$lambda$0$0(this.f$0, cameraId, (CameraState) obj);
                    }
                };
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraPresenceProvider.setupCameraStateObserver$lambda$0$1(cameraInfoInternal, observer);
                    }
                });
                this.cameraStateObservers.put(cameraId, observer);
                Logger.d(TAG, "Registered state observer for camera: " + cameraId);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCameraStateObserver$lambda$0$0(final CameraPresenceProvider cameraPresenceProvider, String str, CameraState cameraState) {
        if (!cameraPresenceProvider.isMonitoring.get()) {
            Logger.d(TAG, "Ignore camera state change handling since already stop monitoring");
            return;
        }
        if (cameraState.getError() != null) {
            StringBuilder sb = new StringBuilder("Camera ");
            sb.append(str);
            sb.append(" state changed to ");
            sb.append(cameraState.getType());
            sb.append(" with error: ");
            CameraState.StateError error = cameraState.getError();
            sb.append(error != null ? Integer.valueOf(error.getCode()) : null);
            sb.append(". Triggering refresh.");
            Logger.w(TAG, sb.toString());
            cameraPresenceProvider.backgroundExecutor.execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.triggerRefreshWithRetries();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCameraStateObserver$lambda$0$1(CameraInfoInternal cameraInfoInternal, Observer observer) {
        cameraInfoInternal.getCameraState().observeForever(observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerRefreshWithRetries() {
        synchronized (this.retryLock) {
            ScheduledFuture<?> scheduledFuture = this.retryScanFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            Logger.d(TAG, "Starting new refresh-with-retries sequence.");
            scheduleRetryAttempt(3, this.currentFilteredIds);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void scheduleRetryAttempt(final int attemptsLeft, final List<CameraIdentifier> initialIds) {
        if (attemptsLeft > 0 && this.isMonitoring.get()) {
            this.retryScanFuture = this.scheduledExecutor.schedule(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPresenceProvider cameraPresenceProvider = this.f$0;
                    cameraPresenceProvider.backgroundExecutor.execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraPresenceProvider.scheduleRetryAttempt$lambda$0$0(cameraPresenceProvider, list, i);
                        }
                    });
                }
            }, attemptsLeft == 3 ? 0L : RETRY_DELAY_MS, TimeUnit.MILLISECONDS);
        } else if (attemptsLeft <= 0) {
            Logger.w(TAG, "Exhausted all retries for camera list refresh.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRetryAttempt$lambda$0$0(CameraPresenceProvider cameraPresenceProvider, List list, int i) {
        if (cameraPresenceProvider.isMonitoring.get() && Intrinsics.areEqual(cameraPresenceProvider.currentFilteredIds, list)) {
            Logger.d(TAG, "Triggering refresh. Attempts left: " + i);
            Observable<List<CameraIdentifier>> observable = cameraPresenceProvider.sourcePresenceObservable;
            if (observable != null) {
                observable.fetchData();
            }
            cameraPresenceProvider.scheduleRetryAttempt(i - 1, list);
        }
    }

    private final void removeCameraStateObserver(String systemCameraId) {
        synchronized (this.observerLock) {
            final Observer<CameraState> observerRemove = this.cameraStateObservers.remove(systemCameraId);
            CameraRepository cameraRepository = this.cameraRepository;
            if (observerRemove != null && cameraRepository != null) {
                try {
                    final CameraInternal camera = cameraRepository.getCamera(systemCameraId);
                    Intrinsics.checkNotNullExpressionValue(camera, "getCamera(...)");
                    CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraPresenceProvider.removeCameraStateObserver$lambda$0$0(camera, observerRemove);
                        }
                    });
                    Logger.d(TAG, "Removed state observer for: " + systemCameraId);
                } catch (IllegalArgumentException unused) {
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeCameraStateObserver$lambda$0$0(CameraInternal cameraInternal, Observer observer) {
        cameraInternal.getCameraInfo().getCameraState().removeObserver(observer);
    }

    private final void clearAllCameraStateObservers() {
        synchronized (this.observerLock) {
            if (this.cameraStateObservers.isEmpty()) {
                return;
            }
            Map map = MapsKt.toMap(this.cameraStateObservers);
            this.cameraStateObservers.clear();
            Unit unit = Unit.INSTANCE;
            CameraRepository cameraRepository = this.cameraRepository;
            if (cameraRepository != null) {
                LinkedHashSet<CameraInternal> cameras = cameraRepository.getCameras();
                Intrinsics.checkNotNullExpressionValue(cameras, "getCameras(...)");
                ArrayList arrayList = new ArrayList();
                for (CameraInternal cameraInternal : cameras) {
                    CameraInfoInternal cameraInfo = cameraInternal != null ? cameraInternal.getCameraInfo() : null;
                    if (cameraInfo != null) {
                        arrayList.add(cameraInfo);
                    }
                }
                final ArrayList arrayList2 = arrayList;
                Logger.d(TAG, "Clearing all " + map.size() + " state observers.");
                for (Map.Entry entry : map.entrySet()) {
                    final String str = (String) entry.getKey();
                    final Observer observer = (Observer) entry.getValue();
                    CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraPresenceProvider.clearAllCameraStateObservers$lambda$2$0(arrayList2, observer, str);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllCameraStateObservers$lambda$2$0(List list, Observer observer, String str) {
        Object next;
        LiveData<CameraState> cameraState;
        try {
            Iterator it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((CameraInfoInternal) next).getCameraId(), str));
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) next;
            if (cameraInfoInternal == null || (cameraState = cameraInfoInternal.getCameraState()) == null) {
                return;
            }
            cameraState.removeObserver(observer);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void addCameraPresenceListener(final CameraPresenceListener listener, Executor executor) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.publicApiListeners.add(new ListenerWrapper(listener, executor));
        executor.execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                CameraPresenceProvider.addCameraPresenceListener$lambda$0(this.f$0, listener);
            }
        });
    }

    static final void addCameraPresenceListener$lambda$0(CameraPresenceProvider cameraPresenceProvider, CameraPresenceListener cameraPresenceListener) {
        Set<CameraIdentifier> set = CollectionsKt.toSet(cameraPresenceProvider.currentFilteredIds);
        if (set.isEmpty()) {
            return;
        }
        cameraPresenceListener.onCamerasAdded(set);
    }

    public final void removeCameraPresenceListener(final CameraPresenceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt.removeAll((List) this.publicApiListeners, new Function1() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Intrinsics.areEqual(((CameraPresenceProvider.ListenerWrapper) obj).getListener(), listener));
            }
        });
    }

    private final void notifyPublicCamerasAdded(final Set<CameraIdentifier> addedIds) {
        for (final ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPresenceProvider.notifyPublicCamerasAdded$lambda$0$0(listenerWrapper, addedIds);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyPublicCamerasAdded$lambda$0$0(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().onCamerasAdded(set);
    }

    private final void notifyPublicCamerasRemoved(final Set<CameraIdentifier> removedIds) {
        for (final ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.CameraPresenceProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPresenceProvider.notifyPublicCamerasRemoved$lambda$0$0(listenerWrapper, removedIds);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyPublicCamerasRemoved$lambda$0$0(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().onCamerasRemoved(set);
    }
}
