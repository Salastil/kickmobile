package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.core.view.InputDeviceCompat;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J#\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0014J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010-\u001a\u00020\u0017*\u00020 2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0017\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J7\u00104\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0002\b8R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui$annotations", "getMotionEventToComposePointerIdMap$ui", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousIndirectPointerEventData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "previousToolType", "", "previousSource", "isInFakeFingerGesture", "", "isReinterpretingFakeFingerGesture", "inferredCursorRawOffset", "Landroidx/compose/ui/geometry/Offset;", "resetFakeFingerGesture", "", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui", "convertToIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "convertToIndirectPointerEvent-k92h6UU$ui", "endStream", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", "rawPositionOverride", FirebaseAnalytics.Param.INDEX, "pressed", "createPointerInputEventData-InuC1xA", "IndirectPointerEventData", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private Offset inferredCursorRawOffset;
    private boolean isInFakeFingerGesture;
    private boolean isReinterpretingFakeFingerGesture;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private final LongSparseArray<IndirectPointerEventData> previousIndirectPointerEventData = new LongSparseArray<>(0, 1, null);
    private int previousToolType = -1;
    private int previousSource = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui$annotations() {
    }

    /* JADX INFO: renamed from: getMotionEventToComposePointerIdMap$ui, reason: from getter */
    public final SparseLongArray getMotionEventToComposePointerIdMap() {
        return this.motionEventToComposePointerIdMap;
    }

    /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005\u0088\u0001\u0002¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "", "packedValue", "", "constructor-impl", "(J)J", "uptime", ViewProps.POSITION, "Landroidx/compose/ui/geometry/Offset;", GesturesListener.SCROLL_DIRECTION_DOWN, "", "(JJZ)J", "getPackedValue", "()J", "getDown-impl", "(J)Z", "getUptime-impl", "getPosition-F1C5BW0", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    private static final class IndirectPointerEventData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long packedValue;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IndirectPointerEventData m8586boximpl(long j) {
            return new IndirectPointerEventData(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m8587constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m8589equalsimpl(long j, Object obj) {
            return (obj instanceof IndirectPointerEventData) && j == ((IndirectPointerEventData) obj).m8596unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m8590equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: getDown-impl, reason: not valid java name */
        public static final boolean m8591getDownimpl(long j) {
            return (j & 1) != 0;
        }

        /* JADX INFO: renamed from: getUptime-impl, reason: not valid java name */
        public static final long m8593getUptimeimpl(long j) {
            return (j >> 1) & SieveCacheKt.NodeLinkMask;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m8594hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m8595toStringimpl(long j) {
            return "IndirectPointerEventData(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m8589equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m8594hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m8595toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m8596unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ IndirectPointerEventData(long j) {
            this.packedValue = j;
        }

        public final long getPackedValue() {
            return this.packedValue;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m8588constructorimpl(long j, long j2, boolean z) {
            return m8587constructorimpl(((j & SieveCacheKt.NodeLinkMask) << 1) | (z ? 1L : 0L) | (((long) INSTANCE.packShorts((short) Float.intBitsToFloat((int) (j2 >> 32)), (short) Float.intBitsToFloat((int) (j2 & 4294967295L)))) << 32));
        }

        /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
        public static final long m8592getPositionF1C5BW0(long j) {
            int i = (int) (j >>> 32);
            Companion companion = INSTANCE;
            float fUnpackShort1 = companion.unpackShort1(i);
            return Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(companion.unpackShort2(i))) & 4294967295L) | (Float.floatToRawIntBits(fUnpackShort1) << 32));
        }

        /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData$Companion;", "", "<init>", "()V", "packShorts", "", "val1", "", "val2", "unpackShort1", "value", "unpackShort2", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int packShorts(short val1, short val2) {
                return (val1 << 16) | (65535 & val2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort1(int value) {
                return (short) (value >>> 16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort2(int value) {
                return (short) (65535 & value);
            }

            private Companion() {
            }
        }
    }

    private final void resetFakeFingerGesture() {
        this.isInFakeFingerGesture = false;
        this.isReinterpretingFakeFingerGesture = false;
        this.inferredCursorRawOffset = null;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionIndex;
        MotionEventAdapter motionEventAdapter;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            resetFakeFingerGesture();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        this.pointers.clear();
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && motionEvent.getActionMasked() == 0) {
            boolean z3 = Build.VERSION.SDK_INT >= 34 && (motionEvent.getClassification() == 3 || motionEvent.getClassification() == 5);
            boolean z4 = motionEvent.getButtonState() == 0 && (motionEvent.isFromSource(8194) || motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD));
            if (z3 || z4) {
                this.isInFakeFingerGesture = true;
            }
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && Build.VERSION.SDK_INT >= 34 && motionEvent.getClassification() == 3) {
            this.isReinterpretingFakeFingerGesture = true;
            if (motionEvent.getActionMasked() == 0) {
                this.inferredCursorRawOffset = Offset.m7062boximpl(Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawY(0))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX(0))) << 32)));
            }
            motionEvent2 = motionEvent;
            motionEventAdapter = this;
            this.pointers.add(m8583createPointerInputEventDataInuC1xA(positionCalculator, motionEvent2, this.inferredCursorRawOffset, 0, false));
        } else {
            motionEventAdapter = this;
            PositionCalculator positionCalculator2 = positionCalculator;
            motionEventAdapter.isReinterpretingFakeFingerGesture = false;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            while (i < pointerCount) {
                motionEventAdapter.pointers.add(motionEventAdapter.m8583createPointerInputEventDataInuC1xA(positionCalculator2, motionEvent, null, i, (z || i == actionIndex || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
                i++;
                positionCalculator2 = positionCalculator2;
            }
            motionEvent2 = motionEvent;
        }
        if (motionEvent2.getActionMasked() == 1) {
            motionEventAdapter.resetFakeFingerGesture();
        }
        motionEventAdapter.removeStaleIds(motionEvent2);
        return new PointerInputEvent(motionEvent2.getEventTime(), motionEventAdapter.pointers, motionEvent2);
    }

    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui$default, reason: not valid java name */
    public static /* synthetic */ AndroidIndirectPointerEvent m8582convertToIndirectPointerEventk92h6UU$ui$default(MotionEventAdapter motionEventAdapter, MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, int i, Object obj) {
        if ((i & 2) != 0) {
            indirectPointerEventPrimaryDirectionalMotionAxis = null;
        }
        return motionEventAdapter.m8585convertToIndirectPointerEventk92h6UU$ui(motionEvent, indirectPointerEventPrimaryDirectionalMotionAxis);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui, reason: not valid java name */
    public final AndroidIndirectPointerEvent m8585convertToIndirectPointerEventk92h6UU$ui(MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride) {
        int actionIndex;
        int iIndirectPrimaryDirectionalScrollAxis;
        long eventTime;
        long jM8592getPositionF1C5BW0;
        boolean zM8591getDownimpl;
        MotionEventAdapter motionEventAdapter = this;
        int actionMasked = motionEvent.getActionMasked();
        clearOnDeviceChange(motionEvent);
        if (actionMasked == 3) {
            motionEventAdapter.motionEventToComposePointerIdMap.clear();
            motionEventAdapter.activeHoverIds.clear();
            return null;
        }
        addFreshIds(motionEvent);
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        boolean z = actionMasked == 0 || actionMasked == 2 || actionMasked == 5;
        int pointerCount = motionEvent.getPointerCount();
        ArrayList arrayList = new ArrayList(pointerCount);
        int i = 0;
        while (i < pointerCount) {
            long jM8584getComposePointerId_I2yYro = motionEventAdapter.m8584getComposePointerId_I2yYro(motionEvent.getPointerId(i));
            long jM7065constructorimpl = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getY(i))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getX(i))) << 32));
            boolean z2 = i != actionIndex;
            IndirectPointerEventData indirectPointerEventData = motionEventAdapter.previousIndirectPointerEventData.get(jM8584getComposePointerId_I2yYro);
            if (i == actionIndex) {
                motionEventAdapter.previousIndirectPointerEventData.remove(jM8584getComposePointerId_I2yYro);
            } else {
                if (z) {
                    motionEventAdapter.previousIndirectPointerEventData.put(jM8584getComposePointerId_I2yYro, IndirectPointerEventData.m8586boximpl(IndirectPointerEventData.m8588constructorimpl(motionEvent.getEventTime(), jM7065constructorimpl, true)));
                }
                long eventTime2 = motionEvent.getEventTime();
                float pressure = motionEvent.getPressure(i);
                if (indirectPointerEventData != null) {
                    eventTime = IndirectPointerEventData.m8593getUptimeimpl(indirectPointerEventData.m8596unboximpl());
                } else {
                    eventTime = motionEvent.getEventTime();
                }
                if (indirectPointerEventData != null) {
                    jM8592getPositionF1C5BW0 = IndirectPointerEventData.m8592getPositionF1C5BW0(indirectPointerEventData.m8596unboximpl());
                } else {
                    jM8592getPositionF1C5BW0 = jM7065constructorimpl;
                }
                if (indirectPointerEventData != null) {
                    zM8591getDownimpl = IndirectPointerEventData.m8591getDownimpl(indirectPointerEventData.m8596unboximpl());
                } else {
                    zM8591getDownimpl = false;
                }
                arrayList.add(new IndirectPointerInputChange(jM8584getComposePointerId_I2yYro, eventTime2, jM7065constructorimpl, z2, pressure, eventTime, jM8592getPositionF1C5BW0, zM8591getDownimpl, null));
                i++;
                motionEventAdapter = this;
                actionMasked = actionMasked;
            }
            long eventTime3 = motionEvent.getEventTime();
            float pressure2 = motionEvent.getPressure(i);
            if (indirectPointerEventData != null) {
                eventTime = IndirectPointerEventData.m8593getUptimeimpl(indirectPointerEventData.m8596unboximpl());
            } else {
                eventTime = motionEvent.getEventTime();
            }
            if (indirectPointerEventData != null) {
                jM8592getPositionF1C5BW0 = IndirectPointerEventData.m8592getPositionF1C5BW0(indirectPointerEventData.m8596unboximpl());
            } else {
                jM8592getPositionF1C5BW0 = jM7065constructorimpl;
            }
            if (indirectPointerEventData != null) {
                zM8591getDownimpl = IndirectPointerEventData.m8591getDownimpl(indirectPointerEventData.m8596unboximpl());
            } else {
                zM8591getDownimpl = false;
            }
            arrayList.add(new IndirectPointerInputChange(jM8584getComposePointerId_I2yYro, eventTime3, jM7065constructorimpl, z2, pressure2, eventTime, jM8592getPositionF1C5BW0, zM8591getDownimpl, null));
            i++;
            motionEventAdapter = this;
            actionMasked = actionMasked;
        }
        int i2 = actionMasked;
        ArrayList arrayList2 = arrayList;
        removeStaleIds(motionEvent);
        if (primaryDirectionalMotionAxisOverride != null) {
            iIndirectPrimaryDirectionalScrollAxis = primaryDirectionalMotionAxisOverride.getValue();
        } else {
            iIndirectPrimaryDirectionalScrollAxis = AndroidIndirectPointerEvent_androidKt.indirectPrimaryDirectionalScrollAxis(motionEvent);
        }
        return new AndroidIndirectPointerEvent(arrayList2, AndroidIndirectPointerEvent_androidKt.convertActionToIndirectPointerEventType(i2), iIndirectPrimaryDirectionalScrollAxis, motionEvent, null);
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m8584getComposePointerId_I2yYro(int motionEventPointerId) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            long j = this.nextId;
            this.nextId = 1 + j;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, j);
            jValueAt = j;
        }
        return PointerId.m8652constructorimpl(jValueAt);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0090  */
    /* JADX WARN: Code duplicated, block: B:20:0x0095  */
    /* JADX WARN: Code duplicated, block: B:22:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x009a  */
    /* JADX WARN: Code duplicated, block: B:25:0x009d  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:47:0x010c  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x01df  */
    /* JADX WARN: Code duplicated, block: B:76:0x020b  */
    /* JADX WARN: Code duplicated, block: B:78:0x020f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0246  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b2 A[EDGE_INSN: B:89:0x01b2->B:64:0x01b2 BREAK  A[LOOP:0: B:45:0x0104->B:63:0x01ac], SYNTHETIC] */
    /* JADX INFO: renamed from: createPointerInputEventData-InuC1xA, reason: not valid java name */
    private final PointerInputEventData m8583createPointerInputEventDataInuC1xA(PositionCalculator positionCalculator, MotionEvent motionEvent, Offset rawPositionOverride, int index, boolean pressed) {
        char c;
        long j;
        long jMo8757localToScreenMKHz9U;
        long j2;
        long jMo8758screenToLocalMKHz9U;
        int toolType;
        char c2;
        int iM8756getUnknownT8wyACA;
        int historySize;
        int i;
        float fFloatValue;
        long jM7089getZeroF1C5BW0;
        long jM7089getZeroF1C5BW1;
        Float f;
        float historicalX;
        long jM7089getZeroF1C5BW2;
        long jM8584getComposePointerId_I2yYro = m8584getComposePointerId_I2yYro(motionEvent.getPointerId(index));
        float pressure = motionEvent.getPressure(index);
        long jM7065constructorimpl = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getY(index))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getX(index))) << 32));
        if (index == 0) {
            if (rawPositionOverride != null) {
                c = ' ';
                jMo8757localToScreenMKHz9U = rawPositionOverride.m7083unboximpl();
                j = 4294967295L;
            } else {
                c = ' ';
                j = 4294967295L;
                jMo8757localToScreenMKHz9U = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawX())) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getRawY())) & 4294967295L));
            }
            jMo8758screenToLocalMKHz9U = positionCalculator.mo8758screenToLocalMKHz9U(jMo8757localToScreenMKHz9U);
        } else {
            c = ' ';
            j = 4294967295L;
            if (Build.VERSION.SDK_INT >= 29) {
                jMo8757localToScreenMKHz9U = rawPositionOverride != null ? rawPositionOverride.m7083unboximpl() : MotionEventHelper.INSTANCE.m8597toRawOffsetdBAh8RU(motionEvent, index);
                jMo8758screenToLocalMKHz9U = positionCalculator.mo8758screenToLocalMKHz9U(jMo8757localToScreenMKHz9U);
            } else {
                jMo8757localToScreenMKHz9U = positionCalculator.mo8757localToScreenMKHz9U(jM7065constructorimpl);
                j2 = jM7065constructorimpl;
            }
            long j3 = jMo8757localToScreenMKHz9U;
            toolType = motionEvent.getToolType(index);
            if (toolType != 0) {
                c2 = c;
                if (toolType != 1) {
                    if (toolType != 2) {
                        iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8754getStylusT8wyACA();
                    } else if (toolType != 3) {
                        iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8753getMouseT8wyACA();
                    } else if (toolType != 4) {
                        iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8752getEraserT8wyACA();
                    } else {
                        iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8756getUnknownT8wyACA();
                    }
                } else if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                    if ((motionEvent.isFromSource(8194) && !motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD)) || (this.isInFakeFingerGesture && !this.isReinterpretingFakeFingerGesture)) {
                        iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8755getTouchT8wyACA();
                    }
                } else {
                    iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8755getTouchT8wyACA();
                }
            } else {
                c2 = c;
                iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8756getUnknownT8wyACA();
            }
            ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
            historySize = motionEvent.getHistorySize();
            int i2 = iM8756getUnknownT8wyACA;
            i = 0;
            while (true) {
                fFloatValue = 1.0f;
                if (i < historySize) {
                    break;
                }
                historicalX = motionEvent.getHistoricalX(index, i);
                float historicalY = motionEvent.getHistoricalY(index, i);
                long j4 = jM7065constructorimpl;
                if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040 && (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) < 2139095040) {
                    long jM7065constructorimpl2 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(historicalX)) << c2) | (((long) Float.floatToRawIntBits(historicalY)) & j));
                    long historicalEventTime = motionEvent.getHistoricalEventTime(i);
                    Float fValueOf = Float.valueOf(motionEvent.getHistoricalAxisValue(52, index, i));
                    f = fValueOf.floatValue() > 0.0f ? fValueOf : null;
                    float fFloatValue2 = f != null ? f.floatValue() : 1.0f;
                    if (Build.VERSION.SDK_INT < 29 || motionEvent.getClassification() != 3) {
                        jM7089getZeroF1C5BW2 = Offset.INSTANCE.m7089getZeroF1C5BW0();
                    } else {
                        jM7089getZeroF1C5BW2 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(50, index, i))) << c2) | (((long) Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(51, index, i))) & j));
                    }
                    arrayList.add(new HistoricalChange(historicalEventTime, jM7065constructorimpl2, fFloatValue2, jM7089getZeroF1C5BW2, jM7065constructorimpl2, (DefaultConstructorMarker) null));
                }
                i++;
                jM7065constructorimpl = j4;
            }
            long j5 = jM7065constructorimpl;
            if (motionEvent.getActionMasked() == 8) {
                jM7089getZeroF1C5BW0 = Offset.INSTANCE.m7089getZeroF1C5BW0();
            } else {
                jM7089getZeroF1C5BW0 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f)) & j) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c2));
            }
            if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && Build.VERSION.SDK_INT >= 29 && motionEvent.getClassification() == 5) {
                Float fValueOf2 = Float.valueOf(motionEvent.getAxisValue(52, index));
                f = fValueOf2.floatValue() > 0.0f ? fValueOf2 : null;
                if (f != null) {
                    fFloatValue = f.floatValue();
                }
            }
            if (ComposeUiFlags.isTrackpadGestureHandlingEnabled || Build.VERSION.SDK_INT < 29 || motionEvent.getClassification() != 3) {
                jM7089getZeroF1C5BW1 = Offset.INSTANCE.m7089getZeroF1C5BW0();
            } else {
                jM7089getZeroF1C5BW1 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getAxisValue(50, index))) << c2) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(51, index))) & j));
            }
            return new PointerInputEventData(jM8584getComposePointerId_I2yYro, motionEvent.getEventTime(), j3, j2, pressed, pressure, i2, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList, jM7089getZeroF1C5BW0, fFloatValue, jM7089getZeroF1C5BW1, j5, null);
        }
        j2 = jMo8758screenToLocalMKHz9U;
        long j6 = jMo8757localToScreenMKHz9U;
        toolType = motionEvent.getToolType(index);
        if (toolType != 0) {
            c2 = c;
            if (toolType != 1) {
                if (toolType != 2) {
                    iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8754getStylusT8wyACA();
                } else if (toolType != 3) {
                    iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8753getMouseT8wyACA();
                } else if (toolType != 4) {
                    iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8752getEraserT8wyACA();
                } else {
                    iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8756getUnknownT8wyACA();
                }
            } else if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                iM8756getUnknownT8wyACA = motionEvent.isFromSource(8194) ? PointerType.INSTANCE.m8753getMouseT8wyACA() : PointerType.INSTANCE.m8753getMouseT8wyACA();
            } else {
                iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8755getTouchT8wyACA();
            }
        } else {
            c2 = c;
            iM8756getUnknownT8wyACA = PointerType.INSTANCE.m8756getUnknownT8wyACA();
        }
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        int i3 = iM8756getUnknownT8wyACA;
        i = 0;
        while (true) {
            fFloatValue = 1.0f;
            if (i < historySize) {
                break;
                break;
            }
            historicalX = motionEvent.getHistoricalX(index, i);
            float historicalY2 = motionEvent.getHistoricalY(index, i);
            long j7 = jM7065constructorimpl;
            if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040) {
            }
            i++;
            jM7065constructorimpl = j7;
        }
        long j8 = jM7065constructorimpl;
        if (motionEvent.getActionMasked() == 8) {
            jM7089getZeroF1C5BW0 = Offset.INSTANCE.m7089getZeroF1C5BW0();
        } else {
            jM7089getZeroF1C5BW0 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f)) & j) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c2));
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
            Float fValueOf3 = Float.valueOf(motionEvent.getAxisValue(52, index));
            if (fValueOf3.floatValue() > 0.0f) {
            }
            if (f != null) {
                fFloatValue = f.floatValue();
            }
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
            jM7089getZeroF1C5BW1 = Offset.INSTANCE.m7089getZeroF1C5BW0();
        } else {
            jM7089getZeroF1C5BW1 = Offset.INSTANCE.m7089getZeroF1C5BW0();
        }
        return new PointerInputEventData(jM8584getComposePointerId_I2yYro, motionEvent.getEventTime(), j6, j2, pressed, pressure, i3, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList2, jM7089getZeroF1C5BW0, fFloatValue, jM7089getZeroF1C5BW1, j8, null);
    }
}
