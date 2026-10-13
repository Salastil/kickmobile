package io.github.expo.pika;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheByClass.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000e"}, d2 = {"Lio/github/expo/pika/ClassValueCache;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lio/github/expo/pika/CacheByClass;", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "classValue", "io/github/expo/pika/ClassValueCache$classValue$1", "Lio/github/expo/pika/ClassValueCache$classValue$1;", "get", "key", "(Ljava/lang/Class;)Ljava/lang/Object;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class ClassValueCache<V> extends CacheByClass<V> {
    private final ClassValueCache$classValue$1 classValue;

    public ClassValueCache(final Function1<? super Class<?>, ? extends V> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.classValue = new ClassValue<V>() { // from class: io.github.expo.pika.ClassValueCache$classValue$1
            @Override // java.lang.ClassValue
            protected V computeValue(Class<?> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return compute.invoke(type);
            }
        };
    }

    @Override // io.github.expo.pika.CacheByClass
    public V get(Class<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (V) get(key);
    }
}
