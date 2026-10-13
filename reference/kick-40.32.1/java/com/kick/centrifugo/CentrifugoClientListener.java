package com.kick.centrifugo;

import android.util.Log;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.centrifugal.centrifuge.Client;
import io.github.centrifugal.centrifuge.ConnectedEvent;
import io.github.centrifugal.centrifuge.ConnectingEvent;
import io.github.centrifugal.centrifuge.DisconnectedEvent;
import io.github.centrifugal.centrifuge.ErrorEvent;
import io.github.centrifugal.centrifuge.EventListener;
import io.github.centrifugal.centrifuge.ServerJoinEvent;
import io.github.centrifugal.centrifuge.ServerLeaveEvent;
import io.github.centrifugal.centrifuge.ServerPublicationEvent;
import io.github.centrifugal.centrifuge.ServerSubscribedEvent;
import io.github.centrifugal.centrifuge.ServerSubscribingEvent;
import io.github.centrifugal.centrifuge.ServerUnsubscribedEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CentrifugoClientListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012D\u0010\u0002\u001a@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020#H\u0016RL\u0010\u0002\u001a@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/kick/centrifugo/CentrifugoClientListener;", "Lio/github/centrifugal/centrifuge/EventListener;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "onConnected", "client", "Lio/github/centrifugal/centrifuge/Client;", "event", "Lio/github/centrifugal/centrifuge/ConnectedEvent;", "onDisconnected", "Lio/github/centrifugal/centrifuge/DisconnectedEvent;", "onConnecting", "Lio/github/centrifugal/centrifuge/ConnectingEvent;", "onSubscribed", "Lio/github/centrifugal/centrifuge/ServerSubscribedEvent;", "onSubscribing", "Lio/github/centrifugal/centrifuge/ServerSubscribingEvent;", "onUnsubscribed", "Lio/github/centrifugal/centrifuge/ServerUnsubscribedEvent;", "onPublication", "Lio/github/centrifugal/centrifuge/ServerPublicationEvent;", "onJoin", "Lio/github/centrifugal/centrifuge/ServerJoinEvent;", "onLeave", "Lio/github/centrifugal/centrifuge/ServerLeaveEvent;", "onError", "Lio/github/centrifugal/centrifuge/ErrorEvent;", "Companion", "kickcentrifugo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CentrifugoClientListener extends EventListener {
    private static final String TAG = "CentrifugeClient";
    private final Function2<String, Map<String, ? extends Object>, Unit> sendEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public CentrifugoClientListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sendEvent = sendEvent;
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onConnected(Client client, ConnectedEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "connected with id " + event.getClient());
        this.sendEvent.invoke("onConnected", MapsKt.mapOf(TuplesKt.to("clientId", event.getClient())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onDisconnected(Client client, DisconnectedEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "disconnected with code " + event.getCode() + " and reason " + event.getReason());
        this.sendEvent.invoke("onDisconnected", MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(event.getCode())), TuplesKt.to("reason", event.getReason())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onConnecting(Client client, ConnectingEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "connecting with code " + event.getCode() + " and reason " + event.getReason());
        this.sendEvent.invoke("onConnecting", MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(event.getCode())), TuplesKt.to("reason", event.getReason())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onSubscribed(Client client, ServerSubscribedEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side subscribe to " + event.getChannel() + ", recovered " + event.getRecovered());
        this.sendEvent.invoke("onSubscribed", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel()), TuplesKt.to("recovered", event.getRecovered())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onSubscribing(Client client, ServerSubscribingEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side subscribing to " + event.getChannel());
        this.sendEvent.invoke("onSubscribing", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onUnsubscribed(Client client, ServerUnsubscribedEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side unsubscribe from " + event.getChannel());
        this.sendEvent.invoke("onUnsubscribed", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onPublication(Client client, ServerPublicationEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side publication from " + event.getChannel() + ", offset " + event.getOffset());
        this.sendEvent.invoke("onPublication", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel()), TuplesKt.to("offset", Long.valueOf(event.getOffset()))));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onJoin(Client client, ServerJoinEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side join in " + event.getChannel() + ", client " + event.getInfo().getClient());
        this.sendEvent.invoke("onJoin", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel()), TuplesKt.to("clientId", event.getInfo().getClient())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onLeave(Client client, ServerLeaveEvent event) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "server-side leave in " + event.getChannel() + ", client " + event.getInfo().getClient());
        this.sendEvent.invoke("onLeave", MapsKt.mapOf(TuplesKt.to("channel", event.getChannel()), TuplesKt.to("clientId", event.getInfo().getClient())));
    }

    @Override // io.github.centrifugal.centrifuge.EventListener
    public void onError(Client client, ErrorEvent event) {
        String string;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "client error " + event.getError());
        Function2<String, Map<String, ? extends Object>, Unit> function2 = this.sendEvent;
        Throwable error = event.getError();
        if (error == null || (string = error.getMessage()) == null) {
            string = event.getError().toString();
        }
        function2.invoke("onError", MapsKt.mapOf(TuplesKt.to("error", string)));
    }
}
