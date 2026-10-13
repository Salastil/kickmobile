package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropIconResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/helpers/PropIconResolver;", "", "<init>", "()V", "lastDrawableName", "", "lastImageUri", "lastEmittedDrawableName", "lastEmittedImageUri", "resolve", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "drawableIconResourceName", "imageIconUri", "onResult", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/gamma/helpers/IconResolution;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PropIconResolver {
    private String lastDrawableName;
    private String lastEmittedDrawableName;
    private String lastEmittedImageUri;
    private String lastImageUri;

    public final void resolve(Context context, String drawableIconResourceName, final String imageIconUri, final Function1<? super IconResolution, Unit> onResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        this.lastDrawableName = drawableIconResourceName;
        this.lastImageUri = imageIconUri;
        if (Intrinsics.areEqual(drawableIconResourceName, this.lastEmittedDrawableName) && Intrinsics.areEqual(imageIconUri, this.lastEmittedImageUri)) {
            onResult.invoke(IconResolution.Unchanged.INSTANCE);
            return;
        }
        this.lastEmittedDrawableName = drawableIconResourceName;
        this.lastEmittedImageUri = imageIconUri;
        if (drawableIconResourceName != null) {
            onResult.invoke(new IconResolution.Resolved(SystemDrawableKt.getSystemDrawableResource(context, drawableIconResourceName)));
        } else if (imageIconUri != null) {
            ImageLoaderKt.loadImage(context, imageIconUri, new Function1() { // from class: com.swmansion.rnscreens.gamma.helpers.PropIconResolver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PropIconResolver.resolve$lambda$0(imageIconUri, this, onResult, (Drawable) obj);
                }
            });
        } else {
            onResult.invoke(new IconResolution.Resolved(null));
        }
    }

    static final Unit resolve$lambda$0(String str, PropIconResolver propIconResolver, Function1 function1, Drawable drawable) {
        if (Intrinsics.areEqual(str, propIconResolver.lastImageUri) && propIconResolver.lastDrawableName == null) {
            function1.invoke(new IconResolution.Resolved(drawable));
        }
        return Unit.INSTANCE;
    }
}
