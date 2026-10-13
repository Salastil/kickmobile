package com.facebook.fresco.vito.draweesupport;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitoViewInflater.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/VitoViewInflater;", "", "<init>", "()V", "inflateImageOptionsBuilder", "Lcom/facebook/fresco/vito/options/ImageOptions$Builder;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "getScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "attrs", "Landroid/content/res/TypedArray;", "attrId", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VitoViewInflater {
    public static final VitoViewInflater INSTANCE = new VitoViewInflater();

    private VitoViewInflater() {
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0139 A[PHI: r4 r7 r10
      0x0139: PHI (r4v9 boolean) = (r4v7 boolean), (r4v7 boolean), (r4v17 boolean), (r4v17 boolean) binds: [B:78:0x0150, B:79:0x0152, B:62:0x0134, B:63:0x0136] A[DONT_GENERATE, DONT_INLINE]
      0x0139: PHI (r7v22 boolean) = (r7v20 boolean), (r7v20 boolean), (r7v28 boolean), (r7v28 boolean) binds: [B:78:0x0150, B:79:0x0152, B:62:0x0134, B:63:0x0136] A[DONT_GENERATE, DONT_INLINE]
      0x0139: PHI (r10v6 boolean) = (r10v4 boolean), (r10v4 boolean), (r10v12 boolean), (r10v12 boolean) binds: [B:78:0x0150, B:79:0x0152, B:62:0x0134, B:63:0x0136] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmStatic
    public static final ImageOptions.Builder inflateImageOptionsBuilder(Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            return ImageOptions.INSTANCE.create();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.facebook.drawee.R.styleable.GenericDraweeHierarchy);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            ImageOptions.Builder builderCreate = ImageOptions.INSTANCE.create();
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int i = 0;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_actualImageScaleType) {
                    builderCreate.scale(INSTANCE.getScaleType(typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImage) {
                    builderCreate.placeholder(GenericDraweeHierarchyInflater.getDrawable(context, typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImage) {
                    AutoRotateDrawable drawable = INSTANCE.getDrawable(context, typedArrayObtainStyledAttributes, index);
                    if (drawable != null) {
                        int integer = typedArrayObtainStyledAttributes.getInteger(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval, i);
                        if (integer > 0) {
                            drawable = new AutoRotateDrawable(drawable, integer);
                        }
                        builderCreate.progress(drawable);
                    }
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_fadeDuration) {
                    builderCreate.fadeDurationMs(typedArrayObtainStyledAttributes.getInt(index, i));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImageScaleType) {
                    builderCreate.placeholderScaleType(INSTANCE.getScaleType(typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImage) {
                    builderCreate.errorDrawable(INSTANCE.getDrawable(context, typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImageScaleType) {
                    builderCreate.errorScaleType(INSTANCE.getScaleType(typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImageScaleType) {
                    builderCreate.progressScaleType(INSTANCE.getScaleType(typedArrayObtainStyledAttributes, index));
                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_overlayImage) {
                    builderCreate.overlay(INSTANCE.getDrawable(context, typedArrayObtainStyledAttributes, index));
                } else {
                    boolean z4 = true;
                    if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundAsCircle) {
                        builderCreate.round(RoundingOptions.INSTANCE.asCircle(true, true));
                    } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundedCornerRadius) {
                        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, i);
                        if (dimensionPixelSize > 0) {
                            float f = dimensionPixelSize;
                            boolean z5 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopLeft, true);
                            boolean z6 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopRight, true);
                            boolean z7 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomLeft, true);
                            boolean z8 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomRight, true);
                            boolean z9 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopStart, true);
                            boolean z10 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopEnd, true);
                            boolean z11 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomStart, true);
                            boolean z12 = typedArrayObtainStyledAttributes.getBoolean(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomEnd, true);
                            if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                                z = z5 && z10;
                                z2 = z6 && z9;
                                z3 = z8 && z11;
                                if (!z7 || !z12) {
                                    z4 = false;
                                }
                            } else {
                                z = z5 && z9;
                                z2 = z6 && z10;
                                z3 = z8 && z12;
                                if (!z7 || !z11) {
                                    z4 = false;
                                }
                            }
                            RoundingOptions.Companion companion = RoundingOptions.INSTANCE;
                            float f2 = z ? f : 0.0f;
                            float f3 = z2 ? f : 0.0f;
                            float f4 = z3 ? f : 0.0f;
                            if (!z4) {
                                f = 0.0f;
                            }
                            builderCreate.round(companion.forCornerRadii(f2, f3, f4, f));
                            i = 0;
                        }
                    } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderWidth) {
                        i = 0;
                        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                        if (dimensionPixelSize2 != 0.0f) {
                            builderCreate.borders(BorderOptions.Companion.create$default(BorderOptions.INSTANCE, typedArrayObtainStyledAttributes.getColor(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderColor, 0), dimensionPixelSize2, typedArrayObtainStyledAttributes.getDimensionPixelSize(com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderPadding, 0), false, 8, null));
                        }
                    } else {
                        i = 0;
                        if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImage || index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImageScaleType || index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundWithOverlayColor || index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage || index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_backgroundImage) {
                            throw new UnsupportedOperationException("Not supported for Vito");
                        }
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            return builderCreate;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final ScalingUtils.ScaleType getScaleType(TypedArray attrs, int attrId) {
        return GenericDraweeHierarchyInflater.getScaleTypeFromXml(attrs, attrId);
    }

    private final Drawable getDrawable(Context context, TypedArray attrs, int attrId) {
        return GenericDraweeHierarchyInflater.getDrawable(context, attrs, attrId);
    }
}
