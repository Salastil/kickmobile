package androidx.camera.camera2.pipe;

import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.camera.camera2.pipe.compat.Camera2Quirks;
import androidx.camera.camera2.pipe.core.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CameraGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0007\u0004\u0005\u0006\u0007\b\t\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/CameraGraphBase;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "Landroidx/camera/camera2/pipe/CameraControls3A;", "Config", "ConcurrentConfig", "RepeatingRequestRequirementsBeforeCapture", "Flags", "OperatingMode", "Constants3A", "Session", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraGraph extends CameraGraphBase<Session>, CameraControls3A {

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u0010\u0010F\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\bG\u0010%J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010L\u001a\u00020\fHÆ\u0003¢\u0006\u0004\bM\u0010.J\u0015\u0010N\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0003J\u0010\u0010O\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bP\u0010.J\u0010\u0010Q\u001a\u00020\fHÆ\u0003¢\u0006\u0004\bR\u0010.J\u0015\u0010S\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003J\u0015\u0010V\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0003J\u0012\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\bX\u0010%J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010Z\u001a\u00020\u001dHÆ\u0003J\t\u0010[\u001a\u00020\u001fHÆ\u0003J\u0012\u0010\\\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b]\u0010%J\u0096\u0002\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b_\u0010`J\u0014\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010d\u001a\u00020eHÖ\u0081\u0004J\n\u0010f\u001a\u00020gHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001d\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u000f\u001a\u00020\u0010¢\u0006\n\n\u0002\u0010/\u001a\u0004\b2\u0010.R\u0013\u0010\u0011\u001a\u00020\f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b3\u0010.R\u001d\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u001d\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00101R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010&\u001a\u0004\b8\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010&\u001a\u0004\b?\u0010%R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006h"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Config;", "", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "streams", "", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "exclusiveStreamGroups", "input", "Landroidx/camera/camera2/pipe/InputStream$Config;", "postviewStream", "sessionTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionParameters", "", "sessionMode", "Landroidx/camera/camera2/pipe/CameraGraph$OperatingMode;", "defaultTemplate", "defaultParameters", "defaultListeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "graphStateListeners", "Landroidx/camera/camera2/pipe/GraphStateListener;", "requiredParameters", "cameraBackendId", "Landroidx/camera/camera2/pipe/CameraBackendId;", "customCameraBackend", "Landroidx/camera/camera2/pipe/CameraBackendFactory;", "metadataTransform", "Landroidx/camera/camera2/pipe/MetadataTransform;", "flags", "Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "sessionColorSpace", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/CameraStream$Config;ILjava/util/Map;IILjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Landroidx/camera/camera2/pipe/CameraBackendFactory;Landroidx/camera/camera2/pipe/MetadataTransform;Landroidx/camera/camera2/pipe/CameraGraph$Flags;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getStreams", "()Ljava/util/List;", "getExclusiveStreamGroups", "getInput", "getPostviewStream", "()Landroidx/camera/camera2/pipe/CameraStream$Config;", "getSessionTemplate-fGx8uWA", "()I", "I", "getSessionParameters", "()Ljava/util/Map;", "getSessionMode-2uNL3no", "getDefaultTemplate-fGx8uWA", "getDefaultParameters", "getDefaultListeners", "getGraphStateListeners", "getRequiredParameters", "getCameraBackendId-AKmI2lo", "getCustomCameraBackend", "()Landroidx/camera/camera2/pipe/CameraBackendFactory;", "getMetadataTransform", "()Landroidx/camera/camera2/pipe/MetadataTransform;", "getFlags", "()Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "getSessionColorSpace-dxVZaPA", "concurrentCameraGraphs", "Landroidx/camera/camera2/pipe/ConcurrentCameraGraphs;", "getConcurrentCameraGraphs$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/ConcurrentCameraGraphs;", "setConcurrentCameraGraphs$camera_camera2_pipe", "(Landroidx/camera/camera2/pipe/ConcurrentCameraGraphs;)V", "component1", "component1-Dz_R5H8", "component2", "component3", "component4", "component5", "component6", "component6-fGx8uWA", "component7", "component8", "component8-2uNL3no", "component9", "component9-fGx8uWA", "component10", "component11", "component12", "component13", "component14", "component14-AKmI2lo", "component15", "component16", "component17", "component18", "component18-dxVZaPA", "copy", "copy-evZ4KcE", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/CameraStream$Config;ILjava/util/Map;IILjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Landroidx/camera/camera2/pipe/CameraBackendFactory;Landroidx/camera/camera2/pipe/MetadataTransform;Landroidx/camera/camera2/pipe/CameraGraph$Flags;Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraGraph$Config;", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Config {
        private final String camera;
        private final String cameraBackendId;
        private ConcurrentCameraGraphs concurrentCameraGraphs;
        private final CameraBackendFactory customCameraBackend;
        private final List<Request.Listener> defaultListeners;
        private final Map<?, Object> defaultParameters;
        private final int defaultTemplate;
        private final List<List<CameraStream.Config>> exclusiveStreamGroups;
        private final Flags flags;
        private final List<GraphStateListener> graphStateListeners;
        private final List<InputStream.Config> input;
        private final MetadataTransform metadataTransform;
        private final CameraStream.Config postviewStream;
        private final Map<?, Object> requiredParameters;
        private final String sessionColorSpace;
        private final int sessionMode;
        private final Map<?, Object> sessionParameters;
        private final int sessionTemplate;
        private final List<CameraStream.Config> streams;

        public /* synthetic */ Config(String str, List list, List list2, List list3, CameraStream.Config config, int i, Map map, int i2, int i3, Map map2, List list4, List list5, Map map3, String str2, CameraBackendFactory cameraBackendFactory, MetadataTransform metadataTransform, Flags flags, String str3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, list2, list3, config, i, map, i2, i3, map2, list4, list5, map3, str2, cameraBackendFactory, metadataTransform, flags, str3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-evZ4KcE$default, reason: not valid java name */
        public static /* synthetic */ Config m377copyevZ4KcE$default(Config config, String str, List list, List list2, List list3, CameraStream.Config config2, int i, Map map, int i2, int i3, Map map2, List list4, List list5, Map map3, String str2, CameraBackendFactory cameraBackendFactory, MetadataTransform metadataTransform, Flags flags, String str3, int i4, Object obj) {
            String str4;
            Flags flags2;
            String str5 = (i4 & 1) != 0 ? config.camera : str;
            List list6 = (i4 & 2) != 0 ? config.streams : list;
            List list7 = (i4 & 4) != 0 ? config.exclusiveStreamGroups : list2;
            List list8 = (i4 & 8) != 0 ? config.input : list3;
            CameraStream.Config config3 = (i4 & 16) != 0 ? config.postviewStream : config2;
            int i5 = (i4 & 32) != 0 ? config.sessionTemplate : i;
            Map map4 = (i4 & 64) != 0 ? config.sessionParameters : map;
            int i6 = (i4 & 128) != 0 ? config.sessionMode : i2;
            int i7 = (i4 & 256) != 0 ? config.defaultTemplate : i3;
            Map map5 = (i4 & 512) != 0 ? config.defaultParameters : map2;
            List list9 = (i4 & 1024) != 0 ? config.defaultListeners : list4;
            List list10 = (i4 & 2048) != 0 ? config.graphStateListeners : list5;
            Map map6 = (i4 & 4096) != 0 ? config.requiredParameters : map3;
            String str6 = (i4 & 8192) != 0 ? config.cameraBackendId : str2;
            String str7 = str5;
            CameraBackendFactory cameraBackendFactory2 = (i4 & 16384) != 0 ? config.customCameraBackend : cameraBackendFactory;
            MetadataTransform metadataTransform2 = (i4 & 32768) != 0 ? config.metadataTransform : metadataTransform;
            Flags flags3 = (i4 & 65536) != 0 ? config.flags : flags;
            if ((i4 & 131072) != 0) {
                flags2 = flags3;
                str4 = config.sessionColorSpace;
            } else {
                str4 = str3;
                flags2 = flags3;
            }
            return config.m384copyevZ4KcE(str7, list6, list7, list8, config3, i5, map4, i6, i7, map5, list9, list10, map6, str6, cameraBackendFactory2, metadataTransform2, flags2, str4);
        }

        /* JADX INFO: renamed from: component1-Dz_R5H8, reason: not valid java name and from getter */
        public final String getCamera() {
            return this.camera;
        }

        public final Map<?, Object> component10() {
            return this.defaultParameters;
        }

        public final List<Request.Listener> component11() {
            return this.defaultListeners;
        }

        public final List<GraphStateListener> component12() {
            return this.graphStateListeners;
        }

        public final Map<?, Object> component13() {
            return this.requiredParameters;
        }

        /* JADX INFO: renamed from: component14-AKmI2lo, reason: not valid java name and from getter */
        public final String getCameraBackendId() {
            return this.cameraBackendId;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final CameraBackendFactory getCustomCameraBackend() {
            return this.customCameraBackend;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final MetadataTransform getMetadataTransform() {
            return this.metadataTransform;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Flags getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component18-dxVZaPA, reason: not valid java name and from getter */
        public final String getSessionColorSpace() {
            return this.sessionColorSpace;
        }

        public final List<CameraStream.Config> component2() {
            return this.streams;
        }

        public final List<List<CameraStream.Config>> component3() {
            return this.exclusiveStreamGroups;
        }

        public final List<InputStream.Config> component4() {
            return this.input;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CameraStream.Config getPostviewStream() {
            return this.postviewStream;
        }

        /* JADX INFO: renamed from: component6-fGx8uWA, reason: not valid java name and from getter */
        public final int getSessionTemplate() {
            return this.sessionTemplate;
        }

        public final Map<?, Object> component7() {
            return this.sessionParameters;
        }

        /* JADX INFO: renamed from: component8-2uNL3no, reason: not valid java name and from getter */
        public final int getSessionMode() {
            return this.sessionMode;
        }

        /* JADX INFO: renamed from: component9-fGx8uWA, reason: not valid java name and from getter */
        public final int getDefaultTemplate() {
            return this.defaultTemplate;
        }

        /* JADX INFO: renamed from: copy-evZ4KcE, reason: not valid java name */
        public final Config m384copyevZ4KcE(String camera, List<CameraStream.Config> streams, List<? extends List<CameraStream.Config>> exclusiveStreamGroups, List<InputStream.Config> input, CameraStream.Config postviewStream, int sessionTemplate, Map<?, ? extends Object> sessionParameters, int sessionMode, int defaultTemplate, Map<?, ? extends Object> defaultParameters, List<? extends Request.Listener> defaultListeners, List<? extends GraphStateListener> graphStateListeners, Map<?, ? extends Object> requiredParameters, String cameraBackendId, CameraBackendFactory customCameraBackend, MetadataTransform metadataTransform, Flags flags, String sessionColorSpace) {
            Intrinsics.checkNotNullParameter(camera, "camera");
            Intrinsics.checkNotNullParameter(streams, "streams");
            Intrinsics.checkNotNullParameter(exclusiveStreamGroups, "exclusiveStreamGroups");
            Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
            Intrinsics.checkNotNullParameter(defaultParameters, "defaultParameters");
            Intrinsics.checkNotNullParameter(defaultListeners, "defaultListeners");
            Intrinsics.checkNotNullParameter(graphStateListeners, "graphStateListeners");
            Intrinsics.checkNotNullParameter(requiredParameters, "requiredParameters");
            Intrinsics.checkNotNullParameter(metadataTransform, "metadataTransform");
            Intrinsics.checkNotNullParameter(flags, "flags");
            return new Config(camera, streams, exclusiveStreamGroups, input, postviewStream, sessionTemplate, sessionParameters, sessionMode, defaultTemplate, defaultParameters, defaultListeners, graphStateListeners, requiredParameters, cameraBackendId, customCameraBackend, metadataTransform, flags, sessionColorSpace, null);
        }

        /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:70:0x00dd  */
        public boolean equals(Object other) {
            boolean zM238equalsimpl0;
            boolean zM246equalsimpl0;
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            if (!CameraId.m429equalsimpl0(this.camera, config.camera) || !Intrinsics.areEqual(this.streams, config.streams) || !Intrinsics.areEqual(this.exclusiveStreamGroups, config.exclusiveStreamGroups) || !Intrinsics.areEqual(this.input, config.input) || !Intrinsics.areEqual(this.postviewStream, config.postviewStream) || !RequestTemplate.m717equalsimpl0(this.sessionTemplate, config.sessionTemplate) || !Intrinsics.areEqual(this.sessionParameters, config.sessionParameters) || !OperatingMode.m410equalsimpl0(this.sessionMode, config.sessionMode) || !RequestTemplate.m717equalsimpl0(this.defaultTemplate, config.defaultTemplate) || !Intrinsics.areEqual(this.defaultParameters, config.defaultParameters) || !Intrinsics.areEqual(this.defaultListeners, config.defaultListeners) || !Intrinsics.areEqual(this.graphStateListeners, config.graphStateListeners) || !Intrinsics.areEqual(this.requiredParameters, config.requiredParameters)) {
                return false;
            }
            String str = this.cameraBackendId;
            String str2 = config.cameraBackendId;
            if (str == null) {
                if (str2 == null) {
                    zM238equalsimpl0 = true;
                } else {
                    zM238equalsimpl0 = false;
                }
            } else if (str2 == null) {
                zM238equalsimpl0 = false;
            } else {
                zM238equalsimpl0 = CameraBackendId.m238equalsimpl0(str, str2);
            }
            if (!zM238equalsimpl0 || !Intrinsics.areEqual(this.customCameraBackend, config.customCameraBackend) || !Intrinsics.areEqual(this.metadataTransform, config.metadataTransform) || !Intrinsics.areEqual(this.flags, config.flags)) {
                return false;
            }
            String str3 = this.sessionColorSpace;
            String str4 = config.sessionColorSpace;
            if (str3 == null) {
                if (str4 == null) {
                    zM246equalsimpl0 = true;
                } else {
                    zM246equalsimpl0 = false;
                }
            } else if (str4 == null) {
                zM246equalsimpl0 = false;
            } else {
                zM246equalsimpl0 = CameraColorSpace.m246equalsimpl0(str3, str4);
            }
            return zM246equalsimpl0;
        }

        public int hashCode() {
            int iM430hashCodeimpl = ((((CameraId.m430hashCodeimpl(this.camera) * 31) + this.streams.hashCode()) * 31) + this.exclusiveStreamGroups.hashCode()) * 31;
            List<InputStream.Config> list = this.input;
            int iHashCode = (iM430hashCodeimpl + (list == null ? 0 : list.hashCode())) * 31;
            CameraStream.Config config = this.postviewStream;
            int iHashCode2 = (((((((((((((((((iHashCode + (config == null ? 0 : config.hashCode())) * 31) + RequestTemplate.m719hashCodeimpl(this.sessionTemplate)) * 31) + this.sessionParameters.hashCode()) * 31) + OperatingMode.m411hashCodeimpl(this.sessionMode)) * 31) + RequestTemplate.m719hashCodeimpl(this.defaultTemplate)) * 31) + this.defaultParameters.hashCode()) * 31) + this.defaultListeners.hashCode()) * 31) + this.graphStateListeners.hashCode()) * 31) + this.requiredParameters.hashCode()) * 31;
            String str = this.cameraBackendId;
            int iM239hashCodeimpl = (iHashCode2 + (str == null ? 0 : CameraBackendId.m239hashCodeimpl(str))) * 31;
            CameraBackendFactory cameraBackendFactory = this.customCameraBackend;
            int iHashCode3 = (((((iM239hashCodeimpl + (cameraBackendFactory == null ? 0 : cameraBackendFactory.hashCode())) * 31) + this.metadataTransform.hashCode()) * 31) + this.flags.hashCode()) * 31;
            String str2 = this.sessionColorSpace;
            return iHashCode3 + (str2 != null ? CameraColorSpace.m248hashCodeimpl(str2) : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Config(camera=");
            sb.append((Object) CameraId.m432toStringimpl(this.camera));
            sb.append(", streams=");
            sb.append(this.streams);
            sb.append(", exclusiveStreamGroups=");
            sb.append(this.exclusiveStreamGroups);
            sb.append(", input=");
            sb.append(this.input);
            sb.append(", postviewStream=");
            sb.append(this.postviewStream);
            sb.append(", sessionTemplate=");
            sb.append((Object) RequestTemplate.m720toStringimpl(this.sessionTemplate));
            sb.append(", sessionParameters=");
            sb.append(this.sessionParameters);
            sb.append(", sessionMode=");
            sb.append((Object) OperatingMode.m412toStringimpl(this.sessionMode));
            sb.append(", defaultTemplate=");
            sb.append((Object) RequestTemplate.m720toStringimpl(this.defaultTemplate));
            sb.append(", defaultParameters=");
            sb.append(this.defaultParameters);
            sb.append(", defaultListeners=");
            sb.append(this.defaultListeners);
            sb.append(", graphStateListeners=");
            sb.append(this.graphStateListeners);
            sb.append(", requiredParameters=");
            sb.append(this.requiredParameters);
            sb.append(", cameraBackendId=");
            String str = this.cameraBackendId;
            String strM250toStringimpl = AbstractJsonLexerKt.NULL;
            sb.append((Object) (str == null ? AbstractJsonLexerKt.NULL : CameraBackendId.m240toStringimpl(str)));
            sb.append(", customCameraBackend=");
            sb.append(this.customCameraBackend);
            sb.append(", metadataTransform=");
            sb.append(this.metadataTransform);
            sb.append(", flags=");
            sb.append(this.flags);
            sb.append(", sessionColorSpace=");
            String str2 = this.sessionColorSpace;
            if (str2 != null) {
                strM250toStringimpl = CameraColorSpace.m250toStringimpl(str2);
            }
            sb.append((Object) strM250toStringimpl);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Config(String camera, List<CameraStream.Config> streams, List<? extends List<CameraStream.Config>> exclusiveStreamGroups, List<InputStream.Config> list, CameraStream.Config config, int i, Map<?, ? extends Object> sessionParameters, int i2, int i3, Map<?, ? extends Object> defaultParameters, List<? extends Request.Listener> defaultListeners, List<? extends GraphStateListener> graphStateListeners, Map<?, ? extends Object> requiredParameters, String str, CameraBackendFactory cameraBackendFactory, MetadataTransform metadataTransform, Flags flags, String str2) {
            Intrinsics.checkNotNullParameter(camera, "camera");
            Intrinsics.checkNotNullParameter(streams, "streams");
            Intrinsics.checkNotNullParameter(exclusiveStreamGroups, "exclusiveStreamGroups");
            Intrinsics.checkNotNullParameter(sessionParameters, "sessionParameters");
            Intrinsics.checkNotNullParameter(defaultParameters, "defaultParameters");
            Intrinsics.checkNotNullParameter(defaultListeners, "defaultListeners");
            Intrinsics.checkNotNullParameter(graphStateListeners, "graphStateListeners");
            Intrinsics.checkNotNullParameter(requiredParameters, "requiredParameters");
            Intrinsics.checkNotNullParameter(metadataTransform, "metadataTransform");
            Intrinsics.checkNotNullParameter(flags, "flags");
            this.camera = camera;
            this.streams = streams;
            this.exclusiveStreamGroups = exclusiveStreamGroups;
            this.input = list;
            this.postviewStream = config;
            this.sessionTemplate = i;
            this.sessionParameters = sessionParameters;
            this.sessionMode = i2;
            this.defaultTemplate = i3;
            this.defaultParameters = defaultParameters;
            this.defaultListeners = defaultListeners;
            this.graphStateListeners = graphStateListeners;
            this.requiredParameters = requiredParameters;
            this.cameraBackendId = str;
            this.customCameraBackend = cameraBackendFactory;
            this.metadataTransform = metadataTransform;
            this.flags = flags;
            this.sessionColorSpace = str2;
            if (str != null && cameraBackendFactory != null) {
                throw new IllegalStateException("Setting both cameraBackendId and customCameraBackend is not supported.".toString());
            }
        }

        /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name */
        public final String m385getCameraDz_R5H8() {
            return this.camera;
        }

        public final List<CameraStream.Config> getStreams() {
            return this.streams;
        }

        public /* synthetic */ Config(String str, List list, List list2, List list3, CameraStream.Config config, int i, Map map, int i2, int i3, Map map2, List list4, List list5, Map map3, String str2, CameraBackendFactory cameraBackendFactory, MetadataTransform metadataTransform, Flags flags, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i4 & 4) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 8) != 0 ? null : list3, (i4 & 16) != 0 ? null : config, (i4 & 32) != 0 ? RequestTemplate.m715constructorimpl(1) : i, (i4 & 64) != 0 ? MapsKt.emptyMap() : map, (i4 & 128) != 0 ? OperatingMode.INSTANCE.m417getNORMAL2uNL3no() : i2, (i4 & 256) != 0 ? RequestTemplate.m715constructorimpl(1) : i3, (i4 & 512) != 0 ? MapsKt.emptyMap() : map2, (i4 & 1024) != 0 ? CollectionsKt.emptyList() : list4, (i4 & 2048) != 0 ? CollectionsKt.emptyList() : list5, (i4 & 4096) != 0 ? MapsKt.emptyMap() : map3, (i4 & 8192) != 0 ? null : str2, (i4 & 16384) != 0 ? null : cameraBackendFactory, (32768 & i4) != 0 ? new MetadataTransform(0, 0, null, 7, null) : metadataTransform, (65536 & i4) != 0 ? new Flags(false, false, null, null, 0, false, false, false, 255, null) : flags, (i4 & 131072) != 0 ? null : str3, null);
        }

        public final List<List<CameraStream.Config>> getExclusiveStreamGroups() {
            return this.exclusiveStreamGroups;
        }

        public final List<InputStream.Config> getInput() {
            return this.input;
        }

        public final CameraStream.Config getPostviewStream() {
            return this.postviewStream;
        }

        /* JADX INFO: renamed from: getSessionTemplate-fGx8uWA, reason: not valid java name */
        public final int m390getSessionTemplatefGx8uWA() {
            return this.sessionTemplate;
        }

        public final Map<?, Object> getSessionParameters() {
            return this.sessionParameters;
        }

        /* JADX INFO: renamed from: getSessionMode-2uNL3no, reason: not valid java name */
        public final int m389getSessionMode2uNL3no() {
            return this.sessionMode;
        }

        /* JADX INFO: renamed from: getDefaultTemplate-fGx8uWA, reason: not valid java name */
        public final int m387getDefaultTemplatefGx8uWA() {
            return this.defaultTemplate;
        }

        public final Map<?, Object> getDefaultParameters() {
            return this.defaultParameters;
        }

        public final List<Request.Listener> getDefaultListeners() {
            return this.defaultListeners;
        }

        public final List<GraphStateListener> getGraphStateListeners() {
            return this.graphStateListeners;
        }

        public final Map<?, Object> getRequiredParameters() {
            return this.requiredParameters;
        }

        /* JADX INFO: renamed from: getCameraBackendId-AKmI2lo, reason: not valid java name */
        public final String m386getCameraBackendIdAKmI2lo() {
            return this.cameraBackendId;
        }

        public final CameraBackendFactory getCustomCameraBackend() {
            return this.customCameraBackend;
        }

        public final MetadataTransform getMetadataTransform() {
            return this.metadataTransform;
        }

        public final Flags getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: getSessionColorSpace-dxVZaPA, reason: not valid java name */
        public final String m388getSessionColorSpacedxVZaPA() {
            return this.sessionColorSpace;
        }

        /* JADX INFO: renamed from: getConcurrentCameraGraphs$camera_camera2_pipe, reason: from getter */
        public final ConcurrentCameraGraphs getConcurrentCameraGraphs() {
            return this.concurrentCameraGraphs;
        }

        public final void setConcurrentCameraGraphs$camera_camera2_pipe(ConcurrentCameraGraphs concurrentCameraGraphs) {
            this.concurrentCameraGraphs = concurrentCameraGraphs;
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;", "", "graphConfigs", "", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "<init>", "(Ljava/util/List;)V", "getGraphConfigs", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConcurrentConfig {
        private final List<Config> graphConfigs;

        public ConcurrentConfig(List<Config> graphConfigs) {
            Intrinsics.checkNotNullParameter(graphConfigs, "graphConfigs");
            this.graphConfigs = graphConfigs;
            if (graphConfigs.size() < 2) {
                throw new IllegalStateException("Cannot create ConcurrentGraphConfig without 2 or more CameraGraph.Config(s)".toString());
            }
            Config config = (Config) CollectionsKt.first((List) graphConfigs);
            List<Config> list = graphConfigs;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String strM386getCameraBackendIdAKmI2lo = ((Config) it.next()).m386getCameraBackendIdAKmI2lo();
                    String strM386getCameraBackendIdAKmI2lo2 = config.m386getCameraBackendIdAKmI2lo();
                    boolean zM238equalsimpl0 = false;
                    if (strM386getCameraBackendIdAKmI2lo == null) {
                        if (strM386getCameraBackendIdAKmI2lo2 == null) {
                            zM238equalsimpl0 = true;
                        }
                    } else if (strM386getCameraBackendIdAKmI2lo2 != null) {
                        zM238equalsimpl0 = CameraBackendId.m238equalsimpl0(strM386getCameraBackendIdAKmI2lo, strM386getCameraBackendIdAKmI2lo2);
                    }
                    if (!zM238equalsimpl0) {
                        throw new IllegalStateException("Each CameraGraph.Config must use the same camera backend!".toString());
                    }
                }
            }
            List<Config> list2 = this.graphConfigs;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(CameraId.m426boximpl(((Config) it2.next()).m385getCameraDz_R5H8()));
            }
            if (CollectionsKt.distinct(arrayList).size() != this.graphConfigs.size()) {
                throw new IllegalStateException("Each CameraGraph.Config must have a distinct camera id!".toString());
            }
        }

        public final List<Config> getGraphConfigs() {
            return this.graphConfigs;
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "", "repeatingFramesToComplete", "Lkotlin/UInt;", "completionBehavior", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "<init>", "(ILandroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRepeatingFramesToComplete-pVg5ArA", "()I", "I", "getCompletionBehavior", "()Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "CompletionBehavior", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RepeatingRequestRequirementsBeforeCapture {
        private final CompletionBehavior completionBehavior;
        private final int repeatingFramesToComplete;

        /* JADX INFO: compiled from: CameraGraph.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "AT_LEAST", "EXACT", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum CompletionBehavior {
            AT_LEAST,
            EXACT;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<CompletionBehavior> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ RepeatingRequestRequirementsBeforeCapture(int i, CompletionBehavior completionBehavior, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, completionBehavior);
        }

        private RepeatingRequestRequirementsBeforeCapture(int i, CompletionBehavior completionBehavior) {
            Intrinsics.checkNotNullParameter(completionBehavior, "completionBehavior");
            this.repeatingFramesToComplete = i;
            this.completionBehavior = completionBehavior;
        }

        /* JADX INFO: renamed from: getRepeatingFramesToComplete-pVg5ArA, reason: not valid java name and from getter */
        public final int getRepeatingFramesToComplete() {
            return this.repeatingFramesToComplete;
        }

        public /* synthetic */ RepeatingRequestRequirementsBeforeCapture(int i, CompletionBehavior completionBehavior, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CompletionBehavior.AT_LEAST : completionBehavior, null);
        }

        public final CompletionBehavior getCompletionBehavior() {
            return this.completionBehavior;
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001/BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jb\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0014\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u00060"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "", "configureBlankSessionOnStop", "", "abortCapturesOnStop", "awaitRepeatingRequestBeforeCapture", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "awaitRepeatingRequestOnDisconnect", "finalizeSessionOnCloseBehavior", "Landroidx/camera/camera2/pipe/CameraGraph$Flags$FinalizeSessionOnCloseBehavior;", "closeCaptureSessionOnDisconnect", "closeCameraDeviceOnClose", "enableRestartDelays", "<init>", "(ZZLandroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;Ljava/lang/Boolean;IZZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfigureBlankSessionOnStop", "()Z", "getAbortCapturesOnStop", "getAwaitRepeatingRequestBeforeCapture", "()Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "getAwaitRepeatingRequestOnDisconnect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFinalizeSessionOnCloseBehavior-Bm6Tfm4", "()I", "I", "getCloseCaptureSessionOnDisconnect", "getCloseCameraDeviceOnClose", "getEnableRestartDelays", "component1", "component2", "component3", "component4", "component5", "component5-Bm6Tfm4", "component6", "component7", "component8", "copy", "copy-LsLUW-E", "(ZZLandroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;Ljava/lang/Boolean;IZZZ)Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "equals", "other", "hashCode", "", "toString", "", "FinalizeSessionOnCloseBehavior", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Flags {
        private final boolean abortCapturesOnStop;
        private final RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture;
        private final Boolean awaitRepeatingRequestOnDisconnect;
        private final boolean closeCameraDeviceOnClose;
        private final boolean closeCaptureSessionOnDisconnect;
        private final boolean configureBlankSessionOnStop;
        private final boolean enableRestartDelays;
        private final int finalizeSessionOnCloseBehavior;

        public /* synthetic */ Flags(boolean z, boolean z2, RepeatingRequestRequirementsBeforeCapture repeatingRequestRequirementsBeforeCapture, Boolean bool, int i, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, repeatingRequestRequirementsBeforeCapture, bool, i, z3, z4, z5);
        }

        /* JADX INFO: renamed from: copy-LsLUW-E$default, reason: not valid java name */
        public static /* synthetic */ Flags m392copyLsLUWE$default(Flags flags, boolean z, boolean z2, RepeatingRequestRequirementsBeforeCapture repeatingRequestRequirementsBeforeCapture, Boolean bool, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = flags.configureBlankSessionOnStop;
            }
            if ((i2 & 2) != 0) {
                z2 = flags.abortCapturesOnStop;
            }
            if ((i2 & 4) != 0) {
                repeatingRequestRequirementsBeforeCapture = flags.awaitRepeatingRequestBeforeCapture;
            }
            if ((i2 & 8) != 0) {
                bool = flags.awaitRepeatingRequestOnDisconnect;
            }
            if ((i2 & 16) != 0) {
                i = flags.finalizeSessionOnCloseBehavior;
            }
            if ((i2 & 32) != 0) {
                z3 = flags.closeCaptureSessionOnDisconnect;
            }
            if ((i2 & 64) != 0) {
                z4 = flags.closeCameraDeviceOnClose;
            }
            if ((i2 & 128) != 0) {
                z5 = flags.enableRestartDelays;
            }
            boolean z6 = z4;
            boolean z7 = z5;
            int i3 = i;
            boolean z8 = z3;
            return flags.m394copyLsLUWE(z, z2, repeatingRequestRequirementsBeforeCapture, bool, i3, z8, z6, z7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getConfigureBlankSessionOnStop() {
            return this.configureBlankSessionOnStop;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAbortCapturesOnStop() {
            return this.abortCapturesOnStop;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final RepeatingRequestRequirementsBeforeCapture getAwaitRepeatingRequestBeforeCapture() {
            return this.awaitRepeatingRequestBeforeCapture;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getAwaitRepeatingRequestOnDisconnect() {
            return this.awaitRepeatingRequestOnDisconnect;
        }

        /* JADX INFO: renamed from: component5-Bm6Tfm4, reason: not valid java name and from getter */
        public final int getFinalizeSessionOnCloseBehavior() {
            return this.finalizeSessionOnCloseBehavior;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCloseCaptureSessionOnDisconnect() {
            return this.closeCaptureSessionOnDisconnect;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getCloseCameraDeviceOnClose() {
            return this.closeCameraDeviceOnClose;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getEnableRestartDelays() {
            return this.enableRestartDelays;
        }

        /* JADX INFO: renamed from: copy-LsLUW-E, reason: not valid java name */
        public final Flags m394copyLsLUWE(boolean configureBlankSessionOnStop, boolean abortCapturesOnStop, RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture, Boolean awaitRepeatingRequestOnDisconnect, int finalizeSessionOnCloseBehavior, boolean closeCaptureSessionOnDisconnect, boolean closeCameraDeviceOnClose, boolean enableRestartDelays) {
            Intrinsics.checkNotNullParameter(awaitRepeatingRequestBeforeCapture, "awaitRepeatingRequestBeforeCapture");
            return new Flags(configureBlankSessionOnStop, abortCapturesOnStop, awaitRepeatingRequestBeforeCapture, awaitRepeatingRequestOnDisconnect, finalizeSessionOnCloseBehavior, closeCaptureSessionOnDisconnect, closeCameraDeviceOnClose, enableRestartDelays, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Flags)) {
                return false;
            }
            Flags flags = (Flags) other;
            return this.configureBlankSessionOnStop == flags.configureBlankSessionOnStop && this.abortCapturesOnStop == flags.abortCapturesOnStop && Intrinsics.areEqual(this.awaitRepeatingRequestBeforeCapture, flags.awaitRepeatingRequestBeforeCapture) && Intrinsics.areEqual(this.awaitRepeatingRequestOnDisconnect, flags.awaitRepeatingRequestOnDisconnect) && FinalizeSessionOnCloseBehavior.m399equalsimpl0(this.finalizeSessionOnCloseBehavior, flags.finalizeSessionOnCloseBehavior) && this.closeCaptureSessionOnDisconnect == flags.closeCaptureSessionOnDisconnect && this.closeCameraDeviceOnClose == flags.closeCameraDeviceOnClose && this.enableRestartDelays == flags.enableRestartDelays;
        }

        public int hashCode() {
            int iHashCode = ((((Boolean.hashCode(this.configureBlankSessionOnStop) * 31) + Boolean.hashCode(this.abortCapturesOnStop)) * 31) + this.awaitRepeatingRequestBeforeCapture.hashCode()) * 31;
            Boolean bool = this.awaitRepeatingRequestOnDisconnect;
            return ((((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + FinalizeSessionOnCloseBehavior.m400hashCodeimpl(this.finalizeSessionOnCloseBehavior)) * 31) + Boolean.hashCode(this.closeCaptureSessionOnDisconnect)) * 31) + Boolean.hashCode(this.closeCameraDeviceOnClose)) * 31) + Boolean.hashCode(this.enableRestartDelays);
        }

        public String toString() {
            return "Flags(configureBlankSessionOnStop=" + this.configureBlankSessionOnStop + ", abortCapturesOnStop=" + this.abortCapturesOnStop + ", awaitRepeatingRequestBeforeCapture=" + this.awaitRepeatingRequestBeforeCapture + ", awaitRepeatingRequestOnDisconnect=" + this.awaitRepeatingRequestOnDisconnect + ", finalizeSessionOnCloseBehavior=" + ((Object) FinalizeSessionOnCloseBehavior.m401toStringimpl(this.finalizeSessionOnCloseBehavior)) + ", closeCaptureSessionOnDisconnect=" + this.closeCaptureSessionOnDisconnect + ", closeCameraDeviceOnClose=" + this.closeCameraDeviceOnClose + ", enableRestartDelays=" + this.enableRestartDelays + ')';
        }

        private Flags(boolean z, boolean z2, RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture, Boolean bool, int i, boolean z3, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(awaitRepeatingRequestBeforeCapture, "awaitRepeatingRequestBeforeCapture");
            this.configureBlankSessionOnStop = z;
            this.abortCapturesOnStop = z2;
            this.awaitRepeatingRequestBeforeCapture = awaitRepeatingRequestBeforeCapture;
            this.awaitRepeatingRequestOnDisconnect = bool;
            this.finalizeSessionOnCloseBehavior = i;
            this.closeCaptureSessionOnDisconnect = z3;
            this.closeCameraDeviceOnClose = z4;
            this.enableRestartDelays = z5;
        }

        public final boolean getConfigureBlankSessionOnStop() {
            return this.configureBlankSessionOnStop;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Flags(boolean z, boolean z2, RepeatingRequestRequirementsBeforeCapture repeatingRequestRequirementsBeforeCapture, Boolean bool, int i, boolean z3, boolean z4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            int i3 = 0;
            z = (i2 & 1) != 0 ? false : z;
            if ((i2 & 2) != 0) {
                z2 = Build.VERSION.SDK_INT >= 30;
            }
            this(z, z2, (i2 & 4) != 0 ? new RepeatingRequestRequirementsBeforeCapture(i3, null, 3, 0 == true ? 1 : 0) : repeatingRequestRequirementsBeforeCapture, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? FinalizeSessionOnCloseBehavior.INSTANCE.m404getOFFBm6Tfm4() : i, (i2 & 32) != 0 ? Camera2Quirks.INSTANCE.shouldCloseCaptureSessionOnDisconnect$camera_camera2_pipe() : z3, (i2 & 64) != 0 ? false : z4, (i2 & 128) != 0 ? false : z5, null);
        }

        public final boolean getAbortCapturesOnStop() {
            return this.abortCapturesOnStop;
        }

        public final RepeatingRequestRequirementsBeforeCapture getAwaitRepeatingRequestBeforeCapture() {
            return this.awaitRepeatingRequestBeforeCapture;
        }

        public final Boolean getAwaitRepeatingRequestOnDisconnect() {
            return this.awaitRepeatingRequestOnDisconnect;
        }

        /* JADX INFO: renamed from: getFinalizeSessionOnCloseBehavior-Bm6Tfm4, reason: not valid java name */
        public final int m395getFinalizeSessionOnCloseBehaviorBm6Tfm4() {
            return this.finalizeSessionOnCloseBehavior;
        }

        public final boolean getCloseCaptureSessionOnDisconnect() {
            return this.closeCaptureSessionOnDisconnect;
        }

        public final boolean getCloseCameraDeviceOnClose() {
            return this.closeCameraDeviceOnClose;
        }

        public final boolean getEnableRestartDelays() {
            return this.enableRestartDelays;
        }

        /* JADX INFO: compiled from: CameraGraph.kt */
        @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Flags$FinalizeSessionOnCloseBehavior;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @JvmInline
        public static final class FinalizeSessionOnCloseBehavior {
            private final int value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final int OFF = m397constructorimpl(0);
            private static final int IMMEDIATE = m397constructorimpl(1);
            private static final int TIMEOUT = m397constructorimpl(2);

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ FinalizeSessionOnCloseBehavior m396boximpl(int i) {
                return new FinalizeSessionOnCloseBehavior(i);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            private static int m397constructorimpl(int i) {
                return i;
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m398equalsimpl(int i, Object obj) {
                return (obj instanceof FinalizeSessionOnCloseBehavior) && i == ((FinalizeSessionOnCloseBehavior) obj).m402unboximpl();
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m399equalsimpl0(int i, int i2) {
                return i == i2;
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m400hashCodeimpl(int i) {
                return Integer.hashCode(i);
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static String m401toStringimpl(int i) {
                return "FinalizeSessionOnCloseBehavior(value=" + i + ')';
            }

            public boolean equals(Object obj) {
                return m398equalsimpl(this.value, obj);
            }

            public int hashCode() {
                return m400hashCodeimpl(this.value);
            }

            public String toString() {
                return m401toStringimpl(this.value);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ int m402unboximpl() {
                return this.value;
            }

            /* JADX INFO: compiled from: CameraGraph.kt */
            @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Flags$FinalizeSessionOnCloseBehavior$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/pipe/CameraGraph$Flags$FinalizeSessionOnCloseBehavior;", "getOFF-Bm6Tfm4", "()I", "I", "IMMEDIATE", "getIMMEDIATE-Bm6Tfm4", "TIMEOUT", "getTIMEOUT-Bm6Tfm4", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX INFO: renamed from: getOFF-Bm6Tfm4, reason: not valid java name */
                public final int m404getOFFBm6Tfm4() {
                    return FinalizeSessionOnCloseBehavior.OFF;
                }

                /* JADX INFO: renamed from: getIMMEDIATE-Bm6Tfm4, reason: not valid java name */
                public final int m403getIMMEDIATEBm6Tfm4() {
                    return FinalizeSessionOnCloseBehavior.IMMEDIATE;
                }

                /* JADX INFO: renamed from: getTIMEOUT-Bm6Tfm4, reason: not valid java name */
                public final int m405getTIMEOUTBm6Tfm4() {
                    return FinalizeSessionOnCloseBehavior.TIMEOUT;
                }
            }

            private /* synthetic */ FinalizeSessionOnCloseBehavior(int i) {
                this.value = i;
            }

            public final int getValue() {
                return this.value;
            }
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\f\u0010\u0005J\u0011\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$OperatingMode;", "", "mode", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class OperatingMode {
        private final int mode;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int NORMAL = m408constructorimpl(0);
        private static final int HIGH_SPEED = m408constructorimpl(1);
        private static final int EXTENSION = m408constructorimpl(2);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ OperatingMode m407boximpl(int i) {
            return new OperatingMode(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m408constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m409equalsimpl(int i, Object obj) {
            return (obj instanceof OperatingMode) && i == ((OperatingMode) obj).getMode();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m410equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m411hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m412toStringimpl(int i) {
            return "OperatingMode(mode=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m409equalsimpl(this.mode, obj);
        }

        public int hashCode() {
            return m411hashCodeimpl(this.mode);
        }

        public String toString() {
            return m412toStringimpl(this.mode);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getMode() {
            return this.mode;
        }

        /* JADX INFO: compiled from: CameraGraph.kt */
        @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$OperatingMode$Companion;", "", "<init>", "()V", "NORMAL", "Landroidx/camera/camera2/pipe/CameraGraph$OperatingMode;", "getNORMAL-2uNL3no", "()I", "I", "HIGH_SPEED", "getHIGH_SPEED-2uNL3no", "EXTENSION", "getEXTENSION-2uNL3no", "custom", "mode", "", "custom-EP6OhB0", "(I)I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNORMAL-2uNL3no, reason: not valid java name */
            public final int m417getNORMAL2uNL3no() {
                return OperatingMode.NORMAL;
            }

            /* JADX INFO: renamed from: getHIGH_SPEED-2uNL3no, reason: not valid java name */
            public final int m416getHIGH_SPEED2uNL3no() {
                return OperatingMode.HIGH_SPEED;
            }

            /* JADX INFO: renamed from: getEXTENSION-2uNL3no, reason: not valid java name */
            public final int m415getEXTENSION2uNL3no() {
                return OperatingMode.EXTENSION;
            }

            /* JADX INFO: renamed from: custom-EP6OhB0, reason: not valid java name */
            public final int m414customEP6OhB0(int mode) {
                if (mode != m417getNORMAL2uNL3no() && mode != m416getHIGH_SPEED2uNL3no()) {
                    return OperatingMode.m408constructorimpl(mode);
                }
                if (Log.INSTANCE.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Custom operating mode " + mode + " conflicts with standard modes");
                }
                throw new IllegalArgumentException(Unit.INSTANCE.toString());
            }
        }

        private /* synthetic */ OperatingMode(int i) {
            this.mode = i;
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0011\u001a\u00020\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Constants3A;", "", "<init>", "()V", "DEFAULT_FRAME_LIMIT", "", "DEFAULT_TIME_LIMIT_MS", "DEFAULT_TIME_LIMIT_NS", "", "METERING_REGIONS_EMPTY", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "getMETERING_REGIONS_EMPTY", "()[Landroid/hardware/camera2/params/MeteringRectangle;", "[Landroid/hardware/camera2/params/MeteringRectangle;", "METERING_REGIONS_DEFAULT", "getMETERING_REGIONS_DEFAULT", "FRAME_NUMBER_INVALID", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFRAME_NUMBER_INVALID-Ugla2oM", "()J", "J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Constants3A {
        public static final int DEFAULT_FRAME_LIMIT = 60;
        public static final int DEFAULT_TIME_LIMIT_MS = 3000;
        public static final long DEFAULT_TIME_LIMIT_NS = 3000000000L;
        public static final Constants3A INSTANCE = new Constants3A();
        private static final MeteringRectangle[] METERING_REGIONS_EMPTY = new MeteringRectangle[0];
        private static final MeteringRectangle[] METERING_REGIONS_DEFAULT = {new MeteringRectangle(0, 0, 0, 0, 0)};
        private static final long FRAME_NUMBER_INVALID = FrameNumber.m532constructorimpl(-1);

        private Constants3A() {
        }

        public final MeteringRectangle[] getMETERING_REGIONS_EMPTY() {
            return METERING_REGIONS_EMPTY;
        }

        public final MeteringRectangle[] getMETERING_REGIONS_DEFAULT() {
            return METERING_REGIONS_DEFAULT;
        }

        /* JADX INFO: renamed from: getFRAME_NUMBER_INVALID-Ugla2oM, reason: not valid java name */
        public final long m391getFRAME_NUMBER_INVALIDUgla2oM() {
            return FRAME_NUMBER_INVALID;
        }
    }

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\bg\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&J\b\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&Jî\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)H¦@¢\u0006\u0004\b+\u0010,Jd\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010$2\n\b\u0002\u00100\u001a\u0004\u0018\u00010$2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u00102\u001a\u00020)H¦@¢\u0006\u0002\u00103J@\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u00102\u001a\u00020)H¦@¢\u0006\u0002\u00105J<\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u00106\u001a\u00020$2\b\b\u0002\u00107\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u00102\u001a\u00020)H¦@¢\u0006\u0002\u00108J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010:\u001a\u00020$H¦@¢\u0006\u0002\u0010;ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006<À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$Session;", "Landroidx/camera/camera2/pipe/CameraControls3A;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "startRepeating", "", "request", "Landroidx/camera/camera2/pipe/Request;", "stopRepeating", "submit", "requests", "", "capture", "Landroidx/camera/camera2/pipe/FrameCapture;", "abort", "lock3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A--tS25XM", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/AeMode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lock3AForCapture", "(Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAf", "waitForAwb", "(ZZIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3APostCapture", "cancelAf", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Session extends CameraControls3A, AutoCloseable {
        void abort();

        FrameCapture capture(Request request);

        List<FrameCapture> capture(List<Request> requests);

        /* JADX INFO: renamed from: lock3A--tS25XM, reason: not valid java name */
        Object mo420lock3AtS25XM(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode2, Function1<? super FrameMetadata, Boolean> function1, Function1<? super FrameMetadata, Boolean> function2, int i, long j, long j2, Continuation<? super Deferred<Result3A>> continuation);

        Object lock3AForCapture(Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation);

        Object lock3AForCapture(boolean z, boolean z2, int i, long j, Continuation<? super Deferred<Result3A>> continuation);

        void startRepeating(Request request);

        void stopRepeating();

        void submit(Request request);

        void submit(List<Request> requests);

        Object unlock3A(Boolean bool, Boolean bool2, Boolean bool3, Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation);

        Object unlock3APostCapture(boolean z, Continuation<? super Deferred<Result3A>> continuation);

        /* JADX INFO: compiled from: CameraGraph.kt */
        @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: lock3A--tS25XM$default, reason: not valid java name */
        static /* synthetic */ Object m419lock3AtS25XM$default(Session session, AeMode aeMode, AfMode afMode, AwbMode awbMode, List list, List list2, List list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode2, Function1 function1, Function1 function2, int i, long j, long j2, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                return session.mo420lock3AtS25XM((i2 & 1) != 0 ? null : aeMode, (i2 & 2) != 0 ? null : afMode, (i2 & 4) != 0 ? null : awbMode, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : list3, (i2 & 64) != 0 ? null : lock3ABehavior, (i2 & 128) != 0 ? null : lock3ABehavior2, (i2 & 256) != 0 ? null : lock3ABehavior3, (i2 & 512) != 0 ? null : aeMode2, (i2 & 1024) != 0 ? null : function1, (i2 & 2048) != 0 ? null : function2, (i2 & 4096) != 0 ? 60 : i, (i2 & 8192) != 0 ? 3000000000L : j, (i2 & 16384) != 0 ? 3000000000L : j2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3A--tS25XM");
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Object unlock3A$default(Session session, Boolean bool, Boolean bool2, Boolean bool3, Function1 function1, int i, long j, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock3A");
            }
            if ((i2 & 1) != 0) {
                bool = null;
            }
            if ((i2 & 2) != 0) {
                bool2 = null;
            }
            if ((i2 & 4) != 0) {
                bool3 = null;
            }
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            if ((i2 & 16) != 0) {
                i = 60;
            }
            if ((i2 & 32) != 0) {
                j = Constants3A.DEFAULT_TIME_LIMIT_NS;
            }
            return session.unlock3A(bool, bool2, bool3, function1, i, j, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Object lock3AForCapture$default(Session session, Function1 function1, int i, long j, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3AForCapture");
            }
            if ((i2 & 1) != 0) {
                function1 = null;
            }
            if ((i2 & 2) != 0) {
                i = 60;
            }
            if ((i2 & 4) != 0) {
                j = Constants3A.DEFAULT_TIME_LIMIT_NS;
            }
            return session.lock3AForCapture(function1, i, j, continuation);
        }

        static /* synthetic */ Object lock3AForCapture$default(Session session, boolean z, boolean z2, int i, long j, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3AForCapture");
            }
            if ((i2 & 1) != 0) {
                z = true;
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            if ((i2 & 4) != 0) {
                i = 60;
            }
            if ((i2 & 8) != 0) {
                j = Constants3A.DEFAULT_TIME_LIMIT_NS;
            }
            int i3 = i;
            return session.lock3AForCapture(z, z2, i3, j, continuation);
        }

        static /* synthetic */ Object unlock3APostCapture$default(Session session, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock3APostCapture");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return session.unlock3APostCapture(z, continuation);
        }
    }
}
