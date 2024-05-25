package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreen() {
    val context = LocalContext.current
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.product),
                contentDescription = null,
                modifier = Modifier
                    .padding(47.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
                    .height(450.dp)
                    .clip(
                        MaterialTheme.shapes.medium.copy(
                            bottomStart = CornerSize(60.dp)
                        )
                    ),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier.padding(25.dp, 35.dp, 0.dp, 0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .clickable {
                            val intent = Intent(context, Home::class.java)
                            context.startActivity(intent)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)

                    )
                }
            }

            Column(
                modifier = Modifier.padding(18.dp, 130.dp, 0.dp, 0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(70.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(35.dp))
                        .background(Color.White, shape = RoundedCornerShape(35.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(35.dp))
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ColorOption(
                            color = Color.Magenta,
                            isSelected = selectedColor == Color.Gray
                        ) { selectedColor = it }
                        ColorOption(
                            color = Color.DarkGray,
                            isSelected = selectedColor == Color(0xFFFFEB3B)
                        ) { selectedColor = it }
                        ColorOption(
                            color = Color(0xFF795548),
                            isSelected = selectedColor == Color(0xFF795548)
                        ) { selectedColor = it }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Minimal Stand",
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "$ 50",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(37.dp)
                            .height(37.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE0E0E0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.minus),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)

                        )
                    }

                    Text(
                        text = "01",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
                    )

                    Box(
                        modifier = Modifier
                            .width(37.dp)
                            .height(37.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE0E0E0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)

                        )
                    }
                }
            }

            Row(
                modifier = Modifier.padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.start),
                    contentDescription = null,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),

                    )

                Text(
                    text = "4.5",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
                )

                Text(
                    text = "   (50 reviews)",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                    color = Color(0xFF808080)
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = "Minimal Stand is made of by natural wood. " +
                        "The design that is very simple and minimal. " +
                        "This is truly one of the best furnitures in any " +
                        "family for now. With 3 different colors, you can easily " +
                        "select the best match for your home. ",
                letterSpacing = 2.sp,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(65.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(Color(0xFFF0F0F0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = null,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424)
                    ),
                    modifier = Modifier
                        .width(260.dp)
                        .height(60.dp)
                        .background(Color(0xFF242424), shape = RoundedCornerShape(6.dp))
                ) {
                        androidx.compose.material3.Text(text = "ADD TO CART", fontSize = 20.sp)
                }
            }
        }

    }
}

@Composable
fun ColorOption(color: Color, isSelected: Boolean, onClick: (Color) -> Unit) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(color)
            .clickable { onClick(color) }
            .border(
                width = 4.dp,
                color = if (isSelected) Color("#909090".toColorInt()) else Color.White,
                shape = CircleShape
            )
    )
}
