package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.UriConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$15 extends FunctionReferenceImpl implements Function1<Boolean, UriConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$15 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$15();

    TypeConverterRegistry$simpleConvertersCache$1$15() {
        super(1, UriConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final UriConverter invoke(boolean z) {
        return new UriConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UriConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
