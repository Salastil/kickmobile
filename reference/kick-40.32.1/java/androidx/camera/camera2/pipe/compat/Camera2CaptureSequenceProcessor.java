package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.util.ArrayMap;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.CaptureSequence;
import androidx.camera.camera2.pipe.CaptureSequenceProcessor;
import androidx.camera.camera2.pipe.InputStream;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.RequestsKt;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.media.AndroidImageWriter;
import androidx.camera.camera2.pipe.media.ImageWrapper;
import androidx.camera.camera2.pipe.media.ImageWriterWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: Camera2CaptureSequenceProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001EBa\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017Jr\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b2\u0012\u0010%\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b2\u0012\u0010&\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\"H\u0016J\u0017\u0010+\u001a\u0004\u0018\u00010\u001a2\u0006\u0010,\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\u000e\u00101\u001a\u00020/H\u0096@¢\u0006\u0002\u00102J\r\u00103\u001a\u00020/H\u0000¢\u0006\u0002\b4J\b\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020/2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u001e\u0010:\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002JR\u0010;\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\f0=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0=2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0=H\u0002J!\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\tH\u0002¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "Landroidx/camera/camera2/pipe/CaptureSequenceProcessor;", "Landroid/hardware/camera2/CaptureRequest;", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequence;", "session", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "streamToSurfaceMap", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "outputToSurfaceMap", "Landroidx/camera/camera2/pipe/OutputId;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "strictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "awaitRepeatingRequestOnDisconnect", "", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;Landroidx/camera/camera2/pipe/core/Threads;ILjava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/StreamGraph;Landroidx/camera/camera2/pipe/StrictMode;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "debugId", "", "lock", "", "disconnected", "lastSingleRepeatingRequestSequence", "build", "isRepeating", "requests", "", "Landroidx/camera/camera2/pipe/Request;", "defaultParameters", "graphParameters", "requiredParameters", "sequenceListener", "Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "submit", "captureSequence", "(Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequence;)Ljava/lang/Integer;", "abortCaptures", "", "stopRepeating", "shutdown", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "disconnect$camera_camera2_pipe", "toString", "", "awaitRepeatingRequestStarted", "imageWriter", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "validateRequestList", "buildSurfaceMaps", "surfaceToStreamMap", "", "surfaceToOutputMap", "buildCaptureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "request", "requestTemplate", "buildCaptureRequestBuilder-0UCm73U", "(Landroidx/camera/camera2/pipe/Request;I)Landroid/hardware/camera2/CaptureRequest$Builder;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CaptureSequenceProcessor implements CaptureSequenceProcessor<CaptureRequest, Camera2CaptureSequence> {
    private static final long WAIT_FOR_REPEATING_TIMEOUT_MS = 2000;
    private final boolean awaitRepeatingRequestOnDisconnect;
    private final int debugId;
    private boolean disconnected;
    private final ImageWriterWrapper imageWriter;
    private Camera2CaptureSequence lastSingleRepeatingRequestSequence;
    private final Object lock;
    private final Map<OutputId, Surface> outputToSurfaceMap;
    private final CameraCaptureSessionWrapper session;
    private final StreamGraph streamGraph;
    private final Map<StreamId, Surface> streamToSurfaceMap;
    private final StrictMode strictMode;
    private final int template;
    private final Threads threads;

    public /* synthetic */ Camera2CaptureSequenceProcessor(CameraCaptureSessionWrapper cameraCaptureSessionWrapper, Threads threads, int i, Map map, Map map2, StreamGraph streamGraph, StrictMode strictMode, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraCaptureSessionWrapper, threads, i, map, map2, streamGraph, strictMode, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Camera2CaptureSequenceProcessor(CameraCaptureSessionWrapper session, Threads threads, int i, Map<StreamId, ? extends Surface> streamToSurfaceMap, Map<OutputId, ? extends Surface> outputToSurfaceMap, StreamGraph streamGraph, StrictMode strictMode, boolean z) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(streamToSurfaceMap, "streamToSurfaceMap");
        Intrinsics.checkNotNullParameter(outputToSurfaceMap, "outputToSurfaceMap");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        this.session = session;
        this.threads = threads;
        this.template = i;
        this.streamToSurfaceMap = streamToSurfaceMap;
        this.outputToSurfaceMap = outputToSurfaceMap;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.awaitRepeatingRequestOnDisconnect = z;
        this.debugId = Camera2CaptureSequenceProcessorKt.getCaptureSequenceProcessorDebugIds().incrementAndGet();
        this.lock = new Object();
        ImageWriterWrapper imageWriterWrapperM1053createU86x6Zg = null;
        if (!streamGraph.getInputs().isEmpty()) {
            InputStream inputStream = (InputStream) CollectionsKt.first((List) streamGraph.getInputs());
            Surface inputSurface = session.getInputSurface();
            if (inputSurface == null) {
                throw new IllegalStateException("inputSurface is required to create instance of imageWriter.".toString());
            }
            try {
                imageWriterWrapperM1053createU86x6Zg = AndroidImageWriter.INSTANCE.m1053createU86x6Zg(inputSurface, inputStream.getId(), inputStream.getMaxImages(), StreamFormat.m745boximpl(inputStream.getFormat()), threads.getCamera2Handler());
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                if (Log.INSTANCE.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Failed to create ImageWriter for session " + this.session + "! Reprocessing will not be supported!", runtimeException);
                }
            }
            if (imageWriterWrapperM1053createU86x6Zg != null && Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Created ImageWriter " + imageWriterWrapperM1053createU86x6Zg + " for session " + this.session);
            }
        }
        this.imageWriter = imageWriterWrapperM1053createU86x6Zg;
    }

    public /* synthetic */ Camera2CaptureSequenceProcessor(CameraCaptureSessionWrapper cameraCaptureSessionWrapper, Threads threads, int i, Map map, Map map2, StreamGraph streamGraph, StrictMode strictMode, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraCaptureSessionWrapper, threads, i, map, map2, streamGraph, strictMode, (i2 & 128) != 0 ? false : z, null);
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public /* bridge */ /* synthetic */ CaptureSequence build(boolean z, List list, Map map, Map map2, Map map3, CaptureSequence.CaptureSequenceListener captureSequenceListener, List list2) {
        return build(z, (List<Request>) list, (Map<?, ? extends Object>) map, (Map<?, ? extends Object>) map2, (Map<?, ? extends Object>) map3, captureSequenceListener, (List<? extends Request.Listener>) list2);
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public Camera2CaptureSequence build(boolean isRepeating, List<Request> requests, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, CaptureSequence.CaptureSequenceListener sequenceListener, List<? extends Request.Listener> listeners) {
        Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor = this;
        Map<?, ? extends Object> defaultParameters2 = defaultParameters;
        Map<?, ? extends Object> graphParameters2 = graphParameters;
        Map<?, ? extends Object> requiredParameters2 = requiredParameters;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(defaultParameters2, "defaultParameters");
        Intrinsics.checkNotNullParameter(graphParameters2, "graphParameters");
        Intrinsics.checkNotNullParameter(requiredParameters2, "requiredParameters");
        Intrinsics.checkNotNullParameter(sequenceListener, "sequenceListener");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        ArrayList arrayList = new ArrayList(requests.size());
        ArrayList arrayList2 = new ArrayList(requests.size());
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (!camera2CaptureSequenceProcessor.validateRequestList(requests, camera2CaptureSequenceProcessor.session)) {
            return null;
        }
        ArrayMap arrayMap4 = arrayMap;
        ArrayMap arrayMap5 = arrayMap2;
        ArrayMap arrayMap6 = arrayMap3;
        if (!camera2CaptureSequenceProcessor.buildSurfaceMaps(requests, arrayMap4, arrayMap5, arrayMap6)) {
            return null;
        }
        for (Request request : requests) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Building CaptureRequest for " + request);
            }
            RequestTemplate template = request.getTemplate();
            int iM721unboximpl = template != null ? template.m721unboximpl() : camera2CaptureSequenceProcessor.template;
            CaptureRequest.Builder builderM831buildCaptureRequestBuilder0UCm73U = camera2CaptureSequenceProcessor.m831buildCaptureRequestBuilder0UCm73U(request, iM721unboximpl);
            if (builderM831buildCaptureRequestBuilder0UCm73U == null) {
                return null;
            }
            Object obj = requiredParameters2.get(CameraPipeKeys.INSTANCE.getCamera2CaptureRequestTag());
            if (obj == null) {
                obj = defaultParameters2.get(CameraPipeKeys.INSTANCE.getCamera2CaptureRequestTag());
            }
            builderM831buildCaptureRequestBuilder0UCm73U.setTag(obj);
            int size = request.getStreams().size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                Request request2 = request;
                Surface surface = (Surface) arrayMap3.get(request2.getStreams().get(i));
                if (surface != null) {
                    builderM831buildCaptureRequestBuilder0UCm73U.addTarget(surface);
                    z = true;
                }
                i++;
                request = request2;
            }
            Request request3 = request;
            if (!z) {
                throw new IllegalStateException("Check failed.");
            }
            if (request3.getInputRequest() == null) {
                arrayList = arrayList;
                RequestsKt.writeParameters(builderM831buildCaptureRequestBuilder0UCm73U, defaultParameters2);
                RequestsKt.writeParameters(builderM831buildCaptureRequestBuilder0UCm73U, graphParameters2);
                RequestsKt.writeParameters(builderM831buildCaptureRequestBuilder0UCm73U, request3.getParameters());
                RequestsKt.writeParameters(builderM831buildCaptureRequestBuilder0UCm73U, requiredParameters2);
            } else {
                if (camera2CaptureSequenceProcessor.imageWriter == null) {
                    if (Log.INSTANCE.getERROR_LOGGABLE()) {
                        android.util.Log.e(Log.TAG, "Failed to queue request to ImageWriter - No ImageWriter available!");
                    }
                    return null;
                }
                ImageWrapper image = request3.getInputRequest().getImage();
                synchronized (camera2CaptureSequenceProcessor.lock) {
                    if (camera2CaptureSequenceProcessor.disconnected) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, camera2CaptureSequenceProcessor + " disconnected. " + image + " can't be queued to " + camera2CaptureSequenceProcessor.imageWriter);
                        }
                        return null;
                    }
                    Unit unit = Unit.INSTANCE;
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Queuing image " + image + " for reprocessing to ImageWriter " + camera2CaptureSequenceProcessor.imageWriter);
                    }
                    if (!camera2CaptureSequenceProcessor.imageWriter.queueInputImage(image)) {
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Failed to queue image " + image + " for reprocessing to ImageWriter " + camera2CaptureSequenceProcessor.imageWriter);
                        }
                        return null;
                    }
                    RequestsKt.writeParameters(builderM831buildCaptureRequestBuilder0UCm73U, request3.getParameters());
                }
            }
            ArrayMap arrayMap7 = arrayMap5;
            int i2 = iM721unboximpl;
            long jNextRequestNumber = Camera2CaptureSequenceProcessorKt.nextRequestNumber();
            CaptureRequest captureRequestBuild = builderM831buildCaptureRequestBuilder0UCm73U.build();
            Intrinsics.checkNotNullExpressionValue(captureRequestBuild, "build(...)");
            CameraCaptureSessionWrapper cameraCaptureSessionWrapper = camera2CaptureSequenceProcessor.session;
            if (cameraCaptureSessionWrapper instanceof CameraConstrainedHighSpeedCaptureSessionWrapper) {
                List<CaptureRequest> listCreateHighSpeedRequestList = ((CameraConstrainedHighSpeedCaptureSessionWrapper) cameraCaptureSessionWrapper).createHighSpeedRequestList(captureRequestBuild);
                if (listCreateHighSpeedRequestList == null) {
                    return null;
                }
                List<StreamId> streams = request3.getStreams();
                if (!(streams instanceof Collection) || !streams.isEmpty()) {
                    Iterator it = streams.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ((StreamId) it.next()).m797unboximpl();
                            List<OutputStream> outputs = camera2CaptureSequenceProcessor.streamGraph.getOutputs();
                            ArrayMap arrayMap8 = arrayMap7;
                            if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                                Iterator it2 = outputs.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        OutputStream outputStream = (OutputStream) it2.next();
                                        OutputStream.StreamUseCase streamUseCase = outputStream.getStreamUseCase();
                                        Iterator it3 = it2;
                                        Iterator it4 = it;
                                        ArrayList arrayList3 = arrayList2;
                                        if (!(streamUseCase == null ? false : OutputStream.StreamUseCase.m654equalsimpl0(streamUseCase.m657unboximpl(), OutputStream.StreamUseCase.INSTANCE.m664getVIDEO_RECORDvrKr8v8()))) {
                                            OutputStream.StreamUseHint streamUseHint = outputStream.getStreamUseHint();
                                            if (!(streamUseHint == null ? false : OutputStream.StreamUseHint.m668equalsimpl0(streamUseHint.m671unboximpl(), OutputStream.StreamUseHint.INSTANCE.m673getVIDEO_RECORD4VYZOf8()))) {
                                                arrayList2 = arrayList3;
                                                it = it4;
                                                it2 = it3;
                                            }
                                        }
                                        int size2 = listCreateHighSpeedRequestList.size();
                                        int i3 = 0;
                                        while (i3 < size2) {
                                            int i4 = size2;
                                            Request request4 = request3;
                                            ArrayMap arrayMap9 = arrayMap4;
                                            ArrayMap arrayMap10 = arrayMap6;
                                            int i5 = i3;
                                            ArrayList arrayList4 = arrayList3;
                                            ArrayList arrayList5 = arrayList;
                                            Camera2RequestMetadata camera2RequestMetadata = new Camera2RequestMetadata(camera2CaptureSequenceProcessor.session, listCreateHighSpeedRequestList.get(i3), defaultParameters, graphParameters, requiredParameters2, arrayMap10, i2, isRepeating, request4, jNextRequestNumber, null);
                                            arrayList4.add(listCreateHighSpeedRequestList.get(i5));
                                            arrayList5.add(camera2RequestMetadata);
                                            arrayMap6 = arrayMap10;
                                            arrayMap4 = arrayMap9;
                                            request3 = request4;
                                            requiredParameters2 = requiredParameters;
                                            arrayList3 = arrayList4;
                                            arrayMap3 = arrayMap3;
                                            camera2CaptureSequenceProcessor = this;
                                            arrayList = arrayList5;
                                            i3 = i5 + 1;
                                            size2 = i4;
                                        }
                                        arrayList = arrayList;
                                        camera2CaptureSequenceProcessor = this;
                                        defaultParameters2 = defaultParameters;
                                        graphParameters2 = graphParameters;
                                        requiredParameters2 = requiredParameters;
                                        arrayMap5 = arrayMap8;
                                        arrayList2 = arrayList3;
                                    }
                                }
                            }
                            arrayMap6 = arrayMap6;
                            arrayMap4 = arrayMap4;
                            request3 = request3;
                            requiredParameters2 = requiredParameters;
                            arrayList2 = arrayList2;
                            arrayMap3 = arrayMap3;
                            arrayMap7 = arrayMap8;
                            camera2CaptureSequenceProcessor = this;
                            arrayList = arrayList;
                            it = it;
                        }
                    }
                }
                Request request5 = request3;
                ArrayMap arrayMap11 = arrayMap4;
                ArrayMap arrayMap12 = arrayMap6;
                ArrayMap arrayMap13 = arrayMap7;
                ArrayList arrayList6 = arrayList2;
                ArrayList arrayList7 = arrayList;
                ArrayMap arrayMap14 = arrayMap3;
                graphParameters2 = graphParameters;
                requiredParameters2 = requiredParameters;
                defaultParameters2 = defaultParameters;
                Camera2RequestMetadata camera2RequestMetadata2 = new Camera2RequestMetadata(this.session, listCreateHighSpeedRequestList.get(0), defaultParameters2, graphParameters2, requiredParameters2, arrayMap12, i2, isRepeating, request5, jNextRequestNumber, null);
                arrayList6.add(listCreateHighSpeedRequestList.get(0));
                arrayList7.add(camera2RequestMetadata2);
                arrayList2 = arrayList6;
                arrayMap6 = arrayMap12;
                arrayList = arrayList7;
                arrayMap3 = arrayMap14;
                arrayMap4 = arrayMap11;
                arrayMap5 = arrayMap13;
                camera2CaptureSequenceProcessor = this;
            } else {
                ArrayMap arrayMap15 = arrayMap4;
                ArrayMap arrayMap16 = arrayMap6;
                ArrayList arrayList8 = arrayList2;
                ArrayList arrayList9 = arrayList;
                defaultParameters2 = defaultParameters;
                graphParameters2 = graphParameters;
                requiredParameters2 = requiredParameters;
                Camera2RequestMetadata camera2RequestMetadata3 = new Camera2RequestMetadata(this.session, captureRequestBuild, defaultParameters2, graphParameters2, requiredParameters2, arrayMap16, i2, isRepeating, request3, jNextRequestNumber, null);
                arrayList8.add(captureRequestBuild);
                arrayList9.add(camera2RequestMetadata3);
                arrayList2 = arrayList8;
                arrayMap6 = arrayMap16;
                arrayList = arrayList9;
                camera2CaptureSequenceProcessor = this;
                arrayMap3 = arrayMap3;
                arrayMap4 = arrayMap15;
                arrayMap5 = arrayMap7;
            }
        }
        Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor2 = camera2CaptureSequenceProcessor;
        return new Camera2CaptureSequence(camera2CaptureSequenceProcessor2.session.getDevice().getCameraId(), isRepeating, arrayList2, arrayList, listeners, sequenceListener, arrayMap4, arrayMap5, camera2CaptureSequenceProcessor2.streamGraph, camera2CaptureSequenceProcessor2.strictMode, null);
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public Integer submit(Camera2CaptureSequence captureSequence) {
        Integer numCaptureBurst;
        Intrinsics.checkNotNullParameter(captureSequence, "captureSequence");
        synchronized (this.lock) {
            if (!this.disconnected) {
                Camera2CaptureSequence camera2CaptureSequence = captureSequence;
                if (captureSequence.getCaptureRequestList().size() == 1 && !(this.session instanceof CameraConstrainedHighSpeedCaptureSessionWrapper)) {
                    if (captureSequence.getRepeating()) {
                        if (this.awaitRepeatingRequestOnDisconnect) {
                            this.lastSingleRepeatingRequestSequence = captureSequence;
                        }
                        numCaptureBurst = this.session.setRepeatingRequest(captureSequence.getCaptureRequestList().get(0), camera2CaptureSequence);
                    } else {
                        numCaptureBurst = this.session.capture(captureSequence.getCaptureRequestList().get(0), captureSequence);
                    }
                } else {
                    boolean repeating = captureSequence.getRepeating();
                    CameraCaptureSessionWrapper cameraCaptureSessionWrapper = this.session;
                    if (repeating) {
                        numCaptureBurst = cameraCaptureSessionWrapper.setRepeatingBurst(captureSequence.getCaptureRequestList(), captureSequence);
                    } else {
                        numCaptureBurst = cameraCaptureSessionWrapper.captureBurst(captureSequence.getCaptureRequestList(), captureSequence);
                    }
                }
                return numCaptureBurst;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, this + " disconnected. " + captureSequence + " won't be submitted");
            }
            return null;
        }
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public void abortCaptures() {
        synchronized (this.lock) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, this + "#abortCaptures");
            }
            this.session.abortCaptures();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public void stopRepeating() {
        synchronized (this.lock) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, this + "#stopRepeating");
            }
            this.session.stopRepeating();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequenceProcessor
    public Object shutdown(Continuation<? super Unit> continuation) {
        disconnect$camera_camera2_pipe();
        return Unit.INSTANCE;
    }

    public final void disconnect$camera_camera2_pipe() {
        Camera2CaptureSequence camera2CaptureSequence;
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#disconnect");
            synchronized (this.lock) {
                if (this.disconnected) {
                    camera2CaptureSequence = null;
                } else {
                    this.disconnected = true;
                    ImageWriterWrapper imageWriterWrapper = this.imageWriter;
                    if (imageWriterWrapper != null) {
                        UByte$$ExternalSyntheticBackport0.m12761m((Object) imageWriterWrapper);
                    }
                    Surface inputSurface = this.session.getInputSurface();
                    if (inputSurface != null) {
                        inputSurface.release();
                    }
                    camera2CaptureSequence = this.lastSingleRepeatingRequestSequence;
                }
            }
            if (this.awaitRepeatingRequestOnDisconnect && camera2CaptureSequence != null) {
                awaitRepeatingRequestStarted(camera2CaptureSequence);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public String toString() {
        return "Camera2CaptureSequenceProcessor-" + this.debugId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void awaitRepeatingRequestStarted(Camera2CaptureSequence captureSequence) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Waiting for the last repeating request sequence: " + captureSequence);
        }
        if (((Unit) this.threads.runBlockingCheckedOrNull(2000L, new AnonymousClass2(captureSequence, null))) == null && Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, this + "#close: awaitStarted on last repeating request timed out, lastSingleRepeatingRequestSequence = " + captureSequence);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2CaptureSequenceProcessor.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2", f = "Camera2CaptureSequenceProcessor.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Camera2CaptureSequence $captureSequence;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Camera2CaptureSequence camera2CaptureSequence, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$captureSequence = camera2CaptureSequence;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$captureSequence, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$captureSequence.awaitStarted$camera_camera2_pipe(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean validateRequestList(List<Request> requests, CameraCaptureSessionWrapper session) {
        boolean z;
        boolean z2;
        if (requests.isEmpty()) {
            throw new IllegalStateException("build(...) should never be called with an empty request list!".toString());
        }
        if (session instanceof CameraConstrainedHighSpeedCaptureSessionWrapper) {
            Boolean bool = null;
            Boolean bool2 = null;
            for (Request request : requests) {
                List<StreamId> streams = request.getStreams();
                if ((streams instanceof Collection) && streams.isEmpty()) {
                    z = false;
                } else {
                    Iterator<T> it = streams.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ((StreamId) it.next()).m797unboximpl();
                            List<OutputStream> outputs = this.streamGraph.getOutputs();
                            if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                                Iterator<T> it2 = outputs.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        OutputStream outputStream = (OutputStream) it2.next();
                                        OutputStream.StreamUseCase streamUseCase = outputStream.getStreamUseCase();
                                        if (!(streamUseCase == null ? false : OutputStream.StreamUseCase.m654equalsimpl0(streamUseCase.m657unboximpl(), OutputStream.StreamUseCase.INSTANCE.m660getPREVIEWvrKr8v8()))) {
                                            OutputStream.StreamUseHint streamUseHint = outputStream.getStreamUseHint();
                                            if ((streamUseHint == null ? false : OutputStream.StreamUseHint.m668equalsimpl0(streamUseHint.m671unboximpl(), OutputStream.StreamUseHint.INSTANCE.m672getDEFAULT4VYZOf8())) || outputStream.getStreamUseHint() == null) {
                                            }
                                        }
                                        z = true;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } else {
                            z = false;
                        }
                    }
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                if (bool != null && !Intrinsics.areEqual(bool, boolValueOf) && Log.INSTANCE.getERROR_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder("The previous high speed request and the current high speed request must both have a preview stream use case or hint. Previous request contains preview stream use case or hint: ");
                    sb.append(bool.booleanValue());
                    sb.append(". Current request contains preview stream use case or hint: ");
                    boolValueOf.getClass();
                    sb.append(z);
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    android.util.Log.e(Log.TAG, sb.toString());
                }
                List<StreamId> streams2 = request.getStreams();
                if ((streams2 instanceof Collection) && streams2.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it3 = streams2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            ((StreamId) it3.next()).m797unboximpl();
                            List<OutputStream> outputs2 = this.streamGraph.getOutputs();
                            if (!(outputs2 instanceof Collection) || !outputs2.isEmpty()) {
                                Iterator<T> it4 = outputs2.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        OutputStream outputStream2 = (OutputStream) it4.next();
                                        OutputStream.StreamUseCase streamUseCase2 = outputStream2.getStreamUseCase();
                                        if (!(streamUseCase2 == null ? false : OutputStream.StreamUseCase.m654equalsimpl0(streamUseCase2.m657unboximpl(), OutputStream.StreamUseCase.INSTANCE.m664getVIDEO_RECORDvrKr8v8()))) {
                                            OutputStream.StreamUseHint streamUseHint2 = outputStream2.getStreamUseHint();
                                            if (streamUseHint2 == null ? false : OutputStream.StreamUseHint.m668equalsimpl0(streamUseHint2.m671unboximpl(), OutputStream.StreamUseHint.INSTANCE.m673getVIDEO_RECORD4VYZOf8())) {
                                            }
                                        }
                                        z2 = true;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } else {
                            z2 = false;
                        }
                    }
                }
                Boolean boolValueOf2 = Boolean.valueOf(z2);
                if (bool2 != null && !Intrinsics.areEqual(bool2, boolValueOf2) && Log.INSTANCE.getERROR_LOGGABLE()) {
                    StringBuilder sb2 = new StringBuilder("The previous high speed request and the current high speed request do not have the same video stream use case. Previous request contains video stream use case: ");
                    sb2.append(bool2.booleanValue());
                    sb2.append(". Current request contains video stream use case: ");
                    boolValueOf2.getClass();
                    sb2.append(z2);
                    sb2.append(FilenameUtils.EXTENSION_SEPARATOR);
                    android.util.Log.e(Log.TAG, sb2.toString());
                }
                List<OutputStream> outputs3 = this.streamGraph.getOutputs();
                if (!(outputs3 instanceof Collection) || !outputs3.isEmpty()) {
                    Iterator<T> it5 = outputs3.iterator();
                    while (it5.hasNext()) {
                        if (!((OutputStream) it5.next()).isValidForHighSpeedOperatingMode()) {
                            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                                android.util.Log.e(Log.TAG, "HIGH_SPEED CameraGraph must only contain Preview and/or Video streams. Configured outputs are " + this.streamGraph.getOutputs());
                            }
                            return false;
                        }
                    }
                }
                bool2 = boolValueOf2;
                bool = boolValueOf;
            }
        }
        return true;
    }

    private final boolean buildSurfaceMaps(List<Request> requests, Map<Surface, StreamId> surfaceToStreamMap, Map<Surface, OutputId> surfaceToOutputMap, Map<StreamId, Surface> streamToSurfaceMap) {
        if (requests.isEmpty()) {
            throw new IllegalStateException("build(...) should never be called with an empty request list!".toString());
        }
        for (Request request : requests) {
            Iterator<StreamId> it = request.getStreams().iterator();
            boolean z = false;
            while (it.hasNext()) {
                int iM797unboximpl = it.next().m797unboximpl();
                if (!streamToSurfaceMap.containsKey(StreamId.m791boximpl(iM797unboximpl))) {
                    Surface surface = this.streamToSurfaceMap.get(StreamId.m791boximpl(iM797unboximpl));
                    if (surface != null) {
                        surfaceToStreamMap.put(surface, StreamId.m791boximpl(iM797unboximpl));
                        streamToSurfaceMap.put(StreamId.m791boximpl(iM797unboximpl), surface);
                        CameraStream cameraStreamM784getaKI5c8E = this.streamGraph.m784getaKI5c8E(iM797unboximpl);
                        if (cameraStreamM784getaKI5c8E == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        for (OutputStream outputStream : cameraStreamM784getaKI5c8E.getOutputs()) {
                            Surface surface2 = this.outputToSurfaceMap.get(OutputId.m571boximpl(outputStream.getId()));
                            if (surface2 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            surfaceToOutputMap.put(surface2, OutputId.m571boximpl(outputStream.getId()));
                        }
                    } else {
                        continue;
                    }
                }
                z = true;
            }
            if (!z) {
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "  Failed to bind any surfaces for " + request + '!');
                }
                return false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.");
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: buildCaptureRequestBuilder-0UCm73U, reason: not valid java name */
    private final CaptureRequest.Builder m831buildCaptureRequestBuilder0UCm73U(Request request, int requestTemplate) {
        CaptureRequest.Builder builderMo800createCaptureRequest2PPcXtw;
        if (request.getInputRequest() != null) {
            TotalCaptureResult totalCaptureResult = (TotalCaptureResult) request.getInputRequest().getFrameInfo().unwrapAs(Reflection.getOrCreateKotlinClass(TotalCaptureResult.class));
            if (totalCaptureResult == null) {
                throw new IllegalStateException(("Failed to unwrap FrameInfo " + request.getInputRequest().getFrameInfo() + " as TotalCaptureResult").toString());
            }
            builderMo800createCaptureRequest2PPcXtw = this.session.getDevice().createReprocessCaptureRequest(totalCaptureResult);
        } else {
            builderMo800createCaptureRequest2PPcXtw = this.session.getDevice().mo800createCaptureRequest2PPcXtw(requestTemplate);
        }
        if (builderMo800createCaptureRequest2PPcXtw != null) {
            return builderMo800createCaptureRequest2PPcXtw;
        }
        if (request.getInputRequest() != null) {
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "Failed to create a ReprocessingCaptureRequest.Builder from " + request.getInputRequest().getFrameInfo() + '!');
            }
        } else if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "Failed to create a CaptureRequest.Builder from " + ((Object) RequestTemplate.m720toStringimpl(requestTemplate)) + '!');
        }
        return null;
    }
}
