package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureStoreOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lexpo/modules/securestore/AuthenticationPromptOptions;", "", "authenticationPrompt", "", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "requireConfirmation", "<init>", "(Ljava/lang/String;ZZ)V", "getAuthenticationPrompt", "()Ljava/lang/String;", "getRequireAuthentication", "()Z", "getRequireConfirmation", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthenticationPromptOptions {
    private final String authenticationPrompt;
    private final boolean requireAuthentication;
    private final boolean requireConfirmation;

    public static /* synthetic */ AuthenticationPromptOptions copy$default(AuthenticationPromptOptions authenticationPromptOptions, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationPromptOptions.authenticationPrompt;
        }
        if ((i & 2) != 0) {
            z = authenticationPromptOptions.requireAuthentication;
        }
        if ((i & 4) != 0) {
            z2 = authenticationPromptOptions.requireConfirmation;
        }
        return authenticationPromptOptions.copy(str, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthenticationPrompt() {
        return this.authenticationPrompt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRequireAuthentication() {
        return this.requireAuthentication;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRequireConfirmation() {
        return this.requireConfirmation;
    }

    public final AuthenticationPromptOptions copy(String authenticationPrompt, boolean requireAuthentication, boolean requireConfirmation) {
        Intrinsics.checkNotNullParameter(authenticationPrompt, "authenticationPrompt");
        return new AuthenticationPromptOptions(authenticationPrompt, requireAuthentication, requireConfirmation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationPromptOptions)) {
            return false;
        }
        AuthenticationPromptOptions authenticationPromptOptions = (AuthenticationPromptOptions) other;
        return Intrinsics.areEqual(this.authenticationPrompt, authenticationPromptOptions.authenticationPrompt) && this.requireAuthentication == authenticationPromptOptions.requireAuthentication && this.requireConfirmation == authenticationPromptOptions.requireConfirmation;
    }

    public int hashCode() {
        return (((this.authenticationPrompt.hashCode() * 31) + Boolean.hashCode(this.requireAuthentication)) * 31) + Boolean.hashCode(this.requireConfirmation);
    }

    public String toString() {
        return "AuthenticationPromptOptions(authenticationPrompt=" + this.authenticationPrompt + ", requireAuthentication=" + this.requireAuthentication + ", requireConfirmation=" + this.requireConfirmation + ")";
    }

    public AuthenticationPromptOptions(String authenticationPrompt, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(authenticationPrompt, "authenticationPrompt");
        this.authenticationPrompt = authenticationPrompt;
        this.requireAuthentication = z;
        this.requireConfirmation = z2;
    }

    public final String getAuthenticationPrompt() {
        return this.authenticationPrompt;
    }

    public final boolean getRequireAuthentication() {
        return this.requireAuthentication;
    }

    public final boolean getRequireConfirmation() {
        return this.requireConfirmation;
    }
}
