package com.pinterest.pinterest_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pinterest.pinterest_clone.R.drawable.pinterest01
import com.pinterest.pinterest_clone.R.drawable.pinterest02
import com.pinterest.pinterest_clone.R.drawable.pinterest03
import com.pinterest.pinterest_clone.R.drawable.pinterest04
import com.pinterest.pinterest_clone.R.drawable.pinterest05
import com.pinterest.pinterest_clone.R.drawable.pinterest06
import com.pinterest.pinterest_clone.R.drawable.pinterest07
import com.pinterest.pinterest_clone.R.drawable.pinterest08
import com.pinterest.pinterest_clone.R.drawable.pinterest09
import com.pinterest.pinterest_clone.R.drawable.pinterest10
import com.pinterest.pinterest_clone.ui.theme.PinterestcloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinterestcloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CallListHome()
                }
            }
        }
    }
}


@Composable
fun ListHome(items: List<Int>, caption: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items.chunked(2).forEach { rowItems ->
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (item in rowItems) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = item),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .fillMaxSize()
                                    .aspectRatio(0.7f)
                            )
                            Text(text = caption[items.indexOf(item)])
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PinterestClonePreview() {
    PinterestcloneTheme {
        CallListHome()
    }
}


@Composable
private fun CallListHome() {
    val captions = List(10) { index -> "Caption ${index + 1}" }
    ListHome(
        items = listOf(
            pinterest01,
            pinterest02,
            pinterest03,
            pinterest04,
            pinterest05,
            pinterest06,
            pinterest07,
            pinterest08,
            pinterest09,
            pinterest10,
        ), caption = captions
    )
}