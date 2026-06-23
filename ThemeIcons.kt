package com.rawamune.p2p

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun DesignerMoonIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        val r = size.width / 2
        val path = Path().apply {
            arcTo(androidx.compose.ui.geometry.Rect(r*0.3f, r*0.3f, r*1.7f, r*1.7f), -90f, 180f, true)
            quadraticTo(r*0.9f, r, r, r*0.3f)
            close()
        }
        drawPath(path = path, color = BrandConfig.ColorNeonStroke, style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerSunIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawCircle(color = BrandConfig.ColorNeonStroke, radius = size.width * 0.2f, style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerPencilIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawRect(color = BrandConfig.ColorNeonStroke, topLeft = Offset(4f, 4f), size = Size(12f, 12f), style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerLockUserIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawRect(color = BrandConfig.ColorNeonStroke, topLeft = Offset(4f, 10f), size = Size(16f, 10f), style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerWhiteClockIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawCircle(color = Color.White, radius = size.width / 2 - 2f, style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerSdCardIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawRect(color = BrandConfig.ColorNeonStroke, topLeft = Offset(4f, 4f), size = Size(16f, 16f), style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerVmessIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        val p = Path().apply {
            moveTo(size.width * 0.8f, size.height * 0.2f)
            lineTo(size.width * 0.2f, size.height * 0.5f)
            lineTo(size.width * 0.5f, size.height * 0.8f)
            close()
        }
        drawPath(path = p, color = BrandConfig.ColorNeonStroke, style = Stroke(width = 3f))
    }
}

@Composable
fun DesignerBellIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawCircle(color = BrandConfig.ColorNeonStroke, radius = 6f, center = Offset(size.width/2, size.height/2))
    }
}
