package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuItemIconSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", "", "drawableIconResourceName", "", "imageIconUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDrawableIconResourceName", "()Ljava/lang/String;", "getImageIconUri", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuItemIconSource {
    private final String drawableIconResourceName;
    private final String imageIconUri;

    public static /* synthetic */ StackHeaderToolbarMenuItemIconSource copy$default(StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stackHeaderToolbarMenuItemIconSource.drawableIconResourceName;
        }
        if ((i & 2) != 0) {
            str2 = stackHeaderToolbarMenuItemIconSource.imageIconUri;
        }
        return stackHeaderToolbarMenuItemIconSource.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDrawableIconResourceName() {
        return this.drawableIconResourceName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImageIconUri() {
        return this.imageIconUri;
    }

    public final StackHeaderToolbarMenuItemIconSource copy(String drawableIconResourceName, String imageIconUri) {
        return new StackHeaderToolbarMenuItemIconSource(drawableIconResourceName, imageIconUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuItemIconSource)) {
            return false;
        }
        StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource = (StackHeaderToolbarMenuItemIconSource) other;
        return Intrinsics.areEqual(this.drawableIconResourceName, stackHeaderToolbarMenuItemIconSource.drawableIconResourceName) && Intrinsics.areEqual(this.imageIconUri, stackHeaderToolbarMenuItemIconSource.imageIconUri);
    }

    public int hashCode() {
        String str = this.drawableIconResourceName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageIconUri;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StackHeaderToolbarMenuItemIconSource(drawableIconResourceName=" + this.drawableIconResourceName + ", imageIconUri=" + this.imageIconUri + ")";
    }

    public StackHeaderToolbarMenuItemIconSource(String str, String str2) {
        this.drawableIconResourceName = str;
        this.imageIconUri = str2;
    }

    public final String getDrawableIconResourceName() {
        return this.drawableIconResourceName;
    }

    public final String getImageIconUri() {
        return this.imageIconUri;
    }
}
