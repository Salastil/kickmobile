package expo.modules.webview;

import android.view.View;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: DomWebViewModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/webview/DomWebViewModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DomWebViewModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        Object objM12684constructorimpl18;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        DomWebViewModule domWebViewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (domWebViewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(domWebViewModule);
            moduleDefinitionBuilder.Name("ExpoDomWebViewModule");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DomWebViewRegistry.INSTANCE.reset();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            moduleDefinitionBuilder2.getAsyncFunctions().put("evalJsForWebViewAsync", new UntypedAsyncFunctionComponent("evalJsForWebViewAsync", anyTypeArr, new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    DomWebView domWebView = DomWebViewRegistry.INSTANCE.get(((Number) obj).intValue());
                    if (domWebView == null) {
                        return null;
                    }
                    domWebView.injectJavaScript(str);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DomWebView.class);
            try {
                Result.Companion companion5 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DomWebView.class, false, null)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$$inlined$View$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DomWebView.class);
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
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DomWebView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, typeDescriptor3, moduleDefinitionBuilder3.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.Events("onMessage", "onRenderProcessGone");
            DomWebViewModule$definition$1$3$1 domWebViewModule$definition$1$3$1 = new Function2<DomWebView, DomWebViewSource, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, DomWebViewSource domWebViewSource) {
                    invoke2(domWebView, domWebViewSource);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, DomWebViewSource source) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(source, "source");
                    view.setSource(source);
                }
            };
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebViewSource.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DomWebViewSource.class, false, DomWebViewSource.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DomWebViewSource.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DomWebViewSource.class));
                }
                anyType3 = new AnyType(typeDescriptor4, null);
            }
            viewDefinitionBuilder.getProps().put("source", new ConcreteViewProp("source", anyType3, domWebViewModule$definition$1$3$1));
            DomWebViewModule$definition$1$3$2 domWebViewModule$definition$1$3$2 = new Function2<DomWebView, String, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, String str) {
                    invoke2(domWebView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, String script) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(script, "script");
                    view.setInjectedJS(script);
                }
            };
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor5, null);
            }
            viewDefinitionBuilder.getProps().put("injectedJavaScript", new ConcreteViewProp("injectedJavaScript", anyType4, domWebViewModule$definition$1$3$2));
            DomWebViewModule$definition$1$3$3 domWebViewModule$definition$1$3$3 = new Function2<DomWebView, String, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, String str) {
                    invoke2(domWebView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, String script) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(script, "script");
                    view.setInjectedJSBeforeContentLoaded(script);
                }
            };
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType5 = new AnyType(typeDescriptor6, null);
            }
            viewDefinitionBuilder.getProps().put("injectedJavaScriptBeforeContentLoaded", new ConcreteViewProp("injectedJavaScriptBeforeContentLoaded", anyType5, domWebViewModule$definition$1$3$3));
            DomWebViewModule$definition$1$3$4 domWebViewModule$definition$1$3$4 = new Function2<DomWebView, String, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, String str) {
                    invoke2(domWebView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, String source) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(source, "source");
                    view.setInjectedJavaScriptObject(source);
                }
            };
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType6 = new AnyType(typeDescriptor7, null);
            }
            viewDefinitionBuilder.getProps().put("injectedJavaScriptObject", new ConcreteViewProp("injectedJavaScriptObject", anyType6, domWebViewModule$definition$1$3$4));
            DomWebViewModule$definition$1$3$5 domWebViewModule$definition$1$3$5 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setWebviewDebuggingEnabled(z);
                }
            };
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                    objM12684constructorimpl8 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType7 = new AnyType(typeDescriptor8, null);
            }
            viewDefinitionBuilder.getProps().put("webviewDebuggingEnabled", new ConcreteViewProp("webviewDebuggingEnabled", anyType7, domWebViewModule$definition$1$3$5));
            DomWebViewModule$definition$1$3$6 domWebViewModule$definition$1$3$6 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setUseExpoModulesBridge(z);
                }
            };
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType8 = new AnyType(typeDescriptor9, null);
            }
            viewDefinitionBuilder.getProps().put("useExpoModulesBridge", new ConcreteViewProp("useExpoModulesBridge", anyType8, domWebViewModule$definition$1$3$6));
            DomWebViewModule$definition$1$3$7 domWebViewModule$definition$1$3$7 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setMediaPlaybackRequiresUserAction(z);
                }
            };
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType9 = new AnyType(typeDescriptor10, null);
            }
            viewDefinitionBuilder.getProps().put("mediaPlaybackRequiresUserAction", new ConcreteViewProp("mediaPlaybackRequiresUserAction", anyType9, domWebViewModule$definition$1$3$7));
            DomWebViewModule$definition$1$3$8 domWebViewModule$definition$1$3$8 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final DomWebView view, final boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getWebView().post(new Runnable() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$8.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.getWebView().setHorizontalScrollBarEnabled(z);
                        }
                    });
                }
            };
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                    objM12684constructorimpl11 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType10 = new AnyType(typeDescriptor11, null);
            }
            viewDefinitionBuilder.getProps().put("showsHorizontalScrollIndicator", new ConcreteViewProp("showsHorizontalScrollIndicator", anyType10, domWebViewModule$definition$1$3$8));
            DomWebViewModule$definition$1$3$9 domWebViewModule$definition$1$3$9 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final DomWebView view, final boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getWebView().post(new Runnable() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.getWebView().setVerticalScrollBarEnabled(z);
                        }
                    });
                }
            };
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType11 = new AnyType(typeDescriptor12, null);
            }
            viewDefinitionBuilder.getProps().put("showsVerticalScrollIndicator", new ConcreteViewProp("showsVerticalScrollIndicator", anyType11, domWebViewModule$definition$1$3$9));
            DomWebViewModule$definition$1$3$10 domWebViewModule$definition$1$3$10 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setNestedScrollEnabled(z);
                }
            };
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$Prop$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th13) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
                    objM12684constructorimpl13 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType12 = new AnyType(typeDescriptor13, null);
            }
            viewDefinitionBuilder.getProps().put("nestedScrollEnabled", new ConcreteViewProp("nestedScrollEnabled", anyType12, domWebViewModule$definition$1$3$10));
            TypeConverterProvider converters2 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebView.class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DomWebView.class, false, null)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DomWebView.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion28 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                    objM12684constructorimpl14 = null;
                }
                TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
                if (typeDescriptor14 == null) {
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DomWebView.class));
                }
                anyType13 = new AnyType(typeDescriptor14, converters2);
            }
            anyTypeArr2[0] = anyType13;
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ScrollToParam.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ScrollToParam.class, false, ScrollToParam.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ScrollToParam.class);
                        }
                    }));
                } catch (Throwable th15) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
                    objM12684constructorimpl15 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ScrollToParam.class));
                }
                anyType14 = new AnyType(typeDescriptor15, converters2);
            }
            anyTypeArr2[1] = anyType14;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((DomWebView) objArr[0]).scrollTo((ScrollToParam) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
            }
            viewDefinitionBuilder.getAsyncFunctions().put("scrollTo", untypedAsyncFunctionComponent);
            TypeConverterProvider converters3 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebView.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DomWebView.class, false, null)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DomWebView.class);
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion32 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                    objM12684constructorimpl16 = null;
                }
                TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
                if (typeDescriptor16 == null) {
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DomWebView.class));
                }
                anyType15 = new AnyType(typeDescriptor16, converters3);
            }
            anyTypeArr3[0] = anyType15;
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType16 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th17) {
                    Result.Companion companion34 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                    objM12684constructorimpl17 = null;
                }
                TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
                if (typeDescriptor17 == null) {
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType16 = new AnyType(typeDescriptor17, converters3);
            }
            anyTypeArr3[1] = anyType16;
            Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((DomWebView) objArr[0]).injectJavaScript((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
            }
            viewDefinitionBuilder.getAsyncFunctions().put("injectJavaScript", untypedAsyncFunctionComponent2);
            if (DomWebView.class == Promise.class) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("reload", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((DomWebView) promise).forceReload();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebView.class), false));
                if (anyType17 == null) {
                    try {
                        Result.Companion companion35 = Result.INSTANCE;
                        objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DomWebView.class, false, null)), new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(DomWebView.class);
                            }
                        }));
                    } catch (Throwable th18) {
                        Result.Companion companion36 = Result.INSTANCE;
                        objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
                        objM12684constructorimpl18 = null;
                    }
                    TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
                    if (typeDescriptor18 == null) {
                        typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DomWebView.class));
                    }
                    anyType17 = new AnyType(typeDescriptor18, null);
                }
                anyTypeArr4[0] = anyType17;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((DomWebView) objArr[0]).forceReload();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("reload", anyTypeArr4, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("reload", anyTypeArr4, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("reload", anyTypeArr4, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("reload", anyTypeArr4, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("reload", anyTypeArr4, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("reload", anyTypeArr4, function3);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent3;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("reload", asyncFunctionWithPromiseComponent);
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((DomWebView) it).reload();
                }
            });
            viewDefinitionBuilder.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$0$2$$inlined$OnViewDestroys$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((DomWebView) it).onViewDestroys$expo_dom_webview_release();
                }
            });
            moduleDefinitionBuilder3.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th19) {
            Trace.endSection();
            throw th19;
        }
    }
}
