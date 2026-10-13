package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class r1 {
    /* JADX WARN: Code duplicated, block: B:35:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0074 A[Catch: IOException -> 0x0070, TRY_LEAVE, TryCatch #5 {IOException -> 0x0070, blocks: (B:32:0x006c, B:36:0x0074), top: B:57:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:48:0x008f A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #8 {IOException -> 0x008b, blocks: (B:44:0x0087, B:48:0x008f), top: B:61:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.FileInputStream] */
    public static final u a(Context context) throws Throwable {
        Exception e;
        ObjectInputStream objectInputStream;
        String str = "";
        Intrinsics.checkNotNullParameter(context, "context");
        ObjectInputStream objectInputStream2 = null;
        objectInputStream2 = null;
        uVar = null;
        uVar = null;
        u uVar = null;
        try {
            try {
                context = context.openFileInput("a.txt");
                try {
                    objectInputStream = new ObjectInputStream(context);
                    try {
                        Object object = objectInputStream.readObject();
                        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type io.mobileshield.sdk.data.domain.DomainData");
                        u uVar2 = (u) object;
                        String strB = uVar2.b();
                        str = strB != null ? strB : "";
                        LocalLogger.log(8, 22205L, str);
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (IOException e2) {
                                String message = e2.getMessage();
                                LocalLogger.log(8, 22900L, message);
                                context = message;
                            }
                        }
                        objectInputStream.close();
                        context = context;
                        uVar = uVar2;
                    } catch (Exception e3) {
                        e = e3;
                        LocalLogger.log(16, 22900L, "LTS : " + e.getMessage());
                        LocalLogger.log(8, 22205L, "");
                        if (context != 0) {
                            try {
                                context.close();
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                            } catch (IOException e4) {
                                context = e4.getMessage();
                                LocalLogger.log(8, 22900L, context);
                            }
                        } else if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    context = context;
                    objectInputStream = null;
                    LocalLogger.log(16, 22900L, "LTS : " + e.getMessage());
                    LocalLogger.log(8, 22205L, "");
                    if (context != 0) {
                        context.close();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                    } else if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return uVar;
                } catch (Throwable th) {
                    th = th;
                    LocalLogger.log(8, 22205L, str);
                    if (context != 0) {
                        try {
                            context.close();
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                            }
                        } catch (IOException e6) {
                            LocalLogger.log(8, 22900L, e6.getMessage());
                            throw th;
                        }
                    } else if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
            }
        } catch (Exception e7) {
            e = e7;
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            context = 0;
        }
        return uVar;
    }
}
