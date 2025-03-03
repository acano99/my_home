package org.acano99.my_home.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.acano99.my_home.ui.theme.highPadding
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.veryHighPadding
import org.acano99.my_home.ui.theme.verySmallPadding

@Composable
fun VerticalMinSpacer() = Spacer(Modifier.height(minPadding))

@Composable
fun VerticalVerySmallSpacer() = Spacer(Modifier.height(verySmallPadding))

@Composable
fun VerticalSmallSpacer() = Spacer(Modifier.height(smallPadding))

@Composable
fun VerticalMediumSpacer() = Spacer(Modifier.height(mediumPadding))

@Composable
fun VerticalHigSpacer() = Spacer(Modifier.height(highPadding))

@Composable
fun VerticalVeryHigSpacer() = Spacer(Modifier.height(veryHighPadding))

@Composable
fun HorizontalMinSpacer() = Spacer(Modifier.height(minPadding))

@Composable
fun HorizontalVerySmallSpacer() = Spacer(Modifier.height(verySmallPadding))

@Composable
fun HorizontalSmallSpacer() = Spacer(Modifier.height(smallPadding))

@Composable
fun HorizontalMediumSpacer() = Spacer(Modifier.height(mediumPadding))

@Composable
fun HorizontalHigSpacer() = Spacer(Modifier.height(highPadding))

@Composable
fun HorizontalVeryHigSpacer() = Spacer(Modifier.height(veryHighPadding))