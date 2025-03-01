package org.acano99.my_home

import androidx.compose.ui.window.ComposeUIViewController
import org.acano99.my_home.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }