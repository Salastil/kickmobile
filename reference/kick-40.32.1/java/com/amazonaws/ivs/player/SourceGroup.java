package com.amazonaws.ivs.player;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class SourceGroup {
    private final String name;
    private final Set<Quality> qualities;

    private SourceGroup(String str, Set<Quality> set) {
        this.name = str;
        this.qualities = set;
    }

    public String getName() {
        return this.name;
    }

    public Set<Quality> getQualities() {
        return this.qualities;
    }
}
