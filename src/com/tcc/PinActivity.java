package com.tcc;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PinActivity extends Activity {

	public EditText nome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastra_pin);
		nome = (EditText) findViewById(R.id.editpin1);
	}


	public void cadastraUsuario(View view) {
		ManageFile filewrite = new ManageFile(this);
        
        if(filewrite.WriteFile(nome.getText().toString())
             == true){
            Toast.makeText(this,
                "Usuário gravado com sucesso.",
                Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, 
                "Não foi possível gravar.", 
                Toast.LENGTH_SHORT).show();
        }
		
	}

	public String recuperaUsuario() throws IOException{
		ManageFile fileread = new ManageFile(this);
        return (fileread.ReadFile());
	}
	
}
