package com.example.artspace.data

import com.example.artspace.R
import com.example.artspace.model.ArtPiece

class Datasource() {
    fun loadArtPieces(): List<ArtPiece> {
        return listOf<ArtPiece>(
            ArtPiece(
                imageResourceId = R.drawable.image_1,
                stringTitleId = R.string.title_1,
                stringArtistAndYearId = R.string.artist_and_year_1,
                stringContentDescriptionId = R.string.image_description_1,
            ),
            ArtPiece(
                imageResourceId = R.drawable.image_2,
                stringTitleId = R.string.title_2,
                stringArtistAndYearId = R.string.artist_and_year_2,
                stringContentDescriptionId = R.string.image_description_2,
            ),
            ArtPiece(
                imageResourceId = R.drawable.image_3,
                stringTitleId = R.string.title_3,
                stringArtistAndYearId = R.string.artist_and_year_3,
                stringContentDescriptionId = R.string.image_description_3,
            ),
        )
    }
}