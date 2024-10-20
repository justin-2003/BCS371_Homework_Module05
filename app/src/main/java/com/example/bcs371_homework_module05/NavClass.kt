package com.example.bcs371_homework_module05

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.graphics.computeCubicVerticalBounds
import androidx.compose.ui.unit.sp


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "last_screen"){
        composable("splash_screen")
        {
            SplashScreen(navController)
        }
        composable("first_screen") {
            FirstScreen(navController)
        }
        composable("second_screen") {
            SecondScreen(navController)
        }
        composable("third_screen") {
            ThirdScreen(navController)
        }
        composable("fourth_screen") {
            FourthScreen(navController)
        }
        composable("fifth_screen") {
            FifthScreen(navController)
        }
        composable("sixth_screen") {
            SixthScreen(navController)
        }
        composable("seventh_screen") {
            SeventhScreen(navController)
        }
        composable("last_screen") {
            LastScreen(navController)
        }
    }
}
var totalAmount = 0
var numberofCorrectAnswers = 0

//SplashScreen
@Composable
fun SplashScreen(navController: NavController){
    val scale = remember {
        Animatable(0f,1f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(durationMillis = 1000, 0,easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
            ))
        delay(3000)
        navController.navigate("first_screen")
    }

    //Centers the text and image
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.dollar_sign), contentDescription ="")
        Text("Who wants to be a millionaire")
    }
}
// only commenting one Screen as they are all the same
@Composable
fun FirstScreen(navController: NavController) {
    //these are the radio options compiled in a list and will show as radio buttons
    val radioOptions = listOf("50", "61", "31", "21")
    //make sure which one is selected and updates
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        //header
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        //Shows the totalAmount of money you have earned
        Text(
            "You have Earned: $totalAmount",
            fontSize = 30.sp, color = Color.Blue
        )
        Spacer(Modifier.padding(20.dp))
        //question
        Text(
            "How many states does US have?",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        //Shows all the radio buttons
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        //It takes to the next question and also updates the amount and correct answers
        Button(onClick = {
            if (selectedOption == "50") {
                totalAmount += 100
                numberofCorrectAnswers +=1
                navController.navigate("second_screen")
            }
        }) {
            Text("Confirm")
        }
    }
}
    @Composable
fun SecondScreen(navController: NavController) {
    val radioOptions = listOf("Venus", "Earth", "Mars","Jupyter")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("What is the only planet in our solar system to rotate clockwise on its axis?",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="Venus"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("third_screen")
        } }) {
            Text("Confirm")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    val radioOptions = listOf("206", "186", "204","190")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("How many bones are there in the adult human body??",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="206"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("fourth_screen")
        }else{
            navController.navigate("fourth_screen")
        }
        }) {
            Text("Confirm")
        }
    }
}
@Composable
fun FourthScreen(navController: NavController) {
    val radioOptions = listOf("Cinnamon", "Cardamom", "Nutmeg","Black pepper")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("Which spice is known as \"queen of spices\"?",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="Cardamom"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("fifth_screen")
        } }) {
            Text("Confirm")
        }
    }
}
@Composable
fun FifthScreen(navController: NavController) {
    val radioOptions = listOf("Mayella", "Scout", "Jem"," Calpurnia")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("In \"To Kill a Mockingbird,\" what is the name of Atticus Finch's daughter?",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="Jem"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("sixth_screen")
        } }) {
            Text("Confirm")
        }
    }
}
@Composable
fun SixthScreen(navController: NavController) {
    val radioOptions = listOf("Carrying oxygen", "Fighting infections", "Clotting blood","Regulating body temperature")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("What is the main function of red blood cells?",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="Carrying oxygen"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("seventh_screen")
        } }) {
            Text("Confirm")
        }
    }
}
@Composable
fun SeventhScreen(navController: NavController) {
    val radioOptions = listOf("Tibia", "Femur", "Humerus","Radius")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.padding(10.dp))
        Text(
            "Homework - who wants to be a Millionaire", Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.White
        )
        Spacer(Modifier.padding(30.dp))
        Text("You have Earned: $$totalAmount",
            fontSize = 30.sp,color = Color.Blue)
        Spacer(Modifier.padding(20.dp))
        Text("Which human bone is the longest and strongest?",
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .background(if (text == selectedOption) Color.Green else Color.Transparent)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { if(selectedOption =="Femur"){
            totalAmount+= 100
            numberofCorrectAnswers +=1
            navController.navigate("last_screen")
        } }) {
            Text("Confirm")
        }
    }
}

@Composable
fun LastScreen(navController: NavController){
    Column(){
        Text("Game over")
        Text("")

    }
}