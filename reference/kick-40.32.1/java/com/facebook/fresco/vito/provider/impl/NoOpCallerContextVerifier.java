package com.facebook.fresco.vito.provider.impl;

import com.facebook.callercontext.CallerContextVerifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpCallerContextVerifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/provider/impl/NoOpCallerContextVerifier;", "Lcom/facebook/callercontext/CallerContextVerifier;", "<init>", "()V", "verifyCallerContext", "", "callerContext", "", "isPrefetch", "", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoOpCallerContextVerifier implements CallerContextVerifier {
    public static final NoOpCallerContextVerifier INSTANCE = new NoOpCallerContextVerifier();

    @Override // com.facebook.callercontext.CallerContextVerifier
    public void verifyCallerContext(Object callerContext, boolean isPrefetch) {
    }

    private NoOpCallerContextVerifier() {
    }
}
