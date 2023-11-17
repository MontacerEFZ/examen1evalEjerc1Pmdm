package montacer.elfazazi.ejerc1examen1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import montacer.elfazazi.ejerc1examen1eval.databinding.ActivityResumenBinding;
import montacer.elfazazi.ejerc1examen1eval.modelos.Viaje;

public class ResumenActivity extends AppCompatActivity {

    private ActivityResumenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResumenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Viaje viaje = (Viaje) bundle.getSerializable("VIAJE");
        Toast.makeText(this, viaje.toString(), Toast.LENGTH_SHORT).show();

        binding.lbDestinoResumen.setText(viaje.getDestino().toString());
        binding.lbPersonasResumen.setText(String.valueOf(viaje.getPersonas()));
        binding.lbDiasResumen.setText(String.valueOf(viaje.getDias()));
        binding.lbTotalResumen.setText(String.valueOf(viaje.getExtras()));

        binding.lbTipoViajeResumen.setText(String.valueOf(viaje.getTipoViaje()));

        if (viaje.getTipoViaje() == 300){
            binding.lbTipoViajeResumen.setText(R.string.soloida);
        }else{
            binding.lbTipoViajeResumen.setText(R.string.idayvuelta);
        }
    }
}