package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import expo.modules.notifications.service.NotificationsService;
import io.datazoom.sdk.logs.Logger_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainThreadRunner.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0086\bø\u0001\u0000J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\fH\u0086\bø\u0001\u0000\u0082\u0001\u0002\u0012\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"Lio/datazoom/sdk/utils/MainThreadResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "getOrDefault", Constants.COLLATION_DEFAULT, "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "()Ljava/lang/Object;", "onSuccess", "action", "Lkotlin/Function1;", "", "onError", "", "Success", "Error", "Lio/datazoom/sdk/utils/MainThreadResult$Error;", "Lio/datazoom/sdk/utils/MainThreadResult$Success;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MainThreadResult<T> {
    public /* synthetic */ MainThreadResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lio/datazoom/sdk/utils/MainThreadResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/datazoom/sdk/utils/MainThreadResult;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lio/datazoom/sdk/utils/MainThreadResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Success<T> extends MainThreadResult<T> {
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.value;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T> copy(T value) {
            return new Success<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.value, ((Success) other).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ")";
        }

        public Success(T t) {
            super(null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private MainThreadResult() {
    }

    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/utils/MainThreadResult$Error;", "Lio/datazoom/sdk/utils/MainThreadResult;", "", NotificationsService.EXCEPTION_KEY, "", "tag", "", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "getException", "()Ljava/lang/Throwable;", "getTag", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Error extends MainThreadResult {
        private final Throwable exception;
        private final String tag;

        public static /* synthetic */ Error copy$default(Error error, Throwable th, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.exception;
            }
            if ((i & 2) != 0) {
                str = error.tag;
            }
            return error.copy(th, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public final Error copy(Throwable exception, String tag) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return new Error(exception, tag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.exception, error.exception) && Intrinsics.areEqual(this.tag, error.tag);
        }

        public int hashCode() {
            return (this.exception.hashCode() * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.exception + ", tag=" + this.tag + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable exception, String tag) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.exception = exception;
            this.tag = tag;
        }

        public final Throwable getException() {
            return this.exception;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    public final T getOrDefault(T t) {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (!(this instanceof Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Error error = (Error) this;
        Logger_androidKt.getLogger().e(error.getTag() + " error: " + error.getException().getMessage());
        return t;
    }

    public final T getOrNull() {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (!(this instanceof Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Error error = (Error) this;
        Logger_androidKt.getLogger().e(error.getTag() + " error: " + error.getException().getMessage());
        return null;
    }

    public final MainThreadResult<T> onSuccess(Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this instanceof Success) {
            action.invoke((Object) ((Success) this).getValue());
        }
        return this;
    }

    public final MainThreadResult<T> onError(Function1<? super Throwable, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this instanceof Error) {
            action.invoke(((Error) this).getException());
        }
        return this;
    }
}
