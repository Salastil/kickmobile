package com.datadog.android.rum.internal.utils;

import android.content.ComponentName;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"UNKNOWN_DESTINATION_URL", "", "resolveViewUrl", "Landroid/content/ComponentName;", "", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewUtilsKt {
    public static final String UNKNOWN_DESTINATION_URL = "Unknown";

    public static final String resolveViewUrl(Object obj) {
        String strResolveViewUrl;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof FragmentNavigator.Destination) {
            return ((FragmentNavigator.Destination) obj).getClassName();
        }
        if (obj instanceof DialogFragmentNavigator.Destination) {
            return ((DialogFragmentNavigator.Destination) obj).getClassName();
        }
        if (obj instanceof ActivityNavigator.Destination) {
            ComponentName component = ((ActivityNavigator.Destination) obj).getComponent();
            return (component == null || (strResolveViewUrl = resolveViewUrl(component)) == null) ? UNKNOWN_DESTINATION_URL : strResolveViewUrl;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = obj.getClass().getSimpleName();
        }
        Intrinsics.checkNotNullExpressionValue(canonicalName, "javaClass.canonicalName ?: javaClass.simpleName");
        return canonicalName;
    }

    public static final String resolveViewUrl(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "<this>");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        if (packageName.length() == 0) {
            String className = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "className");
            return className;
        }
        String className2 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className2, "className");
        if (StringsKt.startsWith$default(className2, componentName.getPackageName() + ".", false, 2, (Object) null)) {
            String className3 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className3, "className");
            return className3;
        }
        String className4 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className4, "className");
        if (StringsKt.contains$default((CharSequence) className4, FilenameUtils.EXTENSION_SEPARATOR, false, 2, (Object) null)) {
            String className5 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className5, "className");
            return className5;
        }
        return componentName.getPackageName() + "." + componentName.getClassName();
    }
}
