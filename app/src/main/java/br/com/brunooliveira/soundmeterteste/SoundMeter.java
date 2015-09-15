package br.com.brunooliveira.soundmeterteste;

/**
 * Created by bo on 28/08/15.*/

import android.media.MediaRecorder;

import java.io.IOException;

public class SoundMeter {
    static final private double EMA_FILTER = 0.6;

    private MediaRecorder mRecorder = null;
    private double mEMA = 0.0;
    int amplitude;

    public void start() {

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mRecorder.start();
        mRecorder.getMaxAmplitude();

    }

    public void stop() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public double getAmplitude() {
        //listening to the user
        amplitude = mRecorder.getMaxAmplitude();
        return amplitude;

    }

    public double getAmplitudeEMA() {
        double amp = getAmplitude();
        mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
        return mEMA;
    }
}


