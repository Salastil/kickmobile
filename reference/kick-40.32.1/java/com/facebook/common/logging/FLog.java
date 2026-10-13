package com.facebook.common.logging;

import androidx.core.app.NotificationCompat;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: FLog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J&\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J:\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JD\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J \u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J*\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J4\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J>\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JH\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J9\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010\u0019\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J&\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J:\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JD\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J \u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J*\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J4\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J>\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JH\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J9\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010+\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010+\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J&\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J:\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JD\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J \u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J*\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J4\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J>\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0007JH\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0007J9\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010,\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010,\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u0010-\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J \u0010-\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J9\u0010-\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010-\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010-\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010-\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010-\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010-\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u0010.\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J \u0010.\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J9\u0010.\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010.\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010.\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010.\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010.\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010.\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u0010/\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J \u0010/\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J9\u0010/\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JC\u0010/\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(J=\u0010/\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010)JG\u0010/\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J&\u0010/\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J*\u0010/\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J1\u00100\u001a\u0004\u0018\u00010\u001b2\b\u00101\u001a\u0004\u0018\u00010\u001b2\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u00102J\u0014\u00103\u001a\u00020\u001b2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\"H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00065"}, d2 = {"Lcom/facebook/common/logging/FLog;", "", "<init>", "()V", "VERBOSE", "", "DEBUG", "INFO", "WARN", MediaError.ERROR_TYPE_ERROR, "ASSERT", "handler", "Lcom/facebook/common/logging/LoggingDelegate;", "setLoggingDelegate", "", "delegate", "isLoggable", "", FirebaseAnalytics.Param.LEVEL, "minimumLoggingLevel", "getMinimumLoggingLevel$annotations", "getMinimumLoggingLevel", "()I", "setMinimumLoggingLevel", "(I)V", "v", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "arg1", "arg2", "arg3", "arg4", "cls", "Ljava/lang/Class;", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "d", ContextChain.TAG_INFRA, "w", "e", "wtf", "formatString", "str", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getTag", "clazz", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FLog {
    private static LoggingDelegate handler;
    public static final FLog INSTANCE = new FLog();
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    @JvmStatic
    public static /* synthetic */ void getMinimumLoggingLevel$annotations() {
    }

    private FLog() {
    }

    static {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = FLogDefaultLoggingDelegate.getInstance();
        Intrinsics.checkNotNullExpressionValue(fLogDefaultLoggingDelegate, "getInstance(...)");
        handler = fLogDefaultLoggingDelegate;
    }

    @JvmStatic
    public static final void setLoggingDelegate(LoggingDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        handler = delegate;
    }

    @JvmStatic
    public static final boolean isLoggable(int level) {
        return handler.isLoggable(level);
    }

    public static final int getMinimumLoggingLevel() {
        return handler.getMinimumLoggingLevel();
    }

    public static final void setMinimumLoggingLevel(int i) {
        handler.setMinimumLoggingLevel(i);
    }

    @JvmStatic
    public static final void v(String tag, String msg) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.v(tag, msg);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Object arg1) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.v(tag, msg);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Object arg1) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        FLog fLog = INSTANCE;
        if (isLoggable(VERBOSE)) {
            v(cls, fLog.formatString(msg, arg1, arg2, arg3));
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.v(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.v(tag, string);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.v(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void v(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.v(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void v(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(VERBOSE)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.v(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.d(tag, msg);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Object arg1) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.d(tag, msg);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Object arg1) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2, arg3);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(DEBUG)) {
            d(tag, INSTANCE.formatString(msg, Arrays.copyOf(args, args.length)));
        }
    }

    @JvmStatic
    public static final void d(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(DEBUG)) {
            d(tag, INSTANCE.formatString(msg, Arrays.copyOf(args, args.length)), tr);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.d(tag, string);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.d(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.d(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void d(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(DEBUG)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.d(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.i(tag, msg);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Object arg1) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.i(tag, msg);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Object arg1) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2, arg3);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, arg1, arg2, arg3, arg4);
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.i(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.i(tag, string);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        FLog fLog = INSTANCE;
        if (isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.i(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.i(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void i(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(INFO)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.i(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void w(String tag, String msg) {
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.w(tag, msg);
        }
    }

    @JvmStatic
    public static final void w(Class<?> cls, String msg) {
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.w(tag, msg);
        }
    }

    @JvmStatic
    public static final void w(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.w(tag, string);
        }
    }

    @JvmStatic
    public static final void w(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.w(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void w(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.w(tag, string);
        }
    }

    @JvmStatic
    public static final void w(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        FLog fLog = INSTANCE;
        if (isLoggable(WARN)) {
            w(cls, fLog.formatString(msg, Arrays.copyOf(args, args.length)), tr);
        }
    }

    @JvmStatic
    public static final void w(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.w(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void w(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(WARN)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.w(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void e(String tag, String msg) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.e(tag, msg);
        }
    }

    @JvmStatic
    public static final void e(Class<?> cls, String msg) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.e(tag, msg);
        }
    }

    @JvmStatic
    public static final void e(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.e(tag, string);
        }
    }

    @JvmStatic
    public static final void e(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.e(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void e(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.e(tag, string);
        }
    }

    @JvmStatic
    public static final void e(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.e(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void e(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.e(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void e(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.e(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void wtf(String tag, String msg) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.wtf(tag, msg);
        }
    }

    @JvmStatic
    public static final void wtf(Class<?> cls, String msg) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            loggingDelegate.wtf(tag, msg);
        }
    }

    @JvmStatic
    public static final void wtf(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.wtf(tag, string);
        }
    }

    @JvmStatic
    public static final void wtf(String tag, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            String string = INSTANCE.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.wtf(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void wtf(Class<?> cls, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            loggingDelegate.wtf(tag, string);
        }
    }

    @JvmStatic
    public static final void wtf(Class<?> cls, Throwable tr, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            String string = fLog.formatString(msg, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.wtf(tag, string, tr);
        }
    }

    @JvmStatic
    public static final void wtf(String tag, String msg, Throwable tr) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            Intrinsics.checkNotNull(tag);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.wtf(tag, msg, tr);
        }
    }

    @JvmStatic
    public static final void wtf(Class<?> cls, String msg, Throwable tr) {
        if (handler.isLoggable(ERROR)) {
            LoggingDelegate loggingDelegate = handler;
            FLog fLog = INSTANCE;
            Intrinsics.checkNotNull(cls);
            String tag = fLog.getTag(cls);
            Intrinsics.checkNotNull(msg);
            Intrinsics.checkNotNull(tr);
            loggingDelegate.wtf(tag, msg, tr);
        }
    }

    private final String formatString(String str, Object... args) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(str);
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str2 = String.format(null, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    private final String getTag(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
