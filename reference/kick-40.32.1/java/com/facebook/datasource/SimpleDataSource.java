package com.facebook.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.common.internal.Preconditions;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleDataSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/facebook/datasource/SimpleDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/datasource/AbstractDataSource;", "<init>", "()V", "setResult", "", "value", "isLast", "extras", "", "", "", "(Ljava/lang/Object;ZLjava/util/Map;)Z", "(Ljava/lang/Object;)Z", "setFailure", RumFeature.EVENT_THROWABLE_PROPERTY, "", "setProgress", "progress", "", "Companion", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleDataSource<T> extends AbstractDataSource<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ SimpleDataSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final <T> SimpleDataSource<T> create() {
        return INSTANCE.create();
    }

    private SimpleDataSource() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setResult(T value, boolean isLast, Map<String, ? extends Object> extras) {
        return super.setResult(Preconditions.checkNotNull(value), isLast, extras);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean setResult(T value) {
        return super.setResult(Preconditions.checkNotNull(value), true, null);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setFailure(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return super.setFailure((Throwable) Preconditions.checkNotNull(throwable));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float progress) {
        return super.setProgress(progress);
    }

    /* JADX INFO: compiled from: SimpleDataSource.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/datasource/SimpleDataSource$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/datasource/SimpleDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> SimpleDataSource<T> create() {
            return new SimpleDataSource<>(null);
        }
    }
}
