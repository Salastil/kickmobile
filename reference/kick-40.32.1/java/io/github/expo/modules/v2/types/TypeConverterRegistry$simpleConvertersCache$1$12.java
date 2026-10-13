package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.DurationConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$12 extends FunctionReferenceImpl implements Function1<Boolean, DurationConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$12 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$12();

    TypeConverterRegistry$simpleConvertersCache$1$12() {
        super(1, DurationConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final DurationConverter invoke(boolean z) {
        return new DurationConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DurationConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
