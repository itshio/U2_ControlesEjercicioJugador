package com.example.u2_controlesejerciciojugador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView tvNombre,tvDorsal,tvMundial,tvPosicion;
    Button btnAnterior, btnSiguiente;
    EditText etNombre;
    Spinner spDorsal;
    RadioGroup rgPosicion;
    CheckBox cbMundial;
    ArrayList<Jugador> lista_jugadores= new ArrayList<Jugador>();
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnterior = (Button)findViewById(R.id.btnAnterior);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        etNombre = (EditText)findViewById(R.id.etNombre);
        spDorsal = (Spinner)findViewById(R.id.spDorsal);
        rgPosicion = (RadioGroup) findViewById(R.id.rgPosicion);
        cbMundial = (CheckBox) findViewById(R.id.cbMundial);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvDorsal = (TextView)findViewById(R.id.tvDorsal);
        tvMundial = (TextView)findViewById(R.id.tvMundial);
        tvPosicion = (TextView)findViewById(R.id.tvPosicion);
        indice= -1;

        String[] dorsales = {"","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        ArrayAdapter<String> adaptadorDorsales = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dorsales);
        spDorsal.setAdapter(adaptadorDorsales);

    }

    public void clickAnterior(View view){

        if(indice>0){
        indice--;
        cargarjugador();

        }else{

            mostrarmensaje("Has llegado al principio");
        }



    }

    public void clickSiguiente(View view){

        if(indice<lista_jugadores.size()-1){
        indice++;
        cargarjugador();

        }else{

            indice=0;
            cargarjugador();
        }



    }

    public void clickLimpiar(View view){

        limpiarformulario();

    }

    public void clickGuardar(View view){

        String cajanombre=etNombre.getText().toString();
        String spinnerdorsal=spDorsal.getSelectedItem().toString();
        int idposicion=rgPosicion.getCheckedRadioButtonId();

        if(cajanombre.equals("")|| spinnerdorsal.equals("")|| idposicion==-1){

            mostrarmensaje("debes rellenar los campos obligatorios");

        }else{

            boolean tienemundial=cbMundial.isChecked();
            RadioButton rbcopia= (RadioButton)findViewById(idposicion);
            String posicion= rbcopia.getText().toString();
            int dorsal= Integer.parseInt(spinnerdorsal);
            Jugador j= new Jugador(cajanombre,dorsal,posicion,tienemundial);
            lista_jugadores.add(j);
            btnAnterior.setEnabled(true);
            btnSiguiente.setEnabled(true);
            limpiarformulario();


        }


    }


    //MIS METODOS

    private void limpiarformulario(){

        etNombre.setText("");
        spDorsal.setSelection(0);
        rgPosicion.clearCheck();
        cbMundial.setChecked(false);

    }


    private void mostrarmensaje (String mensaje){
        Toast.makeText(getApplicationContext(), mensaje,
                Toast.LENGTH_LONG).show();


    }

    private void cargarjugador (){

        Jugador j =lista_jugadores.get(indice);
        tvNombre.setText("Nombre: "+j.getNombre());
        tvDorsal.setText("Dorsal: "+j.getDorsal()+"");
        tvPosicion.setText("Posicion: "+j.getPosicion());

        String mundial = "";
        if(j.isTienemundial()){
            mundial="si";


        }else{
            mundial="no";


        }

        tvMundial.setText("Tiene mundial: "+mundial);



    }


}//NO BORRAR
