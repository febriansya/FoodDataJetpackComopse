package com.example.fooddata.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddata.R

@Composable
fun SignIn() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {
        Column() {
            Text(text = stringResource(id = R.string.sign_in), style = MaterialTheme.typography.h2)
            Text(text = stringResource(id = R.string.kata1), style = MaterialTheme.typography.body2)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.email_address), color = Color.Black
            )
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = R.string.email_address)) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.hint_email),
                        style = MaterialTheme.typography.body2
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = MaterialTheme.colors.secondary,
                    focusedLabelColor = MaterialTheme.colors.secondary,
                    cursorColor = MaterialTheme.colors.primaryVariant
                ),
                textStyle = MaterialTheme.typography.body1
            )

            Text(
                text = stringResource(id = R.string.password), color = Color.Black
            )
            OutlinedTextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.hint_password),
                        style = MaterialTheme.typography.body2
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = MaterialTheme.colors.secondary,
                    focusedLabelColor = MaterialTheme.colors.secondary,
                    cursorColor = MaterialTheme.colors.primaryVariant
                ),
                textStyle = MaterialTheme.typography.body1
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h3
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 6.dp, bottom = 6.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
            ) {
                Text(
                    text = stringResource(id = R.string.buat_akun),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
            }
        }

    }

}

@Preview
@Composable
fun preview() {
    Surface {
        SignIn()

    }
}