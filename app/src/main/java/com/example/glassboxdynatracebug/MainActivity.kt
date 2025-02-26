package com.example.glassboxdynatracebug

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clarisite.mobile.Glassbox
import com.clarisite.mobile.StartupSettings.StartupSettingsBuilder.aSettingsBuilder
import com.example.glassboxdynatracebug.ui.theme.GlassboxDynatraceBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

                try {
            Glassbox.start(aSettingsBuilder()
                .withApplicationCtx(this)
                .withReportUrl("https://report.ybs.gbqofs.io")
                .withAppId("46d314d3-70d4-4c25-a128-5d5f3908cb6a")
                .withCuid("ruvhh15k")
                .build());
        } catch (e: Exception) {
            Log.e("GB", "GB execution exception: + ${e.message}")
        }

        setContent {
            GlassboxDynatraceBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlassboxDynatraceBugTheme {
        Greeting("Android")
    }
}