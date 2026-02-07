package exercise.furnitureappui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShopAdapter adapter;
    private List<ShopItem> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();

        itemList.add(new ShopItem(ShopItem.TYPE_HOT_DEAL, "Hot Deal", "",
                "", "", 0));
        itemList.add(new ShopItem(ShopItem.TYPE_PRODUCT, "Some Bed 1",
                "₱20,000", "Manila City", "1.2K Sold", R.drawable.bed2));
        itemList.add(new ShopItem(ShopItem.TYPE_PRODUCT, "Some Bed 2",
                "₱18,000", "Batangas City", "1.8K Sold", R.drawable.bed3));
        itemList.add(new ShopItem(ShopItem.TYPE_PRODUCT, "Some Bed 3",
                "₱15,000", "Batangas City", "2.5K Sold", R.drawable.bed1));
        itemList.add(new ShopItem(ShopItem.TYPE_PRODUCT, "Some Bed 4",
                "₱12,000", "Quezon City", "500 Sold", R.drawable.bed2));
        adapter = new ShopAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }
}