package com.datadog.android.rum.internal.domain.scope;

import android.app.Activity;
import android.content.ComponentName;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: RumScopeKey.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "", "id", "", ImagesContract.URL, "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumScopeKey {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final String name;
    private final String url;

    public static /* synthetic */ RumScopeKey copy$default(RumScopeKey rumScopeKey, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rumScopeKey.id;
        }
        if ((i & 2) != 0) {
            str2 = rumScopeKey.url;
        }
        if ((i & 4) != 0) {
            str3 = rumScopeKey.name;
        }
        return rumScopeKey.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final RumScopeKey copy(String id, String url, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        return new RumScopeKey(id, url, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumScopeKey)) {
            return false;
        }
        RumScopeKey rumScopeKey = (RumScopeKey) other;
        return Intrinsics.areEqual(this.id, rumScopeKey.id) && Intrinsics.areEqual(this.url, rumScopeKey.url) && Intrinsics.areEqual(this.name, rumScopeKey.name);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "RumScopeKey(id=" + this.id + ", url=" + this.url + ", name=" + this.name + ")";
    }

    public RumScopeKey(String id, String url, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: compiled from: RumScopeKey.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0001H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0001H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0001H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "key", "name", "", "resolveComponent", "Landroid/content/ComponentName;", "resolveComponentUrl", "resolveId", "resolveName", "resolveUrl", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RumScopeKey from$default(Companion companion, Object obj, String str, int i, Object obj2) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.from(obj, str);
        }

        public final RumScopeKey from(Object key, String name) {
            Intrinsics.checkNotNullParameter(key, "key");
            ComponentName componentNameResolveComponent = resolveComponent(key);
            if (componentNameResolveComponent == null) {
                String strResolveId = resolveId(key);
                String strResolveUrl = resolveUrl(key);
                if (name == null) {
                    name = resolveName(key);
                }
                return new RumScopeKey(strResolveId, strResolveUrl, name);
            }
            String str = componentNameResolveComponent.getClassName() + "@" + System.identityHashCode(key);
            String strResolveComponentUrl = resolveComponentUrl(componentNameResolveComponent);
            if (name == null) {
                name = componentNameResolveComponent.getClassName();
                Intrinsics.checkNotNullExpressionValue(name, "componentName.className");
            }
            return new RumScopeKey(str, strResolveComponentUrl, name);
        }

        private final String resolveId(Object key) {
            if (key instanceof String) {
                return (String) key;
            }
            if (key instanceof Number) {
                return key.toString();
            }
            if (key instanceof Enum) {
                return key.getClass().getName() + "@" + ((Enum) key).name();
            }
            if (key instanceof DialogFragmentNavigator.Destination) {
                DialogFragmentNavigator.Destination destination = (DialogFragmentNavigator.Destination) key;
                return destination.getClassName() + "#" + destination.getId();
            }
            if (!(key instanceof FragmentNavigator.Destination)) {
                return key.toString();
            }
            FragmentNavigator.Destination destination2 = (FragmentNavigator.Destination) key;
            return destination2.getClassName() + "#" + destination2.getId();
        }

        private final String resolveUrl(Object key) {
            if (key instanceof String) {
                return (String) key;
            }
            if (key instanceof Number) {
                return key.toString();
            }
            if (key instanceof Enum) {
                return key.getClass().getName() + "." + ((Enum) key).name();
            }
            if (key instanceof DialogFragmentNavigator.Destination) {
                return ((DialogFragmentNavigator.Destination) key).getClassName();
            }
            if (key instanceof FragmentNavigator.Destination) {
                return ((FragmentNavigator.Destination) key).getClassName();
            }
            String canonicalName = key.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = key.getClass().getSimpleName();
            }
            Intrinsics.checkNotNullExpressionValue(canonicalName, "key.javaClass.canonicalN… key.javaClass.simpleName");
            return canonicalName;
        }

        private final String resolveName(Object key) {
            if (key instanceof String) {
                return (String) key;
            }
            if (key instanceof Number) {
                return key.toString();
            }
            if (key instanceof Enum) {
                return ((Enum) key).name();
            }
            if (key instanceof DialogFragmentNavigator.Destination) {
                return ((DialogFragmentNavigator.Destination) key).getClassName();
            }
            if (key instanceof FragmentNavigator.Destination) {
                return ((FragmentNavigator.Destination) key).getClassName();
            }
            String name = key.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "key.javaClass.name");
            return name;
        }

        private final String resolveComponentUrl(ComponentName key) {
            String packageName = key.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "key.packageName");
            if (packageName.length() == 0) {
                String className = key.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "key.className");
                return className;
            }
            String className2 = key.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "key.className");
            if (StringsKt.startsWith$default(className2, key.getPackageName() + ".", false, 2, (Object) null)) {
                String className3 = key.getClassName();
                Intrinsics.checkNotNullExpressionValue(className3, "key.className");
                return className3;
            }
            String className4 = key.getClassName();
            Intrinsics.checkNotNullExpressionValue(className4, "key.className");
            if (StringsKt.contains$default((CharSequence) className4, FilenameUtils.EXTENSION_SEPARATOR, false, 2, (Object) null)) {
                String className5 = key.getClassName();
                Intrinsics.checkNotNullExpressionValue(className5, "key.className");
                return className5;
            }
            return key.getPackageName() + "." + key.getClassName();
        }

        private final ComponentName resolveComponent(Object key) {
            if (key instanceof Activity) {
                return ((Activity) key).getComponentName();
            }
            if (key instanceof ActivityNavigator.Destination) {
                return ((ActivityNavigator.Destination) key).getComponent();
            }
            return null;
        }
    }
}
