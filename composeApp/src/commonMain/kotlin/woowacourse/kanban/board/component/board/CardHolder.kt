package woowacourse.kanban.board.component.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.card.KanbanCard
import woowacourse.kanban.board.domain.KanbanTask
import woowacourse.kanban.board.domain.dialog.Status

@Composable
fun CardHolder(status: Status, cards: List<KanbanTask>, modifier: Modifier = Modifier) {
    val (bodyColor, borderColor) = when (status) {
        Status.TO_DO -> Color(0xFFEFF6FF) to Color(0xFFBEDBFF)
        Status.IN_PROGRESS -> Color(0xFFFFFBEB) to Color(0xFFFEE685)
        Status.DONE -> Color(0xFFF0FDF4) to Color(0xFFB9F8CF)
    }

    Column(
        modifier = modifier
            .width(320.dp),
    ) {
        CardHolderTitle(
            status = status,
            cardCount = cards.size,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 700.dp)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(bodyColor)
                .border(1.dp, borderColor, RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .padding(vertical = 16.dp, horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                count = cards.size,
                key = { index -> "$index ${cards[index].title}" },
            ) {
                KanbanCard(
                    title = cards[it].title,
                    crewName = cards[it].assignee,
                    tags = cards[it].tags,
                    description = cards[it].description,
                )
            }
        }
    }
}

@Composable
private fun CardHolderTitle(status: Status, cardCount: Int, modifier: Modifier = Modifier) {
    val (text, color) = when (status) {
        Status.TO_DO -> "To Do" to Color(0xFF155DFC)
        Status.IN_PROGRESS -> "In Progress" to Color(0xFFE17100)
        Status.DONE -> "Done" to Color(0xFF00A63E)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .background(color)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .padding(vertical = 2.dp, horizontal = 10.dp),
        ) {
            Text(
                text = cardCount.toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun CardHolderPreview() {
    CardHolder(
        status = Status.TO_DO,
        cards = listOf(
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.TO_DO,
                assignee = "다이노",
            ),
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.TO_DO,
                assignee = "다이노",
            ),
        ),
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun CardHolderTitlePreview() {
    CardHolderTitle(
        status = Status.TO_DO,
        cardCount = 3,
    )
}
