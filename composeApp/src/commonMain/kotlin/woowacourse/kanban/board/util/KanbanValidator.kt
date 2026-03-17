package woowacourse.kanban.board.util

object KanbanValidator {
    private val TAG_REGEX = "^.{1,5}$".toRegex()

    fun isTitleValid(title: String): Boolean = title.isNotBlank()

    fun isTagCountValid(tags: List<String>): Boolean = tags.size <= 5

    fun isTagFormatValid(tags: List<String>): Boolean {
        if (tags.isEmpty()) return true
        return tags.all { it.matches(TAG_REGEX) }
    }
}
