package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.utils.DimensionUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetAppearanceCoordinator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0019\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetAppearanceCoordinator;", "", "bottomSheetView", "Landroid/widget/FrameLayout;", "<init>", "(Landroid/widget/FrameLayout;)V", "currentCornerRadius", "", "currentBackgroundColor", "", "Ljava/lang/Integer;", "isCornerRadiusApplyPending", "", "isBackgroundColorApplyPending", "defaultShapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "defaultBackgroundColor", "Landroid/content/res/ColorStateList;", "isCornerRadiusSupported", "setup", "", "setup$react_native_screens_release", "updateCornerRadius", "preferredCornerRadius", "updateCornerRadius$react_native_screens_release", "applyCornerRadius", "background", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "updateBackgroundColor", "color", "updateBackgroundColor$react_native_screens_release", "(Ljava/lang/Integer;)V", "applyBackgroundColor", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetAppearanceCoordinator {
    private final FrameLayout bottomSheetView;
    private Integer currentBackgroundColor;
    private float currentCornerRadius = -1.0f;
    private ColorStateList defaultBackgroundColor;
    private ShapeAppearanceModel defaultShapeAppearanceModel;
    private boolean isBackgroundColorApplyPending;
    private boolean isCornerRadiusApplyPending;
    private final boolean isCornerRadiusSupported;

    public FormSheetAppearanceCoordinator(FrameLayout frameLayout) {
        this.bottomSheetView = frameLayout;
        this.isCornerRadiusSupported = Build.VERSION.SDK_INT >= 33;
    }

    public final void setup$react_native_screens_release() {
        FrameLayout frameLayout;
        if (this.isCornerRadiusSupported && (frameLayout = this.bottomSheetView) != null) {
            frameLayout.setClipToOutline(true);
        }
    }

    public final void updateCornerRadius$react_native_screens_release(float preferredCornerRadius) {
        if (this.isCornerRadiusSupported) {
            this.currentCornerRadius = preferredCornerRadius;
            FrameLayout frameLayout = this.bottomSheetView;
            if (frameLayout == null) {
                return;
            }
            Drawable background = frameLayout.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
            if (materialShapeDrawable != null) {
                applyCornerRadius(materialShapeDrawable);
            } else {
                if (this.isCornerRadiusApplyPending) {
                    return;
                }
                this.isCornerRadiusApplyPending = true;
                frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetAppearanceCoordinator$updateCornerRadius$$inlined$doOnNextLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        view.removeOnLayoutChangeListener(this);
                        this.this$0.isCornerRadiusApplyPending = false;
                        Drawable background2 = view.getBackground();
                        MaterialShapeDrawable materialShapeDrawable2 = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
                        if (materialShapeDrawable2 != null) {
                            this.this$0.applyCornerRadius(materialShapeDrawable2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyCornerRadius(MaterialShapeDrawable background) {
        FrameLayout frameLayout = this.bottomSheetView;
        if (frameLayout == null) {
            return;
        }
        if (this.defaultShapeAppearanceModel == null) {
            this.defaultShapeAppearanceModel = background.getShapeAppearanceModel();
        }
        float f = this.currentCornerRadius;
        if (f == -1.0f) {
            ShapeAppearanceModel shapeAppearanceModel = this.defaultShapeAppearanceModel;
            if (shapeAppearanceModel != null) {
                background.setShapeAppearanceModel(shapeAppearanceModel);
                return;
            }
            return;
        }
        float fDpToPx = DimensionUtilsKt.dpToPx(frameLayout, f);
        ShapeAppearanceModel shapeAppearanceModel2 = this.defaultShapeAppearanceModel;
        if (shapeAppearanceModel2 == null) {
            shapeAppearanceModel2 = background.getShapeAppearanceModel();
            Intrinsics.checkNotNullExpressionValue(shapeAppearanceModel2, "getShapeAppearanceModel(...)");
        }
        background.setShapeAppearanceModel(shapeAppearanceModel2.toBuilder().setTopLeftCorner(0, fDpToPx).setTopRightCorner(0, fDpToPx).build());
    }

    public final void updateBackgroundColor$react_native_screens_release(Integer color) {
        this.currentBackgroundColor = color;
        FrameLayout frameLayout = this.bottomSheetView;
        if (frameLayout == null) {
            return;
        }
        Drawable background = frameLayout.getBackground();
        MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
        if (materialShapeDrawable != null) {
            applyBackgroundColor(materialShapeDrawable);
        } else {
            if (this.isBackgroundColorApplyPending) {
                return;
            }
            this.isBackgroundColorApplyPending = true;
            frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetAppearanceCoordinator$updateBackgroundColor$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.isBackgroundColorApplyPending = false;
                    Drawable background2 = view.getBackground();
                    MaterialShapeDrawable materialShapeDrawable2 = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
                    if (materialShapeDrawable2 != null) {
                        this.this$0.applyBackgroundColor(materialShapeDrawable2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyBackgroundColor(MaterialShapeDrawable background) {
        if (this.defaultBackgroundColor == null) {
            this.defaultBackgroundColor = background.getFillColor();
        }
        Integer num = this.currentBackgroundColor;
        if (num == null) {
            background.setFillColor(this.defaultBackgroundColor);
        } else {
            background.setFillColor(ColorStateList.valueOf(num.intValue()));
        }
    }
}
