package org.koin.core.parameter;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.error.DefinitionParameterException;
import org.koin.core.error.NoParameterFoundException;
import org.koin.core.module.KoinDslMarker;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: ParametersHolder.kt */
/* JADX INFO: loaded from: classes11.dex */
@KoinDslMarker
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001d\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001e\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u001aJ\u001c\u0010$\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020'\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u0002H\u0013¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0001J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0001J\u001a\u0010$\u001a\u0002H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u001aJ\u001c\u00100\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u001aJ!\u00100\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016¢\u0006\u0002\u00101J!\u00102\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u00101J!\u00103\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u00101J\b\u00104\u001a\u00020'H\u0001J\b\u00105\u001a\u000206H\u0016J\u0013\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0015H\u0016R$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u001f\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006:"}, d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "", "_values", "", "useIndexedValues", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "get_values$annotations", "()V", "get_values", "()Ljava/util/List;", "getUseIndexedValues", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "values", "", "getValues", "elementAt", ExifInterface.GPS_DIRECTION_TRUE, ContextChain.TAG_INFRA, "", "clazz", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", FirebaseAnalytics.Param.INDEX, "getIndex", "()I", "setIndex", "(I)V", "get", "(I)Ljava/lang/Object;", "set", "", "t", "(ILjava/lang/Object;)V", ContentDisposition.Parameters.Size, "isEmpty", "isNotEmpty", "insert", "value", "add", "getOrNull", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getFirstValue", "getIndexedValue", "increaseIndex", "toString", "", "equals", "other", "hashCode", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ParametersHolder {
    private final List<Object> _values;
    private int index;
    private final Boolean useIndexedValues;

    /* JADX WARN: Multi-variable type inference failed */
    public ParametersHolder() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void get_values$annotations() {
    }

    public ParametersHolder(List<Object> _values, Boolean bool) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this._values = _values;
        this.useIndexedValues = bool;
    }

    public final List<Object> get_values() {
        return this._values;
    }

    public /* synthetic */ ParametersHolder(ArrayList arrayList, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? null : bool);
    }

    public final Boolean getUseIndexedValues() {
        return this.useIndexedValues;
    }

    public final List<Object> getValues() {
        return this._values;
    }

    public <T> T elementAt(int i, KClass<?> clazz) throws NoParameterFoundException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (i < this._values.size()) {
            return (T) this._values.get(i);
        }
        throw new NoParameterFoundException("Can't get injected parameter #" + i + " from " + this + " for type '" + KClassExtKt.getFullName(clazz) + '\'');
    }

    public final /* synthetic */ <T> T component1() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) elementAt(0, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component2() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) elementAt(1, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component3() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) elementAt(2, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component4() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) elementAt(3, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> T component5() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) elementAt(4, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final <T> T get(int i) {
        return (T) this._values.get(i);
    }

    public final <T> void set(int i, T t) {
        List<Object> list = this._values;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
        list.set(i, t);
    }

    public final int size() {
        return this._values.size();
    }

    public final boolean isEmpty() {
        return this._values.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this._values.isEmpty();
    }

    public final ParametersHolder insert(int index, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._values.add(index, value);
        return this;
    }

    public final ParametersHolder add(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._values.add(value);
        return this;
    }

    public final /* synthetic */ <T> T get() throws DefinitionParameterException {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class));
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder("No value found for type '");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append('\'');
        throw new DefinitionParameterException(sb.toString());
    }

    public final /* synthetic */ <T> T getOrNull() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public <T> T getOrNull(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.isEmpty()) {
            return null;
        }
        Boolean bool = this.useIndexedValues;
        if (bool != null) {
            return Intrinsics.areEqual((Object) bool, (Object) true) ? (T) getIndexedValue(clazz) : (T) getFirstValue(clazz);
        }
        T t = (T) getIndexedValue(clazz);
        return t == null ? (T) getFirstValue(clazz) : t;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001e A[RETURN] */
    private final <T> T getFirstValue(KClass<?> clazz) {
        for (T t : this._values) {
            if (clazz.isInstance(t)) {
                if (t == null) {
                    return null;
                }
                return t;
            }
        }
        t = null;
        if (t == null) {
            return null;
        }
        return t;
    }

    private final <T> T getIndexedValue(KClass<?> clazz) {
        Object obj = this._values.get(this.index);
        T t = null;
        if (!clazz.isInstance(obj)) {
            obj = null;
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (t != null) {
            increaseIndex();
        }
        return t;
    }

    public final void increaseIndex() {
        if (this.index < CollectionsKt.getLastIndex(this._values)) {
            this.index++;
        }
    }

    public String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this._values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParametersHolder)) {
            return false;
        }
        ParametersHolder parametersHolder = (ParametersHolder) other;
        return Intrinsics.areEqual(getValues(), parametersHolder.getValues()) && Intrinsics.areEqual(this.useIndexedValues, parametersHolder.useIndexedValues);
    }

    public int hashCode() {
        int iHashCode = getValues().hashCode() * 31;
        Boolean bool = this.useIndexedValues;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
