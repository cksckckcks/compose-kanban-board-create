package woowacourse.kanban.board.util

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


class KanbanValidatorTest {
    @Test
    fun `isTitleValid 검증 - 정상적인 제목이면 true를 반환한다`() {
        assertThat(KanbanValidator.isTitleValid("제목")).isTrue()
    }

    @Test
    fun `isTitleValid 검증 - 공백이거나 비어있으면 false를 반환한다`() {
        assertThat(KanbanValidator.isTitleValid("")).isFalse()
        assertThat(KanbanValidator.isTitleValid("   ")).isFalse()
    }

    @Test
    fun `isTagCountValid 검증 - 태그가 5개 이하이면 true를 반환한다`() {
        assertThat(KanbanValidator.isTagCountValid(emptyList())).isTrue()
        assertThat(KanbanValidator.isTagCountValid(listOf("1", "2", "3", "4", "5"))).isTrue()
    }

    @Test
    fun `isTagCountValid 검증 - 태그가 6개 이상이면 false를 반환한다`() {
        assertThat(KanbanValidator.isTagCountValid(listOf("1", "2", "3", "4", "5", "6"))).isFalse()
    }

    @Test
    fun `isTagFormatValid 검증 - 빈 리스트면 true를 반환한다`() {
        assertThat(KanbanValidator.isTagFormatValid(emptyList())).isTrue()
    }

    @Test
    fun `isTagFormatValid 검증 - 모든 태그가 1~5자이면 true를 반환한다`() {
        assertThat(KanbanValidator.isTagFormatValid(listOf("1", "12345", "태그임다"))).isTrue()
    }

    @Test
    fun `isTagFormatValid 검증 - 태그 중 하나라도 5자를 초과하면 false를 반환한다`() {
        assertThat(KanbanValidator.isTagFormatValid(listOf("정상태그", "여섯글자태그"))).isFalse()
    }

    @Test
    fun `isTagFormatValid 검증 - 태그 중 하나라도 비어있으면 false를 반환한다`() {
        assertThat(KanbanValidator.isTagFormatValid(listOf("정상", ""))).isFalse()
    }
}