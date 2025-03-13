package com.sic6.masibelajar.ui.screens.article

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.sic6.masibelajar.ui.screens.components.CircleBackground
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun ArticleScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        ArticleScreen()
    }
}


@Composable
fun ArticleScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(5) { index ->
                Text("Article $index")
            }
        }

        CircleBackground(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 360.dp)
                .zIndex(-1f)
        )
    }
}