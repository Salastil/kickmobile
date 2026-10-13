package expo.modules.structuredheaders;

/* JADX INFO: loaded from: classes9.dex */
public interface NumberItem<T> extends Item<T>, LongSupplier {
    int getDivisor();

    @Override // expo.modules.structuredheaders.Item, expo.modules.structuredheaders.Parametrizable
    NumberItem<T> withParams(Parameters parameters);
}
