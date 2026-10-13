package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.BoxedBooleanConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$1 extends FunctionReferenceImpl implements Function1<Boolean, BoxedBooleanConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$1 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$1();

    TypeConverterRegistry$simpleConvertersCache$1$1() {
        super(1, BoxedBooleanConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final BoxedBooleanConverter invoke(boolean z) {
        return new BoxedBooleanConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BoxedBooleanConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
