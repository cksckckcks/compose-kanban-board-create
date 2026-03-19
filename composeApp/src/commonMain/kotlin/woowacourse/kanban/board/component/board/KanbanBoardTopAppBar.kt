package woowacourse.kanban.board.component.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KanbanBoardTopAppBar(
    title: String,
    completeCount: Int,
    totalCount: Int,
    onNewTaskClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                TopAppBarTitle(text = title)

                TaskProgressText(
                    completeCount = completeCount,
                    totalCount = totalCount,
                )
            }

            NewTaskButton(
                text = "새 태스크 생성",
                onClick = onNewTaskClick,
            )
        }

        TaskProgressIndicator(
            completeCount = completeCount,
            totalCount = totalCount,
        )
    }
}

@Preview(showBackground = true, widthDp = 800)
@Composable
private fun KanbanBoardTopAppBar() {
    KanbanBoardTopAppBar(
        title = "Compose Desktop 칸반 보드",
        completeCount = 3,
        totalCount = 6,
        onNewTaskClick = { },
    )
}
