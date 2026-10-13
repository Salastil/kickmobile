package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuItemConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b1\b\u0080\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0016HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003JÂ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010BJ\u0014\u0010C\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b+\u0010(R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b,\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!¨\u0006G"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "", "id", "", "title", "titleCondensed", "tooltipText", ViewProps.ACCESSIBILITY_LABEL, ViewProps.HIDDEN, "", "disabled", "showAsAction", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;", "icon", "Landroid/graphics/drawable/Drawable;", "iconTintColorNormal", "", "iconTintColorPressed", "iconTintColorFocused", "iconTintColorDisabled", "groupId", "itemType", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemType;", "initialToggleState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemType;Z)V", "getId", "()Ljava/lang/String;", "getTitle", "getTitleCondensed", "getTooltipText", "getAccessibilityLabel", "getHidden", "()Z", "getDisabled", "getShowAsAction", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getIconTintColorNormal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconTintColorPressed", "getIconTintColorFocused", "getIconTintColorDisabled", "getGroupId", "getItemType", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemType;", "getInitialToggleState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemType;Z)Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "equals", "other", "hashCode", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuItemConfig {
    private final String accessibilityLabel;
    private final boolean disabled;
    private final String groupId;
    private final boolean hidden;
    private final Drawable icon;
    private final Integer iconTintColorDisabled;
    private final Integer iconTintColorFocused;
    private final Integer iconTintColorNormal;
    private final Integer iconTintColorPressed;
    private final String id;
    private final boolean initialToggleState;
    private final StackHeaderToolbarMenuItemType itemType;
    private final StackHeaderToolbarMenuItemShowAsAction showAsAction;
    private final String title;
    private final String titleCondensed;
    private final String tooltipText;

    public static /* synthetic */ StackHeaderToolbarMenuItemConfig copy$default(StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfig, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, StackHeaderToolbarMenuItemShowAsAction stackHeaderToolbarMenuItemShowAsAction, Drawable drawable, Integer num, Integer num2, Integer num3, Integer num4, String str6, StackHeaderToolbarMenuItemType stackHeaderToolbarMenuItemType, boolean z3, int i, Object obj) {
        String str7 = (i & 1) != 0 ? stackHeaderToolbarMenuItemConfig.id : str;
        return stackHeaderToolbarMenuItemConfig.copy(str7, (i & 2) != 0 ? stackHeaderToolbarMenuItemConfig.title : str2, (i & 4) != 0 ? stackHeaderToolbarMenuItemConfig.titleCondensed : str3, (i & 8) != 0 ? stackHeaderToolbarMenuItemConfig.tooltipText : str4, (i & 16) != 0 ? stackHeaderToolbarMenuItemConfig.accessibilityLabel : str5, (i & 32) != 0 ? stackHeaderToolbarMenuItemConfig.hidden : z, (i & 64) != 0 ? stackHeaderToolbarMenuItemConfig.disabled : z2, (i & 128) != 0 ? stackHeaderToolbarMenuItemConfig.showAsAction : stackHeaderToolbarMenuItemShowAsAction, (i & 256) != 0 ? stackHeaderToolbarMenuItemConfig.icon : drawable, (i & 512) != 0 ? stackHeaderToolbarMenuItemConfig.iconTintColorNormal : num, (i & 1024) != 0 ? stackHeaderToolbarMenuItemConfig.iconTintColorPressed : num2, (i & 2048) != 0 ? stackHeaderToolbarMenuItemConfig.iconTintColorFocused : num3, (i & 4096) != 0 ? stackHeaderToolbarMenuItemConfig.iconTintColorDisabled : num4, (i & 8192) != 0 ? stackHeaderToolbarMenuItemConfig.groupId : str6, (i & 16384) != 0 ? stackHeaderToolbarMenuItemConfig.itemType : stackHeaderToolbarMenuItemType, (i & 32768) != 0 ? stackHeaderToolbarMenuItemConfig.initialToggleState : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getIconTintColorNormal() {
        return this.iconTintColorNormal;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getIconTintColorPressed() {
        return this.iconTintColorPressed;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getIconTintColorFocused() {
        return this.iconTintColorFocused;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getIconTintColorDisabled() {
        return this.iconTintColorDisabled;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final StackHeaderToolbarMenuItemType getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getInitialToggleState() {
        return this.initialToggleState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitleCondensed() {
        return this.titleCondensed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTooltipText() {
        return this.tooltipText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHidden() {
        return this.hidden;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StackHeaderToolbarMenuItemShowAsAction getShowAsAction() {
        return this.showAsAction;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Drawable getIcon() {
        return this.icon;
    }

    public final StackHeaderToolbarMenuItemConfig copy(String id, String title, String titleCondensed, String tooltipText, String accessibilityLabel, boolean hidden, boolean disabled, StackHeaderToolbarMenuItemShowAsAction showAsAction, Drawable icon, Integer iconTintColorNormal, Integer iconTintColorPressed, Integer iconTintColorFocused, Integer iconTintColorDisabled, String groupId, StackHeaderToolbarMenuItemType itemType, boolean initialToggleState) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(showAsAction, "showAsAction");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new StackHeaderToolbarMenuItemConfig(id, title, titleCondensed, tooltipText, accessibilityLabel, hidden, disabled, showAsAction, icon, iconTintColorNormal, iconTintColorPressed, iconTintColorFocused, iconTintColorDisabled, groupId, itemType, initialToggleState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuItemConfig)) {
            return false;
        }
        StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfig = (StackHeaderToolbarMenuItemConfig) other;
        return Intrinsics.areEqual(this.id, stackHeaderToolbarMenuItemConfig.id) && Intrinsics.areEqual(this.title, stackHeaderToolbarMenuItemConfig.title) && Intrinsics.areEqual(this.titleCondensed, stackHeaderToolbarMenuItemConfig.titleCondensed) && Intrinsics.areEqual(this.tooltipText, stackHeaderToolbarMenuItemConfig.tooltipText) && Intrinsics.areEqual(this.accessibilityLabel, stackHeaderToolbarMenuItemConfig.accessibilityLabel) && this.hidden == stackHeaderToolbarMenuItemConfig.hidden && this.disabled == stackHeaderToolbarMenuItemConfig.disabled && this.showAsAction == stackHeaderToolbarMenuItemConfig.showAsAction && Intrinsics.areEqual(this.icon, stackHeaderToolbarMenuItemConfig.icon) && Intrinsics.areEqual(this.iconTintColorNormal, stackHeaderToolbarMenuItemConfig.iconTintColorNormal) && Intrinsics.areEqual(this.iconTintColorPressed, stackHeaderToolbarMenuItemConfig.iconTintColorPressed) && Intrinsics.areEqual(this.iconTintColorFocused, stackHeaderToolbarMenuItemConfig.iconTintColorFocused) && Intrinsics.areEqual(this.iconTintColorDisabled, stackHeaderToolbarMenuItemConfig.iconTintColorDisabled) && Intrinsics.areEqual(this.groupId, stackHeaderToolbarMenuItemConfig.groupId) && this.itemType == stackHeaderToolbarMenuItemConfig.itemType && this.initialToggleState == stackHeaderToolbarMenuItemConfig.initialToggleState;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.titleCondensed;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tooltipText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.accessibilityLabel;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.hidden)) * 31) + Boolean.hashCode(this.disabled)) * 31) + this.showAsAction.hashCode()) * 31;
        Drawable drawable = this.icon;
        int iHashCode6 = (iHashCode5 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Integer num = this.iconTintColorNormal;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.iconTintColorPressed;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.iconTintColorFocused;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.iconTintColorDisabled;
        int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.groupId;
        return ((((iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.itemType.hashCode()) * 31) + Boolean.hashCode(this.initialToggleState);
    }

    public String toString() {
        return "StackHeaderToolbarMenuItemConfig(id=" + this.id + ", title=" + this.title + ", titleCondensed=" + this.titleCondensed + ", tooltipText=" + this.tooltipText + ", accessibilityLabel=" + this.accessibilityLabel + ", hidden=" + this.hidden + ", disabled=" + this.disabled + ", showAsAction=" + this.showAsAction + ", icon=" + this.icon + ", iconTintColorNormal=" + this.iconTintColorNormal + ", iconTintColorPressed=" + this.iconTintColorPressed + ", iconTintColorFocused=" + this.iconTintColorFocused + ", iconTintColorDisabled=" + this.iconTintColorDisabled + ", groupId=" + this.groupId + ", itemType=" + this.itemType + ", initialToggleState=" + this.initialToggleState + ")";
    }

    public StackHeaderToolbarMenuItemConfig(String id, String str, String str2, String str3, String str4, boolean z, boolean z2, StackHeaderToolbarMenuItemShowAsAction showAsAction, Drawable drawable, Integer num, Integer num2, Integer num3, Integer num4, String str5, StackHeaderToolbarMenuItemType itemType, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(showAsAction, "showAsAction");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.id = id;
        this.title = str;
        this.titleCondensed = str2;
        this.tooltipText = str3;
        this.accessibilityLabel = str4;
        this.hidden = z;
        this.disabled = z2;
        this.showAsAction = showAsAction;
        this.icon = drawable;
        this.iconTintColorNormal = num;
        this.iconTintColorPressed = num2;
        this.iconTintColorFocused = num3;
        this.iconTintColorDisabled = num4;
        this.groupId = str5;
        this.itemType = itemType;
        this.initialToggleState = z3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleCondensed() {
        return this.titleCondensed;
    }

    public final String getTooltipText() {
        return this.tooltipText;
    }

    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final StackHeaderToolbarMenuItemShowAsAction getShowAsAction() {
        return this.showAsAction;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final Integer getIconTintColorNormal() {
        return this.iconTintColorNormal;
    }

    public final Integer getIconTintColorPressed() {
        return this.iconTintColorPressed;
    }

    public final Integer getIconTintColorFocused() {
        return this.iconTintColorFocused;
    }

    public final Integer getIconTintColorDisabled() {
        return this.iconTintColorDisabled;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final StackHeaderToolbarMenuItemType getItemType() {
        return this.itemType;
    }

    public final boolean getInitialToggleState() {
        return this.initialToggleState;
    }
}
