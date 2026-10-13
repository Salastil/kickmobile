package androidx.camera.video.internal.config;

import androidx.camera.video.AudioSpec;
import androidx.camera.video.VideoSpec;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatComboRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B1\b\u0002\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00030\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/camera/video/internal/config/FormatComboRegistry;", "", "formatComboMapping", "", "", "", "", "Landroidx/camera/video/internal/config/FormatCombo;", "<init>", "(Ljava/util/Map;)V", "getCombos", "", "outputFormat", "videoMime", "audioMime", "getCombosForVideo", "getCombosForAudio", "Builder", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormatComboRegistry {
    private final Map<Integer, Map<String, Set<FormatCombo>>> formatComboMapping;

    public /* synthetic */ FormatComboRegistry(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FormatComboRegistry(Map<Integer, ? extends Map<String, ? extends Set<FormatCombo>>> map) {
        this.formatComboMapping = map;
    }

    public final List<FormatCombo> getCombos(int outputFormat, String videoMime, String audioMime) {
        List listListOf;
        List listListOf2;
        Intrinsics.checkNotNullParameter(videoMime, "videoMime");
        Intrinsics.checkNotNullParameter(audioMime, "audioMime");
        ArrayList arrayList = new ArrayList();
        if (outputFormat == -1) {
            listListOf = this.formatComboMapping.keySet();
        } else {
            listListOf = CollectionsKt.listOf(Integer.valueOf(outputFormat));
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            Map<String, Set<FormatCombo>> map = this.formatComboMapping.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (map != null) {
                if (Intrinsics.areEqual(videoMime, VideoSpec.MIME_TYPE_UNSPECIFIED)) {
                    listListOf2 = map.keySet();
                } else {
                    listListOf2 = CollectionsKt.listOf(videoMime);
                }
                Iterator it2 = listListOf2.iterator();
                while (it2.hasNext()) {
                    Set<FormatCombo> set = map.get((String) it2.next());
                    if (set != null) {
                        if (Intrinsics.areEqual(audioMime, AudioSpec.MIME_TYPE_UNSPECIFIED)) {
                            arrayList.addAll(set);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : set) {
                                if (Intrinsics.areEqual(((FormatCombo) obj).getAudioMime(), audioMime)) {
                                    arrayList2.add(obj);
                                }
                            }
                            arrayList.addAll(arrayList2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<FormatCombo> getCombosForVideo(String videoMime) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, Set<FormatCombo>>> it = this.formatComboMapping.values().iterator();
        while (it.hasNext()) {
            Set<FormatCombo> set = it.next().get(videoMime);
            if (set != null) {
                arrayList.addAll(set);
            }
        }
        return arrayList;
    }

    public final List<FormatCombo> getCombosForAudio(String audioMime) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, Set<FormatCombo>>> it = this.formatComboMapping.values().iterator();
        while (it.hasNext()) {
            for (Set<FormatCombo> set : it.next().values()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : set) {
                    if (Intrinsics.areEqual(((FormatCombo) obj).getAudioMime(), audioMime)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: FormatComboRegistry.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R.\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/camera/video/internal/config/FormatComboRegistry$Builder;", "", "<init>", "()V", "formatComboMapping", "", "", "", "", "Landroidx/camera/video/internal/config/FormatCombo;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "", "format", "block", "Lkotlin/Function1;", "Landroidx/camera/video/internal/config/FormatComboRegistry$Builder$ContainerScope;", "Lkotlin/ExtensionFunctionType;", "build", "Landroidx/camera/video/internal/config/FormatComboRegistry;", "ContainerScope", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final Map<Integer, Map<String, Set<FormatCombo>>> formatComboMapping = new LinkedHashMap();

        public final void container(int format, Function1<? super ContainerScope, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Map<Integer, Map<String, Set<FormatCombo>>> map = this.formatComboMapping;
            Integer numValueOf = Integer.valueOf(format);
            LinkedHashMap linkedHashMap = map.get(numValueOf);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                map.put(numValueOf, linkedHashMap);
            }
            block.invoke(new ContainerScope(format, linkedHashMap));
        }

        /* JADX INFO: compiled from: FormatComboRegistry.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/camera/video/internal/config/FormatComboRegistry$Builder$ContainerScope;", "", WebViewRumEventMapper.CONTAINER_KEY_NAME, "", "videoMap", "", "", "", "Landroidx/camera/video/internal/config/FormatCombo;", "<init>", "(ILjava/util/Map;)V", "support", "", "videoMimes", "", "audioMimes", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ContainerScope {
            private final int container;
            private final Map<String, Set<FormatCombo>> videoMap;

            public ContainerScope(int i, Map<String, Set<FormatCombo>> videoMap) {
                Intrinsics.checkNotNullParameter(videoMap, "videoMap");
                this.container = i;
                this.videoMap = videoMap;
            }

            public final void support(List<String> videoMimes, List<String> audioMimes) {
                Intrinsics.checkNotNullParameter(videoMimes, "videoMimes");
                Intrinsics.checkNotNullParameter(audioMimes, "audioMimes");
                for (String str : videoMimes) {
                    Map<String, Set<FormatCombo>> map = this.videoMap;
                    LinkedHashSet linkedHashSet = map.get(str);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        map.put(str, linkedHashSet);
                    }
                    Set<FormatCombo> set = linkedHashSet;
                    Iterator<T> it = audioMimes.iterator();
                    while (it.hasNext()) {
                        set.add(new FormatCombo(this.container, str, (String) it.next()));
                    }
                    set.add(new FormatCombo(this.container, str, null));
                }
                Map<String, Set<FormatCombo>> map2 = this.videoMap;
                LinkedHashSet linkedHashSet2 = map2.get(null);
                if (linkedHashSet2 == null) {
                    linkedHashSet2 = new LinkedHashSet();
                    map2.put(null, linkedHashSet2);
                }
                Set<FormatCombo> set2 = linkedHashSet2;
                Iterator<T> it2 = audioMimes.iterator();
                while (it2.hasNext()) {
                    set2.add(new FormatCombo(this.container, null, (String) it2.next()));
                }
            }
        }

        public final FormatComboRegistry build() {
            return new FormatComboRegistry(this.formatComboMapping, null);
        }
    }
}
