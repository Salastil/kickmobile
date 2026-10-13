package expo.modules.fetch;

import com.squareup.zstd.okio.OkioZstd;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.brotli.dec.BrotliInputStream;

/* JADX INFO: compiled from: TransparentCompressionInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/fetch/TransparentCompressionInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "uncompress", "response", "uncompress$expo_release", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TransparentCompressionInterceptor implements Interceptor {
    public static final TransparentCompressionInterceptor INSTANCE = new TransparentCompressionInterceptor();

    private TransparentCompressionInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (request.header("Accept-Encoding") == null) {
            request = request.newBuilder().header("Accept-Encoding", "zstd, br, gzip").build();
        }
        return uncompress$expo_release(chain.proceed(request));
    }

    public final Response uncompress$expo_release(Response response) {
        ResponseBody responseBodyBody;
        String strHeader$default;
        BufferedSource bufferedSourceBuffer;
        Intrinsics.checkNotNullParameter(response, "response");
        if (HttpHeaders.promisesBody(response) && (responseBodyBody = response.body()) != null && (strHeader$default = Response.header$default(response, "Content-Encoding", null, 2, null)) != null) {
            String lowerCase = strHeader$default.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 3152) {
                if (iHashCode != 3189082) {
                    if (iHashCode == 3748713 && lowerCase.equals("zstd")) {
                        bufferedSourceBuffer = Okio.buffer(OkioZstd.zstdDecompress(responseBodyBody.getSource()));
                        return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.INSTANCE.create(bufferedSourceBuffer, responseBodyBody.get$contentType(), -1L)).build();
                    }
                } else if (lowerCase.equals("gzip")) {
                    bufferedSourceBuffer = Okio.buffer(new GzipSource(responseBodyBody.getSource()));
                    return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.INSTANCE.create(bufferedSourceBuffer, responseBodyBody.get$contentType(), -1L)).build();
                }
            } else if (lowerCase.equals("br")) {
                bufferedSourceBuffer = Okio.buffer(Okio.source(new BrotliInputStream(responseBodyBody.getSource().inputStream())));
                return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.INSTANCE.create(bufferedSourceBuffer, responseBodyBody.get$contentType(), -1L)).build();
            }
        }
        return response;
    }
}
