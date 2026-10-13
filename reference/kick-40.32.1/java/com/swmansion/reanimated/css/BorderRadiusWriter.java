package com.swmansion.reanimated.css;

import android.view.View;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSPropertyWriter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/css/BorderRadiusWriter;", "Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "<init>", "()V", "setValue", "", "view", "Landroid/view/View;", "value", "", "get", "(Landroid/view/View;)Ljava/lang/Float;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class BorderRadiusWriter extends CSSPropertyWriter {
    public static final BorderRadiusWriter INSTANCE = new BorderRadiusWriter();

    private BorderRadiusWriter() {
        super(ViewProps.BORDER_RADIUS);
    }

    @Override // android.util.FloatProperty
    public void setValue(View view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderRadius(view, BorderRadiusProp.BORDER_RADIUS, new LengthPercentage(value, LengthPercentageType.POINT));
    }

    @Override // android.util.Property
    public Float get(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LengthPercentage borderRadius = BackgroundStyleApplicator.getBorderRadius(view, BorderRadiusProp.BORDER_RADIUS);
        if (borderRadius == null) {
            return Float.valueOf(0.0f);
        }
        return Float.valueOf(borderRadius.getType() == LengthPercentageType.POINT ? borderRadius.resolve(0.0f) : 0.0f);
    }
}
