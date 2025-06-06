package eu.kanade.tachiyomi.appwidget.components

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.appwidget.ContainerModifier
import eu.kanade.tachiyomi.appwidget.util.stringResource
import yokai.i18n.MR
import yokai.presentation.core.Constants

@Composable
fun LockedWidget() {
    val context = LocalContext.current
    val intent = Intent(LocalContext.current, Class.forName(Constants.MAIN_ACTIVITY)).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    Box(
        modifier = GlanceModifier
            .clickable(actionStartActivity(intent))
            .then(ContainerModifier)
            .padding(8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(MR.strings.appwidget_unavailable_locked),
            style = TextStyle(
                color = ColorProvider(Color(context.getColor(R.color.appwidget_on_secondary_container))),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            ),
        )
    }
}
