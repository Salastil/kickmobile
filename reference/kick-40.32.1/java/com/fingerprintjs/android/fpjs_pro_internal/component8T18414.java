package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.location.Geocoder;
import android.location.LocationManager;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.autofill.AutofillUtils_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bZ\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0085\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\u0004\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00105\u001a\u00020\u0001\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00109\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010=\u001a\u00020<\u0012\b\b\u0002\u0010?\u001a\u00020>\u0012\b\b\u0002\u0010A\u001a\u00020@\u0012\b\b\u0002\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\b\b\u0002\u0010F\u001a\u00020\u0005\u0012\b\b\u0002\u0010H\u001a\u00020G\u0012\b\b\u0002\u0010J\u001a\u00020I\u0012\b\b\u0002\u0010K\u001a\u00020\u0001\u0012\b\b\u0002\u0010L\u001a\u00020\u0001\u0012\b\b\u0002\u0010M\u001a\u00020\u0001\u0012\b\b\u0002\u0010O\u001a\u00020N\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010S\u001a\u00020R\u0012\b\b\u0002\u0010U\u001a\u00020T\u0012\b\b\u0002\u0010W\u001a\u00020V¢\u0006\u0004\bX\u0010YR\u0011\u0010\\\u001a\u00020\b8\u0006¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010^R\u0014\u0010a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010^R\u0014\u0010Z\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010o\u001a\u00020>8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010r\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010g\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010^R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010zR\u0014\u0010j\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010[R\u0014\u0010c\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0017\u0010\u0082\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R'\u0010\u0083\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010zR\u0016\u0010s\u001a\u00020<8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0080\u0001\u001a\u0002088\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010x\u001a\u0002068\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010v\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\by\u0010\u008c\u0001R\u0016\u0010{\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0016\u0010\u0090\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bl\u0010\u008f\u0001R\u0017\u0010\u0092\u0001\u001a\u00020!8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0091\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0016\u0010p\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R\u0016\u0010e\u001a\u00020T8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0016\u0010m\u001a\u0002038\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0099\u0001R\u0018\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bu\u0010\u009a\u0001R\u0016\u0010\u0088\u0001\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010^R\u0017\u0010\u008d\u0001\u001a\u00020I8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0017\u0010\u008a\u0001\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0016\u0010~\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0017\u0010\u009b\u0001\u001a\u00020R8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bi\u0010¤\u0001R\u0017\u0010 \u0001\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010\u0094\u0001R\u0017\u0010\u009e\u0001\u001a\u00020V8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010\u009c\u0001\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0017\u0010\u0096\u0001\u001a\u00020P8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010©\u0001\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b}\u0010\u00ad\u0001R\u0017\u0010\u0093\u0001\u001a\u00020@8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010®\u0001R\u0017\u0010¦\u0001\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0094\u0001R\u0018\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bo\u0010¯\u0001R\u0016\u0010«\u0001\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010^R\u0017\u0010§\u0001\u001a\u0002018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010°\u0001"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component8T18414;", "", "Landroid/content/Context;", "p0", "", "", "p1", "p2", "", "p3", "Lkotlin/Pair;", "p4", "p5", "", "p6", "Landroid/os/UserManager;", "p7", "Landroid/hardware/SensorManager;", "p8", "Landroid/content/pm/PackageManager;", "p9", "Landroid/content/ContentResolver;", "p10", "Landroid/net/ConnectivityManager;", "p11", "p12", "Landroid/location/LocationManager;", "p13", "Landroid/telephony/TelephonyManager;", "p14", "Landroid/location/Geocoder;", "p15", "p16", "Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;", "p17", "p18", "p19", "Lkotlin/ranges/IntRange;", "p20", "Lcom/fingerprintjs/android/fpjs_pro_internal/br;", "p21", "Lcom/fingerprintjs/android/fpjs_pro_internal/B22527;", "p22", "Lcom/fingerprintjs/android/fpjs_pro_internal/a;", "p23", "Lcom/fingerprintjs/android/fpjs_pro_internal/rV4669;", "p24", "Lcom/fingerprintjs/android/fpjs_pro_internal/I30900;", "p25", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak;", "p26", "Lcom/fingerprintjs/android/fpjs_pro_internal/wB2645;", "p27", "p28", "Lcom/fingerprintjs/android/fpjs_pro_internal/K17305;", "p29", "Lcom/fingerprintjs/android/fpjs_pro_internal/M3232;", "p30", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnLongClickListenerR17701;", "p31", "Lcom/fingerprintjs/android/fpjs_pro_internal/lI23295;", "p32", "Lcom/fingerprintjs/android/fpjs_pro_internal/hO26224;", "p33", "Lcom/fingerprintjs/android/fpjs_pro_internal/ah;", "p34", "Lcom/fingerprintjs/android/fpjs_pro_internal/an;", "p35", "Lcom/fingerprintjs/android/fpjs_pro_internal/jC6584;", "p36", "p37", "Lcom/fingerprintjs/android/fpjs_pro_internal/C1722;", "p38", "Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489;", "p39", "p40", "p41", "p42", "Lcom/fingerprintjs/android/fpjs_pro_internal/z;", "p43", "Lcom/fingerprintjs/android/fpjs_pro_internal/aa;", "p44", "Lcom/fingerprintjs/android/fpjs_pro_internal/x;", "p45", "Lcom/fingerprintjs/android/fpjs_pro_internal/as;", "p46", "Lcom/fingerprintjs/android/fpjs_pro_internal/C10931;", "p47", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;ZLjava/util/List;ZJLandroid/os/UserManager;Landroid/hardware/SensorManager;Landroid/content/pm/PackageManager;Landroid/content/ContentResolver;Landroid/net/ConnectivityManager;Ljava/lang/String;Landroid/location/LocationManager;Landroid/telephony/TelephonyManager;Landroid/location/Geocoder;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;Ljava/lang/String;Ljava/lang/String;Lkotlin/ranges/IntRange;Lcom/fingerprintjs/android/fpjs_pro_internal/br;Lcom/fingerprintjs/android/fpjs_pro_internal/B22527;Lcom/fingerprintjs/android/fpjs_pro_internal/a;Lcom/fingerprintjs/android/fpjs_pro_internal/rV4669;Lcom/fingerprintjs/android/fpjs_pro_internal/I30900;Lcom/fingerprintjs/android/fpjs_pro_internal/ak;Lcom/fingerprintjs/android/fpjs_pro_internal/wB2645;Ljava/lang/Object;Lcom/fingerprintjs/android/fpjs_pro_internal/K17305;Lcom/fingerprintjs/android/fpjs_pro_internal/M3232;Lcom/fingerprintjs/android/fpjs_pro_internal/setOnLongClickListenerR17701;Lcom/fingerprintjs/android/fpjs_pro_internal/lI23295;Lcom/fingerprintjs/android/fpjs_pro_internal/hO26224;Lcom/fingerprintjs/android/fpjs_pro_internal/ah;Lcom/fingerprintjs/android/fpjs_pro_internal/an;Lcom/fingerprintjs/android/fpjs_pro_internal/jC6584;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/C1722;Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/fingerprintjs/android/fpjs_pro_internal/z;Lcom/fingerprintjs/android/fpjs_pro_internal/aa;Lcom/fingerprintjs/android/fpjs_pro_internal/x;Lcom/fingerprintjs/android/fpjs_pro_internal/as;Lcom/fingerprintjs/android/fpjs_pro_internal/C10931;)V", "sG29839", "Z", "component5", "component9", "Ljava/lang/String;", "component10", "vD14832N6715", "D8871", "Landroid/content/Context;", "yY18494", "setPivotYN16904", "oD4563", "Lcom/fingerprintjs/android/fpjs_pro_internal/I30900;", "Y16199", "Landroid/net/ConnectivityManager;", "N14263A23323", "rP23717", "Landroid/content/ContentResolver;", "setTopP6481", "xQ31420", "Lcom/fingerprintjs/android/fpjs_pro_internal/hO26224;", "component13", "component12", "Lcom/fingerprintjs/android/fpjs_pro_internal/rV4669;", "component8", "N11182", "Lcom/fingerprintjs/android/fpjs_pro_internal/br;", "cW27173", "W15084", "Lcom/fingerprintjs/android/fpjs_pro_internal/a;", "lN31375", "kC4266", "Ljava/util/List;", "ENTRIES", "Lkotlin/ranges/IntRange;", "setTopP6481U32634", "component3H22396", "Lcom/fingerprintjs/android/fpjs_pro_internal/an;", "INSTANCE", "Lcom/fingerprintjs/android/fpjs_pro_internal/B22527;", "iA15411", "C20232", "Landroid/location/Geocoder;", "E17257D21259", "component4S4936", "Lcom/fingerprintjs/android/fpjs_pro_internal/lI23295;", "tR25644", "Lcom/fingerprintjs/android/fpjs_pro_internal/M3232;", "setScrollXT29053", "Lcom/fingerprintjs/android/fpjs_pro_internal/K17305;", "Landroid/location/LocationManager;", "setContentDescriptionR23122", "Lcom/fingerprintjs/android/fpjs_pro_internal/setOnLongClickListenerR17701;", "J", "hY16199", "Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;", "getExplicitStyle", "getContentSensitivity", "Ljava/lang/Object;", "jC6958", "F2572", "K15285", "Lcom/fingerprintjs/android/fpjs_pro_internal/as;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wB2645;", "Landroid/content/pm/PackageManager;", "component11", "component10Y10845", "Lcom/fingerprintjs/android/fpjs_pro_internal/getRightG17489;", "setOnLongClickListener", "Lcom/fingerprintjs/android/fpjs_pro_internal/jC6584;", "setContentSensitivity", "Lcom/fingerprintjs/android/fpjs_pro_internal/C1722;", "openContextMenu", "Lcom/fingerprintjs/android/fpjs_pro_internal/x;", "Landroid/hardware/SensorManager;", "A22588", "getKeepScreenOn", "getPivotYV11332", "Lcom/fingerprintjs/android/fpjs_pro_internal/C10931;", "mG25782", "Lcom/fingerprintjs/android/fpjs_pro_internal/z;", "A29214", "Lcom/fingerprintjs/android/fpjs_pro_internal/aa;", "Landroid/telephony/TelephonyManager;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ah;", "Landroid/os/UserManager;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ak;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class component8T18414 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    public static I30900 O2678;
    public static rV4669 kP9958;

    /* JADX INFO: renamed from: A22588, reason: from kotlin metadata */
    public final ah getContentSensitivity;

    /* JADX INFO: renamed from: A29214, reason: from kotlin metadata */
    public final aa F2572;

    /* JADX INFO: renamed from: C20232, reason: from kotlin metadata */
    public Geocoder E17257D21259;
    public Context D8871;

    /* JADX INFO: renamed from: E17257D21259, reason: from kotlin metadata */
    public final setAutofillHintsI14457 getExplicitStyle;

    /* JADX INFO: renamed from: ENTRIES, reason: from kotlin metadata */
    public final IntRange rP23717;

    /* JADX INFO: renamed from: F2572, reason: from kotlin metadata */
    public final Object component12;

    /* JADX INFO: renamed from: INSTANCE, reason: from kotlin metadata */
    public final B22527 iA15411;

    /* JADX INFO: renamed from: K15285, reason: from kotlin metadata */
    public as oD4563;

    /* JADX INFO: renamed from: N11182, reason: from kotlin metadata */
    public final br cW27173;

    /* JADX INFO: renamed from: N14263A23323, reason: from kotlin metadata */
    public final SensorManager A22588;

    /* JADX INFO: renamed from: W15084, reason: from kotlin metadata */
    public final a Y16199;

    /* JADX INFO: renamed from: Y16199, reason: from kotlin metadata */
    public ConnectivityManager N14263A23323;

    /* JADX INFO: renamed from: cW27173, reason: from kotlin metadata */
    public final PackageManager component4S4936;

    /* JADX INFO: renamed from: component10, reason: from kotlin metadata */
    public final String vD14832N6715;

    /* JADX INFO: renamed from: component10Y10845, reason: from kotlin metadata */
    public final getRightG17489 setContentDescriptionR23122;

    /* JADX INFO: renamed from: component11, reason: from kotlin metadata */
    public String tR25644;

    /* JADX INFO: renamed from: component12, reason: from kotlin metadata */
    public final rV4669 component8;

    /* JADX INFO: renamed from: component13, reason: from kotlin metadata */
    public final UserManager K15285;

    /* JADX INFO: renamed from: component3H22396, reason: from kotlin metadata */
    public final an yY18494;

    /* JADX INFO: renamed from: component4S4936, reason: from kotlin metadata */
    public final lI23295 N11182;

    /* JADX INFO: renamed from: component8, reason: from kotlin metadata */
    public final List<Pair<String, String>> C20232;
    public final String component9;

    /* JADX INFO: renamed from: getContentSensitivity, reason: from kotlin metadata */
    public Object jC6958;

    /* JADX INFO: renamed from: getExplicitStyle, reason: from kotlin metadata */
    public final Object getKeepScreenOn;

    /* JADX INFO: renamed from: getKeepScreenOn, reason: from kotlin metadata */
    public final Object setContentSensitivity;

    /* JADX INFO: renamed from: getPivotYV11332, reason: from kotlin metadata */
    public final C10931 setOnLongClickListener;

    /* JADX INFO: renamed from: hY16199, reason: from kotlin metadata */
    public final ak getPivotYV11332;

    /* JADX INFO: renamed from: iA15411, reason: from kotlin metadata */
    public final String A29214;

    /* JADX INFO: renamed from: jC6958, reason: from kotlin metadata */
    public final wB2645 xQ31420;

    /* JADX INFO: renamed from: kC4266, reason: from kotlin metadata */
    public LocationManager W15084;

    /* JADX INFO: renamed from: lN31375, reason: from kotlin metadata */
    public final String kC4266;

    /* JADX INFO: renamed from: mG25782, reason: from kotlin metadata */
    public z component10Y10845;

    /* JADX INFO: renamed from: oD4563, reason: from kotlin metadata */
    public final I30900 sG29839;

    /* JADX INFO: renamed from: openContextMenu, reason: from kotlin metadata */
    public final x component11;

    /* JADX INFO: renamed from: rP23717, reason: from kotlin metadata */
    public final ContentResolver setTopP6481;

    /* JADX INFO: renamed from: sG29839, reason: from kotlin metadata */
    public boolean component5;

    /* JADX INFO: renamed from: setContentDescriptionR23122, reason: from kotlin metadata */
    public final setOnLongClickListenerR17701 ENTRIES;

    /* JADX INFO: renamed from: setContentSensitivity, reason: from kotlin metadata */
    public C1722 component3H22396;

    /* JADX INFO: renamed from: setOnLongClickListener, reason: from kotlin metadata */
    public jC6584 setScrollXT29053;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    public final List<String> component10;

    /* JADX INFO: renamed from: setScrollXT29053, reason: from kotlin metadata */
    public K17305 lN31375;

    /* JADX INFO: renamed from: setTopP6481, reason: from kotlin metadata */
    public long hY16199;

    /* JADX INFO: renamed from: setTopP6481U32634, reason: from kotlin metadata */
    public TelephonyManager mG25782;

    /* JADX INFO: renamed from: tR25644, reason: from kotlin metadata */
    public final M3232 INSTANCE;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    public final boolean setTopP6481U32634;

    /* JADX INFO: renamed from: xQ31420, reason: from kotlin metadata */
    public final hO26224 component13;

    /* JADX INFO: renamed from: yY18494, reason: from kotlin metadata */
    public String setPivotYN16904;

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r0 = 10 - r8
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.component8T18414.$$a
            int r6 = r6 * 4
            int r6 = 3 - r6
            int r7 = r7 * 4
            int r7 = 99 - r7
            byte[] r0 = new byte[r0]
            int r8 = 9 - r8
            r2 = 0
            if (r1 != 0) goto L19
            r7 = r6
            r4 = r8
            r3 = r2
            goto L30
        L19:
            r3 = r2
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L30:
            int r6 = r6 + r4
            int r6 = r6 + (-23)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.a(byte, int, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{84, -105, -74, -16, 35, Ascii.NAK, Ascii.SUB, Ascii.SYN, Ascii.SYN, Ascii.SO, 32, Ascii.GS, -36};
        $$b = 250;
    }

    private component8T18414(Context context, List<String> list, String str, boolean z, List<Pair<String, String>> list2, boolean z2, long j, UserManager userManager, SensorManager sensorManager, PackageManager packageManager, ContentResolver contentResolver, ConnectivityManager connectivityManager, String str2, LocationManager locationManager, TelephonyManager telephonyManager, Geocoder geocoder, String str3, setAutofillHintsI14457 setautofillhintsi14457, String str4, String str5, IntRange intRange, br brVar, B22527 b22527, a aVar, rV4669 rv4669, I30900 i30900, ak akVar, wB2645 wb2645, Object obj, K17305 k17305, M3232 m3232, setOnLongClickListenerR17701 setonlongclicklistenerr17701, lI23295 li23295, hO26224 ho26224, ah ahVar, an anVar, jC6584 jc6584, String str6, C1722 c1722, getRightG17489 getrightg17489, Object obj2, Object obj3, Object obj4, z zVar, aa aaVar, x xVar, as asVar, C10931 c10931) {
        this.D8871 = context;
        this.component10 = list;
        this.component9 = str;
        this.setTopP6481U32634 = z;
        this.C20232 = list2;
        this.component5 = z2;
        this.hY16199 = j;
        this.K15285 = userManager;
        this.A22588 = sensorManager;
        this.component4S4936 = packageManager;
        this.setTopP6481 = contentResolver;
        this.N14263A23323 = connectivityManager;
        this.vD14832N6715 = str2;
        this.W15084 = locationManager;
        this.mG25782 = telephonyManager;
        this.E17257D21259 = geocoder;
        this.setPivotYN16904 = str3;
        this.getExplicitStyle = setautofillhintsi14457;
        this.A29214 = str4;
        this.kC4266 = str5;
        this.rP23717 = intRange;
        this.cW27173 = brVar;
        this.iA15411 = b22527;
        this.Y16199 = aVar;
        this.component8 = rv4669;
        this.sG29839 = i30900;
        this.getPivotYV11332 = akVar;
        this.xQ31420 = wb2645;
        this.getKeepScreenOn = obj;
        this.lN31375 = k17305;
        this.INSTANCE = m3232;
        this.ENTRIES = setonlongclicklistenerr17701;
        this.N11182 = li23295;
        this.component13 = ho26224;
        this.getContentSensitivity = ahVar;
        this.yY18494 = anVar;
        this.setScrollXT29053 = jc6584;
        this.tR25644 = str6;
        this.component3H22396 = c1722;
        this.setContentDescriptionR23122 = getrightg17489;
        this.setContentSensitivity = obj2;
        this.jC6958 = obj3;
        this.component12 = obj4;
        this.component10Y10845 = zVar;
        this.F2572 = aaVar;
        this.component11 = xVar;
        this.oD4563 = asVar;
        this.setOnLongClickListener = c10931;
    }

    public /* synthetic */ component8T18414(final Context context, List list, String str, boolean z, List list2, boolean z2, long j, UserManager userManager, SensorManager sensorManager, PackageManager packageManager, ContentResolver contentResolver, ConnectivityManager connectivityManager, String str2, LocationManager locationManager, TelephonyManager telephonyManager, Geocoder geocoder, String str3, setAutofillHintsI14457 setautofillhintsi14457, String str4, String str5, IntRange intRange, br brVar, B22527 b22527, a aVar, rV4669 rv4669, I30900 i30900, ak akVar, wB2645 wb2645, Object obj, K17305 k17305, M3232 m3232, setOnLongClickListenerR17701 setonlongclicklistenerr17701, lI23295 li23295, hO26224 ho26224, ah ahVar, an anVar, jC6584 jc6584, String str6, C1722 c1722, getRightG17489 getrightg17489, Object obj2, Object obj3, Object obj4, z zVar, aa aaVar, x xVar, as asVar, C10931 c10931, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) throws Throwable {
        char c;
        UserManager userManager2;
        SensorManager sensorManager2;
        PackageManager packageManager2;
        ContentResolver contentResolver2;
        ConnectivityManager connectivityManager2;
        String str7;
        LocationManager locationManager2;
        TelephonyManager telephonyManager2;
        Geocoder geocoder2;
        String str8;
        IntRange pivotYN16904;
        B22527 b22527VD14832N6715;
        a aVar2;
        Object objNewInstance;
        setOnLongClickListenerR17701 setonlongclicklistenerr17702;
        hO26224 ho26225;
        Object objNewInstance2;
        Object objNewInstance3;
        Object objNewInstance4;
        String str9 = "";
        char c2 = 2;
        char c3 = 4;
        long j2 = 0;
        if ((i & 128) != 0) {
            c = 5;
            try {
                Object[] objArr = {0L, false, false, new Function1<Object, UserManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.3
                    public static int component5;
                    public static int setPivotYN16904;

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: setPivotYN16904$457818db, reason: merged with bridge method [inline-methods] */
                    public final UserManager invoke(Object obj5) {
                        Object systemService = context.getSystemService("user");
                        Intrinsics.checkNotNull(systemService);
                        return (UserManager) systemService;
                    }

                    public static int setPivotYN16904() {
                        int i3 = component5;
                        int i4 = i3 % 7775586;
                        component5 = i3 + 1;
                        if (i4 != 0) {
                            return setPivotYN16904;
                        }
                        int iNextInt = new Random().nextInt();
                        setPivotYN16904 = iNextInt;
                        return iNextInt;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }
                }, 7, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
                if (objComponent5 == null) {
                    int iIndexOf = 50 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1077;
                    Object[] objArr2 = new Object[1];
                    a((byte) 0, 0, (byte) 0, objArr2);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, minimumFlingVelocity, edgeSlop, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
                }
                userManager2 = (UserManager) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            c2 = 2;
            c3 = 4;
            c = 5;
            userManager2 = userManager;
        }
        float f = 0.0f;
        if ((i & 256) != 0) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(context);
            Object[] objArr3 = new Object[6];
            objArr3[c] = null;
            objArr3[c3] = 7;
            objArr3[3] = anonymousClass5;
            objArr3[c2] = false;
            objArr3[1] = false;
            objArr3[0] = 0L;
            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent6 == null) {
                int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 51;
                char c4 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int capsMode = TextUtils.getCapsMode("", 0, 0) + 1077;
                Object[] objArr4 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr4);
                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(threadPriority, c4, capsMode, 1722308833, false, (String) objArr4[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            sensorManager2 = (SensorManager) component9.component9((D8871) ((Method) objComponent6).invoke(null, objArr3), null);
        } else {
            j2 = 0;
            sensorManager2 = sensorManager;
        }
        if ((i & 512) != 0) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
            Object[] objArr5 = new Object[6];
            objArr5[c] = null;
            objArr5[c3] = 7;
            objArr5[3] = anonymousClass2;
            objArr5[c2] = false;
            objArr5[1] = false;
            objArr5[0] = 0L;
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent7 == null) {
                int absoluteGravity = 51 - Gravity.getAbsoluteGravity(0, 0);
                char c5 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                int defaultSize = View.getDefaultSize(0, 0) + 1077;
                Object[] objArr6 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr6);
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(absoluteGravity, c5, defaultSize, 1722308833, false, (String) objArr6[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            packageManager2 = (PackageManager) component9.component9((D8871) ((Method) objComponent7).invoke(null, objArr5), null);
        } else {
            f = 0.0f;
            packageManager2 = packageManager;
        }
        if ((i & 1024) != 0) {
            Function1<Object, ContentResolver> function1 = new Function1<Object, ContentResolver>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: D8871$1e22f9fb, reason: merged with bridge method [inline-methods] */
                public final ContentResolver invoke(Object obj5) {
                    ContentResolver contentResolver3 = context.getContentResolver();
                    Intrinsics.checkNotNull(contentResolver3);
                    return contentResolver3;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr7 = new Object[6];
            objArr7[c] = null;
            objArr7[c3] = 7;
            objArr7[3] = function1;
            objArr7[c2] = false;
            objArr7[1] = false;
            objArr7[0] = 0L;
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent8 == null) {
                int i3 = (ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) + 50;
                char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int bitsPerPixel = 1076 - ImageFormat.getBitsPerPixel(0);
                Object[] objArr8 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr8);
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i3, longPressTimeout, bitsPerPixel, 1722308833, false, (String) objArr8[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            contentResolver2 = (ContentResolver) component9.component9((D8871) ((Method) objComponent8).invoke(null, objArr7), null);
        } else {
            contentResolver2 = contentResolver;
        }
        if ((i & 2048) != 0) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(context);
            Object[] objArr9 = new Object[6];
            objArr9[c] = null;
            objArr9[c3] = 7;
            objArr9[3] = anonymousClass9;
            objArr9[c2] = false;
            objArr9[1] = false;
            objArr9[0] = 0L;
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent9 == null) {
                int keyRepeatDelay = 51 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int packedPositionType = ExpandableListView.getPackedPositionType(j2) + 1077;
                Object[] objArr10 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr10);
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay, maximumFlingVelocity, packedPositionType, 1722308833, false, (String) objArr10[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            connectivityManager2 = (ConnectivityManager) component9.component9((D8871) ((Method) objComponent9).invoke(null, objArr9), null);
        } else {
            connectivityManager2 = connectivityManager;
        }
        if ((i & 4096) != 0) {
            Function1<Object, String> function2 = new Function1<Object, String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.10
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static final byte[] $$c = null;
                private static final int $$d = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $setPivotYN16904;
                private static char[] component9;
                private static long vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001e  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(short r5, short r6, short r7) {
                    /*
                        int r5 = r5 * 3
                        int r0 = r5 + 1
                        int r6 = r6 + 5
                        int r7 = r7 * 3
                        int r7 = 101 - r7
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass10.$$c
                        byte[] r0 = new byte[r0]
                        r2 = -1
                        if (r1 != 0) goto L14
                        r3 = r5
                        r7 = r6
                        goto L29
                    L14:
                        r4 = r7
                        r7 = r6
                        r6 = r4
                    L17:
                        int r2 = r2 + 1
                        byte r3 = (byte) r6
                        r0[r2] = r3
                        if (r2 != r5) goto L25
                        java.lang.String r5 = new java.lang.String
                        r6 = 0
                        r5.<init>(r0, r6)
                        return r5
                    L25:
                        int r7 = r7 + 1
                        r3 = r1[r7]
                    L29:
                        int r3 = -r3
                        int r6 = r6 + r3
                        goto L17
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass10.$$e(short, short, short):java.lang.String");
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001d  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
                    /*
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass10.$$a
                        int r8 = 99 - r8
                        int r7 = r7 * 3
                        int r7 = 4 - r7
                        int r6 = r6 * 3
                        int r6 = r6 + 1
                        byte[] r1 = new byte[r6]
                        r2 = 0
                        if (r0 != 0) goto L15
                        r8 = r6
                        r3 = r7
                        r4 = r2
                        goto L27
                    L15:
                        r3 = r2
                    L16:
                        int r4 = r3 + 1
                        byte r5 = (byte) r8
                        r1[r3] = r5
                        if (r4 != r6) goto L25
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        r9[r2] = r6
                        return
                    L25:
                        r3 = r0[r7]
                    L27:
                        int r7 = r7 + 1
                        int r3 = -r3
                        int r8 = r8 + r3
                        int r8 = r8 + 6
                        r3 = r4
                        goto L16
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass10.b(int, short, short, java.lang.Object[]):void");
                }

                static void init$0() {
                    $$a = new byte[]{33, 84, 42, -62, -6, 5, -3};
                    $$b = 35;
                }

                static void init$1() {
                    $$c = new byte[]{0, -128, -73, -32, Ascii.DLE};
                    $$d = 35;
                }

                private static void a(char c6, int i4, int i5, Object[] objArr11) throws Throwable {
                    int i6;
                    char c7;
                    int i7 = 2 % 2;
                    ck ckVar = new ck();
                    long[] jArr = new long[i5];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i5) {
                        int i8 = ckVar.setPivotYN16904;
                        try {
                            Object[] objArr12 = {Integer.valueOf(component9[i4 + i8])};
                            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                            if (objComponent10 == null) {
                                int i9 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 50;
                                char cResolveSize = (char) View.resolveSize(0, 0);
                                int keyRepeatTimeout = 5904 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                byte b = $$c[0];
                                i6 = -720328195;
                                byte b2 = b;
                                c7 = 1;
                                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i9, cResolveSize, keyRepeatTimeout, -173582907, false, $$e(b2, (byte) (b2 - 1), b), new Class[]{Integer.TYPE});
                            } else {
                                i6 = -720328195;
                                c7 = 1;
                            }
                            Long l = (Long) ((Method) objComponent10).invoke(null, objArr12);
                            l.longValue();
                            long j3 = i8;
                            long j4 = vD14832N6715;
                            Object[] objArr13 = new Object[4];
                            objArr13[3] = Integer.valueOf(c6);
                            objArr13[2] = Long.valueOf(j4);
                            objArr13[c7] = Long.valueOf(j3);
                            objArr13[0] = l;
                            Object objComponent11 = setSystemGestureExclusionRectsL30479.component5(752268889);
                            if (objComponent11 == null) {
                                int i10 = 53 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 5058;
                                byte b3 = $$c[0];
                                byte b4 = (byte) (b3 - 1);
                                objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(i10, jumpTapTimeout, packedPositionType2, 2120479290, false, $$e(b3, b4, (byte) (-b4)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i8] = ((Long) ((Method) objComponent11).invoke(null, objArr13)).longValue();
                            Object[] objArr14 = new Object[2];
                            objArr14[c7] = ckVar;
                            objArr14[0] = ckVar;
                            Object objComponent12 = setSystemGestureExclusionRectsL30479.component5(i6);
                            if (objComponent12 == null) {
                                objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 51, (char) View.MeasureSpec.getMode(0), 2464 - Color.red(0), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent12).invoke(null, objArr14);
                            int i11 = $11 + 81;
                            $10 = i11 % 128;
                            int i12 = i11 % 2;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    char[] cArr = new char[i5];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i5) {
                        int i13 = $10 + 19;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
                        Object[] objArr15 = {ckVar, ckVar};
                        Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                        if (objComponent13 == null) {
                            objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - KeyEvent.normalizeMetaState(0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), View.getDefaultSize(0, 0) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent13).invoke(null, objArr15);
                    }
                    objArr11[0] = new String(cArr);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ String invoke(Object obj5) {
                    int i4 = 2 % 2;
                    int i5 = $setPivotYN16904 + 69;
                    $D8871 = i5 % 128;
                    int i6 = i5 % 2;
                    String pivotYN16904$444b71f3 = setPivotYN16904$444b71f3(obj5);
                    int i7 = $D8871 + 17;
                    $setPivotYN16904 = i7 % 128;
                    int i8 = i7 % 2;
                    return pivotYN16904$444b71f3;
                }

                public final String setPivotYN16904$444b71f3(Object obj5) {
                    int i4 = 2 % 2;
                    int i5 = $D8871 + 69;
                    $setPivotYN16904 = i5 % 128;
                    int i6 = i5 % 2;
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    Intrinsics.checkNotNull(applicationInfo);
                    String str10 = ((PackageItemInfo) applicationInfo).packageName;
                    Intrinsics.checkNotNull(str10);
                    int i7 = $setPivotYN16904 + 103;
                    $D8871 = i7 % 128;
                    if (i7 % 2 == 0) {
                        return str10;
                    }
                    throw null;
                }

                static {
                    init$1();
                    $10 = 0;
                    $11 = 1;
                    init$0();
                    $D8871 = 0;
                    $setPivotYN16904 = 1;
                    char[] cArr = new char[1959];
                    ByteBuffer.wrap("^ÔöD\u000f(¤\u001cý¸\u0012Û«¶Ãj\u0018G±.Æ\u001c\u001fá´×Í»e`ºJÓ/h\u0002\u0081øÖÉo\u0094\u0087SÜZu&\u008a\u0012#ûx ^ÔöD\u000f(¤\u001cý¸\u0012Û«¶Ãj\u0018G±.Æ\u001c\u001fá´×Í»eqºGÓ;h\u0015\u0081ÂÖÞo\u0097\u0087~ÜJu\"\u008a\u0017=I\u0095ÙlµÇ\u0081\u009e%qFÈ+ ÷{ÚÒ³¥\u0081||×J®&\u0006ïÙÊ°¸\u000b\u008e^ÔöS\u000f4¤\u0019ý¸\u0012Ñ«¶Ãb\u0018V±$Æ\u0010\u001f½´ØÍ\u008bemºJÓ-h\u0019\u0081îÖÒo¸\u0087nÜHu\"\u008a\u0007#ýx·\u0091\u009b\u001c\u0005´\u0094MèæØ¿iP\téo\u0081ùZ\u0082óë\u0084Ë]3^ÔöE\u000f9¤\tý¸\u0012Ï«°Ãk\u0018\r±8Æ\u0007\u001fý´Ï^ÔöS\u000f)¤\týö\u0012Î«½Ã)\u0018q±\u000eÆ8\u001fý´ÉÍ\u0081eEºOÓ?h\u0011¹¿\u0011/èGCu\u001a\u009dõøL\u009c$\u000eÿ8VV!wø\u0097S²*à^\u0089öO\u000fc¤\býø\u0012Ó«\u00adÃ(\u0018Q±-Æ\u0011\u001fà´ÐÍ\u008deeºqÓ%h\u0015\u0081éÖåo\u0083\u0087bÜZug/\u008f\u0087I~eÕ\u000e\u008cþcÕÚ«².iWÀ+·\u0017næÅÖ¼\u008b\u0014cËw¢#\u0019\u0013ðï§ã\u001e\u0085öd\u00ad\\\u0004b^ÔöS\u000f4¤\u0019ýã\u0012Ù«´Ã)\u0018O±!Æ\u0017\u001f½´ÓÍ\u008decº@Ó)h^\u0081îÖÕ^\u0099öI\u000f*¤\u0004ýø\u0012Ä^§öa^ÔöS\u000f4¤\u0019ýã\u0012Ù«´Ã)\u0018A±!Æ\u001b\u001f½´ÑÍ\u0081elº[Ó\u001dh=\u0081°ÖÔo\u0082\u0087aÜ\\u{\u008a\u0010#÷x«\u0091\u0096)}~[\u0097=\t9¡¾XÙóôª\u000eE4üY\u0094ÄO¬æÌ\u0091öHPã<\u009al2\u0081í¶\u0084ð?ÐÖ]\u0081'8xÐ\u008e\u008b´¿\u0017\u0017\u0090î÷EÚ\u001c ó\u001aJw\"êù\u008cPâ'Ôþ~U\u0010,N\u0084 [\u00832í\u0089Þ`+7/\u008eif¿=\u0098\u0094úkÀÂu\u0099upNi\u0002Á\u00928þ\u0093ÊÊn%\u0004\u009cjô½/\u0080\u0086ùñÖ(!\u0083\u001aúFaáÉ'0\u000b\u009b`Â\u008a-½\u0094Ýü\n'e\u008eHùr \u0089\u008b££3\u000bãò\u008aY¿\u0000Tï4V\u0011>Ååñ\u0017Õ¿QF>í\u0004´õ[\u0092â¾\u008anQNø,\u008f\u0007VêýÍ\u0084\u0091,eóB\u009a9¹f\u0011¶èÓCì\u001a\u0017õ)^\u0089öO\u000fc¤\u001aýå\u0012Ó«½Ãs\u0018@±<Æ[\u001fÿ´ÞÍ\u008aetºHÓ*h\u0013\u0081éÖÏo\u0095\u0087iÜ[8\u0081\u0090Xi>Â\u000e^\u008böE\u000f?¤\u0019ýþ\u0012Ï«\u00adÃ(\u0018P±1Æ\u0006\u001f¼´ÝÍ\u0080e/ºJÓ.h\u0012\u0081èÖÝoÉ\u0087kÜYu#\u008a]#þx¤\u0091\u0089)j~k\u00976,\u000eEî\u009a\u009f3\u009fKoàY98N\u001cçÔ<¦U\u009a\u0097Þ?\u0010ÆjmL4«Û\u009abø\n}Ñ\u0005xd\u000fSÖé}\u0088\u0004Õ¬zs\u001f\u001a{¡GH½\u001f\u0088¦\u009cN>\u0015\f¼vC\bê«±ñXÜà?·>^cå[\u008c»SÊúÎ\u0082:)\fðm\u0087C.\u0081\u007fë×%._\u0085yÜ\u009e3¯\u008aÍâH90\u0090Qçf>Ü\u0095½ìàDO\u009b*òNIr \u0088÷½N©¦\u001eý&T\u0018«p\u0002\u0089YÌÇîo \u0096Z=|d\u009b\u008bª2ÈZM\u00815(T_c\u0086Ù-¸TåüJ#/JKñw\u0018\u008dO¸ö¬\u001e\u001bE#ì\u001d\u0013zº\u009cáÃ\u0000h¨¦QÜúú£\u001dL,õN\u009dËF³ïÒ\u0098åA_ê>\u0093c;Ìä©\u008dÍ6ñß\u000b\u0088>1*Ù\u009d\u0082¥+\u009bÔý}\u0018&EHRà\u009c\u0019æ²Àë'\u0004\u0016½tÕñ\u000e\u0089§èÐß\te¢\u0004ÛYsö¬\u0093Å÷~Ë\u00971À\u0004y\u0010\u0091§Ê\u009fc¡\u009cÇ5/n\u007fã#Kì²\u008c\u0019¼@J¯t^ÔöP\u000f?¤\u0005ýô\u0012\u0093«´Ãi\u0018G±=Æ\u0019\u001f÷´Ì^\u008döB\u000f\"¤\u0012ýð\u0012É«¼Ãu\u0018W\u008b\u0018#áÚ\u0087q·(^Çw~\t\u0016ËÍèd\u0082^\u008eöN\u000f&¤\u0004ýø\u0012Ë«·^\u0098öH\u000f?¤\u0005ýú\u0012Õ«¬Ãkð\u0085XC¡o\n\u0016Sé¼ß\u0005±m\u007f¶L\u001f0hW±ú\u001aÖc\u009eËd\u0014A}\"÷q_¾¦Þ\rîTS»v\u0002U^\u009cöE\u000f#¤\u000fýå\u0012Õ«º&m\u008e´wÒÜþ\u0085\u0014j$ÓK»¨`ªÉ\u0081¾²^\u009cöE\u000f#¤\u000fýå\u0012Õ«ºÃY\u0018[±pÆC\u001fÍ´\u0089ÍÐ\u0095Z=\u009cÄ°oÉ66Ù\u0000`n\b Ó\u0093zï\r\u0088Ô,\u007f\u0003\u0006S®·q\u0091^\u0088öD\u000f&5\u0013\u009dÀdµÏ\u008b\u0096{yEÀ;¨ù\u00818)ÒÐ¿{È\"GÍKt5\u001cðÇÈn§\u0019\u0092À0k[\u0012\tºñe\u008c\f\u008a·\u009a^m\tW°\bXë W\u0088£qÄÚõ\u0083\u0015l8ÕP½Ëf\u009dÏá¸Óa_Ê0³|\u001b\u0085Ä¯\u00adÒ\u0016½ÿ\u0016¨8\u0011xùÁ¢¼\u000b\u0083ô¨^ºöN\u000f)¤\u0018ýø\u0012Õ«½Ã&\u0018p±\fÆ>\u001f²´ÝÍ\u0091ehºBÓ?hP\u0081ûÖÕo\u0095\u0087,ÜQun\u008aE#Çxó\u0091Ö^\u0089öO\u000fc¤\u0002ýö\u0012Î«½Ãq\u0018B±:Æ\u0010^\u009cöO\u000f!¤\u000eýñ\u0012Õ«ªÃn^\u008döB\u000f\"¤\u0012ý¯\u0012\u008a^\u0089öA\u000f#¤\týÿ\u0012É\u009dL5\u008aÌ¦gß> Ñ\u0016hx\u0000¶Û\u0085rù\u0005\u009eÜ5w\b\u000e@¦ªy\u008f\u000e*¦ì_Àô¢\u00adQBmû\u0014\u0093ÀHìáÅ\u0096§OTäq\u009d2^Ê\\×ô\u0011\r=¦Gÿ¬\u0010\u0081©òÁ*\u001a\u0018^Ën2Æô?Ø\u0094³ÍY\"n\u009b\u000eóÙ(¶\u0081\u0083ö¼/F\u0084`ý*UÙ\u008aá^\u009döU\u000f!¤\u0006ýÈ\u0012Ä«áÃ0ìÂD\u0004½(\u0016CO© \u009e\u0019þq)ªF\u0003etW\u00ad·\u0006\u0093\u007fÊ×8\b\u0015arÚR3¸d\u0085^\u009cöE\u000f#¤\u000fýå\u0012Õ«ºÃ)\u0018P±,Æ\u001e\u001f½´ØÍ\u0081eoºKÓ9h\u0019\u0081þ^\u009cöE\u000f#¤\u000fýå\u0012Õ«ºÃY\u0018[±pÆC\u001f½´ÌÍ\u0080ejºqÓ3hH\u0081«Ö\u0095o\u0080\u0087iÜGu3\u008a\u0001#ñx¦\u0091½)w~\f\u0097g^\u009cöE\u000f#¤\u000fýå\u0012Õ«ºÃ)\u0018D±'Æ\u001a\u001fõ´ÓÍ\u0081e^º]Ó/h\u001b\u0081²ÖÝo\u0082\u0087bÜLu$\u008a\u001a#ûñ×Y\u000e h\u000bDR®½\u009e\u0004ñlb·\u001e\u001eaiQ°¡\u001bÌb\u0099Ê:\u0015J|vÇY.¹y\u0089À\u0094(qs\u0012Â\u0003jÐ\u0093½8\u0092ad\u008eF7i_ê\u0084Ø-¼Zµ\u0083j(PQ\u0013ùñ&ßO±ô°\u001dzJ\u001dóN\u001b¼@Ñé¬\u0016\u0082¿bä(\r\u0014µóâô\u000b¶°ÙÙ2^\u0089öO\u000fc¤\býø\u0012Ó«\u00adÃj\u0018L±)Æ\u0011\u001f÷´Í^\u0089öO\u000fc¤\býø\u0012Ó«\u00adÃo\u0018N±)Æ\u0012\u001f÷´\u0091Í\u0086etºGÓ'h\u0014\u0081³ÖÜo\u008e\u0087bÜNu3\u008a\u0001#èx·\u0091\u008b)a~@âJJ¾³Ù\u0018èA\b®%\u0017M\u007fÛ¤«\r\u0080z³\u0012¢ºdCHè#±É^þç\u009e\u008fIT&ý\u0007\u008a7SÊøä\u0081£)Kö|\u009fN$2ÍÒ^\u008föE\u000f>¤\u001eýº¿*\u0017öî\u009cE¦\u001c\u0001ówJ\u0017\"ÝùµP\u0081'¨þGUr,q\u0084É[ä2\u009c\u0089¸`V^\u008aöE\u000f ¤\u001fý¹\u0012Ô«®Ã(\u0018N±)Æ\u001c\u001fü´ÔÍ\u0081exº]^\u008aöE\u000f ¤\u001fý¹\u0012Ï«¿Ã(\u0018E±)Æ\u001e\u001f÷´àÍ\u0087e`ºCÓ.h\u0002\u0081ü^\u008aöE\u000f ¤\u001fý¹\u0012Ï«¿Ã(\u0018O±+Æ\u0011\u001fÍ´ÛÍ\u0081eoº]Ó\"h\u0004\u0081ä^\u0089öO\u000fc¤\u0001ýò\u0012Î«·Ãc\u0018O±fÆ\u0014\u001fü´ÛÍ\u0096enºGÓ/h^\u0081ìÖßo\u008a\u0087yÜM 4\u0088òqÞÚµ\u0083ElnÕ\u0010½\u0095fïÏ\u0090¸¥aZÊ,³8\u001bÊÄ÷\u00ad©\u0016£ÿA¨j\u0011?\u001dþµ8L\u0014çr¾\u0084Q¦è\u0080\u0080\u0013[!òV\u0085n\\\u0081÷æ\u008eõ&\u001fù7\u0090[+bÂ\u0098\u0095½,âÄ\u0012\u009f06U^\u0089öO\u000fc¤\u001aýå\u0012Ó«½Ãs\u0018@±<Æ[\u001fð´ÊÍ\u008demºJÓeh\u0016\u0081ôÖÔo\u0080\u0087iÜ[u&\u008a\u0001#ñx«\u0091\u0096\u0019\u0082±DHhã\u0012ºåUÄì¦\u0084h_Eöm\u0081\u001cXìóÝ\u008a\u0083\"ný\u000b\u0094&/\u0012Æø\u0091Ö(\u0089Àu\u009bR2/Í\u0011dý?º\u0015I½\u008fD£ïÙ¶.Y\u000fàm\u0088£S\u008eú×\u008dÐT*ÿ\u000b\u0086\n.£ñ\u009b\u0098â#ÜÊ9\u009dT$AÌ¥\u0097\u0087>ñÁÖh*3uÚPb¦5\u009aÜå\u0006×®\u0011W=üB¥¬J\u008cóã\u009b7@\u000fé8\u009eIG¹ì\u0088\u0095Ö=;â^\u008bs0GÙ\u00ad\u008e\u00837Üß \u0084\u0007-zÒD{¨ ï^\u0089öO\u000fc¤\u001cýò\u0012Ò«½Ãi\u0018Q±\u0017Æ\u0011\u001fþ´ÔÍ\u0089e/ºLÓ>h\u0019\u0081ñÖÞoÉ\u0087jÜ@u8\u008a\u0014#ýx·\u0091\u0092)}~]\u0097?,\n\u0081°^ÔöD\u000f(¤\u001cý¸\u0012Í«¼Ãk\u0018V±\u0017Æ\u0005\u001fû´ÏÍ\u0081^ÔöD\u000f(¤\u001cý¸\u0012Ï«¶Ãe\u0018H±-Æ\u0001\u001f½´ÝÍ\u0085erºKÓ)h\u0011\u0081óÖÞo¸\u0087kÜLu8\u008a\n#ümâÅr<\u001e\u0097*Î\u008e!ù\u0098\u0080ðS+~\u0082\u001bõ7,\u008b\u0087îþ·VY\u0089aà\u0019^ÔöD\u000f(¤\u001cý¸\u0012Ï«¶Ãe\u0018H±-Æ\u0001\u001f½´ÎÍ\u0081elº[Ó/^ÔöS\u000f4¤\u0019ý¸\u0012Í«¼Ãk\u0018V±\u0017Æ\u0001\u001fà´ÞÍ\u0087ed½\u00ad\u0015*ìMG`\u001e\u009añ HÍ Pû6RX%nüÄWª.ô\u0086\u001aY40m\u008bdb\u00855¯\u008còd\u001a?3\u0096pinÀ\u0084\u009bÞrîÊ\u0011\u009d\u0012tYÏb¦\u008fyÌÐº¨\u0000\u0003!^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018|±/Æ\u0005\u001fá\n ¢0[\\ðh©ÌFªÿÞ\u0097\u0006L\båH\u0092hK\u008bà®^ÔöD\u000f(¤\u001cý¸\u0012Ï«¶Ãe\u0018H±-Æ\u0001\u001f½´ÝÍ\u0097euºHÓ$h\u001c\u0081ùÖßo\u0095\u0087h^ÔöS\u000f4¤\u0019ýã\u0012Ù«´Ã)\u0018O±!Æ\u0017\u001f½´ÓÍ\u008decºLÓ8h\u0004\u0081ûÖÕo\u008b\u0087hÜLu$\u008a,#òx«\u0091\u008b)!~G\u0097>^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018B±+Æ\u0016\u001f÷^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018D±1Æ\u0007\u001fýIwáç\u0018\u008b³¿ê\u001b\u0005}¼\tÔÑ\u000fí¦\u008eÑ±\b_^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018L±:Æ\u001c\u001f÷^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018U±%Æ\u0006\u001fõ^ÔöD\u000f(¤\u001cý¸\u0012Þ«ªÃr\u0018S±/Æ\u0014\u001fû´ÏÍ\u0087¹Z\u0011Êè¦C\u0092\u001a6õPL$$üÿòV¯!\u0096øy^ÔöD\u000f,¤\u001eýö\u0012\u0093«½Ãi\u0018T±&Æ\u0019\u001fý´ÞÍ\u0080erº\u0001Óeh\b\u0081ÿÖ\u0095o\u0085\u0087\u007fÜ]u=û\u0018S\u0081ªï\u0001ÒXt·\u0007\u000e|f¤½\u008b\u0014ëcÎº-\u0011\\hjÀ¾\u001f\u0096vÔÍÔ$0s\u0004ÊN\"¤y£Ðõ/Ó\u00860Ýl4\\åTMÐ´¿\u001f\u0085Ft©\u0013\u00100xé£Ó\n§}\u0087¤f\u000fL^ËöF\u000f+¤Jý\u00ad^ÔöP\u000f?¤\u0005ýô\u0012\u0093«ªÃc\u0018O±.ÆZ\u001fÿ´ÞÍ\u0094erA=éó\u0010\u008d»§âZ\rr´\u001bÜ\u0089\u0007å®\u0086Ù¸\u0000W«xÒ,zÓ¥çÌÄw¢\u009eS^\u0097öI\u000f/¤-ýÛ\u0012ù«\u008aÃY\u0018A±;Æ\u0001\u001f¼´ÌÍ\u008bÕ$}µ\u0084É/ùvH\u0099! LH\u0092\u0093º:ÙMÚ\u0094\u0001? Fpî\u00941½XÈã®\n\u0015]'ä{^\u0099öL\u000f8¤\u000fýä\u0012È«¸Ãe\u0018H±;\u0083Í+\\Ò y\u0010 ¡ÏÈv¯\u001ejÅTl%\u001b\u001fg#Ï³6Û\u009déÄ\u0001+d\u0092Jú\u009e!£\u0088Ñÿî&\n\u008d)ôw\\\u0085\u0083öê\u0092Qã¸\u001aïbVq¾\u008bå®LÒ³ª\u001a\u0017A_¨yû\u0087S\u0003ªl\u0001VX§·À\u000eéf%½\u0005\u0014rcHº§\u0011\u0083Èà`\u0013\u0099}2Rk\u00ad\u0084\u0089=öU2noÆÿ?\u0097\u0094¥ÍM\"(\u009b\u000fóÔ(ë\u0081\u0090öá/Y\u0084vý0UÜ\u008aüã\u009cX®±Uæ._?·ÂìàEÂºø\u0013\fH\u001d¡6\u0019ÙN¡§\u0087\u001c¬uCª\t\u00039{ÇÐå\t\u0095~¶×3\f\u0015e6ÝÃ2ük\u008dÀR9\u007f".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 1959);
                    component9 = cArr;
                    vD14832N6715 = 7940888925109614112L;
                }

                /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                    java.util.NoSuchElementException
                    	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
                    	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                    	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                    */
                public static java.lang.Object[] setPivotYN16904(android.content.Context r66, int r67, int r68, int r69) {
                    /*
                        Method dump skipped, instruction units count: 14956
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass10.setPivotYN16904(android.content.Context, int, int, int):java.lang.Object[]");
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr11 = new Object[6];
            objArr11[c] = null;
            objArr11[c3] = 7;
            objArr11[3] = function2;
            objArr11[c2] = false;
            objArr11[1] = false;
            objArr11[0] = 0L;
            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent10 == null) {
                int i4 = 52 - (SystemClock.uptimeMillis() > j2 ? 1 : (SystemClock.uptimeMillis() == j2 ? 0 : -1));
                char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(j2);
                int i5 = 1078 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                Object[] objArr12 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr12);
                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i4, packedPositionType2, i5, 1722308833, false, (String) objArr12[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            str7 = (String) component9.component9((D8871) ((Method) objComponent10).invoke(null, objArr11), null);
        } else {
            str7 = str2;
        }
        if ((i & 8192) == 0) {
            str9 = "";
            locationManager2 = locationManager;
        } else {
            Function1<Object, LocationManager> function3 = new Function1<Object, LocationManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.6
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: component9$7492c12c, reason: merged with bridge method [inline-methods] */
                public final LocationManager invoke(Object obj5) {
                    Object systemService = context.getSystemService(FirebaseAnalytics.Param.LOCATION);
                    if (systemService instanceof LocationManager) {
                        return (LocationManager) systemService;
                    }
                    return null;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr13 = new Object[6];
            objArr13[c] = null;
            objArr13[c3] = 7;
            objArr13[3] = function3;
            objArr13[c2] = false;
            objArr13[1] = false;
            objArr13[0] = 0L;
            Object objComponent11 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent11 == null) {
                int capsMode2 = 51 - TextUtils.getCapsMode("", 0, 0);
                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int packedPositionChild = 1076 - ExpandableListView.getPackedPositionChild(j2);
                Object[] objArr14 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr14);
                objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(capsMode2, jumpTapTimeout, packedPositionChild, 1722308833, false, (String) objArr14[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            locationManager2 = (LocationManager) component9.component9((D8871) ((Method) objComponent11).invoke(null, objArr13), null);
        }
        if ((i & 16384) != 0) {
            Function1<Object, TelephonyManager> function4 = new Function1<Object, TelephonyManager>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.7
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: setPivotYN16904$42170e6, reason: merged with bridge method [inline-methods] */
                public final TelephonyManager invoke(Object obj5) {
                    Object systemService = context.getSystemService("phone");
                    if (systemService instanceof TelephonyManager) {
                        return (TelephonyManager) systemService;
                    }
                    return null;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr15 = new Object[6];
            objArr15[c] = null;
            objArr15[c3] = 7;
            objArr15[3] = function4;
            objArr15[c2] = false;
            objArr15[1] = false;
            objArr15[0] = 0L;
            Object objComponent12 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent12 == null) {
                int iCombineMeasuredStates = 51 - View.combineMeasuredStates(0, 0);
                char c6 = (char) (TypedValue.complexToFloat(0) > f ? 1 : (TypedValue.complexToFloat(0) == f ? 0 : -1));
                int iAxisFromString = 1076 - MotionEvent.axisFromString(str9);
                Object[] objArr16 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr16);
                objComponent12 = setSystemGestureExclusionRectsL30479.vD14832N6715(iCombineMeasuredStates, c6, iAxisFromString, 1722308833, false, (String) objArr16[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            telephonyManager2 = (TelephonyManager) component9.component9((D8871) ((Method) objComponent12).invoke(null, objArr15), null);
        } else {
            telephonyManager2 = telephonyManager;
        }
        if ((i & 32768) != 0) {
            Function1<Object, Geocoder> function5 = new Function1<Object, Geocoder>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.8
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $component5;
                private static long component9;
                private static long vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0028  */
                /* JADX WARN: Code duplicated, block: B:8:0x0022  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(byte r5, int r6, short r7) {
                    /*
                        int r6 = r6 + 4
                        int r5 = r5 * 2
                        int r0 = 1 - r5
                        int r7 = r7 * 2
                        int r7 = r7 + 104
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass8.$$a
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        int r5 = 0 - r5
                        if (r1 != 0) goto L17
                        r4 = r5
                        r7 = r6
                        r3 = r2
                        goto L2c
                    L17:
                        r3 = r7
                        r7 = r6
                        r6 = r3
                        r3 = r2
                    L1b:
                        byte r4 = (byte) r6
                        r0[r3] = r4
                        int r7 = r7 + 1
                        if (r3 != r5) goto L28
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r0, r2)
                        return r5
                    L28:
                        r4 = r1[r7]
                        int r3 = r3 + 1
                    L2c:
                        int r4 = -r4
                        int r6 = r6 + r4
                        goto L1b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.AnonymousClass8.$$c(byte, int, short):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{98, Ascii.NAK, Ascii.DC4, -67};
                    $$b = 145;
                }

                private static void b(String str10, int i6, Object[] objArr17) throws Throwable {
                    char[] charArray;
                    int i7 = 2 % 2;
                    int i8 = $11 + 47;
                    int i9 = i8 % 128;
                    $10 = i9;
                    int i10 = i8 % 2;
                    if (str10 != null) {
                        int i11 = i9 + 43;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        charArray = str10.toCharArray();
                        int i13 = $10 + 13;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                    } else {
                        charArray = str10;
                    }
                    cl clVar = new cl();
                    char[] pivotYN16905 = cl.setPivotYN16904(component9 ^ (-8731904840774042312L), charArray, i6);
                    clVar.vD14832N6715 = 4;
                    while (clVar.vD14832N6715 < pivotYN16905.length) {
                        int i15 = $10 + 75;
                        $11 = i15 % 128;
                        int i16 = i15 % 2;
                        clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
                        int i17 = clVar.vD14832N6715;
                        try {
                            Object[] objArr18 = {Long.valueOf(pivotYN16905[clVar.vD14832N6715] ^ pivotYN16905[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(component9)};
                            Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(353813021);
                            if (objComponent13 == null) {
                                objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.makeMeasureSpec(0, 0) + 51, (char) (ImageFormat.getBitsPerPixel(0) + 43653), 752 - (ViewConfiguration.getWindowTouchSlop() >> 8), 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                            }
                            pivotYN16905[i17] = ((Character) ((Method) objComponent13).invoke(null, objArr18)).charValue();
                            Object[] objArr19 = {clVar, clVar};
                            Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                            if (objComponent14 == null) {
                                objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 5420 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 257882757, false, $$c((byte) 0, -1, (short) 5), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent14).invoke(null, objArr19);
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    objArr17[0] = new String(pivotYN16905, 4, pivotYN16905.length - 4);
                }

                private static void a(String str10, int i6, Object[] objArr17) throws Throwable {
                    int i7;
                    int i8;
                    int i9 = 2 % 2;
                    int i10 = $11 + 67;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    char[] charArray = str10 != null ? str10.toCharArray() : str10;
                    cb cbVar = new cb();
                    cbVar.setPivotYN16904 = i6;
                    int length = charArray.length;
                    long[] jArr = new long[length];
                    cbVar.D8871 = 0;
                    while (cbVar.D8871 < charArray.length) {
                        int i12 = cbVar.D8871;
                        try {
                            Object[] objArr18 = {Integer.valueOf(charArray[cbVar.D8871]), cbVar, cbVar};
                            Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                            if (objComponent13 == null) {
                                i7 = 55223;
                                i8 = 2106881226;
                                objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getTrimmedLength(""), (char) (60693 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Process.myTid() >> 22) + 5955, 148978589, false, $$c((byte) 0, -1, (short) 1), new Class[]{Integer.TYPE, Object.class, Object.class});
                            } else {
                                i7 = 55223;
                                i8 = 2106881226;
                            }
                            jArr[i12] = ((Long) ((Method) objComponent13).invoke(null, objArr18)).longValue() ^ (vD14832N6715 ^ (-1805496993403714128L));
                            Object[] objArr19 = {cbVar, cbVar};
                            Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(i8);
                            if (objComponent14 == null) {
                                objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.getOffsetAfter("", 0) + 52, (char) (Color.red(0) + i7), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3269, 790704297, false, $$c((byte) 0, -1, (short) 0), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent14).invoke(null, objArr19);
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    char[] cArr = new char[length];
                    cbVar.D8871 = 0;
                    while (cbVar.D8871 < charArray.length) {
                        int i13 = $10 + 99;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        cArr[cbVar.D8871] = (char) jArr[cbVar.D8871];
                        Object[] objArr20 = {cbVar, cbVar};
                        Object objComponent15 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                        if (objComponent15 == null) {
                            objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52, (char) (55223 - View.resolveSizeAndState(0, 0, 0)), 3269 - (ViewConfiguration.getJumpTapTimeout() >> 16), 790704297, false, $$c((byte) 0, -1, (short) 0), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent15).invoke(null, objArr20);
                        int i15 = $10 + 111;
                        $11 = i15 % 128;
                        if (i15 % 2 == 0) {
                            int i16 = 5 / 4;
                        }
                    }
                    objArr17[0] = new String(cArr);
                }

                public final Geocoder component5$57232296(Object obj5) {
                    int i6 = 2 % 2;
                    Geocoder geocoder3 = new Geocoder(context, Locale.US);
                    int i7 = $D8871 + 45;
                    $component5 = i7 % 128;
                    if (i7 % 2 != 0) {
                        int i8 = 32 / 0;
                    }
                    return geocoder3;
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Geocoder invoke(Object obj5) {
                    int i6 = 2 % 2;
                    int i7 = $D8871 + 71;
                    $component5 = i7 % 128;
                    int i8 = i7 % 2;
                    Geocoder geocoderComponent5$57232296 = component5$57232296(obj5);
                    int i9 = $D8871 + 63;
                    $component5 = i9 % 128;
                    if (i9 % 2 != 0) {
                        int i10 = 51 / 0;
                    }
                    return geocoderComponent5$57232296;
                }

                static {
                    init$0();
                    $10 = 0;
                    $11 = 1;
                    $component5 = 0;
                    $D8871 = 1;
                    vD14832N6715 = -1178376339860812846L;
                    component9 = 2639572078145390921L;
                }

                public static Object[] vD14832N6715(Context context2, int i6, int i7) {
                    char c7;
                    if (context2 == null) {
                        Object[] objArr17 = {new int[]{i6}, null, new int[]{i6}, new int[1]};
                        int i8 = (((~((-613479299) | i6)) | 545272320) * (-566)) + 1297893741 + ((~((-68206979) | i6)) * 566);
                        int iVD14832N6715 = I30900.Companion.vD14832N6715();
                        int i9 = -(-(i8 * (-475)));
                        int i10 = ~(((-1) ^ i8) | i8);
                        int i11 = ~i8;
                        int i12 = ~(i11 | iVD14832N6715);
                        int i13 = -(-(((i10 & i12) | (i10 ^ i12)) * (-476)));
                        int i14 = (((i9 | i13) << 1) - (i9 ^ i13)) + ((~((i11 ^ iVD14832N6715) | (i11 & iVD14832N6715))) * 952);
                        int i15 = -(-((~(i11 | (~iVD14832N6715))) * 476));
                        int i16 = ((i14 | i15) << 1) - (i15 ^ i14);
                        int i17 = i16 * 193;
                        int i18 = i7 * 193;
                        int i19 = (i17 & i18) + (i17 | i18);
                        int i20 = ~i6;
                        int i21 = ~i16;
                        int i22 = ~((i21 ^ i7) | (i21 & i7));
                        int i23 = ((i20 & i22) | (i20 ^ i22)) * (-192);
                        int i24 = (i19 ^ i23) + ((i23 & i19) << 1);
                        int i25 = ~i16;
                        int i26 = ~i7;
                        int i27 = ~((i25 & i26) | (i25 ^ i26));
                        int i28 = ~i7;
                        int i29 = ~i6;
                        int i30 = ~((i28 ^ i29) | (i28 & i29));
                        int i31 = (i24 - (~(-(-(((i27 & i30) | (i27 ^ i30)) * (-384)))))) - 1;
                        int i32 = (i21 ^ i28) | (i21 & i28);
                        int i33 = ~((i32 & i6) | (i32 ^ i6));
                        int i34 = i26 | i29;
                        int i35 = ~((i34 & i16) | (i34 ^ i16));
                        int i36 = (i33 & i35) | (i33 ^ i35);
                        int i37 = (i7 & i16) | (i16 ^ i7);
                        int i38 = ~((i6 & i37) | (i37 ^ i6));
                        int i39 = ((i38 & i36) | (i36 ^ i38)) * 192;
                        int i40 = (i31 ^ i39) + ((i39 & i31) << 1);
                        int i41 = i40 << 13;
                        int i42 = (i41 | i40) & (~(i40 & i41));
                        int i43 = i42 ^ (i42 >>> 17);
                        ((int[]) objArr17[3])[0] = i43 ^ (i43 << 5);
                        return objArr17;
                    }
                    try {
                        int i44 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int iVD14832N6716 = I30900.Companion.vD14832N6715();
                        int i45 = i44 * (-167);
                        int i46 = ((i45 | (-10399591)) << 1) - (i45 ^ (-10399591));
                        int i47 = ~i44;
                        int i48 = ~((i47 ^ (-62274)) | (i47 & (-62274)));
                        c7 = 3;
                        int i49 = ~((-62274) | iVD14832N6716);
                        int i50 = (i46 - (~(-(-(((i48 ^ i49) | (i49 & i48)) * 336))))) - 1;
                        int i51 = ~((i44 ^ 62273) | (i44 & 62273));
                        int i52 = ~((i44 ^ iVD14832N6716) | (i44 & iVD14832N6716));
                        int i53 = -(-(((i51 ^ i52) | (i52 & i51)) * (-168)));
                        int i54 = (i50 & i53) + (i50 | i53);
                        int i55 = ~iVD14832N6716;
                        int i56 = i54 + (((~((i55 & i44) | (i55 ^ i44))) | (-62274)) * 168);
                        try {
                            Object[] objArr18 = new Object[1];
                            a("츈㵂⢖ៀ̞ฉ綗检吉䍞亚뷀ꤚ鑖菂軌輻\ue947풘쎟켎㨂⧄ᒅTལ竍榉啎䁯侎뫔\ua62c镠肩迱ﬧ\ue66b", i56, objArr18);
                            Object[] objArr19 = (Object[]) Array.newInstance(Class.forName((String) objArr18[0]), 2);
                            int offsetBefore = TextUtils.getOffsetBefore("", 0);
                            int i57 = offsetBefore * (-523);
                            int i58 = (i57 & GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED) + (i57 | GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED);
                            int i59 = ~offsetBefore;
                            int i60 = ~((i59 ^ 1) | (i59 & 1));
                            int i61 = ~(((-2) ^ offsetBefore) | ((-2) & offsetBefore));
                            int i62 = i58 + (((i60 ^ i61) | (i61 & i60) | (~(((-2) ^ i6) | ((-2) & i6)))) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED);
                            int i63 = (~((-2) | offsetBefore)) * (-786);
                            int i64 = (i62 & i63) + (i63 | i62);
                            int i65 = ~i6;
                            int i66 = ~(((-2) ^ i65) | ((-2) & i65));
                            int i67 = ~offsetBefore;
                            int i68 = ~((i67 ^ 1) | (i67 & 1));
                            int i69 = (i66 ^ i68) | (i68 & i66);
                            int i70 = ~((-2) | offsetBefore);
                            int i71 = ((i69 & i70) | (i69 ^ i70)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED;
                            int i72 = ((i64 | i71) << 1) - (i71 ^ i64);
                            Object[] objArr20 = new Object[1];
                            b("⁆\u2005䋽誋㛂扔鼺숨\uf1ec炓\ud880끂莧⅟\uee1e龥啯\udf1d㰏䷂杺贌䶛㬘㣼믣掐\ue972쪷榯넂\ud892鰧ٚ윹", i72, objArr20);
                            try {
                                Object[] objArr21 = {(String) objArr20[0]};
                                Object[] objArr22 = new Object[1];
                                a("츈㵂⢖ៀ̞ฉ綗检吉䍞亚뷀ꤚ鑖菂軌輻\ue947풘쎟켎㨂⧄ᒅTལ竍榉啎䁯侎뫔\ua62c镠肩迱ﬧ\ue66b", 62272 - (~(-View.getDefaultSize(0, 0))), objArr22);
                                objArr19[0] = Class.forName((String) objArr22[0]).getDeclaredConstructor(String.class).newInstance(objArr21);
                                int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                int i73 = ((doubleTapTimeout | 1) << 1) - (doubleTapTimeout ^ 1);
                                Object[] objArr23 = new Object[1];
                                b("꣘ꢛ㘟펳䉓㬄ᣟ䗟礰Щ膟㞉ା嗎뜜ᡫ\uddfdꮊ攆쨃\uef86璘ᒷ볒끨콤㫝溑䈤ᵺ\ue83a彑ᓦ狫鹝", i73, objArr23);
                                try {
                                    Object[] objArr24 = {(String) objArr23[0]};
                                    int i74 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    int i75 = i74 * JfifUtil.MARKER_EOI;
                                    int i76 = (i75 & (-13388695)) + (i75 | (-13388695));
                                    int i77 = (~((i74 ^ i6) | (i74 & i6))) * JfifUtil.MARKER_SOI;
                                    int i78 = ((i76 | i77) << 1) - (i77 ^ i76);
                                    int i79 = ((-62274) & i74) | (i74 ^ (-62274));
                                    int i80 = -(-(((i79 & i65) | (i79 ^ i65)) * (-216)));
                                    int i81 = (i78 & i80) + (i80 | i78);
                                    int i82 = -(-(((~(i74 | (~i6))) | 62273) * JfifUtil.MARKER_SOI));
                                    int i83 = (i81 ^ i82) + ((i82 & i81) << 1);
                                    Object[] objArr25 = new Object[1];
                                    a("츈㵂⢖ៀ̞ฉ綗检吉䍞亚뷀ꤚ鑖菂軌輻\ue947풘쎟켎㨂⧄ᒅTལ竍榉啎䁯侎뫔\ua62c镠肩迱ﬧ\ue66b", i83, objArr25);
                                    objArr19[1] = Class.forName((String) objArr25[0]).getDeclaredConstructor(String.class).newInstance(objArr24);
                                    try {
                                        int i84 = -View.MeasureSpec.getSize(0);
                                        int i85 = ((i84 | 62233) << 1) - (i84 ^ 62233);
                                        Object[] objArr26 = new Object[1];
                                        a("츃㴕⠴\u175bɩ煶粐毣囉䗬냶밅ꬫ陉蕈\uf03bﾱ\ueaa4\ud9ce쓍㏳㼗⨰", i85, objArr26);
                                        Class<?> cls = Class.forName((String) objArr26[0]);
                                        Object[] objArr27 = new Object[1];
                                        b("ჶ႑㸟㏒䨋\udb44\uf15a걙셓ౝ憉\ude2c댙嶗坣\uf1e0旔ꏗ蔍⎠垔", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr27);
                                        Object objInvoke = cls.getMethod((String) objArr27[0], null).invoke(context2, null);
                                        try {
                                            int i86 = -(KeyEvent.getMaxKeyCode() >> 16);
                                            int iVD14832N6717 = I30900.Companion.vD14832N6715();
                                            int i87 = (i86 * 784) - 48666206;
                                            int i88 = ((i87 | 48729222) << 1) - (i87 ^ 48729222);
                                            int i89 = ~i86;
                                            int i90 = ~iVD14832N6717;
                                            int i91 = (i89 ^ i90) | (i89 & i90);
                                            int i92 = -(-((~((i91 ^ 62233) | (i91 & 62233))) * (-783)));
                                            int i93 = (i88 & i92) + (i88 | i92);
                                            int i94 = ~((i90 & 62233) | (i90 ^ 62233));
                                            int i95 = ((i89 & i94) | (i89 ^ i94)) * 783;
                                            int i96 = (i93 & i95) + (i93 | i95);
                                            Object[] objArr28 = new Object[1];
                                            a("츃㴕⠴\u175bɩ煶粐毣囉䗬냶밅ꬫ陉蕈\uf03bﾱ\ueaa4\ud9ce쓍㏳㼗⨰", i96, objArr28);
                                            Class<?> cls2 = Class.forName((String) objArr28[0]);
                                            int i97 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                            int i98 = (i97 * 284) - 282;
                                            int i99 = ~i97;
                                            int i100 = ~((i99 ^ 1) | (i99 & 1));
                                            int i101 = ~((i99 ^ i6) | (i99 & i6));
                                            int i102 = ((i100 ^ i101) | (i101 & i100)) * (-283);
                                            int i103 = ((i98 | i102) << 1) - (i102 ^ i98);
                                            int i104 = -(-((~(((-2) ^ i97) | ((-2) & i97))) * 283));
                                            int i105 = ~i97;
                                            int i106 = (((i103 & i104) + (i104 | i103)) - (~((~(((i105 & (-2)) | (i105 ^ (-2))) | i6)) * 283))) - 1;
                                            Object[] objArr29 = new Object[1];
                                            b("긪깍䏹훊㟭㹜Ꙍﭏ羏熻蒑褺ළⁱ뉸꛶\ud2e35", i106, objArr29);
                                            try {
                                                Object[] objArr30 = {cls2.getMethod((String) objArr29[0], null).invoke(context2, null), 64};
                                                int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                                                int iVD14832N6718 = I30900.Companion.vD14832N6715();
                                                int i107 = maximumDrawingCacheSize * (-1335);
                                                int i108 = (i107 & (-667)) + (i107 | (-667));
                                                int i109 = (maximumDrawingCacheSize ^ iVD14832N6718) | (maximumDrawingCacheSize & iVD14832N6718);
                                                int i110 = ~i109;
                                                int i111 = (i108 - (~((((-2) ^ i110) | ((-2) & i110)) * (-668)))) - 1;
                                                int i112 = (maximumDrawingCacheSize | (~((-2) | iVD14832N6718))) * 1336;
                                                int i113 = (i111 & i112) + (i112 | i111);
                                                int i114 = -(-(((i109 ^ (-2)) | (i109 & (-2))) * 668));
                                                int i115 = (i113 ^ i114) + ((i114 & i113) << 1);
                                                Object[] objArr31 = new Object[1];
                                                b("㘡㙀찴튣렫㨥\uf6bfꮞ\ue78aﹷ胧\ud986闊꾽똡\uf610䌈凸摿␎煁χᗹ劌⺔㔍㯸胹\udcde\ue747\ue912넵訓袇齼\uef75롳", i115, objArr31);
                                                Class<?> cls3 = Class.forName((String) objArr31[0]);
                                                int i116 = -TextUtils.lastIndexOf("", '0', 0, 0);
                                                int iVD14832N6719 = I30900.Companion.vD14832N6715();
                                                int i117 = ~i116;
                                                int i118 = ~((i117 ^ iVD14832N6719) | (i117 & iVD14832N6719));
                                                int i119 = ((i116 * 319) - 4985142) + ((((-15727) ^ i118) | ((-15727) & i118)) * (-318));
                                                int i120 = ~(((-15727) ^ iVD14832N6719) | ((-15727) & iVD14832N6719));
                                                int i121 = ~iVD14832N6719;
                                                int i122 = (i121 ^ i116) | (i121 & i116);
                                                int i123 = ~((i122 & 15726) | (i122 ^ 15726));
                                                int i124 = -(-(((i123 & i120) | (i120 ^ i123)) * TypedValues.Attributes.TYPE_PIVOT_TARGET));
                                                int i125 = ((i119 | i124) << 1) - (i124 ^ i119);
                                                int i126 = (-15727) | i121;
                                                int i127 = i116 | 15726;
                                                int i128 = -(-(((~((i126 & i116) | (i126 ^ i116))) | (~((i127 & iVD14832N6719) | (i127 ^ iVD14832N6719)))) * TypedValues.Attributes.TYPE_PIVOT_TARGET));
                                                int i129 = (i125 ^ i128) + ((i128 & i125) << 1);
                                                Object[] objArr32 = new Object[1];
                                                a("츅\uf368듈癿㮿ﴪ뺓怊╽\ue6e0\ua87d淉⼰킮", i129, objArr32);
                                                Object objInvoke2 = cls3.getMethod((String) objArr32[0], String.class, Integer.TYPE).invoke(objInvoke, objArr30);
                                                Object[] objArr33 = new Object[1];
                                                b("팗퍶厹뛱➦幷ᡰ䕑ʼ懺\ue4b5㝉烼〰퉳ᣟ\ua63e칵-쫁鑷鱊熫뱃쮢ꪀ循渶㧨磊资念漭ᜄ", KeyEvent.getDeadChar(0, 0) + 1, objArr33);
                                                Class<?> cls4 = Class.forName((String) objArr33[0]);
                                                Object[] objArr34 = new Object[1];
                                                b("箭篞\uf049㩍葑틈丄ጹꨈ숐栛慡\ud840鏛", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr34);
                                                Object[] objArr35 = (Object[]) cls4.getField((String) objArr34[0]).get(objInvoke2);
                                                int length = objArr35.length;
                                                int i130 = 0;
                                                while (i130 < length) {
                                                    Object obj5 = objArr35[i130];
                                                    int i131 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                                    int i132 = ((i131 | 1) << 1) - (i131 ^ 1);
                                                    Object[] objArr36 = new Object[1];
                                                    b("팽퍥쟴\ue006뎫࣑ᘩ䭊ˀ", i132, objArr36);
                                                    try {
                                                        Object[] objArr37 = {(String) objArr36[0]};
                                                        int i133 = -Gravity.getAbsoluteGravity(0, 0);
                                                        int i134 = ((i133 | 1) << 1) - (i133 ^ 1);
                                                        Object[] objArr38 = new Object[1];
                                                        b("鯘鮲럿餜쏯熈൯偝䨲薩쭋∛㠥푤ﶋව\ueeed⩼⿅\udf95\udcba砚幔ꥏ荩付灊笡焦鲏ꊑ䫥⟰\uf347퓰ᒡᖛ섊ۥ\ue66e쑅", i134, objArr38);
                                                        Class<?> cls5 = Class.forName((String) objArr38[0]);
                                                        int i135 = -(-TextUtils.indexOf("", "", 0, 0));
                                                        int i136 = (i135 ^ 1) + ((i135 & 1) << 1);
                                                        Object[] objArr39 = new Object[1];
                                                        b("䬵䭒냗蜦쓃澰\ud9cc蓖骟芅핢\uf6ba\ue8d3퍙\ue3bf", i136, objArr39);
                                                        Object objInvoke3 = cls5.getMethod((String) objArr39[0], String.class).invoke(null, objArr37);
                                                        try {
                                                            int i137 = -Color.argb(0, 0, 0, 0);
                                                            int i138 = (i137 * 483) - (-7733594);
                                                            int i139 = ~i137;
                                                            Object[] objArr40 = objArr35;
                                                            int i140 = ~((i139 & (-31958)) | (i139 ^ (-31958)));
                                                            int i141 = (i139 & i65) | (i139 ^ i65);
                                                            int i142 = (i140 | (~i141)) * (-241);
                                                            int i143 = (((i138 & i142) + (i142 | i138)) - (~(((i137 ^ 31957) | (i137 & 31957)) * (-482)))) - 1;
                                                            int i144 = ~(((-31958) & i137) | ((-31958) ^ i137));
                                                            int i145 = ~((i141 ^ 31957) | (i141 & 31957));
                                                            int i146 = i143 + (((i144 & i145) | (i144 ^ i145)) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION);
                                                            Object[] objArr41 = new Object[1];
                                                            a("츃닙㞬롯㵙븢⋸ꞟ⢩군\u2e5e錱\u17fb飝ᶰ鸷͂萪ࢶ跾ຯ\uf37c瑂鸞緮ﻚ掲\ue470", i146, objArr41);
                                                            Class<?> cls6 = Class.forName((String) objArr41[0]);
                                                            int i147 = -(-View.resolveSizeAndState(0, 0, 0));
                                                            int i148 = ((i147 | 36809) << 1) - (i147 ^ 36809);
                                                            Object[] objArr42 = new Object[1];
                                                            a("츖䇄톲慀\uf132ê邕\u206f끘쀒叁", i148, objArr42);
                                                            try {
                                                                Object[] objArr43 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr42[0], null).invoke(obj5, null))};
                                                                Object[] objArr44 = new Object[1];
                                                                b("鯘鮲럿餜쏯熈൯偝䨲薩쭋∛㠥푤ﶋව\ueeed⩼⿅\udf95\udcba砚幔ꥏ荩付灊笡焦鲏ꊑ䫥⟰\uf347퓰ᒡᖛ섊ۥ\ue66e쑅", 1 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr44);
                                                                Class<?> cls7 = Class.forName((String) objArr44[0]);
                                                                Object[] objArr45 = new Object[1];
                                                                a("츅칢컆켨쾄쿺챈쳄촉춊췢쩁쪷쬥쮍쯪졓좣줝", 100 - TextUtils.indexOf((CharSequence) "", '0'), objArr45);
                                                                Object objInvoke4 = cls7.getMethod((String) objArr45[0], InputStream.class).invoke(objInvoke3, objArr43);
                                                                int length2 = objArr19.length;
                                                                int i149 = 0;
                                                                while (i149 < 2) {
                                                                    Object obj6 = objArr19[i149];
                                                                    try {
                                                                        int i150 = -(-ExpandableListView.getPackedPositionType(0L));
                                                                        int i151 = (i150 ^ 45053) + ((i150 & 45053) << 1);
                                                                        Object[] objArr46 = new Object[1];
                                                                        a("츈懾釮쇴熸ꇠ퇩Ǫ뇿\ue1f5ᇩ䇉\uf1c7↕凗臔㇀懛醆쇽熓ꆓ퇥ƚ놿\ue1a5ᆤ䆤\uf1a8↢冧膠ㆶ憚", i151, objArr46);
                                                                        Class<?> cls8 = Class.forName((String) objArr46[0]);
                                                                        int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0);
                                                                        int i152 = (absoluteGravity2 * (-721)) - 721;
                                                                        int i153 = ~absoluteGravity2;
                                                                        int i154 = ~((i153 ^ (-2)) | (i153 & (-2)));
                                                                        int i155 = (i65 ^ i154) | (i154 & i65);
                                                                        int i156 = length;
                                                                        int i157 = ~((absoluteGravity2 ^ 1) | (absoluteGravity2 & 1));
                                                                        int i158 = -(-(((i155 ^ i157) | (i155 & i157)) * 1444));
                                                                        int i159 = (i152 & i158) + (i152 | i158);
                                                                        int i160 = ~((absoluteGravity2 ^ i6) | (absoluteGravity2 & i6));
                                                                        int i161 = (i157 & i160) | (i157 ^ i160);
                                                                        int i162 = ~(i6 | 1);
                                                                        int i163 = -(-(((i161 & i162) | (i161 ^ i162)) * (-1444)));
                                                                        int i164 = ((i159 | i163) << 1) - (i159 ^ i163);
                                                                        int i165 = ~((i153 ^ 1) | (i153 & 1));
                                                                        int i166 = ~(((-2) & absoluteGravity2) | ((-2) ^ absoluteGravity2));
                                                                        int i167 = i164 + (((i165 & i166) | (i165 ^ i166)) * 722);
                                                                        Object[] objArr47 = new Object[1];
                                                                        b("홚혽\uee35ਸ騡\ue2ae륲\ue472߫\udc76塢阀疱趬溜릜ꌦ玬볐殟鄣⇎촿ᵸ컾ᜅ\ue374", i167, objArr47);
                                                                        if (obj6.equals(cls8.getMethod((String) objArr47[0], null).invoke(objInvoke4, null))) {
                                                                            Object[] objArr48 = {new int[]{i6}, null, new int[]{(i6 & (-2)) | (i65 & 1)}, new int[1]};
                                                                            int i168 = (-1448031505) + (((~((-1097842558) | i65)) | (~((-813563377) | i6))) * 1900) + (((~(i65 | 813563376)) | (~(i6 | 1097842557))) * (-950)) + (((~(813563376 | i6)) | (~(i65 | 1097842557))) * 950);
                                                                            int i169 = (i168 ^ 16) + ((i168 & 16) << 1);
                                                                            int iVD14832N67110 = I30900.Companion.vD14832N6715();
                                                                            int i170 = i169 * (-523);
                                                                            int i171 = -(-(i7 * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED));
                                                                            int i172 = (i170 & i171) + (i170 | i171);
                                                                            int i173 = ~i169;
                                                                            int i174 = ~(i173 | i7);
                                                                            int i175 = ~i7;
                                                                            int i176 = ~((i175 ^ i169) | (i175 & i169));
                                                                            int i177 = (i174 & i176) | (i174 ^ i176);
                                                                            int i178 = ~(i175 | iVD14832N67110);
                                                                            int i179 = ((i177 & i178) | (i177 ^ i178)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED;
                                                                            int i180 = (i172 ^ i179) + ((i179 & i172) << 1);
                                                                            int i181 = ~i7;
                                                                            int i182 = (~((i181 & i169) | (i181 ^ i169))) * (-786);
                                                                            int i183 = ((i180 | i182) << 1) - (i182 ^ i180);
                                                                            int i184 = ~iVD14832N67110;
                                                                            int i185 = (~((i184 & i175) | (i175 ^ i184))) | (~((i173 & i7) | (i173 ^ i7)));
                                                                            int i186 = ~(i169 | i175);
                                                                            int i187 = ((i186 & i185) | (i185 ^ i186)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED;
                                                                            int i188 = (i183 ^ i187) + ((i187 & i183) << 1);
                                                                            int i189 = i188 << 13;
                                                                            int i190 = (i189 | i188) & (~(i188 & i189));
                                                                            int i191 = i190 ^ (i190 >>> 17);
                                                                            ((int[]) objArr48[3])[0] = i191 ^ (i191 << 5);
                                                                            return objArr48;
                                                                        }
                                                                        i149 = (i149 | 1) + (i149 & 1);
                                                                        length = i156;
                                                                    } catch (Throwable th2) {
                                                                        Throwable cause2 = th2.getCause();
                                                                        if (cause2 != null) {
                                                                            throw cause2;
                                                                        }
                                                                        throw th2;
                                                                    }
                                                                }
                                                                i130++;
                                                                objArr35 = objArr40;
                                                            } catch (Throwable th3) {
                                                                Throwable cause3 = th3.getCause();
                                                                if (cause3 != null) {
                                                                    throw cause3;
                                                                }
                                                                throw th3;
                                                            }
                                                        } catch (Throwable th4) {
                                                            Throwable cause4 = th4.getCause();
                                                            if (cause4 != null) {
                                                                throw cause4;
                                                            }
                                                            throw th4;
                                                        }
                                                    } catch (Throwable th5) {
                                                        Throwable cause5 = th5.getCause();
                                                        if (cause5 != null) {
                                                            throw cause5;
                                                        }
                                                        throw th5;
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                Throwable cause6 = th6.getCause();
                                                if (cause6 != null) {
                                                    throw cause6;
                                                }
                                                throw th6;
                                            }
                                        } catch (Throwable th7) {
                                            Throwable cause7 = th7.getCause();
                                            if (cause7 != null) {
                                                throw cause7;
                                            }
                                            throw th7;
                                        }
                                    } catch (Throwable th8) {
                                        Throwable cause8 = th8.getCause();
                                        if (cause8 != null) {
                                            throw cause8;
                                        }
                                        throw th8;
                                    }
                                } catch (Throwable th9) {
                                    Throwable cause9 = th9.getCause();
                                    if (cause9 != null) {
                                        throw cause9;
                                    }
                                    throw th9;
                                }
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 != null) {
                                    throw cause10;
                                }
                                throw th10;
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        c7 = 3;
                    }
                    Object[] objArr49 = new Object[4];
                    objArr49[0] = new int[]{i6};
                    objArr49[2] = new int[]{i6};
                    objArr49[c7] = new int[1];
                    objArr49[1] = null;
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i192 = ~iElapsedRealtime;
                    int i193 = 245402782 + (((~(i192 | 1530238914)) | 381167019) * (-1042)) + ((1530238914 | iElapsedRealtime) * 521) + (((~(iElapsedRealtime | (-381167020))) | 305137026 | (~(i192 | 1606268907))) * 521);
                    int i194 = i193 * 713;
                    int i195 = ~i193;
                    int i196 = ~i195;
                    int i197 = ~(~i6);
                    int i198 = ((i196 & i197) | (i196 ^ i197)) * (-712);
                    int i199 = ((i194 | i198) << 1) - (i194 ^ i198);
                    int i200 = ~i193;
                    int i201 = ~i6;
                    int i202 = ~((i200 & i201) | (i200 ^ i201));
                    int i203 = ~(i6 | i193);
                    int i204 = i199 + (((i203 & i202) | (i202 ^ i203)) * (-712));
                    int i205 = ~i201;
                    int i206 = i7 + ((i204 - (~(-(-(((i205 & i195) | (i195 ^ i205)) * 712))))) - 1);
                    int i207 = i206 << 13;
                    int i208 = ((~i206) & i207) | ((~i207) & i206);
                    int i209 = i208 ^ (i208 >>> 17);
                    int i210 = i209 << 5;
                    ((int[]) objArr49[c7])[0] = ((~i209) & i210) | ((~i210) & i209);
                    return objArr49;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr17 = new Object[6];
            objArr17[c] = null;
            objArr17[c3] = 7;
            objArr17[3] = function5;
            objArr17[c2] = false;
            objArr17[1] = false;
            objArr17[0] = 0L;
            Object objComponent13 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent13 == null) {
                int maximumDrawingCacheSize = 51 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char cMyPid = (char) (Process.myPid() >> 22);
                int iBlue = Color.blue(0) + 1077;
                Object[] objArr18 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr18);
                objComponent13 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumDrawingCacheSize, cMyPid, iBlue, 1722308833, false, (String) objArr18[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            geocoder2 = (Geocoder) component9.component9((D8871) ((Method) objComponent13).invoke(null, objArr17), null);
        } else {
            geocoder2 = geocoder;
        }
        if ((i & 65536) != 0) {
            Function1<Object, String> function6 = new Function1<Object, String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component8T18414.4
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: component9$444b71f3, reason: merged with bridge method [inline-methods] */
                public final String invoke(Object obj5) {
                    File cacheDir = context.getCacheDir();
                    Intrinsics.checkNotNull(cacheDir);
                    String absolutePath = cacheDir.getAbsolutePath();
                    Intrinsics.checkNotNull(absolutePath);
                    return absolutePath;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            Object[] objArr19 = new Object[6];
            objArr19[c] = null;
            objArr19[c3] = 7;
            objArr19[3] = function6;
            objArr19[c2] = false;
            objArr19[1] = false;
            objArr19[0] = 0L;
            Object objComponent14 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent14 == null) {
                int mirror = 'c' - AndroidCharacter.getMirror('0');
                char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 1077;
                Object[] objArr20 = new Object[1];
                a((byte) 0, 0, (byte) 0, objArr20);
                objComponent14 = setSystemGestureExclusionRectsL30479.vD14832N6715(mirror, maximumFlingVelocity2, iResolveOpacity, 1722308833, false, (String) objArr20[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            str8 = (String) component9.component9((D8871) ((Method) objComponent14).invoke(null, objArr19), null);
        } else {
            str8 = str3;
        }
        setAutofillHintsI14457 setkeepscreenoni3248 = (i & 131072) != 0 ? new setKeepScreenOnI3248() : setautofillhintsi14457;
        String str10 = (i & 262144) != 0 ? "2.11.0" : str4;
        String strComponent5 = (i & 524288) != 0 ? I30900.ak.INSTANCE.component5() : str5;
        if ((i & 1048576) != 0) {
            component8 component8Var = component8.INSTANCE;
            pivotYN16904 = component8.setPivotYN16904();
        } else {
            pivotYN16904 = intRange;
        }
        br brVar2 = (i & 2097152) != 0 ? new br() : brVar;
        if ((i & 4194304) != 0) {
            getSystemGestureExclusionRects getsystemgestureexclusionrects = getSystemGestureExclusionRects.INSTANCE;
            b22527VD14832N6715 = getSystemGestureExclusionRects.vD14832N6715(context);
        } else {
            b22527VD14832N6715 = b22527;
        }
        if ((i & 8388608) != 0) {
            getSystemGestureExclusionRects getsystemgestureexclusionrects2 = getSystemGestureExclusionRects.INSTANCE;
            aVar2 = (a) getSystemGestureExclusionRects.vD14832N6715(AnonymousClass2.setPivotYN16904(), 1200693360, AnonymousClass2.setPivotYN16904(), -1200693358, new Object[]{context}, AnonymousClass2.setPivotYN16904(), AnonymousClass2.setPivotYN16904());
        } else {
            aVar2 = aVar;
        }
        rV4669 rv46610 = (i & 16777216) != 0 ? kP9958 : rv4669;
        I30900 i30901 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? O2678 : i30900;
        ak akVar2 = (i & 67108864) != 0 ? new ak(context, connectivityManager2) : akVar;
        wB2645 wb2646 = (i & 134217728) != 0 ? new wB2645() : wb2645;
        if ((i & 268435456) != 0) {
            Object objComponent15 = setSystemGestureExclusionRectsL30479.component5(922167875);
            if (objComponent15 == null) {
                objComponent15 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getTouchSlop() >> 8) + 52, (char) (3759 - (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1))), 913 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1682075168, false, null, new Class[0]);
            }
            objNewInstance = ((Constructor) objComponent15).newInstance(null);
        } else {
            str10 = str10;
            akVar2 = akVar2;
            objNewInstance = obj;
        }
        K17305 k17306 = (i & 536870912) != 0 ? new K17305(context, locationManager2, geocoder2) : k17305;
        M3232 m3233 = (i & 1073741824) != 0 ? new M3232(context, locationManager2) : m3232;
        setOnLongClickListenerR17701 setonlongclicklistenerr17703 = (i & Integer.MIN_VALUE) != 0 ? new setOnLongClickListenerR17701(context) : setonlongclicklistenerr17701;
        lI23295 li23296 = (i2 & 1) != 0 ? new lI23295(k17306, setonlongclicklistenerr17703) : li23295;
        if ((i2 & 2) != 0) {
            setOnLongClickListenerR17701 setonlongclicklistenerr17704 = setonlongclicklistenerr17703;
            setonlongclicklistenerr17702 = setonlongclicklistenerr17704;
            ho26225 = new hO26224(k17306, setonlongclicklistenerr17704, z2, j);
        } else {
            setonlongclicklistenerr17702 = setonlongclicklistenerr17703;
            ho26225 = ho26224;
        }
        ah ahVar2 = (i2 & 4) != 0 ? new ah(telephonyManager2) : ahVar;
        ao aoVar = (i2 & 8) != 0 ? new ao(str8) : anVar;
        jC6584 jc6585 = (i2 & 16) != 0 ? new jC6584() : jc6584;
        String strComponent6 = (i2 & 32) != 0 ? I30900.y.INSTANCE.component5() : str6;
        C1722 c1723 = (i2 & 64) != 0 ? new C1722(aoVar, strComponent6, jc6585) : c1722;
        String str11 = strComponent6;
        getRightG17489 getrightg174810 = (i2 & 128) != 0 ? new getRightG17489(c1723) : getrightg17489;
        if ((i2 & 256) != 0) {
            Object objComponent16 = setSystemGestureExclusionRectsL30479.component5(296811718);
            if (objComponent16 == null) {
                objComponent16 = setSystemGestureExclusionRectsL30479.vD14832N6715(Gravity.getAbsoluteGravity(0, 0) + 51, (char) (41601 - (ViewConfiguration.getTouchSlop() >> 8)), 803 - (KeyEvent.getMaxKeyCode() >> 16), 1124448421, false, null, new Class[0]);
            }
            objNewInstance2 = ((Constructor) objComponent16).newInstance(null);
        } else {
            c1723 = c1723;
            objNewInstance2 = obj2;
        }
        if ((i2 & 512) != 0) {
            Object objComponent17 = setSystemGestureExclusionRectsL30479.component5(883717661);
            objNewInstance3 = ((Constructor) (objComponent17 == null ? setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForChild(0, 0) > j2 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j2 ? 0 : -1)) + 67, (char) (3730 - ImageFormat.getBitsPerPixel(0)), Color.rgb(0, 0, 0) + 16777785, 1712927358, false, null, new Class[0]) : objComponent17)).newInstance(null);
        } else {
            objNewInstance3 = obj3;
        }
        if ((i2 & 1024) != 0) {
            Object[] objArr21 = {objNewInstance3};
            Object objComponent18 = setSystemGestureExclusionRectsL30479.component5(239420463);
            if (objComponent18 == null) {
                float f2 = f;
                objComponent18 = setSystemGestureExclusionRectsL30479.vD14832N6715(57 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ExpandableListView.getPackedPositionGroup(j2) + 14028), 635 - Drawable.resolveOpacity(0, 0), 1559232588, false, null, new Class[]{(Class) setSystemGestureExclusionRectsL30479.component5(Color.red(0) + 66, (char) (3731 - (TypedValue.complexToFraction(0, f2, f2) > f2 ? 1 : (TypedValue.complexToFraction(0, f2, f2) == f2 ? 0 : -1))), (Process.getElapsedCpuTime() > j2 ? 1 : (Process.getElapsedCpuTime() == j2 ? 0 : -1)) + 568)});
            }
            objNewInstance4 = ((Constructor) objComponent18).newInstance(objArr21);
        } else {
            geocoder2 = geocoder2;
            str8 = str8;
            objNewInstance4 = obj4;
        }
        z zVar2 = (i2 & 2048) != 0 ? new z() : zVar;
        aa aaVar2 = (i2 & 4096) != 0 ? new aa(zVar2) : aaVar;
        x xVar2 = (i2 & 8192) != 0 ? new x(packageManager2, str7) : xVar;
        as asVar2 = (i2 & 16384) != 0 ? new as() : asVar;
        this(context, list, str, z, list2, z2, j, userManager2, sensorManager2, packageManager2, contentResolver2, connectivityManager2, str7, locationManager2, telephonyManager2, geocoder2, str8, setkeepscreenoni3248, str10, strComponent5, pivotYN16904, brVar2, b22527VD14832N6715, aVar2, rv46610, i30901, akVar2, wb2646, objNewInstance, k17306, m3233, setonlongclicklistenerr17702, li23296, ho26225, ahVar2, aoVar, jc6585, str11, c1723, getrightg174810, objNewInstance2, objNewInstance3, objNewInstance4, zVar2, aaVar2, xVar2, asVar2, (i2 & 32768) != 0 ? new C10931(asVar2) : c10931);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component8T18414$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Landroid/hardware/SensorManager;", "D8871$78f747a", "(Ljava/lang/Object;)Landroid/hardware/SensorManager;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function1<Object, SensorManager> {
        public static int component5;
        public static int setPivotYN16904;
        private /* synthetic */ Context $D8871;

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: D8871$78f747a, reason: merged with bridge method [inline-methods] */
        public final SensorManager invoke(Object obj) {
            Object systemService = this.$D8871.getSystemService("sensor");
            Intrinsics.checkNotNull(systemService);
            return (SensorManager) systemService;
        }

        public static int component9() {
            int i = setPivotYN16904;
            int i2 = i % 9454246;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            component5 = elapsedCpuTime;
            return elapsedCpuTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Context context) {
            super(1);
            this.$D8871 = context;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component8T18414$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Landroid/content/pm/PackageManager;", "D8871$4210f201", "(Ljava/lang/Object;)Landroid/content/pm/PackageManager;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<Object, PackageManager> {
        public static int component9;
        public static int setPivotYN16904;
        private /* synthetic */ Context $D8871;

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: D8871$4210f201, reason: merged with bridge method [inline-methods] */
        public final PackageManager invoke(Object obj) {
            PackageManager packageManager = this.$D8871.getPackageManager();
            Intrinsics.checkNotNull(packageManager);
            return packageManager;
        }

        public static int setPivotYN16904() {
            int i = component9;
            int i2 = i % 6559626;
            component9 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            setPivotYN16904 = elapsedCpuTime;
            return elapsedCpuTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context) {
            super(1);
            this.$D8871 = context;
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component8T18414$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Landroid/net/ConnectivityManager;", "component9$657f2320", "(Ljava/lang/Object;)Landroid/net/ConnectivityManager;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass9 extends Lambda implements Function1<Object, ConnectivityManager> {
        public static int component5;
        public static int setPivotYN16904;
        private /* synthetic */ Context $component9;

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: component9$657f2320, reason: merged with bridge method [inline-methods] */
        public final ConnectivityManager invoke(Object obj) {
            Object systemService = this.$component9.getSystemService("connectivity");
            if (systemService instanceof ConnectivityManager) {
                return (ConnectivityManager) systemService;
            }
            return null;
        }

        public static int setPivotYN16904() {
            int i = setPivotYN16904;
            int i2 = i % 8518372;
            setPivotYN16904 = i + 1;
            if (i2 != 0) {
                return component5;
            }
            int iNextInt = new Random().nextInt(1346667268);
            component5 = iNextInt;
            return iNextInt;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Context context) {
            super(1);
            this.$component9 = context;
        }
    }

    static {
        init$0();
        INSTANCE = new Companion(null);
        kP9958 = new rV4669(false, 1500L, 30, AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH, false, 1500L, 30, AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH, true, true, 100L, 1, false, true);
        O2678 = I30900.aa.INSTANCE;
    }
}
