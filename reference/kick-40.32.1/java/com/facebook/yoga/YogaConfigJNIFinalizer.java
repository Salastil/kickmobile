package com.facebook.yoga;

import kotlin.Metadata;

/* JADX INFO: compiled from: YogaConfigJNIFinalizer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0004J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/yoga/YogaConfigJNIFinalizer;", "Lcom/facebook/yoga/YogaConfigJNIBase;", "<init>", "()V", "finalize", "", "freeNatives", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    protected final void finalize() throws Throwable {
        freeNatives();
    }

    public final void freeNatives() {
        if (this.nativePointer != 0) {
            long j = this.nativePointer;
            this.nativePointer = 0L;
            YogaNative.jni_YGConfigFreeJNI(j);
        }
    }
}
