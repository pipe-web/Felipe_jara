package cl.ichirosensei.myapplication2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class productoviewholder extends RecyclerView.ViewHolder {
    public TextView producto_tv, nombre_tv;
    public productoviewholder(@NonNull View itemView) {
        super(itemView);
        producto_tv=itemView.findViewById(R.id.producto_tv);
        nombre_tv=itemView.findViewById(R.id.nombre_tv);

    }
}
