package com.useinsider.insider;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.DisplayMetrics;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.bouncycastle.i18n.ErrorBundle;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class c4 {
    static void a(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                    a(file2);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static PendingIntent b(Context context, String str) {
        try {
            return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), a(context, str), 201326592);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    static Intent a(Context context, String str) {
        Intent intent = new Intent("delete_interactive_broadcast");
        try {
            intent.setClass(context, DeleteInteractiveReceiver.class);
            intent.putExtra("folder_id", str);
            return intent;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return intent;
        }
    }

    private static DisplayMetrics b(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    static Bitmap b(String str) {
        Bitmap bitmapDecodeStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
            w4.a((Closeable) fileInputStream);
            return bitmapDecodeStream;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return bitmapDecodeStream;
        }
    }

    static void a(Context context, Notification notification, ConcurrentHashMap concurrentHashMap, String str, String str2, String str3) {
        try {
            if (concurrentHashMap.containsKey(str3)) {
                notification.bigContentView.setInt(w4.f(context, str2), str, Color.parseColor((String) concurrentHashMap.get(str3)));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static Bitmap a(Context context, String str, int i, int i2) {
        float fD;
        Bitmap bitmapCreateScaledBitmap = null;
        try {
            float fD2 = w4.d(context, "ins_car_im_size");
            if (i == 0) {
                fD = fD2;
            } else if (i == 1) {
                fD2 = b(context).widthPixels;
                fD = fD2;
            } else if (i != 2) {
                fD = fD2;
                fD2 = 0.0f;
            } else {
                fD2 = b(context).widthPixels / 2.0f;
                fD = w4.d(context, "ins_car_disc_size");
            }
            Bitmap bitmapB = w4.b(str);
            if (bitmapB != null && fD2 != 0.0f) {
                float fMin = Math.min(fD / bitmapB.getHeight(), fD2 / bitmapB.getWidth());
                if (fMin == 1.0f) {
                    return bitmapB;
                }
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapB, (int) (bitmapB.getWidth() * fMin), (int) (bitmapB.getHeight() * fMin), true);
                if (bitmapCreateScaledBitmap.getAllocationByteCount() > i2) {
                    float allocationByteCount = bitmapCreateScaledBitmap.getAllocationByteCount() / i2;
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapB, (int) (bitmapCreateScaledBitmap.getWidth() / allocationByteCount), (int) (bitmapCreateScaledBitmap.getHeight() / allocationByteCount), true);
                }
                bitmapB.recycle();
                return bitmapCreateScaledBitmap;
            }
            return null;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return bitmapCreateScaledBitmap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.FileOutputStream, java.io.OutputStream] */
    static String a(Bitmap bitmap, File file, String str) throws Throwable {
        ?? fileOutputStream;
        try {
            String str2 = file.getAbsolutePath() + DomExceptionUtils.SEPARATOR + str;
            File file2 = new File(file, str);
            ?? r3 = 0;
            ?? r4 = 0;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            fileOutputStream.close();
                            return str2;
                        } catch (Exception e) {
                            e = e;
                            r4 = fileOutputStream;
                            Insider.Instance.putException(e);
                            r3 = r4;
                            if (r4 != 0) {
                                r4.close();
                                r3 = r4;
                            }
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != 0) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    Insider.Instance.putException(e2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = r3;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                Insider insider = Insider.Instance;
                insider.putException(e4);
                r3 = insider;
            }
        } catch (Exception e5) {
            Insider.Instance.putException(e5);
            return "";
        }
    }

    static b4 a(String str) {
        Exception e;
        b4 b4Var;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("slides");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.equals("deep_links")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        Iterator<String> itKeys2 = jSONObject3.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            concurrentHashMap.put(next2, jSONObject3.getString(next2));
                        }
                    } else {
                        concurrentHashMap.put(next, jSONObject2.getString(next));
                    }
                }
                arrayList.add(concurrentHashMap);
            }
            b4Var = new b4(arrayList);
            try {
                b4Var.a(jSONObject.getInt("type"));
                if (jSONObject.has(ErrorBundle.DETAIL_ENTRY)) {
                    b4Var.a(jSONObject.getJSONObject(ErrorBundle.DETAIL_ENTRY));
                }
                return b4Var;
            } catch (Exception e2) {
                e = e2;
                Insider.Instance.putException(e);
                return b4Var;
            }
        } catch (Exception e3) {
            e = e3;
            b4Var = null;
        }
    }

    static int a(Context context) {
        int iE = w4.e(context, "insider_notification_icon");
        return iE == 0 ? context.getApplicationInfo().icon : iE;
    }
}
