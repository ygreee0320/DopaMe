package com.example.dopame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dopame.R
import com.example.dopame.core.designsystem.DopaMeTheme

@Composable
fun HomeScreen(navController: NavController) {
    val isDoneVisible: Boolean by remember { mutableStateOf(false) }

    Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 89.dp, height = 26.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(1f)) // 간격 조정 (.width / .weiget)
            Image(
                painter = painterResource(id = R.drawable.ic_mypage),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // 마이페이지로 이동
                    },
                contentScale = ContentScale.Crop
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_month),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 25.dp)
                .size(width = 83.dp, height = 39.dp),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.img_callender),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 15.dp)
                .height(455.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Button(
            onClick = { // 마이닝 시작하기
                navController.navigate("miningStep1")
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DopaMeTheme.colors.primary60)
        ) {
            Text(
                text = "오늘의 마이닝 시작하기",
                color = DopaMeTheme.colors.gray20,
                style = DopaMeTheme.typography.h1Medium
            )
        }
    }

    if (isDoneVisible) {
        Image(
            painter = painterResource(id = R.drawable.img_home),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
                .background(DopaMeTheme.colors.gray10)
                .clickable {
                    // 마이닝 상세로 이동
                },
            contentScale = ContentScale.Crop
        )
    }
}