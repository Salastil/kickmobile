package expo.modules.structuredheaders;

/* JADX INFO: loaded from: classes9.dex */
public interface Item<T> extends ListElement<T>, Parametrizable<T> {
    @Override // expo.modules.structuredheaders.Parametrizable
    Item<T> withParams(Parameters parameters);
}
