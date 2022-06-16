package lazycoder21.droid.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class UsersDto(
    @SerializedName("data")
    val `data`: List<DataDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val supportDto: SupportDto,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)