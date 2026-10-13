package com.facebook.fresco.vito.provider.components;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.provider.setup.FrescoVitoSetup;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrescoVitoComponents.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0001H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/fresco/vito/provider/components/FrescoVitoComponents;", "Lcom/facebook/fresco/vito/provider/setup/FrescoVitoSetup;", "<init>", "()V", "_implementation", "getController", "Lcom/facebook/fresco/vito/core/FrescoController2;", "getPrefetcher", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "getImagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "getConfig", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "resetImplementation", "", "hasBeenInitialized", "", "getImplementation", "setImplementation", "implementation", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrescoVitoComponents implements FrescoVitoSetup {
    public static final FrescoVitoComponents INSTANCE = new FrescoVitoComponents();
    private static FrescoVitoSetup _implementation;

    private FrescoVitoComponents() {
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    public synchronized FrescoController2 getController() {
        return getImplementation().getController();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    public synchronized FrescoVitoPrefetcher getPrefetcher() {
        return getImplementation().getPrefetcher();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    public synchronized VitoImagePipeline getImagePipeline() {
        return getImplementation().getImagePipeline();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    public synchronized FrescoVitoConfig getConfig() {
        return getImplementation().getConfig();
    }

    @JvmStatic
    public static final synchronized void resetImplementation() {
        _implementation = null;
    }

    @JvmStatic
    public static final synchronized boolean hasBeenInitialized() {
        return _implementation != null;
    }

    @JvmStatic
    public static final synchronized FrescoVitoSetup getImplementation() {
        FrescoVitoSetup frescoVitoSetup;
        frescoVitoSetup = _implementation;
        if (frescoVitoSetup == null) {
            throw new RuntimeException("Fresco context provider must be set");
        }
        return frescoVitoSetup;
    }

    @JvmStatic
    public static final synchronized void setImplementation(FrescoVitoSetup implementation) {
        Intrinsics.checkNotNullParameter(implementation, "implementation");
        if (_implementation != null) {
            FLog.e("FrescoVitoProvider", "Fresco Vito already initialized! Vito must be initialized only once.");
        }
        _implementation = implementation;
    }
}
