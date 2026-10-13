package com.swmansion.reanimated.css;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainThreadCommandQueue.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/swmansion/reanimated/css/MainThreadCommandQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "execute", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "lock", "pending", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "spare", "scheduled", "", "mainHandler", "Landroid/os/Handler;", "drainRunnable", "Ljava/lang/Runnable;", "enqueue", "command", "(Ljava/lang/Object;)V", "drain", "hasPending", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainThreadCommandQueue<T> {
    private final Runnable drainRunnable;
    private final Function1<T, Unit> execute;
    private final Object lock;
    private final Handler mainHandler;
    private ArrayList<T> pending;
    private boolean scheduled;
    private ArrayList<T> spare;

    /* JADX WARN: Multi-variable type inference failed */
    public MainThreadCommandQueue(Function1<? super T, Unit> execute) {
        Intrinsics.checkNotNullParameter(execute, "execute");
        this.execute = execute;
        this.lock = new Object();
        this.pending = new ArrayList<>();
        this.spare = new ArrayList<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.drainRunnable = new Runnable() { // from class: com.swmansion.reanimated.css.MainThreadCommandQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.drain();
            }
        };
    }

    public final void enqueue(T command) {
        Intrinsics.checkNotNullParameter(command, "command");
        synchronized (this.lock) {
            this.pending.add(command);
            if (this.scheduled) {
                return;
            }
            this.scheduled = true;
            Message messageObtain = Message.obtain(this.mainHandler, this.drainRunnable);
            messageObtain.setAsynchronous(true);
            this.mainHandler.sendMessage(messageObtain);
        }
    }

    public final void drain() {
        ArrayList<T> arrayList;
        synchronized (this.lock) {
            arrayList = this.pending;
            ArrayList<T> arrayList2 = this.spare;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
            }
            this.pending = arrayList2;
            this.spare = null;
            this.scheduled = false;
            Unit unit = Unit.INSTANCE;
        }
        try {
            Iterator<T> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                T next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                this.execute.invoke(next);
            }
            arrayList.clear();
            synchronized (this.lock) {
                this.spare = arrayList;
                Unit unit2 = Unit.INSTANCE;
            }
        } catch (Throwable th) {
            arrayList.clear();
            synchronized (this.lock) {
                this.spare = arrayList;
                Unit unit3 = Unit.INSTANCE;
                throw th;
            }
        }
    }

    public final boolean hasPending() {
        boolean z;
        synchronized (this.lock) {
            z = !this.pending.isEmpty();
        }
        return z;
    }
}
