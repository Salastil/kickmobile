package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.network.NetworkResponseData;
import com.facebook.imagepipeline.producers.FetchState;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface NetworkFetcher<FETCH_STATE extends FetchState> {
    FETCH_STATE createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext);

    void fetch(FETCH_STATE fetch_state, Callback callback);

    @Nullable
    Map<String, String> getExtraMap(FETCH_STATE fetch_state, int i);

    void onFetchCompletion(FETCH_STATE fetch_state, int i);

    boolean shouldPropagate(FETCH_STATE fetch_state);

    public interface Callback {
        void onCancellation();

        void onFailure(Throwable th);

        void onResponse(InputStream inputStream, int i) throws IOException;

        default void onResponse(NetworkResponseData networkResponseData) throws IOException {
            if (networkResponseData instanceof NetworkResponseData.Stream) {
                NetworkResponseData.Stream stream = (NetworkResponseData.Stream) networkResponseData;
                onResponse(stream.getStream(), stream.getLength());
            } else if (networkResponseData instanceof NetworkResponseData.Bytes) {
                NetworkResponseData.Bytes bytes = (NetworkResponseData.Bytes) networkResponseData;
                onResponse(new ByteArrayInputStream(bytes.getData(), 0, bytes.getLength()), bytes.getLength());
            } else {
                throw new IllegalArgumentException("Unknown NetworkResponseData type: " + networkResponseData.getClass());
            }
        }
    }
}
