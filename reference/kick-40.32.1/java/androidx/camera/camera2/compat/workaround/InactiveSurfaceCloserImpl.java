package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InactiveSurfaceCloser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloserImpl;", "Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloser;", "<init>", "()V", "lock", "", "configuredOutputs", "", "Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloserImpl$ConfiguredOutput;", "configure", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "deferrableSurface", "Landroidx/camera/core/impl/DeferrableSurface;", "graph", "Landroidx/camera/camera2/pipe/CameraGraph;", "configure-hB7JTeY", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;)V", "onSurfaceInactive", "closeAll", "closeIfConfigured", "", "ConfiguredOutput", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InactiveSurfaceCloserImpl implements InactiveSurfaceCloser {
    private final Object lock = new Object();
    private final List<ConfiguredOutput> configuredOutputs = new ArrayList();

    @Override // androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser
    /* JADX INFO: renamed from: configure-hB7JTeY */
    public void mo76configurehB7JTeY(int streamId, DeferrableSurface deferrableSurface, CameraGraph graph) {
        Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
        Intrinsics.checkNotNullParameter(graph, "graph");
        synchronized (this.lock) {
            this.configuredOutputs.add(new ConfiguredOutput(streamId, deferrableSurface, graph, null));
        }
    }

    @Override // androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser
    public void onSurfaceInactive(DeferrableSurface deferrableSurface) {
        Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
        synchronized (this.lock) {
            closeIfConfigured(this.configuredOutputs, deferrableSurface);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser
    public void closeAll() {
        synchronized (this.lock) {
            Iterator<T> it = this.configuredOutputs.iterator();
            while (it.hasNext()) {
                ((ConfiguredOutput) it.next()).close();
            }
            this.configuredOutputs.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: InactiveSurfaceCloser.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J.\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloserImpl$ConfiguredOutput;", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "deferrableSurface", "Landroidx/camera/core/impl/DeferrableSurface;", "graph", "Landroidx/camera/camera2/pipe/CameraGraph;", "<init>", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreamId-ptHMqGs", "()I", "I", "getDeferrableSurface", "()Landroidx/camera/core/impl/DeferrableSurface;", "getGraph", "()Landroidx/camera/camera2/pipe/CameraGraph;", "close", "", "contains", "", "component1", "component1-ptHMqGs", "component2", "component3", "copy", "copy-hB7JTeY", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;)Landroidx/camera/camera2/compat/workaround/InactiveSurfaceCloserImpl$ConfiguredOutput;", "equals", "other", "hashCode", "", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ConfiguredOutput {
        private final DeferrableSurface deferrableSurface;
        private final CameraGraph graph;
        private final int streamId;

        public /* synthetic */ ConfiguredOutput(int i, DeferrableSurface deferrableSurface, CameraGraph cameraGraph, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, deferrableSurface, cameraGraph);
        }

        /* JADX INFO: renamed from: copy-hB7JTeY$default, reason: not valid java name */
        public static /* synthetic */ ConfiguredOutput m77copyhB7JTeY$default(ConfiguredOutput configuredOutput, int i, DeferrableSurface deferrableSurface, CameraGraph cameraGraph, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = configuredOutput.streamId;
            }
            if ((i2 & 2) != 0) {
                deferrableSurface = configuredOutput.deferrableSurface;
            }
            if ((i2 & 4) != 0) {
                cameraGraph = configuredOutput.graph;
            }
            return configuredOutput.m79copyhB7JTeY(i, deferrableSurface, cameraGraph);
        }

        /* JADX INFO: renamed from: component1-ptHMqGs, reason: not valid java name and from getter */
        public final int getStreamId() {
            return this.streamId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DeferrableSurface getDeferrableSurface() {
            return this.deferrableSurface;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CameraGraph getGraph() {
            return this.graph;
        }

        /* JADX INFO: renamed from: copy-hB7JTeY, reason: not valid java name */
        public final ConfiguredOutput m79copyhB7JTeY(int streamId, DeferrableSurface deferrableSurface, CameraGraph graph) {
            Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
            Intrinsics.checkNotNullParameter(graph, "graph");
            return new ConfiguredOutput(streamId, deferrableSurface, graph, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfiguredOutput)) {
                return false;
            }
            ConfiguredOutput configuredOutput = (ConfiguredOutput) other;
            return StreamId.m794equalsimpl0(this.streamId, configuredOutput.streamId) && Intrinsics.areEqual(this.deferrableSurface, configuredOutput.deferrableSurface) && Intrinsics.areEqual(this.graph, configuredOutput.graph);
        }

        public int hashCode() {
            return (((StreamId.m795hashCodeimpl(this.streamId) * 31) + this.deferrableSurface.hashCode()) * 31) + this.graph.hashCode();
        }

        public String toString() {
            return "ConfiguredOutput(streamId=" + ((Object) StreamId.m796toStringimpl(this.streamId)) + ", deferrableSurface=" + this.deferrableSurface + ", graph=" + this.graph + ')';
        }

        private ConfiguredOutput(int i, DeferrableSurface deferrableSurface, CameraGraph graph) {
            Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
            Intrinsics.checkNotNullParameter(graph, "graph");
            this.streamId = i;
            this.deferrableSurface = deferrableSurface;
            this.graph = graph;
        }

        /* JADX INFO: renamed from: getStreamId-ptHMqGs, reason: not valid java name */
        public final int m80getStreamIdptHMqGs() {
            return this.streamId;
        }

        public final DeferrableSurface getDeferrableSurface() {
            return this.deferrableSurface;
        }

        public final CameraGraph getGraph() {
            return this.graph;
        }

        public final void close() {
            this.graph.mo424setSurfaceNYG5g8E(this.streamId, null);
            this.deferrableSurface.close();
        }

        public final boolean contains(DeferrableSurface deferrableSurface) {
            Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
            return Intrinsics.areEqual(this.deferrableSurface, deferrableSurface);
        }
    }

    private final void closeIfConfigured(List<ConfiguredOutput> list, DeferrableSurface deferrableSurface) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((ConfiguredOutput) it.next()).contains(deferrableSurface)) {
                deferrableSurface.close();
            }
        }
    }
}
