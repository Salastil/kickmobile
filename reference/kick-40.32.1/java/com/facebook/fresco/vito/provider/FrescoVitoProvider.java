package com.facebook.fresco.vito.provider;

import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.provider.components.FrescoVitoComponents;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: FrescoVitoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/vito/provider/FrescoVitoProvider;", "", "<init>", "()V", "getController", "Lcom/facebook/fresco/vito/core/FrescoController2;", "getPrefetcher", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "getImagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "getConfig", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "hasBeenInitialized", "", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrescoVitoProvider {
    public static final FrescoVitoProvider INSTANCE = new FrescoVitoProvider();

    private FrescoVitoProvider() {
    }

    @JvmStatic
    public static final synchronized FrescoController2 getController() {
        return FrescoVitoComponents.INSTANCE.getController();
    }

    @JvmStatic
    public static final synchronized FrescoVitoPrefetcher getPrefetcher() {
        return FrescoVitoComponents.INSTANCE.getPrefetcher();
    }

    @JvmStatic
    public static final synchronized VitoImagePipeline getImagePipeline() {
        return FrescoVitoComponents.INSTANCE.getImagePipeline();
    }

    @JvmStatic
    public static final synchronized FrescoVitoConfig getConfig() {
        return FrescoVitoComponents.INSTANCE.getConfig();
    }

    @JvmStatic
    public static final synchronized boolean hasBeenInitialized() {
        return FrescoVitoComponents.hasBeenInitialized();
    }
}
