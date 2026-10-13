package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes8.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}
