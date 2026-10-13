package com.kick.imagecache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: KickImageCacheModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.kick.imagecache.KickImageCacheModule$definition$1$3$1", f = "KickImageCacheModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class KickImageCacheModule$definition$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ String $urlString;
    int label;
    final /* synthetic */ KickImageCacheModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KickImageCacheModule$definition$1$3$1(String str, KickImageCacheModule kickImageCacheModule, Continuation<? super KickImageCacheModule$definition$1$3$1> continuation) {
        super(2, continuation);
        this.$urlString = str;
        this.this$0 = kickImageCacheModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KickImageCacheModule$definition$1$3$1(this.$urlString, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<String, String>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return ((KickImageCacheModule$definition$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws BadUrlException, IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            URLConnection uRLConnectionOpenConnection = new URL(this.$urlString).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                if (httpURLConnection.getResponseCode() != 200) {
                    throw new BadServerResponseException(httpURLConnection.getResponseCode());
                }
                File file = new File(this.this$0.getContext().getFilesDir(), this.this$0.getCacheFolder());
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file, UUID.randomUUID().toString());
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    InputStream inputStream2 = inputStream;
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        Intrinsics.checkNotNull(inputStream2);
                        ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("localPath", file2.getAbsolutePath()));
                        httpURLConnection.disconnect();
                        return mapMapOf;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                httpURLConnection.disconnect();
                throw th5;
            }
        } catch (Exception unused) {
            throw new BadUrlException(this.$urlString);
        }
    }
}
