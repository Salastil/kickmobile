package expo.modules.webview;

import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomWebViewEvents.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0004HÖ\u0081\u0004R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lexpo/modules/webview/OnRenderProcessGoneEvent;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ImagesContract.URL, "", "title", "didCrash", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getDidCrash$annotations", "getDidCrash", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OnRenderProcessGoneEvent implements Record, PIntrospectionProvider {
    public boolean didCrash;
    public String title;
    public String url;

    public static /* synthetic */ OnRenderProcessGoneEvent copy$default(OnRenderProcessGoneEvent onRenderProcessGoneEvent, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onRenderProcessGoneEvent.url;
        }
        if ((i & 2) != 0) {
            str2 = onRenderProcessGoneEvent.title;
        }
        if ((i & 4) != 0) {
            z = onRenderProcessGoneEvent.didCrash;
        }
        return onRenderProcessGoneEvent.copy(str, str2, z);
    }

    @Field
    public static /* synthetic */ void getDidCrash$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDidCrash() {
        return this.didCrash;
    }

    public final OnRenderProcessGoneEvent copy(String url, String title, boolean didCrash) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        return new OnRenderProcessGoneEvent(url, title, didCrash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnRenderProcessGoneEvent)) {
            return false;
        }
        OnRenderProcessGoneEvent onRenderProcessGoneEvent = (OnRenderProcessGoneEvent) other;
        return Intrinsics.areEqual(this.url, onRenderProcessGoneEvent.url) && Intrinsics.areEqual(this.title, onRenderProcessGoneEvent.title) && this.didCrash == onRenderProcessGoneEvent.didCrash;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.didCrash);
    }

    public String toString() {
        return "OnRenderProcessGoneEvent(url=" + this.url + ", title=" + this.title + ", didCrash=" + this.didCrash + ")";
    }

    /* JADX INFO: compiled from: DomWebViewEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/webview/OnRenderProcessGoneEvent$__Pika;", "", "<init>", "()V", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<OnRenderProcessGoneEvent> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(OnRenderProcessGoneEvent.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ImagesContract.URL, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty("title", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, false, true, false), new PProperty("didCrash", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
                return ((OnRenderProcessGoneEvent) obj).getUrl();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
                return ((OnRenderProcessGoneEvent) obj).getTitle();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
            return Boolean.valueOf(((OnRenderProcessGoneEvent) obj).getDidCrash());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((OnRenderProcessGoneEvent) obj).url = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((OnRenderProcessGoneEvent) obj).title = (String) obj2;
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.OnRenderProcessGoneEvent");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            ((OnRenderProcessGoneEvent) obj).didCrash = ((Boolean) obj2).booleanValue();
        }

        private __Pika() {
        }
    }

    public OnRenderProcessGoneEvent(String url, String title, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        this.url = url;
        this.title = title;
        this.didCrash = z;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getDidCrash() {
        return this.didCrash;
    }
}
