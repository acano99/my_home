package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun ThemeInvoice(modifier: Modifier = Modifier) {
    ThemeCard {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 24.sp)) {
                    withStyle(style = SpanStyle(fontSize = 18.sp, fontWeight = FontWeight.W500)) {
                        append("Factura XXX")
                    }
                    append("\n")
                    append("Vence 12/12/12")
                }
            })
            Text("150 Cup", fontSize = 18.sp)
        }
    }
}