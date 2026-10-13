package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SafeList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0014J\u0014\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/datazoom/sdk/utils/SafeList;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "_items", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "add", "", "item", "(Ljava/lang/Object;)V", "remove", "clear", "isEmpty", "", ContentDisposition.Parameters.Size, "", "forEach", "action", "Lkotlin/Function1;", "addAll", "list", "items", "getItems", "()Ljava/util/List;", "pooledList", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SafeList<T> {
    private final MutableStateFlow<List<T>> _items = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public final void add(T item) {
        List<T> value;
        MutableStateFlow<List<T>> mutableStateFlow = this._items;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus((Collection) value, (Object) item)));
    }

    public final void remove(T item) {
        List<T> value;
        MutableStateFlow<List<T>> mutableStateFlow = this._items;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.minus(value, item)));
    }

    public final void clear() {
        MutableStateFlow<List<T>> mutableStateFlow = this._items;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CollectionsKt.emptyList())) {
        }
    }

    public final boolean isEmpty() {
        return this._items.getValue().isEmpty();
    }

    public final int size() {
        return this._items.getValue().size();
    }

    public final void forEach(Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = CollectionsKt.toList(this._items.getValue()).iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public final void addAll(SafeList<T> list) {
        List<T> value;
        Intrinsics.checkNotNullParameter(list, "list");
        MutableStateFlow<List<T>> mutableStateFlow = this._items;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus((Collection) value, (Iterable) list._items.getValue())));
    }

    public final void addAll(List<? extends T> list) {
        List<T> value;
        Intrinsics.checkNotNullParameter(list, "list");
        MutableStateFlow<List<T>> mutableStateFlow = this._items;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus((Collection) value, (Iterable) list)));
    }

    public final List<T> getItems() {
        return CollectionsKt.toList(this._items.getValue());
    }

    public final List<T> pooledList() {
        List<T> value;
        do {
            value = this._items.getValue();
            if (value.isEmpty()) {
                return CollectionsKt.emptyList();
            }
        } while (!this._items.compareAndSet(value, CollectionsKt.emptyList()));
        return CollectionsKt.toList(value);
    }
}
