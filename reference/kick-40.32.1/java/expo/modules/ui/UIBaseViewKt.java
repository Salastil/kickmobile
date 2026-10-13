package expo.modules.ui;

import android.util.Log;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.ComposeViewBuilderScope;
import expo.modules.kotlin.views.ModuleDefinitionBuilderWithCompose;
import expo.modules.kotlin.views.PropsParsingStrategy;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UIBaseView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"ExpoUIView", "", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "name", "", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ComposeViewBuilderScope;", "Lkotlin/ExtensionFunctionType;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UIBaseViewKt {
    public static final /* synthetic */ <Props extends ComposeProps> void ExpoUIView(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, String name, Function1<? super ComposeViewBuilderScope<Props>, Unit> block) {
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilderWithCompose, "<this>");
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
        moduleDefinitionBuilderWithCompose.registerViewDefinition(composeViewBuilderScope.build());
    }
}
