package com.rawamune.p2p

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class AppThemeMode { DARK, DESIGNER_LIGHT, CLASSIC_WHITE }
enum class DownloadNetworkMode(val label: String) { MOBILE_ONLY("Только по мобильному интернету"), WIFI_ONLY("Только по WI-FI"), BOTH("По мобильному интернету и WI-FI") }

object AppThemeManager { var currentThemeMode by mutableStateOf(AppThemeMode.DARK) }

@Composable
fun SettingsDialog(onDismiss: () -> Unit) {
    var isLargeBlockActive by remember { mutableStateOf(false) }
    var showSquareAlert by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color(0xFF1E293B),
        title = { Text(text = BrandConfig.TEXT_TECH_TITLE, color = Color.White) },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // БЛОК 7: ЗАГРУЗКА ФАЙЛОВ С КАРТОЙ ПАМЯТИ
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Black.copy(alpha = 0.3f))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        DesignerSdCardIcon()
                        Text(text = "Загрузка файлов", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                    // Переключатель лимита 4ГБ через сотовую сеть
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Ограничение в 4ГБ", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text("Не загружать слишком большие файлы через мобильный интернет.", color = Color.Gray, fontSize = 10.sp)
                        }
                        Switch(
                            checked = isLargeBlockActive,
                            onCheckedChange = { isLargeBlockActive = it; showSquareAlert = it },
                            colors = SwitchDefaults.colors(checkedTrackColor = BrandConfig.ColorBrandTitle)
                        )
                    }
                }

                // =========================================================================
                // СТРОГО КВАДРАТНОЕ УВЕДОМЛЕНИЕ С ЗАКРУГЛЕННОЙ СТЕКЛЯННОЙ КНОПКОЙ «ХОРОШО»
                // =========================================================================
                if (isLargeBlockActive && showSquareAlert) {
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 250.dp) // Жестко квадратная геометрия по ТЗ
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.Black.copy(alpha = 0.5f))
                            .border(2.dp, Color.Red, RoundedCornerShape(14.dp))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text("⚠️ ТРАФИК-КОНТРОЛЬ", color = Color.Red, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
                            Text(text = "У вас включен этот режим ↓ |", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Black)
                            Text(text = "Отключите эту настройку, чтобы загружать более большие файлы.", color = Color.LightGray, fontSize = 11.sp, textAlign = TextAlign.Center)

                            // Овальная закруглённая стеклянная кнопка
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .height(36.dp)
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(Color.White.copy(alpha = 0.1f))
                                    .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(18.dp))
                                    .clickable { showSquareAlert = false },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Хорошо", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text(text = BrandConfig.TEXT_CLOSE, color = Color.White) } }
    )
}
