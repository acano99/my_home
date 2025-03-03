package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding

@Composable
fun ThemeCard(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    content: @Composable (ColumnScope) -> Unit
) {
    ElevatedCard(modifier = modifier, colors = colors) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = smallPadding, horizontal = minPadding), content = content
        )
    }
}