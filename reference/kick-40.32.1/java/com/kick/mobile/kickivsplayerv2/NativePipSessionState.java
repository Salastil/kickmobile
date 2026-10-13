package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;

/* JADX INFO: compiled from: NativePipSessionState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/NativePipSessionState;", "", "<init>", "()V", "value", "", "isActive", "()Z", "isActivityStopped", "hadActiveSession", "onPipStateChanged", "newState", "isChangingConfigurations", "onActivityStopped", "isInPictureInPictureMode", "onActivityResumed", "", "markDismissed", "reset", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativePipSessionState {
    private boolean hadActiveSession;
    private boolean isActive;
    private boolean isActivityStopped;

    /* JADX INFO: renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public static /* synthetic */ boolean onPipStateChanged$default(NativePipSessionState nativePipSessionState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return nativePipSessionState.onPipStateChanged(z, z2);
    }

    public final boolean onPipStateChanged(boolean newState, boolean isChangingConfigurations) {
        boolean z = this.hadActiveSession && this.isActive && !newState && !isChangingConfigurations && this.isActivityStopped;
        if (newState) {
            this.hadActiveSession = true;
        }
        this.isActive = newState;
        return z;
    }

    public final boolean onActivityStopped(boolean isChangingConfigurations, boolean isInPictureInPictureMode) {
        this.isActivityStopped = true;
        if (this.hadActiveSession && !isInPictureInPictureMode && !isChangingConfigurations) {
            return true;
        }
        if (!isInPictureInPictureMode) {
            this.hadActiveSession = false;
        }
        return false;
    }

    public final void onActivityResumed() {
        this.isActivityStopped = false;
        if (this.isActive) {
            return;
        }
        this.hadActiveSession = false;
    }

    public final boolean markDismissed() {
        boolean z = this.isActive;
        this.isActive = false;
        this.hadActiveSession = false;
        return z;
    }

    public final void reset() {
        this.isActive = false;
        this.isActivityStopped = false;
        this.hadActiveSession = false;
    }
}
