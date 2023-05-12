package com.example.cadastrarponto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.cadastrarponto.ui.theme.CadastrarPontoTheme

import kotlinx.coroutines.flow.callbackFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CadastrarPontoTheme() {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(108, 162, 76 ),

                    ) {

                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Greeting(name: String) {

    //val contextForToast = LocalContext.current.applicationContext


    var materiais by remember {
        mutableStateOf(false)
    }
    var checked22 by remember {
        mutableStateOf(false)
    }

    var expanded1 by remember {
        mutableStateOf(false)
    }

    var expanded2 by remember {
        mutableStateOf(false)
    }

    val list2 = listOf("Papel", "Metal", "Plástico", "Vidro", "Orgânico", "Eletrônico")

    val list1 = listOf("Exemplo1", "Exemplo2", "Exemplo3", "Exemplo4")

    var selectedItem by remember {
        mutableStateOf("")
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    var selectedLocal by remember {
        mutableStateOf("")
    }

    //val checkedState = remember { mutableStateOf(true) }


    val icon1 = if (expanded1) {
        Icons.Filled.KeyboardArrowUp

    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val icon2 = if (expanded2) {
        Icons.Filled.KeyboardArrowUp

    } else {
        Icons.Filled.KeyboardArrowDown
    }


    Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        Text(text = "Solicite uma coleta", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            color = Color.White)

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
            {

                Card(
                    modifier = Modifier
                        .width(500.dp)
                        .height(560.dp)
                        .padding(start = 15.dp, end = 15.dp,),
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = Color(255, 255, 255)
                )
                {
                    Image(
                        painter = painterResource(R.drawable.image_fundo_card),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Text(
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 14.dp),
                            text = "Você posssui uma coleta em andamento",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            modifier = Modifier.padding(top = 7.dp),
                            textAlign = TextAlign.Center,
                            text = "Informações sobre a coleta",
                            fontSize = 17.sp,
                            color = Color(117, 117, 117)
                        )


                        Column(
                            modifier = Modifier
                                .padding(top = 7.dp)
                                .align(Alignment.Start)
                                .padding(16.dp)
                        ) {
                            Text(
                                modifier = Modifier,
                                textAlign = TextAlign.Start,
                                text = "Endereço da coleta:",
                                fontSize = 18.sp,
                                color = Color.Black
                            )



                            Text(
                                modifier = Modifier,
                                textAlign = TextAlign.Start,
                                text = "Estrada das Pitas 952, Barueri, SP",
                                fontSize = 17.sp,
                                color = Color(117, 117, 117)
                            )

                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                textAlign = TextAlign.Start,
                                text = "Materiais que serão recolhidos:",
                                fontSize = 18.sp,
                                color = Color.Black
                            )



                            Text(
                                modifier = Modifier,
                                textAlign = TextAlign.Start,
                                text = "Ferro, Madeira",
                                fontSize = 17.sp,
                                color = Color(117, 117, 117)
                            )


                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                textAlign = TextAlign.Start,
                                text = "Catador que irá recolher o material:",
                                fontSize = 18.sp,
                                color = Color.Black
                            )



                            Text(
                                modifier = Modifier,
                                textAlign = TextAlign.Start,
                                text = "Wallace Pereira Santos",
                                fontSize = 17.sp,
                                color = Color(117, 117, 117)
                            )


                        }

                        Image(
                            painter = painterResource(R.drawable.foto_recycle),
                            contentDescription = null,
                            modifier = Modifier.size(180.dp).align(Alignment.CenterHorizontally)

                        )




                        //Spacer(modifier = Modifier.padding(20.dp))


//                        Image(
//                            painter = painterResource(id = R.drawable.foto),
//                            contentDescription = stringResource(id = R.string.foto_tela),
//                            modifier = Modifier
//                                .align(CenterHorizontally)
//                                .width(320.dp)
//                                .height(310.dp)
//                        )


                    }


                }


            }
        }
    }












@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CadastrarPontoTheme() {
        Greeting("Android")
    }
}