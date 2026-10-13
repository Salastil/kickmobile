package com.pusher.client.example;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.PrivateChannel;
import com.pusher.client.channel.PrivateChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.util.HttpChannelAuthorizer;

/* JADX INFO: loaded from: classes8.dex */
public class PrivateChannelExampleApp {
    private final PrivateChannel channel;
    private final String channelAuthorizationEndpoint = "http://localhost:3030/pusher/auth";
    private String channelName;
    private String channelsKey;
    private String cluster;
    private String eventName;

    public static void main(String[] strArr) {
        new PrivateChannelExampleApp(strArr);
    }

    /* JADX INFO: Infinite loop detected, blocks: 22, insns: 0 */
    PrivateChannelExampleApp(String[] strArr) {
        this.channelsKey = "FILL_ME_IN";
        this.channelName = "my-channel";
        this.eventName = "my-event";
        this.cluster = "eu";
        int length = strArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length == 4) {
                        this.cluster = strArr[3];
                    }
                }
                this.eventName = strArr[2];
            }
            this.channelName = strArr[1];
            this.channelsKey = strArr[0];
        } else {
            this.channelsKey = strArr[0];
        }
        Pusher pusher = new Pusher(this.channelsKey, new PusherOptions().setUseTLS(true).setCluster(this.cluster).setChannelAuthorizer(new HttpChannelAuthorizer("http://localhost:3030/pusher/auth")));
        pusher.connect(new ConnectionEventListener() { // from class: com.pusher.client.example.PrivateChannelExampleApp.1
            @Override // com.pusher.client.connection.ConnectionEventListener
            public void onConnectionStateChange(ConnectionStateChange connectionStateChange) {
                System.out.printf("Connection state changed from [%s] to [%s]%n", connectionStateChange.getPreviousState(), connectionStateChange.getCurrentState());
            }

            @Override // com.pusher.client.connection.ConnectionEventListener
            public void onError(String str, String str2, Exception exc) {
                System.out.printf("An error was received with message [%s], code [%s], exception [%s]%n", str, str2, exc);
            }
        }, new ConnectionState[0]);
        this.channel = pusher.subscribePrivate(this.channelName, new PrivateChannelEventListener() { // from class: com.pusher.client.example.PrivateChannelExampleApp.2
            @Override // com.pusher.client.channel.ChannelEventListener
            public void onSubscriptionSucceeded(String str) {
                System.out.printf("Subscription to channel [%s] succeeded%n", str);
            }

            @Override // com.pusher.client.channel.SubscriptionEventListener
            public void onEvent(PusherEvent pusherEvent) {
                System.out.printf("Received event [%s]%n", pusherEvent.toString());
            }

            @Override // com.pusher.client.channel.PrivateChannelEventListener
            public void onAuthenticationFailure(String str, Exception exc) {
                System.out.printf("Authorization failure due to [%s], exception was [%s]%n", str, exc);
            }
        }, this.eventName);
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
