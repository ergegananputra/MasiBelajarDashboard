package com.sic6.masibelajar.ui.screens.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.screens.components.CircleBackground
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showBackground = true,
)
@Composable
private fun SettingScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        SettingScreen()
    }
}

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            SectionTitle(
                title = "Profile",
            )
            ProfileSection()

            SectionTitle(
                title = "Account Settings",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            SettingItem(icon = Icons.Outlined.Person, title = "Account") { }
            SettingItem(icon = Icons.Outlined.WorkOutline, title = "Password & Security") { }
            SettingItem(icon = Icons.Outlined.Notifications, title = "Notification") { }
            SettingItem(icon = Icons.Outlined.Translate, title = "Languages Preferences") { }

            SectionTitle(
                title = "Other",
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
            )
            SettingItem(icon = Icons.AutoMirrored.Default.HelpOutline, title = "Help") { }
            SettingItem(icon = Icons.AutoMirrored.Default.Logout, title = "Logout") { }
        }

        CircleBackground(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 360.dp)
                .zIndex(-1f)
        )
    }
}

@Composable
fun ProfileSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .size(48.dp)
                .background(Color.Gray, shape = CircleShape)
        )
        Column {
            Text(
                text = "Shyra Athaya",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "shyray3@gmail.com",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier.padding(horizontal = 20.dp)
    )
}

@Composable
fun SettingItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(start = 20.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                    .size(20.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal
            )
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier.padding(end = 20.dp)
        )
    }
}


