package io.github.centrifugal.centrifuge;

import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class ServerPublicationEvent {
    private String channel;
    private byte[] data;
    private ClientInfo info;
    private long offset;
    Map<String, String> tags;

    public byte[] getData() {
        return this.data;
    }

    void setData(byte[] bArr) {
        this.data = bArr;
    }

    public ClientInfo getInfo() {
        return this.info;
    }

    void setInfo(ClientInfo clientInfo) {
        this.info = clientInfo;
    }

    public long getOffset() {
        return this.offset;
    }

    void setOffset(long j) {
        this.offset = j;
    }

    void setChannel(String str) {
        this.channel = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }
}
