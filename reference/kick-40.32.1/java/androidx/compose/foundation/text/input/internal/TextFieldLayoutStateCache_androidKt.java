package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.style.TextDirection;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldLayoutStateCache.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", Constants.LOCALE, "Landroidx/compose/ui/text/intl/Locale;", "(Landroidx/compose/ui/text/intl/Locale;)I", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale locale) {
        byte bResolve;
        if (Build.VERSION.SDK_INT >= 28) {
            bResolve = DigitDirectionalityApi28.INSTANCE.resolve(locale);
        } else {
            bResolve = DigitDirectionalityApi24.INSTANCE.resolve(locale);
        }
        if (bResolve == 1 || bResolve == 2) {
            return TextDirection.INSTANCE.m10067getRtls_7Xco();
        }
        return TextDirection.INSTANCE.m10066getLtrs_7Xco();
    }
}
