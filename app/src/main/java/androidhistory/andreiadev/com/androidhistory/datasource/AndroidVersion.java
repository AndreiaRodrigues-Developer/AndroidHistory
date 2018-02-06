package androidhistory.andreiadev.com.androidhistory.datasource;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "android_versions")
public class AndroidVersion {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String version;
    private String description;
    @ColumnInfo(name = "release_date")
    private String releaseDate;
    private String image;

    public AndroidVersion(int id, String name, String version, String description, String releaseDate, String image) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.releaseDate = releaseDate;
        this.image = image;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
