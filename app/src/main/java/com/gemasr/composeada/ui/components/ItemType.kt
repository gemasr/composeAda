package com.gemasr.composeada.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gemasr.composeada.ui.theme.spacing
import com.gemasr.composeada.ui.util.parseTypeToColor

@Preview(showBackground = true)
@Composable
fun ItemType(
    modifier: Modifier = Modifier,
    text: String = "Type",
    selected: Boolean = true,
    boxColor: Color = LocalContentColor.current.copy(ContentAlpha.disabled),
    boxShape: Shape = CircleShape,
    boxHeight: Dp = 30.dp,
    boxWidth: Dp = 90.dp,
    img: Int? = null,
    imgSize: Dp = 30.dp
) {
    Box(
        modifier = modifier
            .width(boxWidth)
            .height(boxHeight)
            .clip(boxShape)
            .background(if (selected) boxColor else Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        if (img != null) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = MaterialTheme.spacing.small)
            ) {
                Image(
                    painter = painterResource(img),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(parseTypeToColor(text)),
                    modifier = Modifier.size(imgSize)
                )
            }
        }
        Text(
            text = text.replaceFirstChar { it.titlecase() },
            color = when {
                selected -> MaterialTheme.colors.onSurface
                else -> LocalContentColor.current.copy(ContentAlpha.disabled)
            }
        )
    }
}