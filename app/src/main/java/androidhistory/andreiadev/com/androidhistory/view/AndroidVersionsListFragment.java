package androidhistory.andreiadev.com.androidhistory.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidhistory.andreiadev.com.androidhistory.R;
import androidhistory.andreiadev.com.androidhistory.datasource.AndroidVersion;
import androidhistory.andreiadev.com.androidhistory.datasource.AppDatabase;

public class AndroidVersionsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    GridView gridViewAndroidVersions;

    AppDatabase database;

    public AndroidVersionsListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android_versions_list, container, false);

        database = AppDatabase.getDatabaseInstance(getActivity());

        gridViewAndroidVersions = view.findViewById(R.id.gv_android_versions);
        gridViewAndroidVersions.setOnItemClickListener(this);

        loadAndroidVersions();

        return view;
    }

    private void loadAndroidVersions() {
        if (database.androidVersionDao().getAllAndroidVersions().size() == 0) {
            final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            Query query = databaseReference.orderByKey();
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    List<AndroidVersion> androidVersionsList = new ArrayList<>();
                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                        GenericTypeIndicator<List<AndroidVersion>> t = new GenericTypeIndicator<List<AndroidVersion>>() {
                        };
                        androidVersionsList = singleSnapshot.getValue(t);
                        database.androidVersionDao().insertListOfAndroidVersion(androidVersionsList);
                    }
                    gridViewAndroidVersions.setAdapter(new AndroidVersionsAdapter(getActivity(), androidVersionsList));
                    Log.d(getActivity().getClass().getSimpleName(), "onDataChange(): Data loaded with success.");
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e(getActivity().getClass().getSimpleName(), "onCancelled(): " + databaseError.getMessage());
                }
            });
        } else {
            gridViewAndroidVersions.setAdapter(new AndroidVersionsAdapter(getActivity(), database.androidVersionDao().getAllAndroidVersions()));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle bundle = new Bundle();
        bundle.putInt("androidVersionId", database.androidVersionDao().getAllAndroidVersions().get(i).getId());

        AndroidVersionDetailFragment fragment = new AndroidVersionDetailFragment();
        fragment.setArguments(bundle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(new DetailsTransition());
            fragment.setEnterTransition(new Fade());
            fragment.setSharedElementReturnTransition(new DetailsTransition());
            setExitTransition(new Fade());

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addSharedElement(((ConstraintLayout) view)
                            .getChildAt(0), getActivity().getResources().getString(R.string.version_image_transition_key))
                    .addToBackStack(AndroidVersionDetailFragment.class.getSimpleName())
                    .replace(R.id.container_android_versions, fragment, AndroidVersionDetailFragment.class.getSimpleName())
                    .commit();
        }
    }

}
