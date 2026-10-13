package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.FileConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TypeConverterRegistry$simpleConvertersCache$1$13 extends FunctionReferenceImpl implements Function1<Boolean, FileConverter> {
    public static final TypeConverterRegistry$simpleConvertersCache$1$13 INSTANCE = new TypeConverterRegistry$simpleConvertersCache$1$13();

    TypeConverterRegistry$simpleConvertersCache$1$13() {
        super(1, FileConverter.class, "<init>", "<init>(Z)V", 0);
    }

    public final FileConverter invoke(boolean z) {
        return new FileConverter(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ FileConverter invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
