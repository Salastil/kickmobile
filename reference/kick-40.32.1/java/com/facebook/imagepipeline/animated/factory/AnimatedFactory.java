package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimatedFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/animated/factory/AnimatedFactory;", "", "getAnimatedDrawableFactory", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnimatedFactory {
    DrawableFactory getAnimatedDrawableFactory(Context context);
}
