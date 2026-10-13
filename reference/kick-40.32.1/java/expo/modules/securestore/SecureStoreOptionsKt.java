package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureStoreOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toAuthenticationPromptOptions", "Lexpo/modules/securestore/AuthenticationPromptOptions;", "Lexpo/modules/securestore/SecureStoreOptions;", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "expo-secure-store_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SecureStoreOptionsKt {
    public static /* synthetic */ AuthenticationPromptOptions toAuthenticationPromptOptions$default(SecureStoreOptions secureStoreOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = secureStoreOptions.getRequireAuthentication();
        }
        return toAuthenticationPromptOptions(secureStoreOptions, z);
    }

    public static final AuthenticationPromptOptions toAuthenticationPromptOptions(SecureStoreOptions secureStoreOptions, boolean z) {
        Intrinsics.checkNotNullParameter(secureStoreOptions, "<this>");
        return new AuthenticationPromptOptions(secureStoreOptions.getAuthenticationPrompt(), z, secureStoreOptions.getRequireConfirmation());
    }
}
