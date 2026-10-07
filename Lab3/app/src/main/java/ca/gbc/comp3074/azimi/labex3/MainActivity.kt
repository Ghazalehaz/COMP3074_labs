package ca.gbc.comp3074.azimi.labex3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.azimi.labex3.ui.theme.Labex3Theme

data class Message(
    val user: String,
    val text: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Labex3Theme {
                MessageScreen()
            }
        }
    }
}

@Composable
fun MessageScreen() {

    val messages = listOf(
        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2...3"),
        Message("Joe", "I hate coding!!!"),

        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2...3"),
        Message("Joe", "I hate coding!!!"),

        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2...3"),
        Message("Joe", "I hate coding!!!")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 24.dp,
                end = 16.dp,
                top = 40.dp
            )
    ) {

        items(messages) { message ->

            MessageItem(message)

        }
    }
}

@Composable
fun MessageItem(message: Message) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.Top
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "User image",
            modifier = Modifier
                .size(72.dp)
                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = CircleShape
                )
                .clip(CircleShape)
                .padding(8.dp)
        )

        Spacer(
            modifier = Modifier.width(14.dp)
        )

        Column {

            Text(
                text = message.user,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(
                modifier = Modifier.size(7.dp)
            )

            Surface(
                shape = RoundedCornerShape(20.dp),
                shadowElevation = 2.dp
            ) {

                Text(
                    text = message.text,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 8.dp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {

    Labex3Theme {
        MessageScreen()
    }
}