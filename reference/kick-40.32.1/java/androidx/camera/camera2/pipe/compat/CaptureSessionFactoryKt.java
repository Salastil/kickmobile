package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.media.AndroidMultiResolutionImageReader;
import androidx.camera.camera2.pipe.media.ImageSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0001\u001a0\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"buildOutputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurations;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "surfaces", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "buildSimpleOutputSurfaceMap", "Landroidx/camera/camera2/pipe/OutputId;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CaptureSessionFactoryKt {
    public static final OutputConfigurations buildOutputConfigurations(CameraGraph.Config graphConfig, StreamGraphImpl streamGraph, Map<StreamId, ? extends Surface> surfaces) {
        Surface surface;
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(surfaces, "surfaces");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry<StreamId, ImageSource> entry : streamGraph.getImageSourceMap$camera_camera2_pipe().entrySet()) {
            int iM797unboximpl = entry.getKey().m797unboximpl();
            ImageSource value = entry.getValue();
            CameraStream cameraStream = streamGraph.m784getaKI5c8E(iM797unboximpl);
            if (cameraStream == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            List<OutputStream> outputs = cameraStream.getOutputs();
            if (outputs.size() != 1) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Object objUnwrapAs = value.unwrapAs(Reflection.getOrCreateKotlinClass(AndroidMultiResolutionImageReader.class));
                    if (objUnwrapAs == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    List<OutputConfiguration> outputConfigurations$camera_camera2_pipe = ((AndroidMultiResolutionImageReader) objUnwrapAs).getOutputConfigurations$camera_camera2_pipe();
                    if (outputConfigurations$camera_camera2_pipe.size() != outputs.size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    int size = outputs.size();
                    for (int i = 0; i < size; i++) {
                        OutputStream outputStream = outputs.get(i);
                        OutputConfiguration outputConfiguration = outputConfigurations$camera_camera2_pipe.get(i);
                        StreamGraphImpl.OutputConfig outputConfig = streamGraph.getOutputConfigMap$camera_camera2_pipe().get(outputStream);
                        if (outputConfig == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        StreamGraphImpl.OutputConfig outputConfig2 = outputConfig;
                        if (outputConfig2.getExternalOutputConfig() != null) {
                            throw new IllegalStateException("External OutputConfiguration shouldn't be set in multi-output streams configured with ImageSource.Config".toString());
                        }
                        linkedHashMap3.put(outputConfig2, outputConfiguration);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot configure multiple outputs pre-S!");
                }
            }
        }
        for (CameraStream cameraStream2 : streamGraph.getStreams()) {
            List<OutputStream> outputs2 = cameraStream2.getOutputs();
            if (outputs2.size() == 1) {
                Surface surface2 = surfaces.get(StreamId.m791boximpl(cameraStream2.getId()));
                if (surface2 != null) {
                    linkedHashMap2.put(OutputId.m571boximpl(((OutputStream) CollectionsKt.single((List) outputs2)).getId()), surface2);
                }
            } else {
                for (OutputStream outputStream2 : outputs2) {
                    StreamGraphImpl.OutputConfig outputConfig3 = streamGraph.getOutputConfigMap$camera_camera2_pipe().get(outputStream2);
                    if (outputConfig3 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    StreamGraphImpl.OutputConfig outputConfig4 = outputConfig3;
                    OutputConfiguration externalOutputConfig = outputConfig4.getExternalOutputConfig();
                    if (externalOutputConfig == null) {
                        externalOutputConfig = (OutputConfiguration) linkedHashMap3.get(outputConfig4);
                    }
                    if (externalOutputConfig != null) {
                        surface = externalOutputConfig.getSurface();
                    } else {
                        surface = surfaces.get(StreamId.m791boximpl(cameraStream2.getId()));
                    }
                    if (surface != null) {
                        linkedHashMap2.put(OutputId.m571boximpl(outputStream2.getId()), surface);
                    }
                }
            }
        }
        OutputConfigurationWrapper outputConfigurationWrapper = null;
        for (StreamGraphImpl.OutputConfig outputConfig5 : streamGraph.getOutputConfigs$camera_camera2_pipe()) {
            List<CameraStream> streams = outputConfig5.getStreams();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = streams.iterator();
            while (it.hasNext()) {
                Surface surface3 = surfaces.get(StreamId.m791boximpl(((CameraStream) it.next()).getId()));
                if (surface3 != null) {
                    arrayList2.add(surface3);
                }
            }
            ArrayList arrayList3 = arrayList2;
            OutputConfiguration externalOutputConfig2 = outputConfig5.getExternalOutputConfig();
            if (externalOutputConfig2 == null) {
                externalOutputConfig2 = (OutputConfiguration) linkedHashMap3.get(outputConfig5);
            }
            OutputConfiguration outputConfiguration2 = externalOutputConfig2;
            if (outputConfiguration2 != null) {
                if (arrayList3.size() != outputConfig5.getStreams().size()) {
                    List<CameraStream> streams2 = outputConfig5.getStreams();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj : streams2) {
                        if (!surfaces.containsKey(StreamId.m791boximpl(((CameraStream) obj).getId()))) {
                            arrayList4.add(obj);
                        }
                    }
                    throw new IllegalStateException(("Surfaces are not yet available for " + outputConfig5 + "! Missing surfaces for " + arrayList4 + '!').toString());
                }
                arrayList.add(new AndroidOutputConfiguration(outputConfiguration2, false, 1, null, null));
            } else if (outputConfig5.getDeferrable() && arrayList3.size() != outputConfig5.getStreams().size()) {
                AndroidOutputConfiguration.Companion companion = AndroidOutputConfiguration.INSTANCE;
                Size size2 = outputConfig5.getSize();
                OutputStream.OutputType deferredOutputType = outputConfig5.getDeferredOutputType();
                Intrinsics.checkNotNull(deferredOutputType);
                OutputStream.MirrorMode mirrorMode = outputConfig5.getMirrorMode();
                OutputStream.TimestampBase timestampBase = outputConfig5.getTimestampBase();
                OutputStream.DynamicRangeProfile dynamicRangeProfile = outputConfig5.getDynamicRangeProfile();
                OutputStream.StreamUseCase streamUseCase = outputConfig5.getStreamUseCase();
                List<OutputStream.SensorPixelMode> sensorPixelModes = outputConfig5.getSensorPixelModes();
                boolean surfaceSharing = outputConfig5.getSurfaceSharing();
                Integer groupNumber = outputConfig5.getGroupNumber();
                OutputConfigurationWrapper outputConfigurationWrapperM815creategWWoySg$default = AndroidOutputConfiguration.Companion.m815creategWWoySg$default(companion, null, null, deferredOutputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, sensorPixelModes, size2, surfaceSharing, groupNumber != null ? groupNumber.intValue() : -1, !CameraId.m429equalsimpl0(outputConfig5.getCamera(), graphConfig.m385getCameraDz_R5H8()) ? outputConfig5.getCamera() : null, 2, null);
                if (outputConfigurationWrapperM815creategWWoySg$default != null) {
                    arrayList.add(outputConfigurationWrapperM815creategWWoySg$default);
                    Iterator<CameraStream> it2 = outputConfig5.getStreamBuilder$camera_camera2_pipe().iterator();
                    while (it2.hasNext()) {
                        linkedHashMap.put(StreamId.m791boximpl(it2.next().getId()), outputConfigurationWrapperM815creategWWoySg$default);
                    }
                } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create AndroidOutputConfiguration for " + outputConfig5);
                }
            } else {
                if (arrayList3.size() != outputConfig5.getStreams().size()) {
                    List<CameraStream> streams3 = outputConfig5.getStreams();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj2 : streams3) {
                        if (!surfaces.containsKey(StreamId.m791boximpl(((CameraStream) obj2).getId()))) {
                            arrayList5.add(obj2);
                        }
                    }
                    throw new IllegalStateException(("Surfaces are not yet available for " + outputConfig5 + "! Missing surfaces for " + arrayList5 + '!').toString());
                }
                AndroidOutputConfiguration.Companion companion2 = AndroidOutputConfiguration.INSTANCE;
                Surface surface4 = (Surface) CollectionsKt.first((List) arrayList3);
                OutputStream.MirrorMode mirrorMode2 = outputConfig5.getMirrorMode();
                OutputStream.TimestampBase timestampBase2 = outputConfig5.getTimestampBase();
                OutputStream.DynamicRangeProfile dynamicRangeProfile2 = outputConfig5.getDynamicRangeProfile();
                OutputStream.StreamUseCase streamUseCase2 = outputConfig5.getStreamUseCase();
                List<OutputStream.SensorPixelMode> sensorPixelModes2 = outputConfig5.getSensorPixelModes();
                Size size3 = outputConfig5.getSize();
                boolean surfaceSharing2 = outputConfig5.getSurfaceSharing();
                Integer groupNumber2 = outputConfig5.getGroupNumber();
                OutputConfigurationWrapper outputConfigurationWrapperM815creategWWoySg$default2 = AndroidOutputConfiguration.Companion.m815creategWWoySg$default(companion2, surface4, null, null, mirrorMode2, timestampBase2, dynamicRangeProfile2, streamUseCase2, sensorPixelModes2, size3, surfaceSharing2, groupNumber2 != null ? groupNumber2.intValue() : -1, !CameraId.m429equalsimpl0(outputConfig5.getCamera(), graphConfig.m385getCameraDz_R5H8()) ? outputConfig5.getCamera() : null, 6, null);
                if (outputConfigurationWrapperM815creategWWoySg$default2 != null) {
                    Iterator it3 = CollectionsKt.drop(arrayList3, 1).iterator();
                    while (it3.hasNext()) {
                        outputConfigurationWrapperM815creategWWoySg$default2.addSurface((Surface) it3.next());
                    }
                    if (graphConfig.getPostviewStream() != null) {
                        CameraStream cameraStream3 = streamGraph.get(graphConfig.getPostviewStream());
                        if (cameraStream3 == null) {
                            throw new IllegalStateException("Postview Stream in StreamGraph cannot be null for reprocessing request".toString());
                        }
                        if (outputConfigurationWrapper == null && outputConfig5.getStreams().contains(cameraStream3)) {
                            outputConfigurationWrapper = outputConfigurationWrapperM815creategWWoySg$default2;
                        } else {
                            arrayList.add(outputConfigurationWrapperM815creategWWoySg$default2);
                        }
                    } else {
                        arrayList.add(outputConfigurationWrapperM815creategWWoySg$default2);
                    }
                } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create AndroidOutputConfiguration for " + outputConfig5);
                }
            }
        }
        return new OutputConfigurations(arrayList, linkedHashMap, outputConfigurationWrapper, linkedHashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<OutputId, Surface> buildSimpleOutputSurfaceMap(Map<StreamId, ? extends Surface> map, StreamGraphImpl streamGraphImpl) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (CameraStream cameraStream : streamGraphImpl.getStreams()) {
            Surface surface = map.get(StreamId.m791boximpl(cameraStream.getId()));
            if (surface != null) {
                Iterator<OutputStream> it = cameraStream.getOutputs().iterator();
                while (it.hasNext()) {
                    mapCreateMapBuilder.put(OutputId.m571boximpl(it.next().getId()), surface);
                }
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
