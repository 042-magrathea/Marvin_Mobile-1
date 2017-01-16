package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class show us a tournament with all the data
 */
public class MenuTournament extends AppCompatActivity {

    TextView tvTournamentTitle,tvPublicDes,tvDate,tvMaxPlayers,tvMinPlayers;
    Button btInscription,btDeleteInscription,btClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tournament);

        // TextViews
        tvTournamentTitle=(TextView)findViewById(R.id.tvTournamentTitle);
        tvPublicDes=(TextView)findViewById(R.id.tvPublicDes);
        tvDate=(TextView)findViewById(R.id.tvDate);
        tvMaxPlayers=(TextView)findViewById(R.id.tvMaxPlayers);
        tvMinPlayers=(TextView)findViewById(R.id.tvMinPlayers);

        // Buttons
        btInscription=(Button)findViewById(R.id.btInscription);
        btInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscription();
            }
        });
        btDeleteInscription=(Button)findViewById(R.id.btDeleteInscription);
        btDeleteInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInscription();
            }
        });
        btClose = (Button)findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        // Get the data from the intent
        tvTournamentTitle.setText(getIntent().getStringExtra("title"));
        tvPublicDes.setText(getIntent().getStringExtra("description"));
        tvMaxPlayers.setText(getIntent().getStringExtra("maxPlayers"));
        tvMinPlayers.setText(getIntent().getStringExtra("minPlayers"));
    }

    /**
     * Closes the activity
     */
    private void close(){
        this.finish();
    }

    /**
     * Sign in the tournament
     */
    private void inscription(){
        toastMessage("The inscription was sucessful!");
        btInscription.setVisibility(View.GONE);
        btDeleteInscription.setVisibility(View.VISIBLE);
    }

    /**
     * Dissmis participation in the tournament
     */
    private void deleteInscription(){
        toastMessage("The inscription was deleted!");
        btDeleteInscription.setVisibility(View.GONE);
        btInscription.setVisibility(View.VISIBLE);
    }

    /**
     * Send a toast message
     * @param message the message
     */
    public void toastMessage(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
