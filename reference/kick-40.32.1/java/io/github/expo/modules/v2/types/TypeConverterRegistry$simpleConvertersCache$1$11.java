package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.TypedArrayConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$11 extends FunctionReferenceImpl implements Function1<Boolean, TypedArrayConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$11 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$11();

    TypeConverterRegistry$simpleConvertersCache$1$11() {
        super(1, TypedArrayConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final TypedArrayConverter invoke(boolean z) {
        return new TypedArrayConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TypedArrayConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
