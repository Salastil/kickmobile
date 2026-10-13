package com.kick.mobile.kickivsplayerv2;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Rational;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.amazonaws.ivs.player.MediaPlayer;
import com.amazonaws.ivs.player.Player;
import com.amazonaws.ivs.player.Quality;
import com.amazonaws.ivs.player.ResizeMode;
import com.amazonaws.ivs.player.Source;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.horcrux.svg.TSpanView$$ExternalSyntheticApiModelOutline0;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.model.PlaybackMode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoView;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KickIvsPlayerV2View.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\b*\u0002TW\u0018\u0000 ç\u00012\u00020\u0001:\u0004ç\u0001è\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010Y\u001a\u00020ZH\u0014J\b\u0010[\u001a\u00020ZH\u0014J\u0006\u0010\\\u001a\u00020ZJ\u0006\u0010]\u001a\u00020ZJ\u0016\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\tJ\u0012\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010_\u001a\u00020`H\u0002J\u0006\u0010d\u001a\u00020ZJ0\u0010e\u001a\u00020Z2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010i\u001a\u00020 2\u0006\u0010j\u001a\u00020 H\u0014J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020%H\u0002J\u0010\u0010n\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010o\u001a\u00020ZH\u0002J\b\u0010p\u001a\u00020ZH\u0002J\u0010\u0010q\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010r\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J:\u0010s\u001a\u00020Z2\u0006\u0010t\u001a\u0002072\u0016\b\u0002\u0010u\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u00010w0v2\u0010\b\u0002\u0010x\u001a\n\u0018\u00010yj\u0004\u0018\u0001`zH\u0002J\u0010\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u007f\u001a\u00020}2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020Z2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0081\u0001\u001a\u00020Z2\u0007\u0010\u0082\u0001\u001a\u000207J\u0011\u0010\u0083\u0001\u001a\u00020Z2\b\u0010L\u001a\u0004\u0018\u000107J(\u0010\u0084\u0001\u001a\u00020Z2\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0086\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0087\u0001\u001a\u0004\u0018\u000107Je\u0010\u0088\u0001\u001a\u00020Z2\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0086\u0001\u001a\u0004\u0018\u0001072\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u008b\u0001\u001a\u0004\u0018\u0001072\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u008d\u0001\u001a\u0004\u0018\u0001072\t\u0010\u008e\u0001\u001a\u0004\u0018\u0001072\t\u0010\u008f\u0001\u001a\u0004\u0018\u000107¢\u0006\u0003\u0010\u0090\u0001J\u0013\u0010\u0091\u0001\u001a\u00020Z2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020ZH\u0002J\t\u0010\u0095\u0001\u001a\u00020ZH\u0002J\t\u0010\u0096\u0001\u001a\u00020ZH\u0002J\u0010\u0010\u0097\u0001\u001a\u00020Z2\u0007\u0010\u0098\u0001\u001a\u00020\tJ\u0010\u0010\u0099\u0001\u001a\u00020Z2\u0007\u0010\u009a\u0001\u001a\u00020\tJ\u0010\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u009c\u0001\u001a\u00020lJ\u0010\u0010\u009d\u0001\u001a\u00020Z2\u0007\u0010\u009e\u0001\u001a\u00020\tJ\u0010\u0010\u009f\u0001\u001a\u00020Z2\u0007\u0010 \u0001\u001a\u00020lJ\u0010\u0010¡\u0001\u001a\u00020Z2\u0007\u0010¢\u0001\u001a\u00020 J\u0011\u0010£\u0001\u001a\u00020Z2\b\u0010\u001d\u001a\u0004\u0018\u000107J\u0012\u0010¤\u0001\u001a\u00020Z2\u0007\u0010¥\u0001\u001a\u00020\u001cH\u0002J\u0016\u0010¦\u0001\u001a\u00020Z2\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\"\u0010¨\u0001\u001a\u00020\t2\u0007\u0010©\u0001\u001a\u0002072\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020Z0«\u0001H\u0002J(\u0010¬\u0001\u001a\u00020\t2\u0007\u0010©\u0001\u001a\u0002072\u0014\u0010ª\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020Z0\u00ad\u0001H\u0002J\t\u0010®\u0001\u001a\u00020ZH\u0002J\t\u0010¯\u0001\u001a\u00020ZH\u0002J\u0014\u0010°\u0001\u001a\u00020\u001e2\t\u0010±\u0001\u001a\u0004\u0018\u000107H\u0002J\u001d\u0010²\u0001\u001a\u0005\u0018\u00010³\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0007\u0010´\u0001\u001a\u00020 H\u0002J\u001d\u0010µ\u0001\u001a\u0005\u0018\u00010³\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0007\u0010¶\u0001\u001a\u000207H\u0002J\u0012\u0010·\u0001\u001a\u00020Z2\t\u0010¶\u0001\u001a\u0004\u0018\u000107J\u0017\u0010¸\u0001\u001a\u00020Z2\t\u0010´\u0001\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010QJ\u0010\u0010¹\u0001\u001a\u00020Z2\u0007\u0010º\u0001\u001a\u00020\tJ\u0010\u0010»\u0001\u001a\u00020Z2\u0007\u0010¼\u0001\u001a\u00020\tJ\u0013\u0010½\u0001\u001a\u00020Z2\b\u0010|\u001a\u0004\u0018\u00010}H\u0002J\u0010\u0010¾\u0001\u001a\u00020Z2\u0007\u0010¿\u0001\u001a\u00020%J\u001a\u0010À\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u00020%2\b\b\u0002\u0010|\u001a\u00020}J\u0010\u0010Â\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u00020 J\u000f\u0010Ã\u0001\u001a\u00020Z2\u0006\u0010a\u001a\u00020\tJ\u0019\u0010Ä\u0001\u001a\u00020Z2\u0006\u0010a\u001a\u00020\t2\u0006\u0010|\u001a\u00020}H\u0002J\u0007\u0010Å\u0001\u001a\u00020ZJ\u0007\u0010Æ\u0001\u001a\u00020ZJ\u0007\u0010Ç\u0001\u001a\u00020ZJ\u0010\u0010È\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u00020lJ\u0010\u0010É\u0001\u001a\u00020Z2\u0007\u0010Ê\u0001\u001a\u000207J\u0019\u0010Ë\u0001\u001a\u00020Z2\u0007\u0010Ì\u0001\u001a\u00020 2\u0007\u0010Í\u0001\u001a\u000207J\u0010\u0010Î\u0001\u001a\u00020Z2\u0007\u0010Ì\u0001\u001a\u00020 J\u0010\u0010Ï\u0001\u001a\u00020Z2\u0007\u0010Ì\u0001\u001a\u00020 J!\u0010Ð\u0001\u001a\u00020Z2\u0007\u0010Ñ\u0001\u001a\u00020\u00132\u0006\u0010|\u001a\u00020}2\u0007\u0010Ò\u0001\u001a\u00020%J\u0011\u0010Ó\u0001\u001a\u00020Z2\b\u0010Ô\u0001\u001a\u00030³\u0001J\u0007\u0010Õ\u0001\u001a\u00020ZJ\u0007\u0010Ö\u0001\u001a\u00020ZJ1\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\t2\f\b\u0002\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00012\f\b\u0002\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0002J\u0012\u0010Þ\u0001\u001a\u00020l2\u0007\u0010¿\u0001\u001a\u00020%H\u0002J\u0011\u0010ß\u0001\u001a\u0002072\u0006\u0010|\u001a\u00020}H\u0002J\u001e\u0010E\u001a\u00020Z2\u0010\u0010L\u001a\f\u0012\u0005\u0012\u00030á\u0001\u0018\u00010à\u0001¢\u0006\u0003\u0010â\u0001J\u0010\u0010ã\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u00020%J\u0012\u0010ä\u0001\u001a\u00020Z2\u0007\u0010Ñ\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010å\u0001\u001a\u00020Z2\u0007\u0010Ñ\u0001\u001a\u00020\u0013H\u0002J\t\u0010æ\u0001\u001a\u00020ZH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0012\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0012\u0010(\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010.\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u000200`1X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010A\u001a\b\u0012\u0004\u0012\u00020%0BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000b\"\u0004\bJ\u0010KR,\u0010M\u001a\u0004\u0018\u00010 2\b\u0010L\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u0010\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010X¨\u0006é\u0001"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View;", "Lexpo/modules/kotlin/views/ExpoView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "shouldUseAndroidLayout", "", "getShouldUseAndroidLayout", "()Z", "surfaceView", "Landroid/view/SurfaceView;", "nativePipHost", "Landroid/widget/FrameLayout;", "playerOperationExecutor", "Ljava/util/concurrent/ExecutorService;", "player", "Lcom/amazonaws/ivs/player/Player;", "isPlayerListenerAttached", "isDetached", "isReleasing", "isDestroyed", "isSurfaceHolderCallbackAttached", "streamUri", "Landroid/net/Uri;", "renderSurface", "Landroid/view/Surface;", ViewProps.RESIZE_MODE, "Lcom/amazonaws/ivs/player/ResizeMode;", "videoWidth", "", "videoHeight", "playerObserver", "Ljava/util/Timer;", "lastLiveLatency", "", "Ljava/lang/Long;", "lastBitrate", "lastDuration", "latestStreamRequestId", "activeStreamRequestId", "lastKnownPlayerState", "Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$StreamStateSnapshot;", "finishedLoading", "preloadSourceMap", "Ljava/util/HashMap;", "Lcom/amazonaws/ivs/player/Source;", "Lkotlin/collections/HashMap;", "muxAnalyticsListener", "Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsListener;", "muxAnalyticsMetadata", "Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;", "muxEnvironmentKey", "", "muxPlaybackIdentity", "pendingMuxViewSwitchUrl", "requestedMuxPlaybackMode", "Lcom/mux/stats/sdk/core/model/PlaybackMode;", "appliedMuxPlaybackMode", "isSeekingForMux", "userAgent", "datazoomAnalyticsManager", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager;", "breakpoints", "", "getBreakpoints", "()Ljava/util/List;", "setBreakpoints", "(Ljava/util/List;)V", "lastPositionInSeconds", "sendVideoStatistics", "getSendVideoStatistics", "setSendVideoStatistics", "(Z)V", "value", "maxAutoQuality", "getMaxAutoQuality", "()Ljava/lang/Integer;", "setMaxAutoQuality", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "surfaceHolderCallback", "com/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$surfaceHolderCallback$1", "Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$surfaceHolderCallback$1;", "playerListener", "com/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$playerListener$1", "Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$playerListener$1;", "onAttachedToWindow", "", "onDetachedFromWindow", "destroy", "onNativePipDismissed", "setNativePipPresentation", "activity", "Landroid/app/Activity;", "active", "getNativePipHost", "Landroid/view/ViewGroup;", "onTaskRemovedFromRecents", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "convertMilliSecondsToSeconds", "", "milliSeconds", "createPlayer", "addSurfaceHolderCallbackIfNeeded", "removeSurfaceHolderCallbackIfNeeded", "addPlayerListenerIfNeeded", "removePlayerListenerIfNeeded", "sendNativeWarn", "message", "metadata", "", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isSafeReleaseState", "state", "Lcom/amazonaws/ivs/player/Player$State;", "pauseForReleaseIfNeeded", "waitForSafeReleaseState", "releasePlayer", "setStreamUrl", "streamUrl", "setUserAgent", "setMuxAnalyticsConfig", "environmentKey", "metadataJson", "playbackMode", "setDatazoomAnalyticsConfig", "configurationId", "isProduction", "mediaTailorContentUrl", "mediaTailorIsLivestream", "mediaTailorPalNonce", "mediaTailorTrackingUrl", "mediaTailorUserAgent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendDatazoomAnalyticsEvent", "event", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsEventConfig;", "initializeMuxAnalyticsListener", "replayPlayerStateIntoMuxListener", "updateMuxPlaybackMode", "setMuted", "muted", "setLooping", "shouldLoop", "setVolume", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "setRebufferToLive", "rebufferToLive", "setPlaybackRate", "playbackRate", "setLogLevel", "logLevel", "setResizeMode", "attachRenderSurface", "surface", "clearRenderSurface", "surfaceToClear", "executeOnPlayerExecutor", "operationName", "operation", "Lkotlin/Function0;", "executePlayerOperation", "Lkotlin/Function1;", "updateSurfaceViewBufferSize", "updateSurfaceViewTransform", "findResizeMode", "mode", "findQualityByHeight", "Lcom/amazonaws/ivs/player/Quality;", "qualityHeight", "findQuality", "qualityName", "setQuality", "setAutoMaxQuality", "setAutoQualityMode", "autoQualityMode", "setPipEnabled", "newValue", "syncAudioService", "onDurationChange", "duration", "onSeek", ViewProps.POSITION, "onProgress", "onNativePipStateChanged", "onPipChange", PlayEvent.TYPE, PauseEvent.TYPE, "pauseForSeeking", "seekTo", "setOrigin", "origin", LinkHeader.Rel.PreLoad, "id", ImagesContract.URL, "loadSource", "releaseSource", "onPlayerStateChange", "currentPlayer", "streamRequestId", "onQualityChange", "quality", "onPlayerRebuffering", "togglePip", "updatePipParams", "Landroid/app/PictureInPictureParams;", "autoEnterEnabled", "rect", "Landroid/graphics/Rect;", ViewProps.ASPECT_RATIO, "Landroid/util/Rational;", "getDuration", "mapPlayerState", "", "", "([Ljava/lang/Float;)V", "onTimePoint", "handlePositionChange", "handlePlayerStatistics", "playerObserverCallback", "Companion", "StreamStateSnapshot", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIvsPlayerV2View extends ExpoView {
    private static final long PLAYER_OBSERVER_INTERVAL_MS = 1000;
    private static final long RELEASE_STATE_POLL_MS = 50;
    private static final long RELEASE_STATE_WAIT_MS = 1000;
    private volatile long activeStreamRequestId;
    private PlaybackMode appliedMuxPlaybackMode;
    private List<Long> breakpoints;
    private final DatazoomAnalyticsManager datazoomAnalyticsManager;
    private boolean finishedLoading;
    private volatile boolean isDestroyed;
    private volatile boolean isDetached;
    private volatile boolean isPlayerListenerAttached;
    private volatile boolean isReleasing;
    private boolean isSeekingForMux;
    private boolean isSurfaceHolderCallbackAttached;
    private volatile Long lastBitrate;
    private volatile Long lastDuration;
    private volatile StreamStateSnapshot lastKnownPlayerState;
    private volatile Long lastLiveLatency;
    private int lastPositionInSeconds;
    private volatile long latestStreamRequestId;
    private Integer maxAutoQuality;
    private volatile MuxAnalyticsListener muxAnalyticsListener;
    private MuxAnalyticsMetadata muxAnalyticsMetadata;
    private String muxEnvironmentKey;
    private String muxPlaybackIdentity;
    private final FrameLayout nativePipHost;
    private String pendingMuxViewSwitchUrl;
    private volatile Player player;
    private final KickIvsPlayerV2View$playerListener$1 playerListener;
    private Timer playerObserver;
    private final ExecutorService playerOperationExecutor;
    private final HashMap<Integer, Source> preloadSourceMap;
    private volatile Surface renderSurface;
    private PlaybackMode requestedMuxPlaybackMode;
    private ResizeMode resizeMode;
    private boolean sendVideoStatistics;
    private final boolean shouldUseAndroidLayout;
    private Uri streamUri;
    private final KickIvsPlayerV2View$surfaceHolderCallback$1 surfaceHolderCallback;
    private final SurfaceView surfaceView;
    private volatile String userAgent;
    private volatile int videoHeight;
    private volatile int videoWidth;

    /* JADX INFO: compiled from: KickIvsPlayerV2View.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Player.State.values().length];
            try {
                iArr[Player.State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Player.State.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Player.State.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Player.State.BUFFERING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Player.State.ENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final double convertMilliSecondsToSeconds(long milliSeconds) {
        return milliSeconds / 1000.0d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$surfaceHolderCallback$1] */
    public KickIvsPlayerV2View(final Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.shouldUseAndroidLayout = true;
        SurfaceView surfaceView = new SurfaceView(context);
        this.surfaceView = surfaceView;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(-16777216);
        this.nativePipHost = frameLayout;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return KickIvsPlayerV2View.playerOperationExecutor$lambda$0(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.playerOperationExecutor = executorServiceNewSingleThreadExecutor;
        this.resizeMode = ResizeMode.FIT;
        this.lastKnownPlayerState = new StreamStateSnapshot(Player.State.IDLE, this.latestStreamRequestId);
        this.preloadSourceMap = new HashMap<>();
        this.requestedMuxPlaybackMode = PlaybackMode.INLINE;
        DatazoomAnalyticsManager datazoomAnalyticsManager = new DatazoomAnalyticsManager();
        this.datazoomAnalyticsManager = datazoomAnalyticsManager;
        datazoomAnalyticsManager.setOnMuxAdEvent(new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View._init_$lambda$0(this.f$0, (MuxAdEventData) obj);
            }
        });
        this.breakpoints = CollectionsKt.emptyList();
        this.surfaceHolderCallback = new SurfaceHolder.Callback() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$surfaceHolderCallback$1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                KickIvsPlayerV2View kickIvsPlayerV2View = this.this$0;
                Surface surface = holder.getSurface();
                Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
                kickIvsPlayerV2View.attachRenderSurface(surface);
                this.this$0.updateSurfaceViewTransform();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                this.this$0.updateSurfaceViewTransform();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                this.this$0.clearRenderSurface(holder.getSurface());
            }
        };
        this.playerListener = new KickIvsPlayerV2View$playerListener$1(this);
        KickIvsPlayerV2Manager.INSTANCE.setViewId(Integer.valueOf(getId()));
        surfaceView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setKeepScreenOn(true);
        surfaceView.setKeepScreenOn(true);
        addSurfaceHolderCallbackIfNeeded();
        addView(surfaceView);
        executeOnPlayerExecutor("createPlayer", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View._init_$lambda$1(this.f$0, context);
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoView
    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    /* JADX INFO: compiled from: KickIvsPlayerV2View.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2View$StreamStateSnapshot;", "", "state", "Lcom/amazonaws/ivs/player/Player$State;", "streamRequestId", "", "<init>", "(Lcom/amazonaws/ivs/player/Player$State;J)V", "getState", "()Lcom/amazonaws/ivs/player/Player$State;", "getStreamRequestId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class StreamStateSnapshot {
        private final Player.State state;
        private final long streamRequestId;

        public static /* synthetic */ StreamStateSnapshot copy$default(StreamStateSnapshot streamStateSnapshot, Player.State state, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                state = streamStateSnapshot.state;
            }
            if ((i & 2) != 0) {
                j = streamStateSnapshot.streamRequestId;
            }
            return streamStateSnapshot.copy(state, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Player.State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStreamRequestId() {
            return this.streamRequestId;
        }

        public final StreamStateSnapshot copy(Player.State state, long streamRequestId) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new StreamStateSnapshot(state, streamRequestId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamStateSnapshot)) {
                return false;
            }
            StreamStateSnapshot streamStateSnapshot = (StreamStateSnapshot) other;
            return this.state == streamStateSnapshot.state && this.streamRequestId == streamStateSnapshot.streamRequestId;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + Long.hashCode(this.streamRequestId);
        }

        public String toString() {
            return "StreamStateSnapshot(state=" + this.state + ", streamRequestId=" + this.streamRequestId + ")";
        }

        public StreamStateSnapshot(Player.State state, long j) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.streamRequestId = j;
        }

        public final Player.State getState() {
            return this.state;
        }

        public final long getStreamRequestId() {
            return this.streamRequestId;
        }
    }

    static final Thread playerOperationExecutor$lambda$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "KickIvsPlayerV2Player");
        thread.setDaemon(true);
        return thread;
    }

    static final Unit _init_$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, MuxAdEventData event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MuxAnalyticsListener muxAnalyticsListener = kickIvsPlayerV2View.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.dispatchAdEvent(event);
        }
        return Unit.INSTANCE;
    }

    public final List<Long> getBreakpoints() {
        return this.breakpoints;
    }

    public final void setBreakpoints(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.breakpoints = list;
    }

    public final boolean getSendVideoStatistics() {
        return this.sendVideoStatistics;
    }

    public final void setSendVideoStatistics(boolean z) {
        this.sendVideoStatistics = z;
    }

    public final Integer getMaxAutoQuality() {
        Integer num = this.maxAutoQuality;
        if (num == null) {
            return 720;
        }
        return num;
    }

    public final void setMaxAutoQuality(Integer num) {
        this.maxAutoQuality = num;
        setAutoMaxQuality(num);
    }

    static final Unit _init_$lambda$1(KickIvsPlayerV2View kickIvsPlayerV2View, Context context) {
        Player playerCreatePlayer = kickIvsPlayerV2View.createPlayer(context);
        playerCreatePlayer.setLiveLowLatencyEnabled(true);
        kickIvsPlayerV2View.player = playerCreatePlayer;
        if (kickIvsPlayerV2View.isDetached) {
            kickIvsPlayerV2View.player = null;
            playerCreatePlayer.release();
        } else {
            kickIvsPlayerV2View.addPlayerListenerIfNeeded(playerCreatePlayer);
        }
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.isDestroyed) {
            super.onAttachedToWindow();
            return;
        }
        this.isDetached = false;
        KickIvsPlayerV2Manager.INSTANCE.setViewId(Integer.valueOf(getId()));
        addSurfaceHolderCallbackIfNeeded();
        executePlayerOperation("addListener", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.onAttachedToWindow$lambda$0(this.f$0, (Player) obj);
            }
        });
        Surface surface = this.surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid() && this.renderSurface == null) {
            attachRenderSurface(surface);
        }
        updatePipParams$default(this, KickIvsPlayerV2Manager.INSTANCE.getPipEnabled(), null, null, 6, null);
        updateSurfaceViewTransform();
        Timer timer = new Timer("observerInterval", false);
        this.playerObserver = timer;
        timer.schedule(new TimerTask() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$onAttachedToWindow$$inlined$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.playerObserverCallback();
            }
        }, 0L, 1000L);
        super.onAttachedToWindow();
    }

    static final Unit onAttachedToWindow$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        kickIvsPlayerV2View.addPlayerListenerIfNeeded(currentPlayer);
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public final void destroy() {
        if (this.isDestroyed) {
            return;
        }
        this.isDestroyed = true;
        this.isDetached = true;
        this.isReleasing = true;
        ViewParent parent = this.surfaceView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.surfaceView);
        }
        ViewParent parent2 = this.nativePipHost.getParent();
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.nativePipHost);
        }
        Timer timer = this.playerObserver;
        if (timer != null) {
            timer.cancel();
        }
        this.playerObserver = null;
        AudioService.Companion companion = AudioService.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        companion.stop(context);
        updatePipParams$default(this, false, null, null, 6, null);
        removeSurfaceHolderCallbackIfNeeded();
        this.renderSurface = null;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.release();
        }
        this.muxAnalyticsListener = null;
        this.pendingMuxViewSwitchUrl = null;
        this.datazoomAnalyticsManager.setOnMuxAdEvent(null);
        this.datazoomAnalyticsManager.release();
        PalSDKManager.INSTANCE.resetSession();
        if (!executeOnPlayerExecutor("releasePlayer", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View.destroy$lambda$0(this.f$0);
            }
        })) {
            this.playerOperationExecutor.shutdown();
        }
        KickIvsPlayerV2Manager.INSTANCE.destroy();
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity == null || !currentActivity.isInPictureInPictureMode()) {
            return;
        }
        currentActivity.moveTaskToBack(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    static final Unit destroy$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View) throws Throwable {
        ?? r3;
        Player player = ((KickIvsPlayerV2View) kickIvsPlayerV2View).player;
        ((KickIvsPlayerV2View) kickIvsPlayerV2View).player = null;
        try {
            for (Source source : ((KickIvsPlayerV2View) kickIvsPlayerV2View).preloadSourceMap.values()) {
                r3 = "next(...)";
                Intrinsics.checkNotNullExpressionValue(source, "next(...)");
                try {
                    source.release();
                } catch (Exception e) {
                    r3 = kickIvsPlayerV2View;
                    try {
                        sendNativeWarn$default(r3, "Unable to release preloaded IVS source", null, e, 2, null);
                        kickIvsPlayerV2View = r3;
                    } catch (Throwable th) {
                        th = th;
                        ((KickIvsPlayerV2View) r3).playerOperationExecutor.shutdown();
                        throw th;
                    }
                }
            }
            r3 = kickIvsPlayerV2View;
            ((KickIvsPlayerV2View) r3).preloadSourceMap.clear();
            if (player != null) {
                r3.releasePlayer(player);
            }
            ((KickIvsPlayerV2View) r3).playerOperationExecutor.shutdown();
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            r3 = kickIvsPlayerV2View;
        }
    }

    public final void onNativePipDismissed() {
        if (this.isDestroyed) {
            return;
        }
        pause();
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.release();
        }
        this.muxAnalyticsListener = null;
        this.muxPlaybackIdentity = null;
        this.pendingMuxViewSwitchUrl = null;
        this.appliedMuxPlaybackMode = null;
        this.datazoomAnalyticsManager.release();
        PalSDKManager.INSTANCE.resetSession();
    }

    public final void setNativePipPresentation(Activity activity, boolean active) {
        KickIvsPlayerV2View nativePipHost;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isDestroyed) {
            return;
        }
        if (active) {
            nativePipHost = getNativePipHost(activity);
            if (nativePipHost == null) {
                return;
            }
        } else {
            nativePipHost = this;
        }
        if (this.surfaceView.getParent() == nativePipHost) {
            if (active) {
                return;
            }
            ViewParent parent = this.nativePipHost.getParent();
            viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.nativePipHost);
                return;
            }
            return;
        }
        ViewParent parent2 = this.surfaceView.getParent();
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.surfaceView);
        }
        nativePipHost.addView(this.surfaceView, new ViewGroup.LayoutParams(-1, -1));
        if (!active) {
            ViewParent parent3 = this.nativePipHost.getParent();
            viewGroup = parent3 instanceof ViewGroup ? (ViewGroup) parent3 : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.nativePipHost);
            }
        }
        updateSurfaceViewTransform();
    }

    private final ViewGroup getNativePipHost(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        if (viewGroup == null) {
            return null;
        }
        ViewParent parent = this.nativePipHost.getParent();
        FrameLayout frameLayout = this.nativePipHost;
        if (parent == viewGroup) {
            return frameLayout;
        }
        ViewParent parent2 = frameLayout.getParent();
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.nativePipHost);
        }
        viewGroup.addView(this.nativePipHost, new ViewGroup.LayoutParams(-1, -1));
        return this.nativePipHost;
    }

    public final void onTaskRemovedFromRecents() {
        if (this.isDestroyed) {
            return;
        }
        updatePipParams$default(this, false, null, null, 6, null);
        syncAudioService(null);
        executePlayerOperation("pauseForTaskRemoved", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.onTaskRemovedFromRecents$lambda$0((Player) obj);
            }
        });
    }

    static final Unit onTaskRemovedFromRecents$lambda$0(Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.pause();
        return Unit.INSTANCE;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (!this.isDestroyed && changed) {
            updateSurfaceViewTransform();
            if (KickIvsPlayerV2Manager.INSTANCE.getPipEnabled()) {
                updatePipParams$default(this, true, new Rect(left, top, right, bottom), null, 4, null);
            }
            MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
            if (muxAnalyticsListener != null) {
                muxAnalyticsListener.updatePlayerViewSize(right - left, bottom - top);
            }
        }
    }

    private final Player createPlayer(Context context) {
        Player playerCreate = Player.Factory.create(context);
        Intrinsics.checkNotNullExpressionValue(playerCreate, "create(...)");
        String str = this.userAgent;
        if (str != null) {
            playerCreate.setUserAgent(str);
        }
        return playerCreate;
    }

    private final void addSurfaceHolderCallbackIfNeeded() {
        if (this.isSurfaceHolderCallbackAttached) {
            return;
        }
        this.surfaceView.getHolder().addCallback(this.surfaceHolderCallback);
        this.isSurfaceHolderCallbackAttached = true;
    }

    private final void removeSurfaceHolderCallbackIfNeeded() {
        if (this.isSurfaceHolderCallbackAttached) {
            this.surfaceView.getHolder().removeCallback(this.surfaceHolderCallback);
            this.isSurfaceHolderCallbackAttached = false;
        }
    }

    private final void addPlayerListenerIfNeeded(Player player) {
        if (this.isPlayerListenerAttached) {
            return;
        }
        player.addListener(this.playerListener);
        this.isPlayerListenerAttached = true;
    }

    private final void removePlayerListenerIfNeeded(Player player) {
        if (this.isPlayerListenerAttached) {
            player.removeListener(this.playerListener);
            this.isPlayerListenerAttached = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void sendNativeWarn$default(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Map map, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 4) != 0) {
            exc = null;
        }
        kickIvsPlayerV2View.sendNativeWarn(str, map, exc);
    }

    private final void sendNativeWarn(String message, Map<String, ? extends Object> metadata, Exception error) {
        if (error != null) {
            metadata = MapsKt.plus(metadata, MapsKt.mapOf(TuplesKt.to("exceptionClass", error.getClass().getSimpleName()), TuplesKt.to("exceptionMessage", error.getMessage())));
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onLog", MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.LEVEL, "warn"), TuplesKt.to("message", message), TuplesKt.to("metadata", metadata)));
        }
    }

    private final boolean isSafeReleaseState(Player.State state) {
        return state == Player.State.IDLE || state == Player.State.READY || state == Player.State.ENDED;
    }

    private final void pauseForReleaseIfNeeded(Player player) {
        Player.State state = player.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        if (state == Player.State.PLAYING || state == Player.State.BUFFERING) {
            player.pause();
        }
    }

    private final Player.State waitForSafeReleaseState(Player player) {
        Player.State state = player.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        long jCurrentTimeMillis = System.currentTimeMillis() + 1000;
        while (!isSafeReleaseState(state) && System.currentTimeMillis() < jCurrentTimeMillis) {
            try {
                Thread.sleep(50L);
                state = player.getState();
                Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return state;
    }

    private final void releasePlayer(Player player) {
        KickIvsPlayerV2View kickIvsPlayerV2View;
        try {
            removePlayerListenerIfNeeded(player);
            kickIvsPlayerV2View = this;
        } catch (Exception e) {
            sendNativeWarn$default(this, "Unable to remove IVS player listener before release", null, e, 2, null);
            kickIvsPlayerV2View = this;
        }
        Player.State stateWaitForSafeReleaseState = null;
        try {
            player.setSurface(null);
        } catch (Exception e2) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Unable to clear IVS player surface before release", null, e2, 2, null);
        }
        try {
            kickIvsPlayerV2View.pauseForReleaseIfNeeded(player);
        } catch (Exception e3) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Unable to pause IVS player before release", null, e3, 2, null);
        }
        try {
            stateWaitForSafeReleaseState = kickIvsPlayerV2View.waitForSafeReleaseState(player);
        } catch (Exception e4) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Unable to verify IVS player state before release", null, e4, 2, null);
        }
        if (stateWaitForSafeReleaseState == null) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Releasing IVS player without a known state", null, null, 6, null);
        } else if (!kickIvsPlayerV2View.isSafeReleaseState(stateWaitForSafeReleaseState)) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Releasing IVS player from unsafe state after timeout", MapsKt.mapOf(TuplesKt.to("state", stateWaitForSafeReleaseState.name())), null, 4, null);
        }
        try {
            player.release();
        } catch (Exception e5) {
            sendNativeWarn$default(kickIvsPlayerV2View, "Unable to release IVS player", null, e5, 2, null);
        }
    }

    public final void setStreamUrl(String streamUrl) {
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        if (this.isDestroyed) {
            return;
        }
        final Uri uri = Uri.parse(streamUrl);
        this.streamUri = uri;
        this.latestStreamRequestId++;
        final long j = this.latestStreamRequestId;
        this.finishedLoading = false;
        this.lastKnownPlayerState = new StreamStateSnapshot(Player.State.IDLE, j);
        if (Intrinsics.areEqual(this.pendingMuxViewSwitchUrl, streamUrl)) {
            MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
            if (muxAnalyticsListener != null) {
                muxAnalyticsListener.release();
            }
            this.muxAnalyticsListener = null;
            this.muxPlaybackIdentity = null;
            this.pendingMuxViewSwitchUrl = null;
            this.appliedMuxPlaybackMode = null;
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.updateSourceUrl(streamUrl);
        }
        MuxAnalyticsListener muxAnalyticsListener3 = this.muxAnalyticsListener;
        if (muxAnalyticsListener3 != null) {
            muxAnalyticsListener3.dispatchPlay();
        }
        if (this.pendingMuxViewSwitchUrl == null) {
            initializeMuxAnalyticsListener();
        }
        executePlayerOperation("load", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setStreamUrl$lambda$0(this.f$0, j, uri, (Player) obj);
            }
        });
    }

    static final Unit setStreamUrl$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, long j, Uri uri, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        String str = kickIvsPlayerV2View.userAgent;
        if (str != null) {
            currentPlayer.setUserAgent(str);
        }
        kickIvsPlayerV2View.activeStreamRequestId = j;
        currentPlayer.load(uri);
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onLoadStart", MapsKt.emptyMap());
        }
        return Unit.INSTANCE;
    }

    public final void setUserAgent(String value) {
        String string;
        String str = null;
        if (value != null && (string = StringsKt.trim((CharSequence) value).toString()) != null && string.length() > 0) {
            str = string;
        }
        this.userAgent = str;
        executePlayerOperation("setUserAgent", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setUserAgent$lambda$1(this.f$0, (Player) obj);
            }
        });
    }

    static final Unit setUserAgent$lambda$1(KickIvsPlayerV2View kickIvsPlayerV2View, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        String str = kickIvsPlayerV2View.userAgent;
        if (str != null) {
            currentPlayer.setUserAgent(str);
        }
        return Unit.INSTANCE;
    }

    public final void setMuxAnalyticsConfig(String environmentKey, String metadataJson, String playbackMode) {
        PlaybackMode playbackMode2;
        String str;
        if (this.isDestroyed) {
            return;
        }
        String str2 = (environmentKey == null || StringsKt.isBlank(environmentKey)) ? null : environmentKey;
        String str3 = this.muxEnvironmentKey;
        if (str3 == null || StringsKt.isBlank(str3)) {
            str3 = null;
        }
        boolean zAreEqual = Intrinsics.areEqual(str2, str3);
        MuxAnalyticsMetadata muxAnalyticsMetadataFromJson = MuxAnalyticsMetadata.INSTANCE.fromJson(metadataJson);
        String strPlaybackIdentity = muxAnalyticsMetadataFromJson != null ? muxAnalyticsMetadataFromJson.playbackIdentity() : null;
        boolean z = (!zAreEqual || (str = this.muxPlaybackIdentity) == null || strPlaybackIdentity == null || Intrinsics.areEqual(str, strPlaybackIdentity)) ? false : true;
        this.muxEnvironmentKey = environmentKey;
        this.muxAnalyticsMetadata = muxAnalyticsMetadataFromJson;
        if (Intrinsics.areEqual(playbackMode, "fullscreen")) {
            playbackMode2 = PlaybackMode.FULLSCREEN;
        } else {
            playbackMode2 = Intrinsics.areEqual(playbackMode, "miniplayer") ? PlaybackMode.MINI_PLAYER : PlaybackMode.INLINE;
        }
        this.requestedMuxPlaybackMode = playbackMode2;
        if (!zAreEqual) {
            MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
            if (muxAnalyticsListener != null) {
                muxAnalyticsListener.release();
            }
            this.muxAnalyticsListener = null;
            this.muxPlaybackIdentity = null;
            this.pendingMuxViewSwitchUrl = null;
            this.appliedMuxPlaybackMode = null;
        }
        if (str2 == null) {
            return;
        }
        if (z) {
            if ((muxAnalyticsMetadataFromJson != null ? muxAnalyticsMetadataFromJson.getStreamUrl() : null) != null) {
                Uri uri = this.streamUri;
                if (!Intrinsics.areEqual(uri != null ? uri.toString() : null, muxAnalyticsMetadataFromJson.getStreamUrl())) {
                    this.pendingMuxViewSwitchUrl = muxAnalyticsMetadataFromJson.getStreamUrl();
                    return;
                }
            }
        }
        if (z) {
            MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
            if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.release();
            }
            this.muxAnalyticsListener = null;
            this.muxPlaybackIdentity = null;
            this.appliedMuxPlaybackMode = null;
        }
        this.pendingMuxViewSwitchUrl = null;
        initializeMuxAnalyticsListener();
        updateMuxPlaybackMode();
    }

    public final void setDatazoomAnalyticsConfig(String configurationId, String metadataJson, Boolean isProduction, String mediaTailorContentUrl, Boolean mediaTailorIsLivestream, String mediaTailorPalNonce, String mediaTailorTrackingUrl, String mediaTailorUserAgent) {
        String str;
        if (this.isDestroyed) {
            return;
        }
        String str2 = configurationId;
        final DatazoomAnalyticsConfig datazoomAnalyticsConfig = null;
        DatazoomMediaTailorConfig datazoomMediaTailorConfig = null;
        datazoomAnalyticsConfig = null;
        datazoomAnalyticsConfig = null;
        datazoomAnalyticsConfig = null;
        if (str2 != null && !StringsKt.isBlank(str2) && (str = metadataJson) != null && !StringsKt.isBlank(str)) {
            boolean zBooleanValue = isProduction != null ? isProduction.booleanValue() : true;
            if (mediaTailorContentUrl != null) {
                datazoomMediaTailorConfig = new DatazoomMediaTailorConfig(mediaTailorContentUrl, mediaTailorIsLivestream != null ? mediaTailorIsLivestream.booleanValue() : false, mediaTailorPalNonce, mediaTailorTrackingUrl, mediaTailorUserAgent);
            }
            datazoomAnalyticsConfig = new DatazoomAnalyticsConfig(configurationId, metadataJson, zBooleanValue, datazoomMediaTailorConfig);
        }
        executeOnPlayerExecutor("setDatazoomAnalyticsConfig", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View.setDatazoomAnalyticsConfig$lambda$1(this.f$0, datazoomAnalyticsConfig);
            }
        });
    }

    static final Unit setDatazoomAnalyticsConfig$lambda$1(KickIvsPlayerV2View kickIvsPlayerV2View, DatazoomAnalyticsConfig datazoomAnalyticsConfig) {
        Player player = kickIvsPlayerV2View.player;
        if (datazoomAnalyticsConfig == null || player == null || kickIvsPlayerV2View.isDetached || kickIvsPlayerV2View.isReleasing) {
            kickIvsPlayerV2View.datazoomAnalyticsManager.release();
            return Unit.INSTANCE;
        }
        kickIvsPlayerV2View.datazoomAnalyticsManager.apply(datazoomAnalyticsConfig, player, kickIvsPlayerV2View);
        return Unit.INSTANCE;
    }

    public final void sendDatazoomAnalyticsEvent(final DatazoomAnalyticsEventConfig event) {
        if (this.isDestroyed) {
            return;
        }
        executeOnPlayerExecutor("sendDatazoomAnalyticsEvent", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View.sendDatazoomAnalyticsEvent$lambda$0(this.f$0, event);
            }
        });
    }

    static final Unit sendDatazoomAnalyticsEvent$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, DatazoomAnalyticsEventConfig datazoomAnalyticsEventConfig) {
        kickIvsPlayerV2View.datazoomAnalyticsManager.sendEvent(datazoomAnalyticsEventConfig);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void initializeMuxAnalyticsListener() {
        MuxAnalyticsMetadata muxAnalyticsMetadata;
        MuxAnalyticsListener muxAnalyticsListener;
        String string;
        MuxAnalyticsListener muxAnalyticsListener2;
        MuxAnalyticsListener muxAnalyticsListener3;
        if (this.isDestroyed) {
            return;
        }
        Long l = null;
        l = null;
        if (this.muxAnalyticsListener != null) {
            MuxAnalyticsMetadata muxAnalyticsMetadata2 = this.muxAnalyticsMetadata;
            if (muxAnalyticsMetadata2 != null && (muxAnalyticsListener3 = this.muxAnalyticsListener) != null) {
                muxAnalyticsListener3.updateCustomerData(muxAnalyticsMetadata2);
            }
            if (this.muxPlaybackIdentity == null) {
                MuxAnalyticsMetadata muxAnalyticsMetadata3 = this.muxAnalyticsMetadata;
                this.muxPlaybackIdentity = muxAnalyticsMetadata3 != null ? muxAnalyticsMetadata3.playbackIdentity() : null;
                return;
            }
            return;
        }
        String str = this.muxEnvironmentKey;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str == null || (muxAnalyticsMetadata = this.muxAnalyticsMetadata) == null) {
                return;
            }
            Context applicationContext = getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.muxAnalyticsListener = new MuxAnalyticsListener(applicationContext, "android_ivs", str, muxAnalyticsMetadata);
            MuxAnalyticsMetadata muxAnalyticsMetadata4 = this.muxAnalyticsMetadata;
            this.muxPlaybackIdentity = muxAnalyticsMetadata4 != null ? muxAnalyticsMetadata4.playbackIdentity() : null;
            MuxAnalyticsListener muxAnalyticsListener4 = this.muxAnalyticsListener;
            if (muxAnalyticsListener4 != null) {
                muxAnalyticsListener4.updatePlayerViewSize(getWidth(), getHeight());
            }
            MuxAnalyticsListener muxAnalyticsListener5 = this.muxAnalyticsListener;
            if (muxAnalyticsListener5 != null) {
                muxAnalyticsListener5.updateSourceSize(this.videoWidth, this.videoHeight);
            }
            MuxAnalyticsListener muxAnalyticsListener6 = this.muxAnalyticsListener;
            if (muxAnalyticsListener6 != null) {
                Long l2 = this.lastDuration;
                if (l2 != null && l2.longValue() > 0) {
                    l = l2;
                }
                muxAnalyticsListener6.updateSourceDuration(l);
            }
            MuxAnalyticsListener muxAnalyticsListener7 = this.muxAnalyticsListener;
            if (muxAnalyticsListener7 != null) {
                muxAnalyticsListener7.updateCustomerData(muxAnalyticsMetadata);
            }
            Uri uri = this.streamUri;
            if (uri != null && (string = uri.toString()) != null && (muxAnalyticsListener2 = this.muxAnalyticsListener) != null) {
                muxAnalyticsListener2.updateSourceUrl(string);
            }
            updateMuxPlaybackMode();
            if (this.streamUri != null && (muxAnalyticsListener = this.muxAnalyticsListener) != null) {
                muxAnalyticsListener.dispatchPlay();
            }
            replayPlayerStateIntoMuxListener();
        }
    }

    private final void replayPlayerStateIntoMuxListener() {
        MuxAnalyticsListener muxAnalyticsListener;
        StreamStateSnapshot streamStateSnapshot = this.lastKnownPlayerState;
        if (streamStateSnapshot.getStreamRequestId() != this.latestStreamRequestId) {
            return;
        }
        Player.State state = streamStateSnapshot.getState();
        boolean z = false;
        boolean z2 = (state != Player.State.BUFFERING || KickIvsPlayerV2Manager.INSTANCE.isNativePipActive() || this.isSeekingForMux) ? false : true;
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            if (!this.isSeekingForMux && state != Player.State.PLAYING && state != Player.State.BUFFERING) {
                z = true;
            }
            muxAnalyticsListener2.updatePlaybackState(z, z2);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i == 2 && (muxAnalyticsListener = this.muxAnalyticsListener) != null) {
                muxAnalyticsListener.dispatchPlaying();
                return;
            }
            return;
        }
        MuxAnalyticsListener muxAnalyticsListener3 = this.muxAnalyticsListener;
        if (muxAnalyticsListener3 != null) {
            muxAnalyticsListener3.dispatchPlayerReady();
        }
    }

    private final void updateMuxPlaybackMode() {
        PlaybackMode playbackMode;
        if (KickIvsPlayerV2Manager.INSTANCE.isNativePipActive()) {
            playbackMode = PlaybackMode.PICTURE_IN_PICTURE;
        } else {
            playbackMode = this.requestedMuxPlaybackMode;
        }
        if (this.appliedMuxPlaybackMode == playbackMode) {
            return;
        }
        this.appliedMuxPlaybackMode = playbackMode;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updatePlaybackMode(playbackMode);
        }
    }

    public final void setMuted(final boolean muted) {
        executePlayerOperation("setMuted", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setMuted$lambda$0(muted, (Player) obj);
            }
        });
    }

    static final Unit setMuted$lambda$0(boolean z, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setMuted(z);
        return Unit.INSTANCE;
    }

    public final void setLooping(final boolean shouldLoop) {
        executePlayerOperation("setLooping", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setLooping$lambda$0(shouldLoop, (Player) obj);
            }
        });
    }

    static final Unit setLooping$lambda$0(boolean z, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setLooping(z);
        return Unit.INSTANCE;
    }

    public final void setVolume(final double volume) {
        executePlayerOperation("setVolume", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setVolume$lambda$0(volume, (Player) obj);
            }
        });
    }

    static final Unit setVolume$lambda$0(double d, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setVolume((float) d);
        return Unit.INSTANCE;
    }

    public final void setRebufferToLive(final boolean rebufferToLive) {
        executePlayerOperation("setRebufferToLive", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setRebufferToLive$lambda$0(rebufferToLive, (Player) obj);
            }
        });
    }

    static final Unit setRebufferToLive$lambda$0(boolean z, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setRebufferToLive(z);
        return Unit.INSTANCE;
    }

    public final void setPlaybackRate(final double playbackRate) {
        executePlayerOperation("setPlaybackRate", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setPlaybackRate$lambda$0(playbackRate, (Player) obj);
            }
        });
    }

    static final Unit setPlaybackRate$lambda$0(double d, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setPlaybackRate((float) d);
        return Unit.INSTANCE;
    }

    public final void setLogLevel(final int logLevel) {
        executePlayerOperation("setLogLevel", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setLogLevel$lambda$0(logLevel, (Player) obj);
            }
        });
    }

    static final Unit setLogLevel$lambda$0(int i, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        if (i == 0) {
            currentPlayer.setLogLevel(Player.LogLevel.DEBUG);
        } else if (i == 1) {
            currentPlayer.setLogLevel(Player.LogLevel.INFO);
        } else if (i == 2) {
            currentPlayer.setLogLevel(Player.LogLevel.WARNING);
        } else if (i == 3) {
            currentPlayer.setLogLevel(Player.LogLevel.ERROR);
        }
        return Unit.INSTANCE;
    }

    public final void setResizeMode(String resizeMode) {
        this.resizeMode = findResizeMode(resizeMode);
        updateSurfaceViewTransform();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachRenderSurface(final Surface surface) {
        clearRenderSurface$default(this, null, 1, null);
        updateSurfaceViewBufferSize();
        if (this.isDetached || !surface.isValid()) {
            return;
        }
        this.renderSurface = surface;
        executePlayerOperation("setSurface", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.attachRenderSurface$lambda$0(this.f$0, surface, (Player) obj);
            }
        });
    }

    static final Unit attachRenderSurface$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Surface surface, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        if (kickIvsPlayerV2View.renderSurface == surface && !kickIvsPlayerV2View.isDetached) {
            currentPlayer.setSurface(surface);
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void clearRenderSurface$default(KickIvsPlayerV2View kickIvsPlayerV2View, Surface surface, int i, Object obj) {
        if ((i & 1) != 0) {
            surface = null;
        }
        kickIvsPlayerV2View.clearRenderSurface(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearRenderSurface(Surface surfaceToClear) {
        Surface surface = this.renderSurface;
        if (surfaceToClear == null || surface == surfaceToClear) {
            this.renderSurface = null;
            if (surface == null || executeOnPlayerExecutor("clearSurface", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return KickIvsPlayerV2View.clearRenderSurface$lambda$0(this.f$0);
                }
            })) {
                return;
            }
            sendNativeWarn$default(this, "Unable to enqueue surface clear", null, null, 6, null);
        }
    }

    static final Unit clearRenderSurface$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View) {
        Player player = kickIvsPlayerV2View.player;
        if (player != null) {
            player.setSurface(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean executeOnPlayerExecutor(final String operationName, final Function0<Unit> operation) {
        try {
            this.playerOperationExecutor.execute(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    KickIvsPlayerV2View.executeOnPlayerExecutor$lambda$0(operation, this, operationName);
                }
            });
            return true;
        } catch (RejectedExecutionException e) {
            sendNativeWarn("Player operation rejected", MapsKt.mapOf(TuplesKt.to("operationName", operationName)), e);
            return false;
        }
    }

    static final void executeOnPlayerExecutor$lambda$0(Function0 function0, KickIvsPlayerV2View kickIvsPlayerV2View, String str) {
        try {
            function0.invoke();
        } catch (Exception e) {
            kickIvsPlayerV2View.sendNativeWarn("Player operation failed", MapsKt.mapOf(TuplesKt.to("operationName", str)), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean executePlayerOperation(String operationName, final Function1<? super Player, Unit> operation) {
        return executeOnPlayerExecutor(operationName, new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View.executePlayerOperation$lambda$0(this.f$0, operation);
            }
        });
    }

    static final Unit executePlayerOperation$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Function1 function1) {
        if (kickIvsPlayerV2View.isReleasing) {
            return Unit.INSTANCE;
        }
        Player player = kickIvsPlayerV2View.player;
        if (player == null) {
            return Unit.INSTANCE;
        }
        function1.invoke(player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSurfaceViewBufferSize() {
        if (this.videoWidth <= 0 || this.videoHeight <= 0) {
            return;
        }
        this.surfaceView.getHolder().setFixedSize(this.videoWidth, this.videoHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSurfaceViewTransform() {
        float f;
        float width = this.surfaceView.getWidth();
        float height = this.surfaceView.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f2 = 1.0f;
        if (this.resizeMode == ResizeMode.ZOOM || this.videoWidth <= 0 || this.videoHeight <= 0) {
            this.surfaceView.setScaleX(1.0f);
            this.surfaceView.setScaleY(1.0f);
            return;
        }
        float f3 = this.videoWidth / this.videoHeight;
        float f4 = width / height;
        if (this.resizeMode != ResizeMode.FIT ? f3 <= f4 : f3 > f4) {
            f = f4 / f3;
        } else {
            float f5 = f3 / f4;
            f = 1.0f;
            f2 = f5;
        }
        this.surfaceView.setPivotX(width / 2.0f);
        this.surfaceView.setPivotY(height / 2.0f);
        this.surfaceView.setScaleX(f2);
        this.surfaceView.setScaleY(f);
    }

    private final ResizeMode findResizeMode(String mode) {
        if (mode != null) {
            int iHashCode = mode.hashCode();
            if (iHashCode != -1362001767) {
                if (iHashCode != 727618043) {
                    if (iHashCode == 728219723 && mode.equals("aspectZoom")) {
                        return ResizeMode.ZOOM;
                    }
                } else if (mode.equals("aspectFill")) {
                    return ResizeMode.FILL;
                }
            } else if (mode.equals("aspectFit")) {
                return ResizeMode.FIT;
            }
        }
        return ResizeMode.FIT;
    }

    private final Quality findQualityByHeight(Player player, int qualityHeight) {
        Object next;
        Set<Quality> qualities = player.getQualities();
        Intrinsics.checkNotNullExpressionValue(qualities, "getQualities(...)");
        Iterator<T> it = qualities.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((Quality) next).getHeight() == qualityHeight) {
                return (Quality) next;
            }
        }
        next = null;
        return (Quality) next;
    }

    private final Quality findQuality(Player player, String qualityName) {
        Object next;
        Set<Quality> qualities = player.getQualities();
        Intrinsics.checkNotNullExpressionValue(qualities, "getQualities(...)");
        Iterator<T> it = qualities.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Quality) next).getName(), qualityName)) {
                return (Quality) next;
            }
        }
        next = null;
        return (Quality) next;
    }

    public final void setQuality(final String qualityName) {
        if (qualityName == null) {
            return;
        }
        executePlayerOperation("setQuality", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setQuality$lambda$0(this.f$0, qualityName, (Player) obj);
            }
        });
    }

    static final Unit setQuality$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, String str, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Quality qualityFindQuality = kickIvsPlayerV2View.findQuality(currentPlayer, str);
        if (qualityFindQuality != null) {
            currentPlayer.setQuality(qualityFindQuality);
        }
        return Unit.INSTANCE;
    }

    public final void setAutoMaxQuality(final Integer qualityHeight) {
        if (qualityHeight != null) {
            executePlayerOperation("setAutoMaxQuality", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return KickIvsPlayerV2View.setAutoMaxQuality$lambda$0(this.f$0, qualityHeight, (Player) obj);
                }
            });
        }
    }

    static final Unit setAutoMaxQuality$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Integer num, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Quality qualityFindQualityByHeight = kickIvsPlayerV2View.findQualityByHeight(currentPlayer, num.intValue());
        if (qualityFindQualityByHeight != null) {
            currentPlayer.setAutoMaxQuality(qualityFindQualityByHeight);
        }
        return Unit.INSTANCE;
    }

    public final void setAutoQualityMode(final boolean autoQualityMode) {
        executePlayerOperation("setAutoQualityMode", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setAutoQualityMode$lambda$0(autoQualityMode, (Player) obj);
            }
        });
    }

    static final Unit setAutoQualityMode$lambda$0(boolean z, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setAutoQualityMode(z);
        return Unit.INSTANCE;
    }

    public final void setPipEnabled(boolean newValue) {
        if (this.isDestroyed) {
            return;
        }
        KickIvsPlayerV2Manager.INSTANCE.setPipEnabled(newValue);
    }

    private final void syncAudioService(Player.State state) {
        if ((state == Player.State.PLAYING || state == Player.State.BUFFERING) && KickIvsPlayerV2Manager.INSTANCE.shouldRunAudioService()) {
            AudioService.Companion companion = AudioService.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.start(context);
            return;
        }
        AudioService.Companion companion2 = AudioService.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        companion2.stop(context2);
    }

    public final void onDurationChange(long duration) {
        if (this.isDestroyed) {
            return;
        }
        this.lastDuration = Long.valueOf(duration);
        double duration2 = getDuration(duration);
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            Long lValueOf = Long.valueOf(duration);
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            muxAnalyticsListener.updateSourceDuration(lValueOf);
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onDurationChange", MapsKt.mapOf(TuplesKt.to("duration", Integer.valueOf(MathKt.roundToInt(duration2)))));
        }
    }

    public static /* synthetic */ void onSeek$default(KickIvsPlayerV2View kickIvsPlayerV2View, long j, Player.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = kickIvsPlayerV2View.lastKnownPlayerState.getState();
        }
        kickIvsPlayerV2View.onSeek(j, state);
    }

    public final void onSeek(long position, Player.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.isDestroyed) {
            return;
        }
        double dConvertMilliSecondsToSeconds = convertMilliSecondsToSeconds(position);
        this.isSeekingForMux = false;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updatePlaybackState(state != Player.State.PLAYING, false);
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.dispatchSeeked(position);
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onSeek", MapsKt.mapOf(TuplesKt.to(ViewProps.POSITION, Integer.valueOf(MathKt.roundToInt(dConvertMilliSecondsToSeconds)))));
        }
    }

    public final void onProgress(int position) {
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent;
        if (this.isDestroyed || (sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent()) == null) {
            return;
        }
        sendEvent.invoke("onProgress", MapsKt.mapOf(TuplesKt.to(ViewProps.POSITION, Integer.valueOf(position))));
    }

    public final void onNativePipStateChanged(final boolean active) {
        if (this.isDestroyed) {
            return;
        }
        executePlayerOperation("onPipChange", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.onNativePipStateChanged$lambda$0(this.f$0, active, (Player) obj);
            }
        });
    }

    static final Unit onNativePipStateChanged$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, boolean z, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Player.State state = currentPlayer.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        kickIvsPlayerV2View.onPipChange(z, state);
        return Unit.INSTANCE;
    }

    private final void onPipChange(boolean active, Player.State state) {
        if (this.isDestroyed) {
            return;
        }
        updateMuxPlaybackMode();
        syncAudioService(state);
        if (active && state == Player.State.BUFFERING) {
            MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
            if (muxAnalyticsListener != null) {
                muxAnalyticsListener.updatePlaybackState(false, false);
            }
            MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
            if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.dispatchRebufferEnd();
            }
        }
    }

    public final void play() {
        initializeMuxAnalyticsListener();
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.dispatchPlay();
        }
        executePlayerOperation(PlayEvent.TYPE, new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.play$lambda$0((Player) obj);
            }
        });
    }

    static final Unit play$lambda$0(Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.play();
        return Unit.INSTANCE;
    }

    public final void pause() {
        this.isSeekingForMux = false;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updatePlaybackState(true, false);
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.dispatchPause();
        }
        syncAudioService(null);
        executePlayerOperation(PauseEvent.TYPE, new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.pause$lambda$0((Player) obj);
            }
        });
    }

    static final Unit pause$lambda$0(Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.pause();
        return Unit.INSTANCE;
    }

    public final void pauseForSeeking() {
        this.isSeekingForMux = true;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updatePlaybackState(false, false);
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.dispatchSeeking();
        }
        executePlayerOperation(PauseEvent.TYPE, new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.pauseForSeeking$lambda$0((Player) obj);
            }
        });
    }

    static final Unit pauseForSeeking$lambda$0(Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.pause();
        return Unit.INSTANCE;
    }

    public final void seekTo(double position) {
        final long j = (long) (position * 1000.0d);
        this.isSeekingForMux = true;
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updatePlaybackState(false, false);
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.dispatchSeeking();
        }
        executePlayerOperation("seekTo", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.seekTo$lambda$0(j, (Player) obj);
            }
        });
    }

    static final Unit seekTo$lambda$0(long j, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.seekTo(j);
        return Unit.INSTANCE;
    }

    public final void setOrigin(final String origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        executePlayerOperation("setOrigin", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.setOrigin$lambda$0(origin, (Player) obj);
            }
        });
    }

    static final Unit setOrigin$lambda$0(String str, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        currentPlayer.setOrigin(str);
        return Unit.INSTANCE;
    }

    public final void preload(final int id, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.isDestroyed) {
            return;
        }
        final Uri uri = Uri.parse(url);
        executePlayerOperation(LinkHeader.Rel.PreLoad, new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.preload$lambda$0(uri, this, id, (Player) obj);
            }
        });
    }

    static final Unit preload$lambda$0(Uri uri, KickIvsPlayerV2View kickIvsPlayerV2View, int i, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        MediaPlayer mediaPlayer = currentPlayer instanceof MediaPlayer ? (MediaPlayer) currentPlayer : null;
        if (mediaPlayer != null) {
            mediaPlayer.preload(uri, new KickIvsPlayerV2View$preload$1$1(kickIvsPlayerV2View, i));
        }
        return Unit.INSTANCE;
    }

    public final void loadSource(final int id) {
        executePlayerOperation("loadSource", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.loadSource$lambda$0(this.f$0, id, (Player) obj);
            }
        });
    }

    static final Unit loadSource$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, int i, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Source source = kickIvsPlayerV2View.preloadSourceMap.get(Integer.valueOf(i));
        if (source != null) {
            MediaPlayer mediaPlayer = currentPlayer instanceof MediaPlayer ? (MediaPlayer) currentPlayer : null;
            if (mediaPlayer != null) {
                mediaPlayer.loadSource(source);
            }
        }
        return Unit.INSTANCE;
    }

    public final void releaseSource(final int id) {
        executeOnPlayerExecutor("releaseSource", new Function0() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KickIvsPlayerV2View.releaseSource$lambda$0(this.f$0, id);
            }
        });
    }

    static final Unit releaseSource$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, int i) {
        Source sourceRemove = kickIvsPlayerV2View.preloadSourceMap.remove(Integer.valueOf(i));
        if (sourceRemove != null) {
            sourceRemove.release();
        }
        return Unit.INSTANCE;
    }

    public final void onPlayerStateChange(Player currentPlayer, Player.State state, long streamRequestId) {
        KickIvsPlayerV2View kickIvsPlayerV2View = this;
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        if (kickIvsPlayerV2View.isDestroyed) {
            return;
        }
        MuxAnalyticsListener muxAnalyticsListener = kickIvsPlayerV2View.muxAnalyticsListener;
        if (streamRequestId != kickIvsPlayerV2View.latestStreamRequestId) {
            muxAnalyticsListener = null;
        }
        MuxAnalyticsListener muxAnalyticsListener2 = muxAnalyticsListener;
        if (streamRequestId == kickIvsPlayerV2View.latestStreamRequestId) {
            kickIvsPlayerV2View.lastKnownPlayerState = new StreamStateSnapshot(state, streamRequestId);
        }
        KickIvsPlayerV2Manager.INSTANCE.setPlaying(state == Player.State.PLAYING || state == Player.State.BUFFERING);
        kickIvsPlayerV2View.setPipEnabled(state == Player.State.PLAYING || state == Player.State.BUFFERING);
        kickIvsPlayerV2View.syncAudioService(state);
        boolean z = (state != Player.State.BUFFERING || KickIvsPlayerV2Manager.INSTANCE.isNativePipActive() || kickIvsPlayerV2View.isSeekingForMux) ? false : true;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.updatePlaybackState((kickIvsPlayerV2View.isSeekingForMux || state == Player.State.PLAYING || state == Player.State.BUFFERING) ? false : true, z);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.dispatchPlayerReady();
            }
            Set<Quality> qualities = currentPlayer.getQualities();
            Intrinsics.checkNotNullExpressionValue(qualities, "getQualities(...)");
            Set<Quality> set = qualities;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            for (Quality quality : set) {
                arrayList.add(MapsKt.mapOf(TuplesKt.to("name", quality.getName()), TuplesKt.to("codecs", quality.getCodecs()), TuplesKt.to("bitrate", Integer.valueOf(quality.getBitrate())), TuplesKt.to("framerate", Double.valueOf(quality.getFramerate())), TuplesKt.to(ViewProps.WIDTH, Integer.valueOf(quality.getWidth())), TuplesKt.to(ViewProps.HEIGHT, Integer.valueOf(quality.getHeight()))));
            }
            kickIvsPlayerV2View.setAutoMaxQuality(kickIvsPlayerV2View.getMaxAutoQuality());
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("version", currentPlayer.getVersion()), TuplesKt.to(RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, currentPlayer.getSessionId()), TuplesKt.to("qualities", arrayList));
            Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
            if (sendEvent != null) {
                sendEvent.invoke("onData", MapsKt.mapOf(TuplesKt.to("playerData", mapMapOf)));
            }
        } else if (i == 2) {
            if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.dispatchRebufferEnd();
            }
            if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.dispatchPlaying();
            }
            PalSDKManager.INSTANCE.sendSignal(PalSignal.PlaybackStarted);
            if (!kickIvsPlayerV2View.finishedLoading) {
                double duration = kickIvsPlayerV2View.getDuration(currentPlayer.getDuration());
                kickIvsPlayerV2View.finishedLoading = true;
                Function2<String, Map<String, ? extends Object>, Unit> sendEvent2 = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
                if (sendEvent2 != null) {
                    sendEvent2.invoke("onLoad", MapsKt.mapOf(TuplesKt.to("duration", Integer.valueOf(MathKt.roundToInt(duration)))));
                }
            }
            updatePipParams$default(kickIvsPlayerV2View, KickIvsPlayerV2Manager.INSTANCE.getPipEnabled(), null, null, 6, null);
        } else if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    AudioService.Companion companion = AudioService.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    companion.stop(context);
                    updatePipParams$default(this, false, null, null, 6, null);
                    if (muxAnalyticsListener2 != null) {
                        muxAnalyticsListener2.dispatchEnded();
                    }
                    PalSDKManager.INSTANCE.sendSignal(PalSignal.PlaybackEnded);
                } else {
                    updatePipParams$default(kickIvsPlayerV2View, false, null, null, 6, null);
                }
            } else if (z) {
                if (muxAnalyticsListener2 != null) {
                    muxAnalyticsListener2.dispatchRebufferStart();
                }
            } else if (muxAnalyticsListener2 != null) {
                muxAnalyticsListener2.dispatchRebufferEnd();
            }
            kickIvsPlayerV2View = this;
        } else {
            AudioService.Companion companion2 = AudioService.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            companion2.stop(context2);
            kickIvsPlayerV2View = this;
            updatePipParams$default(kickIvsPlayerV2View, false, null, null, 6, null);
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent3 = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent3 != null) {
            sendEvent3.invoke("onPlayerStateChange", MapsKt.mapOf(TuplesKt.to("state", kickIvsPlayerV2View.mapPlayerState(state))));
        }
    }

    public final void onQualityChange(Quality quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        if (this.isDestroyed) {
            return;
        }
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updateSourceQuality(Integer.valueOf(quality.getBitrate()), Float.valueOf(quality.getFramerate()), quality.getCodecs());
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onQualityChange", MapsKt.mapOf(TuplesKt.to("name", quality.getName()), TuplesKt.to("codecs", quality.getCodecs()), TuplesKt.to("bitrate", Integer.valueOf(quality.getBitrate())), TuplesKt.to("framerate", Double.valueOf(quality.getFramerate())), TuplesKt.to(ViewProps.WIDTH, Integer.valueOf(quality.getWidth())), TuplesKt.to(ViewProps.HEIGHT, Integer.valueOf(quality.getHeight()))));
        }
    }

    public final void onPlayerRebuffering() {
        MuxAnalyticsListener muxAnalyticsListener;
        if (this.isDestroyed) {
            return;
        }
        boolean zIsNativePipActive = KickIvsPlayerV2Manager.INSTANCE.isNativePipActive();
        boolean z = !zIsNativePipActive;
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.updatePlaybackState(false, z);
        }
        if (!zIsNativePipActive && (muxAnalyticsListener = this.muxAnalyticsListener) != null) {
            muxAnalyticsListener.dispatchRebufferStart();
        }
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onRebuffering", MapsKt.emptyMap());
        }
    }

    public final void togglePip() {
        Activity currentActivity;
        if (this.isDestroyed || !getContext().getPackageManager().hasSystemFeature("android.software.picture_in_picture") || (currentActivity = getAppContext().getCurrentActivity()) == null) {
            return;
        }
        boolean zIsInPictureInPictureMode = currentActivity.isInPictureInPictureMode();
        if (!KickIvsPlayerV2Manager.INSTANCE.getPipEnabled()) {
            if (zIsInPictureInPictureMode) {
                currentActivity.moveTaskToBack(false);
            }
        } else {
            if (zIsInPictureInPictureMode) {
                return;
            }
            if (Build.VERSION.SDK_INT < 26) {
                currentActivity.enterPictureInPictureMode();
                return;
            }
            Rational rational = new Rational(16, 9);
            if (this.videoWidth > 0 && this.videoHeight > 0) {
                rational = new Rational(this.videoWidth, this.videoHeight);
            }
            PictureInPictureParams pictureInPictureParamsUpdatePipParams = updatePipParams(KickIvsPlayerV2Manager.INSTANCE.getPipEnabled(), null, rational);
            if (pictureInPictureParamsUpdatePipParams != null) {
                currentActivity.enterPictureInPictureMode(pictureInPictureParamsUpdatePipParams);
            }
        }
    }

    static /* synthetic */ PictureInPictureParams updatePipParams$default(KickIvsPlayerV2View kickIvsPlayerV2View, boolean z, Rect rect, Rational rational, int i, Object obj) {
        if ((i & 2) != 0) {
            rect = null;
        }
        if ((i & 4) != 0) {
            rational = new Rational(16, 9);
        }
        return kickIvsPlayerV2View.updatePipParams(z, rect, rational);
    }

    private final PictureInPictureParams updatePipParams(boolean autoEnterEnabled, Rect rect, Rational aspectRatio) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        PictureInPictureParams.Builder aspectRatio2 = TSpanView$$ExternalSyntheticApiModelOutline0.m11704m().setAspectRatio(aspectRatio);
        if (rect != null) {
            aspectRatio2.setSourceRectHint(rect);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            aspectRatio2.setAutoEnterEnabled(autoEnterEnabled);
            aspectRatio2.setSeamlessResizeEnabled(true);
        }
        PictureInPictureParams pictureInPictureParamsBuild = aspectRatio2.build();
        try {
            Activity currentActivity = getAppContext().getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.setPictureInPictureParams(pictureInPictureParamsBuild);
            }
        } catch (IllegalStateException unused) {
        }
        return pictureInPictureParamsBuild;
    }

    private final double getDuration(long duration) {
        return convertMilliSecondsToSeconds(duration);
    }

    private final String mapPlayerState(Player.State state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return "Ready";
        }
        if (i == 2) {
            return "Playing";
        }
        if (i == 3) {
            return "Idle";
        }
        if (i == 4) {
            return "Buffering";
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return "Ended";
    }

    public final void onTimePoint(long position) {
        if (this.isDestroyed) {
            return;
        }
        double dConvertMilliSecondsToSeconds = convertMilliSecondsToSeconds(position);
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
        if (sendEvent != null) {
            sendEvent.invoke("onTimePoint", MapsKt.mapOf(TuplesKt.to(ViewProps.POSITION, Double.valueOf(dConvertMilliSecondsToSeconds))));
        }
    }

    private final void handlePositionChange(Player currentPlayer) {
        long position = currentPlayer.getPosition();
        MuxAnalyticsListener muxAnalyticsListener = this.muxAnalyticsListener;
        if (muxAnalyticsListener != null) {
            muxAnalyticsListener.updateCurrentPosition(position);
        }
        MuxAnalyticsListener muxAnalyticsListener2 = this.muxAnalyticsListener;
        if (muxAnalyticsListener2 != null) {
            muxAnalyticsListener2.dispatchTimeUpdate();
        }
        int iRoundToInt = MathKt.roundToInt(convertMilliSecondsToSeconds(position));
        if (iRoundToInt > 0 && this.lastPositionInSeconds != iRoundToInt && currentPlayer.getState() == Player.State.PLAYING) {
            onProgress(iRoundToInt);
        }
        List<Long> list = this.breakpoints;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            long jLongValue = ((Number) obj).longValue();
            if (this.lastPositionInSeconds + 1 <= jLongValue && jLongValue <= position) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            onTimePoint(((Number) it.next()).longValue());
        }
        this.lastPositionInSeconds = iRoundToInt;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    private final void handlePlayerStatistics(Player currentPlayer) {
        boolean z;
        Function2<String, Map<String, ? extends Object>, Unit> sendEvent;
        Long l = this.lastBitrate;
        long averageBitrate = currentPlayer.getAverageBitrate();
        if (l != null && l.longValue() == averageBitrate) {
            Long l2 = this.lastDuration;
            long duration = currentPlayer.getDuration();
            if (l2 != null && l2.longValue() == duration) {
                Long l3 = this.lastLiveLatency;
                long liveLatency = currentPlayer.getLiveLatency();
                if (l3 != null && l3.longValue() == liveLatency) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        if (this.sendVideoStatistics && z && (sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent()) != null) {
            sendEvent.invoke("onVideoStatistics", MapsKt.mapOf(TuplesKt.to("videoData", MapsKt.mapOf(TuplesKt.to("duration", Double.valueOf(getDuration(currentPlayer.getDuration()))), TuplesKt.to("bitrate", Integer.valueOf((int) currentPlayer.getAverageBitrate())), TuplesKt.to("liveLatency", Integer.valueOf((int) currentPlayer.getLiveLatency())), TuplesKt.to("framesDropped", null), TuplesKt.to("framesDecoded", null)))));
        }
        this.lastLiveLatency = Long.valueOf(currentPlayer.getLiveLatency());
        this.lastBitrate = Long.valueOf(currentPlayer.getAverageBitrate());
        this.lastDuration = Long.valueOf(currentPlayer.getDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playerObserverCallback() {
        if (this.isDetached) {
            return;
        }
        executePlayerOperation("playerObserver", new Function1() { // from class: com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2View$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KickIvsPlayerV2View.playerObserverCallback$lambda$0(this.f$0, (Player) obj);
            }
        });
    }

    static final Unit playerObserverCallback$lambda$0(KickIvsPlayerV2View kickIvsPlayerV2View, Player currentPlayer) {
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        kickIvsPlayerV2View.handlePositionChange(currentPlayer);
        kickIvsPlayerV2View.handlePlayerStatistics(currentPlayer);
        return Unit.INSTANCE;
    }

    public final void setBreakpoints(Float[] value) {
        ArrayList arrayList;
        ArrayList arrayListEmptyList;
        if (value != null) {
            ArrayList arrayList2 = new ArrayList(value.length);
            for (Float f : value) {
                arrayList2.add(Double.valueOf(f.floatValue()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(Long.valueOf((long) (((Number) it.next()).doubleValue() * 1000.0d)));
            }
            arrayListEmptyList = arrayList4;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        this.breakpoints = arrayListEmptyList;
        this.lastPositionInSeconds = 0;
    }
}
