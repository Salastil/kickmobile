package androidx.compose.runtime.snapshots;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001:\u0001>B0\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001d\u0010#\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001d\u0010%\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100\u0003H\u0082\bJ?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010-*\u00020\u00012\u0006\u0010.\u001a\u0002H-2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u00100J/\u00101\u001a\u0002H-\"\u0004\b\u0000\u0010-2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H-0\u0004H\u0082\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u000e\u00104\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0001J)\u00105\u001a\u00020\u00052!\u00106\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00100\u0003J\u0006\u00107\u001a\u00020\u0005J\u0006\u00108\u001a\u00020\u0005J\u001e\u00109\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010;\u001a\u00020\u0014H\u0007J\u0006\u00104\u001a\u00020\u0005J&\u0010<\u001a\u00020\u001f\"\b\b\u0000\u0010-*\u00020\u00012\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u0003H\u0002R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00060\u0001j\u0002`!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "drainChanges", "sendNotifications", "addChanges", "set", "removeChanges", "report", "", "readObserver", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "observedScopeMapsLock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "forEachScopeMap", "block", "removeScopeMapIf", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "currentMapThreadId", "", "observeReads", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "withScopeMapLock", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNoObservations", "clear", "clearIf", "predicate", ViewProps.START, "stop", "notifyChanges", "changes", "snapshot", "ensureMap", "onChanged", "ObservedScopeMap", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SnapshotStateObserver.applyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SnapshotStateObserver.readObserver$lambda$0(this.f$0, obj);
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Object observedScopeMapsLock = new Object();
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    static final Unit applyObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Set set, Snapshot snapshot) {
        snapshotStateObserver.addChanges(set);
        if (snapshotStateObserver.drainChanges()) {
            snapshotStateObserver.sendNotifications();
        }
        return Unit.INSTANCE;
    }

    private final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMapsLock) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMapsLock) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    z2 = observedScopeMapArr[i].recordInvalidation(setRemoveChanges) || z2;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SnapshotStateObserver.sendNotifications$lambda$0(this.f$0);
            }
        });
    }

    static final Unit sendNotifications$lambda$0(SnapshotStateObserver snapshotStateObserver) {
        do {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                if (!snapshotStateObserver.sendingNotifications) {
                    snapshotStateObserver.sendingNotifications = true;
                    try {
                        MutableVector<ObservedScopeMap> mutableVector = snapshotStateObserver.observedScopeMaps;
                        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                        int size = mutableVector.getSize();
                        for (int i = 0; i < size; i++) {
                            observedScopeMapArr[i].notifyInvalidatedScopes();
                        }
                        snapshotStateObserver.sendingNotifications = false;
                    } catch (Throwable th) {
                        snapshotStateObserver.sendingNotifications = false;
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } while (snapshotStateObserver.drainChanges());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    static final Unit readObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Object obj) {
        if (!snapshotStateObserver.isPaused) {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                block.invoke(observedScopeMapArr[i]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (block.invoke(mutableVector.content[i2]).booleanValue()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0127  */
    /* JADX WARN: Code duplicated, block: B:53:0x013b A[Catch: all -> 0x01a7, TryCatch #4 {all -> 0x01a7, blocks: (B:35:0x00fb, B:40:0x0110, B:41:0x011b, B:48:0x012e, B:51:0x0133, B:53:0x013b, B:55:0x0141), top: B:120:0x00be }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0141 A[Catch: all -> 0x01a7, TRY_LEAVE, TryCatch #4 {all -> 0x01a7, blocks: (B:35:0x00fb, B:40:0x0110, B:41:0x011b, B:48:0x012e, B:51:0x0133, B:53:0x013b, B:55:0x0141), top: B:120:0x00be }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v9 */
    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        boolean z;
        ObservedScopeMap observedScopeMap;
        long j;
        MutableVector<DerivedStateObserver> mutableVector;
        long j2;
        TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
        Snapshot snapshot;
        Snapshot snapshotMakeCurrent;
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        synchronized (this.observedScopeMapsLock) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
            z = this.isPaused;
            observedScopeMap = this.currentMap;
            j = this.currentMapThreadId;
            Unit unit = Unit.INSTANCE;
        }
        long j3 = 0;
        if (j != -1) {
            if (!(j == jCurrentThreadId)) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + jCurrentThreadId + ", name=" + Thread_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            synchronized (this.observedScopeMapsLock) {
                try {
                    this.isPaused = false;
                    this.currentMap = observedScopeMapEnsureMap;
                    this.currentMapThreadId = jCurrentThreadId;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                }
            }
            Function1<Object, Unit> function1 = this.readObserver;
            Object obj = observedScopeMapEnsureMap.currentScope;
            MutableObjectIntMap mutableObjectIntMap = observedScopeMapEnsureMap.currentScopeReads;
            int i = observedScopeMapEnsureMap.currentToken;
            observedScopeMapEnsureMap.currentScope = scope;
            observedScopeMapEnsureMap.currentScopeReads = (MutableObjectIntMap) observedScopeMapEnsureMap.scopeToValues.get(scope);
            if (observedScopeMapEnsureMap.currentToken == -1) {
                observedScopeMapEnsureMap.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = observedScopeMapEnsureMap.getDerivedStateObserver();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                if (function1 == null) {
                    block.invoke();
                    j2 = j;
                    mutableVector = mutableVectorDerivedStateObservers;
                } else {
                    Snapshot snapshot2 = (Snapshot) SnapshotKt.threadSnapshot.get();
                    try {
                        if (!(snapshot2 instanceof TransparentObserverMutableSnapshot)) {
                            j2 = j;
                            if (snapshot2 != null) {
                                mutableVector = mutableVectorDerivedStateObservers;
                                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                snapshot = transparentObserverMutableSnapshot;
                                snapshotMakeCurrent = snapshot.makeCurrent();
                                block.invoke();
                                snapshot.restoreCurrent(snapshotMakeCurrent);
                                snapshot.dispose();
                            } else {
                                mutableVector = mutableVectorDerivedStateObservers;
                                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                snapshot = transparentObserverMutableSnapshot;
                                snapshotMakeCurrent = snapshot.makeCurrent();
                                block.invoke();
                                snapshot.restoreCurrent(snapshotMakeCurrent);
                                snapshot.dispose();
                            }
                            synchronized (this.observedScopeMapsLock) {
                                this.currentMap = observedScopeMap;
                                this.isPaused = z;
                                this.currentMapThreadId = j3;
                                Unit unit3 = Unit.INSTANCE;
                            }
                            throw th;
                        }
                        try {
                            if (((TransparentObserverMutableSnapshot) snapshot2).getThreadId() == Thread_jvmKt.currentThreadId()) {
                                Function1<Object, Unit> readObserver = ((TransparentObserverMutableSnapshot) snapshot2).getReadObserver();
                                Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot2).getWriteObserver$runtime();
                                try {
                                    j2 = j;
                                    try {
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(function1, readObserver, false, 4, null));
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                                        block.invoke();
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(readObserver);
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(writeObserver$runtime);
                                        mutableVector = mutableVectorDerivedStateObservers;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(readObserver);
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(writeObserver$runtime);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } else {
                                j2 = j;
                                if (snapshot2 != null || (snapshot2 instanceof MutableSnapshot)) {
                                    mutableVector = mutableVectorDerivedStateObservers;
                                    try {
                                        transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        mutableVector.removeAt(mutableVector.getSize() - 1);
                                        throw th;
                                    }
                                } else {
                                    transparentObserverMutableSnapshot = snapshot2.takeNestedSnapshot(function1);
                                    mutableVector = mutableVectorDerivedStateObservers;
                                }
                                snapshot = transparentObserverMutableSnapshot;
                                try {
                                    snapshotMakeCurrent = snapshot.makeCurrent();
                                    try {
                                        block.invoke();
                                        snapshot.restoreCurrent(snapshotMakeCurrent);
                                        snapshot.dispose();
                                    } catch (Throwable th5) {
                                        try {
                                            snapshot.restoreCurrent(snapshotMakeCurrent);
                                            throw th5;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            try {
                                                snapshot.dispose();
                                                throw th;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                mutableVector.removeAt(mutableVector.getSize() - 1);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            j2 = j;
                            mutableVector = mutableVectorDerivedStateObservers;
                            mutableVector.removeAt(mutableVector.getSize() - 1);
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                    }
                }
                try {
                    mutableVector.removeAt(mutableVector.getSize() - 1);
                    Object obj2 = observedScopeMapEnsureMap.currentScope;
                    Intrinsics.checkNotNull(obj2);
                    observedScopeMapEnsureMap.clearObsoleteStateReads(obj2);
                    observedScopeMapEnsureMap.currentScope = obj;
                    observedScopeMapEnsureMap.currentScopeReads = mutableObjectIntMap;
                    observedScopeMapEnsureMap.currentToken = i;
                    synchronized (this.observedScopeMapsLock) {
                        this.currentMap = observedScopeMap;
                        this.isPaused = z;
                        this.currentMapThreadId = j2;
                        Unit unit4 = Unit.INSTANCE;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    j3 = j2;
                }
            } catch (Throwable th12) {
                th = th12;
                mutableVector = mutableVectorDerivedStateObservers;
            }
        } catch (Throwable th13) {
            th = th13;
            j3 = j;
        }
    }

    private final <T> T withScopeMapLock(Function0<? extends T> block) {
        T tInvoke;
        synchronized (this.observedScopeMapsLock) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
        int size = mutableVector.getSize();
        int i = 0;
        while (true) {
            if (i >= size) {
                observedScopeMap = null;
                break;
            }
            observedScopeMap = observedScopeMapArr[i];
            if (observedScopeMap.getOnChanged() == onChanged) {
                break;
            }
            i++;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0001J.\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002J7\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0014\b\b\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040.H\u0086\bJ\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001H\u0002J\u000e\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001d0\u0003J\u0006\u00105\u001a\u00020\u001dJ\u0018\u00106\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002J\u0006\u00107\u001a\u00020\u0004J\u0014\u00108\u001a\u00020\u001d2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010:J\u0012\u0010;\u001a\u00020\u00042\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0006\u0010=\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R6\u0010$\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010%j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001`&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "invalidated", "Landroidx/collection/MutableScatterSet;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedState;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "readingDerivedStates", "", "getReadingDerivedStates", "()Z", "setReadingDerivedStates", "(Z)V", "deriveStateScopeCount", "dependencyToDerivedStates", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordRead", "value", "recordedValues", "observe", PermissionsResponse.SCOPE_KEY, "readObserver", "block", "Lkotlin/Function0;", "clearObsoleteStateReads", "clearScopeObservations", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "hasScopeObservations", "removeObservation", "clear", "recordInvalidation", "changes", "", "rereadDerivedState", "derivedState", "notifyInvalidatedScopes", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private boolean readingDerivedStates;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final MutableScatterMap<Object, Object> valueToScopes = ScopeMap.m6478constructorimpl$default(null, 1, null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount--;
            }
        };
        private final MutableScatterMap<Object, Object> dependencyToDerivedStates = ScopeMap.m6478constructorimpl$default(null, 1, null);
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            this.scopeToValues = new MutableScatterMap<>(i2, i, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final boolean getReadingDerivedStates() {
            return this.readingDerivedStates;
        }

        public final void setReadingDerivedStates(boolean z) {
            this.readingDerivedStates = z;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i;
            int i2;
            int i3;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = recordedValues.put(value, currentToken, -1);
            int i4 = 2;
            if (!(value instanceof DerivedState) || iPut == currentToken) {
                i = 2;
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                MutableScatterMap<Object, Object> mutableScatterMap = this.dependencyToDerivedStates;
                ScopeMap.m6493removeScopeimpl(mutableScatterMap, value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    i3 = i4;
                                    StateObject stateObject = (StateObject) objArr[(i5 << 3) + i7];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        ((StateObjectImpl) stateObject).m6729recordReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(i3));
                                    }
                                    ScopeMap.m6471addimpl(mutableScatterMap, stateObject, value);
                                } else {
                                    i3 = i4;
                                }
                                j >>= 8;
                                i7++;
                                i4 = i3;
                            }
                            i = i4;
                            if (i6 != 8) {
                                break;
                            }
                        } else {
                            i = i4;
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        i4 = i;
                    }
                } else {
                    i = 2;
                }
                i2 = -1;
            }
            if (iPut == i2) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m6729recordReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(i));
                }
                ScopeMap.m6471addimpl(this.valueToScopes, value, currentScope);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
            Object obj = this.currentScope;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (MutableObjectIntMap) this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = getDerivedStateObserver();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                if (readObserver != null) {
                    Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
                    if ((snapshot instanceof TransparentObserverMutableSnapshot) && ((TransparentObserverMutableSnapshot) snapshot).getThreadId() == Thread_jvmKt.currentThreadId()) {
                        Function1<Object, Unit> readObserver2 = ((TransparentObserverMutableSnapshot) snapshot).getReadObserver();
                        Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot).getWriteObserver$runtime();
                        try {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(readObserver, readObserver2, false, 4, null));
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                            block.invoke();
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                        } catch (Throwable th) {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                            throw th;
                        }
                    } else {
                        if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, null, true, false);
                        } else {
                            transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
                        }
                        try {
                            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                            try {
                                block.invoke();
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                transparentObserverMutableSnapshot.dispose();
                            } catch (Throwable th2) {
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            transparentObserverMutableSnapshot.dispose();
                            throw th3;
                        }
                    }
                } else {
                    block.invoke();
                }
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th4) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(scope);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            MutableObjectIntMap<Object> mutableObjectIntMap = mutableObjectIntMapRemove;
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(scope, obj);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00a2 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x00a4 A[LOOP:2: B:16:0x006b->B:28:0x00a4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:29:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:49:0x00b1 A[EDGE_INSN: B:49:0x00b1->B:30:0x00b1 BREAK  A[LOOP:2: B:16:0x006b->B:28:0x00a4], SYNTHETIC] */
        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j3 = jArr3[i2];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j3 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j4;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            Boolean boolInvoke = predicate.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                MutableObjectIntMap mutableObjectIntMap2 = mutableObjectIntMap;
                                Object[] objArr = mutableObjectIntMap2.keys;
                                int[] iArr = mutableObjectIntMap2.values;
                                long[] jArr4 = mutableObjectIntMap2.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j3;
                                    int i8 = 0;
                                    while (true) {
                                        long j5 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j5 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                            if (i8 != length2) {
                                                break;
                                            }
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        } else if (i8 != length2) {
                                            break;
                                            break;
                                        } else {
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j3;
                                }
                            } else {
                                jArr2 = jArr3;
                                j = j3;
                            }
                            if (boolInvoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(i6);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j3 = j >> i;
                        c2 = c;
                        j4 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            ScopeMap.m6491removeimpl(this.valueToScopes, value, scope);
            if (!(value instanceof DerivedState) || ScopeMap.m6479containsimpl(this.valueToScopes, value)) {
                return;
            }
            ScopeMap.m6493removeScopeimpl(this.dependencyToDerivedStates, value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            ScopeMap.m6476clearimpl(this.valueToScopes);
            this.scopeToValues.clear();
            ScopeMap.m6476clearimpl(this.dependencyToDerivedStates);
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0252  */
        /* JADX WARN: Code duplicated, block: B:110:0x0264  */
        /* JADX WARN: Code duplicated, block: B:112:0x0268  */
        /* JADX WARN: Code duplicated, block: B:114:0x0275  */
        /* JADX WARN: Code duplicated, block: B:117:0x0282  */
        /* JADX WARN: Code duplicated, block: B:119:0x028e  */
        /* JADX WARN: Code duplicated, block: B:121:0x0294  */
        /* JADX WARN: Code duplicated, block: B:125:0x02a8 A[DONT_INVERT, PHI: r21
          0x02a8: PHI (r21v12 boolean) = (r21v11 boolean), (r21v13 boolean) binds: [B:116:0x0280, B:124:0x02a6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:126:0x02aa A[LOOP:6: B:115:0x0276->B:126:0x02aa, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:127:0x02ad  */
        /* JADX WARN: Code duplicated, block: B:147:0x0331  */
        /* JADX WARN: Code duplicated, block: B:18:0x007a  */
        /* JADX WARN: Code duplicated, block: B:193:0x0419  */
        /* JADX WARN: Code duplicated, block: B:226:0x04e3 A[DONT_INVERT, PHI: r26
          0x04e3: PHI (r26v14 boolean) = (r26v13 boolean), (r26v15 boolean) binds: [B:217:0x04bb, B:225:0x04e1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:227:0x04e5 A[Catch: all -> 0x0504, LOOP:18: B:216:0x04b1->B:227:0x04e5, LOOP_END, TryCatch #0 {all -> 0x0504, blocks: (B:152:0x033e, B:154:0x0344, B:156:0x0348, B:159:0x0356, B:161:0x0364, B:163:0x0370, B:165:0x0376, B:167:0x038f, B:168:0x0393, B:170:0x03a7, B:172:0x03ad, B:174:0x03b1, B:177:0x03c3, B:179:0x03d1, B:181:0x03dd, B:183:0x03e3, B:185:0x03f3, B:191:0x0406, B:194:0x041f, B:197:0x043e, B:192:0x040d, B:195:0x0422, B:203:0x0466, B:204:0x0475, B:206:0x0487, B:207:0x048b, B:209:0x0499, B:211:0x049f, B:213:0x04a3, B:216:0x04b1, B:218:0x04bd, B:220:0x04c9, B:222:0x04cf, B:223:0x04d9, B:227:0x04e5, B:228:0x04e8, B:229:0x04ed, B:230:0x04f0), top: B:274:0x033e }] */
        /* JADX WARN: Code duplicated, block: B:232:0x04fa  */
        /* JADX WARN: Code duplicated, block: B:237:0x0509  */
        /* JADX WARN: Code duplicated, block: B:240:0x0516  */
        /* JADX WARN: Code duplicated, block: B:242:0x051a  */
        /* JADX WARN: Code duplicated, block: B:244:0x0527  */
        /* JADX WARN: Code duplicated, block: B:247:0x0534  */
        /* JADX WARN: Code duplicated, block: B:249:0x0540  */
        /* JADX WARN: Code duplicated, block: B:251:0x0546  */
        /* JADX WARN: Code duplicated, block: B:256:0x055b  */
        /* JADX WARN: Code duplicated, block: B:258:0x055f A[LOOP:16: B:245:0x0528->B:258:0x055f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:259:0x0562  */
        /* JADX WARN: Code duplicated, block: B:260:0x0569  */
        /* JADX WARN: Code duplicated, block: B:290:0x0164 A[EDGE_INSN: B:290:0x0164->B:63:0x0164 BREAK  A[LOOP:4: B:48:0x0112->B:60:0x014d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:294:0x02b2 A[EDGE_INSN: B:294:0x02b2->B:128:0x02b2 BREAK  A[LOOP:6: B:115:0x0276->B:126:0x02aa], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:295:0x02b2 A[EDGE_INSN: B:295:0x02b2->B:128:0x02b2 BREAK  A[LOOP:6: B:115:0x0276->B:126:0x02aa], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:298:0x029e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:300:0x0230 A[EDGE_INSN: B:300:0x0230->B:98:0x0230 BREAK  A[LOOP:8: B:85:0x01f4->B:96:0x0228], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:319:0x056b A[EDGE_INSN: B:319:0x056b->B:261:0x056b BREAK  A[LOOP:16: B:245:0x0528->B:258:0x055f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:320:0x056b A[EDGE_INSN: B:320:0x056b->B:261:0x056b BREAK  A[LOOP:16: B:245:0x0528->B:258:0x055f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:323:0x0550 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:325:0x04ed A[EDGE_INSN: B:325:0x04ed->B:229:0x04ed BREAK  A[LOOP:18: B:216:0x04b1->B:227:0x04e5], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:59:0x014b A[DONT_INVERT, PHI: r21
          0x014b: PHI (r21v31 boolean) = (r21v30 boolean), (r21v32 boolean) binds: [B:49:0x0120, B:58:0x0149] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:60:0x014d A[Catch: all -> 0x024d, LOOP:4: B:48:0x0112->B:60:0x014d, LOOP_END, TryCatch #1 {all -> 0x024d, blocks: (B:23:0x0087, B:25:0x008d, B:27:0x0091, B:30:0x00a5, B:32:0x00b5, B:34:0x00bf, B:36:0x00c5, B:38:0x00e0, B:39:0x00e4, B:41:0x00f6, B:43:0x00fc, B:45:0x0100, B:48:0x0112, B:50:0x0122, B:52:0x012c, B:54:0x0132, B:56:0x0142, B:63:0x0164, B:66:0x017f, B:60:0x014d, B:61:0x0156, B:64:0x0167, B:72:0x01a2, B:73:0x01b2, B:75:0x01ca, B:76:0x01ce, B:78:0x01dc, B:80:0x01e2, B:82:0x01e6, B:85:0x01f4, B:87:0x0200, B:89:0x020c, B:91:0x0212, B:92:0x021c, B:96:0x0228, B:97:0x022b, B:98:0x0230, B:99:0x0233), top: B:276:0x0087 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0160  */
        /* JADX WARN: Code duplicated, block: B:95:0x0226 A[DONT_INVERT, PHI: r21
          0x0226: PHI (r21v20 boolean) = (r21v19 boolean), (r21v21 boolean) binds: [B:86:0x01fe, B:94:0x0224] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:96:0x0228 A[Catch: all -> 0x024d, LOOP:8: B:85:0x01f4->B:96:0x0228, LOOP_END, TryCatch #1 {all -> 0x024d, blocks: (B:23:0x0087, B:25:0x008d, B:27:0x0091, B:30:0x00a5, B:32:0x00b5, B:34:0x00bf, B:36:0x00c5, B:38:0x00e0, B:39:0x00e4, B:41:0x00f6, B:43:0x00fc, B:45:0x0100, B:48:0x0112, B:50:0x0122, B:52:0x012c, B:54:0x0132, B:56:0x0142, B:63:0x0164, B:66:0x017f, B:60:0x014d, B:61:0x0156, B:64:0x0167, B:72:0x01a2, B:73:0x01b2, B:75:0x01ca, B:76:0x01ce, B:78:0x01dc, B:80:0x01e2, B:82:0x01e6, B:85:0x01f4, B:87:0x0200, B:89:0x020c, B:91:0x0212, B:92:0x021c, B:96:0x0228, B:97:0x022b, B:98:0x0230, B:99:0x0233), top: B:276:0x0087 }] */
        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z;
            Iterator it;
            MutableScatterMap<Object, Object> mutableScatterMap;
            String str;
            int i;
            Object obj;
            boolean z2;
            Object[] objArr;
            long[] jArr;
            int length;
            int i2;
            long j;
            int i3;
            int i4;
            Object[] objArr2;
            Iterator it2;
            MutableScatterMap<Object, Object> mutableScatterMap2;
            String str2;
            int i5;
            Object[] objArr3;
            long j2;
            long[] jArr2;
            long[] jArr3;
            Object[] objArr4;
            int i6;
            long[] jArr4;
            Object[] objArr5;
            int i7;
            int i8;
            int i9;
            long j3;
            int i10;
            Object obj2;
            Object[] objArr6;
            long[] jArr5;
            int length2;
            int i11;
            long j4;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            long j5;
            MutableScatterMap<Object, Object> mutableScatterMap3 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map = this.recordedDerivedStateValues;
            MutableScatterMap<Object, Object> mutableScatterMap4 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str3 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i18 = 8;
            if (changes instanceof ScatterSetWrapper) {
                ScatterSet set$runtime = ((ScatterSetWrapper) changes).getSet$runtime();
                Object[] objArr7 = set$runtime.elements;
                long[] jArr6 = set$runtime.metadata;
                int length3 = jArr6.length - 2;
                if (length3 >= 0) {
                    int i19 = 0;
                    z = false;
                    while (true) {
                        long j6 = jArr6[i19];
                        int i20 = length3;
                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i21 = 8 - ((~(i19 - i20)) >>> 31);
                            int i22 = 0;
                            while (i22 < i21) {
                                if ((j6 & 255) < 128) {
                                    Object obj3 = objArr7[(i19 << 3) + i22];
                                    int i23 = i18;
                                    if (obj3 instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        if (((StateObjectImpl) obj3).m6728isReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(2))) {
                                            if (this.readingDerivedStates && ScopeMap.m6479containsimpl(mutableScatterMap3, obj3)) {
                                                this.readingDerivedStates = true;
                                                try {
                                                    Object obj4 = mutableScatterMap3.get(obj3);
                                                    if (obj4 != null) {
                                                        if (obj4 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj4;
                                                            Object[] objArr8 = mutableScatterSet2.elements;
                                                            long[] jArr7 = mutableScatterSet2.metadata;
                                                            jArr4 = jArr6;
                                                            int length4 = jArr7.length - 2;
                                                            objArr5 = objArr7;
                                                            if (length4 >= 0) {
                                                                j3 = j6;
                                                                int i24 = 0;
                                                                while (true) {
                                                                    long j7 = jArr7[i24];
                                                                    long[] jArr8 = jArr7;
                                                                    Object[] objArr9 = objArr8;
                                                                    if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i25 = 8 - ((~(i24 - length4)) >>> 31);
                                                                        int i26 = 0;
                                                                        while (i26 < i25) {
                                                                            if ((j7 & 255) < 128) {
                                                                                i14 = i26;
                                                                                DerivedState<?> derivedState = (DerivedState) objArr9[(i24 << 3) + i26];
                                                                                Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                                                i16 = i22;
                                                                                Object obj5 = map.get(derivedState);
                                                                                SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                                                if (policy == null) {
                                                                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                                                                }
                                                                                j5 = j7;
                                                                                if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj5)) {
                                                                                    i15 = i21;
                                                                                    i17 = i19;
                                                                                    Boolean.valueOf(this.statesToReread.add(derivedState));
                                                                                } else {
                                                                                    Object obj6 = mutableScatterMap4.get(derivedState);
                                                                                    if (obj6 == null) {
                                                                                        i15 = i21;
                                                                                        i17 = i19;
                                                                                    } else if (obj6 instanceof MutableScatterSet) {
                                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj6;
                                                                                        Object[] objArr10 = mutableScatterSet3.elements;
                                                                                        long[] jArr9 = mutableScatterSet3.metadata;
                                                                                        int length5 = jArr9.length - 2;
                                                                                        if (length5 >= 0) {
                                                                                            i17 = i19;
                                                                                            int i27 = 0;
                                                                                            while (true) {
                                                                                                long j8 = jArr9[i27];
                                                                                                long[] jArr10 = jArr9;
                                                                                                i15 = i21;
                                                                                                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                                                    if (i27 != length5) {
                                                                                                        break;
                                                                                                        break;
                                                                                                    }
                                                                                                    i27++;
                                                                                                    i21 = i15;
                                                                                                    jArr9 = jArr10;
                                                                                                    i23 = 8;
                                                                                                } else {
                                                                                                    int i28 = 8 - ((~(i27 - length5)) >>> 31);
                                                                                                    for (int i29 = 0; i29 < i28; i29++) {
                                                                                                        if ((j8 & 255) < 128) {
                                                                                                            mutableScatterSet.add(objArr10[(i27 << 3) + i29]);
                                                                                                            z = true;
                                                                                                        }
                                                                                                        j8 >>= i23;
                                                                                                    }
                                                                                                    if (i28 != i23) {
                                                                                                        break;
                                                                                                    }
                                                                                                    if (i27 != length5) {
                                                                                                        break;
                                                                                                    }
                                                                                                    i27++;
                                                                                                    i21 = i15;
                                                                                                    jArr9 = jArr10;
                                                                                                    i23 = 8;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            i15 = i21;
                                                                                            i17 = i19;
                                                                                        }
                                                                                    } else {
                                                                                        i15 = i21;
                                                                                        i17 = i19;
                                                                                        mutableScatterSet.add(obj6);
                                                                                        z = true;
                                                                                    }
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                }
                                                                            } else {
                                                                                i14 = i26;
                                                                                i15 = i21;
                                                                                i16 = i22;
                                                                                i17 = i19;
                                                                                j5 = j7;
                                                                            }
                                                                            j7 = j5 >> 8;
                                                                            i26 = i14 + 1;
                                                                            i23 = 8;
                                                                            i22 = i16;
                                                                            i19 = i17;
                                                                            i21 = i15;
                                                                        }
                                                                        i7 = i21;
                                                                        i8 = i22;
                                                                        i9 = i19;
                                                                        if (i25 != i23) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        i7 = i21;
                                                                        i8 = i22;
                                                                        i9 = i19;
                                                                    }
                                                                    if (i24 == length4) {
                                                                        break;
                                                                    }
                                                                    i24++;
                                                                    objArr8 = objArr9;
                                                                    jArr7 = jArr8;
                                                                    i22 = i8;
                                                                    i19 = i9;
                                                                    i21 = i7;
                                                                    i23 = 8;
                                                                }
                                                            }
                                                        } else {
                                                            jArr4 = jArr6;
                                                            objArr5 = objArr7;
                                                            i7 = i21;
                                                            i8 = i22;
                                                            i9 = i19;
                                                            j3 = j6;
                                                            DerivedState<?> derivedState2 = (DerivedState) obj4;
                                                            Object obj7 = map.get(derivedState2);
                                                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                                                            if (policy2 == null) {
                                                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj7)) {
                                                                Boolean.valueOf(this.statesToReread.add(derivedState2));
                                                            } else {
                                                                Object obj8 = mutableScatterMap4.get(derivedState2);
                                                                if (obj8 != null) {
                                                                    if (obj8 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj8;
                                                                        Object[] objArr11 = mutableScatterSet4.elements;
                                                                        long[] jArr11 = mutableScatterSet4.metadata;
                                                                        int length6 = jArr11.length - 2;
                                                                        if (length6 >= 0) {
                                                                            int i30 = 0;
                                                                            while (true) {
                                                                                long j9 = jArr11[i30];
                                                                                if ((((~j9) << 7) & j9 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                                    if (i30 != length6) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    i30++;
                                                                                } else {
                                                                                    int i31 = 8 - ((~(i30 - length6)) >>> 31);
                                                                                    for (int i32 = 0; i32 < i31; i32++) {
                                                                                        if ((j9 & 255) < 128) {
                                                                                            mutableScatterSet.add(objArr11[(i30 << 3) + i32]);
                                                                                            z = true;
                                                                                        }
                                                                                        j9 >>= 8;
                                                                                    }
                                                                                    if (i31 != 8) {
                                                                                        break;
                                                                                    }
                                                                                    if (i30 != length6) {
                                                                                        break;
                                                                                    }
                                                                                    i30++;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        mutableScatterSet.add(obj8);
                                                                        z = true;
                                                                    }
                                                                }
                                                                Unit unit2 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        this.readingDerivedStates = false;
                                                    } else {
                                                        jArr4 = jArr6;
                                                        objArr5 = objArr7;
                                                    }
                                                    i7 = i21;
                                                    i8 = i22;
                                                    i9 = i19;
                                                    j3 = j6;
                                                    this.readingDerivedStates = false;
                                                } catch (Throwable th) {
                                                    this.readingDerivedStates = false;
                                                    throw th;
                                                }
                                            } else {
                                                jArr4 = jArr6;
                                                objArr5 = objArr7;
                                                i7 = i21;
                                                i8 = i22;
                                                i9 = i19;
                                                j3 = j6;
                                            }
                                            obj2 = mutableScatterMap4.get(obj3);
                                            if (obj2 != null) {
                                                if (obj2 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj2;
                                                    objArr6 = mutableScatterSet5.elements;
                                                    jArr5 = mutableScatterSet5.metadata;
                                                    length2 = jArr5.length - 2;
                                                    if (length2 >= 0) {
                                                        i11 = 0;
                                                        while (true) {
                                                            j4 = jArr5[i11];
                                                            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                if (i11 != length2) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i11++;
                                                            } else {
                                                                i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                                for (i13 = 0; i13 < i12; i13++) {
                                                                    if ((j4 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr6[(i11 << 3) + i13]);
                                                                        z = true;
                                                                    }
                                                                    j4 >>= 8;
                                                                }
                                                                if (i12 == 8) {
                                                                    break;
                                                                }
                                                                if (i11 != length2) {
                                                                    break;
                                                                }
                                                                i11++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj2);
                                                    z = true;
                                                }
                                            }
                                        } else {
                                            jArr4 = jArr6;
                                            objArr5 = objArr7;
                                            i7 = i21;
                                            i8 = i22;
                                            i9 = i19;
                                            j3 = j6;
                                        }
                                    } else {
                                        if (this.readingDerivedStates) {
                                            jArr4 = jArr6;
                                            objArr5 = objArr7;
                                            i7 = i21;
                                            i8 = i22;
                                            i9 = i19;
                                            j3 = j6;
                                        } else {
                                            jArr4 = jArr6;
                                            objArr5 = objArr7;
                                            i7 = i21;
                                            i8 = i22;
                                            i9 = i19;
                                            j3 = j6;
                                        }
                                        obj2 = mutableScatterMap4.get(obj3);
                                        if (obj2 != null) {
                                            if (obj2 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj2;
                                                objArr6 = mutableScatterSet6.elements;
                                                jArr5 = mutableScatterSet6.metadata;
                                                length2 = jArr5.length - 2;
                                                if (length2 >= 0) {
                                                    i11 = 0;
                                                    while (true) {
                                                        j4 = jArr5[i11];
                                                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            if (i11 != length2) {
                                                                break;
                                                                break;
                                                            }
                                                            i11++;
                                                        } else {
                                                            i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                            while (i13 < i12) {
                                                                if ((j4 & 255) < 128) {
                                                                    mutableScatterSet.add(objArr6[(i11 << 3) + i13]);
                                                                    z = true;
                                                                }
                                                                j4 >>= 8;
                                                            }
                                                            if (i12 == 8) {
                                                                break;
                                                                break;
                                                            }
                                                            if (i11 != length2) {
                                                                break;
                                                                break;
                                                            }
                                                            i11++;
                                                        }
                                                    }
                                                }
                                            } else {
                                                mutableScatterSet.add(obj2);
                                                z = true;
                                            }
                                        }
                                    }
                                    i10 = 8;
                                } else {
                                    jArr4 = jArr6;
                                    objArr5 = objArr7;
                                    i7 = i21;
                                    i8 = i22;
                                    i9 = i19;
                                    j3 = j6;
                                    i10 = i18;
                                }
                                j6 = j3 >> i10;
                                i22 = i8 + 1;
                                i18 = i10;
                                jArr6 = jArr4;
                                objArr7 = objArr5;
                                i19 = i9;
                                i21 = i7;
                            }
                            jArr3 = jArr6;
                            objArr4 = objArr7;
                            int i33 = i19;
                            if (i21 != i18) {
                                break;
                            }
                            i6 = i33;
                        } else {
                            jArr3 = jArr6;
                            objArr4 = objArr7;
                            i6 = i19;
                        }
                        length3 = i20;
                        if (i6 == length3) {
                            break;
                        }
                        i19 = i6 + 1;
                        jArr6 = jArr3;
                        objArr7 = objArr4;
                        i18 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                Iterator it3 = changes.iterator();
                boolean z3 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (next instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (((StateObjectImpl) next).m6728isReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(2))) {
                            if (this.readingDerivedStates && ScopeMap.m6479containsimpl(mutableScatterMap3, next)) {
                                this.readingDerivedStates = true;
                                try {
                                    Object obj9 = mutableScatterMap3.get(next);
                                    if (obj9 == null) {
                                        it = it3;
                                        mutableScatterMap = mutableScatterMap3;
                                        str = str3;
                                    } else if (obj9 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj9;
                                        Object[] objArr12 = mutableScatterSet7.elements;
                                        long[] jArr12 = mutableScatterSet7.metadata;
                                        int length7 = jArr12.length - 2;
                                        if (length7 >= 0) {
                                            int i34 = 0;
                                            while (true) {
                                                long j10 = jArr12[i34];
                                                long[] jArr13 = jArr12;
                                                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i35 = 8 - ((~(i34 - length7)) >>> 31);
                                                    int i36 = 0;
                                                    while (i36 < i35) {
                                                        if ((j10 & 255) < 128) {
                                                            DerivedState<?> derivedState3 = (DerivedState) objArr12[(i34 << 3) + i36];
                                                            Intrinsics.checkNotNull(derivedState3, str3);
                                                            it2 = it3;
                                                            Object obj10 = map.get(derivedState3);
                                                            SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                            if (policy3 == null) {
                                                                policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            mutableScatterMap2 = mutableScatterMap3;
                                                            str2 = str3;
                                                            if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj10)) {
                                                                i5 = i36;
                                                                objArr3 = objArr12;
                                                                j2 = j10;
                                                                Boolean.valueOf(this.statesToReread.add(derivedState3));
                                                            } else {
                                                                Object obj11 = mutableScatterMap4.get(derivedState3);
                                                                if (obj11 == null) {
                                                                    i5 = i36;
                                                                    objArr3 = objArr12;
                                                                    j2 = j10;
                                                                } else if (obj11 instanceof MutableScatterSet) {
                                                                    MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj11;
                                                                    Object[] objArr13 = mutableScatterSet8.elements;
                                                                    long[] jArr14 = mutableScatterSet8.metadata;
                                                                    int length8 = jArr14.length - 2;
                                                                    if (length8 >= 0) {
                                                                        i5 = i36;
                                                                        objArr3 = objArr12;
                                                                        int i37 = 0;
                                                                        while (true) {
                                                                            long j11 = jArr14[i37];
                                                                            j2 = j10;
                                                                            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                int i38 = 8 - ((~(i37 - length8)) >>> 31);
                                                                                int i39 = 0;
                                                                                while (i39 < i38) {
                                                                                    if ((j11 & 255) < 128) {
                                                                                        mutableScatterSet.add(objArr13[(i37 << 3) + i39]);
                                                                                        z3 = true;
                                                                                    }
                                                                                    j11 >>= 8;
                                                                                    i39++;
                                                                                    jArr14 = jArr14;
                                                                                }
                                                                                jArr2 = jArr14;
                                                                                if (i38 != 8) {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                jArr2 = jArr14;
                                                                            }
                                                                            if (i37 == length8) {
                                                                                break;
                                                                            }
                                                                            i37++;
                                                                            j10 = j2;
                                                                            jArr14 = jArr2;
                                                                        }
                                                                    } else {
                                                                        i5 = i36;
                                                                        objArr3 = objArr12;
                                                                        j2 = j10;
                                                                    }
                                                                } else {
                                                                    i5 = i36;
                                                                    objArr3 = objArr12;
                                                                    j2 = j10;
                                                                    mutableScatterSet.add(obj11);
                                                                    z3 = true;
                                                                }
                                                                Unit unit3 = Unit.INSTANCE;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            mutableScatterMap2 = mutableScatterMap3;
                                                            str2 = str3;
                                                            i5 = i36;
                                                            objArr3 = objArr12;
                                                            j2 = j10;
                                                        }
                                                        j10 = j2 >> 8;
                                                        i36 = i5 + 1;
                                                        objArr12 = objArr3;
                                                        mutableScatterMap3 = mutableScatterMap2;
                                                        str3 = str2;
                                                        it3 = it2;
                                                    }
                                                    it = it3;
                                                    mutableScatterMap = mutableScatterMap3;
                                                    str = str3;
                                                    objArr2 = objArr12;
                                                    if (i35 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    it = it3;
                                                    mutableScatterMap = mutableScatterMap3;
                                                    str = str3;
                                                    objArr2 = objArr12;
                                                }
                                                if (i34 == length7) {
                                                    break;
                                                }
                                                i34++;
                                                it3 = it;
                                                jArr12 = jArr13;
                                                objArr12 = objArr2;
                                                mutableScatterMap3 = mutableScatterMap;
                                                str3 = str;
                                            }
                                        } else {
                                            it = it3;
                                            mutableScatterMap = mutableScatterMap3;
                                            str = str3;
                                        }
                                    } else {
                                        it = it3;
                                        mutableScatterMap = mutableScatterMap3;
                                        str = str3;
                                        DerivedState<?> derivedState4 = (DerivedState) obj9;
                                        Object obj12 = map.get(derivedState4);
                                        SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                        if (policy4 == null) {
                                            policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                        }
                                        if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj12)) {
                                            Boolean.valueOf(this.statesToReread.add(derivedState4));
                                        } else {
                                            Object obj13 = mutableScatterMap4.get(derivedState4);
                                            if (obj13 != null) {
                                                if (obj13 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj13;
                                                    Object[] objArr14 = mutableScatterSet9.elements;
                                                    long[] jArr15 = mutableScatterSet9.metadata;
                                                    int length9 = jArr15.length - 2;
                                                    if (length9 >= 0) {
                                                        int i40 = 0;
                                                        while (true) {
                                                            long j12 = jArr15[i40];
                                                            if ((((~j12) << 7) & j12 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                if (i40 != length9) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i40++;
                                                            } else {
                                                                int i41 = 8 - ((~(i40 - length9)) >>> 31);
                                                                for (int i42 = 0; i42 < i41; i42++) {
                                                                    if ((j12 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr14[(i40 << 3) + i42]);
                                                                        z3 = true;
                                                                    }
                                                                    j12 >>= 8;
                                                                }
                                                                if (i41 != 8) {
                                                                    break;
                                                                }
                                                                if (i40 != length9) {
                                                                    break;
                                                                }
                                                                i40++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj13);
                                                    z3 = true;
                                                }
                                            }
                                            Unit unit4 = Unit.INSTANCE;
                                        }
                                    }
                                    i = 0;
                                    this.readingDerivedStates = false;
                                } catch (Throwable th2) {
                                    this.readingDerivedStates = false;
                                    throw th2;
                                }
                            } else {
                                it = it3;
                                mutableScatterMap = mutableScatterMap3;
                                str = str3;
                                i = 0;
                            }
                            obj = mutableScatterMap4.get(next);
                            if (obj == null) {
                                z2 = z3;
                            } else if (obj instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet10 = (MutableScatterSet) obj;
                                objArr = mutableScatterSet10.elements;
                                jArr = mutableScatterSet10.metadata;
                                length = jArr.length - 2;
                                if (length >= 0) {
                                    i2 = i;
                                    while (true) {
                                        j = jArr[i2];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            i3 = 8 - ((~(i2 - length)) >>> 31);
                                            for (i4 = i; i4 < i3; i4++) {
                                                if ((j & 255) < 128) {
                                                    mutableScatterSet.add(objArr[(i2 << 3) + i4]);
                                                    z3 = true;
                                                }
                                                j >>= 8;
                                            }
                                            if (i3 == 8) {
                                                break;
                                            }
                                        }
                                        if (i2 != length) {
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                                z2 = z3;
                            } else {
                                mutableScatterSet.add(obj);
                                z2 = true;
                            }
                            z3 = z2;
                        } else {
                            it = it3;
                            mutableScatterMap = mutableScatterMap3;
                            str = str3;
                        }
                    } else {
                        if (this.readingDerivedStates) {
                            it = it3;
                            mutableScatterMap = mutableScatterMap3;
                            str = str3;
                            i = 0;
                        } else {
                            it = it3;
                            mutableScatterMap = mutableScatterMap3;
                            str = str3;
                            i = 0;
                        }
                        obj = mutableScatterMap4.get(next);
                        if (obj == null) {
                            z2 = z3;
                        } else if (obj instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet11 = (MutableScatterSet) obj;
                            objArr = mutableScatterSet11.elements;
                            jArr = mutableScatterSet11.metadata;
                            length = jArr.length - 2;
                            if (length >= 0) {
                                i2 = i;
                                while (true) {
                                    j = jArr[i2];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        i3 = 8 - ((~(i2 - length)) >>> 31);
                                        while (i4 < i3) {
                                            if ((j & 255) < 128) {
                                                mutableScatterSet.add(objArr[(i2 << 3) + i4]);
                                                z3 = true;
                                            }
                                            j >>= 8;
                                        }
                                        if (i3 == 8) {
                                            break;
                                            break;
                                        }
                                    }
                                    if (i2 != length) {
                                        break;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            z2 = z3;
                        } else {
                            mutableScatterSet.add(obj);
                            z2 = true;
                        }
                        z3 = z2;
                    }
                    it3 = it;
                    mutableScatterMap3 = mutableScatterMap;
                    str3 = str;
                }
                z = z3;
            }
            if (!this.readingDerivedStates && this.statesToReread.getSize() != 0) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                DerivedState<?>[] derivedStateArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i43 = 0; i43 < size; i43++) {
                    rereadDerivedState(derivedStateArr[i43]);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int iHashCode = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            Object obj = this.valueToScopes.get(derivedState);
            if (obj == null) {
                return;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(i2, i, defaultConstructorMarker);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, iHashCode, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr2 = mutableScatterSet.metadata;
            int length = jArr2.length - 2;
            if (length < 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            Object obj2 = objArr[(i3 << 3) + i6];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(i2, i, defaultConstructorMarker);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, iHashCode, obj2, mutableObjectIntMap);
                        }
                        j >>= i4;
                        i6++;
                        i4 = i4;
                        jArr2 = jArr2;
                    }
                    jArr = jArr2;
                    if (i5 != i4) {
                        return;
                    }
                } else {
                    jArr = jArr2;
                }
                if (i3 == length) {
                    return;
                }
                i3++;
                jArr2 = jArr;
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0045 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0047 A[LOOP:0: B:5:0x0012->B:15:0x0047, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:19:0x004a A[EDGE_INSN: B:19:0x004a->B:16:0x004a BREAK  A[LOOP:0: B:5:0x0012->B:15:0x0047], SYNTHETIC] */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] objArr = mutableScatterSet2.elements;
            long[] jArr = mutableScatterSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.clearScopeObservations(scope);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.removeScopeIf(predicate);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                observedScopeMapArr[i].clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
