package com.amazonaws.ivs.player;

import android.media.MediaDrm;
import java.util.EnumSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public enum ProtectionSystem {
    WIDEVINE(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")),
    PLAYREADY(UUID.fromString("9a04f079-9840-4286-ab92-e65be0885f95"));

    private static final EnumSet<ProtectionSystem> supported = EnumSet.noneOf(ProtectionSystem.class);
    private final UUID uuid;

    ProtectionSystem(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public static EnumSet<ProtectionSystem> getSupported() {
        EnumSet<ProtectionSystem> enumSet = supported;
        synchronized (enumSet) {
            if (enumSet.isEmpty()) {
                for (ProtectionSystem protectionSystem : values()) {
                    if (MediaDrm.isCryptoSchemeSupported(protectionSystem.getUUID())) {
                        supported.add(protectionSystem);
                    }
                }
            }
        }
        return supported;
    }

    public static ProtectionSystem valueOf(UUID uuid) {
        for (ProtectionSystem protectionSystem : values()) {
            if (protectionSystem.getUUID().equals(uuid)) {
                return protectionSystem;
            }
        }
        return null;
    }
}
