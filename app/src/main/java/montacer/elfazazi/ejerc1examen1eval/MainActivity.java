package montacer.elfazazi.ejerc1examen1eval;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import montacer.elfazazi.ejerc1examen1eval.databinding.ActivityMainBinding;
import montacer.elfazazi.ejerc1examen1eval.modelos.Viaje;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ActivityResultLauncher<Intent> resumenViaje;

    private String destino;
    private int personas;
    private int dias;
    private int tipoViaje;
    private int extrasYTotal;

    private Viaje viaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView((binding.getRoot()));

        inicializarLaunchers();

        binding.btnCalcularMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resumenViaje.launch(new Intent(MainActivity.this, ResumenActivity.class ));

                viaje = crearViaje();
                int alquiler = 0;
                int excursion = 0;
                int traslado = 0;
                int todo = 0;

                if (viaje != null){

                    if (binding.cbAlquilerCocheMain.isChecked()){
                        alquiler = viaje.getDias()*50;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        excursion = 100;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        traslado = 75;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        todo = viaje.getDias()*20;
                    }

                    int extras = (alquiler+excursion+traslado+todo)*viaje.getPersonas();
                    extrasYTotal += extras;

                    viaje.setExtras(extrasYTotal );
                }

                Intent intent = new Intent(MainActivity.this, ResumenActivity.class );
                Bundle bundle = new Bundle();
                bundle.putSerializable("VIAJE", viaje);
                intent.putExtras(bundle);

                resumenViaje.launch(intent);
            }
        });
        
        binding.btnCancelarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viaje = crearViaje();
                Toast.makeText(MainActivity.this, viaje.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private Viaje crearViaje() {
        if (binding.txtPersonasMain.getText().toString().isEmpty() || binding.txtDiasMain.getText().toString().isEmpty() ||
        binding.spDestinosMain.getSelectedItemPosition() == 0){
            return null;
        }
        if (!binding.rbIdaMain.isChecked() && !binding.rbIdaYVueltaMain.isChecked()){
            return null;
        }
        if (Integer.parseInt(binding.txtPersonasMain.getText().toString()) < 1 ||
                Integer.parseInt(binding.txtPersonasMain.getText().toString()) >6){
            return null;
        }
        if (Integer.parseInt(binding.txtDiasMain.getText().toString()) < 1 ||
                Integer.parseInt(binding.txtDiasMain.getText().toString()) > 30){
            return  null;
        }

        destino = binding.spDestinosMain.getSelectedItem().toString();
        personas = Integer.parseInt(binding.txtPersonasMain.getText().toString());
        dias = Integer.parseInt(binding.txtDiasMain.getText().toString());

        if (binding.rbIdaMain.isChecked()){
            tipoViaje = 300;
        }
        if (binding.rbIdaYVueltaMain.isChecked()){
            tipoViaje = 550;
        }

        extrasYTotal = personas*tipoViaje;

        viaje = new Viaje(destino, personas, dias, tipoViaje, extrasYTotal);

        return viaje;
    }

    private void inicializarLaunchers() {/*
        resumenViaje = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                Viaje viaje = crearViaje();
                int alquiler = 0;
                int excursion = 0;
                int traslado = 0;
                int todo = 0;

                if (viaje != null){

                    if (binding.cbAlquilerCocheMain.isChecked()){
                        alquiler = viaje.getDias()*50;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        excursion = 100;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        traslado = 75;
                    }
                    if (binding.cbAlquilerCocheMain.isChecked()){
                        todo = viaje.getDias()*20;
                    }

                    int extras = (alquiler+excursion+traslado+todo)*viaje.getPersonas();
                    extrasYTotal += extras;

                    viaje.setExtras(extrasYTotal );

7777
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("VIAJE", viaje);
                    intent.putExtras(bundle);

 777
                }else {
                    Toast.makeText(MainActivity.this, "faltan datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
      
    }

   */

        resumenViaje = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                Toast.makeText(MainActivity.this, "volvemos del resumen", Toast.LENGTH_SHORT).show();
            }
        });
    }


}