package com.facebook.react.modules.network;

import android.content.Context;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlock;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: OkHttpClientProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/modules/network/OkHttpClientProvider;", "", "<init>", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient$ReactAndroid", "()Lokhttp3/OkHttpClient;", "setClient$ReactAndroid", "(Lokhttp3/OkHttpClient;)V", "factory", "Lcom/facebook/react/modules/network/OkHttpClientFactory;", "getFactory$ReactAndroid", "()Lcom/facebook/react/modules/network/OkHttpClientFactory;", "setFactory$ReactAndroid", "(Lcom/facebook/react/modules/network/OkHttpClientFactory;)V", "setOkHttpClientFactory", "", "getOkHttpClient", "createClient", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "createClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "cacheSize", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OkHttpClientProvider {
    public static final OkHttpClientProvider INSTANCE = new OkHttpClientProvider();
    private static OkHttpClient client;
    private static OkHttpClientFactory factory;

    private OkHttpClientProvider() {
    }

    public final OkHttpClient getClient$ReactAndroid() {
        return client;
    }

    public final void setClient$ReactAndroid(OkHttpClient okHttpClient) {
        client = okHttpClient;
    }

    public final OkHttpClientFactory getFactory$ReactAndroid() {
        return factory;
    }

    public final void setFactory$ReactAndroid(OkHttpClientFactory okHttpClientFactory) {
        factory = okHttpClientFactory;
    }

    @JvmStatic
    public static final void setOkHttpClientFactory(OkHttpClientFactory factory2) {
        factory = factory2;
    }

    @JvmStatic
    public static final OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = client;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient okHttpClientCreateClient = createClient();
        client = okHttpClientCreateClient;
        return okHttpClientCreateClient;
    }

    @JvmStatic
    public static final OkHttpClient createClient() {
        OkHttpClient okHttpClientCreateNewNetworkModuleClient;
        OkHttpClientFactory okHttpClientFactory = factory;
        return (okHttpClientFactory == null || (okHttpClientCreateNewNetworkModuleClient = okHttpClientFactory.createNewNetworkModuleClient()) == null) ? createClientBuilder().build() : okHttpClientCreateNewNetworkModuleClient;
    }

    @JvmStatic
    public static final OkHttpClient createClient(Context context) {
        OkHttpClient okHttpClientCreateNewNetworkModuleClient;
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClientFactory okHttpClientFactory = factory;
        return (okHttpClientFactory == null || (okHttpClientCreateNewNetworkModuleClient = okHttpClientFactory.createNewNetworkModuleClient()) == null) ? createClientBuilder(context).build() : okHttpClientCreateNewNetworkModuleClient;
    }

    @JvmStatic
    public static final OkHttpClient.Builder createClientBuilder() {
        return new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());
    }

    @JvmStatic
    public static final OkHttpClient.Builder createClientBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createClientBuilder(context, TLVBlock.MAXIMUM_DATA_SIZE_MB);
    }

    @JvmStatic
    public static final OkHttpClient.Builder createClientBuilder(Context context, int cacheSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builderCreateClientBuilder = createClientBuilder();
        return cacheSize == 0 ? builderCreateClientBuilder : builderCreateClientBuilder.cache(new Cache(new File(context.getCacheDir(), "http-cache"), cacheSize));
    }
}
