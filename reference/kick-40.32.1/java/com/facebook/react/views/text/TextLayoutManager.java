package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.window.reflection.WindowExtensionsConstants;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactClickableSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactFragmentIndexSpan;
import com.facebook.react.views.text.internal.span.ReactLinkSpan;
import com.facebook.react.views.text.internal.span.ReactOpacitySpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.ShadowStyleSpan;
import com.facebook.react.views.text.internal.span.TextEffectSpan;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import io.ktor.http.ContentDisposition;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TextLayoutManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001:\u0006\u009f\u0001 \u0001¡\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020#J\u000e\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201J\u0012\u00102\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u001aH\u0002J\"\u00105\u001a\u0002062\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u00108\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020#H\u0007JJ\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J4\u0010G\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u0002012\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0015\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKJ \u0010L\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010NJ(\u0010L\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010NJ1\u0010L\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010E\u001a\u0004\u0018\u00010FH\u0000¢\u0006\u0002\bOJ9\u0010L\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010E\u001a\u0004\u0018\u00010FH\u0000¢\u0006\u0002\bOJ@\u0010P\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0002Jl\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020#2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u001dH\u0002JZ\u0010c\u001a\u00020R2\u0006\u0010S\u001a\u00020#2\u0006\u0010d\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u001dH\u0002J-\u0010e\u001a\u00020+2\u0006\u0010b\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020g2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0001¢\u0006\u0002\bhJ \u0010i\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020g2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0002J \u0010j\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020g2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0002J^\u0010k\u001a\u00020R2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0002JH\u0010Q\u001a\u00020o2\u0006\u0010S\u001a\u00020#2\u0006\u0010b\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020YH\u0002JV\u0010p\u001a\u00020q2\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u00020r2\u0006\u0010l\u001a\u00020r2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007J^\u0010p\u001a\u00020q2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u00020r2\u0006\u0010l\u001a\u00020r2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007Jp\u0010s\u001a\u00020+2\u0006\u0010S\u001a\u00020#2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\u0006\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u001dH\u0007J`\u0010v\u001a\u00020w2\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010x\u001a\u0004\u0018\u00010y2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007Jh\u0010v\u001a\u00020w2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010x\u001a\u0004\u0018\u00010y2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007J0\u0010z\u001a\u00020y2\u0006\u0010{\u001a\u00020q2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020YH\u0007J0\u0010|\u001a\u00020W2\u0006\u0010}\u001a\u00020R2\u0006\u0010l\u001a\u00020r2\u0006\u0010m\u001a\u00020W2\u0006\u0010~\u001a\u00020Y2\u0006\u0010u\u001a\u00020\u0005H\u0002J\u0018\u0010\u007f\u001a\u00020\u00052\u0006\u0010}\u001a\u00020R2\u0006\u0010u\u001a\u00020\u0005H\u0002J3\u0010\u0080\u0001\u001a\u00020W2\u0006\u0010}\u001a\u00020R2\u0007\u0010S\u001a\u00030\u0081\u00012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0007\u0010\u0082\u0001\u001a\u00020\u0005H\u0002J*\u0010\u0083\u0001\u001a\u00020W2\u0006\u0010}\u001a\u00020R2\u0006\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020Y2\u0007\u0010\u0082\u0001\u001a\u00020\u0005H\u0002JH\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010}\u001a\u00020R2\u0007\u0010S\u001a\u00030\u0081\u00012\u0007\u0010\u0085\u0001\u001a\u00020W2\u0007\u0010\u0082\u0001\u001a\u00020\u00052\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020W2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002JI\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020;2\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010m\u001a\u00020W2\b\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007JQ\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010l\u001a\u0002012\u0006\u0010V\u001a\u00020W2\u0006\u0010m\u001a\u00020W2\b\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007J\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010U2\u0006\u0010S\u001a\u00020#2\u0006\u0010b\u001a\u00020\u001dH\u0002J\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J\u0014\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J\u0014\u0010\u0095\u0001\u001a\u00030\u0096\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J%\u0010\u0099\u0001\u001a\u00020+2\b\u0010\u009a\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u0001H\u0002J\u001c\u0010\u009d\u0001\u001a\u00020+2\b\u0010\u009e\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'¨\u0006¢\u0001"}, d2 = {"Lcom/facebook/react/views/text/TextLayoutManager;", "", "<init>", "()V", "AS_KEY_HASH", "", "AS_KEY_STRING", "AS_KEY_FRAGMENTS", "AS_KEY_CACHE_ID", "AS_KEY_BASE_ATTRIBUTES", "FR_KEY_STRING", "FR_KEY_REACT_TAG", "FR_KEY_IS_ATTACHMENT", "FR_KEY_WIDTH", "FR_KEY_HEIGHT", "FR_KEY_TEXT_ATTRIBUTES", "PA_KEY_MAX_NUMBER_OF_LINES", "PA_KEY_ELLIPSIZE_MODE", "PA_KEY_TEXT_BREAK_STRATEGY", "PA_KEY_ADJUST_FONT_SIZE_TO_FIT", "PA_KEY_INCLUDE_FONT_PADDING", "PA_KEY_HYPHENATION_FREQUENCY", "PA_KEY_MINIMUM_FONT_SIZE", "PA_KEY_MAXIMUM_FONT_SIZE", "PA_KEY_TEXT_ALIGN_VERTICAL", "TAG", "", "textPaintInstance", "Ljava/lang/ThreadLocal;", "Landroid/text/TextPaint;", "DEFAULT_INCLUDE_FONT_PADDING", "", "DEFAULT_ADJUST_FONT_SIZE_TO_FIT", "tagToSpannableCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/text/Spannable;", "setUseBoundsForWidthMethod", "Ljava/lang/reflect/Method;", "getSetUseBoundsForWidthMethod", "()Ljava/lang/reflect/Method;", "setUseBoundsForWidthMethod$delegate", "Lkotlin/Lazy;", "setCachedSpannableForTag", "", "reactTag", "sp", "deleteCachedSpannableForTag", "isRTL", "attributedString", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getTextAlignmentAttr", "getTextJustificationMode", "alignmentAttr", "getTextAlignment", "Landroid/text/Layout$Alignment;", "spanned", "getTextGravity", "buildSpannableFromFragments", "assets", "Landroid/content/res/AssetManager;", "fontWeightAdjustment", "fragments", "sb", "Landroid/text/SpannableStringBuilder;", "ops", "", "Lcom/facebook/react/views/text/internal/span/SetSpanOperation;", "outputReactTags", "", "textEffectRegistry", "Lcom/facebook/react/views/text/TextEffectRegistry;", "buildSpannableFromFragmentsOptimized", "inlineViewSizeToPixels", ContentDisposition.Parameters.Size, "", "inlineViewSizeToPixels$ReactAndroid", "getOrCreateSpannableForText", "reactTextViewManagerCallback", "Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "getOrCreateSpannableForText$ReactAndroid", "createSpannableFromAttributedString", "createLayout", "Landroid/text/Layout;", "text", "boring", "Landroid/text/BoringLayout$Metrics;", ViewProps.WIDTH, "", "widthYogaMeasureMode", "Lcom/facebook/yoga/YogaMeasureMode;", ViewProps.INCLUDE_FONT_PADDING, ViewProps.TEXT_BREAK_STRATEGY, "hyphenationFrequency", "alignment", "justificationMode", ViewProps.ELLIPSIZE_MODE, "Landroid/text/TextUtils$TruncateAt;", "maxNumberOfLines", "paint", "buildLayout", "layoutWidth", "updateTextPaint", "baseTextAttributes", "Lcom/facebook/react/views/text/TextAttributeProps;", "updateTextPaint$ReactAndroid", "scratchPaintWithAttributes", "newPaintWithAttributes", "createLayoutForMeasurement", "paragraphAttributes", ViewProps.HEIGHT, "heightYogaMeasureMode", "Lcom/facebook/react/views/text/TextLayoutManager$CreateLayoutResult;", "createPreparedLayout", "Lcom/facebook/react/views/text/PreparedLayout;", "Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "adjustSpannableFontToFit", "minimumFontSizeAttr", "maximumNumberOfLines", "measureText", "", "attachmentsPositions", "", "measurePreparedLayout", "preparedLayout", "getVerticalOffset", WindowExtensionsConstants.LAYOUT_PACKAGE, "heightMeasureMode", "calculateLineCount", "calculateWidth", "Landroid/text/Spanned;", "calculatedLineCount", "calculateHeight", "nextAttachmentMetrics", "calculatedWidth", ContextChain.TAG_INFRA, "verticalOffset", SpanEventSerializer.METRICS_KEY_PREFIX, "Lcom/facebook/react/views/text/TextLayoutManager$AttachmentMetrics;", "measureLines", "Lcom/facebook/react/bridge/WritableArray;", "assetManager", "isBoring", "jsonStringToReadableMap", "Lcom/facebook/react/bridge/ReadableMap;", "json", "jsonObjectToReadableMap", "Lcom/facebook/react/bridge/JavaOnlyMap;", "jsonObject", "Lorg/json/JSONObject;", "jsonArrayToReadableArray", "Lcom/facebook/react/bridge/JavaOnlyArray;", "jsonArray", "Lorg/json/JSONArray;", "putJsonValue", "map", "key", "value", "pushJsonValue", "array", "FragmentAttributes", "CreateLayoutResult", "AttachmentMetrics", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextLayoutManager {
    public static final int AS_KEY_BASE_ATTRIBUTES = 4;
    public static final int AS_KEY_CACHE_ID = 3;
    public static final int AS_KEY_FRAGMENTS = 2;
    public static final int AS_KEY_HASH = 0;
    public static final int AS_KEY_STRING = 1;
    private static final boolean DEFAULT_ADJUST_FONT_SIZE_TO_FIT = false;
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    public static final int FR_KEY_HEIGHT = 4;
    public static final int FR_KEY_IS_ATTACHMENT = 2;
    public static final int FR_KEY_REACT_TAG = 1;
    public static final int FR_KEY_STRING = 0;
    public static final int FR_KEY_TEXT_ATTRIBUTES = 5;
    public static final int FR_KEY_WIDTH = 3;
    public static final TextLayoutManager INSTANCE = new TextLayoutManager();
    public static final int PA_KEY_ADJUST_FONT_SIZE_TO_FIT = 3;
    public static final int PA_KEY_ELLIPSIZE_MODE = 1;
    public static final int PA_KEY_HYPHENATION_FREQUENCY = 5;
    public static final int PA_KEY_INCLUDE_FONT_PADDING = 4;
    public static final int PA_KEY_MAXIMUM_FONT_SIZE = 7;
    public static final int PA_KEY_MAX_NUMBER_OF_LINES = 0;
    public static final int PA_KEY_MINIMUM_FONT_SIZE = 6;
    public static final int PA_KEY_TEXT_ALIGN_VERTICAL = 8;
    public static final int PA_KEY_TEXT_BREAK_STRATEGY = 2;
    private static final String TAG;

    /* JADX INFO: renamed from: setUseBoundsForWidthMethod$delegate, reason: from kotlin metadata */
    private static final Lazy setUseBoundsForWidthMethod;
    private static final ConcurrentHashMap<Integer, Spannable> tagToSpannableCache;
    private static final ThreadLocal<TextPaint> textPaintInstance;

    /* JADX INFO: compiled from: TextLayoutManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[YogaMeasureMode.values().length];
            try {
                iArr2[YogaMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[YogaMeasureMode.AT_MOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private TextLayoutManager() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("TextLayoutManager", "getSimpleName(...)");
        TAG = "TextLayoutManager";
        textPaintInstance = new ThreadLocal<TextPaint>() { // from class: com.facebook.react.views.text.TextLayoutManager$textPaintInstance$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public TextPaint initialValue() {
                return new TextPaint(1);
            }
        };
        tagToSpannableCache = new ConcurrentHashMap<>();
        setUseBoundsForWidthMethod = LazyKt.lazy(new Function0() { // from class: com.facebook.react.views.text.TextLayoutManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextLayoutManager.setUseBoundsForWidthMethod_delegate$lambda$0();
            }
        });
    }

    private final Method getSetUseBoundsForWidthMethod() {
        return (Method) setUseBoundsForWidthMethod.getValue();
    }

    static final Method setUseBoundsForWidthMethod_delegate$lambda$0() {
        try {
            return StaticLayout.Builder.class.getMethod("setUseBoundsForWidth", Boolean.TYPE);
        } catch (ReflectiveOperationException unused) {
            return null;
        }
    }

    public final void setCachedSpannableForTag(int reactTag, Spannable sp) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        tagToSpannableCache.put(Integer.valueOf(reactTag), sp);
    }

    public final void deleteCachedSpannableForTag(int reactTag) {
        tagToSpannableCache.remove(Integer.valueOf(reactTag));
    }

    public final boolean isRTL(MapBuffer attributedString) {
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        if (!attributedString.contains(2)) {
            return false;
        }
        MapBuffer mapBuffer = attributedString.getMapBuffer(2);
        if (mapBuffer.getCount() == 0) {
            return false;
        }
        MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(0).getMapBuffer(5);
        return mapBuffer2.contains(23) && TextAttributeProps.INSTANCE.getLayoutDirection(mapBuffer2.getString(23)) == 1;
    }

    private final String getTextAlignmentAttr(MapBuffer attributedString) {
        if (!attributedString.contains(2)) {
            return null;
        }
        MapBuffer mapBuffer = attributedString.getMapBuffer(2);
        if (mapBuffer.getCount() != 0) {
            MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(0).getMapBuffer(5);
            if (mapBuffer2.contains(12)) {
                return mapBuffer2.getString(12);
            }
        }
        return null;
    }

    private final int getTextJustificationMode(String alignmentAttr) {
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        return (alignmentAttr == null || !Intrinsics.areEqual(alignmentAttr, "justified")) ? 0 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    private final Layout.Alignment getTextAlignment(MapBuffer attributedString, Spannable spanned, String alignmentAttr) {
        Layout.Alignment alignment;
        boolean z = isRTL(attributedString) != TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spanned, 0, spanned.length());
        if (z) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        }
        if (alignmentAttr != null) {
            int iHashCode = alignmentAttr.hashCode();
            if (iHashCode != -1364013995) {
                if (iHashCode != 100571) {
                    if (z) {
                        return Layout.Alignment.ALIGN_NORMAL;
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                if (z) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            if (alignmentAttr.equals("center")) {
                return Layout.Alignment.ALIGN_CENTER;
            }
        }
        return alignment;
    }

    @JvmStatic
    public static final int getTextGravity(MapBuffer attributedString, Spannable spanned) {
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(spanned, "spanned");
        TextLayoutManager textLayoutManager = INSTANCE;
        Layout.Alignment textAlignment = textLayoutManager.getTextAlignment(attributedString, spanned, textLayoutManager.getTextAlignmentAttr(attributedString));
        boolean zIsRtl = TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spanned, 0, spanned.length());
        int i = WhenMappings.$EnumSwitchMapping$0[textAlignment.ordinal()];
        if (i == 1) {
            return zIsRtl ? 5 : 3;
        }
        if (i == 2) {
            return zIsRtl ? 3 : 5;
        }
        if (i == 3) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ae, code lost:
    
        if (com.facebook.react.internal.featureflags.ReactNativeFeatureFlags.enablePreparedTextLayout() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
    
        r31.add(new com.facebook.react.views.text.internal.span.SetSpanOperation(r10, r12, new com.facebook.react.views.text.internal.span.ReactLinkSpan(r6)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        r31.add(new com.facebook.react.views.text.internal.span.SetSpanOperation(r10, r12, new com.facebook.react.views.text.internal.span.ReactClickableSpan(r15)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void buildSpannableFromFragments(android.content.res.AssetManager r27, int r28, com.facebook.react.common.mapbuffer.MapBuffer r29, android.text.SpannableStringBuilder r30, java.util.List<com.facebook.react.views.text.internal.span.SetSpanOperation> r31, int[] r32, com.facebook.react.views.text.TextEffectRegistry r33) {
        /*
            Method dump skipped, instruction units count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.buildSpannableFromFragments(android.content.res.AssetManager, int, com.facebook.react.common.mapbuffer.MapBuffer, android.text.SpannableStringBuilder, java.util.List, int[], com.facebook.react.views.text.TextEffectRegistry):void");
    }

    /* JADX INFO: compiled from: TextLayoutManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/views/text/TextLayoutManager$FragmentAttributes;", "", "props", "Lcom/facebook/react/views/text/TextAttributeProps;", "length", "", "reactTag", "isAttachment", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "<init>", "(Lcom/facebook/react/views/text/TextAttributeProps;IIZDD)V", "getProps", "()Lcom/facebook/react/views/text/TextAttributeProps;", "getLength", "()I", "getReactTag", "()Z", "getWidth", "()D", "getHeight", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FragmentAttributes {
        private final double height;
        private final boolean isAttachment;
        private final int length;
        private final TextAttributeProps props;
        private final int reactTag;
        private final double width;

        public FragmentAttributes(TextAttributeProps props, int i, int i2, boolean z, double d, double d2) {
            Intrinsics.checkNotNullParameter(props, "props");
            this.props = props;
            this.length = i;
            this.reactTag = i2;
            this.isAttachment = z;
            this.width = d;
            this.height = d2;
        }

        public final TextAttributeProps getProps() {
            return this.props;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getReactTag() {
            return this.reactTag;
        }

        /* JADX INFO: renamed from: isAttachment, reason: from getter */
        public final boolean getIsAttachment() {
            return this.isAttachment;
        }

        public final double getWidth() {
            return this.width;
        }

        public final double getHeight() {
            return this.height;
        }
    }

    private final Spannable buildSpannableFromFragmentsOptimized(AssetManager assets, int fontWeightAdjustment, MapBuffer fragments, int[] outputReactTags, TextEffectRegistry textEffectRegistry) {
        int i;
        FragmentAttributes fragmentAttributes;
        StringBuilder sb = new StringBuilder();
        ArrayList<FragmentAttributes> arrayList = new ArrayList(fragments.getCount());
        int count = fragments.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            MapBuffer mapBuffer = fragments.getMapBuffer(i3);
            TextAttributeProps textAttributePropsFromMapBuffer = TextAttributeProps.INSTANCE.fromMapBuffer(mapBuffer.getMapBuffer(5));
            String strApply = TextTransform.INSTANCE.apply(mapBuffer.getString(0), textAttributePropsFromMapBuffer.getTextTransform());
            sb.append(strApply);
            int length = strApply.length();
            int i4 = mapBuffer.contains(1) ? mapBuffer.getInt(1) : -1;
            boolean z = mapBuffer.contains(2) && mapBuffer.getBoolean(2);
            double d = Double.NaN;
            double d2 = mapBuffer.contains(3) ? mapBuffer.getDouble(3) : Double.NaN;
            if (mapBuffer.contains(4)) {
                d = mapBuffer.getDouble(4);
            }
            arrayList.add(new FragmentAttributes(textAttributePropsFromMapBuffer, length, i4, z, d2, d));
        }
        SpannableString spannableString = new SpannableString(sb);
        List<TextAttributeProps.TextEffectEntry> listEmptyList = CollectionsKt.emptyList();
        int i5 = 0;
        int i6 = 0;
        for (FragmentAttributes fragmentAttributes2 : arrayList) {
            int i7 = i2 + 1;
            int length2 = fragmentAttributes2.getLength() + i5;
            int i8 = i5 == 0 ? 18 : 34;
            if (fragmentAttributes2.getIsAttachment()) {
                fragmentAttributes = fragmentAttributes2;
                i = i6;
                spannableString.setSpan(new TextInlineViewPlaceholderSpan(fragmentAttributes2.getReactTag(), inlineViewSizeToPixels$ReactAndroid(fragmentAttributes.getWidth()), inlineViewSizeToPixels$ReactAndroid(fragmentAttributes.getHeight())), i5, length2, i8);
            } else {
                i = i6;
                fragmentAttributes = fragmentAttributes2;
                if (fragmentAttributes.getProps().getRole() == null ? fragmentAttributes.getProps().getAccessibilityRole() == ReactAccessibilityDelegate.AccessibilityRole.LINK : fragmentAttributes.getProps().getRole() == ReactAccessibilityDelegate.Role.LINK) {
                    if (ReactNativeFeatureFlags.enablePreparedTextLayout()) {
                        spannableString.setSpan(new ReactLinkSpan(i2), i5, length2, i8);
                    } else {
                        spannableString.setSpan(new ReactClickableSpan(fragmentAttributes.getReactTag()), i5, length2, i8);
                    }
                }
                if (fragmentAttributes.getProps().getIsColorSet()) {
                    Integer color = fragmentAttributes.getProps().getColor();
                    spannableString.setSpan(color != null ? new ReactForegroundColorSpan(color.intValue()) : null, i5, length2, i8);
                }
                if (fragmentAttributes.getProps().getIsBackgroundColorSet()) {
                    Integer backgroundColor = fragmentAttributes.getProps().getBackgroundColor();
                    spannableString.setSpan(backgroundColor != null ? new ReactBackgroundColorSpan(backgroundColor.intValue()) : null, i5, length2, i8);
                }
                if (!Float.isNaN(fragmentAttributes.getProps().getOpacity())) {
                    spannableString.setSpan(new ReactOpacitySpan(fragmentAttributes.getProps().getOpacity()), i5, length2, i8);
                }
                if (!Float.isNaN(fragmentAttributes.getProps().getLetterSpacing())) {
                    spannableString.setSpan(new CustomLetterSpacingSpan(fragmentAttributes.getProps().getLetterSpacing()), i5, length2, i8);
                }
                spannableString.setSpan(new ReactAbsoluteSizeSpan(fragmentAttributes.getProps().getFontSize()), i5, length2, i8);
                if (fragmentAttributes.getProps().getFontStyle() != -1 || fragmentAttributes.getProps().getFontWeight() != -1 || fragmentAttributes.getProps().getFontVariationSettings() != null || fragmentAttributes.getProps().getFontFamily() != null) {
                    spannableString.setSpan(new CustomStyleSpan(fragmentAttributes.getProps().getFontStyle(), fragmentAttributes.getProps().getFontWeight(), fragmentAttributes.getProps().getFontFeatureSettings(), fragmentAttributes.getProps().getFontVariationSettings(), fragmentAttributes.getProps().getFontFamily(), assets, fontWeightAdjustment), i5, length2, i8);
                }
                if (fragmentAttributes.getProps().getIsUnderlineTextDecorationSet()) {
                    spannableString.setSpan(new ReactUnderlineSpan(fragmentAttributes.getProps().getTextDecorationColor(), fragmentAttributes.getProps().getTextDecorationStyle()), i5, length2, i8);
                }
                if (fragmentAttributes.getProps().getIsLineThroughTextDecorationSet()) {
                    spannableString.setSpan(new ReactStrikethroughSpan(fragmentAttributes.getProps().getTextDecorationColor(), fragmentAttributes.getProps().getTextDecorationStyle()), i5, length2, i8);
                }
                if ((fragmentAttributes.getProps().getTextShadowOffsetDx() != 0.0f || fragmentAttributes.getProps().getTextShadowOffsetDy() != 0.0f || fragmentAttributes.getProps().getTextShadowRadius() != 0.0f) && Color.alpha(fragmentAttributes.getProps().getTextShadowColor()) != 0) {
                    spannableString.setSpan(new ShadowStyleSpan(fragmentAttributes.getProps().getTextShadowOffsetDx(), fragmentAttributes.getProps().getTextShadowOffsetDy(), fragmentAttributes.getProps().getTextShadowRadius(), fragmentAttributes.getProps().getTextShadowColor()), i5, length2, i8);
                }
                if (!Float.isNaN(fragmentAttributes.getProps().getLineHeight())) {
                    spannableString.setSpan(new CustomLineHeightSpan(fragmentAttributes.getProps().getLineHeight()), i5, length2, i8);
                }
                if (ReactNativeFeatureFlags.enablePreparedTextLayout()) {
                    spannableString.setSpan(new ReactFragmentIndexSpan(i2), i5, length2, i8);
                    if (outputReactTags != null) {
                        outputReactTags[i2] = fragmentAttributes.getReactTag();
                    }
                } else {
                    spannableString.setSpan(new ReactTagSpan(fragmentAttributes.getReactTag()), i5, length2, i8);
                }
            }
            List<TextAttributeProps.TextEffectEntry> textEffects$ReactAndroid = fragmentAttributes.getProps().getTextEffects$ReactAndroid();
            if (Intrinsics.areEqual(textEffects$ReactAndroid, listEmptyList)) {
                i6 = i;
            } else {
                if (!listEmptyList.isEmpty() && textEffectRegistry != null) {
                    for (TextAttributeProps.TextEffectEntry textEffectEntry : listEmptyList) {
                        TextEffectSpan textEffectSpanCreateSpan$ReactAndroid = textEffectRegistry.createSpan$ReactAndroid(textEffectEntry.getName(), jsonStringToReadableMap(textEffectEntry.getProps()));
                        if (textEffectSpanCreateSpan$ReactAndroid != null) {
                            spannableString.setSpan(textEffectSpanCreateSpan$ReactAndroid, i, i5, 34);
                        }
                    }
                }
                listEmptyList = textEffects$ReactAndroid;
                i6 = i5;
            }
            i2 = i7;
            i5 = length2;
        }
        if (!listEmptyList.isEmpty() && textEffectRegistry != null) {
            for (TextAttributeProps.TextEffectEntry textEffectEntry2 : listEmptyList) {
                TextEffectSpan textEffectSpanCreateSpan$ReactAndroid2 = textEffectRegistry.createSpan$ReactAndroid(textEffectEntry2.getName(), jsonStringToReadableMap(textEffectEntry2.getProps()));
                if (textEffectSpanCreateSpan$ReactAndroid2 != null) {
                    spannableString.setSpan(textEffectSpanCreateSpan$ReactAndroid2, i6, i5, 34);
                }
            }
        }
        return spannableString;
    }

    public final int inlineViewSizeToPixels$ReactAndroid(double size) {
        return (int) Math.ceil(PixelUtil.toPixelFromDIP(size));
    }

    public final Spannable getOrCreateSpannableForText(AssetManager assets, MapBuffer attributedString, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        return getOrCreateSpannableForText$ReactAndroid(assets, attributedString, reactTextViewManagerCallback, null);
    }

    public final Spannable getOrCreateSpannableForText(AssetManager assets, int fontWeightAdjustment, MapBuffer attributedString, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        return getOrCreateSpannableForText$ReactAndroid(assets, fontWeightAdjustment, attributedString, reactTextViewManagerCallback, null);
    }

    public final Spannable getOrCreateSpannableForText$ReactAndroid(AssetManager assets, MapBuffer attributedString, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        return getOrCreateSpannableForText$ReactAndroid(assets, 0, attributedString, reactTextViewManagerCallback, textEffectRegistry);
    }

    public final Spannable getOrCreateSpannableForText$ReactAndroid(AssetManager assets, int fontWeightAdjustment, MapBuffer attributedString, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        if (attributedString.contains(3)) {
            Spannable spannable = tagToSpannableCache.get(Integer.valueOf(attributedString.getInt(3)));
            if (spannable != null) {
                return spannable;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        return createSpannableFromAttributedString(assets, fontWeightAdjustment, attributedString.getMapBuffer(2), reactTextViewManagerCallback, null, textEffectRegistry);
    }

    static /* synthetic */ Spannable createSpannableFromAttributedString$default(TextLayoutManager textLayoutManager, AssetManager assetManager, int i, MapBuffer mapBuffer, ReactTextViewManagerCallback reactTextViewManagerCallback, int[] iArr, TextEffectRegistry textEffectRegistry, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            textEffectRegistry = null;
        }
        return textLayoutManager.createSpannableFromAttributedString(assetManager, i, mapBuffer, reactTextViewManagerCallback, iArr, textEffectRegistry);
    }

    private final Spannable createSpannableFromAttributedString(AssetManager assets, int fontWeightAdjustment, MapBuffer fragments, ReactTextViewManagerCallback reactTextViewManagerCallback, int[] outputReactTags, TextEffectRegistry textEffectRegistry) {
        if (ReactNativeFeatureFlags.enableAndroidTextMeasurementOptimizations()) {
            Spannable spannableBuildSpannableFromFragmentsOptimized = buildSpannableFromFragmentsOptimized(assets, fontWeightAdjustment, fragments, outputReactTags, textEffectRegistry);
            if (reactTextViewManagerCallback != null) {
                reactTextViewManagerCallback.onPostProcessSpannable(spannableBuildSpannableFromFragmentsOptimized);
            }
            return spannableBuildSpannableFromFragmentsOptimized;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        buildSpannableFromFragments(assets, fontWeightAdjustment, fragments, spannableStringBuilder, arrayList, outputReactTags, textEffectRegistry);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get((arrayList.size() - i) - 1).execute(spannableStringBuilder, i);
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private final Layout createLayout(Spannable text, BoringLayout.Metrics boring, float width, YogaMeasureMode widthYogaMeasureMode, boolean includeFontPadding, int textBreakStrategy, int hyphenationFrequency, Layout.Alignment alignment, int justificationMode, TextUtils.TruncateAt ellipsizeMode, int maxNumberOfLines, TextPaint paint) {
        if (boring != null && (widthYogaMeasureMode == YogaMeasureMode.UNDEFINED || boring.width <= ((float) Math.floor(width)))) {
            BoringLayout boringLayoutMake = BoringLayout.make(text, paint, widthYogaMeasureMode == YogaMeasureMode.EXACTLY ? (int) Math.ceil(width) : boring.width, alignment, 1.0f, 0.0f, boring, includeFontPadding);
            Intrinsics.checkNotNullExpressionValue(boringLayoutMake, "make(...)");
            return boringLayoutMake;
        }
        int iCeil = (int) Math.ceil(Layout.getDesiredWidth(text, paint));
        int i = WhenMappings.$EnumSwitchMapping$1[widthYogaMeasureMode.ordinal()];
        if (i == 1) {
            iCeil = (int) Math.ceil(width);
        } else if (i == 2) {
            iCeil = Math.min(iCeil, (int) Math.floor(width));
        }
        return buildLayout(text, iCeil, includeFontPadding, textBreakStrategy, hyphenationFrequency, alignment, justificationMode, ellipsizeMode, maxNumberOfLines, paint);
    }

    private final Layout buildLayout(Spannable text, int layoutWidth, boolean includeFontPadding, int textBreakStrategy, int hyphenationFrequency, Layout.Alignment alignment, int justificationMode, TextUtils.TruncateAt ellipsizeMode, int maxNumberOfLines, TextPaint paint) {
        StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(text, 0, text.length(), paint, layoutWidth).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(includeFontPadding).setBreakStrategy(textBreakStrategy).setHyphenationFrequency(hyphenationFrequency);
        Intrinsics.checkNotNullExpressionValue(hyphenationFrequency2, "setHyphenationFrequency(...)");
        if (maxNumberOfLines != -1 && maxNumberOfLines != 0) {
            hyphenationFrequency2.setEllipsize(ellipsizeMode).setMaxLines(maxNumberOfLines);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hyphenationFrequency2.setJustificationMode(justificationMode);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
        }
        StaticLayout staticLayoutBuild = hyphenationFrequency2.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        return staticLayoutBuild;
    }

    public final void updateTextPaint$ReactAndroid(TextPaint paint, TextAttributeProps baseTextAttributes, AssetManager assets, int fontWeightAdjustment) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(baseTextAttributes, "baseTextAttributes");
        Intrinsics.checkNotNullParameter(assets, "assets");
        if (baseTextAttributes.getFontSize() != -1) {
            paint.setTextSize(baseTextAttributes.getFontSize());
        }
        if (baseTextAttributes.getFontStyle() != -1 || baseTextAttributes.getFontWeight() != -1 || baseTextAttributes.getFontVariationSettings() != null || baseTextAttributes.getFontFamily() != null) {
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(null, baseTextAttributes.getFontStyle(), baseTextAttributes.getFontWeight(), baseTextAttributes.getFontFamily(), assets);
            paint.setTypeface(ReactTypefaceUtils.applyFontWeightAdjustment(typefaceApplyStyles, fontWeightAdjustment));
            if (baseTextAttributes.getFontStyle() != -1 && baseTextAttributes.getFontStyle() != typefaceApplyStyles.getStyle()) {
                int fontStyle = (~typefaceApplyStyles.getStyle()) & baseTextAttributes.getFontStyle();
                paint.setFakeBoldText((fontStyle & 1) != 0);
                paint.setTextSkewX((fontStyle & 2) != 0 ? -0.25f : 0.0f);
            }
        } else {
            Typeface typefaceApplyFontWeightAdjustment = ReactTypefaceUtils.applyFontWeightAdjustment(null, fontWeightAdjustment);
            if (typefaceApplyFontWeightAdjustment != null) {
                paint.setTypeface(typefaceApplyFontWeightAdjustment);
            }
        }
        ReactTypefaceUtils.INSTANCE.applyFontVariationSettings$ReactAndroid(paint, baseTextAttributes.getFontVariationSettings());
    }

    private final TextPaint scratchPaintWithAttributes(TextAttributeProps baseTextAttributes, AssetManager assets, int fontWeightAdjustment) {
        TextPaint textPaint = textPaintInstance.get();
        if (textPaint == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        TextPaint textPaint2 = textPaint;
        textPaint2.setTypeface(null);
        textPaint2.setTextSize(12.0f);
        textPaint2.setFakeBoldText(false);
        textPaint2.setTextSkewX(0.0f);
        updateTextPaint$ReactAndroid(textPaint2, baseTextAttributes, assets, fontWeightAdjustment);
        return textPaint2;
    }

    private final TextPaint newPaintWithAttributes(TextAttributeProps baseTextAttributes, AssetManager assets, int fontWeightAdjustment) {
        TextPaint textPaint = new TextPaint(1);
        updateTextPaint$ReactAndroid(textPaint, baseTextAttributes, assets, fontWeightAdjustment);
        return textPaint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Layout createLayoutForMeasurement(AssetManager assets, int fontWeightAdjustment, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        TextPaint textPaintScratchPaintWithAttributes;
        Spannable orCreateSpannableForText$ReactAndroid = getOrCreateSpannableForText$ReactAndroid(assets, fontWeightAdjustment, attributedString, reactTextViewManagerCallback, textEffectRegistry);
        if (attributedString.contains(3)) {
            textPaintScratchPaintWithAttributes = ((ReactTextPaintHolderSpan[]) orCreateSpannableForText$ReactAndroid.getSpans(0, 0, ReactTextPaintHolderSpan.class))[0].getTextPaint();
        } else {
            textPaintScratchPaintWithAttributes = scratchPaintWithAttributes(TextAttributeProps.INSTANCE.fromMapBuffer(attributedString.getMapBuffer(4)), assets, fontWeightAdjustment);
        }
        return createLayout(orCreateSpannableForText$ReactAndroid, textPaintScratchPaintWithAttributes, attributedString, paragraphAttributes, width, widthYogaMeasureMode, height, heightYogaMeasureMode).getLayout();
    }

    private final CreateLayoutResult createLayout(Spannable text, TextPaint paint, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode) {
        BoringLayout.Metrics metricsIsBoring = isBoring(text, paint);
        int textBreakStrategy = TextAttributeProps.INSTANCE.getTextBreakStrategy(paragraphAttributes.getString(2));
        boolean z = paragraphAttributes.contains(4) ? paragraphAttributes.getBoolean(4) : true;
        int hyphenationFrequency = TextAttributeProps.INSTANCE.getHyphenationFrequency(paragraphAttributes.getString(5));
        boolean z2 = paragraphAttributes.contains(3) ? paragraphAttributes.getBoolean(3) : false;
        int i = paragraphAttributes.contains(0) ? paragraphAttributes.getInt(0) : -1;
        TextUtils.TruncateAt ellipsizeMode = paragraphAttributes.contains(1) ? TextAttributeProps.INSTANCE.getEllipsizeMode(paragraphAttributes.getString(1)) : null;
        String textAlignmentAttr = getTextAlignmentAttr(attributedString);
        Layout.Alignment textAlignment = getTextAlignment(attributedString, text, textAlignmentAttr);
        int textJustificationMode = getTextJustificationMode(textAlignmentAttr);
        if (z2) {
            adjustSpannableFontToFit(text, width, YogaMeasureMode.EXACTLY, height, heightYogaMeasureMode, paragraphAttributes.contains(6) ? (float) paragraphAttributes.getDouble(6) : Float.NaN, i, z, textBreakStrategy, hyphenationFrequency, textAlignment, textJustificationMode, paint);
            i = i;
            hyphenationFrequency = hyphenationFrequency;
            textJustificationMode = textJustificationMode;
        }
        return new CreateLayoutResult(createLayout(text, metricsIsBoring, width, widthYogaMeasureMode, z, textBreakStrategy, hyphenationFrequency, textAlignment, textJustificationMode, ellipsizeMode, i, paint), textBreakStrategy, textJustificationMode);
    }

    @JvmStatic
    public static final PreparedLayout createPreparedLayout(AssetManager assets, ReadableMapBuffer attributedString, ReadableMapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        return createPreparedLayout(assets, 0, attributedString, paragraphAttributes, width, widthYogaMeasureMode, height, heightYogaMeasureMode, reactTextViewManagerCallback, textEffectRegistry);
    }

    @JvmStatic
    public static final PreparedLayout createPreparedLayout(AssetManager assets, int fontWeightAdjustment, ReadableMapBuffer attributedString, ReadableMapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        ReadableMapBuffer mapBuffer = attributedString.getMapBuffer(2);
        int[] iArr = new int[mapBuffer.getCount()];
        TextLayoutManager textLayoutManager = INSTANCE;
        CreateLayoutResult createLayoutResultCreateLayout = textLayoutManager.createLayout(textLayoutManager.createSpannableFromAttributedString(assets, fontWeightAdjustment, mapBuffer, reactTextViewManagerCallback, iArr, textEffectRegistry), textLayoutManager.newPaintWithAttributes(TextAttributeProps.INSTANCE.fromMapBuffer(attributedString.getMapBuffer(4)), assets, fontWeightAdjustment), attributedString, paragraphAttributes, width, widthYogaMeasureMode, height, heightYogaMeasureMode);
        int i = paragraphAttributes.contains(0) ? paragraphAttributes.getInt(0) : -1;
        return new PreparedLayout(createLayoutResultCreateLayout.getLayout(), i, textLayoutManager.getVerticalOffset(createLayoutResultCreateLayout.getLayout(), paragraphAttributes, height, heightYogaMeasureMode, i), iArr, createLayoutResultCreateLayout.getTextBreakStrategy(), createLayoutResultCreateLayout.getJustificationMode());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0111  */
    /* JADX WARN: Code duplicated, block: B:41:0x0121  */
    /* JADX WARN: Code duplicated, block: B:52:0x0137  */
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
    @JvmStatic
    public static final void adjustSpannableFontToFit(Spannable text, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, float minimumFontSizeAttr, int maximumNumberOfLines, boolean includeFontPadding, int textBreakStrategy, int hyphenationFrequency, Layout.Alignment alignment, int justificationMode, TextPaint paint) {
        int i;
        int i2;
        int i3;
        int i4;
        Spannable text2 = text;
        TextPaint paint2 = paint;
        Intrinsics.checkNotNullParameter(text2, "text");
        YogaMeasureMode widthYogaMeasureMode2 = widthYogaMeasureMode;
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode2, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        Layout.Alignment alignment2 = alignment;
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(paint2, "paint");
        BoringLayout.Metrics metricsIsBoring = INSTANCE.isBoring(text2, paint2);
        int iDpToPx = (int) (Float.isNaN(minimumFontSizeAttr) ? PixelUtil.INSTANCE.dpToPx(4) : minimumFontSizeAttr);
        int i5 = 0;
        Iterator it = ArrayIteratorKt.iterator((ReactAbsoluteSizeSpan[]) text2.getSpans(0, text2.length(), ReactAbsoluteSizeSpan.class));
        int iMax = iDpToPx;
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((ReactAbsoluteSizeSpan) it.next()).getSize());
        }
        int i6 = iMax;
        int i7 = iDpToPx;
        while (true) {
            int i8 = ((i7 + iMax) + 1) / 2;
            float f = i8 / i6;
            paint2.setTextSize(Math.max((int) (paint2.getTextSize() * f), iDpToPx));
            for (Iterator it2 = ArrayIteratorKt.iterator((ReactAbsoluteSizeSpan[]) text2.getSpans(i5, text2.length(), ReactAbsoluteSizeSpan.class)); it2.hasNext(); it2 = it2) {
                ReactAbsoluteSizeSpan reactAbsoluteSizeSpan = (ReactAbsoluteSizeSpan) it2.next();
                text2.setSpan(new ReactAbsoluteSizeSpan(Math.max((int) (reactAbsoluteSizeSpan.getSize() * f), iDpToPx)), text2.getSpanStart(reactAbsoluteSizeSpan), text2.getSpanEnd(reactAbsoluteSizeSpan), text2.getSpanFlags(reactAbsoluteSizeSpan));
                text2.removeSpan(reactAbsoluteSizeSpan);
                metricsIsBoring = metricsIsBoring;
            }
            BoringLayout.Metrics metrics = metricsIsBoring;
            BoringLayout.Metrics metricsIsBoring2 = metrics != null ? INSTANCE.isBoring(text2, paint2) : metrics;
            int i9 = iMax;
            int i10 = iDpToPx;
            int i11 = i7;
            Layout layoutCreateLayout = INSTANCE.createLayout(text2, metricsIsBoring2, width, widthYogaMeasureMode2, includeFontPadding, textBreakStrategy, hyphenationFrequency, alignment2, justificationMode, null, -1, paint2);
            if (i11 == i9) {
                return;
            }
            if (text.length() == 1) {
                i = 0;
                if (layoutCreateLayout.getLineWidth(0) > width) {
                    i2 = 1;
                }
                if (heightYogaMeasureMode != YogaMeasureMode.UNDEFINED || layoutCreateLayout.getHeight() <= height) {
                    i3 = i;
                } else {
                    i3 = 1;
                }
                if (maximumNumberOfLines != -1 || maximumNumberOfLines == 0 || layoutCreateLayout.getLineCount() <= maximumNumberOfLines) {
                    i4 = i;
                } else {
                    i4 = 1;
                }
                if (i8 > i10 || (i4 == 0 && i3 == 0 && i2 == 0)) {
                    i11 = i8;
                    iMax = i9;
                } else {
                    iMax = i9 - i11 == 1 ? i11 : i8;
                }
                int i12 = i11;
                iDpToPx = i10;
                i7 = i12;
                paint2 = paint;
                i5 = i;
                metricsIsBoring = metricsIsBoring2;
                i6 = i8;
                text2 = text;
                widthYogaMeasureMode2 = widthYogaMeasureMode;
                alignment2 = alignment;
            } else {
                i = 0;
            }
            i2 = i;
            if (heightYogaMeasureMode != YogaMeasureMode.UNDEFINED) {
                i3 = i;
            } else {
                i3 = i;
            }
            if (maximumNumberOfLines != -1) {
                i4 = i;
            } else {
                i4 = i;
            }
            if (i8 > i10) {
                i11 = i8;
                iMax = i9;
            } else {
                i11 = i8;
                iMax = i9;
            }
            int i13 = i11;
            iDpToPx = i10;
            i7 = i13;
            paint2 = paint;
            i5 = i;
            metricsIsBoring = metricsIsBoring2;
            i6 = i8;
            text2 = text;
            widthYogaMeasureMode2 = widthYogaMeasureMode;
            alignment2 = alignment;
        }
    }

    @JvmStatic
    public static final long measureText(AssetManager assets, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, ReactTextViewManagerCallback reactTextViewManagerCallback, float[] attachmentsPositions, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        return measureText(assets, 0, attributedString, paragraphAttributes, width, widthYogaMeasureMode, height, heightYogaMeasureMode, reactTextViewManagerCallback, attachmentsPositions, textEffectRegistry);
    }

    @JvmStatic
    public static final long measureText(AssetManager assets, int fontWeightAdjustment, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode, ReactTextViewManagerCallback reactTextViewManagerCallback, float[] attachmentsPositions, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        TextLayoutManager textLayoutManager = INSTANCE;
        Layout layoutCreateLayoutForMeasurement = textLayoutManager.createLayoutForMeasurement(assets, fontWeightAdjustment, attributedString, paragraphAttributes, width, widthYogaMeasureMode, height, heightYogaMeasureMode, reactTextViewManagerCallback, textEffectRegistry);
        int iNextAttachmentMetrics = 0;
        int i = paragraphAttributes.contains(0) ? paragraphAttributes.getInt(0) : -1;
        CharSequence text = layoutCreateLayoutForMeasurement.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        Spanned spanned = (Spanned) text;
        int iCalculateLineCount = textLayoutManager.calculateLineCount(layoutCreateLayoutForMeasurement, i);
        float fCalculateWidth = textLayoutManager.calculateWidth(layoutCreateLayoutForMeasurement, spanned, width, widthYogaMeasureMode, iCalculateLineCount);
        float fCalculateHeight = textLayoutManager.calculateHeight(layoutCreateLayoutForMeasurement, height, heightYogaMeasureMode, iCalculateLineCount);
        if (attachmentsPositions != null) {
            AttachmentMetrics attachmentMetrics = new AttachmentMetrics();
            int i2 = 0;
            while (iNextAttachmentMetrics < spanned.length()) {
                iNextAttachmentMetrics = INSTANCE.nextAttachmentMetrics(layoutCreateLayoutForMeasurement, spanned, fCalculateWidth, iCalculateLineCount, iNextAttachmentMetrics, 0.0f, attachmentMetrics);
                if (attachmentMetrics.getWasFound()) {
                    attachmentsPositions[i2] = PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getTop());
                    attachmentsPositions[i2 + 1] = PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getLeft());
                    i2 += 2;
                }
            }
        }
        return YogaMeasureOutput.make(PixelUtil.INSTANCE.pxToDp(fCalculateWidth), PixelUtil.INSTANCE.pxToDp(fCalculateHeight));
    }

    @JvmStatic
    public static final float[] measurePreparedLayout(PreparedLayout preparedLayout, float width, YogaMeasureMode widthYogaMeasureMode, float height, YogaMeasureMode heightYogaMeasureMode) {
        Intrinsics.checkNotNullParameter(preparedLayout, "preparedLayout");
        Intrinsics.checkNotNullParameter(widthYogaMeasureMode, "widthYogaMeasureMode");
        Intrinsics.checkNotNullParameter(heightYogaMeasureMode, "heightYogaMeasureMode");
        Layout layout = preparedLayout.getLayout();
        CharSequence text = layout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        Spanned spanned = (Spanned) text;
        int maximumNumberOfLines = preparedLayout.getMaximumNumberOfLines();
        TextLayoutManager textLayoutManager = INSTANCE;
        int iCalculateLineCount = textLayoutManager.calculateLineCount(layout, maximumNumberOfLines);
        float fCalculateWidth = textLayoutManager.calculateWidth(layout, spanned, width, widthYogaMeasureMode, iCalculateLineCount);
        float fCalculateHeight = textLayoutManager.calculateHeight(layout, height, heightYogaMeasureMode, iCalculateLineCount);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(fCalculateWidth)));
        arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(fCalculateHeight)));
        AttachmentMetrics attachmentMetrics = new AttachmentMetrics();
        int iNextAttachmentMetrics = 0;
        while (iNextAttachmentMetrics < spanned.length()) {
            iNextAttachmentMetrics = textLayoutManager.nextAttachmentMetrics(layout, spanned, fCalculateWidth, iCalculateLineCount, iNextAttachmentMetrics, preparedLayout.getVerticalOffset(), attachmentMetrics);
            if (attachmentMetrics.getWasFound()) {
                arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getTop())));
                arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getLeft())));
                arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getWidth())));
                arrayList.add(Float.valueOf(PixelUtil.INSTANCE.pxToDp(attachmentMetrics.getHeight())));
            }
        }
        float[] fArr = new float[arrayList.size()];
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            fArr[i] = ((Number) obj).floatValue();
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r4.equals("auto") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r4.equals(com.facebook.react.uimanager.ViewProps.TOP) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        return 0.0f;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final float getVerticalOffset(android.text.Layout r3, com.facebook.react.common.mapbuffer.ReadableMapBuffer r4, float r5, com.facebook.yoga.YogaMeasureMode r6, int r7) {
        /*
            r2 = this;
            r0 = 8
            boolean r1 = r4.contains(r0)
            if (r1 == 0) goto Ld
            java.lang.String r4 = r4.getString(r0)
            goto Le
        Ld:
            r4 = 0
        Le:
            r0 = 0
            if (r4 != 0) goto L12
            return r0
        L12:
            int r1 = r3.getHeight()
            int r7 = r2.calculateLineCount(r3, r7)
            float r2 = r2.calculateHeight(r3, r5, r6, r7)
            float r3 = (float) r1
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 <= 0) goto L24
            return r0
        L24:
            int r5 = r4.hashCode()
            switch(r5) {
                case -1383228885: goto L4d;
                case -1364013995: goto L3f;
                case 115029: goto L35;
                case 3005871: goto L2c;
                default: goto L2b;
            }
        L2b:
            goto L58
        L2c:
            java.lang.String r2 = "auto"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L3e
            goto L58
        L35:
            java.lang.String r2 = "top"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L3e
            goto L58
        L3e:
            return r0
        L3f:
            java.lang.String r5 = "center"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L48
            goto L58
        L48:
            float r2 = r2 - r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            return r2
        L4d:
            java.lang.String r5 = "bottom"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L56
            goto L58
        L56:
            float r2 = r2 - r3
            return r2
        L58:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid textAlignVertical: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ReactNative"
            com.facebook.common.logging.FLog.w(r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.getVerticalOffset(android.text.Layout, com.facebook.react.common.mapbuffer.ReadableMapBuffer, float, com.facebook.yoga.YogaMeasureMode, int):float");
    }

    private final int calculateLineCount(Layout layout, int maximumNumberOfLines) {
        if (maximumNumberOfLines == -1 || maximumNumberOfLines == 0) {
            return layout.getLineCount();
        }
        return Math.min(maximumNumberOfLines, layout.getLineCount());
    }

    private final float calculateWidth(Layout layout, Spanned text, float width, YogaMeasureMode widthYogaMeasureMode, int calculatedLineCount) {
        return widthYogaMeasureMode == YogaMeasureMode.EXACTLY ? width : layout.getWidth();
    }

    private final float calculateHeight(Layout layout, float height, YogaMeasureMode heightYogaMeasureMode, int calculatedLineCount) {
        if (heightYogaMeasureMode != YogaMeasureMode.EXACTLY) {
            float lineBottom = layout.getLineBottom(calculatedLineCount - 1);
            if (heightYogaMeasureMode != YogaMeasureMode.AT_MOST || lineBottom <= height) {
                return lineBottom;
            }
        }
        return height;
    }

    private final int nextAttachmentMetrics(Layout layout, Spanned text, float calculatedWidth, int calculatedLineCount, int i, float verticalOffset, AttachmentMetrics metrics) {
        float secondaryHorizontal;
        int iNextSpanTransition = text.nextSpanTransition(i, text.length(), TextInlineViewPlaceholderSpan.class);
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) text.getSpans(i, iNextSpanTransition, TextInlineViewPlaceholderSpan.class);
        if (textInlineViewPlaceholderSpanArr.length == 0) {
            metrics.setWasFound(false);
            return iNextSpanTransition;
        }
        Assertions.assertCondition(textInlineViewPlaceholderSpanArr.length == 1);
        TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr[0];
        int spanStart = text.getSpanStart(textInlineViewPlaceholderSpan);
        int lineForOffset = layout.getLineForOffset(spanStart);
        boolean z = layout.getEllipsisCount(lineForOffset) > 0;
        if (lineForOffset > calculatedLineCount || (z && spanStart >= layout.getLineStart(lineForOffset) + layout.getEllipsisStart(lineForOffset))) {
            metrics.setTop(Float.NaN);
            metrics.setLeft(Float.NaN);
        } else {
            float width = textInlineViewPlaceholderSpan.getWidth();
            float height = textInlineViewPlaceholderSpan.getHeight();
            boolean zIsRtlCharAt = layout.isRtlCharAt(spanStart);
            if ((layout.getParagraphDirection(lineForOffset) == -1) == zIsRtlCharAt) {
                secondaryHorizontal = layout.getPrimaryHorizontal(spanStart);
            } else {
                secondaryHorizontal = layout.getSecondaryHorizontal(spanStart);
            }
            if (zIsRtlCharAt) {
                secondaryHorizontal -= width;
            }
            metrics.setTop(layout.getLineBaseline(lineForOffset) - height);
            metrics.setLeft(secondaryHorizontal);
        }
        metrics.setTop(metrics.getTop() + verticalOffset);
        metrics.setWasFound(true);
        metrics.setWidth(textInlineViewPlaceholderSpan.getWidth());
        metrics.setHeight(textInlineViewPlaceholderSpan.getHeight());
        return iNextSpanTransition;
    }

    public static /* synthetic */ WritableArray measureLines$default(AssetManager assetManager, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f, float f2, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry, int i, Object obj) {
        if ((i & 64) != 0) {
            textEffectRegistry = null;
        }
        return measureLines(assetManager, mapBuffer, mapBuffer2, f, f2, reactTextViewManagerCallback, textEffectRegistry);
    }

    @JvmStatic
    public static final WritableArray measureLines(AssetManager assetManager, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, float height, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        return measureLines(assetManager, 0, attributedString, paragraphAttributes, width, height, reactTextViewManagerCallback, textEffectRegistry);
    }

    @JvmStatic
    public static final WritableArray measureLines(AssetManager assetManager, int fontWeightAdjustment, MapBuffer attributedString, MapBuffer paragraphAttributes, float width, float height, ReactTextViewManagerCallback reactTextViewManagerCallback, TextEffectRegistry textEffectRegistry) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(paragraphAttributes, "paragraphAttributes");
        Layout layoutCreateLayoutForMeasurement = INSTANCE.createLayoutForMeasurement(assetManager, fontWeightAdjustment, attributedString, paragraphAttributes, width, YogaMeasureMode.EXACTLY, height, YogaMeasureMode.EXACTLY, reactTextViewManagerCallback, textEffectRegistry);
        CharSequence text = layoutCreateLayoutForMeasurement.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return FontMetricsUtil.getFontMetrics(text, layoutCreateLayoutForMeasurement, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    private final BoringLayout.Metrics isBoring(Spannable text, TextPaint paint) {
        BoringLayout.Metrics metricsIsBoring;
        if (Build.VERSION.SDK_INT < 33) {
            metricsIsBoring = BoringLayout.isBoring(text, paint);
        } else {
            metricsIsBoring = BoringLayout.isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, true, null);
        }
        if (metricsIsBoring == null || metricsIsBoring.width < 0) {
            return null;
        }
        return metricsIsBoring;
    }

    /* JADX INFO: compiled from: TextLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/text/TextLayoutManager$CreateLayoutResult;", "", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", ViewProps.TEXT_BREAK_STRATEGY, "", "justificationMode", "<init>", "(Landroid/text/Layout;II)V", "getLayout", "()Landroid/text/Layout;", "getTextBreakStrategy", "()I", "getJustificationMode", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class CreateLayoutResult {
        private final int justificationMode;
        private final Layout layout;
        private final int textBreakStrategy;

        public CreateLayoutResult(Layout layout, int i, int i2) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.layout = layout;
            this.textBreakStrategy = i;
            this.justificationMode = i2;
        }

        public final Layout getLayout() {
            return this.layout;
        }

        public final int getTextBreakStrategy() {
            return this.textBreakStrategy;
        }

        public final int getJustificationMode() {
            return this.justificationMode;
        }
    }

    /* JADX INFO: compiled from: TextLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/facebook/react/views/text/TextLayoutManager$AttachmentMetrics;", "", "<init>", "()V", "wasFound", "", "getWasFound", "()Z", "setWasFound", "(Z)V", ViewProps.TOP, "", "getTop", "()F", "setTop", "(F)V", "left", "getLeft", "setLeft", ViewProps.WIDTH, "getWidth", "setWidth", ViewProps.HEIGHT, "getHeight", "setHeight", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class AttachmentMetrics {
        private float height;
        private float left;
        private float top;
        private boolean wasFound;
        private float width;

        public final boolean getWasFound() {
            return this.wasFound;
        }

        public final void setWasFound(boolean z) {
            this.wasFound = z;
        }

        public final float getTop() {
            return this.top;
        }

        public final void setTop(float f) {
            this.top = f;
        }

        public final float getLeft() {
            return this.left;
        }

        public final void setLeft(float f) {
            this.left = f;
        }

        public final float getWidth() {
            return this.width;
        }

        public final void setWidth(float f) {
            this.width = f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final void setHeight(float f) {
            this.height = f;
        }
    }

    private final ReadableMap jsonStringToReadableMap(String json) {
        if (json == null) {
            return null;
        }
        try {
            return jsonObjectToReadableMap(new JSONObject(json));
        } catch (Exception unused) {
            return null;
        }
    }

    private final JavaOnlyMap jsonObjectToReadableMap(JSONObject jsonObject) throws JSONException {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Iterator<String> itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkNotNull(next);
            Object obj = jsonObject.get(next);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            putJsonValue(javaOnlyMap, next, obj);
        }
        return javaOnlyMap;
    }

    private final JavaOnlyArray jsonArrayToReadableArray(JSONArray jsonArray) throws JSONException {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jsonArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            pushJsonValue(javaOnlyArray, obj);
        }
        return javaOnlyArray;
    }

    private final void putJsonValue(JavaOnlyMap map, String key, Object value) {
        if (Intrinsics.areEqual(value, JSONObject.NULL)) {
            map.putNull(key);
            return;
        }
        if (value instanceof Boolean) {
            map.putBoolean(key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Number) {
            map.putDouble(key, ((Number) value).doubleValue());
            return;
        }
        if (value instanceof String) {
            map.putString(key, (String) value);
            return;
        }
        if (value instanceof JSONObject) {
            map.putMap(key, jsonObjectToReadableMap((JSONObject) value));
            return;
        }
        if (value instanceof JSONArray) {
            map.putArray(key, jsonArrayToReadableArray((JSONArray) value));
            return;
        }
        FLog.w(ReactConstants.TAG, "Unsupported text effect prop type for key " + key + ": " + value.getClass().getName());
    }

    private final void pushJsonValue(JavaOnlyArray array, Object value) {
        if (Intrinsics.areEqual(value, JSONObject.NULL)) {
            array.pushNull();
            return;
        }
        if (value instanceof Boolean) {
            array.pushBoolean(((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Number) {
            array.pushDouble(((Number) value).doubleValue());
            return;
        }
        if (value instanceof String) {
            array.pushString((String) value);
            return;
        }
        if (value instanceof JSONObject) {
            array.pushMap(jsonObjectToReadableMap((JSONObject) value));
            return;
        }
        if (value instanceof JSONArray) {
            array.pushArray(jsonArrayToReadableArray((JSONArray) value));
            return;
        }
        FLog.w(ReactConstants.TAG, "Unsupported text effect prop type: " + value.getClass().getName());
    }
}
