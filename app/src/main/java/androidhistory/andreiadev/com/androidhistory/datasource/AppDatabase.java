package androidhistory.andreiadev.com.androidhistory.datasource;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {AndroidVersion.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "android_versions-db")
                    //TODO remove this in the future
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        INSTANCE = null;
    }

    public abstract AndroidVersionDao androidVersionDao();
}
