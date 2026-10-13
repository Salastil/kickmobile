package com.facebook.fresco.vito.provider.setup;

import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrescoVitoSetup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/provider/setup/FrescoVitoSetup;", "", "getController", "Lcom/facebook/fresco/vito/core/FrescoController2;", "getPrefetcher", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "getImagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "getConfig", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrescoVitoSetup {
    FrescoVitoConfig getConfig();

    FrescoController2 getController();

    VitoImagePipeline getImagePipeline();

    FrescoVitoPrefetcher getPrefetcher();
}
