package id.ac.ubaya.informatika.satujiwa_nald.model

import com.google.gson.annotations.SerializedName

//data class Donasi(
//    val nama:String?,
//    val yayasan:String?,
//    val deskripsi:String?,
//    val danaSekarang:Int?,
//    val danaButuh:Int?,
//    val hari:String?,
//    val photoUrl:String?
//)

data class Donasi(
    val id:Int?,

    @SerializedName("nama")
    val nama:String?,

    @SerializedName("yayasan")
    val yayasan:String?,

    @SerializedName("deskripsi")
    val deskripsi:String?,

    @SerializedName("danaSekarang")
    val danaSekarang:Int?,

    @SerializedName("danaButuh")
    val danaButuh:Int?,

    @SerializedName("hari")
    val hari:String?,

    @SerializedName("photoURL")
    val photoURL:String?,
)

data class DonasiSaya(
    val id:Int?,

    @SerializedName("nama")
    val nama:String?,

    @SerializedName("yayasan")
    val yayasan:String?,

    @SerializedName("deskripsi")
    val deskripsi:String?,

    @SerializedName("donasiSaya")
    val danaSaya:Int?,

    @SerializedName("hari")
    val hari:String?,

    @SerializedName("photoURL")
    val photoURL:String?,
)