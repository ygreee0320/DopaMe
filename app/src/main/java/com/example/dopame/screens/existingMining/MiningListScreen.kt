package com.example.dopame.screens.existingMining

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
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
import com.example.dopame.data.model.MiningData
import com.example.dopame.screens.utils.nextButton

@Composable
fun MiningListScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DopaMeTheme.colors.gray20),
        contentAlignment = Alignment.BottomEnd
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
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        text = "오늘의 마이닝을 완료했어요.",
                        color = DopaMeTheme.colors.gray80,
                        style = DopaMeTheme.typography.h1Medium
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "지난 마이닝에 대해 \n오늘의 내가 답변해볼까요?",
                        color = Color.White,
                        style = DopaMeTheme.typography.h1Medium
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_mining_face),
                    contentDescription = "Mining Face",
                    modifier = Modifier.size(width = 100.dp, height = 115.dp),
                    contentScale = ContentScale.Crop
                )
            }

            MiningList()
        }

        nextButton(
            navController = navController,
            nextRoute = "home",
            nextEnabled = true,
            buttonText = "홈으로 돌아가기"
        )
    }
}

@Composable
private fun MiningList() {
    val miningRepository = MiningRepository()
    val getAllData = miningRepository.getAllData()
    val scrollState = rememberLazyListState()
    //data: State<ArrayList<MiningData>?>

    LazyColumn(
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        userScrollEnabled = true
    ) {
        itemsIndexed(
            items = getAllData,
            key = { index, mining ->
                mining.id
            }
        ) {
            index, mining ->
            GridItemCard(data = mining)
        }
        /*data.value?.let {
            items(it) { item ->
                GridItemCard(item)
            }
        }*/
    }
}

@Composable
private fun GridItemCard(data: MiningData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp),
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = DopaMeTheme.colors.gray10)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = data.title,
                color = Color.White
            )
        }
    }
}

class MiningRepository {
    fun getAllData(): List<MiningData> {
        return listOf(
            MiningData(
                id = 0,
                title = "배달앱 무료 배달로 전쟁한다",
                hashTag = listOf("음식", "배달")
            ),
            MiningData(
                id = 1,
                title = "강아지 영상",
                hashTag = listOf("강아지", "동물")
            ),
            MiningData(
                id = 2,
                title = "강아지 영상2",
                hashTag = listOf("강아지", "동물")
            )
        )
    }
}

@Preview
@Composable
private fun MiningListScreenPreview() {
    DopaMeTheme {
        val navController = rememberNavController()
        MiningListScreen(navController = navController)
    }
}