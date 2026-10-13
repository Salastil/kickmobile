package com.facebook.react.views.textinput;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.util.Predicate;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextDecorationStyle;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.internal.span.CanvasEffectSpan;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import io.ktor.http.LinkHeader;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactEditText.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ù\u00012\u00020\u0001:\u0006÷\u0001ø\u0001ù\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010j\u001a\u00020kH\u0005J\b\u0010l\u001a\u00020\u000bH\u0016J0\u0010m\u001a\u00020k2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u0010H\u0014J\u0010\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020uH\u0016J\u0018\u0010v\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020k2\u0006\u0010{\u001a\u00020\u0010H\u0016J)\u0010|\u001a\u00020k2\u0006\u0010}\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u0010H\u0014J\u0016\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0016J\u000f\u0010\u0087\u0001\u001a\u00020kH\u0000¢\u0006\u0003\b\u0088\u0001J\u000f\u0010\u0089\u0001\u001a\u00020kH\u0000¢\u0006\u0003\b\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020k2\u0007\u0010\u008d\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020k2\u0007\u0010\u008d\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020k2\b\u0010.\u001a\u0004\u0018\u00010/J\u0011\u0010\u0090\u0001\u001a\u00020k2\b\u00100\u001a\u0004\u0018\u000101J\"\u0010\u0091\u0001\u001a\u00020k2\u0007\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0007\u0010\u0094\u0001\u001a\u00020\u0010J\u001b\u0010\u0091\u0001\u001a\u00020k2\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0007\u0010\u0094\u0001\u001a\u00020\u0010H\u0002J\u0011\u0010\u0095\u0001\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0002J\u001b\u0010\u0096\u0001\u001a\u00020k2\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0007\u0010\u0094\u0001\u001a\u00020\u0010H\u0016J\u001b\u0010\u0097\u0001\u001a\u00020k2\u0007\u0010\u0098\u0001\u001a\u00020\u00102\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0014J'\u0010\u009a\u0001\u001a\u00020k2\u0007\u0010\u009b\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020\u00102\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0014J\u0019\u0010\u009f\u0001\u001a\u00020k2\b\u0010,\u001a\u0004\u0018\u00010-H\u0000¢\u0006\u0003\b \u0001J\u000f\u0010¡\u0001\u001a\u00020k2\u0006\u00106\u001a\u00020\u000bJ\u0007\u0010¢\u0001\u001a\u00020\u000bJ\u0007\u0010£\u0001\u001a\u00020\u000bJ\u000f\u0010¤\u0001\u001a\u00020kH\u0000¢\u0006\u0003\b¥\u0001J\u0012\u0010¦\u0001\u001a\u00020k2\u0007\u0010§\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010¨\u0001\u001a\u00020k2\b\u0010D\u001a\u0004\u0018\u00010\tJ\t\u0010©\u0001\u001a\u00020kH\u0002J\u0011\u0010ª\u0001\u001a\u00020k2\b\u0010:\u001a\u0004\u0018\u00010\tJ\u0012\u0010«\u0001\u001a\u00020k2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u00ad\u0001\u001a\u00020k2\t\u0010®\u0001\u001a\u0004\u0018\u00010\tJ\u001a\u0010¯\u0001\u001a\u00020k2\t\u0010°\u0001\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0003\b±\u0001J\u0014\u0010²\u0001\u001a\u00020k2\t\u0010³\u0001\u001a\u0004\u0018\u00010\tH\u0016J\u0007\u0010´\u0001\u001a\u00020kJ\u0007\u0010µ\u0001\u001a\u00020kJ\u0007\u0010¶\u0001\u001a\u00020\u0010J\u0019\u0010·\u0001\u001a\u00020k2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0000¢\u0006\u0003\bº\u0001J\u0019\u0010»\u0001\u001a\u00020k2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0000¢\u0006\u0003\b¼\u0001J\u0010\u0010½\u0001\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020\u0010J\u0013\u0010¾\u0001\u001a\u00020k2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0002J\u0013\u0010¿\u0001\u001a\u00020k2\b\u0010À\u0001\u001a\u00030Á\u0001H\u0002J\u0013\u0010Â\u0001\u001a\u00020k2\b\u0010Ã\u0001\u001a\u00030Á\u0001H\u0002J<\u0010Ä\u0001\u001a\u00020k\"\u0005\b\u0000\u0010Å\u00012\b\u0010Ã\u0001\u001a\u00030Á\u00012\u000f\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u0003HÅ\u00010Ç\u00012\u000f\u0010È\u0001\u001a\n\u0012\u0005\u0012\u0003HÅ\u00010É\u0001H\u0002J\u0013\u0010Ê\u0001\u001a\u00020k2\b\u0010Ë\u0001\u001a\u00030Á\u0001H\u0002J\t\u0010Ì\u0001\u001a\u00020\u000bH\u0004J\t\u0010Í\u0001\u001a\u00020kH\u0002J\t\u0010Î\u0001\u001a\u00020kH\u0004J\t\u0010Ï\u0001\u001a\u00020kH\u0002J\t\u0010Ð\u0001\u001a\u00020kH\u0002J\t\u0010Ñ\u0001\u001a\u00020kH\u0002J\u0013\u0010Ò\u0001\u001a\u00020k2\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0016J\t\u0010Õ\u0001\u001a\u00020kH\u0016J\u0012\u0010Ö\u0001\u001a\u00020k2\u0007\u0010×\u0001\u001a\u00020\u0010H\u0016J\u001a\u0010Ø\u0001\u001a\u00020k2\u0007\u0010Ù\u0001\u001a\u00020\u00102\b\u0010Ú\u0001\u001a\u00030Û\u0001J!\u0010Ü\u0001\u001a\u00020k2\u0007\u0010Ù\u0001\u001a\u00020\u00102\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0010¢\u0006\u0003\u0010Ý\u0001J\u0010\u0010Þ\u0001\u001a\u00020\u00102\u0007\u0010Ù\u0001\u001a\u00020\u0010J\u0011\u0010ß\u0001\u001a\u00020k2\b\u0010à\u0001\u001a\u00030Û\u0001J\u001a\u0010ß\u0001\u001a\u00020k2\b\u0010à\u0001\u001a\u00030Û\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0010J\u0012\u0010á\u0001\u001a\u00020k2\t\u0010â\u0001\u001a\u0004\u0018\u00010\tJ\u0011\u0010ã\u0001\u001a\u00020k2\b\u0010ä\u0001\u001a\u00030Û\u0001J\u0010\u0010å\u0001\u001a\u00020k2\u0007\u0010æ\u0001\u001a\u00020\u000bJ\u0011\u0010ç\u0001\u001a\u00020k2\b\u0010è\u0001\u001a\u00030Û\u0001J\u0011\u0010é\u0001\u001a\u00020k2\b\u0010ê\u0001\u001a\u00030Û\u0001J\u000f\u0010ë\u0001\u001a\u00020k2\u0006\u0010@\u001a\u00020\u000bJ\u000f\u0010ì\u0001\u001a\u00020k2\u0006\u0010C\u001a\u00020\u000bJ\u000f\u0010í\u0001\u001a\u00020k2\u0006\u0010A\u001a\u00020\u000bJ\t\u0010î\u0001\u001a\u00020kH\u0004J\t\u0010ï\u0001\u001a\u00020kH\u0002J\u0011\u0010ð\u0001\u001a\u00020k2\b\u0010U\u001a\u0004\u0018\u00010VJ\u0011\u0010ñ\u0001\u001a\u00020k2\b\u0010F\u001a\u0004\u0018\u00010\tJ\u0013\u0010ò\u0001\u001a\u00020k2\b\u0010ó\u0001\u001a\u00030ô\u0001H\u0016J\u0012\u0010õ\u0001\u001a\u00020\u000b2\u0007\u0010x\u001a\u00030ö\u0001H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\b4R\u000e\u00105\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"R\u000e\u0010@\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u00020E2\u0006\u0010=\u001a\u00020E@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR\u001a\u0010S\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010W\u001a\b\u0018\u00010XR\u00020\u00008BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\fR\u0014\u0010]\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\fR$\u0010^\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010\f\"\u0004\b`\u0010\u000eR(\u0010a\u001a\u0004\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\"\"\u0004\bc\u0010$R$\u0010d\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\be\u0010\u0014\"\u0004\bf\u0010\u0016R$\u0010g\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bh\u0010\u0014\"\u0004\bi\u0010\u0016¨\u0006ú\u0001"}, d2 = {"Lcom/facebook/react/views/textinput/ReactEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "TAG", "", "isSettingTextFromJS", "", "()Z", "setSettingTextFromJS", "(Z)V", "defaultGravityHorizontal", "", "defaultGravityVertical", "nativeEventCount", "getNativeEventCount", "()I", "setNativeEventCount", "(I)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/text/TextWatcher;", "stagedInputType", "getStagedInputType", "setStagedInputType", "stagedAutoCapitalize", "getStagedAutoCapitalize$ReactAndroid", "setStagedAutoCapitalize$ReactAndroid", "submitBehavior", "getSubmitBehavior", "()Ljava/lang/String;", "setSubmitBehavior", "(Ljava/lang/String;)V", "dragAndDropFilter", "", "getDragAndDropFilter", "()Ljava/util/List;", "setDragAndDropFilter", "(Ljava/util/List;)V", "disableFullscreen", "selectionWatcher", "Lcom/facebook/react/views/textinput/SelectionWatcher;", "contentSizeWatcher", "Lcom/facebook/react/views/textinput/ContentSizeWatcher;", "scrollWatcher", "Lcom/facebook/react/views/textinput/ScrollWatcher;", "keyListener", "Lcom/facebook/react/views/textinput/ReactEditText$InternalKeyListener;", "keyListener$1", "detectScrollMovement", "onKeyPress", "textAttributes", "Lcom/facebook/react/views/text/TextAttributes;", "typefaceDirty", ViewProps.FONT_FAMILY, ViewProps.FONT_WEIGHT, ViewProps.FONT_STYLE, "value", "parsedFontVariationSettings", "getParsedFontVariationSettings$ReactAndroid", "autoFocus", "contextMenuHidden", "didAttachToWindow", "selectTextOnFocus", "placeholder", "Lcom/facebook/react/uimanager/style/Overflow;", ViewProps.OVERFLOW, "getOverflow$ReactAndroid", "()Lcom/facebook/react/uimanager/style/Overflow;", "wasMultiline", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "disableTextDiffing", "getDisableTextDiffing$ReactAndroid", "setDisableTextDiffing$ReactAndroid", "isSettingTextFromState", "setSettingTextFromState", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "textWatcherDelegator", "Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;", "getTextWatcherDelegator", "()Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;", "isMultiline", "isMultiline$ReactAndroid", "isSecureText", "disableFullscreenUI", "getDisableFullscreenUI", "setDisableFullscreenUI", "returnKeyType", "getReturnKeyType", "setReturnKeyType", "gravityHorizontal", "getGravityHorizontal$ReactAndroid", "setGravityHorizontal$ReactAndroid", "gravityVertical", "getGravityVertical$ReactAndroid", "setGravityVertical$ReactAndroid", "finalize", "", "isLayoutRequested", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "setLineHeight", ViewProps.LINE_HEIGHT, "onScrollChanged", "horiz", "vert", "oldHoriz", "oldVert", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onTextContextMenuItem", "id", "clearFocusAndMaybeRefocus", "clearFocusAndMaybeRefocus$ReactAndroid", "clearFocusFromJS", "clearFocusFromJS$ReactAndroid", "requestFocusProgrammatically", "addTextChangedListener", "watcher", "removeTextChangedListener", "setContentSizeWatcher", "setScrollWatcher", "maybeSetSelection", "eventCounter", ViewProps.START, ViewProps.END, "clampToTextLength", "setSelection", "onSelectionChanged", "selStart", "selEnd", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setSelectionWatcher", "setSelectionWatcher$ReactAndroid", "setOnKeyPress", "shouldBlurOnReturn", "shouldSubmitOnReturn", "commitStagedInputType", "commitStagedInputType$ReactAndroid", "setInputType", "type", "setPlaceholder", "updatePlaceholderEllipsize", "setFontFamily", "setFontWeight", "fontWeightString", "setFontStyle", "fontStyleString", "setReactFontVariationSettings", ViewProps.FONT_VARIATION_SETTINGS, "setReactFontVariationSettings$ReactAndroid", "setFontFeatureSettings", "fontFeatureSettings", "maybeUpdateTypeface", "requestFocusFromJS", "incrementAndGetEventCounter", "maybeSetTextFromJS", "reactTextUpdate", "Lcom/facebook/react/views/text/ReactTextUpdate;", "maybeSetTextFromJS$ReactAndroid", "maybeSetTextFromState", "maybeSetTextFromState$ReactAndroid", "canUpdateWithEventCount", "maybeSetText", "manageSpans", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "stripStyleEquivalentSpans", "sb", "stripSpansOfKind", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "shouldStrip", "Landroidx/core/util/Predicate;", "addSpansFromStyleAttributes", "workingText", "showSoftKeyboard", "showSoftKeyboardIfEditable", "hideSoftKeyboard", "onContentSizeChange", "setIntrinsicContentSize", "updateImeOptions", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAttachedToWindow", "setBackgroundColor", "color", "setBorderWidth", ViewProps.POSITION, ViewProps.WIDTH, "", "setBorderColor", "(ILjava/lang/Integer;)V", "getBorderColor", "setBorderRadius", ViewProps.BORDER_RADIUS, "setBorderStyle", "style", "setLetterSpacingPt", "letterSpacingPt", "setAllowFontScaling", ViewProps.ALLOW_FONT_SCALING, "setFontSize", ViewProps.FONT_SIZE, "setMaxFontSizeMultiplier", ViewProps.MAX_FONT_SIZE_MULTIPLIER, "setAutoFocus", "setSelectTextOnFocus", "setContextMenuHidden", "applyTextAttributes", "updateCachedSpannable", "setEventDispatcher", "setOverflow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDragEvent", "Landroid/view/DragEvent;", "TextWatcherDelegator", "InternalKeyListener", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG_MODE;
    private static final KeyListener keyListener;
    private final String TAG;
    private boolean autoFocus;
    private ContentSizeWatcher contentSizeWatcher;
    private boolean contextMenuHidden;
    private final int defaultGravityHorizontal;
    private final int defaultGravityVertical;
    private boolean detectScrollMovement;
    private boolean didAttachToWindow;
    private boolean disableFullscreen;
    private boolean disableTextDiffing;
    private List<String> dragAndDropFilter;
    private EventDispatcher eventDispatcher;
    private String fontFamily;
    private int fontStyle;
    private int fontWeight;
    private final InputMethodManager inputMethodManager;
    private boolean isSettingTextFromJS;
    private boolean isSettingTextFromState;

    /* JADX INFO: renamed from: keyListener$1, reason: from kotlin metadata */
    private InternalKeyListener keyListener;
    private CopyOnWriteArrayList<TextWatcher> listeners;
    private int nativeEventCount;
    private boolean onKeyPress;
    private Overflow overflow;
    private String parsedFontVariationSettings;
    private String placeholder;
    private String returnKeyType;
    private ScrollWatcher scrollWatcher;
    private boolean selectTextOnFocus;
    private SelectionWatcher selectionWatcher;
    private int stagedAutoCapitalize;
    private int stagedInputType;
    private StateWrapper stateWrapper;
    private String submitBehavior;
    private final TextAttributes textAttributes;
    private TextWatcherDelegator textWatcherDelegator;
    private boolean typefaceDirty;
    private boolean wasMultiline;

    @Override // android.view.View
    public boolean isLayoutRequested() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue("ReactEditText", "getSimpleName(...)");
        this.TAG = "ReactEditText";
        this.fontWeight = -1;
        this.fontStyle = -1;
        this.overflow = Overflow.VISIBLE;
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.inputMethodManager = (InputMethodManager) systemService;
        this.defaultGravityHorizontal = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        this.defaultGravityVertical = getGravity() & 112;
        this.nativeEventCount = 0;
        this.isSettingTextFromJS = false;
        this.disableFullscreen = false;
        this.listeners = null;
        this.stagedInputType = getInputType();
        if (this.keyListener == null) {
            this.keyListener = new InternalKeyListener();
        }
        this.scrollWatcher = null;
        this.textAttributes = new TextAttributes();
        applyTextAttributes();
        if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27) {
            setLayerType(1, null);
        }
        final boolean zIsFocusable = isFocusable();
        final int importantForAccessibility = getImportantForAccessibility();
        ViewCompat.setAccessibilityDelegate(this, new ReactAccessibilityDelegate(zIsFocusable, importantForAccessibility) { // from class: com.facebook.react.views.textinput.ReactEditText$editTextAccessibilityDelegate$1
            {
                ReactEditText reactEditText = this.this$0;
            }

            @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View host, int action, Bundle args) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (action == 16) {
                    Editable text = this.this$0.getText();
                    if (text != null) {
                        int length = text.length();
                        if (length > 0) {
                            this.this$0.setSelection(length);
                        }
                        return this.this$0.requestFocusProgrammatically();
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                return super.performAccessibilityAction(host, action, args);
            }
        });
        ActionMode.Callback callback = new ActionMode.Callback() { // from class: com.facebook.react.views.textinput.ReactEditText$customActionModeCallback$1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(item, "item");
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                if (this.this$0.contextMenuHidden) {
                    return false;
                }
                this.this$0.showSoftKeyboardIfEditable();
                menu.removeItem(R.id.pasteAsPlainText);
                return true;
            }
        };
        setCustomSelectionActionModeCallback(callback);
        setCustomInsertionActionModeCallback(callback);
    }

    /* JADX INFO: renamed from: isSettingTextFromJS, reason: from getter */
    protected final boolean getIsSettingTextFromJS() {
        return this.isSettingTextFromJS;
    }

    protected final void setSettingTextFromJS(boolean z) {
        this.isSettingTextFromJS = z;
    }

    protected final int getNativeEventCount() {
        return this.nativeEventCount;
    }

    protected final void setNativeEventCount(int i) {
        this.nativeEventCount = i;
    }

    public final int getStagedInputType() {
        return this.stagedInputType;
    }

    public final void setStagedInputType(int i) {
        this.stagedInputType = i;
    }

    /* JADX INFO: renamed from: getStagedAutoCapitalize$ReactAndroid, reason: from getter */
    public final int getStagedAutoCapitalize() {
        return this.stagedAutoCapitalize;
    }

    public final void setStagedAutoCapitalize$ReactAndroid(int i) {
        this.stagedAutoCapitalize = i;
    }

    public final String getSubmitBehavior() {
        return this.submitBehavior;
    }

    public final void setSubmitBehavior(String str) {
        this.submitBehavior = str;
    }

    public final List<String> getDragAndDropFilter() {
        return this.dragAndDropFilter;
    }

    public final void setDragAndDropFilter(List<String> list) {
        this.dragAndDropFilter = list;
    }

    /* JADX INFO: renamed from: getParsedFontVariationSettings$ReactAndroid, reason: from getter */
    public final String getParsedFontVariationSettings() {
        return this.parsedFontVariationSettings;
    }

    /* JADX INFO: renamed from: getOverflow$ReactAndroid, reason: from getter */
    public final Overflow getOverflow() {
        return this.overflow;
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    /* JADX INFO: renamed from: getDisableTextDiffing$ReactAndroid, reason: from getter */
    public final boolean getDisableTextDiffing() {
        return this.disableTextDiffing;
    }

    public final void setDisableTextDiffing$ReactAndroid(boolean z) {
        this.disableTextDiffing = z;
    }

    /* JADX INFO: renamed from: isSettingTextFromState, reason: from getter */
    protected final boolean getIsSettingTextFromState() {
        return this.isSettingTextFromState;
    }

    protected final void setSettingTextFromState(boolean z) {
        this.isSettingTextFromState = z;
    }

    private final TextWatcherDelegator getTextWatcherDelegator() {
        if (this.textWatcherDelegator == null) {
            this.textWatcherDelegator = new TextWatcherDelegator();
        }
        return this.textWatcherDelegator;
    }

    public final boolean isMultiline$ReactAndroid() {
        return (getInputType() & 131072) != 0;
    }

    private final boolean isSecureText() {
        return (getInputType() & 144) != 0;
    }

    /* JADX INFO: renamed from: getDisableFullscreenUI, reason: from getter */
    public final boolean getDisableFullscreen() {
        return this.disableFullscreen;
    }

    public final void setDisableFullscreenUI(boolean z) {
        this.disableFullscreen = z;
        updateImeOptions();
    }

    public final String getReturnKeyType() {
        return this.returnKeyType;
    }

    public final void setReturnKeyType(String str) {
        this.returnKeyType = str;
        updateImeOptions();
    }

    public final int getGravityHorizontal$ReactAndroid() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    public final void setGravityHorizontal$ReactAndroid(int i) {
        if (i == 0) {
            i = this.defaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & (-8388616)));
    }

    public final int getGravityVertical$ReactAndroid() {
        return getGravity() & 112;
    }

    public final void setGravityVertical$ReactAndroid(int i) {
        if (i == 0) {
            i = this.defaultGravityVertical;
        }
        setGravity(i | (getGravity() & (-113)));
    }

    protected final void finalize() {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "finalize[" + getId() + "] delete cached spannable");
        }
        TextLayoutManager.INSTANCE.deleteCachedSpannableForTag(getId());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        onContentSizeChange();
        if (this.selectTextOnFocus && isFocused()) {
            selectAll();
            this.selectTextOnFocus = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.detectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.detectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.detectScrollMovement = false;
        }
        return super.onTouchEvent(ev);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 66 && !isMultiline$ReactAndroid()) {
            hideSoftKeyboard();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int lineHeight) {
        this.textAttributes.setLineHeight(lineHeight);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        ScrollWatcher scrollWatcher = this.scrollWatcher;
        if (scrollWatcher != null) {
            scrollWatcher.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        ReactEditTextInputConnectionWrapper reactEditTextInputConnectionWrapperOnCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (reactEditTextInputConnectionWrapperOnCreateInputConnection != null && this.onKeyPress) {
            EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher != null) {
                reactEditTextInputConnectionWrapperOnCreateInputConnection = new ReactEditTextInputConnectionWrapper(reactEditTextInputConnectionWrapperOnCreateInputConnection, reactContext, this, eventDispatcher);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        if (isMultiline$ReactAndroid() && (shouldBlurOnReturn() || shouldSubmitOnReturn())) {
            outAttrs.imeOptions &= -1073741825;
        }
        return reactEditTextInputConnectionWrapperOnCreateInputConnection;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id) {
        if (id == 16908322) {
            id = R.id.pasteAsPlainText;
        }
        return super.onTextContextMenuItem(id);
    }

    public final void clearFocusAndMaybeRefocus$ReactAndroid() {
        if (Build.VERSION.SDK_INT > 28 || !isInTouchMode()) {
            super.clearFocus();
        } else {
            View rootView = getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup != null) {
                int descendantFocusability = viewGroup.getDescendantFocusability();
                viewGroup.setDescendantFocusability(393216);
                super.clearFocus();
                viewGroup.setDescendantFocusability(descendantFocusability);
            } else {
                super.clearFocus();
            }
        }
        hideSoftKeyboard();
    }

    public final void clearFocusFromJS$ReactAndroid() {
        clearFocusAndMaybeRefocus$ReactAndroid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean requestFocusProgrammatically() {
        boolean zRequestFocus = super.requestFocus(130, null);
        if (isInTouchMode() && getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
        return zRequestFocus;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        if (this.listeners == null) {
            this.listeners = new CopyOnWriteArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        CopyOnWriteArrayList<TextWatcher> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(watcher);
        }
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        CopyOnWriteArrayList<TextWatcher> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(watcher);
            if (copyOnWriteArrayList.isEmpty()) {
                this.listeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public final void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.contentSizeWatcher = contentSizeWatcher;
    }

    public final void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.scrollWatcher = scrollWatcher;
    }

    public final void maybeSetSelection(int eventCounter, int start, int end) {
        if (canUpdateWithEventCount(eventCounter)) {
            maybeSetSelection(start, end);
        }
    }

    private final void maybeSetSelection(int start, int end) {
        if (start == -1 || end == -1) {
            return;
        }
        setSelection(clampToTextLength(start), clampToTextLength(end));
    }

    private final int clampToTextLength(int value) {
        int length;
        if (getText() == null) {
            length = 0;
        } else {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            length = text.length();
        }
        return (int) Math.max(0.0d, Math.min(value, length));
    }

    @Override // android.widget.EditText
    public void setSelection(int start, int end) {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "setSelection[" + getId() + "]: " + start + ServerSentEventKt.SPACE + end);
        }
        super.setSelection(start, end);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        SelectionWatcher selectionWatcher;
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "onSelectionChanged[" + getId() + "]: " + selStart + ServerSentEventKt.SPACE + selEnd);
        }
        super.onSelectionChanged(selStart, selEnd);
        if (this.selectionWatcher == null || !hasFocus() || (selectionWatcher = this.selectionWatcher) == null) {
            return;
        }
        selectionWatcher.onSelectionChanged(selStart, selEnd);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && (selectionWatcher = this.selectionWatcher) != null && selectionWatcher != null) {
            selectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
        if (focused && hasSelection()) {
            showSoftKeyboardIfEditable();
        }
    }

    public final void setSelectionWatcher$ReactAndroid(SelectionWatcher selectionWatcher) {
        this.selectionWatcher = selectionWatcher;
    }

    public final void setOnKeyPress(boolean onKeyPress) {
        this.onKeyPress = onKeyPress;
    }

    public final boolean shouldBlurOnReturn() {
        String str = this.submitBehavior;
        if (str == null) {
            return !isMultiline$ReactAndroid();
        }
        return Intrinsics.areEqual(str, "blurAndSubmit");
    }

    public final boolean shouldSubmitOnReturn() {
        String str = this.submitBehavior;
        if (str == null) {
            return !isMultiline$ReactAndroid();
        }
        return Intrinsics.areEqual(str, "submit") || Intrinsics.areEqual(str, "blurAndSubmit");
    }

    public final void commitStagedInputType$ReactAndroid() {
        if (getInputType() != this.stagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.stagedInputType);
            maybeSetSelection(selectionStart, selectionEnd);
        }
    }

    @Override // android.widget.TextView
    public void setInputType(int type) {
        Typeface typeface = super.getTypeface();
        super.setInputType(type);
        this.stagedInputType = type;
        super.setTypeface(typeface);
        if (isMultiline$ReactAndroid()) {
            setSingleLine(false);
        } else if (!isSecureText()) {
            setSingleLine(true);
        }
        if (this.wasMultiline && !isMultiline$ReactAndroid() && isLaidOut() && getWidth() > 0 && getHeight() > 0) {
            forceLayout();
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
        this.wasMultiline = isMultiline$ReactAndroid();
        updatePlaceholderEllipsize();
        if (this.keyListener == null) {
            this.keyListener = new InternalKeyListener();
        }
        InternalKeyListener internalKeyListener = this.keyListener;
        if (internalKeyListener != null) {
            internalKeyListener.setInputType(type);
        }
        super.setKeyListener(this.keyListener);
    }

    public final void setPlaceholder(String placeholder) {
        if (!Intrinsics.areEqual(placeholder, this.placeholder)) {
            this.placeholder = placeholder;
            setHint(placeholder);
        }
        updatePlaceholderEllipsize();
    }

    private final void updatePlaceholderEllipsize() {
        setEllipsize(!isMultiline$ReactAndroid() ? TextUtils.TruncateAt.END : null);
    }

    public final void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        this.typefaceDirty = true;
    }

    public final void setFontWeight(String fontWeightString) {
        int fontWeight = ReactTypefaceUtils.parseFontWeight(fontWeightString);
        if (fontWeight != this.fontWeight) {
            this.fontWeight = fontWeight;
            this.typefaceDirty = true;
        }
    }

    public final void setFontStyle(String fontStyleString) {
        int fontStyle = ReactTypefaceUtils.parseFontStyle(fontStyleString);
        if (fontStyle != this.fontStyle) {
            this.fontStyle = fontStyle;
            this.typefaceDirty = true;
        }
    }

    public final void setReactFontVariationSettings$ReactAndroid(String fontVariationSettings) {
        String fontVariationSettings$ReactAndroid = ReactTypefaceUtils.INSTANCE.parseFontVariationSettings$ReactAndroid(fontVariationSettings);
        if (Intrinsics.areEqual(fontVariationSettings$ReactAndroid, this.parsedFontVariationSettings)) {
            return;
        }
        this.parsedFontVariationSettings = fontVariationSettings$ReactAndroid;
        this.typefaceDirty = true;
    }

    @Override // android.widget.TextView
    public void setFontFeatureSettings(String fontFeatureSettings) {
        if (Intrinsics.areEqual(fontFeatureSettings, getFontFeatureSettings())) {
            return;
        }
        super.setFontFeatureSettings(fontFeatureSettings);
        this.typefaceDirty = true;
    }

    public final void maybeUpdateTypeface() {
        int paintFlags;
        int paintFlags2;
        if (this.typefaceDirty) {
            this.typefaceDirty = false;
            Typeface typeface = getTypeface();
            int i = this.fontStyle;
            int i2 = this.fontWeight;
            String str = this.fontFamily;
            AssetManager assets = getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            setTypeface(ReactTypefaceUtils.applyStyles(typeface, i, i2, str, assets));
            if (Build.VERSION.SDK_INT >= 26) {
                super.setFontVariationSettings(this.parsedFontVariationSettings);
            }
            boolean z = (this.fontStyle == -1 && this.fontWeight == -1 && this.fontFamily == null && getFontFeatureSettings() == null && this.parsedFontVariationSettings == null) ? false : true;
            if (z) {
                paintFlags = getPaintFlags() | 128;
            } else {
                paintFlags = getPaintFlags() & (-129);
            }
            setPaintFlags(paintFlags);
            if (z) {
                paintFlags2 = getPaintFlags() | 64;
            } else {
                paintFlags2 = getPaintFlags() & (-65);
            }
            setPaintFlags(paintFlags2);
        }
    }

    public final void requestFocusFromJS() {
        requestFocusProgrammatically();
    }

    public final int incrementAndGetEventCounter() {
        int i = this.nativeEventCount + 1;
        this.nativeEventCount = i;
        return i;
    }

    public final void maybeSetTextFromJS$ReactAndroid(ReactTextUpdate reactTextUpdate) {
        Intrinsics.checkNotNullParameter(reactTextUpdate, "reactTextUpdate");
        this.isSettingTextFromJS = true;
        maybeSetText(reactTextUpdate);
        this.isSettingTextFromJS = false;
    }

    public final void maybeSetTextFromState$ReactAndroid(ReactTextUpdate reactTextUpdate) {
        Intrinsics.checkNotNullParameter(reactTextUpdate, "reactTextUpdate");
        this.isSettingTextFromState = true;
        maybeSetText(reactTextUpdate);
        this.isSettingTextFromState = false;
    }

    public final boolean canUpdateWithEventCount(int eventCounter) {
        return eventCounter >= this.nativeEventCount;
    }

    private final void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if (!(isSecureText() && TextUtils.equals(getText(), reactTextUpdate.getText())) && canUpdateWithEventCount(reactTextUpdate.getJsEventCounter())) {
            if (DEBUG_MODE) {
                FLog.e(this.TAG, "maybeSetText[" + getId() + "]: current text: " + ((Object) getText()) + " update: " + ((Object) reactTextUpdate.getText()));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
            manageSpans(spannableStringBuilder);
            stripStyleEquivalentSpans(spannableStringBuilder);
            this.disableTextDiffing = true;
            if (reactTextUpdate.getText().length() == 0) {
                setText((CharSequence) null);
            } else {
                Editable text = getText();
                if (text == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                text.replace(0, length(), spannableStringBuilder);
            }
            this.disableTextDiffing = false;
            if (getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            updateCachedSpannable();
        }
    }

    private final void manageSpans(SpannableStringBuilder spannableStringBuilder) {
        Editable text = getText();
        if (text == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        for (Object obj : text.getSpans(0, length(), Object.class)) {
            int spanFlags = text.getSpanFlags(obj);
            boolean z = (spanFlags & 33) == 33;
            if (obj instanceof ReactSpan) {
                text.removeSpan(obj);
            }
            if (z) {
                int spanStart = text.getSpanStart(obj);
                int spanEnd = text.getSpanEnd(obj);
                text.removeSpan(obj);
                if (INSTANCE.sameTextForSpan(text, spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    private final void stripStyleEquivalentSpans(SpannableStringBuilder sb) {
        stripSpansOfKind(sb, ReactAbsoluteSizeSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$1(this.f$0, (ReactAbsoluteSizeSpan) obj);
            }
        });
        stripSpansOfKind(sb, ReactBackgroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$2(this.f$0, (ReactBackgroundColorSpan) obj);
            }
        });
        stripSpansOfKind(sb, ReactForegroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$3(this.f$0, (ReactForegroundColorSpan) obj);
            }
        });
        stripSpansOfKind(sb, ReactStrikethroughSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$4(this.f$0, (ReactStrikethroughSpan) obj);
            }
        });
        stripSpansOfKind(sb, ReactUnderlineSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$5(this.f$0, (ReactUnderlineSpan) obj);
            }
        });
        stripSpansOfKind(sb, CustomLetterSpacingSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$6(this.f$0, (CustomLetterSpacingSpan) obj);
            }
        });
        final int i = this.fontStyle;
        if (i == -1) {
            i = 0;
        }
        final int i2 = this.fontWeight;
        if (i2 == -1) {
            i2 = 400;
        }
        stripSpansOfKind(sb, CustomStyleSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$7(i, this, i2, (CustomStyleSpan) obj);
            }
        });
    }

    static final boolean stripStyleEquivalentSpans$lambda$1(ReactEditText reactEditText, ReactAbsoluteSizeSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getSize() == reactEditText.textAttributes.getEffectiveFontSize();
    }

    static final boolean stripStyleEquivalentSpans$lambda$2(ReactEditText reactEditText, ReactBackgroundColorSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        int backgroundColor = span.getBackgroundColor();
        Integer backgroundColor2 = BackgroundStyleApplicator.getBackgroundColor(reactEditText);
        return backgroundColor2 != null && backgroundColor == backgroundColor2.intValue();
    }

    static final boolean stripStyleEquivalentSpans$lambda$3(ReactEditText reactEditText, ReactForegroundColorSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getForegroundColor() == reactEditText.getCurrentTextColor();
    }

    static final boolean stripStyleEquivalentSpans$lambda$4(ReactEditText reactEditText, ReactStrikethroughSpan reactStrikethroughSpan) {
        return (reactEditText.getPaintFlags() & 16) != 0;
    }

    static final boolean stripStyleEquivalentSpans$lambda$5(ReactEditText reactEditText, ReactUnderlineSpan reactUnderlineSpan) {
        return (reactEditText.getPaintFlags() & 8) != 0;
    }

    static final boolean stripStyleEquivalentSpans$lambda$6(ReactEditText reactEditText, CustomLetterSpacingSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getSpacing() == reactEditText.textAttributes.getEffectiveLetterSpacing();
    }

    static final boolean stripStyleEquivalentSpans$lambda$7(int i, ReactEditText reactEditText, int i2, CustomStyleSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getStyle() == i && Intrinsics.areEqual(span.getFontFamily(), reactEditText.fontFamily) && span.getWeight() == i2 && Intrinsics.areEqual(span.getFontFeatureSettings(), reactEditText.getFontFeatureSettings()) && Intrinsics.areEqual(span.getFontVariationSettings(), reactEditText.parsedFontVariationSettings);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> void stripSpansOfKind(SpannableStringBuilder sb, Class<T> clazz, Predicate<T> shouldStrip) {
        Iterator it = ArrayIteratorKt.iterator(sb.getSpans(0, sb.length(), clazz));
        while (it.hasNext()) {
            Object next = it.next();
            if (shouldStrip.test(next)) {
                sb.removeSpan(next);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addSpansFromStyleAttributes(SpannableStringBuilder workingText) {
        int i = 0;
        workingText.setSpan(new ReactAbsoluteSizeSpan(this.textAttributes.getEffectiveFontSize()), 0, workingText.length(), 16711698);
        workingText.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, workingText.length(), 16711698);
        Integer backgroundColor = BackgroundStyleApplicator.getBackgroundColor(this);
        if (backgroundColor != null && backgroundColor.intValue() != 0) {
            workingText.setSpan(new ReactBackgroundColorSpan(backgroundColor.intValue()), 0, workingText.length(), 16711698);
        }
        int i2 = 3;
        TextDecorationStyle textDecorationStyle = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if ((getPaintFlags() & 16) != 0) {
            workingText.setSpan(new ReactStrikethroughSpan(i, textDecorationStyle, i2, objArr3 == true ? 1 : 0), 0, workingText.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            workingText.setSpan(new ReactUnderlineSpan(i, objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0), 0, workingText.length(), 16711698);
        }
        float effectiveLetterSpacing = this.textAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            workingText.setSpan(new CustomLetterSpacingSpan(effectiveLetterSpacing), 0, workingText.length(), 16711698);
        }
        if (this.fontStyle != -1 || this.fontWeight != -1 || this.fontFamily != null || getFontFeatureSettings() != null || this.parsedFontVariationSettings != null) {
            int i3 = this.fontStyle;
            int i4 = this.fontWeight;
            String fontFeatureSettings = getFontFeatureSettings();
            String str = this.parsedFontVariationSettings;
            String str2 = this.fontFamily;
            AssetManager assets = getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            workingText.setSpan(new CustomStyleSpan(i3, i4, fontFeatureSettings, str, str2, assets, ReactTypefaceUtils.getFontWeightAdjustment(context)), 0, workingText.length(), 16711698);
        }
        float effectiveLineHeight = this.textAttributes.getEffectiveLineHeight();
        if (Float.isNaN(effectiveLineHeight)) {
            return;
        }
        workingText.setSpan(new CustomLineHeightSpan(effectiveLineHeight), 0, workingText.length(), 16711698);
    }

    protected final boolean showSoftKeyboard() {
        return this.inputMethodManager.showSoftInput(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSoftKeyboardIfEditable() {
        if (isEnabled() && isInTouchMode() && getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
    }

    protected final void hideSoftKeyboard() {
        this.inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.contentSizeWatcher;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    private final void setIntrinsicContentSize() {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE || this.stateWrapper != null || reactContext.isBridgeless()) {
            return;
        }
        ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
        UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
        }
    }

    private final void updateImeOptions() {
        String str = this.returnKeyType;
        int i = 6;
        if (str != null) {
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        i = 7;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        i = 3;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        i = 2;
                    }
                    break;
                case 3089282:
                    str.equals("done");
                    break;
                case 3377907:
                    if (str.equals(LinkHeader.Rel.Next)) {
                        i = 5;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        i = 1;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        i = 4;
                    }
                    break;
            }
        }
        if (this.disableFullscreen) {
            i |= GroupFlagsKt.HasAuxSlotFlag;
        }
        setImeOptions(i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture() && ReactNativeFeatureFlags.enableFontScaleChangesUpdatingLayout()) {
            applyTextAttributes();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setTextIsSelectable(true);
        maybeSetSelection(selectionStart, selectionEnd);
        if (this.autoFocus && !this.didAttachToWindow) {
            requestFocusProgrammatically();
        }
        this.didAttachToWindow = true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(color));
    }

    public final void setBorderWidth(int position, float width) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.getEntries().get(position), Float.valueOf(PixelUtil.toDIPFromPixel(width)));
    }

    public final void setBorderColor(int position, Integer color) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.getEntries().get(position), color);
    }

    public final int getBorderColor(int position) {
        Integer borderColor = BackgroundStyleApplicator.getBorderColor(this, LogicalEdge.getEntries().get(position));
        if (borderColor != null) {
            return borderColor.intValue();
        }
        return 0;
    }

    public final void setBorderRadius(float borderRadius) {
        setBorderRadius(borderRadius, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public final void setBorderRadius(float borderRadius, int position) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.getEntries().get(position), Float.isNaN(borderRadius) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(borderRadius), LengthPercentageType.POINT));
    }

    public final void setBorderStyle(String style) {
        BackgroundStyleApplicator.setBorderStyle(this, style == null ? null : BorderStyle.INSTANCE.fromString(style));
    }

    public final void setLetterSpacingPt(float letterSpacingPt) {
        this.textAttributes.setLetterSpacing(letterSpacingPt);
        applyTextAttributes();
    }

    public final void setAllowFontScaling(boolean allowFontScaling) {
        if (this.textAttributes.getAllowFontScaling() != allowFontScaling) {
            this.textAttributes.setAllowFontScaling(allowFontScaling);
            applyTextAttributes();
        }
    }

    public final void setFontSize(float fontSize) {
        this.textAttributes.setFontSize(fontSize);
        applyTextAttributes();
    }

    public final void setMaxFontSizeMultiplier(float maxFontSizeMultiplier) {
        if (maxFontSizeMultiplier == this.textAttributes.getMaxFontSizeMultiplier()) {
            return;
        }
        this.textAttributes.setMaxFontSizeMultiplier(maxFontSizeMultiplier);
        applyTextAttributes();
    }

    public final void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    public final void setSelectTextOnFocus(boolean selectTextOnFocus) {
        super.setSelectAllOnFocus(selectTextOnFocus);
        this.selectTextOnFocus = selectTextOnFocus;
    }

    public final void setContextMenuHidden(boolean contextMenuHidden) {
        this.contextMenuHidden = contextMenuHidden;
    }

    protected final void applyTextAttributes() {
        setTextSize(0, this.textAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.textAttributes.getEffectiveLetterSpacing();
        if (Float.isNaN(effectiveLetterSpacing)) {
            return;
        }
        setLetterSpacing(effectiveLetterSpacing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCachedSpannable() {
        if (this.stateWrapper == null || getId() == -1) {
            return;
        }
        Editable text = getText();
        Editable editable = text;
        boolean z = editable == null || editable.length() == 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (text != null && !z) {
            try {
                spannableStringBuilder.append(text.subSequence(0, text.length()));
            } catch (IndexOutOfBoundsException e) {
                ReactSoftExceptionLogger.logSoftException(this.TAG, e);
            }
        }
        if (z && getHint() != null) {
            CharSequence hint = getHint();
            Intrinsics.checkNotNullExpressionValue(hint, "getHint(...)");
            if (hint.length() > 0) {
                spannableStringBuilder.append(getHint());
            }
        }
        addSpansFromStyleAttributes(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ReactTextPaintHolderSpan(new TextPaint(getPaint())), 0, spannableStringBuilder.length(), 18);
        TextLayoutManager.INSTANCE.setCachedSpannableForTag(getId(), spannableStringBuilder);
    }

    public final void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public final void setOverflow(String overflow) {
        this.overflow = Overflow.Companion.fromString$default(Overflow.INSTANCE, overflow, null, 2, null);
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Layout layout;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        Editable text = getText();
        Editable editable = text instanceof Spanned ? text : null;
        if (editable != null && (layout = getLayout()) != null) {
            CanvasEffectSpan[] canvasEffectSpanArr = (CanvasEffectSpan[]) editable.getSpans(0, editable.length(), CanvasEffectSpan.class);
            Intrinsics.checkNotNull(canvasEffectSpanArr);
            if (!(canvasEffectSpanArr.length == 0)) {
                float compoundPaddingLeft = getCompoundPaddingLeft();
                float extendedPaddingTop = getExtendedPaddingTop();
                int iSave = canvas.save();
                canvas.translate(compoundPaddingLeft, extendedPaddingTop);
                try {
                    Iterator it = ArrayIteratorKt.iterator(canvasEffectSpanArr);
                    while (it.hasNext()) {
                        CanvasEffectSpan canvasEffectSpan = (CanvasEffectSpan) it.next();
                        canvasEffectSpan.onPreDraw(editable.getSpanStart(canvasEffectSpan), editable.getSpanEnd(canvasEffectSpan), canvas, layout);
                    }
                    canvas.restoreToCount(iSave);
                    super.onDraw(canvas);
                    float compoundPaddingLeft2 = getCompoundPaddingLeft();
                    float extendedPaddingTop2 = getExtendedPaddingTop();
                    int iSave2 = canvas.save();
                    canvas.translate(compoundPaddingLeft2, extendedPaddingTop2);
                    try {
                        Iterator it2 = ArrayIteratorKt.iterator(canvasEffectSpanArr);
                        while (it2.hasNext()) {
                            CanvasEffectSpan canvasEffectSpan2 = (CanvasEffectSpan) it2.next();
                            canvasEffectSpan2.onDraw(editable.getSpanStart(canvasEffectSpan2), editable.getSpanEnd(canvasEffectSpan2), canvas, layout);
                        }
                        canvas.restoreToCount(iSave2);
                        return;
                    } catch (Throwable th) {
                        canvas.restoreToCount(iSave2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    canvas.restoreToCount(iSave);
                    throw th2;
                }
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List<String> list = this.dragAndDropFilter;
        if (list != null && event.getAction() == 1) {
            List<String> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (event.getClipDescription().hasMimeType((String) it.next())) {
                }
            }
            return false;
        }
        return super.onDragEvent(event);
    }

    /* JADX INFO: compiled from: ReactEditText.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;", "Landroid/text/TextWatcher;", "<init>", "(Lcom/facebook/react/views/textinput/ReactEditText;)V", "beforeTextChanged", "", "s", "", ViewProps.START, "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class TextWatcherDelegator implements TextWatcher {
        public TextWatcherDelegator() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.this.getIsSettingTextFromJS() || (copyOnWriteArrayList = ReactEditText.this.listeners) == null) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).beforeTextChanged(s, start, count, after);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.INSTANCE.getDEBUG_MODE()) {
                FLog.e(ReactEditText.this.TAG, "onTextChanged[" + ReactEditText.this.getId() + "]: " + ((Object) s) + ServerSentEventKt.SPACE + start + ServerSentEventKt.SPACE + before + ServerSentEventKt.SPACE + count);
            }
            if (!ReactEditText.this.getIsSettingTextFromJS() && (copyOnWriteArrayList = ReactEditText.this.listeners) != null) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(s, start, before, count);
                }
            }
            ReactEditText.this.updateCachedSpannable();
            ReactEditText.this.onContentSizeChange();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.this.getIsSettingTextFromJS() || (copyOnWriteArrayList = ReactEditText.this.listeners) == null) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).afterTextChanged(s);
            }
        }
    }

    /* JADX INFO: compiled from: ReactEditText.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/views/textinput/ReactEditText$InternalKeyListener;", "Landroid/text/method/KeyListener;", "<init>", "()V", "_inputType", "", "getInputType", "setInputType", "", "inputType", "onKeyDown", "", "view", "Landroid/view/View;", "text", "Landroid/text/Editable;", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyOther", "clearMetaKeyState", "content", "states", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class InternalKeyListener implements KeyListener {
        private int _inputType;

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return this._inputType;
        }

        public final void setInputType(int inputType) {
            this._inputType = inputType;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyDown(view, text, keyCode, event);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyUp(view, text, keyCode, event);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyOther(View view, Editable text, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyOther(view, text, event);
        }

        @Override // android.text.method.KeyListener
        public void clearMetaKeyState(View view, Editable content, int states) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(content, "content");
            ReactEditText.keyListener.clearMetaKeyState(view, content, states);
        }
    }

    /* JADX INFO: compiled from: ReactEditText.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/textinput/ReactEditText$Companion;", "", "<init>", "()V", "DEBUG_MODE", "", "getDEBUG_MODE", "()Z", "keyListener", "Landroid/text/method/KeyListener;", "sameTextForSpan", "oldText", "Landroid/text/Editable;", "newText", "Landroid/text/SpannableStringBuilder;", ViewProps.START, "", ViewProps.END, "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getDEBUG_MODE() {
            return ReactEditText.DEBUG_MODE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean sameTextForSpan(Editable oldText, SpannableStringBuilder newText, int start, int end) {
            if (start > newText.length() || end > newText.length()) {
                return false;
            }
            while (start < end) {
                if (oldText.charAt(start) != newText.charAt(start)) {
                    return false;
                }
                start++;
            }
            return true;
        }
    }

    static {
        boolean z = ReactBuildConfig.DEBUG;
        DEBUG_MODE = false;
        QwertyKeyListener instanceForFullKeyboard = QwertyKeyListener.getInstanceForFullKeyboard();
        Intrinsics.checkNotNullExpressionValue(instanceForFullKeyboard, "getInstanceForFullKeyboard(...)");
        keyListener = instanceForFullKeyboard;
    }
}
