package woowacourse.kanban.board.component.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import woowacourse.kanban.board.domain.dialog.Status

@Composable
fun CardHolderTitle(
    status: Status,
    cardCount: Int,
    modifier: Modifier = Modifier,
) {
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
private fun CardHolderTitlePreview() {
    CardHolderTitle(
        status = Status.TO_DO,
        cardCount = 3,
    )
}
