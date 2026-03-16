package woowacourse.kanban.board.domain

import kotlin.test.Test
import kotlin.test.assertFailsWith
import org.assertj.core.api.Assertions.assertThat
import woowacourse.kanban.board.domain.dialog.Status

class KanbanTaskTest {
    @Test
    fun `KanbanTask 정상 생성 - 모든 정보가 올바른 경우`() {
        // Given
        val title = "새로운 기능 구현"
        val description = "이 기능은 매우 중요합니다."
        val tags = listOf("긴급", "백엔드")
        val crewName = "아키"

        // When
        val task = KanbanTask(
            title = title,
            description = description,
            tags = tags,
            status = Status.TO_DO,
            assignee = crewName,
        )

        // Then
        assertThat(task.title).isEqualTo(title)
        assertThat(task.description).isEqualTo(description)
        assertThat(task.tags).containsExactlyElementsOf(tags)
        assertThat(task.assignee).isEqualTo(crewName)
    }

    @Test
    fun `KanbanTask 생성 실패 - 제목이 비어 있는 경우`() {
        // Given
        val emptyTitle = ""

        // When & Then
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanTask(
                title = emptyTitle,
                status = Status.TO_DO,
                assignee = "아키",
            )
        }
        assertThat(exception.message).isEqualTo("제목은 비어 있거나 공백만 있을 수 없습니다.")
    }

    @Test
    fun `KanbanTask 생성 실패 - 제목이 공백만 있는 경우`() {
        // Given
        val blankTitle = "   \t\n\r\n\t\n"

        // When & Then
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanTask(
                title = blankTitle,
                status = Status.TO_DO,
                assignee = "아키",
            )
        }
        assertThat(exception.message).isEqualTo("제목은 비어 있거나 공백만 있을 수 없습니다.")
    }

    @Test
    fun `KanbanTask 생성 실패 - 태그가 5개 이상인 경우`() {
        // Given
        val tags = listOf("안녕1", "안녕2", "안녕3", "안녕4", "안녕5", "안녕6")


        // When & Then
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanTask(
                title = "제목",
                status = Status.TO_DO,
                assignee = "아키",
                tags = tags,
            )
        }
        assertThat(exception.message).isEqualTo("태그는 5개까지만 등록할 수 있습니다.")
    }

    @Test
    fun `KanbanTask 생성 실패 - 태그 중 5글자가 넘는 태그가 있는 경우`() {
        // Given
        val tags = listOf("안녕하세요긴태그", "안녕")

        // When & Then
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanTask(
                title = "제목",
                status = Status.TO_DO,
                assignee = "아키",
                tags = tags,
            )
        }
        assertThat(exception.message).isEqualTo("태그의 길이는 1에서 5자로 설정해야됩니다.")
    }
}
