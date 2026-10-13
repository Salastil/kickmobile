package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.gamma.helpers.ReadableMapExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: StackHeaderToolbarMenuMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0019H\u0002J,\u0010\u001a\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u001e\u001a\u00020\u001f*\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\bH\u0002J\u001c\u0010#\u001a\u00020$*\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00020\bH\u0002J\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'*\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0002J#\u0010(\u001a\u0004\u0018\u00010)*\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020)H\u0002¢\u0006\u0002\u0010*J\u001e\u0010+\u001a\u0004\u0018\u00010\u001f*\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001fH\u0002J$\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010'*\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\bH\u0002¨\u0006."}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuMapper;", "", "<init>", "()V", "parseMenu", "Lkotlin/Pair;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "value", "Lcom/facebook/react/bridge/Dynamic;", "parseMenuElementOptions", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "parseMenuElementIconSource", "parseGroups", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupConfig;", "parseChildren", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "iconSources", "", "parseElement", "parseItemIconSource", "parseItemConfig", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "readShowAsActionEnum", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;", "key", Constants.COLLATION_DEFAULT, "toShowAsActionEnum", "readItemTypeEnum", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemType;", "toItemTypeEnum", "readNullableStringUpdate", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "readNullableBooleanUpdate", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Z)Ljava/lang/Boolean;", "readNullableShowAsActionEnumUpdate", "readNullableColorUpdate", "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderToolbarMenuMapper {
    public static final StackHeaderToolbarMenuMapper INSTANCE = new StackHeaderToolbarMenuMapper();

    private StackHeaderToolbarMenuMapper() {
    }

    public final Pair<StackHeaderToolbarMenuConfig, Map<String, StackHeaderToolbarMenuItemIconSource>> parseMenu(Context context, Dynamic value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isNull()) {
            return new Pair<>(new StackHeaderToolbarMenuConfig(CollectionsKt.emptyList(), CollectionsKt.emptyList()), MapsKt.emptyMap());
        }
        ReadableMap readableMapAsMapOrNull = StackHeaderToolbarMenuMapperKt.asMapOrNull(value);
        if (readableMapAsMapOrNull == null) {
            throw new JSApplicationIllegalArgumentException("[RNScreens] toolbarMenu must be an object.");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new Pair<>(new StackHeaderToolbarMenuConfig(parseGroups(readableMapAsMapOrNull), parseChildren(context, readableMapAsMapOrNull, linkedHashMap)), linkedHashMap);
    }

    public final StackHeaderToolbarMenuElementOptions parseMenuElementOptions(Context context, ReadableMap map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        return new StackHeaderToolbarMenuElementOptions(readNullableStringUpdate(map, "title"), readNullableStringUpdate(map, "titleCondensed"), readNullableStringUpdate(map, "tooltipText"), readNullableStringUpdate(map, ViewProps.ACCESSIBILITY_LABEL), readNullableBooleanUpdate(map, ViewProps.HIDDEN, false), readNullableBooleanUpdate(map, "disabled", false), readNullableShowAsActionEnumUpdate(map, "showAsAction", StackHeaderToolbarMenuItemDefaults.INSTANCE.getSHOW_AS_ACTION()), null, readNullableColorUpdate(map, context, "iconTintColorNormal"), readNullableColorUpdate(map, context, "iconTintColorPressed"), readNullableColorUpdate(map, context, "iconTintColorFocused"), readNullableColorUpdate(map, context, "iconTintColorDisabled"), readNullableBooleanUpdate(map, "checked", false), readNullableStringUpdate(map, "menuTitle"));
    }

    public final StackHeaderToolbarMenuItemIconSource parseMenuElementIconSource(ReadableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.hasKey("drawableIconResourceName") || map.hasKey("imageIconResource")) {
            return new StackHeaderToolbarMenuItemIconSource(map.getString("drawableIconResourceName"), ReadableMapExtKt.readImageUri(map, "imageIconResource", null));
        }
        return null;
    }

    private final List<StackHeaderToolbarMenuGroupConfig> parseGroups(ReadableMap map) {
        ReadableArray array = map.getArray("groups");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, array.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ReadableMap map2 = array.getMap(((IntIterator) it).nextInt());
            if (map2 == null) {
                throw new IllegalArgumentException("[RNScreens] Menu groups array must contain valid group specification objects.".toString());
            }
            arrayList.add(new StackHeaderToolbarMenuGroupConfig(ReadableMapExtKt.requireNotNullString(map2, "groupId"), ReadableMapExtKt.readBoolean(map2, "singleSelection", false)));
        }
        return arrayList;
    }

    private final List<StackHeaderToolbarMenuElementConfig> parseChildren(Context context, ReadableMap map, Map<String, StackHeaderToolbarMenuItemIconSource> iconSources) {
        ReadableArray array = map.getArray("children");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, array.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ReadableMap map2 = array.getMap(((IntIterator) it).nextInt());
            if (map2 == null) {
                throw new IllegalArgumentException("[RNScreens] Menu children array must contain valid menu element specification objects.".toString());
            }
            arrayList.add(INSTANCE.parseElement(context, map2, iconSources));
        }
        return arrayList;
    }

    private final StackHeaderToolbarMenuElementConfig parseElement(Context context, ReadableMap map, Map<String, StackHeaderToolbarMenuItemIconSource> iconSources) {
        StackHeaderToolbarMenuItemConfig itemConfig = parseItemConfig(context, map);
        iconSources.put(itemConfig.getId(), parseItemIconSource(map));
        String optionalString = ReadableMapExtKt.readOptionalString(map, "type");
        if (Intrinsics.areEqual(optionalString, "menuItem")) {
            return new StackHeaderToolbarMenuElementConfig.MenuItem(itemConfig);
        }
        if (Intrinsics.areEqual(optionalString, "menu")) {
            return new StackHeaderToolbarMenuElementConfig.Submenu(itemConfig, new StackHeaderToolbarMenuConfig(parseGroups(map), parseChildren(context, map, iconSources)), ReadableMapExtKt.readOptionalString(map, "menuTitle"));
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Unknown toolbar menu element type: " + optionalString + ".");
    }

    private final StackHeaderToolbarMenuItemIconSource parseItemIconSource(ReadableMap map) {
        String string = map.getString("drawableIconResourceName");
        if (string == null) {
            string = StackHeaderToolbarMenuItemDefaults.INSTANCE.getDRAWABLE_ICON_RESOURCE_NAME();
        }
        return new StackHeaderToolbarMenuItemIconSource(string, ReadableMapExtKt.readImageUri(map, "imageIconResource", StackHeaderToolbarMenuItemDefaults.INSTANCE.getIMAGE_ICON_URI()));
    }

    private final StackHeaderToolbarMenuItemConfig parseItemConfig(Context context, ReadableMap map) {
        String strRequireNotNullString = ReadableMapExtKt.requireNotNullString(map, "id");
        String optionalString = ReadableMapExtKt.readOptionalString(map, "title");
        if (optionalString == null) {
            optionalString = StackHeaderToolbarMenuItemDefaults.INSTANCE.getTITLE();
        }
        String optionalString2 = ReadableMapExtKt.readOptionalString(map, "titleCondensed");
        if (optionalString2 == null) {
            optionalString2 = StackHeaderToolbarMenuItemDefaults.INSTANCE.getTITLE_CONDENSED();
        }
        String optionalString3 = ReadableMapExtKt.readOptionalString(map, "tooltipText");
        if (optionalString3 == null) {
            optionalString3 = StackHeaderToolbarMenuItemDefaults.INSTANCE.getTOOLTIP_TEXT();
        }
        String optionalString4 = ReadableMapExtKt.readOptionalString(map, ViewProps.ACCESSIBILITY_LABEL);
        if (optionalString4 == null) {
            optionalString4 = StackHeaderToolbarMenuItemDefaults.INSTANCE.getACCESSIBILITY_LABEL();
        }
        return new StackHeaderToolbarMenuItemConfig(strRequireNotNullString, optionalString, optionalString2, optionalString3, optionalString4, ReadableMapExtKt.readBoolean(map, ViewProps.HIDDEN, false), ReadableMapExtKt.readBoolean(map, "disabled", false), readShowAsActionEnum(map, "showAsAction", StackHeaderToolbarMenuItemDefaults.INSTANCE.getSHOW_AS_ACTION()), null, ReadableMapExtKt.readColor(map, context, "iconTintColorNormal", StackHeaderToolbarMenuItemDefaults.INSTANCE.getICON_TINT_COLOR_NORMAL()), ReadableMapExtKt.readColor(map, context, "iconTintColorPressed", StackHeaderToolbarMenuItemDefaults.INSTANCE.getICON_TINT_COLOR_PRESSED()), ReadableMapExtKt.readColor(map, context, "iconTintColorFocused", StackHeaderToolbarMenuItemDefaults.INSTANCE.getICON_TINT_COLOR_FOCUSED()), ReadableMapExtKt.readColor(map, context, "iconTintColorDisabled", StackHeaderToolbarMenuItemDefaults.INSTANCE.getICON_TINT_COLOR_DISABLED()), ReadableMapExtKt.readOptionalString(map, "groupId"), readItemTypeEnum(map, "itemType", StackHeaderToolbarMenuItemDefaults.INSTANCE.getITEM_TYPE()), ReadableMapExtKt.readBoolean(map, "initialToggleState", false));
    }

    private final StackHeaderToolbarMenuItemShowAsAction readShowAsActionEnum(ReadableMap readableMap, String str, StackHeaderToolbarMenuItemShowAsAction stackHeaderToolbarMenuItemShowAsAction) {
        String optionalString = ReadableMapExtKt.readOptionalString(readableMap, str);
        return optionalString == null ? stackHeaderToolbarMenuItemShowAsAction : toShowAsActionEnum(optionalString);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final StackHeaderToolbarMenuItemShowAsAction toShowAsActionEnum(String value) {
        switch (value.hashCode()) {
            case -1962930485:
                if (value.equals("ifRoomWithText")) {
                    return StackHeaderToolbarMenuItemShowAsAction.IF_ROOM_WITH_TEXT;
                }
                break;
            case -1414557169:
                if (value.equals("always")) {
                    return StackHeaderToolbarMenuItemShowAsAction.ALWAYS;
                }
                break;
            case -1192154216:
                if (value.equals("ifRoom")) {
                    return StackHeaderToolbarMenuItemShowAsAction.IF_ROOM;
                }
                break;
            case 104712844:
                if (value.equals("never")) {
                    return StackHeaderToolbarMenuItemShowAsAction.NEVER;
                }
                break;
            case 264769090:
                if (value.equals("alwaysWithText")) {
                    return StackHeaderToolbarMenuItemShowAsAction.ALWAYS_WITH_TEXT;
                }
                break;
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid value for StackHeaderToolbarMenuItemShowAsAction: " + value + ".");
    }

    private final StackHeaderToolbarMenuItemType readItemTypeEnum(ReadableMap readableMap, String str, StackHeaderToolbarMenuItemType stackHeaderToolbarMenuItemType) {
        String optionalString = ReadableMapExtKt.readOptionalString(readableMap, str);
        return optionalString == null ? stackHeaderToolbarMenuItemType : toItemTypeEnum(optionalString);
    }

    private final StackHeaderToolbarMenuItemType toItemTypeEnum(String value) {
        int iHashCode = value.hashCode();
        if (iHashCode != -1422950858) {
            if (iHashCode != -868304044) {
                if (iHashCode == 1673671211 && value.equals("automatic")) {
                    return StackHeaderToolbarMenuItemType.AUTOMATIC;
                }
            } else if (value.equals("toggle")) {
                return StackHeaderToolbarMenuItemType.TOGGLE;
            }
        } else if (value.equals("action")) {
            return StackHeaderToolbarMenuItemType.ACTION;
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid value for StackHeaderToolbarMenuItemType: " + value + ".");
    }

    private final StackHeaderToolbarFieldUpdate<String> readNullableStringUpdate(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.isNull(str) ? StackHeaderToolbarFieldUpdate.Reset.INSTANCE : StackHeaderToolbarFieldUpdate.INSTANCE.from(readableMap.getString(str));
        }
        return null;
    }

    private final Boolean readNullableBooleanUpdate(ReadableMap readableMap, String str, boolean z) {
        if (readableMap.hasKey(str)) {
            return readableMap.isNull(str) ? Boolean.valueOf(z) : Boolean.valueOf(readableMap.getBoolean(str));
        }
        return null;
    }

    private final StackHeaderToolbarMenuItemShowAsAction readNullableShowAsActionEnumUpdate(ReadableMap readableMap, String str, StackHeaderToolbarMenuItemShowAsAction stackHeaderToolbarMenuItemShowAsAction) {
        String string;
        StackHeaderToolbarMenuItemShowAsAction showAsActionEnum;
        if (readableMap.hasKey(str)) {
            return (readableMap.isNull(str) || (string = readableMap.getString(str)) == null || (showAsActionEnum = INSTANCE.toShowAsActionEnum(string)) == null) ? stackHeaderToolbarMenuItemShowAsAction : showAsActionEnum;
        }
        return null;
    }

    private final StackHeaderToolbarFieldUpdate<Integer> readNullableColorUpdate(ReadableMap readableMap, Context context, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.isNull(str) ? StackHeaderToolbarFieldUpdate.Reset.INSTANCE : StackHeaderToolbarFieldUpdate.INSTANCE.from(ReadableMapExtKt.parseColor(readableMap, context, str));
        }
        return null;
    }
}
