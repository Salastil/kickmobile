package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.PathConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$16 extends FunctionReferenceImpl implements Function1<Boolean, PathConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$16 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$16();

    TypeConverterRegistry$simpleConvertersCache$1$16() {
        super(1, PathConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final PathConverter invoke(boolean z) {
        return new PathConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ PathConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
