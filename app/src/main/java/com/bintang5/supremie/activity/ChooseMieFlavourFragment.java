package com.bintang5.supremie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.bintang5.supremie.R;

import java.util.ArrayList;

import fragment.MieFlavourGridAdapter;
import model.MieStock;

/**
 * Created by rei on 2/09/17.
 */

public class ChooseMieFlavourFragment extends AppCompatActivity {

    Integer chosenFlavour;
    int[] quantities;
    State state;
    ArrayList<MieStock> oneBrand;
    Button lanjut;


    @Nullable
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_choose_flavour);
        GridView gridView = (GridView)findViewById(R.id.grid_mie_flavour);
        state = State.getInstance();
        oneBrand = state.getAllStock().getOfBrand(State.getInstance().getBrand());
        quantities = new int[oneBrand.size()];
        chosenFlavour = state.getSubMieId();

        if (State.getInstance().getSubMieId() != null) {
            quantities[State.getInstance().getSubMieId()] =
                    State.getInstance().getQuantityMie();
        }
        final MieFlavourGridAdapter flavourGridAdapter = new MieFlavourGridAdapter(this,
                oneBrand, quantities, chosenFlavour);
        flavourGridAdapter.setOnQuantityChangeListener(new MieFlavourGridAdapter.OnQuantityChangeListener() {
            @Override
            public void onQuantityChange(int quantity) {
                if (quantity > 0) {
                    enableLanjut();
                } else if (quantity == 0) {
                    disableLanjut();
                }
            }
        });

        gridView.setAdapter(flavourGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("DERP", String.valueOf(i));
                flavourGridAdapter.addQuantity(i);
                flavourGridAdapter.notifyDataSetChanged();
            }
        });

    }

    public void enableLanjut() {
        lanjut = (Button)findViewById(R.id.flavour_lanjutkan);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseMieFlavourFragment.this, ChooseToppingFragment.class);
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
        lanjut.setBackgroundColor(ContextCompat.getColor(this, R.color.supremieRed));
    }

    public void disableLanjut() {
        lanjut = (Button)findViewById(R.id.flavour_lanjutkan);
        lanjut.setOnClickListener(null);
        lanjut.setBackgroundColor(ContextCompat.getColor(this, R.color.lightGrey));
    }

    //TODO: this don't work!
    @Override
    public void onPause() {
        super.onPause();
//        if (chosenFlavour != null) {
//            State.getInstance().setChooseMieFragmentId(chosenFlavour, quantities[chosenFlavour]);
//            State.getInstance().setMieId(oneBrand.get(chosenFlavour).id);
//        }
    }

}
