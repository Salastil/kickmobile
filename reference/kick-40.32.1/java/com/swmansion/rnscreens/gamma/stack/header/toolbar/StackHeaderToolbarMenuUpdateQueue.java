package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: StackHeaderToolbarMenuUpdateQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuUpdateQueue;", "", "iconResolver", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuIconResolver;", "delegate", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuUpdateQueueDelegate;", "<init>", "(Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuIconResolver;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuUpdateQueueDelegate;)V", "pendingBatches", "Lkotlin/collections/ArrayDeque;", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementRawUpdate;", "isProcessing", "", "isTornDown", "enqueue", "", "batch", "enqueue$react_native_screens_release", "tearDown", "tearDown$react_native_screens_release", "processNext", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderToolbarMenuUpdateQueue {
    private final StackHeaderToolbarMenuUpdateQueueDelegate delegate;
    private final StackHeaderToolbarMenuIconResolver iconResolver;
    private boolean isProcessing;
    private boolean isTornDown;
    private final ArrayDeque<List<StackHeaderToolbarMenuElementRawUpdate>> pendingBatches;

    public StackHeaderToolbarMenuUpdateQueue(StackHeaderToolbarMenuIconResolver iconResolver, StackHeaderToolbarMenuUpdateQueueDelegate delegate) {
        Intrinsics.checkNotNullParameter(iconResolver, "iconResolver");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.iconResolver = iconResolver;
        this.delegate = delegate;
        this.pendingBatches = new ArrayDeque<>();
    }

    public final void enqueue$react_native_screens_release(List<StackHeaderToolbarMenuElementRawUpdate> batch) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        if (batch.isEmpty()) {
            return;
        }
        this.pendingBatches.addLast(batch);
        if (this.isProcessing) {
            return;
        }
        processNext();
    }

    public final void tearDown$react_native_screens_release() {
        this.pendingBatches.clear();
        this.isTornDown = true;
        this.isProcessing = false;
    }

    private final void processNext() {
        final List<StackHeaderToolbarMenuElementRawUpdate> list;
        StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr;
        StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue;
        Ref.IntRef intRef;
        while (true) {
            List<StackHeaderToolbarMenuElementRawUpdate> listFirstOrNull = this.pendingBatches.firstOrNull();
            if (listFirstOrNull == null) {
                this.isProcessing = false;
                return;
            }
            this.isProcessing = true;
            StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr2 = new StackHeaderToolbarMenuElementUpdate[listFirstOrNull.size()];
            final Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = listFirstOrNull.size();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            final int i = 0;
            for (Object obj : listFirstOrNull) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final StackHeaderToolbarMenuElementRawUpdate stackHeaderToolbarMenuElementRawUpdate = (StackHeaderToolbarMenuElementRawUpdate) obj;
                StackHeaderToolbarMenuItemIconSource iconSource = stackHeaderToolbarMenuElementRawUpdate.getIconSource();
                if (iconSource == null) {
                    List<StackHeaderToolbarMenuElementRawUpdate> list2 = listFirstOrNull;
                    stackHeaderToolbarMenuElementUpdateArr = stackHeaderToolbarMenuElementUpdateArr2;
                    intRef = intRef2;
                    int i3 = i;
                    stackHeaderToolbarMenuUpdateQueue = this;
                    processNext$onElementResolved(stackHeaderToolbarMenuElementUpdateArr, stackHeaderToolbarMenuUpdateQueue, list2, intRef, booleanRef, i3, stackHeaderToolbarMenuElementRawUpdate.getOptions());
                    list = list2;
                } else {
                    list = listFirstOrNull;
                    final Ref.BooleanRef booleanRef2 = booleanRef;
                    final StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue2 = this;
                    final StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr3 = stackHeaderToolbarMenuElementUpdateArr2;
                    StackHeaderToolbarMenuIconResolver stackHeaderToolbarMenuIconResolver = stackHeaderToolbarMenuUpdateQueue2.iconResolver;
                    Function1<? super StackHeaderToolbarFieldUpdate<? extends Drawable>, Unit> function1 = new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuUpdateQueue$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return StackHeaderToolbarMenuUpdateQueue.processNext$lambda$2$0(i, stackHeaderToolbarMenuElementRawUpdate, stackHeaderToolbarMenuElementUpdateArr3, stackHeaderToolbarMenuUpdateQueue2, list, intRef2, booleanRef2, (StackHeaderToolbarFieldUpdate) obj2);
                        }
                    };
                    stackHeaderToolbarMenuElementUpdateArr = stackHeaderToolbarMenuElementUpdateArr3;
                    stackHeaderToolbarMenuUpdateQueue = stackHeaderToolbarMenuUpdateQueue2;
                    intRef = intRef2;
                    booleanRef = booleanRef2;
                    stackHeaderToolbarMenuIconResolver.resolve(iconSource, function1);
                }
                this = stackHeaderToolbarMenuUpdateQueue;
                intRef2 = intRef;
                listFirstOrNull = list;
                i = i2;
                stackHeaderToolbarMenuElementUpdateArr2 = stackHeaderToolbarMenuElementUpdateArr;
            }
            StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue3 = this;
            StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr4 = stackHeaderToolbarMenuElementUpdateArr2;
            booleanRef.element = false;
            if (intRef2.element > 0) {
                return;
            }
            processNext$dispatchResolvedBatch(stackHeaderToolbarMenuUpdateQueue3, stackHeaderToolbarMenuElementUpdateArr4);
            this = stackHeaderToolbarMenuUpdateQueue3;
        }
    }

    private static final void processNext$dispatchResolvedBatch(StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue, StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr) {
        stackHeaderToolbarMenuUpdateQueue.pendingBatches.removeFirst();
        StackHeaderToolbarMenuUpdateQueueDelegate stackHeaderToolbarMenuUpdateQueueDelegate = stackHeaderToolbarMenuUpdateQueue.delegate;
        ArrayList arrayList = new ArrayList(stackHeaderToolbarMenuElementUpdateArr.length);
        for (StackHeaderToolbarMenuElementUpdate stackHeaderToolbarMenuElementUpdate : stackHeaderToolbarMenuElementUpdateArr) {
            if (stackHeaderToolbarMenuElementUpdate == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            arrayList.add(stackHeaderToolbarMenuElementUpdate);
        }
        stackHeaderToolbarMenuUpdateQueueDelegate.onUpdatesResolved(arrayList);
    }

    private static final void processNext$onElementResolved(StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr, StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue, List<StackHeaderToolbarMenuElementRawUpdate> list, Ref.IntRef intRef, Ref.BooleanRef booleanRef, int i, StackHeaderToolbarMenuElementOptions stackHeaderToolbarMenuElementOptions) {
        if (stackHeaderToolbarMenuElementUpdateArr[i] != null) {
            throw new IllegalStateException("[RNScreens] Unexpected duplicated element resolution.".toString());
        }
        if (stackHeaderToolbarMenuUpdateQueue.isTornDown) {
            return;
        }
        stackHeaderToolbarMenuElementUpdateArr[i] = new StackHeaderToolbarMenuElementUpdate(list.get(i).getId(), stackHeaderToolbarMenuElementOptions);
        intRef.element--;
        if (intRef.element != 0 || booleanRef.element) {
            return;
        }
        processNext$dispatchResolvedBatch(stackHeaderToolbarMenuUpdateQueue, stackHeaderToolbarMenuElementUpdateArr);
        stackHeaderToolbarMenuUpdateQueue.processNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processNext$lambda$2$0(int i, StackHeaderToolbarMenuElementRawUpdate stackHeaderToolbarMenuElementRawUpdate, StackHeaderToolbarMenuElementUpdate[] stackHeaderToolbarMenuElementUpdateArr, StackHeaderToolbarMenuUpdateQueue stackHeaderToolbarMenuUpdateQueue, List list, Ref.IntRef intRef, Ref.BooleanRef booleanRef, StackHeaderToolbarFieldUpdate icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        StackHeaderToolbarMenuElementOptions options = stackHeaderToolbarMenuElementRawUpdate.getOptions();
        processNext$onElementResolved(stackHeaderToolbarMenuElementUpdateArr, stackHeaderToolbarMenuUpdateQueue, list, intRef, booleanRef, i, options.copy((16255 & 1) != 0 ? options.title : null, (16255 & 2) != 0 ? options.titleCondensed : null, (16255 & 4) != 0 ? options.tooltipText : null, (16255 & 8) != 0 ? options.accessibilityLabel : null, (16255 & 16) != 0 ? options.hidden : null, (16255 & 32) != 0 ? options.disabled : null, (16255 & 64) != 0 ? options.showAsAction : null, (16255 & 128) != 0 ? options.icon : icon, (16255 & 256) != 0 ? options.iconTintColorNormal : null, (16255 & 512) != 0 ? options.iconTintColorPressed : null, (16255 & 1024) != 0 ? options.iconTintColorFocused : null, (16255 & 2048) != 0 ? options.iconTintColorDisabled : null, (16255 & 4096) != 0 ? options.checked : null, (16255 & 8192) != 0 ? options.menuTitle : null));
        return Unit.INSTANCE;
    }
}
