package com.example.eval8

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpVerifiedPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.checkcircle),
            contentDescription = "Checked circle",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)

        )
        Text(
            text = "OTP Verified Successfully!", fontSize = 20.sp,
            fontWeight = FontWeight(weight = 800),
            lineHeight = 24.sp,
            color = Color(0xFFEE8664),
            modifier = Modifier.padding(top = 20.dp)
        )
        ContinueBtn(Modifier.padding(top = 20.dp))
    }
}

@Composable
fun ContinueBtn(modifier: Modifier = Modifier) {


    Button(
        onClick = { }, modifier = modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth(),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color(
                0xFFEE8664
            )
        ),
        shape = CutCornerShape(10)
    ) {
        Text(
            text = "CONTINUE TO SMARTFUN", fontSize = 15.sp,
            fontWeight = FontWeight(weight = 600),
            lineHeight = 16.sp,
        )
    }
}