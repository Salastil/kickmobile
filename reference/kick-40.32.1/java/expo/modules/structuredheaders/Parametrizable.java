package expo.modules.structuredheaders;

/* JADX INFO: loaded from: classes9.dex */
public interface Parametrizable<T> extends Type<T> {
    Parameters getParams();

    Parametrizable<T> withParams(Parameters parameters);
}
