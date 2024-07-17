package com.example.dopame.screens.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dopame.core.designsystem.DopaMeTheme

@Composable
fun nextButton(
    navController: NavController,
    nextRoute: String,
    nextEnabled: Boolean = false,
    buttonText: String = "다음"
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Button(
            onClick = { navController.navigate(nextRoute) },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (nextEnabled) DopaMeTheme.colors.primary60 else DopaMeTheme.colors.gray30
            ),
            enabled = nextEnabled,
        ) {
            Text(
                text = buttonText,
                fontSize = 18.sp,
                color = if (nextEnabled) Color.Black else DopaMeTheme.colors.gray60,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium
            )
        }
    }
}