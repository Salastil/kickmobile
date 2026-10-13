package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public abstract class EventListener {
    public void onConnected(Client client, ConnectedEvent connectedEvent) {
    }

    public void onConnecting(Client client, ConnectingEvent connectingEvent) {
    }

    public void onDisconnected(Client client, DisconnectedEvent disconnectedEvent) {
    }

    public void onError(Client client, ErrorEvent errorEvent) {
    }

    public void onJoin(Client client, ServerJoinEvent serverJoinEvent) {
    }

    public void onLeave(Client client, ServerLeaveEvent serverLeaveEvent) {
    }

    public void onMessage(Client client, MessageEvent messageEvent) {
    }

    public void onPublication(Client client, ServerPublicationEvent serverPublicationEvent) {
    }

    public void onSubscribed(Client client, ServerSubscribedEvent serverSubscribedEvent) {
    }

    public void onSubscribing(Client client, ServerSubscribingEvent serverSubscribingEvent) {
    }

    public void onUnsubscribed(Client client, ServerUnsubscribedEvent serverUnsubscribedEvent) {
    }
}
