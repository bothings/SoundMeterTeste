package br.com.brunooliveira.soundmeterteste;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class MainActivity extends Activity {
    //SoundMeter sm;
    TextView tx;
    Handler handler = new Handler();
    SoundMeter smt = new SoundMeter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = (TextView) findViewById(R.id.sound);

        smt.start();

        new Thread(new Runnable() {
            double amp;
            @Override
            public void run() {
                while(true){
                    amp = smt.getAmplitude();
                    System.out.print("Amplitude: ");
                    System.out.println(amp);
                }

            }
        }).start();
    }
}

    /*
    @Override
    protected void onResume() {
        sm.start();
        final int a = 0;
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(a == 0){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tx.setText("db: " + sm.getAmplitude());

                        }
                    });
                    //System.out.println("*****SOM: "  );

                }

            }
        }).start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/
