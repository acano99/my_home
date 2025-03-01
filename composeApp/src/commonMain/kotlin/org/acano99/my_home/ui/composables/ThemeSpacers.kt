package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.acano99.my_home.ui.theme.highPadding
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.verySmallPadding

@Composable
fun MinSpacer() = Spacer(Modifier.height(minPadding))

@Composable
fun VerySmallSpacer() = Spacer(Modifier.height(verySmallPadding))

@Composable
fun SmallSpacer() = Spacer(Modifier.height(smallPadding))

@Composable
fun MediumSpacer() = Spacer(Modifier.height(mediumPadding))

@Composable
fun HigSpacer() = Spacer(Modifier.height(highPadding))