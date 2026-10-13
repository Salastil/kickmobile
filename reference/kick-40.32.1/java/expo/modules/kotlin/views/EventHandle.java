package expo.modules.kotlin.views;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BB\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012/\u0010\u0005\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\u0003\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0086\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010RE\u0010\u0005\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\u0003\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/views/EventHandle;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", "coalescingKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getCoalescingKey$annotations", "getCoalescingKey", "()Lkotlin/jvm/functions/Function1;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EventHandle<T> {
    public static final int $stable = 0;
    private final Function1<T, Short> coalescingKey;
    private final String name;

    public static /* synthetic */ void getCoalescingKey$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public final EventHandle<T> getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventHandle(String name, Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.coalescingKey = function1;
    }

    public final String getName() {
        return this.name;
    }

    public final Function1<T, Short> getCoalescingKey() {
        return this.coalescingKey;
    }
}
