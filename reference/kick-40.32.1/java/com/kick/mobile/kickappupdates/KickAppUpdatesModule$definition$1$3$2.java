package com.kick.mobile.kickappupdates;

import com.google.android.gms.tasks.OnFailureListener;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickAppUpdatesModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final class KickAppUpdatesModule$definition$1$3$2 implements OnFailureListener {
    final /* synthetic */ Promise $promise;

    KickAppUpdatesModule$definition$1$3$2(Promise promise) {
        this.$promise = promise;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String message = exception.getMessage();
        if (message != null) {
            this.$promise.reject(message, "UNKNOWN", exception);
        }
    }
}
