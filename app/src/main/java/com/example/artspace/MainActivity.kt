package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun ButtonRow(
    increaseStep: () -> Unit,
    decreaseStep: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = { decreaseStep() },
            modifier = Modifier
                .width(120.dp),
            shape = RoundedCornerShape(40.dp),
        ) {
            Text(
                text = "Previous",
                modifier = modifier
            )
        }
        Button(
            onClick = { increaseStep() },
            modifier = Modifier
                .width(120.dp),
            shape = RoundedCornerShape(40.dp),
        ) {
            Text(
                text = "Next",
                modifier = modifier
            )
        }
    }
}

@Composable
fun InfoRow(
    title: String,
    artistAndYear: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .background(color = Color(0xFFEEEAEA))
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = artistAndYear,
                style = MaterialTheme.typography.labelSmall,
                )
        }
    }
}

@Composable
fun ImageRow(
    @DrawableRes image: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = Modifier
            .height(400.dp)
            .width(400.dp)
            .background(color = Color.Transparent)
            .padding(24.dp)
            .clip(RoundedCornerShape(8.dp)),
//            .clip(RoundedCornerShape(8.dp)),
        color = Color.Transparent,
        shadowElevation = 2.dp,
        tonalElevation = 4.dp,
        ) {
        Image(
            painter = painterResource(image),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
    }
}
@Composable
fun Screen(modifier: Modifier = Modifier) {
    // TODO: include set() to not allow negative numbers
    var currentStep by remember { mutableStateOf(1) }
    var title by remember { mutableStateOf("") }
    var artistAndYear by remember { mutableStateOf("") }
    var contentDescription by remember { mutableStateOf("") }
    var image by remember { mutableStateOf(R.drawable.image_1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when(currentStep % 3) {
            1 -> {
                image = R.drawable.image_1
                title = stringResource(R.string.title_1)
                contentDescription = stringResource(R.string.image_description_1)
                artistAndYear = stringResource(R.string.artist_and_year_1,  "Loaf", 2023)
            }
            2 -> {
                image = R.drawable.image_2
                title = stringResource(R.string.title_2)
                contentDescription = stringResource(R.string.image_description_2)
                artistAndYear = stringResource(R.string.artist_and_year_2,  "Ernesto", 1996)
            }
            0 -> {
                image = R.drawable.image_3
                title = stringResource(R.string.title_3)
                contentDescription = stringResource(R.string.image_description_3)
                artistAndYear = stringResource(R.string.artist_and_year_3,  "Grumpy Pug", 2022)
            }

            else -> {
                // TODO: refactor to allow rotate left any number
                // of images
                currentStep =  2 // abs(currentStep) % 3
            }
        }

        ImageRow(
            image = image,
            contentDescription = contentDescription,
        )
        Spacer(modifier = Modifier.height(100.dp))
        InfoRow(title = title, artistAndYear = artistAndYear)
        ButtonRow(
            increaseStep = { currentStep++ },
            decreaseStep = { currentStep-- }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Screen()
    }
}
