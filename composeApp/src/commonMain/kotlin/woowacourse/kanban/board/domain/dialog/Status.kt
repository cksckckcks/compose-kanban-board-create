package woowacourse.kanban.board.domain.dialog

enum class Status(val label: String) {
    TO_DO(label = "To Do"),
    IN_PROGRESS(label = "In Progress"),
    DONE(label = "Done");
}