package fr.wcs.blablawild;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_DEPARTURE = "fr.wcs.blablawild.DEPARTURE";
    public static final String EXTRA_DESTINATION = "fr.wcs.blablawild.DESTINATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final EditText editDeparture = findViewById(R.id.edit_departure);
        final EditText editDestination = findViewById(R.id.edit_destination);

        Button buttonSearchItinerary = findViewById(R.id.button_search_itinerary_action);
        buttonSearchItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = editDeparture.getText().toString();
                String destination = editDestination.getText().toString();
                if (departure.isEmpty() || destination.isEmpty()) {
                    Toast.makeText(ItinerarySearchActivity.this, R.string.search_error, Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    intent.putExtra(EXTRA_DEPARTURE, departure);
                    intent.putExtra(EXTRA_DESTINATION, destination);
                    startActivity(intent);
                }
                // hides keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }
}
