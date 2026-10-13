package expo.modules.kotlin.views;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ComposeProps;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010-\u001a\u00020$2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050/\"\u00020\u0005¢\u0006\u0002\u00100J[\u00101\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40302\"\u0006\b\u0001\u00104\u0018\u000121\b\n\u00105\u001a+\u0012\u0013\u0012\u0011H4¢\u0006\f\b7\u0012\b\b\u0004\u0012\u0004\b\b(8\u0012\u0004\u0012\u000209\u0018\u000106j\n\u0012\u0004\u0012\u0002H4\u0018\u0001`:H\u0086\bø\u0001\u0000J\u001a\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0<02J*\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H=0<02\"\u0006\b\u0001\u0010=\u0018\u0001H\u0087\b¢\u0006\u0002\b>J8\u0010;\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@0?02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001H\u0087\b¢\u0006\u0002\bAJF\u0010;\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HC0B02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001\"\u0006\b\u0003\u0010C\u0018\u0001H\u0087\b¢\u0006\u0002\bDJT\u0010;\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HF0E02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001\"\u0006\b\u0003\u0010C\u0018\u0001\"\u0006\b\u0004\u0010F\u0018\u0001H\u0087\b¢\u0006\u0002\bGJb\u0010;\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\"\u0012 \u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HI0H02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001\"\u0006\b\u0003\u0010C\u0018\u0001\"\u0006\b\u0004\u0010F\u0018\u0001\"\u0006\b\u0005\u0010I\u0018\u0001H\u0087\b¢\u0006\u0002\bJJp\u0010;\u001a4\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012(\u0012&\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u0002HL0K02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001\"\u0006\b\u0003\u0010C\u0018\u0001\"\u0006\b\u0004\u0010F\u0018\u0001\"\u0006\b\u0005\u0010I\u0018\u0001\"\u0006\b\u0006\u0010L\u0018\u0001H\u0087\b¢\u0006\u0002\bMJ~\u0010;\u001a:\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012.\u0012,\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002HO0N02\"\u0006\b\u0001\u0010=\u0018\u0001\"\u0006\b\u0002\u0010@\u0018\u0001\"\u0006\b\u0003\u0010C\u0018\u0001\"\u0006\b\u0004\u0010F\u0018\u0001\"\u0006\b\u0005\u0010I\u0018\u0001\"\u0006\b\u0006\u0010L\u0018\u0001\"\u0006\b\u0007\u0010O\u0018\u0001H\u0087\b¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020\u0005H\u0001J#\u0010S\u001a\u00020$2\u0006\u0010R\u001a\u00020\u00052\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0/H\u0001¢\u0006\u0002\u0010VJ/\u0010W\u001a\u00020$2\"\u0010X\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\"¢\u0006\u0002\b%¢\u0006\u0002\b&¢\u0006\u0002\u0010+J\b\u0010Y\u001a\u00020ZH\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001c8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010 RD\u0010!\u001a \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010,\u0012\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006["}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewBuilderScope;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "", "name", "", "propsParsingStrategy", "Lexpo/modules/kotlin/views/PropsParsingStrategy;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/views/PropsParsingStrategy;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getPropsParsingStrategy$annotations", "getPropsParsingStrategy", "()Lexpo/modules/kotlin/views/PropsParsingStrategy;", "viewType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getViewType$annotations", "getViewType", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "eventNames", "", "getEventNames$annotations", "getEventNames", "()Ljava/util/List;", "asyncFunctions", "", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "getAsyncFunctions$annotations", "getAsyncFunctions", "()Ljava/util/Map;", "contentLambda", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "getContentLambda$annotations", "getContentLambda", "()Lkotlin/jvm/functions/Function4;", "setContentLambda", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "Events", "callbacks", "", "([Ljava/lang/String;)V", "Event", "Lkotlin/properties/PropertyDelegateProvider;", "Lexpo/modules/kotlin/views/EventHandle;", ExifInterface.GPS_DIRECTION_TRUE, "coalescingKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "AsyncFunction", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "P0", "AsyncFunctionWith1Arg", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "P1", "AsyncFunctionWith2Args", "Lexpo/modules/kotlin/views/AsyncFunctionHandle3;", "P2", "AsyncFunctionWith3Args", "Lexpo/modules/kotlin/views/AsyncFunctionHandle4;", "P3", "AsyncFunctionWith4Args", "Lexpo/modules/kotlin/views/AsyncFunctionHandle5;", "P4", "AsyncFunctionWith5Args", "Lexpo/modules/kotlin/views/AsyncFunctionHandle6;", "P5", "AsyncFunctionWith6Args", "Lexpo/modules/kotlin/views/AsyncFunctionHandle7;", "P6", "AsyncFunctionWith7Args", "registerNoArgAsyncFunction", "fnName", "registerAsyncFunctionWithArgs", "argsTypes", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "Content", "block", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@DefinitionMarker
public final class ComposeViewBuilderScope<Props extends ComposeProps> {
    public static final int $stable = 8;
    private final Map<String, SuspendFunctionComponent> asyncFunctions;
    private Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> contentLambda;
    private final List<String> eventNames;
    private final String name;
    private final PropsParsingStrategy<Props> propsParsingStrategy;
    private final TypeDescriptor viewType;

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getContentLambda$annotations() {
    }

    public static /* synthetic */ void getEventNames$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public static /* synthetic */ void getPropsParsingStrategy$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public ComposeViewBuilderScope(String name, PropsParsingStrategy<Props> propsParsingStrategy) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propsParsingStrategy, "propsParsingStrategy");
        this.name = name;
        this.propsParsingStrategy = propsParsingStrategy;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$special$$inlined$typeDescriptorOf$1
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
        this.eventNames = new ArrayList();
        this.asyncFunctions = new LinkedHashMap();
    }

    public final String getName() {
        return this.name;
    }

    public final PropsParsingStrategy<Props> getPropsParsingStrategy() {
        return this.propsParsingStrategy;
    }

    public final TypeDescriptor getViewType() {
        return this.viewType;
    }

    public final List<String> getEventNames() {
        return this.eventNames;
    }

    public final Map<String, SuspendFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> getContentLambda() {
        return this.contentLambda;
    }

    public final void setContentLambda(Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> function4) {
        this.contentLambda = function4;
    }

    public final void Events(String... callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        CollectionsKt.addAll(this.eventNames, callbacks);
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.views.ComposeViewBuilderScope$Event$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1<T, D> implements PropertyDelegateProvider {
        final /* synthetic */ Function1<T, Short> $coalescingKey;
        final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(ComposeViewBuilderScope<Props> composeViewBuilderScope, Function1<? super T, Short> function1) {
            this.$scope = composeViewBuilderScope;
            this.$coalescingKey = function1;
        }

        @Override // kotlin.properties.PropertyDelegateProvider
        public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
            return provideDelegate(obj, (KProperty<?>) kProperty);
        }

        @Override // kotlin.properties.PropertyDelegateProvider
        public final EventHandle<T> provideDelegate(Object obj, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.$scope.getEventNames().add(property.getName());
            return new EventHandle<>(property.getName(), this.$coalescingKey);
        }
    }

    public static /* synthetic */ PropertyDelegateProvider Event$default(ComposeViewBuilderScope composeViewBuilderScope, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return new AnonymousClass1(composeViewBuilderScope, function1);
    }

    public final /* synthetic */ <T> PropertyDelegateProvider<Object, EventHandle<T>> Event(Function1<? super T, Short> coalescingKey) {
        return new AnonymousClass1(this, coalescingKey);
    }

    public final PropertyDelegateProvider<Object, AsyncFunctionHandle<Unit>> AsyncFunction() {
        return new PropertyDelegateProvider() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$$ExternalSyntheticLambda0
            @Override // kotlin.properties.PropertyDelegateProvider
            public final Object provideDelegate(Object obj, KProperty kProperty) {
                return ComposeViewBuilderScope.AsyncFunction$lambda$0(this.f$0, obj, kProperty);
            }
        };
    }

    static final AsyncFunctionHandle AsyncFunction$lambda$0(ComposeViewBuilderScope composeViewBuilderScope, Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        composeViewBuilderScope.registerNoArgAsyncFunction(property.getName());
        return new AsyncFunctionHandle(property.getName());
    }

    public final /* synthetic */ <P0> PropertyDelegateProvider<Object, AsyncFunctionHandle<P0>> AsyncFunctionWith1Arg() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.2
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle<P0> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle<P0> provideDelegate(Object obj, KProperty<?> property) {
                Object objM12684constructorimpl;
                Object objM12684constructorimpl2;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                AnyType[] anyTypeArr = new AnyType[2];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$2$provideDelegate$$inlined$toArgsArray$default$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                            }
                        }));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$2$provideDelegate$$inlined$toArgsArray$default$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P0");
                                return null;
                            }
                        }));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[1] = anyType2;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1> PropertyDelegateProvider<Object, AsyncFunctionHandle2<P0, P1>> AsyncFunctionWith2Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.3
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle2<P0, P1> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle2<P0, P1> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle2<P0, P1> provideDelegate(Object obj, KProperty<?> property) {
                Object objM12684constructorimpl;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                AnyType[] anyTypeArr = new AnyType[3];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$3$provideDelegate$$inlined$toArgsArray$default$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                            }
                        }));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$3$provideDelegate$$inlined$toArgsArray$default$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P0");
                                return null;
                            }
                        }));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[1] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$3$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor3, null);
                }
                anyTypeArr[2] = anyType3;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle2<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1, P2> PropertyDelegateProvider<Object, AsyncFunctionHandle3<P0, P1, P2>> AsyncFunctionWith3Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.4
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle3<P0, P1, P2> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle3<P0, P1, P2> */
            /* JADX WARN: Unknown type variable: P2 in type: expo.modules.kotlin.views.AsyncFunctionHandle3<P0, P1, P2> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle3<P0, P1, P2> provideDelegate(Object obj, KProperty<?> property) {
                Object objM12684constructorimpl;
                char c;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                Object objM12684constructorimpl4;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                Intrinsics.reifiedOperationMarker(4, "P2");
                AnyType[] anyTypeArr = new AnyType[4];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$4$provideDelegate$$inlined$toArgsArray$default$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                            }
                        }));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 != null) {
                    c = 1;
                } else {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        c = 1;
                        try {
                            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$4$provideDelegate$$inlined$toArgsArray$default$2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    Intrinsics.reifiedOperationMarker(6, "P0");
                                    return null;
                                }
                            }));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.INSTANCE;
                            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        c = 1;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[c] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$4$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th4) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor3, null);
                }
                anyTypeArr[2] = anyType3;
                AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P2");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P2");
                AnyType anyType4 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor3 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$4$provideDelegate$$inlined$toArgsArray$default$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P2");
                                return null;
                            }
                        }));
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        objM12684constructorimpl4 = null;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                    if (typeDescriptor4 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType4 = new AnyType(typeDescriptor4, null);
                }
                anyTypeArr[3] = anyType4;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle3<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1, P2, P3> PropertyDelegateProvider<Object, AsyncFunctionHandle4<P0, P1, P2, P3>> AsyncFunctionWith4Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.5
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle4<P0, P1, P2, P3> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle4<P0, P1, P2, P3> */
            /* JADX WARN: Unknown type variable: P2 in type: expo.modules.kotlin.views.AsyncFunctionHandle4<P0, P1, P2, P3> */
            /* JADX WARN: Unknown type variable: P3 in type: expo.modules.kotlin.views.AsyncFunctionHandle4<P0, P1, P2, P3> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle4<P0, P1, P2, P3> provideDelegate(Object obj, KProperty<?> property) {
                Object objM12684constructorimpl;
                boolean z;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                Object objM12684constructorimpl4;
                Object objM12684constructorimpl5;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                Intrinsics.reifiedOperationMarker(4, "P2");
                Intrinsics.reifiedOperationMarker(4, "P3");
                AnyType[] anyTypeArr = new AnyType[5];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$5$provideDelegate$$inlined$toArgsArray$default$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                            }
                        }));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 != null) {
                    z = false;
                } else {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        z = false;
                        try {
                            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$5$provideDelegate$$inlined$toArgsArray$default$2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    Intrinsics.reifiedOperationMarker(6, "P0");
                                    return null;
                                }
                            }));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.INSTANCE;
                            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[1] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, Boolean.valueOf(z)));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$5$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th4) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor3, null);
                }
                anyTypeArr[2] = anyType3;
                AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P2");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P2");
                AnyType anyType4 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, Boolean.valueOf(z)));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor3 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$5$provideDelegate$$inlined$toArgsArray$default$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P2");
                                return null;
                            }
                        }));
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        objM12684constructorimpl4 = null;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                    if (typeDescriptor4 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType4 = new AnyType(typeDescriptor4, null);
                }
                anyTypeArr[3] = anyType4;
                AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P3");
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P3");
                AnyType anyType5 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, Boolean.valueOf(z)));
                if (anyType5 == null) {
                    try {
                        Result.Companion companion9 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor4 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$5$provideDelegate$$inlined$toArgsArray$default$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P3");
                                return null;
                            }
                        }));
                    } catch (Throwable th6) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                        objM12684constructorimpl5 = null;
                    }
                    TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                    if (typeDescriptor5 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType5 = new AnyType(typeDescriptor5, null);
                }
                anyTypeArr[4] = anyType5;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle4<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> PropertyDelegateProvider<Object, AsyncFunctionHandle5<P0, P1, P2, P3, P4>> AsyncFunctionWith5Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.6
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle5<P0, P1, P2, P3, P4> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle5<P0, P1, P2, P3, P4> */
            /* JADX WARN: Unknown type variable: P2 in type: expo.modules.kotlin.views.AsyncFunctionHandle5<P0, P1, P2, P3, P4> */
            /* JADX WARN: Unknown type variable: P3 in type: expo.modules.kotlin.views.AsyncFunctionHandle5<P0, P1, P2, P3, P4> */
            /* JADX WARN: Unknown type variable: P4 in type: expo.modules.kotlin.views.AsyncFunctionHandle5<P0, P1, P2, P3, P4> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle5<P0, P1, P2, P3, P4> provideDelegate(Object obj, KProperty<?> property) {
                char c;
                Object objM12684constructorimpl;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                Object objM12684constructorimpl4;
                Object objM12684constructorimpl5;
                Object objM12684constructorimpl6;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                Intrinsics.reifiedOperationMarker(4, "P2");
                Intrinsics.reifiedOperationMarker(4, "P3");
                Intrinsics.reifiedOperationMarker(4, "P4");
                AnyType[] anyTypeArr = new AnyType[6];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType != null) {
                    c = 1;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[1];
                        c = 1;
                        try {
                            pTypeDescriptorArr[0] = PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null);
                            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c = 1;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P0");
                                return null;
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[c] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th4) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor3, null);
                }
                anyTypeArr[2] = anyType3;
                AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P2");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P2");
                AnyType anyType4 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor3 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P2");
                                return null;
                            }
                        }));
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        objM12684constructorimpl4 = null;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                    if (typeDescriptor4 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType4 = new AnyType(typeDescriptor4, null);
                }
                anyTypeArr[3] = anyType4;
                AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P3");
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P3");
                AnyType anyType5 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
                if (anyType5 == null) {
                    try {
                        Result.Companion companion9 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor4 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P3");
                                return null;
                            }
                        }));
                    } catch (Throwable th6) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                        objM12684constructorimpl5 = null;
                    }
                    TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                    if (typeDescriptor5 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType5 = new AnyType(typeDescriptor5, null);
                }
                anyTypeArr[4] = anyType5;
                AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P4");
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P4");
                AnyType anyType6 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
                if (anyType6 == null) {
                    try {
                        Result.Companion companion11 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor5 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$6$provideDelegate$$inlined$toArgsArray$default$6
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P4");
                                return null;
                            }
                        }));
                    } catch (Throwable th7) {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                        objM12684constructorimpl6 = null;
                    }
                    TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                    if (typeDescriptor6 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType6 = new AnyType(typeDescriptor6, null);
                }
                anyTypeArr[5] = anyType6;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle5<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> PropertyDelegateProvider<Object, AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5>> AsyncFunctionWith6Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.7
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            /* JADX WARN: Unknown type variable: P2 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            /* JADX WARN: Unknown type variable: P3 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            /* JADX WARN: Unknown type variable: P4 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            /* JADX WARN: Unknown type variable: P5 in type: expo.modules.kotlin.views.AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> provideDelegate(Object obj, KProperty<?> property) {
                char c;
                Object objM12684constructorimpl;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                Object objM12684constructorimpl4;
                Object objM12684constructorimpl5;
                Object objM12684constructorimpl6;
                Object objM12684constructorimpl7;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                Intrinsics.reifiedOperationMarker(4, "P2");
                Intrinsics.reifiedOperationMarker(4, "P3");
                Intrinsics.reifiedOperationMarker(4, "P4");
                Intrinsics.reifiedOperationMarker(4, "P5");
                AnyType[] anyTypeArr = new AnyType[7];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType != null) {
                    c = 1;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[1];
                        c = 1;
                        try {
                            pTypeDescriptorArr[0] = PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null);
                            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c = 1;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P0");
                                return null;
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType2 = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[c] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th4) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor3, null);
                }
                anyTypeArr[2] = anyType3;
                AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P2");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P2");
                AnyType anyType4 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor3 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P2");
                                return null;
                            }
                        }));
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        objM12684constructorimpl4 = null;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                    if (typeDescriptor4 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType4 = new AnyType(typeDescriptor4, null);
                }
                anyTypeArr[3] = anyType4;
                AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P3");
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P3");
                AnyType anyType5 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
                if (anyType5 == null) {
                    try {
                        Result.Companion companion9 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor4 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P3");
                                return null;
                            }
                        }));
                    } catch (Throwable th6) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                        objM12684constructorimpl5 = null;
                    }
                    TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                    if (typeDescriptor5 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType5 = new AnyType(typeDescriptor5, null);
                }
                anyTypeArr[4] = anyType5;
                AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P4");
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P4");
                AnyType anyType6 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
                if (anyType6 == null) {
                    try {
                        Result.Companion companion11 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor5 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$6
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P4");
                                return null;
                            }
                        }));
                    } catch (Throwable th7) {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                        objM12684constructorimpl6 = null;
                    }
                    TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                    if (typeDescriptor6 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType6 = new AnyType(typeDescriptor6, null);
                }
                anyTypeArr[5] = anyType6;
                AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P5");
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P5");
                AnyType anyType7 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
                if (anyType7 == null) {
                    try {
                        Result.Companion companion13 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P5");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor6 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$7$provideDelegate$$inlined$toArgsArray$default$7
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P5");
                                return null;
                            }
                        }));
                    } catch (Throwable th8) {
                        Result.Companion companion14 = Result.INSTANCE;
                        objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                        objM12684constructorimpl7 = null;
                    }
                    TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                    if (typeDescriptor7 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P5");
                        typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType7 = new AnyType(typeDescriptor7, null);
                }
                anyTypeArr[6] = anyType7;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle6<>(property.getName());
            }
        };
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> PropertyDelegateProvider<Object, AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6>> AsyncFunctionWith7Args() {
        Intrinsics.needClassReification();
        return new PropertyDelegateProvider(this) { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope.AsyncFunction.8
            final /* synthetic */ ComposeViewBuilderScope<Props> $scope;

            {
                this.$scope = this;
            }

            @Override // kotlin.properties.PropertyDelegateProvider
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return provideDelegate(obj, (KProperty<?>) kProperty);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r13v4, types: [expo.modules.kotlin.types.TypeConverterProvider] */
            /* JADX WARN: Unknown type variable: P0 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P1 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P2 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P3 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P4 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P5 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            /* JADX WARN: Unknown type variable: P6 in type: expo.modules.kotlin.views.AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> */
            @Override // kotlin.properties.PropertyDelegateProvider
            public final AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> provideDelegate(Object obj, KProperty<?> property) {
                char c;
                Object objM12684constructorimpl;
                KType kType;
                Object objM12684constructorimpl2;
                Object objM12684constructorimpl3;
                TypeConverterProvider typeConverterProvider;
                Object objM12684constructorimpl4;
                TypeConverterProvider typeConverterProvider2;
                Object objM12684constructorimpl5;
                TypeConverterProvider typeConverterProvider3;
                Object objM12684constructorimpl6;
                TypeConverterProvider typeConverterProvider4;
                Object objM12684constructorimpl7;
                TypeConverterProvider typeConverterProvider5;
                Object objM12684constructorimpl8;
                TypeConverterProvider typeConverterProvider6;
                TypeDescriptor typeDescriptor;
                Intrinsics.checkNotNullParameter(property, "property");
                ComposeViewBuilderScope<Props> composeViewBuilderScope = this.$scope;
                String name = property.getName();
                Intrinsics.reifiedOperationMarker(4, "P0");
                Intrinsics.reifiedOperationMarker(4, "P1");
                Intrinsics.reifiedOperationMarker(4, "P2");
                Intrinsics.reifiedOperationMarker(4, "P3");
                Intrinsics.reifiedOperationMarker(4, "P4");
                Intrinsics.reifiedOperationMarker(4, "P5");
                Intrinsics.reifiedOperationMarker(4, "P6");
                AnyType[] anyTypeArr = new AnyType[8];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                if (anyType != null) {
                    c = 1;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[1];
                        c = 1;
                        try {
                            pTypeDescriptorArr[0] = PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null);
                            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c = 1;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                        objM12684constructorimpl = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl;
                    if (typeDescriptor2 == null) {
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                    }
                    anyType = new AnyType(typeDescriptor2, null);
                }
                anyTypeArr[0] = anyType;
                AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                AnyType anyType2 = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                        Intrinsics.needClassReification();
                        kType = null;
                        try {
                            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    Intrinsics.reifiedOperationMarker(6, "P0");
                                    return null;
                                }
                            }));
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion4 = Result.INSTANCE;
                            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        kType = null;
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = kType;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor3 == null) {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(kType);
                    }
                    anyType2 = new AnyType(typeDescriptor3, kType);
                }
                anyTypeArr[c] = anyType2;
                AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P1");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P1");
                AnyType anyType3 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor2 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$3
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P1");
                                return null;
                            }
                        }));
                    } catch (Throwable th5) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor4 != null) {
                        typeConverterProvider = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P1");
                        typeConverterProvider = null;
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType3 = new AnyType(typeDescriptor4, typeConverterProvider);
                }
                anyTypeArr[2] = anyType3;
                AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P2");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P2");
                AnyType anyType4 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor3 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P2");
                                return null;
                            }
                        }));
                    } catch (Throwable th6) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        objM12684constructorimpl4 = null;
                    }
                    TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl4;
                    if (typeDescriptor5 != null) {
                        typeConverterProvider2 = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P2");
                        typeConverterProvider2 = null;
                        typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType4 = new AnyType(typeDescriptor5, typeConverterProvider2);
                }
                anyTypeArr[3] = anyType4;
                AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P3");
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P3");
                AnyType anyType5 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
                if (anyType5 == null) {
                    try {
                        Result.Companion companion9 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor4 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P3");
                                return null;
                            }
                        }));
                    } catch (Throwable th7) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                        objM12684constructorimpl5 = null;
                    }
                    TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl5;
                    if (typeDescriptor6 != null) {
                        typeConverterProvider3 = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P3");
                        typeConverterProvider3 = null;
                        typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType5 = new AnyType(typeDescriptor6, typeConverterProvider3);
                }
                anyTypeArr[4] = anyType5;
                AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P4");
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P4");
                AnyType anyType6 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
                if (anyType6 == null) {
                    try {
                        Result.Companion companion11 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor5 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$6
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P4");
                                return null;
                            }
                        }));
                    } catch (Throwable th8) {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                        objM12684constructorimpl6 = null;
                    }
                    TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl6;
                    if (typeDescriptor7 != null) {
                        typeConverterProvider4 = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P4");
                        typeConverterProvider4 = null;
                        typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType6 = new AnyType(typeDescriptor7, typeConverterProvider4);
                }
                anyTypeArr[5] = anyType6;
                AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P5");
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P5");
                AnyType anyType7 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
                if (anyType7 == null) {
                    try {
                        Result.Companion companion13 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P5");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor6 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$7
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P5");
                                return null;
                            }
                        }));
                    } catch (Throwable th9) {
                        Result.Companion companion14 = Result.INSTANCE;
                        objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                        objM12684constructorimpl7 = null;
                    }
                    TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl7;
                    if (typeDescriptor8 != null) {
                        typeConverterProvider5 = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P5");
                        typeConverterProvider5 = null;
                        typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType7 = new AnyType(typeDescriptor8, typeConverterProvider5);
                }
                anyTypeArr[6] = anyType7;
                AnyTypeCache anyTypeCache7 = AnyTypeCache.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "P6");
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P6");
                AnyType anyType8 = anyTypeCache7.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
                if (anyType8 == null) {
                    try {
                        Result.Companion companion15 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P6");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        RawTypeDescriptor rawTypeDescriptor7 = TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7);
                        Intrinsics.needClassReification();
                        objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor7, new Function0<KType>() { // from class: expo.modules.kotlin.views.ComposeViewBuilderScope$AsyncFunction$8$provideDelegate$$inlined$toArgsArray$default$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                Intrinsics.reifiedOperationMarker(6, "P6");
                                return null;
                            }
                        }));
                    } catch (Throwable th10) {
                        Result.Companion companion16 = Result.INSTANCE;
                        objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                    }
                    Object obj2 = objM12684constructorimpl8;
                    if (Result.m12690isFailureimpl(obj2)) {
                        obj2 = null;
                    }
                    TypeDescriptor typeDescriptor9 = (TypeDescriptor) obj2;
                    if (typeDescriptor9 != null) {
                        typeDescriptor = typeDescriptor9;
                        typeConverterProvider6 = null;
                    } else {
                        Intrinsics.reifiedOperationMarker(6, "P6");
                        typeConverterProvider6 = null;
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
                    }
                    anyType8 = new AnyType(typeDescriptor, typeConverterProvider6);
                }
                anyTypeArr[7] = anyType8;
                composeViewBuilderScope.registerAsyncFunctionWithArgs(name, anyTypeArr);
                return new AsyncFunctionHandle7(property.getName());
            }
        };
    }

    public final void registerNoArgAsyncFunction(String fnName) {
        Intrinsics.checkNotNullParameter(fnName, "fnName");
        if (this.asyncFunctions.containsKey(fnName)) {
            throw new IllegalArgumentException(("AsyncFunction '" + fnName + "' is already declared on view '" + this.name + "'. Each function name must be unique within a view.").toString());
        }
        this.asyncFunctions.put(fnName, new SuspendFunctionComponent(fnName, new AnyType[]{new AnyType(this.viewType, null, 2, null)}, new C08572(fnName, null)));
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.views.ComposeViewBuilderScope$registerNoArgAsyncFunction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "args", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.kotlin.views.ComposeViewBuilderScope$registerNoArgAsyncFunction$2", f = "ModuleDefinitionBuilderComposeExtension.kt", i = {0, 0, 0}, l = {328}, m = "invokeSuspend", n = {"args", "view", "handler"}, nl = {-1}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C08572 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ String $fnName;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08572(String str, Continuation<? super C08572> continuation) {
            super(3, continuation);
            this.$fnName = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C08572 c08572 = new C08572(this.$fnName, continuation);
            c08572.L$0 = objArr;
            return c08572.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.kotlin.views.ComposeFunctionHolder<*>");
            ComposeFunctionHolder composeFunctionHolder = (ComposeFunctionHolder) obj2;
            Function2<Object[], Continuation<Object>, Object> function2 = composeFunctionHolder.getFunctionHandlers().get(this.$fnName);
            if (function2 == null) {
                throw new IllegalStateException(("No handler registered for AsyncFunction '" + this.$fnName + "' on view '" + composeFunctionHolder.getName() + "'. Did you forget to bind it with `" + this.$fnName + ".handle { ... }` inside the Content { } block?").toString());
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(composeFunctionHolder);
            this.L$2 = SpillingKt.nullOutSpilledVariable(function2);
            this.label = 1;
            Object objInvoke = function2.invoke(new Object[0], this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    public final void registerAsyncFunctionWithArgs(String fnName, AnyType[] argsTypes) {
        Intrinsics.checkNotNullParameter(fnName, "fnName");
        Intrinsics.checkNotNullParameter(argsTypes, "argsTypes");
        if (this.asyncFunctions.containsKey(fnName)) {
            throw new IllegalArgumentException(("AsyncFunction '" + fnName + "' is already declared on view '" + this.name + "'. Each function name must be unique within a view.").toString());
        }
        this.asyncFunctions.put(fnName, new SuspendFunctionComponent(fnName, argsTypes, new C08562(fnName, null)));
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.views.ComposeViewBuilderScope$registerAsyncFunctionWithArgs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "args", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.kotlin.views.ComposeViewBuilderScope$registerAsyncFunctionWithArgs$2", f = "ModuleDefinitionBuilderComposeExtension.kt", i = {0, 0, 0}, l = {341}, m = "invokeSuspend", n = {"args", "view", "handler"}, nl = {-1}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C08562 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ String $fnName;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08562(String str, Continuation<? super C08562> continuation) {
            super(3, continuation);
            this.$fnName = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C08562 c08562 = new C08562(this.$fnName, continuation);
            c08562.L$0 = objArr;
            return c08562.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.kotlin.views.ComposeFunctionHolder<*>");
            ComposeFunctionHolder composeFunctionHolder = (ComposeFunctionHolder) obj2;
            Function2<Object[], Continuation<Object>, Object> function2 = composeFunctionHolder.getFunctionHandlers().get(this.$fnName);
            if (function2 == null) {
                throw new IllegalStateException(("No handler registered for AsyncFunction '" + this.$fnName + "' on view '" + composeFunctionHolder.getName() + "'. Did you forget to bind it with `" + this.$fnName + ".handle { ... }` inside the Content { } block?").toString());
            }
            Object[] objArrSliceArray = ArraysKt.sliceArray(objArr, RangesKt.until(1, objArr.length));
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(composeFunctionHolder);
            this.L$2 = SpillingKt.nullOutSpilledVariable(function2);
            this.label = 1;
            Object objInvoke = function2.invoke(objArrSliceArray, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    public final void Content(Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.contentLambda != null) {
            throw new IllegalArgumentException(("Content { } must be set exactly once for view '" + this.name + "'.").toString());
        }
        this.contentLambda = block;
    }

    public final ViewManagerDefinition build() {
        Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> function4 = this.contentLambda;
        if (function4 == null) {
            throw new IllegalArgumentException(("Content { } was not set for view '" + this.name + "'. Add `Content { props -> ... }` inside the builder block.").toString());
        }
        ComposeViewEventDefinitionBuilder composeViewEventDefinitionBuilder = new ComposeViewEventDefinitionBuilder();
        if (!this.eventNames.isEmpty()) {
            String[] strArr = (String[]) this.eventNames.toArray(new String[0]);
            composeViewEventDefinitionBuilder.Events((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder(this.name, this.propsParsingStrategy, function4, composeViewEventDefinitionBuilder);
        for (Map.Entry<String, SuspendFunctionComponent> entry : this.asyncFunctions.entrySet()) {
            composeViewFunctionDefinitionBuilder.getDeferredFunctions().put(entry.getKey(), entry.getValue());
        }
        return composeViewFunctionDefinitionBuilder.build();
    }
}
