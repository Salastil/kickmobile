package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.LargeIconButtonTokens;
import androidx.compose.material3.tokens.MediumIconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.StandardIconButtonTokens;
import androidx.compose.material3.tokens.XLargeIconButtonTokens;
import androidx.compose.material3.tokens.XSmallIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IconButtonDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002¿\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u001dJ\u0011\u0010#\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\rJ\r\u0010*\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010*\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b+\u0010\u001dJ\r\u0010/\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b0\u0010\rJ\r\u00103\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u001dJ\r\u00107\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u00107\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b8\u0010\rJ\u001b\u00109\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b:\u0010\u0012J\r\u0010;\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010;\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b<\u0010\rJ\u0011\u0010=\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010?\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010A\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\bB\u0010 J\r\u0010C\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010C\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\bD\u0010\u001dJ\u0011\u0010E\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001f\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001f\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u0015\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ*\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010RH\u0007¢\u0006\u0003\u0010\u0093\u0001J\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0007¢\u0006\u0003\u0010\u0094\u0001J7\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010RH\u0007¢\u0006\u0003\u0010\u009e\u0001J\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0007¢\u0006\u0003\u0010\u009f\u0001J\u001d\u0010±\u0001\u001a\u00030²\u00012\n\b\u0002\u0010³\u0001\u001a\u00030´\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001d\u0010·\u0001\u001a\u00030²\u00012\n\b\u0002\u0010³\u0001\u001a\u00030´\u0001¢\u0006\u0006\b¸\u0001\u0010¶\u0001J\u001d\u0010¹\u0001\u001a\u00030²\u00012\n\b\u0002\u0010³\u0001\u001a\u00030´\u0001¢\u0006\u0006\bº\u0001\u0010¶\u0001J\u001d\u0010»\u0001\u001a\u00030²\u00012\n\b\u0002\u0010³\u0001\u001a\u00030´\u0001¢\u0006\u0006\b¼\u0001\u0010¶\u0001J\u001d\u0010½\u0001\u001a\u00030²\u00012\n\b\u0002\u0010³\u0001\u001a\u00030´\u0001¢\u0006\u0006\b¾\u0001\u0010¶\u0001R\u0018\u0010'\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u0018\u00105\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.R\u0011\u0010Q\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bX\u0010TR\u0011\u0010Y\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bZ\u0010TR\u0011\u0010[\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\b\\\u0010TR\u0011\u0010]\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\b^\u0010TR\u0011\u0010_\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\b`\u0010TR\u0011\u0010a\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bb\u0010TR\u0011\u0010c\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bd\u0010TR\u0011\u0010e\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bf\u0010TR\u0011\u0010g\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bh\u0010TR\u0011\u0010i\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bj\u0010TR\u0011\u0010k\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bl\u0010TR\u001a\u0010m\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bn\u0010o\u001a\u0004\bp\u0010TR\u0011\u0010q\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\br\u0010TR\u0011\u0010s\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bt\u0010TR\u0011\u0010u\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bv\u0010TR\u0011\u0010w\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bx\u0010TR\u0011\u0010y\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bz\u0010TR\u0011\u0010{\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\b|\u0010TR\u0011\u0010}\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\b~\u0010TR\u0012\u0010\u007f\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010TR\u0013\u0010\u0081\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010TR\u0013\u0010\u0083\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010TR\u0013\u0010\u0085\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010TR\u0013\u0010\u0087\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010TR\u0013\u0010\u0089\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010TR\u0013\u0010\u008b\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010TR\u0013\u0010\u008d\u0001\u001a\u00020R8G¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010TR%\u0010\u0095\u0001\u001a\u00030\u0090\u0001*\u00030\u0096\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R%\u0010 \u0001\u001a\u00030\u009c\u0001*\u00030\u0096\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b¡\u0001\u0010\u0098\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00030¥\u0001¢\u0006\r\n\u0003\u0010¨\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010©\u0001\u001a\u00030¥\u0001¢\u0006\r\n\u0003\u0010¨\u0001\u001a\u0006\bª\u0001\u0010§\u0001R\u0018\u0010«\u0001\u001a\u00030¥\u0001¢\u0006\r\n\u0003\u0010¨\u0001\u001a\u0006\b¬\u0001\u0010§\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030¥\u0001¢\u0006\r\n\u0003\u0010¨\u0001\u001a\u0006\b®\u0001\u0010§\u0001R\u0018\u0010¯\u0001\u001a\u00030¥\u0001¢\u0006\r\n\u0003\u0010¨\u0001\u001a\u0006\b°\u0001\u0010§\u0001¨\u0006À\u0001"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "<init>", "()V", "iconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "iconButtonVibrantColors", "iconButtonVibrantColors-ro_MJ88", "defaultIconButtonVibrantColors", "defaultIconButtonVibrantColors$material3", "iconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "iconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "iconToggleButtonVibrantColors", "iconToggleButtonVibrantColors-5tl4gsc", "defaultIconToggleButtonVibrantColors", "defaultIconToggleButtonVibrantColors$material3", "filledIconButtonColors", "filledIconButtonColors-ro_MJ88", "defaultFilledIconButtonColors", "getDefaultFilledIconButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "filledIconToggleButtonColors-5tl4gsc", "defaultFilledIconToggleButtonColors", "getDefaultFilledIconToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3", "outlinedIconButtonVibrantColors", "outlinedIconButtonVibrantColors-ro_MJ88", "defaultOutlinedIconButtonVibrantColors", "defaultOutlinedIconButtonVibrantColors$material3", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3", "outlinedIconToggleButtonVibrantColors", "outlinedIconToggleButtonVibrantColors-5tl4gsc", "defaultOutlinedIconToggleButtonVibrantColors", "defaultOutlinedIconToggleButtonVibrantColors$material3", "outlinedIconToggleButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonVibrantBorder", "outlinedIconButtonBorder", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonVibrantBorder", "standardShape", "Landroidx/compose/ui/graphics/Shape;", "getStandardShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledShape", "getFilledShape", "outlinedShape", "getOutlinedShape", "extraSmallRoundShape", "getExtraSmallRoundShape", "extraSmallSquareShape", "getExtraSmallSquareShape", "extraSmallPressedShape", "getExtraSmallPressedShape", "extraSmallSelectedRoundShape", "getExtraSmallSelectedRoundShape", "extraSmallSelectedSquareShape", "getExtraSmallSelectedSquareShape", "smallRoundShape", "getSmallRoundShape", "smallSquareShape", "getSmallSquareShape", "smallPressedShape", "getSmallPressedShape", "smallSelectedRoundShape", "getSmallSelectedRoundShape", "smallSelectedSquareShape", "getSmallSelectedSquareShape", "SmallSelectedSquareShape", "getSmallSelectedSquareShape_pascalName$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getSmallSelectedSquareShape_pascalName", "mediumRoundShape", "getMediumRoundShape", "mediumSquareShape", "getMediumSquareShape", "mediumPressedShape", "getMediumPressedShape", "mediumSelectedRoundShape", "getMediumSelectedRoundShape", "mediumSelectedSquareShape", "getMediumSelectedSquareShape", "largeRoundShape", "getLargeRoundShape", "largeSquareShape", "getLargeSquareShape", "largePressedShape", "getLargePressedShape", "largeSelectedRoundShape", "getLargeSelectedRoundShape", "largeSelectedSquareShape", "getLargeSelectedSquareShape", "extraLargeRoundShape", "getExtraLargeRoundShape", "extraLargeSquareShape", "getExtraLargeSquareShape", "extraLargePressedShape", "getExtraLargePressedShape", "extraLargeSelectedRoundShape", "getExtraLargeSelectedRoundShape", "extraLargeSelectedSquareShape", "getExtraLargeSelectedSquareShape", "shapes", "Landroidx/compose/material3/IconButtonShapes;", "shape", "pressedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonShapes;", "defaultIconButtonShapes", "Landroidx/compose/material3/Shapes;", "getDefaultIconButtonShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultIconButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/IconButtonShapes;", "toggleableShapes", "Landroidx/compose/material3/IconToggleButtonShapes;", "checkedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonShapes;", "defaultIconToggleButtonShapes", "getDefaultIconToggleButtonShapes$material3$annotations", "getDefaultIconToggleButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/IconToggleButtonShapes;", "extraSmallIconSize", "Landroidx/compose/ui/unit/Dp;", "getExtraSmallIconSize-D9Ej5fM", "()F", "F", "smallIconSize", "getSmallIconSize-D9Ej5fM", "mediumIconSize", "getMediumIconSize-D9Ej5fM", "largeIconSize", "getLargeIconSize-D9Ej5fM", "extraLargeIconSize", "getExtraLargeIconSize-D9Ej5fM", "extraSmallContainerSize", "Landroidx/compose/ui/unit/DpSize;", "widthOption", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "extraSmallContainerSize-N-wlBFI", "(I)J", "smallContainerSize", "smallContainerSize-N-wlBFI", "mediumContainerSize", "mediumContainerSize-N-wlBFI", "largeContainerSize", "largeContainerSize-N-wlBFI", "extraLargeContainerSize", "extraLargeContainerSize-N-wlBFI", "IconButtonWidthOption", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();
    private static final float extraSmallIconSize = XSmallIconButtonTokens.INSTANCE.m6382getIconSizeD9Ej5fM();
    private static final float smallIconSize = SmallIconButtonTokens.INSTANCE.m6186getIconSizeD9Ej5fM();
    private static final float mediumIconSize = MediumIconButtonTokens.INSTANCE.m5951getIconSizeD9Ej5fM();
    private static final float largeIconSize = LargeIconButtonTokens.INSTANCE.m5900getIconSizeD9Ej5fM();
    private static final float extraLargeIconSize = XLargeIconButtonTokens.INSTANCE.m6373getIconSizeD9Ej5fM();

    public static /* synthetic */ void getDefaultIconButtonShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultIconToggleButtonShapes$material3$annotations(Shapes shapes) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the camel case version", replaceWith = @ReplaceWith(expression = "smallSelectedSquareShape", imports = {}))
    public static /* synthetic */ void getSmallSelectedSquareShape_pascalName$annotations(Composer composer, int i) {
    }

    private IconButtonDefaults() {
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1037266503, "C(iconButtonColors)50@2164L7,51@2207L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1037266503, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:49)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        IconButtonColors iconButtonColorsM4113defaultIconButtonColors4WTKRHQ$material3 = m4113defaultIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM7348unboximpl);
        if (!Color.m7339equalsimpl0(iconButtonColorsM4113defaultIconButtonColors4WTKRHQ$material3.getContentColor(), jM7348unboximpl)) {
            iconButtonColorsM4113defaultIconButtonColors4WTKRHQ$material3 = IconButtonColors.m4100copyjRlVdoo$default(iconButtonColorsM4113defaultIconButtonColors4WTKRHQ$material3, 0L, jM7348unboximpl, 0L, Color.m7337copywmQWz5c$default(jM7348unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4113defaultIconButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4128iconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long j5;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1639168605, "C(iconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)80@3507L7,85@3742L11,86@3809L7:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        } else {
            jM7348unboximpl = j2;
        }
        long jM7374getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM7348unboximpl;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j6, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM7348unboximpl;
            jM7337copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1639168605, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:85)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = m4113defaultIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m7348unboximpl()).m4103copyjRlVdoo(jM7374getUnspecified0d7_KjU, j5, jM7374getUnspecified0d7_KjU2, jM7337copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m4113defaultIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultIconButtonColorsCached = colorScheme.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached != null) {
            return defaultIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), j, Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors iconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 111454247, "C(iconButtonVibrantColors)117@5073L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(111454247, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:117)");
        }
        IconButtonColors iconButtonColorsDefaultIconButtonVibrantColors$material3 = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4129iconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, 1036440437, "C(iconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)139@6116L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j6, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1036440437, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:139)");
        }
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4103copyjRlVdoo(jM7374getUnspecified0d7_KjU, j5, jM7374getUnspecified0d7_KjU3, jM7337copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    public final IconButtonColors defaultIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultIconButtonVibrantColorsCached = colorScheme.getDefaultIconButtonVibrantColorsCached();
        if (defaultIconButtonVibrantColorsCached != null) {
            return defaultIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-1355771567);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)172@7603L7,173@7646L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355771567, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:171)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM4114defaultIconToggleButtonColors4WTKRHQ$material3 = m4114defaultIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM7348unboximpl);
        if (!Color.m7339equalsimpl0(iconToggleButtonColorsM4114defaultIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM7348unboximpl)) {
            IconToggleButtonColors iconToggleButtonColorsM4156copytNS2XkQ$default = IconToggleButtonColors.m4156copytNS2XkQ$default(iconToggleButtonColorsM4114defaultIconToggleButtonColors4WTKRHQ$material3, 0L, jM7348unboximpl, 0L, Color.m7337copywmQWz5c$default(jM7348unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM4156copytNS2XkQ$default;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM4114defaultIconToggleButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4130iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long j7;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, 1402082449, "C(iconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)203@9087L7,210@9442L11,211@9515L7:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        } else {
            jM7348unboximpl = j2;
        }
        long jM7374getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM7348unboximpl;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j8, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM7348unboximpl;
            jM7337copywmQWz5c$default = j4;
        }
        long jM7374getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1402082449, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:210)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long j9 = jM7374getUnspecified0d7_KjU;
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = m4114defaultIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m7348unboximpl()).m4157copytNS2XkQ(j9, j7, jM7374getUnspecified0d7_KjU2, jM7337copywmQWz5c$default, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m4114defaultIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), j, Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1755001127, "C(iconToggleButtonVibrantColors)248@11186L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1755001127, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:248)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3 = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4131iconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1027328773, "C(iconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)274@12554L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j8, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = j4;
        }
        long jM7374getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1027328773, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:274)");
        }
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4157copytNS2XkQ(jM7374getUnspecified0d7_KjU, j7, jM7374getUnspecified0d7_KjU3, jM7337copywmQWz5c$default, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached = colorScheme.getDefaultIconToggleButtonVibrantColorsCached();
        if (defaultIconToggleButtonVibrantColorsCached != null) {
            return defaultIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonVibrantColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -958304265, "C(filledIconButtonColors)307@14134L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-958304265, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:307)");
        }
        IconButtonColors defaultFilledIconButtonColors$material3 = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4119filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -245481051, "C(filledIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)320@14778L31,324@14975L11:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m7374getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM3712contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(j5, composer, i & 14) : j2;
        long jM7374getUnspecified0d7_KjU = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245481051, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:324)");
        }
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4103copyjRlVdoo(j5, jM3712contentColorForek8zF_U, jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledIconButtonColorsCached = colorScheme.getDefaultFilledIconButtonColorsCached();
        if (defaultFilledIconButtonColorsCached != null) {
            return defaultFilledIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1455160689, "C(filledIconToggleButtonColors)353@16377L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455160689, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:353)");
        }
        IconToggleButtonColors defaultFilledIconToggleButtonColors$material3 = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4120filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1473292947, "C(filledIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)375@17591L38,377@17685L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM3712contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(jM7374getUnspecified0d7_KjU5, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1473292947, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:377)");
        }
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4157copytNS2XkQ(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM3712contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledIconToggleButtonColorsCached = colorScheme.getDefaultFilledIconToggleButtonColorsCached();
        if (defaultFilledIconToggleButtonColorsCached != null) {
            return defaultFilledIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1145002745, "C(filledTonalIconButtonColors)414@19664L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1145002745, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:414)");
        }
        IconButtonColors defaultFilledTonalIconButtonColors$material3 = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4121filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 562762851, "C(filledTonalIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)428@20330L31,432@20527L11:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m7374getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM3712contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(j5, composer, i & 14) : j2;
        long jM7374getUnspecified0d7_KjU = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(562762851, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:432)");
        }
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4103copyjRlVdoo(j5, jM3712contentColorForek8zF_U, jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledTonalIconButtonColorsCached = colorScheme.getDefaultFilledTonalIconButtonColorsCached();
        if (defaultFilledTonalIconButtonColorsCached != null) {
            return defaultFilledTonalIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledTonalIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 656374417, "C(filledTonalIconToggleButtonColors)461@21989L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(656374417, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:461)");
        }
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColors$material3 = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4122filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2130748241, "C(filledTonalIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)477@22855L31,481@23099L38,483@23193L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM3712contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(jM7374getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM3712contentColorForek8zF_U2 = (i2 & 32) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(jM7374getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130748241, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:483)");
        }
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4157copytNS2XkQ(jM7374getUnspecified0d7_KjU, jM3712contentColorForek8zF_U, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM3712contentColorForek8zF_U2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached = colorScheme.getDefaultFilledTonalIconToggleButtonColorsCached();
        if (defaultFilledTonalIconToggleButtonColorsCached != null) {
            return defaultFilledTonalIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledTonalIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(1591384183);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)521@25284L7,522@25327L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1591384183, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:520)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        IconButtonColors iconButtonColorsM4115defaultOutlinedIconButtonColors4WTKRHQ$material3 = m4115defaultOutlinedIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM7348unboximpl);
        if (!Color.m7339equalsimpl0(iconButtonColorsM4115defaultOutlinedIconButtonColors4WTKRHQ$material3.getContentColor(), jM7348unboximpl)) {
            IconButtonColors iconButtonColorsM4100copyjRlVdoo$default = IconButtonColors.m4100copyjRlVdoo$default(iconButtonColorsM4115defaultOutlinedIconButtonColors4WTKRHQ$material3, 0L, jM7348unboximpl, 0L, Color.m7337copywmQWz5c$default(jM7348unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconButtonColorsM4100copyjRlVdoo$default;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconButtonColorsM4115defaultOutlinedIconButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4134outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long j5;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1335916251, "C(outlinedIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)549@26474L7,554@26709L11,555@26784L7:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        } else {
            jM7348unboximpl = j2;
        }
        long jM7374getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM7348unboximpl;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j6, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM7348unboximpl;
            jM7337copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1335916251, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:554)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = m4115defaultOutlinedIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m7348unboximpl()).m4103copyjRlVdoo(jM7374getUnspecified0d7_KjU, j5, jM7374getUnspecified0d7_KjU2, jM7337copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m4115defaultOutlinedIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultOutlinedIconButtonColorsCached = colorScheme.getDefaultOutlinedIconButtonColorsCached();
        if (defaultOutlinedIconButtonColorsCached != null) {
            return defaultOutlinedIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), j, Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors outlinedIconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -899469399, "C(outlinedIconButtonVibrantColors)588@28091L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-899469399, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:588)");
        }
        IconButtonColors iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3 = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m4135outlinedIconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -278201933, "C(outlinedIconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)610@29147L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j6, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278201933, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:610)");
        }
        IconButtonColors iconButtonColorsM4103copyjRlVdoo = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4103copyjRlVdoo(jM7374getUnspecified0d7_KjU, j5, jM7374getUnspecified0d7_KjU3, jM7337copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM4103copyjRlVdoo;
    }

    public final IconButtonColors defaultOutlinedIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultOutlinedIconButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconButtonVibrantColorsCached();
        if (defaultOutlinedIconButtonVibrantColorsCached != null) {
            return defaultOutlinedIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-834376945);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)644@30691L7,645@30734L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834376945, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:643)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3 = m4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM7348unboximpl);
        if (!Color.m7339equalsimpl0(iconToggleButtonColorsM4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM7348unboximpl)) {
            IconToggleButtonColors iconToggleButtonColorsM4156copytNS2XkQ$default = IconToggleButtonColors.m4156copytNS2XkQ$default(iconToggleButtonColorsM4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3, 0L, jM7348unboximpl, 0L, Color.m7337copywmQWz5c$default(jM7348unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM4156copytNS2XkQ$default;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4136outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long j7;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -514625005, "C(outlinedIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)675@32158L7,680@32440L38,682@32534L11,683@32615L7:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        } else {
            jM7348unboximpl = j2;
        }
        long jM7374getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM7348unboximpl;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j8, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM7348unboximpl;
            jM7337copywmQWz5c$default = j4;
        }
        long jM7374getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM3712contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(jM7374getUnspecified0d7_KjU3, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514625005, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:682)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = m4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m7348unboximpl()).m4157copytNS2XkQ(jM7374getUnspecified0d7_KjU, j7, jM7374getUnspecified0d7_KjU2, jM7337copywmQWz5c$default, jM7374getUnspecified0d7_KjU3, jM3712contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m4116defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), j, Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m3711contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1236236887, "C(outlinedIconToggleButtonVibrantColors)726@34507L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1236236887, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:726)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3 = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m4137outlinedIconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long jM7337copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -142016199, "C(outlinedIconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)750@35816L38,752@35910L11:IconButtonDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j8, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM7374getUnspecified0d7_KjU2;
            jM7337copywmQWz5c$default = j4;
        }
        long jM7374getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM3712contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(jM7374getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-142016199, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:752)");
        }
        IconToggleButtonColors iconToggleButtonColorsM4157copytNS2XkQ = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4157copytNS2XkQ(jM7374getUnspecified0d7_KjU, j7, jM7374getUnspecified0d7_KjU3, jM7337copywmQWz5c$default, jM7374getUnspecified0d7_KjU4, jM3712contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM4157copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconToggleButtonVibrantColorsCached();
        if (defaultOutlinedIconToggleButtonVibrantColorsCached != null) {
            return defaultOutlinedIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(1933433512);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonBorder)N(enabled,checked)797@38020L33:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1933433512, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButtonDefaults.kt:793)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconToggleButtonVibrantBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(394022990);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonVibrantBorder)N(enabled,checked)812@38567L40:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394022990, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantBorder (IconButtonDefaults.kt:808)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonVibrantBorder = outlinedIconButtonVibrantBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonVibrantBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1270640488, "C(outlinedIconButtonBorder)N(enabled)826@39128L7,833@39353L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1270640488, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButtonDefaults.kt:825)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM7348unboximpl = ((Color) objConsume).m7348unboximpl();
        if (!z) {
            jM7348unboximpl = Color.m7337copywmQWz5c$default(jM7348unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1314786165, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(jM7348unboximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m1584BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m6189getOutlinedOutlineWidthD9Ej5fM(), jM7348unboximpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }

    public final BorderStroke outlinedIconButtonVibrantBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2139728858, "C(outlinedIconButtonVibrantBorder)N(enabled)844@39847L5,851@40070L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2139728858, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantBorder (IconButtonDefaults.kt:843)");
        }
        long value = ColorSchemeKt.getValue(OutlinedIconButtonTokens.INSTANCE.getOutlineColor(), composer, 6);
        if (!z) {
            value = Color.m7337copywmQWz5c$default(value, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1009913785, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(value);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m1584BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m6189getOutlinedOutlineWidthD9Ej5fM(), value);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }

    public final Shape getStandardShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -377108005, "C(<get-standardShape>)856@40320L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-377108005, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-standardShape> (IconButtonDefaults.kt:856)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1542796069, "C(<get-filledShape>)860@40475L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1542796069, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButtonDefaults.kt:860)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1706356635, "C(<get-outlinedShape>)864@40635L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1706356635, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButtonDefaults.kt:864)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1321634995, "C(<get-extraSmallRoundShape>)868@40813L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1321634995, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallRoundShape> (IconButtonDefaults.kt:868)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 219275465, "C(<get-extraSmallSquareShape>)872@40994L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(219275465, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSquareShape> (IconButtonDefaults.kt:872)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1061421875, "C(<get-extraSmallPressedShape>)876@41178L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1061421875, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallPressedShape> (IconButtonDefaults.kt:876)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 370391251, "C(<get-extraSmallSelectedRoundShape>)880@41375L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(370391251, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSelectedRoundShape> (IconButtonDefaults.kt:880)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 814033279, "C(<get-extraSmallSelectedSquareShape>)884@41582L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(814033279, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSelectedSquareShape> (IconButtonDefaults.kt:884)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2020124271, "C(<get-smallRoundShape>)888@41742L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2020124271, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallRoundShape> (IconButtonDefaults.kt:888)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 309880915, "C(<get-smallSquareShape>)892@41911L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(309880915, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallSquareShape> (IconButtonDefaults.kt:892)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -915829737, "C(<get-smallPressedShape>)896@42083L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915829737, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallPressedShape> (IconButtonDefaults.kt:896)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1359654471, "C(<get-smallSelectedRoundShape>)900@42268L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1359654471, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallSelectedRoundShape> (IconButtonDefaults.kt:900)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1515364429, "C(<get-smallSelectedSquareShape>)904@42463L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1515364429, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallSelectedSquareShape> (IconButtonDefaults.kt:904)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final /* synthetic */ Shape getSmallSelectedSquareShape_pascalName(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1665942605, "C(<get-SmallSelectedSquareShape>)913@42852L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665942605, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-SmallSelectedSquareShape> (IconButtonDefaults.kt:913)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2111840525, "C(<get-mediumRoundShape>)917@43015L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2111840525, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumRoundShape> (IconButtonDefaults.kt:917)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1471824891, "C(<get-mediumSquareShape>)921@43180L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471824891, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSquareShape> (IconButtonDefaults.kt:921)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 72043507, "C(<get-mediumPressedShape>)925@43355L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(72043507, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumPressedShape> (IconButtonDefaults.kt:925)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1651572077, "C(<get-mediumSelectedRoundShape>)929@43543L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1651572077, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSelectedRoundShape> (IconButtonDefaults.kt:929)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1224712133, "C(<get-mediumSelectedSquareShape>)933@43741L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1224712133, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSelectedSquareShape> (IconButtonDefaults.kt:933)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1926537991, "C(<get-largeRoundShape>)937@43901L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1926537991, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeRoundShape> (IconButtonDefaults.kt:937)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -137453869, "C(<get-largeSquareShape>)941@44063L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-137453869, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSquareShape> (IconButtonDefaults.kt:941)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1695211601, "C(<get-largePressedShape>)945@44235L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695211601, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largePressedShape> (IconButtonDefaults.kt:945)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -987878831, "C(<get-largeSelectedRoundShape>)949@44420L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-987878831, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSelectedRoundShape> (IconButtonDefaults.kt:949)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -577828301, "C(<get-largeSelectedSquareShape>)953@44615L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-577828301, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSelectedSquareShape> (IconButtonDefaults.kt:953)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1371354061, "C(<get-extraLargeRoundShape>)957@44787L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1371354061, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeRoundShape> (IconButtonDefaults.kt:957)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1416839217, "C(<get-extraLargeSquareShape>)961@44961L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1416839217, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSquareShape> (IconButtonDefaults.kt:961)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 481568179, "C(<get-extraLargePressedShape>)965@45145L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(481568179, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargePressedShape> (IconButtonDefaults.kt:965)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1450837075, "C(<get-extraLargeSelectedRoundShape>)969@45342L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1450837075, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSelectedRoundShape> (IconButtonDefaults.kt:969)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -116183833, "C(<get-extraLargeSelectedSquareShape>)973@45549L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-116183833, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSelectedSquareShape> (IconButtonDefaults.kt:973)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final IconButtonShapes shapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1165993094, "C(shapes)N(shape,pressedShape)985@46037L6:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1165993094, i, -1, "androidx.compose.material3.IconButtonDefaults.shapes (IconButtonDefaults.kt:985)");
        }
        IconButtonShapes iconButtonShapesCopy = getDefaultIconButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonShapesCopy;
    }

    public final IconButtonShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1198298816, "C(shapes)995@46454L6:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1198298816, i, -1, "androidx.compose.material3.IconButtonDefaults.shapes (IconButtonDefaults.kt:995)");
        }
        IconButtonShapes defaultIconButtonShapes$material3 = getDefaultIconButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultIconButtonShapes$material3;
    }

    public final IconButtonShapes getDefaultIconButtonShapes$material3(Shapes shapes) {
        IconButtonShapes defaultIconButtonShapesCached = shapes.getDefaultIconButtonShapesCached();
        if (defaultIconButtonShapesCached != null) {
            return defaultIconButtonShapesCached;
        }
        IconButtonShapes iconButtonShapes = new IconButtonShapes(ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getContainerShapeRound()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getPressedContainerShape()));
        shapes.setDefaultIconButtonShapesCached$material3(iconButtonShapes);
        return iconButtonShapes;
    }

    public final IconToggleButtonShapes toggleableShapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1794821771, "C(toggleableShapes)N(shape,pressedShape,checkedShape)1023@47650L6:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if ((i2 & 4) != 0) {
            shape3 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1794821771, i, -1, "androidx.compose.material3.IconButtonDefaults.toggleableShapes (IconButtonDefaults.kt:1023)");
        }
        IconToggleButtonShapes iconToggleButtonShapesCopy = getDefaultIconToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonShapesCopy;
    }

    public final IconToggleButtonShapes toggleableShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2022759230, "C(toggleableShapes)1036@48160L6:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2022759230, i, -1, "androidx.compose.material3.IconButtonDefaults.toggleableShapes (IconButtonDefaults.kt:1036)");
        }
        IconToggleButtonShapes defaultIconToggleButtonShapes$material3 = getDefaultIconToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultIconToggleButtonShapes$material3;
    }

    public final IconToggleButtonShapes getDefaultIconToggleButtonShapes$material3(Shapes shapes) {
        IconToggleButtonShapes defaultIconToggleButtonShapesCached = shapes.getDefaultIconToggleButtonShapesCached();
        if (defaultIconToggleButtonShapesCached != null) {
            return defaultIconToggleButtonShapesCached;
        }
        IconToggleButtonShapes iconToggleButtonShapes = new IconToggleButtonShapes(ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getContainerShapeRound()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getPressedContainerShape()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound()));
        shapes.setDefaultIconToggleButtonShapesCached$material3(iconToggleButtonShapes);
        return iconToggleButtonShapes;
    }

    /* JADX INFO: renamed from: getExtraSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4124getExtraSmallIconSizeD9Ej5fM() {
        return extraSmallIconSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4127getSmallIconSizeD9Ej5fM() {
        return smallIconSize;
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4126getMediumIconSizeD9Ej5fM() {
        return mediumIconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4125getLargeIconSizeD9Ej5fM() {
        return largeIconSize;
    }

    /* JADX INFO: renamed from: getExtraLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4123getExtraLargeIconSizeD9Ej5fM() {
        return extraLargeIconSize;
    }

    /* JADX INFO: renamed from: extraSmallContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m4109extraSmallContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs();
        }
        return iconButtonDefaults.m4118extraSmallContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: extraSmallContainerSize-N-wlBFI, reason: not valid java name */
    public final long m4118extraSmallContainerSizeNwlBFI(int widthOption) {
        float fM10168constructorimpl;
        if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4146getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4148getWiderc6NtMs())) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(XSmallIconButtonTokens.INSTANCE.m6386getWideLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m6387getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(XSmallIconButtonTokens.INSTANCE.m6380getDefaultLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m6380getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(XSmallIconButtonTokens.INSTANCE.m6383getNarrowLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m6384getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m10190DpSizeYgX7TsA(Dp.m10168constructorimpl(XSmallIconButtonTokens.INSTANCE.m6382getIconSizeD9Ej5fM() + fM10168constructorimpl), XSmallIconButtonTokens.INSTANCE.m6379getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m4112smallContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs();
        }
        return iconButtonDefaults.m4138smallContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI, reason: not valid java name */
    public final long m4138smallContainerSizeNwlBFI(int widthOption) {
        float fM10168constructorimpl;
        if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4146getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4148getWiderc6NtMs())) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(SmallIconButtonTokens.INSTANCE.m6190getWideLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m6191getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(SmallIconButtonTokens.INSTANCE.m6184getDefaultLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m6184getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(SmallIconButtonTokens.INSTANCE.m6187getNarrowLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m6188getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m10190DpSizeYgX7TsA(Dp.m10168constructorimpl(SmallIconButtonTokens.INSTANCE.m6186getIconSizeD9Ej5fM() + fM10168constructorimpl), SmallIconButtonTokens.INSTANCE.m6183getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: mediumContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m4111mediumContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs();
        }
        return iconButtonDefaults.m4133mediumContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: mediumContainerSize-N-wlBFI, reason: not valid java name */
    public final long m4133mediumContainerSizeNwlBFI(int widthOption) {
        float fM10168constructorimpl;
        if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4146getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4148getWiderc6NtMs())) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(MediumIconButtonTokens.INSTANCE.m5955getWideLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5956getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(MediumIconButtonTokens.INSTANCE.m5949getDefaultLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5949getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(MediumIconButtonTokens.INSTANCE.m5952getNarrowLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5953getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m10190DpSizeYgX7TsA(Dp.m10168constructorimpl(MediumIconButtonTokens.INSTANCE.m5951getIconSizeD9Ej5fM() + fM10168constructorimpl), MediumIconButtonTokens.INSTANCE.m5948getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: largeContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m4110largeContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs();
        }
        return iconButtonDefaults.m4132largeContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: largeContainerSize-N-wlBFI, reason: not valid java name */
    public final long m4132largeContainerSizeNwlBFI(int widthOption) {
        float fM10168constructorimpl;
        if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4146getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4148getWiderc6NtMs())) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(LargeIconButtonTokens.INSTANCE.m5906getWideLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5907getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(LargeIconButtonTokens.INSTANCE.m5904getUniformLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5904getUniformLeadingSpaceD9Ej5fM());
            }
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(LargeIconButtonTokens.INSTANCE.m5901getNarrowLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5902getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m10190DpSizeYgX7TsA(Dp.m10168constructorimpl(LargeIconButtonTokens.INSTANCE.m5900getIconSizeD9Ej5fM() + fM10168constructorimpl), LargeIconButtonTokens.INSTANCE.m5899getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: extraLargeContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m4108extraLargeContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs();
        }
        return iconButtonDefaults.m4117extraLargeContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: extraLargeContainerSize-N-wlBFI, reason: not valid java name */
    public final long m4117extraLargeContainerSizeNwlBFI(int widthOption) {
        float fM10168constructorimpl;
        if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4146getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4147getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m4142equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m4148getWiderc6NtMs())) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(XLargeIconButtonTokens.INSTANCE.m6377getWideLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m6378getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(XLargeIconButtonTokens.INSTANCE.m6371getDefaultLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m6371getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(XLargeIconButtonTokens.INSTANCE.m6374getNarrowLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m6375getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m10190DpSizeYgX7TsA(Dp.m10168constructorimpl(XLargeIconButtonTokens.INSTANCE.m6373getIconSizeD9Ej5fM() + fM10168constructorimpl), XLargeIconButtonTokens.INSTANCE.m6370getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: compiled from: IconButtonDefaults.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class IconButtonWidthOption {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Narrow = m4140constructorimpl(0);
        private static final int Uniform = m4140constructorimpl(1);
        private static final int Wide = m4140constructorimpl(2);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IconButtonWidthOption m4139boximpl(int i) {
            return new IconButtonWidthOption(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m4140constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m4141equalsimpl(int i, Object obj) {
            return (obj instanceof IconButtonWidthOption) && i == ((IconButtonWidthOption) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4142equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m4143hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object other) {
            return m4141equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m4143hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: IconButtonDefaults.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption$Companion;", "", "<init>", "()V", "Narrow", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "getNarrow-rc6NtMs", "()I", "I", "Uniform", "getUniform-rc6NtMs", "Wide", "getWide-rc6NtMs", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNarrow-rc6NtMs, reason: not valid java name */
            public final int m4146getNarrowrc6NtMs() {
                return IconButtonWidthOption.Narrow;
            }

            /* JADX INFO: renamed from: getUniform-rc6NtMs, reason: not valid java name */
            public final int m4147getUniformrc6NtMs() {
                return IconButtonWidthOption.Uniform;
            }

            /* JADX INFO: renamed from: getWide-rc6NtMs, reason: not valid java name */
            public final int m4148getWiderc6NtMs() {
                return IconButtonWidthOption.Wide;
            }
        }

        private /* synthetic */ IconButtonWidthOption(int i) {
            this.value = i;
        }

        public String toString() {
            return m4144toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m4144toStringimpl(int i) {
            if (m4142equalsimpl0(i, Narrow)) {
                return "Narrow";
            }
            if (m4142equalsimpl0(i, Uniform)) {
                return "Uniform";
            }
            return m4142equalsimpl0(i, Wide) ? "Wide" : ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
    }
}
