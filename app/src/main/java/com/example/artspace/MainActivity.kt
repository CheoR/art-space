package com.example.artspace

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//                        .background(Color.DarkGray),
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
//            .width(IntrinsicSize.Max)
            .background(Color.Red)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(120.dp),
            shape = RoundedCornerShape(8.dp),
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
            shape = RoundedCornerShape(8.dp),
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
            .background(color = Color.Gray)
            .width(IntrinsicSize.Max)

    ) {
        Column(
        ) {
            // TODO: https://developer.android.com/jetpack/compose/resources
            // embed multiple string resources
            Text(text = stringResource(R.string.title))
            Text(text = stringResource(R.string.artist_and_year, "Loaf", 2023))
//            Text(text = stringResource(R.string.artist))
//            Text(text =  stringResource(R.string.year))
        }
    }
}

@Composable
fun ImageRow(modifier: Modifier = Modifier) {
    var image = painterResource(R.drawable.icon)
    var contentDescription = stringResource(R.string.image_description)
    Surface(
        modifier = Modifier
            .background(color=Color.Transparent)
            .clip(RoundedCornerShape(8.dp)),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,

        ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            modifier = Modifier
                .background(color=Color.Transparent)
                .padding(2.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
    }
}
@Composable
fun Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(IntrinsicSize.Max)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        ImageRow()
        Spacer(modifier = Modifier.height(16.dp))
        InfoRow()
        Spacer(modifier = Modifier.height(16.dp))
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
