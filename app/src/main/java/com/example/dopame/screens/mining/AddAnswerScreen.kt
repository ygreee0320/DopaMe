package com.example.dopame.screens.mining

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dopame.core.designsystem.DopaMeTheme
import com.example.dopame.screens.home.AddLinkScreen
import com.example.dopame.screens.utils.nextButton

@Composable
fun AddAnswerScreen(navController: NavController) {

    val focusManager = LocalFocusManager.current
    var answer by remember { mutableStateOf("") }
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
                    painter = painterResource(id = com.example.dopame.R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Q. ",
                    color = DopaMeTheme.colors.primary60,
                    style = DopaMeTheme.typography.h1Medium
                )
                Text(
                    text = "최근 트렌드로 자리 잡은 챌린지 문화에 대해 어떻게 생각하시나요?",
                    color = Color.White,
                    style = DopaMeTheme.typography.h1Medium
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            BasicTextField(
                value = answer,
                onValueChange = { answer = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
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
                singleLine = false,
                decorationBox = { innerTextField ->
                    if (answer.isEmpty()) {
                        Text(
                            text = "떠오르는 생각을 자유롭게 적어보세요.",
                            style = LocalTextStyle.current.copy(
                                color = DopaMeTheme.colors.gray60,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        nextEnabled = false
                    } else {
                        nextEnabled = true
                    }
                    innerTextField()
                }
            )
        }

        nextButton(
            navController = navController,
            nextRoute = "miningDone",
            nextEnabled = nextEnabled,
            buttonText = "작성 완료"
        )
    }
}

@Preview
@Composable
private fun AddAnswerScreenPreview() {
    DopaMeTheme {
        val navController = rememberNavController()
        AddAnswerScreen(navController = navController)
    }
}