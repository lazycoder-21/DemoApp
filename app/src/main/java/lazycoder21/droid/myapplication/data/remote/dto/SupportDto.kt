package lazycoder21.droid.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SupportDto(
    @SerializedName("text")
    val text: String,
    @SerializedName("url")
    val url: String
)