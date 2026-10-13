package com.facebook.react.views.text;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.views.text.internal.span.TextEffectSpan;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextEffectSpanFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/text/TextEffectSpanFactory;", "", "createSpan", "Lcom/facebook/react/views/text/internal/span/TextEffectSpan;", "props", "Lcom/facebook/react/bridge/ReadableMap;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@UnstableReactNativeAPI
public interface TextEffectSpanFactory {
    TextEffectSpan createSpan(ReadableMap props);
}
