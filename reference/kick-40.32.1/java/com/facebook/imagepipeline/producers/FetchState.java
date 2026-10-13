package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\"¨\u0006-"}, d2 = {"Lcom/facebook/imagepipeline/producers/FetchState;", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/imagepipeline/producers/ProducerContext;", "<init>", "(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V", "getConsumer", "()Lcom/facebook/imagepipeline/producers/Consumer;", "getContext", "()Lcom/facebook/imagepipeline/producers/ProducerContext;", "lastIntermediateResultTimeMs", "", "getLastIntermediateResultTimeMs", "()J", "setLastIntermediateResultTimeMs", "(J)V", "onNewResultStatusFlags", "", "getOnNewResultStatusFlags", "()I", "setOnNewResultStatusFlags", "(I)V", "responseBytesRange", "Lcom/facebook/imagepipeline/common/BytesRange;", "getResponseBytesRange", "()Lcom/facebook/imagepipeline/common/BytesRange;", "setResponseBytesRange", "(Lcom/facebook/imagepipeline/common/BytesRange;)V", "id", "", "getId", "()Ljava/lang/String;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/imagepipeline/producers/ProducerListener2;", "getListener", "()Lcom/facebook/imagepipeline/producers/ProducerListener2;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", SearchIntents.EXTRA_QUERY, "getQuery", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FetchState {
    private final Consumer<EncodedImage> consumer;
    private final ProducerContext context;
    private long lastIntermediateResultTimeMs;
    private int onNewResultStatusFlags;
    private BytesRange responseBytesRange;

    public FetchState(Consumer<EncodedImage> consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        this.consumer = consumer;
        this.context = context;
    }

    public final Consumer<EncodedImage> getConsumer() {
        return this.consumer;
    }

    public final ProducerContext getContext() {
        return this.context;
    }

    public final long getLastIntermediateResultTimeMs() {
        return this.lastIntermediateResultTimeMs;
    }

    public final void setLastIntermediateResultTimeMs(long j) {
        this.lastIntermediateResultTimeMs = j;
    }

    public final int getOnNewResultStatusFlags() {
        return this.onNewResultStatusFlags;
    }

    public final void setOnNewResultStatusFlags(int i) {
        this.onNewResultStatusFlags = i;
    }

    public final BytesRange getResponseBytesRange() {
        return this.responseBytesRange;
    }

    public final void setResponseBytesRange(BytesRange bytesRange) {
        this.responseBytesRange = bytesRange;
    }

    public final String getId() {
        return this.context.getId();
    }

    public final ProducerListener2 getListener() {
        return this.context.getProducerListener();
    }

    public Uri getUri() {
        Uri sourceUri = this.context.getImageRequest().getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        return sourceUri;
    }

    public String getQuery() {
        return getUri().getQuery();
    }
}
