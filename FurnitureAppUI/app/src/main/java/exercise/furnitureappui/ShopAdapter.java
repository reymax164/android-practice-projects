package exercise.furnitureappui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
public class ShopAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShopItem> items;
    public ShopAdapter(Context context, List<ShopItem> items) {
        this.context = context;
        this.items = items;
    }
    // determine which layout to use based on position/data
    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }
    // inflate the correct layout
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                              parent, int viewType) {
        if (viewType == ShopItem.TYPE_HOT_DEAL) {
            View view =
                    LayoutInflater.from(context).inflate(R.layout.item_hot_deal, parent,
                            false);
            return new HotDealViewHolder(view);
        } else {
            View view =
                    LayoutInflater.from(context).inflate(R.layout.item_product, parent,
                            false);
            return new ProductViewHolder(view);
        }
    }
    // bind data to the views
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,
                                 int position) {
        ShopItem item = items.get(position);
        if (getItemViewType(position) == ShopItem.TYPE_HOT_DEAL) {
            // ((HotDealViewHolder) holder).title.setText(item.getTitle());

        } else {
            ProductViewHolder productHolder = (ProductViewHolder) holder;
            productHolder.name.setText(item.getTitle());
            productHolder.price.setText(item.getPrice());
            productHolder.location.setText(item.getLocation());
            productHolder.sold.setText(item.getSoldCount());

            // load image using glide
            Glide.with(context).load(item.getImageResId()).into(productHolder.image);
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class HotDealViewHolder extends RecyclerView.ViewHolder {
        public HotDealViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    // ViewHolder for Products
    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, location, sold;
        ImageView image;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_prod_name);
            price = itemView.findViewById(R.id.tv_prod_price);
            location = itemView.findViewById(R.id.tv_prod_loc);
            sold = itemView.findViewById(R.id.tv_prod_sold);
            image = itemView.findViewById(R.id.img_product);
        }
    }
}

