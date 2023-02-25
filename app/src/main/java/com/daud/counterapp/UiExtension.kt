package com.daud.counterapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@Composable
fun CreateButton(imageVector: ImageVector, buttonText: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = { onClick.invoke() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
        Text(text = buttonText, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
    }
}

fun Context.showWarning() {
    Toast.makeText(
        this,
        "Current Count is 0",
        Toast.LENGTH_SHORT
    ).show()
}