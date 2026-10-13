package io.datazoom.sdk.network.events.model;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.utils.AnySerializer;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: EventDto.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0003]^_B±\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012+\b\u0002\u0010\t\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e\u0012+\b\u0002\u0010\u000f\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e\u0012'\b\u0002\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0016\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0017\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0018\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e\u0012'\b\u0002\u0010\u0019\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e¢\u0006\u0004\b\u001a\u0010\u001bBÕ\u0002\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010?\u001a\u00020\u0003HÂ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J,\u0010C\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000eHÆ\u0003J,\u0010D\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000eHÆ\u0003J(\u0010E\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003J(\u0010F\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003J(\u0010G\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÆ\u0003J(\u0010H\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÆ\u0003J(\u0010I\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003J(\u0010J\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003J(\u0010K\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003J(\u0010L\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÆ\u0003J(\u0010M\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÆ\u0003J(\u0010N\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÂ\u0003Jµ\u0004\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2+\b\u0002\u0010\t\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2+\b\u0002\u0010\u000f\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2'\b\u0002\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0016\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0017\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0018\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e2'\b\u0002\u0010\u0019\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000eHÆ\u0001J\u0014\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010S\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010T\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0001¢\u0006\u0002\b\\R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\"R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\"R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\"\u001a\u0004\b)\u0010*R?\u0010\t\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R?\u0010\u000f\u001a%\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010-R5\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b0\u0010\"R5\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\"R;\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\"\u001a\u0004\b3\u0010-R;\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u0010-R5\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b6\u0010\"R5\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b7\u0010\"R5\u0010\u0016\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b8\u0010\"R;\u0010\u0017\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\"\u001a\u0004\b:\u0010-R;\u0010\u0018\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\"\u001a\u0004\b<\u0010-R5\u0010\u0019\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r0\nj\u0002`\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b=\u0010\"¨\u0006`"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventDto;", "", "customerCode", "", "configurationId", "eventId", "connectorList", "event", "Lio/datazoom/sdk/network/events/model/EventDto$Event;", "userDetails", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "device", "geoLocation", "network", "video", "ad", "page", "opsMetadata", "cdn", "player", "custom", "cmcd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/datazoom/sdk/network/events/model/EventDto$Event;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/datazoom/sdk/network/events/model/EventDto$Event;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCustomerCode$annotations", "()V", "getConfigurationId$annotations", "getEventId$annotations", "getEventId", "()Ljava/lang/String;", "getConnectorList$annotations", "getEvent$annotations", "getEvent", "()Lio/datazoom/sdk/network/events/model/EventDto$Event;", "getUserDetails$annotations", "getUserDetails", "()Ljava/util/HashMap;", "getDevice$annotations", "getDevice", "getGeoLocation$annotations", "getNetwork$annotations", "getVideo$annotations", "getVideo", "getAd$annotations", "getAd", "getPage$annotations", "getOpsMetadata$annotations", "getCdn$annotations", "getPlayer$annotations", "getPlayer", "getCustom$annotations", "getCustom", "getCmcd$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "Event", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class EventDto {
    private final HashMap<String, Object> ad;
    private final HashMap<String, Object> cdn;
    private final HashMap<String, Object> cmcd;
    private final String configurationId;
    private final String connectorList;
    private final HashMap<String, Object> custom;
    private String customerCode;
    private final HashMap<String, Object> device;
    private final Event event;
    private final String eventId;
    private final HashMap<String, Object> geoLocation;
    private final HashMap<String, Object> network;
    private final HashMap<String, Object> opsMetadata;
    private final HashMap<String, Object> page;
    private final HashMap<String, Object> player;
    private final HashMap<String, Object> userDetails;
    private final HashMap<String, Object> video;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$2();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$3();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$4();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$5();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$6();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$7();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$8();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$9();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventDto._childSerializers$_anonymous_$10();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$10() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$9() {
        return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getCustomerCode() {
        return this.customerCode;
    }

    private final HashMap<String, Object> component12() {
        return this.page;
    }

    private final HashMap<String, Object> component13() {
        return this.opsMetadata;
    }

    private final HashMap<String, Object> component14() {
        return this.cdn;
    }

    private final HashMap<String, Object> component17() {
        return this.cmcd;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getConfigurationId() {
        return this.configurationId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final String getConnectorList() {
        return this.connectorList;
    }

    private final HashMap<String, Object> component8() {
        return this.geoLocation;
    }

    private final HashMap<String, Object> component9() {
        return this.network;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventDto copy$default(EventDto eventDto, String str, String str2, String str3, String str4, Event event, HashMap map, HashMap map2, HashMap map3, HashMap map4, HashMap map5, HashMap map6, HashMap map7, HashMap map8, HashMap map9, HashMap map10, HashMap map11, HashMap map12, int i, Object obj) {
        HashMap map13;
        HashMap map14;
        String str5 = (i & 1) != 0 ? eventDto.customerCode : str;
        String str6 = (i & 2) != 0 ? eventDto.configurationId : str2;
        String str7 = (i & 4) != 0 ? eventDto.eventId : str3;
        String str8 = (i & 8) != 0 ? eventDto.connectorList : str4;
        Event event2 = (i & 16) != 0 ? eventDto.event : event;
        HashMap map15 = (i & 32) != 0 ? eventDto.userDetails : map;
        HashMap map16 = (i & 64) != 0 ? eventDto.device : map2;
        HashMap map17 = (i & 128) != 0 ? eventDto.geoLocation : map3;
        HashMap map18 = (i & 256) != 0 ? eventDto.network : map4;
        HashMap map19 = (i & 512) != 0 ? eventDto.video : map5;
        HashMap map20 = (i & 1024) != 0 ? eventDto.ad : map6;
        HashMap map21 = (i & 2048) != 0 ? eventDto.page : map7;
        HashMap map22 = (i & 4096) != 0 ? eventDto.opsMetadata : map8;
        HashMap map23 = (i & 8192) != 0 ? eventDto.cdn : map9;
        String str9 = str5;
        HashMap map24 = (i & 16384) != 0 ? eventDto.player : map10;
        HashMap map25 = (i & 32768) != 0 ? eventDto.custom : map11;
        if ((i & 65536) != 0) {
            map14 = map25;
            map13 = eventDto.cmcd;
        } else {
            map13 = map12;
            map14 = map25;
        }
        return eventDto.copy(str9, str6, str7, str8, event2, map15, map16, map17, map18, map19, map20, map21, map22, map23, map24, map14, map13);
    }

    @SerialName("ad")
    public static /* synthetic */ void getAd$annotations() {
    }

    @SerialName("cdn")
    private static /* synthetic */ void getCdn$annotations() {
    }

    @SerialName("cmcd")
    private static /* synthetic */ void getCmcd$annotations() {
    }

    @SerialName("configuration_id")
    private static /* synthetic */ void getConfigurationId$annotations() {
    }

    @SerialName("connector_list")
    private static /* synthetic */ void getConnectorList$annotations() {
    }

    @SerialName("custom")
    public static /* synthetic */ void getCustom$annotations() {
    }

    @SerialName("customer_code")
    private static /* synthetic */ void getCustomerCode$annotations() {
    }

    @SerialName("device")
    public static /* synthetic */ void getDevice$annotations() {
    }

    @SerialName("event")
    public static /* synthetic */ void getEvent$annotations() {
    }

    @SerialName("event_id")
    public static /* synthetic */ void getEventId$annotations() {
    }

    @SerialName("geo_location")
    private static /* synthetic */ void getGeoLocation$annotations() {
    }

    @SerialName("network")
    private static /* synthetic */ void getNetwork$annotations() {
    }

    @SerialName("ops_metadata")
    private static /* synthetic */ void getOpsMetadata$annotations() {
    }

    @SerialName("page")
    private static /* synthetic */ void getPage$annotations() {
    }

    @SerialName("player")
    public static /* synthetic */ void getPlayer$annotations() {
    }

    @SerialName("user_details")
    public static /* synthetic */ void getUserDetails$annotations() {
    }

    @SerialName("video")
    public static /* synthetic */ void getVideo$annotations() {
    }

    public final HashMap<String, Object> component10() {
        return this.video;
    }

    public final HashMap<String, Object> component11() {
        return this.ad;
    }

    public final HashMap<String, Object> component15() {
        return this.player;
    }

    public final HashMap<String, Object> component16() {
        return this.custom;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Event getEvent() {
        return this.event;
    }

    public final HashMap<String, Object> component6() {
        return this.userDetails;
    }

    public final HashMap<String, Object> component7() {
        return this.device;
    }

    public final EventDto copy(String customerCode, String configurationId, String eventId, String connectorList, Event event, HashMap<String, Object> userDetails, HashMap<String, Object> device, HashMap<String, Object> geoLocation, HashMap<String, Object> network, HashMap<String, Object> video, HashMap<String, Object> ad, HashMap<String, Object> page, HashMap<String, Object> opsMetadata, HashMap<String, Object> cdn, HashMap<String, Object> player, HashMap<String, Object> custom, HashMap<String, Object> cmcd) {
        Intrinsics.checkNotNullParameter(configurationId, "configurationId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(geoLocation, "geoLocation");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(opsMetadata, "opsMetadata");
        Intrinsics.checkNotNullParameter(cdn, "cdn");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(cmcd, "cmcd");
        return new EventDto(customerCode, configurationId, eventId, connectorList, event, userDetails, device, geoLocation, network, video, ad, page, opsMetadata, cdn, player, custom, cmcd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventDto)) {
            return false;
        }
        EventDto eventDto = (EventDto) other;
        return Intrinsics.areEqual(this.customerCode, eventDto.customerCode) && Intrinsics.areEqual(this.configurationId, eventDto.configurationId) && Intrinsics.areEqual(this.eventId, eventDto.eventId) && Intrinsics.areEqual(this.connectorList, eventDto.connectorList) && Intrinsics.areEqual(this.event, eventDto.event) && Intrinsics.areEqual(this.userDetails, eventDto.userDetails) && Intrinsics.areEqual(this.device, eventDto.device) && Intrinsics.areEqual(this.geoLocation, eventDto.geoLocation) && Intrinsics.areEqual(this.network, eventDto.network) && Intrinsics.areEqual(this.video, eventDto.video) && Intrinsics.areEqual(this.ad, eventDto.ad) && Intrinsics.areEqual(this.page, eventDto.page) && Intrinsics.areEqual(this.opsMetadata, eventDto.opsMetadata) && Intrinsics.areEqual(this.cdn, eventDto.cdn) && Intrinsics.areEqual(this.player, eventDto.player) && Intrinsics.areEqual(this.custom, eventDto.custom) && Intrinsics.areEqual(this.cmcd, eventDto.cmcd);
    }

    public int hashCode() {
        String str = this.customerCode;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.configurationId.hashCode()) * 31;
        String str2 = this.eventId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.connectorList;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.event.hashCode()) * 31;
        HashMap<String, Object> map = this.userDetails;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        HashMap<String, Object> map2 = this.device;
        return ((((((((((((((((((((iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31) + this.geoLocation.hashCode()) * 31) + this.network.hashCode()) * 31) + this.video.hashCode()) * 31) + this.ad.hashCode()) * 31) + this.page.hashCode()) * 31) + this.opsMetadata.hashCode()) * 31) + this.cdn.hashCode()) * 31) + this.player.hashCode()) * 31) + this.custom.hashCode()) * 31) + this.cmcd.hashCode();
    }

    public String toString() {
        return "EventDto(customerCode=" + this.customerCode + ", configurationId=" + this.configurationId + ", eventId=" + this.eventId + ", connectorList=" + this.connectorList + ", event=" + this.event + ", userDetails=" + this.userDetails + ", device=" + this.device + ", geoLocation=" + this.geoLocation + ", network=" + this.network + ", video=" + this.video + ", ad=" + this.ad + ", page=" + this.page + ", opsMetadata=" + this.opsMetadata + ", cdn=" + this.cdn + ", player=" + this.player + ", custom=" + this.custom + ", cmcd=" + this.cmcd + ")";
    }

    /* JADX INFO: compiled from: EventDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/events/model/EventDto;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EventDto> serializer() {
            return EventDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventDto(int i, String str, String str2, String str3, String str4, Event event, HashMap map, HashMap map2, HashMap map3, HashMap map4, HashMap map5, HashMap map6, HashMap map7, HashMap map8, HashMap map9, HashMap map10, HashMap map11, HashMap map12, SerializationConstructorMarker serializationConstructorMarker) {
        if (16 != (i & 16)) {
            PluginExceptionsKt.throwMissingFieldException(i, 16, EventDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.customerCode = "";
        } else {
            this.customerCode = str;
        }
        if ((i & 2) == 0) {
            this.configurationId = "";
        } else {
            this.configurationId = str2;
        }
        if ((i & 4) == 0) {
            this.eventId = null;
        } else {
            this.eventId = str3;
        }
        if ((i & 8) == 0) {
            this.connectorList = "";
        } else {
            this.connectorList = str4;
        }
        this.event = event;
        if ((i & 32) == 0) {
            this.userDetails = null;
        } else {
            this.userDetails = map;
        }
        if ((i & 64) == 0) {
            this.device = null;
        } else {
            this.device = map2;
        }
        if ((i & 128) == 0) {
            this.geoLocation = new HashMap<>();
        } else {
            this.geoLocation = map3;
        }
        if ((i & 256) == 0) {
            this.network = new HashMap<>();
        } else {
            this.network = map4;
        }
        if ((i & 512) == 0) {
            this.video = new HashMap<>();
        } else {
            this.video = map5;
        }
        if ((i & 1024) == 0) {
            this.ad = new HashMap<>();
        } else {
            this.ad = map6;
        }
        if ((i & 2048) == 0) {
            this.page = new HashMap<>();
        } else {
            this.page = map7;
        }
        this.opsMetadata = (i & 4096) == 0 ? new HashMap() : map8;
        this.cdn = (i & 8192) == 0 ? new HashMap() : map9;
        this.player = (i & 16384) == 0 ? new HashMap() : map10;
        this.custom = (32768 & i) == 0 ? new HashMap() : map11;
        this.cmcd = (i & 65536) == 0 ? new HashMap() : map12;
    }

    public EventDto(String str, String configurationId, String str2, String str3, Event event, HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> geoLocation, HashMap<String, Object> network, HashMap<String, Object> video, HashMap<String, Object> ad, HashMap<String, Object> page, HashMap<String, Object> opsMetadata, HashMap<String, Object> cdn, HashMap<String, Object> player, HashMap<String, Object> custom, HashMap<String, Object> cmcd) {
        Intrinsics.checkNotNullParameter(configurationId, "configurationId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(geoLocation, "geoLocation");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(opsMetadata, "opsMetadata");
        Intrinsics.checkNotNullParameter(cdn, "cdn");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(cmcd, "cmcd");
        this.customerCode = str;
        this.configurationId = configurationId;
        this.eventId = str2;
        this.connectorList = str3;
        this.event = event;
        this.userDetails = map;
        this.device = map2;
        this.geoLocation = geoLocation;
        this.network = network;
        this.video = video;
        this.ad = ad;
        this.page = page;
        this.opsMetadata = opsMetadata;
        this.cdn = cdn;
        this.player = player;
        this.custom = custom;
        this.cmcd = cmcd;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(EventDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.customerCode, "")) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.customerCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.configurationId, "")) {
            output.encodeStringElement(serialDesc, 1, self.configurationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.eventId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.eventId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.connectorList, "")) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.connectorList);
        }
        output.encodeSerializableElement(serialDesc, 4, EventDto$Event$$serializer.INSTANCE, self.event);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.userDetails != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.userDetails);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.device != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.device);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.geoLocation, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.geoLocation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.network, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.network);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.video, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.video);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.ad, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.ad);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.page, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.page);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.opsMetadata, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.opsMetadata);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cdn, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.cdn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.player, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 14, lazyArr[14].getValue(), self.player);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || !Intrinsics.areEqual(self.custom, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.custom);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && Intrinsics.areEqual(self.cmcd, new HashMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 16, lazyArr[16].getValue(), self.cmcd);
    }

    public /* synthetic */ EventDto(String str, String str2, String str3, String str4, Event event, HashMap map, HashMap map2, HashMap map3, HashMap map4, HashMap map5, HashMap map6, HashMap map7, HashMap map8, HashMap map9, HashMap map10, HashMap map11, HashMap map12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "" : str4, event, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : map2, (i & 128) != 0 ? new HashMap() : map3, (i & 256) != 0 ? new HashMap() : map4, (i & 512) != 0 ? new HashMap() : map5, (i & 1024) != 0 ? new HashMap() : map6, (i & 2048) != 0 ? new HashMap() : map7, (i & 4096) != 0 ? new HashMap() : map8, (i & 8192) != 0 ? new HashMap() : map9, (i & 16384) != 0 ? new HashMap() : map10, (32768 & i) != 0 ? new HashMap() : map11, (i & 65536) != 0 ? new HashMap() : map12);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final Event getEvent() {
        return this.event;
    }

    public final HashMap<String, Object> getUserDetails() {
        return this.userDetails;
    }

    public final HashMap<String, Object> getDevice() {
        return this.device;
    }

    public final HashMap<String, Object> getVideo() {
        return this.video;
    }

    public final HashMap<String, Object> getAd() {
        return this.ad;
    }

    public final HashMap<String, Object> getPlayer() {
        return this.player;
    }

    public final HashMap<String, Object> getCustom() {
        return this.custom;
    }

    /* JADX INFO: compiled from: EventDto.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012'\b\u0002\u0010\u0006\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000b\u0012'\b\u0002\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000b¢\u0006\u0004\b\r\u0010\u000eBY\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J(\u0010\"\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000bHÆ\u0003J(\u0010#\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000bHÆ\u0003Jo\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\b\u0002\u0010\u0006\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000b2'\b\u0002\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000bHÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR;\u0010\u0006\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR;\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0007j\u0002`\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001d¨\u00064"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventDto$Event;", "", "type", "", "timestamp", "", "fluxData", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "metaData", "<init>", "(Ljava/lang/String;JLjava/util/HashMap;Ljava/util/HashMap;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/util/HashMap;Ljava/util/HashMap;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "getTimestamp$annotations", "getTimestamp", "()J", "getFluxData$annotations", "getFluxData", "()Ljava/util/HashMap;", "getMetaData$annotations", "getMetaData", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Event {
        private final HashMap<String, Object> fluxData;
        private final HashMap<String, Object> metaData;
        private final long timestamp;
        private final String type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$Event$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDto.Event._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventDto$Event$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDto.Event._childSerializers$_anonymous_$0();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new HashMapSerializer(StringSerializer.INSTANCE, AnySerializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Event copy$default(Event event, String str, long j, HashMap map, HashMap map2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = event.type;
            }
            if ((i & 2) != 0) {
                j = event.timestamp;
            }
            if ((i & 4) != 0) {
                map = event.fluxData;
            }
            if ((i & 8) != 0) {
                map2 = event.metaData;
            }
            return event.copy(str, j, map, map2);
        }

        @SerialName(SpanEventSerializer.METRICS_KEY_PREFIX)
        public static /* synthetic */ void getFluxData$annotations() {
        }

        @SerialName(RumFeature.EVENT_ATTRIBUTES_PROPERTY)
        public static /* synthetic */ void getMetaData$annotations() {
        }

        @SerialName("timestamp")
        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @SerialName("type")
        public static /* synthetic */ void getType$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final HashMap<String, Object> component3() {
            return this.fluxData;
        }

        public final HashMap<String, Object> component4() {
            return this.metaData;
        }

        public final Event copy(String type, long timestamp, HashMap<String, Object> fluxData, HashMap<String, Object> metaData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(fluxData, "fluxData");
            Intrinsics.checkNotNullParameter(metaData, "metaData");
            return new Event(type, timestamp, fluxData, metaData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics.areEqual(this.type, event.type) && this.timestamp == event.timestamp && Intrinsics.areEqual(this.fluxData, event.fluxData) && Intrinsics.areEqual(this.metaData, event.metaData);
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + this.fluxData.hashCode()) * 31) + this.metaData.hashCode();
        }

        public String toString() {
            return "Event(type=" + this.type + ", timestamp=" + this.timestamp + ", fluxData=" + this.fluxData + ", metaData=" + this.metaData + ")";
        }

        /* JADX INFO: compiled from: EventDto.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventDto$Event$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/events/model/EventDto$Event;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Event> serializer() {
                return EventDto$Event$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Event(int i, String str, long j, HashMap map, HashMap map2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, EventDto$Event$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
            this.timestamp = j;
            if ((i & 4) == 0) {
                this.fluxData = new HashMap<>();
            } else {
                this.fluxData = map;
            }
            if ((i & 8) == 0) {
                this.metaData = new HashMap<>();
            } else {
                this.metaData = map2;
            }
        }

        public Event(String type, long j, HashMap<String, Object> fluxData, HashMap<String, Object> metaData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(fluxData, "fluxData");
            Intrinsics.checkNotNullParameter(metaData, "metaData");
            this.type = type;
            this.timestamp = j;
            this.fluxData = fluxData;
            this.metaData = metaData;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$base(Event self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.type);
            output.encodeLongElement(serialDesc, 1, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.fluxData, new HashMap())) {
                output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.fluxData);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.metaData, new HashMap())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.metaData);
        }

        public final String getType() {
            return this.type;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public /* synthetic */ Event(String str, long j, HashMap map, HashMap map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? new HashMap() : map, (i & 8) != 0 ? new HashMap() : map2);
        }

        public final HashMap<String, Object> getFluxData() {
            return this.fluxData;
        }

        public final HashMap<String, Object> getMetaData() {
            return this.metaData;
        }
    }
}
