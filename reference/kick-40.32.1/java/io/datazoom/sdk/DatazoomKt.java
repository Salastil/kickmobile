package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Datazoom.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"datazoom", "Lio/datazoom/sdk/Datazoom;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DatazoomKt {
    public static final Datazoom datazoom(Function1<? super Datazoom, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Datazoom datazoom = Datazoom.INSTANCE;
        init.invoke(datazoom);
        return datazoom;
    }
}
