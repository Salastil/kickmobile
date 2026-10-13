package com.datadog.android.rum.operations;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OperationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/rum/operations/OperationOptions;", "", "()V", "Empty", "Lcom/datadog/android/rum/operations/OperationOptions$Empty;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OperationOptions {
    public /* synthetic */ OperationOptions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OperationOptions() {
    }

    /* JADX INFO: compiled from: OperationOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/rum/operations/OperationOptions$Empty;", "Lcom/datadog/android/rum/operations/OperationOptions;", "()V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Empty extends OperationOptions {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super(null);
        }
    }
}
