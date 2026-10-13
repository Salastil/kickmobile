package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}
