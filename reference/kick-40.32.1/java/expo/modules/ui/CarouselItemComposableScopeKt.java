package expo.modules.ui;

import androidx.compose.material3.carousel.CarouselItemScope;
import expo.modules.kotlin.views.ComposableScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CarouselItemComposableScope.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"carouselItemScope", "Landroidx/compose/material3/carousel/CarouselItemScope;", "Lexpo/modules/kotlin/views/ComposableScope;", "getCarouselItemScope$annotations", "(Lexpo/modules/kotlin/views/ComposableScope;)V", "getCarouselItemScope", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/material3/carousel/CarouselItemScope;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CarouselItemComposableScopeKt {
    public static /* synthetic */ void getCarouselItemScope$annotations(ComposableScope composableScope) {
    }

    public static final CarouselItemScope getCarouselItemScope(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        CarouselItemComposableScope carouselItemComposableScope = composableScope instanceof CarouselItemComposableScope ? (CarouselItemComposableScope) composableScope : null;
        if (carouselItemComposableScope != null) {
            return carouselItemComposableScope.getCarouselItemScope();
        }
        return null;
    }
}
