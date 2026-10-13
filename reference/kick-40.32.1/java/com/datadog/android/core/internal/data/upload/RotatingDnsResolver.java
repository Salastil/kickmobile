package com.datadog.android.core.internal.data.upload;

import com.datadog.android.internal.time.TimeProvider;
import com.facebook.hermes.intl.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.Dns;

/* JADX INFO: compiled from: RotatingDnsResolver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/RotatingDnsResolver;", "Lokhttp3/Dns;", "delegate", "ttl", "Lkotlin/time/Duration;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lokhttp3/Dns;JLcom/datadog/android/internal/time/TimeProvider;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "knownHosts", "", "", "Lcom/datadog/android/core/internal/data/upload/RotatingDnsResolver$ResolvedHost;", "J", "isValid", "", "knownHost", Constants.LOCALEMATCHER_LOOKUP, "", "Ljava/net/InetAddress;", "hostname", "safeCopy", "list", "Companion", "ResolvedHost", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotatingDnsResolver implements Dns {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long TTL_30_MIN;
    private final Dns delegate;
    private final Map<String, ResolvedHost> knownHosts;
    private final TimeProvider timeProvider;
    private final long ttl;

    public /* synthetic */ RotatingDnsResolver(Dns dns, long j, TimeProvider timeProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(dns, j, timeProvider);
    }

    private RotatingDnsResolver(Dns delegate, long j, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.delegate = delegate;
        this.ttl = j;
        this.timeProvider = timeProvider;
        this.knownHosts = new LinkedHashMap();
    }

    public /* synthetic */ RotatingDnsResolver(Dns dns, long j, TimeProvider timeProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns, (i & 2) != 0 ? TTL_30_MIN : j, timeProvider, null);
    }

    /* JADX INFO: compiled from: RotatingDnsResolver.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\bHÂ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001b\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/RotatingDnsResolver$ResolvedHost;", "", "hostname", "", "addresses", "", "Ljava/net/InetAddress;", "resolutionTimestamp", "", "(Ljava/lang/String;Ljava/util/List;J)V", "getAddresses", "()Ljava/util/List;", "getHostname", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "getAge", "Lkotlin/time/Duration;", "currentTime", "getAge-5sfh64U", "(J)J", "hashCode", "", "rotate", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ResolvedHost {
        private final List<InetAddress> addresses;
        private final String hostname;
        private final long resolutionTimestamp;

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final long getResolutionTimestamp() {
            return this.resolutionTimestamp;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResolvedHost copy$default(ResolvedHost resolvedHost, String str, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resolvedHost.hostname;
            }
            if ((i & 2) != 0) {
                list = resolvedHost.addresses;
            }
            if ((i & 4) != 0) {
                j = resolvedHost.resolutionTimestamp;
            }
            return resolvedHost.copy(str, list, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHostname() {
            return this.hostname;
        }

        public final List<InetAddress> component2() {
            return this.addresses;
        }

        public final ResolvedHost copy(String hostname, List<InetAddress> addresses, long resolutionTimestamp) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            Intrinsics.checkNotNullParameter(addresses, "addresses");
            return new ResolvedHost(hostname, addresses, resolutionTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResolvedHost)) {
                return false;
            }
            ResolvedHost resolvedHost = (ResolvedHost) other;
            return Intrinsics.areEqual(this.hostname, resolvedHost.hostname) && Intrinsics.areEqual(this.addresses, resolvedHost.addresses) && this.resolutionTimestamp == resolvedHost.resolutionTimestamp;
        }

        public int hashCode() {
            return (((this.hostname.hashCode() * 31) + this.addresses.hashCode()) * 31) + Long.hashCode(this.resolutionTimestamp);
        }

        public String toString() {
            return "ResolvedHost(hostname=" + this.hostname + ", addresses=" + this.addresses + ", resolutionTimestamp=" + this.resolutionTimestamp + ")";
        }

        public ResolvedHost(String hostname, List<InetAddress> addresses, long j) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            Intrinsics.checkNotNullParameter(addresses, "addresses");
            this.hostname = hostname;
            this.addresses = addresses;
            this.resolutionTimestamp = j;
        }

        public final String getHostname() {
            return this.hostname;
        }

        public final List<InetAddress> getAddresses() {
            return this.addresses;
        }

        /* JADX INFO: renamed from: getAge-5sfh64U, reason: not valid java name */
        public final long m11145getAge5sfh64U(long currentTime) {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(currentTime - this.resolutionTimestamp, DurationUnit.NANOSECONDS);
        }

        public final void rotate() {
            synchronized (this.addresses) {
                InetAddress inetAddress = (InetAddress) CollectionsKt.removeFirstOrNull(this.addresses);
                if (inetAddress != null) {
                    this.addresses.add(inetAddress);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ResolvedHost resolvedHost = this.knownHosts.get(hostname);
        if (resolvedHost != null && isValid(resolvedHost)) {
            resolvedHost.rotate();
            return safeCopy(resolvedHost.getAddresses());
        }
        List<InetAddress> listLookup = this.delegate.lookup(hostname);
        this.knownHosts.put(hostname, new ResolvedHost(hostname, CollectionsKt.toMutableList((Collection) listLookup), this.timeProvider.getDeviceElapsedTimeNanos()));
        return safeCopy(listLookup);
    }

    private final List<InetAddress> safeCopy(List<? extends InetAddress> list) {
        List<InetAddress> list2;
        synchronized (list) {
            list2 = CollectionsKt.toList(list);
        }
        return list2;
    }

    private final boolean isValid(ResolvedHost knownHost) {
        return Duration.m14063compareToLRDsOJo(knownHost.m11145getAge5sfh64U(this.timeProvider.getDeviceElapsedTimeNanos()), this.ttl) < 0 && !knownHost.getAddresses().isEmpty();
    }

    /* JADX INFO: compiled from: RotatingDnsResolver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/RotatingDnsResolver$Companion;", "", "()V", "TTL_30_MIN", "Lkotlin/time/Duration;", "getTTL_30_MIN-UwyO8pc", "()J", "J", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getTTL_30_MIN-UwyO8pc, reason: not valid java name */
        public final long m11144getTTL_30_MINUwyO8pc() {
            return RotatingDnsResolver.TTL_30_MIN;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        TTL_30_MIN = DurationKt.toDuration(30, DurationUnit.MINUTES);
    }
}
