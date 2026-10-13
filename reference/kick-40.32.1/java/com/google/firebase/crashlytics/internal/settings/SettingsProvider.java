package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes8.dex */
public interface SettingsProvider {
    Task<Settings> getSettingsAsync();

    Settings getSettingsSync();
}
