package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.clipboard.ClipboardModule.ClipboardEventEmitter;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
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
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ClipboardModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardCacheDir", "Ljava/io/File;", "getClipboardCacheDir", "()Ljava/io/File;", "clipboardCacheDir$delegate", "Lkotlin/Lazy;", "clipboardEventEmitter", "Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "clipboardHasItemWithType", "", "mimeType", "", "firstItem", "Landroid/content/ClipData$Item;", "getFirstItem", "(Landroid/content/ClipboardManager;)Landroid/content/ClipData$Item;", "ClipboardEventEmitter", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClipboardModule extends Module {

    /* JADX INFO: renamed from: clipboardCacheDir$delegate, reason: from kotlin metadata */
    private final Lazy clipboardCacheDir = LazyKt.lazy(new Function0() { // from class: expo.modules.clipboard.ClipboardModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ClipboardModule.clipboardCacheDir_delegate$lambda$15(this.f$0);
        }
    });
    private ClipboardEventEmitter clipboardEventEmitter;

    /* JADX INFO: compiled from: ClipboardModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StringFormat.values().length];
            try {
                iArr[StringFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StringFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        ClipboardModule clipboardModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (clipboardModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(clipboardModule);
            moduleDefinitionBuilder.Name("ExpoClipboard");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(GetStringOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getStringAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ClipboardModule clipboardModule2 = this.this$0;
                        ClipData.Item firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((GetStringOptions) promise).getPreferredFormat().ordinal()];
                        if (i == 1) {
                            if (firstItem != null) {
                                ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                            }
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GetStringOptions.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(GetStringOptions.class, false, GetStringOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(GetStringOptions.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(GetStringOptions.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        GetStringOptions getStringOptions = (GetStringOptions) objArr[0];
                        ClipboardModule clipboardModule2 = this.this$0;
                        ClipData.Item firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[getStringOptions.getPreferredFormat().ordinal()];
                        String strCoerceToPlainText = null;
                        if (i != 1) {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                strCoerceToPlainText = firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        } else if (firstItem != null) {
                            strCoerceToPlainText = ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                        }
                        return strCoerceToPlainText == null ? "" : strCoerceToPlainText;
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getStringAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$4
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
                anyType2 = new AnyType(typeDescriptor2, converters2);
            }
            anyTypeArr2[0] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SetStringOptions.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SetStringOptions.class, false, SetStringOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SetStringOptions.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SetStringOptions.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[1] = anyType3;
            Function1<Object[], Boolean> function2 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] objArr) {
                    ClipData clipDataNewPlainText;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    SetStringOptions setStringOptions = (SetStringOptions) objArr[1];
                    String str = (String) obj;
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[setStringOptions.getInputFormat().ordinal()];
                    if (i == 1) {
                        clipDataNewPlainText = ClipData.newPlainText(null, str);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        clipDataNewPlainText = ClipData.newHtmlText(null, ClipboardModuleKt.plainTextFromHtml(str), str);
                    }
                    Intrinsics.checkNotNull(clipDataNewPlainText);
                    this.this$0.getClipboardManager().setPrimaryClip(ClipboardModuleKt.applyIsSensitive(clipDataNewPlainText, setStringOptions.getIsSensitive()));
                    return true;
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("setStringAsync", untypedAsyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Boolean> function3 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    return Boolean.valueOf(primaryClipDescription != null ? ClipboardModuleKt.getHasTextContent(primaryClipDescription) : false);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("hasStringAsync", untypedAsyncFunctionComponent3);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("getImageAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GetImageOptions.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(GetImageOptions.class, false, GetImageOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(GetImageOptions.class);
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(GetImageOptions.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters3);
            }
            anyTypeArr4[0] = anyType4;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr4, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("setImageAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$3
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
                anyType5 = new AnyType(typeDescriptor5, converters4);
            }
            anyTypeArr5[0] = anyType5;
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SetImageOptions.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SetImageOptions.class, false, null)), new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SetImageOptions.class);
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
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SetImageOptions.class));
                }
                anyType6 = new AnyType(typeDescriptor6, converters4);
            }
            anyTypeArr5[1] = anyType6;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr5, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$5(null, this)));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            Function1<Object[], Boolean> function4 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    boolean z = false;
                    if (primaryClipDescription != null && primaryClipDescription.hasMimeType("image/*")) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("hasImageAsync", untypedAsyncFunctionComponent4);
            moduleDefinitionBuilder.Events(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.clipboardEventEmitter = this.this$0.new ClipboardEventEmitter();
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.attachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.detachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.pauseListening();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.resumeListening();
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th7) {
            Trace.endSection();
            throw th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardManager getClipboardManager() throws ClipboardUnavailableException {
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        throw new ClipboardUnavailableException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getClipboardCacheDir() {
        return (File) this.clipboardCacheDir.getValue();
    }

    static final File clipboardCacheDir_delegate$lambda$15(ClipboardModule clipboardModule) {
        File file = new File(clipboardModule.getContext().getCacheDir(), ClipboardModuleKt.CLIPBOARD_DIRECTORY_NAME);
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ClipboardModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0001J\r\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "", "<init>", "(Lexpo/modules/clipboard/ClipboardModule;)V", "isListening", "", "timestamp", "", "resumeListening", "", "pauseListening", "attachListener", "detachListener", "()Lkotlin/Unit;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "maybeClipboardManager", "Landroid/content/ClipboardManager;", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class ClipboardEventEmitter {
        private final ClipboardManager.OnPrimaryClipChangedListener listener;
        private final ClipboardManager maybeClipboardManager;
        private boolean isListening = true;
        private long timestamp = -1;

        public ClipboardEventEmitter() {
            Object objM12684constructorimpl;
            this.listener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: expo.modules.clipboard.ClipboardModule$ClipboardEventEmitter$$ExternalSyntheticLambda1
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ClipboardModule.ClipboardEventEmitter.listener$lambda$7(clipboardModule, this);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                ClipboardEventEmitter clipboardEventEmitter = this;
                objM12684constructorimpl = Result.m12684constructorimpl(ClipboardModule.this.getClipboardManager());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            this.maybeClipboardManager = (ClipboardManager) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        }

        public final void resumeListening() {
            this.isListening = true;
        }

        public final void pauseListening() {
            this.isListening = false;
        }

        public final Object attachListener() {
            Unit unit;
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager != null) {
                clipboardManager.addPrimaryClipChangedListener(this.listener);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit == null ? Integer.valueOf(Log.e(ClipboardModuleKt.TAG, "'CLIPBOARD_SERVICE' unavailable. Events won't be received")) : unit;
        }

        public final Unit detachListener() {
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager == null) {
                return null;
            }
            clipboardManager.removePrimaryClipChangedListener(this.listener);
            return Unit.INSTANCE;
        }

        static final void listener$lambda$7(ClipboardModule clipboardModule, ClipboardEventEmitter clipboardEventEmitter) {
            ClipDescription primaryClipDescription;
            if (clipboardModule.getAppContext().getHasActiveReactInstance()) {
                ClipboardManager clipboardManager = clipboardEventEmitter.maybeClipboardManager;
                if (!clipboardEventEmitter.isListening) {
                    clipboardManager = null;
                }
                if (clipboardManager == null || (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    if (clipboardEventEmitter.timestamp == primaryClipDescription.getTimestamp()) {
                        return;
                    } else {
                        clipboardEventEmitter.timestamp = primaryClipDescription.getTimestamp();
                    }
                }
                Pair[] pairArr = new Pair[1];
                ContentType[] contentTypeArr = new ContentType[3];
                ContentType contentType = ContentType.PLAIN_TEXT;
                if (!ClipboardModuleKt.getHasTextContent(primaryClipDescription)) {
                    contentType = null;
                }
                contentTypeArr[0] = contentType;
                ContentType contentType2 = ContentType.HTML;
                if (!primaryClipDescription.hasMimeType("text/html")) {
                    contentType2 = null;
                }
                contentTypeArr[1] = contentType2;
                contentTypeArr[2] = primaryClipDescription.hasMimeType("image/*") ? ContentType.IMAGE : null;
                List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) contentTypeArr);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOfNotNull, 10));
                Iterator it = listListOfNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ContentType) it.next()).getJsName());
                }
                pairArr[0] = TuplesKt.to("contentTypes", arrayList);
                clipboardModule.sendEvent(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME, BundleKt.bundleOf(pairArr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean clipboardHasItemWithType(String mimeType) {
        ClipDescription primaryClipDescription = getClipboardManager().getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType(mimeType);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipData.Item getFirstItem(ClipboardManager clipboardManager) {
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null) {
            if (primaryClip.getItemCount() <= 0) {
                primaryClip = null;
            }
            if (primaryClip != null) {
                return primaryClip.getItemAt(0);
            }
        }
        return null;
    }
}
