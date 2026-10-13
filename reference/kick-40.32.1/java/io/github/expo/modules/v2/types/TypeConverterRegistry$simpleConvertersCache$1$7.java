package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.UnitConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$7 extends FunctionReferenceImpl implements Function1<Boolean, UnitConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$7 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$7();

    TypeConverterRegistry$simpleConvertersCache$1$7() {
        super(1, UnitConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final UnitConverter invoke(boolean z) {
        return new UnitConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UnitConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
