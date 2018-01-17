package androidhistory.andreiadev.com.androidhistory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_android_versions, new AndroidVersionsListFragment(), AndroidVersionsListFragment.class.getSimpleName())
                .commit();

    }

}

