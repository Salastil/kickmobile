package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.StrictMode;
import androidx.exifinterface.media.ExifInterface;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.fresco.urimod.UriModifier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ImagePipeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 y2\u00020\u0001:\u0001yB±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\r\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010.\u001a\u00020/J4\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u000107J>\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\"\u001a\u0004\u0018\u00010\u0006JH\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/J*\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102010\n2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001J$\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001JJ\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u0001072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u00010/J&\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J.\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010\"\u001a\u00020\u0006J.\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010<\u001a\u000207JV\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010<\u001a\u0002072\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>J$\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001J.\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001102012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006J*\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020CJ\"\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J4\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0010\u0010=\u001a\f\u0012\u0004\u0012\u00020/\u0012\u0002\b\u00030>J,\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006JL\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>2\b\b\u0002\u0010B\u001a\u00020CJ,\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\"\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J4\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0010\u0010=\u001a\f\u0012\u0004\u0012\u00020/\u0012\u0002\b\u00030>J*\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020CJ4\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020C2\b\u0010\"\u001a\u0004\u0018\u00010\u0006JH\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020C2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>J\"\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J8\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>J,\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010B\u001a\u00020CJ6\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010B\u001a\u00020C2\b\u0010\"\u001a\u0004\u0018\u00010\u0006JN\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010B\u001a\u00020C2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010J\u001a\u00020G2\b\u00103\u001a\u0004\u0018\u000104J\u000e\u0010K\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0006\u0010L\u001a\u00020GJ\u0018\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010/J\u0006\u0010Q\u001a\u00020GJ\u0006\u0010V\u001a\u00020GJ\u0010\u0010W\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010W\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010X\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010X\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010Y\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IJ\u001a\u0010Y\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010N\u001a\u0004\u0018\u00010OJ\u0010\u0010Z\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0002J\u000e\u0010Y\u001a\u00020\u000b2\u0006\u00103\u001a\u000204J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000b012\b\u0010H\u001a\u0004\u0018\u00010IJ<\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0]2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010^\u001a\u00020\u000e2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020A0`2\u0006\u0010a\u001a\u00020bH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000b012\b\u00103\u001a\u0004\u0018\u000104J\u001c\u0010c\u001a\u0004\u0018\u00010\u000e2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0001J\u0018\u0010d\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001022\b\u0010^\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010e\u001a\u00020G2\u0006\u0010^\u001a\u00020\u000e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u000f02J\u0010\u0010g\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010\u000eJ\\\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hi0201\"\u0004\b\u0000\u0010i2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hi020k2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/H\u0002Jp\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hi0201\"\u0004\b\u0000\u0010i2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hi020k2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010/2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>H\u0002J@\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hi0201\"\u0004\b\u0000\u0010i2\u0014\u0010j\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002Hi\u0018\u0001020k2\u0006\u0010l\u001a\u00020m2\b\u0010\"\u001a\u0004\u0018\u00010\u0006J`\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A012\u000e\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0k2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u0002072\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u0010B\u001a\u00020C2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010>H\u0002J\u001a\u0010o\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u0001042\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0010\u0010p\u001a\u00020\u00062\b\u0010q\u001a\u0004\u0018\u00010\u0006J\u0016\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000e0s2\u0006\u0010H\u001a\u00020IH\u0002J\u0006\u0010t\u001a\u00020GJ\u0006\u0010u\u001a\u00020GJ\u0006\u0010x\u001a\u00020GR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010v\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bv\u0010w¨\u0006z"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipeline;", "", "producerSequenceFactory", "Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "requestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "isPrefetchEnabledSupplier", "Lcom/facebook/common/internal/Supplier;", "", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "threadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "suppressBitmapPrefetchingSupplier", "lazyDataSource", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "<init>", "(Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;Ljava/util/Set;Ljava/util/Set;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/callercontext/CallerContextVerifier;Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "getProducerSequenceFactory", "()Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "requestListener", "requestListener2", "getBitmapMemoryCache", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "idCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "isLazyDataSource", "()Lcom/facebook/common/internal/Supplier;", "getConfig", "()Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "generateUniqueFutureId", "", "getDataSourceSupplier", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContext", "requestLevel", "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;", "uiComponentId", "getEncodedImageDataSourceSupplier", "fetchImageFromBitmapCache", "fetchDecodedImage", "lowestPermittedRequestLevelOnSubmit", "extras", "", "fetchEncodedImage", "prefetchToBitmapCache", "Ljava/lang/Void;", "priority", "Lcom/facebook/imagepipeline/common/Priority;", "prefetchToDiskCache", "prefetchToEncodedCache", "evictFromMemoryCache", "", "uri", "Landroid/net/Uri;", "evictFromDiskCache", "evictFromCache", "clearMemoryCaches", "clearSpecificDiskCache", "cacheChoice", "Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;", "diskCacheId", "clearDiskCaches", "usedDiskCacheSize", "", "getUsedDiskCacheSize", "()J", "clearCaches", "isInBitmapMemoryCache", "isInEncodedMemoryCache", "isInDiskCacheSync", "isInDynamicDiskCachesSync", "isInDiskCache", "isInDynamicDiskCaches", "Lbolts/Task;", "cacheKey", "intermediateContinuation", "Lbolts/Continuation;", "cts", "Lbolts/CancellationTokenSource;", "getCacheKey", "getCachedImage", "returnImageToCache", "imageReference", "hasCachedImage", "submitFetchRequest", ExifInterface.GPS_DIRECTION_TRUE, "producerSequence", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "submitPrefetchRequest", "getRequestListenerForRequest", "getCombinedRequestListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "predicateForUri", "Lcom/facebook/common/internal/Predicate;", PauseEvent.TYPE, "resume", "isPaused", "()Z", "init", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePipeline {
    private final MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CallerContextVerifier callerContextVerifier;
    private final ImagePipelineConfigInterface config;
    private final Supplier<DiskCachesStore> diskCachesStoreSupplier;
    private final MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache;
    private final AtomicLong idCounter;
    private final Supplier<Boolean> isLazyDataSource;
    private final Supplier<Boolean> isPrefetchEnabledSupplier;
    private final ProducerSequenceFactory producerSequenceFactory;
    private final RequestListener requestListener;
    private final RequestListener2 requestListener2;
    private final Supplier<Boolean> suppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private static final CancellationException NULL_IMAGEREQUEST_EXCEPTION = new CancellationException("ImageRequest is null");
    private static final CancellationException MODIFIED_URL_IS_NULL = new CancellationException("Modified URL is null");

    /* JADX INFO: compiled from: ImagePipeline.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageRequest.CacheChoice.DYNAMIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final boolean clearMemoryCaches$lambda$3(CacheKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public final void init() {
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<? extends RequestListener> requestListeners, Set<? extends RequestListener2> requestListener2s, Supplier<Boolean> isPrefetchEnabledSupplier, MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> suppressBitmapPrefetchingSupplier, Supplier<Boolean> lazyDataSource, CallerContextVerifier callerContextVerifier, ImagePipelineConfigInterface config) {
        Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        Intrinsics.checkNotNullParameter(config, "config");
        this.producerSequenceFactory = producerSequenceFactory;
        this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.requestListener = new ForwardingRequestListener((Set<RequestListener>) requestListeners);
        this.requestListener2 = new ForwardingRequestListener2(requestListener2s);
        this.idCounter = new AtomicLong();
        this.bitmapMemoryCache = bitmapMemoryCache;
        this.encodedMemoryCache = encodedMemoryCache;
        this.cacheKeyFactory = cacheKeyFactory;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
        this.isLazyDataSource = lazyDataSource;
        this.callerContextVerifier = callerContextVerifier;
        this.config = config;
    }

    public final ProducerSequenceFactory getProducerSequenceFactory() {
        return this.producerSequenceFactory;
    }

    public final MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.bitmapMemoryCache;
    }

    public final CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public final Supplier<Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    public final ImagePipelineConfigInterface getConfig() {
        return this.config;
    }

    public final String generateUniqueFutureId() {
        return String.valueOf(this.idCounter.getAndIncrement());
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object callerContext, final ImageRequest.RequestLevel requestLevel) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, callerContext, requestLevel, null, null, 24, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object callerContext, final ImageRequest.RequestLevel requestLevel, final RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, callerContext, requestLevel, requestListener, null, 16, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object callerContext, final ImageRequest.RequestLevel requestLevel, final RequestListener requestListener, final String uiComponentId) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, callerContext, requestLevel, requestListener, uiComponentId);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getEncodedImageDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, callerContext);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchDecodedImage(imageRequest, callerContext, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public static /* synthetic */ DataSource fetchDecodedImage$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            requestLevel = null;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        if ((i & 16) != 0) {
            str = null;
        }
        return imagePipeline.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, str);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object callerContext, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, RequestListener requestListener, String uiComponentId) {
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            Producer<CloseableReference<CloseableImage>> decodedImageProducerSequence = this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest);
            if (lowestPermittedRequestLevelOnSubmit == null) {
                lowestPermittedRequestLevelOnSubmit = ImageRequest.RequestLevel.FULL_FETCH;
            }
            return submitFetchRequest(decodedImageProducerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId);
        } catch (Exception e) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(e);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object callerContext) {
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, null, null, 24, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object callerContext, RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, requestListener, null, 16, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object callerContext, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        return fetchDecodedImage$default(this, imageRequest, callerContext, lowestPermittedRequestLevelOnSubmit, null, null, 16, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object callerContext, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, RequestListener requestListener, String uiComponentId, Map<String, ?> extras) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            return submitFetchRequest(this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, extras);
        } catch (Exception e) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(e);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchEncodedImage(imageRequest, callerContext, null);
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object callerContext, RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getSourceUri() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.producerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
                Intrinsics.checkNotNullExpressionValue(imageRequest, "build(...)");
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, requestListener, null, null);
        } catch (Exception e) {
            DataSource<CloseableReference<PooledByteBuffer>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            return dataSourceImmediateFailedDataSource;
        }
    }

    public final DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object callerContext, Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToBitmapCache(imageRequest, callerContext, null, null, priority);
    }

    public final DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object callerContext) {
        return prefetchToBitmapCache$default(this, imageRequest, callerContext, null, null, null, 16, null);
    }

    public final DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object callerContext, Map<String, ?> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return prefetchToBitmapCache$default(this, imageRequest, callerContext, null, extras, null, 16, null);
    }

    public final DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object callerContext, RequestListener requestListener) {
        return prefetchToBitmapCache$default(this, imageRequest, callerContext, requestListener, null, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataSource prefetchToBitmapCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, RequestListener requestListener, Map map, Priority priority, int i, Object obj2) {
        if ((i & 8) != 0) {
            map = null;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            priority = Priority.MEDIUM;
        }
        return imagePipeline.prefetchToBitmapCache(imageRequest, obj, requestListener, map2, priority);
    }

    public final DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object callerContext, RequestListener requestListener, Map<String, ?> extras, Priority priority) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(priority, "priority");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        boolean zBooleanValue = true;
        if (!FrescoSystrace.isTracing()) {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                    return dataSourceImmediateSuccessfulDataSource;
                }
                if (imageRequest == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Boolean boolShouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches == null) {
                    Boolean bool = this.suppressBitmapPrefetchingSupplier.get();
                    Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
                    zBooleanValue = bool.booleanValue();
                } else if (boolShouldDecodePrefetches.booleanValue()) {
                    zBooleanValue = false;
                }
                ProducerSequenceFactory producerSequenceFactory = this.producerSequenceFactory;
                return submitPrefetchRequest(zBooleanValue ? producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest) : producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener, extras);
            } catch (Exception e) {
                DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(e);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource3);
                return dataSourceImmediateFailedDataSource3;
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#prefetchToBitmapCache");
        try {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource4 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource4, "immediateFailedDataSource(...)");
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource4;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                    FrescoSystrace.endSection();
                    return dataSourceImmediateSuccessfulDataSource2;
                }
                if (imageRequest == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Boolean boolShouldDecodePrefetches2 = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches2 == null) {
                    Boolean bool2 = this.suppressBitmapPrefetchingSupplier.get();
                    Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
                    zBooleanValue = bool2.booleanValue();
                } else if (boolShouldDecodePrefetches2.booleanValue()) {
                    zBooleanValue = false;
                }
                ProducerSequenceFactory producerSequenceFactory2 = this.producerSequenceFactory;
                dataSourceImmediateFailedDataSource = submitPrefetchRequest(zBooleanValue ? producerSequenceFactory2.getEncodedImagePrefetchProducerSequence(imageRequest) : producerSequenceFactory2.getDecodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener, extras);
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource;
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            }
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext, RequestListener requestListener) {
        return prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, requestListener);
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext) {
        return prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, null, null);
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext, Map<String, ?> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, null, extras);
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext, Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToDiskCache(imageRequest, callerContext, priority, null);
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext, Priority priority, RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToDiskCache(imageRequest, callerContext, priority, requestListener, null);
    }

    public final DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object callerContext, Priority priority, RequestListener requestListener, Map<String, ?> extras) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (imageRequest == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(new NullPointerException("imageRequest is null"));
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
        try {
            return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener, extras);
        } catch (Exception e) {
            DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(e);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource3);
            return dataSourceImmediateFailedDataSource3;
        }
    }

    public final DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object callerContext) {
        return prefetchToEncodedCache(imageRequest, callerContext, Priority.MEDIUM, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Map map, int i, Object obj2) {
        if ((i & 4) != 0) {
            map = null;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, (Map<String, ?>) map);
    }

    public final DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object callerContext, Map<String, ?> extras) {
        return prefetchToEncodedCache(imageRequest, callerContext, Priority.MEDIUM, null, extras);
    }

    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Priority priority, int i, Object obj2) {
        if ((i & 4) != 0) {
            priority = Priority.MEDIUM;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority);
    }

    public final DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object callerContext, Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToEncodedCache(imageRequest, callerContext, priority, null, null);
    }

    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Priority priority, RequestListener requestListener, int i, Object obj2) {
        if ((i & 4) != 0) {
            priority = Priority.MEDIUM;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority, requestListener);
    }

    public final DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object callerContext, Priority priority, RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToEncodedCache(imageRequest, callerContext, priority, requestListener, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Priority priority, RequestListener requestListener, Map map, int i, Object obj2) {
        if ((i & 4) != 0) {
            priority = Priority.MEDIUM;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority, (i & 8) != 0 ? null : requestListener, (i & 16) != 0 ? null : map);
    }

    public final DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object callerContext, Priority priority, RequestListener requestListener, Map<String, ?> extras) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(priority, "priority");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource3;
            }
            try {
                if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                    return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener, extras);
                }
                DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                return dataSourceImmediateSuccessfulDataSource;
            } catch (Exception e) {
                DataSource<Void> dataSourceImmediateFailedDataSource4 = DataSources.immediateFailedDataSource(e);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource4);
                return dataSourceImmediateFailedDataSource4;
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#prefetchToEncodedCache");
        try {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource5 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource5, "immediateFailedDataSource(...)");
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource5;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource6 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource6, "immediateFailedDataSource(...)");
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource6;
            }
            try {
                if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                    dataSourceImmediateFailedDataSource = submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener, extras);
                    FrescoSystrace.endSection();
                    return dataSourceImmediateFailedDataSource;
                }
                DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                FrescoSystrace.endSection();
                return dataSourceImmediateSuccessfulDataSource2;
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            }
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final void evictFromMemoryCache(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Predicate<CacheKey> predicatePredicateForUri = predicateForUri(uri);
        this.bitmapMemoryCache.removeAll(predicatePredicateForUri);
        this.encodedMemoryCache.removeAll(predicatePredicateForUri);
    }

    public final void evictFromDiskCache(Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        evictFromDiskCache(imageRequestFromUri);
    }

    public final void evictFromDiskCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        diskCachesStore2.getMainBufferedDiskCache().remove(encodedCacheKey);
        diskCachesStore2.getSmallImageBufferedDiskCache().remove(encodedCacheKey);
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(encodedCacheKey);
        }
    }

    public final void evictFromCache(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public final void clearMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda5
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.clearMemoryCaches$lambda$3((CacheKey) obj);
            }
        };
        this.bitmapMemoryCache.removeAll(predicate);
        this.encodedMemoryCache.removeAll(predicate);
    }

    public final void clearSpecificDiskCache(ImageRequest.CacheChoice cacheChoice, String diskCacheId) {
        Intrinsics.checkNotNullParameter(cacheChoice, "cacheChoice");
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        if (cacheChoice == ImageRequest.CacheChoice.SMALL) {
            diskCachesStore2.getSmallImageBufferedDiskCache().clearAll();
            return;
        }
        if (cacheChoice == ImageRequest.CacheChoice.DEFAULT) {
            diskCachesStore2.getMainBufferedDiskCache().clearAll();
            return;
        }
        if (cacheChoice == ImageRequest.CacheChoice.DYNAMIC) {
            if (diskCacheId != null) {
                BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
                if (bufferedDiskCache != null) {
                    bufferedDiskCache.clearAll();
                    return;
                }
                return;
            }
            Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().clearAll();
            }
        }
    }

    public final void clearDiskCaches() {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        diskCachesStore2.getMainBufferedDiskCache().clearAll();
        diskCachesStore2.getSmallImageBufferedDiskCache().clearAll();
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clearAll();
        }
    }

    public final long getUsedDiskCacheSize() {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        long size = diskCachesStore2.getMainBufferedDiskCache().getSize() + diskCachesStore2.getSmallImageBufferedDiskCache().getSize();
        Collection<BufferedDiskCache> collectionValues = diskCachesStore2.getDynamicBufferedDiskCaches().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        long size2 = 0;
        while (it.hasNext()) {
            size2 += ((BufferedDiskCache) it.next()).getSize();
        }
        return size + size2;
    }

    public final void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public final boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CloseableReference<CloseableImage> closeableReference = this.bitmapMemoryCache.get(this.cacheKeyFactory.getBitmapCacheKey(imageRequest, null));
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInEncodedMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.encodedMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInEncodedMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> closeableReference = this.encodedMemoryCache.get(this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null));
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DYNAMIC);
    }

    public final boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build();
        Intrinsics.checkNotNull(imageRequestBuild);
        return isInDiskCacheSync(imageRequestBuild);
    }

    private final boolean isInDynamicDiskCachesSync(ImageRequest imageRequest) {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        String diskCacheId = imageRequest.getDiskCacheId();
        if (diskCacheId != null) {
            BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache != null) {
                return bufferedDiskCache.diskCheckSync(encodedCacheKey);
            }
            return false;
        }
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().diskCheckSync(encodedCacheKey)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInDiskCacheSync(ImageRequest imageRequest) {
        boolean zDiskCheckSync;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        ImageRequest.CacheChoice cacheChoice = imageRequest.getCacheChoice();
        Intrinsics.checkNotNullExpressionValue(cacheChoice, "getCacheChoice(...)");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[cacheChoice.ordinal()];
            if (i == 1) {
                zDiskCheckSync = diskCachesStore2.getMainBufferedDiskCache().diskCheckSync(encodedCacheKey);
            } else if (i == 2) {
                zDiskCheckSync = diskCachesStore2.getSmallImageBufferedDiskCache().diskCheckSync(encodedCacheKey);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                zDiskCheckSync = isInDynamicDiskCachesSync(imageRequest);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zDiskCheckSync;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public final DataSource<Boolean> isInDiskCache(Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri != null) {
            return isInDiskCache(imageRequestFromUri);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, bolts.Task] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, bolts.Task, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [bolts.Task, bolts.Task<java.lang.Boolean>] */
    private final Task<Boolean> isInDynamicDiskCaches(ImageRequest imageRequest, CacheKey cacheKey, final Continuation<Boolean, Void> intermediateContinuation, final CancellationTokenSource cts) {
        Task<Boolean> taskContains;
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        String diskCacheId = imageRequest != null ? imageRequest.getDiskCacheId() : null;
        if (diskCacheId != null) {
            BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache != null && (taskContains = bufferedDiskCache.contains(cacheKey)) != null) {
                return taskContains;
            }
            Task<Boolean> taskForResult = Task.forResult(false);
            Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
            return taskForResult;
        }
        if (diskCachesStore2.getDynamicBufferedDiskCaches().size() == 0) {
            Task<Boolean> taskForResult2 = Task.forResult(false);
            Intrinsics.checkNotNullExpressionValue(taskForResult2, "forResult(...)");
            return taskForResult2;
        }
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        ?? ForResult = Task.forResult(false);
        Intrinsics.checkNotNullExpressionValue(ForResult, "forResult(...)");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ForResult;
        ?? r4 = ForResult;
        while (it.hasNext()) {
            objectRef.element = it.next().getValue().contains(cacheKey);
            r4.continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline.isInDynamicDiskCaches.1
                @Override // bolts.Continuation
                public /* bridge */ /* synthetic */ Object then(Task task) {
                    return then((Task<Boolean>) task);
                }

                @Override // bolts.Continuation
                public final Task<? extends Object> then(Task<Boolean> task) {
                    if (!task.isCancelled() && !task.isFaulted() && task.getResult().booleanValue()) {
                        cts.cancel();
                        return Task.forResult(true).continueWith(intermediateContinuation);
                    }
                    if (task.isCancelled()) {
                        return Task.forResult(false);
                    }
                    return objectRef.element;
                }
            }, cts.getToken());
            r4 = (Task) objectRef.element;
        }
        return r4;
    }

    public final DataSource<Boolean> isInDiskCache(final ImageRequest imageRequest) {
        if (imageRequest == null) {
            DataSource<Boolean> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        final DiskCachesStore diskCachesStore2 = diskCachesStore;
        final CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource simpleDataSourceCreate = SimpleDataSource.INSTANCE.create();
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        Continuation continuation = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda0
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$8(simpleDataSourceCreate, task);
            }
        };
        final Continuation continuation2 = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda1
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$9(simpleDataSourceCreate, task);
            }
        };
        diskCachesStore2.getMainBufferedDiskCache().contains(encodedCacheKey).continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda2
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$10(diskCachesStore2, encodedCacheKey, task);
            }
        }).continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda3
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$11(this.f$0, imageRequest, encodedCacheKey, continuation2, cancellationTokenSource, task);
            }
        }, cancellationTokenSource.getToken()).continueWith(continuation);
        return simpleDataSourceCreate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Void isInDiskCache$lambda$8(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        boolean z = false;
        if ((bool != null ? bool.booleanValue() : false) || (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue())) {
            z = true;
        }
        simpleDataSource.setResult(Boolean.valueOf(z));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Void isInDiskCache$lambda$9(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        simpleDataSource.setResult(Boolean.valueOf((bool != null ? bool.booleanValue() : false) || !(task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue())), false);
        return null;
    }

    static final Task isInDiskCache$lambda$10(DiskCachesStore diskCachesStore, CacheKey cacheKey, Task task) {
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(true);
        }
        return diskCachesStore.getSmallImageBufferedDiskCache().contains(cacheKey);
    }

    static final Task isInDiskCache$lambda$11(ImagePipeline imagePipeline, ImageRequest imageRequest, CacheKey cacheKey, Continuation continuation, CancellationTokenSource cancellationTokenSource, Task task) {
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(true);
        }
        return imagePipeline.isInDynamicDiskCaches(imageRequest, cacheKey, continuation, cancellationTokenSource);
    }

    public final CacheKey getCacheKey(ImageRequest imageRequest, Object callerContext) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        CacheKey postprocessedBitmapCacheKey = null;
        if (!FrescoSystrace.isTracing()) {
            if (imageRequest == null) {
                return null;
            }
            Postprocessor postprocessor = imageRequest.getPostprocessor();
            CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
            return postprocessor != null ? cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext) : cacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext);
        }
        FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        if (imageRequest != null) {
            try {
                Postprocessor postprocessor2 = imageRequest.getPostprocessor();
                CacheKeyFactory cacheKeyFactory2 = this.cacheKeyFactory;
                postprocessedBitmapCacheKey = postprocessor2 != null ? cacheKeyFactory2.getPostprocessedBitmapCacheKey(imageRequest, callerContext) : cacheKeyFactory2.getBitmapCacheKey(imageRequest, callerContext);
            } finally {
                FrescoSystrace.endSection();
            }
        }
        return postprocessedBitmapCacheKey;
    }

    public final CloseableReference<CloseableImage> getCachedImage(CacheKey cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = this.bitmapMemoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public final void returnImageToCache(CacheKey cacheKey, CloseableReference<CloseableImage> imageReference) {
        CloseableImage closeableImage;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(imageReference, "imageReference");
        if (CloseableReference.isValid(imageReference) && (closeableImage = imageReference.get()) != null && !closeableImage.isStateful() && closeableImage.getQualityInfo().isOfFullQuality()) {
            CloseableReference.closeSafely(this.bitmapMemoryCache.cacheOnRelease(cacheKey, imageReference));
        }
    }

    public final boolean hasCachedImage(CacheKey cacheKey) {
        if (cacheKey == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(cacheKey);
    }

    private final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, RequestListener requestListener, String uiComponentId) {
        return submitFetchRequest(producerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, null);
    }

    private final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, RequestListener requestListener, String uiComponentId, Map<String, ?> extras) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(callerContext, false);
            }
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener, callerContext, max, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext.putExtras(extras);
                DataSource<CloseableReference<T>> dataSourceCreate = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, internalRequestListener);
                Intrinsics.checkNotNull(dataSourceCreate);
                return dataSourceCreate;
            } catch (Exception e) {
                DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(e);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
                return dataSourceImmediateFailedDataSource2;
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            InternalRequestListener internalRequestListener2 = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(callerContext, false);
            }
            try {
                ImageRequest.RequestLevel max2 = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                SettableProducerContext settableProducerContext2 = new SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener2, callerContext, max2, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext2.putExtras(extras);
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext2, internalRequestListener2);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            }
            FrescoSystrace.endSection();
            return dataSourceImmediateFailedDataSource;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producerSequence, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(producerSequence, "producerSequence");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            try {
                DataSource<CloseableReference<T>> dataSourceCreate = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
                Intrinsics.checkNotNull(dataSourceCreate);
                return dataSourceCreate;
            } catch (Exception e) {
                DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(e);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
                return dataSourceImmediateFailedDataSource2;
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            try {
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            }
            return dataSourceImmediateFailedDataSource;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final DataSource<Void> submitPrefetchRequest(Producer<Void> producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, Priority priority, RequestListener requestListener, Map<String, ?> extras) {
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
        CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
        boolean z = true;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(callerContext, true);
        }
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        Uri uriModifyPrefetchUri = UriModifier.INSTANCE.modifyPrefetchUri(sourceUri, callerContext);
        if (uriModifyPrefetchUri == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(MODIFIED_URL_IS_NULL);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        ImageRequest imageRequestBuild = Intrinsics.areEqual(sourceUri, uriModifyPrefetchUri) ? imageRequest : ImageRequestBuilder.fromRequest(imageRequest).setSource(uriModifyPrefetchUri).build();
        try {
            ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequestBuild.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
            Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
            String strGenerateUniqueFutureId = generateUniqueFutureId();
            InternalRequestListener internalRequestListener2 = internalRequestListener;
            if (!this.config.getExperiments().getAllowProgressiveOnPrefetch() || !imageRequestBuild.getProgressiveRenderingEnabled()) {
                z = false;
            }
            SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequestBuild, strGenerateUniqueFutureId, internalRequestListener2, callerContext, max, true, z, priority, this.config);
            settableProducerContext.putExtras(extras);
            return ProducerToDataSourceAdapter.INSTANCE.create(producerSequence, settableProducerContext, internalRequestListener);
        } catch (Exception e) {
            DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(e);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
    }

    public final RequestListener getRequestListenerForRequest(ImageRequest imageRequest, RequestListener requestListener) {
        ForwardingRequestListener forwardingRequestListener;
        if (imageRequest == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.requestListener;
            }
            return new ForwardingRequestListener(this.requestListener, imageRequest.getRequestListener());
        }
        if (imageRequest.getRequestListener() == null) {
            forwardingRequestListener = new ForwardingRequestListener(this.requestListener, requestListener);
        } else {
            forwardingRequestListener = new ForwardingRequestListener(this.requestListener, requestListener, imageRequest.getRequestListener());
        }
        return forwardingRequestListener;
    }

    public final RequestListener getCombinedRequestListener(RequestListener listener) {
        return listener != null ? new ForwardingRequestListener(this.requestListener, listener) : this.requestListener;
    }

    private final Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda4
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.predicateForUri$lambda$16(uri, (CacheKey) obj);
            }
        };
    }

    static final boolean predicateForUri$lambda$16(Uri uri, CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key.containsUri(uri);
    }

    public final void pause() {
        this.threadHandoffProducerQueue.startQueueing();
    }

    public final void resume() {
        this.threadHandoffProducerQueue.stopQueuing();
    }

    public final boolean isPaused() {
        return this.threadHandoffProducerQueue.isQueueing();
    }
}
