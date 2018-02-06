package androidhistory.andreiadev.com.androidhistory.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import androidhistory.andreiadev.com.androidhistory.datasource.AndroidVersion;
import androidhistory.andreiadev.com.androidhistory.R;

public class AndroidVersionsAdapter extends BaseAdapter {

    private Context context;
    private List<AndroidVersion> androidVersionsList;

    public AndroidVersionsAdapter(Context context, List<AndroidVersion> androidVersionsList) {
        this.context = context;
        this.androidVersionsList = androidVersionsList;
    }

    public int getCount() {
        return this.androidVersionsList.size();
    }

    public AndroidVersion getItem(int i) {
        return androidVersionsList.get(i);
    }

    public long getItemId(int i) {
        return (long) androidVersionsList.get(i).getId();
    }

    public View getView(int i, View convertView, ViewGroup viewGroup) {
        AndroidVersion androidVersion = androidVersionsList.get(i);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_android_versions, null);
        }

        ImageView tvVersionImage = convertView.findViewById(R.id.iv_version_image);
        TextView tvVersionName = convertView.findViewById(R.id.tv_version_image);
        Glide.with(convertView.getContext()).load(androidVersion.getImage()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                Log.e(AndroidVersionsAdapter.class.getSimpleName(), "Glide: Fail loading picture.");
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Log.d(AndroidVersionsAdapter.class.getSimpleName(), "Glide: Resource ready.");
                return false;
            }
        }).into(tvVersionImage);
        tvVersionName.setText(androidVersion.getName());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // the view being shared
            tvVersionImage.setTransitionName(context.getResources().getString(R.string.version_image_transition_key) + i);
        }
        return convertView;
    }
}

