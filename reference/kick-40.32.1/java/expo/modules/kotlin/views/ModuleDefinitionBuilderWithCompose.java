package expo.modules.kotlin.views;

import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.modules.InternalModuleDefinitionBuilder;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J^\u0010\u0006\u001a\u00020\u0007\"\u0010\b\u0000\u0010\b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u001f\b\u0002\u0010\u000e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012JD\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0017\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012Ju\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u001123\b\b\u0010\u001a\u001a-\u0012\u0004\u0012\u00020\u001c\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\u001d\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u001f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "Lexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "<init>", "(Lexpo/modules/kotlin/modules/Module;)V", "View", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/views/ExpoComposeView;", "P", "Lexpo/modules/kotlin/views/ComposeProps;", "viewClass", "Lkotlin/reflect/KClass;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "ComposeView", "Props", "name", "", "block", "Lexpo/modules/kotlin/views/ComposeViewBuilderScope;", "events", "Lexpo/modules/kotlin/views/ComposeViewEventDefinitionBuilder;", "viewFunction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "Landroidx/compose/runtime/Composable;", "ComposeViewLegacy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ModuleDefinitionBuilderWithCompose extends InternalModuleDefinitionBuilder {
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ModuleDefinitionBuilderWithCompose() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModuleDefinitionBuilderWithCompose(Module module) {
        super(module, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ModuleDefinitionBuilderWithCompose(Module module, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : module);
    }

    public static /* synthetic */ void ComposeView$default(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, KClass viewClass, Function1 body, int i, Object obj) {
        Object objM12684constructorimpl;
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: View");
        }
        if ((i & 2) != 0) {
            Intrinsics.needClassReification();
            body = ModuleDefinitionBuilderWithCompose$View$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleDefinitionBuilderWithCompose$View$$inlined$typeDescriptorOf$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(viewClass, typeDescriptor, null, 4, null);
        Intrinsics.reifiedOperationMarker(6, "P");
        boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
        if (zThrowNonReifiedIsIntrospectableError) {
            Intrinsics.reifiedOperationMarker(6, "P");
            PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            reflectionM11989boximpl = PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(pIntrospectionDataThrowNonReifiedIntrospectionOfError));
        } else {
            Intrinsics.reifiedOperationMarker(4, "P");
            Log.w("ExpoModulesCore", "Props class " + ComposeProps.class + " is not introspectable. Falling back to reflection-based props parsing, which may have performance implications. To fix this, annotate the props class with @OptimizedComposeProps.");
            Intrinsics.reifiedOperationMarker(4, "P");
            reflectionM11989boximpl = PropsParsingStrategy.Reflection.m11989boximpl(PropsParsingStrategy.Reflection.m11990constructorimpl(Reflection.getOrCreateKotlinClass(ComposeProps.class)));
        }
        for (ComposeViewProp composeViewProp : reflectionM11989boximpl.unwrappedProps().values()) {
            viewDefinitionBuilder.getProps().put(composeViewProp.getName(), composeViewProp);
        }
        CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
        body.invoke(viewDefinitionBuilder);
        moduleDefinitionBuilderWithCompose.registerViewDefinition(viewDefinitionBuilder.build());
    }

    public final /* synthetic */ <Props extends ComposeProps> void ComposeView(String name, Function1<? super ComposeViewBuilderScope<Props>, Unit> block) {
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.reifiedOperationMarker(6, "Props");
        boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
        if (zThrowNonReifiedIsIntrospectableError) {
            Intrinsics.reifiedOperationMarker(6, "Props");
            PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            reflectionM11989boximpl = PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(pIntrospectionDataThrowNonReifiedIntrospectionOfError));
        } else {
            Intrinsics.reifiedOperationMarker(4, "Props");
            Log.w("ExpoModulesCore", "Props class " + ComposeProps.class + " is not introspectable. Falling back to reflection-based props parsing, which may have performance implications. To fix this, annotate the props class with @OptimizedComposeProps.");
            Intrinsics.reifiedOperationMarker(4, "Props");
            reflectionM11989boximpl = PropsParsingStrategy.Reflection.m11989boximpl(PropsParsingStrategy.Reflection.m11990constructorimpl(Reflection.getOrCreateKotlinClass(ComposeProps.class)));
        }
        ComposeViewBuilderScope composeViewBuilderScope = new ComposeViewBuilderScope(name, reflectionM11989boximpl);
        block.invoke(composeViewBuilderScope);
        registerViewDefinition(composeViewBuilderScope.build());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the View<Props>(name) { ... Content { props -> ... } } builder-scope DSL. Declare events via `val onX by Event<T>()`.")
    public final /* synthetic */ <Props extends ComposeProps> void ComposeViewLegacy(String name, Function1<? super ComposeViewEventDefinitionBuilder, Unit> events, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> viewFunction) {
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        ComposeViewEventDefinitionBuilder composeViewEventDefinitionBuilder = new ComposeViewEventDefinitionBuilder();
        events.invoke(composeViewEventDefinitionBuilder);
        Intrinsics.reifiedOperationMarker(6, "Props");
        boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
        if (zThrowNonReifiedIsIntrospectableError) {
            Intrinsics.reifiedOperationMarker(6, "Props");
            PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            reflectionM11989boximpl = PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(pIntrospectionDataThrowNonReifiedIntrospectionOfError));
        } else {
            Intrinsics.reifiedOperationMarker(4, "Props");
            Log.w("ExpoModulesCore", "Props class " + ComposeProps.class + " is not introspectable. Falling back to reflection-based props parsing, which may have performance implications. To fix this, annotate the props class with @OptimizedComposeProps.");
            Intrinsics.reifiedOperationMarker(4, "Props");
            reflectionM11989boximpl = PropsParsingStrategy.Reflection.m11989boximpl(PropsParsingStrategy.Reflection.m11990constructorimpl(Reflection.getOrCreateKotlinClass(ComposeProps.class)));
        }
        registerViewDefinition(new ComposeViewFunctionDefinitionBuilder(name, reflectionM11989boximpl, viewFunction, composeViewEventDefinitionBuilder).build());
    }

    public final /* synthetic */ <T extends ExpoComposeView<P>, P extends ComposeProps> void ComposeView(KClass<T> viewClass, Function1<? super ViewDefinitionBuilder<T>, Unit> body) {
        Object objM12684constructorimpl;
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleDefinitionBuilderWithCompose$View$$inlined$typeDescriptorOf$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(viewClass, typeDescriptor, null, 4, null);
        Intrinsics.reifiedOperationMarker(6, "P");
        boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
        if (zThrowNonReifiedIsIntrospectableError) {
            Intrinsics.reifiedOperationMarker(6, "P");
            PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            reflectionM11989boximpl = PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(pIntrospectionDataThrowNonReifiedIntrospectionOfError));
        } else {
            Intrinsics.reifiedOperationMarker(4, "P");
            Log.w("ExpoModulesCore", "Props class " + ComposeProps.class + " is not introspectable. Falling back to reflection-based props parsing, which may have performance implications. To fix this, annotate the props class with @OptimizedComposeProps.");
            Intrinsics.reifiedOperationMarker(4, "P");
            reflectionM11989boximpl = PropsParsingStrategy.Reflection.m11989boximpl(PropsParsingStrategy.Reflection.m11990constructorimpl(Reflection.getOrCreateKotlinClass(ComposeProps.class)));
        }
        for (ComposeViewProp composeViewProp : reflectionM11989boximpl.unwrappedProps().values()) {
            viewDefinitionBuilder.getProps().put(composeViewProp.getName(), composeViewProp);
        }
        CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
        body.invoke(viewDefinitionBuilder);
        registerViewDefinition(viewDefinitionBuilder.build());
    }
}
