package expo.modules.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlotView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u001a\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t\u001a \u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0006\b\u0000\u0010\u000f\u0018\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"renderSlot", "", "Lexpo/modules/ui/SlotView;", "(Lexpo/modules/ui/SlotView;Landroidx/compose/runtime/Composer;I)V", "isSlotWithName", "", "view", "Lexpo/modules/kotlin/views/ExpoComposeView;", "slotName", "", "isSlotView", "findChildSlotView", "viewGroup", "Landroid/view/ViewGroup;", "findChildOfType", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/view/ViewGroup;)Ljava/lang/Object;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SlotViewKt {
    static final Unit renderSlot$lambda$2(SlotView slotView, int i, Composer composer, int i2) {
        renderSlot(slotView, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void renderSlot(final SlotView slotView, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(slotView, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(1134408277);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(renderSlot):SlotView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(slotView) : composerStartRestartGroup.changedInstance(slotView) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1134408277, i2, -1, "expo.modules.ui.renderSlot (SlotView.kt:42)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composerStartRestartGroup.startReplaceGroup(-755336712);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*43@1407L9");
            slotView.Content(uIComposableScope, composerStartRestartGroup, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SlotViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SlotViewKt.renderSlot$lambda$2(slotView, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final boolean isSlotWithName(ExpoComposeView<?> view, String slotName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        return (view instanceof SlotView) && Intrinsics.areEqual(((SlotView) view).getProps().getSlotName().getValue(), slotName);
    }

    public static final boolean isSlotView(ExpoComposeView<?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view instanceof SlotView;
    }

    public static final SlotView findChildSlotView(ViewGroup viewGroup, String slotName) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i);
            SlotView slotView = childAt instanceof SlotView ? (SlotView) childAt : null;
            if (slotView != null && Intrinsics.areEqual(slotView.getProps().getSlotName().getValue(), slotName)) {
                return slotView;
            }
            i++;
        }
    }

    public static final /* synthetic */ <T> T findChildOfType(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            T t = (T) viewGroup.getChildAt(i);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (t instanceof Object) {
                return t;
            }
        }
        return null;
    }
}
