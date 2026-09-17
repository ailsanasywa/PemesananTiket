package com.example.pemesanantiket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TicketScreen()
            }
        }
    }
}

@Composable
fun TicketScreen() {

    val ticketPrice = 25000

    var ticketCount by rememberSaveable {
        mutableIntStateOf(1)
    }

    val totalPrice = ticketPrice * ticketCount

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFF4F8),
            Color(0xFFF5F0FC),
            Color(0xFFFFFFFF)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(55.dp))

            Box(
                modifier = Modifier
                    .size(78.dp)
                    .background(
                        color = Color(0xFFEDE3F5),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Filled.ConfirmationNumber,
                    contentDescription = "Icon Tiket",
                    modifier = Modifier.size(42.dp),
                    tint = Color(0xFF8A5AA3)
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Pesan Tiketmu",
                fontSize = 31.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF302A38)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Atur jumlah tiket yang ingin kamu pesan",
                fontSize = 15.sp,
                color = Color(0xFF817988),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {

                    Text(
                        text = "HARGA PER TIKET",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA398AA),
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = formatRupiah(ticketPrice),
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF9B6AAE)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {

                    Text(
                        text = "Jumlah Tiket",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF302A38)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        CounterButton(
                            symbol = "−",
                            backgroundColor = Color(0xFFF8E6EE),
                            textColor = Color(0xFF9B547D),
                            onClick = {
                                if (ticketCount > 1) {
                                    ticketCount--
                                }
                            }
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = ticketCount.toString(),
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF302A38)
                            )

                            Text(
                                text = "tiket",
                                fontSize = 13.sp,
                                color = Color(0xFFA398AA)
                            )
                        }

                        CounterButton(
                            symbol = "+",
                            backgroundColor = Color(0xFFEAE2F5),
                            textColor = Color(0xFF76529B),
                            onClick = {
                                ticketCount++
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF342D3C)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "Total",
                            fontSize = 14.sp,
                            color = Color(0xFFD8CEDC)
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "$ticketCount tiket",
                            fontSize = 13.sp,
                            color = Color(0xFFAAA0AE)
                        )
                    }

                    Text(
                        text = formatRupiah(totalPrice),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFC8DC)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            OutlinedButton(
                onClick = {
                    ticketCount = 1
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF9B547D)
                )
            ) {

                Text(
                    text = "↻",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Reset Pesanan",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun CounterButton(
    symbol: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = Modifier.size(62.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        contentPadding = PaddingValues(0.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp
        )
    ) {

        Text(
            text = symbol,
            fontSize = 32.sp,
            color = textColor,
            fontWeight = FontWeight.Normal
        )
    }
}

fun formatRupiah(value: Int): String {

    val formatter = NumberFormat.getNumberInstance(
        Locale("id", "ID")
    )

    return "Rp${formatter.format(value)}"
}