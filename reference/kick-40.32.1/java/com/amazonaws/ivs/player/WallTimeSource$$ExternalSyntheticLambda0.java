package com.amazonaws.ivs.player;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WallTimeSource$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WallTimeSource f$0;

    public /* synthetic */ WallTimeSource$$ExternalSyntheticLambda0(WallTimeSource wallTimeSource) {
        this.f$0 = wallTimeSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.taskFired();
    }
}
