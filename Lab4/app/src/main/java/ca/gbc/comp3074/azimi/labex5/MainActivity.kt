
package ca.gbc.comp3074.azimi.labex5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.gbc.comp3074.azimi.labex5.data.AppDatabase
import ca.gbc.comp3074.azimi.labex5.ui.CustomerViewModel
import ca.gbc.comp3074.azimi.labex5.ui.CustomerViewModelFactory
import ca.gbc.comp3074.azimi.labex5.ui.CustomerApp
import ca.gbc.comp3074.azimi.labex5.ui.theme.Labex5Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)

        setContent {
            Labex5Theme {
                val viewModel: CustomerViewModel = viewModel(
                    factory = CustomerViewModelFactory(
                        database.customerDao()
                    )
                )

                CustomerApp(viewModel)
            }
        }
    }
}
