package androidhistory.andreiadev.com.androidhistory.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidhistory.andreiadev.com.androidhistory.R;
import androidhistory.andreiadev.com.androidhistory.view.AndroidVersionsListFragment;

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

