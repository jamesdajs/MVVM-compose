package com.example.mvvmcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcompose.R
import com.example.mvvmcompose.ui.theme.MVVMComposeTheme
import com.hegaro.mvvm.data.model.AuthModel
import com.hegaro.mvvm.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentLogin(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun ContentLogin(
    modifier: Modifier = Modifier,
    authViewModel:AuthViewModel= viewModel()
) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
        ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally



        ){
            logoImg()

            Text(
                modifier = Modifier.padding(15.dp),
                text = "hola")
            Text(text = "hola")
                }
        Button(onClick = {
            authViewModel.login(AuthModel("james.rock.alt@gmail.com","qweqweqwe"))
        }) {
            Text(text = "login")
        }
    }
}
@Composable
fun logoImg(modifier:Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.iconx1024),
        contentDescription = "logo",
        modifier = Modifier
            .width(250.dp)
            .padding(top = 50.dp)
        )
}
/*@Composable
fun textFieldEmail(){
    var email
    TextField(value = , onValueChange = )
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMComposeTheme {

            ContentLogin(Modifier.fillMaxSize())

    }
}