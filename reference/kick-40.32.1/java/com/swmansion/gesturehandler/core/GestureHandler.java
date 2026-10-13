package com.swmansion.gesturehandler.core;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.gesturehandler.RNSVGHitTester;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerDetectorView;
import com.swmansion.gesturehandler.react.events.eventbuilders.GestureHandlerEventDataBuilder;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GestureHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\u0010\n\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 ç\u00012\u00020\u0001:\bå\u0001æ\u0001ç\u0001è\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010\u0087\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0016J\u0010\u0010\u008c\u0001\u001a\u00020+2\u0007\u0010\u008d\u0001\u001a\u00020\u0000J>\u0010\u008e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020%2\u0007\u0010\u0090\u0001\u001a\u00020%2\u0007\u0010\u0091\u0001\u001a\u00020%2\u0007\u0010\u0092\u0001\u001a\u00020%2\u0007\u0010\u0093\u0001\u001a\u00020%2\u0007\u0010\u0094\u0001\u001a\u00020%J\u0019\u0010\u008e\u0001\u001a\u00030\u0084\u00012\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010%¢\u0006\u0003\u0010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00030\u0084\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010rJ\u001c\u0010\u0099\u0001\u001a\u00030\u0084\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010e\u001a\u0004\u0018\u00010fJ\n\u0010\u009a\u0001\u001a\u00030\u0084\u0001H\u0014J\t\u0010\u009b\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0011\u0010\u009e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0012\u0010\u009f\u0001\u001a\u00020+2\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010 \u0001\u001a\u00020+2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u0014\u0010¡\u0001\u001a\u00030\u0089\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u001c\u0010¢\u0001\u001a\u00030\u0084\u00012\b\u0010£\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001J\u001e\u0010¥\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0002J\u001e\u0010¦\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0002J\u001e\u0010§\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0002J\u001c\u0010¨\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001J\n\u0010©\u0001\u001a\u00030\u0084\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010«\u0001\u001a\u00030\u0084\u00012\u0007\u0010¬\u0001\u001a\u00020DH\u0002J\u0013\u0010\u00ad\u0001\u001a\u00030\u0084\u00012\u0007\u0010¬\u0001\u001a\u00020DH\u0002J\u0013\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010¬\u0001\u001a\u00020DH\u0002J\t\u0010°\u0001\u001a\u0004\u0018\u000108J\t\u0010±\u0001\u001a\u0004\u0018\u000108J\u0013\u0010²\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010³\u0001\u001a\u00020+2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0012\u0010´\u0001\u001a\u00020+2\u0007\u0010µ\u0001\u001a\u00020\u0000H\u0016J\u0010\u0010¶\u0001\u001a\u00020+2\u0007\u0010µ\u0001\u001a\u00020\u0000J\u0012\u0010·\u0001\u001a\u00020+2\u0007\u0010µ\u0001\u001a\u00020\u0000H\u0016J\u0012\u0010¸\u0001\u001a\u00020+2\u0007\u0010µ\u0001\u001a\u00020\u0000H\u0016J\u0019\u0010¹\u0001\u001a\u00020+2\u000e\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000»\u0001H\u0016J\"\u0010,\u001a\u00020+2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010½\u0001\u001a\u00020%J\b\u0010¾\u0001\u001a\u00030\u0084\u0001J\b\u0010¿\u0001\u001a\u00030\u0084\u0001J\b\u0010À\u0001\u001a\u00030\u0084\u0001J\u0013\u0010À\u0001\u001a\u00030\u0084\u00012\u0007\u0010Á\u0001\u001a\u00020+H\u0016J\b\u0010Â\u0001\u001a\u00030\u0084\u0001J\b\u0010Ã\u0001\u001a\u00030\u0084\u0001J\u0010\u0010Ä\u0001\u001a\u00020+2\u0007\u0010Å\u0001\u001a\u00020\u0000J\n\u0010Æ\u0001\u001a\u00030\u0084\u0001H\u0016J\u001e\u0010Ç\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0014J\u001e\u0010È\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0014J\u001e\u0010É\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0014J\u001c\u0010Ê\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010Ë\u0001\u001a\u00020\u0007H\u0014J\n\u0010Ì\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010Í\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010Î\u0001\u001a\u00030\u0084\u0001H\u0014J\b\u0010Ï\u0001\u001a\u00030\u0084\u0001J\u0012\u0010Ð\u0001\u001a\u00020+2\u0007\u0010Ñ\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010Ò\u0001\u001a\u00020+2\b\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0004J\u0014\u0010Ó\u0001\u001a\u00030Ô\u00012\b\u0010Õ\u0001\u001a\u00030Ô\u0001H\u0004J\b\u0010Ö\u0001\u001a\u00030\u0084\u0001J\u0019\u0010×\u0001\u001a\u00030\u0084\u00012\u000f\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010Ù\u0001J\u0014\u0010Ú\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\t\u0010Û\u0001\u001a\u00020+H\u0016J\u000b\u0010Ü\u0001\u001a\u00020\u000fH\u0096\u0080\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0013\u0010!\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u001e\u0010#\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u001e\u0010&\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001e\u0010,\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020+@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010-\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR\u001a\u00105\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010-\"\u0004\b7\u00101R\"\u00109\u001a\u0004\u0018\u0001082\b\u0010\u0014\u001a\u0004\u0018\u000108@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\"\u0010<\u001a\u0004\u0018\u0001082\b\u0010\u0014\u001a\u0004\u0018\u000108@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u001e\u0010>\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u001e\u0010@\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000bR\u0018\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ER\u001a\u0010F\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010-\"\u0004\bH\u00101R\u001a\u0010I\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u00101R\u001a\u0010L\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010-\"\u0004\bN\u00101R\u001a\u0010O\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010-\"\u0004\bQ\u00101R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010U\u001a\u00020T2\u0006\u0010\u0014\u001a\u00020T@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010(R\u001e\u0010Z\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010(R\u000e\u0010\\\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010_\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\rR\u001a\u0010b\u001a\u00020+X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010-\"\u0004\bd\u00101R\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010s\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\u000bR\u001a\u0010u\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u000b\"\u0004\bw\u0010\rR\u001a\u0010x\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u000b\"\u0004\bz\u0010\rR\u001a\u0010{\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010-\"\u0004\b|\u00101R\u001a\u0010}\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010-\"\u0004\b~\u00101R\u001c\u0010\u007f\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010-\"\u0005\b\u0081\u0001\u00101R\u0016\u0010\u0082\u0001\u001a\u00020+X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010-R\u0013\u0010Ý\u0001\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010(R\u0013\u0010ß\u0001\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bà\u0001\u0010(R\u0013\u0010á\u0001\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010(R\u0013\u0010ã\u0001\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bä\u0001\u0010(¨\u0006é\u0001"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler;", "", "<init>", "()V", "trackedPointerIDs", "", "trackedPointersIDsCount", "", "windowOffset", "tag", "getTag", "()I", "setTag", "(I)V", ViewProps.TEST_ID, "", "getTestID", "()Ljava/lang/String;", "setTestID", "(Ljava/lang/String;)V", "value", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "hostDetectorView", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;", "getHostDetectorView", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;", "setHostDetectorView", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;)V", "viewForEvents", "getViewForEvents", "coordinateView", "getCoordinateView", "state", "getState", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "getX", "()F", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "getY", "", "isWithinBounds", "()Z", "enabled", "isEnabled", "setEnabled", "(Z)V", "actionType", "getActionType", "setActionType", "forceReinitializeDuringOnHandle", "getForceReinitializeDuringOnHandle", "setForceReinitializeDuringOnHandle", "Lcom/facebook/react/bridge/WritableArray;", "changedTouchesPayload", "getChangedTouchesPayload", "()Lcom/facebook/react/bridge/WritableArray;", "allTouchesPayload", "getAllTouchesPayload", "touchEventType", "getTouchEventType", "trackedPointersCount", "getTrackedPointersCount", "trackedPointers", "", "Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "[Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "needsPointerData", "getNeedsPointerData", "setNeedsPointerData", "dispatchesAnimatedEvents", "getDispatchesAnimatedEvents", "setDispatchesAnimatedEvents", "dispatchesReanimatedEvents", "getDispatchesReanimatedEvents", "setDispatchesReanimatedEvents", "cancelsJSResponder", "getCancelsJSResponder", "setCancelsJSResponder", "hitSlop", "", "", "eventCoalescingKey", "getEventCoalescingKey", "()S", "lastAbsolutePositionX", "getLastAbsolutePositionX", "lastAbsolutePositionY", "getLastAbsolutePositionY", "manualActivation", "lastEventOffsetX", "lastEventOffsetY", "numberOfPointers", "getNumberOfPointers", "setNumberOfPointers", "shouldCancelWhenOutside", "getShouldCancelWhenOutside", "setShouldCancelWhenOutside", "orchestrator", "Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "getOrchestrator", "()Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "setOrchestrator", "(Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;)V", "onTouchEventListener", "Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "getOnTouchEventListener", "()Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "setOnTouchEventListener", "(Lcom/swmansion/gesturehandler/core/OnTouchEventListener;)V", "interactionController", "Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "pointerType", "getPointerType", "mouseButton", "getMouseButton", "setMouseButton", "activationIndex", "getActivationIndex", "setActivationIndex", "isActive", "setActive", "isAwaiting", "setAwaiting", "shouldResetProgress", "getShouldResetProgress", "setShouldResetProgress", "isContinuous", "dispatchStateChange", "", "newState", "prevState", "dispatchHandlerUpdate", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "resetConfig", "hasCommonPointers", "other", "setHitSlop", "leftPad", "topPad", "rightPad", "bottomPad", ViewProps.WIDTH, ViewProps.HEIGHT, ViewProps.PADDING, "(Ljava/lang/Float;)V", "setInteractionController", "controller", "prepare", "onPrepare", "findNextLocalPointerId", "startTrackingPointer", "pointerId", "stopTrackingPointer", "isTrackingPointer", "needAdapt", "adaptEvent", "handle", "transformedEvent", "sourceEvent", "dispatchTouchDownEvent", "dispatchTouchUpEvent", "dispatchTouchMoveEvent", "updatePointerData", "extractAllPointersData", "cancelPointers", "addChangedPointer", "pointerData", "addPointerToAll", "createPointerData", "Lcom/facebook/react/bridge/WritableMap;", "consumeChangedTouchesPayload", "consumeAllTouchesPayload", "moveToState", "wantsEvent", "shouldRequireToWaitForFailure", "handler", "shouldWaitForHandlerFailure", "shouldRecognizeSimultaneously", "shouldBeCancelledBy", "shouldBeginWithRecordedHandlers", "recorded", "", "posX", "posY", "cancel", "fail", "activate", "force", "begin", ViewProps.END, "isDescendantOf", "of", "resetProgress", "initialize", "onHandle", "onHandleHover", "onStateChange", "previousState", "onReset", "onCancel", "onFail", "recordHandlerIfNotPresent", "isButtonInConfig", "clickedButton", "shouldSkipEvent", "transformPoint", "Landroid/graphics/PointF;", "point", "reset", "withMarkedAsInBounds", "closure", "Lkotlin/Function0;", "setPointerType", "wantsToAttachDirectlyToView", "toString", "lastRelativePositionX", "getLastRelativePositionX", "lastRelativePositionY", "getLastRelativePositionY", "lastPositionInWindowX", "getLastPositionInWindowX", "lastPositionInWindowY", "getLastPositionInWindowY", "AdaptEventException", "Factory", "Companion", "PointerData", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class GestureHandler {
    public static final int ACTION_TYPE_JS_FUNCTION_NEW_API = 4;
    public static final int ACTION_TYPE_JS_FUNCTION_OLD_API = 3;
    public static final int ACTION_TYPE_NATIVE_ANIMATED_EVENT = 2;
    public static final int ACTION_TYPE_NATIVE_DETECTOR = 5;
    public static final int ACTION_TYPE_NONE = 0;
    public static final int ACTION_TYPE_REANIMATED_WORKLET = 1;
    public static final int ACTION_TYPE_VIRTUAL_DETECTOR = 6;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEFAULT_CANCELS_JS_RESPONDER = true;
    private static final boolean DEFAULT_DISPATCHES_ANIMATED_EVENTS = false;
    private static final boolean DEFAULT_DISPATCHES_REANIMATED_EVENTS = false;
    private static final Void DEFAULT_HIT_SLOP = null;
    private static final boolean DEFAULT_IS_ENABLED = true;
    private static final boolean DEFAULT_MANUAL_ACTIVATION = false;
    private static final int DEFAULT_MOUSE_BUTTON = 0;
    private static final boolean DEFAULT_NEEDS_POINTER_DATA = false;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = false;
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private static final int HIT_SLOP_BOTTOM_IDX = 3;
    private static final int HIT_SLOP_HEIGHT_IDX = 5;
    private static final int HIT_SLOP_LEFT_IDX = 0;
    public static final float HIT_SLOP_NONE = Float.NaN;
    private static final int HIT_SLOP_RIGHT_IDX = 2;
    private static final int HIT_SLOP_TOP_IDX = 1;
    private static final int HIT_SLOP_WIDTH_IDX = 4;
    private static final int MAX_POINTERS_COUNT = 17;
    public static final int POINTER_TYPE_KEY = 3;
    public static final int POINTER_TYPE_MOUSE = 2;
    public static final int POINTER_TYPE_OTHER = 4;
    public static final int POINTER_TYPE_STYLUS = 1;
    public static final int POINTER_TYPE_TOUCH = 0;
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_BEGAN = 2;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_END = 5;
    public static final int STATE_FAILED = 1;
    public static final int STATE_UNDETERMINED = 0;
    private static short nextEventCoalescingKey;
    private static MotionEvent.PointerCoords[] pointerCoords;
    private static MotionEvent.PointerProperties[] pointerProps;
    private int actionType;
    private int activationIndex;
    private WritableArray allTouchesPayload;
    private boolean cancelsJSResponder;
    private WritableArray changedTouchesPayload;
    private boolean dispatchesAnimatedEvents;
    private boolean dispatchesReanimatedEvents;
    private short eventCoalescingKey;
    private boolean forceReinitializeDuringOnHandle;
    private float[] hitSlop;
    private RNGestureHandlerDetectorView hostDetectorView;
    private GestureHandlerInteractionController interactionController;
    private boolean isActive;
    private boolean isAwaiting;
    private final boolean isContinuous;
    private boolean isEnabled;
    private boolean isWithinBounds;
    private float lastAbsolutePositionX;
    private float lastAbsolutePositionY;
    private float lastEventOffsetX;
    private float lastEventOffsetY;
    private boolean manualActivation;
    private int mouseButton;
    private boolean needsPointerData;
    private int numberOfPointers;
    private OnTouchEventListener onTouchEventListener;
    private GestureHandlerOrchestrator orchestrator;
    private int pointerType;
    private boolean shouldCancelWhenOutside;
    private boolean shouldResetProgress;
    private int state;
    private int tag;
    private String testID;
    private int touchEventType;
    private final int[] trackedPointerIDs = new int[17];
    private final PointerData[] trackedPointers;
    private int trackedPointersCount;
    private int trackedPointersIDsCount;
    private View view;
    private final int[] windowOffset;
    private float x;
    private float y;

    protected void initialize(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
    }

    protected void onCancel() {
    }

    protected void onFail() {
    }

    protected void onHandleHover(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
    }

    protected void onPrepare() {
    }

    protected void onReset() {
    }

    protected void onStateChange(int newState, int previousState) {
    }

    public void resetProgress() {
    }

    public boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> recorded) {
        Intrinsics.checkNotNullParameter(recorded, "recorded");
        return true;
    }

    public boolean wantsToAttachDirectlyToView() {
        return false;
    }

    public GestureHandler() {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        this.windowOffset = iArr;
        this.isEnabled = true;
        PointerData[] pointerDataArr = new PointerData[17];
        for (int i2 = 0; i2 < 17; i2++) {
            pointerDataArr[i2] = null;
        }
        this.trackedPointers = pointerDataArr;
        this.cancelsJSResponder = true;
        this.pointerType = 4;
    }

    public final int getTag() {
        return this.tag;
    }

    public final void setTag(int i) {
        this.tag = i;
    }

    public final String getTestID() {
        return this.testID;
    }

    public final void setTestID(String str) {
        this.testID = str;
    }

    public final View getView() {
        return this.view;
    }

    public final RNGestureHandlerDetectorView getHostDetectorView() {
        return this.hostDetectorView;
    }

    public final void setHostDetectorView(RNGestureHandlerDetectorView rNGestureHandlerDetectorView) {
        this.hostDetectorView = rNGestureHandlerDetectorView;
    }

    public final View getViewForEvents() {
        if (INSTANCE.usesNativeOrVirtualDetector(this.actionType)) {
            RNGestureHandlerDetectorView rNGestureHandlerDetectorView = this.hostDetectorView;
            Intrinsics.checkNotNull(rNGestureHandlerDetectorView);
            return rNGestureHandlerDetectorView;
        }
        View view = this.view;
        Intrinsics.checkNotNull(view);
        return view;
    }

    public final View getCoordinateView() {
        View view = this.view;
        if (!(view instanceof RNGestureHandlerDetectorView)) {
            return view;
        }
        RNGestureHandlerDetectorView rNGestureHandlerDetectorView = (RNGestureHandlerDetectorView) view;
        return rNGestureHandlerDetectorView.getChildCount() == 1 ? rNGestureHandlerDetectorView.getChildAt(0) : view;
    }

    public final int getState() {
        return this.state;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: isWithinBounds, reason: from getter */
    public final boolean getIsWithinBounds() {
        return this.isWithinBounds;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    protected final void setEnabled(boolean z) {
        if (this.view != null && this.isEnabled != z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.core.GestureHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.cancel();
                }
            });
        }
        this.isEnabled = z;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final void setActionType(int i) {
        this.actionType = i;
    }

    public final boolean getForceReinitializeDuringOnHandle() {
        return this.forceReinitializeDuringOnHandle;
    }

    public final void setForceReinitializeDuringOnHandle(boolean z) {
        this.forceReinitializeDuringOnHandle = z;
    }

    public final WritableArray getChangedTouchesPayload() {
        return this.changedTouchesPayload;
    }

    public final WritableArray getAllTouchesPayload() {
        return this.allTouchesPayload;
    }

    public final int getTouchEventType() {
        return this.touchEventType;
    }

    public final int getTrackedPointersCount() {
        return this.trackedPointersCount;
    }

    public final boolean getNeedsPointerData() {
        return this.needsPointerData;
    }

    public final void setNeedsPointerData(boolean z) {
        this.needsPointerData = z;
    }

    public final boolean getDispatchesAnimatedEvents() {
        return this.dispatchesAnimatedEvents;
    }

    public final void setDispatchesAnimatedEvents(boolean z) {
        this.dispatchesAnimatedEvents = z;
    }

    public final boolean getDispatchesReanimatedEvents() {
        return this.dispatchesReanimatedEvents;
    }

    public final void setDispatchesReanimatedEvents(boolean z) {
        this.dispatchesReanimatedEvents = z;
    }

    public final boolean getCancelsJSResponder() {
        return this.cancelsJSResponder;
    }

    public final void setCancelsJSResponder(boolean z) {
        this.cancelsJSResponder = z;
    }

    public final short getEventCoalescingKey() {
        return this.eventCoalescingKey;
    }

    public final float getLastAbsolutePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastAbsolutePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final int getNumberOfPointers() {
        return this.numberOfPointers;
    }

    protected final void setNumberOfPointers(int i) {
        this.numberOfPointers = i;
    }

    protected final boolean getShouldCancelWhenOutside() {
        return this.shouldCancelWhenOutside;
    }

    protected final void setShouldCancelWhenOutside(boolean z) {
        this.shouldCancelWhenOutside = z;
    }

    protected final GestureHandlerOrchestrator getOrchestrator() {
        return this.orchestrator;
    }

    protected final void setOrchestrator(GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        this.orchestrator = gestureHandlerOrchestrator;
    }

    public final OnTouchEventListener getOnTouchEventListener() {
        return this.onTouchEventListener;
    }

    public final void setOnTouchEventListener(OnTouchEventListener onTouchEventListener) {
        this.onTouchEventListener = onTouchEventListener;
    }

    public final int getPointerType() {
        return this.pointerType;
    }

    protected final int getMouseButton() {
        return this.mouseButton;
    }

    protected final void setMouseButton(int i) {
        this.mouseButton = i;
    }

    public final int getActivationIndex() {
        return this.activationIndex;
    }

    public final void setActivationIndex(int i) {
        this.activationIndex = i;
    }

    /* JADX INFO: renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    /* JADX INFO: renamed from: isAwaiting, reason: from getter */
    public final boolean getIsAwaiting() {
        return this.isAwaiting;
    }

    public final void setAwaiting(boolean z) {
        this.isAwaiting = z;
    }

    public final boolean getShouldResetProgress() {
        return this.shouldResetProgress;
    }

    public final void setShouldResetProgress(boolean z) {
        this.shouldResetProgress = z;
    }

    /* JADX INFO: renamed from: isContinuous, reason: from getter */
    public boolean getIsContinuous() {
        return this.isContinuous;
    }

    public void dispatchStateChange(int newState, int prevState) {
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onStateChange(this, newState, prevState);
        }
    }

    public void dispatchHandlerUpdate(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onHandlerUpdate(this, event);
        }
    }

    public void dispatchTouchEvent() {
        OnTouchEventListener onTouchEventListener;
        if (this.changedTouchesPayload == null || (onTouchEventListener = this.onTouchEventListener) == null) {
            return;
        }
        onTouchEventListener.onTouchEvent(this);
    }

    public void resetConfig() {
        this.testID = null;
        this.needsPointerData = false;
        this.manualActivation = false;
        this.shouldCancelWhenOutside = false;
        setEnabled(true);
        this.hitSlop = (float[]) DEFAULT_HIT_SLOP;
        this.mouseButton = 0;
        this.dispatchesAnimatedEvents = false;
        this.dispatchesReanimatedEvents = false;
        this.cancelsJSResponder = true;
    }

    public final boolean hasCommonPointers(GestureHandler other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            if (this.trackedPointerIDs[i] != -1 && other.trackedPointerIDs[i] != -1) {
                return true;
            }
        }
        return false;
    }

    public final void setHitSlop(float leftPad, float topPad, float rightPad, float bottomPad, float width, float height) {
        if (this.hitSlop == null) {
            this.hitSlop = new float[6];
        }
        float[] fArr = this.hitSlop;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = leftPad;
        float[] fArr2 = this.hitSlop;
        Intrinsics.checkNotNull(fArr2);
        fArr2[1] = topPad;
        float[] fArr3 = this.hitSlop;
        Intrinsics.checkNotNull(fArr3);
        fArr3[2] = rightPad;
        float[] fArr4 = this.hitSlop;
        Intrinsics.checkNotNull(fArr4);
        fArr4[3] = bottomPad;
        float[] fArr5 = this.hitSlop;
        Intrinsics.checkNotNull(fArr5);
        fArr5[4] = width;
        float[] fArr6 = this.hitSlop;
        Intrinsics.checkNotNull(fArr6);
        fArr6[5] = height;
    }

    public final void setHitSlop(Float padding) {
        if (padding == null) {
            this.hitSlop = (float[]) DEFAULT_HIT_SLOP;
        } else {
            setHitSlop(padding.floatValue(), padding.floatValue(), padding.floatValue(), padding.floatValue(), Float.NaN, Float.NaN);
        }
    }

    public final void setInteractionController(GestureHandlerInteractionController controller) {
        this.interactionController = controller;
    }

    public final void prepare(View view, GestureHandlerOrchestrator orchestrator) {
        if (this.view != null || this.orchestrator != null) {
            throw new IllegalStateException("Already prepared or hasn't been reset".toString());
        }
        Arrays.fill(this.trackedPointerIDs, -1);
        this.trackedPointersIDsCount = 0;
        this.state = 0;
        this.view = view;
        this.orchestrator = orchestrator;
        Activity activityFindActivity = ExtensionsKt.findActivity(view != null ? view.getContext() : null);
        View viewFindViewById = activityFindActivity != null ? activityFindActivity.findViewById(R.id.content) : null;
        int[] iArr = this.windowOffset;
        if (viewFindViewById != null) {
            viewFindViewById.getLocationOnScreen(iArr);
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        onPrepare();
    }

    private final int findNextLocalPointerId() {
        int[] iArr;
        int i = 0;
        while (i < this.trackedPointersIDsCount) {
            int i2 = 0;
            while (true) {
                iArr = this.trackedPointerIDs;
                if (i2 >= iArr.length || iArr[i2] == i) {
                    break;
                }
                i2++;
            }
            if (i2 == iArr.length) {
                break;
            }
            i++;
        }
        return i;
    }

    public final void startTrackingPointer(int pointerId) {
        if (isTrackingPointer(pointerId)) {
            return;
        }
        this.trackedPointerIDs[pointerId] = findNextLocalPointerId();
        this.trackedPointersIDsCount++;
    }

    public final void stopTrackingPointer(int pointerId) {
        if (isTrackingPointer(pointerId)) {
            this.trackedPointerIDs[pointerId] = -1;
            this.trackedPointersIDsCount--;
        }
    }

    private final boolean isTrackingPointer(int pointerId) {
        return this.trackedPointerIDs[pointerId] != -1;
    }

    private final boolean needAdapt(MotionEvent event) {
        if (event.getPointerCount() != this.trackedPointersIDsCount) {
            return true;
        }
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            int i2 = this.trackedPointerIDs[i];
            if (i2 != -1 && i2 != i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private final MotionEvent adaptEvent(MotionEvent event) throws AdaptEventException {
        int actionIndex;
        MotionEvent.PointerProperties[] pointerPropertiesArr;
        MotionEvent.PointerProperties[] pointerPropertiesArr2;
        MotionEvent.PointerCoords[] pointerCoordsArr;
        if (!needAdapt(event)) {
            return event;
        }
        int actionMasked = event.getActionMasked();
        int i = 2;
        int i2 = 0;
        if (actionMasked == 0) {
            actionIndex = event.getActionIndex();
            if (this.trackedPointerIDs[event.getPointerId(actionIndex)] != -1) {
                if (this.trackedPointersIDsCount == 1) {
                    i = 0;
                } else {
                    i = 5;
                }
            }
        } else if (actionMasked == 1) {
            actionIndex = event.getActionIndex();
            if (this.trackedPointerIDs[event.getPointerId(actionIndex)] != -1) {
                if (this.trackedPointersIDsCount == 1) {
                    i = 1;
                } else {
                    i = 6;
                }
            }
        } else if (actionMasked == 5) {
            actionIndex = event.getActionIndex();
            if (this.trackedPointerIDs[event.getPointerId(actionIndex)] != -1) {
                if (this.trackedPointersIDsCount == 1) {
                    i = 0;
                } else {
                    i = 5;
                }
            }
        } else if (actionMasked != 6) {
            i = actionMasked;
            actionIndex = -1;
        } else {
            actionIndex = event.getActionIndex();
            if (this.trackedPointerIDs[event.getPointerId(actionIndex)] != -1) {
                if (this.trackedPointersIDsCount == 1) {
                    i = 1;
                } else {
                    i = 6;
                }
            }
        }
        INSTANCE.initPointerProps(this.trackedPointersIDsCount);
        float rawX = event.getRawX() - event.getX();
        float rawY = event.getRawY() - event.getY();
        event.offsetLocation(rawX, rawY);
        int pointerCount = event.getPointerCount();
        int i3 = i;
        int i4 = 0;
        while (true) {
            pointerPropertiesArr = null;
            MotionEvent.PointerCoords[] pointerCoordsArr2 = null;
            if (i2 >= pointerCount) {
                break;
            }
            int pointerId = event.getPointerId(i2);
            if (this.trackedPointerIDs[pointerId] != -1) {
                MotionEvent.PointerProperties[] pointerPropertiesArr3 = pointerProps;
                if (pointerPropertiesArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr3 = null;
                }
                event.getPointerProperties(i2, pointerPropertiesArr3[i4]);
                MotionEvent.PointerProperties[] pointerPropertiesArr4 = pointerProps;
                if (pointerPropertiesArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr4 = null;
                }
                MotionEvent.PointerProperties pointerProperties = pointerPropertiesArr4[i4];
                Intrinsics.checkNotNull(pointerProperties);
                pointerProperties.id = this.trackedPointerIDs[pointerId];
                MotionEvent.PointerCoords[] pointerCoordsArr3 = pointerCoords;
                if (pointerCoordsArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                } else {
                    pointerCoordsArr2 = pointerCoordsArr3;
                }
                event.getPointerCoords(i2, pointerCoordsArr2[i4]);
                if (i2 == actionIndex) {
                    i3 |= i4 << 8;
                }
                i4++;
            }
            i2++;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr5 = pointerProps;
        if (pointerPropertiesArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
            pointerPropertiesArr5 = null;
        }
        if (pointerPropertiesArr5.length != 0) {
            MotionEvent.PointerCoords[] pointerCoordsArr4 = pointerCoords;
            if (pointerCoordsArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                pointerCoordsArr4 = null;
            }
            if (pointerCoordsArr4.length != 0) {
                try {
                    long downTime = event.getDownTime();
                    long eventTime = event.getEventTime();
                    MotionEvent.PointerProperties[] pointerPropertiesArr6 = pointerProps;
                    if (pointerPropertiesArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                        pointerPropertiesArr2 = null;
                    } else {
                        pointerPropertiesArr2 = pointerPropertiesArr6;
                    }
                    MotionEvent.PointerCoords[] pointerCoordsArr5 = pointerCoords;
                    if (pointerCoordsArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                        pointerCoordsArr = null;
                    } else {
                        pointerCoordsArr = pointerCoordsArr5;
                    }
                    MotionEvent motionEventObtain = MotionEvent.obtain(downTime, eventTime, i3, i4, pointerPropertiesArr2, pointerCoordsArr, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags());
                    Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
                    float f = -rawX;
                    float f2 = -rawY;
                    event.offsetLocation(f, f2);
                    motionEventObtain.offsetLocation(f, f2);
                    return motionEventObtain;
                } catch (IllegalArgumentException e) {
                    throw new AdaptEventException(this, event, e);
                }
            }
        }
        MotionEvent.PointerCoords[] pointerCoordsArr6 = pointerCoords;
        if (pointerCoordsArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
            pointerCoordsArr6 = null;
        }
        int length = pointerCoordsArr6.length;
        MotionEvent.PointerProperties[] pointerPropertiesArr7 = pointerProps;
        if (pointerPropertiesArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
        } else {
            pointerPropertiesArr = pointerPropertiesArr7;
        }
        throw new IllegalStateException("pointerCoords.size=" + length + ", pointerProps.size=" + pointerPropertiesArr.length);
    }

    /* JADX INFO: compiled from: GestureHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$AdaptEventException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "event", "Landroid/view/MotionEvent;", "e", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "<init>", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Landroid/view/MotionEvent;Ljava/lang/IllegalArgumentException;)V", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AdaptEventException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdaptEventException(GestureHandler handler, MotionEvent event, IllegalArgumentException e) {
            super(StringsKt.trimIndent("\n    handler: " + Reflection.getOrCreateKotlinClass(handler.getClass()).getSimpleName() + "\n    state: " + handler.getState() + "\n    view: " + handler.getView() + "\n    orchestrator: " + handler.getOrchestrator() + "\n    isEnabled: " + handler.getIsEnabled() + "\n    isActive: " + handler.getIsActive() + "\n    isAwaiting: " + handler.getIsAwaiting() + "\n    trackedPointersCount: " + handler.trackedPointersIDsCount + "\n    trackedPointers: " + ArraysKt.joinToString$default(handler.trackedPointerIDs, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n    while handling event: " + event + "\n      "), e);
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    public final void handle(MotionEvent transformedEvent, MotionEvent sourceEvent) {
        int i;
        int pointerCount;
        int i2;
        Intrinsics.checkNotNullParameter(transformedEvent, "transformedEvent");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (!this.isEnabled || (i = this.state) == 3 || i == 1 || i == 5 || this.trackedPointersIDsCount < 1) {
            return;
        }
        try {
            MotionEvent[] motionEventArr = {adaptEvent(transformedEvent), adaptEvent(sourceEvent)};
            MotionEvent motionEvent = motionEventArr[0];
            MotionEvent motionEvent2 = motionEventArr[1];
            if (motionEvent.getActionMasked() == 6) {
                pointerCount = motionEvent.getPointerCount() - 1;
            } else {
                pointerCount = motionEvent.getPointerCount();
            }
            this.numberOfPointers = pointerCount;
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            boolean zIsWithinBounds = isWithinBounds(getCoordinateView(), this.x, this.y);
            this.isWithinBounds = zIsWithinBounds;
            if (this.shouldCancelWhenOutside && !zIsWithinBounds && ((i2 = this.state) == 4 || i2 == 2)) {
                fail();
                return;
            }
            this.lastAbsolutePositionX = GestureUtils.INSTANCE.getLastPointerX(motionEvent, true);
            this.lastAbsolutePositionY = GestureUtils.INSTANCE.getLastPointerY(motionEvent, true);
            this.lastEventOffsetX = motionEvent.getRawX() - motionEvent.getX();
            this.lastEventOffsetY = motionEvent.getRawY() - motionEvent.getY();
            if (sourceEvent.getAction() == 0 || sourceEvent.getAction() == 9 || sourceEvent.getAction() == 7) {
                setPointerType(sourceEvent);
            }
            if (ExtensionsKt.isHoverAction(sourceEvent)) {
                onHandleHover(motionEvent, motionEvent2);
            } else {
                onHandle(motionEvent, motionEvent2);
            }
            if (!Intrinsics.areEqual(motionEvent, transformedEvent)) {
                motionEvent.recycle();
            }
            if (Intrinsics.areEqual(motionEvent2, sourceEvent)) {
                return;
            }
            motionEvent2.recycle();
        } catch (AdaptEventException unused) {
            fail();
        }
    }

    private final void dispatchTouchDownEvent(MotionEvent event, MotionEvent sourceEvent) {
        this.changedTouchesPayload = null;
        this.touchEventType = 1;
        int pointerId = event.getPointerId(event.getActionIndex());
        this.trackedPointers[pointerId] = new PointerData(pointerId, event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), (sourceEvent.getX(event.getActionIndex()) + (sourceEvent.getRawX() - sourceEvent.getX())) - this.windowOffset[0], (sourceEvent.getY(event.getActionIndex()) + (sourceEvent.getRawY() - sourceEvent.getY())) - this.windowOffset[1]);
        this.trackedPointersCount++;
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        extractAllPointersData();
        dispatchTouchEvent();
    }

    private final void dispatchTouchUpEvent(MotionEvent event, MotionEvent sourceEvent) {
        int pointerId = event.getPointerId(event.getActionIndex());
        if (this.trackedPointers[pointerId] == null) {
            return;
        }
        extractAllPointersData();
        this.changedTouchesPayload = null;
        this.touchEventType = 3;
        this.trackedPointers[pointerId] = new PointerData(pointerId, event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), (sourceEvent.getX(event.getActionIndex()) + (sourceEvent.getRawX() - sourceEvent.getX())) - this.windowOffset[0], (sourceEvent.getY(event.getActionIndex()) + (sourceEvent.getRawY() - sourceEvent.getY())) - this.windowOffset[1]);
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        this.trackedPointers[pointerId] = null;
        this.trackedPointersCount--;
        dispatchTouchEvent();
    }

    private final void dispatchTouchMoveEvent(MotionEvent event, MotionEvent sourceEvent) {
        this.changedTouchesPayload = null;
        this.touchEventType = 2;
        float rawX = sourceEvent.getRawX() - sourceEvent.getX();
        float rawY = sourceEvent.getRawY() - sourceEvent.getY();
        int pointerCount = event.getPointerCount();
        int i = 0;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            PointerData pointerData = this.trackedPointers[event.getPointerId(i2)];
            if (pointerData != null && (pointerData.getX() != event.getX(i2) || pointerData.getY() != event.getY(i2))) {
                pointerData.setX(event.getX(i2));
                pointerData.setY(event.getY(i2));
                pointerData.setAbsoluteX((sourceEvent.getX(i2) + rawX) - this.windowOffset[0]);
                pointerData.setAbsoluteY((sourceEvent.getY(i2) + rawY) - this.windowOffset[1]);
                addChangedPointer(pointerData);
                i++;
            }
        }
        if (i > 0) {
            extractAllPointersData();
            dispatchTouchEvent();
        }
    }

    public final void updatePointerData(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getActionMasked() == 0 || event.getActionMasked() == 5) {
            dispatchTouchDownEvent(event, sourceEvent);
            dispatchTouchMoveEvent(event, sourceEvent);
        } else if (event.getActionMasked() == 1 || event.getActionMasked() == 6) {
            dispatchTouchMoveEvent(event, sourceEvent);
            dispatchTouchUpEvent(event, sourceEvent);
        } else if (event.getActionMasked() == 2) {
            dispatchTouchMoveEvent(event, sourceEvent);
        }
    }

    private final void extractAllPointersData() {
        this.allTouchesPayload = null;
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addPointerToAll(pointerData);
            }
        }
    }

    private final void cancelPointers() {
        this.touchEventType = 4;
        this.changedTouchesPayload = null;
        extractAllPointersData();
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addChangedPointer(pointerData);
            }
        }
        this.trackedPointersCount = 0;
        ArraysKt.fill$default(this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        dispatchTouchEvent();
    }

    private final void addChangedPointer(PointerData pointerData) {
        if (this.changedTouchesPayload == null) {
            this.changedTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.changedTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final void addPointerToAll(PointerData pointerData) {
        if (this.allTouchesPayload == null) {
            this.allTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.allTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final WritableMap createPointerData(PointerData pointerData) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("id", pointerData.getPointerId());
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, PixelUtil.toDIPFromPixel(pointerData.getX()));
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, PixelUtil.toDIPFromPixel(pointerData.getY()));
        writableMapCreateMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(pointerData.getAbsoluteX()));
        writableMapCreateMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(pointerData.getAbsoluteY()));
        return writableMapCreateMap;
    }

    public final WritableArray consumeChangedTouchesPayload() {
        WritableArray writableArray = this.changedTouchesPayload;
        this.changedTouchesPayload = null;
        return writableArray;
    }

    public final WritableArray consumeAllTouchesPayload() {
        WritableArray writableArray = this.allTouchesPayload;
        this.allTouchesPayload = null;
        return writableArray;
    }

    private final void moveToState(int newState) {
        UiThreadUtil.assertOnUiThread();
        if (this.state == newState) {
            return;
        }
        if (this.trackedPointersCount > 0 && (newState == 5 || newState == 3 || newState == 1)) {
            cancelPointers();
        }
        int i = this.state;
        this.state = newState;
        if (newState == 4) {
            short s = nextEventCoalescingKey;
            nextEventCoalescingKey = (short) (s + 1);
            this.eventCoalescingKey = s;
        }
        RNGestureHandlerDetectorView rNGestureHandlerDetectorView = this.hostDetectorView;
        if (rNGestureHandlerDetectorView == null && this.orchestrator == null) {
            throw new IllegalStateException("Manually handled gesture had not been assigned to any detector".toString());
        }
        if (this.orchestrator == null && rNGestureHandlerDetectorView != null) {
            rNGestureHandlerDetectorView.recordHandlerIfNotPresent(this);
        }
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        Intrinsics.checkNotNull(gestureHandlerOrchestrator);
        gestureHandlerOrchestrator.onHandlerStateChange(this, newState, i);
        onStateChange(newState, i);
    }

    public final boolean wantsEvent(MotionEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isEnabled || (i = this.state) == 1 || i == 3 || i == 5) {
            return false;
        }
        if (event.getActionMasked() == 2) {
            int pointerCount = event.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (isTrackingPointer(event.getPointerId(i2))) {
                    return true;
                }
            }
            return false;
        }
        return isTrackingPointer(event.getPointerId(event.getActionIndex()));
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldRequireHandlerToWaitForFailure(this, handler);
    }

    public final boolean shouldWaitForHandlerFailure(GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldWaitForHandlerFailure(this, handler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this) {
            return true;
        }
        GestureHandlerInteractionController gestureHandlerInteractionController = this.interactionController;
        if (gestureHandlerInteractionController != null) {
            return gestureHandlerInteractionController.shouldRecognizeSimultaneously(this, handler);
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler handler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldHandlerBeCancelledBy(this, handler);
    }

    public final boolean isWithinBounds(View view, float posX, float posY) {
        float f;
        RNSVGHitTester.Companion companion = RNSVGHitTester.INSTANCE;
        Intrinsics.checkNotNull(view);
        if (companion.isSvgElement(view)) {
            return RNSVGHitTester.INSTANCE.hitTest(view, posX, posY);
        }
        float width = view.getWidth();
        float height = view.getHeight();
        float[] fArr = this.hitSlop;
        float f2 = 0.0f;
        if (fArr != null) {
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            float f6 = fArr[3];
            Companion companion2 = INSTANCE;
            float f7 = companion2.hitSlopSet(f3) ? 0.0f - f3 : 0.0f;
            f2 = companion2.hitSlopSet(f4) ? 0.0f - f4 : 0.0f;
            if (companion2.hitSlopSet(f5)) {
                width += f5;
            }
            if (companion2.hitSlopSet(f6)) {
                height += f6;
            }
            float f8 = fArr[4];
            float f9 = fArr[5];
            if (companion2.hitSlopSet(f8)) {
                if (!companion2.hitSlopSet(f3)) {
                    f7 = width - f8;
                } else if (!companion2.hitSlopSet(f5)) {
                    width = f8 + f7;
                }
            }
            if (companion2.hitSlopSet(f9)) {
                if (!companion2.hitSlopSet(f4)) {
                    f2 = height - f9;
                } else if (!companion2.hitSlopSet(f6)) {
                    height = f9 + f2;
                }
            }
            f = f2;
            f2 = f7;
        } else {
            f = 0.0f;
        }
        return f2 <= posX && posX <= width && f <= posY && posY <= height;
    }

    public final void cancel() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2 || this.isAwaiting) {
            onCancel();
            moveToState(3);
        }
    }

    public final void fail() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            onFail();
            moveToState(1);
        }
    }

    public final void activate() {
        activate(false);
    }

    public void activate(boolean force) {
        if (!this.manualActivation || force) {
            int i = this.state;
            if (i == 0 || i == 2) {
                moveToState(4);
            }
        }
    }

    public final void begin() {
        if (this.state == 0) {
            moveToState(2);
        }
    }

    public final void end() {
        int i = this.state;
        if (i == 2 || i == 4) {
            moveToState(5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0018, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isDescendantOf(com.swmansion.gesturehandler.core.GestureHandler r3) {
        /*
            r2 = this;
            java.lang.String r0 = "of"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.view.View r2 = r2.view
            r0 = 0
            if (r2 == 0) goto Lf
            android.view.ViewParent r2 = r2.getParent()
            goto L10
        Lf:
            r2 = r0
        L10:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L17
            android.view.View r2 = (android.view.View) r2
            goto L18
        L17:
            r2 = r0
        L18:
            if (r2 == 0) goto L2f
            android.view.View r1 = r3.view
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r1 == 0) goto L24
            r2 = 1
            return r2
        L24:
            android.view.ViewParent r2 = r2.getParent()
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L17
            android.view.View r2 = (android.view.View) r2
            goto L18
        L2f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.isDescendantOf(com.swmansion.gesturehandler.core.GestureHandler):boolean");
    }

    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        moveToState(1);
    }

    public final void recordHandlerIfNotPresent() {
        RNGestureHandlerDetectorView rNGestureHandlerDetectorView = this.hostDetectorView;
        if (rNGestureHandlerDetectorView != null) {
            rNGestureHandlerDetectorView.recordHandlerIfNotPresent(this);
        }
    }

    private final boolean isButtonInConfig(int clickedButton) {
        int i = this.mouseButton;
        if (i == 0) {
            return clickedButton == 1;
        }
        return (i & clickedButton) != 0;
    }

    protected final boolean shouldSkipEvent(MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (sourceEvent.getToolType(0) != 3) {
            return false;
        }
        if (sourceEvent.getActionMasked() == 0 || sourceEvent.getActionMasked() == 1 || sourceEvent.getActionMasked() == 6 || sourceEvent.getActionMasked() == 5) {
            return true;
        }
        if (sourceEvent.getActionMasked() == 2 || isButtonInConfig(sourceEvent.getActionButton())) {
            return sourceEvent.getActionMasked() == 2 && !isButtonInConfig(sourceEvent.getButtonState());
        }
        return true;
    }

    protected final PointF transformPoint(PointF point) {
        PointF pointFTransformPointToViewCoords;
        Intrinsics.checkNotNullParameter(point, "point");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null && (pointFTransformPointToViewCoords = gestureHandlerOrchestrator.transformPointToViewCoords(getCoordinateView(), point)) != null) {
            return pointFTransformPointToViewCoords;
        }
        point.x = Float.NaN;
        point.y = Float.NaN;
        return point;
    }

    public final void reset() {
        this.view = null;
        this.orchestrator = null;
        Arrays.fill(this.trackedPointerIDs, -1);
        this.trackedPointersIDsCount = 0;
        this.trackedPointersCount = 0;
        ArraysKt.fill$default(this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        this.touchEventType = 0;
        onReset();
    }

    public final void withMarkedAsInBounds(Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        this.isWithinBounds = true;
        closure.invoke();
        this.isWithinBounds = false;
    }

    private final void setPointerType(MotionEvent event) {
        this.pointerType = ExtensionsKt.getPointerType(event, event.getActionIndex());
    }

    public String toString() {
        Class<?> cls;
        String simpleName = this.testID;
        if (simpleName == null) {
            View view = this.view;
            simpleName = (view == null || (cls = view.getClass()) == null) ? null : cls.getSimpleName();
        }
        return getClass().getSimpleName() + "@[" + this.tag + "]:" + simpleName;
    }

    public final float getLastRelativePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastRelativePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final float getLastPositionInWindowX() {
        return (this.lastAbsolutePositionX + this.lastEventOffsetX) - this.windowOffset[0];
    }

    public final float getLastPositionInWindowY() {
        return (this.lastAbsolutePositionY + this.lastEventOffsetY) - this.windowOffset[1];
    }

    /* JADX INFO: compiled from: GestureHandler.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000e\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H$¢\u0006\u0002\u0010\u0011J\u001d\u0010\u000e\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u0017\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001eR\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$Factory;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "", "<init>", "()V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "create", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlerTag", "", "(Landroid/content/Context;I)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setConfig", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/facebook/react/bridge/ReadableMap;)V", "updateConfig", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Lcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Factory<T extends GestureHandler> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String KEY_CANCELS_JS_RESPONDER = "cancelsJSResponder";
        private static final String KEY_DISPATCHES_ANIMATED_EVENTS = "dispatchesAnimatedEvents";
        private static final String KEY_DISPATCHES_REANIMATED_EVENTS = "dispatchesReanimatedEvents";
        private static final String KEY_ENABLED = "enabled";
        private static final String KEY_HIT_SLOP = "hitSlop";
        private static final String KEY_MANUAL_ACTIVATION = "manualActivation";
        private static final String KEY_MOUSE_BUTTON = "mouseButton";
        private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
        private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
        private static final String KEY_TEST_ID = "testID";

        protected abstract T create(Context context);

        public abstract GestureHandlerEventDataBuilder<T> createEventBuilder(T handler);

        public abstract String getName();

        public abstract Class<T> getType();

        public final T create(Context context, int handlerTag) {
            T t = (T) create(context);
            t.setTag(handlerTag);
            return t;
        }

        public final void setConfig(T handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            handler.resetConfig();
            updateConfig(handler, config);
        }

        public void updateConfig(T handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            if (config.hasKey(KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                handler.setShouldCancelWhenOutside(config.getBoolean(KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (config.hasKey("enabled")) {
                handler.setEnabled(config.getBoolean("enabled"));
            }
            if (config.hasKey(KEY_HIT_SLOP)) {
                INSTANCE.handleHitSlopProperty(handler, config);
            }
            if (config.hasKey(KEY_NEEDS_POINTER_DATA)) {
                handler.setNeedsPointerData(config.getBoolean(KEY_NEEDS_POINTER_DATA));
            }
            if (config.hasKey(KEY_DISPATCHES_ANIMATED_EVENTS)) {
                handler.setDispatchesAnimatedEvents(config.getBoolean(KEY_DISPATCHES_ANIMATED_EVENTS));
            }
            if (config.hasKey(KEY_DISPATCHES_REANIMATED_EVENTS)) {
                handler.setDispatchesReanimatedEvents(config.getBoolean(KEY_DISPATCHES_REANIMATED_EVENTS));
            }
            if (config.hasKey(KEY_MANUAL_ACTIVATION)) {
                ((GestureHandler) handler).manualActivation = config.getBoolean(KEY_MANUAL_ACTIVATION);
            }
            if (config.hasKey(KEY_MOUSE_BUTTON)) {
                handler.setMouseButton(config.getInt(KEY_MOUSE_BUTTON));
            }
            if (config.hasKey("testID")) {
                handler.setTestID(config.getString("testID"));
            }
            if (config.hasKey(KEY_CANCELS_JS_RESPONDER)) {
                handler.setCancelsJSResponder(config.getBoolean(KEY_CANCELS_JS_RESPONDER));
            }
        }

        /* JADX INFO: compiled from: GestureHandler.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$Factory$Companion;", "", "<init>", "()V", "KEY_SHOULD_CANCEL_WHEN_OUTSIDE", "", "KEY_ENABLED", "KEY_NEEDS_POINTER_DATA", "KEY_DISPATCHES_ANIMATED_EVENTS", "KEY_DISPATCHES_REANIMATED_EVENTS", "KEY_MANUAL_ACTIVATION", "KEY_MOUSE_BUTTON", "KEY_HIT_SLOP", "KEY_TEST_ID", "KEY_CANCELS_JS_RESPONDER", "handleHitSlopProperty", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void handleHitSlopProperty(GestureHandler handler, ReadableMap config) {
                if (config.isNull(Factory.KEY_HIT_SLOP)) {
                    handler.setHitSlop(null);
                } else {
                    if (config.getType(Factory.KEY_HIT_SLOP) == ReadableType.Number) {
                        handler.setHitSlop(Float.valueOf(PixelUtil.toPixelFromDIP(config.getDouble(Factory.KEY_HIT_SLOP))));
                        return;
                    }
                    ReadableArray array = config.getArray(Factory.KEY_HIT_SLOP);
                    Intrinsics.checkNotNull(array);
                    handler.setHitSlop(handleHitSlopProperty$edge(array, 0), handleHitSlopProperty$edge(array, 1), handleHitSlopProperty$edge(array, 2), handleHitSlopProperty$edge(array, 3), handleHitSlopProperty$edge(array, 4), handleHitSlopProperty$edge(array, 5));
                }
            }

            private static final float handleHitSlopProperty$edge(ReadableArray readableArray, int i) {
                if (readableArray.isNull(i)) {
                    return Float.NaN;
                }
                return PixelUtil.toPixelFromDIP(readableArray.getDouble(i));
            }
        }
    }

    /* JADX INFO: compiled from: GestureHandler.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\fH\u0002J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0017H\u0002J\u0010\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fJ\u000e\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010100X\u0082.¢\u0006\u0004\n\u0002\u00102R\u0018\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010400X\u0082.¢\u0006\u0004\n\u0002\u00105R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$Companion;", "", "<init>", "()V", "DEFAULT_NEEDS_POINTER_DATA", "", "DEFAULT_MANUAL_ACTIVATION", "DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE", "DEFAULT_IS_ENABLED", "DEFAULT_HIT_SLOP", "", "DEFAULT_MOUSE_BUTTON", "", "DEFAULT_DISPATCHES_ANIMATED_EVENTS", "DEFAULT_DISPATCHES_REANIMATED_EVENTS", "DEFAULT_CANCELS_JS_RESPONDER", "STATE_UNDETERMINED", "STATE_FAILED", "STATE_BEGAN", "STATE_CANCELLED", "STATE_ACTIVE", "STATE_END", "HIT_SLOP_NONE", "", "HIT_SLOP_LEFT_IDX", "HIT_SLOP_TOP_IDX", "HIT_SLOP_RIGHT_IDX", "HIT_SLOP_BOTTOM_IDX", "HIT_SLOP_WIDTH_IDX", "HIT_SLOP_HEIGHT_IDX", "DIRECTION_RIGHT", "DIRECTION_LEFT", "DIRECTION_UP", "DIRECTION_DOWN", "ACTION_TYPE_NONE", "ACTION_TYPE_REANIMATED_WORKLET", "ACTION_TYPE_NATIVE_ANIMATED_EVENT", "ACTION_TYPE_JS_FUNCTION_OLD_API", "ACTION_TYPE_JS_FUNCTION_NEW_API", "ACTION_TYPE_NATIVE_DETECTOR", "ACTION_TYPE_VIRTUAL_DETECTOR", "POINTER_TYPE_TOUCH", "POINTER_TYPE_STYLUS", "POINTER_TYPE_MOUSE", "POINTER_TYPE_KEY", "POINTER_TYPE_OTHER", "MAX_POINTERS_COUNT", "pointerProps", "", "Landroid/view/MotionEvent$PointerProperties;", "[Landroid/view/MotionEvent$PointerProperties;", "pointerCoords", "Landroid/view/MotionEvent$PointerCoords;", "[Landroid/view/MotionEvent$PointerCoords;", "initPointerProps", "", ContentDisposition.Parameters.Size, "nextEventCoalescingKey", "", "hitSlopSet", "value", "stateToString", "", "state", "usesNativeOrVirtualDetector", "actionType", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean usesNativeOrVirtualDetector(int actionType) {
            return actionType == 5 || actionType == 6;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initPointerProps(int size) {
            if (GestureHandler.pointerProps == null) {
                GestureHandler.pointerProps = new MotionEvent.PointerProperties[17];
                GestureHandler.pointerCoords = new MotionEvent.PointerCoords[17];
            }
            while (size > 0) {
                MotionEvent.PointerProperties[] pointerPropertiesArr = GestureHandler.pointerProps;
                MotionEvent.PointerCoords[] pointerCoordsArr = null;
                if (pointerPropertiesArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr = null;
                }
                int i = size - 1;
                if (pointerPropertiesArr[i] != null) {
                    return;
                }
                MotionEvent.PointerProperties[] pointerPropertiesArr2 = GestureHandler.pointerProps;
                if (pointerPropertiesArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    pointerPropertiesArr2 = null;
                }
                pointerPropertiesArr2[i] = new MotionEvent.PointerProperties();
                MotionEvent.PointerCoords[] pointerCoordsArr2 = GestureHandler.pointerCoords;
                if (pointerCoordsArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                } else {
                    pointerCoordsArr = pointerCoordsArr2;
                }
                pointerCoordsArr[i] = new MotionEvent.PointerCoords();
                size--;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hitSlopSet(float value) {
            return !Float.isNaN(value);
        }

        public final String stateToString(int state) {
            if (state == 0) {
                return "UNDETERMINED";
            }
            if (state == 1) {
                return "FAILED";
            }
            if (state == 2) {
                return "BEGIN";
            }
            if (state == 3) {
                return "CANCELLED";
            }
            if (state == 4) {
                return "ACTIVE";
            }
            if (state != 5) {
                return null;
            }
            return "END";
        }
    }

    /* JADX INFO: compiled from: GestureHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "", "pointerId", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "absoluteX", "absoluteY", "<init>", "(IFFFF)V", "getPointerId", "()I", "getX", "()F", "setX", "(F)V", "getY", "setY", "getAbsoluteX", "setAbsoluteX", "getAbsoluteY", "setAbsoluteY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class PointerData {
        private float absoluteX;
        private float absoluteY;
        private final int pointerId;
        private float x;
        private float y;

        public static /* synthetic */ PointerData copy$default(PointerData pointerData, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pointerData.pointerId;
            }
            if ((i2 & 2) != 0) {
                f = pointerData.x;
            }
            if ((i2 & 4) != 0) {
                f2 = pointerData.y;
            }
            if ((i2 & 8) != 0) {
                f3 = pointerData.absoluteX;
            }
            if ((i2 & 16) != 0) {
                f4 = pointerData.absoluteY;
            }
            float f5 = f4;
            float f6 = f2;
            return pointerData.copy(i, f, f6, f3, f5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPointerId() {
            return this.pointerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getAbsoluteX() {
            return this.absoluteX;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getAbsoluteY() {
            return this.absoluteY;
        }

        public final PointerData copy(int pointerId, float x, float y, float absoluteX, float absoluteY) {
            return new PointerData(pointerId, x, y, absoluteX, absoluteY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PointerData)) {
                return false;
            }
            PointerData pointerData = (PointerData) other;
            return this.pointerId == pointerData.pointerId && Float.compare(this.x, pointerData.x) == 0 && Float.compare(this.y, pointerData.y) == 0 && Float.compare(this.absoluteX, pointerData.absoluteX) == 0 && Float.compare(this.absoluteY, pointerData.absoluteY) == 0;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.pointerId) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.absoluteX)) * 31) + Float.hashCode(this.absoluteY);
        }

        public String toString() {
            return "PointerData(pointerId=" + this.pointerId + ", x=" + this.x + ", y=" + this.y + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ")";
        }

        public PointerData(int i, float f, float f2, float f3, float f4) {
            this.pointerId = i;
            this.x = f;
            this.y = f2;
            this.absoluteX = f3;
            this.absoluteY = f4;
        }

        public final int getPointerId() {
            return this.pointerId;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final float getAbsoluteX() {
            return this.absoluteX;
        }

        public final void setAbsoluteX(float f) {
            this.absoluteX = f;
        }

        public final float getAbsoluteY() {
            return this.absoluteY;
        }

        public final void setAbsoluteY(float f) {
            this.absoluteY = f;
        }
    }
}
