package io.ktor.network.sockets;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SocketOptionsPlatformCapabilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\nJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/network/sockets/SocketOptionsPlatformCapabilities;", "", "<init>", "()V", "Ljava/nio/channels/SocketChannel;", "channel", "", "setReusePort", "(Ljava/nio/channels/SocketChannel;)V", "Ljava/nio/channels/ServerSocketChannel;", "(Ljava/nio/channels/ServerSocketChannel;)V", "Ljava/nio/channels/DatagramChannel;", "(Ljava/nio/channels/DatagramChannel;)V", "", "name", "socketOption", "(Ljava/lang/String;)Ljava/lang/Object;", "", "Ljava/lang/reflect/Field;", "standardSocketOptions", "Ljava/util/Map;", "Ljava/lang/reflect/Method;", "channelSetOption", "Ljava/lang/reflect/Method;", "serverChannelSetOption", "datagramSetOption", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SocketOptionsPlatformCapabilities {
    public static final SocketOptionsPlatformCapabilities INSTANCE = new SocketOptionsPlatformCapabilities();
    private static final Method channelSetOption;
    private static final Method datagramSetOption;
    private static final Method serverChannelSetOption;
    private static final Map<String, Field> standardSocketOptions;

    private SocketOptionsPlatformCapabilities() {
    }

    static {
        Map mapEmptyMap;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls;
        Class<?> cls2;
        Method[] methodArr;
        int length;
        int i;
        Method method4;
        Method method5;
        Field[] fields;
        try {
            Class<?> cls3 = Class.forName("java.net.StandardSocketOptions");
            if (cls3 == null || (fields = cls3.getFields()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Field field : fields) {
                    int modifiers = field.getModifiers();
                    if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers)) {
                        arrayList.add(field);
                    }
                }
                ArrayList arrayList2 = arrayList;
                mapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                for (Object obj : arrayList2) {
                    String name = ((Field) obj).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    mapEmptyMap.put(name, obj);
                }
            }
        } catch (Throwable unused) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        standardSocketOptions = mapEmptyMap;
        Method method6 = null;
        try {
            try {
                Class<?> cls4 = Class.forName("java.net.SocketOption");
                Class<?> cls5 = Class.forName("java.nio.channels.SocketChannel");
                Method[] methods = cls5.getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
                Method[] methodArr2 = methods;
                int length2 = methodArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        method5 = null;
                        break;
                    }
                    method5 = methodArr2[i2];
                    Method method7 = method5;
                    int modifiers2 = method7.getModifiers();
                    if (Modifier.isPublic(modifiers2) && !Modifier.isStatic(modifiers2) && Intrinsics.areEqual(method7.getName(), "setOption") && method7.getParameterTypes().length == 2 && Intrinsics.areEqual(method7.getReturnType(), cls5) && Intrinsics.areEqual(method7.getParameterTypes()[0], cls4) && Intrinsics.areEqual(method7.getParameterTypes()[1], Object.class)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                method = method5;
                while (true) {
                    if (i >= length) {
                        method4 = null;
                        break;
                    }
                    method4 = methodArr[i];
                    Method method8 = method4;
                    int modifiers3 = method8.getModifiers();
                    if (Modifier.isPublic(modifiers3) && !Modifier.isStatic(modifiers3) && Intrinsics.areEqual(method8.getName(), "setOption") && method8.getParameterTypes().length == 2 && Intrinsics.areEqual(method8.getReturnType(), cls2) && Intrinsics.areEqual(method8.getParameterTypes()[0], cls) && Intrinsics.areEqual(method8.getParameterTypes()[1], Object.class)) {
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Throwable unused2) {
                method = null;
            }
            cls = Class.forName("java.net.SocketOption");
            cls2 = Class.forName("java.nio.channels.ServerSocketChannel");
            Method[] methods2 = cls2.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods2, "getMethods(...)");
            methodArr = methods2;
            length = methodArr.length;
            i = 0;
            method2 = method4;
        } catch (Throwable unused3) {
            method2 = null;
        }
        channelSetOption = method;
        serverChannelSetOption = method2;
        try {
            Class<?> cls6 = Class.forName("java.net.SocketOption");
            Class<?> cls7 = Class.forName("java.nio.channels.DatagramChannel");
            Method[] methods3 = cls7.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods3, "getMethods(...)");
            Method[] methodArr3 = methods3;
            int length3 = methodArr3.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    method3 = null;
                    break;
                }
                method3 = methodArr3[i3];
                Method method9 = method3;
                int modifiers4 = method9.getModifiers();
                if (Modifier.isPublic(modifiers4) && !Modifier.isStatic(modifiers4) && Intrinsics.areEqual(method9.getName(), "setOption") && method9.getParameterTypes().length == 2 && Intrinsics.areEqual(method9.getReturnType(), cls7) && Intrinsics.areEqual(method9.getParameterTypes()[0], cls6) && Intrinsics.areEqual(method9.getParameterTypes()[1], Object.class)) {
                    break;
                } else {
                    i3++;
                }
            }
            method6 = method3;
        } catch (Throwable unused4) {
        }
        datagramSetOption = method6;
    }

    public final void setReusePort(SocketChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = channelSetOption;
        Intrinsics.checkNotNull(method);
        method.invoke(channel, objSocketOption, true);
    }

    public final void setReusePort(ServerSocketChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = serverChannelSetOption;
        Intrinsics.checkNotNull(method);
        method.invoke(channel, objSocketOption, true);
    }

    public final void setReusePort(DatagramChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = datagramSetOption;
        Intrinsics.checkNotNull(method);
        method.invoke(channel, objSocketOption, true);
    }

    private final Object socketOption(String name) throws IOException {
        Object obj;
        Field field = standardSocketOptions.get(name);
        if (field != null && (obj = field.get(null)) != null) {
            return obj;
        }
        throw new IOException("Socket option " + name + " is not supported");
    }
}
