package com.pusher.client.channel;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes8.dex */
public class User {
    private static final Gson GSON = new Gson();
    private final String id;
    private final String jsonData;

    public User(String str, String str2) {
        this.id = str;
        this.jsonData = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getInfo() {
        return this.jsonData;
    }

    public <V> V getInfo(Class<V> cls) {
        return (V) GSON.fromJson(this.jsonData, (Class) cls);
    }

    public String toString() {
        return String.format("[User id=%s, data=%s]", this.id, this.jsonData);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        String str = this.jsonData;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (getId().equals(user.getId()) && getInfo().equals(user.getInfo())) {
                return true;
            }
        }
        return false;
    }
}
