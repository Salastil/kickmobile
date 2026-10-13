package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ConnectedEvent {
    private String client;
    private byte[] data;

    public String getClient() {
        return this.client;
    }

    void setClient(String str) {
        this.client = str;
    }

    public byte[] getData() {
        return this.data;
    }

    void setData(byte[] bArr) {
        this.data = bArr;
    }
}
