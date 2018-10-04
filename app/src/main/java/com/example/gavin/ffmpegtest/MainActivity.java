package com.example.gavin.ffmpegtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");

        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
    }

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    public void protocol(View view){
        tv.setText(urlprotocolinfo());
    }

    public void filter(View view) {
        tv.setText(avfilterinfo());

    }

    public void format (View view) {
        tv.setText(avformatinfo());
    }

    public void codec (View view){
        tv.setText(avcodecinfo());
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String avformatinfo();
    public native String urlprotocolinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();
}
