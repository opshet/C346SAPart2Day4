package sg.edu.rp.c346.id20010021.c346sapart2day4;

import java.io.Serializable;

public class PSIReading  implements Serializable {

    private int index;
    private String place;

    public PSIReading(int index, String place) {
        this.index = index;
        this.place = place;

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
