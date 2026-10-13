package com.swmansion.reanimated.css;

import android.view.View;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSPropertyWriter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/css/BackgroundColorAccess;", "Lcom/swmansion/reanimated/css/ColorAccess;", "<init>", "()V", "read", "", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "write", "", "color", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class BackgroundColorAccess implements ColorAccess {
    public static final BackgroundColorAccess INSTANCE = new BackgroundColorAccess();

    private BackgroundColorAccess() {
    }

    @Override // com.swmansion.reanimated.css.ColorAccess
    public Integer read(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return BackgroundStyleApplicator.getBackgroundColor(view);
    }

    @Override // com.swmansion.reanimated.css.ColorAccess
    public void write(View view, int color) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBackgroundColor(view, Integer.valueOf(color));
    }
}
