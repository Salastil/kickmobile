package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.DynamicConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$8 extends FunctionReferenceImpl implements Function1<Boolean, DynamicConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$8 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$8();

    TypeConverterRegistry$simpleConvertersCache$1$8() {
        super(1, DynamicConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final DynamicConverter invoke(boolean z) {
        return new DynamicConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DynamicConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
