package androidx.camera.video.internal.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.LruCache;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CodecUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\bH\u0007J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0007J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0007J\b\u0010 \u001a\u00020!H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000e¨\u0006\""}, d2 = {"Landroidx/camera/video/internal/utils/CodecUtil;", "", "<init>", "()V", "MAX_CODEC_INFO_CACHE_COUNT", "", "codecInfoCache", "Landroid/util/LruCache;", "", "Landroid/media/MediaCodecInfo;", "allEncoderInfosCache", "", "allEncoderInfos", "getAllEncoderInfos", "()Ljava/util/List;", "allEncoderMimeTypesCache", "allEncoderMimeTypes", "getAllEncoderMimeTypes", "allVideoEncoderMimeTypesCache", "allVideoEncoderMimeTypes", "getAllVideoEncoderMimeTypes", "allAudioEncoderMimeTypesCache", "allAudioEncoderMimeTypes", "getAllAudioEncoderMimeTypes", "createCodec", "Landroid/media/MediaCodec;", "encoderConfig", "Landroidx/camera/video/internal/encoder/EncoderConfig;", "findCodecAndGetCodecInfo", "mimeType", "getVideoEncoderMimeTypes", "getAudioEncoderMimeTypes", "reset", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodecUtil {
    private static final int MAX_CODEC_INFO_CACHE_COUNT = 10;
    private static List<String> allAudioEncoderMimeTypesCache;
    private static List<MediaCodecInfo> allEncoderInfosCache;
    private static List<String> allEncoderMimeTypesCache;
    private static List<String> allVideoEncoderMimeTypesCache;
    public static final CodecUtil INSTANCE = new CodecUtil();
    private static final LruCache<String, MediaCodecInfo> codecInfoCache = new LruCache<>(10);

    private CodecUtil() {
    }

    private final List<MediaCodecInfo> getAllEncoderInfos() {
        List<MediaCodecInfo> list = allEncoderInfosCache;
        if (list != null) {
            return list;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        ArrayList arrayList2 = arrayList;
        allEncoderInfosCache = arrayList2;
        return arrayList2;
    }

    private final List<String> getAllEncoderMimeTypes() {
        List listEmptyList;
        List<String> list = allEncoderMimeTypesCache;
        if (list != null) {
            return list;
        }
        List<MediaCodecInfo> allEncoderInfos = getAllEncoderInfos();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = allEncoderInfos.iterator();
        while (it.hasNext()) {
            String[] supportedTypes = ((MediaCodecInfo) it.next()).getSupportedTypes();
            if (supportedTypes == null || (listEmptyList = ArraysKt.toList(supportedTypes)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, listEmptyList);
        }
        List<String> listDistinct = CollectionsKt.distinct(arrayList);
        allEncoderMimeTypesCache = listDistinct;
        return listDistinct;
    }

    private final List<String> getAllVideoEncoderMimeTypes() {
        List<String> list = allVideoEncoderMimeTypesCache;
        if (list != null) {
            return list;
        }
        List<String> allEncoderMimeTypes = getAllEncoderMimeTypes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allEncoderMimeTypes) {
            if (StringsKt.startsWith$default((String) obj, "video/", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        allVideoEncoderMimeTypesCache = arrayList2;
        return arrayList2;
    }

    private final List<String> getAllAudioEncoderMimeTypes() {
        List<String> list = allAudioEncoderMimeTypesCache;
        if (list != null) {
            return list;
        }
        List<String> allEncoderMimeTypes = getAllEncoderMimeTypes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allEncoderMimeTypes) {
            if (StringsKt.startsWith$default((String) obj, "audio/", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        allAudioEncoderMimeTypesCache = arrayList2;
        return arrayList2;
    }

    @JvmStatic
    public static final MediaCodec createCodec(EncoderConfig encoderConfig) throws InvalidConfigException {
        Intrinsics.checkNotNullParameter(encoderConfig, "encoderConfig");
        CodecUtil codecUtil = INSTANCE;
        String mimeType = encoderConfig.getMimeType();
        Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
        return codecUtil.createCodec(mimeType);
    }

    @JvmStatic
    public static final MediaCodecInfo findCodecAndGetCodecInfo(String mimeType) throws InvalidConfigException {
        MediaCodecInfo mediaCodecInfo;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        LruCache<String, MediaCodecInfo> lruCache = codecInfoCache;
        synchronized (lruCache) {
            mediaCodecInfo = lruCache.get(mimeType);
            Unit unit = Unit.INSTANCE;
        }
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        MediaCodec mediaCodecCreateCodec = null;
        try {
            mediaCodecCreateCodec = INSTANCE.createCodec(mimeType);
            MediaCodecInfo codecInfo = mediaCodecCreateCodec.getCodecInfo();
            synchronized (lruCache) {
                lruCache.put(mimeType, codecInfo);
            }
            if (mediaCodecCreateCodec != null) {
                mediaCodecCreateCodec.release();
            }
            return codecInfo;
        } catch (Throwable th) {
            if (mediaCodecCreateCodec != null) {
                mediaCodecCreateCodec.release();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final List<String> getVideoEncoderMimeTypes() {
        return INSTANCE.getAllVideoEncoderMimeTypes();
    }

    @JvmStatic
    public static final List<String> getAudioEncoderMimeTypes() {
        return INSTANCE.getAllAudioEncoderMimeTypes();
    }

    public final void reset() {
        allEncoderInfosCache = null;
        allEncoderMimeTypesCache = null;
        allVideoEncoderMimeTypesCache = null;
        allAudioEncoderMimeTypesCache = null;
        LruCache<String, MediaCodecInfo> lruCache = codecInfoCache;
        synchronized (lruCache) {
            lruCache.evictAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final MediaCodec createCodec(String mimeType) throws InvalidConfigException {
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(mimeType);
            Intrinsics.checkNotNull(mediaCodecCreateEncoderByType);
            return mediaCodecCreateEncoderByType;
        } catch (IOException e) {
            throw new InvalidConfigException(e);
        } catch (IllegalArgumentException e2) {
            throw new InvalidConfigException(e2);
        }
    }
}
