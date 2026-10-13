package com.amazonaws.ivs.player;

import android.content.Context;
import com.amazonaws.ivs.player.json.Json;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class SuperResolution extends IVSFeature<Config> implements Releasable, Experimental {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private EGLManager eglManager;
    private HardwareInfo hardwareInfo;
    private Platform platform;
    private VideoFrameTransformer upscaleRefiner;
    TransformerExperimentState videoTransformerExperimentState;

    public static class Config extends IVSFeature.IVSConfig<Config> {

        @Json(required = true)
        public boolean enabled = false;
    }

    private native long Init();

    private native void Release(long j);

    private native String getSuperResPayload(long j, String str);

    enum TransformerExperimentState {
        OFF(0),
        INITIALIZE(1),
        RUN(2);

        private int value;

        TransformerExperimentState(int i) {
            this.value = i;
        }
    }

    SuperResolution() {
        super("super_resolution", new Config());
        this.platform = null;
        this.eglManager = null;
        this.hardwareInfo = null;
        this.upscaleRefiner = null;
        this.videoTransformerExperimentState = TransformerExperimentState.OFF;
        this.nativeHandle = Init();
    }

    boolean init(Context context, Platform platform) {
        this.platform = platform;
        if (this.videoTransformerExperimentState.compareTo(TransformerExperimentState.INITIALIZE) < 0) {
            return false;
        }
        Result<EGLException, EGLManager> resultCreate = EGLManager.create();
        if (resultCreate.isError()) {
            reportError(resultCreate.getError());
            return false;
        }
        EGLManager value = resultCreate.getValue();
        this.eglManager = value;
        Result<EGLException, HardwareInfo> resultCreate2 = HardwareInfo.create(context, value);
        if (resultCreate2.isError()) {
            reportError(resultCreate2.getError());
            return false;
        }
        this.hardwareInfo = resultCreate2.getValue();
        VideoFrameTransformer videoFrameTransformer = new VideoFrameTransformer(new SuperResolution$$ExternalSyntheticLambda0(this), new SuperResolution$$ExternalSyntheticLambda1(this));
        this.upscaleRefiner = videoFrameTransformer;
        return videoFrameTransformer.init(this.eglManager, this.hardwareInfo) && this.isEnabled;
    }

    VideoFrameTransformer getTransformer() {
        if (this.videoTransformerExperimentState.equals(TransformerExperimentState.RUN)) {
            return this.upscaleRefiner;
        }
        return null;
    }

    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
        if ("treatment".equals(experiments.getAssignedGroup(getDescription()))) {
            this.isEnabled = true;
        }
        String assignedGroup = experiments.getAssignedGroup(new VideoFrameTransformer(new SuperResolution$$ExternalSyntheticLambda0(this), new SuperResolution$$ExternalSyntheticLambda1(this)).getDescription());
        if (assignedGroup.equals("AB-1")) {
            this.videoTransformerExperimentState = TransformerExperimentState.INITIALIZE;
        } else if (assignedGroup.equals("AB-2")) {
            this.videoTransformerExperimentState = TransformerExperimentState.RUN;
        }
    }

    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(JSONObject jSONObject) throws JSONException {
        if (this.isEnabled && jSONObject != null) {
            this.config.updateWithJson(jSONObject);
            this.isEnabled = ((Config) this.config.asImpl()).enabled;
        }
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    JSONObject getCriteriaForFeature() throws JSONException {
        Map<String, String> deviceProperties = this.platform.getDeviceProperties();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceManufacturer", deviceProperties.get("device_manufacturer"));
        jSONObject.put("deviceModel", deviceProperties.get("device_model"));
        jSONObject.put("deviceOsVersion", deviceProperties.get("device_os_version"));
        return jSONObject;
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        VideoFrameTransformer videoFrameTransformer = this.upscaleRefiner;
        if (videoFrameTransformer != null) {
            videoFrameTransformer.release();
        }
        HardwareInfo hardwareInfo = this.hardwareInfo;
        if (hardwareInfo != null) {
            hardwareInfo.release();
        }
        EGLManager eGLManager = this.eglManager;
        if (eGLManager != null) {
            eGLManager.release();
        }
        Release(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    @Override // com.amazonaws.ivs.player.Experimental
    public Experiments.Experiment getDescription() {
        return Experiments.Experiment.SUPER_RESOLUTION;
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    protected void reportError(RuntimeException runtimeException) {
        if (runtimeException instanceof GLException) {
            Iterator<GLError> it = ((GLException) runtimeException).errors.iterator();
            while (it.hasNext()) {
                super.reportAnalyticsEvent(GPUAnalyticsEvent.createErrorEvent(this.hardwareInfo, it.next()));
            }
            return;
        }
        if (runtimeException instanceof EGLException) {
            super.reportAnalyticsEvent(GPUAnalyticsEvent.createErrorEvent(this.hardwareInfo, (EGLException) runtimeException));
        } else {
            super.reportError(runtimeException);
        }
    }
}
