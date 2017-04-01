package com.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Principal extends Activity {

	private static final int SAIR = Menu.FIRST;
	private static final int INSERIR = Menu.FIRST + 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, SAIR, 0, "Sair");
		menu.add(0, INSERIR, 0, "Cadastro Usuário");
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case SAIR:
			finish();
			return true;

		case INSERIR:
			Intent intent = new Intent(this, PinActivity.class);
			startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void iniciaRastreio(View view) {
		
		new Coordenadas(this);
	}
}
