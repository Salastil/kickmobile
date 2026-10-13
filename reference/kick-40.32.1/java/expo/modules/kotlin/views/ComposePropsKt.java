package expo.modules.kotlin.views;

import android.util.Log;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expo.modules.kotlin.types.ConverterContext;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ComposeProps.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"createComposeProps", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "propsMap", "Lcom/facebook/react/bridge/ReadableMap;", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/types/ConverterContext;)Lexpo/modules/kotlin/views/ComposeProps;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ComposePropsKt {
    public static final /* synthetic */ <Props extends ComposeProps> Props createComposeProps(ReadableMap readableMap, ConverterContext converterContext) {
        PropsParsingStrategy.Reflection reflectionM11989boximpl;
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
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
        Props props = (Props) reflectionM11989boximpl.createNewInstance();
        if (readableMap == null) {
            return props;
        }
        Map<String, ComposeViewProp> mapProps = reflectionM11989boximpl.props();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            ComposeViewProp composeViewProp = mapProps.get(strNextKey);
            if (composeViewProp != null) {
                Dynamic dynamic = readableMap.getDynamic(strNextKey);
                try {
                    Object objCopyPropsWithNewValue = composeViewProp.copyPropsWithNewValue(dynamic, props, converterContext);
                    if (objCopyPropsWithNewValue != null) {
                        props = (Props) objCopyPropsWithNewValue;
                    }
                    Intrinsics.reifiedOperationMarker(1, "Props");
                    props = props;
                    Unit unit = Unit.INSTANCE;
                    dynamic.recycle();
                } catch (Throwable th) {
                    dynamic.recycle();
                    throw th;
                }
            }
        }
        return props;
    }
}
