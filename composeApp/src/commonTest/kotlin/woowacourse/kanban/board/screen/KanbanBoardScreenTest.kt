package woowacourse.kanban.board.screen

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanbanBoardScreenTest {
    @Test
    fun `칸반보드 스크린의 카드홀더들이 정상적으로 화면에 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoardScreen()
        }

        onNodeWithText("To Do").assertIsDisplayed()
        onNodeWithText("In Progress").assertIsDisplayed()
        onNodeWithText("Done").assertIsDisplayed()
    }

    @Test
    fun `새 태스크 버튼을 누르면 다이얼로그가 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoardScreen()
        }

        onNodeWithText("새 태스크 생성").performClick()
        onNodeWithText("제목 *").assertIsDisplayed()
    }

    @Test
    fun `태스크를 생성했을 때 칸반보드에 카드가 정상적으로 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoardScreen()
        }

        onNodeWithText("새 태스크 생성").performClick()
        onNodeWithText("태스크 제목을 입력하세요.").performTextInput("안녕하세요")
        onNodeWithText("생성").performClick()
        onNodeWithText("안녕하세요").assertIsDisplayed()
    }

    @Test
    fun `태스크를 생성했을 때 스낵바가 정상적으로 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoardScreen()
        }

        onNodeWithText("새 태스크 생성").performClick()
        onNodeWithText("태스크 제목을 입력하세요.").performTextInput("안녕하세요")
        onNodeWithText("생성").performClick()
        waitForIdle()

        onNodeWithText("새로운 태스크가 추가되었습니다.", useUnmergedTree = true).assertIsDisplayed()
    }
}
