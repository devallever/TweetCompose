package app.allever.android.compose.sample.official.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.compose.sample.app.tweet.R
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorIconPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary

@Preview(showBackground = false)
@Composable
fun TopBar(title: String = "", onBack: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = title,
                color = ColorTextPrimary,
                textAlign = TextAlign.Center,
                fontSize = 17.sp
            )
        }
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            IconButton(onClick = {
                onBack()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.twe_ic_back),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        ColorIconPrimary
                    ),
                    modifier = Modifier
                        .size(48.dp)
                        .padding(12.dp)
                )
            }

        }

    }


}