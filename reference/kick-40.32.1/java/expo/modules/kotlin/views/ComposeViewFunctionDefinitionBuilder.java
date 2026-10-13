package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import com.facebook.imageutils.JfifUtil;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ComposeProps;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\\\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00121\u0010\b\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010)\u001a\u00020*H\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R>\u0010\b\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R0\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\"8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewFunctionDefinitionBuilder;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "", "name", "", "propsParsingStrategy", "Lexpo/modules/kotlin/views/PropsParsingStrategy;", "viewFunction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "eventBuilder", "Lexpo/modules/kotlin/views/ComposeViewEventDefinitionBuilder;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/views/PropsParsingStrategy;Lkotlin/jvm/functions/Function4;Lexpo/modules/kotlin/views/ComposeViewEventDefinitionBuilder;)V", "getName", "()Ljava/lang/String;", "getPropsParsingStrategy", "()Lexpo/modules/kotlin/views/PropsParsingStrategy;", "getViewFunction", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "viewType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getViewType$annotations", "()V", "getViewType", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "deferredFunctions", "", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "getDeferredFunctions$annotations", "getDeferredFunctions", "()Ljava/util/Map;", "setDeferredFunctions", "(Ljava/util/Map;)V", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@DefinitionMarker
public final class ComposeViewFunctionDefinitionBuilder<Props extends ComposeProps> {
    public static final int $stable = 8;
    private Map<String, SuspendFunctionComponent> deferredFunctions;
    private final ComposeViewEventDefinitionBuilder eventBuilder;
    private final String name;
    private final PropsParsingStrategy<Props> propsParsingStrategy;
    private final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> viewFunction;
    private final TypeDescriptor viewType;

    public static /* synthetic */ void getDeferredFunctions$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeViewFunctionDefinitionBuilder(String name, PropsParsingStrategy<Props> propsParsingStrategy, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> viewFunction, ComposeViewEventDefinitionBuilder eventBuilder) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propsParsingStrategy, "propsParsingStrategy");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        Intrinsics.checkNotNullParameter(eventBuilder, "eventBuilder");
        this.name = name;
        this.propsParsingStrategy = propsParsingStrategy;
        this.viewFunction = viewFunction;
        this.eventBuilder = eventBuilder;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewFunctionDefinitionBuilder$special$$inlined$typeDescriptorOf$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        this.viewType = typeDescriptor == null ? TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)))) : typeDescriptor;
        this.deferredFunctions = new LinkedHashMap();
    }

    public final String getName() {
        return this.name;
    }

    public final PropsParsingStrategy<Props> getPropsParsingStrategy() {
        return this.propsParsingStrategy;
    }

    public final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> getViewFunction() {
        return this.viewFunction;
    }

    public /* synthetic */ ComposeViewFunctionDefinitionBuilder(String str, PropsParsingStrategy propsParsingStrategy, Function4 function4, ComposeViewEventDefinitionBuilder composeViewEventDefinitionBuilder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, propsParsingStrategy, function4, (i & 8) != 0 ? new ComposeViewEventDefinitionBuilder() : composeViewEventDefinitionBuilder);
    }

    public final TypeDescriptor getViewType() {
        return this.viewType;
    }

    public final Map<String, SuspendFunctionComponent> getDeferredFunctions() {
        return this.deferredFunctions;
    }

    public final void setDeferredFunctions(Map<String, SuspendFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.deferredFunctions = map;
    }

    public final ViewManagerDefinition build() {
        Map<String, SuspendFunctionComponent> map = this.deferredFunctions;
        Iterator<Map.Entry<String, SuspendFunctionComponent>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            SuspendFunctionComponent value = it.next().getValue();
            value.runOnQueue(Queues.MAIN);
            value.setOwnerType(this.viewType);
            value.setCanTakeOwner(true);
        }
        String str = this.name;
        CallbacksDefinition callbacksDefinition = this.eventBuilder.getCallbacksDefinition();
        Map<String, ComposeViewProp> mapProps = this.propsParsingStrategy.props();
        List list = CollectionsKt.toList(map.values());
        return new ViewManagerDefinition(new Function2() { // from class: expo.modules.kotlin.views.ComposeViewFunctionDefinitionBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposeViewFunctionDefinitionBuilder.build$lambda$1(this.f$0, (Context) obj, (AppContext) obj2);
            }
        }, ComposeFunctionHolder.class, mapProps, str, null, callbacksDefinition, null, null, list, JfifUtil.MARKER_RST0, null);
    }

    static final View build$lambda$1(ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder, Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        try {
            return new ComposeFunctionHolder(context, appContext, composeViewFunctionDefinitionBuilder.name, composeViewFunctionDefinitionBuilder.viewFunction, composeViewFunctionDefinitionBuilder.propsParsingStrategy.createNewInstance(), composeViewFunctionDefinitionBuilder.eventBuilder.getCallbacksDefinition());
        } catch (Exception e) {
            throw new IllegalStateException("Could not instantiate props instance of " + composeViewFunctionDefinitionBuilder.name + " compose component.", e);
        }
    }
}
