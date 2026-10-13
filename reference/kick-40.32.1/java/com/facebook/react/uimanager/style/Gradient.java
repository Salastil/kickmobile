package com.facebook.react.uimanager.style;

import android.graphics.Shader;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: Gradient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/style/Gradient;", "", "getShader", "Landroid/graphics/Shader;", ViewProps.WIDTH, "", ViewProps.HEIGHT, "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Gradient {
    Shader getShader(float width, float height);
}
