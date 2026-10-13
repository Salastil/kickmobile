package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.StreamId;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/compat/OutputConfigurations;", "", "all", "", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "deferred", "", "Landroidx/camera/camera2/pipe/StreamId;", "postviewOutput", "outputSurfaceMap", "Landroidx/camera/camera2/pipe/OutputId;", "Landroid/view/Surface;", "<init>", "(Ljava/util/List;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;Ljava/util/Map;)V", "getAll", "()Ljava/util/List;", "getDeferred", "()Ljava/util/Map;", "getPostviewOutput", "()Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "getOutputSurfaceMap", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OutputConfigurations {
    private final List<OutputConfigurationWrapper> all;
    private final Map<StreamId, OutputConfigurationWrapper> deferred;
    private final Map<OutputId, Surface> outputSurfaceMap;
    private final OutputConfigurationWrapper postviewOutput;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutputConfigurations copy$default(OutputConfigurations outputConfigurations, List list, Map map, OutputConfigurationWrapper outputConfigurationWrapper, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = outputConfigurations.all;
        }
        if ((i & 2) != 0) {
            map = outputConfigurations.deferred;
        }
        if ((i & 4) != 0) {
            outputConfigurationWrapper = outputConfigurations.postviewOutput;
        }
        if ((i & 8) != 0) {
            map2 = outputConfigurations.outputSurfaceMap;
        }
        return outputConfigurations.copy(list, map, outputConfigurationWrapper, map2);
    }

    public final List<OutputConfigurationWrapper> component1() {
        return this.all;
    }

    public final Map<StreamId, OutputConfigurationWrapper> component2() {
        return this.deferred;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OutputConfigurationWrapper getPostviewOutput() {
        return this.postviewOutput;
    }

    public final Map<OutputId, Surface> component4() {
        return this.outputSurfaceMap;
    }

    public final OutputConfigurations copy(List<? extends OutputConfigurationWrapper> all, Map<StreamId, ? extends OutputConfigurationWrapper> deferred, OutputConfigurationWrapper postviewOutput, Map<OutputId, ? extends Surface> outputSurfaceMap) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        Intrinsics.checkNotNullParameter(outputSurfaceMap, "outputSurfaceMap");
        return new OutputConfigurations(all, deferred, postviewOutput, outputSurfaceMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutputConfigurations)) {
            return false;
        }
        OutputConfigurations outputConfigurations = (OutputConfigurations) other;
        return Intrinsics.areEqual(this.all, outputConfigurations.all) && Intrinsics.areEqual(this.deferred, outputConfigurations.deferred) && Intrinsics.areEqual(this.postviewOutput, outputConfigurations.postviewOutput) && Intrinsics.areEqual(this.outputSurfaceMap, outputConfigurations.outputSurfaceMap);
    }

    public int hashCode() {
        int iHashCode = ((this.all.hashCode() * 31) + this.deferred.hashCode()) * 31;
        OutputConfigurationWrapper outputConfigurationWrapper = this.postviewOutput;
        return ((iHashCode + (outputConfigurationWrapper == null ? 0 : outputConfigurationWrapper.hashCode())) * 31) + this.outputSurfaceMap.hashCode();
    }

    public String toString() {
        return "OutputConfigurations(all=" + this.all + ", deferred=" + this.deferred + ", postviewOutput=" + this.postviewOutput + ", outputSurfaceMap=" + this.outputSurfaceMap + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutputConfigurations(List<? extends OutputConfigurationWrapper> all, Map<StreamId, ? extends OutputConfigurationWrapper> deferred, OutputConfigurationWrapper outputConfigurationWrapper, Map<OutputId, ? extends Surface> outputSurfaceMap) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        Intrinsics.checkNotNullParameter(outputSurfaceMap, "outputSurfaceMap");
        this.all = all;
        this.deferred = deferred;
        this.postviewOutput = outputConfigurationWrapper;
        this.outputSurfaceMap = outputSurfaceMap;
    }

    public final List<OutputConfigurationWrapper> getAll() {
        return this.all;
    }

    public final Map<StreamId, OutputConfigurationWrapper> getDeferred() {
        return this.deferred;
    }

    public final OutputConfigurationWrapper getPostviewOutput() {
        return this.postviewOutput;
    }

    public final Map<OutputId, Surface> getOutputSurfaceMap() {
        return this.outputSurfaceMap;
    }
}
