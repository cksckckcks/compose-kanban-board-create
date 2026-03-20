package woowacourse.kanban.board.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.board.CardGroup
import woowacourse.kanban.board.component.board.KanbanBoardTopAppBar
import woowacourse.kanban.board.component.dialog.TaskDialog
import woowacourse.kanban.board.domain.KanbanTask
import woowacourse.kanban.board.domain.dialog.Status

@Composable
fun KanbanBoardScreen() {
    val cards: MutableList<KanbanTask> = remember { mutableStateListOf() }
    var isNewTaskDialog by remember { mutableStateOf(false) }

    KanbanBoardContent(
        cards = cards,
        isNewTaskDialog = isNewTaskDialog,
        onNewTaskClick = {
            isNewTaskDialog = true
        },
        onDismissClick = {
            isNewTaskDialog = false
        },
        onCreateClick = {
            cards.add(it)
            isNewTaskDialog = false
        },
    )
}

@Composable
private fun KanbanBoardContent(
    cards: List<KanbanTask>,
    isNewTaskDialog: Boolean,
    onNewTaskClick: () -> Unit,
    onDismissClick: () -> Unit,
    onCreateClick: (KanbanTask) -> Unit,
) {
    Scaffold(
        topBar = {
            KanbanBoardTopAppBar(
                title = "Compose Desktop 칸반 보드",
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

        if (isNewTaskDialog) {
            TaskDialog(
                onDismissClick = onDismissClick,
                onCreateClick = onCreateClick,
            )
        }
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
        isNewTaskDialog = false,
        onNewTaskClick = { },
        onCreateClick = { },
        onDismissClick = { },
    )
}
