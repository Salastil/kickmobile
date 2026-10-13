package com.amazon.mediatailorsdk;

import android.view.MotionEvent;
import com.google.ads.interactivemedia.pal.NonceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAL.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/amazon/mediatailorsdk/AndroidPalNonceManagerWrapper;", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "nonceManager", "Lcom/google/ads/interactivemedia/pal/NonceManager;", "<init>", "(Lcom/google/ads/interactivemedia/pal/NonceManager;)V", "getNonce", "", "sendPlaybackStart", "", "sendPlaybackEnd", "sendAdClick", "sendAdTouch", "event", "Landroid/view/MotionEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AndroidPalNonceManagerWrapper implements PalNonceManagerWrapper {
    private final NonceManager nonceManager;

    public AndroidPalNonceManagerWrapper(NonceManager nonceManager) {
        Intrinsics.checkNotNullParameter(nonceManager, "nonceManager");
        this.nonceManager = nonceManager;
    }

    @Override // com.amazon.mediatailorsdk.PalNonceManagerWrapper
    public String getNonce() {
        String nonce = this.nonceManager.getNonce();
        Intrinsics.checkNotNullExpressionValue(nonce, "getNonce(...)");
        return nonce;
    }

    @Override // com.amazon.mediatailorsdk.PalNonceManagerWrapper
    public void sendPlaybackStart() {
        this.nonceManager.sendPlaybackStart();
    }

    @Override // com.amazon.mediatailorsdk.PalNonceManagerWrapper
    public void sendPlaybackEnd() {
        this.nonceManager.sendPlaybackEnd();
    }

    @Override // com.amazon.mediatailorsdk.PalNonceManagerWrapper
    public void sendAdClick() {
        this.nonceManager.sendAdClick();
    }

    public final void sendAdTouch(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.nonceManager.sendAdTouch(event);
    }
}
