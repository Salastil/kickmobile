package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.BoxedIntConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$2 extends FunctionReferenceImpl implements Function1<Boolean, BoxedIntConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$2 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$2();

    TypeConverterRegistry$simpleConvertersCache$1$2() {
        super(1, BoxedIntConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final BoxedIntConverter invoke(boolean z) {
        return new BoxedIntConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BoxedIntConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
