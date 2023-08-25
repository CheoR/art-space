package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtPiece(
    @StringRes val stringArtistAndYearId: Int,
    @StringRes val stringTitleId: Int,
    @StringRes val stringContentDescriptionId: Int,
    @DrawableRes val imageResourceId: Int
)
