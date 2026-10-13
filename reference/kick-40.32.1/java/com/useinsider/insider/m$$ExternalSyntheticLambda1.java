package com.useinsider.insider;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class m$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ Insider f$0;

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f$0.putException(exc);
    }
}
