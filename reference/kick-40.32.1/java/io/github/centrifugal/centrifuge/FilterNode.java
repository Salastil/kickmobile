package io.github.centrifugal.centrifuge;

import io.github.centrifugal.centrifuge.internal.protocol.Protocol;

/* JADX INFO: loaded from: classes9.dex */
public final class FilterNode {
    private final Protocol.FilterNode node;

    FilterNode(Protocol.FilterNode filterNode) {
        this.node = filterNode;
    }

    Protocol.FilterNode getProtoNode() {
        return this.node;
    }
}
