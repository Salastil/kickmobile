package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import com.android.billingclient.api.BillingClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\u0017J'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u0019J\u001b\u0010\u001a\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\bH\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\bH\u0010¢\u0006\u0002\b\u001fR\"\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", BillingClient.FeatureType.SUBSCRIPTIONS, "Landroidx/compose/runtime/collection/ScopeMap;", "", "Lkotlinx/coroutines/channels/SendChannel;", "", "Landroidx/collection/MutableScatterMap;", "pendingChanges", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "toNotify", "Landroidx/collection/MutableScatterSet;", "readObserverCache", "Landroidx/collection/MutableScatterMap;", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "SubscriptionChange", "Add", "RemoveScope", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MultiSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    private MutableScatterMap<Object, Object> subscriptions = ScopeMap.m6478constructorimpl$default(null, 1, null);
    private final List<SubscriptionChange> pendingChanges = new ArrayList();
    private final MutableScatterSet<SendChannel<Unit>> toNotify = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterMap<SendChannel<Unit>, Function1<Object, Unit>> readObserverCache = ScatterMapKt.mutableScatterMapOf();
    private final ObserverHandle unregisterApplyObserver = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    });

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001\u0082\u0001\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface SubscriptionChange {
    }

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "obj", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/SendChannel;)V", "getObj", "()Ljava/lang/Object;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Add implements SubscriptionChange {
        private final SendChannel<Unit> channel;
        private final Object obj;

        /* JADX WARN: Multi-variable type inference failed */
        public Add(Object obj, SendChannel<? super Unit> sendChannel) {
            this.obj = obj;
            this.channel = sendChannel;
        }

        public final SendChannel<Unit> getChannel() {
            return this.channel;
        }

        public final Object getObj() {
            return this.obj;
        }
    }

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class RemoveScope implements SubscriptionChange {
        private final SendChannel<Unit> channel;

        /* JADX WARN: Multi-variable type inference failed */
        public RemoveScope(SendChannel<? super Unit> sendChannel) {
            this.channel = sendChannel;
        }

        public final SendChannel<Unit> getChannel() {
            return this.channel;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0055 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[Catch: all -> 0x0065, LOOP:0: B:7:0x001e->B:17:0x0057, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x001e, B:9:0x002e, B:11:0x003a, B:13:0x0043, B:14:0x004f, B:17:0x0057, B:18:0x005a), top: B:25:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a A[EDGE_INSN: B:27:0x005a->B:18:0x005a BREAK  A[LOOP:0: B:7:0x001e->B:17:0x0057], SYNTHETIC] */
    static final Unit unregisterApplyObserver$lambda$0(final MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager, final Set set, Snapshot snapshot) {
        synchronized (multiSubscriptionSnapshotFlowManager.getLock()) {
            ScopeMap.m6483forEachKeyimpl(multiSubscriptionSnapshotFlowManager.subscriptions, new Function1() { // from class: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0$0$0(set, multiSubscriptionSnapshotFlowManager, obj);
                }
            });
            MutableScatterSet<SendChannel<Unit>> mutableScatterSet = multiSubscriptionSnapshotFlowManager.toNotify;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
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
                                ((SendChannel) objArr[(i << 3) + i3]).mo12563trySendJP2dKIU(Unit.INSTANCE);
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
            multiSubscriptionSnapshotFlowManager.toNotify.clear();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a A[LOOP:0: B:11:0x0021->B:21:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[EDGE_INSN: B:26:0x0064->B:23:0x0064 BREAK  A[LOOP:0: B:11:0x0021->B:21:0x005a], SYNTHETIC] */
    public static final Unit unregisterApplyObserver$lambda$0$0$0(Set set, MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager, Object obj) {
        Object obj2;
        if (set.contains(obj) && (obj2 = multiSubscriptionSnapshotFlowManager.subscriptions.get(obj)) != null) {
            if (obj2 instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
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
                                    multiSubscriptionSnapshotFlowManager.toNotify.add((SendChannel) objArr[(i << 3) + i3]);
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
            } else {
                multiSubscriptionSnapshotFlowManager.toNotify.add((SendChannel) obj2);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void watch$runtime(SendChannel<? super Unit> channel, Object obj) {
        this.pendingChanges.add(new Add(obj, channel));
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public Function1<Object, Unit> readObserverFor$runtime(final SendChannel<? super Unit> channel) {
        Function1<Object, Unit> function1 = this.readObserverCache.get(channel);
        if (function1 != null) {
            return function1;
        }
        Function1<Object, Unit> function2 = new Function1() { // from class: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiSubscriptionSnapshotFlowManager.readObserverFor$lambda$0(this.f$0, channel, obj);
            }
        };
        this.readObserverCache.put(channel, function2);
        return function2;
    }

    static final Unit readObserverFor$lambda$0(MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager, SendChannel sendChannel, Object obj) {
        multiSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, obj);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void clearWatchSet$runtime(SendChannel<? super Unit> channel) {
        this.pendingChanges.add(new RemoveScope(channel));
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void commitSubscriptionChanges$runtime() {
        synchronized (getLock()) {
            List<SubscriptionChange> list = this.pendingChanges;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                SubscriptionChange subscriptionChange = list.get(i);
                if (subscriptionChange instanceof Add) {
                    ScopeMap.m6471addimpl(this.subscriptions, ((Add) subscriptionChange).getObj(), ((Add) subscriptionChange).getChannel());
                } else {
                    if (!(subscriptionChange instanceof RemoveScope)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ScopeMap.m6493removeScopeimpl(this.subscriptions, ((RemoveScope) subscriptionChange).getChannel());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.pendingChanges.clear();
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.pendingChanges.clear();
        this.readObserverCache.clear();
        synchronized (getLock()) {
            ScopeMap.m6476clearimpl(this.subscriptions);
            Unit unit = Unit.INSTANCE;
        }
    }
}
