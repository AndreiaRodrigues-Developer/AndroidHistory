package androidhistory.andreiadev.com.androidhistory;

/**
 * Created by andreiarodrigues on 16/11/2017.
 */

public class AndroidVersion {
    private String id;
    private String name;
    private String version;
    private String description;
    private String image;

    public AndroidVersion(String id, String name, String version, String description, String image) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
