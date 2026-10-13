package com.amazonaws.ivs.player;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
class DrmPssh {
    private static final int ID_SIZE = 16;
    private static final int INT_SIZE = 4;
    private static final int PSSH = StandardCharsets.UTF_8.encode("pssh").getInt();
    private byte[] data;
    private final List<byte[]> keyIds = new ArrayList();
    private UUID systemId;

    DrmPssh(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferOrder;
        int i;
        this.data = new byte[0];
        if (byteBuffer == null || byteBuffer.remaining() < 4 || (i = (byteBufferOrder = byteBuffer.duplicate().order(ByteOrder.BIG_ENDIAN)).getInt()) > byteBufferOrder.limit()) {
            return;
        }
        if (i < byteBufferOrder.limit()) {
            byteBufferOrder.limit(i);
        }
        try {
            if (byteBufferOrder.getInt() == PSSH) {
                int i2 = byteBufferOrder.getInt() >> 24;
                byte[] bArr = new byte[16];
                byteBufferOrder.get(bArr);
                this.systemId = getUUID(ByteBuffer.wrap(bArr));
                if (i2 > 0) {
                    int i3 = byteBufferOrder.getInt();
                    for (int i4 = 0; i4 < i3; i4++) {
                        byte[] bArr2 = new byte[16];
                        byteBufferOrder.get(bArr2);
                        this.keyIds.add(bArr2);
                    }
                }
                int i5 = byteBufferOrder.getInt();
                if (i5 > 0) {
                    byte[] bArr3 = new byte[i5];
                    this.data = bArr3;
                    byteBufferOrder.get(bArr3, 0, bArr3.length);
                }
            }
        } catch (BufferUnderflowException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof DrmPssh) {
            DrmPssh drmPssh = (DrmPssh) obj;
            if (Objects.equals(this.systemId, drmPssh.systemId) && Arrays.deepEquals(this.keyIds.toArray(), drmPssh.keyIds.toArray()) && Arrays.equals(this.data, drmPssh.data)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.systemId, Integer.valueOf(Arrays.hashCode(this.data)), Integer.valueOf(Arrays.deepHashCode(this.keyIds.toArray())));
    }

    static UUID getUUID(ByteBuffer byteBuffer) {
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

    public UUID getSystemId() {
        return this.systemId;
    }

    public List<byte[]> getKeyIds() {
        return this.keyIds;
    }

    public byte[] getData() {
        return this.data;
    }
}
