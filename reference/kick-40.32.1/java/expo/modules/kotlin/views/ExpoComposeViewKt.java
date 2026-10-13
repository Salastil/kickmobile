package expo.modules.kotlin.views;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a@\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0001*\u0002H\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"ComposableScope", "Lexpo/modules/kotlin/views/ComposableScope;", "withIf", ExifInterface.GPS_DIRECTION_TRUE, "condition", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lexpo/modules/kotlin/views/ComposableScope;ZLkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/views/ComposableScope;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ExpoComposeViewKt {
    public static final ComposableScope ComposableScope() {
        return EmptyComposableScope.INSTANCE;
    }

    public static final <T extends ComposableScope> T withIf(T t, boolean z, Function1<? super T, ? extends T> block) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return z ? block.invoke(t) : t;
    }
}
