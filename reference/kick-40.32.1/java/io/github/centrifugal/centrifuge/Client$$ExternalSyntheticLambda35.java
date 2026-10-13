package io.github.centrifugal.centrifuge;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class Client$$ExternalSyntheticLambda35 implements Runnable {
    public final /* synthetic */ Client f$0;

    public /* synthetic */ Client$$ExternalSyntheticLambda35(Client client) {
        this.f$0 = client;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.waitServerPing();
    }
}
