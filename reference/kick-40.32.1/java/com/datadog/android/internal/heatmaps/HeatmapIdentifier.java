package com.datadog.android.internal.heatmaps;

import com.datadog.android.internal.utils.ByteArrayExtKt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: HeatmapIdentifier.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier;", "", "rawValue", "", "(Ljava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HeatmapIdentifier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SCREEN_NAMESPACE_VIEW_PREFIX = "view:";
    private static final String SEPARATOR = "/";
    private final String rawValue;

    public static /* synthetic */ HeatmapIdentifier copy$default(HeatmapIdentifier heatmapIdentifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = heatmapIdentifier.rawValue;
        }
        return heatmapIdentifier.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRawValue() {
        return this.rawValue;
    }

    public final HeatmapIdentifier copy(String rawValue) {
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        return new HeatmapIdentifier(rawValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HeatmapIdentifier) && Intrinsics.areEqual(this.rawValue, ((HeatmapIdentifier) other).rawValue);
    }

    public int hashCode() {
        return this.rawValue.hashCode();
    }

    public String toString() {
        return "HeatmapIdentifier(rawValue=" + this.rawValue + ")";
    }

    public HeatmapIdentifier(String rawValue) {
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        this.rawValue = rawValue;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    /* JADX INFO: compiled from: HeatmapIdentifier.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J<\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier$Companion;", "", "()V", "SCREEN_NAMESPACE_VIEW_PREFIX", "", "SEPARATOR", "canonicalPath", "elementPath", "", "screenName", "appPackageName", "create", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifier;", "onHashingFailure", "Lkotlin/Function1;", "", "", "escape", "input", "sha256Hex", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HeatmapIdentifier create$default(Companion companion, List list, String str, String str2, Function1 function1, int i, Object obj) {
            if ((i & 8) != 0) {
                function1 = new Function1<Throwable, Unit>() { // from class: com.datadog.android.internal.heatmaps.HeatmapIdentifier$Companion$create$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }
                };
            }
            return companion.create(list, str, str2, function1);
        }

        public final HeatmapIdentifier create(List<String> elementPath, String screenName, String appPackageName, Function1<? super Throwable, Unit> onHashingFailure) {
            Intrinsics.checkNotNullParameter(elementPath, "elementPath");
            Intrinsics.checkNotNullParameter(screenName, "screenName");
            Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
            Intrinsics.checkNotNullParameter(onHashingFailure, "onHashingFailure");
            try {
                return new HeatmapIdentifier(sha256Hex(canonicalPath(elementPath, screenName, appPackageName)));
            } catch (UnsupportedEncodingException e) {
                onHashingFailure.invoke(e);
                return null;
            } catch (NoSuchAlgorithmException e2) {
                onHashingFailure.invoke(e2);
                return null;
            }
        }

        private final String canonicalPath(List<String> elementPath, String screenName, String appPackageName) {
            StringBuilder sb = new StringBuilder();
            sb.append(HeatmapIdentifier.INSTANCE.escape(appPackageName));
            sb.append("/");
            sb.append(HeatmapIdentifier.INSTANCE.escape(HeatmapIdentifier.SCREEN_NAMESPACE_VIEW_PREFIX + screenName));
            for (String str : elementPath) {
                sb.append("/");
                sb.append(HeatmapIdentifier.INSTANCE.escape(str));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private final String escape(String input) throws UnsupportedEncodingException {
            String strEncode = URLEncoder.encode(input, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(input, \"UTF-8\")");
            return strEncode;
        }

        private final String sha256Hex(String input) throws NoSuchAlgorithmException {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest(input.toByteArray(Charsets.UTF_8))");
            return ByteArrayExtKt.toHexString(bArrDigest);
        }
    }
}
