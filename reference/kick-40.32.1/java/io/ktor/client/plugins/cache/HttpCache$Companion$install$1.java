package io.ktor.client.plugins.cache;

import androidx.media3.muxer.WebmConstants;
import com.datadog.trace.api.DDSpanTypes;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HttpCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {WebmConstants.MkvEbmlElement.TRACK_ENTRY, 178, 184, 193, 198}, m = "invokeSuspend", n = {"$this$intercept", "content", "$this$intercept", "content", "$this$intercept", "content", DDSpanTypes.CACHE, "header", "$this$intercept", "content", DDSpanTypes.CACHE, "validateStatus", "cachedCall", "$this$intercept", "content", DDSpanTypes.CACHE, "validateStatus"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, v = 1)
final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:45:0x0101  */
    /* JADX WARN: Code duplicated, block: B:48:0x0141  */
    /* JADX WARN: Code duplicated, block: B:50:0x014b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0192  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x0200  */
    /* JADX WARN: Code duplicated, block: B:65:0x0204  */
    /* JADX WARN: Code duplicated, block: B:70:0x0240  */
    /* JADX WARN: Code duplicated, block: B:72:0x024f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0259  */
    /* JADX WARN: Code duplicated, block: B:78:0x0291  */
    /* JADX WARN: Code duplicated, block: B:80:0x029b  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ce, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCacheLegacyKt.interceptSendLegacy(r2, r1, (io.ktor.http.content.OutgoingContent) r0, r11.$scope, r11) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x018b, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCache.INSTANCE.proceedWithMissingCache$ktor_client_core(r2, r11.$scope, r11) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01fa, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCache.INSTANCE.proceedWithCache$ktor_client_core(r2, r11.$scope, r3, r11) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x023a, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCache.INSTANCE.proceedWithWarning(r2, r12, r11.$scope, r2.getContext().getExecutionContext(), r11) == r7) goto L67;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:45:0x0101, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x014b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x0259, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:80:0x029b, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
