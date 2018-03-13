package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by bastienwcs on 16/02/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {
    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView textFirstname = convertView.findViewById(R.id.text_firstname);
        TextView textLastname = convertView.findViewById(R.id.text_lastname);
        TextView textDate = convertView.findViewById(R.id.text_date);
        TextView textPrice = convertView.findViewById(R.id.text_price);
        // Populate the data into the template view using the data object
        textFirstname.setText(trip.getFirstname());
        textLastname.setText(trip.getLastname());
        textPrice.setText(String.format("$%s", trip.getPrice()));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        textDate.setText(sdf.format(trip.getDate()));
        // Return the completed view to render on screen
        return convertView;
    }
}
