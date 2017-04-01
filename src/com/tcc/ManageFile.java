package com.tcc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.util.Log;

public class ManageFile {

	private static final String TAG = "ManageFile";
	private Context context;
	String local = "data\\data\\com.tcc\\files\\UsersTcc.txt";

	public ManageFile(Context context) {
		this.context = context;
	}

	public boolean WriteFile(String text) {
		try {

			File file = new File(local);
			if (file.exists()) {
				file.delete();
			}
			
			FileOutputStream out = context.openFileOutput("UsersTcc.txt",
					Context.MODE_APPEND);
			out.write(text.getBytes());
			out.write("\n".getBytes());
			out.flush();
			out.close();
			return true;

		} catch (Exception e) {
			Log.e(TAG, e.toString());
			return false;
		}
	}

	public String ReadFile() throws IOException {

		
		File textfile = new File(local);

		InputStream input = new BufferedInputStream(new FileInputStream(local));
		byte[] buffer = new byte[(int) textfile.length() - 1];

		input.read(buffer);

		return new String(buffer);
	}
}
