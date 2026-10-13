package io.github.centrifugal.centrifuge;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.protobuf.ByteString;
import io.github.centrifugal.centrifuge.internal.backoff.Backoff;
import io.github.centrifugal.centrifuge.internal.protocol.Protocol;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java8.util.concurrent.CompletableFuture;
import java8.util.function.Consumer;
import java8.util.function.Function;

/* JADX INFO: loaded from: classes9.dex */
public class Subscription {
    private final Backoff backoff;
    private final String channel;
    private final Client client;
    private ByteString data;
    private boolean deltaNegotiated;
    private String epoch;
    private final Map<String, CompletableFuture<Throwable>> futures;
    private final SubscriptionEventListener listener;
    private long offset;
    private final SubscriptionOptions opts;
    private byte[] prevData;
    private long pushId;
    private boolean recover;
    private ScheduledFuture<?> refreshTask;
    private int resubscribeAttempts;
    private ScheduledFuture<?> resubscribeTask;
    private volatile SubscriptionState state;
    private long subscribeEpoch;
    private FilterNode tagsFilter;
    private String token;

    Subscription(Client client, String str, SubscriptionEventListener subscriptionEventListener, SubscriptionOptions subscriptionOptions) {
        this.state = SubscriptionState.UNSUBSCRIBED;
        this.futures = new ConcurrentHashMap();
        this.resubscribeAttempts = 0;
        this.pushId = 0L;
        this.subscribeEpoch = 0L;
        this.client = client;
        this.channel = str;
        this.listener = subscriptionEventListener;
        this.backoff = new Backoff();
        this.opts = subscriptionOptions;
        this.token = subscriptionOptions.getToken();
        if (subscriptionOptions.getData() != null) {
            this.data = ByteString.copyFrom(subscriptionOptions.getData());
        }
        this.tagsFilter = subscriptionOptions.getTagsFilter();
        this.prevData = null;
        this.deltaNegotiated = false;
        if (subscriptionOptions.getSince() != null) {
            this.offset = subscriptionOptions.getSince().getOffset();
            this.epoch = subscriptionOptions.getSince().getEpoch();
            this.recover = true;
        }
    }

    Subscription(Client client, String str, SubscriptionEventListener subscriptionEventListener) {
        this(client, str, subscriptionEventListener, new SubscriptionOptions());
    }

    void setState(SubscriptionState subscriptionState) {
        this.state = subscriptionState;
    }

    public SubscriptionState getState() {
        return this.state;
    }

    public String getChannel() {
        return this.channel;
    }

    SubscriptionEventListener getListener() {
        return this.listener;
    }

    long getOffset() {
        return this.offset;
    }

    private void setOffset(long j) {
        this.offset = j;
    }

    String getEpoch() {
        return this.epoch;
    }

    private void setEpoch(String str) {
        this.epoch = str;
    }

    void resubscribeIfNecessary() {
        if (getState() != SubscriptionState.SUBSCRIBING) {
            return;
        }
        sendSubscribe();
    }

    void sendRefresh() {
        if (this.opts.getTokenGetter() == null) {
            return;
        }
        final long j = this.subscribeEpoch + 1;
        this.subscribeEpoch = j;
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12231xca0c2cd2(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$2$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12231xca0c2cd2(final long j) {
        this.opts.getTokenGetter().getSubscriptionToken(new SubscriptionTokenEvent(getChannel()), new TokenCallback() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda3
            @Override // io.github.centrifugal.centrifuge.TokenCallback
            public final void Done(Throwable th, String str) {
                this.f$0.m12230x54920691(j, th, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$1$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12230x54920691(final long j, Throwable th, String str) {
        if (this.subscribeEpoch == j && getState() == SubscriptionState.SUBSCRIBED) {
            if (th != null) {
                if (th instanceof UnauthorizedException) {
                    failUnauthorized(true);
                    return;
                } else {
                    this.listener.onError(this, new SubscriptionErrorEvent(new SubscriptionTokenError(th)));
                    this.refreshTask = this.client.getScheduler().schedule(new Subscription$$ExternalSyntheticLambda11(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                    return;
                }
            }
            if (str == null || str.equals("")) {
                failUnauthorized(true);
            } else {
                this.token = str;
                this.client.subRefreshSynchronized(this.channel, str, new ResultCallback() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda16
                    @Override // io.github.centrifugal.centrifuge.ResultCallback
                    public final void onDone(Throwable th2, Object obj) {
                        this.f$0.m12229xdf17e050(j, th2, (Protocol.SubRefreshResult) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$0$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12229xdf17e050(long j, Throwable th, Protocol.SubRefreshResult subRefreshResult) {
        Throwable nullPointerException;
        if (this.subscribeEpoch == j && getState() == SubscriptionState.SUBSCRIBED) {
            if (th != null) {
                nullPointerException = th;
            } else {
                nullPointerException = subRefreshResult == null ? new NullPointerException() : null;
            }
            if (nullPointerException != null) {
                this.listener.onError(this, new SubscriptionErrorEvent(new SubscriptionRefreshError(nullPointerException)));
                if (th instanceof ReplyError) {
                    ReplyError replyError = (ReplyError) th;
                    if (replyError.isTemporary()) {
                        this.refreshTask = this.client.getScheduler().schedule(new Subscription$$ExternalSyntheticLambda11(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                        return;
                    } else {
                        _unsubscribe(true, replyError.getCode(), replyError.getMessage());
                        return;
                    }
                }
                this.refreshTask = this.client.getScheduler().schedule(new Subscription$$ExternalSyntheticLambda11(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                return;
            }
            if (subRefreshResult.getExpires()) {
                this.refreshTask = this.client.getScheduler().schedule(new Subscription$$ExternalSyntheticLambda11(this), subRefreshResult.getTtl(), TimeUnit.SECONDS);
            }
        }
    }

    void moveToSubscribing(int i, String str) {
        if (getState() == SubscriptionState.SUBSCRIBING) {
            clearSubscribingState();
        } else {
            setState(SubscriptionState.SUBSCRIBING);
            this.listener.onSubscribing(this, new SubscribingEvent(i, str));
        }
    }

    void moveToUnsubscribed(boolean z, int i, String str) {
        if (getState() == SubscriptionState.UNSUBSCRIBED) {
            return;
        }
        _unsubscribe(z, i, str);
    }

    void handlePublication(Protocol.Publication publication) throws Exception {
        ClientInfo clientInfoFromProtocolClientInfo = ClientInfo.fromProtocolClientInfo(publication.getInfo());
        PublicationEvent publicationEvent = new PublicationEvent();
        byte[] byteArray = publication.getData().toByteArray();
        if (this.deltaNegotiated) {
            byte[] prevData = getPrevData();
            if (prevData != null && publication.getDelta()) {
                byteArray = Fossil.applyDelta(prevData, byteArray);
            }
            setPrevData(byteArray);
        }
        publicationEvent.setData(byteArray);
        publicationEvent.setInfo(clientInfoFromProtocolClientInfo);
        publicationEvent.setOffset(publication.getOffset());
        publicationEvent.setTags(publication.getTagsMap());
        if (publication.getOffset() > 0) {
            setOffset(publication.getOffset());
        }
        this.listener.onPublication(this, publicationEvent);
    }

    void moveToSubscribed(Protocol.SubscribeResult subscribeResult) throws Exception {
        setState(SubscriptionState.SUBSCRIBED);
        if (subscribeResult.getRecoverable()) {
            this.recover = true;
        }
        setEpoch(subscribeResult.getEpoch());
        this.deltaNegotiated = subscribeResult.getDelta();
        setPushId(subscribeResult.getId());
        this.listener.onSubscribed(this, new SubscribedEvent(Boolean.valueOf(subscribeResult.getWasRecovering()), Boolean.valueOf(subscribeResult.getRecovered()), Boolean.valueOf(subscribeResult.getPositioned()), Boolean.valueOf(subscribeResult.getRecoverable()), (subscribeResult.getPositioned() || subscribeResult.getRecoverable()) ? new StreamPosition(subscribeResult.getOffset(), subscribeResult.getEpoch()) : null, subscribeResult.getData() != null ? subscribeResult.getData().toByteArray() : null));
        if (subscribeResult.getPublicationsCount() > 0) {
            Iterator<Protocol.Publication> it = subscribeResult.getPublicationsList().iterator();
            while (it.hasNext()) {
                this.client.handlePub(this.channel, it.next());
            }
        } else {
            setOffset(subscribeResult.getOffset());
        }
        Iterator<Map.Entry<String, CompletableFuture<Throwable>>> it2 = this.futures.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().complete(null);
        }
        this.futures.clear();
        if (subscribeResult.getExpires()) {
            this.refreshTask = this.client.getScheduler().schedule(new Subscription$$ExternalSyntheticLambda11(this), subscribeResult.getTtl(), TimeUnit.SECONDS);
        }
    }

    void subscribeError(ReplyError replyError) {
        if (replyError.getCode() == 112 && this.opts.getStateGetter() != null) {
            this.recover = false;
            setOffset(0L);
            setEpoch("");
            setPrevData(null);
            scheduleResubscribe();
            return;
        }
        this.listener.onError(this, new SubscriptionErrorEvent(new SubscriptionSubscribeError(replyError)));
        if (replyError.getCode() == 109) {
            this.token = "";
            scheduleResubscribe();
        } else if (replyError.isTemporary()) {
            scheduleResubscribe();
        } else {
            _unsubscribe(false, replyError.getCode(), replyError.getMessage());
        }
    }

    public void setTagsFilter(FilterNode filterNode) {
        if (filterNode != null && this.opts.getDelta() != null && !this.opts.getDelta().isEmpty()) {
            throw new IllegalStateException("cannot use delta and tags filter together");
        }
        this.tagsFilter = filterNode;
    }

    public void subscribe() {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12234lambda$subscribe$3$iogithubcentrifugalcentrifugeSubscription();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$subscribe$3$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12234lambda$subscribe$3$iogithubcentrifugalcentrifugeSubscription() {
        if (getState() == SubscriptionState.SUBSCRIBED || getState() == SubscriptionState.SUBSCRIBING) {
            return;
        }
        setState(SubscriptionState.SUBSCRIBING);
        this.listener.onSubscribing(this, new SubscribingEvent(0, "subscribe called"));
        sendSubscribe();
    }

    Protocol.SubscribeRequest createSubscribeRequest() {
        boolean recover = getRecover();
        StreamPosition streamPosition = new StreamPosition();
        if (recover) {
            streamPosition.setOffset(getOffset());
            streamPosition.setEpoch(getEpoch());
        }
        Protocol.SubscribeRequest.Builder builderNewBuilder = Protocol.SubscribeRequest.newBuilder();
        builderNewBuilder.setChannel(this.channel).setToken(this.token);
        ByteString byteString = this.data;
        if (byteString != null) {
            builderNewBuilder.setData(byteString);
        }
        if (recover) {
            builderNewBuilder.setRecover(true).setEpoch(streamPosition.getEpoch()).setOffset(streamPosition.getOffset());
        }
        builderNewBuilder.setPositioned(this.opts.isPositioned());
        builderNewBuilder.setRecoverable(this.opts.isRecoverable());
        builderNewBuilder.setJoinLeave(this.opts.isJoinLeave());
        builderNewBuilder.setDelta(this.opts.getDelta());
        FilterNode filterNode = this.tagsFilter;
        if (filterNode != null) {
            builderNewBuilder.setTf(filterNode.getProtoNode());
        }
        builderNewBuilder.setFlag(this.opts.getStateGetter() != null ? 3L : 1L);
        return builderNewBuilder.build();
    }

    void sendSubscribe() {
        if (this.opts.getStateGetter() != null && !getRecover()) {
            final long j = this.subscribeEpoch + 1;
            this.subscribeEpoch = j;
            this.opts.getStateGetter().getSubscriptionState(new SubscriptionGetStateEvent(this.channel), new StateCallback() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda7
                @Override // io.github.centrifugal.centrifuge.StateCallback
                public final void Done(Throwable th, StreamPosition streamPosition) {
                    this.f$0.m12233xefad9d44(j, th, streamPosition);
                }
            });
            return;
        }
        continueSubscribe();
    }

    /* JADX INFO: renamed from: lambda$sendSubscribe$5$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12233xefad9d44(final long j, final Throwable th, final StreamPosition streamPosition) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12232x7a337703(j, th, streamPosition);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendSubscribe$4$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12232x7a337703(long j, Throwable th, StreamPosition streamPosition) {
        if (this.subscribeEpoch == j && getState() == SubscriptionState.SUBSCRIBING) {
            if (th != null || streamPosition == null) {
                if (th == null) {
                    th = new NullPointerException("null stream position");
                }
                this.listener.onError(this, new SubscriptionErrorEvent(new SubscriptionGetStateError(th)));
                scheduleResubscribe();
                return;
            }
            this.recover = true;
            setOffset(streamPosition.getOffset());
            setEpoch(streamPosition.getEpoch() == null ? "" : streamPosition.getEpoch());
            continueSubscribe();
        }
    }

    private void continueSubscribe() {
        if (this.token.equals("") && this.opts.getTokenGetter() != null) {
            final long j = this.subscribeEpoch + 1;
            this.subscribeEpoch = j;
            this.opts.getTokenGetter().getSubscriptionToken(new SubscriptionTokenEvent(this.channel), new TokenCallback() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda8
                @Override // io.github.centrifugal.centrifuge.TokenCallback
                public final void Done(Throwable th, String str) {
                    this.f$0.m12216xb0a05007(j, th, str);
                }
            });
            return;
        }
        this.client.sendSubscribe(this, createSubscribeRequest());
    }

    /* JADX INFO: renamed from: lambda$continueSubscribe$7$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12216xb0a05007(final long j, final Throwable th, final String str) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12215x3b2629c6(j, th, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$continueSubscribe$6$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12215x3b2629c6(long j, Throwable th, String str) {
        if (this.subscribeEpoch == j && getState() == SubscriptionState.SUBSCRIBING) {
            if (th != null) {
                if (th instanceof UnauthorizedException) {
                    failUnauthorized(true);
                    return;
                } else {
                    this.listener.onError(this, new SubscriptionErrorEvent(new SubscriptionTokenError(th)));
                    scheduleResubscribe();
                    return;
                }
            }
            if (str == null || str.equals("")) {
                failUnauthorized(false);
            } else {
                this.token = str;
                this.client.sendSubscribe(this, createSubscribeRequest());
            }
        }
    }

    public void unsubscribe() {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12235xcf8bf6f6();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$unsubscribe$8$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12235xcf8bf6f6() {
        _unsubscribe(true, 0, "unsubscribe called");
    }

    private void clearSubscribedState() {
        ScheduledFuture<?> scheduledFuture = this.refreshTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.refreshTask = null;
        }
    }

    private void clearSubscribingState() {
        ScheduledFuture<?> scheduledFuture = this.resubscribeTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.resubscribeTask = null;
        }
    }

    private void _unsubscribe(boolean z, int i, String str) {
        if (getState() == SubscriptionState.UNSUBSCRIBED) {
            return;
        }
        if (getState() == SubscriptionState.SUBSCRIBED) {
            clearSubscribedState();
        } else if (getState() == SubscriptionState.SUBSCRIBING) {
            clearSubscribingState();
        }
        setState(SubscriptionState.UNSUBSCRIBED);
        setPushId(0L);
        if (z) {
            this.client.sendUnsubscribe(getChannel());
        }
        Iterator<Map.Entry<String, CompletableFuture<Throwable>>> it = this.futures.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().complete(new SubscriptionStateError(getState()));
        }
        this.futures.clear();
        this.listener.onUnsubscribed(this, new UnsubscribedEvent(i, str));
    }

    private void scheduleResubscribe() {
        if (getState() != SubscriptionState.SUBSCRIBING) {
            return;
        }
        this.resubscribeTask = this.client.getScheduler().schedule(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startResubscribing();
            }
        }, this.backoff.duration(this.resubscribeAttempts, this.opts.getMinResubscribeDelay(), this.opts.getMaxResubscribeDelay()), TimeUnit.MILLISECONDS);
        this.resubscribeAttempts++;
    }

    void startResubscribing() {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sendSubscribe();
            }
        });
    }

    boolean getRecover() {
        return this.recover;
    }

    private void failUnauthorized(boolean z) {
        _unsubscribe(z, 1, "unauthorized");
    }

    public void publish(final byte[] bArr, final ResultCallback<PublishResult> resultCallback) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12226lambda$publish$9$iogithubcentrifugalcentrifugeSubscription(bArr, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: publishSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12226lambda$publish$9$iogithubcentrifugalcentrifugeSubscription(final byte[] bArr, final ResultCallback<PublishResult> resultCallback) {
        CompletableFuture<Throwable> completableFuture = new CompletableFuture<>();
        final String string = UUID.randomUUID().toString();
        this.futures.put(string, completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda1
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12227x4535794b(resultCallback, string, bArr, (Throwable) obj);
            }
        }).orTimeout(this.client.getOpts().getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda2
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12228xbaaf9f8c(string, resultCallback, (Throwable) obj);
            }
        });
        if (getState() == SubscriptionState.SUBSCRIBED) {
            completableFuture.complete(null);
        }
    }

    /* JADX INFO: renamed from: lambda$publishSynchronized$10$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12227x4535794b(ResultCallback resultCallback, String str, byte[] bArr, Throwable th) {
        if (th != null) {
            resultCallback.onDone(th, null);
        } else {
            this.futures.remove(str);
            this.client.publish(getChannel(), bArr, resultCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$publishSynchronized$11$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ Void m12228xbaaf9f8c(String str, ResultCallback resultCallback, Throwable th) {
        this.futures.remove(str);
        resultCallback.onDone(th, null);
        return null;
    }

    public void history(final HistoryOptions historyOptions, final ResultCallback<HistoryResult> resultCallback) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12217lambda$history$12$iogithubcentrifugalcentrifugeSubscription(historyOptions, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: historySynchronized, reason: merged with bridge method [inline-methods] */
    public void m12217lambda$history$12$iogithubcentrifugalcentrifugeSubscription(final HistoryOptions historyOptions, final ResultCallback<HistoryResult> resultCallback) {
        CompletableFuture<Throwable> completableFuture = new CompletableFuture<>();
        final String string = UUID.randomUUID().toString();
        this.futures.put(string, completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda5
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12218xcb2202a9(resultCallback, string, historyOptions, (Throwable) obj);
            }
        }).orTimeout(this.client.getOpts().getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda6
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12219x409c28ea(string, resultCallback, (Throwable) obj);
            }
        });
        if (getState() == SubscriptionState.SUBSCRIBED) {
            completableFuture.complete(null);
        }
    }

    /* JADX INFO: renamed from: lambda$historySynchronized$13$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12218xcb2202a9(ResultCallback resultCallback, String str, HistoryOptions historyOptions, Throwable th) {
        if (th != null) {
            resultCallback.onDone(th, null);
        } else {
            this.futures.remove(str);
            this.client.history(getChannel(), historyOptions, resultCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$historySynchronized$14$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ Void m12219x409c28ea(String str, ResultCallback resultCallback, Throwable th) {
        this.futures.remove(str);
        resultCallback.onDone(th, null);
        return null;
    }

    public void presence(final ResultCallback<PresenceResult> resultCallback) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12220lambda$presence$15$iogithubcentrifugalcentrifugeSubscription(resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: presenceSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12220lambda$presence$15$iogithubcentrifugalcentrifugeSubscription(final ResultCallback<PresenceResult> resultCallback) {
        CompletableFuture<Throwable> completableFuture = new CompletableFuture<>();
        final String string = UUID.randomUUID().toString();
        this.futures.put(string, completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda12
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12224xbcd9d08b(resultCallback, string, (Throwable) obj);
            }
        }).orTimeout(this.client.getOpts().getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda13
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12225x3253f6cc(string, resultCallback, (Throwable) obj);
            }
        });
        if (getState() == SubscriptionState.SUBSCRIBED) {
            completableFuture.complete(null);
        }
    }

    /* JADX INFO: renamed from: lambda$presenceSynchronized$16$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12224xbcd9d08b(ResultCallback resultCallback, String str, Throwable th) {
        if (th != null) {
            resultCallback.onDone(th, null);
        } else {
            this.futures.remove(str);
            this.client.presence(getChannel(), resultCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$presenceSynchronized$17$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ Void m12225x3253f6cc(String str, ResultCallback resultCallback, Throwable th) {
        this.futures.remove(str);
        resultCallback.onDone(th, null);
        return null;
    }

    public void presenceStats(final ResultCallback<PresenceStatsResult> resultCallback) {
        this.client.getExecutor().submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12221xd1fcf292(resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: presenceStatsSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12221xd1fcf292(final ResultCallback<PresenceStatsResult> resultCallback) {
        CompletableFuture<Throwable> completableFuture = new CompletableFuture<>();
        final String string = UUID.randomUUID().toString();
        this.futures.put(string, completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda17
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12222x7664009f(resultCallback, string, (Throwable) obj);
            }
        }).orTimeout(this.client.getOpts().getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Subscription$$ExternalSyntheticLambda18
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12223x8ee34a35(string, resultCallback, (Throwable) obj);
            }
        });
        if (getState() == SubscriptionState.SUBSCRIBED) {
            completableFuture.complete(null);
        }
    }

    /* JADX INFO: renamed from: lambda$presenceStatsSynchronized$19$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ void m12222x7664009f(ResultCallback resultCallback, String str, Throwable th) {
        if (th != null) {
            resultCallback.onDone(th, null);
        } else {
            this.futures.remove(str);
            this.client.presenceStats(getChannel(), resultCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$presenceStatsSynchronized$20$io-github-centrifugal-centrifuge-Subscription, reason: not valid java name */
    /* synthetic */ Void m12223x8ee34a35(String str, ResultCallback resultCallback, Throwable th) {
        this.futures.remove(str);
        resultCallback.onDone(th, null);
        return null;
    }

    private byte[] getPrevData() {
        return this.prevData;
    }

    private void setPrevData(byte[] bArr) {
        this.prevData = bArr;
    }

    private void setPushId(long j) {
        if (j == 0 && this.pushId == 0) {
            return;
        }
        long j2 = this.pushId;
        this.pushId = j;
        this.client.updateSubscriptionPushId(this, j2, j);
    }

    void invalidateState() {
        this.token = "";
        this.offset = 0L;
        this.epoch = "_";
        this.prevData = null;
        setPushId(0L);
    }
}
