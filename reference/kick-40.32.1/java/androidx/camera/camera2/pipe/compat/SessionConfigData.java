package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraColorSpace;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fHÆ\u0003J\u0012\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b+\u0010!J|\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001d\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00065"}, d2 = {"Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "", "sessionType", "", "inputConfiguration", "", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "outputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "sessionTemplateId", "sessionParameters", "", "sessionColorSpace", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;ILjava/util/Map;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSessionType", "()I", "getInputConfiguration", "()Ljava/util/List;", "getOutputConfigurations", "getExecutor", "()Ljava/util/concurrent/Executor;", "getStateCallback", "()Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "getSessionTemplateId", "getSessionParameters", "()Ljava/util/Map;", "getSessionColorSpace-dxVZaPA", "()Ljava/lang/String;", "Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component8-dxVZaPA", "copy", "copy-WTWd9Ag", "(ILjava/util/List;Ljava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;ILjava/util/Map;Ljava/lang/String;)Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "equals", "", "other", "hashCode", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SessionConfigData {
    private final Executor executor;
    private final List<InputConfigData> inputConfiguration;
    private final List<OutputConfigurationWrapper> outputConfigurations;
    private final String sessionColorSpace;
    private final Map<?, Object> sessionParameters;
    private final int sessionTemplateId;
    private final int sessionType;
    private final CameraCaptureSessionWrapper.StateCallback stateCallback;

    public /* synthetic */ SessionConfigData(int i, List list, List list2, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map map, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, executor, stateCallback, i2, map, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-WTWd9Ag$default, reason: not valid java name */
    public static /* synthetic */ SessionConfigData m904copyWTWd9Ag$default(SessionConfigData sessionConfigData, int i, List list, List list2, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map map, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sessionConfigData.sessionType;
        }
        if ((i3 & 2) != 0) {
            list = sessionConfigData.inputConfiguration;
        }
        if ((i3 & 4) != 0) {
            list2 = sessionConfigData.outputConfigurations;
        }
        if ((i3 & 8) != 0) {
            executor = sessionConfigData.executor;
        }
        if ((i3 & 16) != 0) {
            stateCallback = sessionConfigData.stateCallback;
        }
        if ((i3 & 32) != 0) {
            i2 = sessionConfigData.sessionTemplateId;
        }
        if ((i3 & 64) != 0) {
            map = sessionConfigData.sessionParameters;
        }
        if ((i3 & 128) != 0) {
            str = sessionConfigData.sessionColorSpace;
        }
        Map map2 = map;
        String str2 = str;
        CameraCaptureSessionWrapper.StateCallback stateCallback2 = stateCallback;
        int i4 = i2;
        return sessionConfigData.m906copyWTWd9Ag(i, list, list2, executor, stateCallback2, i4, map2, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSessionType() {
        return this.sessionType;
    }

    public final List<InputConfigData> component2() {
        return this.inputConfiguration;
    }

    public final List<OutputConfigurationWrapper> component3() {
        return this.outputConfigurations;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Executor getExecutor() {
        return this.executor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CameraCaptureSessionWrapper.StateCallback getStateCallback() {
        return this.stateCallback;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSessionTemplateId() {
        return this.sessionTemplateId;
    }

    public final Map<?, Object> component7() {
        return this.sessionParameters;
    }

    /* JADX INFO: renamed from: component8-dxVZaPA, reason: not valid java name and from getter */
    public final String getSessionColorSpace() {
        return this.sessionColorSpace;
    }

    /* JADX INFO: renamed from: copy-WTWd9Ag, reason: not valid java name */
    public final SessionConfigData m906copyWTWd9Ag(int sessionType, List<InputConfigData> inputConfiguration, List<? extends OutputConfigurationWrapper> outputConfigurations, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int sessionTemplateId, Map<?, ? extends Object> sessionParameters, String sessionColorSpace) {
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
        return new SessionConfigData(sessionType, inputConfiguration, outputConfigurations, executor, stateCallback, sessionTemplateId, sessionParameters, sessionColorSpace, null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    public boolean equals(Object other) {
        boolean zM246equalsimpl0;
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfigData)) {
            return false;
        }
        SessionConfigData sessionConfigData = (SessionConfigData) other;
        if (this.sessionType != sessionConfigData.sessionType || !Intrinsics.areEqual(this.inputConfiguration, sessionConfigData.inputConfiguration) || !Intrinsics.areEqual(this.outputConfigurations, sessionConfigData.outputConfigurations) || !Intrinsics.areEqual(this.executor, sessionConfigData.executor) || !Intrinsics.areEqual(this.stateCallback, sessionConfigData.stateCallback) || this.sessionTemplateId != sessionConfigData.sessionTemplateId || !Intrinsics.areEqual(this.sessionParameters, sessionConfigData.sessionParameters)) {
            return false;
        }
        String str = this.sessionColorSpace;
        String str2 = sessionConfigData.sessionColorSpace;
        if (str == null) {
            if (str2 == null) {
                zM246equalsimpl0 = true;
            } else {
                zM246equalsimpl0 = false;
            }
        } else if (str2 == null) {
            zM246equalsimpl0 = false;
        } else {
            zM246equalsimpl0 = CameraColorSpace.m246equalsimpl0(str, str2);
        }
        return zM246equalsimpl0;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.sessionType) * 31;
        List<InputConfigData> list = this.inputConfiguration;
        int iHashCode2 = (((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.outputConfigurations.hashCode()) * 31) + this.executor.hashCode()) * 31) + this.stateCallback.hashCode()) * 31) + Integer.hashCode(this.sessionTemplateId)) * 31) + this.sessionParameters.hashCode()) * 31;
        String str = this.sessionColorSpace;
        return iHashCode2 + (str != null ? CameraColorSpace.m248hashCodeimpl(str) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionConfigData(sessionType=");
        sb.append(this.sessionType);
        sb.append(", inputConfiguration=");
        sb.append(this.inputConfiguration);
        sb.append(", outputConfigurations=");
        sb.append(this.outputConfigurations);
        sb.append(", executor=");
        sb.append(this.executor);
        sb.append(", stateCallback=");
        sb.append(this.stateCallback);
        sb.append(", sessionTemplateId=");
        sb.append(this.sessionTemplateId);
        sb.append(", sessionParameters=");
        sb.append(this.sessionParameters);
        sb.append(", sessionColorSpace=");
        String str = this.sessionColorSpace;
        sb.append((Object) (str == null ? AbstractJsonLexerKt.NULL : CameraColorSpace.m250toStringimpl(str)));
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SessionConfigData(int i, List<InputConfigData> list, List<? extends OutputConfigurationWrapper> outputConfigurations, Executor executor, CameraCaptureSessionWrapper.StateCallback stateCallback, int i2, Map<?, ? extends Object> sessionParameters, String str) {
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
        this.sessionType = i;
        this.inputConfiguration = list;
        this.outputConfigurations = outputConfigurations;
        this.executor = executor;
        this.stateCallback = stateCallback;
        this.sessionTemplateId = i2;
        this.sessionParameters = sessionParameters;
        this.sessionColorSpace = str;
    }

    public final int getSessionType() {
        return this.sessionType;
    }

    public final List<InputConfigData> getInputConfiguration() {
        return this.inputConfiguration;
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

    /* JADX INFO: renamed from: getSessionColorSpace-dxVZaPA, reason: not valid java name */
    public final String m907getSessionColorSpacedxVZaPA() {
        return this.sessionColorSpace;
    }
}
