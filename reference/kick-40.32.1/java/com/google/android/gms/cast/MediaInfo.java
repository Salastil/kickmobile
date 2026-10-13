package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.config.ProfilingConfig;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzhs;
import com.google.android.gms.internal.cast.zzhv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1;
    String zzb;
    private String zzc;
    private int zzd;
    private String zze;
    private MediaMetadata zzf;
    private long zzg;
    private List zzh;
    private TextTrackStyle zzi;
    private List zzj;
    private List zzk;
    private String zzl;
    private VastAdsRequest zzm;
    private long zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private JSONObject zzs;
    private final Writer zzt;
    public static final long zza = CastUtils.secToMillisec(-1L);
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzbr();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    /* JADX INFO: loaded from: classes8.dex */
    public static class Builder {
        private String zza;
        private String zzc;
        private MediaMetadata zzd;
        private List zzf;
        private TextTrackStyle zzg;
        private String zzh;
        private List zzi;
        private List zzj;
        private String zzk;
        private VastAdsRequest zzl;
        private String zzm;
        private String zzn;
        private String zzo;
        private String zzp;
        private int zzb = -1;
        private long zze = -1;

        public Builder() {
        }

        public Builder(String str) {
            this.zza = str;
        }

        public Builder(String str, String str2) {
            this.zza = str;
            this.zzk = str2;
        }

        public MediaInfo build() {
            return new MediaInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, -1L, this.zzm, this.zzn, this.zzo, this.zzp);
        }

        public Builder setAdBreakClips(List<AdBreakClipInfo> list) {
            this.zzj = list;
            return this;
        }

        public Builder setAdBreaks(List<AdBreakInfo> list) {
            this.zzi = list;
            return this;
        }

        public Builder setAtvEntity(String str) {
            this.zzm = str;
            return this;
        }

        public Builder setContentType(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zzn = str;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzh = jSONObject == null ? null : jSONObject.toString();
            return this;
        }

        public Builder setEntity(String str) {
            this.zzk = str;
            return this;
        }

        public Builder setHlsSegmentFormat(String str) {
            this.zzo = str;
            return this;
        }

        public Builder setHlsVideoSegmentFormat(String str) {
            this.zzp = str;
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzf = list;
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzd = mediaMetadata;
            return this;
        }

        public Builder setStreamDuration(long j) {
            if (j < 0 && j != -1) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            this.zze = j;
            return this;
        }

        public Builder setStreamType(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.zzb = i;
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzg = textTrackStyle;
            return this;
        }

        public Builder setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zzl = vastAdsRequest;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    public class Writer {
        final /* synthetic */ MediaInfo zza;

        public Writer(MediaInfo mediaInfo) {
            Objects.requireNonNull(mediaInfo);
            this.zza = mediaInfo;
        }

        public void setAdBreakClips(List<AdBreakClipInfo> list) {
            this.zza.zzk(list);
        }

        public void setAdBreaks(List<AdBreakInfo> list) {
            this.zza.zzj(list);
        }

        public void setContentId(String str) {
            this.zza.zzc(str);
        }

        public void setContentType(String str) {
            this.zza.zze(str);
        }

        public void setContentUrl(String str) {
            this.zza.zzo(str);
        }

        public void setCustomData(JSONObject jSONObject) {
            this.zza.zzr(jSONObject);
        }

        public void setEntity(String str) {
            this.zza.zzl(str);
        }

        public void setHlsSegmentFormat(String str) {
            this.zza.zzp(str);
        }

        public void setHlsVideoSegmentFormat(String str) {
            this.zza.zzq(str);
        }

        public void setMediaTracks(List<MediaTrack> list) {
            this.zza.zzh(list);
        }

        public void setMetadata(MediaMetadata mediaMetadata) {
            this.zza.zzf(mediaMetadata);
        }

        public void setStreamType(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.zza.zzd(i);
        }

        public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zza.zzi(textTrackStyle);
        }

        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zza.zzm(vastAdsRequest);
        }

        public void setStartAbsoluteTime(long j) {
            if (j < 0 && j != -1) {
                throw new IllegalArgumentException("Invalid start absolute time");
            }
            this.zza.zzn(j);
        }

        public void setStreamDuration(long j) {
            if (j < 0 && j != -1) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            this.zza.zzg(j);
        }
    }

    MediaInfo(String str, int i, String str2, MediaMetadata mediaMetadata, long j, List list, TextTrackStyle textTrackStyle, String str3, List list2, List list3, String str4, VastAdsRequest vastAdsRequest, long j2, String str5, String str6, String str7, String str8) {
        this.zzt = new Writer(this);
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
        this.zzf = mediaMetadata;
        this.zzg = j;
        this.zzh = list;
        this.zzi = textTrackStyle;
        this.zzb = str3;
        if (str3 != null) {
            try {
                this.zzs = new JSONObject(this.zzb);
            } catch (JSONException unused) {
                this.zzs = null;
                this.zzb = null;
            }
        } else {
            this.zzs = null;
        }
        this.zzj = list2;
        this.zzk = list3;
        this.zzl = str4;
        this.zzm = vastAdsRequest;
        this.zzn = j2;
        this.zzo = str5;
        this.zzp = str6;
        this.zzq = str7;
        this.zzr = str8;
        if (this.zzc == null && str6 == null && str4 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.zzs;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.zzs;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zza(this.zzc, mediaInfo.zzc) && this.zzd == mediaInfo.zzd && CastUtils.zza(this.zze, mediaInfo.zze) && CastUtils.zza(this.zzf, mediaInfo.zzf) && this.zzg == mediaInfo.zzg && CastUtils.zza(this.zzh, mediaInfo.zzh) && CastUtils.zza(this.zzi, mediaInfo.zzi) && CastUtils.zza(this.zzj, mediaInfo.zzj) && CastUtils.zza(this.zzk, mediaInfo.zzk) && CastUtils.zza(this.zzl, mediaInfo.zzl) && CastUtils.zza(this.zzm, mediaInfo.zzm) && this.zzn == mediaInfo.zzn && CastUtils.zza(this.zzo, mediaInfo.zzo) && CastUtils.zza(this.zzp, mediaInfo.zzp) && CastUtils.zza(this.zzq, mediaInfo.zzq) && CastUtils.zza(this.zzr, mediaInfo.zzr);
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        List list = this.zzk;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<AdBreakInfo> getAdBreaks() {
        List list = this.zzj;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getContentId() {
        String str = this.zzc;
        return str == null ? "" : str;
    }

    public String getContentType() {
        return this.zze;
    }

    public String getContentUrl() {
        return this.zzp;
    }

    public JSONObject getCustomData() {
        return this.zzs;
    }

    public String getEntity() {
        return this.zzl;
    }

    public String getHlsSegmentFormat() {
        return this.zzq;
    }

    public String getHlsVideoSegmentFormat() {
        return this.zzr;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzh;
    }

    public MediaMetadata getMetadata() {
        return this.zzf;
    }

    public long getStartAbsoluteTime() {
        return this.zzn;
    }

    public long getStreamDuration() {
        return this.zzg;
    }

    public int getStreamType() {
        return this.zzd;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzi;
    }

    public VastAdsRequest getVmapAdsRequest() {
        return this.zzm;
    }

    public Writer getWriter() {
        return this.zzt;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.Objects.hashCode(this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzf, Long.valueOf(this.zzg), String.valueOf(this.zzs), this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, Long.valueOf(this.zzn), this.zzo, this.zzq, this.zzr);
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzi = textTrackStyle;
    }

    final void zza(JSONObject jSONObject) throws JSONException {
        AdBreakClipInfo adBreakClipInfo;
        AdBreakInfo adBreakInfo;
        int i = 0;
        if (jSONObject.has("breaks")) {
            JSONArray jSONArray = jSONObject.getJSONArray("breaks");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Parcelable.Creator<AdBreakInfo> creator = AdBreakInfo.CREATOR;
                if (jSONObject2 != null && jSONObject2.has("id") && jSONObject2.has(ViewProps.POSITION)) {
                    try {
                        String string = jSONObject2.getString("id");
                        long jSecToMillisec = CastUtils.secToMillisec(jSONObject2.getLong(ViewProps.POSITION));
                        boolean zOptBoolean = jSONObject2.optBoolean("isWatched");
                        long jSecToMillisec2 = CastUtils.secToMillisec(jSONObject2.optLong("duration"));
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("breakClipIds");
                        String[] strArr = new String[i];
                        if (jSONArrayOptJSONArray != null) {
                            strArr = new String[jSONArrayOptJSONArray.length()];
                            for (int i3 = i; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                strArr[i3] = jSONArrayOptJSONArray.getString(i3);
                            }
                        }
                        adBreakInfo = new AdBreakInfo(jSecToMillisec, string, jSecToMillisec2, zOptBoolean, strArr, jSONObject2.optBoolean("isEmbedded"), jSONObject2.optBoolean("expanded"));
                    } catch (JSONException e) {
                        Log.d("AdBreakInfo", String.format(Locale.ROOT, "Error while creating an AdBreakInfo from JSON: %s", e.getMessage()));
                        adBreakInfo = null;
                    }
                } else {
                    adBreakInfo = null;
                }
                if (adBreakInfo == null) {
                    arrayList.clear();
                    break;
                } else {
                    arrayList.add(adBreakInfo);
                    i2++;
                    i = 0;
                }
            }
            this.zzj = new ArrayList(arrayList);
        }
        if (jSONObject.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("breakClips");
            ArrayList arrayList2 = new ArrayList(jSONArray2.length());
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                long j = AdBreakClipInfo.AD_BREAK_CLIP_NOT_SKIPPABLE;
                if (jSONObject3 != null && jSONObject3.has("id")) {
                    try {
                        String string2 = jSONObject3.getString("id");
                        long jSecToMillisec3 = CastUtils.secToMillisec(jSONObject3.optLong("duration"));
                        String strOptStringOrNull = CastUtils.optStringOrNull(jSONObject3, "clickThroughUrl");
                        String strOptStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "contentUrl");
                        String strOptStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "mimeType");
                        if (strOptStringOrNull3 == null) {
                            strOptStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "contentType");
                        }
                        String str = strOptStringOrNull3;
                        adBreakClipInfo = new AdBreakClipInfo(string2, CastUtils.optStringOrNull(jSONObject3, "title"), jSecToMillisec3, strOptStringOrNull2, str, strOptStringOrNull, (r9 == 0 || r9.length() == 0) ? null : jSONObject3.optJSONObject("customData").toString(), CastUtils.optStringOrNull(jSONObject3, "contentId"), CastUtils.optStringOrNull(jSONObject3, "posterUrl"), jSONObject3.has("whenSkippable") ? CastUtils.secToMillisec(((Integer) jSONObject3.get("whenSkippable")).intValue()) : -1L, CastUtils.optStringOrNull(jSONObject3, "hlsSegmentFormat"), VastAdsRequest.fromJson(jSONObject3.optJSONObject("vastAdsRequest")));
                    } catch (JSONException e2) {
                        Log.d("AdBreakClipInfo", String.format(Locale.ROOT, "Error while creating an AdBreakClipInfo from JSON: %s", e2.getMessage()));
                        adBreakClipInfo = null;
                    }
                } else {
                    adBreakClipInfo = null;
                }
                if (adBreakClipInfo == null) {
                    arrayList2.clear();
                    break;
                }
                arrayList2.add(adBreakClipInfo);
            }
            this.zzk = new ArrayList(arrayList2);
        }
    }

    public final JSONObject zzb() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzc);
            jSONObject.putOpt("contentUrl", this.zzp);
            int i = this.zzd;
            if (i != 1) {
                str = i != 2 ? ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT : "LIVE";
            } else {
                str = "BUFFERED";
            }
            jSONObject.put("streamType", str);
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            MediaMetadata mediaMetadata = this.zzf;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.zza());
            }
            long j = this.zzg;
            if (j <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", CastUtils.millisecToSec(j));
            }
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.zzh.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.zzi;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.zzs;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str3 = this.zzl;
            if (str3 != null) {
                jSONObject.put("entity", str3);
            }
            if (this.zzj != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.zzj.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((AdBreakInfo) it2.next()).zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.zzk != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.zzk.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((AdBreakClipInfo) it3.next()).zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.zzm;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j2 = this.zzn;
            if (j2 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j2));
            }
            jSONObject.putOpt("atvEntity", this.zzo);
            String str4 = this.zzq;
            if (str4 != null) {
                jSONObject.put("hlsSegmentFormat", str4);
            }
            String str5 = this.zzr;
            if (str5 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str5);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzd = i;
    }

    final /* synthetic */ void zze(String str) {
        this.zze = str;
    }

    final /* synthetic */ void zzf(MediaMetadata mediaMetadata) {
        this.zzf = mediaMetadata;
    }

    final /* synthetic */ void zzg(long j) {
        this.zzg = j;
    }

    final /* synthetic */ void zzh(List list) {
        this.zzh = list;
    }

    final /* synthetic */ void zzi(TextTrackStyle textTrackStyle) {
        this.zzi = textTrackStyle;
    }

    final /* synthetic */ void zzj(List list) {
        this.zzj = list;
    }

    final /* synthetic */ void zzk(List list) {
        this.zzk = list;
    }

    final /* synthetic */ void zzl(String str) {
        this.zzl = str;
    }

    final /* synthetic */ void zzm(VastAdsRequest vastAdsRequest) {
        this.zzm = vastAdsRequest;
    }

    final /* synthetic */ void zzn(long j) {
        this.zzn = j;
    }

    final /* synthetic */ void zzo(String str) {
        this.zzp = str;
    }

    final /* synthetic */ void zzp(String str) {
        this.zzq = str;
    }

    final /* synthetic */ void zzq(String str) {
        this.zzr = str;
    }

    final /* synthetic */ void zzr(JSONObject jSONObject) {
        this.zzs = jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.zzs;
        this.zzb = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        int i;
        zzhv zzhvVarZzc;
        int i2;
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        String strOptString = jSONObject.optString("streamType", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT);
        int i3 = 2;
        if (ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT.equals(strOptString)) {
            this.zzd = 0;
        } else if ("BUFFERED".equals(strOptString)) {
            this.zzd = 1;
        } else if ("LIVE".equals(strOptString)) {
            this.zzd = 2;
        } else {
            this.zzd = -1;
        }
        this.zze = CastUtils.optStringOrNull(jSONObject, "contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzf = mediaMetadata;
            mediaMetadata.zzb(jSONObject2);
        }
        this.zzg = -1L;
        if (this.zzd != 2 && jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double dOptDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble) && dOptDouble >= 0.0d) {
                this.zzg = CastUtils.secToMillisec(dOptDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            int i4 = 0;
            while (i4 < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                String str = MediaTrack.ROLE_ALTERNATE;
                long j = jSONObject3.getLong("trackId");
                String strOptString2 = jSONObject3.optString("type");
                int i5 = 3;
                if ("TEXT".equals(strOptString2)) {
                    i5 = 1;
                } else if ("AUDIO".equals(strOptString2)) {
                    i5 = i3;
                } else if (!"VIDEO".equals(strOptString2)) {
                    i5 = 0;
                }
                String strOptStringOrNull = CastUtils.optStringOrNull(jSONObject3, "trackContentId");
                String strOptStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "trackContentType");
                String strOptStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "name");
                String strOptStringOrNull4 = CastUtils.optStringOrNull(jSONObject3, DDTags.LANGUAGE_TAG_KEY);
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i = i3;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i = 3;
                    } else {
                        if ("CHAPTERS".equals(string)) {
                            i2 = 4;
                        } else if ("METADATA".equals(string)) {
                            i2 = 5;
                        } else {
                            i = -1;
                        }
                        i = i2;
                    }
                } else {
                    i = 0;
                }
                if (jSONObject3.has("roles")) {
                    int i6 = zzhv.zzd;
                    zzhs zzhsVar = new zzhs();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                        zzhsVar.zzb(jSONArray2.optString(i7));
                    }
                    zzhvVarZzc = zzhsVar.zzc();
                } else {
                    zzhvVarZzc = null;
                }
                arrayList.add(new MediaTrack(j, i5, strOptStringOrNull, strOptStringOrNull2, strOptStringOrNull3, strOptStringOrNull4, i, zzhvVarZzc, jSONObject3.optJSONObject("customData")));
                i4++;
                i3 = 2;
            }
            this.zzh = new ArrayList(arrayList);
        } else {
            this.zzh = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject4);
            this.zzi = textTrackStyle;
        } else {
            this.zzi = null;
        }
        zza(jSONObject);
        this.zzs = jSONObject.optJSONObject("customData");
        this.zzl = CastUtils.optStringOrNull(jSONObject, "entity");
        this.zzo = CastUtils.optStringOrNull(jSONObject, "atvEntity");
        this.zzm = VastAdsRequest.fromJson(jSONObject.optJSONObject("vmapAdsRequest"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double dOptDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(dOptDouble2) && !Double.isInfinite(dOptDouble2) && dOptDouble2 >= 0.0d) {
                this.zzn = CastUtils.secToMillisec(dOptDouble2);
            }
        }
        if (jSONObject.has("contentUrl")) {
            this.zzp = jSONObject.optString("contentUrl");
        }
        this.zzq = CastUtils.optStringOrNull(jSONObject, "hlsSegmentFormat");
        this.zzr = CastUtils.optStringOrNull(jSONObject, "hlsVideoSegmentFormat");
    }
}
