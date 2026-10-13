package com.amazonaws.ivs.player;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class HardwareInfo implements Releasable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Context context;
    EGLManager eglManager;
    EGLSurface surface;

    String getGPUVendor() {
        return (String) this.eglManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.HardwareInfo$$ExternalSyntheticLambda3
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11055lambda$getGPUVendor$0$comamazonawsivsplayerHardwareInfo();
            }
        }, this.surface);
    }

    /* JADX INFO: renamed from: lambda$getGPUVendor$0$com-amazonaws-ivs-player-HardwareInfo, reason: not valid java name */
    /* synthetic */ String m11055lambda$getGPUVendor$0$comamazonawsivsplayerHardwareInfo() {
        return this.eglManager.getString(7936);
    }

    String getGlVersion() {
        return (String) this.eglManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.HardwareInfo$$ExternalSyntheticLambda4
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11056lambda$getGlVersion$1$comamazonawsivsplayerHardwareInfo();
            }
        }, this.surface);
    }

    /* JADX INFO: renamed from: lambda$getGlVersion$1$com-amazonaws-ivs-player-HardwareInfo, reason: not valid java name */
    /* synthetic */ String m11056lambda$getGlVersion$1$comamazonawsivsplayerHardwareInfo() {
        return this.eglManager.getString(7938);
    }

    String getGPURenderer() {
        return (String) this.eglManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.HardwareInfo$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11054lambda$getGPURenderer$2$comamazonawsivsplayerHardwareInfo();
            }
        }, this.surface);
    }

    /* JADX INFO: renamed from: lambda$getGPURenderer$2$com-amazonaws-ivs-player-HardwareInfo, reason: not valid java name */
    /* synthetic */ String m11054lambda$getGPURenderer$2$comamazonawsivsplayerHardwareInfo() {
        return this.eglManager.getString(7937);
    }

    String[] getGPUExtensions() {
        String str = (String) this.eglManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.HardwareInfo$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11053lambda$getGPUExtensions$3$comamazonawsivsplayerHardwareInfo();
            }
        }, this.surface);
        if (!str.isEmpty()) {
            String[] strArrSplit = str.split(ServerSentEventKt.SPACE);
            Arrays.sort(strArrSplit);
            return strArrSplit;
        }
        return new String[0];
    }

    /* JADX INFO: renamed from: lambda$getGPUExtensions$3$com-amazonaws-ivs-player-HardwareInfo, reason: not valid java name */
    /* synthetic */ String m11053lambda$getGPUExtensions$3$comamazonawsivsplayerHardwareInfo() {
        return this.eglManager.getString(7939);
    }

    long getTotalMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) this.context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    long getTotalCoreCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    static Result<EGLException, HardwareInfo> create(final Context context, final EGLManager eGLManager) {
        return eGLManager.createEGLOffscreenSurface().flatMap(new Function() { // from class: com.amazonaws.ivs.player.HardwareInfo$$ExternalSyntheticLambda0
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return Result.value(new HardwareInfo(context, eGLManager, (EGLSurface) obj));
            }
        });
    }

    private HardwareInfo(Context context, EGLManager eGLManager, EGLSurface eGLSurface) {
        this.context = context;
        this.eglManager = eGLManager;
        this.surface = eGLSurface;
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        this.eglManager.releaseSurface(this.surface);
        this.surface = EGL14.EGL_NO_SURFACE;
    }
}
