package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.verySmallPadding

@Composable
fun ThemeElevatedButton() {
    ElevatedButton(
        onClick = {},
        shape = RoundedCornerShape(verySmallPadding),
        modifier = Modifier.fillMaxWidth().padding(
            minPadding
        )
    ) {
        Text("Planificar nueva comida", fontSize = 18.sp)
    }
}