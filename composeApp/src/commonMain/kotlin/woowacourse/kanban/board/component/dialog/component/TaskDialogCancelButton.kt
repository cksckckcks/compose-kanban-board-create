package woowacourse.kanban.board.component.dialog.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskDialogCancelButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.White,
        ),
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
private fun TaskDialogSubmitButtonPreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TaskDialogCancelButton(
            text = "취소",
            enabled = true,
            onClick = {},
        )
    }
}
