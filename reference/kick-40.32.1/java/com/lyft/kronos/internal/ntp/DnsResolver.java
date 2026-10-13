package com.lyft.kronos.internal.ntp;

import com.datadog.android.log.LogAttributes;
import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.Metadata;

/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/lyft/kronos/internal/ntp/DnsResolver;", "", "resolve", "Ljava/net/InetAddress;", LogAttributes.HOST, "", "kronos-java"}, k = 1, mv = {1, 4, 0})
public interface DnsResolver {
    InetAddress resolve(String host) throws UnknownHostException;
}
