import androidx.compose.runtime.remember
import com.goldden.lucck.volunteerapp.Models.OrderCardModel
import com.goldden.lucck.volunteerapp.R

val orderList =
    listOf(
        OrderCardModel("Order 1", R.drawable.img, "Description for Order 1", 1, "Львів"),
        OrderCardModel("Order 2", R.drawable.img_1, "Description for Order 2",2, "Київ"),
        OrderCardModel("Order 2", R.drawable.img_1, "Description for Order 2", 3,"Харків"),
        OrderCardModel("Order 2", R.drawable.img_1, "Description for Order 2", 4,"Харків")
    )
