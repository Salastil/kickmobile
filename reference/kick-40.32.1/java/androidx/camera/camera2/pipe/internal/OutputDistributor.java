package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.CameraTimestamp;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.media.Finalizer;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: OutputDistributor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u000278B'\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00112\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0014¢\u0006\u0004\b/\u00100J\"\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a022\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0003J,\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a022\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "maximumCachedOutputs", "", "outputFinalizer", "Landroidx/camera/camera2/pipe/media/Finalizer;", "outputMatcher", "Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "<init>", "(ILandroidx/camera/camera2/pipe/media/Finalizer;Landroidx/camera/camera2/pipe/internal/OutputMatcher;)V", "lock", "", "closed", "", "cameraOutputSequenceNumbers", "", "newestCameraOutputNumber", "newestFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "J", "lastFailedFrameNumber", "lastFailedCameraOutputNumber", "startedOutputs", "", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", "availableOutputs", "", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputStarted", "", "cameraFrameNumber", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputNumber", "outputListener", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "onOutputStarted-qGubWw0", "(JJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;)V", "onOutputResult", "outputNumber", "outputResult", "onOutputResult-DvZWqE8", "(JLjava/lang/Object;)V", "onOutputFailure", "frameNumber", "onOutputFailure-Vw7M1qk", "(J)V", "removeOutputsOlderThan", "", "output", "isOutOfOrder", "cameraOutputSequence", "close", "OutputListener", "StartedOutput", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputDistributor<T> implements AutoCloseable {
    private final Map<Long, OutputResult<T>> availableOutputs;
    private long cameraOutputSequenceNumbers;
    private boolean closed;
    private long lastFailedCameraOutputNumber;
    private long lastFailedFrameNumber;
    private final Object lock;
    private final int maximumCachedOutputs;
    private long newestCameraOutputNumber;
    private long newestFrameNumber;
    private final Finalizer<T> outputFinalizer;
    private final OutputMatcher outputMatcher;
    private final List<StartedOutput<T>> startedOutputs;

    /* JADX INFO: compiled from: OutputDistributor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onOutputComplete", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputComplete-3ejhThk", "(JJJJLjava/lang/Object;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OutputListener<T> {
        /* JADX INFO: renamed from: onOutputComplete-3ejhThk */
        void mo1016onOutputComplete3ejhThk(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutputDistributor(int i, Finalizer<? super T> outputFinalizer, OutputMatcher outputMatcher) {
        Intrinsics.checkNotNullParameter(outputFinalizer, "outputFinalizer");
        Intrinsics.checkNotNullParameter(outputMatcher, "outputMatcher");
        this.maximumCachedOutputs = i;
        this.outputFinalizer = outputFinalizer;
        this.outputMatcher = outputMatcher;
        this.lock = new Object();
        this.cameraOutputSequenceNumbers = 1L;
        this.newestCameraOutputNumber = Long.MIN_VALUE;
        this.newestFrameNumber = FrameNumber.m532constructorimpl(Long.MIN_VALUE);
        this.lastFailedFrameNumber = Long.MIN_VALUE;
        this.lastFailedCameraOutputNumber = Long.MIN_VALUE;
        this.startedOutputs = new ArrayList();
        this.availableOutputs = new LinkedHashMap();
    }

    public /* synthetic */ OutputDistributor(int i, Finalizer finalizer, OutputMatcher outputMatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, finalizer, outputMatcher);
    }

    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0165  */
    /* JADX WARN: Code duplicated, block: B:73:0x0171 A[LOOP:2: B:71:0x016b->B:73:0x0171, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x0187  */
    /* JADX WARN: Code duplicated, block: B:79:0x0192  */
    /* JADX WARN: Code duplicated, block: B:81:0x0195  */
    /* JADX WARN: Code duplicated, block: B:83:0x019c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x019e  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: onOutputStarted-qGubWw0, reason: not valid java name */
    public final void m1027onOutputStartedqGubWw0(long cameraFrameNumber, long cameraTimestamp, long cameraOutputNumber, OutputListener<T> outputListener) {
        T next;
        boolean z;
        OutputDistributor<T> outputDistributor;
        T next2;
        T t;
        Long l;
        List<StartedOutput<T>> listRemoveOutputsOlderThan;
        boolean z2;
        OutputResult<T> outputResultRemove;
        OutputResult outputResult;
        OutputResult<T> outputResult2;
        Object objM1038constructorimpl;
        long jLongValue;
        Object result;
        Iterator<T> it;
        T next3;
        Intrinsics.checkNotNullParameter(outputListener, "outputListener");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            Iterator<T> it2 = this.startedOutputs.iterator();
            do {
                if (!it2.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it2.next();
            } while (!FrameNumber.m534equalsimpl0(((StartedOutput) next).m1034getCameraFrameNumberUgla2oM(), cameraFrameNumber));
            StartedOutput startedOutput = next;
            if (startedOutput != null) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "onOutputStarted was invoked multiple times with a previously started output!onOutputStarted with " + ((Object) FrameNumber.m536toStringimpl(cameraFrameNumber)) + ", " + ((Object) CameraTimestamp.m466toStringimpl(cameraTimestamp)) + ", " + cameraOutputNumber + ". Previously started output: " + startedOutput + ". Ignoring.");
                }
                return;
            }
            boolean z3 = this.closed;
            long j = this.cameraOutputSequenceNumbers;
            this.cameraOutputSequenceNumbers = 1 + j;
            if (!z3 && this.lastFailedFrameNumber != cameraFrameNumber && this.lastFailedCameraOutputNumber != cameraOutputNumber) {
                boolean z4 = cameraFrameNumber < this.newestFrameNumber;
                if (!z4) {
                    this.newestFrameNumber = cameraFrameNumber;
                }
                boolean z5 = cameraOutputNumber < this.newestCameraOutputNumber;
                if (!z5) {
                    this.newestCameraOutputNumber = cameraOutputNumber;
                }
                boolean z6 = z4 || z5;
                Iterator<T> it3 = this.availableOutputs.keySet().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = z3;
                        next3 = (T) null;
                        break;
                    } else {
                        next3 = it3.next();
                        z = z3;
                        if (this.outputMatcher.fuzzyEqual(cameraOutputNumber, ((Number) next3).longValue())) {
                            break;
                        } else {
                            z3 = z;
                        }
                    }
                }
                Long l2 = next3;
                if (l2 != null) {
                    outputResultRemove = this.availableOutputs.remove(l2);
                    listRemoveOutputsOlderThan = removeOutputsOlderThan(z6, j, cameraOutputNumber);
                    outputDistributor = this;
                    l = l2;
                    z2 = true;
                } else {
                    outputDistributor = this;
                    List<StartedOutput<T>> list = outputDistributor.startedOutputs;
                    StartedOutput<T> startedOutput2 = new StartedOutput<>(z6, cameraFrameNumber, cameraTimestamp, j, cameraOutputNumber, outputListener, null);
                    j = j;
                    list.add(startedOutput2);
                    z2 = false;
                    l = null;
                    listRemoveOutputsOlderThan = null;
                }
                Unit unit = Unit.INSTANCE;
                if (listRemoveOutputsOlderThan != null) {
                    it = listRemoveOutputsOlderThan.iterator();
                    while (it.hasNext()) {
                        ((StartedOutput) it.next()).m1030completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m589getERROR_OUTPUT_MISSINGU7r42EA());
                    }
                }
                outputResult = (OutputResult) objectRef.element;
                if (outputResult != null) {
                    result = outputResult.getResult();
                    if (!OutputResult.m1041getAvailableimpl(result)) {
                        result = null;
                    }
                    if (result != null) {
                        outputDistributor.outputFinalizer.finalize((T) result);
                    }
                }
                if (z2) {
                    if (z) {
                        OutputResult.Companion companion = OutputResult.INSTANCE;
                        objM1038constructorimpl = OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(OutputStatus.INSTANCE.m586getERROR_OUTPUT_ABORTEDU7r42EA()));
                    } else {
                        outputResult2 = outputResultRemove;
                        if (outputResult2 != null) {
                            objM1038constructorimpl = outputResult2.getResult();
                        } else {
                            OutputResult.Companion companion2 = OutputResult.INSTANCE;
                            objM1038constructorimpl = OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(OutputStatus.INSTANCE.m588getERROR_OUTPUT_FAILEDU7r42EA()));
                        }
                    }
                    Object obj = objM1038constructorimpl;
                    if (l != null) {
                        jLongValue = l.longValue();
                    } else {
                        jLongValue = -1;
                    }
                    outputListener.mo1016onOutputComplete3ejhThk(cameraFrameNumber, cameraTimestamp, j, jLongValue, obj);
                }
            }
            z = z3;
            outputDistributor = this;
            Iterator<T> it4 = outputDistributor.availableOutputs.keySet().iterator();
            do {
                if (!it4.hasNext()) {
                    next2 = (T) null;
                    break;
                }
                next2 = it4.next();
            } while (!outputDistributor.outputMatcher.fuzzyEqual(cameraOutputNumber, ((Number) next2).longValue()));
            Long l3 = next2;
            if (l3 != null) {
                l3.longValue();
                t = (T) outputDistributor.availableOutputs.remove(l3);
            } else {
                t = null;
            }
            objectRef.element = t;
            l = l3;
            listRemoveOutputsOlderThan = null;
            z2 = true;
            outputResultRemove = null;
            Unit unit2 = Unit.INSTANCE;
            if (listRemoveOutputsOlderThan != null) {
                it = listRemoveOutputsOlderThan.iterator();
                while (it.hasNext()) {
                    ((StartedOutput) it.next()).m1030completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m589getERROR_OUTPUT_MISSINGU7r42EA());
                }
            }
            outputResult = (OutputResult) objectRef.element;
            if (outputResult != null) {
                result = outputResult.getResult();
                if (!OutputResult.m1041getAvailableimpl(result)) {
                    result = null;
                }
                if (result != null) {
                    outputDistributor.outputFinalizer.finalize((T) result);
                }
            }
            if (z2) {
                if (z) {
                    OutputResult.Companion companion3 = OutputResult.INSTANCE;
                    objM1038constructorimpl = OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(OutputStatus.INSTANCE.m586getERROR_OUTPUT_ABORTEDU7r42EA()));
                } else {
                    outputResult2 = outputResultRemove;
                    if (outputResult2 != null) {
                        objM1038constructorimpl = outputResult2.getResult();
                    } else {
                        OutputResult.Companion companion4 = OutputResult.INSTANCE;
                        objM1038constructorimpl = OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(OutputStatus.INSTANCE.m588getERROR_OUTPUT_FAILEDU7r42EA()));
                    }
                }
                Object obj2 = objM1038constructorimpl;
                if (l != null) {
                    jLongValue = l.longValue();
                } else {
                    jLongValue = -1;
                }
                outputListener.mo1016onOutputComplete3ejhThk(cameraFrameNumber, cameraTimestamp, j, jLongValue, obj2);
            }
        }
    }

    /* JADX INFO: renamed from: onOutputResult-DvZWqE8, reason: not valid java name */
    public final void m1026onOutputResultDvZWqE8(long outputNumber, Object outputResult) {
        OutputResult<T> outputResultM1037boximpl;
        List<StartedOutput<T>> listRemoveOutputsOlderThan;
        T next;
        synchronized (this.lock) {
            if (this.closed || this.outputMatcher.fuzzyEqual(this.lastFailedCameraOutputNumber, outputNumber)) {
                outputResultM1037boximpl = OutputResult.m1037boximpl(outputResult);
            } else {
                Iterator<T> it = this.startedOutputs.iterator();
                do {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                } while (!this.outputMatcher.fuzzyEqual(((StartedOutput) next).getCameraOutputNumber(), outputNumber));
                StartedOutput<T> startedOutput = next;
                if (startedOutput != null) {
                    listRemoveOutputsOlderThan = removeOutputsOlderThan(startedOutput);
                    startedOutput.m1029completeWithDvZWqE8(outputNumber, outputResult);
                    this.startedOutputs.remove(startedOutput);
                    outputResultM1037boximpl = null;
                } else {
                    this.availableOutputs.put(Long.valueOf(outputNumber), OutputResult.m1037boximpl(outputResult));
                    if (this.availableOutputs.size() > this.maximumCachedOutputs) {
                        outputResultM1037boximpl = this.availableOutputs.remove(Long.valueOf(((Number) CollectionsKt.first(this.availableOutputs.keySet())).longValue()));
                    } else {
                        outputResultM1037boximpl = null;
                        listRemoveOutputsOlderThan = null;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            listRemoveOutputsOlderThan = null;
            Unit unit2 = Unit.INSTANCE;
        }
        OutputResult<T> outputResult2 = outputResultM1037boximpl;
        if (outputResult2 != null) {
            Object result = outputResult2.getResult();
            Object obj = OutputResult.m1041getAvailableimpl(result) ? result : null;
            if (obj != null) {
                this.outputFinalizer.finalize((T) obj);
            }
        }
        if (listRemoveOutputsOlderThan != null) {
            Iterator<T> it2 = listRemoveOutputsOlderThan.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).m1030completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m589getERROR_OUTPUT_MISSINGU7r42EA());
            }
        }
    }

    /* JADX INFO: renamed from: onOutputFailure-Vw7M1qk, reason: not valid java name */
    public final void m1025onOutputFailureVw7M1qk(long frameNumber) {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.lastFailedFrameNumber = frameNumber;
            Iterator<T> it = this.startedOutputs.iterator();
            StartedOutput startedOutput = null;
            boolean z = false;
            StartedOutput startedOutput2 = null;
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    T next = it.next();
                    if (FrameNumber.m534equalsimpl0(((StartedOutput) next).m1034getCameraFrameNumberUgla2oM(), frameNumber)) {
                        if (!z) {
                            z = true;
                            startedOutput2 = next;
                        }
                    }
                }
                startedOutput2 = null;
                break;
            }
            StartedOutput startedOutput3 = startedOutput2;
            if (startedOutput3 != null) {
                this.lastFailedCameraOutputNumber = startedOutput3.getCameraOutputNumber();
                this.startedOutputs.remove(startedOutput3);
                Unit unit = Unit.INSTANCE;
                startedOutput = startedOutput3;
            }
            if (startedOutput != null) {
                startedOutput.m1030completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m588getERROR_OUTPUT_FAILEDU7r42EA());
            }
        }
    }

    private final List<StartedOutput<T>> removeOutputsOlderThan(StartedOutput<T> output) {
        return removeOutputsOlderThan(output.isOutOfOrder(), output.getCameraOutputSequence(), output.getCameraOutputNumber());
    }

    private final List<StartedOutput<T>> removeOutputsOlderThan(boolean isOutOfOrder, long cameraOutputSequence, long cameraOutputNumber) {
        List<StartedOutput<T>> list = this.startedOutputs;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            StartedOutput startedOutput = (StartedOutput) t;
            if (startedOutput.isOutOfOrder() == isOutOfOrder && startedOutput.getCameraOutputSequence() < cameraOutputSequence && startedOutput.getCameraOutputNumber() < cameraOutputNumber) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.startedOutputs.removeAll(arrayList2);
        return arrayList2;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            List mutableList = CollectionsKt.toMutableList((Collection) this.availableOutputs.values());
            this.availableOutputs.clear();
            List mutableList2 = CollectionsKt.toMutableList((Collection) this.startedOutputs);
            this.startedOutputs.clear();
            Unit unit = Unit.INSTANCE;
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                Object result = ((OutputResult) it.next()).getResult();
                Finalizer<T> finalizer = this.outputFinalizer;
                if (!OutputResult.m1041getAvailableimpl(result)) {
                    result = null;
                }
                finalizer.finalize((T) result);
            }
            Iterator it2 = mutableList2.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).m1030completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m586getERROR_OUTPUT_ABORTEDU7r42EA());
            }
        }
    }

    /* JADX INFO: compiled from: OutputDistributor.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b#\u0010$J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\u0010\u0010&\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b'\u0010\u0012J\u0010\u0010(\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b)\u0010\u0012J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\rHÂ\u0003JX\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", ExifInterface.GPS_DIRECTION_TRUE, "", "isOutOfOrder", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "cameraOutputNumber", "outputListener", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "<init>", "(ZJJJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getCameraFrameNumber-Ugla2oM", "()J", "J", "getCameraTimestamp-LS1Wq50", "getCameraOutputSequence", "getCameraOutputNumber", "complete", "Lkotlinx/atomicfu/AtomicBoolean;", "completeWithFailure", "", "failureReason", "Landroidx/camera/camera2/pipe/OutputStatus;", "completeWithFailure-tXNfJfc", "(I)V", "completeWith", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "completeWith-DvZWqE8", "(JLjava/lang/Object;)V", "component1", "component2", "component2-Ugla2oM", "component3", "component3-LS1Wq50", "component4", "component5", "component6", "copy", "copy-HscHeSQ", "(ZJJJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;)Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", "equals", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class StartedOutput<T> {
        private final long cameraFrameNumber;
        private final long cameraOutputNumber;
        private final long cameraOutputSequence;
        private final long cameraTimestamp;
        private final AtomicBoolean complete;
        private final boolean isOutOfOrder;
        private final OutputListener<T> outputListener;

        public /* synthetic */ StartedOutput(boolean z, long j, long j2, long j3, long j4, OutputListener outputListener, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, j, j2, j3, j4, outputListener);
        }

        private final OutputListener<T> component6() {
            return this.outputListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-HscHeSQ$default, reason: not valid java name */
        public static /* synthetic */ StartedOutput m1028copyHscHeSQ$default(StartedOutput startedOutput, boolean z, long j, long j2, long j3, long j4, OutputListener outputListener, int i, Object obj) {
            if ((i & 1) != 0) {
                z = startedOutput.isOutOfOrder;
            }
            if ((i & 2) != 0) {
                j = startedOutput.cameraFrameNumber;
            }
            if ((i & 4) != 0) {
                j2 = startedOutput.cameraTimestamp;
            }
            if ((i & 8) != 0) {
                j3 = startedOutput.cameraOutputSequence;
            }
            if ((i & 16) != 0) {
                j4 = startedOutput.cameraOutputNumber;
            }
            if ((i & 32) != 0) {
                outputListener = startedOutput.outputListener;
            }
            OutputListener outputListener2 = outputListener;
            long j5 = j4;
            long j6 = j3;
            return startedOutput.m1033copyHscHeSQ(z, j, j2, j6, j5, outputListener2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsOutOfOrder() {
            return this.isOutOfOrder;
        }

        /* JADX INFO: renamed from: component2-Ugla2oM, reason: not valid java name and from getter */
        public final long getCameraFrameNumber() {
            return this.cameraFrameNumber;
        }

        /* JADX INFO: renamed from: component3-LS1Wq50, reason: not valid java name and from getter */
        public final long getCameraTimestamp() {
            return this.cameraTimestamp;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getCameraOutputSequence() {
            return this.cameraOutputSequence;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getCameraOutputNumber() {
            return this.cameraOutputNumber;
        }

        /* JADX INFO: renamed from: copy-HscHeSQ, reason: not valid java name */
        public final StartedOutput<T> m1033copyHscHeSQ(boolean isOutOfOrder, long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long cameraOutputNumber, OutputListener<T> outputListener) {
            Intrinsics.checkNotNullParameter(outputListener, "outputListener");
            return new StartedOutput<>(isOutOfOrder, cameraFrameNumber, cameraTimestamp, cameraOutputSequence, cameraOutputNumber, outputListener, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartedOutput)) {
                return false;
            }
            StartedOutput startedOutput = (StartedOutput) other;
            return this.isOutOfOrder == startedOutput.isOutOfOrder && FrameNumber.m534equalsimpl0(this.cameraFrameNumber, startedOutput.cameraFrameNumber) && CameraTimestamp.m464equalsimpl0(this.cameraTimestamp, startedOutput.cameraTimestamp) && this.cameraOutputSequence == startedOutput.cameraOutputSequence && this.cameraOutputNumber == startedOutput.cameraOutputNumber && Intrinsics.areEqual(this.outputListener, startedOutput.outputListener);
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isOutOfOrder) * 31) + FrameNumber.m535hashCodeimpl(this.cameraFrameNumber)) * 31) + CameraTimestamp.m465hashCodeimpl(this.cameraTimestamp)) * 31) + Long.hashCode(this.cameraOutputSequence)) * 31) + Long.hashCode(this.cameraOutputNumber)) * 31) + this.outputListener.hashCode();
        }

        public String toString() {
            return "StartedOutput(isOutOfOrder=" + this.isOutOfOrder + ", cameraFrameNumber=" + ((Object) FrameNumber.m536toStringimpl(this.cameraFrameNumber)) + ", cameraTimestamp=" + ((Object) CameraTimestamp.m466toStringimpl(this.cameraTimestamp)) + ", cameraOutputSequence=" + this.cameraOutputSequence + ", cameraOutputNumber=" + this.cameraOutputNumber + ", outputListener=" + this.outputListener + ')';
        }

        private StartedOutput(boolean z, long j, long j2, long j3, long j4, OutputListener<T> outputListener) {
            Intrinsics.checkNotNullParameter(outputListener, "outputListener");
            this.isOutOfOrder = z;
            this.cameraFrameNumber = j;
            this.cameraTimestamp = j2;
            this.cameraOutputSequence = j3;
            this.cameraOutputNumber = j4;
            this.outputListener = outputListener;
            this.complete = AtomicFU.atomic(false);
        }

        public final boolean isOutOfOrder() {
            return this.isOutOfOrder;
        }

        /* JADX INFO: renamed from: getCameraFrameNumber-Ugla2oM, reason: not valid java name */
        public final long m1034getCameraFrameNumberUgla2oM() {
            return this.cameraFrameNumber;
        }

        /* JADX INFO: renamed from: getCameraTimestamp-LS1Wq50, reason: not valid java name */
        public final long m1035getCameraTimestampLS1Wq50() {
            return this.cameraTimestamp;
        }

        public final long getCameraOutputSequence() {
            return this.cameraOutputSequence;
        }

        public final long getCameraOutputNumber() {
            return this.cameraOutputNumber;
        }

        /* JADX INFO: renamed from: completeWithFailure-tXNfJfc, reason: not valid java name */
        public final void m1030completeWithFailuretXNfJfc(int failureReason) {
            OutputResult.Companion companion = OutputResult.INSTANCE;
            m1029completeWithDvZWqE8(-1L, OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(failureReason)));
        }

        /* JADX INFO: renamed from: completeWith-DvZWqE8, reason: not valid java name */
        public final void m1029completeWithDvZWqE8(long outputNumber, Object outputResult) {
            if (!this.complete.compareAndSet(false, true)) {
                throw new IllegalStateException(("Output " + this.cameraOutputSequence + " at " + ((Object) FrameNumber.m536toStringimpl(this.cameraFrameNumber)) + " for " + outputNumber + " was completed multiple times!").toString());
            }
            this.outputListener.mo1016onOutputComplete3ejhThk(this.cameraFrameNumber, this.cameraTimestamp, this.cameraOutputSequence, outputNumber, outputResult);
        }
    }
}
