package expo.modules.kotlin.views;

import io.github.expo.pika.PProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [Props] */
/* JADX INFO: compiled from: PropsParsingStrategy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class PropsParsingStrategy$Introspection$props$1$1<Props> extends FunctionReferenceImpl implements Function1<Props, Object> {
    PropsParsingStrategy$Introspection$props$1$1(Object obj) {
        super(1, obj, PProperty.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Incorrect types in method signature: (TProps;)Ljava/lang/Object; */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ComposeProps p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((PProperty) this.receiver).get(p0);
    }
}
