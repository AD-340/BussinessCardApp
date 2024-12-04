package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Web
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Nahom Alemu",
                        title = "Software Developer",
                        phone = "(123) 123-1234",
                        email = "nahom.@emailme.com",
                        website = "www.infonahom.com",
                        linkedin = "https://www.linkedin.com/in/nahomalemu",
                        profileImage = R.drawable.profile_pic
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phone: String,
    email: String,
    website: String,
    linkedin: String,
    profileImage: Int,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(2.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = title, fontSize = 18.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone", tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = phone, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email", tint = Color.Gray)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = email, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Web, contentDescription = "Website", tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = website, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { uriHandler.openUri(linkedin) }
            ) {
                Icon(imageVector = Icons.Filled.Link, contentDescription = "LinkedIn", tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "LinkedIn Profile", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            name = "Nahom Alemu",
            title = "Software Developer",
            phone = "(123) 123-1234",
            email = "nahom.@emailme.com",
            website = "www.infonahom.com",
            linkedin = "https://www.linkedin.com/in/nahomalemu",
            profileImage = R.drawable.profile_pic
        )
    }
}
