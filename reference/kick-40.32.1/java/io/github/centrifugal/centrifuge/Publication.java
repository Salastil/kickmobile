package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class Publication {
    private byte[] data;
    private ClientInfo info;
    private long offset;

    public byte[] getData() {
        return this.data;
    }

    void setData(byte[] bArr) {
        this.data = bArr;
    }

    public long getOffset() {
        return this.offset;
    }

    void setOffset(long j) {
        this.offset = j;
    }

    public ClientInfo getInfo() {
        return this.info;
    }

    void setInfo(ClientInfo clientInfo) {
        this.info = clientInfo;
    }
}
