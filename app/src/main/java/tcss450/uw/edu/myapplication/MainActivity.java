package tcss450.uw.edu.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the button1_Text "TEXT" */
    public void displayText(View view) {
        // Do something in response to button
        //create an Intent to start an activity called DisplayTextActivity
        Intent intent = new Intent(this, DisplayTextActivity.class);
        String message = "Display this text";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /** Called when the user clicks the button2_Image "IMAGE" */
    public void displayImage(View view) {
        // Do something in response to button
        Intent intentone = new Intent(this, DisplayImageActivity.class);
        startActivity(intentone);
    }
    /** Called when the user clicks the button3_Web "WEB" */
    public void openWeb(View view) {
        // Do something in response to button
        Uri webpage = Uri.parse("http://developer.android.com/training/basics/intents/sending.html#Build");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /** Called when the user clicks the button4_Toast "TOAST" */
    public void popToast(View view) {
        // Do something in response to button
        Toast.makeText(MainActivity.this, "this is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();
    }
    /** Called when the user clicks the button5_Dialog "DIALOG" */
    public void popDialog(View view) {
        // Do something in response to button
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
