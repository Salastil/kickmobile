package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class RPCResult {
    private byte[] data;
    private ReplyError error;

    public ReplyError getError() {
        return this.error;
    }

    public void setError(ReplyError replyError) {
        this.error = replyError;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
