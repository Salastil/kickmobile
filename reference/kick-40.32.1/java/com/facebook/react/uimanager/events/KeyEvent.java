package com.facebook.react.uimanager.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b \u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/uimanager/events/KeyEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewTag", "keyEvent", "Landroid/view/KeyEvent;", "<init>", "(IILandroid/view/KeyEvent;)V", "keyCode", "unicodeChar", "isAltPressed", "", "isCtrlPressed", "isMetaPressed", "isShiftPressed", "canCoalesce", "getEventCategory", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getKeyString", "", "getCodeString", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KeyEvent extends Event<KeyEvent> {
    private static final String UNIDENTIFIED = "Unidentified";
    private final boolean isAltPressed;
    private final boolean isCtrlPressed;
    private final boolean isMetaPressed;
    private final boolean isShiftPressed;
    private final int keyCode;
    private final int unicodeChar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Map<Integer, String>> CODE_MAP$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.facebook.react.uimanager.events.KeyEvent$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MapsKt.mapOf(TuplesKt.to(29, "KeyA"), TuplesKt.to(30, "KeyB"), TuplesKt.to(31, "KeyC"), TuplesKt.to(32, "KeyD"), TuplesKt.to(33, "KeyE"), TuplesKt.to(34, "KeyF"), TuplesKt.to(35, "KeyG"), TuplesKt.to(36, "KeyH"), TuplesKt.to(37, "KeyI"), TuplesKt.to(38, "KeyJ"), TuplesKt.to(39, "KeyK"), TuplesKt.to(40, "KeyL"), TuplesKt.to(41, "KeyM"), TuplesKt.to(42, "KeyN"), TuplesKt.to(43, "KeyO"), TuplesKt.to(44, "KeyP"), TuplesKt.to(45, "KeyQ"), TuplesKt.to(46, "KeyR"), TuplesKt.to(47, "KeyS"), TuplesKt.to(48, "KeyT"), TuplesKt.to(49, "KeyU"), TuplesKt.to(50, "KeyV"), TuplesKt.to(51, "KeyW"), TuplesKt.to(52, "KeyX"), TuplesKt.to(53, "KeyY"), TuplesKt.to(54, "KeyZ"), TuplesKt.to(7, "Digit0"), TuplesKt.to(8, "Digit1"), TuplesKt.to(9, "Digit2"), TuplesKt.to(10, "Digit3"), TuplesKt.to(11, "Digit4"), TuplesKt.to(12, "Digit5"), TuplesKt.to(13, "Digit6"), TuplesKt.to(14, "Digit7"), TuplesKt.to(15, "Digit8"), TuplesKt.to(16, "Digit9"), TuplesKt.to(66, ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE), TuplesKt.to(62, "Space"), TuplesKt.to(61, "Tab"), TuplesKt.to(67, ReactEditTextInputConnectionWrapper.BACKSPACE_KEY_VALUE), TuplesKt.to(111, "Escape"), TuplesKt.to(59, "ShiftLeft"), TuplesKt.to(60, "ShiftRight"), TuplesKt.to(113, "ControlLeft"), TuplesKt.to(114, "ControlRight"), TuplesKt.to(57, "AltLeft"), TuplesKt.to(58, "AltRight"), TuplesKt.to(117, "MetaLeft"), TuplesKt.to(118, "MetaRight"), TuplesKt.to(19, "ArrowUp"), TuplesKt.to(20, "ArrowDown"), TuplesKt.to(21, "ArrowLeft"), TuplesKt.to(22, "ArrowRight"), TuplesKt.to(23, ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE));
        }
    });
    private static final Lazy<Map<Integer, String>> KEY_NAME_MAP$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.facebook.react.uimanager.events.KeyEvent$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MapsKt.mapOf(TuplesKt.to(66, ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE), TuplesKt.to(23, ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE), TuplesKt.to(62, ServerSentEventKt.SPACE), TuplesKt.to(61, "Tab"), TuplesKt.to(67, ReactEditTextInputConnectionWrapper.BACKSPACE_KEY_VALUE), TuplesKt.to(111, "Escape"), TuplesKt.to(59, "Shift"), TuplesKt.to(60, "Shift"), TuplesKt.to(113, "Control"), TuplesKt.to(114, "Control"), TuplesKt.to(57, "Alt"), TuplesKt.to(58, "Alt"), TuplesKt.to(117, "Meta"), TuplesKt.to(118, "Meta"), TuplesKt.to(19, "ArrowUp"), TuplesKt.to(20, "ArrowDown"), TuplesKt.to(21, "ArrowLeft"), TuplesKt.to(22, "ArrowRight"));
        }
    });

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected int getEventCategory() {
        return 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyEvent(int i, int i2, android.view.KeyEvent keyEvent) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        this.keyCode = keyEvent.getKeyCode();
        this.unicodeChar = keyEvent.getUnicodeChar();
        this.isAltPressed = keyEvent.isAltPressed();
        this.isCtrlPressed = keyEvent.isCtrlPressed();
        this.isMetaPressed = keyEvent.isMetaPressed();
        this.isShiftPressed = keyEvent.isShiftPressed();
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TypedValues.Attributes.S_TARGET, getViewTag());
        writableMapCreateMap.putString("key", getKeyString());
        writableMapCreateMap.putString("code", getCodeString());
        writableMapCreateMap.putBoolean("altKey", this.isAltPressed);
        writableMapCreateMap.putBoolean("ctrlKey", this.isCtrlPressed);
        writableMapCreateMap.putBoolean("metaKey", this.isMetaPressed);
        writableMapCreateMap.putBoolean("shiftKey", this.isShiftPressed);
        writableMapCreateMap.putDouble("timestamp", getTimestampMs());
        return writableMapCreateMap;
    }

    private final String getKeyString() {
        int i = this.unicodeChar;
        if (i != 0 && !Character.isISOControl(i)) {
            return String.valueOf((char) this.unicodeChar);
        }
        String str = (String) INSTANCE.getKEY_NAME_MAP().get(Integer.valueOf(this.keyCode));
        return str == null ? UNIDENTIFIED : str;
    }

    private final String getCodeString() {
        String str = (String) INSTANCE.getCODE_MAP().get(Integer.valueOf(this.keyCode));
        return str == null ? UNIDENTIFIED : str;
    }

    /* JADX INFO: compiled from: KeyEvent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/uimanager/events/KeyEvent$Companion;", "", "<init>", "()V", "UNIDENTIFIED", "", "CODE_MAP", "", "", "getCODE_MAP", "()Ljava/util/Map;", "CODE_MAP$delegate", "Lkotlin/Lazy;", "KEY_NAME_MAP", "getKEY_NAME_MAP", "KEY_NAME_MAP$delegate", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Integer, String> getCODE_MAP() {
            return (Map) KeyEvent.CODE_MAP$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Integer, String> getKEY_NAME_MAP() {
            return (Map) KeyEvent.KEY_NAME_MAP$delegate.getValue();
        }
    }
}
