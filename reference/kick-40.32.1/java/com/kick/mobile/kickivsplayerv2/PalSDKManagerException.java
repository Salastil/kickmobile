package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PALSDKManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/PalSDKManagerException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class PalSDKManagerException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PalSDKManagerException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
