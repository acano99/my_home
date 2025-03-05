package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myhome.composeapp.generated.resources.Res
import myhome.composeapp.generated.resources.today
import org.jetbrains.compose.resources.stringResource

@Composable
fun ThemeDateHeader(modifier: Modifier = Modifier, title: String) {
    val header = stringResource(Res.string.today)
    ThemeCard {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Default.DateRange,
                contentDescription = null
            )
            HorizontalVerySmallSpacer()
            Text(text = buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 34.sp)) {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append(header)
                    }
                    append("\n")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 32.sp
                        )
                    ) {
                        append(title)
                    }
                }

            })
        }
    }
}