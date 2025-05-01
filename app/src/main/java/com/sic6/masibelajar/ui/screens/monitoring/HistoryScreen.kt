package com.sic6.masibelajar.ui.screens.monitoring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.screens.dashboard.WebSocketViewModel
import com.sic6.masibelajar.ui.screens.monitoring.components.HistoryCard
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showBackground = true,
)
@Composable
private fun HistoryScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        HistoryScreen()
    }
}
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: WebSocketViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Smart Setting",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "View past activities and stay updated on your security",
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(28.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Saturday, 28/04/2025",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
            )
        }

        Spacer(Modifier.height(12.dp))

        HistoryItem(
            icon = Icons.Default.DirectionsRun,
            description = "Fall Accident",
            time = "12:10:00",
            color = MaterialTheme.colorScheme.error
        )
        HistoryItem(
            icon = Icons.Default.Person,
            description = "Non-Toddler id #229 leaving the safezone area",
            time = "12:10:00",
            color = Color.Black
        )
        HistoryItem(
            icon = Icons.Default.ChildCare,
            description = "Toddler id #321 has been detected inside the safezone more than specific time",
            time = "12:00:00",
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun HistoryItem(
    icon: ImageVector,
    description: String,
    time: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .padding(end = 12.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = description,
                color = color,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = time,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
