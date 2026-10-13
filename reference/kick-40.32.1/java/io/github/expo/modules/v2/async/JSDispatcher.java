package io.github.expo.modules.v2.async;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: JSDispatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/github/expo/modules/v2/async/JSDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "scheduler", "Lio/github/expo/modules/v2/async/JSScheduler;", "<init>", "(Lio/github/expo/modules/v2/async/JSScheduler;)V", "dispatch", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JSDispatcher extends CoroutineDispatcher {
    private final JSScheduler scheduler;

    public JSDispatcher(JSScheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo14283dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.scheduler.post(block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: toString */
    public String getName() {
        return "JSDispatcher";
    }
}
