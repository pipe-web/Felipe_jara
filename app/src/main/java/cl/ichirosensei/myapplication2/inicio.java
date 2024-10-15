package cl.ichirosensei.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class inicio extends AppCompatActivity {

    private EditText editTextTextProducto;
    private EditText editTextTextnombre;;
    private Button buttonA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        editTextTextProducto = (EditText) findViewById(R.id.editTextTextProducto);
        editTextTextnombre = (EditText) findViewById(R.id.editTextTextnombre);
        buttonA = (Button) findViewById(R.id.buttonA);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String producto = editTextTextProducto.getText().toString();
                String nombre= editTextTextnombre.getText().toString();
                if (producto.isEmpty()){
                    editTextTextProducto.setError("Ingrese un producto");
                }
                else if (nombre.isEmpty()){
                    editTextTextnombre.setError("Ingrese un nombre");
                }

                addProductoToBD(producto,nombre);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addProductoToBD(String producto, String nombre) {

        HashMap<String, Object>productoHasgmap = new HashMap<>();
        productoHasgmap.put("producto",producto);
        productoHasgmap.put("nombre",nombre);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference productoRef = database.getReference("producto");
        String Key =productoRef.push().getKey();
        productoHasgmap.put("key",Key);

        productoRef.child(Key).setValue(productoHasgmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(inicio.this,"Producto Agregado",Toast.LENGTH_SHORT).show();
                editTextTextProducto.getText().clear();
                editTextTextnombre.getText().clear();
            }
        });




    }
}