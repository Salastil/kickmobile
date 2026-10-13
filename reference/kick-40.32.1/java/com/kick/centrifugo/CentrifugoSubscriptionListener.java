package com.kick.centrifugo;

import android.util.Log;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.centrifugal.centrifuge.JoinEvent;
import io.github.centrifugal.centrifuge.LeaveEvent;
import io.github.centrifugal.centrifuge.PublicationEvent;
import io.github.centrifugal.centrifuge.SubscribedEvent;
import io.github.centrifugal.centrifuge.SubscribingEvent;
import io.github.centrifugal.centrifuge.Subscription;
import io.github.centrifugal.centrifuge.SubscriptionErrorEvent;
import io.github.centrifugal.centrifuge.SubscriptionEventListener;
import io.github.centrifugal.centrifuge.UnsubscribedEvent;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CentrifugoSubscriptionListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBM\u0012D\u0010\u0002\u001a@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001dH\u0016RL\u0010\u0002\u001a@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/kick/centrifugo/CentrifugoSubscriptionListener;", "Lio/github/centrifugal/centrifuge/SubscriptionEventListener;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "onSubscribed", "sub", "Lio/github/centrifugal/centrifuge/Subscription;", "event", "Lio/github/centrifugal/centrifuge/SubscribedEvent;", "onSubscribing", "Lio/github/centrifugal/centrifuge/SubscribingEvent;", "onUnsubscribed", "Lio/github/centrifugal/centrifuge/UnsubscribedEvent;", "onError", "Lio/github/centrifugal/centrifuge/SubscriptionErrorEvent;", "onPublication", "Lio/github/centrifugal/centrifuge/PublicationEvent;", "onJoin", "Lio/github/centrifugal/centrifuge/JoinEvent;", "onLeave", "Lio/github/centrifugal/centrifuge/LeaveEvent;", "Companion", "kickcentrifugo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CentrifugoSubscriptionListener extends SubscriptionEventListener {
    private static final String TAG = "CentrifugeSubs";
    private final Function2<String, Map<String, ? extends Object>, Unit> sendEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public CentrifugoSubscriptionListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sendEvent = sendEvent;
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onSubscribed(Subscription sub, SubscribedEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "successfully subscribed to channel " + sub.getChannel() + ", was recovering " + event.wasRecovering() + ", recovered " + event.getRecovered());
        this.sendEvent.invoke("onClientSubscribed", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("wasRecovering", event.wasRecovering()), TuplesKt.to("recovered", event.getRecovered())));
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onSubscribing(Subscription sub, SubscribingEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "subscribing to channel " + sub.getChannel() + ServerSentEventKt.SPACE + event.getCode() + ServerSentEventKt.SPACE + event.getReason());
        this.sendEvent.invoke("onClientSubscribing", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("code", Integer.valueOf(event.getCode())), TuplesKt.to("reason", event.getReason())));
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onUnsubscribed(Subscription sub, UnsubscribedEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "unsubscribed from channel " + sub.getChannel() + ServerSentEventKt.SPACE + event.getCode() + ServerSentEventKt.SPACE + event.getReason());
        this.sendEvent.invoke("onClientUnsubscribed", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("code", Integer.valueOf(event.getCode())), TuplesKt.to("reason", event.getReason())));
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onError(Subscription sub, SubscriptionErrorEvent event) {
        String string;
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "subscription error: " + event.getError());
        Function2<String, Map<String, ? extends Object>, Unit> function2 = this.sendEvent;
        Throwable error = event.getError();
        if (error == null || (string = error.getMessage()) == null) {
            string = event.getError().toString();
        }
        function2.invoke("onClientError", MapsKt.mapOf(TuplesKt.to("error", string)));
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onPublication(Subscription sub, PublicationEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        byte[] data = event.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        String str = new String(data, Charsets.UTF_8);
        Log.d(TAG, "message from channel " + sub.getChannel() + ServerSentEventKt.SPACE + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.sendEvent.invoke("onClientPublication", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("event", jSONObject.getString("event")), TuplesKt.to("data", jSONObject.getString("data"))));
        } catch (JSONException unused) {
            this.sendEvent.invoke("onClientEventParsingError", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel())));
        }
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onJoin(Subscription sub, JoinEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "client joined channel " + sub.getChannel() + ", user ID " + event.getInfo().getUser());
        this.sendEvent.invoke("onClientJoin", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("userId", event.getInfo().getUser())));
    }

    @Override // io.github.centrifugal.centrifuge.SubscriptionEventListener
    public void onLeave(Subscription sub, LeaveEvent event) {
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(TAG, "client left channel " + sub.getChannel() + ", user ID " + event.getInfo().getUser());
        this.sendEvent.invoke("onClientLeave", MapsKt.mapOf(TuplesKt.to("channel", sub.getChannel()), TuplesKt.to("userId", event.getInfo().getUser())));
    }
}
