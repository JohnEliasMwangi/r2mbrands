package com.example.r2mbrands.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@Composable
fun NeuCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    elevation: Dp = 6.dp,
    backgroundColor: Color = Color(0xFFF1F5F8),
    borderStroke: BorderStroke? = BorderStroke(1.dp, Color(0x66FFFFFF)),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.shadow(
            elevation = elevation,
            shape = RoundedCornerShape(cornerRadius),
            ambientColor = Color(0xFF94A3B8),
            spotColor = Color(0xFF64748B)
        ),
        shape = RoundedCornerShape(cornerRadius),
        color = backgroundColor,
        border = borderStroke
    ) {
        content()
    }
}

@Composable
fun NeuInsetBox(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    backgroundColor: Color = Color(0xFFE8EEF3),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor)
            .border(1.dp, Color(0x22122026), RoundedCornerShape(cornerRadius))
    ) {
        content()
    }
}

@Composable
fun EyebrowBadge(
    text: String,
    modifier: Modifier = Modifier,
    isDark: Boolean = false
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(if (isDark) Color(0x22FFFFFF) else R2MTealSoft)
            .padding(horizontal = 14.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text.uppercase(),
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.2.sp,
            color = if (isDark) Color(0xFF22D3EE) else R2MTeal
        )
    }
}

@Composable
fun SectionHeader(
    eyebrow: String,
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null
) {
    Column(modifier = modifier.fillMaxWidth()) {
        EyebrowBadge(text = eyebrow)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 30.sp,
            color = R2MInk
        )
        if (!description.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 21.sp,
                color = R2MInkMuted
            )
        }
    }
}

@Composable
fun GradientGlowBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(3.dp)
            .clip(CircleShape)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        R2MTeal,
                        R2MCyan,
                        Color(0xFF8AF3FF),
                        R2MCyan,
                        R2MTeal
                    )
                )
            )
    )
}
