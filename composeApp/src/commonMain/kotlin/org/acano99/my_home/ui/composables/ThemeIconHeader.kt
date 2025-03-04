package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThemeIconHeader(modifier: Modifier = Modifier, imageVector: ImageVector, title: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = imageVector,
            contentDescription = ""
        )
        HorizontalMinSpacer()
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.W500)
    }
}