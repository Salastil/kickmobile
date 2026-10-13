package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.PersistableBundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0010\u001a\u00020\t*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"moduleName", "", "TAG", "kotlin.jvm.PlatformType", "CLIPBOARD_DIRECTORY_NAME", "CLIPBOARD_CHANGED_EVENT_NAME", "applyIsSensitive", "Landroid/content/ClipData;", "isSensitive", "", "plainTextFromHtml", "htmlContent", "coerceToPlainText", "Landroid/content/ClipData$Item;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "hasTextContent", "Landroid/content/ClipDescription;", "getHasTextContent", "(Landroid/content/ClipDescription;)Z", "expo-clipboard_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClipboardModuleKt {
    public static final String CLIPBOARD_CHANGED_EVENT_NAME = "onClipboardChanged";
    public static final String CLIPBOARD_DIRECTORY_NAME = ".clipboard";
    private static final String TAG = "ClipboardModule";
    private static final String moduleName = "ExpoClipboard";

    public static final ClipData applyIsSensitive(ClipData clipData, boolean z) {
        Intrinsics.checkNotNullParameter(clipData, "<this>");
        if (!z) {
            return clipData;
        }
        ClipDescription description = clipData.getDescription();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean("android.content.extra.IS_SENSITIVE", true);
        description.setExtras(persistableBundle);
        return clipData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String plainTextFromHtml(String str) {
        Spanned spannedFromHtml = Html.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        char[] cArr = new char[spannedFromHtml.length()];
        TextUtils.getChars(spannedFromHtml, 0, spannedFromHtml.length(), cArr, 0);
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String coerceToPlainText(ClipData.Item item, Context context) {
        if (item.getText() == null && item.getHtmlText() != null) {
            String htmlText = item.getHtmlText();
            Intrinsics.checkNotNullExpressionValue(htmlText, "getHtmlText(...)");
            return plainTextFromHtml(htmlText);
        }
        return item.coerceToText(context).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasTextContent(ClipDescription clipDescription) {
        return clipDescription.hasMimeType("text/plain") || clipDescription.hasMimeType("text/html");
    }
}
