package expo.modules.kotlin.views;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEvent;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.views.ComposeProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004Bd\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00121\u0010\u000b\u001a-\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016JM\u00100\u001a\b\u0012\u0004\u0012\u0002H10-\"\u0004\b\u0001\u001012\u0006\u0010\t\u001a\u00020\n2/\u00102\u001a+\u0012\u0013\u0012\u0011H1¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000103j\n\u0012\u0004\u0012\u0002H1\u0018\u0001`6H\u0001J\u0011\u00107\u001a\u00020\u0010*\u000208H\u0017¢\u0006\u0002\u00109R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R;\u0010\u000b\u001a-\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u000f\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"RP\u0010#\u001a6\u0012\u0004\u0012\u00020\n\u0012,\u0012*\b\u0001\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0%\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010&0'\u0012\u0006\u0012\u0004\u0018\u00010&0\f0$8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R,\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0$8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010)\u001a\u0004\b/\u0010+¨\u0006:²\u0006\u0014\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/kotlin/views/ViewFunctionHolder;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "name", "", "composableContent", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Lexpo/modules/kotlin/views/ComposeProps;Lexpo/modules/kotlin/views/CallbacksDefinition;)V", "getName", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function4;", "getProps", "()Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "getCallbacksDefinition", "()Lexpo/modules/kotlin/views/CallbacksDefinition;", "propsMutableState", "Landroidx/compose/runtime/MutableState;", "getPropsMutableState", "()Landroidx/compose/runtime/MutableState;", "functionHandlers", "", "", "", "Lkotlin/coroutines/Continuation;", "getFunctionHandlers$annotations", "()V", "getFunctionHandlers", "()Ljava/util/Map;", "eventCallbacks", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "getEventCallbacks$annotations", "getEventCallbacks", "getOrCreateEventCallback", ExifInterface.GPS_DIRECTION_TRUE, "coalescingKey", "Lkotlin/Function1;", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposeFunctionHolder<Props extends ComposeProps> extends ExpoComposeView<Props> implements ViewFunctionHolder {
    public static final int $stable = 8;
    private final CallbacksDefinition callbacksDefinition;
    private final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> composableContent;
    private final Map<String, ViewEventCallback<?>> eventCallbacks;
    private final Map<String, Function2<Object[], Continuation<Object>, Object>> functionHandlers;
    private final String name;
    private final Props props;
    private final MutableState<Props> propsMutableState;

    static final Unit Content$lambda$2(ComposeFunctionHolder composeFunctionHolder, ComposableScope composableScope, int i, Composer composer, int i2) {
        composeFunctionHolder.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getEventCallbacks$annotations() {
    }

    public static /* synthetic */ void getFunctionHandlers$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ComposeFunctionHolder(Context context, AppContext appContext, String name, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> composableContent, Props props, CallbacksDefinition callbacksDefinition) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(composableContent, "composableContent");
        Intrinsics.checkNotNullParameter(props, "props");
        this.name = name;
        this.composableContent = composableContent;
        this.props = props;
        this.callbacksDefinition = callbacksDefinition;
        this.propsMutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getProps(), null, 2, null);
        this.functionHandlers = new LinkedHashMap();
        this.eventCallbacks = new LinkedHashMap();
    }

    @Override // expo.modules.kotlin.views.ViewFunctionHolder
    public String getName() {
        return this.name;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public Props getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ViewFunctionHolder
    public CallbacksDefinition getCallbacksDefinition() {
        return this.callbacksDefinition;
    }

    public final MutableState<Props> getPropsMutableState() {
        return this.propsMutableState;
    }

    public final Map<String, Function2<Object[], Continuation<Object>, Object>> getFunctionHandlers() {
        return this.functionHandlers;
    }

    public final Map<String, ViewEventCallback<?>> getEventCallbacks() {
        return this.eventCallbacks;
    }

    public final <T> ViewEventCallback<T> getOrCreateEventCallback(String name, Function1<? super T, Short> coalescingKey) {
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, ViewEventCallback<?>> map = this.eventCallbacks;
        Object obj = map.get(name);
        if (obj == null) {
            obj = (ViewEventCallback) new ViewEvent(name, this, coalescingKey);
            map.put(name, (ViewEventCallback<?>) obj);
        }
        return (ViewEventCallback) obj;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(1424484963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)*619@21942L24:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1424484963, i2, -1, "expo.modules.kotlin.views.ComposeFunctionHolder.Content (ExpoComposeView.kt:616)");
            }
            this.composableContent.invoke(new FunctionalComposableScope(this, composableScope), (Props) Content$lambda$0(this.propsMutableState), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ComposeFunctionHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeFunctionHolder.Content$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final <Props extends ComposeProps> Props Content$lambda$0(MutableState<Props> mutableState) {
        return mutableState.getValue();
    }
}
