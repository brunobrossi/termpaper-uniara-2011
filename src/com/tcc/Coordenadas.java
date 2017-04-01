package com.tcc;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

public class Coordenadas extends Activity {

	private String user;
	private ManageFile m;

	public Coordenadas(Principal p) {

		LocationManager lm = (LocationManager) p
				.getSystemService(Context.LOCATION_SERVICE);
		LocationProvider provider = lm.getProvider("gps");
		lm.requestLocationUpdates("gps", 60000, 1, locationListener);
	}
	

	private final LocationListener locationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location l) {
			m = new ManageFile(Coordenadas.this);
			try {
				user = m.ReadFile();
				new ServicoEnvio(l.getLatitude(), l.getLongitude(), user);
			} catch (IOException e) {
				Log.e(null, null);
			}
		}

		public void onProviderDisabled(String provider) {
		}

		public void onProviderEnabled(String provider) {
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};

}
