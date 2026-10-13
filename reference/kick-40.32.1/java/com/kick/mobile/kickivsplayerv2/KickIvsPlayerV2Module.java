package com.kick.mobile.kickivsplayerv2;

import androidx.exifinterface.media.ExifInterface;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2Module;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIvsPlayerV2Module extends Module {
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
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        Object objM12684constructorimpl22;
        Object objM12684constructorimpl23;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        Object objM12684constructorimpl28;
        Object objM12684constructorimpl29;
        Object objM12684constructorimpl30;
        Object objM12684constructorimpl31;
        Object objM12684constructorimpl32;
        Object objM12684constructorimpl33;
        Object objM12684constructorimpl34;
        Object objM12684constructorimpl35;
        Object objM12684constructorimpl36;
        Object objM12684constructorimpl37;
        Object objM12684constructorimpl38;
        Object objM12684constructorimpl39;
        Object objM12684constructorimpl40;
        Object objM12684constructorimpl41;
        Object objM12684constructorimpl42;
        Object objM12684constructorimpl43;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl44;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        KickIvsPlayerV2Module kickIvsPlayerV2Module = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickIvsPlayerV2Module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickIvsPlayerV2Module);
            moduleDefinitionBuilder.Name("KickIvsPlayerV2");
            moduleDefinitionBuilder.Events("onSeek", "onData", "onVideoStatistics", "onPlayerStateChange", "onDurationChange", "onQualityChange", "onPipChange", "onRebuffering", "onLoadStart", "onLoad", "onProgress", "onError", "onTimePoint", "onLog", "onAdEvent");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    KickIvsPlayerV2Manager kickIvsPlayerV2Manager = KickIvsPlayerV2Manager.INSTANCE;
                    final KickIvsPlayerV2Module kickIvsPlayerV2Module2 = this.this$0;
                    kickIvsPlayerV2Manager.setEventListener(new Function2<String, Map<String, ? extends Object>, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Map<String, ? extends Object> map) {
                            invoke2(str, map);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String name, Map<String, ? extends Object> body) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            Intrinsics.checkNotNullParameter(body, "body");
                            kickIvsPlayerV2Module2.sendEvent(name, body);
                        }
                    });
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PalSDKManager.INSTANCE.destroyBridge();
                    KickIvsPlayerV2Manager.INSTANCE.destroy();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getPlayerVersions", new SyncFunctionComponent("getPlayerVersions", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return MapsKt.mapOf(TuplesKt.to("moduleVersion", BuildConfig.MODULE_VERSION), TuplesKt.to("ivsPlayerVersion", BuildConfig.IVS_PLAYER_VERSION), TuplesKt.to("muxSdkVersion", "8.9.2"), TuplesKt.to("palSdkVersion", BuildConfig.PAL_SDK_VERSION), TuplesKt.to("datazoomSdkVersion", "0.0.3"));
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(StreamInfo.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(StreamInfo.class);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(StreamInfo.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr2[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("setStreamInfo", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    KickIvsPlayerV2Manager.INSTANCE.setStreamInfo((StreamInfo) objArr[0]);
                    promise.resolve();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("setStreamInfo", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class);
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$View$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(KickIvsPlayerV2View.class);
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
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, typeDescriptor2, moduleDefinitionBuilder4.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            KickIvsPlayerV2Module$definition$1$5$1 kickIvsPlayerV2Module$definition$1$5$1 = new Function2<KickIvsPlayerV2View, Boolean, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool) {
                    invoke2(kickIvsPlayerV2View, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$1$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Boolean $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = bool;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setSendVideoStatistics(this.$value.booleanValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, bool, null), 3, null);
                }
            };
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType2 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType2 = new AnyType(typeDescriptor3, null);
            }
            ConcreteViewProp concreteViewProp = new ConcreteViewProp("showStats", anyType2, kickIvsPlayerV2Module$definition$1$5$1);
            viewDefinitionBuilder.getProps().put("showStats", concreteViewProp);
            KickIvsPlayerV2Module$definition$1$5$2 kickIvsPlayerV2Module$definition$1$5$2 = new Function2<KickIvsPlayerV2View, String, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, String str) {
                    invoke2(kickIvsPlayerV2View, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$2$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setResizeMode(this.$value);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, str, null), 3, null);
                }
            };
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType3 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor4, null);
            }
            ConcreteViewProp concreteViewProp2 = new ConcreteViewProp(ViewProps.RESIZE_MODE, anyType3, kickIvsPlayerV2Module$definition$1$5$2);
            viewDefinitionBuilder.getProps().put(ViewProps.RESIZE_MODE, concreteViewProp2);
            KickIvsPlayerV2Module$definition$1$5$3 kickIvsPlayerV2Module$definition$1$5$3 = new Function2<KickIvsPlayerV2View, Boolean, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool) {
                    invoke2(kickIvsPlayerV2View, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$3$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Boolean $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = bool;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setMuted(this.$value.booleanValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, bool, null), 3, null);
                }
            };
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType4 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType4 = new AnyType(typeDescriptor5, null);
            }
            ConcreteViewProp concreteViewProp3 = new ConcreteViewProp("muted", anyType4, kickIvsPlayerV2Module$definition$1$5$3);
            viewDefinitionBuilder.getProps().put("muted", concreteViewProp3);
            KickIvsPlayerV2Module$definition$1$5$4 kickIvsPlayerV2Module$definition$1$5$4 = new Function2<KickIvsPlayerV2View, Boolean, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool) {
                    invoke2(kickIvsPlayerV2View, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$4$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Boolean $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = bool;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setLooping(this.$value.booleanValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, bool, null), 3, null);
                }
            };
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType5 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType5 = new AnyType(typeDescriptor6, null);
            }
            ConcreteViewProp concreteViewProp4 = new ConcreteViewProp("loop", anyType5, kickIvsPlayerV2Module$definition$1$5$4);
            viewDefinitionBuilder.getProps().put("loop", concreteViewProp4);
            KickIvsPlayerV2Module$definition$1$5$5 kickIvsPlayerV2Module$definition$1$5$5 = new Function2<KickIvsPlayerV2View, Boolean, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool) {
                    invoke2(kickIvsPlayerV2View, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$5$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$5$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Boolean $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = bool;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setRebufferToLive(this.$value.booleanValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, bool, null), 3, null);
                }
            };
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType6 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType6 = new AnyType(typeDescriptor7, null);
            }
            ConcreteViewProp concreteViewProp5 = new ConcreteViewProp("rebufferToLive", anyType6, kickIvsPlayerV2Module$definition$1$5$5);
            viewDefinitionBuilder.getProps().put("rebufferToLive", concreteViewProp5);
            KickIvsPlayerV2Module$definition$1$5$6 kickIvsPlayerV2Module$definition$1$5$6 = new Function2<KickIvsPlayerV2View, String, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, String str) {
                    invoke2(kickIvsPlayerV2View, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$6$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$6$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $qualityName;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$qualityName = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$qualityName, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setQuality(this.$qualityName);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, str, null), 3, null);
                }
            };
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType7 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError8 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError8), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType7 = new AnyType(typeDescriptor8, null);
            }
            ConcreteViewProp concreteViewProp6 = new ConcreteViewProp("quality", anyType7, kickIvsPlayerV2Module$definition$1$5$6);
            viewDefinitionBuilder.getProps().put("quality", concreteViewProp6);
            KickIvsPlayerV2Module$definition$1$5$7 kickIvsPlayerV2Module$definition$1$5$7 = new Function2<KickIvsPlayerV2View, Integer, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Integer num) {
                    invoke2(kickIvsPlayerV2View, num);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$7$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Integer $qualityHeight;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Integer num, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$qualityHeight = num;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$qualityHeight, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setMaxAutoQuality(this.$qualityHeight);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Integer num) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (num == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, num, null), 3, null);
                }
            };
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType8 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError9 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError9), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
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
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType8 = new AnyType(typeDescriptor9, null);
            }
            ConcreteViewProp concreteViewProp7 = new ConcreteViewProp("autoMaxQuality", anyType8, kickIvsPlayerV2Module$definition$1$5$7);
            viewDefinitionBuilder.getProps().put("autoMaxQuality", concreteViewProp7);
            KickIvsPlayerV2Module$definition$1$5$8 kickIvsPlayerV2Module$definition$1$5$8 = new Function2<KickIvsPlayerV2View, Boolean, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool) {
                    invoke2(kickIvsPlayerV2View, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$8$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$8$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Boolean $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = bool;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setAutoQualityMode(this.$value.booleanValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, bool, null), 3, null);
                }
            };
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType9 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError10 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError10), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType9 = new AnyType(typeDescriptor10, null);
            }
            ConcreteViewProp concreteViewProp8 = new ConcreteViewProp("autoQualityMode", anyType9, kickIvsPlayerV2Module$definition$1$5$8);
            viewDefinitionBuilder.getProps().put("autoQualityMode", concreteViewProp8);
            KickIvsPlayerV2Module$definition$1$5$9 kickIvsPlayerV2Module$definition$1$5$9 = new Function2<KickIvsPlayerV2View, Double, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Double d) {
                    invoke2(kickIvsPlayerV2View, d);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$9$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$9$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Double $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Double d, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = d;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setPlaybackRate(this.$value.doubleValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Double d) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (d == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, d, null), 3, null);
                }
            };
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Double.class), true));
            if (anyType10 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError11 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError11), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Double.class);
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
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Double.class));
                }
                anyType10 = new AnyType(typeDescriptor11, null);
            }
            ConcreteViewProp concreteViewProp9 = new ConcreteViewProp("playbackRate", anyType10, kickIvsPlayerV2Module$definition$1$5$9);
            viewDefinitionBuilder.getProps().put("playbackRate", concreteViewProp9);
            KickIvsPlayerV2Module$definition$1$5$10 kickIvsPlayerV2Module$definition$1$5$10 = new Function2<KickIvsPlayerV2View, Integer, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Integer num) {
                    invoke2(kickIvsPlayerV2View, num);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$10$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$10$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Integer $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Integer num, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = num;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setLogLevel(this.$value.intValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Integer num) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (num == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, num, null), 3, null);
                }
            };
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType11 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError12 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError12), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
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
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType11 = new AnyType(typeDescriptor12, null);
            }
            ConcreteViewProp concreteViewProp10 = new ConcreteViewProp("logLevel", anyType11, kickIvsPlayerV2Module$definition$1$5$10);
            viewDefinitionBuilder.getProps().put("logLevel", concreteViewProp10);
            KickIvsPlayerV2Module$definition$1$5$11 kickIvsPlayerV2Module$definition$1$5$11 = new Function2<KickIvsPlayerV2View, Double, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$11
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, Double d) {
                    invoke2(kickIvsPlayerV2View, d);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$11$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$11$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Double $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, Double d, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = d;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setVolume(this.$value.doubleValue());
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, Double d) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (d == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, d, null), 3, null);
                }
            };
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Double.class), true));
            if (anyType12 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError13 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError13), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Double.class);
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
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Double.class));
                }
                anyType12 = new AnyType(typeDescriptor13, null);
            }
            ConcreteViewProp concreteViewProp11 = new ConcreteViewProp(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, anyType12, kickIvsPlayerV2Module$definition$1$5$11);
            viewDefinitionBuilder.getProps().put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, concreteViewProp11);
            KickIvsPlayerV2Module$definition$1$5$12 kickIvsPlayerV2Module$definition$1$5$12 = new Function2<KickIvsPlayerV2View, List<? extends Integer>, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$12
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, List<? extends Integer> list) {
                    invoke2(kickIvsPlayerV2View, (List<Integer>) list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$12$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$12$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ List<Integer> $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, List<Integer> list, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = list;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        KickIvsPlayerV2View kickIvsPlayerV2View = this.$view;
                        List<Integer> list = this.$value;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Boxing.boxLong(((Number) it.next()).intValue()));
                        }
                        kickIvsPlayerV2View.setBreakpoints(arrayList);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, List<Integer> list) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (list == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, list, null), 3, null);
                }
            };
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType13 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError14 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError14), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)));
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
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
                }
                anyType13 = new AnyType(typeDescriptor14, null);
            }
            ConcreteViewProp concreteViewProp12 = new ConcreteViewProp("breakpoints", anyType13, kickIvsPlayerV2Module$definition$1$5$12);
            viewDefinitionBuilder.getProps().put("breakpoints", concreteViewProp12);
            KickIvsPlayerV2Module$definition$1$5$13 kickIvsPlayerV2Module$definition$1$5$13 = new Function2<KickIvsPlayerV2View, String, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$13
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, String str) {
                    invoke2(kickIvsPlayerV2View, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$13$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$13$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setStreamUrl(this.$value);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, str, null), 3, null);
                }
            };
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType14 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError15 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError15), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType14 = new AnyType(typeDescriptor15, null);
            }
            ConcreteViewProp concreteViewProp13 = new ConcreteViewProp("streamUrl", anyType14, kickIvsPlayerV2Module$definition$1$5$13);
            viewDefinitionBuilder.getProps().put("streamUrl", concreteViewProp13);
            KickIvsPlayerV2Module$definition$1$5$14 kickIvsPlayerV2Module$definition$1$5$14 = new Function2<KickIvsPlayerV2View, String, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$14

                /* JADX INFO: renamed from: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$14$1, reason: invalid class name */
                /* JADX INFO: compiled from: KickIvsPlayerV2Module.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$1$5$14$1", f = "KickIvsPlayerV2Module.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $value;
                    final /* synthetic */ KickIvsPlayerV2View $view;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$view = kickIvsPlayerV2View;
                        this.$value = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$view, this.$value, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$view.setUserAgent(this.$value);
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KickIvsPlayerV2View kickIvsPlayerV2View, String str) {
                    invoke2(kickIvsPlayerV2View, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KickIvsPlayerV2View view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, str, null), 3, null);
                }
            };
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType15 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError16 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError16), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$Prop$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType15 = new AnyType(typeDescriptor16, null);
            }
            ConcreteViewProp concreteViewProp14 = new ConcreteViewProp("userAgent", anyType15, kickIvsPlayerV2Module$definition$1$5$14);
            viewDefinitionBuilder.getProps().put("userAgent", concreteViewProp14);
            TypeConverterProvider converters2 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType16 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError17 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError17), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
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
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType16 = new AnyType(typeDescriptor17, converters2);
            }
            anyTypeArr3[0] = anyType16;
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType17 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError18 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError18), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType17 = new AnyType(typeDescriptor18, converters2);
            }
            anyTypeArr3[1] = anyType17;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Boolean bool = (Boolean) objArr[1];
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (bool != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$15$1(kickIvsPlayerV2View, bool, null), 3, null);
                    }
                    return Unit.INSTANCE;
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1) : new UntypedAsyncFunctionComponent("togglePipEnabled", anyTypeArr3, function1);
            }
            AsyncFunctionComponent asyncFunctionComponent = stringAsyncFunctionComponent;
            viewDefinitionBuilder.getAsyncFunctions().put("togglePipEnabled", stringAsyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = stringAsyncFunctionComponent;
            TypeConverterProvider converters3 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError19 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError19), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th19) {
                    Result.Companion companion38 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                    objM12684constructorimpl19 = null;
                }
                TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
                if (typeDescriptor19 == null) {
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType18 = new AnyType(typeDescriptor19, converters3);
            }
            anyTypeArr4[0] = anyType18;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent(PlayEvent.TYPE, anyTypeArr4, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$16$1((KickIvsPlayerV2View) objArr[0], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put(PlayEvent.TYPE, asyncFunctionWithPromiseComponent4);
            TypeConverterProvider converters4 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType19 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError20 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError20), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th20) {
                    Result.Companion companion40 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                    objM12684constructorimpl20 = null;
                }
                TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
                if (typeDescriptor20 == null) {
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType19 = new AnyType(typeDescriptor20, converters4);
            }
            anyTypeArr5[0] = anyType19;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent(PauseEvent.TYPE, anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$17$1((KickIvsPlayerV2View) objArr[0], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put(PauseEvent.TYPE, asyncFunctionWithPromiseComponent5);
            TypeConverterProvider converters5 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType20 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError21 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError21), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th21) {
                    Result.Companion companion42 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                    objM12684constructorimpl21 = null;
                }
                TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
                if (typeDescriptor21 == null) {
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType20 = new AnyType(typeDescriptor21, converters5);
            }
            anyTypeArr6[0] = anyType20;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("pauseForSeeking", anyTypeArr6, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$18$1((KickIvsPlayerV2View) objArr[0], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("pauseForSeeking", asyncFunctionWithPromiseComponent6);
            TypeConverterProvider converters6 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType21 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError22 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError22), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th22) {
                    Result.Companion companion44 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                    objM12684constructorimpl22 = null;
                }
                TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
                if (typeDescriptor22 == null) {
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType21 = new AnyType(typeDescriptor22, converters6);
            }
            anyTypeArr7[0] = anyType21;
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Double.class), true));
            if (anyType22 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError23 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError23), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Double.class);
                        }
                    }));
                } catch (Throwable th23) {
                    Result.Companion companion46 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
                    objM12684constructorimpl23 = null;
                }
                TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
                if (typeDescriptor23 == null) {
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Double.class));
                }
                anyType22 = new AnyType(typeDescriptor23, converters6);
            }
            anyTypeArr7[1] = anyType22;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("seekTo", anyTypeArr7, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$9
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Double d = (Double) objArr[1];
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (d != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$19$1(kickIvsPlayerV2View, d, promise, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("seekTo", asyncFunctionWithPromiseComponent7);
            TypeConverterProvider converters7 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType23 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError24 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError24), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th24) {
                    Result.Companion companion48 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
                    objM12684constructorimpl24 = null;
                }
                TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
                if (typeDescriptor24 == null) {
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType23 = new AnyType(typeDescriptor24, converters7);
            }
            anyTypeArr8[0] = anyType23;
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType24 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError25 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError25), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th25) {
                    Result.Companion companion50 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                    objM12684constructorimpl25 = null;
                }
                TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
                if (typeDescriptor25 == null) {
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType24 = new AnyType(typeDescriptor25, converters7);
            }
            anyTypeArr8[1] = anyType24;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("setOrigin", anyTypeArr8, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$12
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (str != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$20$1(kickIvsPlayerV2View, str, promise, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("setOrigin", asyncFunctionWithPromiseComponent8);
            TypeConverterProvider converters8 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType25 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError26 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError26), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th26) {
                    Result.Companion companion52 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                    objM12684constructorimpl26 = null;
                }
                TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
                if (typeDescriptor26 == null) {
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType25 = new AnyType(typeDescriptor26, converters8);
            }
            anyTypeArr9[0] = anyType25;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("togglePip", anyTypeArr9, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$14
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$21$1((KickIvsPlayerV2View) objArr[0], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("togglePip", asyncFunctionWithPromiseComponent9);
            TypeConverterProvider converters9 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[3];
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType26 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError27 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError27), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th27) {
                    Result.Companion companion54 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                    objM12684constructorimpl27 = null;
                }
                TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
                if (typeDescriptor27 == null) {
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType26 = new AnyType(typeDescriptor27, converters9);
            }
            anyTypeArr10[0] = anyType26;
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType27 == null) {
                try {
                    Result.Companion companion55 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError28 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError28), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                } catch (Throwable th28) {
                    Result.Companion companion56 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
                    objM12684constructorimpl28 = null;
                }
                TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
                if (typeDescriptor28 == null) {
                    typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType27 = new AnyType(typeDescriptor28, converters9);
            }
            anyTypeArr10[1] = anyType27;
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType28 == null) {
                try {
                    Result.Companion companion57 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError29 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError29), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th29) {
                    Result.Companion companion58 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                    objM12684constructorimpl29 = null;
                }
                TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                if (typeDescriptor29 == null) {
                    typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType28 = new AnyType(typeDescriptor29, converters9);
            }
            anyTypeArr10[2] = anyType28;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent(LinkHeader.Rel.PreLoad, anyTypeArr10, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$18
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    String str = (String) objArr[2];
                    int iIntValue = ((Number) obj2).intValue();
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (str != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$22$1(kickIvsPlayerV2View, iIntValue, str, promise, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put(LinkHeader.Rel.PreLoad, asyncFunctionWithPromiseComponent10);
            TypeConverterProvider converters10 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[2];
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType29 == null) {
                try {
                    Result.Companion companion59 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError30 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError30), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th30) {
                    Result.Companion companion60 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                    objM12684constructorimpl30 = null;
                }
                TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                if (typeDescriptor30 == null) {
                    typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType29 = new AnyType(typeDescriptor30, converters10);
            }
            anyTypeArr11[0] = anyType29;
            AnyType anyType30 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType30 == null) {
                try {
                    Result.Companion companion61 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError31 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError31), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }));
                } catch (Throwable th31) {
                    Result.Companion companion62 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                    objM12684constructorimpl31 = null;
                }
                TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                if (typeDescriptor31 == null) {
                    typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType30 = new AnyType(typeDescriptor31, converters10);
            }
            anyTypeArr11[1] = anyType30;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("loadSource", anyTypeArr11, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$21
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Integer num = (Integer) objArr[1];
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (num != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$23$1(kickIvsPlayerV2View, num, promise, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("loadSource", asyncFunctionWithPromiseComponent11);
            TypeConverterProvider converters11 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr12 = new AnyType[2];
            AnyType anyType31 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType31 == null) {
                try {
                    Result.Companion companion63 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError32 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError32), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th32) {
                    Result.Companion companion64 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl32)) {
                    objM12684constructorimpl32 = null;
                }
                TypeDescriptor typeDescriptor32 = (TypeDescriptor) objM12684constructorimpl32;
                if (typeDescriptor32 == null) {
                    typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType31 = new AnyType(typeDescriptor32, converters11);
            }
            anyTypeArr12[0] = anyType31;
            AnyType anyType32 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType32 == null) {
                try {
                    Result.Companion companion65 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError33 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError33), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }));
                } catch (Throwable th33) {
                    Result.Companion companion66 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(ResultKt.createFailure(th33));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl33)) {
                    objM12684constructorimpl33 = null;
                }
                TypeDescriptor typeDescriptor33 = (TypeDescriptor) objM12684constructorimpl33;
                if (typeDescriptor33 == null) {
                    typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType32 = new AnyType(typeDescriptor33, converters11);
            }
            anyTypeArr12[1] = anyType32;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("releaseSource", anyTypeArr12, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$24
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Integer num = (Integer) objArr[1];
                    KickIvsPlayerV2View kickIvsPlayerV2View = (KickIvsPlayerV2View) obj;
                    if (num != null) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$24$1(kickIvsPlayerV2View, num, promise, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("releaseSource", asyncFunctionWithPromiseComponent12);
            TypeConverterProvider converters12 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[2];
            AnyType anyType33 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType33 == null) {
                try {
                    Result.Companion companion67 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError34 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError34), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th34) {
                    Result.Companion companion68 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(ResultKt.createFailure(th34));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl34)) {
                    objM12684constructorimpl34 = null;
                }
                TypeDescriptor typeDescriptor34 = (TypeDescriptor) objM12684constructorimpl34;
                if (typeDescriptor34 == null) {
                    typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType33 = new AnyType(typeDescriptor34, converters12);
            }
            anyTypeArr13[0] = anyType33;
            AnyType anyType34 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(MuxAnalyticsViewConfig.class), true));
            if (anyType34 == null) {
                try {
                    Result.Companion companion69 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError35 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError35), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(MuxAnalyticsViewConfig.class);
                        }
                    }));
                } catch (Throwable th35) {
                    Result.Companion companion70 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(ResultKt.createFailure(th35));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl35)) {
                    objM12684constructorimpl35 = null;
                }
                TypeDescriptor typeDescriptor35 = (TypeDescriptor) objM12684constructorimpl35;
                if (typeDescriptor35 == null) {
                    typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(MuxAnalyticsViewConfig.class));
                }
                anyType34 = new AnyType(typeDescriptor35, converters12);
            }
            anyTypeArr13[1] = anyType34;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent13 = new AsyncFunctionWithPromiseComponent("setMuxAnalyticsConfig", anyTypeArr13, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$27
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$25$1((KickIvsPlayerV2View) obj, (MuxAnalyticsViewConfig) objArr[1], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("setMuxAnalyticsConfig", asyncFunctionWithPromiseComponent13);
            TypeConverterProvider converters13 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[2];
            AnyType anyType35 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType35 == null) {
                try {
                    Result.Companion companion71 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError36 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError36), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$28
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th36) {
                    Result.Companion companion72 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(ResultKt.createFailure(th36));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl36)) {
                    objM12684constructorimpl36 = null;
                }
                TypeDescriptor typeDescriptor36 = (TypeDescriptor) objM12684constructorimpl36;
                if (typeDescriptor36 == null) {
                    typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType35 = new AnyType(typeDescriptor36, converters13);
            }
            anyTypeArr14[0] = anyType35;
            AnyType anyType36 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DatazoomAnalyticsViewConfig.class), true));
            if (anyType36 == null) {
                try {
                    Result.Companion companion73 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError37 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError37), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$29
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DatazoomAnalyticsViewConfig.class);
                        }
                    }));
                } catch (Throwable th37) {
                    Result.Companion companion74 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(ResultKt.createFailure(th37));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl37)) {
                    objM12684constructorimpl37 = null;
                }
                TypeDescriptor typeDescriptor37 = (TypeDescriptor) objM12684constructorimpl37;
                if (typeDescriptor37 == null) {
                    typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DatazoomAnalyticsViewConfig.class));
                }
                anyType36 = new AnyType(typeDescriptor37, converters13);
            }
            anyTypeArr14[1] = anyType36;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent14 = new AsyncFunctionWithPromiseComponent("setDatazoomAnalyticsConfig", anyTypeArr14, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$30
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$26$1((KickIvsPlayerV2View) obj, (DatazoomAnalyticsViewConfig) objArr[1], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("setDatazoomAnalyticsConfig", asyncFunctionWithPromiseComponent14);
            TypeConverterProvider converters14 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[2];
            AnyType anyType37 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KickIvsPlayerV2View.class), false));
            if (anyType37 == null) {
                try {
                    Result.Companion companion75 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError38 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl38 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError38), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$31
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KickIvsPlayerV2View.class);
                        }
                    }));
                } catch (Throwable th38) {
                    Result.Companion companion76 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(ResultKt.createFailure(th38));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl38)) {
                    objM12684constructorimpl38 = null;
                }
                TypeDescriptor typeDescriptor38 = (TypeDescriptor) objM12684constructorimpl38;
                if (typeDescriptor38 == null) {
                    typeDescriptor38 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KickIvsPlayerV2View.class));
                }
                anyType37 = new AnyType(typeDescriptor38, converters14);
            }
            anyTypeArr15[0] = anyType37;
            AnyType anyType38 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DatazoomAnalyticsEventConfig.class), true));
            if (anyType38 == null) {
                try {
                    Result.Companion companion77 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError39 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl39 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError39), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$32
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DatazoomAnalyticsEventConfig.class);
                        }
                    }));
                } catch (Throwable th39) {
                    Result.Companion companion78 = Result.INSTANCE;
                    objM12684constructorimpl39 = Result.m12684constructorimpl(ResultKt.createFailure(th39));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl39)) {
                    objM12684constructorimpl39 = null;
                }
                TypeDescriptor typeDescriptor39 = (TypeDescriptor) objM12684constructorimpl39;
                if (typeDescriptor39 == null) {
                    typeDescriptor39 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DatazoomAnalyticsEventConfig.class));
                }
                anyType38 = new AnyType(typeDescriptor39, converters14);
            }
            anyTypeArr15[1] = anyType38;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent15 = new AsyncFunctionWithPromiseComponent("sendDatazoomAnalyticsEvent", anyTypeArr15, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$4$$inlined$AsyncFunctionWithPromise$33
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KickIvsPlayerV2Module$definition$1$5$27$1((KickIvsPlayerV2View) obj, (DatazoomAnalyticsEventConfig) objArr[1], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("sendDatazoomAnalyticsEvent", asyncFunctionWithPromiseComponent15);
            moduleDefinitionBuilder4.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters15 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[1];
            AnyType anyType39 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PalNonceRequestConfig.class), true));
            if (anyType39 == null) {
                try {
                    Result.Companion companion79 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError40 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl40 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError40), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(PalNonceRequestConfig.class);
                        }
                    }));
                } catch (Throwable th40) {
                    Result.Companion companion80 = Result.INSTANCE;
                    objM12684constructorimpl40 = Result.m12684constructorimpl(ResultKt.createFailure(th40));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl40)) {
                    objM12684constructorimpl40 = null;
                }
                TypeDescriptor typeDescriptor40 = (TypeDescriptor) objM12684constructorimpl40;
                if (typeDescriptor40 == null) {
                    typeDescriptor40 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(PalNonceRequestConfig.class));
                }
                anyType39 = new AnyType(typeDescriptor40, converters15);
            }
            anyTypeArr16[0] = anyType39;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent16 = new AsyncFunctionWithPromiseComponent("generatePalNonce", anyTypeArr16, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    PalSDKModuleBridge.INSTANCE.generateNonce(this.this$0.getAppContext().getReactContext(), (PalNonceRequestConfig) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder5.getAsyncFunctions().put("generatePalNonce", asyncFunctionWithPromiseComponent16);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            TypeConverterProvider converters16 = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr17 = new AnyType[1];
            AnyType anyType40 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType40 == null) {
                try {
                    Result.Companion companion81 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError41 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl41 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError41), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th41) {
                    Result.Companion companion82 = Result.INSTANCE;
                    objM12684constructorimpl41 = Result.m12684constructorimpl(ResultKt.createFailure(th41));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl41)) {
                    objM12684constructorimpl41 = null;
                }
                TypeDescriptor typeDescriptor41 = (TypeDescriptor) objM12684constructorimpl41;
                if (typeDescriptor41 == null) {
                    typeDescriptor41 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType40 = new AnyType(typeDescriptor41, converters16);
            }
            anyTypeArr17[0] = anyType40;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent17 = new AsyncFunctionWithPromiseComponent("setPalSessionActive", anyTypeArr17, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    PalSDKModuleBridge.INSTANCE.setSessionActive(((Boolean) objArr[0]).booleanValue(), promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("setPalSessionActive", asyncFunctionWithPromiseComponent17);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            TypeConverterProvider converters17 = moduleDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr18 = new AnyType[1];
            AnyType anyType41 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType41 == null) {
                try {
                    Result.Companion companion83 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError42 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl42 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError42), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th42) {
                    Result.Companion companion84 = Result.INSTANCE;
                    objM12684constructorimpl42 = Result.m12684constructorimpl(ResultKt.createFailure(th42));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl42)) {
                    objM12684constructorimpl42 = null;
                }
                TypeDescriptor typeDescriptor42 = (TypeDescriptor) objM12684constructorimpl42;
                if (typeDescriptor42 == null) {
                    typeDescriptor42 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType41 = new AnyType(typeDescriptor42, converters17);
            }
            anyTypeArr18[0] = anyType41;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent18 = new AsyncFunctionWithPromiseComponent("sendPalPlaybackEvent", anyTypeArr18, new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunctionWithPromise$8
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    PalSDKModuleBridge.INSTANCE.sendPlaybackEvent((String) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder7.getAsyncFunctions().put("sendPalPlaybackEvent", asyncFunctionWithPromiseComponent18);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("resetPalSession", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        PalSDKModuleBridge.INSTANCE.resetSession(promise);
                    }
                });
            } else {
                TypeConverterProvider converters18 = moduleDefinitionBuilder8.getConverters();
                AnyType[] anyTypeArr19 = new AnyType[1];
                AnyType anyType42 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType42 == null) {
                    try {
                        Result.Companion companion85 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError43 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        objM12684constructorimpl43 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError43), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th43) {
                        Result.Companion companion86 = Result.INSTANCE;
                        objM12684constructorimpl43 = Result.m12684constructorimpl(ResultKt.createFailure(th43));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl43)) {
                        objM12684constructorimpl43 = null;
                    }
                    TypeDescriptor typeDescriptor43 = (TypeDescriptor) objM12684constructorimpl43;
                    if (typeDescriptor43 == null) {
                        typeDescriptor43 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType42 = new AnyType(typeDescriptor43, converters18);
                }
                anyTypeArr19[0] = anyType42;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        PalSDKModuleBridge.INSTANCE.resetSession((Promise) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2);
                } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2);
                } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2);
                } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                    stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2);
                } else {
                    stringAsyncFunctionComponent2 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2) : new UntypedAsyncFunctionComponent("resetPalSession", anyTypeArr19, function2);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent2;
            }
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder8.getAsyncFunctions().put("resetPalSession", asyncFunctionWithPromiseComponent);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionWithPromiseComponent;
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("destroyPalBridge", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        PalSDKModuleBridge.INSTANCE.destroyBridge(promise);
                    }
                });
            } else {
                TypeConverterProvider converters19 = moduleDefinitionBuilder9.getConverters();
                AnyType[] anyTypeArr20 = new AnyType[1];
                AnyType anyType43 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType43 == null) {
                    try {
                        Result.Companion companion87 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError44 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        objM12684constructorimpl44 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError44), new Function0<KType>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th44) {
                        Result.Companion companion88 = Result.INSTANCE;
                        objM12684constructorimpl44 = Result.m12684constructorimpl(ResultKt.createFailure(th44));
                    }
                    TypeDescriptor typeDescriptor44 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl44) ? null : objM12684constructorimpl44);
                    if (typeDescriptor44 == null) {
                        typeDescriptor44 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType43 = new AnyType(typeDescriptor44, converters19);
                }
                anyTypeArr20[0] = anyType43;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Module$definition$lambda$0$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        PalSDKModuleBridge.INSTANCE.destroyBridge((Promise) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3);
                } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3);
                } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3);
                } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                    stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3);
                } else {
                    stringAsyncFunctionComponent3 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3) : new UntypedAsyncFunctionComponent("destroyPalBridge", anyTypeArr20, function3);
                }
                asyncFunctionWithPromiseComponent2 = stringAsyncFunctionComponent3;
            }
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionWithPromiseComponent2;
            moduleDefinitionBuilder9.getAsyncFunctions().put("destroyPalBridge", asyncFunctionWithPromiseComponent2);
            AsyncFunctionComponent asyncFunctionComponent6 = asyncFunctionWithPromiseComponent2;
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th45) {
            Trace.endSection();
            throw th45;
        }
    }
}
