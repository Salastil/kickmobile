package io.github.centrifugal.centrifuge;

import io.github.centrifugal.centrifuge.internal.protocol.Protocol;

/* JADX INFO: loaded from: classes9.dex */
public class ClientInfo {
    private byte[] chanInfo;
    private String client;
    private byte[] connInfo;
    private String user;

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public byte[] getConnInfo() {
        return this.connInfo;
    }

    public void setConnInfo(byte[] bArr) {
        this.connInfo = bArr;
    }

    public byte[] getChanInfo() {
        return this.chanInfo;
    }

    public void setChanInfo(byte[] bArr) {
        this.chanInfo = bArr;
    }

    static ClientInfo fromProtocolClientInfo(Protocol.ClientInfo clientInfo) {
        if (clientInfo == null) {
            return null;
        }
        ClientInfo clientInfo2 = new ClientInfo();
        clientInfo2.setUser(clientInfo.getUser());
        clientInfo2.setClient(clientInfo.getClient());
        clientInfo2.setConnInfo(clientInfo.getConnInfo().toByteArray());
        clientInfo2.setChanInfo(clientInfo.getChanInfo().toByteArray());
        return clientInfo2;
    }
}
