package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.verySmallPadding

@Composable
fun ThemeElevatedButton(
    modifier: Modifier = Modifier.fillMaxWidth().padding(
        minPadding
    ), colors: ButtonColors = ButtonDefaults.elevatedButtonColors(), text: String
) {
    ElevatedButton(
        onClick = {},
        shape = RoundedCornerShape(verySmallPadding),
        modifier = modifier,
        colors = colors
    ) {
        Text(text, fontSize = 18.sp)
    }
}