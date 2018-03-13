package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    final static int VEHICLE_NONE = 0;
    final static int VEHICLE_CAR = 1;
    final static int VEHICLE_BOAT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Spinner spinnerVehicle = findViewById(R.id.spinner_vehicle);
        spinnerVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final EditText editBrand = findViewById(R.id.edit_brand);
                final EditText editModel = findViewById(R.id.edit_model);
                final EditText editKilometers = findViewById(R.id.edit_kilometers);
                final EditText editHours = findViewById(R.id.edit_hours);
                Button buttonSend = findViewById(R.id.button_send);

                if (i == VEHICLE_NONE) {
                    editKilometers.setVisibility(View.GONE);
                    editHours.setVisibility(View.GONE);
                    buttonSend.setEnabled(false);
                } else if (i == VEHICLE_CAR) {
                    editKilometers.setVisibility(View.VISIBLE);
                    editHours.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);
                    buttonSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String brandValue = editBrand.getText().toString();
                            String modelValue = editModel.getText().toString();
                            String kilometersValue = editKilometers.getText().toString();
                            int kilometersInt = 0;
                            if (!kilometersValue.isEmpty()) {
                                Integer.parseInt(kilometersValue);
                            }

                            VehicleCar car = new VehicleCar(brandValue, modelValue, kilometersInt);
                            Toast.makeText(VehicleActivity.this, car.getDescription(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (i == VEHICLE_BOAT) {
                    editKilometers.setVisibility(View.GONE);
                    editHours.setVisibility(View.VISIBLE);
                    buttonSend.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // ?????
            }
        });
    }
}
