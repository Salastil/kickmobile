package io.github.centrifugal.centrifuge;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes9.dex */
public class SubscriptionOptions {
    private byte[] data;
    private StreamPosition since;
    private SubscriptionStateGetter stateGetter;
    private FilterNode tagsFilter;
    public SubscriptionTokenGetter tokenGetter;
    private String token = "";
    private int minResubscribeDelay = 500;
    private int maxResubscribeDelay = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private boolean positioned = false;
    private boolean recoverable = false;
    private boolean joinLeave = false;
    private String delta = "";

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public SubscriptionTokenGetter getTokenGetter() {
        return this.tokenGetter;
    }

    public void setTokenGetter(SubscriptionTokenGetter subscriptionTokenGetter) {
        this.tokenGetter = subscriptionTokenGetter;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int getMinResubscribeDelay() {
        return this.minResubscribeDelay;
    }

    public void setMinResubscribeDelay(int i) {
        this.minResubscribeDelay = i;
    }

    public int getMaxResubscribeDelay() {
        return this.maxResubscribeDelay;
    }

    public void setMaxResubscribeDelay(int i) {
        this.maxResubscribeDelay = i;
    }

    public boolean isPositioned() {
        return this.positioned;
    }

    public void setPositioned(boolean z) {
        this.positioned = z;
    }

    public boolean isRecoverable() {
        return this.recoverable;
    }

    public void setRecoverable(boolean z) {
        this.recoverable = z;
    }

    public boolean isJoinLeave() {
        return this.joinLeave;
    }

    public void setJoinLeave(boolean z) {
        this.joinLeave = z;
    }

    public String getDelta() {
        return this.delta;
    }

    public void setDelta(String str) {
        this.delta = str;
    }

    public FilterNode getTagsFilter() {
        return this.tagsFilter;
    }

    public void setTagsFilter(FilterNode filterNode) {
        this.tagsFilter = filterNode;
    }

    public SubscriptionStateGetter getStateGetter() {
        return this.stateGetter;
    }

    public void setStateGetter(SubscriptionStateGetter subscriptionStateGetter) {
        this.stateGetter = subscriptionStateGetter;
    }

    public void setSince(StreamPosition streamPosition) {
        this.since = streamPosition;
    }

    public StreamPosition getSince() {
        return this.since;
    }
}
