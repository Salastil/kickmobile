package expo.modules.kotlin.views;

import expo.modules.kotlin.modules.DefinitionMarker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001d\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewEventDefinitionBuilder;", "", "<init>", "()V", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "getCallbacksDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/CallbacksDefinition;", "setCallbacksDefinition$expo_modules_core_release", "(Lexpo/modules/kotlin/views/CallbacksDefinition;)V", "Events", "", "callbacks", "", "", "([Ljava/lang/String;)V", "EventsWithArray", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@DefinitionMarker
public final class ComposeViewEventDefinitionBuilder {
    public static final int $stable = 8;
    private CallbacksDefinition callbacksDefinition = new CallbacksDefinition(new String[]{ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME});

    /* JADX INFO: renamed from: getCallbacksDefinition$expo_modules_core_release, reason: from getter */
    public final CallbacksDefinition getCallbacksDefinition() {
        return this.callbacksDefinition;
    }

    public final void setCallbacksDefinition$expo_modules_core_release(CallbacksDefinition callbacksDefinition) {
        Intrinsics.checkNotNullParameter(callbacksDefinition, "<set-?>");
        this.callbacksDefinition = callbacksDefinition;
    }

    public final void Events(String... callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME);
        spreadBuilder.addSpread(callbacks);
        this.callbacksDefinition = new CallbacksDefinition((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public final void EventsWithArray(String[] callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME);
        spreadBuilder.addSpread(callbacks);
        this.callbacksDefinition = new CallbacksDefinition((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }
}
