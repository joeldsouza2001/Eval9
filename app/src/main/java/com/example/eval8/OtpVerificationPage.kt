package com.example.eval8


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OtpVerificationPage() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "OTP Verification",
            fontSize = 20.sp,
            fontWeight = FontWeight(weight = 700),
            lineHeight = 24.sp,
            modifier = Modifier.padding(top = 30.dp)
        )
        Text(
            text = "Enter the One Time Password sent to your registered mobile number ******48.",
            fontSize = 14.sp,
            fontWeight = FontWeight(weight = 400),
            lineHeight = 20.sp
        )
        OtpRows(Modifier.padding(top = 250.dp))
        VerifyOtpButton(Modifier.padding(top = 60.dp))
        Row(Modifier.padding(top = 30.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Did not receive OTP?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(weight = 500)
                )
                Text(
                    text = "RESEND OTP",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(weight = 500),
                    color = Color(
                        0xFF8C00F3
                    )

                )
            }

        }
    }
}


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpRows(modifier: Modifier = Modifier) {


    val otpList = remember {
        mutableStateListOf("", "", "", "", "", "")
    }

    val focusReq = remember {
        List(6) {FocusRequester()}
    }

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        repeat(6) {

            TextField(
                value = otpList[it], onValueChange = { value ->
                    otpList[it] = value
                    if(value.isNotEmpty() && it<5){
                        focusReq[it+1].requestFocus()
                    }


                }, modifier = Modifier.width(45.dp).focusRequester(focusReq[it]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (it == 5) ImeAction.Done else ImeAction.Next
                )
            )

        }


    }
}

@Composable
fun VerifyOtpButton(modifier: Modifier = Modifier) {


    Button(
        onClick = { },
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth(),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color(
                0xFFEE8664
            )
        ),
        shape = CutCornerShape(10)
    ) {
        Text(text = "VERIFY BUTTON")
    }
}