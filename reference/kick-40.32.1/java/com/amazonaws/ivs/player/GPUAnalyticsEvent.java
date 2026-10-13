package com.amazonaws.ivs.player;

import android.text.TextUtils;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;

/* JADX INFO: loaded from: classes5.dex */
abstract class GPUAnalyticsEvent {
    final String gpuArchitecture;
    final String gpuName;
    final String gpuVendor;

    static GPUErrorAnalyticsEvent createErrorEvent(HardwareInfo hardwareInfo, GLError gLError) {
        return new GPUErrorAnalyticsEvent(hardwareInfo, gLError.description, gLError.errorCodes.isEmpty() ? 0 : gLError.errorCodes.get(0).intValue());
    }

    static GPUErrorAnalyticsEvent createErrorEvent(HardwareInfo hardwareInfo, EGLException eGLException) {
        return new GPUErrorAnalyticsEvent(hardwareInfo, eGLException.message, eGLException.errorCode);
    }

    static GPUInitAnalyticsEvent createInitEvent(HardwareInfo hardwareInfo, Performance.Snapshot snapshot) {
        return new GPUInitAnalyticsEvent(hardwareInfo, snapshot, "");
    }

    static GPUStatusAnalyticsEvent createStatusEvent(HardwareInfo hardwareInfo, Performance.Snapshot snapshot, Performance.Snapshot snapshot2, Performance.Snapshot snapshot3) {
        return new GPUStatusAnalyticsEvent(hardwareInfo, snapshot, snapshot2, snapshot3);
    }

    GPUAnalyticsEvent(HardwareInfo hardwareInfo) {
        this.gpuName = hardwareInfo.getGPURenderer();
        this.gpuArchitecture = hardwareInfo.getGlVersion();
        this.gpuVendor = hardwareInfo.getGPURenderer();
    }

    static final class GPUInitAnalyticsEvent extends GPUAnalyticsEvent {
        final long cpuCoreCount;
        final String gpuConfig;
        final String gpuFeatures;
        final float timeInit;
        final long totalRam;

        private GPUInitAnalyticsEvent(HardwareInfo hardwareInfo, Performance.Snapshot snapshot, String str) {
            super(hardwareInfo);
            this.cpuCoreCount = hardwareInfo.getTotalCoreCount();
            this.gpuFeatures = TextUtils.join(WebViewLogEventConsumer.DDTAGS_SEPARATOR, hardwareInfo.getGPUExtensions());
            this.totalRam = hardwareInfo.getTotalMemory();
            this.timeInit = snapshot.time();
            this.gpuConfig = str;
        }
    }

    static final class GPUStatusAnalyticsEvent extends GPUAnalyticsEvent {
        final int framesCaptured;
        final int framesRendered;
        final int framesTransformed;
        final float timeCapture;
        final float timeEndToEnd;
        final float timeRender;
        final float timeTransform;

        private GPUStatusAnalyticsEvent(HardwareInfo hardwareInfo, Performance.Snapshot snapshot, Performance.Snapshot snapshot2, Performance.Snapshot snapshot3) {
            super(hardwareInfo);
            this.framesCaptured = snapshot.samples();
            float fTime = snapshot.time();
            this.timeCapture = fTime;
            this.framesTransformed = snapshot2.samples();
            float fTime2 = snapshot2.time();
            this.timeTransform = fTime2;
            this.framesRendered = snapshot3.samples();
            float fTime3 = snapshot3.time();
            this.timeRender = fTime3;
            this.timeEndToEnd = fTime + fTime2 + fTime3;
        }
    }

    static final class GPUErrorAnalyticsEvent extends GPUAnalyticsEvent {
        final int errorCode;
        final String errorMessage;
        final String errorSource;

        GPUErrorAnalyticsEvent(HardwareInfo hardwareInfo, String str, int i) {
            super(hardwareInfo);
            this.errorMessage = str;
            this.errorSource = "";
            this.errorCode = i;
        }
    }
}
