package com.amazonaws.ivs.player;

import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class UserDataUnregisteredSeiMessage extends SeiMessage {
    public final byte[] data;
    public final long timestamp;
    public final UUID uuid;

    public UserDataUnregisteredSeiMessage(String str, long j, byte[] bArr) {
        this.uuid = UUID.fromString(str);
        this.timestamp = j;
        this.data = bArr;
    }
}
