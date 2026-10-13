package com.amazon.mediatailorsdk.network.session.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: SessionInitRequest.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rBO\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\u0004\b\b\u0010\tR-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest;", "", "rootParams", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/collections/HashMap;", "playerParams", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getRootParams", "()Ljava/util/HashMap;", "getPlayerParams", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = SessionInitRequestSerializer.class)
public final class SessionInitRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HashMap<String, String> playerParams;
    private final HashMap<String, JsonElement> rootParams;

    /* JADX INFO: compiled from: SessionInitRequest.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SessionInitRequest> serializer() {
            return SessionInitRequestSerializer.INSTANCE;
        }
    }

    public SessionInitRequest(HashMap<String, JsonElement> rootParams, HashMap<String, String> playerParams) {
        Intrinsics.checkNotNullParameter(rootParams, "rootParams");
        Intrinsics.checkNotNullParameter(playerParams, "playerParams");
        this.rootParams = rootParams;
        this.playerParams = playerParams;
    }

    public final HashMap<String, JsonElement> getRootParams() {
        return this.rootParams;
    }

    public final HashMap<String, String> getPlayerParams() {
        return this.playerParams;
    }
}
