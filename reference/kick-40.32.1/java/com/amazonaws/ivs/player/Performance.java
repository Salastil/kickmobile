package com.amazonaws.ivs.player;

import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
class Performance {
    Performance() {
    }

    static class Monitor {
        private final HashMap<String, Trackable> trackables = new HashMap<>();

        Monitor() {
        }

        Snapshot getSnapshot(String str) {
            Trackable trackable = this.trackables.get(str);
            if (trackable != null) {
                return trackable.getSnapshot();
            }
            return new Snapshot();
        }

        Trackable time(String str) {
            Trackable trackable = this.trackables.get(str);
            if (trackable == null) {
                trackable = new Trackable();
                this.trackables.put(str, trackable);
            }
            trackable.setStartTime();
            return trackable;
        }

        void reset(String str) {
            Trackable trackable = this.trackables.get(str);
            if (trackable != null) {
                trackable.reset();
            }
        }
    }

    static class Trackable implements AutoCloseable {
        private final Snapshot snapshot = new Snapshot();
        private long startTime;

        Trackable() {
        }

        Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            update(System.nanoTime() - this.startTime);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime() {
            this.startTime = System.nanoTime();
        }

        private void update(long j) {
            this.snapshot.numMeasurements++;
            this.snapshot.meanMeasurement += (j - this.snapshot.meanMeasurement) / this.snapshot.numMeasurements;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.snapshot.reset();
        }
    }

    static class Snapshot {
        private int numMeasurements = 0;
        private float meanMeasurement = 0.0f;

        Snapshot() {
        }

        float time() {
            return this.meanMeasurement / 1000000.0f;
        }

        int samples() {
            return this.numMeasurements;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.numMeasurements = 0;
            this.meanMeasurement = 0.0f;
        }
    }
}
