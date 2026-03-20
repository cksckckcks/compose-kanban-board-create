package woowacourse.kanban.board.component.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.domain.KanbanTask
import woowacourse.kanban.board.domain.dialog.Status

@OptIn(ExperimentalTestApi::class)
class CardHolderTest {
    @Test
    fun `상태가 ToDo일 때 타이틀이 화면에 표시된다`() = runComposeUiTest {
        val status = Status.TO_DO

        setContent {
            CardHolder(
                status = status,
                cards = emptyList(),
            )
        }

        onNodeWithText("To Do").assertIsDisplayed()
    }

    @Test
    fun `상태가 In Progress일 때 타이틀이 화면에 표시된다`() = runComposeUiTest {
        val status = Status.IN_PROGRESS

        setContent {
            CardHolder(
                status = status,
                cards = emptyList(),
            )
        }

        onNodeWithText("In Progress").assertIsDisplayed()
    }

    @Test
    fun `상태가 Done일 때 타이틀이 화면에 표시된다`() = runComposeUiTest {
        val status = Status.DONE

        setContent {
            CardHolder(
                status = status,
                cards = emptyList(),
            )
        }

        onNodeWithText("Done").assertIsDisplayed()
    }

    @Test
    fun `리스트의 개수가 화면에 잘 표시된다`() = runComposeUiTest {
        val status = Status.TO_DO

        setContent {
            CardHolder(
                status = status,
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

        onNodeWithText("2").assertIsDisplayed()
    }
}
