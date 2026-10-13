package expo.modules.kotlin.viewevent;

import android.view.View;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.views.CallbacksDefinition;
import expo.modules.kotlin.views.ViewFunctionHolder;
import expo.modules.kotlin.views.ViewManagerDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"resolveCallbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "view", "Landroid/view/View;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ViewEventKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final CallbacksDefinition resolveCallbacksDefinition(View view, ModuleRegistry registry) {
        ViewManagerDefinition viewDefinition;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(registry, "registry");
        if (view instanceof ViewFunctionHolder) {
            return ((ViewFunctionHolder) view).getCallbacksDefinition();
        }
        ModuleHolder<?> moduleHolder = registry.getModuleHolder(view.getClass());
        if (moduleHolder == null || (viewDefinition = registry.getViewDefinition(moduleHolder, view.getClass())) == null) {
            return null;
        }
        return viewDefinition.getCallbacksDefinition();
    }
}
