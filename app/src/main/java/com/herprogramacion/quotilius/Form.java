package com.herprogramacion.quotilius;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Form extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Asignando escuchas a los botones
        Button saveButton = (Button)findViewById(R.id.saveButton);
        Button cancelButton = (Button)findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form, menu);
        return true;
    }

    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){

        if(v.getId()==R.id.saveButton) {
            //Obtener los datos de los campos
            EditText quoteField = (EditText) findViewById(R.id.quoteField);
            EditText authorField = (EditText) findViewById(R.id.authorField);

            //Nuevo Intent con Extras
            Intent backData = new Intent();
            backData.putExtra("body", quoteField.getText().toString());
            backData.putExtra("author", authorField.getText().toString());

            //Enviar la información
            setResult(RESULT_OK, backData);

        }else{

            //El envío fracasó
            setResult(RESULT_CANCELED);
        }

        //Terminar la actividad Nueva_Frase
        finish();

    }
}
