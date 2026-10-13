package com.datadog.android.internal.utils;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/internal/utils/ImageViewUtils;", "", "()V", "calculateClipping", "Landroid/graphics/Rect;", "parentRect", "childRect", "density", "", "positionRectAtEnd", "positionRectAtStart", "positionRectInCenter", "resolveContentRectWithScaling", "imageView", "Landroid/widget/ImageView;", "drawable", "Landroid/graphics/drawable/Drawable;", "customScaleType", "Landroid/widget/ImageView$ScaleType;", "resolveParentRectAbsPosition", "view", "Landroid/view/View;", "cropToPadding", "", "scaleRectToCenterCrop", "scaleRectToCenterInsideParent", "scaleRectToFitParent", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageViewUtils {
    public static final ImageViewUtils INSTANCE = new ImageViewUtils();

    /* JADX INFO: compiled from: ImageViewUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ImageViewUtils() {
    }

    public static /* synthetic */ Rect resolveParentRectAbsPosition$default(ImageViewUtils imageViewUtils, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return imageViewUtils.resolveParentRectAbsPosition(view, z);
    }

    public final Rect resolveParentRectAbsPosition(View view, boolean cropToPadding) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int paddingLeft = cropToPadding ? view.getPaddingLeft() : 0;
        int paddingRight = cropToPadding ? view.getPaddingRight() : 0;
        int paddingTop = cropToPadding ? view.getPaddingTop() : 0;
        int paddingBottom = cropToPadding ? view.getPaddingBottom() : 0;
        int i = iArr[0];
        return new Rect(paddingLeft + i, iArr[1] + paddingTop, (i + view.getWidth()) - paddingRight, (iArr[1] + view.getHeight()) - paddingBottom);
    }

    public final Rect calculateClipping(Rect parentRect, Rect childRect, float density) {
        Intrinsics.checkNotNullParameter(parentRect, "parentRect");
        Intrinsics.checkNotNullParameter(childRect, "childRect");
        return new Rect(IntExtKt.densityNormalized(childRect.left < parentRect.left ? parentRect.left - childRect.left : 0, density), IntExtKt.densityNormalized(childRect.top < parentRect.top ? parentRect.top - childRect.top : 0, density), IntExtKt.densityNormalized(childRect.right > parentRect.right ? childRect.right - parentRect.right : 0, density), IntExtKt.densityNormalized(childRect.bottom > parentRect.bottom ? childRect.bottom - parentRect.bottom : 0, density));
    }

    public static /* synthetic */ Rect resolveContentRectWithScaling$default(ImageViewUtils imageViewUtils, ImageView imageView, Drawable drawable, ImageView.ScaleType scaleType, int i, Object obj) {
        if ((i & 4) != 0) {
            scaleType = null;
        }
        return imageViewUtils.resolveContentRectWithScaling(imageView, drawable, scaleType);
    }

    public final Rect resolveContentRectWithScaling(ImageView imageView, Drawable drawable, ImageView.ScaleType customScaleType) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Rect rectResolveParentRectAbsPosition$default = resolveParentRectAbsPosition$default(this, imageView, false, 2, null);
        Rect rect = new Rect(0, 0, intrinsicWidth, intrinsicHeight);
        if (customScaleType == null) {
            customScaleType = imageView.getScaleType();
        }
        switch (customScaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[customScaleType.ordinal()]) {
            case -1:
            case 7:
            case 8:
                return new Rect(rectResolveParentRectAbsPosition$default.left, rectResolveParentRectAbsPosition$default.top, rectResolveParentRectAbsPosition$default.right, rectResolveParentRectAbsPosition$default.bottom);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return positionRectAtStart(rectResolveParentRectAbsPosition$default, scaleRectToFitParent(rectResolveParentRectAbsPosition$default, rect));
            case 2:
                return positionRectAtEnd(rectResolveParentRectAbsPosition$default, scaleRectToFitParent(rectResolveParentRectAbsPosition$default, rect));
            case 3:
                return positionRectInCenter(rectResolveParentRectAbsPosition$default, scaleRectToFitParent(rectResolveParentRectAbsPosition$default, rect));
            case 4:
                return positionRectInCenter(rectResolveParentRectAbsPosition$default, scaleRectToCenterInsideParent(rectResolveParentRectAbsPosition$default, rect));
            case 5:
                return positionRectInCenter(rectResolveParentRectAbsPosition$default, rect);
            case 6:
                return positionRectInCenter(rectResolveParentRectAbsPosition$default, scaleRectToCenterCrop(rectResolveParentRectAbsPosition$default, rect));
        }
    }

    private final Rect scaleRectToCenterInsideParent(Rect parentRect, Rect childRect) {
        if (parentRect.width() > childRect.width() && parentRect.height() > childRect.height()) {
            return childRect;
        }
        float fMin = Math.min(parentRect.width() / childRect.width(), parentRect.height() / childRect.height());
        if (fMin >= 1.0f) {
            fMin = 1.0f;
        }
        float fWidth = childRect.width() * fMin;
        float fHeight = childRect.height() * fMin;
        Rect rect = new Rect();
        rect.left = parentRect.left;
        rect.top = parentRect.top;
        rect.right = rect.left + ((int) fWidth);
        rect.bottom = rect.top + ((int) fHeight);
        return rect;
    }

    private final Rect scaleRectToCenterCrop(Rect parentRect, Rect childRect) {
        float fMax = Math.max(parentRect.width() / childRect.width(), parentRect.height() / childRect.height());
        float fWidth = childRect.width() * fMax;
        float fHeight = childRect.height() * fMax;
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = (int) fWidth;
        rect.bottom = (int) fHeight;
        return rect;
    }

    private final Rect scaleRectToFitParent(Rect parentRect, Rect childRect) {
        float fMin = Math.min(parentRect.width() / childRect.width(), parentRect.height() / childRect.height());
        float fWidth = childRect.width() * fMin;
        float fHeight = childRect.height() * fMin;
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = (int) fWidth;
        rect.bottom = (int) fHeight;
        return rect;
    }

    private final Rect positionRectInCenter(Rect parentRect, Rect childRect) {
        int iCenterX = parentRect.centerX();
        int iCenterY = parentRect.centerY();
        int iWidth = childRect.width();
        int iHeight = childRect.height();
        Rect rect = new Rect();
        rect.left = iCenterX - (iWidth / 2);
        rect.top = iCenterY - (iHeight / 2);
        rect.right = rect.left + iWidth;
        rect.bottom = rect.top + iHeight;
        return rect;
    }

    private final Rect positionRectAtStart(Rect parentRect, Rect childRect) {
        int iWidth = childRect.width();
        int iHeight = childRect.height();
        Rect rect = new Rect();
        rect.left = parentRect.left;
        rect.top = parentRect.top;
        rect.right = rect.left + iWidth;
        rect.bottom = rect.top + iHeight;
        return rect;
    }

    private final Rect positionRectAtEnd(Rect parentRect, Rect childRect) {
        int iWidth = childRect.width();
        int iHeight = childRect.height();
        Rect rect = new Rect();
        rect.right = parentRect.right;
        rect.bottom = parentRect.bottom;
        rect.left = parentRect.right - iWidth;
        rect.top = parentRect.bottom - iHeight;
        return rect;
    }
}
