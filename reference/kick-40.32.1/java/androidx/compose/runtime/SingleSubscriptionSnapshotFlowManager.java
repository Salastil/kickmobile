package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0018J'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0010¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\fH\u0002J\u001b\u0010\u001c\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\fH\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\fH\u0010¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/runtime/SingleSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", "soleWatchedObject", "", "workingSoleWatchedObject", "watchSet", "Landroidx/collection/MutableScatterSet;", "workingWatchSet", "subscribedChannel", "Lkotlinx/coroutines/channels/SendChannel;", "", "getSubscribedChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "setSubscribedChannel", "(Lkotlinx/coroutines/channels/SendChannel;)V", "readObserverCache", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSetImpl", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "promote", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SingleSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    private Object soleWatchedObject;
    private SendChannel<? super Unit> subscribedChannel;
    private MutableScatterSet<Object> watchSet;
    private Object workingSoleWatchedObject;
    private MutableScatterSet<Object> workingWatchSet;
    private final Function1<Object, Unit> readObserverCache = new Function1() { // from class: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SingleSubscriptionSnapshotFlowManager.readObserverCache$lambda$0(this.f$0, obj);
        }
    };
    private final ObserverHandle unregisterApplyObserver = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SingleSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    });

    public final SendChannel<Unit> getSubscribedChannel() {
        return this.subscribedChannel;
    }

    public final void setSubscribedChannel(SendChannel<? super Unit> sendChannel) {
        this.subscribedChannel = sendChannel;
    }

    static final Unit readObserverCache$lambda$0(SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager, Object obj) {
        SendChannel<? super Unit> sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
        Intrinsics.checkNotNull(sendChannel);
        singleSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, obj);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0062 A[Catch: all -> 0x0077, LOOP:0: B:12:0x0027->B:24:0x0062, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:8:0x0017, B:26:0x0066, B:9:0x001a, B:12:0x0027, B:14:0x0037, B:16:0x0043, B:18:0x004c, B:20:0x0057, B:21:0x005a, B:24:0x0062), top: B:35:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[EDGE_INSN: B:25:0x0065->B:26:0x0066 BREAK  A[LOOP:0: B:12:0x0027->B:24:0x0062]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0065 A[SYNTHETIC] */
    static final Unit unregisterApplyObserver$lambda$0(SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager, Set set, Snapshot snapshot) {
        SendChannel<? super Unit> sendChannel;
        synchronized (singleSubscriptionSnapshotFlowManager.getLock()) {
            MutableScatterSet<Object> mutableScatterSet = singleSubscriptionSnapshotFlowManager.watchSet;
            if (mutableScatterSet == null) {
                if (!CollectionsKt.contains(set, singleSubscriptionSnapshotFlowManager.soleWatchedObject)) {
                    sendChannel = null;
                    break;
                }
                sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
            } else {
                MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
                Object[] objArr = mutableScatterSet2.elements;
                long[] jArr = mutableScatterSet2.metadata;
                int length = jArr.length - 2;
                if (length < 0) {
                    sendChannel = null;
                    break;
                }
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                                sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                                break loop0;
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i == length) {
                                i++;
                            }
                        }
                        sendChannel = null;
                        break;
                    }
                    if (i == length) {
                        sendChannel = null;
                        break;
                    }
                    i++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (sendChannel != null) {
            ChannelResult.m14235boximpl(sendChannel.mo12563trySendJP2dKIU(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void watch$runtime(SendChannel<? super Unit> channel, Object obj) {
        if (!Intrinsics.areEqual(this.subscribedChannel, channel)) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        MutableScatterSet<Object> mutableScatterSet = this.workingWatchSet;
        Object obj2 = this.workingSoleWatchedObject;
        if (mutableScatterSet != null) {
            if (!(obj2 == null)) {
                PreconditionsKt.throwIllegalStateException("workingSoleWatchedObject must be null when workingWatchSet is non-null");
            }
            mutableScatterSet.add(obj);
        } else {
            if (obj2 == null) {
                this.workingSoleWatchedObject = obj;
                return;
            }
            MutableScatterSet<Object> mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetMutableScatterSetOf.add(obj2);
            mutableScatterSetMutableScatterSetOf.add(obj);
            this.workingWatchSet = mutableScatterSetMutableScatterSetOf;
            this.workingSoleWatchedObject = null;
        }
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public Function1<Object, Unit> readObserverFor$runtime(SendChannel<? super Unit> channel) {
        SendChannel<? super Unit> sendChannel = this.subscribedChannel;
        if (!(sendChannel == null || Intrinsics.areEqual(sendChannel, channel))) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        this.subscribedChannel = channel;
        return this.readObserverCache;
    }

    private final void clearWatchSetImpl() {
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void clearWatchSet$runtime(SendChannel<? super Unit> channel) {
        clearWatchSetImpl();
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void commitSubscriptionChanges$runtime() {
        synchronized (getLock()) {
            this.soleWatchedObject = this.workingSoleWatchedObject;
            if (this.workingWatchSet == null) {
                this.watchSet = null;
            } else {
                if (this.watchSet == null) {
                    this.watchSet = ScatterSetKt.mutableScatterSetOf();
                }
                MutableScatterSet<Object> mutableScatterSet = this.watchSet;
                this.watchSet = this.workingWatchSet;
                this.workingWatchSet = mutableScatterSet;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        clearWatchSetImpl();
        synchronized (getLock()) {
            this.subscribedChannel = null;
            this.soleWatchedObject = null;
            this.watchSet = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0065 A[LOOP:0: B:14:0x0030->B:24:0x0065, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0068 A[EDGE_INSN: B:28:0x0068->B:25:0x0068 BREAK  A[LOOP:0: B:14:0x0030->B:24:0x0065], SYNTHETIC] */
    public final MultiSubscriptionSnapshotFlowManager promote() {
        MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = new MultiSubscriptionSnapshotFlowManager();
        SendChannel<? super Unit> sendChannel = this.subscribedChannel;
        if (!(sendChannel != null)) {
            PreconditionsKt.throwIllegalStateException("promote must only be called when a manager is managing subscriptions for one channel and needs to start managing them for a second");
        }
        MutableScatterSet<Object> mutableScatterSet = this.watchSet;
        if (mutableScatterSet == null) {
            Object obj = this.soleWatchedObject;
            Intrinsics.checkNotNull(obj);
            multiSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, obj);
        } else {
            MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
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
                                multiSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                        if (i != length) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        multiSubscriptionSnapshotFlowManager.commitSubscriptionChanges$runtime();
        dispose$runtime();
        return multiSubscriptionSnapshotFlowManager;
    }
}
