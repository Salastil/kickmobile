package expo.modules.kotlin.views;

import android.util.Log;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PropsParsingStrategy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0081\b¨\u0006\u0004"}, d2 = {"toPropsParsingStrategy", "Lexpo/modules/kotlin/views/PropsParsingStrategy;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PropsParsingStrategyKt {
    public static final /* synthetic */ <Props extends ComposeProps> PropsParsingStrategy<Props> toPropsParsingStrategy() {
        Intrinsics.reifiedOperationMarker(6, "Props");
        boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
        if (zThrowNonReifiedIsIntrospectableError) {
            Intrinsics.reifiedOperationMarker(6, "Props");
            PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            return PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(pIntrospectionDataThrowNonReifiedIntrospectionOfError));
        }
        Intrinsics.reifiedOperationMarker(4, "Props");
        Log.w("ExpoModulesCore", "Props class " + ComposeProps.class + " is not introspectable. Falling back to reflection-based props parsing, which may have performance implications. To fix this, annotate the props class with @OptimizedComposeProps.");
        Intrinsics.reifiedOperationMarker(4, "Props");
        return PropsParsingStrategy.Reflection.m11989boximpl(PropsParsingStrategy.Reflection.m11990constructorimpl(Reflection.getOrCreateKotlinClass(ComposeProps.class)));
    }
}
