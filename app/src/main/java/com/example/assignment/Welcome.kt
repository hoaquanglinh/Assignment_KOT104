package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLayout() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 120.dp, 16.dp, 0.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MAKE YOUR",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF606060)
            )

            Spacer(modifier = Modifier.size(11.dp))

            Text(
                text = "HOME BEAUTIFUL",
                modifier = Modifier
                    .padding(bottom = 16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "The best simple place where you " +
                        "discover most wonderful furnitures and " +
                        "make your home beautiful",
                modifier = Modifier
                    .padding(16.dp, 5.dp, 10.dp, 0.dp),
                fontSize = 18.sp,
                style = TextStyle(lineHeight = 38.sp),
                letterSpacing = 1.5.sp,
                color = Color(0xFF808080)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 170.dp, 16.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        val intent = Intent(context, Login::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(height = 54.dp)
                        .width(159.dp)
                        .background(Color(0xFF242424), shape = RoundedCornerShape(6.dp)),
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 18.sp
                    )
                }
            }
        }

    }
}
