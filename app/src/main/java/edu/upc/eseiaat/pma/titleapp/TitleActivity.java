package edu.upc.eseiaat.pma.titleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TitleActivity extends AppCompatActivity {

    private String title = "Aquest és el títol inicial...";
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        title_text = (TextView)findViewById(R.id.title);
        title_text.setText(title);
    }

    public void editTitle(View view) {
        // (I)
        // 1. Crear un 'intent'
        Intent intent = new Intent(this, EditTitleActivity.class);
        // 2. Afegir paràmetres (dades extra) a la crida a l'activitat
        intent.putExtra("title", title);
        // 3. Passar l'intent a Android perquè obri l'activitat
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case 0:
            // (IV)
            if (resultCode == AppCompatActivity.RESULT_OK) {
                title = data.getStringExtra("title");
                title_text.setText(title);
            }
        }
    }
}
