package io.datazoom.sdk.openmeasurement;

import com.iab.omid.library.amazon2.adsession.media.Position;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OmEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toOMPosition", "Lcom/iab/omid/library/amazon2/adsession/media/Position;", "", "openmeasurement_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OmEventKt {
    public static final Position toOMPosition(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != 108104) {
            if (iHashCode != 111267) {
                if (iHashCode == 3446944 && lowerCase.equals("post")) {
                    return Position.MIDROLL;
                }
            } else if (lowerCase.equals("pre")) {
                return Position.PREROLL;
            }
        } else if (lowerCase.equals("mid")) {
            return Position.MIDROLL;
        }
        return Position.STANDALONE;
    }
}
