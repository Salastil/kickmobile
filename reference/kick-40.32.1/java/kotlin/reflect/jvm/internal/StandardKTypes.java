package kotlin.reflect.jvm.internal;

import com.facebook.infer.annotation.ThreadConfined;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: StandardKTypes.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/StandardKTypes;", "", "<init>", "()V", ThreadConfined.ANY, "Lkotlin/reflect/KType;", "getANY", "()Lkotlin/reflect/KType;", "NULLABLE_ANY", "getNULLABLE_ANY", "CLONEABLE", "getCLONEABLE", "SERIALIZABLE", "getSERIALIZABLE", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StandardKTypes {
    public static final StandardKTypes INSTANCE = new StandardKTypes();
    private static final KType ANY = Reflection.typeOf(Object.class);
    private static final KType NULLABLE_ANY = Reflection.nullableTypeOf(Object.class);
    private static final KType CLONEABLE = Reflection.typeOf(Cloneable.class);
    private static final KType SERIALIZABLE = Reflection.typeOf(Serializable.class);

    private StandardKTypes() {
    }

    public final KType getANY() {
        return ANY;
    }

    public final KType getNULLABLE_ANY() {
        return NULLABLE_ANY;
    }

    public final KType getCLONEABLE() {
        return CLONEABLE;
    }

    public final KType getSERIALIZABLE() {
        return SERIALIZABLE;
    }
}
