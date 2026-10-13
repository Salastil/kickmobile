package io.github.centrifugal.centrifuge;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface Dns {
    List<InetAddress> resolve(String str) throws UnknownHostException;
}
