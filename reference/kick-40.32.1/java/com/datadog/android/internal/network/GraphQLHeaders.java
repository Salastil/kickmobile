package com.datadog.android.internal.network;

import kotlin.Metadata;

/* JADX INFO: compiled from: GraphQLHeaders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/internal/network/GraphQLHeaders;", "", "headerValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHeaderValue", "()Ljava/lang/String;", "DD_GRAPHQL_NAME_HEADER", "DD_GRAPHQL_VARIABLES_HEADER", "DD_GRAPHQL_TYPE_HEADER", "DD_GRAPHQL_PAYLOAD_HEADER", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum GraphQLHeaders {
    DD_GRAPHQL_NAME_HEADER("_dd-custom-header-graph-ql-operation-name"),
    DD_GRAPHQL_VARIABLES_HEADER("_dd-custom-header-graph-ql-variables"),
    DD_GRAPHQL_TYPE_HEADER("_dd-custom-header-graph-ql-operation-type"),
    DD_GRAPHQL_PAYLOAD_HEADER("_dd-custom-header-graph-ql-payload");

    private final String headerValue;

    GraphQLHeaders(String str) {
        this.headerValue = str;
    }

    public final String getHeaderValue() {
        return this.headerValue;
    }
}
