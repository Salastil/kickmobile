package com.facebook.fresco.vito.core.impl.debug;

import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugDataProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "Lcom/facebook/fresco/vito/core/impl/debug/DebugDataProvider;", "shortName", "", "longName", "description", "extractData", "Lkotlin/Function2;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getExtractData", "()Lkotlin/jvm/functions/Function2;", "drawable", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StringDebugDataProvider extends DebugDataProvider {
    private final Function2<FrescoDrawableInterface, ControllerListener2.Extras, String> extractData;

    public final Function2<FrescoDrawableInterface, ControllerListener2.Extras, String> getExtractData() {
        return this.extractData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StringDebugDataProvider(String shortName, String longName, String description, Function2<? super FrescoDrawableInterface, ? super ControllerListener2.Extras, String> extractData) {
        super(shortName, longName, description, null);
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(longName, "longName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(extractData, "extractData");
        this.extractData = extractData;
    }

    public final String extractData(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return this.extractData.invoke(drawable, null);
    }
}
