package androidhistory.andreiadev.com.androidhistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AndroidVersionsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    GridView gridViewAndroidVersions;

    AppDatabase database;

    public AndroidVersionsListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android_versions_list, container, false);

        database = AppDatabase.getDatabaseInstance(getContext());
        insertAndroidVersionsMock();

        gridViewAndroidVersions = view.findViewById(R.id.gv_android_versions);
        gridViewAndroidVersions.setAdapter(new AndroidVersionsAdapter(getContext(), getAndroidVersionsMock()));
        gridViewAndroidVersions.setOnItemClickListener(this);
        return view;
    }

    private void insertAndroidVersionsMock() {
        if (database.androidVersionDao().getAllAndroidVersions().size() == 0) {
            for (AndroidVersion androidVersion : getAndroidVersionsMock()) {
                database.androidVersionDao().insertAndroidVersion(androidVersion);
            }
        }
    }

    private List<AndroidVersion> getAndroidVersionsMock() {

        List<AndroidVersion> androidVersionsList = new ArrayList<>();
        androidVersionsList.add(new AndroidVersion(1, "Cupcake", "1.5",
                "This is the Cupcake Android version.", " ", "https://assets.hongkiat.com/uploads/android-evolution/android-cupcake.jpg"));
        androidVersionsList.add(new AndroidVersion(2, "Donut", "1.6",
                "This is the Donut Android version.", " ", "https://s3.amazonaws.com/user-media.venngage.com/584531-2331ed11b8a0fb7e284862a3f8b079c0.png"));
        androidVersionsList.add(new AndroidVersion(3, "Eclair", "2.0 - 2.1",
                "This is the Eclair Android version.", " ", "http://i1-news.softpedia-static.com/images/news2/Android-SDK-Now-Features-Android-2-0-Eclair-Support-2.png"));
        androidVersionsList.add(new AndroidVersion(4, "Froyo", "2.2 - 2.2.3",
                "This is the Froyo Android version.", " ", "https://images.techhive.com/images/idge/imported/article/ctw/2010/06/11/android-22-upgrade-list-100375844-orig.jpg"));
        androidVersionsList.add(new AndroidVersion(5, "Gingerbread", "2.3 - 2.3.7",
                "This is the Gingerbread Android version.", " ", "https://i-cdn.phonearena.com/images/article/88079-image/Future-Play-Store-apps-will-no-longer-run-on-Android-2.3-Gingerbread.jpg"));
        androidVersionsList.add(new AndroidVersion(6, "Honeycomb", "3 - 3.2.6",
                "This is the Honeycomb Android version.", " ", "https://tctechcrunch2011.files.wordpress.com/2011/02/honeycombbee.png"));
        androidVersionsList.add(new AndroidVersion(7, "Ice Cream Sandwich", "4.0 - 4.0.4",
                "This is the Ice Cream Sandwich Android version.", " ", "https://www.androidcentral.com/sites/androidcentral.com/files/postimages/9274/11x05101719.jpg"));
        androidVersionsList.add(new AndroidVersion(8, "Jelly Bean", "4.1 - 4.3.1",
                "This is the Jelly Bean Android version.", " ", "http://www.androidz.com.br/portal/wp-content/uploads/2012/07/android-jelly-bean1.jpg"));
        androidVersionsList.add(new AndroidVersion(9, "KitKat", "4.4 - 4.4.4",
                "This is the KitKat Android version.", " ", "https://www.android.com/static/2016/img/share/oreo-lg.jpg"));
        androidVersionsList.add(new AndroidVersion(10, "Lollipop", "5.0 - 5.1.1",
                "This is the Lollipop Android version.", " ", "http://img.talkandroid.com/uploads/2014/10/android_lollipop_waving.png"));
        androidVersionsList.add(new AndroidVersion(11, "Marshmallow", "6.0 - 6.0.1",
                "This is the Marshmallow Android version.", " ", "https://img.talkandroid.com/uploads/2015/08/android_marshmallow_large.jpg"));
        androidVersionsList.add(new AndroidVersion(12, "Nougat", "7.0 - 7.1.2",
                "This is the Nougat Android version.", " ", "https://www.android.com/static/2016/img/share/n-lg.png"));
        androidVersionsList.add(new AndroidVersion(13, "Oreo", "8",
                "This is the Oreo Android version.", " ", "https://timedotcom.files.wordpress.com/2017/08/android-oreo.png"));
        return androidVersionsList;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getContext(), "" + getAndroidVersionsMock().get(i).getName(), Toast.LENGTH_SHORT).show();


    }
}
