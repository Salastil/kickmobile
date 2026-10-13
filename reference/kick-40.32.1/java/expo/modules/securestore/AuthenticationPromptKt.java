package expo.modules.securestore;

import android.content.Context;
import androidx.biometric.BiometricPrompt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationPrompt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"buildAuthenticationPromptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "title", "", "requireConfirmation", "", "expo-secure-store_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationPromptKt {
    public static /* synthetic */ BiometricPrompt.PromptInfo buildAuthenticationPromptInfo$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return buildAuthenticationPromptInfo(context, str, z);
    }

    public static final BiometricPrompt.PromptInfo buildAuthenticationPromptInfo(Context context, String title, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        BiometricPrompt.PromptInfo promptInfoBuild = new BiometricPrompt.PromptInfo.Builder().setTitle(title).setNegativeButtonText(context.getString(android.R.string.cancel)).setConfirmationRequired(z).build();
        Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
        return promptInfoBuild;
    }
}
