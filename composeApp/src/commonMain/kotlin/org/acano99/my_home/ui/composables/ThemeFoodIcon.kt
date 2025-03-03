package org.acano99.my_home.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.acano99.my_home.ui.theme.minPadding

@Composable
fun ThemeFoodIcon(
    size: Dp = 40.dp,
    backgroundColor: Color = Color.LightGray,
    tint: Color = Color.DarkGray,
    icon: ImageVector
) {
    Icon(
        modifier = Modifier.size(size).background(
            color = backgroundColor,
            shape = RoundedCornerShape(50)
        ).border(
            border = BorderStroke(width = 1.dp, color = backgroundColor),
            shape = RoundedCornerShape(50)
        ).padding(minPadding),
        imageVector = icon,
        contentDescription = null,
        tint = tint
    )
}
