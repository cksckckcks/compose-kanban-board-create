package woowacourse.kanban.board.domain

import woowacourse.kanban.board.domain.dialog.Status

data class KanbanTask(
    val title: String,
    val status: Status,
    val assignee: String,
    val description: String? = null,
    val tags: List<String> = emptyList(),
) {
    init {
        require(title.isNotBlank()) { "제목은 비어 있거나 공백만 있을 수 없습니다." }
        require(tags.size <= 5) { "태그는 5개까지만 등록할 수 있습니다." }
        require(tags.all { it.length in 1..5 }) { "태그의 길이는 1에서 5자로 설정해야됩니다." }
    }

    companion object {
        private val TAG_REGEX = "^.{1,5}$".toRegex()

        fun isTitleValid(title: String): Boolean = title.isNotBlank()

        fun isTagCountValid(tags: List<String>): Boolean = tags.size <= 5

        fun isTagFormatValid(tags: List<String>): Boolean {
            if (tags.isEmpty()) return true
            return tags.all { it.matches(TAG_REGEX) }
        }
    }
}
