package androidhistory.andreiadev.com.androidhistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AndroidVersionDetailFragment extends Fragment {

    AppDatabase database;

    ImageView ivVersionImage;
    TextView tvVersionName;
    TextView tvVersion;
    TextView tvVersionDescription;

    AndroidVersion currentAndroidVersion;

    public AndroidVersionDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android_version_detail, container, false);

        ivVersionImage = view.findViewById(R.id.iv_version_image_detail);
        tvVersionName = view.findViewById(R.id.tv_version_name_detail);
        tvVersion = view.findViewById(R.id.tv_version_detail);
        tvVersionDescription = view.findViewById(R.id.tv_version_description_detail);

        database = AppDatabase.getDatabaseInstance(getContext());

        if (getArguments() != null && getArguments().getInt("androidVersionId") != 0) {
            currentAndroidVersion = database.androidVersionDao().getAndroidVersion(getArguments().getInt("androidVersionId"));
            bindViews();
        }

        return view;
    }

    private void bindViews() {
        Glide.with(getContext()).load(currentAndroidVersion.getImage()).into(ivVersionImage);
        tvVersionName.setText(currentAndroidVersion.getName());
        tvVersion.setText(currentAndroidVersion.getVersion());
        tvVersionDescription.setText(currentAndroidVersion.getDescription());
    }
}
