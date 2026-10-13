package expo.modules.ui;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.ui.graphics.Color;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002*\"\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*&\u0010\u0004\"\b\u0012\u0004\u0012\u0002`\u00060\u00052\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00060\u0005*J\u0010\u0007\"\"\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0004\u0012\u00020\n0\b2\"\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0004\u0012\u00020\n0\b*¼\u0001\u0010\u000b\"[\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0012(\u0012&\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u00112[\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0012(\u0012&\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u0011¨\u0006\u0016"}, d2 = {"ModifierType", "", "", "Lcom/facebook/react/bridge/Dynamic;", "ModifierList", "", "Lexpo/modules/ui/ModifierType;", "ModifierEventDispatcher", "Lkotlin/Function2;", "", "", "ModifierFactory", "Lkotlin/Function4;", "Lexpo/modules/kotlin/views/ComposableScope;", "Lexpo/modules/kotlin/types/ConverterContext;", "Lexpo/modules/ui/ModifierEventDispatcher;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "parseColorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/graphics/Color;", "raw", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModifierRegistryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Color> parseColorAnimationSpec(Object obj) {
        if (!(obj instanceof Map)) {
            return null;
        }
        Map map = (Map) obj;
        Object obj2 = map.get("$type");
        if (Intrinsics.areEqual(obj2, "spring")) {
            Object obj3 = map.get("dampingRatio");
            Number number = obj3 instanceof Number ? (Number) obj3 : null;
            float fFloatValue = number != null ? number.floatValue() : 1.0f;
            Object obj4 = map.get("stiffness");
            Number number2 = obj4 instanceof Number ? (Number) obj4 : null;
            return AnimationSpecKt.spring$default(fFloatValue, number2 != null ? number2.floatValue() : 1500.0f, null, 4, null);
        }
        if (Intrinsics.areEqual(obj2, "tween")) {
            Object obj5 = map.get("durationMillis");
            Number number3 = obj5 instanceof Number ? (Number) obj5 : null;
            int iIntValue = number3 != null ? number3.intValue() : 300;
            Object obj6 = map.get("delayMillis");
            Number number4 = obj6 instanceof Number ? (Number) obj6 : null;
            return AnimationSpecKt.tween$default(iIntValue, number4 != null ? number4.intValue() : 0, null, 4, null);
        }
        if (!Intrinsics.areEqual(obj2, "snap")) {
            return null;
        }
        Object obj7 = map.get("delayMillis");
        Number number5 = obj7 instanceof Number ? (Number) obj7 : null;
        return AnimationSpecKt.snap(number5 != null ? number5.intValue() : 0);
    }
}
