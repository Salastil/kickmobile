package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J\r\u0010 \u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010 \u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010\u0011J\r\u0010\"\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u0011J'\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010+J/\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010.J9\u0010$\u001a\u00020%2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020*2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u00102J7\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u00104JK\u00105\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:H\u0007¢\u0006\u0002\u0010;JU\u00105\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:2\b\b\u0002\u0010<\u001a\u00020*H\u0007¢\u0006\u0002\u0010=JS\u00105\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:H\u0007¢\u0006\u0002\u0010>J]\u00105\u001a\u00020%2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020*2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:H\u0007¢\u0006\u0002\u0010?J[\u00105\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010@JK\u0010A\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010:H\u0007¢\u0006\u0002\u0010;R\u0018\u0010\u0012\u001a\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010B\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0013\u0010G\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bH\u0010ER\u0013\u0010I\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bJ\u0010ER\u0013\u0010K\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bL\u0010ER\u0013\u0010M\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bN\u0010ER\u0013\u0010O\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bP\u0010ER\u0013\u0010Q\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bR\u0010ER\u0013\u0010S\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bT\u0010ER\u0013\u0010U\u001a\u00020C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bV\u0010E¨\u0006W"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "<init>", "()V", "topAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "topAppBarColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "centerAlignedTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "isScrollingContentAtStart", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "enterAlwaysScrollBehavior", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "reverseLayout", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "TopAppBarExpandedHeight", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithoutSubtitleExpandedHeight", "getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithSubtitleExpandedHeight", "getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithoutSubtitleExpandedHeight", "getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithSubtitleExpandedHeight", "getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();
    private static final PaddingValues ContentPadding = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
    private static final float TopAppBarExpandedHeight = AppBarSmallTokens.INSTANCE.m5540getContainerHeightD9Ej5fM();
    private static final float MediumAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m5540getContainerHeightD9Ej5fM();
    private static final float MediumAppBarExpandedHeight = AppBarMediumTokens.INSTANCE.m5539getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m5537getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m5538getLargeContainerHeightD9Ej5fM();
    private static final float LargeAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m5540getContainerHeightD9Ej5fM();
    private static final float LargeAppBarExpandedHeight = AppBarLargeTokens.INSTANCE.m5536getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m5534getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m5535getLargeContainerHeightD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$2$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$4$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$6$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$8$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$9$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean exitUntilCollapsedScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$2$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$4$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$6$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$7$0() {
        return true;
    }

    private TopAppBarDefaults() {
    }

    public final TopAppBarColors topAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1388520854, "C(topAppBarColors)1404@71709L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388520854, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1404)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public final TopAppBarColors m5199topAppBarColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1325733438, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color)1427@72893L11:AppBar.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1325733438, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1427)");
        }
        TopAppBarColors topAppBarColorsM5176copytNS2XkQ = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m5176copytNS2XkQ(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM7374getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM5176copytNS2XkQ;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility in favor of topAppBarColors with subtitleContentColor")
    /* JADX INFO: renamed from: topAppBarColors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ TopAppBarColors m5200topAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2142919275, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1459@74317L367:AppBar.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2142919275, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1459)");
        }
        TopAppBarColors topAppBarColorsM5199topAppBarColors5tl4gsc = m5199topAppBarColors5tl4gsc(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM7374getUnspecified0d7_KjU4, composer, (65534 & i) | ((i << 6) & 458752) | ((i << 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM5199topAppBarColors5tl4gsc;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme colorScheme) {
        TopAppBarColors defaultTopAppBarColorsCached = colorScheme.getDefaultTopAppBarColorsCached();
        if (defaultTopAppBarColorsCached != null) {
            return defaultTopAppBarColorsCached;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getOnScrollContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTitleColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getSubtitleColor()), null);
        colorScheme.setDefaultTopAppBarColorsCached$material3(topAppBarColors);
        return topAppBarColors;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2143182847, "C(<get-windowInsets>)1489@75757L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1489)");
        }
        WindowInsets windowInsetsM2445onlybOOhFvg = WindowInsetsKt.m2445onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m2457plusgK_yJZ4(WindowInsetsSides.INSTANCE.m2467getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m2471getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM2445onlybOOhFvg;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors centerAlignedTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 513940029, "C(centerAlignedTopAppBarColors)1503@76301L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(513940029, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1503)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: centerAlignedTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m5187centerAlignedTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1896017784, "C(centerAlignedTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1533@77702L11:AppBar.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1533)");
        }
        TopAppBarColors topAppBarColorsM5174copytNS2XkQ$default = TopAppBarColors.m5174copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM5174copytNS2XkQ$default;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors mediumTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1268886463, "C(mediumTopAppBarColors)1552@78373L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1268886463, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1552)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: mediumTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m5198mediumTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -582474442, "C(mediumTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1583@79798L11:AppBar.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1583)");
        }
        TopAppBarColors topAppBarColorsM5174copytNS2XkQ$default = TopAppBarColors.m5174copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM5174copytNS2XkQ$default;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors largeTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1744932393, "C(largeTopAppBarColors)1602@80467L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1744932393, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1602)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: largeTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m5197largeTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1471507700, "C(largeTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1633@81890L11:AppBar.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1633)");
        }
        TopAppBarColors topAppBarColorsM5174copytNS2XkQ$default = TopAppBarColors.m5174copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM5174copytNS2XkQ$default;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Function0<Boolean> function1;
        ComposerKt.sourceInformationMarkerStart(composer, 286497075, "C(pinnedScrollBehavior)N(state,canScroll)1656@83005L24,1657@83066L8,1659@83117L89:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 445785947, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$0$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function1 = (Function0) objRememberedValue;
        } else {
            function1 = function0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1659)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 445787660, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(topAppBarState2)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(topAppBarState2, function1, null, 4, null);
            composer.updateRememberedValue(pinnedScrollBehavior);
            objRememberedValue2 = pinnedScrollBehavior;
        }
        PinnedScrollBehavior pinnedScrollBehavior2 = (PinnedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pinnedScrollBehavior2;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(LazyListState lazyListState, TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -608587040, "C(pinnedScrollBehavior)N(lazyListState,state,canScroll)1684@84510L24,1685@84571L8,1688@84666L64,1692@84870L35,1689@84746L170:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -736588152, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$2$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        Function0<Boolean> function1 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-608587040, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1686)");
        }
        final State stateRememberIsScrollingContentAtStart = AppBarKt.rememberIsScrollingContentAtStart(lazyListState, composer2, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer2, -736578557, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = composer2.changed(stateRememberIsScrollingContentAtStart);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$3$0(stateRememberIsScrollingContentAtStart));
                }
            };
            composer2.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Composer composer3 = composer2;
        TopAppBarScrollBehavior topAppBarScrollBehaviorPinnedScrollBehavior = pinnedScrollBehavior(topAppBarState2, function1, (Function0<Boolean>) objRememberedValue2, composer3, ((i >> 3) & WebSocketProtocol.PAYLOAD_SHORT) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        return topAppBarScrollBehaviorPinnedScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$3$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(ScrollState scrollState, boolean z, TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -209339169, "C(pinnedScrollBehavior)N(scrollState,reverseScrolling,state,canScroll)1719@86217L24,1720@86278L8,1723@86373L144,1730@86657L35,1727@86533L170:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 688527783, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$4$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function0<Boolean> function1 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-209339169, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1721)");
        }
        final State stateRememberIsScrollingContentAtStart = AppBarKt.rememberIsScrollingContentAtStart(scrollState, z, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        ComposerKt.sourceInformationMarkerStart(composer, 688539938, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = composer.changed(stateRememberIsScrollingContentAtStart);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$5$0(stateRememberIsScrollingContentAtStart));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TopAppBarScrollBehavior topAppBarScrollBehaviorPinnedScrollBehavior = pinnedScrollBehavior(topAppBarState2, function1, (Function0<Boolean>) objRememberedValue2, composer, ((i >> 6) & WebSocketProtocol.PAYLOAD_SHORT) | ((i >> 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarScrollBehaviorPinnedScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$5$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, Function0<Boolean> function1, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -231982721, "C(pinnedScrollBehavior)N(state,canScroll,isScrollingContentAtStart)1757@88084L24,1758@88145L8,1759@88206L8,1761@88264L254:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 402908327, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$6$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 402910279, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$7$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-231982721, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1760)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 402912381, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer2.changed(function1)) || (i & 384) == 256);
        Object objRememberedValue3 = composer2.rememberedValue();
        if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new PinnedScrollBehavior(topAppBarState, function0, function1);
            composer2.updateRememberedValue(objRememberedValue3);
        }
        PinnedScrollBehavior pinnedScrollBehavior = (PinnedScrollBehavior) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return pinnedScrollBehavior;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Function0<Boolean> function1;
        ComposerKt.sourceInformationMarkerStart(composer, 959086674, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1792@89991L24,1793@90052L8,1794@90150L7,1795@90216L26,1797@90285L312:AppBar.kt#uh7d8r");
        TopAppBarState topAppBarStateRememberTopAppBarState = (i2 & 1) != 0 ? AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7) : topAppBarState;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1735670950, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$0$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function1 = (Function0) objRememberedValue;
        } else {
            function1 = function0;
        }
        AnimationSpec<Float> animationSpecValue = (i2 & 4) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1797)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1735663190, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(topAppBarStateRememberTopAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32) | composer.changed(animationSpecValue) | composer.changed(decayAnimationSpecRememberSplineBasedDecay);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarStateRememberTopAppBarState, animationSpecValue, decayAnimationSpecRememberSplineBasedDecay, function1, null, 16, null);
            composer.updateRememberedValue(enterAlwaysScrollBehavior);
            objRememberedValue2 = enterAlwaysScrollBehavior;
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior2 = (EnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterAlwaysScrollBehavior2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the enterAlwaysScrollBehavior() function that takes lazyListState or scrollState parameters.", replaceWith = @ReplaceWith(expression = "enterAlwaysScrollBehavior(lazyListState, state, canScroll, snapAnimationSpec, flingAnimationSpec)", imports = {}))
    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, boolean z, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 53729710, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1837@92386L24,1838@92447L8,1839@92545L7,1840@92611L26,1843@92720L380:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 94647734, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$2$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(53729710, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1843)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 94656842, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec) | ((((57344 & i) ^ 24576) > 16384 && composer2.changed(z)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            boolean z2 = z;
            LegacyEnterAlwaysScrollBehavior legacyEnterAlwaysScrollBehavior = new LegacyEnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0, z2);
            composer2.updateRememberedValue(legacyEnterAlwaysScrollBehavior);
            objRememberedValue2 = legacyEnterAlwaysScrollBehavior;
        }
        LegacyEnterAlwaysScrollBehavior legacyEnterAlwaysScrollBehavior2 = (LegacyEnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return legacyEnterAlwaysScrollBehavior2;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(LazyListState lazyListState, TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1173138683, "C(enterAlwaysScrollBehavior)N(lazyListState,state,canScroll,snapAnimationSpec,flingAnimationSpec)1880@94779L24,1881@94840L8,1882@94938L7,1883@95004L26,1886@95117L64,1892@95430L35,1887@95197L279:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -2104837619, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$4$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function0<Boolean> function1 = function0;
        if ((i2 & 8) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
        }
        if ((i2 & 16) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1173138683, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1884)");
        }
        final State stateRememberIsScrollingContentAtStart = AppBarKt.rememberIsScrollingContentAtStart(lazyListState, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -2104818712, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = composer.changed(stateRememberIsScrollingContentAtStart);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$5$0(stateRememberIsScrollingContentAtStart));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TopAppBarScrollBehavior topAppBarScrollBehaviorEnterAlwaysScrollBehavior = enterAlwaysScrollBehavior(topAppBarState2, function1, animationSpec, decayAnimationSpec2, (Function0<Boolean>) objRememberedValue2, composer, ((i >> 3) & 8190) | (458752 & i), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarScrollBehaviorEnterAlwaysScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$5$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(ScrollState scrollState, boolean z, TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1264911706, "C(enterAlwaysScrollBehavior)N(scrollState,reverseScrolling,state,canScroll,snapAnimationSpec,flingAnimationSpec)1930@97632L24,1931@97693L8,1932@97791L7,1933@97857L26,1936@97970L64,1942@98283L35,1937@98050L279:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -104398258, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$6$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function0<Boolean> function1 = function0;
        AnimationSpec<Float> animationSpecValue = (i2 & 16) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 32) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1264911706, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1934)");
        }
        final State stateRememberIsScrollingContentAtStart = AppBarKt.rememberIsScrollingContentAtStart(scrollState, z, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        ComposerKt.sourceInformationMarkerStart(composer, -104379351, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = composer.changed(stateRememberIsScrollingContentAtStart);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$7$0(stateRememberIsScrollingContentAtStart));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TopAppBarScrollBehavior topAppBarScrollBehaviorEnterAlwaysScrollBehavior = enterAlwaysScrollBehavior(topAppBarState2, function1, animationSpecValue, decayAnimationSpecRememberSplineBasedDecay, (Function0<Boolean>) objRememberedValue2, composer, ((i >> 6) & 8190) | ((i >> 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarScrollBehaviorEnterAlwaysScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$7$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function0<Boolean> function1, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -608172578, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec,isScrollingContentAtStart)1973@100091L24,1974@100152L8,1975@100250L7,1976@100316L26,1977@100395L8,1979@100446L383:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -338291226, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$8$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if ((i2 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -338283450, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$9$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-608172578, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1979)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -338281443, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec);
        Object objRememberedValue3 = composer2.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            Function0<Boolean> function2 = function1;
            DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
            EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec2, function0, function2);
            composer2.updateRememberedValue(enterAlwaysScrollBehavior);
            objRememberedValue3 = enterAlwaysScrollBehavior;
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior2 = (EnterAlwaysScrollBehavior) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return enterAlwaysScrollBehavior2;
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1757023234, "C(exitUntilCollapsedScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)2012@102228L24,2013@102289L8,2014@102387L7,2015@102453L26,2017@102522L319:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -577176346, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.exitUntilCollapsedScrollBehavior$lambda$0$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:2017)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -577168579, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = (ExitUntilCollapsedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return exitUntilCollapsedScrollBehavior;
    }

    /* JADX INFO: renamed from: getTopAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5196getTopAppBarExpandedHeightD9Ej5fM() {
        return TopAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5192getMediumAppBarCollapsedHeightD9Ej5fM() {
        return MediumAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5193getMediumAppBarExpandedHeightD9Ej5fM() {
        return MediumAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5195getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5194getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5188getLargeAppBarCollapsedHeightD9Ej5fM() {
        return LargeAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5189getLargeAppBarExpandedHeightD9Ej5fM() {
        return LargeAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5191getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m5190getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithSubtitleExpandedHeight;
    }
}
