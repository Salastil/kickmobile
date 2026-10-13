package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
class DrmListener implements DrmSession.Listener {
    private final long ptr;

    private native void onError(long j, String str);

    private native void onKeyExpired(long j);

    private native void onKeyRequested(long j);

    private native void onProvisionRequested(long j);

    DrmListener(long j) {
        this.ptr = j;
    }

    @Override // com.amazonaws.ivs.player.DrmSession.Listener
    public void onKeyExpired() {
        onKeyExpired(this.ptr);
    }

    @Override // com.amazonaws.ivs.player.DrmSession.Listener
    public void onKeyRequested() {
        onKeyRequested(this.ptr);
    }

    @Override // com.amazonaws.ivs.player.DrmSession.Listener
    public void onProvisionRequested() {
        onProvisionRequested(this.ptr);
    }

    @Override // com.amazonaws.ivs.player.DrmSession.Listener
    public void onError(String str) {
        onError(this.ptr, str);
    }
}
