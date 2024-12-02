package com.example.gestiondetaches.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// تعريف الألوان باستخدام lightColorScheme في Material 3
private val LightThemeColors = lightColorScheme(
    primary = Primary,
    secondary = Secondary
    // يمكنك إضافة المزيد من الألوان حسب حاجتك مثل background, surface, إلخ.
)

@Composable
fun GestionDeTachesTheme(content: @Composable () -> Unit) {
    // استخدام MaterialTheme من Material 3
    MaterialTheme(
        colorScheme = LightThemeColors,  // هنا نستخدم colorScheme بدلاً من colors
        content = content
    )
}
