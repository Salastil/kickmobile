package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StackHeaderToolbarMenuUpdateQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuIconResolver;", "", "resolve", "", "iconSource", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", "onResolved", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "icon", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StackHeaderToolbarMenuIconResolver {
    void resolve(StackHeaderToolbarMenuItemIconSource iconSource, Function1<? super StackHeaderToolbarFieldUpdate<? extends Drawable>, Unit> onResolved);
}
