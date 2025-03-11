package org.acano99.my_home.ui.screens.buyList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.acano99.my_home.ui.composables.ThemeDateHeader
import org.acano99.my_home.ui.composables.ThemeDialogDatePicker
import org.acano99.my_home.ui.screens.common.CommonScreen
import org.acano99.my_home.ui.theme.smallPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildListHomeScreen(navController: NavController? = null) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = 1578096000000,
    )
    var showSelectedDatePicker by remember { mutableStateOf(false) }

    CommonScreen(fab = {}, title = "") {
        ThemeDateHeader(
            modifier = Modifier.fillMaxWidth().padding(start = smallPadding),
            title = "12 de febrero",
            onClick = { showSelectedDatePicker = true }
        )
        if (showSelectedDatePicker)
            ThemeDialogDatePicker(
                modifier = Modifier.fillMaxWidth().padding(horizontal = smallPadding),
                state = datePickerState,
                onDismissRequest = { showSelectedDatePicker = false },
                onAcceptRequest = { }
            )
    }
}