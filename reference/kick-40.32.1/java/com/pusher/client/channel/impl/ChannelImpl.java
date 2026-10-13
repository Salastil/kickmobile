package com.pusher.client.channel.impl;

import com.pusher.client.util.Factory;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelImpl extends BaseChannel {
    protected final String name;

    public ChannelImpl(String str, Factory factory) {
        super(factory);
        if (str == null) {
            throw new IllegalArgumentException("Cannot subscribe to a channel with a null name");
        }
        for (String str2 : getDisallowedNameExpressions()) {
            if (str.matches(str2)) {
                throw new IllegalArgumentException("Channel name " + str + " is invalid. Private channel names must start with \"private-\" and presence channel names must start with \"presence-\"");
            }
        }
        this.name = str;
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.Channel
    public String getName() {
        return this.name;
    }

    @Override // com.pusher.client.channel.impl.BaseChannel
    public String toString() {
        return String.format("[Public Channel: name=%s]", this.name);
    }

    protected String[] getDisallowedNameExpressions() {
        return new String[]{"^private-.*", "^presence-.*"};
    }
}
