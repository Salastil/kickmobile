package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.R;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.Overflow;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImportantForInteractionHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/view/ImportantForInteractionHelper;", "", "<init>", "()V", "IMPORTANT_FOR_INTERACTION_YES", "", "IMPORTANT_FOR_INTERACTION_NO", "IMPORTANT_FOR_INTERACTION_EXCLUDE_DESCENDANTS", "IMPORTANT_FOR_INTERACTION_AUTO_CSSPOINTEREVENTSAUTO", "IMPORTANT_FOR_INTERACTION_DONT_CLIP_DESCENDANTS", "setImportantForInteraction", "", "view", "Landroid/view/View;", ViewProps.POINTER_EVENTS, "Lcom/facebook/react/uimanager/PointerEvents;", ViewProps.OVERFLOW, "Lcom/facebook/react/uimanager/style/Overflow;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImportantForInteractionHelper {
    public static final int IMPORTANT_FOR_INTERACTION_AUTO_CSSPOINTEREVENTSAUTO = 8;
    public static final int IMPORTANT_FOR_INTERACTION_DONT_CLIP_DESCENDANTS = 16;
    public static final int IMPORTANT_FOR_INTERACTION_EXCLUDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_INTERACTION_NO = 2;
    public static final int IMPORTANT_FOR_INTERACTION_YES = 1;
    public static final ImportantForInteractionHelper INSTANCE = new ImportantForInteractionHelper();

    /* JADX INFO: compiled from: ImportantForInteractionHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEvents.values().length];
            try {
                iArr[PointerEvents.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEvents.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEvents.BOX_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEvents.BOX_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ImportantForInteractionHelper() {
    }

    @JvmStatic
    public static final void setImportantForInteraction(View view, PointerEvents pointerEvents, Overflow overflow) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
        Intrinsics.checkNotNullParameter(overflow, "overflow");
        if (ReactNativeFeatureFlags.syncAndroidClipBoundsWithOverflow()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
            if (i2 != 1) {
                i = 2;
                if (i2 == 2) {
                    i = 6;
                } else if (i2 == 3) {
                    i = 12;
                } else if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i = 8;
            }
            view.setTag(R.id.important_for_interaction, Integer.valueOf((overflow == Overflow.VISIBLE ? 16 : 0) | i));
        }
    }
}
