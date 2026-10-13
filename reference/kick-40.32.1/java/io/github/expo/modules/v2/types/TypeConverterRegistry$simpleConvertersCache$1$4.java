package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.BoxedFloatConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$4 extends FunctionReferenceImpl implements Function1<Boolean, BoxedFloatConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$4 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$4();

    TypeConverterRegistry$simpleConvertersCache$1$4() {
        super(1, BoxedFloatConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final BoxedFloatConverter invoke(boolean z) {
        return new BoxedFloatConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BoxedFloatConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
