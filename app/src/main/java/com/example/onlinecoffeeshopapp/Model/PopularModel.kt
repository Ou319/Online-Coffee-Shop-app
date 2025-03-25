import android.os.Parcel
import android.os.Parcelable


data class PopularModel(
    val description:String="",
    val extra:String="",
    val picUrl:ArrayList<String> = ArrayList(),
    val price:Double=0.0,
    val rating:Double=0.0,
    val title:String=""
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(description)
        dest.writeString(extra)
        dest.writeStringList(picUrl)
        dest.writeDouble(price)
        dest.writeDouble(rating)
        dest.writeString(title)
    }

    companion object CREATOR : Parcelable.Creator<PopularModel> {
        override fun createFromParcel(parcel: Parcel): PopularModel {
            return PopularModel(parcel)
        }

        override fun newArray(size: Int): Array<PopularModel?> {
            return arrayOfNulls(size)
        }
    }

}