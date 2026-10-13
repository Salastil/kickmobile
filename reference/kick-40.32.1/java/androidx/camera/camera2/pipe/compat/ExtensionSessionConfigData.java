package androidx.camera.camera2.pipe.compat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0080\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001d\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00067"}, d2 = {"Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "", "sessionType", "", "outputConfigurations", "", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "sessionTemplateId", "sessionParameters", "", "extensionMode", "extensionStateCallback", "Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper$StateCallback;", "postviewOutputConfiguration", "<init>", "(ILjava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;ILjava/util/Map;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper$StateCallback;Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;)V", "getSessionType", "()I", "getOutputConfigurations", "()Ljava/util/List;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getStateCallback", "()Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "getSessionTemplateId", "getSessionParameters", "()Ljava/util/Map;", "getExtensionMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtensionStateCallback", "()Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper$StateCallback;", "getPostviewOutputConfiguration", "()Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;ILjava/util/Map;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper$StateCallback;Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;)Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "equals", "", "other", "hashCode", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExtensionSessionConfigData {
    private final Executor executor;
    private final Integer extensionMode;
    private final CameraExtensionSessionWrapper.StateCallback extensionStateCallback;
    private final List<OutputConfigurationWrapper> outputConfigurations;
    private final OutputConfigurationWrapper postviewOutputConfiguration;
    private final Map<?, Object> sessionParameters;
    private final int sessionTemplateId;
    private final int sessionType;
    private final CameraCaptureSessionWrapper.StateCallback stateCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtensionSessionConfigData copy$default(ExtensionSessionConfigData extensionSessionConfigData, int i, List list, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map map, Integer num, CameraExtensionSessionWrapper.StateCallback stateCallback2, OutputConfigurationWrapper outputConfigurationWrapper, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = extensionSessionConfigData.sessionType;
        }
        if ((i3 & 2) != 0) {
            list = extensionSessionConfigData.outputConfigurations;
        }
        if ((i3 & 4) != 0) {
            executor = extensionSessionConfigData.executor;
        }
        if ((i3 & 8) != 0) {
            stateCallback = extensionSessionConfigData.stateCallback;
        }
        if ((i3 & 16) != 0) {
            i2 = extensionSessionConfigData.sessionTemplateId;
        }
        if ((i3 & 32) != 0) {
            map = extensionSessionConfigData.sessionParameters;
        }
        if ((i3 & 64) != 0) {
            num = extensionSessionConfigData.extensionMode;
        }
        if ((i3 & 128) != 0) {
            stateCallback2 = extensionSessionConfigData.extensionStateCallback;
        }
        if ((i3 & 256) != 0) {
            outputConfigurationWrapper = extensionSessionConfigData.postviewOutputConfiguration;
        }
        CameraExtensionSessionWrapper.StateCallback stateCallback3 = stateCallback2;
        OutputConfigurationWrapper outputConfigurationWrapper2 = outputConfigurationWrapper;
        Map map2 = map;
        Integer num2 = num;
        int i4 = i2;
        Executor executor2 = executor;
        return extensionSessionConfigData.copy(i, list, executor2, stateCallback, i4, map2, num2, stateCallback3, outputConfigurationWrapper2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSessionType() {
        return this.sessionType;
    }

    public final List<OutputConfigurationWrapper> component2() {
        return this.outputConfigurations;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Executor getExecutor() {
        return this.executor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CameraCaptureSessionWrapper.StateCallback getStateCallback() {
        return this.stateCallback;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSessionTemplateId() {
        return this.sessionTemplateId;
    }

    public final Map<?, Object> component6() {
        return this.sessionParameters;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getExtensionMode() {
        return this.extensionMode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CameraExtensionSessionWrapper.StateCallback getExtensionStateCallback() {
        return this.extensionStateCallback;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final OutputConfigurationWrapper getPostviewOutputConfiguration() {
        return this.postviewOutputConfiguration;
    }

    public final ExtensionSessionConfigData copy(int sessionType, List<? extends OutputConfigurationWrapper> outputConfigurations, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int sessionTemplateId, Map<?, ? extends Object> sessionParameters, Integer extensionMode, CameraExtensionSessionWrapper.StateCallback extensionStateCallback, OutputConfigurationWrapper postviewOutputConfiguration) {
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
        return new ExtensionSessionConfigData(sessionType, outputConfigurations, executor, stateCallback, sessionTemplateId, sessionParameters, extensionMode, extensionStateCallback, postviewOutputConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtensionSessionConfigData)) {
            return false;
        }
        ExtensionSessionConfigData extensionSessionConfigData = (ExtensionSessionConfigData) other;
        return this.sessionType == extensionSessionConfigData.sessionType && Intrinsics.areEqual(this.outputConfigurations, extensionSessionConfigData.outputConfigurations) && Intrinsics.areEqual(this.executor, extensionSessionConfigData.executor) && Intrinsics.areEqual(this.stateCallback, extensionSessionConfigData.stateCallback) && this.sessionTemplateId == extensionSessionConfigData.sessionTemplateId && Intrinsics.areEqual(this.sessionParameters, extensionSessionConfigData.sessionParameters) && Intrinsics.areEqual(this.extensionMode, extensionSessionConfigData.extensionMode) && Intrinsics.areEqual(this.extensionStateCallback, extensionSessionConfigData.extensionStateCallback) && Intrinsics.areEqual(this.postviewOutputConfiguration, extensionSessionConfigData.postviewOutputConfiguration);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.sessionType) * 31) + this.outputConfigurations.hashCode()) * 31) + this.executor.hashCode()) * 31) + this.stateCallback.hashCode()) * 31) + Integer.hashCode(this.sessionTemplateId)) * 31) + this.sessionParameters.hashCode()) * 31;
        Integer num = this.extensionMode;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        CameraExtensionSessionWrapper.StateCallback stateCallback = this.extensionStateCallback;
        int iHashCode3 = (iHashCode2 + (stateCallback == null ? 0 : stateCallback.hashCode())) * 31;
        OutputConfigurationWrapper outputConfigurationWrapper = this.postviewOutputConfiguration;
        return iHashCode3 + (outputConfigurationWrapper != null ? outputConfigurationWrapper.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionSessionConfigData(sessionType=" + this.sessionType + ", outputConfigurations=" + this.outputConfigurations + ", executor=" + this.executor + ", stateCallback=" + this.stateCallback + ", sessionTemplateId=" + this.sessionTemplateId + ", sessionParameters=" + this.sessionParameters + ", extensionMode=" + this.extensionMode + ", extensionStateCallback=" + this.extensionStateCallback + ", postviewOutputConfiguration=" + this.postviewOutputConfiguration + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExtensionSessionConfigData(int i, List<? extends OutputConfigurationWrapper> outputConfigurations, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map<?, ? extends Object> sessionParameters, Integer num, CameraExtensionSessionWrapper.StateCallback stateCallback2, OutputConfigurationWrapper outputConfigurationWrapper) {
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
        this.sessionType = i;
        this.outputConfigurations = outputConfigurations;
        this.executor = executor;
        this.stateCallback = stateCallback;
        this.sessionTemplateId = i2;
        this.sessionParameters = sessionParameters;
        this.extensionMode = num;
        this.extensionStateCallback = stateCallback2;
        this.postviewOutputConfiguration = outputConfigurationWrapper;
    }

    public /* synthetic */ ExtensionSessionConfigData(int i, List list, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map map, Integer num, CameraExtensionSessionWrapper.StateCallback stateCallback2, OutputConfigurationWrapper outputConfigurationWrapper, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, executor, stateCallback, i2, map, (i3 & 64) != 0 ? null : num, (i3 & 128) != 0 ? null : stateCallback2, (i3 & 256) != 0 ? null : outputConfigurationWrapper);
    }

    public final int getSessionType() {
        return this.sessionType;
    }

    public final List<OutputConfigurationWrapper> getOutputConfigurations() {
        return this.outputConfigurations;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final CameraCaptureSessionWrapper.StateCallback getStateCallback() {
        return this.stateCallback;
    }

    public final int getSessionTemplateId() {
        return this.sessionTemplateId;
    }

    public final Map<?, Object> getSessionParameters() {
        return this.sessionParameters;
    }

    public final Integer getExtensionMode() {
        return this.extensionMode;
    }

    public final CameraExtensionSessionWrapper.StateCallback getExtensionStateCallback() {
        return this.extensionStateCallback;
    }

    public final OutputConfigurationWrapper getPostviewOutputConfiguration() {
        return this.postviewOutputConfiguration;
    }
}
