package com.facebook.imagepipeline.animated.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedImageValidator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u001d\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/animated/base/ValidationResult;", "", "isValid", "", "message", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getMessage", "()Ljava/lang/String;", "Success", "Failure", "Lcom/facebook/imagepipeline/animated/base/ValidationResult$Failure;", "Lcom/facebook/imagepipeline/animated/base/ValidationResult$Success;", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ValidationResult {
    private final boolean isValid;
    private final String message;

    public /* synthetic */ ValidationResult(boolean z, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str);
    }

    private ValidationResult(boolean z, String str) {
        this.isValid = z;
        this.message = str;
    }

    public /* synthetic */ ValidationResult(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, null);
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: isValid, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    /* JADX INFO: compiled from: AnimatedImageValidator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/facebook/imagepipeline/animated/base/ValidationResult$Success;", "Lcom/facebook/imagepipeline/animated/base/ValidationResult;", "<init>", "()V", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Success extends ValidationResult {
        public static final Success INSTANCE = new Success();

        /* JADX WARN: Multi-variable type inference failed */
        private Success() {
            super(true, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: AnimatedImageValidator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/imagepipeline/animated/base/ValidationResult$Failure;", "Lcom/facebook/imagepipeline/animated/base/ValidationResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Failure extends ValidationResult {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String message) {
            super(false, message, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }
}
