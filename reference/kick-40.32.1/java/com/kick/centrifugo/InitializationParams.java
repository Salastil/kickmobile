package com.kick.centrifugo;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: KickcentrifugoModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/kick/centrifugo/InitializationParams;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "connectionUrl", "", "getConnectionUrl$annotations", "getConnectionUrl", "()Ljava/lang/String;", "connectionAuthUrl", "getConnectionAuthUrl$annotations", "getConnectionAuthUrl", "channelAuthUrl", "getChannelAuthUrl$annotations", "getChannelAuthUrl", "clientId", "getClientId$annotations", "getClientId", "headers", "", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "kickcentrifugo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InitializationParams implements Record {
    private final String connectionUrl = "";
    private final String connectionAuthUrl = "";
    private final String channelAuthUrl = "";
    private final String clientId = "";
    private final Map<String, String> headers = MapsKt.emptyMap();

    @Field
    public static /* synthetic */ void getChannelAuthUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getClientId$annotations() {
    }

    @Field
    public static /* synthetic */ void getConnectionAuthUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getConnectionUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    public final String getConnectionUrl() {
        return this.connectionUrl;
    }

    public final String getConnectionAuthUrl() {
        return this.connectionAuthUrl;
    }

    public final String getChannelAuthUrl() {
        return this.channelAuthUrl;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }
}
