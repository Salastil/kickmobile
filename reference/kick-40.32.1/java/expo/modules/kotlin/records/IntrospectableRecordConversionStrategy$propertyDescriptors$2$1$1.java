package expo.modules.kotlin.records;

import io.github.expo.pika.PProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class IntrospectableRecordConversionStrategy$propertyDescriptors$2$1$1 extends FunctionReferenceImpl implements Function2<Object, Object, Unit> {
    IntrospectableRecordConversionStrategy$propertyDescriptors$2$1$1(Object obj) {
        super(2, obj, PProperty.class, "set", "set(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke2(obj, obj2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object p0, Object obj) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PProperty) this.receiver).set(p0, obj);
    }
}
