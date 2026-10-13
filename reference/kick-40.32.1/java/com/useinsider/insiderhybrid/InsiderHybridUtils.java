package com.useinsider.insiderhybrid;

import com.useinsider.insider.Insider;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8a1c41283db52d6403eea27da9125d0c7af3cbca81829c3b5167d2377934d1b7 */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderHybridUtils {
    public static ArrayList<Object> convertJSONArrayToArrayList(JSONArray jSONArray) {
        try {
            ArrayList<Object> arrayList = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    arrayList.add(convertJSONObjectToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    arrayList.add(convertJSONArrayToArrayList((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    arrayList.add(obj);
                } else if (obj instanceof Integer) {
                    arrayList.add(obj);
                } else if (obj instanceof Double) {
                    arrayList.add(obj);
                } else if (obj instanceof String) {
                    arrayList.add(obj);
                } else {
                    arrayList.add(String.valueOf(obj));
                }
            }
            return arrayList;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    public static HashMap<String, Object> convertJSONObjectToMap(JSONObject jSONObject) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    map.put(next, convertJSONObjectToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    map.put(next, convertJSONArrayToArrayList((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    map.put(next, obj);
                } else if (obj instanceof Integer) {
                    map.put(next, obj);
                } else if (obj instanceof Double) {
                    map.put(next, obj);
                } else if (obj instanceof String) {
                    map.put(next, obj);
                } else {
                    map.put(next, String.valueOf(obj));
                }
            }
            return map;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    public static <T> boolean isConvertibleToArray(List<?> list, final Class<T> cls) {
        return list.stream().allMatch(new Predicate() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InsiderHybridUtils.lambda$isConvertibleToArray$6(cls, obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$isConvertibleToArray$6(Class cls, Object obj) {
        return obj == null || cls.isInstance(obj);
    }

    static /* synthetic */ boolean lambda$toNumberArray$0(Object obj) {
        return obj instanceof Number;
    }

    static /* synthetic */ Number lambda$toNumberArray$1(Object obj) {
        return (Number) obj;
    }

    static /* synthetic */ Number[] lambda$toNumberArray$2(int i) {
        return new Number[i];
    }

    static /* synthetic */ boolean lambda$toStringArray$3(Object obj) {
        return obj instanceof String;
    }

    static /* synthetic */ String lambda$toStringArray$4(Object obj) {
        return (String) obj;
    }

    static /* synthetic */ String[] lambda$toStringArray$5(int i) {
        return new String[i];
    }

    public static Number[] toNumberArray(List<?> list) {
        return (Number[]) list.stream().filter(new Predicate() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InsiderHybridUtils.lambda$toNumberArray$0(obj);
            }
        }).map(new Function() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return InsiderHybridUtils.lambda$toNumberArray$1(obj);
            }
        }).toArray(new IntFunction() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return InsiderHybridUtils.lambda$toNumberArray$2(i);
            }
        });
    }

    public static String[] toStringArray(List<?> list) {
        return (String[]) list.stream().filter(new Predicate() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InsiderHybridUtils.lambda$toStringArray$3(obj);
            }
        }).map(new Function() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return InsiderHybridUtils.lambda$toStringArray$4(obj);
            }
        }).toArray(new IntFunction() { // from class: com.useinsider.insiderhybrid.InsiderHybridUtils$$ExternalSyntheticLambda6
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return InsiderHybridUtils.lambda$toStringArray$5(i);
            }
        });
    }

    public static HashMap<String, Object> validateMap(Map<String, Object> map) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        HashMap<String, Object> map2 = new HashMap<>();
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                String simpleName = obj.getClass().getSimpleName();
                int iHashCode = simpleName.hashCode();
                if (iHashCode != -1808118735) {
                    if (iHashCode == 578806391 && simpleName.equals("ArrayList")) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (isConvertibleToArray(arrayList, String.class)) {
                            map2.put(str, toStringArray(arrayList));
                        } else if (isConvertibleToArray(arrayList, Number.class)) {
                            map2.put(str, toNumberArray(arrayList));
                        } else {
                            map2.put(str, arrayList.toArray());
                        }
                    } else {
                        map2.put(str, obj);
                    }
                } else if (simpleName.equals("String")) {
                    try {
                        map2.put(str, simpleDateFormat.parse(obj.toString()));
                    } catch (ParseException unused) {
                        map2.put(str, obj);
                    } catch (Exception unused2) {
                    }
                } else {
                    map2.put(str, obj);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
        return map2;
    }
}
