package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ItemCart(var image: Int, var ten: String, var gia: Double, var soluong: Int)

class Cart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .weight(1f)
                .clickable{
                    val intent = Intent(context, Home::class.java)
                    context.startActivity(intent)
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)

            )

            Text(
                text = "My cart",
                fontSize = 23.sp
            )

            Box(
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

        val cartList: MutableList<ItemCart> = mutableListOf()
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))
        cartList.add(ItemCart(R.drawable.background, "Iphone 13", 1000.0, 1))

        LazyColumn(
            modifier = Modifier.weight(9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(cartList) { cart ->
                CartItem(cart)
            }
        }

        val promoCode = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.weight(3f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(47.dp)
            ) {
                OutlinedTextField(
                    value = promoCode.value,
                    onValueChange = { promoCode.value = it },
                    placeholder = { Text("Enter your promo code") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .width(47.dp)
                        .height(47.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFF303030)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.backwhite),
                        contentDescription = null,
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)

                    )
                }
            }

            Spacer(modifier = Modifier.padding(7.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF808080)
                )
                Text(
                    text = "$ 95.00",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { val intent = Intent(context, Pay::class.java)
                    context.startActivity(intent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
            ) {
                Text(
                    text = "Check out",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun CartItem(cart: ItemCart) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Image(
            painter = painterResource(id = cart.image),
            contentDescription = null,
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .clip(shape = RoundedCornerShape(13.dp)),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = cart.ten,
                        fontSize = 20.sp,
                        color = Color(0xFF999999)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.shape),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)

                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "$ ${cart.gia}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)

                    )
                }

                Text(
                    text = "${cart.soluong}",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
                )

                Box(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)

                    )
                }
            }
        }
    }
}