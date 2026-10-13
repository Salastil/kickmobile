package com.datadog.android.core;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.core.internal.DatadogCore;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkReference.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\n\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/SdkReference;", "", "sdkInstanceName", "", "onSdkInstanceCaptured", "Lkotlin/Function1;", "Lcom/datadog/android/api/SdkCore;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "reference", "Ljava/util/concurrent/atomic/AtomicReference;", "get", "tryAcquire", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdkReference {
    private final Function1<SdkCore, Unit> onSdkInstanceCaptured;
    private final AtomicReference<SdkCore> reference;
    private final String sdkInstanceName;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkReference() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SdkReference(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SdkReference(String str, Function1<? super SdkCore, Unit> onSdkInstanceCaptured) {
        Intrinsics.checkNotNullParameter(onSdkInstanceCaptured, "onSdkInstanceCaptured");
        this.sdkInstanceName = str;
        this.onSdkInstanceCaptured = onSdkInstanceCaptured;
        this.reference = new AtomicReference<>(null);
    }

    public /* synthetic */ SdkReference(String str, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new Function1<SdkCore, Unit>() { // from class: com.datadog.android.core.SdkReference.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SdkCore sdkCore) {
                invoke2(sdkCore);
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    public final SdkCore get() {
        SdkCore sdkCore = this.reference.get();
        if (sdkCore == null) {
            return tryAcquire();
        }
        DatadogCore datadogCore = sdkCore instanceof DatadogCore ? (DatadogCore) sdkCore : null;
        Boolean boolValueOf = datadogCore != null ? Boolean.valueOf(datadogCore.isActive$dd_sdk_android_core_release()) : null;
        if (boolValueOf == null || boolValueOf.booleanValue()) {
            return sdkCore;
        }
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.reference, sdkCore, null);
        return null;
    }

    private final SdkCore tryAcquire() {
        SdkCore datadog;
        synchronized (this.reference) {
            datadog = this.reference.get();
            if (datadog == null) {
                if (Datadog.isInitialized(this.sdkInstanceName)) {
                    datadog = Datadog.getInstance(this.sdkInstanceName);
                    this.reference.set(datadog);
                    this.onSdkInstanceCaptured.invoke(datadog);
                } else {
                    datadog = null;
                }
            }
        }
        return datadog;
    }
}
