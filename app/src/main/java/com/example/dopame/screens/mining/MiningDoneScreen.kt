package com.example.dopame.screens.mining

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dopame.R
import com.example.dopame.core.designsystem.DopaMeTheme
import kotlinx.coroutines.delay

@Composable
fun MiningDoneScreen(navController: NavController) {

    // 3초 후에 MiningListScreen으로 자동 이동
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("existingMining") {
            popUpTo("miningDone") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DopaMeTheme.colors.gray20)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            IconButton(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close",
                    tint = Color.Unspecified
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_mining_done),
                    contentDescription = "Mining Done",
                    modifier = Modifier.size(width = 270.dp, height = 226.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "오늘의 마이닝 끝!",
                    color = Color.White,
                    style = DopaMeTheme.typography.h1Medium
                )
                Text(
                    text = "도파민을 나의 사고확장으로",
                    color = Color.White,
                    style = DopaMeTheme.typography.h1Medium
                )
            }
        }
    }
}

@Preview
@Composable
private fun MiningDoneScreenPreview() {
    DopaMeTheme {
        val navController = rememberNavController()
        MiningDoneScreen(navController = navController)
    }
}