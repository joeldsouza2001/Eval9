package com.example.eval8

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eval8.model.Datasource
import com.example.eval8.model.Offer


@Composable
fun MainPage() {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        DropdownMenu()
        OffersList()
        Spacer(modifier = Modifier.height(200.dp))
        ContinueButton(modifier = Modifier.padding(top = 10.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu() {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var location by remember {
        mutableStateOf("")
    }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = {
            isExpanded = it
        },
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),

    ) {
        TextField(
            value = location,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "Location")
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()

                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            },
            modifier = Modifier.width(400.dp)
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Semnox Mangalore")

                },
                onClick = {
                    location = "Semnox Mangalore"
                    isExpanded = false
                },


                )
            DropdownMenuItem(
                text = {
                    Text(text = "Semnox Bangalore")
                },
                onClick = {
                    location = "Semnox Bangalore"
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Semnox USA")
                },
                onClick = {
                    location = "Semnox USA"
                    isExpanded = false
                }
            )
        }
    }
}

@Composable
fun OfferCard(offer: Offer) {

    var isClicked by remember { mutableStateOf(offer.isSelected) }
    val cardColor = if (isClicked) Color(0xFFFFFFFF) else Color(0xFFF3F5F5)
    val borderWidth = if (isClicked) 2 else -1

    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(120.dp)
            .padding(5.dp)
            .border(
                width = borderWidth.dp,
                color = Color(0xFFEE8664),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                isClicked = !isClicked
                offer.isSelected = !offer.isSelected
            },

        colors = CardDefaults.cardColors(containerColor = cardColor)

    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                painter = painterResource(id = offer.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = offer.title, fontSize = 14.sp)
        }
    }
}


@Composable
fun OffersList(modifier: Modifier = Modifier) {
    val offersList = Datasource().loadData()

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(offersList) {

            OfferCard(offer = it)

        }

    }

}

@Composable
fun ContinueButton(modifier: Modifier = Modifier) {


    Button(
        onClick = { /*TODO*/ },
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
        Text(text = "CONTINUE TO PAY")
    }
}

