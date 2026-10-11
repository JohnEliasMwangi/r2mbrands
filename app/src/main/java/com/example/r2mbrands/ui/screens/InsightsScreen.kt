package com.example.r2mbrands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.r2mbrands.data.InsightArticle
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@Composable
fun InsightsScreen(
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var activeArticle by remember { mutableStateOf<InsightArticle?>(null) }

    val allArticles = R2MRepository.insights
    val filteredArticles = remember(searchQuery) {
        if (searchQuery.isBlank()) allArticles
        else allArticles.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.tag.contains(searchQuery, ignoreCase = true) ||
                    it.excerpt.contains(searchQuery, ignoreCase = true)
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("insights_screen"),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            SectionHeader(
                eyebrow = "Field Intel",
                title = "Notes from the field",
                description = "Practical perspectives on distribution, merchandising, and winning the shelf in fast-moving Kenyan trade."
            )
        }

        // Search Bar
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search trade topics (e.g. OTIF, shelf share, leakage)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("insights_search_input"),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = R2MInkMuted
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = R2MTeal,
                    unfocusedBorderColor = Color(0xFFCBD5E1),
                    focusedContainerColor = Color(0xFFF1F5F8),
                    unfocusedContainerColor = Color(0xFFF1F5F8)
                )
            )
        }

        // Articles List
        items(filteredArticles) { article ->
            InsightArticleCard(
                article = article,
                onReadClick = { activeArticle = article }
            )
        }

        item {
            CtaBandCard(
                onNavigateToContact = onNavigateToContact,
                title = "Turn these ideas into shelf wins",
                subtitle = "Schedule a confidential trade review with R2M Brands operations directors."
            )
        }
    }

    // Article Reader Dialog
    activeArticle?.let { article ->
        ArticleReaderDialog(
            article = article,
            onDismiss = { activeArticle = null }
        )
    }
}

@Composable
fun InsightArticleCard(
    article: InsightArticle,
    onReadClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onReadClick)
            .testTag("article_card_${article.id}"),
        cornerRadius = 24.dp,
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                EyebrowBadge(text = article.tag)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = article.readTime,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = R2MInkMuted
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 24.sp,
                color = R2MInk
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = article.excerpt,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 19.sp,
                color = R2MInkMuted
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Read article",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = R2MTeal
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = R2MTeal,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Composable
fun ArticleReaderDialog(
    article: InsightArticle,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier.testTag("article_reader_dialog"),
        shape = RoundedCornerShape(24.dp),
        containerColor = Color(0xFFF1F5F8),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    EyebrowBadge(text = article.tag)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = article.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk,
                        lineHeight = 24.sp
                    )
                }
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = R2MInkMuted
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = article.author,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MTeal
                    )
                    Text(
                        text = article.readTime,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = R2MInkMuted
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = article.fullContent,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 21.sp,
                    color = R2MInk
                )
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = R2MTeal)
            ) {
                Text("Close Reader")
            }
        }
    )
}
