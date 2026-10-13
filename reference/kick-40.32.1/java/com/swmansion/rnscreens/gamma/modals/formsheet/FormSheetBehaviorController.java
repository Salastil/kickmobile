package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FormSheetBehaviorController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0013\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0015\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0018JE\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J6\u0010#\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002J&\u0010&\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J6\u0010'\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0002J6\u0010(\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006."}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController;", "", "sheetView", "Landroid/widget/FrameLayout;", FormSheetDetentChangedEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Landroid/widget/FrameLayout;Lkotlin/jvm/functions/Function1;)V", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "kotlin.jvm.PlatformType", "currentDetentsCount", "lastEmittedDetentIndex", "bottomSheetCallback", "com/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController$bottomSheetCallback$1", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController$bottomSheetCallback$1;", "setup", "setup$react_native_screens_release", "destroy", "destroy$react_native_screens_release", "updateSheetBehavior", "detents", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDetents;", "sheetAvailableSpace", "contentHeightForFitToContents", "nativeContainerPaddingBottom", "initialDetentIndex", "applyInitialDetent", "", "updateSheetBehavior$react_native_screens_release", "configureFitToContents", "contentHeight", "bottomInset", "configureSingleDetent", "configureTwoDetents", "configureThreeDetents", "resolveStateFromIndex", "detentsCount", "mapStateToDetentIndex", "state", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetBehaviorController {
    private static final int FORM_SHEET_LAST_DETENT_INDEX = -1;
    private static final int FORM_SHEET_UNKNOWN_DETENT_INDEX = -1;
    private final BottomSheetBehavior<FrameLayout> behavior;
    private final FormSheetBehaviorController$bottomSheetCallback$1 bottomSheetCallback;
    private int currentDetentsCount;
    private int lastEmittedDetentIndex;
    private final Function1<Integer, Unit> onDetentChanged;
    private final FrameLayout sheetView;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetBehaviorController$bottomSheetCallback$1] */
    public FormSheetBehaviorController(FrameLayout sheetView, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(sheetView, "sheetView");
        this.sheetView = sheetView;
        this.onDetentChanged = function1;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(sheetView);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        this.behavior = bottomSheetBehaviorFrom;
        this.currentDetentsCount = 1;
        this.lastEmittedDetentIndex = -1;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetBehaviorController$bottomSheetCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                int iMapStateToDetentIndex = this.this$0.mapStateToDetentIndex(newState);
                if (iMapStateToDetentIndex == -1 || iMapStateToDetentIndex == this.this$0.lastEmittedDetentIndex) {
                    return;
                }
                this.this$0.lastEmittedDetentIndex = iMapStateToDetentIndex;
                Function1 function2 = this.this$0.onDetentChanged;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(iMapStateToDetentIndex));
                }
            }
        };
        bottomSheetBehaviorFrom.setHideable(true);
    }

    public /* synthetic */ FormSheetBehaviorController(FrameLayout frameLayout, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout, (i & 2) != 0 ? null : function1);
    }

    public final void setup$react_native_screens_release() {
        this.behavior.addBottomSheetCallback(this.bottomSheetCallback);
    }

    public final void destroy$react_native_screens_release() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public static /* synthetic */ void updateSheetBehavior$react_native_screens_release$default(FormSheetBehaviorController formSheetBehaviorController, FormSheetDetents formSheetDetents, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        if ((i5 & 16) != 0) {
            i4 = 0;
        }
        if ((i5 & 32) != 0) {
            z = false;
        }
        formSheetBehaviorController.updateSheetBehavior$react_native_screens_release(formSheetDetents, i, i2, i3, i4, z);
    }

    public final void updateSheetBehavior$react_native_screens_release(FormSheetDetents detents, int sheetAvailableSpace, int contentHeightForFitToContents, int nativeContainerPaddingBottom, int initialDetentIndex, boolean applyInitialDetent) {
        Intrinsics.checkNotNullParameter(detents, "detents");
        this.currentDetentsCount = detents.getCount$react_native_screens_release();
        if (sheetAvailableSpace <= 0) {
            return;
        }
        if (detents.isFitToContents$react_native_screens_release()) {
            configureFitToContents(detents, sheetAvailableSpace, contentHeightForFitToContents, nativeContainerPaddingBottom);
        } else {
            int count$react_native_screens_release = detents.getCount$react_native_screens_release();
            if (count$react_native_screens_release == 1) {
                configureSingleDetent(detents, sheetAvailableSpace);
            } else if (count$react_native_screens_release == 2) {
                configureTwoDetents(detents, sheetAvailableSpace, initialDetentIndex, applyInitialDetent);
            } else if (count$react_native_screens_release == 3) {
                configureThreeDetents(detents, sheetAvailableSpace, initialDetentIndex, applyInitialDetent);
            } else {
                throw new IllegalStateException("[RNScreens] Unsupported detent count " + detents.getCount$react_native_screens_release() + ".");
            }
        }
        this.sheetView.requestLayout();
    }

    private final BottomSheetBehavior<FrameLayout> configureFitToContents(FormSheetDetents detents, int sheetAvailableSpace, int contentHeight, int bottomInset) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.setFitToContents(true);
        bottomSheetBehavior.setMaxHeight(detents.maxAllowedHeightForFitToContents$react_native_screens_release(sheetAvailableSpace, contentHeight, bottomInset));
        bottomSheetBehavior.setState(3);
        return bottomSheetBehavior;
    }

    private final BottomSheetBehavior<FrameLayout> configureSingleDetent(FormSheetDetents detents, int sheetAvailableSpace) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.setFitToContents(true);
        bottomSheetBehavior.setMaxHeight(detents.maxAllowedHeight$react_native_screens_release(sheetAvailableSpace));
        bottomSheetBehavior.setState(3);
        return bottomSheetBehavior;
    }

    private final BottomSheetBehavior<FrameLayout> configureTwoDetents(FormSheetDetents detents, int sheetAvailableSpace, int initialDetentIndex, boolean applyInitialDetent) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(true);
        bottomSheetBehavior.setPeekHeight(detents.firstHeight$react_native_screens_release(sheetAvailableSpace));
        bottomSheetBehavior.setMaxHeight(detents.maxAllowedHeight$react_native_screens_release(sheetAvailableSpace));
        if (applyInitialDetent) {
            bottomSheetBehavior.setState(resolveStateFromIndex(initialDetentIndex, detents.getCount$react_native_screens_release()));
        }
        return bottomSheetBehavior;
    }

    private final BottomSheetBehavior<FrameLayout> configureThreeDetents(FormSheetDetents detents, int sheetAvailableSpace, int initialDetentIndex, boolean applyInitialDetent) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(false);
        bottomSheetBehavior.setPeekHeight(detents.firstHeight$react_native_screens_release(sheetAvailableSpace));
        bottomSheetBehavior.setHalfExpandedRatio(detents.halfExpandedRatio$react_native_screens_release());
        bottomSheetBehavior.setExpandedOffset(FormSheetDetents.expandedOffsetFromTop$react_native_screens_release$default(detents, sheetAvailableSpace, 0, 2, null));
        bottomSheetBehavior.setMaxHeight(detents.maxAllowedHeight$react_native_screens_release(sheetAvailableSpace));
        if (applyInitialDetent) {
            bottomSheetBehavior.setState(resolveStateFromIndex(initialDetentIndex, detents.getCount$react_native_screens_release()));
        }
        return bottomSheetBehavior;
    }

    private final int resolveStateFromIndex(int index, int detentsCount) {
        if (index == -1) {
            index = detentsCount - 1;
        }
        int iCoerceIn = RangesKt.coerceIn(index, 0, detentsCount - 1);
        if (detentsCount != 1) {
            if (detentsCount != 2) {
                if (detentsCount == 3 && iCoerceIn != 0) {
                    return iCoerceIn != 1 ? 3 : 6;
                }
                return 4;
            }
            if (iCoerceIn == 0) {
                return 4;
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int mapStateToDetentIndex(int state) {
        int i = this.currentDetentsCount;
        if (i == 1) {
            return state == 3 ? 0 : -1;
        }
        if (i == 2) {
            if (state != 3) {
                return state != 4 ? -1 : 0;
            }
            return 1;
        }
        if (i != 3) {
            return -1;
        }
        if (state == 3) {
            return 2;
        }
        if (state != 4) {
            return state != 6 ? -1 : 1;
        }
        return 0;
    }
}
