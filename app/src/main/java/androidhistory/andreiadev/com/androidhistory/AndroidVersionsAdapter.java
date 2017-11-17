package androidhistory.andreiadev.com.androidhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AndroidVersionsAdapter extends BaseAdapter {

    Context context;
    List<AndroidVersion> androidVersionsList;

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
        Glide.with(convertView.getContext()).load(androidVersion.getImage()).into(tvVersionImage);
        tvVersionName.setText(androidVersion.getName());
        return convertView;
    }
}

