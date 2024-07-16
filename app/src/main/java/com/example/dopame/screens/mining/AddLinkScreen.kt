package com.example.dopame.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dopame.R
import com.example.dopame.core.designsystem.DopaMeTheme
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlin.random.Random

@Composable
fun AddLinkScreen(navController: NavController) {

    val randomNumber = remember { Random.nextInt(1, 6) }
    var url by remember { mutableStateOf("") }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var nextEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DopaMeTheme.colors.gray20)
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column {
                Text(
                    text = "오늘 본 유튜브 shorts ${randomNumber}번째 영상",
                    color = Color.White,
                    style = DopaMeTheme.typography.h1Medium
                )

                Text(
                    text = "URL 붙여넣기!",
                    color = Color.White,
                    style = DopaMeTheme.typography.h1Medium
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            BasicTextField(
                value = url,
                onValueChange = { url = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = DopaMeTheme.colors.gray30,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                textStyle = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (url.isEmpty()) {
                        Text(
                            text = "url 붙여넣기",
                            style = LocalTextStyle.current.copy(
                                color = DopaMeTheme.colors.gray50,
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (url.isNotEmpty()) {
                val videoId = extractVideoIdFromUrl(url)
                if (videoId != null) {
                    AndroidView(factory = {
                        YouTubePlayerView(context).apply {
                            addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                                override fun onReady(youTubePlayer: YouTubePlayer) {
                                    youTubePlayer.loadVideo(videoId, 0f)
                                }
                            })
                        }
                    })
                    nextEnabled = true
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            Button(
                onClick = { navController.navigate("miningStep2") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (nextEnabled) DopaMeTheme.colors.primary60 else DopaMeTheme.colors.gray30
                ),
                enabled = url.isNotEmpty(),
            ) {
                Text(
                    text = "다음",
                    fontSize = 18.sp,
                    color = if (nextEnabled) Color.Black else DopaMeTheme.colors.gray60,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

fun extractVideoIdFromUrl(url: String): String? {
    val regex = "^(?:https?://)?(?:www\\.|m\\.)?(?:youtube\\.com/(?:v/|watch\\?v=|embed/|shorts/)|youtu\\.be/)([^&?/\\s]+)".toRegex()
    val matchResult = regex.find(url)
    return matchResult?.groups?.get(1)?.value
}

@Preview
@Composable
private fun AddLinkScreenPreview() {
    DopaMeTheme {
        val navController = rememberNavController()
        AddLinkScreen(navController = navController)
    }
}