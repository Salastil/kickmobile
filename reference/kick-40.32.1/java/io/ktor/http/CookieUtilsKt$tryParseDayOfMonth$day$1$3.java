package io.ktor.http;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CookieUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class CookieUtilsKt$tryParseDayOfMonth$day$1$3 implements Function1<Character, Boolean> {
    public static final CookieUtilsKt$tryParseDayOfMonth$day$1$3 INSTANCE = new CookieUtilsKt$tryParseDayOfMonth$day$1$3();

    public final Boolean invoke(char c) {
        return Boolean.valueOf(CookieUtilsKt.isDigit(c));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
        return invoke(ch.charValue());
    }
}
