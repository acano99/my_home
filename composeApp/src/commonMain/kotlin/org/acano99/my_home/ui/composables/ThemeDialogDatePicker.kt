package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.smallPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeDialogDatePicker(
    modifier: Modifier = Modifier,
    state: DatePickerState,
    onDismissRequest: () -> Unit,
    onAcceptRequest: (Long) -> Unit
) {
    BasicAlertDialog(
        modifier = modifier, onDismissRequest = onDismissRequest, properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(mediumPadding)) {
            Column {
                DatePicker(state = state, modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.fillMaxWidth().padding(smallPadding),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text("Cancelar")
                    }
                    HorizontalSmallSpacer()
                    OutlinedButton(onClick = { onAcceptRequest(state.selectedDateMillis ?: 0) }) {
                        Text("Aceptar")
                    }
                }
            }
        }
    }
}