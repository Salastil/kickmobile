package com.amazonaws.ivs.player;

import com.amazonaws.ivs.player.json.Json;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class ConfigurationParser {
    static HashMap<Class, Field[]> classToFieldMap = new HashMap<>();

    interface Encodable {
        JSONObject toJson() throws JSONException;

        void updateWithJson(JSONObject jSONObject) throws JSONException;
    }

    ConfigurationParser() {
    }

    static <T> T createConfigurationFromJson(JSONObject jSONObject, Class<T> cls) throws JSONException {
        try {
            T tNewInstance = cls.newInstance();
            updateConfigurationFromJson(jSONObject, tNewInstance);
            return tNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    static <T> void updateConfigurationFromJson(JSONObject jSONObject, T t) throws JSONException {
        Field[] fields;
        if (classToFieldMap.containsValue(t.getClass())) {
            fields = classToFieldMap.get(t.getClass());
        } else {
            fields = t.getClass().getFields();
            classToFieldMap.put(t.getClass(), fields);
        }
        for (Field field : fields) {
            Json json = (Json) field.getAnnotation(Json.class);
            if (json != null) {
                String strValue = json.value();
                if (strValue.isEmpty()) {
                    strValue = field.getName();
                }
                boolean zRequired = json.required();
                if (zRequired || jSONObject.has(strValue)) {
                    if (zRequired && !jSONObject.has(strValue)) {
                        throw new JSONException("Field " + field.getName() + " marked required, but was not found in json");
                    }
                    if (field.getType().isArray()) {
                        handleArray(field, strValue, jSONObject, t);
                    } else {
                        Class<?> type = field.getType();
                        if (isBasicType(type)) {
                            handlePrimitive(field, strValue, type, jSONObject, t);
                        } else {
                            handleComposite(field, strValue, type, jSONObject, t);
                        }
                    }
                }
            }
        }
    }

    static <T> JSONObject createJsonFromConfiguration(T t) throws JSONException {
        Field[] fields;
        JSONObject jSONObject = new JSONObject();
        if (classToFieldMap.containsValue(t.getClass())) {
            fields = classToFieldMap.get(t.getClass());
        } else {
            fields = t.getClass().getFields();
            classToFieldMap.put(t.getClass(), fields);
        }
        for (Field field : fields) {
            String name = field.getName();
            Json json = (Json) field.getAnnotation(Json.class);
            if (json != null) {
                String strValue = json.value();
                if (!strValue.isEmpty()) {
                    name = strValue;
                }
                boolean zRequired = json.required();
                boolean z = GetFieldValue(field, t) == null;
                if (zRequired || !z) {
                    if (zRequired && z) {
                        throw new JSONException("Field " + field.getName() + " marked required, but was null");
                    }
                    if (field.getType().isArray()) {
                        Class<?> componentType = field.getType().getComponentType();
                        if (isBasicType(componentType)) {
                            jSONObject.put(name, new JSONArray(GetFieldValue(field, t)));
                        } else {
                            Object[] objArr = (Object[]) GetFieldValue(field, t);
                            JSONArray jSONArray = new JSONArray();
                            for (int i = 0; i < ((Object[]) Objects.requireNonNull(objArr)).length; i++) {
                                jSONArray.put(createJsonFromConfiguration(Objects.requireNonNull(componentType.cast(objArr[i]))));
                            }
                            jSONObject.put(name, jSONArray);
                        }
                    } else {
                        Class<?> type = field.getType();
                        if (isBasicType(type)) {
                            jSONObject.put(name, GetFieldValue(field, t));
                        } else {
                            jSONObject.put(name, createJsonFromConfiguration(type));
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private static <T> void handleArray(Field field, String str, JSONObject jSONObject, T t) throws JSONException {
        Class<?> type = field.getType();
        Class<?> componentType = type.getComponentType();
        int i = 0;
        if (!(jSONObject.get(str) instanceof JSONArray)) {
            SetFieldValue(field, Array.newInstance(componentType, 0), t);
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (type == int[].class || type == Integer[].class) {
            if (!checkJsonArrayType(jSONArray, Integer.class)) {
                SetFieldValue(field, Array.newInstance(componentType, 0), t);
                return;
            }
            Object objNewInstance = Array.newInstance(componentType, jSONArray.length());
            while (i < jSONArray.length()) {
                Array.set(objNewInstance, i, Integer.valueOf(jSONArray.getInt(i)));
                i++;
            }
            SetFieldValue(field, objNewInstance, t);
            return;
        }
        if (type == long[].class || type == Long[].class) {
            if (!checkJsonArrayType(jSONArray, Long.class)) {
                SetFieldValue(field, Array.newInstance(componentType, 0), t);
                return;
            }
            Object objNewInstance2 = Array.newInstance(componentType, jSONArray.length());
            while (i < jSONArray.length()) {
                Array.set(objNewInstance2, i, Long.valueOf(jSONArray.getLong(i)));
                i++;
            }
            SetFieldValue(field, objNewInstance2, t);
            return;
        }
        if (type == double[].class || type == Double[].class) {
            if (!checkJsonArrayType(jSONArray, Double.class)) {
                SetFieldValue(field, Array.newInstance(componentType, 0), t);
                return;
            }
            Object objNewInstance3 = Array.newInstance(componentType, jSONArray.length());
            while (i < jSONArray.length()) {
                Array.set(objNewInstance3, i, Double.valueOf(jSONArray.getDouble(i)));
                i++;
            }
            SetFieldValue(field, objNewInstance3, t);
            return;
        }
        if (type == boolean[].class || type == Boolean[].class) {
            if (!checkJsonArrayType(jSONArray, Boolean.class)) {
                SetFieldValue(field, Array.newInstance(componentType, 0), t);
                return;
            }
            Object objNewInstance4 = Array.newInstance(componentType, jSONArray.length());
            while (i < jSONArray.length()) {
                Array.set(objNewInstance4, i, Boolean.valueOf(jSONArray.getBoolean(i)));
                i++;
            }
            SetFieldValue(field, objNewInstance4, t);
            return;
        }
        if (type == String[].class) {
            if (!checkJsonArrayType(jSONArray, String.class)) {
                SetFieldValue(field, Array.newInstance(componentType, 0), t);
                return;
            }
            Object objNewInstance5 = Array.newInstance(componentType, jSONArray.length());
            while (i < jSONArray.length()) {
                Array.set(objNewInstance5, i, jSONArray.getString(i));
                i++;
            }
            SetFieldValue(field, objNewInstance5, t);
            return;
        }
        if (!checkJsonArrayType(jSONArray, JSONObject.class)) {
            SetFieldValue(field, Array.newInstance(componentType, 0), t);
            return;
        }
        Object objNewInstance6 = Array.newInstance(componentType, jSONArray.length());
        while (i < jSONArray.length()) {
            Array.set(objNewInstance6, i, createConfigurationFromJson(jSONArray.getJSONObject(i), componentType));
            i++;
        }
        SetFieldValue(field, objNewInstance6, t);
    }

    private static <T> boolean checkJsonArrayType(JSONArray jSONArray, Class<T> cls) throws JSONException {
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= jSONArray.length()) {
                return true;
            }
            boolean z2 = jSONArray.get(i) instanceof Integer;
            if (!cls.isInstance(0L) && !cls.isInstance(Double.valueOf(0.0d))) {
                z = false;
            }
            if (!cls.isInstance(jSONArray.get(i)) && (!z2 || !z)) {
                return false;
            }
            i++;
        }
    }

    private static <T> void handlePrimitive(Field field, String str, Class<?> cls, JSONObject jSONObject, T t) throws JSONException {
        Object obj = jSONObject.get(str);
        if (cls == Integer.TYPE || cls == Integer.class) {
            if (!(obj instanceof Integer)) {
                throw new JSONException("Found json element {" + str + "} expected type integer, found " + obj.getClass().getName());
            }
            SetFieldValue(field, (Integer) obj, t);
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            if (obj instanceof Long) {
                SetFieldValue(field, (Long) obj, t);
                return;
            }
            if (obj instanceof Integer) {
                SetFieldValue(field, (Integer) obj, t);
                return;
            }
            throw new JSONException("Found json element {" + str + "} expected type Long, found " + obj.getClass().getName());
        }
        if (cls == Double.TYPE || cls == Double.class) {
            if (obj instanceof Double) {
                SetFieldValue(field, (Double) obj, t);
                return;
            }
            if (obj instanceof Integer) {
                SetFieldValue(field, (Integer) obj, t);
                return;
            }
            throw new JSONException("Found json element {" + str + "} expected type Double, found " + obj.getClass().getName());
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            if (!(obj instanceof Boolean)) {
                throw new JSONException("Found json element {" + str + "} expected type Boolean, found " + obj.getClass().getName());
            }
            SetFieldValue(field, (Boolean) obj, t);
            return;
        }
        if (cls == String.class) {
            if (!(obj instanceof String)) {
                throw new JSONException("Found json element {" + str + "} expected type String, found " + obj.getClass().getName());
            }
            SetFieldValue(field, (String) obj, t);
            return;
        }
        throw new JSONException("Unhandled primitive case for json");
    }

    private static <T> void handleComposite(Field field, String str, Class<?> cls, JSONObject jSONObject, T t) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        Object objGetFieldValue = GetFieldValue(field, t);
        if (objGetFieldValue == null) {
            objGetFieldValue = createConfigurationFromJson(jSONObject2, cls);
        } else {
            updateConfigurationFromJson(jSONObject2, objGetFieldValue);
        }
        SetFieldValue(field, objGetFieldValue, t);
    }

    private static <T> boolean isBasicType(Class<T> cls) {
        return cls.isPrimitive() || cls == String.class || cls == Integer.class || cls == Long.class || cls == Double.class || cls == Boolean.class;
    }

    private static <T> void SetFieldValue(Field field, T t, Object obj) throws JSONException {
        try {
            field.set(obj, t);
        } catch (IllegalAccessException unused) {
            throw new JSONException("Couldn't set " + field.getName() + " with value " + t);
        }
    }

    private static Object GetFieldValue(Field field, Object obj) throws JSONException {
        try {
            return field.get(obj);
        } catch (IllegalAccessException unused) {
            throw new JSONException("Couldn't get " + field.getName() + " value");
        }
    }
}
