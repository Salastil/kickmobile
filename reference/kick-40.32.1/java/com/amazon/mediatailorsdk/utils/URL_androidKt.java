package com.amazon.mediatailorsdk.utils;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: URL.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, d2 = {"absoluteUrl", "", ImagesContract.URL, Constants.SENSITIVITY_BASE, "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class URL_androidKt {
    public static final String absoluteUrl(String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str2 = str;
        return ((str2 == null || StringsKt.isBlank(str2)) ? new URL(url) : new URL(new URL(str), url)).toString();
    }
}
