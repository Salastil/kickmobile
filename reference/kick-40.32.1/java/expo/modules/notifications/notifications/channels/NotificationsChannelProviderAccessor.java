package expo.modules.notifications.notifications.channels;

import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.providers.AppContextProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationsChannelProviderAccessor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/channels/NotificationsChannelProviderAccessor;", "", "getChannelProvider", "Lexpo/modules/notifications/notifications/channels/NotificationsChannelsProvider;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationsChannelProviderAccessor {

    /* JADX INFO: compiled from: NotificationsChannelProviderAccessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static NotificationsChannelsProvider getChannelProvider(NotificationsChannelProviderAccessor notificationsChannelProviderAccessor, ModuleRegistry registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            return NotificationsChannelProviderAccessor.super.getChannelProvider(registry);
        }
    }

    default NotificationsChannelsProvider getChannelProvider(ModuleRegistry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        AppContextProvider module = registry.getModule(AndroidXNotificationsChannelsProviderKt.NotificationsChannelsProviderName);
        Intrinsics.checkNotNull(module, "null cannot be cast to non-null type expo.modules.notifications.notifications.channels.NotificationsChannelsProvider");
        return (NotificationsChannelsProvider) module;
    }
}
