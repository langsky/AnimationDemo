package hgl.ican.io.animationdemo.materialAnimator;

import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.widget.ImageView;

/**
 * Created by swd1 on 16-11-11.
 */

public class Sample implements Parcelable {

    private final int color;
    private final String name;

    public Sample(@ColorInt int color, String name) {
        this.color = color;
        this.name = name;
    }

    private Sample(Parcel in) {
        color = in.readInt();
        name = in.readString();
    }

    public static final Creator<Sample> CREATOR = new Creator<Sample>() {
        @Override
        public Sample createFromParcel(Parcel in) {
            return new Sample(in);
        }

        @Override
        public Sample[] newArray(int size) {
            return new Sample[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(color);
        dest.writeString(name);
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @BindingAdapter("bind:colorTint")
    public void setColorTint(ImageView imageView, @ColorInt int color) {
        imageView.setBackgroundColor(color);
    }
}
