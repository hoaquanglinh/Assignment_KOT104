package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ItemDanhMuc(var idRes: Int, var title: String)
data class Product(var imageRes: Int, var name: String, var price: String)

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vectorr),
                contentDescription = null,
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
            )

            Column {
                Text(text = "Make home", fontSize = 20.sp, color = Color(0xFF303030))
                Text(text = "Beautiful", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }

            Box(
                modifier = Modifier.clickable{
                    val intent = Intent(context, Cart::class.java)
                    context.startActivity(intent)
                }
            ){
                Image(
                    painter = painterResource(id = R.drawable.bi_cart2),
                    contentDescription = null,
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        val listItemDanhMuc: MutableList<ItemDanhMuc> = mutableListOf()
        listItemDanhMuc.add(ItemDanhMuc(R.drawable.froup9, "Popular"))
        listItemDanhMuc.add(ItemDanhMuc(R.drawable.chair, "Chair"))
        listItemDanhMuc.add(ItemDanhMuc(R.drawable.table, "Table"))
        listItemDanhMuc.add(ItemDanhMuc(R.drawable.ghe, "Bed"))
        listItemDanhMuc.add(ItemDanhMuc(R.drawable.sofa, "Sofa"))

        var selectedIndex by remember { mutableStateOf(-1) }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listItemDanhMuc) { itemDanhMuc ->
                val index = listItemDanhMuc.indexOf(itemDanhMuc)
                DanhMuc(
                    image = itemDanhMuc.idRes,
                    title = itemDanhMuc.title,
                    isPopular = itemDanhMuc.title == "Popular",
                    isSelected = selectedIndex == index,
                    onClick = { selectedIndex = index }
                )
            }
        }

        val productList: MutableList<Product> = mutableListOf()
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))
        productList.add(Product(R.drawable.background, "Black Simple Lamp", "$12.00"))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(6.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productList) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun DanhMuc(
    image: Int,
    title: String,
    isPopular: Boolean = false,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(0.dp, 0.dp, 13.dp, 0.dp)
    ) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .background(
                    if (isSelected) Color.Black else Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Text(
            text = title,
            fontSize = 18.sp,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }


}

@Composable
fun ProductItem(product: Product) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable {
                val intent = Intent(context, ProductActivity::class.java)
                context.startActivity(intent)
            }
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(190.dp)
                    .fillMaxWidth()
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.name, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.price, fontSize = 14.sp, color = Color.Gray)
        }
    }
}
