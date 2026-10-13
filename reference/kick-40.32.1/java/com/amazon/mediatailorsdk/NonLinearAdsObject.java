package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsObject;", "", "adData", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "<init>", "(Lcom/amazon/mediatailorsdk/NonLinearAdsData;)V", "getAdData", "()Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NonLinearAdsObject {
    private final NonLinearAdsData adData;

    public NonLinearAdsObject(NonLinearAdsData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.adData = adData;
    }

    public final NonLinearAdsData getAdData() {
        return this.adData;
    }
}
