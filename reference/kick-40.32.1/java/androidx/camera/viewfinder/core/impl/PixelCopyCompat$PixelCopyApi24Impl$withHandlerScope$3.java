package androidx.camera.viewfinder.core.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PixelCopyCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class PixelCopyCompat$PixelCopyApi24Impl$withHandlerScope$3 extends FunctionReferenceImpl implements Function0<Unit> {
    PixelCopyCompat$PixelCopyApi24Impl$withHandlerScope$3(Object obj) {
        super(0, obj, RefCounted.class, "release", "release()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((RefCounted) this.receiver).release();
    }
}
