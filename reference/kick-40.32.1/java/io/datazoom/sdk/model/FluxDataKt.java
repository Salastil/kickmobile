package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: FluxData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004*\n\u0010\u0005\"\u00020\u00022\u00020\u0002¨\u0006\u0006"}, d2 = {"ignoreIfZero", "", "Lio/datazoom/sdk/model/FluxData$Type;", "getIgnoreIfZero", "()Ljava/util/Set;", "FD", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FluxDataKt {
    private static final Set<FluxData.Type> ignoreIfZero = SetsKt.setOf((Object[]) new FluxData.Type[]{FluxData.Type.BITRATE, FluxData.Type.PLAYBACK_DURATION, FluxData.Type.ENGAGEMENT_DURATION, FluxData.Type.BUFFER_LENGTH_MS, FluxData.Type.PLAYBACK_DURATION_CONTENT_MS, FluxData.Type.BUFFER_DURATION_CONTENT_MS, FluxData.Type.TOTAL_BUFFER_TIME, FluxData.Type.RENDITION_AUDIO_BITRATE, FluxData.Type.RENDITION_AUDIO_BITRATE_KBPS, FluxData.Type.RENDITION_VIDEO_BITRATE_KBPS, FluxData.Type.RENDITION_VIDEO_BITRATE});

    public static final Set<FluxData.Type> getIgnoreIfZero() {
        return ignoreIfZero;
    }
}
