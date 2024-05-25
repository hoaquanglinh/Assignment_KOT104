package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PayScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PayScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.clickable {
                val intent = Intent(context, Cart::class.java)
                context.startActivity(intent)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)

                )
            }

            Text(
                text = "Check out",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Shipping Address",
                fontSize = 21.sp,
                color = Color(0xFF909090)
            )

            Image(
                painter = painterResource(id = R.drawable.but),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)

            )
        }

        Spacer(modifier = Modifier.padding(7.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clip(shape = RoundedCornerShape(10.dp)),
        ) {
            Text(
                text = "Bruno Fernandes",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp, 15.dp)
            )

            Divider(
                color = Color(0xFFF0F0F0),
                thickness = 1.dp,
                modifier = Modifier.padding(10.dp, 0.dp)
            )

            Column(
                modifier = Modifier.padding(10.dp, 15.dp)
            ) {
                Text(
                    text = "25 rue Robert Latouche, Nice, 06200, Côte",
                    fontSize = 17.sp,
                    color = Color(0xFF808080)
                )
                Text(
                    text = "D’azur, France",
                    fontSize = 17.sp,
                    color = Color(0xFF808080)
                )
            }
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Payment",
                fontSize = 21.sp,
                color = Color(0xFF909090)
            )

            Image(
                painter = painterResource(id = R.drawable.but),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)

            )
        }

        Spacer(modifier = Modifier.padding(7.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White)
                .clip(shape = RoundedCornerShape(7.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .height(35.dp),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = "**** **** **** 3947",
                fontSize = 19.sp,
                color = Color(0xFF242424)
            )

        }

        Spacer(modifier = Modifier.padding(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Delivery method",
                fontSize = 21.sp,
                color = Color(0xFF909090)
            )

            Image(
                painter = painterResource(id = R.drawable.but),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)

            )
        }

        Spacer(modifier = Modifier.padding(7.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White)
                .clip(shape = RoundedCornerShape(7.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.padding(15.dp))
            Image(
                painter = painterResource(id = R.drawable.dhl),
                contentDescription = null,
                modifier = Modifier
                    .width(90.dp)
                    .height(33.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Fast (2-3days)",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
        }

        Spacer(modifier = Modifier.padding(25.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.White)
                .clip(shape = RoundedCornerShape(7.dp)),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order: ",
                    fontSize = 20.sp,
                    color = Color(0xFF808080)
                )

                Text(
                    text = "$ 5.00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Delivery: ",
                    fontSize = 20.sp,
                    color = Color(0xFF808080)
                )

                Text(
                    text = "$ 5.00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total: ",
                    fontSize = 20.sp,
                    color = Color(0xFF808080)
                )

                Text(
                    text = "$ 10.00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )
            }
        }

        Spacer(modifier = Modifier.padding(25.dp))

        Button(
            onClick = {
                val intent = Intent(context, Congrats::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
        ) {
            Text(
                text = "SUBMIT ORDER",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}