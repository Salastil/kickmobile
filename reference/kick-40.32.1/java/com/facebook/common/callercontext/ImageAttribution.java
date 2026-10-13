package com.facebook.common.callercontext;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface ImageAttribution {
    String getCallingClassName();

    @Nullable
    ContextChain getContextChain();
}
