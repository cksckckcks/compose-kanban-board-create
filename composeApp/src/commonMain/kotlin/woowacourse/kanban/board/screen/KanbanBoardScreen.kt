package woowacourse.kanban.board.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.board.CardGroup
import woowacourse.kanban.board.component.board.KanbanBoardTopAppBar
import woowacourse.kanban.board.domain.KanbanTask
import woowacourse.kanban.board.domain.dialog.Status

@Composable
fun KanbanBoardScreen() {
    val cards: MutableList<KanbanTask> = remember { mutableStateListOf() }

    KanbanBoardContent(
        cards = cards,
        onNewTaskClick = {
            // 다이얼로그 띄우기
        },
    )
}

@Composable
private fun KanbanBoardContent(
    cards: List<KanbanTask>,
    onNewTaskClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            KanbanBoardTopAppBar(
                title = "안녕하세요 제목입니다",
                completeCount = cards.count { it.status == Status.DONE },
                totalCount = cards.size,
                onNewTaskClick = onNewTaskClick,
            )
        },
        containerColor = Color.White,
    ) { innerPadding ->
        CardGroup(
            cards = cards,
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 1200)
@Composable
private fun KanbanBoardContentPreview() {
    KanbanBoardContent(
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
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.IN_PROGRESS,
                assignee = "다이노",
            ),
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.DONE,
                assignee = "다이노",
            ),
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.DONE,
                assignee = "다이노",
            ),
            KanbanTask(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                status = Status.DONE,
                assignee = "다이노",
            ),
        ),
        onNewTaskClick = { },
    )
}
