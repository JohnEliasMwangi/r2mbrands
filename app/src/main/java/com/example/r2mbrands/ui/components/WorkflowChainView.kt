package com.example.r2mbrands.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@Composable
fun WorkflowChainView(
    modifier: Modifier = Modifier
) {
    val steps = R2MRepository.workflowSteps
    var selectedStep by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        steps.forEach { step ->
            val isSelected = selectedStep == step.stepNumber
            WorkflowStepCard(
                step = step,
                isSelected = isSelected,
                onClick = {
                    selectedStep = if (isSelected) 0 else step.stepNumber
                }
            )
        }
    }
}

@Composable
fun WorkflowStepCard(
    step: WorkflowStep,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("workflow_step_${step.stepNumber}"),
        cornerRadius = 20.dp,
        elevation = if (isSelected) 8.dp else 4.dp,
        backgroundColor = if (isSelected) Color(0xFFF9FBFC) else Color(0xFFF1F5F8)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Step Number Badge
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) R2MTeal else Color(0xFFE2E8F0)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "0${step.stepNumber}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = if (isSelected) R2MWhite else R2MInk
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = step.tag.uppercase(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = R2MTeal,
                            letterSpacing = 0.8.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(R2MTealSoft)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = step.keyMetric,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = R2MTeal
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = step.title,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = R2MInk
                    )
                }

                Icon(
                    imageVector = if (isSelected) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isSelected) "Collapse" else "Expand",
                    tint = R2MInkMuted,
                    modifier = Modifier.size(20.dp)
                )
            }

            AnimatedVisibility(visible = isSelected) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = step.blurb,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 19.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    NeuInsetBox(
                        modifier = Modifier.fillMaxWidth(),
                        backgroundColor = Color(0xFFE8EEF3),
                        cornerRadius = 12.dp
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "FIELD EXECUTION STANDARD",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = R2MTeal,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = step.detailedAction,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                lineHeight = 17.sp,
                                color = R2MInk
                            )
                        }
                    }
                }
            }
        }
    }
}
