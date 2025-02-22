package com.example.tipranks.stocks.presentation.views

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tipranks.stocks.domain.model.Stock
import com.example.tipranks.stocks.presentation.StocksAction

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StockCard(
    stock: Stock,
    index: Int,
    modifier: Modifier = Modifier,
    onAction: (StocksAction) -> Unit
) {

    var isLongPressed by remember { mutableStateOf(false) }
    val cardColor by animateColorAsState(
        targetValue = if (isLongPressed) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.surfaceVariant,
        animationSpec = tween(durationMillis = 300),
        label = "Card Color Animation"
    )

    Card(
        modifier = modifier
            .wrapContentSize()
            .padding(8.dp)
            .clickable {
                onAction(StocksAction.OnClickCard(index + 1, stock.label))
            }
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown()
                    isLongPressed = true
                    waitForUpOrCancellation()
                    isLongPressed = false
                }
            },
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
//        CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = stock.label,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Value: ${stock.value}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = "Category: ${stock.category}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = "UID: ${stock.uid}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.clickable {
                    onAction(StocksAction.OnUidClick(stock.uid))
                },
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}