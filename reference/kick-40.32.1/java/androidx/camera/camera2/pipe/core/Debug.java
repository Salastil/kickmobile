package androidx.camera.camera2.pipe.core;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ConcurrentCameraGraphs;
import androidx.camera.camera2.pipe.InputStream;
import androidx.camera.camera2.pipe.InputStreamId;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.StreamId;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0004\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011J1\u0010\u0012\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0004\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\u001c\u0010\u0014\u001a\u00020\u00152\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bø\u0001\u0000J\t\u0010\u0016\u001a\u00020\u0015H\u0086\bJ0\u0010\u0017\u001a\u00020\u00152\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH\u0002J$\u0010\u001e\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020 J$\u0010!\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020 J.\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0$0#2\u0012\u0010\u001c\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH\u0002J\u0012\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/camera/camera2/pipe/core/Debug;", "", "<init>", "()V", "systemTimeSource", "Landroidx/camera/camera2/pipe/core/SystemTimeSource;", "getSystemTimeSource$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/core/SystemTimeSource;", "ENABLE_LOGGING", "", "ENABLE_TRACING", "trace", ExifInterface.GPS_DIRECTION_TRUE, "label", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "instrument", "instrument$camera_camera2_pipe", "traceStart", "", "traceStop", "appendParameters", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "parameters", "", "formatParameterMap", "limit", "", "formatParameterMapToLineSeparatedList", "parametersToSortedStringPairs", "", "Lkotlin/Pair;", "keyNameToString", "key", "valueToString", "value", "formatCameraGraphProperties", "metadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Debug {
    public static final boolean ENABLE_LOGGING = true;
    public static final boolean ENABLE_TRACING = true;
    public static final Debug INSTANCE = new Debug();
    private static final SystemTimeSource systemTimeSource = new SystemTimeSource();

    private Debug() {
    }

    public final SystemTimeSource getSystemTimeSource$camera_camera2_pipe() {
        return systemTimeSource;
    }

    public final <T> T instrument$camera_camera2_pipe(String label, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(block, "block");
        long jMo927nowvQl9yQU = getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU();
        try {
            Trace.beginSection(label);
            return block.invoke();
        } finally {
            Trace.endSection();
            long jM917constructorimpl = DurationNs.m917constructorimpl(getSystemTimeSource$camera_camera2_pipe().mo927nowvQl9yQU() - jMo927nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sb = new StringBuilder();
                sb.append(label);
                sb.append(" - ");
                Timestamps timestamps = Timestamps.INSTANCE;
                String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
                android.util.Log.d(Log.TAG, sb.toString());
            }
        }
    }

    public final void traceStart(Function0<String> label) {
        Intrinsics.checkNotNullParameter(label, "label");
        Trace.beginSection(label.invoke());
    }

    public final void traceStop() {
        Trace.endSection();
    }

    private final void appendParameters(StringBuilder builder, String name, Map<?, ? extends Object> parameters) {
        if (parameters.isEmpty()) {
            builder.append(name + ": (None)\n");
            return;
        }
        builder.append(name + '\n');
        Iterator<T> it = INSTANCE.parametersToSortedStringPairs(parameters).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builder.append("  " + StringsKt.padEnd((String) pair.getFirst(), 50, ' ') + ' ' + ((String) pair.getSecond()) + '\n');
        }
    }

    public static /* synthetic */ String formatParameterMap$default(Debug debug, Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return debug.formatParameterMap(map, i);
    }

    public final String formatParameterMap(Map<?, ? extends Object> parameters, int limit) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return CollectionsKt.joinToString$default(parametersToSortedStringPairs(parameters), null, "{", "}", limit, null, new Function1() { // from class: androidx.camera.camera2.pipe.core.Debug$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Debug.formatParameterMap$lambda$0((Pair) obj);
            }
        }, 17, null);
    }

    static final CharSequence formatParameterMap$lambda$0(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((String) it.getFirst()) + '=' + ((String) it.getSecond());
    }

    public static /* synthetic */ String formatParameterMapToLineSeparatedList$default(Debug debug, Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return debug.formatParameterMapToLineSeparatedList(map, i);
    }

    public final String formatParameterMapToLineSeparatedList(Map<?, ? extends Object> parameters, int limit) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return CollectionsKt.joinToString$default(parametersToSortedStringPairs(parameters), ",\n", "{\n", "\n}", limit, null, new Function1() { // from class: androidx.camera.camera2.pipe.core.Debug$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Debug.formatParameterMapToLineSeparatedList$lambda$0((Pair) obj);
            }
        }, 16, null);
    }

    static final CharSequence formatParameterMapToLineSeparatedList$lambda$0(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((String) it.getFirst()) + '=' + ((String) it.getSecond());
    }

    private final String keyNameToString(Object key) {
        if (key instanceof CameraCharacteristics.Key) {
            String name = ((CameraCharacteristics.Key) key).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        if (key instanceof CaptureRequest.Key) {
            String name2 = ((CaptureRequest.Key) key).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            return name2;
        }
        if (!(key instanceof CaptureResult.Key)) {
            return String.valueOf(key);
        }
        String name3 = ((CaptureResult.Key) key).getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        return name3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String valueToString(Object value) {
        return value instanceof Object[] ? ArraysKt.joinToString$default((Object[]) value, (CharSequence) null, "[", "]", 0, (CharSequence) null, new Function1() { // from class: androidx.camera.camera2.pipe.core.Debug$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Debug.INSTANCE.valueToString(obj);
            }
        }, 25, (Object) null) : String.valueOf(value);
    }

    public final String formatCameraGraphProperties(CameraMetadata metadata, CameraGraph.Config graphConfig, CameraGraph cameraGraph) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        ConcurrentCameraGraphs concurrentCameraGraphs$camera_camera2_pipe = graphConfig.getConcurrentCameraGraphs();
        Set<CameraId> cameraIds = concurrentCameraGraphs$camera_camera2_pipe != null ? concurrentCameraGraphs$camera_camera2_pipe.getCameraIds() : null;
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
        Integer num = (Integer) metadata.get(LENS_FACING);
        String str3 = "External";
        String str4 = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        if (num != null && num.intValue() == 0) {
            str = "Front";
        } else if (num != null && num.intValue() == 1) {
            str = "Back";
        } else {
            str = (num != null && num.intValue() == 2) ? "External" : ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num2 = (Integer) metadata.get(INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num2 != null && num2.intValue() == 0) {
            str3 = "Limited";
        } else if (num2 != null && num2.intValue() == 1) {
            str3 = "Full";
        } else if (num2 != null && num2.intValue() == 2) {
            str3 = "Legacy";
        } else if (num2 != null && num2.intValue() == 3) {
            str3 = "Level 3";
        } else if (num2 == null || num2.intValue() != 4) {
            str3 = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        int iM389getSessionMode2uNL3no = graphConfig.m389getSessionMode2uNL3no();
        if (CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no, CameraGraph.OperatingMode.INSTANCE.m416getHIGH_SPEED2uNL3no())) {
            str4 = "High Speed";
        } else if (CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no, CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no())) {
            str4 = ReactProgressBarViewManager.DEFAULT_STYLE;
        } else if (CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no, CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no())) {
            str4 = "Extension";
        }
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) metadata.get(REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null && ArraysKt.contains(iArr, 11)) {
            str2 = "Logical";
        } else {
            str2 = "Physical";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cameraGraph + " (Camera " + graphConfig.m385getCameraDz_R5H8() + ")\n");
        if (cameraIds != null) {
            sb.append("  Concurrent: " + cameraIds + '\n');
        }
        sb.append("  Facing:    " + str + " (" + str2 + ", " + str3 + ")\n");
        StringBuilder sb2 = new StringBuilder("  Mode:      ");
        sb2.append(str4);
        sb2.append('\n');
        sb.append(sb2.toString());
        sb.append("Outputs:\n");
        Iterator<CameraStream> it = cameraGraph.getStreams().getStreams().iterator();
        while (it.hasNext()) {
            int i = 0;
            for (Object obj : it.next().getOutputs()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                OutputStream outputStream = (OutputStream) obj;
                sb.append("  ");
                sb.append(StringsKt.padEnd(i == 0 ? StreamId.m796toStringimpl(outputStream.getStream().getId()) : "", 12, ' '));
                sb.append(StringsKt.padEnd(OutputId.m576toStringimpl(outputStream.getId()), 12, ' '));
                String string = outputStream.getSize().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sb.append(StringsKt.padEnd(string, 12, ' '));
                sb.append(StringsKt.padEnd(StreamFormat.m750getNameimpl(outputStream.getFormat()), 16, ' '));
                OutputStream.MirrorMode mirrorModeMo596getMirrorModedO1_9xk = outputStream.getMirrorMode();
                if (mirrorModeMo596getMirrorModedO1_9xk != null) {
                    sb.append(" [" + ((Object) OutputStream.MirrorMode.m636toStringimpl(mirrorModeMo596getMirrorModedO1_9xk.m637unboximpl())) + AbstractJsonLexerKt.END_LIST);
                }
                OutputStream.TimestampBase timestampBaseMo599getTimestampBasepcPfPbY = outputStream.getTimestampBase();
                if (timestampBaseMo599getTimestampBasepcPfPbY != null) {
                    sb.append(" [" + ((Object) OutputStream.TimestampBase.m679toStringimpl(timestampBaseMo599getTimestampBasepcPfPbY.m680unboximpl())) + AbstractJsonLexerKt.END_LIST);
                }
                OutputStream.DynamicRangeProfile dynamicRangeProfileMo593getDynamicRangeProfileOoVcG5w = outputStream.getDynamicRangeProfile();
                if (dynamicRangeProfileMo593getDynamicRangeProfileOoVcG5w != null) {
                    sb.append(" [" + ((Object) OutputStream.DynamicRangeProfile.m616toStringimpl(dynamicRangeProfileMo593getDynamicRangeProfileOoVcG5w.m617unboximpl())) + AbstractJsonLexerKt.END_LIST);
                }
                OutputStream.StreamUseCase streamUseCaseMo597getStreamUseCase8x2ez34 = outputStream.getStreamUseCase();
                if (streamUseCaseMo597getStreamUseCase8x2ez34 != null) {
                    sb.append(" [" + ((Object) OutputStream.StreamUseCase.m656toStringimpl(streamUseCaseMo597getStreamUseCase8x2ez34.m657unboximpl())) + AbstractJsonLexerKt.END_LIST);
                }
                OutputStream.StreamUseHint streamUseHintMo598getStreamUseHintHIPxoCc = outputStream.getStreamUseHint();
                if (streamUseHintMo598getStreamUseHintHIPxoCc != null) {
                    sb.append(" [" + ((Object) OutputStream.StreamUseHint.m670toStringimpl(streamUseHintMo598getStreamUseHintHIPxoCc.m671unboximpl())) + AbstractJsonLexerKt.END_LIST);
                }
                if (!CameraId.m429equalsimpl0(outputStream.getCamera(), graphConfig.m385getCameraDz_R5H8())) {
                    sb.append(" [");
                    sb.append(CameraId.m426boximpl(outputStream.getCamera()));
                    sb.append("]");
                }
                sb.append("\n");
                i = i2;
            }
        }
        if (!cameraGraph.getStreams().getInputs().isEmpty()) {
            sb.append("Inputs:\n");
            for (InputStream inputStream : cameraGraph.getStreams().getInputs()) {
                sb.append(ServerSentEventKt.SPACE);
                sb.append(StringsKt.padEnd(InputStreamId.m556toStringimpl(inputStream.getId()), 12, ' '));
                sb.append(StringsKt.padEnd(StreamFormat.m752toStringimpl(inputStream.getFormat()), 12, ' '));
                sb.append(StringsKt.padEnd(String.valueOf(inputStream.getMaxImages()), 12, ' '));
                sb.append("\n");
            }
        }
        sb.append("Session Template: " + RequestTemplate.m718getNameimpl(graphConfig.m390getSessionTemplatefGx8uWA()) + '\n');
        Debug debug = INSTANCE;
        debug.appendParameters(sb, "Session Parameters", graphConfig.getSessionParameters());
        sb.append("Default Template: " + RequestTemplate.m718getNameimpl(graphConfig.m387getDefaultTemplatefGx8uWA()) + '\n');
        debug.appendParameters(sb, "Default Parameters", graphConfig.getDefaultParameters());
        debug.appendParameters(sb, "Required Parameters", graphConfig.getRequiredParameters());
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public final <T> T trace(String label, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Trace.beginSection(label);
            return block.invoke();
        } finally {
            Trace.endSection();
        }
    }

    private final List<Pair<String, String>> parametersToSortedStringPairs(Map<?, ? extends Object> parameters) {
        ArrayList arrayList = new ArrayList(parameters.size());
        for (Map.Entry<?, ? extends Object> entry : parameters.entrySet()) {
            Debug debug = INSTANCE;
            arrayList.add(TuplesKt.to(debug.keyNameToString(entry.getKey()), debug.valueToString(entry.getValue())));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.camera.camera2.pipe.core.Debug$parametersToSortedStringPairs$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            }
        });
    }
}
