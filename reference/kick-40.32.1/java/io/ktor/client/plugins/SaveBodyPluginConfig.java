package io.ktor.client.plugins;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: SaveBody.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = Messages.PLUGIN_DEPRECATED_MESSAGE)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/SaveBodyPluginConfig;", "", "<init>", "()V", "", "disabled", "Z", "getDisabled", "()Z", "setDisabled", "(Z)V", "getDisabled$annotations", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SaveBodyPluginConfig {
    private boolean disabled;

    @Deprecated(message = Messages.SAVE_BODY_DISABLED_MESSAGE)
    public static /* synthetic */ void getDisabled$annotations() {
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
    }
}
