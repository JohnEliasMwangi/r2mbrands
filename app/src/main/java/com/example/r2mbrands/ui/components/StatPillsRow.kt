package com.example.r2mbrands.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MTeal
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StatPillsRow(
    modifier: Modifier = Modifier
) {
    val stats = R2MRepository.stats
    val numberFormat = NumberFormat.getNumberInstance(Locale.US)

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        maxItemsInEachRow = 2
    ) {
        stats.forEach { stat ->
            NeuCard(
                modifier = Modifier
                    .weight(1f)
                    .testTag("stat_pill_${stat.label.lowercase().replace(" ", "_")}"),
                cornerRadius = 20.dp,
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)
                ) {
                    Text(
                        text = "${numberFormat.format(stat.target)}${stat.suffix}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MTeal
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = stat.label,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MInk
                    )
                    Text(
                        text = "Verified field data",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = R2MInkMuted
                    )
                }
            }
        }
    }
}
