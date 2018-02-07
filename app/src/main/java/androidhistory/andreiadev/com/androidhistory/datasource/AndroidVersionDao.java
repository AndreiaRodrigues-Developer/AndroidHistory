package androidhistory.andreiadev.com.androidhistory.datasource;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AndroidVersionDao {

    @Query("SELECT * FROM android_versions")
    List<AndroidVersion> getAllAndroidVersions();

    @Query("SELECT * FROM android_versions WHERE id = :id")
    AndroidVersion getAndroidVersion(int id);

    @Insert
    void insertListOfAndroidVersion(List<AndroidVersion> messages);

    @Insert
    void insertAndroidVersion(AndroidVersion androidVersion);

    @Delete
    int deleteAndroidVersion(AndroidVersion androidVersion);

}
