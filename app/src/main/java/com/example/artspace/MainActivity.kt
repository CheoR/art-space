package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
fun ButtonRow(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.Red)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = { /*TODO*/ },
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
            onClick = { /*TODO*/ },
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
fun InfoRow(modifier: Modifier = Modifier) {
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
                text = stringResource(R.string.title_1),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.artist_and_year_1,  "Loaf", 2023),
                style = MaterialTheme.typography.labelSmall,
                )
        }
    }
}

@Composable
fun ImageRow(modifier: Modifier = Modifier) {
    var image = painterResource(R.drawable.image_1)
    var contentDescription = stringResource(R.string.image_description_1)
    Surface(
        modifier = Modifier
            .background(color = Color.Transparent)
            .padding(24.dp)
            .clip(RoundedCornerShape(8.dp)),
//            .fillMaxWidth()
//            .height(300.dp)
//            .clip(RoundedCornerShape(8.dp)),
        color = Color.Transparent,
        shadowElevation = 4.dp,
        tonalElevation = 4.dp,

        ) {
        Image(
            painter = image,
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageRow()
        InfoRow()
        ButtonRow()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Screen()
    }
}
