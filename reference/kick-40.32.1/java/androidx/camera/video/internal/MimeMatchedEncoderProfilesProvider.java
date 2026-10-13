package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.VideoSpec;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MimeMatchedEncoderProfilesProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/camera/video/internal/MimeMatchedEncoderProfilesProvider;", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "baseProvider", "videoMime", "", "audioMime", "<init>", "(Landroidx/camera/core/impl/EncoderProfilesProvider;Ljava/lang/String;Ljava/lang/String;)V", "profilesCache", "", "", "Landroidx/camera/core/impl/EncoderProfilesProxy;", "hasProfile", "", "quality", "getAll", "filterProfiles", "profiles", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MimeMatchedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final String audioMime;
    private final EncoderProfilesProvider baseProvider;
    private final Map<Integer, EncoderProfilesProxy> profilesCache;
    private final String videoMime;

    public MimeMatchedEncoderProfilesProvider(EncoderProfilesProvider baseProvider, String videoMime, String audioMime) {
        Intrinsics.checkNotNullParameter(baseProvider, "baseProvider");
        Intrinsics.checkNotNullParameter(videoMime, "videoMime");
        Intrinsics.checkNotNullParameter(audioMime, "audioMime");
        this.baseProvider = baseProvider;
        this.videoMime = videoMime;
        this.audioMime = audioMime;
        this.profilesCache = new LinkedHashMap();
    }

    public /* synthetic */ MimeMatchedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(encoderProfilesProvider, (i & 2) != 0 ? VideoSpec.MIME_TYPE_UNSPECIFIED : str, (i & 4) != 0 ? AudioSpec.MIME_TYPE_UNSPECIFIED : str2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int quality) {
        return getAll(quality) != null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int quality) {
        EncoderProfilesProxy encoderProfilesProxy;
        synchronized (this.profilesCache) {
            Map<Integer, EncoderProfilesProxy> map = this.profilesCache;
            Integer numValueOf = Integer.valueOf(quality);
            EncoderProfilesProxy encoderProfilesProxyFilterProfiles = map.get(numValueOf);
            if (encoderProfilesProxyFilterProfiles == null) {
                EncoderProfilesProxy all = this.baseProvider.getAll(quality);
                encoderProfilesProxyFilterProfiles = all != null ? filterProfiles(all) : null;
                map.put(numValueOf, encoderProfilesProxyFilterProfiles);
            }
            encoderProfilesProxy = encoderProfilesProxyFilterProfiles;
        }
        return encoderProfilesProxy;
    }

    private final EncoderProfilesProxy filterProfiles(EncoderProfilesProxy profiles) {
        if (!Intrinsics.areEqual(this.videoMime, VideoSpec.MIME_TYPE_UNSPECIFIED) || !Intrinsics.areEqual(this.audioMime, AudioSpec.MIME_TYPE_UNSPECIFIED)) {
            List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles = profiles.getVideoProfiles();
            Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : videoProfiles) {
                EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) obj;
                if (Intrinsics.areEqual(this.videoMime, VideoSpec.MIME_TYPE_UNSPECIFIED) || Intrinsics.areEqual(videoProfileProxy.getMediaType(), this.videoMime)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles = profiles.getAudioProfiles();
            Intrinsics.checkNotNullExpressionValue(audioProfiles, "getAudioProfiles(...)");
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : audioProfiles) {
                EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = (EncoderProfilesProxy.AudioProfileProxy) obj2;
                if (Intrinsics.areEqual(this.audioMime, AudioSpec.MIME_TYPE_UNSPECIFIED) || Intrinsics.areEqual(audioProfileProxy.getMediaType(), this.audioMime)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (arrayList2.size() != profiles.getVideoProfiles().size() || arrayList4.size() != profiles.getAudioProfiles().size()) {
                if (arrayList2.isEmpty() && arrayList4.isEmpty()) {
                    return null;
                }
                return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(profiles.getDefaultDurationSeconds(), profiles.getRecommendedFileFormat(), arrayList4, arrayList2);
            }
        }
        return profiles;
    }
}
