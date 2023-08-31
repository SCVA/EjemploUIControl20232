package ejemplos.ejemplouicontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textoPrueba;
    EditText password;
    ImageButton botonImagen;
    Button botonCambioColorDos;
    CheckBox minuscula;
    Switch minuscula2;
    RadioGroup opcionesDimen;
    Spinner selectorFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        textoPrueba = (TextView) findViewById( R.id.textoEjemplo );
        password = (EditText) findViewById( R.id.editTextPassword );
        botonImagen = (ImageButton) findViewById( R.id.imageButton );
        botonCambioColorDos = (Button) findViewById( R.id.button2 );
        minuscula = (CheckBox) findViewById( R.id.checkBox );
        minuscula2 = (Switch) findViewById( R.id.switch1 );
        opcionesDimen = (RadioGroup) findViewById( R.id.opcionesDimension );
        selectorFondo = (Spinner) findViewById( R.id.spinner );

        textoPrueba.setText( "Prueba" );
        textoPrueba.setAllCaps( true );

        password.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String passwordInicial = password.getText().toString(); // Obtener el valor del campo.
                textoPrueba.setText(passwordInicial);
            }
        } );

        botonImagen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoPrueba.setTextColor( Color.GREEN);
            }
        } );

        botonCambioColorDos.setOnClickListener( this );

        minuscula.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //if(minuscula.isChecked())
                if(b) {
                    textoPrueba.setAllCaps( false );
                }else{
                    textoPrueba.setAllCaps( true );
                }
            }
        } );

        minuscula2.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    textoPrueba.setAllCaps( false );
                }else{
                    textoPrueba.setAllCaps( true );
                }
            }
        } );

        opcionesDimen.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.radioButton){
                    textoPrueba.setTextSize( 12 );
                }else if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton2){
                    textoPrueba.setTextSize( 34 );
                }
            }
        } );

        selectorFondo.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion = adapterView.getItemAtPosition( i ).toString();
                View contenedor = view.getRootView();
                if(opcion.equals( "Fondo Blanco" )){
                    contenedor.setBackgroundColor( Color.WHITE );
                } else if (opcion.equals( "Fondo Negro" )) {
                    contenedor.setBackgroundColor( Color.BLACK);
                }else {
                    contenedor.setBackgroundColor( Color.BLUE );
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
    }

    public void cambiarColorTexto(View v){
        textoPrueba.setTextColor( Color.RED);
    }


    @Override
    public void onClick(View view) {
        textoPrueba.setTextColor( Color.YELLOW);
    }
}