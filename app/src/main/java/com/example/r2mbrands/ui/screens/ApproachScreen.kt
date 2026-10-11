package com.example.r2mbrands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.data.WorkflowStep
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.NeuInsetBox
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.components.WorkflowChainView
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft

@Composable
fun ApproachScreen(
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    val phases = R2MRepository.approachPhases

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("approach_screen"),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            SectionHeader(
                eyebrow = "Our Methodology",
                title = "Predict. Execute. Win.",
                description = "A closed loop that connects planning to the field and back again. It is how we keep coverage honest and growth repeatable."
            )
        }

        // 3 Pillars
        item {
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                phases.forEach { phase ->
                    PhaseCard(phase = phase)
                }
            }
        }

        // 6-Step Closed Loop
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    eyebrow = "Accountable Loop",
                    title = "Six steps, zero blind spots",
                    description = "From route design to reporting, each operational step hands clean telemetry to the next."
                )

                Spacer(modifier = Modifier.height(14.dp))

                WorkflowChainView()
            }
        }

        item {
            CtaBandCard(
                onNavigateToContact = onNavigateToContact,
                title = "See the loop run on your brand",
                subtitle = "Let's benchmark your current outlet penetration against our 47-county trade dataset."
            )
        }
    }
}

@Composable
fun PhaseCard(
    phase: WorkflowStep,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("phase_card_${phase.tag.lowercase()}"),
        cornerRadius = 24.dp,
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "0${phase.stepNumber}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0x33122026)
                )
                Spacer(modifier = Modifier.width(12.dp))
                EyebrowBadge(text = phase.tag)
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(R2MTealSoft)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = phase.keyMetric,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MTeal
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = phase.title,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = R2MInk,
                lineHeight = 23.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = phase.blurb,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 19.sp,
                color = R2MInkMuted
            )

            Spacer(modifier = Modifier.height(12.dp))

            NeuInsetBox(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(0xFFE8EEF3),
                cornerRadius = 12.dp
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "DISCIPLINE IN THE FIELD",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = R2MTeal,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = phase.detailedAction,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = R2MInk,
                        lineHeight = 17.sp
                    )
                }
            }
        }
    }
}
