package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ServerSubscribedEvent {
    private final String channel;
    private final byte[] data;
    private final Boolean positioned;
    private final Boolean recoverable;
    private final Boolean recovered;
    private final StreamPosition streamPosition;
    private final Boolean wasRecovering;

    ServerSubscribedEvent(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, StreamPosition streamPosition, byte[] bArr) {
        this.channel = str;
        this.wasRecovering = bool;
        this.recovered = bool2;
        this.positioned = bool3;
        this.recoverable = bool4;
        this.streamPosition = streamPosition;
        this.data = bArr;
    }

    public Boolean getRecovered() {
        return this.recovered;
    }

    public String getChannel() {
        return this.channel;
    }

    public Boolean wasRecovering() {
        return this.wasRecovering;
    }

    public byte[] getData() {
        return this.data;
    }

    public Boolean getPositioned() {
        return this.positioned;
    }

    public Boolean getRecoverable() {
        return this.recoverable;
    }

    public StreamPosition getStreamPosition() {
        return this.streamPosition;
    }
}
