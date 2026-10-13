package expo.modules.updates.loader;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RemoteLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.loader.RemoteLoader$Companion", f = "RemoteLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {150}, m = "processRollBackToEmbeddedDirective", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "configuration", "logger", "database", "selectionPolicy", "directory", "launchedUpdate", "updateDirective", "embeddedUpdate", "manifestFilters", "embeddedLoader"}, nl = {153}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
final class RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 extends ContinuationImpl {
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
    final /* synthetic */ RemoteLoader.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(RemoteLoader.Companion companion, Continuation<? super RemoteLoader$Companion$processRollBackToEmbeddedDirective$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processRollBackToEmbeddedDirective(null, null, null, null, null, null, null, null, this);
    }
}
