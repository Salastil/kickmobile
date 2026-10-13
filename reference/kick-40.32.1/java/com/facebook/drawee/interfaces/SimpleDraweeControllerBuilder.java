package com.facebook.drawee.interfaces;

import android.net.Uri;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface SimpleDraweeControllerBuilder {
    DraweeController build();

    SimpleDraweeControllerBuilder setCallerContext(@Nullable Object obj);

    SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController draweeController);

    SimpleDraweeControllerBuilder setUri(@Nullable Uri uri);

    SimpleDraweeControllerBuilder setUri(@Nullable String str);
}
