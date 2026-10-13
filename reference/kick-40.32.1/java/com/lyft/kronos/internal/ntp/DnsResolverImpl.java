package com.lyft.kronos.internal.ntp;

import com.datadog.android.log.LogAttributes;
import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/lyft/kronos/internal/ntp/DnsResolverImpl;", "Lcom/lyft/kronos/internal/ntp/DnsResolver;", "()V", "resolve", "Ljava/net/InetAddress;", LogAttributes.HOST, "", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class DnsResolverImpl implements DnsResolver {
    @Override // com.lyft.kronos.internal.ntp.DnsResolver
    public InetAddress resolve(String host) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(host, "host");
        InetAddress byName = InetAddress.getByName(host);
        Intrinsics.checkNotNullExpressionValue(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
