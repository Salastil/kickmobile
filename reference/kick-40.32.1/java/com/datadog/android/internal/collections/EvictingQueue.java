package com.datadog.android.internal.collections;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvictingQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u001e\u0010\u0015\u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0096\u0003¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0017\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u0012H\u0096\u0001J\u0016\u0010\u000e\u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\rH\u0096\u0001J\u0017\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u001bH\u0096\u0003J\r\u0010\u001c\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u001e\u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0097\u0001¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001f\u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0097\u0001¢\u0006\u0002\u0010\u0018J\u0016\u0010 \u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0018J\u001e\u0010 \u001a\u00020\r2\u000e\u0010\u000e\u001a\n \u0016*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u000fJ\u001f\u0010!\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u0012H\u0096\u0001J\u001f\u0010\"\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u0012H\u0096\u0001R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u0004X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006#"}, d2 = {"Lcom/datadog/android/internal/collections/EvictingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Queue;", "maxSize", "", "(I)V", "delegate", "Ljava/util/Deque;", "(ILjava/util/Deque;)V", ContentDisposition.Parameters.Size, "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "kotlin.jvm.PlatformType", "containsAll", "()Ljava/lang/Object;", "isEmpty", "iterator", "", "lastOrNull", "offer", "peek", "poll", "remove", "removeAll", "retainAll", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvictingQueue<T> implements Queue<T> {
    private final Deque<T> delegate;
    private final int maxSize;

    @Override // java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        return this.delegate.contains(element);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.containsAll(elements);
    }

    @Override // java.util.Queue
    public T element() {
        return this.delegate.element();
    }

    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator<T> it = this.delegate.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Queue
    public T peek() {
        return this.delegate.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.delegate.poll();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.delegate.remove();
    }

    @Override // java.util.Collection
    public boolean remove(Object element) {
        return this.delegate.remove(element);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.removeAll(elements);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.retainAll(elements);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public EvictingQueue(int i, Deque<T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.maxSize = Math.max(0, i);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public EvictingQueue(int i) {
        this(i, new LinkedList());
    }

    public /* synthetic */ EvictingQueue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i);
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T element) {
        return offer(element);
    }

    @Override // java.util.Queue
    public boolean offer(T element) {
        if (this.maxSize == 0) {
            return false;
        }
        if (size() >= this.maxSize) {
            this.delegate.poll();
        }
        return this.delegate.offer(element);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        if (this.maxSize == 0) {
            return false;
        }
        int size = elements.size();
        int i2 = this.maxSize;
        if (size >= i2) {
            clear();
            for (T t : elements) {
                int i3 = i + 1;
                if (i >= elements.size() - this.maxSize) {
                    this.delegate.add(t);
                }
                i = i3;
            }
            return true;
        }
        int size2 = elements.size() - (i2 - size());
        while (true) {
            Deque<T> deque = this.delegate;
            if (i < size2) {
                deque.poll();
                i++;
            } else {
                return deque.addAll(elements);
            }
        }
    }

    public final T lastOrNull() {
        return this.delegate.peekLast();
    }
}
