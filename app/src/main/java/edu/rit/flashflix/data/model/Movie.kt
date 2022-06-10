package edu.rit.flashflix.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

class ResponseWrapper<T>(
    val results: List<T>
)

@Entity
@Parcelize
class Movie (
    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val backdrop_path: String,
    val title: String?,
    val name: String?,
    val overview: String,
    val vote_average: Double
) : Parcelable