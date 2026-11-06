package io.github.secnewt.template.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import io.github.secnewt.template.R
import io.github.secnewt.ui.NewtPrimaryButton
import io.github.secnewt.ui.NewtValueRow
import io.github.secnewt.ui.NewtSwitchRow
import io.github.secnewt.ui.NewtSettingsCard
import io.github.secnewt.ui.NewtSummary
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.fillMaxWidth

/**
 * The starter screen. Replace it with the app's first real screen, built from the same shared
 * pieces (see NEWT_STYLE.md in newt-android-lib): a "Right now" summary, settings cards whose
 * rows say their state in words, and worded buttons.
 */
@Composable
fun WelcomeScreen() {
    var example by rememberSaveable { mutableStateOf(false) }
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.semantics { heading() },
            )
            NewtSummary("Right now", "A Newt app: big type, no permissions, no internet.")
            NewtSettingsCard("Settings", icon = Icons.Filled.Settings) {
                NewtSwitchRow("Example switch", example, { example = it }, hint = "Says ON or OFF in words")
                NewtValueRow("Example choice", "Balanced", onClick = {})
            }
            NewtPrimaryButton("Example button", onClick = {}, modifier = Modifier.fillMaxWidth())
        }
    }
}
